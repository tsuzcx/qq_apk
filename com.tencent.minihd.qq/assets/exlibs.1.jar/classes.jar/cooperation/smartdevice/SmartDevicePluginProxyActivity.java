package cooperation.smartdevice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class SmartDevicePluginProxyActivity
  extends PluginProxyActivity
{
  private static final String a = "SmartDevicePluginProxyActivity";
  
  public String getPluginID()
  {
    return "qqsmartdevice.apk";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label71;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      if (QLog.isColorLevel()) {
        QLog.d("SmartDevicePluginProxyActivity", 2, localStringBuffer.toString());
      }
      return;
      label71:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */