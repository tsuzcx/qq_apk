package com.tencent.mobileqq.app.lbs;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hse;
import hsf;
import mqq.manager.Manager;

public class LbsInfoMgr
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "LbsInfoMgr";
  public static final int b = 900000;
  public static final int c = 3600000;
  public int a;
  public long a;
  private BizTroopHandler jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler;
  public BizTroopObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LbsInfoMgr.LocationInfo jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo;
  
  public LbsInfoMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 900000;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new hsf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)paramQQAppInterface.a(21));
    this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo = new LbsInfoMgr.LocationInfo();
  }
  
  private void c()
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("LbsInfoMgr", 2, "start  reportLbsInfoToServer");
      }
      b();
    }
  }
  
  public LbsInfoMgr.LocationInfo a()
  {
    if ((a()) && (b()))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.i("LbsInfoMgr", 2, "isApplicationShowing True, Check timeSpan");
      }
      if (l1 - l2 >= this.jdField_a_of_type_Int) {
        b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("LbsInfoMgr", 2, "getSeltLocation:  + latitude: " + this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo.b + " longitude: " + this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppLbsLbsInfoMgr$LocationInfo;
  }
  
  public void a()
  {
    if (a()) {
      c();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localTroopInfoManager != null) {
        return localTroopInfoManager.c();
      }
    }
    return false;
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    ThreadManager.a(new hse(this));
  }
  
  public boolean b()
  {
    long l1 = System.currentTimeMillis();
    Context localContext = BaseApplication.getContext();
    if (!((PowerManager)localContext.getSystemService("power")).isScreenOn()) {
      return false;
    }
    if (((KeyguardManager)localContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("LbsInfoMgr", 2, "isApplicationShowing time cost " + (l2 - l1));
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.lbs.LbsInfoMgr
 * JD-Core Version:    0.7.0.1
 */