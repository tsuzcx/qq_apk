import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QualityCheckBox;
import java.util.ArrayList;

public class gsy
  implements View.OnClickListener
{
  public gsy(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    paramView = PresendPicMgr.a(null);
    if (this.a.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.jdField_b_of_type_Int)))
    {
      this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      int i = this.a.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.jdField_b_of_type_Int));
      if (i >= 0)
      {
        this.a.jdField_b_of_type_JavaUtilArrayList.remove(i);
        if (paramView != null) {
          paramView.b((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_b_of_type_Int));
        }
      }
      PhotoPreviewActivity.a(this.a);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.isChecked()) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(PhotoPreviewActivity.a(this.a), this.a.jdField_a_of_type_Int);
      }
      return;
      if ((PhotoPreviewActivity.a(this.a) == 2) && (this.a.jdField_b_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
        PhotoPreviewActivity.a(this.a, (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_b_of_type_Int));
      }
      this.a.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if ((paramView != null) && (this.a.jdField_b_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
        paramView.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_b_of_type_Int));
      }
      this.a.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(this.a.jdField_b_of_type_Int));
      PhotoPreviewActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsy
 * JD-Core Version:    0.7.0.1
 */