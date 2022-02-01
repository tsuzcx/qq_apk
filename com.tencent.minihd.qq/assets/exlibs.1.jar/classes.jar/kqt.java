import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.File;

public class kqt
  implements Runnable
{
  public kqt(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil.a(this.jdField_a_of_type_JavaLangString);
    File localFile = new File(str1);
    Object localObject = localFile.getParent();
    localObject = new File((String)localObject + "/download" + this.jdField_a_of_type_JavaLangString + ".xml");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (HttpDownloadUtil.a(null, MsfSdkUtils.insertMtype("QPSingle", this.b), (File)localObject))
    {
      String str2 = SecUtil.a(((File)localObject).getAbsolutePath());
      if (!this.c.equalsIgnoreCase(str2)) {
        AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil).putInt(this.c, 2);
      }
    }
    else
    {
      return;
    }
    if (((File)localObject).renameTo(localFile))
    {
      AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil).putInt(this.c, 3);
      this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil.a(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil.a(this.jdField_a_of_type_JavaLangString, this.c);
      AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil, str1);
      return;
    }
    AntiFraudConfigFileUtil.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil).putInt(this.c, 2);
    ((File)localObject).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kqt
 * JD-Core Version:    0.7.0.1
 */