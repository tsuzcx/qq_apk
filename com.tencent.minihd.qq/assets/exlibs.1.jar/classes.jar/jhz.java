import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class jhz
  extends DatingObserver
{
  public jhz(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while ((!paramBoolean) || (paramLong1 != this.a.jdField_a_of_type_Long) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 75) || (!Utils.a(paramString1, this.a.u)) || (paramArrayOfByte == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.dating", 2, "profile get sig, sig " + paramArrayOfByte);
    }
    this.a.a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jhz
 * JD-Core Version:    0.7.0.1
 */