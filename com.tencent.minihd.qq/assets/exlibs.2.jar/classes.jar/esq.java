import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class esq
  implements View.OnClickListener
{
  public esq(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a))
    {
      this.a.w();
      return;
    }
    if (NetworkUtil.b(this.a))
    {
      this.a.r();
      return;
    }
    DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131368754)).setMessage(2131368753).setPositiveButton(2131368755, new ess(this)).setNegativeButton(2131365736, new esr(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     esq
 * JD-Core Version:    0.7.0.1
 */