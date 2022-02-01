package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;

public class ReportControllerImpl
  extends ReportController
  implements Handler.Callback, BusinessObserver
{
  private static final int jdField_a_of_type_Int = 40;
  private static final long jdField_a_of_type_Long = 86400000L;
  private static final int jdField_b_of_type_Int = 20;
  private static final int c = 9527;
  private static final int d = 9528;
  private static final int e = 2;
  private static final String i = "pre_report_time";
  private static final String j = "${uin_unknown}";
  private static final String k = "${count_unknown}";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_b_of_type_Long;
  private int f;
  
  private ReportControllerImpl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Create:" + paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.b(), this);
    try
    {
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "ActionReportInterval");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        this.b = (Long.parseLong(paramQQAppInterface) * 1000L);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label99:
      break label99;
    }
    if (this.b <= 1000L) {
      this.b = 86400000L;
    }
  }
  
  private int a()
  {
    for (;;)
    {
      try
      {
        if (this.f <= 0)
        {
          this.f = (new Random().nextInt(1000000) + 100);
          int m = this.f;
          return m;
        }
        if (this.f >= 1000100) {
          this.f = 100;
        } else {
          this.f += 1;
        }
      }
      finally {}
    }
  }
  
  public static ReportController a(QQAppInterface paramQQAppInterface)
  {
    return new ReportControllerImpl(paramQQAppInterface);
  }
  
  private boolean a()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.a)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "doReportClickEvent:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    label519:
    for (;;)
    {
      int n;
      int i1;
      int i2;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        n = this.jdField_a_of_type_JavaUtilHashMap.size();
        ArrayList localArrayList = new ArrayList(20);
        localObject3 = new ArrayList(20);
        int m = a();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          localObject4 = (String)localIterator.next();
          localObject4 = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(localObject4);
          if ((((Reporting)localObject4).mDetailHashCode != 0) && (((Reporting)localObject4).mDetail.hashCode() != ((Reporting)localObject4).mDetailHashCode))
          {
            localIterator.remove();
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", (Entity)localObject4, 5, null);
            i2 = n - 1;
            n = i1;
            i1 = i2;
            break label470;
            label201:
            localObject4 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ReportServlet.class);
            ((NewIntent)localObject4).putExtra("sendType", 10);
            ((NewIntent)localObject4).putExtra("seqKey", m);
            ((NewIntent)localObject4).putExtra("tags", localArrayList);
            ((NewIntent)localObject4).putExtra("retryTime", 0);
            ((NewIntent)localObject4).putExtra("contents", (Serializable)localObject3);
            ((NewIntent)localObject4).setObserver(this);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject4);
            localObject3 = new ArrayList(20);
            localArrayList = new ArrayList(20);
            if (n < i1)
            {
              m = a();
              break label485;
            }
          }
          else
          {
            localArrayList.add(((Reporting)localObject4).mTag);
            String str = ((Reporting)localObject4).mDetail.replace("${count_unknown}", String.valueOf(((Reporting)localObject4).mCount));
            ((ArrayList)localObject3).add(str);
            localIterator.remove();
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", (Entity)localObject4, 5, null);
            if (!QLog.isColorLevel()) {
              break label508;
            }
            QLog.d("ReportController", 2, "Report: " + ((Reporting)localObject4).mTag + ", " + str + ", " + m);
            break label508;
          }
        }
        else
        {
          return true;
        }
      }
      break label485;
      label455:
      Object localObject4 = localObject1;
      Object localObject2 = localObject3;
      Object localObject3 = localObject4;
      for (;;)
      {
        label470:
        if (n % 20 == 0) {
          break label519;
        }
        if (n < i1) {
          break label455;
        }
        break label201;
        label485:
        localObject4 = localObject3;
        i2 = i1;
        localObject3 = localObject2;
        localObject2 = localObject4;
        i1 = n;
        n = i2;
        break;
        label508:
        i2 = i1 + 1;
        i1 = n;
        n = i2;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(9527);
    try
    {
      a();
      Object localObject = BaseApplicationImpl.a.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      long l = System.currentTimeMillis();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("pre_report_time", l);
      ((SharedPreferences.Editor)localObject).commit();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(9527, this.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ReportController", 4, "report exception:" + localException);
        }
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "saveReportData:" + paramQQAppInterface);
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.values();
      if (localObject != null)
      {
        int m = ((Collection)localObject).size();
        if (m <= 0) {}
      }
      try
      {
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        EntityTransaction localEntityTransaction = paramQQAppInterface.a();
        localEntityTransaction.a();
        try
        {
          localObject = ((Collection)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localReporting = (Reporting)((Iterator)localObject).next();
            if (localReporting.getStatus() != 1000) {
              break label161;
            }
            paramQQAppInterface.b(localReporting);
          }
          this.jdField_a_of_type_JavaUtilHashMap.clear();
        }
        catch (Throwable localThrowable)
        {
          localEntityTransaction.c();
          localEntityTransaction.b();
          paramQQAppInterface.a();
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        Reporting localReporting;
        label151:
        label161:
        break label151;
      }
      return;
      paramQQAppInterface.a(localReporting);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(9527);
  }
  
  protected void a(QQAppInterface arg1, ProxyManager paramProxyManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ???;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = paramProxyManager;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Init:" + ???);
    }
    paramProxyManager = ???.a().createEntityManager().a(Reporting.class);
    if (paramProxyManager != null) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramProxyManager = paramProxyManager.iterator();
        if (paramProxyManager.hasNext())
        {
          Reporting localReporting1 = (Reporting)paramProxyManager.next();
          String str = localReporting1.mTag + ":" + localReporting1.mDetail;
          Reporting localReporting2 = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if (localReporting2 != null)
          {
            int m = localReporting1.mCount;
            localReporting2.mCount += m;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localReporting1);
        }
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "addReporting:" + paramString2 + ", " + paramInt);
    }
    String str = paramString1 + ":" + paramString2;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Reporting localReporting = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localReporting == null)
        {
          localReporting = new Reporting();
          localReporting.mTag = paramString1;
          localReporting.mDetail = paramString2;
          localReporting.mCount = paramInt;
          localReporting.mDetailHashCode = localReporting.mDetail.hashCode();
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localReporting);
          if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting, 3, null);
          }
          if (this.jdField_a_of_type_JavaLangBoolean != null)
          {
            if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
              break label275;
            }
            if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 40) {
              b();
            }
          }
        }
        else
        {
          localReporting.mCount += paramInt;
          if ((this.jdField_a_of_type_JavaLangBoolean == null) || (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting.clone(), 4, null);
        }
      }
      label275:
      if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(9528)) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(9528);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() != null) {}
      for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();; localObject = "10000")
      {
        localObject = localBaseApplicationImpl.getSharedPreferences((String)localObject, 0);
        long l = System.currentTimeMillis();
        if (Math.abs(l - ((SharedPreferences)localObject).getLong("pre_report_time", l)) >= this.b) {
          break;
        }
        return;
      }
    }
    b();
  }
  
  protected void b(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Destory:" + paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(9528);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9527) {
      b();
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 9528) {
        b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10)
    {
      int m = paramBundle.getInt("seqKey");
      paramInt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReportController", 2, "OnReceive: isSuccess-" + paramBoolean + ", seqKey = " + m);
      }
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((!paramBoolean) && (paramInt < 2) && (localQQAppInterface != null))
      {
        NewIntent localNewIntent = new NewIntent(localQQAppInterface.a(), ReportServlet.class);
        localNewIntent.putExtra("sendType", 10);
        localNewIntent.putExtra("seqKey", m);
        localNewIntent.putExtra("tags", paramBundle.getStringArrayList("tags"));
        localNewIntent.putExtra("contents", paramBundle.getStringArrayList("contents"));
        localNewIntent.putExtra("retryTime", paramInt + 1);
        localNewIntent.setObserver(this);
        localQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportControllerImpl
 * JD-Core Version:    0.7.0.1
 */