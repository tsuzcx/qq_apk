package com.tencent.mobileqq.activity.flaotaio;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import gkq;
import gkr;
import gks;
import gkt;
import gku;
import gkv;
import gkw;
import gkx;
import gky;
import gkz;
import gla;
import glb;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class BaseFloatChatPie
  implements Handler.Callback, View.OnClickListener, ChatActivityConstants, MediaPlayerManager.Listener, FloatHbPage.FloatHbCallBack, RootCallBack, EmoticonCallback, AbsListView.OnScrollListener, Observer
{
  public static final String a = "hongbao_money_get";
  public static final String b = "action_for_item_click";
  public static final int c = 248;
  public static final int d = 94;
  protected float a;
  protected int a;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  public final Handler a;
  protected MessageQueue.IdleHandler a;
  private View jdField_a_of_type_AndroidViewView;
  protected EditText a;
  protected FrameLayout a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public SessionInfo a;
  protected FloatAioPage a;
  public FloatChatAdapter a;
  protected FloatEmoticonPanel a;
  protected FloatHbPage a;
  protected SlipFrameLayout a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new gkt(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gks(this);
  public QQAppInterface a;
  protected ScrollerRunnable a;
  private ToastStyleDialog jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  public XListView a;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  protected int b;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  public FrameLayout b;
  protected ImageView b;
  public TextView b;
  public boolean b;
  protected FrameLayout c;
  protected ImageView c;
  protected TextView c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  protected TextView d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int f = 0;
  
  public BaseFloatChatPie(QQAppInterface paramQQAppInterface, FloatAioPage paramFloatAioPage)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Int = 131074;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage = paramFloatAioPage;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private Drawable a()
  {
    if (this.jdField_c_of_type_JavaLangString != null) {
      return FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_c_of_type_JavaLangString);
    }
    return null;
  }
  
  private String a()
  {
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        if (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        }
        break;
      case 3000: 
        return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, 0);
      case 1: 
        return ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    return null;
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean3) {
      i = 2131366525;
    }
    for (;;)
    {
      QQToast.a(paramContext, i, 0).a();
      return;
      if (paramBoolean2) {
        i = 2131366526;
      } else if (paramBoolean1) {
        i = 2131366524;
      } else {
        i = 2131366523;
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void a(TextView paramTextView)
  {
    int j = "更多历史消息 进入QQ查看".indexOf("进入");
    int i = j;
    if (j < 0) {
      i = 7;
    }
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427448);
    SpannableString localSpannableString = new SpannableString("更多历史消息 进入QQ查看");
    localSpannableString.setSpan(new gkv(this, k), i, j + 6, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  private void f(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_e_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (paramInt <= 0)
    {
      if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (BaseChatItemLayout.jdField_b_of_type_Boolean)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setId(2131296332);
      ((TextView)localObject1).setBackgroundResource(2130837662);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(3.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 85;
      ((FrameLayout.LayoutParams)localObject2).rightMargin = ((int)(68.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    }
    Object localObject2 = this.jdField_e_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
  }
  
  private void f(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(94);
    String str1 = paramIntent.getStringExtra("error_msg");
    if (str1 != null)
    {
      l();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str1, 1).a();
      return;
    }
    str1 = paramIntent.getStringExtra("hb_count_tv");
    boolean bool1 = paramIntent.getBooleanExtra("hb_error_tv", false);
    String str2 = paramIntent.getStringExtra("hb_yiling_tv");
    boolean bool2 = paramIntent.getBooleanExtra("pin_icon", false);
    Log.i("app2", "handleHongbaoMsg bBCount=" + str1 + " yiLingResult=" + str2 + " curHbSenderUin=" + this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.b();
    }
    if (bool1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a(16);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a(a(), a(), this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a(str1, str2, bool2);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gkx(this), 500L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a(52);
    }
  }
  
  private void g(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 10004);
  }
  
  private void u()
  {
    IntentFilter localIntentFilter;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gkw(this);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("hongbao_money_get");
      localIntentFilter.addAction("action_for_item_click");
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void w()
  {
    if (QQLSRecentManager.e) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ThreadManager.b().post(new gkz(this));
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null)) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.a();
    int i4 = this.jdField_a_of_type_ComTencentWidgetXListView.getScrollY();
    int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.s() - this.jdField_a_of_type_ComTencentWidgetXListView.m();
    this.jdField_a_of_type_ComTencentWidgetXListView.t();
    this.jdField_a_of_type_ComTencentWidgetXListView.m();
    int i = this.jdField_b_of_type_Int;
    Object localObject2;
    int k;
    int i3;
    int j;
    int n;
    switch (this.jdField_b_of_type_Int & 0xFFFF0000)
    {
    default: 
      localObject2 = localList;
      k = this.jdField_e_of_type_Int;
      i3 = localList.size();
      j = ((List)localObject2).size();
      n = this.jdField_b_of_type_Int & 0xFFFF;
      if ((n == 0) && (this.jdField_a_of_type_AndroidViewView == this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount() - 1))) {
        n = 2;
      }
      break;
    }
    for (;;)
    {
      long l;
      switch (n)
      {
      case 4: 
      default: 
        i = k;
        if (localList != localObject2)
        {
          if ((i3 <= 0) || (j <= 0)) {
            break label1329;
          }
          l = ((ChatMessage)localList.get(i3 - 1)).uniseq;
          i = j - 1;
          if (i < 0) {
            break label1329;
          }
          if (((ChatMessage)((List)localObject2).get(i)).uniseq != l) {
            break label1212;
          }
          label309:
          if (i < 0) {
            break label1219;
          }
          i = j - (i3 - this.jdField_e_of_type_Int + j - 1 - i);
        }
        break;
      }
      label329:
      Object localObject1;
      label389:
      label447:
      label581:
      label620:
      label756:
      int i1;
      for (;;)
      {
        if (n == 5)
        {
          i = j - (i3 - this.jdField_e_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentWidgetXListView.m(), -1, null);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, this.jdField_a_of_type_AndroidContentContext.getString(2131363741), 3000).a();
          this.jdField_b_of_type_Int = 0;
          this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_e_of_type_Int = i;
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.notifyDataSetChanged();
          localObject2 = localList;
          break;
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject1 = this.jdField_a_of_type_JavaUtilList;
            this.jdField_a_of_type_JavaUtilList = null;
            if ((this.jdField_d_of_type_Boolean) && (((List)localObject1).size() > 0))
            {
              localObject2 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
              if (!((ChatMessage)localObject2).isSend()) {
                ((ChatMessage)localObject2).mAnimFlag = true;
              }
              ((ChatMessage)localObject2).mPendantAnimatable = true;
            }
            if (1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {
              break label707;
            }
            localObject2 = ChatActivityUtils.b((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            label533:
            if ((1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (localObject2 != null) || (((List)localObject1).size() != 0)) {
              break label725;
            }
            localObject2 = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString);
            if (localObject2 == null) {
              break label743;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setText("(" + (String)localObject2 + ")");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter;
            if (this.jdField_a_of_type_Boolean) {
              break label756;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((FloatChatAdapter)localObject2).a((List)localObject1, bool);
            localObject2 = localObject1;
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
            this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.getCount());
            localObject2 = localObject1;
            break;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
            break label447;
            label707:
            localObject2 = ChatActivityUtils.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            break label533;
            label725:
            localObject2 = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            break label581;
            label743:
            this.jdField_c_of_type_AndroidWidgetTextView.setText("");
            break label620;
          }
          this.f += 1;
          if (this.f == 1) {
            this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentWidgetXListView.b() - 1, 0);
          }
          for (;;)
          {
            i = j;
            break;
            this.jdField_a_of_type_ComTencentWidgetXListView.post(new gla(this));
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentWidgetXListView.b() - 1);
          i = j;
          continue;
          i = k;
          if (i3 > 0)
          {
            i = k;
            if (i2 >= 0)
            {
              m = -1;
              k = m;
              if (j <= 0) {
                break label1334;
              }
              i1 = i2;
              if (i2 >= localList.size()) {
                i1 = localList.size() - 1;
              }
              l = ((ChatMessage)localList.get(i1)).uniseq;
              k = 0;
              label912:
              i = m;
              if (k < j)
              {
                if (((ChatMessage)((List)localObject2).get(k)).uniseq == l) {
                  i = k;
                }
              }
              else
              {
                k = i;
                if (i >= 0) {
                  break label1334;
                }
                k = i;
                if (localList.size() <= i1 + 1) {
                  break label1334;
                }
                l = ((ChatMessage)localList.get(i1 + 1)).uniseq;
                m = 0;
                label986:
                k = i;
                if (m >= j) {
                  break label1334;
                }
                if (((ChatMessage)((List)localObject2).get(m)).uniseq != l) {
                  break label1072;
                }
                k = m;
              }
            }
          }
        }
      }
      label1072:
      label1329:
      label1334:
      for (int m = 1;; m = 0)
      {
        if (k >= 0)
        {
          i1 = this.jdField_e_of_type_Int + k;
          i = i1;
          if (m != 0) {
            i = i1 - 1;
          }
          if ((i4 < 0) && (k == 0))
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.B();
            break label329;
            k += 1;
            break label912;
            m += 1;
            break label986;
          }
          if (i4 < 0)
          {
            m = this.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
            i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetXListView.m()).getBottom();
            this.jdField_a_of_type_ComTencentWidgetXListView.C();
            this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(k + this.jdField_a_of_type_ComTencentWidgetXListView.m(), m - i1 + i4);
            break label329;
          }
          m = this.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
          i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetXListView.m()).getBottom();
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(k + this.jdField_a_of_type_ComTencentWidgetXListView.m(), m - i1);
          break label329;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.C();
        i = j;
        break label329;
        label1212:
        i -= 1;
        break;
        label1219:
        i = j;
        break label329;
        if (n != 6) {
          break label389;
        }
        m = this.jdField_e_of_type_Int;
        k = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.getCount();
        i = 0;
        label1247:
        if (i < k)
        {
          localObject1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.getItem(i);
          if ((localObject1 == null) || (((ChatMessage)localObject1).msgtype != -4009)) {}
        }
        for (;;)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
          if (i == 0) {}
          for (k = 0;; k = -1)
          {
            ((ScrollerRunnable)localObject1).a(i, k, null);
            i = j - (i3 - m);
            break;
            i += 1;
            break label1247;
          }
          i = 0;
        }
        i = -1;
        break label309;
      }
    }
  }
  
  private void y()
  {
    e(null);
  }
  
  public void L() {}
  
  public void M()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public int a()
  {
    int i = View.MeasureSpec.makeMeasureSpec(3000, -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(3000, -2147483648);
    this.jdField_b_of_type_AndroidViewView.measure(i, j);
    return this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  /* Error */
  public int a(int paramInt, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: ldc_w 675
    //   3: aload_0
    //   4: getfield 128	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7: invokevirtual 136	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: invokestatic 680	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   13: istore 8
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 115	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 610	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   23: aload_0
    //   24: getfield 81	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   27: getfield 182	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload_0
    //   31: getfield 81	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   34: getfield 165	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   37: iconst_0
    //   38: invokevirtual 615	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IZ)Ljava/util/List;
    //   41: putfield 574	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   44: aload_0
    //   45: getfield 497	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter	Lcom/tencent/mobileqq/activity/flaotaio/FloatChatAdapter;
    //   48: aload_0
    //   49: getfield 574	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   52: iconst_0
    //   53: invokevirtual 600	com/tencent/mobileqq/activity/flaotaio/FloatChatAdapter:a	(Ljava/util/List;Z)V
    //   56: aload_0
    //   57: getfield 497	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter	Lcom/tencent/mobileqq/activity/flaotaio/FloatChatAdapter;
    //   60: invokevirtual 604	com/tencent/mobileqq/activity/flaotaio/FloatChatAdapter:getCount	()I
    //   63: iconst_1
    //   64: isub
    //   65: istore 5
    //   67: iconst_0
    //   68: istore_3
    //   69: iload 8
    //   71: istore 4
    //   73: iload 5
    //   75: iflt +304 -> 379
    //   78: aload_0
    //   79: getfield 497	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter	Lcom/tencent/mobileqq/activity/flaotaio/FloatChatAdapter;
    //   82: iload 5
    //   84: aconst_null
    //   85: aload_0
    //   86: getfield 499	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   89: invokevirtual 684	com/tencent/mobileqq/activity/flaotaio/FloatChatAdapter:getView	(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   92: astore 9
    //   94: sipush 3000
    //   97: ldc_w 661
    //   100: invokestatic 667	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   103: istore 6
    //   105: sipush 3000
    //   108: ldc_w 661
    //   111: invokestatic 667	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   114: istore 7
    //   116: aload 9
    //   118: new 686	android/view/ViewGroup$LayoutParams
    //   121: dup
    //   122: iconst_m1
    //   123: iconst_m1
    //   124: invokespecial 687	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   127: invokevirtual 691	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   130: aload 9
    //   132: iload 6
    //   134: iload 7
    //   136: invokevirtual 670	android/view/View:measure	(II)V
    //   139: aload 9
    //   141: invokevirtual 673	android/view/View:getMeasuredHeight	()I
    //   144: istore 6
    //   146: aload_0
    //   147: getfield 497	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter	Lcom/tencent/mobileqq/activity/flaotaio/FloatChatAdapter;
    //   150: invokevirtual 604	com/tencent/mobileqq/activity/flaotaio/FloatChatAdapter:getCount	()I
    //   153: istore 7
    //   155: iload 5
    //   157: iload 7
    //   159: iconst_1
    //   160: isub
    //   161: if_icmpne +215 -> 376
    //   164: aload 9
    //   166: instanceof 693
    //   169: ifeq +70 -> 239
    //   172: aload 9
    //   174: checkcast 693	com/tencent/mobileqq/activity/flaotaio/FloatBaseChatItemLayout
    //   177: getfield 694	com/tencent/mobileqq/activity/flaotaio/FloatBaseChatItemLayout:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   180: astore 9
    //   182: aload_2
    //   183: iconst_0
    //   184: aload 9
    //   186: invokevirtual 697	android/view/View:getMeasuredWidth	()I
    //   189: iastore
    //   190: aload_2
    //   191: iconst_1
    //   192: aload 9
    //   194: invokevirtual 673	android/view/View:getMeasuredHeight	()I
    //   197: iastore
    //   198: ldc_w 367
    //   201: new 369	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 699
    //   211: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_2
    //   215: iconst_0
    //   216: iaload
    //   217: invokevirtual 702	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: ldc_w 704
    //   223: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: iconst_1
    //   228: iaload
    //   229: invokevirtual 702	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 388	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   238: pop
    //   239: iload 6
    //   241: istore_3
    //   242: iload 4
    //   244: iload 6
    //   246: iadd
    //   247: istore 7
    //   249: iload_3
    //   250: istore 4
    //   252: iload 7
    //   254: istore 6
    //   256: iload 7
    //   258: iload_1
    //   259: if_icmplt +86 -> 345
    //   262: iload 7
    //   264: istore 4
    //   266: new 706	java/util/ArrayList
    //   269: dup
    //   270: invokespecial 707	java/util/ArrayList:<init>	()V
    //   273: astore_2
    //   274: aload_0
    //   275: getfield 497	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter	Lcom/tencent/mobileqq/activity/flaotaio/FloatChatAdapter;
    //   278: aload_2
    //   279: iconst_0
    //   280: invokevirtual 600	com/tencent/mobileqq/activity/flaotaio/FloatChatAdapter:a	(Ljava/util/List;Z)V
    //   283: iload 4
    //   285: aload_0
    //   286: invokevirtual 709	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:a	()I
    //   289: iadd
    //   290: istore 4
    //   292: iload 4
    //   294: iload_1
    //   295: if_icmpge +66 -> 361
    //   298: iload 4
    //   300: iload_3
    //   301: isub
    //   302: istore_1
    //   303: iload_1
    //   304: iload 8
    //   306: isub
    //   307: ireturn
    //   308: astore 9
    //   310: aload_0
    //   311: new 706	java/util/ArrayList
    //   314: dup
    //   315: invokespecial 707	java/util/ArrayList:<init>	()V
    //   318: putfield 574	com/tencent/mobileqq/activity/flaotaio/BaseFloatChatPie:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   321: goto -277 -> 44
    //   324: astore 9
    //   326: ldc_w 367
    //   329: ldc_w 622
    //   332: aload 9
    //   334: invokestatic 712	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   337: pop
    //   338: iload 4
    //   340: istore 6
    //   342: iload_3
    //   343: istore 4
    //   345: iload 5
    //   347: iconst_1
    //   348: isub
    //   349: istore 5
    //   351: iload 4
    //   353: istore_3
    //   354: iload 6
    //   356: istore 4
    //   358: goto -285 -> 73
    //   361: iload_1
    //   362: iload_3
    //   363: isub
    //   364: istore_1
    //   365: goto -62 -> 303
    //   368: astore 9
    //   370: iload 6
    //   372: istore_3
    //   373: goto -47 -> 326
    //   376: goto -134 -> 242
    //   379: goto -113 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	BaseFloatChatPie
    //   0	382	1	paramInt	int
    //   0	382	2	paramArrayOfInt	int[]
    //   68	305	3	i	int
    //   71	286	4	j	int
    //   65	285	5	k	int
    //   103	268	6	m	int
    //   114	149	7	n	int
    //   13	294	8	i1	int
    //   92	101	9	localView	View
    //   308	1	9	localException1	Exception
    //   324	9	9	localException2	Exception
    //   368	1	9	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   15	44	308	java/lang/Exception
    //   78	155	324	java/lang/Exception
    //   164	239	368	java/lang/Exception
  }
  
  public Drawable a(ChatMessage paramChatMessage)
  {
    return FloatBaseBubbleBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout;
  }
  
  public ChatMessage a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    return null;
  }
  
  public void a()
  {
    TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = paramInt & 0xFFFF0000;
    if ((paramInt & 0xFFFF) > (this.jdField_b_of_type_Int & 0xFFFF)) {
      paramInt &= 0xFFFF;
    }
    long l;
    for (;;)
    {
      this.jdField_b_of_type_Int = (paramInt | i);
      if (i < 196608) {
        break label123;
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(12)) {
        break;
      }
      l = SystemClock.uptimeMillis();
      if (l - this.jdField_b_of_type_Long <= 1000L) {
        break label102;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
      return;
      paramInt = this.jdField_b_of_type_Int & 0xFFFF;
    }
    label102:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 1000L - (l - this.jdField_b_of_type_Long));
    return;
    label123:
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
  }
  
  protected void a(Intent paramIntent)
  {
    g(paramIntent);
    b(paramIntent);
    c(paramIntent);
  }
  
  public void a(View paramView) {}
  
  public void a(ImageView paramImageView)
  {
    ChatMessage localChatMessage = a();
    if (localChatMessage != null) {
      paramImageView.setImageDrawable(a(localChatMessage));
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      ApngImage.resumeAll();
    }
    do
    {
      return;
      URLDrawable.pause();
    } while (PicItemBuilder.g);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = this.jdField_a_of_type_ComTencentWidgetXListView.n();
    int n = this.jdField_a_of_type_ComTencentWidgetXListView.m();
    int k = paramInt3 - n - m;
    if (this.jdField_e_of_type_Int < k)
    {
      int j = paramInt1 + paramInt2 - m;
      int i = j;
      if (j >= paramInt3 - n - m) {
        i = k - 1;
      }
      if (i >= this.jdField_e_of_type_Int) {
        this.jdField_e_of_type_Int = (i + 1);
      }
    }
    for (paramInt3 = k - this.jdField_e_of_type_Int; this.jdField_e_of_type_AndroidWidgetTextView == null; paramInt3 = 0)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(13)) {
        Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 13, paramInt3, k - paramInt1 - paramInt2).sendToTarget();
      }
      return;
    }
    f(paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.b();
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    g();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      a(i | 0x20000);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean2, false, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean3, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_AndroidWidgetFrameLayout.isShown();
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramMessageRecord.istroop))));
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      PicPreDownloadUtils.a((String)localObject);
      if ((localObject != null) && (((String)localObject).length() > 3478)) {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131366078, 1);
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = new ArrayList();
      String str = AtTroopMemberSpan.a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), (ArrayList)localObject);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, (ArrayList)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006180", "0X8006180", 0, 0, "", "", "", "");
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject, null);
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(Intent paramIntent) {}
  
  public void b(View paramView)
  {
    s();
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {}
    while (f()) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      int i = this.jdField_b_of_type_AndroidWidgetFrameLayout.getHeight();
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetFrameLayout, "translationY", new float[] { i, 0.0F });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new glb(this));
      localObjectAnimator.setInterpolator(new DecelerateInterpolator(1.5F));
      localObjectAnimator.start();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a();
  }
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  protected void c(Intent paramIntent)
  {
    a(true);
    d(paramIntent);
  }
  
  public void c(View paramView) {}
  
  protected void c(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {}
    while (!f()) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = true;
      int i = this.jdField_b_of_type_AndroidWidgetFrameLayout.getHeight();
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetFrameLayout, "translationY", new float[] { 0.0F, i });
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.setInterpolator(new DecelerateInterpolator(1.5F));
      localObjectAnimator.addListener(new gkr(this));
      localObjectAnimator.start();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0;
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(25);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131366091));
        this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
  }
  
  protected void d(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
  }
  
  public boolean d()
  {
    ChatMessage localChatMessage = a();
    return (localChatMessage != null) && ((localChatMessage.istroop == 1) || (localChatMessage.istroop == 3000));
  }
  
  public void e()
  {
    SizeMeasure.b(this.jdField_a_of_type_AndroidContentContext);
    u();
    f();
    k();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a());
    m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
  }
  
  protected void e(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Int)
    {
      if (paramInt != 2) {
        break label100;
      }
      TroopGagMgr.SelfGagInfo localSelfGagInfo = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if (localSelfGagInfo != null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(localSelfGagInfo.b);
        c(false);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      q();
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      label100:
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    }
  }
  
  protected void e(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("target_activity", ChatActivity.class);
      paramIntent.putExtra("tab_index", 1);
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      paramIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
      return;
      paramIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    }
  }
  
  protected boolean e()
  {
    return false;
  }
  
  protected void f()
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903318, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout = ((SlipFrameLayout)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout.setCallBack(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((View)localObject).findViewById(2131297026));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131297681));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131297682));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131297683));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131297684));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838384);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject).findViewById(2131297034));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setMotionEventInterceptor(new gkq(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter = new FloatChatAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903320, null);
      this.jdField_b_of_type_AndroidViewView.setPadding(0, AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((View)localObject).findViewById(2131297685));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131297687));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((View)localObject).findViewById(2131297688));
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.b);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131297693));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131296411));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297202));
      a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((View)localObject).findViewById(2131297689));
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new gku(this));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a();
      if (((Intent)localObject).getBooleanExtra("open_aio_by_red_msg", false))
      {
        this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("friendUin");
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("wish_word");
        this.jdField_a_of_type_Long = ((Intent)localObject).getLongExtra("msg_uni_seq", -1L);
        g();
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838374);
    }
  }
  
  protected boolean f()
  {
    return this.jdField_b_of_type_AndroidWidgetFrameLayout.isShown();
  }
  
  public void g()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(false);
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(94, 20000L);
  }
  
  public void h()
  {
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      x();
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
        continue;
        f(paramMessage.arg1);
        continue;
        s();
        continue;
        h();
        l();
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "打开红包超时，请重试|", 0).a();
      }
    }
  }
  
  public void i()
  {
    SizeMeasure.b(this.jdField_a_of_type_AndroidContentContext);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.f;
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new gky(this), 400L);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void j()
  {
    w();
  }
  
  protected void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage = new FloatHbPage(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a(this);
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void o()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("msg_uni_seq", this.jdField_a_of_type_Long);
    localIntent.putExtra("click_msg", true);
    localIntent.putExtra("also_open_hb_detail", true);
    e(localIntent);
    l();
    s();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131297687: 
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatEmoticonPanel == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatEmoticonPanel = new FloatEmoticonPanel(this.jdField_a_of_type_AndroidContentContext, this);
          this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatEmoticonPanel);
        }
      } while (this.jdField_c_of_type_Boolean);
      if (f())
      {
        c(true);
        return;
      }
      q();
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatEmoticonPanel.a();
      b(true);
      return;
    case 2131297688: 
      c(false);
      return;
    case 2131297693: 
      c(false);
      b();
      return;
    case 2131297684: 
      y();
      s();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800617E", "0X800617E", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.getCount();
    if (this.jdField_e_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentWidgetXListView.b() - 1);
    }
    paramView.setVisibility(8);
  }
  
  public void p()
  {
    if (f())
    {
      c(true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a())
    {
      l();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.b();
  }
  
  public void q()
  {
    try
    {
      ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout.getWindowToken(), 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void r()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a()) {
      l();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.b();
  }
  
  public void t()
  {
    l();
    v();
    this.f = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage.a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      a(this.jdField_a_of_type_ComTencentWidgetXListView.c());
      this.jdField_a_of_type_ComTencentWidgetXListView.setRecyclerListener(null);
    }
    n();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatEmoticonPanel.b();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    }
    q();
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null) {
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((!(paramObject instanceof MessageRecord)) || (!(paramObject instanceof ChatMessage)));
        paramObservable = (MessageRecord)paramObject;
        if (paramObservable.isSendFromLocal()) {
          break;
        }
      } while (((paramObservable.msgtype == -1004) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin))) || (!a(paramObservable)));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      this.jdField_d_of_type_Boolean = true;
      a(196608);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      a(true);
    } while ((!(paramObservable instanceof MessageForStructing)) || ((paramObservable.istroop != 1) && (paramObservable.istroop != 3000) && (paramObservable.istroop != 0)) || (!"viewMultiMsg".equals(((MessageForStructing)paramObservable).structingMsg.mMsgAction)));
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop, paramObservable.uniseq, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie
 * JD-Core Version:    0.7.0.1
 */