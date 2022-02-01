import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.av.app.QavChatHandler;
import com.tencent.qav.activity.QavInviteActivity;
import com.tencent.qav.ipc.QavCallbackObserver;

public class lip
  extends QavCallbackObserver
{
  public lip(QavInviteActivity paramQavInviteActivity) {}
  
  public void a(Bitmap paramBitmap)
  {
    QavChatHandler.a().b().post(new lir(this, paramBitmap));
  }
  
  public void a(String paramString)
  {
    QavChatHandler.a().b().post(new liq(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lip
 * JD-Core Version:    0.7.0.1
 */