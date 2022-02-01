import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class eys
  implements ActionSheet.OnButtonClickListener
{
  public eys(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "";
      Object localObject = RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).getText();
      if (localObject != null)
      {
        localObject = localObject.toString();
        paramView = (View)localObject;
        if (localObject != null) {
          paramView = ((String)localObject).trim();
        }
      }
      if (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity)) {
        RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.f, paramView);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.finish();
      return;
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, true);
      break;
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, false);
      break;
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity.f, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eys
 * JD-Core Version:    0.7.0.1
 */