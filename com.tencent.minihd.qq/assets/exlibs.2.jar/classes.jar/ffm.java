import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;

public class ffm
  implements DialogInterface.OnDismissListener
{
  public ffm(ThemeSwitchDlgActivity paramThemeSwitchDlgActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ffm
 * JD-Core Version:    0.7.0.1
 */