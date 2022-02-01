package com.tencent.av.ui;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bzg;
import bzj;
import bzk;
import bzl;
import bzo;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qav.QavSDK;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  private static final String jdField_a_of_type_JavaLangString = "DoubleVideoCtrlUI";
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private bzl jdField_a_of_type_Bzl = new bzl(this);
  private bzo jdField_a_of_type_Bzo = new bzo(this);
  AutoBgImageView jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
  private QavBussinessObserver jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver = new bzg(this);
  public boolean a;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  AutoBgImageView jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView;
  AutoBgImageView c;
  
  public DoubleVideoCtrlUI(QavAppInterface paramQavAppInterface, BaseActivity paramBaseActivity, ViewGroup paramViewGroup, VideoControlUI.ConnectInfo paramConnectInfo)
  {
    super(paramQavAppInterface, paramBaseActivity, paramViewGroup, paramConnectInfo);
    this.jdField_a_of_type_Boolean = false;
    QavSDK.getInstance().addObserver(this.jdField_a_of_type_Bzl);
    QavSDK.getInstance().addObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
  }
  
  private void a(boolean paramBoolean) {}
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramBoolean1) || (paramBoolean2))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!paramBoolean1)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setBackgroundResource(2130838851);
        if (!paramBoolean3) {
          break label177;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
      }
    }
    for (;;)
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setBackgroundResource(2130838848);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setBackgroundResource(2130838851);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel.b) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
      break;
      label177:
      if (paramBoolean4)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      while (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) || (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("DoubleVideoCtrlUI", 1, "updateHeadAndName");
      }
      Handler localHandler = QavChatHandler.a().a();
      localHandler.removeCallbacks(this.jdField_a_of_type_Bzo);
      localHandler.post(this.jdField_a_of_type_Bzo);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    QavChatHandler.a().b().post(new bzj(this, paramBoolean));
  }
  
  private void d(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      paramView = QavBussinessCtrl.a().a();
      if (paramView != null) {
        if (paramView.f) {
          break label39;
        }
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      return;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    QavChatHandler.a().b().post(new bzk(this, paramBoolean));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel.b)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.c();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
  }
  
  private void g()
  {
    QavBussinessCtrl localQavBussinessCtrl = QavBussinessCtrl.a();
    if (localQavBussinessCtrl != null)
    {
      localQavBussinessCtrl.b(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a(), 0);
      QavBussinessCtrl.a().b(false);
    }
  }
  
  private void h()
  {
    Object localObject = QavBussinessCtrl.a();
    if (localObject != null) {
      if (((QavBussinessCtrl)localObject).a() != 0) {
        break label46;
      }
    }
    label46:
    for (int i = 1;; i = 0)
    {
      ((QavBussinessCtrl)localObject).a(i);
      localObject = ((QavBussinessCtrl)localObject).a();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131298312, ((QavSession)localObject).d);
      }
      return;
    }
  }
  
  private void i()
  {
    QavSession localQavSession = QavBussinessCtrl.a().a();
    if (localQavSession != null)
    {
      boolean bool = localQavSession.e;
      QavBussinessCtrl.a().b(bool);
      if (!bool) {
        super.a(2131298310);
      }
    }
    else
    {
      return;
    }
    super.b(2131298310);
  }
  
  private void j()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298450));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298451));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298452));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298446));
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298453));
    QavBussinessCtrl.a().a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298341));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298342));
  }
  
  protected int a()
  {
    return 2130903461;
  }
  
  public void a()
  {
    super.a();
    c();
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    b(false);
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      QLog.d("DoubleVideoCtrlUI", 1, "onClick mQavPanel == null");
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof QavChatActivity)));
      a();
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131298310: 
        b(paramLong, paramView);
        return;
      case 2131298439: 
        QLog.d("DoubleVideoCtrlUI", 1, "onClick Hangup ");
        g();
        return;
      case 2131298312: 
        QLog.d("DoubleVideoCtrlUI", 1, "onClick QavPanel.ViewID.HAND_FREE ");
        h();
        return;
      case 2131298339: 
        QLog.d("DoubleVideoCtrlUI", 1, "onClick HIDE ");
        a();
        return;
      case 2131298446: 
        paramView = a();
      }
    } while (paramView == null);
    paramView.a();
    return;
    d(paramLong, paramView);
    return;
    f();
  }
  
  public boolean a()
  {
    if (super.a())
    {
      QLog.d("DoubleVideoCtrlUI", 2, "onBackPressed called return 2");
      return true;
    }
    Object localObject = a();
    QavSession localQavSession = QavBussinessCtrl.a().a();
    boolean bool = false;
    if (localQavSession == null) {
      bool = true;
    }
    for (;;)
    {
      QavBussinessCtrl.a().c(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a(), bool);
      if (localObject == null) {
        break;
      }
      localObject = ((QavChatActivity)localObject).a();
      if (localObject == null) {
        break;
      }
      ((SmallScreenActivityPlugin)localObject).a();
      return true;
      if (localQavSession.f()) {
        bool = true;
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
    }
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
  }
  
  void b(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView)) {
      i();
    }
  }
  
  void c()
  {
    boolean bool2 = true;
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoCtrlUI", 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    super.c();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298375));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298295));
    j();
    k();
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298376));
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b()) {
        break label161;
      }
    }
    label161:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QavPanel)localObject).a(2130903474, false, bool1);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveEnable(true);
      localObject = QavBussinessCtrl.a().a();
      if (localObject == null) {
        break;
      }
      a(((QavSession)localObject).f, ((QavSession)localObject).h, ((QavSession)localObject).d(), ((QavSession)localObject).c);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b())
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b()) {
        break label208;
      }
    }
    for (;;)
    {
      a(bool1, bool2, false, this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b());
      return;
      bool1 = false;
      break;
      label208:
      bool2 = false;
    }
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_Bzl);
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
  }
  
  void c(long paramLong, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */