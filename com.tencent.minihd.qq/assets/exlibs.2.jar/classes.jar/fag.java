import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class fag
  implements CompoundButton.OnCheckedChangeListener
{
  public fag(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (((paramCompoundButton == this.a.a.a()) || (paramCompoundButton == this.a.b.a())) && (!NetworkUtil.e(this.a.getActivity())))
    {
      this.a.a(2131369864, 1);
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      if (!paramBoolean)
      {
        paramBoolean = bool;
        SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, paramCompoundButton, paramBoolean);
      }
    }
    do
    {
      return;
      paramBoolean = false;
      break;
      if (paramCompoundButton == this.a.a.a())
      {
        this.a.app.f(paramBoolean, true);
        return;
      }
    } while (paramCompoundButton != this.a.b.a());
    this.a.app.g(paramBoolean, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fag
 * JD-Core Version:    0.7.0.1
 */