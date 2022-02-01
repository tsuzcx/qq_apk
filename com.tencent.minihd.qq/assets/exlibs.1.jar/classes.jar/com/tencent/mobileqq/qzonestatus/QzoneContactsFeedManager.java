package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import java.util.ArrayList;
import jqa;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class QzoneContactsFeedManager
  implements Manager
{
  private static int jdField_a_of_type_Int = -1;
  static final String jdField_a_of_type_JavaLangString = "last_request_time";
  private static int jdField_b_of_type_Int = 0;
  static final String jdField_b_of_type_JavaLangString = "last_attach_info";
  private static int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "QzoneContactsFeedManager";
  private static int jdField_d_of_type_Int = -1;
  private static final int e = 0;
  private static final int f = 1;
  private static final int g = 2;
  private static final int h = 3;
  private long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private String jdField_d_of_type_JavaLangString;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  
  static
  {
    b = -1;
    c = -1;
  }
  
  public QzoneContactsFeedManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private SharedPreferences a()
  {
    String str = SecurityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) + "GetQZoneFeeds";
    return BaseApplication.getContext().getSharedPreferences(str, 0);
  }
  
  private void a(ArrayList paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramInt >= paramArrayList.size()))
    {
      e();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "refreshAllInner(" + paramInt + ")...");
    }
    int n = c() + paramInt;
    int m = n;
    if (n >= paramArrayList.size()) {
      m = paramArrayList.size();
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QzoneContactsFeedServlet.class);
    paramArrayList = new ArrayList(paramArrayList.subList(paramInt, m));
    QzoneContactsFeedUtils.a(localNewIntent, QzoneContactsFeedUtils.a(1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), paramArrayList, 0L, null));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  @TargetApi(9)
  private void b(long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putLong("last_request_time", paramLong);
    localEditor.putString("last_attach_info", paramString);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  private static int c()
  {
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = QzoneConfig.a().a("QZoneSetting", "NewestFeedsUinNum", 100);
    }
    return jdField_a_of_type_Int;
  }
  
  private static int d()
  {
    if (b < 0) {
      b = QzoneConfig.a().a("QZoneSetting", "NewestFeedsRetryNum", 2);
    }
    return b;
  }
  
  private static int e()
  {
    if (c < 0)
    {
      c = QzoneConfig.a().a("QZoneSetting", "NewestFeedsMinTimeCell", 900);
      c *= 1000;
    }
    return c;
  }
  
  private static int f()
  {
    if (jdField_d_of_type_Int < 0)
    {
      jdField_d_of_type_Int = QzoneConfig.a().a("QZoneSetting", "NewestFeedsMinRefreshTimeCell", 604800);
      jdField_d_of_type_Int *= 1000;
    }
    return jdField_d_of_type_Int;
  }
  
  public long a()
  {
    return a().getLong("last_request_time", 0L);
  }
  
  public String a()
  {
    return a().getString("last_attach_info", "");
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!GetQZoneFeeds.b) {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedManager", 2, "GetQZoneFeeds 此step尚未执行，此次调用就此返回，等待自动机中GetQZoneFeeds执行此方法");
      }
    }
    while (!NetworkUtil.f(BaseApplication.getContext())) {
      return;
    }
    ThreadManager.b().post(new jqa(this));
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateFriend(" + this.i + ")...");
    }
    if (this.i != 0) {
      return;
    }
    this.i = 3;
    this.j = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
    a(this.jdField_a_of_type_JavaUtilArrayList, this.j);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateAll(" + this.i + ")...");
    }
    if (this.i != 0) {
      return;
    }
    this.i = 2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_d_of_type_JavaLangString = paramString;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QzoneContactsFeedServlet.class);
    QzoneContactsFeedUtils.a(localNewIntent, QzoneContactsFeedUtils.a(2, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), null, paramLong, paramString));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (paramnewest_feeds_rsp == null) {}
    while ((this.i == 3) || (((this.i != 1) || (this.j != 0)) && (this.i != 2))) {
      return;
    }
    b(paramnewest_feeds_rsp.last_feed_time, paramnewest_feeds_rsp.str_attach);
  }
  
  public void b()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "refreshAll(" + this.i + ")...");
    }
    if (this.i != 0) {
      return;
    }
    this.i = 1;
    this.j = 0;
    this.jdField_a_of_type_JavaUtilArrayList = QzoneContactsFeedUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      StringBuilder localStringBuilder = new StringBuilder().append("allFriends.size:");
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        m = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      QLog.d("QzoneContactsFeedManager", 2, m + ",getAllFreindsCount:" + localFriendsManager.c());
    }
    a(this.jdField_a_of_type_JavaUtilArrayList, this.j);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "retry(" + this.k + ")...");
    }
    this.k += 1;
    if (this.k >= d())
    {
      this.k = 0;
      if (this.i == 1) {
        b(0L, null);
      }
      d();
      return;
    }
    if ((this.i == 1) || (this.i == 3))
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, this.j);
      return;
    }
    if (this.i == 2)
    {
      this.i = 0;
      a(this.jdField_a_of_type_Long, this.jdField_d_of_type_JavaLangString);
      return;
    }
    e();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "doNextRequest(" + this.j + ")...");
    }
    if ((this.i != 1) && (this.i != 3))
    {
      e();
      return;
    }
    this.j += c();
    a(this.jdField_a_of_type_JavaUtilArrayList, this.j);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "close...");
    }
    this.i = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.j = 0;
    this.k = 0;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "onDestroy...");
    }
    e();
    GetQZoneFeeds.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager
 * JD-Core Version:    0.7.0.1
 */