import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.qphone.base.util.QLog;

public class jdv
  implements Runnable
{
  public jdv(PngGifEngine paramPngGifEngine) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PngGifEngine.a(), 2, "func run begins.");
    }
    Object localObject = PngGifEngine.a(this.a);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    long l2;
    do
    {
      return;
      l2 = SystemClock.uptimeMillis();
      localObject = PngGifEngine.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(PngGifEngine.a(), 2, "func run, bitmap:" + localObject);
      }
    } while ((localObject == null) || (((Bitmap)localObject).isRecycled()));
    long l1 = SystemClock.uptimeMillis();
    l2 += PngGifEngine.a(this.a).b;
    localObject = PngGifEngine.a(this.a).obtainMessage(1, localObject);
    if (l1 > l2)
    {
      PngGifEngine.a(this.a).sendMessage((Message)localObject);
      return;
    }
    PngGifEngine.a(this.a).sendMessageDelayed((Message)localObject, l2 - l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdv
 * JD-Core Version:    0.7.0.1
 */