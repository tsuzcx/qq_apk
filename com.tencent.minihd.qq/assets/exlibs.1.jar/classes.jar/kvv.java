import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vipav.VipFunCallConstants;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;

public class kvv
  extends DownloadListener
{
  public kvv(VipFunCallManager paramVipFunCallManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d(VipFunCallManager.a, 2, "onDone, status=" + paramDownloadTask.a());
    }
    Object localObject = paramDownloadTask.a();
    int j = ((Bundle)localObject).getInt("id");
    localObject = ((Bundle)localObject).getString("version");
    int i;
    if (paramDownloadTask.a() == 3)
    {
      i = 1;
      if (i == 0) {
        break label224;
      }
      if (FileUtils.b(VipFunCallConstants.b + ".tmp", VipFunCallConstants.b)) {
        break label151;
      }
      if (QLog.isColorLevel()) {
        QLog.d(VipFunCallManager.a, 2, "rename failure.");
      }
    }
    for (;;)
    {
      i = VipFunCallManager.a();
      if (!VipFunCallManager.a(j, i)) {
        this.a.a(j, i, false, 0);
      }
      return;
      i = 0;
      break;
      label151:
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        BaseApplicationImpl.a().getSharedPreferences("fun_call_sp_file", 4).edit().putString("profileFuncallVersion", (String)localObject).commit();
        if (QLog.isColorLevel())
        {
          QLog.d(VipFunCallManager.a, 2, "config version " + (String)localObject);
          continue;
          label224:
          if (QLog.isColorLevel()) {
            QLog.d(VipFunCallManager.a, 2, "download config fail " + (String)localObject);
          }
        }
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvv
 * JD-Core Version:    0.7.0.1
 */