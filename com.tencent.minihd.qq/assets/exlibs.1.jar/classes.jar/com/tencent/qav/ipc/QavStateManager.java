package com.tencent.qav.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.av.utils.UITools1;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.PhoneStatusMonitor;
import com.tencent.qav.session.QavSession.SessionStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ljl;
import ljm;
import ljn;
import ljo;
import mqq.manager.Manager;

public class QavStateManager
  implements IBinder.DeathRecipient, Manager
{
  public static final String a = "com.tencent.mobileqq:video";
  private static final String jdField_b_of_type_JavaLangString = "QavStateManager";
  private int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ljl(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IQavService jdField_a_of_type_ComTencentQavIpcIQavService;
  private QavState jdField_a_of_type_ComTencentQavIpcQavState;
  private PhoneStatusMonitor jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private ljn jdField_a_of_type_Ljn;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  public QavStateManager(QQAppInterface paramQQAppInterface)
  {
    this.b = new ArrayList();
    AVLog.d("QavStateManager", String.format("QavStateManager this=%s", new Object[] { this }));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a();
    c();
  }
  
  private void a()
  {
    AVLog.d("QavStateManager", String.format("bindQavService mQavService=%s mBinding=%s", new Object[] { this.jdField_a_of_type_ComTencentQavIpcIQavService, Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if ((this.jdField_a_of_type_ComTencentQavIpcIQavService == null) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
        this.jdField_a_of_type_AndroidContentServiceConnection = new ljo(this, null);
      }
      if (this.jdField_a_of_type_Ljn == null) {
        this.jdField_a_of_type_Ljn = new ljn(this, null);
      }
    }
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavService.class);
      this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 0);
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("QavStateManager", "bindQavService fail.", localException);
    }
  }
  
  private void a(int paramInt)
  {
    AVLog.d("QavStateManager", String.format("setSmallScreenState smallScreenState=%s", new Object[] { Integer.valueOf(paramInt) }));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(QavState paramQavState)
  {
    QavState localQavState = (QavState)this.jdField_a_of_type_JavaUtilMap.get(paramQavState.jdField_a_of_type_JavaLangString);
    if (localQavState == null)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramQavState.jdField_a_of_type_JavaLangString, paramQavState);
      if (this.jdField_a_of_type_ComTencentQavIpcQavState == null)
      {
        this.jdField_a_of_type_ComTencentQavIpcQavState = paramQavState;
        if (QLog.isColorLevel()) {
          QLog.d("QavStateManager", 2, "notifyStartVideoChat mActiveState = " + this.jdField_a_of_type_ComTencentQavIpcQavState.toString());
        }
        e();
      }
    }
    do
    {
      return;
      localQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = paramQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus;
    } while (localQavState != this.jdField_a_of_type_ComTencentQavIpcQavState);
    f();
  }
  
  private void b()
  {
    AVLog.d("QavStateManager", String.format("unbindQavService mQavService=%s", new Object[] { this.jdField_a_of_type_ComTencentQavIpcIQavService }));
    if (this.jdField_a_of_type_ComTencentQavIpcIQavService != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQavIpcIQavService.a(null);
      this.jdField_a_of_type_ComTencentQavIpcIQavService.asBinder().unlinkToDeath(this, 0);
      this.jdField_a_of_type_ComTencentQavIpcIQavService = null;
      if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentServiceConnection = null;
          return;
        }
        catch (Exception localException2)
        {
          AVLog.e("QavStateManager", "unbindQavService fail.", localException2);
        }
        localException1 = localException1;
        AVLog.e("QavStateManager", "unbindQavService fail.", localException1);
      }
    }
  }
  
  private void b(QavState paramQavState)
  {
    QavState localQavState = (QavState)this.jdField_a_of_type_JavaUtilMap.get(paramQavState.jdField_a_of_type_JavaLangString);
    if (localQavState != null)
    {
      localQavState.jdField_b_of_type_Long = paramQavState.jdField_b_of_type_Long;
      if (localQavState == this.jdField_a_of_type_ComTencentQavIpcQavState)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavStateManager", 2, "notifyUpdateVideoChat mActiveState = " + this.jdField_a_of_type_ComTencentQavIpcQavState.toString());
        }
        f();
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ljm(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("qav.Action.QavService.Start");
      localIntentFilter.addAction("tencent.video.v2q.SmallScreenState");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void c(QavState paramQavState)
  {
    QavState localQavState = (QavState)this.jdField_a_of_type_JavaUtilMap.get(paramQavState.jdField_a_of_type_JavaLangString);
    if (localQavState != null)
    {
      localQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = paramQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus;
      if (localQavState == this.jdField_a_of_type_ComTencentQavIpcQavState)
      {
        g();
        this.jdField_a_of_type_ComTencentQavIpcQavState = null;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(localQavState.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void d()
  {
    AVLog.d("QavStateManager", "unregisterQavServiceReceiver");
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QavStateManager.QavStateListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentQavIpcQavState);
    }
  }
  
  private void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QavStateManager.QavStateListener)localIterator.next()).b(this.jdField_a_of_type_ComTencentQavIpcQavState);
    }
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + this.b.size() == 0;
  }
  
  private void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QavStateManager.QavStateListener)localIterator.next()).c(this.jdField_a_of_type_ComTencentQavIpcQavState);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  private void i()
  {
    if ((f()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null) {
      return this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null) {
      l = this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_b_of_type_Long;
    }
    return l;
  }
  
  public QavSession.SessionStatus a()
  {
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null) {
      return this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus;
    }
    return QavSession.SessionStatus.NONE;
  }
  
  public String a()
  {
    String str2 = "00:00";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null)
    {
      long l = this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_b_of_type_Long;
      str1 = str2;
      if (l > 0L) {
        str1 = UITools1.a(l / 1000L);
      }
    }
    return str1;
  }
  
  public void a(QavStateManager.QavStateListener paramQavStateListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramQavStateListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentQavIpcQavState != null;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null) {
      return String.valueOf(this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_a_of_type_Long);
    }
    return "";
  }
  
  public void b(QavStateManager.QavStateListener paramQavStateListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramQavStateListener);
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null) {
      if ((this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus != QavSession.SessionStatus.CONNECTING) && (this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus != QavSession.SessionStatus.INVITING))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus != QavSession.SessionStatus.BE_INVITING) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void binderDied()
  {
    AVLog.e("QavStateManager", "binderDied");
    this.jdField_a_of_type_ComTencentQavIpcIQavService = null;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null) {
      bool = this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_a_of_type_Boolean;
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentQavIpcQavState != null) {
      bool = this.jdField_a_of_type_ComTencentQavIpcQavState.jdField_b_of_type_Boolean;
    }
    return bool;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor != null) {
      return this.jdField_a_of_type_ComTencentQavMonitorPhoneStatusMonitor.a();
    }
    return false;
  }
  
  public void onDestroy()
  {
    AVLog.e("QavStateManager", String.format("onDestroy this=%s", new Object[] { this }));
    b();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.QavStateManager
 * JD-Core Version:    0.7.0.1
 */