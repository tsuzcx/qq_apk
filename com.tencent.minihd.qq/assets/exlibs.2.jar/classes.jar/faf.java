import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class faf
  extends FriendListObserver
{
  public faf(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      SettingUncommUsedContactsActivity.a(this.a, this.a.a.a(), paramBoolean2);
      SettingUncommUsedContactsActivity.a(this.a, this.a.b.a(), paramBoolean3);
    }
  }
  
  protected void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131368455, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.a.a(), paramBoolean2);
    }
  }
  
  protected void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131368455, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.b.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     faf
 * JD-Core Version:    0.7.0.1
 */