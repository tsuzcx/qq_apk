package com.dataline.util;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cv;
import cx;
import cz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ProgressReq;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ProgressRsp;

public class DLRouterSessionInfoRequestTask
{
  static final int jdField_a_of_type_Int = 12;
  public static final String a = "dataline.DLRouterSessionListAdapter";
  static final int jdField_b_of_type_Int = 13;
  private static long jdField_b_of_type_Long = 0L;
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 15000;
  static final int e = 2;
  static final int f = 2;
  private static int j = 0;
  public long a;
  private DLRouterSessionInfoRequestTask.NotifyReceiver jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask$NotifyReceiver;
  private DLRouterSessionListAdapter jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  public boolean a;
  private Timer jdField_b_of_type_JavaUtilTimer = null;
  private long jdField_c_of_type_Long;
  private long jdField_d_of_type_Long;
  public int g = a();
  public int h = 0;
  public int i;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  
  public DLRouterSessionInfoRequestTask()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = a();
    this.jdField_a_of_type_Boolean = false;
    this.c = 0L;
    this.d = 0L;
  }
  
  public static int a()
  {
    int n = j;
    j = n + 1;
    return n;
  }
  
  public static long a()
  {
    if (jdField_b_of_type_Long == 0L) {
      jdField_b_of_type_Long = MessageCache.a();
    }
    long l1 = jdField_b_of_type_Long;
    jdField_b_of_type_Long = 1L + l1;
    return l1;
  }
  
  private void c(boolean paramBoolean)
  {
    c();
    this.jdField_a_of_type_Boolean = false;
    a(paramBoolean);
    if (QLog.isDevelopLevel()) {
      QLog.d("dataline.DLRouterSessionListAdapter", 4, "请求结束 : nCMD[" + this.i + "], nSendCookie[" + this.g + "], uTaskCookie[" + this.jdField_a_of_type_Long + "], isTimeout[" + paramBoolean + "], IsPersistentTimeout[" + a());
    }
    if (this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter != null) {
      this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.a(this, paramBoolean);
    }
    this.jdField_a_of_type_Long = 0L;
    this.g = 0;
    if (!a()) {
      d();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter == null) {}
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.a());
    a(0, 16);
    return;
    if (this.k == 0)
    {
      a(0, 32);
      return;
    }
    a(0, 23);
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("dataline.DLRouterSessionListAdapter", 4, "暂停请求 : nCMD[" + this.i + "], nSendCookie[" + this.g + "], uTaskCookie[" + this.jdField_a_of_type_Long + "], isRunning[" + this.jdField_a_of_type_Boolean + "], mMsgTaskListHashMap[" + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    c();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter = null;
    BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask$NotifyReceiver);
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.DLRouterSessionListAdapter", 4, "开始请求list,但已经在运行了 : nSendCookie[" + this.g + "], uTaskCookie[" + this.jdField_a_of_type_Long + "], infoflag[" + paramInt2);
      }
    }
    do
    {
      return;
      this.i = paramInt1;
      this.jdField_a_of_type_Long = a();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.g = a();
      b();
      this.jdField_a_of_type_Boolean = true;
      this.h = paramInt2;
      SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
      localMsgBody.uint32_sub_cmd.set(12);
      ProtocolHelper.fillMsgHeader(localMsgBody.msg_header, this.c, this.d);
      localMsgBody.msg_subcmd_0xc_progress_req = new SubMsgType0x7.MsgBody.ProgressReq();
      localMsgBody.msg_subcmd_0xc_progress_req.uint32_cmd.set(this.i);
      localMsgBody.msg_subcmd_0xc_progress_req.uint64_cookie.set(this.jdField_a_of_type_Long);
      localMsgBody.msg_subcmd_0xc_progress_req.uint32_infoflag.set(this.h);
      localMsgBody.msg_subcmd_0xc_progress_req.setHasFlag(true);
      localMsgBody.setHasFlag(true);
      a(this.g, localMsgBody);
    } while (!QLog.isDevelopLevel());
    QLog.d("dataline.DLRouterSessionListAdapter", 4, "开始请求list : nSendCookie[" + this.g + "], uTaskCookie[" + this.jdField_a_of_type_Long + "], infoflag[" + this.h);
  }
  
  public void a(int paramInt, SubMsgType0x7.MsgBody paramMsgBody)
  {
    if (this.c != this.d)
    {
      cz localcz = new cz(this);
      localcz.jdField_a_of_type_Int = paramInt;
      localcz.b = paramMsgBody.uint32_sub_cmd.get();
      localcz.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0x7SubMsgType0x7$MsgBody = paramMsgBody;
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localcz);
      paramMsgBody = paramMsgBody.toByteArray();
      ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.a().a()).a(53)).a(this.c, paramInt, paramMsgBody);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(3);
    ProtocolHelper.fillMsgHeader(localMsgBody.msg_header, this.c, this.d);
    SubMsgType0x7.MsgBody.FileControl localFileControl = new SubMsgType0x7.MsgBody.FileControl();
    int n = a();
    localFileControl.uint64_sessionid.set(paramLong);
    localFileControl.uint32_operate.set(paramInt);
    localFileControl.uint32_seq.set(n);
    localFileControl.uint32_group_id.set(0);
    localFileControl.uint32_batchID.set(0);
    localFileControl.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x3_filecontrol.add(localFileControl);
    localMsgBody.setHasFlag(true);
    a(n, localMsgBody);
    if (QLog.isDevelopLevel()) {
      QLog.d("dataline.DLRouterSessionListAdapter", 4, "NotifyFileControl : nSendCookie[" + n + "],  uint64_sessionid[" + paramLong + "],  operate[" + paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int n = paramBundle.getInt("nCookie");
    boolean bool = paramBundle.getBoolean("isTimeout");
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(n))) {}
    do
    {
      return;
      paramBundle = (cz)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(n));
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(n));
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.DLRouterSessionListAdapter", 4, "发信令结果 : nSendCookie[" + n + "], nCmd[" + paramBundle.b + "], isTimeout[" + bool);
      }
      switch (paramBundle.b)
      {
      case 3: 
      default: 
        return;
      }
    } while ((!bool) || (this.g != n));
    c(bool);
  }
  
  public void a(DLRouterSessionListAdapter paramDLRouterSessionListAdapter, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter = paramDLRouterSessionListAdapter;
    this.c = paramLong1;
    this.d = paramLong2;
    paramDLRouterSessionListAdapter = new IntentFilter();
    paramDLRouterSessionListAdapter.addAction("SmartDevice_receiveDatalineCSReply");
    paramDLRouterSessionListAdapter.addAction("SmartDevice_receiveDatalineCCReply");
    paramDLRouterSessionListAdapter.addAction("SmartDevice_receiveDatalineCCPush");
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask$NotifyReceiver = new DLRouterSessionInfoRequestTask.NotifyReceiver(this);
    BaseApplication.getContext().registerReceiver(this.jdField_a_of_type_ComDatalineUtilDLRouterSessionInfoRequestTask$NotifyReceiver, paramDLRouterSessionListAdapter);
  }
  
  public void a(SubMsgType0x7.MsgBody.ProgressRsp paramProgressRsp)
  {
    List localList = paramProgressRsp.rpt_msg_progressinfo.get();
    long l1 = paramProgressRsp.uint64_cookie.get();
    int n = paramProgressRsp.uint32_package_count.get();
    int i1 = paramProgressRsp.uint32_package_index.get();
    int i2 = paramProgressRsp.uint32_cmd.get();
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      QLog.d("dataline.DLRouterSessionListAdapter", 4, "收到SessionInfo回包 : 回包的uTaskCookie[" + l1 + "], 当前的uTaskCookie[" + this.jdField_a_of_type_Long + "], nPackageCount[" + n + "], nPackageIndex[" + i1 + "], cmd[" + i2);
      if (localList == null) {
        QLog.d("dataline.DLRouterSessionListAdapter", 4, "progressInfoList为空");
      }
    }
    else
    {
      if (this.jdField_a_of_type_Long != l1) {
        break label249;
      }
      a(n);
      if (a(i1))
      {
        if ((localList != null) && (localList.size() != 0)) {
          break label243;
        }
        bool = true;
        label175:
        b(bool);
        c(false);
      }
    }
    for (;;)
    {
      if ((i2 == 0) && (this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter != null)) {
        this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.a(localList);
      }
      return;
      QLog.d("dataline.DLRouterSessionListAdapter", 4, "progressInfoList大小[" + localList.size());
      break;
      label243:
      bool = false;
      break label175;
      label249:
      if (QLog.isColorLevel()) {
        QLog.e("dataline.DLRouterSessionListAdapter", 2, "OnSessionInfoResponse : 没找到对应的请求, uint64_cookie[" + l1);
      }
      d();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.k += 1;
      return;
    }
    this.k = 0;
  }
  
  public boolean a()
  {
    return this.k >= 2;
  }
  
  public boolean a(int paramInt)
  {
    c();
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == this.m) {
      return true;
    }
    b();
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_JavaUtilTimer = new Timer();
    cv localcv = new cv(this, this.g, this.jdField_a_of_type_Long);
    this.jdField_b_of_type_JavaUtilTimer.schedule(localcv, 15000L);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l += 1;
      return;
    }
    this.l = 0;
  }
  
  public boolean b()
  {
    return this.l >= 2;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilTimer != null)
    {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
      this.jdField_b_of_type_JavaUtilTimer.purge();
      this.jdField_b_of_type_JavaUtilTimer = null;
    }
  }
  
  void d()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilTimer == null))
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      cx localcx = new cx(this);
      this.jdField_a_of_type_JavaUtilTimer.schedule(localcx, 3000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.DLRouterSessionListAdapter", 4, "定时3秒之后，开始下次请求 ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.DLRouterSessionInfoRequestTask
 * JD-Core Version:    0.7.0.1
 */