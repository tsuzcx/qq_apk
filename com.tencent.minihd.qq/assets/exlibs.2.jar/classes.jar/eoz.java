import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;

public class eoz
  implements View.OnClickListener
{
  public eoz(PayBridgeActivity paramPayBridgeActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297371: 
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      paramView = QWalletPushManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity.a);
      PayBridgeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    QWalletPushManager.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityPayBridgeActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eoz
 * JD-Core Version:    0.7.0.1
 */