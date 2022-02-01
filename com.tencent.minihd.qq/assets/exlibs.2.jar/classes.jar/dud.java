import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dud
  implements View.OnFocusChangeListener
{
  public dud(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramView != DetailProfileActivity.a(this.a)) {
        break label68;
      }
      paramView = DetailProfileActivity.a(this.a).getText().toString();
      if ((TextUtils.isEmpty(paramView)) || (!TextUtils.isEmpty(paramView.trim()))) {}
    }
    label68:
    do
    {
      QQToast.a(this.a, "昵称不可以为空", 0).b(this.a.getTitleBarHeight());
      do
      {
        return;
      } while (paramView != DetailProfileActivity.d(this.a));
      paramView = DetailProfileActivity.d(this.a).getText().toString();
    } while ((TextUtils.isEmpty(paramView)) || (SearchBaseActivity.a.matcher(paramView).matches()));
    QQToast.a(this.a, "邮箱格式不正确", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dud
 * JD-Core Version:    0.7.0.1
 */