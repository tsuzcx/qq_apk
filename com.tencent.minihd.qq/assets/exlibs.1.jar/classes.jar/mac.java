import VIP.RespCheckPayAuth;
import android.os.Handler;
import android.os.Message;
import cooperation.qwallet.open.OpenPayActivity;

public class mac
  extends Handler
{
  OpenPayActivity a;
  
  public mac(OpenPayActivity paramOpenPayActivity)
  {
    this.a = paramOpenPayActivity;
  }
  
  public void a()
  {
    this.a = null;
    super.removeCallbacksAndMessages(null);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (paramMessage.arg1 == 1) {}
    for (int i = 1;; i = 0)
    {
      paramMessage = paramMessage.obj;
      if (j == 3) {
        break;
      }
      return;
    }
    if ((i == 0) || (paramMessage == null))
    {
      this.a.a(-1011, "Connection error.", null, null);
      return;
    }
    paramMessage = (RespCheckPayAuth)paramMessage;
    if (paramMessage.ret != 0)
    {
      this.a.a(-1012, paramMessage.errMsg, null, null);
      return;
    }
    this.a.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */