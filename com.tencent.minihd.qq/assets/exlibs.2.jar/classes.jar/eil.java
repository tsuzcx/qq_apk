import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class eil
  implements TextWatcher
{
  public eil(LoginActivity paramLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    LoginActivity.b(this.a);
    if (LoginActivity.a(this.a) != null) {
      LoginActivity.a(this.a, null);
    }
    do
    {
      do
      {
        return;
      } while (paramCharSequence == null);
      paramCharSequence = paramCharSequence.toString();
    } while ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (LoginActivity.a(this.a) == null));
    paramInt1 = 0;
    label60:
    SimpleAccount localSimpleAccount;
    if (paramInt1 < LoginActivity.a(this.a).size())
    {
      localSimpleAccount = (SimpleAccount)LoginActivity.a(this.a).get(paramInt1);
      if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
        break label114;
      }
    }
    label114:
    while (!paramCharSequence.equals(this.a.app.b(localSimpleAccount.getUin())))
    {
      paramInt1 += 1;
      break label60;
      break;
    }
    if ((localSimpleAccount != null) && (localSimpleAccount.isLogined()))
    {
      LoginActivity.a(this.a).setText("!@#ewaGbhkc$!!=");
      LoginActivity.a(this.a, localSimpleAccount);
    }
    for (;;)
    {
      LoginActivity.a(this.a).setClearButtonVisible(false);
      return;
      LoginActivity.a(this.a).setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eil
 * JD-Core Version:    0.7.0.1
 */