import android.view.View;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DetailModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class idb
  implements ActionSheet.OnButtonClickListener
{
  public idb(DetailModel paramDetailModel, ActionSheet paramActionSheet, DatingComment paramDatingComment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a.b("0X8004F0F");
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_Int & 0x2) == 0) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a.b("0X8004F11");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a.b("0X8004F10");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idb
 * JD-Core Version:    0.7.0.1
 */