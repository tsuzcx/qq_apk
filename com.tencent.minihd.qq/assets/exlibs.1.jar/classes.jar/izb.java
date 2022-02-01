import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;
import com.tencent.qphone.base.util.QLog;

class izb
  extends FMObserver
{
  izb(iza paramiza) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          paramString1 = BaseApplicationImpl.getContext().getString(2131362407);
          if (QLog.isColorLevel()) {
            QLog.i("PreviewStep_1", 2, "FAILED OnFileOfflinePreview harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + paramString1 + "]");
          }
          this.a.a.b(11203, paramString1, paramString1);
          return;
        }
        if (paramBoolean)
        {
          if (!FMConfig.a) {
            break label202;
          }
          paramString1 = "183.61.37.13";
          paramInt1 = 443;
          if (QLog.isDevelopLevel()) {
            QLog.i("PreviewStep_1", 4, "SUCCESS OnFileDiscOfflinePreview harcode[" + FMConfig.a + "]");
          }
          iza.a(this.a, paramString1, paramString4, paramInt1, paramString2, null);
          this.a.a.e();
          continue;
        }
        PreviewingOfflineFileView.b(this.a.a).runOnUiThread(new izd(this, paramInt1, paramString1));
      }
      finally {}
      continue;
      label202:
      paramInt1 = paramInt2;
      paramString1 = paramString3;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if ((paramBoolean) && (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = BaseApplicationImpl.getContext().getString(2131362407);
      if (QLog.isColorLevel()) {
        QLog.i("PreviewStep_1", 2, "FAILED OnFileOfflinePreview harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + paramString1 + "]");
      }
      this.a.a.b(11203, paramString1, paramString1);
      return;
    }
    if (paramBoolean)
    {
      if (!FMConfig.a) {
        break label190;
      }
      paramString1 = "183.61.37.13";
      paramInt1 = 443;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PreviewStep_1", 4, "SUCCESS OnFileWeiYunPreview harcode[" + FMConfig.a + "]");
      }
      iza.a(this.a, paramString1, paramString5, paramInt1, paramString2, paramString3);
      this.a.a.e();
      return;
      PreviewingOfflineFileView.d(this.a.a).runOnUiThread(new ize(this, paramInt1, paramString1));
      return;
      label190:
      paramInt1 = paramInt2;
      paramString1 = paramString4;
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          paramString1 = BaseApplicationImpl.getContext().getString(2131362407);
          if (QLog.isColorLevel()) {
            QLog.i("PreviewStep_1", 2, "FAILED OnFileOfflinePreview harcode[" + FMConfig.a + "],server return true,but downloadKey is null, rcmsg[" + paramString1 + "]");
          }
          this.a.a.b(11203, paramString1, paramString1);
          return;
        }
        if (paramBoolean)
        {
          if (!FMConfig.a) {
            break label202;
          }
          paramString1 = "183.61.37.13";
          paramInt1 = 443;
          if (QLog.isDevelopLevel()) {
            QLog.i("PreviewStep_1", 4, "SUCCESS OnFileOfflinePreview harcode[" + FMConfig.a + "]");
          }
          iza.a(this.a, paramString1, paramString4, paramInt1, paramString2, null);
          this.a.a.e();
          continue;
        }
        PreviewingOfflineFileView.a(this.a.a).runOnUiThread(new izc(this, paramInt1, paramString1));
      }
      finally {}
      continue;
      label202:
      paramInt1 = paramInt2;
      paramString1 = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izb
 * JD-Core Version:    0.7.0.1
 */