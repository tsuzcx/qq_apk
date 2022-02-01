import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class drn
  implements View.OnClickListener
{
  public drn(Contacts paramContacts) {}
  
  public void onClick(View paramView)
  {
    Contacts.a(this.a);
    AddContactsActivity.a(this.a.getActivity());
    ReportController.b(this.a.app, "CliOper", "", "", "0X8006126", "0X8006126", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drn
 * JD-Core Version:    0.7.0.1
 */