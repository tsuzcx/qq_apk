import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZonePreDownloadManagerImp;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.MobileQQ;

public class jvn
  extends ContentObserver
{
  public jvn(QZonePreDownloadManagerImp paramQZonePreDownloadManagerImp, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    String str1 = QZConfigProviderUtil.c();
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "qzone photodownload configUpdateObserver error" + str1 + "selfChange:" + paramBoolean);
    }
    String str2 = QZonePreDownloadManagerImp.a(this.a).getApplication().getProcessName();
    if (!TextUtils.isEmpty(str1))
    {
      if (!str1.equals(str2)) {
        QzoneConfig.a().b();
      }
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jvn
 * JD-Core Version:    0.7.0.1
 */