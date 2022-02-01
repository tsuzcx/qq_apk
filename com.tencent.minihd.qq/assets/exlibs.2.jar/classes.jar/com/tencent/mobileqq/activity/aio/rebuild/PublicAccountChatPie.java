package com.tencent.mobileqq.activity.aio.rebuild;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.publicAccountText;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.troopbar.TroopBarDetailActivity;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.PubAccountAssistantTipsBar;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XPanelContainer;
import gas;
import gat;
import gav;
import gaw;
import gax;
import gay;
import gaz;
import gba;
import gbb;
import gbc;
import gbe;
import gbf;
import gbg;
import gbh;
import gbi;
import gbj;
import gbk;
import gbm;
import gbn;
import gbo;
import gbp;
import gbq;
import gbr;
import gbs;
import gbt;
import gbu;
import gbv;
import gbw;
import gbx;
import gby;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class PublicAccountChatPie
  extends BaseChatPie
{
  private static final String M = "2632129500";
  private static final int ch = 1;
  private static final int ci = 2;
  private static final int cj = 3;
  private static final int ck = 0;
  private static final int cl = 1;
  private static final int cm = 2;
  private static final int cn = 3;
  private static final int co = 4;
  private static final int cp = 5;
  public String K = "";
  public String L = "";
  private PublicAccountManager jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager;
  private CustomMenuBar jdField_a_of_type_ComTencentBizUiCustomMenuBar;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
  protected MessageObserver a;
  public PublicAccountHandler a;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private PublicAccountInfo jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  private PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new gbf(this);
  public int[] a;
  private Handler jdField_b_of_type_AndroidOsHandler = new gas(this);
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private NewIntent jdField_b_of_type_MqqAppNewIntent = null;
  private NewIntent c = null;
  public int cf = 0;
  public int cg = -1;
  private int cq = 0;
  private int cr = 3;
  private int cs;
  private int ct;
  private int cu = 0;
  private int cv = 0;
  private View d;
  private View e = null;
  private View jdField_f_of_type_AndroidViewView = null;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private Dialog jdField_g_of_type_AndroidAppDialog;
  private View jdField_g_of_type_AndroidViewView = null;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  public PublicAccountChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gbv(this);
  }
  
  private void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new gbw(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    if (this.e == null) {
      return;
    }
    publicAccountText.a((TextView)this.e.findViewById(2131296729), paramAccountDetail.name);
    Object localObject = (TextView)this.e.findViewById(2131296730);
    if (this.K != null) {
      publicAccountText.a((TextView)localObject, this.K, 2);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(a().jdField_a_of_type_JavaLangString);
    ImageView localImageView = (ImageView)this.e.findViewById(2131296551);
    localImageView.setImageDrawable((Drawable)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gbo(this, localImageView);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    localObject = (ImageView)this.e.findViewById(2131296555);
    if (paramAccountDetail.certifiedGrade == 0)
    {
      ((ImageView)localObject).setVisibility(8);
      return;
    }
    ((ImageView)localObject).setVisibility(0);
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    int i = 0;
    if (paramMessageForStructing.structingMsg == null) {}
    for (;;)
    {
      return;
      this.cf = paramMessageForStructing.structingMsg.mPromotionType;
      this.K = paramMessageForStructing.structingMsg.mPromotionMsg;
      this.L = paramMessageForStructing.structingMsg.mPromotionMenus;
      this.cg = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
      try
      {
        if (this.L == null) {
          continue;
        }
        this.z = false;
        paramMessageForStructing = this.L.split(",");
        if (paramMessageForStructing == null) {
          continue;
        }
        int j = paramMessageForStructing.length;
        this.jdField_a_of_type_ArrayOfInt = new int[j];
        while (i < j)
        {
          paramMessageForStructing[i] = paramMessageForStructing[i].trim();
          this.jdField_a_of_type_ArrayOfInt[i] = Integer.parseInt(paramMessageForStructing[i]);
          i += 1;
        }
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        this.z = true;
      }
    }
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        new Thread(new gbj(this, paramString, paramInt, l1, l2), "report_show_msg_result").start();
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "Pb_account_lifeservice", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      PublicAccountManager.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = PublicAccountManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt, paramBoolean, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new gbp(this));
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras() == null) {
      v();
    }
  }
  
  private void ae()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  @TargetApi(11)
  private void af()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new gbx(this));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_f_of_type_AndroidViewView);
      this.s = true;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    a(this.jdField_f_of_type_AndroidViewView, this.jdField_f_of_type_AndroidViewView.getHeight(), 0, new gby(this));
    this.e.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.e.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new gat(this));
    this.e.startAnimation(localTranslateAnimation);
  }
  
  private void ag()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {}
    do
    {
      do
      {
        return;
        this.e = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext()).inflate(2130903083, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      } while (this.e == null);
      this.e.setClickable(true);
      this.e.findViewById(2131296551).setOnClickListener(new gay(this));
      if (this.cf == 2)
      {
        this.e.findViewById(2131296728).setVisibility(8);
        this.e.findViewById(2131296731).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.e);
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext()).inflate(2130903082, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    } while (this.jdField_f_of_type_AndroidViewView == null);
    if (this.cf == 2) {
      this.jdField_f_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131493417));
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_f_of_type_AndroidViewView);
    Object localObject = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (this.p))
    {
      a((AccountDetail)localObject);
      this.p = false;
    }
    localObject = (PublicMenuBar)this.e.findViewById(2131296732);
    ((PublicMenuBar)localObject).setOnMenuItemClickListener(new gaz(this));
    ((PublicMenuBar)localObject).a();
    MenuItem localMenuItem1 = new MenuItem("DO_NOT_FOLLOW", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368512), a().getResources().getDrawable(2130838651), 0);
    MenuItem localMenuItem2 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368513), a().getResources().getDrawable(2130838648), 1);
    ((PublicMenuBar)localObject).a(localMenuItem1, 2130903613);
    ((PublicMenuBar)localObject).a(localMenuItem2, 2130903613);
    ((PublicMenuBar)localObject).setSwitchButtonVisibility(false);
    ((PublicMenuBar)localObject).setVisibility(0);
  }
  
  private void ah()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    g(false);
  }
  
  private void ai()
  {
    int k;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
      if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0) && (!this.z))
      {
        k = this.jdField_a_of_type_ArrayOfInt.length;
        localObject = new String[k];
        if ((this.cg < 0) || (this.cg >= k)) {
          break label310;
        }
      }
    }
    label169:
    label310:
    for (int i = 1;; i = 0)
    {
      int j = 0;
      if (j < k)
      {
        if (this.jdField_a_of_type_ArrayOfInt[j] == 0)
        {
          localObject[j] = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368516);
          label103:
          if (i == 0) {
            break label184;
          }
          if (j == this.cg) {
            break label169;
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(localObject[j]);
        }
        for (;;)
        {
          j += 1;
          break;
          localObject[j] = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368517), new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[j]) });
          break label103;
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localObject[j], 3);
          continue;
          label184:
          if (j != k - 1) {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.c(localObject[j]);
          } else {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localObject[j], 3);
          }
        }
        this.z = true;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368518);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject, 3);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new gba(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new gbb(this));
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        this.y = false;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
    }
  }
  
  private void aj()
  {
    if (this.t) {
      return;
    }
    Object localObject = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((ImageView)localObject).setId(2131296334);
    ((ImageView)localObject).setImageResource(2130841734);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setOnClickListener(this);
    ((ImageView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131363624));
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    int i = AIOUtils.a(40.0F, localResources);
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    localLayoutParams.leftMargin = AIOUtils.a(32.0F, localResources);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, 1);
    }
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar);
    }
    if (this.e != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.e);
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a(this.jdField_f_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903084, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296737));
    if (this.v)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, AIOUtils.a(34.0F, localResources), 0.0F);
      ((TranslateAnimation)localObject).setDuration(250L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new gbc(this));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296733);
    ((View)localObject).setOnClickListener(new gbe(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.d = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296734);
    ak();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("menuEventSharePre", 0);
    if (!((SharedPreferences)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      ((SharedPreferences.Editor)localObject).commit();
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new gbg(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new gbh(this));
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    b((List)localObject);
    this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      f(true);
    }
    this.t = true;
  }
  
  private void ak()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.b(new gbi(this, localSharedPreferences, str));
  }
  
  private void al()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
    if (localPublicAccountDataManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs))
      {
        String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362347);
        String str2 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362348), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        this.jdField_g_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, str1, str2, 2131362349, 2131362350, new gbk(this, localPublicAccountDataManager), new gbm(this, localPublicAccountDataManager));
        this.jdField_g_of_type_AndroidAppDialog.setOnDismissListener(new gbn(this));
        this.jdField_g_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        this.jdField_g_of_type_AndroidAppDialog.show();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ChatActivity", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "follow");
    }
    if (this.c != null) {
      this.c.setObserver(null);
    }
    this.c = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), PublicAccountServlet.class);
    this.c.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.c.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new gbq(this);
    this.c.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.c);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "follow exit");
    }
  }
  
  private void an()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
      if (localPublicAccountDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      ao();
    }
  }
  
  private void ao()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    SosoInterface.a(new gbs(this, 1, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void b(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
      if ((paramList == null) || (paramList.isEmpty()))
      {
        g(true);
        if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        int k = paramList.size();
        int i = 0;
        while ((i < k) && (i <= 2))
        {
          Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i);
          Object localObject1;
          String str;
          label140:
          label160:
          MenuItem localMenuItem;
          label196:
          label220:
          mobileqq_mp.ButtonInfo localButtonInfo;
          if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
          {
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
              break label332;
            }
            str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
              break label339;
            }
            j = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
            localMenuItem = new MenuItem((String)localObject1, str, null, j);
            if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
              break label344;
            }
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label369;
            }
            localObject2 = ((List)localObject1).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label369;
            }
            localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
            if (!localButtonInfo.key.has()) {
              break label350;
            }
            localObject1 = localButtonInfo.key.get();
            label263:
            if (!localButtonInfo.name.has()) {
              break label357;
            }
            str = localButtonInfo.name.get();
            label284:
            if (!localButtonInfo.id.has()) {
              break label364;
            }
          }
          label332:
          label339:
          label344:
          label350:
          label357:
          label364:
          for (int j = localButtonInfo.id.get();; j = 0)
          {
            localMenuItem.a(new MenuItem((String)localObject1, str, null, j));
            break label220;
            localObject1 = "";
            break;
            str = "";
            break label140;
            j = 0;
            break label160;
            localObject1 = null;
            break label196;
            localObject1 = "";
            break label263;
            str = "";
            break label284;
          }
          label369:
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, a());
          i += 1;
        }
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label62;
      }
      i = 0;
      localLinearLayout.setVisibility(i);
      if (!paramBoolean) {
        break label68;
      }
    }
    label62:
    label68:
    for (int i = 2131297027;; i = 2131296737)
    {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(2, i);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(2, i);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean k()
  {
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject == null) && (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))
      {
        PublicAccountUtil.a();
        PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return true;
      }
      return false;
    }
  }
  
  private boolean l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
      if ((localObject != null) && (((QQMessageFacade.Message)localObject).msgtype == -2011))
      {
        MessageForStructing localMessageForStructing = new MessageForStructing();
        MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
        localMessageForStructing.parse();
        if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2)))
        {
          a(localMessageForStructing);
          return true;
        }
      }
    }
    return false;
  }
  
  private void o(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      if (!this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  protected void B()
  {
    super.B();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(37, 500L);
    if ((!this.t) && (this.u))
    {
      this.u = false;
      ThreadManager.b(new gbr(this));
    }
  }
  
  protected void T()
  {
    super.T();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void U()
  {
    super.U();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(20);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(37);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.u = true;
  }
  
  public void a(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  void a(AbsListView paramAbsListView)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = paramAbsListView.s();
    ChatMessage localChatMessage;
    if (i <= paramAbsListView.t())
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
      if (localChatMessage != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("")) || (!localChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true")) || (localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true"))) {
        continue;
      }
      try
      {
        if (localChatMessage.getExtInfoFromExtStr("pa_msgId").equals("")) {}
        long l1;
        for (String str = "0";; str = localChatMessage.getExtInfoFromExtStr("pa_msgId"))
        {
          l1 = Long.parseLong(str);
          localArrayList1.add(Long.valueOf(l1));
          localArrayList2.add(localChatMessage);
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivity", 2, "Report message at index: " + String.valueOf(i) + ". MessageId is " + l1);
          }
          localChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
          break;
        }
        a(localArrayList2);
        try
        {
          l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (!localArrayList1.isEmpty()) {
            this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, 0L, l1, l2, 2, localArrayList1);
          }
          return;
        }
        catch (Exception paramAbsListView) {}
        return;
      }
      catch (Exception paramAbsListView) {}
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(37);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.e == null) || (this.jdField_f_of_type_AndroidViewView == null) || (this.cr == 5)) {}
    label237:
    label239:
    int i;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (this.cu > paramInt3)
          {
            this.cr = 4;
            this.cu = paramInt3;
            switch (this.cr)
            {
            }
          }
          for (;;)
          {
            if ((!this.s) && (!this.r)) {
              break label237;
            }
            if ((!this.x) || (this.r)) {
              break label239;
            }
            this.x = false;
            return;
            if (this.cu >= paramInt3) {
              break;
            }
            this.cr = 3;
            break;
            if ((paramInt3 > paramInt2) && (!this.s))
            {
              this.ct = this.jdField_f_of_type_AndroidViewView.getLayoutParams().height;
              a(this.jdField_f_of_type_AndroidViewView);
              this.s = true;
            }
            this.cr = 2;
            this.x = true;
            continue;
            if ((paramInt3 == paramInt2) && (this.s))
            {
              if (this.ct != 0) {
                a(this.jdField_f_of_type_AndroidViewView, this.ct);
              }
              this.s = false;
              this.r = true;
            }
            this.cr = 2;
            this.x = true;
          }
        }
        if (this.e.getHeight() != 0) {
          this.ct = this.e.getHeight();
        }
        i = this.cs - d();
        this.cs = d();
        if (this.cv * i < 0)
        {
          this.cv = i;
          return;
        }
        this.cv = i;
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "Move = " + String.valueOf(i));
        }
        switch (this.cq)
        {
        default: 
          return;
        }
      } while (((i <= 5) || (!this.w)) && ((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.m()) || (i <= 0) || (!this.w) || (this.q)));
      this.q = true;
      paramAbsListView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.ct);
      paramAbsListView.setFillAfter(true);
      paramAbsListView.setDuration(250L);
      paramAbsListView.setAnimationListener(new gav(this));
      this.e.startAnimation(paramAbsListView);
      return;
    } while (((i >= -5) || (!this.w)) && (((!this.r) && ((paramInt1 + paramInt2 != paramInt3) || (i >= 0) || (!this.w))) || (this.q)));
    this.q = true;
    paramAbsListView = new TranslateAnimation(0.0F, 0.0F, -this.ct, 0.0F);
    paramAbsListView.setFillAfter(true);
    paramAbsListView.setDuration(250L);
    paramAbsListView.setAnimationListener(new gaw(this));
    this.e.startAnimation(paramAbsListView);
  }
  
  void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "saveReadedToDB");
    }
    ThreadManager.b(new gax(this, paramList));
  }
  
  protected boolean a(boolean paramBoolean)
  {
    ad();
    super.a(paramBoolean);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    String str = localIntent.getStringExtra("from");
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager = PublicAccountManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new gbt(this));
    }
    if ((str != null) && (str.equals("starShortcut")))
    {
      PublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent.getStringExtra("starhomeurl"), localIntent.getStringExtra("uin"), str);
      return true;
    }
    if ((NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      HtmlOffline.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), "108", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, new gbu(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10));
    return true;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    al();
    an();
  }
  
  public int d()
  {
    int i = 0;
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((this.jdField_g_of_type_AndroidViewView != null) && (localView != this.jdField_g_of_type_AndroidViewView))
    {
      this.cs = 0;
      this.jdField_g_of_type_AndroidViewView = localView;
      return 0;
    }
    if (localView != null) {
      i = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "ScrollY: " + String.valueOf(i) + "  OldScrollY: " + String.valueOf(this.cs));
    }
    this.jdField_g_of_type_AndroidViewView = localView;
    return i;
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      }
      g(false);
    }
  }
  
  protected void g()
  {
    PubAccountAssistantTipsBar localPubAccountAssistantTipsBar = new PubAccountAssistantTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this, this.jdField_a_of_type_AndroidOsHandler);
    ReaderTipsBar localReaderTipsBar = new ReaderTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localPubAccountAssistantTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localReaderTipsBar);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (this.d != null)
      {
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(20);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(20);
        if ((this.d != null) && (this.d.getVisibility() == 0))
        {
          this.d.setVisibility(8);
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivity", 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
          }
          AccountDetail localAccountDetail = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localAccountDetail != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(localAccountDetail.name);
            if (this.p)
            {
              a(localAccountDetail);
              this.p = false;
            }
            if (this.jdField_g_of_type_AndroidAppDialog == null)
            {
              al();
              an();
            }
          }
          if (this.o)
          {
            this.o = false;
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(localAccountDetail);
            ae();
          }
        }
      }
    }
  }
  
  protected void i(Intent paramIntent)
  {
    ad();
    super.i(paramIntent);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a()))) {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a();
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      b((List)localObject);
      this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        f(true);
      }
    }
    Object localObject = paramIntent.getStringExtra("from");
    if ((localObject != null) && (((String)localObject).equals("starShortcut"))) {
      PublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), (String)localObject);
    }
  }
  
  public void m()
  {
    Object localObject = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && ((((PublicAccountInfo)localObject).accountFlag & 0x200000) != 0))
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, TroopBarDetailActivity.class);
      ((Intent)localObject).putExtra("need_finish", true);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject, 2000);
      return;
    }
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
    localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AccountDetailActivity.class);
    ((Intent)localObject).putExtra("need_finish", true);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject, 2000);
  }
  
  public void n(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841831);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131363663));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296334) {
      f(true);
    }
    if (2131297361 == paramView.getId())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "Pb_account_lifeservice", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
    }
    super.onClick(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.w = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void u()
  {
    
    if (this.jdField_b_of_type_MqqAppNewIntent != null) {
      PublicAccountManager.a().a(this.jdField_b_of_type_MqqAppNewIntent);
    }
    if (this.c != null) {
      this.c.setObserver(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
    super.u();
    if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie
 * JD-Core Version:    0.7.0.1
 */