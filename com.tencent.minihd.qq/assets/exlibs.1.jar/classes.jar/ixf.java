import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QQProxyForQlink.WState;
import java.util.ArrayList;
import java.util.List;

class ixf
  implements DialogInterface.OnClickListener
{
  ixf(ixe paramixe, QQProxyForQlink.WState paramWState) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Ixe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("0X8004855", 1);
    Object localObject = new ArrayList();
    ((List)localObject).add(this.jdField_a_of_type_Ixe.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ixe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$WState.jdField_a_of_type_JavaLangString, (List)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("_FILE_PATH_", this.jdField_a_of_type_Ixe.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("STRING_CONTINUE_SEND_TO_", true);
    this.jdField_a_of_type_Ixe.jdField_a_of_type_AndroidAppActivity.setResult(10, (Intent)localObject);
    this.jdField_a_of_type_Ixe.jdField_a_of_type_AndroidAppActivity.finish();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixf
 * JD-Core Version:    0.7.0.1
 */