import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class fet
  implements TextWatcher
{
  public fet(SubLoginActivity paramSubLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SubLoginActivity.a(this.a) != null) {
      SubLoginActivity.a(this.a, null);
    }
    do
    {
      do
      {
        return;
      } while (paramCharSequence == null);
      paramCharSequence = paramCharSequence.toString();
    } while ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (SubLoginActivity.a(this.a) == null));
    paramInt1 = 0;
    label53:
    SimpleAccount localSimpleAccount;
    if (paramInt1 < SubLoginActivity.a(this.a).size())
    {
      localSimpleAccount = (SimpleAccount)SubLoginActivity.a(this.a).get(paramInt1);
      if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
        break label107;
      }
    }
    label107:
    while (!paramCharSequence.equals(this.a.app.b(localSimpleAccount.getUin())))
    {
      paramInt1 += 1;
      break label53;
      break;
    }
    if ((localSimpleAccount != null) && (localSimpleAccount.isLogined()))
    {
      SubLoginActivity.a(this.a).setText("!@#ewaGbhkc$!!=");
      SubLoginActivity.a(this.a, localSimpleAccount);
    }
    for (;;)
    {
      SubLoginActivity.a(this.a).setClearButtonVisible(false);
      return;
      SubLoginActivity.a(this.a).setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fet
 * JD-Core Version:    0.7.0.1
 */