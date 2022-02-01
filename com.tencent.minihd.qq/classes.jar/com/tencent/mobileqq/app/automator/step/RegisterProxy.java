package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import hrs;
import hrt;
import hru;
import java.util.HashMap;
import java.util.Random;

public class RegisterProxy
  extends AsyncStep
{
  private static final long d = 3000L;
  public static final int j = 100;
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  Handler jdField_a_of_type_AndroidOsHandler;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private hrs jdField_a_of_type_Hrs;
  private boolean b;
  public long c;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  
  public RegisterProxy()
  {
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + "[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = " + paramBoolean);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler = new hru(this, ThreadManager.b());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + "[ReSendProxy] RESULT_NET_CONNECT resend request!");
    }
    super.a(4);
  }
  
  private boolean b()
  {
    return (this.o == 2) && (this.p == 2) && (this.q == 2);
  }
  
  private void c()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    long l3;
    HashMap localHashMap;
    String str;
    if ((BaseApplicationImpl.jdField_a_of_type_Long < 0L) && (BaseApplicationImpl.jdField_b_of_type_Long < 0L))
    {
      MsgAutoMonitorUtil.a().k();
      l2 = l1 + BaseApplicationImpl.jdField_a_of_type_Long;
      l3 = l1 + BaseApplicationImpl.jdField_b_of_type_Long;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
        QLog.i("AutoMonitor", 2, "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e <= 9) {
          break label457;
        }
        str = ">9";
        label151:
        localHashMap.put("param_FailCount", str);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e <= 0) {
          break label472;
        }
        str = "CLIENT_TIMEOUT";
        label175:
        localHashMap.put("param_FailCode", str);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.jdField_c_of_type_Long));
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actLoginB", true, l2, 0L, localHashMap, null);
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actLoginR", true, l3, 0L, localHashMap, null);
      }
    }
    else
    {
      BaseApplicationImpl.jdField_b_of_type_Long = 0L;
      BaseApplicationImpl.jdField_a_of_type_Long = 0L;
      if (BaseApplicationImpl.jdField_c_of_type_Long > 0L)
      {
        l1 -= BaseApplicationImpl.jdField_c_of_type_Long;
        if ((!BaseApplicationImpl.jdField_b_of_type_Boolean) || (!BaseApplicationImpl.jdField_c_of_type_Boolean)) {
          break label479;
        }
        str = "1";
      }
    }
    for (;;)
    {
      Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + str);
      localHashMap = new HashMap();
      localHashMap.put("actLoginType", str);
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actLoginT", true, l1, 0L, localHashMap, null);
      BaseApplicationImpl.jdField_c_of_type_Long = 0L;
      return;
      Log.i("AutoMonitor", "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      Log.i("AutoMonitor", "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      break;
      label457:
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e);
      break label151;
      label472:
      str = "";
      break label175;
      label479:
      if ((BaseApplicationImpl.jdField_b_of_type_Boolean) && (!BaseApplicationImpl.jdField_c_of_type_Boolean)) {
        str = "2";
      } else if ((!BaseApplicationImpl.jdField_b_of_type_Boolean) && (BaseApplicationImpl.jdField_c_of_type_Boolean)) {
        str = "3";
      } else {
        str = "4";
      }
    }
  }
  
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    MessageHandler localMessageHandler;
    long l2;
    long l3;
    if (this.jdField_b_of_type_Boolean)
    {
      localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (this.h == 18)
      {
        i = 2;
        localMessageHandler.a(i);
        this.jdField_b_of_type_Boolean = false;
      }
    }
    else
    {
      l2 = (int)(System.currentTimeMillis() / 1000L);
      l3 = Math.abs(new Random().nextInt());
      localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (this.h != 18) {
        break label147;
      }
    }
    label147:
    for (int i = 2;; i = 1)
    {
      localMessageHandler.a(i, true, l2 << 32 | l3);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      return 2;
      i = 1;
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new hrt(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_Hrs = new hrs(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Hrs);
    }
    if ((this.h == 17) || (this.h == 19)) {
      MsgAutoMonitorUtil.a().a(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.i = 3;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c())
    {
      if (paramInt != 4) {
        break label26;
      }
      a(true);
    }
    for (;;)
    {
      super.a(paramInt);
      return;
      label26:
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      }
    }
  }
  
  public boolean a()
  {
    return ((this.n == 2) || (this.n == 1)) && ((this.o == 2) || (this.o == 1)) && ((this.p == 2) || (this.p == 1)) && ((this.q == 2) || (this.q == 1));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Hrs);
      this.jdField_a_of_type_Hrs = null;
    }
    MsgAutoMonitorUtil.a().b(Thread.currentThread().getThreadGroup().activeCount());
    c();
    if (this.h == 17) {
      AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(b());
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
      Log.i("AutoMonitor", "SyncData, cost=" + l1);
      if (NetworkUtil.f(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true)) {
          break label255;
        }
        localObject = "actSyncMsgFirst";
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, (String)localObject, b(), l1, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b()) {}
    for (int i = 2;; i = 1)
    {
      ((Automator)localObject).d = i;
      return;
      label255:
      localObject = "actSyncMsgSecond";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */