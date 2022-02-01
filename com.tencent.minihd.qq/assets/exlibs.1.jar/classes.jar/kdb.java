import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class kdb
  implements Runnable
{
  public kdb(NearbyTroopsActivity paramNearbyTroopsActivity, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.c(NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity));
    if (NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity) == 0)
    {
      NearbyTroopsBaseView localNearbyTroopsBaseView = NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity, NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity));
      if ((localNearbyTroopsBaseView != null) && ((localNearbyTroopsBaseView instanceof NearbyTroopsView))) {
        ((NearbyTroopsView)localNearbyTroopsBaseView).setHasHotTroopRedDot(this.jdField_a_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.stopTitleProgress();
    if (NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity) != null) {
      NearbyTroopsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdb
 * JD-Core Version:    0.7.0.1
 */