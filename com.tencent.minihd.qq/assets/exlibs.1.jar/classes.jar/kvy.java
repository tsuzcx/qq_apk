import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;

public class kvy
  extends DownloadListener
{
  public kvy(VipFunCallManager paramVipFunCallManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d(VipFunCallManager.jdField_a_of_type_JavaLangString, 2, "onDone, status=" + paramDownloadTask.a());
    }
    Bundle localBundle1 = paramDownloadTask.a();
    int j = localBundle1.getInt("id");
    int k = localBundle1.getInt("resourceType");
    boolean bool1;
    if (paramDownloadTask.a() == 3)
    {
      bool1 = true;
      if (!bool1) {
        break label384;
      }
      bool1 = FileUtils.b(VipFunCallManager.a(j, k) + ".tmp", VipFunCallManager.a(j, k));
      if ((!bool1) && (QLog.isColorLevel())) {
        QLog.d(VipFunCallManager.jdField_a_of_type_JavaLangString, 2, "rename failure.");
      }
    }
    label384:
    for (;;)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().getBoolean("isIPC")))
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("status", "onDone");
        localBundle2.putInt("id", j);
        localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
        localBundle2.putBoolean("result", bool1);
        localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(localBundle2);
      }
      boolean bool2 = paramDownloadTask.a().getBoolean("isIPC");
      if (bool2) {}
      for (int i = localBundle1.getInt("srcType");; i = 0)
      {
        this.a.a(j, bool2, i);
        if (k == 3)
        {
          i = ((SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).f();
          if (i != 2) {
            break label361;
          }
          i = 0;
        }
        label298:
        label361:
        label376:
        for (;;)
        {
          paramDownloadTask = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (bool1) {}
          for (j = 0;; j = 1)
          {
            ReportController.b(paramDownloadTask, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, "", "", "");
            return;
            bool1 = false;
            break;
            if (i != 3) {
              break label376;
            }
            i = 2;
            break label298;
          }
        }
      }
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
      localBundle2.putInt("progress", (int)paramDownloadTask.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
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
      localBundle.putInt("resourceType", paramDownloadTask.getInt("resourceType"));
      if (this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(localBundle);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvy
 * JD-Core Version:    0.7.0.1
 */