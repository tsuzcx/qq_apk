import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import java.util.ArrayList;
import java.util.Iterator;

public class dzx
  extends AutomatorObserver
{
  public dzx(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(int paramInt)
  {
    Object localObject1 = (ContactFacade)this.a.app.getManager(52);
    if (localObject1 == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        ForwardRecentActivity.c(this.a);
        return;
      case 1: 
        localObject2 = (FriendManager)this.a.app.getManager(8);
      }
    } while (localObject2 == null);
    Object localObject2 = ((FriendManager)localObject2).c();
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      ArrayList localArrayList;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localArrayList = ((ContactFacade)localObject1).a(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
      } while ((localArrayList == null) || (localArrayList.size() <= 0));
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        ForwardRecentActivity.a(this.a, false);
        break;
      }
      ForwardRecentActivity.a(this.a, true);
      break;
      localObject1 = ((ContactFacade)localObject1).a("-1004");
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        ForwardRecentActivity.b(this.a, false);
        break;
      }
      ForwardRecentActivity.b(this.a, true);
      break;
      localObject1 = ((ContactFacade)localObject1).a("-1003");
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        ForwardRecentActivity.c(this.a, false);
        break;
      }
      ForwardRecentActivity.c(this.a, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dzx
 * JD-Core Version:    0.7.0.1
 */