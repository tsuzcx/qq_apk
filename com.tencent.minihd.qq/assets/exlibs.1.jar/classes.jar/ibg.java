import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.dating.DatingExtraActivity;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class ibg
  implements ActionSheet.OnDismissListener
{
  public ibg(DatingExtraActivity paramDatingExtraActivity) {}
  
  public void onDismiss()
  {
    DatingBaseActivity.a(this.a.app, "0X800494E", "00000000");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibg
 * JD-Core Version:    0.7.0.1
 */