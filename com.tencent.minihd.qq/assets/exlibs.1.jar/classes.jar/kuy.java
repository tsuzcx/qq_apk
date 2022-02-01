import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class kuy
  extends DownloadListener
{
  public kuy(ColorRingManager paramColorRingManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + paramDownloadTask.a());
    }
    Bundle localBundle = paramDownloadTask.a();
    long l = localBundle.getLong("id");
    int i = localBundle.getInt("resourceType");
    boolean bool;
    if (paramDownloadTask.a() == 3)
    {
      bool = true;
      if (!bool) {
        break label433;
      }
      bool = FileUtils.b(ColorRingManager.b(l, i) + ".tmp", ColorRingManager.b(l, i));
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.d("ColorRingManager", 2, "rename failure.");
      }
    }
    label264:
    label295:
    label425:
    label430:
    label433:
    for (;;)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().getBoolean("isIPC")))
      {
        paramDownloadTask = new Bundle();
        paramDownloadTask.putString("status", "onDone");
        paramDownloadTask.putLong("id", l);
        paramDownloadTask.putInt("srcType", localBundle.getInt("srcType"));
        paramDownloadTask.putBoolean("result", bool);
        paramDownloadTask.putInt("resourceType", localBundle.getInt("resourceType"));
        paramDownloadTask.putString("colorType", localBundle.getString("colorType"));
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(paramDownloadTask);
      }
      if (i == 3)
      {
        paramDownloadTask = (SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
        i = paramDownloadTask.f();
        if (i != 2) {
          break label410;
        }
        i = 0;
      }
      for (;;)
      {
        int j;
        if ("colorring".equals(localBundle.getString("colorType")))
        {
          QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (bool)
          {
            j = 0;
            ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, "", "", "");
          }
        }
        else if ("comering".equals(localBundle.getString("colorType")))
        {
          if (!bool) {
            break label425;
          }
        }
        for (i = 0;; i = 1)
        {
          ReportController.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + paramDownloadTask.f(), "", "", "");
          return;
          bool = false;
          break;
          if (i != 3) {
            break label430;
          }
          i = 2;
          break label264;
          j = 1;
          break label295;
        }
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + paramDownloadTask.b + "percent=" + paramDownloadTask.a);
    }
    if (paramDownloadTask.a().getBoolean("isIPC"))
    {
      Bundle localBundle1 = paramDownloadTask.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putLong("id", localBundle1.getLong("id"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)paramDownloadTask.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(localBundle2);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + paramDownloadTask.b + "percent=" + paramDownloadTask.a);
    }
    if (paramDownloadTask.a().getBoolean("isIPC"))
    {
      paramDownloadTask = paramDownloadTask.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putLong("id", paramDownloadTask.getLong("id"));
      localBundle.putInt("srcType", paramDownloadTask.getInt("srcType"));
      localBundle.putInt("resourceType", paramDownloadTask.getInt("resourceType"));
      localBundle.putString("colorType", paramDownloadTask.getString("colorType"));
      if (this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onResponse(localBundle);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kuy
 * JD-Core Version:    0.7.0.1
 */