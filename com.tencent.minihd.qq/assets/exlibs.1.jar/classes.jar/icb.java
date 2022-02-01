import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;

public class icb
  implements View.OnClickListener
{
  public icb(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public void onClick(View paramView)
  {
    if (DatingUserCenterActivity.a(this.a) != null)
    {
      DatingUserCenterActivity.a(this.a).dismiss();
      DatingUserCenterActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icb
 * JD-Core Version:    0.7.0.1
 */