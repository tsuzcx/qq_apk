import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.ISmartDeviceService;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.util.ArrayList;

public class mee
  implements Runnable
{
  public mee(SmartDeviceIPCHost paramSmartDeviceIPCHost) {}
  
  public void run()
  {
    while (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      Bundle localBundle = (Bundle)this.a.jdField_a_of_type_JavaUtilArrayList.remove(0);
      String str = localBundle.getString("notify_cmd");
      if (localBundle != null) {}
      try
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "qq->plugin post to main thread doPostCachedMsg strNotifyCmd:" + str + " thread:" + Thread.currentThread());
        }
        this.a.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", localBundle);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mee
 * JD-Core Version:    0.7.0.1
 */