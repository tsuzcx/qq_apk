import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.dating.DatingFilterActivity;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.ActionSheet;

public class ibr
  implements IphonePickerView.IphonePickListener
{
  public ibr(DatingFilterActivity paramDatingFilterActivity) {}
  
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
    if (this.a.jdField_a_of_type_Int == 0)
    {
      DatingFilterActivity.a(this.a).setRightText(DatingFilters.a[paramInt2]);
      DatingFilterActivity.a(this.a).h = paramInt2;
      return;
    }
    if (this.a.jdField_a_of_type_Int == 1)
    {
      DatingFilterActivity.b(this.a).setRightText(DatingFilters.b[paramInt2]);
      DatingFilterActivity.a(this.a).e = paramInt2;
      return;
    }
    DatingFilterActivity.c(this.a).setRightText(DatingFilters.c[paramInt2]);
    DatingFilterActivity.a(this.a).f = paramInt2;
    DatingFilterActivity.a(this.a).g = DatingFilterActivity.a(this.a).a(paramInt2);
    Object localObject = DatingFilterActivity.d(this.a);
    FormSimpleItem localFormSimpleItem;
    if (DatingFilterActivity.a(this.a).g == 5)
    {
      paramInt1 = 0;
      ((FormSimpleItem)localObject).setVisibility(paramInt1);
      localFormSimpleItem = DatingFilterActivity.b(this.a);
      if (DatingFilterActivity.a(this.a).g != 5) {
        break label197;
      }
    }
    label197:
    for (localObject = this.a.getString(2131369932);; localObject = this.a.getString(2131369755))
    {
      localFormSimpleItem.setLeftText((CharSequence)localObject);
      return;
      paramInt1 = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibr
 * JD-Core Version:    0.7.0.1
 */