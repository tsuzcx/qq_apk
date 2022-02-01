import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.widget.QQToast;

public class jii
  implements ConditionSearchManager.IConfigListener
{
  public jii(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.a();
    this.a.a.d(this);
    if (!paramBoolean) {
      QQToast.a(this.a, 2131369486, 0).b(this.a.getTitleBarHeight());
    }
    while (paramInt != 2) {
      return;
    }
    NearbyPeopleProfileActivity.a(this.a).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jii
 * JD-Core Version:    0.7.0.1
 */