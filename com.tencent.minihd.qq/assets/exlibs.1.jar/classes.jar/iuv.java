import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.SucDownloadInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadNfn;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.qphone.base.util.QLog;

public class iuv
  extends Handler
  implements UniformDownloader.IUniformDownloaderListener
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  Notification jdField_a_of_type_AndroidAppNotification;
  final Bundle jdField_a_of_type_AndroidOsBundle;
  int b = 0;
  int c = 0;
  
  public iuv(UniformDownloadNfn paramUniformDownloadNfn, Looper paramLooper, int paramInt, Bundle paramBundle, long paramLong)
  {
    super(paramLooper);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = ((Bundle)paramBundle.clone());
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidOsBundle.putInt("_notify_param_Id", this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      this.jdField_a_of_type_AndroidAppNotification = paramUniformDownloadNfn.a(paramBundle);
      return;
    }
    QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + paramLong + "]. notify runable, param is null");
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadStart, NF");
    paramBundle = Message.obtain();
    paramBundle.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    localBundle.putInt("_START_WAITING_", 0);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadStart, sendMessage failed, NF");
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadFailed, NF");
    paramBundle = Message.obtain();
    paramBundle.what = 5;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_ERR_CODE_", paramInt);
    localBundle.putString("_FILE_ERR_STRING_", paramString);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadFailed, sendMessage failed, NF");
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    int i = UniformDownloadNfn.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn);
    paramBundle = UniformDownloadUtil.b(paramString);
    if (paramBundle != null) {
      UniformDownloadMgr.a().a(new UniformDownloadMgr.SucDownloadInfo(paramBundle, i));
    }
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadSucess, NF");
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putString("_FILE_PATH_", paramString);
    localBundle.putLong("_FILE_SIZE_", paramLong);
    localBundle.putInt("_NEW_N_ID_", i);
    if (paramBundle != null) {
      localBundle.putString("_PKG_NAME_", paramBundle);
    }
    localMessage.setData(localBundle);
    if (!sendMessage(localMessage)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadSucess, sendMessage failed, NF");
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadResume progress=" + paramInt + ", NF ");
    paramBundle = Message.obtain();
    paramBundle.what = 7;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadResume, sendMessage failed, NF");
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    paramBundle = Message.obtain();
    paramBundle.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadProgress, sendMessage failed, NF");
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadPause, NF");
    paramBundle = Message.obtain();
    paramBundle.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadPause, sendMessage failed, NF");
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    super.handleMessage(paramMessage);
    Object localObject = paramMessage.getData();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      this.b = paramMessage.what;
      return;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_START, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      int i = ((Bundle)localObject).getInt("_START_WAITING_");
      localObject = UniformDownloadMgr.a();
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Filename");
      long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_notify_param_Filesize");
      int j = this.jdField_a_of_type_Int;
      if (i == 1) {
        bool = true;
      }
      ((UniformDownloadMgr)localObject).a(str1, str2, l, j, bool);
      this.c = 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      if (2 != this.c) {
        UniformDownloadMgr.a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"), this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Filename"), this.jdField_a_of_type_AndroidOsBundle.getLong("_notify_param_Filesize"), this.jdField_a_of_type_Int, false);
      }
      this.c = 2;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_PAUSE, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn.c(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().b(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.c = 3;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_SUC, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().b(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.c = 4;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn.d(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().b(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.c = 5;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_RESUME, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn.e(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"), this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Filename"), this.jdField_a_of_type_AndroidOsBundle.getLong("_notify_param_Filesize"), this.jdField_a_of_type_Int, true);
      this.c = 7;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_CLR, NF. NId = " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadNfn.a(this.jdField_a_of_type_Int);
      UniformDownloadMgr.a().b(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iuv
 * JD-Core Version:    0.7.0.1
 */