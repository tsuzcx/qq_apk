import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import java.util.List;

public class gib
  implements Runnable
{
  public gib(RecommendListView paramRecommendListView) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (RecommendListView.a(this.a))
      {
        if (!RecommendListView.a(this.a)) {
          return;
        }
        Object localObject1 = (PhoneContactManager)this.a.a.getManager(10);
        if (localObject1 != null)
        {
          localObject1 = ((PhoneContactManager)localObject1).c();
          this.a.a.runOnUiThread(new gic(this, (List)localObject1));
          return;
        }
      }
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gib
 * JD-Core Version:    0.7.0.1
 */