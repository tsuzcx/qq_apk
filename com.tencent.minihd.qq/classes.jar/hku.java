import android.graphics.Bitmap;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class hku
  implements Runnable
{
  public hku(LebaHelper paramLebaHelper, URL paramURL, File paramFile, String paramString) {}
  
  public void run()
  {
    try
    {
      if (!HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_JavaIoFile)) {
        break label199;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "suc--------");
      }
      Bitmap localBitmap = LebaHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaIoFile);
      if (localBitmap != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "notify UI++++++++");
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.d.iterator();
        while (localIterator.hasNext()) {
          ((DownloadIconsListener)localIterator.next()).a(this.jdField_a_of_type_JavaLangString, localBitmap);
        }
      }
      LebaHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
      LebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
      return;
    }
    return;
    label199:
    this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
    LebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hku
 * JD-Core Version:    0.7.0.1
 */