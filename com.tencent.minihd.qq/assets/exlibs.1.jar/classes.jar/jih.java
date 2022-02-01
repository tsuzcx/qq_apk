import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;

class jih
  implements Runnable
{
  jih(jig paramjig) {}
  
  public void run()
  {
    if (!StringUtil.b(NearbyPeopleProfileActivity.a(this.a.a).uin)) {
      this.a.a.app.a(NearbyPeopleProfileActivity.a(this.a.a).uin, 3000, false);
    }
    if (this.a.a.a > 0L) {
      this.a.a.app.a(String.valueOf(this.a.a.a), 3001, false);
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return;
      } while (StringUtil.b(NearbyPeopleProfileActivity.a(this.a.a).uin));
      localEntityManager = this.a.a.app.a().createEntityManager();
    } while (localEntityManager == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.a.a).uin });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
      this.a.a.app.a(String.valueOf(localNearbyPeopleCard.tinyId), 3001, false);
    }
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jih
 * JD-Core Version:    0.7.0.1
 */