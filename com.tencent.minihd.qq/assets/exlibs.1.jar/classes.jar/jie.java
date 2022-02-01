import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingCacheMng;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class jie
  implements Runnable
{
  public jie(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    Object localObject = (DatingManager)this.a.app.getManager(67);
    if (localObject != null) {}
    for (localObject = ((DatingManager)localObject).a().a(this.a.u, this.a.a);; localObject = null)
    {
      if (localObject != null)
      {
        this.a.a((byte[])localObject);
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, "profile create, get sig from db");
        }
      }
      do
      {
        return;
        localObject = (DatingHandler)this.a.app.a(40);
        if (localObject != null) {
          ((DatingHandler)localObject).a(this.a.u, this.a.a, 0);
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dating", 2, "profile create, get sig  dh = " + localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jie
 * JD-Core Version:    0.7.0.1
 */