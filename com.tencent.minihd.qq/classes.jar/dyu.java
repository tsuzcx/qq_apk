import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class dyu
  implements DialogInterface.OnClickListener
{
  public dyu(ForwardOperations paramForwardOperations, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOperations", 2, "copy file error", paramDialogInterface);
      }
      ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dyu
 * JD-Core Version:    0.7.0.1
 */