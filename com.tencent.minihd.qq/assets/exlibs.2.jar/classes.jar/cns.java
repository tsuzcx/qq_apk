import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;

public class cns
  implements View.OnClickListener
{
  public cns(EditUniqueTitleActivity paramEditUniqueTitleActivity, AlertDialog paramAlertDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.a.getEditableText().toString();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
      return;
      long l = NetConnInfoCenter.getServerTime();
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, (String)localObject);
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, (int)l + 2592000);
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity), EditUniqueTitleActivity.b(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity), EditUniqueTitleActivity.c(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity), EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity));
      localObject = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.app;
      String str = EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity);
      if (TextUtils.isEmpty(EditUniqueTitleActivity.c(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity))) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, str, paramView, "1", "1");
        break;
      }
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, (String)localObject);
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, -1);
      EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity, EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity), EditUniqueTitleActivity.b(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity), EditUniqueTitleActivity.c(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity), EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity));
      localObject = this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.app;
      str = EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity);
      if (TextUtils.isEmpty(EditUniqueTitleActivity.c(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity))) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, str, paramView, "1", "0");
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity.app, "P_CliOper", "Grp_manage", "", "mber_title", "cancle_title", 0, 0, EditUniqueTitleActivity.a(this.jdField_a_of_type_ComTencentBizTroopEditUniqueTitleActivity), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cns
 * JD-Core Version:    0.7.0.1
 */