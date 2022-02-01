import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class gfs
  implements Runnable
{
  public gfs(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    List localList = ((FriendsManager)this.a.a.getManager(49)).c();
    localList = AddContactsView.a(this.a, localList);
    if ((localList != null) && (localList.size() > 0)) {}
    for (int i = localList.size();; i = 0)
    {
      AddContactsView.a(this.a).obtainMessage(1, 5, 0, localList).sendToTarget();
      if (i != 0)
      {
        ReportController.b(this.a.a, "CliOper", "", "", "0X8004E3E", "0X8004E3E", 0, 0, "", "", "", "");
        this.a.c = true;
      }
      AddContactsView.a(this.a).obtainMessage(4, i, 1).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfs
 * JD-Core Version:    0.7.0.1
 */