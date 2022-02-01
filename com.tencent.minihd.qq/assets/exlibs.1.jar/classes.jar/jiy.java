import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class jiy
  implements Runnable
{
  public jiy(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void run()
  {
    EntityManager localEntityManager = NearbyProfileDisplayPanel.a(this.a).app.a().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.a(NearbyProfileDisplayPanel.a(this.a));
      localEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jiy
 * JD-Core Version:    0.7.0.1
 */