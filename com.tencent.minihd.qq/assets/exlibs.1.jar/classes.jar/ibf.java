import android.view.View;
import com.tencent.mobileqq.data.DatingConfigItem;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.dating.DatingExtraActivity;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

public class ibf
  implements ActionSheet.OnButtonClickListener
{
  public ibf(DatingExtraActivity paramDatingExtraActivity, List paramList, ActionSheet paramActionSheet, DatingHandler paramDatingHandler, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqDatingDatingExtraActivity.getApplicationContext())) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingExtraActivity.b(2131369801);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingExtraActivity.a(0, 2131369800, 0);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler.a(this.jdField_a_of_type_JavaLangString, 0, ((DatingConfigItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id);
    DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingExtraActivity.app, "0X800494E", String.valueOf(((DatingConfigItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibf
 * JD-Core Version:    0.7.0.1
 */