import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vipav.VipOpenVipDialog;

public final class kwj
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (VipOpenVipDialog.a != null) {
      VipUtils.a(VipOpenVipDialog.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, VipOpenVipDialog.a.jdField_a_of_type_JavaLangString, VipOpenVipDialog.a.jdField_b_of_type_JavaLangString, VipOpenVipDialog.a.c, VipOpenVipDialog.a.jdField_a_of_type_Int, VipOpenVipDialog.a.jdField_b_of_type_Int, VipOpenVipDialog.a.jdField_a_of_type_ArrayOfJavaLangString);
    }
    VipOpenVipDialog.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kwj
 * JD-Core Version:    0.7.0.1
 */