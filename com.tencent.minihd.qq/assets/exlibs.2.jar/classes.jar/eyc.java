import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class eyc
  extends WtloginObserver
{
  public eyc(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("RegisterQQNumberActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("RegisterQQNumberActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    RegisterQQNumberActivity.a(this.a);
    paramString = new Intent(this.a, LoginActivity.class);
    paramString.putExtra("uin", RegisterQQNumberActivity.a(this.a));
    paramString.putExtra("tab_index", 1);
    paramString.addFlags(131072);
    this.a.startActivity(paramString);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eyc
 * JD-Core Version:    0.7.0.1
 */