import QQService.TagInfo;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class dxf
  implements CompoundButton.OnCheckedChangeListener
{
  dxf(dxe paramdxe, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.app.aL)
      {
        this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Dxe.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Dxg != null) {
        this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Dxg.notifyDataSetChanged();
      }
      return;
      paramCompoundButton.setChecked(false);
      continue;
      int i = 0;
      while (i < this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((TagInfo)this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.get(i)).iTagId == ((TagInfo)this.jdField_a_of_type_Dxe.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).iTagId)
        {
          this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.remove(i);
          this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.jdField_a_of_type_Dxe.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList.size());
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxf
 * JD-Core Version:    0.7.0.1
 */