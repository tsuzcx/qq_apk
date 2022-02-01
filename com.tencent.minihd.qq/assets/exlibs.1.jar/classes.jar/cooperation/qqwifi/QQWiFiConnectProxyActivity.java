package cooperation.qqwifi;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QQWiFiConnectProxyActivity
  extends PluginProxyActivity
{
  protected Class getProxyActivity(String paramString)
  {
    if ("com.tencent.wifisdk.activity.QQWIFIMapActivity".equals(paramString)) {
      return QQWIFIMapProxyActivity.class;
    }
    return QQWiFiProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWiFiConnectProxyActivity
 * JD-Core Version:    0.7.0.1
 */