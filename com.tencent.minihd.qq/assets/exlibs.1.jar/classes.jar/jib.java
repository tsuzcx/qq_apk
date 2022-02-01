import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import java.util.List;

public class jib
  extends TroopObserver
{
  public jib(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(paramBoolean, paramInt, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jib
 * JD-Core Version:    0.7.0.1
 */