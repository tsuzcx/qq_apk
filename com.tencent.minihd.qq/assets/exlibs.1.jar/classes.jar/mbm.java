import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import cooperation.qzone.UploadServerSetting;

public class mbm
  implements DialogInterface.OnClickListener
{
  public mbm(UploadServerSetting paramUploadServerSetting, EditText paramEditText1, EditText paramEditText2, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.b != null))
    {
      paramDialogInterface = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      String str = this.b.getText().toString();
      UploadServerSetting.a(this.jdField_a_of_type_CooperationQzoneUploadServerSetting, paramDialogInterface, str);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadServerSetting", 2, "ShareAlbum update upload server");
      }
      IUploadService.UploadServiceCreator.getInstance().setTestServer(5);
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbm
 * JD-Core Version:    0.7.0.1
 */