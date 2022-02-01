import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class epk
  extends DatingObserver
{
  public epk(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (!paramBoolean) {
      PermisionPrivacyActivity.a(this.a, 2131368455);
    }
    PermisionPrivacyActivity.a(this.a, this.a.g.a(), PermisionPrivacyActivity.a(this.a).b());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.g.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     epk
 * JD-Core Version:    0.7.0.1
 */