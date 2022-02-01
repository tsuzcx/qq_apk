import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZonePreDownloadManagerImp;
import com.tencent.qphone.base.util.QLog;

public class hni
  extends BroadcastReceiver
{
  public hni(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      str = QQAppInterface.b + "QZonePreDownload";
      localObject = new StringBuilder().append("intent is: ");
      if (paramIntent == null)
      {
        paramContext = "null";
        QLog.d(str, 4, paramContext);
      }
    }
    else
    {
      if (this.a.getAccount() != null) {
        break label82;
      }
    }
    label82:
    boolean bool;
    label273:
    label337:
    do
    {
      do
      {
        do
        {
          int i;
          int j;
          do
          {
            do
            {
              return;
              paramContext = "not null";
              break;
            } while ((paramIntent == null) || (!"QZonePreDownload".equals(paramIntent.getAction())));
            if (QLog.isDevelopLevel()) {
              QLog.d(QQAppInterface.b + "QZonePreDownload", 4, "receive setting action" + paramIntent.getAction());
            }
            paramIntent = paramIntent.getExtras();
            paramContext = "";
            if (paramIntent != null) {
              paramContext = paramIntent.getString("action");
            }
            if (!"register".equals(paramContext)) {
              break label273;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d(QQAppInterface.b + "QZonePreDownload", 4, "preDownloadBrocastReceiver receive register and then get manager");
            }
            paramContext = (QZonePreDownloadManagerImp)this.a.getManager(71);
            str = this.a.a();
            localObject = paramIntent.getString("periods");
            i = paramIntent.getInt("expiredDay");
            j = paramIntent.getInt("interval");
          } while (paramContext == null);
          paramContext.a(str, (String)localObject, i, j);
          return;
          if (!"unregister".equals(paramContext)) {
            break label337;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d(QQAppInterface.b + "QZonePreDownload", 4, "preDownloadBrocastReceiver receive unregister and then get manager");
          }
          paramContext = (QZonePreDownloadManagerImp)this.a.getManager(71);
        } while (paramContext == null);
        paramContext.a();
        return;
      } while (!"preDownloadComplete".equals(paramContext));
      bool = paramIntent.getBoolean("downloadCompleted");
      if (QLog.isDevelopLevel()) {
        QLog.d(QQAppInterface.b + "QZonePreDownload", 4, "preDownloadBrocastReceiver receive downloadCompleted:" + bool + "and then get manager");
      }
      paramContext = (QZonePreDownloadManagerImp)this.a.getManager(71);
    } while (paramContext == null);
    paramContext.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hni
 * JD-Core Version:    0.7.0.1
 */