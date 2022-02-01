import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class hpq
  extends DownloadListener
{
  public hpq(SignatureManager paramSignatureManager) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onCancel| task:" + paramDownloadTask);
    }
  }
  
  @TargetApi(9)
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onDone| task:" + paramDownloadTask);
    }
    Object localObject = paramDownloadTask.a();
    if (localObject != null) {}
    for (int i = ((Bundle)localObject).getInt("resType");; i = 0)
    {
      switch (i)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
          } while ((3 != paramDownloadTask.a()) && (paramDownloadTask.a() != 0));
          SignatureManager.a(this.a).sendEmptyMessage(1);
        } while (this.a.a == null);
        paramDownloadTask = this.a.a.a().getSharedPreferences("sigResUpt", 0);
        i = paramDownloadTask.getInt("sigTplCfgVerTemp", 0);
        paramDownloadTask = paramDownloadTask.edit();
        paramDownloadTask.putInt("sigTplCfgVer", i);
        if (Build.VERSION.SDK_INT <= 8)
        {
          paramDownloadTask.commit();
          return;
        }
        paramDownloadTask.apply();
        return;
      } while ((3 != paramDownloadTask.a()) && (paramDownloadTask.a() != 0));
      i = ((Bundle)localObject).getInt("dynamicType");
      String str = ((Bundle)localObject).getString("tplId");
      localObject = ((Bundle)localObject).getString("fileName");
      paramDownloadTask = null;
      switch (i)
      {
      }
      for (;;)
      {
        paramDownloadTask = new File(paramDownloadTask);
        if (!DownloaderFactory.a(new File(SignatureTemplateConfig.a(str, (String)localObject)), paramDownloadTask)) {
          break;
        }
        SignatureManager.b(this.a).sendEmptyMessage(3);
        return;
        paramDownloadTask = SignatureTemplateConfig.a(str, "dynamic_aio");
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onStart| task:" + paramDownloadTask);
    }
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hpq
 * JD-Core Version:    0.7.0.1
 */