package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.WindowManager;
import bzf;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.QavSDK;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qav.activity.QavInviteActivity;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SmallScreenVideoController
{
  static final String jdField_a_of_type_JavaLangString = "SmallScreenVideoController";
  Context jdField_a_of_type_AndroidContentContext = null;
  Display jdField_a_of_type_AndroidViewDisplay = null;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  public SmallScreenVideoControlUI a;
  public SmallScreenVideoLayerUI a;
  public QavAppInterface a;
  QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
  private QavBussinessObserver jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver = new bzf(this);
  public QavSession a;
  boolean jdField_a_of_type_Boolean = false;
  
  SmallScreenVideoController(SmallScreenService paramSmallScreenService)
  {
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_AndroidContentContext = paramSmallScreenService.getApplicationContext();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getSystemService("window")).getDefaultDisplay();
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenVideoControlUI(this.jdField_a_of_type_ComTencentQavAppQavAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a();
    }
    GLRootView localGLRootView = (GLRootView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131298330);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI = new SmallScreenVideoLayerUI(this.jdField_a_of_type_AndroidContentContext);
    localGLRootView.setContentPane(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI);
    long l = BaseApplicationImpl.a.a().getLongAccountUin();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(String.valueOf(l), String.valueOf(this.jdField_a_of_type_ComTencentQavSessionQavSession.jdField_a_of_type_Long));
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
    }
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
  }
  
  void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QavAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onCreate");
      }
      this.jdField_a_of_type_ComTencentQavAppQavAppInterface = ((QavAppInterface)paramAppRuntime);
      this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = QavBussinessCtrl.a();
      QavSDK.getInstance().addObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
      this.jdField_a_of_type_ComTencentQavSessionQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      a();
    }
  }
  
  public void b()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onStart(), ts=" + l1);
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onStart(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void c()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onResume(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.d();
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
    }
  }
  
  void f()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 8))
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
      return;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
  }
  
  void g()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick start");
    }
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
    int i;
    Intent localIntent;
    if (localQavSession != null)
    {
      i = localQavSession.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onClick sessionType =" + i);
      }
      if ((localQavSession.d()) && ((i == 1) || (i == 2)))
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavChatActivity.class);
        localIntent.addFlags(262144);
        localIntent.addFlags(268435456);
        localIntent.addFlags(4194304);
        localIntent.putExtra("key_peer_uin", String.valueOf(localQavSession.jdField_a_of_type_Long));
        localIntent.putExtra("key_only_audio", localQavSession.jdField_c_of_type_Boolean);
        localIntent.putExtra("key_is_receiver", localQavSession.b);
        localIntent.putExtra("sessionType", i);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        localIntent.putExtra("Fromwhere", "SmallScreen");
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "onClick end");
        }
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException);
        continue;
      }
      long l = localException.jdField_a_of_type_Long;
      int j = localException.jdField_c_of_type_Int;
      if (l != 0L)
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavInviteActivity.class);
        localIntent.addFlags(268435456);
        localIntent.putExtra("key_peer_uin", String.valueOf(localException.jdField_a_of_type_Long));
        if (i == 1) {}
        for (;;)
        {
          localIntent.putExtra("key_only_audio", bool);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          AVLog.d("SmallScreenVideoController", "onRequestVideo start QavInviteActivity");
          break;
          bool = false;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.e("SmallScreenVideoController", 2, "onClick status error");
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenVideoController", 2, "onClick app is null");
        }
      }
    }
  }
  
  void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController
 * JD-Core Version:    0.7.0.1
 */