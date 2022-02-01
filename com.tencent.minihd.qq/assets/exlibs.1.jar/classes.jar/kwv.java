import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AlbumImageProxy;
import com.tencent.mobileqq.widget.RotateBitmap;

public class kwv
  extends Handler
{
  public kwv(AlbumImageProxy paramAlbumImageProxy) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (Bitmap)paramMessage.obj;
    this.a.setImageRotateBitmapResetBase(new RotateBitmap(paramMessage, 0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kwv
 * JD-Core Version:    0.7.0.1
 */