import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.downloadnew.MyAppDialog;

public class ldr
  implements Runnable
{
  public ldr(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity.getResources();
    MyAppDialog localMyAppDialog = new MyAppDialog(this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity);
    localMyAppDialog.a(2131362598, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, true);
    localMyAppDialog.b(2131362599, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, true);
    localMyAppDialog.a(localResources.getString(2131362589));
    localMyAppDialog.b(localResources.getString(2131362600));
    localMyAppDialog.setCancelable(false);
    localMyAppDialog.setOnDismissListener(new lds(this));
    if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity != null) && (!this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity.isFinishing())) {
      localMyAppDialog.show();
    }
    this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog = localMyAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ldr
 * JD-Core Version:    0.7.0.1
 */