import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;

public class dfd
  extends BizTroopObserver
{
  public dfd(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    Switch localSwitch;
    AddFriendVerifyActivity localAddFriendVerifyActivity;
    if ((paramBoolean) && (paramInt1 == 1))
    {
      localSwitch = this.a.b.a();
      localSwitch.setOnCheckedChangeListener(null);
      localAddFriendVerifyActivity = this.a;
      if (paramInt2 != 1) {
        break label72;
      }
    }
    label72:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localAddFriendVerifyActivity.a = paramBoolean;
      localSwitch.setChecked(this.a.a);
      localSwitch.setOnCheckedChangeListener(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfd
 * JD-Core Version:    0.7.0.1
 */