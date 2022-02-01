import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.qav.activity.QavInviteActivity;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.ipc.QavCallbackWrapper;

public class lis
  implements Runnable
{
  public lis(QavInviteActivity paramQavInviteActivity) {}
  
  public void run()
  {
    Object localObject = QavBussinessCtrl.a().a();
    if (localObject != null)
    {
      Bitmap localBitmap = ((QavCallbackWrapper)localObject).a(this.a.a.a(), this.a.a.a());
      localObject = ((QavCallbackWrapper)localObject).a(this.a.a.a(), this.a.a.a());
      QavChatHandler.a().b().post(new lit(this, localBitmap, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lis
 * JD-Core Version:    0.7.0.1
 */