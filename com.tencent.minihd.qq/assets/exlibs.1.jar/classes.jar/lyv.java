import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qqdataline.ipc.IDatalineService.Stub;
import mqq.app.MobileQQ;

public class lyv
  implements ServiceConnection
{
  public lyv(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = IDatalineService.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
    }
    paramComponentName = (RegisterProxySvcPackHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
    this.a.a(paramComponentName.a(), paramComponentName.e(), paramComponentName.f(), paramComponentName.g(), paramComponentName.a());
    DatalineRemoteManager.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unbindService(DatalineRemoteManager.a(this.a));
    this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService = null;
    this.a.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyv
 * JD-Core Version:    0.7.0.1
 */