import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.servlet.QZonePreDownloadManagerImp;
import com.tencent.mobileqq.statistics.ReportController;

public class fbq
  implements View.OnClickListener
{
  public fbq(SplashActivity paramSplashActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297592)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.e = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131367905), "qqsetting_receivemsg_whenexit_key", bool);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().e();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().a();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getSharedPreferences("unreadcount", 4).edit();
    paramView.putInt("unread", i + j);
    paramView.commit();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.c();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.e;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.d = true;
    if (QQPlayerService.a())
    {
      paramView = new Intent();
      paramView.setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.sendBroadcast(paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.finish();
    paramView = (QZonePreDownloadManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(71);
    if (paramView != null) {
      paramView.a();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fbq
 * JD-Core Version:    0.7.0.1
 */