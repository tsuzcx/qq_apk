import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.ListItem;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;

public class flu
  extends CardObserver
{
  public flu(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.uin)))
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        UncommonlyUsedContactsActivity.ListItem localListItem;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localListItem = (UncommonlyUsedContactsActivity.ListItem)localIterator.next();
        } while ((localListItem.a == null) || (!paramObject.uin.equals(localListItem.a.uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.jdField_a_of_type_Flw.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flu
 * JD-Core Version:    0.7.0.1
 */