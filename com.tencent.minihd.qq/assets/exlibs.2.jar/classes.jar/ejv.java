import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SSOAccountObserver;

public class ejv
  extends SSOAccountObserver
{
  public ejv(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.e();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSOAccountObserver", 2, "onGetTicketNoPasswd wtTicket=" + paramArrayOfByte);
    }
    String str = null;
    if (paramInt == 4096) {
      str = new String(paramArrayOfByte);
    }
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("last_account", paramString);
    paramArrayOfByte.putExtra("wtTicket", str);
    paramArrayOfByte.putExtra("ssobundle", paramBundle);
    this.a.setResult(-1, paramArrayOfByte);
    this.a.finish();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ejv
 * JD-Core Version:    0.7.0.1
 */