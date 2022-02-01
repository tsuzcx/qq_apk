package cooperation.secmsg.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;

public class SecMsgResultReceiver
  extends ResultReceiver
{
  private QQAppInterface a;
  
  public SecMsgResultReceiver(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramQQAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle = BaseReq.a(paramBundle);
    if (paramBundle != null) {
      paramBundle.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.secmsg.ipc.SecMsgResultReceiver
 * JD-Core Version:    0.7.0.1
 */