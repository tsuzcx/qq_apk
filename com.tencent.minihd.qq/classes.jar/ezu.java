import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.SendingFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;

class ezu
  implements Runnable
{
  ezu(ezt paramezt) {}
  
  public void run()
  {
    if (NetworkUtil.e(this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      return;
    }
    this.a.a.jdField_d_of_type_Boolean = true;
    SendMultiPictureHelper.a(this.a.a);
    this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    int i = 0;
    while (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      long l = this.a.a.a((SendMultiPictureHelper.SendingFileInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i), this.a.a.jdField_c_of_type_Int, this.a.a.jdField_d_of_type_JavaLangString, this.a.a.jdField_c_of_type_JavaLangString);
      ((SendMultiPictureHelper.SendingFileInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).a = l;
      this.a.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.a.f, new Object[] { Integer.valueOf(this.a.a.jdField_a_of_type_Int + i), Integer.valueOf(this.a.a.b), Integer.valueOf(0) }));
      i += 1;
    }
    this.a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ezu
 * JD-Core Version:    0.7.0.1
 */