package com.tencent.mobileqq.servlet;

import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.MsgNotification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class CliNotifyPush
  extends MSFServlet
{
  public static final int a = 1;
  public static final String a = "MessageSvc.WNSQzone.Push";
  private static final String[] a = { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone" };
  public static final int b = 2;
  public static final String b = "recvuin";
  public static final int c = 4;
  public static final String c = "time";
  public static final int d = 5;
  private static final String d = "CliNotifyPush";
  private static final String e = "CliNotifySvc.SvcReqPush";
  private static final String f = "MessageSvc.WNSQzone";
  private static final String g = "QZONE_PUSH_ST";
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    long l2 = 0L;
    SharedPreferences localSharedPreferences = paramQQAppInterface.a().getSharedPreferences("QZONE_PUSH_ST", 0);
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramQQAppInterface.length() > 0) {
          l1 = localSharedPreferences.getLong(paramQQAppInterface + "", 0L);
        }
      }
    }
    return l1;
  }
  
  public static SingleMsg a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    System.arraycopy(paramArrayOfByte, 4, paramArrayOfByte, 0, paramArrayOfByte.length - 4);
    PushInfo localPushInfo = new PushInfo();
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("utf-8");
    localPushInfo.readFrom(paramArrayOfByte);
    long l = a(paramQQAppInterface);
    try
    {
      paramArrayOfByte = localPushInfo.vecMsg;
      paramArrayOfByte = (SingleMsg)paramArrayOfByte.get(paramArrayOfByte.size() - 1);
      int i;
      paramArrayOfByte.printStackTrace();
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        i = Integer.parseInt((String)paramArrayOfByte.data.get("pushtype"));
        if (((i == 1) || (i == 2) || (i == 4) || (i == 5)) && (paramArrayOfByte.addTime > l))
        {
          a(paramQQAppInterface, paramArrayOfByte.addTime);
          return paramArrayOfByte;
        }
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramQQAppInterface = paramArrayOfByte;
          paramArrayOfByte = localException;
        }
      }
      paramArrayOfByte = paramArrayOfByte;
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {}
    for (long l = Long.parseLong(paramQQAppInterface.getAccount());; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Feeds", 2, "sentQzoneMsfPushAck=localTimeStamp=" + paramLong + "=uin=" + l);
      }
      if ((paramLong != 0L) && (l != 0L))
      {
        NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZonePushAckServlet.class);
        localNewIntent.putExtra("timestamp", paramLong);
        localNewIntent.putExtra("hostuin", l);
        paramQQAppInterface.startServlet(localNewIntent);
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        localEditor.putLong(paramQQAppInterface + "", paramLong);
      }
    }
    localEditor.commit();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    SingleMsg localSingleMsg = a(localQQAppInterface, paramFromServiceMsg.getWupBuffer());
    if ((localSingleMsg == null) || (localSingleMsg.data == null)) {}
    int k;
    int i;
    long l;
    Object localObject2;
    do
    {
      return;
      paramFromServiceMsg = (String)localSingleMsg.data.get("conent");
      k = Integer.parseInt((String)localSingleMsg.data.get("pushtype"));
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush type=" + k);
      }
      if ((k != 4) && (k != 2)) {
        break label820;
      }
      i = 1;
      l = localSingleMsg.opUin;
      if (k != 5) {
        break;
      }
      localObject2 = (SubAccountManager)localQQAppInterface.getManager(59);
    } while ((localObject2 == null) || (((SubAccountManager)localObject2).a((String)localSingleMsg.data.get("recvuin")) != 1));
    Object localObject1 = new SubAccountMessage();
    ((SubAccountMessage)localObject1).isread = false;
    ((SubAccountMessage)localObject1).msg = ((String)localSingleMsg.data.get("conent"));
    ((SubAccountMessage)localObject1).unreadNum = Integer.parseInt((String)localSingleMsg.data.get("relatecount"));
    ((SubAccountMessage)localObject1).msgtype = -1000;
    ((SubAccountMessage)localObject1).selfuin = localQQAppInterface.getAccount();
    ((SubAccountMessage)localObject1).sendername = "空间动态";
    ((SubAccountMessage)localObject1).senderuin = "2005060620050606";
    ((SubAccountMessage)localObject1).frienduin = "2005060620050606";
    ((SubAccountMessage)localObject1).subUin = ((String)localSingleMsg.data.get("recvuin"));
    ((SubAccountMessage)localObject1).time = Long.parseLong((String)localSingleMsg.data.get("time"));
    ((SubAccountMessage)localObject1).needNotify = false;
    if (localObject2 != null) {
      ((SubAccountManager)localObject2).a((SubAccountMessage)localObject1);
    }
    int m = localQQAppInterface.a().a(((SubAccountMessage)localObject1).subUin, 7000);
    if (localObject2 != null) {}
    for (int j = ((SubAccountManager)localObject2).d(((SubAccountMessage)localObject1).subUin);; j = 0)
    {
      j -= m;
      if (j != 0)
      {
        localQQAppInterface.a().b(((SubAccountMessage)localObject1).subUin, 7000, j);
        localQQAppInterface.a().a(new String[] { AppConstants.W, ((SubAccountMessage)localObject1).subUin });
      }
      localObject2 = new SubAccountBackProtocData();
      ((SubAccountBackProtocData)localObject2).jdField_c_of_type_JavaLangString = ((SubAccountMessage)localObject1).subUin;
      ((SubAccountBackProtocData)localObject2).jdField_c_of_type_Boolean = true;
      ((SubAccountBackProtocData)localObject2).p = 0;
      localQQAppInterface.a().a(8003, true, localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "ClientNotifyPush get online sub qzone push success");
      }
      if ((k == 1) && (a(localQQAppInterface, k))) {
        ((QZoneManagerImp)localQQAppInterface.getManager(9)).a(1, i, l, paramFromServiceMsg);
      }
      label580:
      boolean bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("Feeds", 2, "receive push time:" + localSingleMsg.addTime + "=unreadCount=" + i + "=uin=" + l + "=message=" + paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("MessageSvc.WNSQzone.Push", 2, "receive push time:" + localSingleMsg.addTime);
        }
        a(localSingleMsg.addTime, localQQAppInterface);
        if ((!localQQAppInterface.isBackground_Pause) || (!a(localQQAppInterface, k)) || (paramFromServiceMsg == null)) {
          break;
        }
        bool2 = localQQAppInterface.f();
        if (bool2) {
          break label902;
        }
        paramFromServiceMsg = localQQAppInterface.a().getApplicationContext().getString(2131367217) + i + localQQAppInterface.a().getApplicationContext().getString(2131367218);
      }
      label900:
      label902:
      for (;;)
      {
        localObject1 = ((ActivityManager)localQQAppInterface.a().getSystemService("activity")).getRunningTasks(1);
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {}
        for (boolean bool1 = ((ActivityManager.RunningTaskInfo)((List)localObject1).get(0)).topActivity.getClassName().equals("cooperation.qzone.QzoneGPUPluginProxyActivity");; bool1 = false)
        {
          if (bool1) {
            break label900;
          }
          localObject1 = "";
          if (k == 2) {
            localObject1 = (String)localSingleMsg.data.get("shcemaUrlAnd");
          }
          MsgNotification.a().a(localQQAppInterface, 1, paramFromServiceMsg, bool2, k, (String)localObject1);
          return;
          label820:
          i = Integer.parseInt((String)localSingleMsg.data.get("count"));
          break;
          QLog.i("Feeds", 1, "receive push time:" + localSingleMsg.addTime + "=unreadCount=" + i + "=uin=" + l);
          break label580;
        }
        break;
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 5) {
      return false;
    }
    if (paramInt == 2) {
      return LocalMultiProcConfig.a(paramQQAppInterface.a().getApplicationContext().getString(2131366827) + paramQQAppInterface.getAccount(), true);
    }
    return LocalMultiProcConfig.a(paramQQAppInterface.a().getApplicationContext().getString(2131366826) + paramQQAppInterface.getAccount(), true);
  }
  
  public String[] getPreferSSOCommands()
  {
    return a;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush")) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
      }
      paramIntent = (byte[])paramFromServiceMsg.attributes.get("pushMsgs");
      localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).a(0)).a(null, paramFromServiceMsg, localSvcMsgPush);
    }
    while ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) || (!paramFromServiceMsg.isSuccess()))
    {
      SvcMsgPush localSvcMsgPush;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get online qzone push");
    }
    a(paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.CliNotifyPush
 * JD-Core Version:    0.7.0.1
 */