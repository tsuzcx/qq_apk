import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import cooperation.qqdataline.ipc.IDatalineService;
import java.util.ArrayList;

public class lyy
  implements Runnable
{
  public lyy(DatalineRemoteManager paramDatalineRemoteManager) {}
  
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
        this.a.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", localBundle);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + str);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyy
 * JD-Core Version:    0.7.0.1
 */