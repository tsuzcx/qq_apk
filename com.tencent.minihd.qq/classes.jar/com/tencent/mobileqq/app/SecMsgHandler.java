package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetBaseInfo_Req;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetBaseInfo_Rsp;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_Req;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_Req_Comm;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_Rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import hpm;
import hpn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.s2c.msgtype0x210.submsgtype0x60.SubMsgType0x60.MsgBody;

public class SecMsgHandler
  extends BusinessHandler
{
  public static final int a = 2047;
  public static final String a = "SecMsgHandler";
  public static volatile boolean a = false;
  public static final int b = 1;
  public static final String b = "extra_notification_sec_msg";
  public static final int c = 2;
  public static final String c = "extra_sec_msg_list";
  public static final int d = 3;
  public static final String d = "extra_empty_sec_msg_list";
  public static final int e = 4;
  public static final String e = "extra_get_inbox_over";
  public static final int f = 5;
  public static final String f = "extra_session_list";
  public static final int g = 6;
  public static final String g = "extra_get_session_list_over";
  public static final int h = 7;
  public static final int i = 2;
  public static final int j = 1;
  public static final int k = 0;
  public static volatile int l = 3;
  public static int m = 5;
  public OnPluginInstallListener a;
  private ArrayList a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  protected SecMsgHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new hpn(this);
  }
  
  private SecMsgComu.SecMsg_Req a(int paramInt, long paramLong)
  {
    SecMsgComu.SecMsg_Req localSecMsg_Req = new SecMsgComu.SecMsg_Req();
    localSecMsg_Req.cmd.set(paramInt);
    localSecMsg_Req.packet_seq.set(paramLong);
    SecMsgComu.SecMsg_Req_Comm localSecMsg_Req_Comm = new SecMsgComu.SecMsg_Req_Comm();
    localSecMsg_Req_Comm.platform.set(109L);
    localSecMsg_Req_Comm.osver.set(DeviceInfoUtil.e());
    localSecMsg_Req_Comm.mqqver.set("5.9.3");
    localSecMsg_Req.comm.set(localSecMsg_Req_Comm);
    return localSecMsg_Req;
  }
  
  private void a()
  {
    Object localObject1 = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((localObject1 != null) && (!((SecMsgManager)localObject1).b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, Sec msg feature not available, abort push msg.");
      }
      return;
    }
    localObject1 = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningAppProcesses();
    boolean bool1;
    label67:
    boolean bool2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      bool1 = false;
      bool2 = bool1;
      if (!((Iterator)localObject1).hasNext()) {
        break label185;
      }
      localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      if ((!((ActivityManager.RunningAppProcessInfo)localObject3).processName.startsWith("com.tencent.minihd.qq")) || (((ActivityManager.RunningAppProcessInfo)localObject3).importance != 100) || (!"com.tencent.minihd.qq:secmsg".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)localObject3).processName))) {
        break label465;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "isQQProcessForground >> " + ((ActivityManager.RunningAppProcessInfo)localObject3).processName + "[ " + ((ActivityManager.RunningAppProcessInfo)localObject3).importance + " ]");
      }
      bool1 = true;
    }
    label185:
    label465:
    for (;;)
    {
      for (;;)
      {
        break label67;
        bool2 = false;
        bool1 = NoDisturbUtil.a((BaseApplicationImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!bool2) && (bool1)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SecMsgHandler", 2, "handleMsgNotifyInner, isChatting=" + bool2 + ", canDisturb=" + bool1);
        }
        if (!GuardManager.a.b())
        {
          if (!bool2) {
            break;
          }
          localObject1 = new Intent("com.tencent.mobileqq.secmsg.PushMsg");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().sendBroadcast((Intent)localObject1);
          return;
        }
        if (!bool1) {
          break;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources();
        try
        {
          localObject1 = BitmapFactory.decodeResource((Resources)localObject3, 2130838429);
          if (localObject1 == null) {
            break;
          }
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), SplashActivity.class);
          String str1 = ((Resources)localObject3).getString(2131369381);
          String str2 = ((Resources)localObject3).getString(2131369382);
          localObject3 = ((Resources)localObject3).getString(2131369383);
          ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "CMD_SHOW_NOTIFIYCATION");
          localToServiceMsg.extraData.putStringArray("cmds", new String[] { str1, str2, localObject3 });
          localToServiceMsg.extraData.putParcelable("intent", localIntent);
          localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localToServiceMsg);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "sendPbMsg2Msf, cmdIndex=" + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), SecMsgServlet.class);
    localNewIntent.putExtra("cmd", String.valueOf(paramInt));
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("timeout", paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "handleGetSecMsgBaseInfo");
    }
    paramIntent = paramIntent.getByteArrayExtra("data");
    if (paramIntent == null) {}
    long l2;
    long l1;
    do
    {
      return;
      SecMsgComu.SecMsg_Req localSecMsg_Req = new SecMsgComu.SecMsg_Req();
      localSecMsg_Req.mergeFrom(paramIntent);
      l2 = -1L;
      l1 = l2;
      if (localSecMsg_Req.reqcmd_0x06.has())
      {
        paramIntent = (SecMsgComu.SecMsg_GetBaseInfo_Req)localSecMsg_Req.reqcmd_0x06.get();
        l1 = l2;
        if (paramIntent.mask.has()) {
          l1 = paramIntent.mask.get();
        }
      }
      if ((paramFromServiceMsg.getResultCode() != 1000) || (paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        a(5, false, null);
        return;
      }
      paramFromServiceMsg = new SecMsgComu.SecMsg_Rsp();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte);
      if (0L != paramFromServiceMsg.ret.get()) {
        break;
      }
      paramIntent = new SecMsgManager.SecMsgBaseInfo();
    } while (!paramFromServiceMsg.rspcmd_0x06.has());
    paramFromServiceMsg = (SecMsgComu.SecMsg_GetBaseInfo_Rsp)paramFromServiceMsg.rspcmd_0x06.get();
    if (paramFromServiceMsg.f_forbid.has()) {
      paramIntent.jdField_a_of_type_Boolean = paramFromServiceMsg.f_forbid.get();
    }
    if (paramFromServiceMsg.f_whiteuser.has()) {
      paramIntent.jdField_b_of_type_Boolean = paramFromServiceMsg.f_whiteuser.get();
    }
    if (paramFromServiceMsg.f_disable.has()) {
      paramIntent.c = paramFromServiceMsg.f_disable.get();
    }
    if (paramFromServiceMsg.dss.has()) {
      paramIntent.jdField_a_of_type_JavaUtilList = paramFromServiceMsg.dss.get();
    }
    if (paramFromServiceMsg.newest_seq.has()) {
      paramIntent.jdField_a_of_type_Long = paramFromServiceMsg.newest_seq.get();
    }
    if (paramFromServiceMsg.nowts.has()) {
      paramIntent.jdField_b_of_type_Long = paramFromServiceMsg.nowts.get();
    }
    if (paramFromServiceMsg.appstate.has()) {
      paramIntent.d = ((int)paramFromServiceMsg.appstate.get());
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuffer();
      paramFromServiceMsg.append("mIsForbidden=").append(paramIntent.jdField_a_of_type_Boolean).append(",mIsWhiteUser=").append(paramIntent.jdField_b_of_type_Boolean).append(",mIsDisable=").append(paramIntent.c).append(",mNewestSeq=").append(paramIntent.jdField_a_of_type_Long).append(",mServerTimestamp=").append(paramIntent.jdField_b_of_type_Long).append(",mFeatureState=").append(paramIntent.d).append(",mShieldSessionList=").append(paramIntent.jdField_a_of_type_JavaUtilList).append(",mask=").append(Long.toBinaryString(l1));
      QLog.d("SecMsgHandler", 2, paramFromServiceMsg.toString());
    }
    paramFromServiceMsg = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    boolean bool2;
    if (paramFromServiceMsg != null)
    {
      boolean bool1 = paramFromServiceMsg.c();
      paramFromServiceMsg.a(paramIntent, l1);
      if (l1 != 16L)
      {
        bool2 = paramFromServiceMsg.c();
        if (bool1 != bool2)
        {
          l2 = paramFromServiceMsg.b();
          if (l2 <= 0L) {
            break label674;
          }
        }
      }
    }
    for (;;)
    {
      paramFromServiceMsg.a(bool2, l2);
      l2 = paramFromServiceMsg.a();
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 4, "last seq: " + l2 + ", fetch newest seq " + paramIntent.jdField_a_of_type_Long + ", now try to show entrance.");
      }
      if ((l2 < paramIntent.jdField_a_of_type_Long) && (paramFromServiceMsg.c()))
      {
        paramFromServiceMsg.a(true, paramFromServiceMsg.b());
        if (l1 == 16L) {
          a();
        }
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        if (paramIntent != null) {
          paramIntent.sendEmptyMessage(1009);
        }
      }
      a(5, true, null);
      return;
      label674:
      l2 = NetConnInfoCenter.getServerTime();
    }
    a(5, false, null);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (a()))
    {
      SecMsgComu.SecMsg_GetBaseInfo_Req localSecMsg_GetBaseInfo_Req = new SecMsgComu.SecMsg_GetBaseInfo_Req();
      localSecMsg_GetBaseInfo_Req.mask.set(paramLong1);
      SecMsgComu.SecMsg_Req localSecMsg_Req = a(6, paramLong2);
      localSecMsg_Req.reqcmd_0x06.set(localSecMsg_GetBaseInfo_Req);
      a(6, localSecMsg_Req.toByteArray(), 30000L);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int n = Integer.valueOf(paramIntent.getStringExtra("cmd")).intValue();
    switch (n)
    {
    default: 
      try
      {
        throw new Exception("unknow cmd");
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SecMsgHandler", 2, "handle cmd=" + n + " exception:" + paramIntent.getMessage());
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgHandler", 2, "handleOnlinePushSecMsg");
    }
    if (paramArrayOfByte == null) {}
    SecMsgManager localSecMsgManager;
    long l1;
    do
    {
      for (;;)
      {
        return;
        localSecMsgManager = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if ((localSecMsgManager != null) && (!localSecMsgManager.b()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "handleOnlinePushSecMsg, Sec msg feature not available, abort push msg.");
          }
        }
        else
        {
          SubMsgType0x60.MsgBody localMsgBody = new SubMsgType0x60.MsgBody();
          try
          {
            localMsgBody.mergeFrom(paramArrayOfByte);
            l1 = localMsgBody.uint32_pushcmd.get();
            if ((l1 == 1L) || (l1 == 2L))
            {
              l1 = localMsgBody.int64_ts.get();
              if (localSecMsgManager != null) {
                localSecMsgManager.b();
              }
              if (!jdField_a_of_type_Boolean)
              {
                paramArrayOfByte = (IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(26);
                if ((paramArrayOfByte == null) || (paramArrayOfByte.isPlugininstalled("secmsg_plugin.apk")) || (jdField_a_of_type_Boolean)) {
                  break label208;
                }
                l = 3;
                a();
                return;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("SecMsgHandler", 2, "handleOnlinePushSecMsg, parse error, exception: " + paramArrayOfByte.getMessage());
    return;
    label208:
    localSecMsgManager.a(true, l1);
    a();
  }
  
  public boolean a()
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    IPluginManager localIPluginManager = (IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(26);
    boolean bool;
    if ((localIPluginManager != null) && (!localIPluginManager.isPlugininstalled("secmsg_plugin.apk")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgHandler", 2, "begin try download secmsg plugin. try num:" + l + ", pluginmanager is ready:" + localIPluginManager.isReady());
      }
      SecMsgManager localSecMsgManager = (SecMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localSecMsgManager != null) {
        localSecMsgManager.a(false, 0L);
      }
      if (localIPluginManager.isReady())
      {
        localIPluginManager.installPlugin("secmsg_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      int n = m;
      m = n - 1;
      if (n <= 0) {
        break;
      }
      ThreadManager.b().postDelayed(new hpm(this), 10000L);
      break;
      bool = true;
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecMsgHandler
 * JD-Core Version:    0.7.0.1
 */