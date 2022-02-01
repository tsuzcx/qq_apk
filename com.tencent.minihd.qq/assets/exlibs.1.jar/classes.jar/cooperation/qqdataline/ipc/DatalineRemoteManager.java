package cooperation.qqdataline.ipc;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.DatalinePluginProxyActivity;
import cooperation.qqdataline.ServerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import lyv;
import lyw;
import lyx;
import lyy;
import lyz;
import lza;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;

public class DatalineRemoteManager
  implements Observer
{
  private static final String jdField_a_of_type_JavaLangString = "DatalineRemoteManager";
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new lyv(this);
  public QQAppInterface a;
  public IDatalineService a;
  public ArrayList a;
  public boolean a;
  
  public DatalineRemoteManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    d();
  }
  
  private Bundle a(Bundle paramBundle)
  {
    String str = paramBundle.getString("notify_cmd");
    if (this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "mDatalineService not started strNotifyCmd:" + str);
      }
      b();
    }
    do
    {
      return null;
      c();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        paramBundle = this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", paramBundle);
        if (paramBundle != null) {
          paramBundle.setClassLoader(getClass().getClassLoader());
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "sendRemoteNotify send success strNotifyCmd:" + str);
        }
        return paramBundle;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "sendRemoteNotify send failed strNotifyCmd:" + str);
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("notify_cmd");
    Bundle localBundle;
    if (paramBundle.equals("onReceiveRegisterProxySvcPack"))
    {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!paramBundle.hasNext()) {
          break;
        }
        localBundle = (Bundle)paramBundle.next();
      } while (!localBundle.getString("notify_cmd").equals("onReceiveRegisterProxySvcPack"));
    }
    do
    {
      do
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localBundle);
        return;
        while (!paramBundle.equals("UpdateUnreadMsgsNum")) {}
        paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      } while (!paramBundle.hasNext());
      localBundle = (Bundle)paramBundle.next();
    } while (!localBundle.getString("notify_cmd").equals("UpdateUnreadMsgsNum"));
    this.jdField_a_of_type_JavaUtilArrayList.remove(localBundle);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = paramBundle.getString("notify_cmd");
    if (this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService == null) {
      if (((String)localObject).equals("onReceive")) {
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + (String)localObject + " no need cached");
        }
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramBoolean) {
          b();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + (String)localObject + " cached");
        }
        localObject = Looper.getMainLooper();
        if (Thread.currentThread() != ((Looper)localObject).getThread())
        {
          new Handler((Looper)localObject).post(new lyx(this, paramBundle));
          return;
        }
        a(paramBundle);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
        return;
        c();
        if (paramBundle != null) {}
        try
        {
          paramBundle.setClassLoader(getClass().getClassLoader());
          this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", paramBundle);
          if (QLog.isColorLevel())
          {
            QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send success strNotifyCmd:" + (String)localObject);
            return;
          }
        }
        catch (RemoteException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send failed strNotifyCmd:" + (String)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      new Handler((Looper)localObject).post(new lza(this, paramBoolean));
    }
    while (BaseActivity.sTopActivity == null) {
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("isFromStatusbar", paramBoolean);
    DatalinePluginProxyActivity.a(BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.qqdataline.activity.LiteWifiphotoActivity", -1, null);
    BaseActivity.sTopActivity.overridePendingTransition(2130968595, 0);
  }
  
  private Bundle b(Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getString("invoke_cmd");
    long l1;
    int i;
    int j;
    if (((String)localObject2).equals("DatalineHandler_sendC2CMessage_ToService"))
    {
      l1 = paramBundle.getLong("uCookie");
      localObject1 = paramBundle.getString("toUin");
      i = paramBundle.getInt("c2cCmd");
      j = paramBundle.getInt("subCmd");
      int k = paramBundle.getInt("datalineCmd");
      localObject2 = paramBundle.getByteArray("bodyContent");
      long l2 = paramBundle.getLong("nSessionId");
      paramBundle = new Bundle();
      paramBundle.putParcelable("ToServiceMsg", ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(l1, (String)localObject1, i, j, k, (byte[])localObject2, l2));
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramBundle;
            if (((String)localObject2).equals("BusinessHandler_sendPbReq"))
            {
              ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).b((ToServiceMsg)paramBundle.getParcelable("ToServiceMsg"));
              return null;
            }
            if (!((String)localObject2).equals("DataLineMsgProxy_getInitMpfileTaskRecordList")) {
              break;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            paramBundle = (Bundle)localObject1;
          } while (localObject2 == null);
          localObject2 = ((MpfileTaskProxy)localObject2).a();
          paramBundle = (Bundle)localObject1;
        } while (((List)localObject2).size() <= 0);
        paramBundle = new MessageRecordParcel[((List)localObject2).size()];
        i = 0;
        while (i < paramBundle.length)
        {
          paramBundle[i] = new MessageRecordParcel((MessageRecord)((List)localObject2).get(i));
          i += 1;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putParcelableArray("result", paramBundle);
        return localObject1;
        if (((String)localObject2).equals("DataLineMPfile_browserMpfileInfo"))
        {
          a((MpfileTaskInfo)paramBundle.getParcelable("taskInfo"), paramBundle.getLong("din"));
          return null;
        }
        if (!((String)localObject2).equals("DataLineWifiphoto_showWifiphotoBar")) {
          break;
        }
        i = paramBundle.getInt("what");
        j = paramBundle.getInt("status");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        paramBundle = (Bundle)localObject1;
      } while (localObject2 == null);
      paramBundle = ((Handler)localObject2).obtainMessage(i);
      paramBundle.arg1 = j;
      ((Handler)localObject2).sendMessage(paramBundle);
      return null;
      if (((String)localObject2).equals("DataLineMsgProxy_add_DataLineMsgRecord"))
      {
        a((DataLineMsgRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).a(), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_add_MpfileTaskRecord"))
      {
        a((MpfileTaskRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).a(), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_update"))
      {
        a(paramBundle.getString("tableName"), (ContentValues)paramBundle.getParcelable("value"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_delete"))
      {
        a(paramBundle.getString("tableName"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
        return null;
      }
      boolean bool;
      if (((String)localObject2).equals("RouterHandler_datalineSendCCMsg"))
      {
        bool = RouterHandler.a(paramBundle.getLong("din"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", bool);
        return paramBundle;
      }
      if (((String)localObject2).equals("RouterHandler_datalineSendCSMsg"))
      {
        bool = RouterHandler.a(paramBundle.getInt("nUserCmd"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", bool);
        return paramBundle;
      }
      if (((String)localObject2).equals("RouterHandler_getSelfDeviceUin"))
      {
        l1 = RouterHandler.a();
        paramBundle = new Bundle();
        paramBundle.putLong("result", l1);
        return paramBundle;
      }
      if (((String)localObject2).equals("DatalineHandler_saveFileManagerEntity"))
      {
        localObject1 = paramBundle.getString("strFilePath");
        i = paramBundle.getInt("nOpType");
        l1 = paramBundle.getLong("sCurDIN");
        paramBundle = FileManagerUtil.a((String)localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1L, (String)localObject2, 6000);
        localFileManagerEntity.nOpType = i;
        localFileManagerEntity.fileSize = FileManagerUtil.a((String)localObject1);
        localFileManagerEntity.isReaded = true;
        localFileManagerEntity.peerUin = ((String)localObject2);
        if (l1 == 0L) {}
        for (localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131368530);; localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131368533))
        {
          localFileManagerEntity.strFilePath = ((String)localObject1);
          localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
          localFileManagerEntity.fileName = paramBundle;
          localFileManagerEntity.cloudType = 3;
          localFileManagerEntity.bSend = false;
          localFileManagerEntity.status = 1;
          localFileManagerEntity.fProgress = 1.0F;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
          return null;
        }
      }
      if (((String)localObject2).equals("DatalineHandler_showWifiphotoActivity"))
      {
        a(paramBundle.getBoolean("isFromStatusbar"));
        return null;
      }
      if (((String)localObject2).equals("BusinessHandler_makeSureProxyServiceStart"))
      {
        b();
        return null;
      }
      paramBundle = (Bundle)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
    return null;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "mDatalineService start service");
      }
      DatalineProxyService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    for (;;)
    {
      return;
      Object localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new lyy(this));
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
          this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", localBundle);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + (String)localObject);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + (String)localObject);
        }
      }
    }
  }
  
  private void d()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "registerRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.register(new lyz(this, "dataline.remotecall"));
  }
  
  private void e()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (!localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.unregister("dataline.remotecall");
  }
  
  public long a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "addMpFileDownloadTask");
    localBundle.putLong("taskId", paramLong1);
    localBundle.putLong("din", paramLong2);
    localBundle.putString("fileId", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("totalSize", paramLong3);
    paramString1 = a(localBundle);
    if (paramString1 == null) {
      return -1L;
    }
    return paramString1.getLong("result");
  }
  
  public MpfileTaskInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileDownloadTask");
    localBundle.putString("fileId", paramString);
    paramString = a(localBundle);
    if (paramString == null) {
      return null;
    }
    return (MpfileTaskInfo)paramString.getParcelable("result");
  }
  
  public ServerInfo a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileServerInfo");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    ServerInfo localServerInfo = new ServerInfo();
    localServerInfo.jdField_a_of_type_JavaLangString = localBundle.getString("ServerInfo.serverIp");
    localServerInfo.jdField_a_of_type_Int = localBundle.getInt("ServerInfo.serverPort");
    return localServerInfo;
  }
  
  public String a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileSaveFolder");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    e();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceiveRegisterProxySvcPack");
    localBundle.putInt("iPcOnlineStatus", paramInt1);
    localBundle.putInt("iIsSupportDataLine", paramInt2);
    localBundle.putInt("iIsSupportPrintable", paramInt3);
    localBundle.putInt("iIsSupportViewPCFile", paramInt4);
    localBundle.putLong("iPcVersion", paramLong);
    a(localBundle, false);
  }
  
  public void a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramMpfileTaskInfo, paramLong);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(10009);
    localForwardFileInfo.d(7);
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.d(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
    localForwardFileInfo.c(paramMpfileTaskInfo.jdField_d_of_type_Long);
    localForwardFileInfo.d(paramMpfileTaskInfo.b);
    localForwardFileInfo.a(paramMpfileTaskInfo.e);
    paramMpfileTaskInfo = Looper.getMainLooper();
    if (Thread.currentThread() != paramMpfileTaskInfo.getThread())
    {
      new Handler(paramMpfileTaskInfo).post(new lyw(this, localFileManagerEntity, localForwardFileInfo));
      return;
    }
    paramMpfileTaskInfo = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), FileBrowserActivity.class);
    paramMpfileTaskInfo.addFlags(268435456);
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      paramMpfileTaskInfo.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    paramMpfileTaskInfo.putExtra("fileinfo", localForwardFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().startActivity(paramMpfileTaskInfo);
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    if ((paramEntity instanceof DataLineMsgRecord)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramEntity, paramProxyListener);
    }
    while (!(paramEntity instanceof MpfileTaskRecord)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((MpfileTaskRecord)paramEntity);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceive");
    if (paramToServiceMsg != null) {
      localBundle.putParcelable("ToServiceMsg", paramToServiceMsg);
    }
    if (paramFromServiceMsg != null) {
      localBundle.putParcelable("FromServiceMsg", paramFromServiceMsg);
    }
    if (paramArrayOfByte != null) {
      localBundle.putByteArray("data", paramArrayOfByte);
    }
    a(localBundle, true);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "cancelMpfile");
    localBundle.putString("strDataLineMPFileID", paramString);
    a(localBundle);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
    }
    while (!paramString1.equals(MpfileTaskRecord.tableName())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
    }
    while (!paramString1.equals(MpfileTaskRecord.tableName())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
  }
  
  public void a(msg_comm.Msg paramMsg)
  {
    paramMsg = paramMsg.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "handleDataLinePushMsg_210");
    localBundle.putByteArray("msgBytes", paramMsg);
    a(localBundle, true);
  }
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    paramMsg = paramMsg.toByteArray();
    paramMsgBody = paramMsgBody.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "DoCCPush");
    localBundle.putByteArray("msgBytes", paramMsg);
    localBundle.putByteArray("ccBytes", paramMsgBody);
    a(localBundle, true);
  }
  
  public boolean a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "isWifiphotoCanDisabled");
    localBundle.putString("din", paramString);
    paramString = a(localBundle);
    if (paramString == null) {
      return false;
    }
    return paramString.getBoolean("result");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (paramObservable != null)
    {
      int i = paramObservable.e();
      paramObservable = new Bundle();
      paramObservable.putString("notify_cmd", "UpdateUnreadMsgsNum");
      paramObservable.putInt("unread", i);
      a(paramObservable, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager
 * JD-Core Version:    0.7.0.1
 */