import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.MayKnowAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class gfn
  extends FriendListObserver
{
  public gfn(AddContactsView paramAddContactsView) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    if (paramBoolean1)
    {
      paramObject = (List)paramObject;
      paramObject = AddContactsView.a(this.a, paramObject);
      gfv localgfv = AddContactsView.a(this.a);
      int i;
      if (paramBoolean2)
      {
        i = 1;
        if (!paramBoolean3) {
          break label153;
        }
      }
      label153:
      for (int j = 5;; j = 1)
      {
        localgfv.obtainMessage(i, j, 0, paramObject).sendToTarget();
        if ((!this.a.c) && (paramObject != null) && (paramObject.size() > 0)) {
          ReportController.b(this.a.a, "CliOper", "", "", "0X8004E3E", "0X8004E3E", 0, 0, "", "", "", "");
        }
        this.a.a.getPreferences().edit().putLong("sp_get_mayknow_timestamp", System.currentTimeMillis()).commit();
        return;
        i = 2;
        break;
      }
    }
    AddContactsView.a(this.a, 3);
    AddContactsView.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfn
 * JD-Core Version:    0.7.0.1
 */