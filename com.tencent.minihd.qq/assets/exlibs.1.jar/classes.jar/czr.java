import android.content.Context;
import android.content.Intent;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class czr
  implements Runnable
{
  public czr(SmartDeviceProxyMgr paramSmartDeviceProxyMgr, String paramString1, String paramString2, Boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a.getApplication().getApplicationContext(), ChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(131072);
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.b);
    localIntent.putExtra("bFromLightApp", this.jdField_a_of_type_JavaLangBoolean);
    localIntent.putExtra("uintype", 9501);
    localIntent.putExtra("operType", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a.getApplication().getApplicationContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     czr
 * JD-Core Version:    0.7.0.1
 */