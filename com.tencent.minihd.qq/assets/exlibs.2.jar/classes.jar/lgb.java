import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class lgb
  implements Runnable
{
  public lgb(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h) != null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.k = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h).mSavePath;
        UpdateManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lgb
 * JD-Core Version:    0.7.0.1
 */