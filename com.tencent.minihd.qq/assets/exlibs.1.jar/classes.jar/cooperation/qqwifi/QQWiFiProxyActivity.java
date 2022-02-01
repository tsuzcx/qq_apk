package cooperation.qqwifi;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QQWiFiProxyActivity
  extends PluginProxyActivity
{
  protected Class getProxyActivity(String paramString)
  {
    if ("com.tencent.wifisdk.activity.QQWIFIMapActivity".equals(paramString)) {
      return QQWIFIMapProxyActivity.class;
    }
    return super.getProxyActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWiFiProxyActivity
 * JD-Core Version:    0.7.0.1
 */