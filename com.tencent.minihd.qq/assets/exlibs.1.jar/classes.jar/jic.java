import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.qphone.base.util.QLog;

public class jic
  implements Runnable
{
  public jic(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    NearbyPeopleProfileActivity.a(this.a).d();
    if (QLog.isColorLevel()) {
      QLog.i("Q.dating", 2, "updateDateSig sig = " + this.a.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jic
 * JD-Core Version:    0.7.0.1
 */