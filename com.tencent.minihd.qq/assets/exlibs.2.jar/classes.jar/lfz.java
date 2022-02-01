import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class lfz
  implements Runnable
{
  public lfz(DownloadManager paramDownloadManager, String paramString, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2) {}
  
  public void run()
  {
    int j = 3;
    int i = j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      if (this.jdField_a_of_type_Int == 0) {
        i = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/vnd.android.package-archive");
      }
      for (;;)
      {
        LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "startDownloadTask downloadSDKClient result=" + i + " url=" + this.jdField_a_of_type_JavaLangString);
        if (i == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, i, "");
        return;
        if (this.jdField_a_of_type_Int == 1)
        {
          i = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "application/tm.android.apkdiff");
        }
        else
        {
          LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "startDownload download unapk file, url = " + this.jdField_a_of_type_JavaLangString + ",filename = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d);
          i = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().startDownloadTask(this.jdField_a_of_type_JavaLangString, "resource/tm.android.unknown", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e);
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
          i = j;
        }
      } while ((this.b != this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo) || (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.j != 20));
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(20, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lfz
 * JD-Core Version:    0.7.0.1
 */