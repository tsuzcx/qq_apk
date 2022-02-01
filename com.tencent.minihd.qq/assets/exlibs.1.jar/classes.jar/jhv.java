import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class jhv
  implements Runnable
{
  jhv(jht paramjht) {}
  
  public void run()
  {
    this.a.a.app.b(this.a.a.app.a(), 3000);
    EntityManager localEntityManager = this.a.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.a.app.a() });
      if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
        this.a.a.app.b(String.valueOf(localNearbyPeopleCard.tinyId), 3001);
      }
      localEntityManager.a();
    }
    if (NearbyPeopleProfileActivity.a(this.a.a)) {
      NearbyPeopleProfileActivity.a(this.a.a).d();
    }
    new Handler(ThreadManager.b()).postDelayed(new jhw(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jhv
 * JD-Core Version:    0.7.0.1
 */