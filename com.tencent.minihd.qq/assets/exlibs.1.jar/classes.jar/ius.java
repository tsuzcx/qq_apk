import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.qphone.base.util.QLog;

public class ius
{
  public final int a;
  final long jdField_a_of_type_Long;
  final Bundle jdField_a_of_type_AndroidOsBundle;
  public UniformDownloader a;
  public final String a;
  public final int b;
  
  public ius(UniformDownloadMgr paramUniformDownloadMgr, Bundle paramBundle, int paramInt1, UniformDownloader paramUniformDownloader, long paramLong, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader = paramUniformDownloader;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramUniformDownloader.a();
    this.b = paramInt2;
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] new DownloadInst.[ mUDID:[" + this.jdField_a_of_type_Long + "] url:" + this.jdField_a_of_type_JavaLangString + " ]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ius
 * JD-Core Version:    0.7.0.1
 */