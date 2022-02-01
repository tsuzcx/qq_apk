import com.tencent.mobileqq.app.PPCLoginAuthHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class hmb
  implements Runnable
{
  public hmb(PPCLoginAuthHandler paramPPCLoginAuthHandler) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.b.a(this.a.b.a()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localEntityManager.a(ExtensionInfo.class, this.a.b.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localEntityManager.a(localExtensionInfo);
    }
    for (;;)
    {
      localEntityManager.a();
      return;
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.a.b.getAccount();
      localEntityManager.a(localExtensionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmb
 * JD-Core Version:    0.7.0.1
 */