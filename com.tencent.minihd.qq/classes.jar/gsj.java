import android.view.View;
import com.tencent.mobileqq.activity.photo.PhotoCropAction;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gsj
  implements ActionSheet.OnButtonClickListener
{
  public gsj(PhotoCropAction paramPhotoCropAction, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.a();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsj
 * JD-Core Version:    0.7.0.1
 */