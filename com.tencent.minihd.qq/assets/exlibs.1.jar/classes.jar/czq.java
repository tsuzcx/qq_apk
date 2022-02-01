import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.smartdevice.SmartDevicePluginLoader;

public class czq
  implements Handler.Callback
{
  public czq(SmartDeviceProxyMgr paramSmartDeviceProxyMgr) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (QQAppInterface)BaseApplicationImpl.a().a();
      boolean bool1 = SmartDevicePluginLoader.a().a(paramMessage);
      boolean bool2 = NetworkUtil.g(BaseApplicationImpl.getContext());
      SmartDeviceProxyMgr.a(this.a, "SmartDeviceProxyMgr::install plugin: isInstalled " + bool1 + " isWifiConnected " + bool2);
      if ((!bool1) && (bool2)) {
        SmartDevicePluginLoader.a().a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     czq
 * JD-Core Version:    0.7.0.1
 */