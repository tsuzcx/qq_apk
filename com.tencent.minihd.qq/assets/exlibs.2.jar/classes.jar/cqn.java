import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class cqn
  implements BusinessObserver
{
  public cqn(Share paramShare) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    byte[] arrayOfByte;
    do
    {
      return;
      arrayOfByte = paramBundle.getByteArray("data");
    } while (arrayOfByte == null);
    paramBundle = new GetAppInfoProto.GetAppinfoResponse();
    try
    {
      paramBundle.mergeFrom(arrayOfByte);
      ThreadManager.a(new cqo(this, paramBundle));
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(Share.b(), 2, localInvalidProtocolBufferMicroException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqn
 * JD-Core Version:    0.7.0.1
 */