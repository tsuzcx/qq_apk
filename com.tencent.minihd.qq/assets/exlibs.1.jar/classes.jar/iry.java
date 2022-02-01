import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.io.UnsupportedEncodingException;

public class iry
  implements Runnable
{
  public iry(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void run()
  {
    OfflineFileUploadPara localOfflineFileUploadPara = new OfflineFileUploadPara();
    localOfflineFileUploadPara.jdField_a_of_type_JavaLangString = this.a.e;
    localOfflineFileUploadPara.jdField_a_of_type_Long = this.a.d;
    this.a.jdField_a_of_type_ArrayOfByte = FileManagerUtil.c(this.a.jdField_b_of_type_JavaLangString);
    this.a.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString);
    this.a.c = FileManagerUtil.b(this.a.jdField_b_of_type_JavaLangString);
    localOfflineFileUploadPara.c = this.a.jdField_a_of_type_ArrayOfByte;
    localOfflineFileUploadPara.d = this.a.jdField_b_of_type_ArrayOfByte;
    localOfflineFileUploadPara.e = this.a.c;
    try
    {
      localOfflineFileUploadPara.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localOfflineFileUploadPara.jdField_a_of_type_ArrayOfByte = this.a.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localOfflineFileUploadPara, FileManagerRSWorker.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iry
 * JD-Core Version:    0.7.0.1
 */