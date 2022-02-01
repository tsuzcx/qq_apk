package com.tencent.mobileqq.app.automator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.app.Constants.Key;

public class Automator
  extends BusinessHandler
  implements Runnable
{
  public static final int a = 1;
  public static final String a = "QQInitHandler";
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  public static final boolean a = true;
  public static final int b = 2;
  public static final String b = "acc_info";
  public static final boolean b = false;
  public static final int c = 3;
  public static final String c = "isConvertOldQQHeadOK";
  public static final String d = "isFriendlistok";
  public static final String e = "isTrooplistok";
  public static final int f = 40001;
  public static final String f = "isPublicAccountListOK";
  private static final int jdField_g_of_type_Int = 3;
  public static final String g = "isDiscussionlistok";
  public static final String h = "isFirstQQInit";
  public long a;
  public SharedPreferences a;
  private LinearGroup jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public Timer a;
  private LinkedList b = new LinkedList();
  public boolean c = false;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public boolean f = false;
  private volatile boolean jdField_g_of_type_Boolean;
  private int h = 0;
  
  public Automator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilTimer = null;
  }
  
  private void a(LinearGroup paramLinearGroup)
  {
    boolean bool = true;
    if ("{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}".equals(paramLinearGroup.b)) {
      this.b.clear();
    }
    do
    {
      if (bool) {
        this.b.add(paramLinearGroup);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addWaitingMode_Locked " + paramLinearGroup.b + " " + bool);
      }
      return;
      if ((!"{[13,16],19,21,53,55,23,42,32,56,57}".equals(paramLinearGroup.b)) && (!"{15,18,21,53,55,24}".equals(paramLinearGroup.b))) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null);
    bool = StepFactory.b(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup);
    Iterator localIterator = this.b.iterator();
    label125:
    if (localIterator.hasNext())
    {
      AsyncStep localAsyncStep = (AsyncStep)localIterator.next();
      if ((!"{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}".equals(localAsyncStep.b)) && (!localAsyncStep.b.equals(paramLinearGroup.b))) {
        break label243;
      }
      bool = false;
    }
    label243:
    for (;;)
    {
      break label125;
      break;
      if (!"{{4,3,5,6},40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52}".equals(paramLinearGroup.b)) {
        break;
      }
      localIterator = this.b.iterator();
      bool = true;
      if (localIterator.hasNext())
      {
        if ("{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}".equals(((AsyncStep)localIterator.next()).b)) {
          bool = false;
        }
        for (;;)
        {
          break;
        }
      }
      break;
    }
  }
  
  public int a()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    if (this.g) {
      return 1;
    }
    return -1;
  }
  
  public AsyncStep a(ArrayList paramArrayList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          AsyncStep localAsyncStep = (AsyncStep)paramArrayList.next();
          if (this.jdField_a_of_type_JavaUtilLinkedList.remove(localAsyncStep)) {
            return localAsyncStep;
          }
        }
      }
      return null;
    }
  }
  
  public CheckUpdateItemInterface a(int paramInt)
  {
    return (CheckUpdateItemInterface)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  protected Class a()
  {
    return AutomatorObserver.class;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.h -= 1;
      AsyncStep localAsyncStep = (AsyncStep)this.jdField_a_of_type_JavaUtilLinkedList.poll();
      if (localAsyncStep != null) {
        b(localAsyncStep);
      }
      return;
    }
  }
  
  public void a(int paramInt, CheckUpdateItemInterface paramCheckUpdateItemInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramCheckUpdateItemInterface);
  }
  
  public void a(AsyncStep arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "start " + ???.b);
    }
    LinearGroup localLinearGroup = (LinearGroup)???;
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = localLinearGroup;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "run " + localLinearGroup.b);
        }
        if (jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
          jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(0, 4, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24));
        }
        jdField_a_of_type_JavaUtilConcurrentExecutor.execute(this);
        return;
      }
      a(localLinearGroup);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    new RuntimeException("u should never be here");
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    boolean bool = false;
    if (paramLong != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), paramLong).commit();
    }
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramBoolean1)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFriendlistok", false).commit();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshAllList isListChanged=").append(paramBoolean1).append(",timeStamp=").append(paramLong).append(",accInfoPref!=null ");
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        bool = true;
      }
      QLog.d("QQInitHandler", 2, bool);
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      localStringBuilder = new StringBuilder().append("{");
      if (!paramBoolean1) {
        break label197;
      }
    }
    label197:
    for (int i = 7;; i = 8)
    {
      a(StepFactory.a(this, i + "}"));
      return;
    }
  }
  
  public boolean a()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    return true;
  }
  
  public void b()
  {
    a(0, true, null);
  }
  
  protected void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.h < 3)
      {
        this.h += 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramAsyncStep);
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramAsyncStep);
    }
  }
  
  public boolean b()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.b(localLinearGroup);
    }
    return true;
  }
  
  public void c()
  {
    if (!this.g) {}
    for (;;)
    {
      return;
      boolean bool1 = true;
      boolean bool2 = true;
      LinkedList localLinkedList;
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        localLinkedList = this.b;
        bool1 = bool2;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(4);
          bool1 = c();
        }
        if (!bool1) {
          continue;
        }
        a(StepFactory.a(this, "{[13,16],19,21,53,55,23,42,32,56,57}"));
        return;
      }
      finally {}
    }
  }
  
  public boolean c()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.c(localLinearGroup);
    }
    return true;
  }
  
  public void d()
  {
    a(StepFactory.a(this, "{15,18,21,53,55,24}"));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onDestroy");
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.h = 0;
    }
    synchronized (this.b)
    {
      this.b.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(8);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
      }
      this.jdField_a_of_type_Long = 0L;
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void f()
  {
    a(4, true, null);
  }
  
  public void run()
  {
    int i;
    if (!this.g) {
      i = 0;
    }
    for (;;)
    {
      synchronized (this.b)
      {
        if (!this.g)
        {
          i = 1;
          this.g = true;
        }
        if (i != 0) {
          StepFactory.a(this, "2").run();
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
        if (??? != null) {
          ((AsyncStep)???).run();
        }
      }
      synchronized (this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = ((LinearGroup)this.b.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
        {
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.Automator
 * JD-Core Version:    0.7.0.1
 */