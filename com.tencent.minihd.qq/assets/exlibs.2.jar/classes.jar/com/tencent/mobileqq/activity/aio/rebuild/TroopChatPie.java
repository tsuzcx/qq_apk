package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.RedPacketShower;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XPanelContainer;
import cooperation.troop.TroopProxyActivity;
import gcc;
import gcd;
import gce;
import gcf;
import gcg;
import gci;
import gcj;
import gck;
import gcl;
import gcm;
import gco;
import gcp;
import gcq;
import gcr;
import gcs;
import gct;
import gcu;
import gcv;
import gcw;
import gcx;
import gcy;
import gdc;
import gdd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.BasePadActivity;

public class TroopChatPie
  extends BaseChatPie
{
  public static final String K = "abp_flag";
  public static final String L = "is_from_web";
  private static final String M = "TroopChatPie";
  static final int cf = 1;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private ViewTreeObserver jdField_a_of_type_AndroidViewViewTreeObserver;
  protected Button a;
  AnonymousChatHelper.AnonymousStatusListener jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener;
  public QQAnonymousDialog a;
  private TroopCardAppInfoHelper.IGetAppInfoCB jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new gce(this);
  private TroopCardAppInfoHelper jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper;
  private TroopAssistTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new gcd(this);
  protected MessageObserver a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gcy(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new gcf(this);
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new gcl(this);
  public TroopFeedsCenterLogic a;
  private VideoPlayLogic jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  private FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private Handler jdField_b_of_type_AndroidOsHandler;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  Runnable jdField_b_of_type_JavaLangRunnable = new gcv(this);
  private Handler jdField_c_of_type_AndroidOsHandler = new gdc(this, Looper.getMainLooper());
  private Runnable jdField_c_of_type_JavaLangRunnable;
  public View d;
  private SpannableString jdField_e_of_type_AndroidTextSpannableString;
  View jdField_e_of_type_AndroidViewView;
  private SpannableString f;
  public View f;
  public boolean o = false;
  protected boolean p;
  protected boolean q = false;
  protected boolean r = false;
  public boolean s = false;
  public boolean t = false;
  private boolean u = false;
  private boolean v;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gct(this);
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new gcw(this));
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
        break label150;
      }
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (2 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_e_of_type_Int != 1) || (this.i != 0)))
      {
        ad();
        if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(localSelfGagInfo.b);
        }
        this.jdField_c_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, localSelfGagInfo.jdField_a_of_type_Long * 1000L);
      }
    }
    else
    {
      return;
    }
    this.r = true;
    return;
    label150:
    this.r = false;
    ae();
  }
  
  private void ai()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.a(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  private void aj() {}
  
  private void ak()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      localObject = new gdd(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (TroopFileError.TroopFileErrorFilter)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    if (!this.p) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366369));
    }
    for (;;)
    {
      b(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b();
      }
      if (this.p)
      {
        localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((HotChatInfo)localObject).state == 1)) {
          HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (HotChatInfo)localObject);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369516));
    }
  }
  
  private void al()
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
      for (;;)
      {
        return;
        localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((TroopInfo)localObject).wMemberNum == 0)) {
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l));
            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d("TroopChatPie", 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopChatPie", 2, "getTroopInfoIfNeed failed");
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "handleTroopNotificationMsg");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.o);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ThreadManager.b(new gcj(this));
    }
  }
  
  private void an()
  {
    gck localgck = new gck(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localgck, 1000L);
  }
  
  private void ao()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, null, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopChatPie", 2, localException.toString());
    }
  }
  
  private void ap()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground() != null) {
      i();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundResource(2130841717);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(super.c());
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841082);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130841709);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427931));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838414);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427927));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842093);
    if (!this.p) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839426);
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(false);
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      AnonymousChatHelper.a().b();
      ah();
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(null);
        this.jdField_a_of_type_AndroidWidgetEditText.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427526));
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return;
      a(false);
    }
  }
  
  private void aq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "handleGrayTipsMsg");
    }
    TroopTipsMsgMgr localTroopTipsMsgMgr = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
    if (localTroopTipsMsgMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!localTroopTipsMsgMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "troopAIO has unread troopTipMsg");
    }
    ThreadManager.b(new gcs(this, localTroopTipsMsgMgr));
  }
  
  protected void A()
  {
    super.A();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a();
    }
    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      if (l >= 1000L) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "Stay_open_group", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + (l / 1000L + 1L), "", "");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
    }
  }
  
  protected void B()
  {
    super.B();
    if (this.o)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundResource(2130839444);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
    }
  }
  
  protected void C()
  {
    super.C();
    ak();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.q = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      if (this.q)
      {
        d(true);
        gcu localgcu = new gcu(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, localgcu);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
  }
  
  protected void D()
  {
    super.D();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.d();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      String str = localIntent.getStringExtra("uin");
      int i = localIntent.getIntExtra("uintype", -1);
      if ((!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i)) {}
      for (i = 1; (i != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null); i = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.c();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
        return;
      }
    }
  }
  
  protected void H()
  {
    if (this.s)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HotChatListActivity.class);
      localIntent.putExtra("abp_flag", this.s);
      localIntent.setFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      return;
    }
    super.H();
  }
  
  protected void Q()
  {
    super.Q();
    af();
    TroopInfo localTroopInfo = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L)) {
      a(0L, 0L);
    }
  }
  
  protected void R()
  {
    super.R();
    if (this.jdField_e_of_type_Int == 1) {}
    label68:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_e_of_type_Int != 2) {
              break label68;
            }
            if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
              break;
            }
          } while (!this.o);
          this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839440);
          return;
        } while (!this.o);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839452);
        return;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
          break;
        }
      } while (!this.o);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839440);
      return;
    } while (!this.o);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839452);
  }
  
  public void T()
  {
    super.T();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void U()
  {
    super.U();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 2)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903288, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight(), this.jdField_d_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      if (this.o) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.o);
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    return super.a(paramInt);
  }
  
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.minihd.qq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(i + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(false);
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()) && (TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      Bundle localBundle = paramIntent.getExtras();
      Object localObject = Boolean.valueOf(false);
      String str = "";
      if (localBundle.containsKey("TroopFile_DeleteFile")) {
        localObject = Boolean.valueOf(localBundle.getBoolean("TroopFile_DeleteFile"));
      }
      if (localBundle.containsKey("TroopFile_FileName")) {
        str = localBundle.getString("TroopFile_FileName");
      }
      if (((Boolean)localObject).booleanValue())
      {
        localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363383), new Object[] { TroopFileUtils.a(str) });
        TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject);
        continue;
        localObject = paramIntent.getExtras().getString("member_uin");
        if (a((String)localObject, paramIntent.getExtras().getString("member_display_name"), true)) {
          if ((localObject != null) && (((String)localObject).equalsIgnoreCase("0")))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            continue;
            if ((paramInt2 == 8001) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)) {
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
            }
          }
        }
      }
    }
  }
  
  void a(int paramInt, long paramLong)
  {
    long l2 = 0L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    long l1 = l2;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
      } while (MsgProxyUtils.n(((ChatMessage)localObject2).msgtype));
      l1 = ((ChatMessage)localObject2).shmsgseq;
    }
    localObject1 = new gcx(this);
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == 9) {
      i = 1;
    }
    if ((paramInt == 1) && (i == 0)) {
      if ((int)l1 > 1L + paramLong)
      {
        if (l1 - paramLong <= 200L) {
          break label373;
        }
        paramLong = l1 - 200L;
      }
    }
    label373:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg", 4, "***===getNavigateType = " + paramInt);
          }
        }
        return;
        if ((i == 0) && ((paramInt == 5) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
          if ((localObject2 != null) && (l1 - ((MessageRecord)localObject2).shmsgseq <= 200L)) {
            if ((int)l1 > ((MessageRecord)localObject2).shmsgseq + 1L)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, ((MessageRecord)localObject2).shmsgseq, false);
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
            }
            else
            {
              paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)localObject2);
              if (paramInt != -1) {
                this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt, paramInt, null);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog == null) {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = new QQAnonymousDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.show();
    if ((paramInt == 1) || (paramInt == 3)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gcr(this), 1000L);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    if ((this.o) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      f(false);
    }
    for (;;)
    {
      if ((this.o) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364042) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      }
      super.a(paramIntent);
      if (this.o)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297028).setVisibility(8);
      }
      return;
      if ((!this.o) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        f(true);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundResource(2130839444);
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130839444);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (((i == 2) || (i == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramConfiguration);
    }
    super.a(paramConfiguration);
  }
  
  protected void a(QQMessageFacade.Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c())) {}
    while (((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b())) || (this.p)) {
      return;
    }
    super.a(paramMessage);
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    if ((this.p) && (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramCharSequence = new ArrayList();
      paramCharSequence = AtTroopMemberSpan.a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), paramCharSequence);
    }
    super.a(paramCharSequence);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364011, new Object[] { Long.valueOf(paramLong) });
    if (this.o)
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramString;
      return;
    }
    a(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.o)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 19.0F);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPie", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_c_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
        if (!this.q)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        this.q = false;
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      if (!this.q)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      this.q = false;
      return true;
    }
    d(false);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return false;
      } while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
      if (paramBoolean)
      {
        j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().delete(j - 1, j);
      }
      FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if ((!localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.p)) {
        break;
      }
      paramBoolean = true;
      paramString1 = AtTroopMemberSpan.a((QQAppInterface)localObject, localBaseActivity, str, paramString1, paramString2, paramBoolean, this.jdField_a_of_type_AndroidWidgetEditText);
    } while ((paramString1 == null) || (paramString1.length() == 0));
    j(0);
    int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    if (j < 0) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().insert(i, paramString1);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return true;
      paramBoolean = false;
      break;
      i = j;
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    aj();
    return true;
  }
  
  protected void ad()
  {
    if ((this.jdField_e_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != null)) {
      j(2);
    }
  }
  
  protected void ae()
  {
    if (this.jdField_e_of_type_Int == 2) {
      j(0);
    }
  }
  
  protected void af()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = new TroopAioTips();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsRedPacketShower != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsRedPacketShower.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.g();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
      ThreadManager.b(new gcg(this));
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().containsKey("forward_type")) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin")))) {
        break label414;
      }
      i = 1;
      label147:
      FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      boolean bool = localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((TroopRemindSettingManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!bool))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366062), 3000L);
        TroopRemindSettingManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (bool) {
        localFriendManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3) && (!bool)) {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366061), 3000L);
      }
      al();
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && ((this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 9)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d();
      }
      am();
      aq();
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) != null) {
        break label419;
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB);
    }
    for (;;)
    {
      ThreadManager.b(new gci(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
      break;
      label414:
      i = 0;
      break label147;
      label419:
      if (-1 == ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).intValue())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.c(true);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.c(false);
      }
    }
  }
  
  public void ag()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new gco(this));
    this.jdField_f_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void ah()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new gcq(this));
    this.jdField_f_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void b()
  {
    if (b(true)) {
      return;
    }
    super.b();
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      return;
      p();
    }
  }
  
  protected boolean b()
  {
    return this.o;
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.r)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363814, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
      ad();
      bool = true;
    }
    return bool;
  }
  
  protected SpannableString c()
  {
    if (this.o) {
      return e();
    }
    return super.c();
  }
  
  protected SpannableString d()
  {
    if (this.o) {
      return f();
    }
    return super.d();
  }
  
  protected void d(Intent paramIntent)
  {
    boolean bool = false;
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    this.p = false;
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
    HotChatInfo localHotChatInfo = localHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localHotChatInfo != null) {
      bool = true;
    }
    this.p = bool;
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopChatPie", 4, "updateSession_business, isHotChat = " + this.p + " , " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (localHotChatInfo != null)
    {
      if (!localHotChatManager.a()) {
        break label215;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localHotChatInfo);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
      {
        paramIntent = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
        }
      }
      h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      StartupTracker.a("AIO_updateSession_business", null);
      return;
      label215:
      if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (localHotChatManager.b())) {
        HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
    }
  }
  
  protected boolean d()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a())) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a();
          }
          bool2 = super.d();
          bool1 = bool2;
        } while (this.jdField_c_of_type_Boolean);
        bool1 = bool2;
      } while (!this.s);
      bool1 = bool2;
    } while (bool2);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HotChatListActivity.class);
    localIntent.putExtra("abp_flag", this.s);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    return bool2;
  }
  
  protected SpannableString e()
  {
    if (this.jdField_f_of_type_AndroidTextSpannableString == null)
    {
      ImageSpan localImageSpan = new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130839439);
      SpannableString localSpannableString = new SpannableString("语音输入");
      localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
      this.jdField_f_of_type_AndroidTextSpannableString = localSpannableString;
    }
    return this.jdField_f_of_type_AndroidTextSpannableString;
  }
  
  protected void e()
  {
    super.e();
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.i = paramInt;
      if (!this.r) {
        break label132;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), false);
      b(true);
    }
    label132:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  protected void e(Intent paramIntent)
  {
    if (this.p)
    {
      this.s = paramIntent.getBooleanExtra("abp_flag", false);
      this.t = paramIntent.getBooleanExtra("is_from_web", false);
    }
    if ((this.t) && (!this.s))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131365114);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回");
      return;
    }
    if (this.s)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("热聊");
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回热聊");
      return;
    }
    super.e(paramIntent);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b();
  }
  
  protected SpannableString f()
  {
    if (this.jdField_e_of_type_AndroidTextSpannableString == null)
    {
      ImageSpan localImageSpan = new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130839440);
      SpannableString localSpannableString = new SpannableString("文字输入");
      localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
      this.jdField_e_of_type_AndroidTextSpannableString = localSpannableString;
    }
    return this.jdField_e_of_type_AndroidTextSpannableString;
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void f(boolean paramBoolean)
  {
    this.o = paramBoolean;
    AnonymousChatHelper.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(12, -1);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_d_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_f_of_type_AndroidViewView == null)
    {
      this.jdField_f_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130839444);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_f_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_f_of_type_AndroidViewView, 0);
    }
    if (this.jdField_e_of_type_AndroidViewView == null)
    {
      this.jdField_e_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_e_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(2, 2131297027);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297028).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839444);
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundResource(2130839459);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(c());
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839452);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130839444);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838413);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.jdField_c_of_type_Int);
      if (!this.p) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839442);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_a_of_type_JavaLangCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364042) + AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = new gcm(this);
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131364060);
        this.jdField_a_of_type_AndroidWidgetEditText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
    }
    for (;;)
    {
      o();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      return;
      ap();
    }
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar = new TroopAssistTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar);
  }
  
  protected void g(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
    }
    super.g(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    paramIntent = new gdd(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
  }
  
  protected void h(Intent paramIntent)
  {
    int j = 0;
    Object localObject1 = paramIntent.getExtras();
    Object localObject2 = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i)) {}
    for (this.l = false; (!this.l) || (((Bundle)localObject1).containsKey("forward_type")); this.l = true)
    {
      c(paramIntent);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramIntent.getExtras().containsKey("video_play_url")))
    {
      localObject1 = paramIntent.getStringExtra("video_play_url");
      long l = paramIntent.getLongExtra("video_play_msg", 0L);
      i = j;
      if (paramIntent.getBooleanExtra("video_play_feed", false))
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetLinearLayout);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((String)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItemId(i) != l);
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
      int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      if ((i < j) || (i > k + j - 1)) {
        break;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
      if (paramIntent == null) {
        break;
      }
      localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
      if ((localObject2 == null) || (!(localObject2 instanceof MessageForStructing))) {
        break;
      }
      localObject2 = (MessageForStructing)localObject2;
      if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForGeneralShare))) {
        break;
      }
      localObject2 = (StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg;
      if (localObject2 == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((String)localObject1, (StructMsgForGeneralShare)localObject2, paramIntent);
      return;
      if ((this.jdField_c_of_type_Int != 0) || (bool))
      {
        c(true);
        return;
      }
      if (((Bundle)localObject1).getLong("res_share_id", 0L) <= 0L) {
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
      return;
      i = -1;
    }
  }
  
  void h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while ((((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(paramString)) || (this.p) || (this.p)) {
      return;
    }
    ThreadManager.b().postDelayed(new gcc(this, paramString), 5000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMessage.arg1);
        continue;
        if (!this.p)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.o);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b(false);
        }
      }
    }
  }
  
  public boolean k()
  {
    return this.o;
  }
  
  protected void l()
  {
    if (!this.p)
    {
      if (!this.o) {
        break label102;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839442);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
        break label115;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363490));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new gcp(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364170));
      return;
      label102:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839426);
      break;
      label115:
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363490));
    }
  }
  
  public void m()
  {
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (this.p)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).c((String)localObject1))
      {
        ChatSettingForHotChat.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
        return;
      }
      QQToast.a(a(), "你已不在该热聊", 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (((FriendManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      TroopProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2000);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingForTroop.class);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("vistor_type", 1);
    Object localObject2;
    int i;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      if (localObject1 == null) {
        break label462;
      }
      localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label462;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label462;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label450;
      }
      i = 1;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (i != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
        return;
        label450:
        i = 0;
        break;
      }
      label462:
      i = 0;
    }
  }
  
  protected void o()
  {
    if (this.o)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839463);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841828);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131297029) && (b(true))) {}
    do
    {
      do
      {
        return;
        if ((paramView.getId() == 2131297032) && (this.o)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
        if (paramView.getId() != 2131297033) {
          break;
        }
        if ((!this.p) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      } while (b(true));
      super.onClick(paramView);
    } while ((paramView.getId() != 2131296329) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    TroopInfo localTroopInfo;
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() != 0) && (paramInt3 == 1) && (paramCharSequence.charAt(paramInt1) == '@') && (!this.h) && (!this.v))
    {
      paramCharSequence = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (!paramCharSequence.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localTroopInfo = paramCharSequence.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localTroopInfo != null)
        {
          paramCharSequence = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 3);
          paramCharSequence.putExtra("param_is_pop_up_style", true);
          if (!this.o) {
            break label246;
          }
          paramCharSequence.putExtra("param_chat_mode", 1);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramCharSequence, 6001);
          str1 = "2";
        }
      }
    }
    for (;;)
    {
      try
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((localTroopInfo.troopowneruin == null) || (!localTroopInfo.troopowneruin.equals(str2))) {
          continue;
        }
        paramCharSequence = "0";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", paramCharSequence, "");
      }
      catch (Exception paramCharSequence)
      {
        String str2;
        label246:
        continue;
      }
      this.v = false;
      return;
      paramCharSequence.putExtra("param_chat_mode", 0);
      break;
      paramCharSequence = str1;
      if (localTroopInfo.Administrator != null)
      {
        paramCharSequence = str1;
        if (localTroopInfo.Administrator.contains(str2)) {
          paramCharSequence = "1";
        }
      }
    }
  }
  
  protected void p()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (this.p)
    {
      if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
  }
  
  protected void t()
  {
    if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130839444);
      return;
    }
    super.t();
  }
  
  protected void u()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
    }
    if (this.jdField_c_of_type_AndroidOsHandler != null)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper != null) {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a();
    }
    AnonymousChatHelper.a().b();
    TroopMemberLbsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.o) {
      ap();
    }
    ae();
    super.u();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {}
    label300:
    label315:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (!(paramObject instanceof MessageRecord)) {
                      break label315;
                    }
                    if (!(paramObject instanceof ChatMessage)) {
                      break label300;
                    }
                    paramObservable = (MessageRecord)paramObject;
                    if (paramObservable.isSendFromLocal()) {
                      break;
                    }
                  } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != paramObservable.istroop) && ((!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (!MsgProxyUtils.c(paramObservable.istroop)))) || (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) || (SystemMsg.isTroopSystemMessage(paramObservable.msgtype)) || (paramObservable.msgtype == -1013) || ("1000000".equalsIgnoreCase(paramObservable.senderuin)) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null));
                  paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObservable.frienduin, paramObservable.istroop);
                } while (paramObject.uniseq != paramObservable.uniseq);
                paramObservable = paramObject.nickName;
                if ((paramObject.selfuin != null) && (paramObject.selfuin.equals(paramObject.senderuin))) {
                  paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
                }
                for (;;)
                {
                  MsgSummary localMsgSummary = new MsgSummary();
                  MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMsgSummary, paramObservable, true, false);
                  paramObject = localMsgSummary.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
                  this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramObservable, paramObject);
                  return;
                  if (AnonymousChatHelper.a(paramObject)) {
                    paramObservable = AnonymousChatHelper.a(paramObject).b;
                  }
                }
              } while ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1));
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
              return;
            } while (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null);
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.e();
            return;
          } while (!(paramObject instanceof TroopAioAgent.Message));
          paramObservable = (TroopAioAgent.Message)paramObject;
        } while (paramObservable == null);
        if (paramObservable.jdField_a_of_type_Int == TroopAioAgent.jdField_a_of_type_Int)
        {
          if (paramObservable.jdField_c_of_type_Int == 1)
          {
            a(paramObservable.jdField_c_of_type_Int, paramObservable.jdField_a_of_type_Long);
            return;
          }
          a(paramObservable.jdField_c_of_type_Int, paramObservable.jdField_b_of_type_Long);
          return;
        }
        if (paramObservable.jdField_a_of_type_Int != TroopAioAgent.jdField_b_of_type_Int) {
          break;
        }
      } while (this.jdField_c_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObservable.jdField_b_of_type_Int);
      return;
    } while (paramObservable.jdField_a_of_type_Int != TroopAioAgent.jdField_c_of_type_Int);
    paramObservable = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingForTroop.class);
    paramObservable.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    paramObservable.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramObservable.putExtra("vistor_type", 1);
    paramObservable.putExtra("selection", 17);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramObservable, 2000);
  }
  
  protected void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof BasePadActivity)) {
      this.v = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.bActivityToFragment;
    }
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */