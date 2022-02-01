import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

public class fdi
  implements DialogInterface.OnClickListener
{
  public fdi(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.a().c(SubAccountMessageActivity.a(this.a).subuin, 7000);
    paramDialogInterface = (SubAccountManager)this.a.app.getManager(59);
    if (paramDialogInterface != null) {
      paramDialogInterface.b(SubAccountMessageActivity.a(this.a).subuin);
    }
    paramDialogInterface = new Intent(this.a, SubLoginActivity.class);
    paramDialogInterface.putExtra("fromWhere", this.a.a);
    this.a.startActivity(paramDialogInterface);
    this.a.b();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdi
 * JD-Core Version:    0.7.0.1
 */