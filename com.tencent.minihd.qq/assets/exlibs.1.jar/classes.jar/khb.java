import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;

public class khb
  implements Runnable
{
  public khb(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity) {}
  
  public void run()
  {
    Object localObject = this.a.app.a().createEntityManager().a(TroopBarUploadItemEntity.class);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopBarUploadItemEntity localTroopBarUploadItemEntity = (TroopBarUploadItemEntity)((Iterator)localObject).next();
        if (localTroopBarUploadItemEntity.mState == 6)
        {
          String str1 = this.a.app.a();
          String str2 = ((TicketManager)this.a.app.getManager(2)).getSkey(str1);
          this.a.a.b(this.a.app, str1, str2, localTroopBarUploadItemEntity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     khb
 * JD-Core Version:    0.7.0.1
 */