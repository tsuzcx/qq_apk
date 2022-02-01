import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class jzy
  implements BitmapDecoder
{
  public jzy(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    String str = this.a.a(paramURL).a;
    if (TextUtils.isEmpty(str)) {
      paramURL = null;
    }
    for (;;)
    {
      return paramURL;
      try
      {
        Bitmap localBitmap = this.a.a(str);
        paramURL = localBitmap;
        if (localBitmap == null)
        {
          paramURL = this.a.b(str);
          return paramURL;
        }
      }
      catch (Throwable paramURL)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jzy
 * JD-Core Version:    0.7.0.1
 */