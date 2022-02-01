import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class jzx
  implements BitmapDecoder
{
  public jzx(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    Bitmap localBitmap = null;
    LocalMediaInfo localLocalMediaInfo = this.a.a(paramURL);
    paramURL = new BitmapFactory.Options();
    paramURL.inDensity = 160;
    paramURL.inTargetDensity = 160;
    paramURL.inScreenDensity = 160;
    try
    {
      paramURL = BitmapFactory.decodeFile(localLocalMediaInfo.a, paramURL);
      if (paramURL != null) {
        localBitmap = ThumbnailUtils.extractThumbnail(paramURL, localLocalMediaInfo.f, localLocalMediaInfo.g, 2);
      }
      return localBitmap;
    }
    catch (OutOfMemoryError paramURL)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VIdeoThumbDownloader", 2, "DeviceImgBitmapDecoder getBitmap", paramURL);
        }
        paramURL = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jzx
 * JD-Core Version:    0.7.0.1
 */