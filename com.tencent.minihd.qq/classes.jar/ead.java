import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ead
  extends SearchResultDialog
{
  public ead(ForwardRecentActivity paramForwardRecentActivity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, ForwardOperations paramForwardOperations, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramForwardOperations, paramInt2);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (ForwardRecentActivity.a(this.a) != null)
    {
      Iterator localIterator = ForwardRecentActivity.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)localIterator.next();
        long l = 0L;
        switch (localRecentUser.type)
        {
        }
        for (;;)
        {
          localArrayList.add(new ContactsSearchableRecentUser(paramContext, paramQQAppInterface, localRecentUser, l, a()));
          break;
          l = 42949672960L;
          continue;
          l = 17179869184L;
          continue;
          l = 25769803776L;
          continue;
          l = 25769803776L;
        }
      }
    }
    if ((FriendManager)paramQQAppInterface.getManager(8) == null) {
      return localArrayList;
    }
    if (ForwardRecentActivity.a(this.a)) {
      localArrayList.addAll(a(paramContext, paramQQAppInterface, 38654705664L, paramInt, false, null));
    }
    if (ForwardRecentActivity.b(this.a)) {
      localArrayList.addAll(a(paramContext, paramQQAppInterface, false));
    }
    if (ForwardRecentActivity.c(this.a)) {
      localArrayList.addAll(a(paramContext, paramQQAppInterface, 30064771072L, paramInt, null, b()));
    }
    if (ForwardRecentActivity.d(this.a)) {
      localArrayList.addAll(a());
    }
    if (ForwardRecentActivity.e(this.a)) {
      localArrayList.addAll(c(paramContext, paramQQAppInterface, 21474836480L, paramInt));
    }
    if (ForwardRecentActivity.f(this.a)) {
      localArrayList.addAll(b(paramContext, paramQQAppInterface, 21474836480L, paramInt));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ead
 * JD-Core Version:    0.7.0.1
 */