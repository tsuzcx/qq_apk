import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.ClearableEditText.OnTextClearedListener;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ehs
  implements ClearableEditText.OnTextClearedListener
{
  public ehs(LoginActivity paramLoginActivity) {}
  
  public void a()
  {
    libsafeedit.clearPassBuffer();
    this.a.getAppRuntime().stopPCActivePolling("clearPassInput");
    if ((LoginActivity.a(this.a) == null) || (LoginActivity.a(this.a).size() <= 0) || (LoginActivity.a(this.a) == null) || (LoginActivity.a(this.a).getText() == null) || (LoginActivity.a(this.a).getText().toString() == null)) {}
    label82:
    Object localObject;
    label140:
    do
    {
      return;
      int i = 0;
      SimpleAccount localSimpleAccount;
      if (i < LoginActivity.a(this.a).size())
      {
        localObject = LoginActivity.a(this.a).getText().toString();
        localSimpleAccount = (SimpleAccount)LoginActivity.a(this.a).get(i);
        if (localSimpleAccount != null) {
          break label140;
        }
      }
      while (!((String)localObject).equals(this.a.app.b(localSimpleAccount.getUin())))
      {
        i += 1;
        break label82;
        break;
      }
      this.a.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
      LoginActivity.a(this.a, null);
      this.a.app.getApplication().refreAccountList();
      localObject = this.a.getAppRuntime().getApplication().getAllAccounts();
    } while ((localObject == null) || (LoginActivity.a(this.a) == null));
    LoginActivity.a(this.a).clear();
    LoginActivity.a(this.a).addAll((Collection)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehs
 * JD-Core Version:    0.7.0.1
 */