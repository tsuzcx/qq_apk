package com.tencent.qav.app;

import android.os.Bundle;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qav.QavSDK;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.channel.VideoChannelImpl;
import com.tencent.qav.channel.VideoChannelServlet;
import com.tencent.qav.monitor.AccountMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import liu;

public class QavAppInterface
  extends AppInterface
{
  private static final String b = "QavAppInterface";
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
  private AccountMonitor jdField_a_of_type_ComTencentQavMonitorAccountMonitor;
  
  public QavAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private void a()
  {
    VideoChannelImpl localVideoChannelImpl = VideoChannelImpl.a();
    localVideoChannelImpl.a(this);
    QavSDK.getInstance().initSDK(a(), Long.valueOf(a()).longValue(), localVideoChannelImpl);
  }
  
  public int a()
  {
    return AppSetting.a();
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(paramString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { VideoChannelServlet.class };
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ThreadManager.b(new liu(this));
    a();
    this.jdField_a_of_type_ComTencentQavMonitorAccountMonitor = new AccountMonitor(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QavBussinessCtrl.a().a();
    SmallScreenUtils.a(a());
    if (this.jdField_a_of_type_ComTencentQavMonitorAccountMonitor != null)
    {
      this.jdField_a_of_type_ComTencentQavMonitorAccountMonitor.a();
      this.jdField_a_of_type_ComTencentQavMonitorAccountMonitor = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.app.QavAppInterface
 * JD-Core Version:    0.7.0.1
 */