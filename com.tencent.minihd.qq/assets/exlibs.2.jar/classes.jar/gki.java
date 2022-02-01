import android.content.Context;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.ContactSearchableTroop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gki
  extends SearchResultDialog
{
  public gki(TroopView paramTroopView, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, ForwardOperations paramForwardOperations, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramForwardOperations, paramInt2);
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = this.a.a.a();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new ContactSearchableTroop(paramContext, paramQQAppInterface, (TroopInfo)((Iterator)localObject).next(), 0L, 21474836480L));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gki
 * JD-Core Version:    0.7.0.1
 */