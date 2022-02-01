import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class epg
  extends CardObserver
{
  public epg(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing())) {
      PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean2);
    }
  }
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.d.a(), paramBoolean2);
    }
  }
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing()) {
      PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean2);
    }
  }
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean)
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(49)).b(this.a.app.a());
    PermisionPrivacyActivity.a(this.a, this.a.d.a(), localCard.allowPeopleSee);
  }
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.a.a(2131368455, 1);
    }
    if (paramBoolean2)
    {
      PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean3);
      return;
    }
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     epg
 * JD-Core Version:    0.7.0.1
 */