import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;

public class kvx
  extends DownloadListener
{
  public kvx(VipFunCallManager paramVipFunCallManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d(VipFunCallManager.jdField_a_of_type_JavaLangString, 2, "onDone, status=" + paramDownloadTask.a());
    }
    Bundle localBundle = paramDownloadTask.a();
    int i = localBundle.getInt("id");
    if (paramDownloadTask.a() == 3) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool1 = FileUtils.b(VipFunCallManager.a(i, VipFunCallManager.d) + ".tmp", VipFunCallManager.a(i, VipFunCallManager.d));
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d(VipFunCallManager.jdField_a_of_type_JavaLangString, 2, "rename failure.");
            bool2 = bool1;
          }
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().getBoolean("isIPC")))
      {
        paramDownloadTask = new Bundle();
        paramDownloadTask.putString("status", "onDone");
        paramDownloadTask.putInt("id", i);
        paramDownloadTask.putInt("srcType", localBundle.getInt("srcType"));
        paramDownloadTask.putInt("resourceType", VipFunCallManager.d);
        paramDownloadTask.putBoolean("result", bool2);
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(paramDownloadTask);
      }
      return;
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VipFunCallManager.jdField_a_of_type_JavaLangString, 2, "onProgress, loaded=" + paramDownloadTask.b + "percent=" + paramDownloadTask.a);
    }
    if (paramDownloadTask.a().getBoolean("isIPC"))
    {
      Bundle localBundle1 = paramDownloadTask.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("id", localBundle1.getInt("id"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("resourceType", VipFunCallManager.d);
      localBundle2.putInt("progress", (int)paramDownloadTask.a);
      this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(localBundle2);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VipFunCallManager.jdField_a_of_type_JavaLangString, 2, "onStart, loaded=" + paramDownloadTask.b + "percent=" + paramDownloadTask.a);
    }
    if (paramDownloadTask.a().getBoolean("isIPC"))
    {
      paramDownloadTask = paramDownloadTask.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", paramDownloadTask.getInt("id"));
      localBundle.putInt("srcType", paramDownloadTask.getInt("srcType"));
      localBundle.putInt("resourceType", VipFunCallManager.d);
      if (this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(localBundle);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvx
 * JD-Core Version:    0.7.0.1
 */