import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jrs
  implements View.OnClickListener
{
  public jrs(EditActivity paramEditActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.app, "CliOper", "", "", "signiture", "set_clk_his", 0, 0, "0", "", "", "");
    StatusHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity, this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.app.c(), 0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jrs
 * JD-Core Version:    0.7.0.1
 */