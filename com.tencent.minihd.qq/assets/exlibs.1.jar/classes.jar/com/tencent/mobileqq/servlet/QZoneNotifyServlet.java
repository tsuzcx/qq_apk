package com.tencent.mobileqq.servlet;

import NS_UNDEAL_COUNT.feed_host_info;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.util.QZoneLogTags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import jvj;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneNotifyServlet
  extends MSFServlet
{
  public static final int a = 1;
  public static long a = 0L;
  public static final String a = "Qzone_Get_NewAndUnread_Count";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static long b = 0L;
  public static final String b = "Qzone_Refresh_UI";
  public static final String c = "qzone_send_by_time";
  public static final String d = "qzone_get_sub_account_unread_count_listener";
  public static final String e = "scene";
  private static final String f = "Q.lebatab." + QZoneLogTags.b + "QZoneNotifyServlet";
  private Timer jdField_a_of_type_JavaUtilTimer;
  private jvj jdField_a_of_type_Jvj;
  private long c = 0L;
  
  static
  {
    b = 600000L;
    jdField_a_of_type_Long = 0L;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer == null) {
      this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
    }
    if (this.jdField_a_of_type_Jvj != null)
    {
      this.jdField_a_of_type_Jvj.cancel();
      this.jdField_a_of_type_Jvj = null;
    }
    this.jdField_a_of_type_Jvj = new jvj(this);
    long l = b;
    Object localObject = (QQAppInterface)getAppRuntime();
    if (localObject != null)
    {
      localObject = (QZoneManagerImp)((QQAppInterface)localObject).getManager(9);
      if (localObject != null) {
        l = ((QZoneManagerImp)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_Jvj, l);
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "scheduleQZoneCountTask.section interval=" + l);
      }
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramQQAppInterface = (FriendsManagerImp)paramQQAppInterface.getManager(8);
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList1.size())
      {
        String str = paramQQAppInterface.b(String.valueOf(((feed_host_info)paramArrayList1.get(i)).uUin));
        paramArrayList2.add(new Pair(Long.valueOf(((feed_host_info)paramArrayList1.get(i)).uUin), str));
        i += 1;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Jvj != null)
    {
      this.jdField_a_of_type_Jvj.cancel();
      this.jdField_a_of_type_Jvj = null;
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    this.c = System.currentTimeMillis();
    Object localObject;
    int i;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      localObject = paramFromServiceMsg.getWupBuffer();
      paramIntent = new ArrayList();
      if (QLog.isDevelopLevel()) {
        QLog.d(f, 4, "onReceiveNS_UNDEAL_COUNT.feed_host_info");
      }
      paramFromServiceMsg = QZoneFeedCountPackeger.a((byte[])localObject, (QQAppInterface)getAppRuntime(), paramIntent);
      if (paramFromServiceMsg != null)
      {
        localObject = (QZoneManagerImp)localQQAppInterface.getManager(9);
        i = ((QZoneManagerImp)localObject).a(1);
        int k = ((QZoneManagerImp)localObject).a(0);
        int j = ((QZoneManagerImp)localObject).a(5);
        if (QLog.isColorLevel()) {
          QLog.d(QZoneLogTags.e + "." + f, 2, "onReceive get QZoneManager cache arrays zebra unread: " + j);
        }
        ArrayList localArrayList = new ArrayList();
        a(localQQAppInterface, paramIntent, localArrayList);
        ((QZoneManagerImp)localObject).a(paramFromServiceMsg, localArrayList);
        bool1 = false;
        if (paramFromServiceMsg[0] != i) {
          bool1 = true;
        }
        i = 0;
        if (paramFromServiceMsg[1] != k)
        {
          i = 1;
          bool1 = true;
        }
        if (paramFromServiceMsg[5] != j)
        {
          j = 5;
          boolean bool2 = true;
          i = j;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d(QZoneLogTags.e + "." + f, 2, "onReceive compare rsp result and cache arrays unread, has new: " + true);
            bool1 = bool2;
            i = j;
          }
        }
        if (paramFromServiceMsg[2] > 0L)
        {
          b = paramFromServiceMsg[2] * 1000L;
          ((QZoneManagerImp)localObject).b(b);
          if (QLog.isColorLevel()) {
            QLog.d(f, 2, "onReceive getFeedInterval:" + b);
          }
        }
        paramIntent = new Bundle();
        paramIntent.putBoolean("new", bool1);
        paramIntent.putInt("notify_type", i);
        if (QLog.isDevelopLevel())
        {
          if (5 == i) {
            QLog.d(QZoneLogTags.e + f, 4, "inform QZoneObserver QZONE_GET_UNREAD isSuccess true.hasnew=" + bool1 + " Type: " + i + "and then notify observer");
          }
        }
        else
        {
          notifyObserver(null, 1000, true, paramIntent, QZoneObserver.class);
          if (localQQAppInterface != null)
          {
            paramIntent = new HashMap();
            StatisticCollector.a(localQQAppInterface.a()).a(localQQAppInterface.a(), "actQzoneUnread", true, this.c - jdField_a_of_type_Long, 0L, paramIntent, "");
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        QLog.d(f, 4, "inform QZoneObserver QZONE_GET_UNREAD isSuccess true.hasnew=" + bool1 + " Type: " + i + "and then notify observer");
        break;
        if (QLog.isColorLevel()) {
          QLog.d(f, 2, "inform QZONE_GET_UNREAD isSuccess false");
        }
        notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
      } while (localQQAppInterface == null);
      paramIntent = "|wufbuf: " + HexUtil.a((byte[])localObject);
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("param_FailCode", String.valueOf(9045));
      paramFromServiceMsg.put("param_errorDesc", paramIntent);
      StatisticCollector.a(localQQAppInterface.a()).a(localQQAppInterface.a(), "actQzoneUnread", false, this.c - jdField_a_of_type_Long, 0L, paramFromServiceMsg, "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "inform QZONE_GET_UNREAD resultcode fail.");
      }
      if (((paramIntent instanceof GetSubAccountUnreadIntent)) && (((GetSubAccountUnreadIntent)paramIntent).a != null)) {
        ((GetSubAccountUnreadIntent)paramIntent).a.a(null);
      }
      notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    } while (localQQAppInterface == null);
    paramIntent = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.a(paramFromServiceMsg);
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("param_FailCode", String.valueOf(9311));
    paramFromServiceMsg.put("param_errorDesc", paramIntent);
    StatisticCollector.a(localQQAppInterface.a()).a(localQQAppInterface.a(), "actQzoneUnread", false, this.c - jdField_a_of_type_Long, 0L, paramFromServiceMsg, "");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "onSend.begin.");
    }
    QQAppInterface localQQAppInterface;
    int i;
    boolean bool;
    int j;
    int k;
    if (paramIntent.getAction().equals("Qzone_Get_NewAndUnread_Count"))
    {
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      i = 3;
      bool = paramIntent.getBooleanExtra("bNotWorkInBackGround", false);
      j = paramIntent.getIntExtra("qzone_send_by_time", 0);
      k = paramIntent.getIntExtra("scene", 102);
      if (j != 1) {
        break label123;
      }
      i = 2;
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "onSend.is send by time.timetype == 1");
      }
      if (System.currentTimeMillis() - jdField_a_of_type_Long >= b) {
        break label123;
      }
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "onSend.interval time is not enough.");
      }
    }
    for (;;)
    {
      return;
      label123:
      if (((j == 0) || (j == 3)) && (bool) && (localQQAppInterface.isBackground_Pause))
      {
        a();
        return;
      }
      paramIntent = (QZoneManagerImp)localQQAppInterface.getManager(9);
      if (((j == 0) || (j == 3)) && (paramIntent != null) && (!paramIntent.a()))
      {
        a();
        return;
      }
      if (j == 2) {
        i = 4;
      }
      if (j == 3) {
        i = 1;
      }
      int m = localQQAppInterface.a().getResources().getDisplayMetrics().widthPixels;
      int n = localQQAppInterface.a().getResources().getDisplayMetrics().heightPixels;
      paramIntent = QZoneFeedCountPackeger.a(Long.valueOf(localQQAppInterface.a()).longValue(), null, m, n, i, k);
      if (paramIntent == null)
      {
        paramIntent = new byte[4];
        notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
      }
      while ((j == 0) || (j == 3))
      {
        a();
        return;
        paramPacket.setTimeout(30000L);
        if (QLog.isDevelopLevel()) {
          QLog.d(QZoneLogTags.c + f, 4, "onSend cmd: " + "SQQzoneSvc." + "getUndealCount" + " iVisitQZoneType: " + i);
        }
        paramPacket.setSSOCommand("SQQzoneSvc." + "getUndealCount");
        paramPacket.putSendData(paramIntent);
        jdField_a_of_type_Long = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(f, 2, "onSend.send success.");
        }
      }
    }
  }
  
  public void service(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("Qzone_Refresh_UI"))
    {
      int i = paramIntent.getIntExtra("notify_type", 0);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putInt("notify_type", i);
      notifyObserver(null, 1000, true, paramIntent, QZoneObserver.class);
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet
 * JD-Core Version:    0.7.0.1
 */