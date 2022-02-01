import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.ActionSheet;

public class hwe
  implements IphonePickerView.IphonePickListener
{
  public hwe(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
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
    if (this.a.c == 0)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ConditionSearchFriendActivity.jdField_b_of_type_ArrayOfJavaLangString.length) {}
      }
      else
      {
        paramInt1 = 0;
      }
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchFriendActivity.jdField_b_of_type_ArrayOfJavaLangString[paramInt1]);
      this.a.jdField_b_of_type_Int = paramInt1;
      return;
    }
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < ConditionSearchFriendActivity.jdField_a_of_type_ArrayOfJavaLangString.length) {}
    }
    else
    {
      paramInt1 = 0;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchFriendActivity.jdField_a_of_type_ArrayOfJavaLangString[paramInt1]);
    this.a.jdField_a_of_type_Int = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hwe
 * JD-Core Version:    0.7.0.1
 */