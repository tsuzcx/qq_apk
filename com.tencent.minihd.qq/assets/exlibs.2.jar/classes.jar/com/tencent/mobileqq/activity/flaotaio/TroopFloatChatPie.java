package com.tencent.mobileqq.activity.flaotaio;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import gmz;
import gnb;
import gnc;
import gne;
import gnf;
import gng;
import gnh;
import gni;
import java.util.ArrayList;
import java.util.Observable;

public class TroopFloatChatPie
  extends BaseFloatChatPie
{
  static final int e = 1;
  private FloatTroopAioNavBar jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new gnf(this);
  protected MessageObserver a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gnc(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new gng(this);
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new gnh(this);
  private Handler b;
  protected boolean c;
  protected boolean d;
  
  public TroopFloatChatPie(QQAppInterface paramQQAppInterface, FloatAioPage paramFloatAioPage)
  {
    super(paramQQAppInterface, paramFloatAioPage);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler = new gne(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gni(this);
  }
  
  private void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      TroopGagMgr.SelfGagInfo localSelfGagInfo = paramSelfGagInfo;
      if (paramSelfGagInfo == null) {
        localSelfGagInfo = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean);
      }
      if (!localSelfGagInfo.jdField_a_of_type_Boolean) {
        break label116;
      }
      if ((!f()) && (!e()))
      {
        v();
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(localSelfGagInfo.b);
        }
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, localSelfGagInfo.jdField_a_of_type_Long * 1000L);
      }
    }
    else
    {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    return;
    label116:
    this.jdField_d_of_type_Boolean = false;
    w();
  }
  
  private void x()
  {
    a(false);
    if (this.c)
    {
      HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localHotChatInfo != null) && (localHotChatInfo.state == 1)) {
        HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo);
      }
    }
  }
  
  private void y()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      return;
      localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (((TroopInfo)localObject).wMemberNum != 0));
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a((ArrayList)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("msg_navigate_type", paramInt);
    localIntent.putExtra("msg_uni_seq", paramLong);
    e(localIntent);
    s();
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_d_of_type_Boolean)
    {
      c(false);
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363814, 0).a();
      }
      v();
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    if (a(true)) {
      return;
    }
    super.b();
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.c = false;
    if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
      {
        paramIntent = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
        }
      }
      return;
    }
  }
  
  protected void d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      return;
      r();
    }
  }
  
  public void i()
  {
    super.i();
    x();
  }
  
  protected void j()
  {
    super.j();
    u();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void n()
  {
    super.n();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void onClick(View paramView)
  {
    if (a(true)) {
      return;
    }
    super.onClick(paramView);
  }
  
  protected void r()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (this.c)
    {
      if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
  }
  
  public void t()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar.b();
    }
    super.t();
  }
  
  protected void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar = new FloatTroopAioNavBar();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar.d();
      ThreadManager.b(new gmz(this));
      FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      boolean bool = localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((TroopRemindSettingManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!bool)) {
        TroopRemindSettingManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (bool) {
        localFriendManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      y();
      ThreadManager.b(new gnb(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTroopAioNavBar.b();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof TroopAioAgent.Message))
    {
      paramObservable = (TroopAioAgent.Message)paramObject;
      if ((paramObservable != null) && (paramObservable.jdField_a_of_type_Int == TroopAioAgent.jdField_a_of_type_Int)) {
        a(paramObservable.c, paramObservable.b);
      }
    }
  }
  
  protected void v()
  {
    if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != null)) {
      e(2);
    }
  }
  
  protected void w()
  {
    if (this.jdField_a_of_type_Int == 2) {
      e(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.TroopFloatChatPie
 * JD-Core Version:    0.7.0.1
 */