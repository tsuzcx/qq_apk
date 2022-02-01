package cooperation.smartdevice.ipc;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mec;
import med;
import mee;
import mef;

public class SmartDeviceIPCHost
  implements Observer
{
  public static final String a = "SmartDeviceIPCHost";
  private ServiceConnection a;
  public QQAppInterface a;
  public ISmartDeviceService a;
  public ArrayList a;
  public boolean a;
  
  public SmartDeviceIPCHost(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentServiceConnection = new mec(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost() construct!!!!!");
    }
    c();
    d();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService start service");
      }
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  public Bundle a(Bundle paramBundle)
  {
    String str = paramBundle.getString("notify_cmd");
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService not started strNotifyCmd:" + str);
      }
      d();
    }
    do
    {
      return null;
      b();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "qq->plugin sendRemoteNotify strNotifyCmd:" + str);
        }
        paramBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", paramBundle);
        if (paramBundle != null) {
          paramBundle.setClassLoader(getClass().getClassLoader());
        }
        return paramBundle;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + str);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "params is null");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = paramBundle.getString("notify_cmd");
      if (this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService not started strNotifyCmd:" + (String)localObject + " cached");
        }
        d();
        localObject = Looper.getMainLooper();
        if (Thread.currentThread() != ((Looper)localObject).getThread())
        {
          new Handler((Looper)localObject).post(new med(this, paramBundle));
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
        b();
        return;
      }
      b();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "qq->plugin postRemoteNotify strNotifyCmd:" + (String)localObject);
        }
        this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + (String)localObject);
  }
  
  public Bundle b(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("invoke_cmd");
    if (QLog.isColorLevel()) {
      QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnRemoteInvoke strNotifyCmd:" + (String)localObject);
    }
    if (((String)localObject).compareToIgnoreCase("invokeCmdSendCS") == 0)
    {
      ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramBundle);
      paramBundle = null;
    }
    String str;
    do
    {
      return paramBundle;
      if (((String)localObject).compareToIgnoreCase("invokeCmdOpenChatMsgActivity") == 0)
      {
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramBundle);
        break;
      }
      if (((String)localObject).equals("SmartDeviceHandler_makeSureProxyServiceStart"))
      {
        d();
        break;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoChat") == 0) {
        break;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoMessage") == 0)
      {
        DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramBundle.getString("din"), paramBundle.getString("videoPath"));
        break;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetBuddyName") != 0) {
        break;
      }
      paramBundle = paramBundle.getString("Uin");
      str = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("BuddyName", str);
      paramBundle = (Bundle)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnRemoteInvoke buddyname is:" + str);
    return localObject;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService == null)) {}
    for (;;)
    {
      return;
      Object localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new mee(this));
        return;
      }
      while (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        localObject = localBundle.getString("notify_cmd");
        if (localBundle != null) {}
        try
        {
          localBundle.setClassLoader(getClass().getClassLoader());
          if (QLog.isColorLevel()) {
            QLog.d("SmartDeviceIPCHost", 2, "qq->plugin main thread doPostCachedMsg strNotifyCmd:" + (String)localObject + " thread:" + Thread.currentThread());
          }
          this.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", localBundle);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + (String)localObject);
        }
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "in SmartDeviceIPCHost::registerRemoteCommand");
    }
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::registerRemoteCommand register CMD:com.qqsmartdevice.remotecall");
    }
    localPluginCommunicationHandler.register(new mef(this, "com.qqsmartdevice.remotecall"));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (paramObservable.istroop == 9501)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObservable.frienduin, 9501);
        paramObject = new Bundle();
        paramObject.putString("notify_cmd", "updateUnreadMsgsNum");
        paramObject.putString("din", paramObservable.frienduin);
        paramObject.putInt("unread", i);
        a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost
 * JD-Core Version:    0.7.0.1
 */