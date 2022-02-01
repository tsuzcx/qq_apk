import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.qphone.base.util.QLog;

class iuf
  implements Runnable
{
  iuf(iue paramiue, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    QfavFilePreviewController.b(this.jdField_a_of_type_Iue.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    QfavFilePreviewController.c(this.jdField_a_of_type_Iue.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a) + ", port=" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a)) + ", key=" + QfavFilePreviewController.b(this.jdField_a_of_type_Iue.a) + ", retCode =" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a)));
    }
    FilePreviewActivity.ControlerCallback localControlerCallback;
    if (1 == QfavFilePreviewController.b(this.jdField_a_of_type_Iue.a))
    {
      localControlerCallback = this.jdField_a_of_type_Iue.a.a;
      if (0L != QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a)) {
        break label320;
      }
    }
    for (;;)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a), String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a)), QfavFilePreviewController.a(this.jdField_a_of_type_Iue.a), null, QfavFilePreviewController.b(this.jdField_a_of_type_Iue.a), null, QfavFilePreviewController.c(this.jdField_a_of_type_Iue.a));
      QfavFilePreviewController.b(this.jdField_a_of_type_Iue.a, 3);
      return;
      label320:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iuf
 * JD-Core Version:    0.7.0.1
 */