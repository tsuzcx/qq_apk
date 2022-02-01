import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public final class jwf
  implements View.OnClickListener
{
  public jwf(String paramString, JumpAction paramJumpAction) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "CliOper", "", "", "0X80060C3", "0X80060C3", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
    if (QLog.isColorLevel()) {
      QLog.d("splash", 2, "0X80060C3: md5 = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwf
 * JD-Core Version:    0.7.0.1
 */