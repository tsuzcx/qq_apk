import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public class hqs
  implements Comparator
{
  public hqs(RecentUserCache paramRecentUserCache) {}
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    paramEntity1 = (RecentUser)paramEntity1;
    paramEntity2 = (RecentUser)paramEntity2;
    long l1 = Math.max(paramEntity1.lastmsgtime, paramEntity1.lastmsgdrafttime);
    long l2 = Math.max(paramEntity2.lastmsgtime, paramEntity2.lastmsgdrafttime);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqs
 * JD-Core Version:    0.7.0.1
 */