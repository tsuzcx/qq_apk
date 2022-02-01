package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.activity.recent.RecentCallObserver;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import dkk;
import dkl;
import dkm;
import dkn;
import dkr;
import dks;
import dkt;
import dku;
import dkv;
import dkw;
import dkx;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.Constants.LogoutReason;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class Call
  extends BaseActivity
  implements Handler.Callback, ViewStub.OnInflateListener, OnRecentUserOpsListener, AbsListView.OnScrollListener, OverScrollViewListener, Observer
{
  public static final int a = 1020;
  private static final String jdField_a_of_type_JavaLangString = "CallTab";
  public static final int b = 1021;
  public static final int c = 1022;
  public static final int d = 1025;
  public static final int e = 1027;
  public static final int f = 1030;
  public static final int g = 16;
  protected static final int h = 0;
  protected static final int i = 1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dkt(this);
  protected Handler.Callback a;
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private RecentCallHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
  private RecentCallObserver jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver = new dkm(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dks(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dkn(this);
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new dkx(this, null);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dkr(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  boolean jdField_a_of_type_Boolean = true;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private int j = 0;
  
  public Call()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new dkk(this);
  }
  
  private void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  private void a(View paramView) {}
  
  private void a(String paramString) {}
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "setFirstDrawComplete, " + this.d);
    }
    if (this.d) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1025);
    this.d = true;
    if (!this.e) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1020);
    }
    c();
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc 172
    //   4: invokevirtual 176	com/tencent/mobileqq/activity/Call:findViewById	(I)Landroid/view/View;
    //   7: checkcast 178	android/view/ViewGroup
    //   10: putfield 180	com/tencent/mobileqq/activity/Call:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   13: aload_0
    //   14: aload_0
    //   15: ldc 181
    //   17: invokevirtual 176	com/tencent/mobileqq/activity/Call:findViewById	(I)Landroid/view/View;
    //   20: checkcast 178	android/view/ViewGroup
    //   23: putfield 183	com/tencent/mobileqq/activity/Call:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   26: aload_0
    //   27: getfield 116	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   30: ifnonnull +23 -> 53
    //   33: aload_0
    //   34: new 185	com/tencent/mobileqq/activity/recent/RecentCallHelper
    //   37: dup
    //   38: aload_0
    //   39: getfield 189	com/tencent/mobileqq/activity/Call:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: aload_0
    //   43: getfield 180	com/tencent/mobileqq/activity/Call:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   46: aload_0
    //   47: invokespecial 192	com/tencent/mobileqq/activity/recent/RecentCallHelper:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/view/View;Landroid/view/ViewStub$OnInflateListener;)V
    //   50: putfield 116	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   53: aload_0
    //   54: getfield 116	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper	Lcom/tencent/mobileqq/activity/recent/RecentCallHelper;
    //   57: invokevirtual 195	com/tencent/mobileqq/activity/recent/RecentCallHelper:l	()V
    //   60: aload_0
    //   61: ldc 196
    //   63: invokevirtual 176	com/tencent/mobileqq/activity/Call:findViewById	(I)Landroid/view/View;
    //   66: checkcast 198	android/widget/ImageView
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +9 -> 80
    //   74: aload_1
    //   75: ldc 199
    //   77: invokevirtual 202	android/widget/ImageView:setBackgroundResource	(I)V
    //   80: aload_0
    //   81: ldc 203
    //   83: invokevirtual 176	com/tencent/mobileqq/activity/Call:findViewById	(I)Landroid/view/View;
    //   86: checkcast 198	android/widget/ImageView
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +16 -> 107
    //   94: aload_1
    //   95: aload_0
    //   96: invokevirtual 207	com/tencent/mobileqq/activity/Call:getResources	()Landroid/content/res/Resources;
    //   99: ldc 208
    //   101: invokevirtual 214	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   104: invokevirtual 218	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   107: aload_0
    //   108: ldc 219
    //   110: invokevirtual 176	com/tencent/mobileqq/activity/Call:findViewById	(I)Landroid/view/View;
    //   113: checkcast 198	android/widget/ImageView
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +9 -> 127
    //   121: aload_1
    //   122: ldc 220
    //   124: invokevirtual 202	android/widget/ImageView:setBackgroundResource	(I)V
    //   127: return
    //   128: astore_1
    //   129: goto -49 -> 80
    //   132: astore_1
    //   133: return
    //   134: astore_1
    //   135: goto -28 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	Call
    //   69	53	1	localImageView	android.widget.ImageView
    //   128	1	1	localThrowable1	java.lang.Throwable
    //   132	1	1	localThrowable2	java.lang.Throwable
    //   134	1	1	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   74	80	128	java/lang/Throwable
    //   121	127	132	java/lang/Throwable
    //   94	107	134	java/lang/Throwable
  }
  
  private void h()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    ((FriendListHandler)this.app.a(1)).d(this.app.a(), (byte)2);
  }
  
  private void i()
  {
    ((FriendListHandler)this.app.a(1)).d(this.app.a(), (byte)2);
  }
  
  private void j()
  {
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CallTab", 2, localException.toString());
    }
  }
  
  private void k()
  {
    if (this.app != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver);
      if (this.app.a() != null) {
        this.app.a().deleteObserver(this);
      }
      QCallFacade localQCallFacade = (QCallFacade)this.app.getManager(37);
      if (localQCallFacade != null) {
        localQCallFacade.deleteObserver(this);
      }
      this.app.a(getClass(), null);
      this.app.a(getClass());
    }
    try
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CallTab", 2, localException.toString());
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      if (NetworkUtil.e(getActivity())) {
        break label41;
      }
      QQToast.a(getActivity(), getString(2131369501), 0).b(getTitleBarHeight());
    }
    label41:
    do
    {
      return;
      localObject = ((HotChatManager)this.app.getManager(58)).a();
    } while (localObject == null);
    Object localObject = HotChatInfo.createWifiPOIInfo((HotChatInfo)localObject);
    this.app.a(new dkl(this, (Common.WifiPOIInfo)localObject));
    m();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369502);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void n() {}
  
  public void a()
  {
    if (this.app != null)
    {
      QCallFacade localQCallFacade = (QCallFacade)this.app.getManager(37);
      if (localQCallFacade != null) {
        localQCallFacade.b(MessageCache.a());
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    String str1;
    if ((paramRecentBaseData instanceof RecentCallItem))
    {
      localObject2 = (RecentCallItem)paramRecentBaseData;
      localObject1 = ((RecentCallItem)localObject2).a();
      switch (((RecentCallItem)localObject2).c())
      {
      case 2: 
      default: 
        str1 = "99";
        localObject2 = localObject1;
        localObject1 = str1;
      }
    }
    for (;;)
    {
      int m;
      label101:
      String str2;
      if (localObject2 != null)
      {
        m = ((QCallRecent)localObject2).type;
        paramRecentBaseData = null;
        str1 = null;
        if (m == 1006)
        {
          str1 = ((QCallRecent)localObject2).uin;
          str2 = ((QCallRecent)localObject2).troopUin;
          if ((paramView == null) || (paramView.getId() != 2131299864)) {
            break label435;
          }
          if (!((QCallRecent)localObject2).isVideo()) {
            break label715;
          }
        }
      }
      label259:
      label276:
      label421:
      label428:
      label435:
      label715:
      for (int k = 0;; k = 1)
      {
        if ((((QCallRecent)localObject2).type == 3000) || (((QCallRecent)localObject2).type == 1)) {}
        label383:
        do
        {
          return;
          str1 = "0";
          localObject2 = localObject1;
          localObject1 = str1;
          break;
          str1 = "1";
          localObject2 = localObject1;
          localObject1 = str1;
          break;
          str1 = "2";
          localObject2 = localObject1;
          localObject1 = str1;
          break;
          paramRecentBaseData = ((QCallRecent)localObject2).uin;
          break label101;
          if (m == 1024)
          {
            if (k == 0) {
              break label383;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject1, "", "", "");
            paramRecentBaseData = this.app;
            if (!((QCallRecent)localObject2).isVideo()) {
              break label421;
            }
            paramView = "1";
            ReportController.b(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject1, "", "");
            paramRecentBaseData = this.app;
            if (!((QCallRecent)localObject2).isMissedCall()) {
              break label428;
            }
          }
          for (paramView = "0";; paramView = "1")
          {
            ReportController.b(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
            return;
            ChatActivityUtils.a(this.app, getActivity(), m, paramRecentBaseData, paramString, str1, true, str2, true, true, null, null);
            break;
            ReportController.b(this.app, "CliOper", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject1, "", "", "");
            break label259;
            paramView = "0";
            break label276;
          }
          paramView = new Intent(getActivity(), QCallDetailActivity.class);
          paramView.putExtra("uin", ((QCallRecent)localObject2).uin);
          paramView.putExtra("troop_uin", ((QCallRecent)localObject2).troopUin);
          paramView.putExtra("uintype", m);
          paramView.putExtra("uinname", paramString);
          paramView.putExtra("bind_type", ((QCallRecent)localObject2).bindType);
          paramView.putExtra("bind_id", ((QCallRecent)localObject2).bindId);
          paramView.putExtra("extra_type", ((QCallRecent)localObject2).extraType);
          paramView.putExtra("sig", ((QCallRecent)localObject2).lightalkSig);
          paramView.putExtra("entrance", "Call");
          startActivity(paramView);
          ReportController.b(this.app, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
          if (((QCallRecent)localObject2).type == 3000)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject1, "", "", "");
            return;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject1, "", "", "");
          return;
        } while (!QLog.isColorLevel());
        QLog.i("CallTab", 2, "onRecentBaseDataClick|call is null, data = " + paramRecentBaseData);
        return;
      }
      localObject1 = "99";
      localObject2 = null;
    }
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean)
  {
    paramView = paramContactsSearchableRecentUser.a();
    if (HotChatManager.b(paramView.uin)) {
      l();
    }
    do
    {
      do
      {
        return;
      } while (this.app == null);
      if ((QCallFacade)this.app.getManager(37) != null)
      {
        paramContactsSearchableRecentUser = new Intent(getActivity(), QCallDetailActivity.class);
        paramContactsSearchableRecentUser.putExtra("uin", paramView.uin);
        paramContactsSearchableRecentUser.putExtra("troop_uin", paramView.troopUin);
        paramContactsSearchableRecentUser.putExtra("uintype", paramView.type);
        paramContactsSearchableRecentUser.putExtra("uinname", paramString);
        paramContactsSearchableRecentUser.putExtra("entrance", "Call");
        startActivity(paramContactsSearchableRecentUser);
      }
      paramContactsSearchableRecentUser = new SearchHistory();
      paramContactsSearchableRecentUser.type = paramView.type;
      paramContactsSearchableRecentUser.uin = paramView.uin;
      paramContactsSearchableRecentUser.troopUin = paramView.troopUin;
      paramContactsSearchableRecentUser.displayName = paramString;
      paramView = (SearchHistoryManager)this.app.getManager(53);
    } while (paramView == null);
    paramView.a(paramContactsSearchableRecentUser);
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
    }
    do
    {
      do
      {
        return;
        if (paramView.getId() == 2131297331)
        {
          ReportController.b(this.app, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
          paramView = new Intent(getActivity(), ForwardRecentActivity.class);
          paramView.putExtra("forward_type", 13);
          startActivity(paramView);
          return;
        }
        if (paramView.getId() == 2131299865)
        {
          paramView = new Intent(getActivity(), PhoneFrameActivity.class);
          paramView.putExtra("key_req_type", 4);
          getActivity().startActivity(paramView);
          ReportController.b(this.app, "CliOper", "", "", "0X8004F82", "0X8004F82", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() == 2131299877)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.app, true, true, true);
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8004C0C", "0X8004C0C", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() == 2131299875)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.app, true, true, true);
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8004F85", "0X8004F85", 0, 0, "", "", "", "");
          return;
        }
      } while ((paramView.getId() != 2131297249) && (paramView.getId() != 2131297250) && (paramView.getId() != 2131297251) && (paramView.getId() != 2131297252) && (paramView.getId() != 2131297253) && (paramView.getId() != 2131297254) && (paramView.getId() != 2131297255));
      if (QLog.isColorLevel()) {
        QLog.i("CallTab", 2, "onItemClick uin: " + paramObject);
      }
      paramView = (String)paramObject;
      paramObject = ContactUtils.j(this.app, paramView);
      ChatActivityUtils.a(this.app, getActivity(), 0, paramView, paramObject, null, true, null, true, true, null, null);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.b())) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004C0D", "0X8004C0D", 0, 0, "", "", "", "");
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.c()));
    ReportController.b(this.app, "CliOper", "", "", "0X8004C12", "0X8004C12", 0, 0, "", "", "", "");
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    QCallFacade localQCallFacade = (QCallFacade)this.app.getManager(37);
    if ((localQCallFacade != null) && (paramRecentBaseData != null))
    {
      localQCallFacade.b(paramRecentBaseData.a(), paramRecentBaseData.a());
      ReportController.b(this.app, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
    }
    if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2")))
    {
      if (paramRecentBaseData.a() == 3000) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      do
      {
        return;
        this.j = paramInt;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramAbsListView, paramInt);
    } while ((paramInt != 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean));
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "onScrollStateChanged list idle refresh list");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_b_of_type_AndroidOsHandler);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new CustomHandler(ThreadManager.c(), this);
    }
    j();
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.app, false);
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CallTab", 2, "filldata|change account, clear data ,and refresh");
        }
        Message localMessage = Message.obtain();
        localMessage.what = 16;
        localMessage.arg1 = 1;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
    }
    d();
  }
  
  protected boolean a()
  {
    return (this.j != 0) && (this.j != 1);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      boolean bool = NetworkUtil.e(BaseApplication.getContext());
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView, this.app, this.jdField_a_of_type_AndroidOsHandler, bool);
    }
    return true;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, "isRefreshRecentDataNecesary: mIsForeground|" + this.jdField_b_of_type_Boolean + ", msg.arg1|" + paramMessage.arg1);
    }
    return ((this.jdField_b_of_type_Boolean) || (paramMessage.arg1 != 0)) && (this.app.isLogin());
  }
  
  protected void addTopLayout() {}
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this, 2130968752));
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    g();
    n();
    reLayoutClipParams(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup);
    a(false);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.b(paramInt, paramView, paramListView);
    }
  }
  
  public void c()
  {
    RecentCallHelper localRecentCallHelper;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label44;
      }
      localRecentCallHelper = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
      if (a()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localRecentCallHelper.a(bool, true, this.jdField_b_of_type_AndroidOsHandler);
      return;
    }
    label44:
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean = true;
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 189	com/tencent/mobileqq/activity/Call:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 189	com/tencent/mobileqq/activity/Call:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: bipush 37
    //   23: invokevirtual 292	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   26: checkcast 294	com/tencent/mobileqq/qcall/QCallFacade
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +8 -> 39
    //   34: aload_2
    //   35: aload_0
    //   36: invokevirtual 705	com/tencent/mobileqq/qcall/QCallFacade:addObserver	(Ljava/util/Observer;)V
    //   39: aload_0
    //   40: getfield 189	com/tencent/mobileqq/activity/Call:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 708	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   46: invokevirtual 712	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	()V
    //   49: goto -35 -> 14
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Call
    //   9	2	1	bool	boolean
    //   29	6	2	localQCallFacade	QCallFacade
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	52	finally
    //   17	30	52	finally
    //   34	39	52	finally
    //   39	49	52	finally
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("CallTab", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((-1 != paramInt2) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("roomId");
    } while (paramIntent == null);
    ReportController.b(this.app, "CliOper", "", "", "Multi_call", "Multi_call_shortcut_launch", 0, 0, "", "", "", "");
    ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, null);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    reLayoutClipParams(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramConfiguration, false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903133);
    b();
    return false;
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.c();
    }
    this.jdField_b_of_type_Boolean = true;
    getActivity().getWindow().setSoftInputMode(32);
    this.j = 0;
    if (this.d)
    {
      if (!this.e) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1020);
      }
      c();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1030, 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.app, 0, false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_b_of_type_AndroidOsHandler);
        }
      }
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1025, 3000L);
    }
  }
  
  protected void doWhenFragmentReplace(Fragment paramFragment1, Fragment paramFragment2)
  {
    if ((paramFragment2 == null) && (getResources().getConfiguration().orientation == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.app, true, false, false);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label14:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.c) || (getActivity() == null) || (getActivity().isFinishing())) {}
    do
    {
      do
      {
        return true;
      } while ((paramMessage.what != 16) || (!a(paramMessage)) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.app, getActivity(), this.jdField_a_of_type_AndroidOsHandler);
    } while (!QLog.isColorLevel());
    QLog.d("CallTab", 2, "Call.handleMessage");
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.n();
  }
  
  protected void onDestroy()
  {
    this.c = true;
    k();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.e();
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this, paramViewStub, paramView, this.app, this.jdField_a_of_type_AndroidViewViewGroup, null, this, this, this);
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramLogoutReason);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.d();
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16);
    }
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.l();
    }
  }
  
  public void rightPanelEmpty()
  {
    super.rightPanelEmpty();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.n();
  }
  
  protected String setLastActivityName()
  {
    return getString(2131366026);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    Object localObject = paramIntent.getComponent();
    if ((localObject != null) && (((ComponentName)localObject).getClassName().equals(QCallDetailActivity.class.getName())))
    {
      int k = paramIntent.getIntExtra("uintype", -1);
      localObject = paramIntent.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(k, (String)localObject);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof QCallFacade))
    {
      if (!(paramObject instanceof Boolean)) {
        break label101;
      }
      if (((Boolean)paramObject).booleanValue()) {
        if (this.app == null) {
          break label229;
        }
      }
    }
    label101:
    label229:
    for (paramObservable = (QCallFacade)this.app.getManager(37);; paramObservable = null)
    {
      if (paramObservable != null) {
        paramObservable.a(false);
      }
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null) && (RecentUtil.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1027))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1027, 100L);
      }
      return;
      if (this.app != null) {}
      for (paramObservable = (QCallFacade)this.app.getManager(37);; paramObservable = null)
      {
        if (paramObservable == null)
        {
          paramObservable = null;
          label127:
          if ((paramObservable != null) && (paramObservable.size() != 0)) {
            break label185;
          }
          getActivity().runOnUiThread(new dku(this));
        }
        for (;;)
        {
          getActivity().runOnUiThread(new dkw(this));
          c();
          break;
          paramObservable = paramObservable.a();
          break label127;
          if ((paramObject instanceof Integer))
          {
            if (((Integer)paramObject).intValue() > 0) {
              getActivity().runOnUiThread(new dkv(this));
            }
            c();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Call
 * JD-Core Version:    0.7.0.1
 */