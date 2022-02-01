import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.coverstore.QZonePersonalizePlugin;

public class mbp
  extends BroadcastReceiver
{
  public mbp(QZonePersonalizePlugin paramQZonePersonalizePlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = QZonePersonalizePlugin.a;
      StringBuilder localStringBuilder = new StringBuilder().append("intent is: ");
      if (paramIntent == null)
      {
        paramContext = "null";
        QLog.d((String)localObject, 4, paramContext);
      }
    }
    else
    {
      if ((paramIntent == null) || (!"QZoneCardPreDownload".equals(paramIntent.getAction()))) {
        break label252;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneCardLogic." + QZonePersonalizePlugin.a, 4, "QZoneCardPreDownload js receive setting action" + paramIntent.getAction());
      }
      localObject = paramIntent.getExtras();
      paramIntent = "";
      paramContext = "";
      if (localObject != null)
      {
        paramIntent = ((Bundle)localObject).getString("result");
        paramContext = ((Bundle)localObject).getString("cardurl");
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneCardLogic." + QZonePersonalizePlugin.a, 4, "QZoneCardPreDownload js receive cardurl:" + paramContext + "\n dowonload result:" + paramIntent);
      }
      this.a.mRuntime.a().c("window.QzFeedDressJSInterface.onReceive({type:\"cardurl\",data:\"" + paramContext + "\"});window.QzFeedDressJSInterface.onReceive({type:\"result\",data:\"success\"});");
    }
    label252:
    int i;
    do
    {
      do
      {
        do
        {
          return;
          paramContext = "not null";
          break;
        } while ((paramIntent == null) || (!"action_facade_qzone2js".equals(paramIntent.getAction())));
        paramIntent = paramIntent.getExtras();
      } while (paramIntent == null);
      i = paramIntent.getInt("ret");
      paramContext = paramIntent.getString("imgDir");
      paramIntent = paramIntent.getString("imgNameList");
      if (QLog.isDevelopLevel()) {
        QLog.d(QZonePersonalizePlugin.a, 4, "receive ret:" + i + "|imgDir:" + paramContext + "|imgNameList:" + paramIntent);
      }
    } while (i != 0);
    this.a.mRuntime.a().c("window.QzAvatarDressJSInterface.onReceive({type:\"result\",data:\"success\",imgDir:\"" + paramContext + "\",imgNameList:\"" + paramIntent + "\"});");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbp
 * JD-Core Version:    0.7.0.1
 */