import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qav.ipc.QavCallbackObserver;

public class bzl
  extends QavCallbackObserver
{
  public bzl(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void a(Bitmap paramBitmap)
  {
    QavChatHandler.a().b().post(new bzn(this, paramBitmap));
  }
  
  public void a(String paramString)
  {
    QavChatHandler.a().b().post(new bzm(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzl
 * JD-Core Version:    0.7.0.1
 */