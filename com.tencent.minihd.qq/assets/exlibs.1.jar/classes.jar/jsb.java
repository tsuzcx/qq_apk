import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;

public class jsb
  implements View.OnClickListener
{
  public jsb(EditActivity paramEditActivity, int paramInt, SignatureTemplateConfig.SignatureTemplateType paramSignatureTemplateType) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.b) {
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[0] + EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity) > EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).getWidth()) {
      EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).smoothScrollTo(arrayOfInt[0] + EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity) - EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).getWidth() + EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).getScrollX(), EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).getScrollY());
    }
    if (arrayOfInt[0] < 0)
    {
      paramView = EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity);
      int i = EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).getScrollX();
      paramView.smoothScrollTo(arrayOfInt[0] + i, EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).getScrollY());
    }
    EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.h();
    EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).setCurrentItem(EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity)[this.jdField_a_of_type_Int], false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.app, "CliOper", "", "", "signiture", "set_clk_tab_id", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.jdField_a_of_type_Int, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsb
 * JD-Core Version:    0.7.0.1
 */