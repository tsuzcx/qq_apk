import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class fez
  extends SubAccountBindObserver
{
  public fez(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + SubLoginActivity.b(this.a));
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if (!SubLoginActivity.b(this.a)) {}
    for (;;)
    {
      return;
      SubLoginActivity.b(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount: start");
      }
      this.a.a();
      Object localObject;
      if (paramBoolean)
      {
        this.a.b(this.a.getString(2131368716));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        SubAccountAssistantForward.b(this.a.app);
        SubAccountAssistantForward.a(this.a.app);
        localObject = new Intent(this.a, SplashActivity.class);
        ((Intent)localObject).putExtra("tab_index", 1);
        ((Intent)localObject).setFlags(67108864);
        this.a.startActivity((Intent)localObject);
        this.a.finish();
      }
      while ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel()))
      {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
        return;
        switch (paramSubAccountBackProtocData.p)
        {
        default: 
          this.a.a(this.a.getString(2131368697));
          break;
        case 1002: 
          SubAccountControll.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(this.a.getString(2131368694));
          break;
        case 1004: 
          String str = paramSubAccountBackProtocData.a;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131368696);
          }
          this.a.a((String)localObject);
          this.a.runOnUiThread(new ffa(this));
          SubLoginActivity.a(this.a, null);
          SubAccountAssistantForward.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fez
 * JD-Core Version:    0.7.0.1
 */