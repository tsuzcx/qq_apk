import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.ipc.QavCallbackWrapper;

public class bzo
  implements Runnable
{
  public bzo(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    Object localObject = QavBussinessCtrl.a().a();
    if (localObject != null)
    {
      Bitmap localBitmap = ((QavCallbackWrapper)localObject).a(this.a.a.a(), this.a.a.a());
      localObject = ((QavCallbackWrapper)localObject).a(this.a.a.a(), this.a.a.a());
      QavChatHandler.a().b().post(new bzp(this, localBitmap, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzo
 * JD-Core Version:    0.7.0.1
 */