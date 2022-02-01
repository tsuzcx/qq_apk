import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingBaseActivity;

public class hzs
  implements View.OnClickListener
{
  public hzs(DatingBaseActivity paramDatingBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if (DatingBaseActivity.a(this.a) != null)
    {
      DatingBaseActivity.a(this.a).dismiss();
      DatingBaseActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzs
 * JD-Core Version:    0.7.0.1
 */