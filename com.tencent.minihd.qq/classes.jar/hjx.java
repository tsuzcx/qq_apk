import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

public class hjx
  implements Runnable
{
  public hjx(FriendsManager paramFriendsManager, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_JavaLangString);
    if (((Card)localObject).iVoteIncrement > 0)
    {
      ((Card)localObject).iVoteIncrement = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a((Card)localObject);
    }
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)FriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager).a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_JavaLangString });
    localObject = localNearbyPeopleCard;
    if (localNearbyPeopleCard == null) {
      localObject = new NearbyPeopleCard();
    }
    if (((NearbyPeopleCard)localObject).likeCountInc > 0)
    {
      ((NearbyPeopleCard)localObject).likeCountInc = 0;
      if (((NearbyPeopleCard)localObject).getStatus() != 1000) {
        break label110;
      }
      FriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager).b((Entity)localObject);
    }
    label110:
    while ((((NearbyPeopleCard)localObject).getStatus() != 1001) && (((NearbyPeopleCard)localObject).getStatus() != 1002)) {
      return;
    }
    FriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager).a((Entity)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjx
 * JD-Core Version:    0.7.0.1
 */