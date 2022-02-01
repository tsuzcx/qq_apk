package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FriendFreqGrayTips;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.servlet.ReduFriendObserver;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import gae;
import gaf;
import gag;
import gaj;
import gak;
import gal;
import gam;
import gan;
import java.util.Observable;

public class FriendChatPie
  extends BaseChatPie
{
  public FriendHotTipsBar a;
  private GatherContactsTips jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips = null;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gan(this);
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new gal(this);
  protected VipGifObserver a;
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new gak(this);
  Runnable b;
  protected MessageObserver c;
  Runnable c;
  private boolean o = false;
  private boolean p = false;
  private boolean q = true;
  
  public FriendChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_b_of_type_JavaLangRunnable = new gae(this);
    this.jdField_c_of_type_JavaLangRunnable = new gaf(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new gaj(this);
    this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver = new gam(this);
  }
  
  private void a(long paramLong)
  {
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(a())) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
      localVipGiftManager.a(localVipGiftDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
  }
  
  protected void C()
  {
    super.C();
  }
  
  protected void H()
  {
    super.H();
    if ((this.p) && ("schemeconfirm".equals(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type")))) {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  protected void O()
  {
    StartupTracker.a(null, "AIO_onShow_business");
    super.O();
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.p = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.o = WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_onShow_business", null);
  }
  
  protected void P()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    if (this.q)
    {
      this.q = false;
      ThreadManager.b(this.jdField_c_of_type_JavaLangRunnable);
    }
    super.P();
  }
  
  protected void T()
  {
    super.T();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
  }
  
  protected void U()
  {
    super.U();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
  }
  
  protected void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {}
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    super.a(paramEmoticonInfo);
    if (this.o)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.o);
      this.o = false;
    }
  }
  
  protected boolean a()
  {
    return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void b()
  {
    super.b();
    if (this.o)
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.o);
      this.o = false;
    }
  }
  
  protected boolean d()
  {
    if ((this.p) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")))
    {
      WpaThirdAppStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return true;
    }
    return super.d();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.a = 0L;
  }
  
  protected boolean f()
  {
    return (!this.p) || (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm"));
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFriendHotTipsBar = new FriendHotTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    FriendFreqGrayTips localFriendFreqGrayTips = new FriendFreqGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips = new GatherContactsTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFriendHotTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localFriendFreqGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips);
  }
  
  protected void h(Intent paramIntent)
  {
    super.h(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.a();
    }
  }
  
  protected void j()
  {
    if (this.jdField_b_of_type_Boolean) {
      s();
    }
  }
  
  protected void l()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new gag(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131366081));
  }
  
  protected void u()
  {
    super.u();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGatherContactsTips.b()))) {
      ThreadManager.b(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageForStructing)) && (!((MessageForStructing)paramObject).isread))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramObject;
      if ((localMessageForStructing == null) || (localMessageForStructing.structingMsg == null) || (localMessageForStructing.structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(localMessageForStructing.structingMsg.mResid)) || (!((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72)).a(localMessageForStructing))) {}
    }
    super.update(paramObservable, paramObject);
  }
  
  protected void y()
  {
    super.y();
  }
  
  protected void z()
  {
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie
 * JD-Core Version:    0.7.0.1
 */