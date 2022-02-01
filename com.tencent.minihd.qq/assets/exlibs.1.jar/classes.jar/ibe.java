import android.view.View;
import com.tencent.mobileqq.dating.DatingExtraActivity;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ibe
  implements ActionSheet.OnButtonClickListener
{
  public ibe(DatingExtraActivity paramDatingExtraActivity, ActionSheet paramActionSheet, DatingHandler paramDatingHandler, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqDatingDatingExtraActivity.getApplicationContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingExtraActivity.b(2131369798);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingExtraActivity.a(0, 2131369797, 0);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler.b(this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibe
 * JD-Core Version:    0.7.0.1
 */