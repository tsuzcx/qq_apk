import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class jia
  implements ConditionSearchManager.IConfigListener
{
  public jia(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt == 2))
    {
      if (NearbyPeopleProfileActivity.a(this.a) != null) {
        NearbyPeopleProfileActivity.a(this.a).c();
      }
      if (NearbyPeopleProfileActivity.a(this.a) != null) {
        NearbyPeopleProfileActivity.a(this.a).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jia
 * JD-Core Version:    0.7.0.1
 */