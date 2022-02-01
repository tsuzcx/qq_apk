package com.tencent.mobileqq.vas;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import mqq.manager.Manager;

public class AvatarPendantManager
  implements Manager
{
  public static final String a;
  public static volatile boolean b;
  public long a;
  protected AppInterface a;
  protected AvatarPendantManager.PendantInfoLruCache a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AvatarPendantManager.class.getSimpleName();
  }
  
  public AvatarPendantManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache = new AvatarPendantManager.PendantInfoLruCache(this, 10);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PendantInfo a(long paramLong)
  {
    PendantInfo localPendantInfo2 = (PendantInfo)this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.get(Long.valueOf(paramLong));
    PendantInfo localPendantInfo1;
    if (localPendantInfo2 != null)
    {
      localPendantInfo1 = localPendantInfo2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getPendantInfo pendantId=" + paramLong + " from cache");
        localPendantInfo1 = localPendantInfo2;
      }
    }
    for (;;)
    {
      localPendantInfo1.a(this.jdField_a_of_type_Boolean);
      return localPendantInfo1;
      localPendantInfo1 = new PendantInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.put(Long.valueOf(paramLong), localPendantInfo1);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).a(true);
    }
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Long != paramLong;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).a(false);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.clear();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarPendantManager
 * JD-Core Version:    0.7.0.1
 */