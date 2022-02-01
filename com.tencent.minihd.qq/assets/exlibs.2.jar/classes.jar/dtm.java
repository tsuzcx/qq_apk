import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dtm
  implements DialogInterface.OnClickListener
{
  public dtm(Conversation paramConversation) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramDialogInterface.putExtra("tab_tab_type", 0);
      this.a.startActivity(paramDialogInterface);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006122", "0X8006122", 0, 0, "0", "", "", "");
      return;
    case 1: 
      AddContactsActivity.a(this.a.getActivity());
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006122", "0X8006122", 0, 0, "1", "", "", "");
      return;
    }
    paramDialogInterface = new Intent(this.a, ScannerActivity.class);
    paramDialogInterface.putExtra("from", "Conversation");
    paramDialogInterface.putExtra("is_activity_to_fragment", false);
    paramDialogInterface.setFlags(67108864);
    this.a.startActivity(paramDialogInterface);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8006122", "0X8006122", 0, 0, "4", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtm
 * JD-Core Version:    0.7.0.1
 */