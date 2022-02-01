import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.nearpeople.TurnBrandDownloader;
import com.tencent.mobileqq.nearpeople.TurnBrandDownloader.ImageCallback;
import com.tencent.mobileqq.nearpeople.TurnBrandDownloader.ImageRef;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

public class jkv
  extends Handler
{
  public jkv(TurnBrandDownloader paramTurnBrandDownloader) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage != null) {
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      TurnBrandDownloader.a(this.a, true);
      if (TurnBrandDownloader.b(this.a) != null) {
        TurnBrandDownloader.a(this.a);
      }
      return;
      TurnBrandDownloader.ImageRef localImageRef = (TurnBrandDownloader.ImageRef)TurnBrandDownloader.b(this.a).poll();
      if ((localImageRef != null) && (localImageRef.a != null) && (localImageRef.b != null))
      {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramMessage.obj != null)
        {
          localObject1 = localObject2;
          if ((paramMessage.obj instanceof Bitmap)) {
            localObject1 = (Bitmap)paramMessage.obj;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("TurnBrandDownloader", 2, "mImageManagerHandler rcv MSG_REPLY: tinyid: " + localImageRef.a + ", url: " + localImageRef.b + ", bitmap: " + localObject1);
        }
        TurnBrandDownloader.a(this.a).a((Bitmap)localObject1, localImageRef.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkv
 * JD-Core Version:    0.7.0.1
 */