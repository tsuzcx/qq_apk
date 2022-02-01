import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class czs
  extends BroadcastReceiver
{
  public czs(SmartDeviceProxyMgr paramSmartDeviceProxyMgr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("SmartDevice_devListChang")) || (paramIntent.getAction().equalsIgnoreCase("onDeviceDisconnected")) || (paramIntent.getAction().equalsIgnoreCase("onDeviceLogined")))
    {
      this.a.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
      paramContext = this.a.a();
      if (QLog.isColorLevel()) {
        QLog.i("SmartDeviceProxyMgr", 2, "DeviceList @@ cache receivechange list:" + paramContext);
      }
      if (paramContext != null) {
        ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).b(13, true, new ArrayList(Arrays.asList(paramContext)));
      }
      new LightAppUtil().a();
      this.a.i = 2;
    }
    do
    {
      do
      {
        return;
        if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_login"))
        {
          if (paramIntent.getExtras().getInt("logincode") == 0)
          {
            this.a.e = 2;
            return;
          }
          this.a.e = 3;
          return;
        }
        if (!paramIntent.getAction().equalsIgnoreCase("mqq.intent.action.LOGOUT")) {
          break;
        }
      } while (!this.a.a());
      SmartDeviceProxyMgr.a(this.a, "SmartDeviceProxyMgr::receive qq logout broadcast!!!");
      this.a.b();
      return;
    } while ((!paramIntent.getAction().equalsIgnoreCase("SmartDevice_clickOnDeviceList")) || (!this.a.a()));
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     czs
 * JD-Core Version:    0.7.0.1
 */