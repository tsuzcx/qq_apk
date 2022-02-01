import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import tencent.im.group.nearbybanner.nearbybanner.BannerInfo;

public class kdl
  implements Runnable
{
  public kdl(NearbyTroopsView paramNearbyTroopsView) {}
  
  public void run()
  {
    Object localObject1 = NearbyTroopsView.a(this.a).bytes_img_url.get().toStringUtf8();
    try
    {
      localObject1 = HttpUtil.a(BaseApplication.getContext(), (String)localObject1, "GET", null, null);
      Bitmap localBitmap = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (localBitmap != null)
      {
        Object localObject2 = new File(NearbyTroopsView.c);
        if (!((File)localObject2).exists())
        {
          ((File)localObject2).getParentFile().mkdirs();
          ((File)localObject2).createNewFile();
        }
        localObject2 = new FileOutputStream((File)localObject2);
        ((FileOutputStream)localObject2).write((byte[])localObject1);
        ((FileOutputStream)localObject2).flush();
        ((FileOutputStream)localObject2).close();
        localObject1 = this.a.a.obtainMessage(10, localBitmap);
        this.a.a.sendMessage((Message)localObject1);
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdl
 * JD-Core Version:    0.7.0.1
 */