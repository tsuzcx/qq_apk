import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class dxv
  extends SearchResultDialog
{
  public dxv(ForwardFriendListActivity paramForwardFriendListActivity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, ForwardOperations paramForwardOperations, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramForwardOperations, paramInt2);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = ForwardFriendListActivity.a(this.a).a();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ArrayList)localHashMap.get((Integer)localIterator.next());
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, ForwardFriendListActivity.a(this.a).a(localFriends.groupid), 0L, 38654705664L));
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxv
 * JD-Core Version:    0.7.0.1
 */