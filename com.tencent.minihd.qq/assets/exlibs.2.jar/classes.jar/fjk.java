import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

class fjk
  implements View.OnClickListener
{
  fjk(fji paramfji, String paramString, CheckBox paramCheckBox, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopHandler)this.jdField_a_of_type_Fji.a.app.a(19);
    Object localObject;
    if (paramView != null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_JavaLangString)));
      paramView.a(Long.parseLong(this.jdField_a_of_type_Fji.a.i), (List)localObject, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      localObject = this.jdField_a_of_type_Fji.a.q;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label184;
      }
    }
    label184:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(this.jdField_a_of_type_Fji.a.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_Fji.a.i, (String)localObject, paramView, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_Fji.a.h();
      this.jdField_a_of_type_Fji.a.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fjk
 * JD-Core Version:    0.7.0.1
 */