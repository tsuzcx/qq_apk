import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class eib
  implements DialogInterface.OnClickListener
{
  public eib(LoginActivity paramLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (UpgradeDetailWrapper)this.a.getIntent().getParcelableExtra(UpgradeDetailWrapper.class.getSimpleName());
    UpgradeDetailActivity.a(this.a, paramDialogInterface, true, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eib
 * JD-Core Version:    0.7.0.1
 */