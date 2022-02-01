import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;

public class jhn
  implements Runnable
{
  public jhn(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    if (localEntityManager != null) {
      if (this.a.jdField_a_of_type_Long <= 0L) {
        break label402;
      }
    }
    label392:
    label397:
    label402:
    for (Object localObject2 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.a.jdField_a_of_type_Long) });; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!StringUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
          localObject1 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString });
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject2).tinyId = this.a.jdField_a_of_type_Long;
        ((NearbyPeopleCard)localObject2).uin = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      ((NearbyPeopleCard)localObject2).nickname = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
      ((NearbyPeopleCard)localObject2).age = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Int;
      ((NearbyPeopleCard)localObject2).gender = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
      ((NearbyPeopleCard)localObject2).maritalStatus = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_Byte;
      ((NearbyPeopleCard)localObject2).job = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_Int;
      ((NearbyPeopleCard)localObject2).constellation = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_Byte;
      ((NearbyPeopleCard)localObject2).xuanYan = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_ArrayOfByte;
      ((NearbyPeopleCard)localObject2).distance = this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString;
      ((NearbyPeopleCard)localObject2).timeDiff = null;
      this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(101, localObject2).sendToTarget();
      localEntityManager.a();
      if ((!TextUtils.isEmpty(this.a.u)) && (this.a.q == 0))
      {
        localObject1 = (DatingManager)this.a.app.getManager(67);
        if (localObject1 == null) {
          break label397;
        }
      }
      for (localObject1 = ((DatingManager)localObject1).a(this.a.u, true);; localObject1 = null)
      {
        if (localObject1 != null)
        {
          this.a.q = ((DatingInfo)localObject1).datingSubject;
          localObject2 = this.a;
          if (((DatingInfo)localObject1).publisherID != this.a.jdField_a_of_type_Long) {
            break label392;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((NearbyPeopleProfileActivity)localObject2).c = bool;
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jhn
 * JD-Core Version:    0.7.0.1
 */