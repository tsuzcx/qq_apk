import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class efv
  implements View.OnClickListener
{
  public efv(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.app.e(true);
    if ((LbsBaseActivity.c(this.a) != null) && (LbsBaseActivity.c(this.a).isShowing())) {
      LbsBaseActivity.c(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     efv
 * JD-Core Version:    0.7.0.1
 */