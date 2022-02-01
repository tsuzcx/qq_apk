import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.ISmartDeviceService.Stub;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import mqq.app.MobileQQ;

public class mec
  implements ServiceConnection
{
  public mec(SmartDeviceIPCHost paramSmartDeviceIPCHost) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService = ISmartDeviceService.Stub.a(paramIBinder);
    this.a.b();
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService connected");
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(SmartDeviceIPCHost.a(this.a));
    this.a.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService = null;
    this.a.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService disconnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mec
 * JD-Core Version:    0.7.0.1
 */