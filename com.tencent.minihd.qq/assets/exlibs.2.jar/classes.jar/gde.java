import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public final class gde
  implements DialogInterface.OnClickListener
{
  public gde(AbsShareMsg paramAbsShareMsg, Activity paramActivity, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "qbShowWpaResultDialog back");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        paramDialogInterface = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("appid");
        if (paramDialogInterface != null) {
          ForwardOperations.a(this.jdField_a_of_type_AndroidAppActivity, true, this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("callback_type"), Long.parseLong(paramDialogInterface));
        }
      }
      Util.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8004B56", "0X8004B56", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", 1);
    paramDialogInterface.setFlags(335544320);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8004B55", "0X8004B55", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gde
 * JD-Core Version:    0.7.0.1
 */