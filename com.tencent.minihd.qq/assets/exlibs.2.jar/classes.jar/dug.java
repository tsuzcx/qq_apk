import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

public class dug
  implements IphonePickerView.IphonePickListener
{
  public dug(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void a()
  {
    if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.jdField_a_of_type_Boolean = true;
    DetailProfileActivity localDetailProfileActivity = this.a;
    if (paramInt2 == 0) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      localDetailProfileActivity.a(paramInt1, true);
      DetailProfileActivity.a(this.a, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dug
 * JD-Core Version:    0.7.0.1
 */