import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class edt
  implements DialogInterface.OnClickListener
{
  public edt(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = GroupManagerActivity.a(this.a).getInputValue();
    if (paramDialogInterface.equals("")) {
      paramDialogInterface = this.a.getResources().getString(2131368814);
    }
    for (;;)
    {
      if (GroupManagerActivity.a(this.a) == 0) {
        if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          b = (byte)(((Groups)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1)).seqid + 1);
          GroupManagerActivity.a(this.a, this.a.a(b, paramDialogInterface));
          if (QLog.isColorLevel()) {
            QLog.d(GroupManagerActivity.jdField_a_of_type_JavaLangString, 2, "AddFriendGroup needShowDialog = " + GroupManagerActivity.a(this.a));
          }
          if (GroupManagerActivity.a(this.a)) {
            this.a.a(2131368017);
          }
          ReportController.b(this.a.app, "CliOper", "", "", "category", "Add_category", 0, 0, "", "", "", "");
        }
      }
      while (1 != GroupManagerActivity.a(this.a)) {
        for (;;)
        {
          return;
          byte b = 1;
        }
      }
      GroupManagerActivity.a(this.a, this.a.b((byte)GroupManagerActivity.a(this.a).group_id, paramDialogInterface));
      if (QLog.isColorLevel()) {
        QLog.d(GroupManagerActivity.jdField_a_of_type_JavaLangString, 2, "EditeFriendGroup needShowDialog = " + GroupManagerActivity.a(this.a));
      }
      if (GroupManagerActivity.a(this.a)) {
        this.a.a(2131368019);
      }
      ReportController.b(this.a.app, "CliOper", "", "", "category", "Name_category", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     edt
 * JD-Core Version:    0.7.0.1
 */