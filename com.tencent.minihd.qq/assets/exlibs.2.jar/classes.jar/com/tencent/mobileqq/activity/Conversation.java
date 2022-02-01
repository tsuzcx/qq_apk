package com.tencent.mobileqq.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.activity.widget.WidgetContainer.OnWidgetMoveListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.customviews.CircleMenu.Builder;
import com.tencent.mobileqq.customviews.CircleMenuManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.newfriend.NewFriendPushListener;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.LbsTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.CustomRelativeLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.CustomHorizontalLoadingBar;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.TraceUtils;
import cooperation.qlink.QQProxyForQlink;
import dsd;
import dsi;
import dsj;
import dsk;
import dsl;
import dsp;
import dsq;
import dss;
import dst;
import dsu;
import dsv;
import dsw;
import dsx;
import dsy;
import dta;
import dtb;
import dtc;
import dtd;
import dtf;
import dtg;
import dth;
import dti;
import dtj;
import dtk;
import dtl;
import dtm;
import dtn;
import dto;
import dtp;
import dts;
import dtt;
import dtu;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.BasePadActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MyFragment;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class Conversation
  extends BaseActivity
  implements Handler.Callback, UpgradeTipsDialog.OnPreparedListener, OnRecentUserOpsListener, WidgetContainer.OnWidgetMoveListener, AppConstants, QQTabHost.OnTabSelectionListener, AbsListView.OnScrollListener, OverScrollViewListener, Observer
{
  public static final int A = 1020;
  public static final int B = 1023;
  public static final int C = 1025;
  public static final int D = 1030;
  public static final int E = 1134025;
  public static final int F = 1134026;
  public static final int G = 1031;
  public static final int H = 1032;
  public static final int I = 1033;
  public static final int J = 1034;
  public static final int K = 1035;
  public static final int L = 1036;
  public static final int M = 1037;
  public static final int N = 9001;
  public static final int O = 9002;
  public static final int P = 16;
  protected static final int Q = 1;
  protected static final int R = 0;
  protected static final int S = 1;
  protected static final int T = 2;
  protected static final int U = 3;
  public static final int V = 0;
  public static final int W = 1;
  public static final int a = 10000;
  protected static final long a = 300000L;
  public static final String a = "conversation";
  public static WeakReference a;
  private static final int aa = 17;
  private static final int ab = 12;
  private static final int ac = 11;
  private static final int ad = 10;
  private static final int ae = 9;
  private static final int af = 8;
  private static final int aj = 250;
  private static final int al = 5;
  public static final int b = 10001;
  public static final String b = "from";
  public static boolean b = false;
  public static final int c = 10002;
  public static final String c = "conversation_index";
  public static final int d = 1009;
  private static final String jdField_d_of_type_JavaLangString = "Q.recent";
  public static final int e = 11340003;
  public static final int f = 11340004;
  public static final int g = 11340006;
  public static final int h = 11340007;
  public static final int i = 1134010;
  public static final int j = 1134011;
  public static final int k = 1134012;
  public static final int l = 1134013;
  public static final int m = 1134014;
  public static final int n = 1134015;
  public static final int o = 1134018;
  public static final int p = 1134019;
  public static final int q = 1134020;
  public static final int r = 1134021;
  public static final int s = 1134022;
  public static final int t = 1134024;
  public static final int u = 1010;
  public static final int v = 1013;
  public static final int w = 1014;
  public static final int x = 1016;
  public static final int y = 1017;
  public static final int z = 1019;
  private float jdField_a_of_type_Float = -1.0F;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dsx(this);
  protected Handler.Callback a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ConversationHotChatCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = null;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog;
  public BannerManager a;
  private LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private WidgetContainer jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer;
  protected BizTroopObserver a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dsp(this);
  private final ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new dsj(this);
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new dst(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new dsq(this);
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dtp(this);
  private final HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new dtt(this, null);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dsl(this);
  private final SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new dsu(this);
  private final TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dts(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new dsk(this);
  private final FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dss(this);
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private final NewFriendPushListener jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener = new dtd(this);
  private final GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new dsv(this);
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new dsw(this);
  VipGiftManager jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = null;
  private CustomRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  private CustomHorizontalLoadingBar jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar;
  private dtu jdField_a_of_type_Dtu;
  protected StringBuilder a;
  Comparator jdField_a_of_type_JavaUtilComparator = new dtf(this);
  public List a;
  protected boolean a;
  private int ag = 0;
  private int ah = -1;
  private int ai;
  private int ak = -1;
  private float jdField_b_of_type_Float = 0.0F;
  public long b;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new dsy(this);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List jdField_b_of_type_JavaUtilList = new ArrayList(40);
  private float jdField_c_of_type_Float = 0.0F;
  private long jdField_c_of_type_Long;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new dta(this);
  private final Handler jdField_c_of_type_AndroidOsHandler = new dtj(this);
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long;
  private long e = 0L;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  
  static
  {
    jdField_b_of_type_Boolean = false;
  }
  
  public Conversation()
  {
    this.jdField_b_of_type_Long = 2000L;
    this.d = 0L;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new dsd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new dsi(this);
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "addObservers");
    }
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver, true);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    Object localObject = (RedTouchManager)this.app.getManager(35);
    if (localObject != null) {
      ((RedTouchManager)localObject).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { LbsTransfileProcessor.class, BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    try
    {
      localObject = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      localObject = new IntentFilter("android.intent.action.TIME_SET");
      ((IntentFilter)localObject).addAction("android.intent.action.DATE_CHANGED");
      ((IntentFilter)localObject).addAction("android.intent.action.TIMEZONE_CHANGED");
      registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.recent", 2, localException.toString());
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "removeObservers");
    }
    if (this.app != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      if (this.app.a() != null) {
        this.app.a().deleteObserver(this);
      }
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.app.a(getClass(), null);
      this.app.a(getClass());
      Object localObject = (QCallFacade)this.app.getManager(37);
      if (localObject != null) {
        ((QCallFacade)localObject).deleteObserver(this);
      }
      localObject = (RedTouchManager)this.app.getManager(35);
      if (localObject != null) {
        ((RedTouchManager)localObject).deleteObserver(this);
      }
    }
    try
    {
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.recent", 2, localException.toString());
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      if (NetworkUtil.e(this)) {
        break label35;
      }
      QQToast.a(this, getString(2131369501), 0).b(getTitleBarHeight());
    }
    label35:
    do
    {
      return;
      localObject = ((HotChatManager)this.app.getManager(58)).a();
    } while (localObject == null);
    Object localObject = HotChatInfo.createWifiPOIInfo((HotChatInfo)localObject);
    this.app.a(new dtb(this, (Common.WifiPOIInfo)localObject));
    D();
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
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
  
  private void E()
  {
    if (SubAccountControll.a(this.app, "sub.uin.all"))
    {
      SubAccountControll localSubAccountControll = (SubAccountControll)this.app.getManager(60);
      if (localSubAccountControll != null)
      {
        ArrayList localArrayList = localSubAccountControll.a("sub.uin.all");
        int i2 = localArrayList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          Pair localPair = (Pair)localArrayList.get(i1);
          localSubAccountControll.a(this.app, this, localPair, new dtc(this, localSubAccountControll, localPair));
          i1 += 1;
        }
      }
    }
  }
  
  private void F()
  {
    this.jdField_a_of_type_AndroidViewView = getParent().findViewById(2131297977);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer = ((WidgetContainer)findViewById(2131297307));
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.setWidgetMoveListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.a(this.app, this);
    a(false, getResources().getConfiguration());
  }
  
  private int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    long l1 = Math.max(paramRecentUser1.lastmsgtime, paramRecentUser1.lastmsgdrafttime);
    long l2 = Math.max(paramRecentUser2.lastmsgtime, paramRecentUser2.lastmsgdrafttime);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
  
  private void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      QQToast.a(BaseApplication.getContext(), 2131365730, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492923));
    }
    while (paramString == null) {
      return;
    }
    paramString = ((FriendManager)this.app.getManager(8)).a(paramString);
    if (paramString != null)
    {
      int i2 = paramString.size();
      long[] arrayOfLong = new long[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(i1);
        if (localDiscussionMemberInfo != null) {
          arrayOfLong[i1] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i1 += 1;
      }
    }
    getActivity().overridePendingTransition(2130968593, 0);
  }
  
  private void b(long paramLong)
  {
    if (this.f) {
      a(1016, paramLong, true);
    }
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ConfigHandler.a(this.app) >= 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((ConfigHandler.b(this.app)) || (ConfigHandler.a(this.app, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = new UpgradeTipsDialog(getActivity(), this.app, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new dtl(this));
  }
  
  public static void b(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.setDrawerEnabled(paramBoolean);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameEnable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  public static boolean c()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get(); localDrawerFrame == null; localDrawerFrame = null) {
      return false;
    }
    if ((localDrawerFrame.b()) || (localDrawerFrame.c())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "changeConversationLoadingState|[" + paramBoolean + "," + bool1 + "," + bool2 + "]");
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_c_of_type_AndroidOsHandler.removeMessages(3);
    }
    if ((bool1) || (bool2)) {
      a(false, true);
    }
    do
    {
      do
      {
        return;
        int i1 = LoadingStateManager.a().a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "changeConversationLoadingState|loadingState = " + i1);
        }
        switch (i1)
        {
        default: 
          return;
        case 0: 
        case 3: 
          a(false, false);
          return;
        case 1: 
          a(true, false);
        }
      } while (this.jdField_c_of_type_AndroidOsHandler.hasMessages(4));
      this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 180000L);
      return;
      a(true, false);
    } while (this.jdField_c_of_type_AndroidOsHandler.hasMessages(3));
    this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 180000L);
    return;
    a(false, true);
  }
  
  public static void h()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null) {
        localDrawerFrame.f();
      }
      return;
    }
  }
  
  public static void i()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if ((localDrawerFrame != null) && (localDrawerFrame.b())) {
        localDrawerFrame.e();
      }
      return;
    }
  }
  
  private void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.i);
    }
    if (this.i) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1025);
    this.i = true;
    if (!this.j) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.a.onActivityFocusChanged(this, true);
  }
  
  private void n()
  {
    if (this.app.a().a().b("9998", 0) == null) {}
    String str;
    do
    {
      return;
      str = SystemMsgController.a().a(this.app);
    } while ((str != null) && (!str.equals("")));
    this.app.u();
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.s());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.s() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
    int i1 = this.ah + 1;
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
        if (!(localObject instanceof RecentBaseData))
        {
          i1 += 1;
        }
        else
        {
          localObject = (RecentBaseData)localObject;
          if (((RecentBaseData)localObject).a())
          {
            i2 = ((RecentBaseData)localObject).b();
            label124:
            if (i2 <= 0) {
              break label173;
            }
            this.ah = i1;
          }
        }
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.ah + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.m(), 0);
        return;
      }
      o();
      this.ah = -1;
      return;
      i2 = 0;
      break label124;
      label173:
      break;
    }
  }
  
  private void q()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.e);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(getActivity().getContentResolver(), "date_format");
      if (str != null)
      {
        TimeManager.a().a(str);
        TimeManager.a().a();
        this.e = l1;
      }
    }
  }
  
  private void r() {}
  
  private void s() {}
  
  private void t()
  {
    if (LoadingStateManager.a().c()) {
      LoadingStateManager.a().a(3);
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.show();
      ConfigHandler.a(this.app);
      int i1 = ConfigHandler.a(this.app);
      ConfigHandler.b(this.app, i1 + 1);
      ReportController.b(this.app, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      ReportController.b(this.app, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void v()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = new ConversationHotChatCtrl(this);
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    x();
    a(false);
    StartupTracker.a("Recent_OnCreate", null);
    w();
  }
  
  private void w()
  {
    CircleMenu.Builder localBuilder = new CircleMenu.Builder(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout).a(new int[] { 2130838055, 2130838041, 2130838056 });
    dtm localdtm = new dtm(this);
    CircleMenuManager.a(241, localBuilder.a(new int[] { 2131366332, 2131369848, 2131367975 }, localdtm).a(2130838054));
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((SplashActivity)getParent()).a();
    this.jdField_a_of_type_Dtu = new dtu(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Dtu, false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout = ((CustomRelativeLayout)findViewById(2131296742));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.setWidgetMoveListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297308));
    this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar = ((CustomHorizontalLoadingBar)this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.findViewById(2131297305));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.findViewById(2131297304));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setChoiceMode(1);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(new ColorDrawable(-1));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
    j();
    Object localObject;
    if ((this != null) && ((this instanceof SplashActivity)))
    {
      SplashActivity localSplashActivity = (SplashActivity)this;
      localObject = localSplashActivity.b;
      localSplashActivity.b = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout, null, this, this, (View)localObject, 4, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager = new BannerManager(this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(new View(this));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnInterceptTouchListener(new dtn(this));
      localObject = RecentDataListManager.a().jdField_b_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      reLayoutClipParams(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout, this.jdField_a_of_type_AndroidViewViewGroup);
      F();
      return;
      localObject = null;
    }
  }
  
  private void y()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    a(1010, 0L, false);
    a(1023, 0L, false);
    u();
    VipBannerInfo.a(this);
    if (!this.jdField_a_of_type_Boolean) {
      ((FriendListHandler)this.app.a(1)).d(this.app.a(), (byte)2);
    }
    z();
  }
  
  private void z()
  {
    Object localObject = getActivity();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        ReportController.b(this.app, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void a()
  {
    B();
  }
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost) {}
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (this.jdField_b_of_type_AndroidOsHandler == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshRecentList|invalidate to refresh");
      }
      return;
    }
    if (!b())
    {
      this.h = false;
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(11);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramObject;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
    this.h = true;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
    {
      if (this.f) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  protected void a(int paramInt, RecentUser paramRecentUser)
  {
    if ((paramRecentUser == null) || (paramInt == 0)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshAfterClick|[" + paramRecentUser + "," + paramInt + "]");
      }
    }
    do
    {
      return;
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(paramRecentUser.uin);
      }
    } while ((paramInt & 0x2) == 0);
    a(8, paramRecentUser.uin, paramRecentUser.type);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(0, paramInt1, RecentDataListManager.a(paramString, paramInt2));
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()))
    {
      this.jdField_a_of_type_Dtu.a(paramInt, paramList);
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        if (AppSetting.k) {
          this.app.p();
        }
      }
      return;
    }
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList != null) {
        break label201;
      }
    }
    label201:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.i("Q.recent", 4, i1 + "]");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        if (paramInt != 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(paramList);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      }
      if (AppSetting.k) {
        this.app.p();
      }
      this.app.A();
      a(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10001, null));
      d(false);
      return;
    }
    if (paramList == null)
    {
      paramInt = 0;
      label217:
      i1 = 0;
      label219:
      if (i1 < paramInt)
      {
        localObject = (RecentBaseData)paramList.get(i1);
        if (localObject != null) {
          break label258;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label219;
      break;
      paramInt = paramList.size();
      break label217;
      label258:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((RecentBaseData)localObject);
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (str != null) {
        ReportController.b(this.app, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + paramInt + ", tag = " + str);
      }
      return;
      if (paramBoolean)
      {
        str = "0X800402E";
      }
      else
      {
        str = "0X800402F";
        continue;
        str = "0X8004032";
        continue;
        str = "0X8004030";
        continue;
        str = "0X8004031";
      }
    }
  }
  
  public void a(long paramLong)
  {
    a(0, 10, Long.valueOf(paramLong));
  }
  
  public void a(Message paramMessage)
  {
    int i2 = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
    }
    boolean bool;
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        bool = false;
        if (!bool) {
          break label231;
        }
        r();
        label50:
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "refreshStatusInfo bShowNetBar=" + bool);
        }
        LoadingStateManager.a().a(bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
        {
          if (this.app.f) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(4, 0);
          }
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
          if (!bool) {
            break label238;
          }
          i1 = 2;
          label129:
          paramMessage.a(1, i1);
          bool = LoadingStateManager.a().e();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
          if (!bool) {
            break label243;
          }
        }
      }
    }
    label231:
    label238:
    label243:
    for (int i1 = i2;; i1 = 0)
    {
      paramMessage.a(5, i1);
      LoadingStateManager.a().b(bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(null);
      return;
      bool = true;
      break;
      if (paramMessage.obj.toString().equals(getString(2131365730)))
      {
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          bool = false;
          break;
        }
        bool = true;
        break;
      }
      bool = false;
      break;
      s();
      break label50;
      i1 = 0;
      break label129;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (getResources().getConfiguration().orientation == 1)
    {
      if (paramMotionEvent.getAction() != 0) {
        break label48;
      }
      this.ak = getLefPanelWidth();
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_c_of_type_Float = 0.0F;
    }
    label48:
    do
    {
      return;
      if (paramMotionEvent.getAction() == 1)
      {
        if (this.jdField_c_of_type_Float >= this.ak / 4)
        {
          k();
          return;
        }
        c(false);
        return;
      }
    } while (paramMotionEvent.getAction() != 2);
    this.jdField_b_of_type_Float = (paramMotionEvent.getRawX() - this.jdField_a_of_type_Float);
    if ((this.jdField_b_of_type_Float > 0.0F) && (this.jdField_c_of_type_Float < 0.0F)) {}
    for (this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;; this.jdField_c_of_type_Float += this.jdField_b_of_type_Float)
    {
      float f1 = this.jdField_a_of_type_AndroidViewView.getScrollX() - this.jdField_b_of_type_Float;
      if ((f1 >= 0.0F) && (f1 <= this.ak)) {
        this.jdField_a_of_type_AndroidViewView.scrollBy((int)-this.jdField_b_of_type_Float, 0);
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      return;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      StartupTracker.a(null, "AIO_Click_cost");
      ThreadPriorityManager.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
      }
      paramView = null;
      if ((paramRecentBaseData instanceof RecentUserBaseData)) {
        paramView = ((RecentUserBaseData)paramRecentBaseData).a();
      }
      if ((paramView != null) && (HotChatManager.b(paramView.uin))) {
        C();
      }
      for (;;)
      {
        if (paramRecentBaseData != null)
        {
          paramRecentBaseData.b();
          this.h = true;
        }
        StartupTracker.a("AIO_Click_cost", null);
        return;
        a(RecentUtil.a(getActivity(), this.app, paramView, paramString, paramBoolean), paramView);
      }
    }
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
      if (localObject2 != null)
      {
        int i1 = ((QCallRecent)localObject2).type;
        paramRecentBaseData = null;
        str1 = null;
        if (i1 == 1006) {
          str1 = ((QCallRecent)localObject2).uin;
        }
        String str2;
        for (;;)
        {
          str2 = ((QCallRecent)localObject2).troopUin;
          if ((paramView == null) || (paramView.getId() != 2131299864)) {
            break label752;
          }
          paramBoolean = true;
          if (((QCallRecent)localObject2).isVideo()) {
            paramBoolean = false;
          }
          if (((QCallRecent)localObject2).type != 8) {
            break label450;
          }
          i1 = ((QCallRecent)localObject2).extraType;
          paramView = new HashMap();
          paramView.put("dstClient", "Lightalk");
          paramView.put("bindType", String.valueOf(((QCallRecent)localObject2).bindType));
          paramView.put("bindId", ((QCallRecent)localObject2).bindId);
          paramView.put("extraType", String.valueOf(((QCallRecent)localObject2).extraType));
          if (((QCallRecent)localObject2).lightalkSig != null) {
            paramView.put("sig", HexUtil.a(((QCallRecent)localObject2).lightalkSig));
          }
          ChatActivityUtils.a(this.app, getActivity(), i1, paramRecentBaseData, paramString, str1, true, ((QCallRecent)localObject2).troopUin, true, true, null, null, paramView);
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
        }
        label450:
        if ((((QCallRecent)localObject2).type == 3000) || (((QCallRecent)localObject2).type == 1)) {
          break;
        }
        if (i1 == 1024) {
          if (CrmUtils.b(this.app, paramRecentBaseData, i1))
          {
            label491:
            if (!paramBoolean) {
              break label700;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject1, "", "", "");
            label531:
            paramRecentBaseData = this.app;
            if (!((QCallRecent)localObject2).isVideo()) {
              break label738;
            }
            paramView = "1";
            label548:
            ReportController.b(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject1, "", "");
            paramRecentBaseData = this.app;
            if (!((QCallRecent)localObject2).isMissedCall()) {
              break label745;
            }
          }
        }
        label700:
        label738:
        label745:
        for (paramView = "0";; paramView = "1")
        {
          ReportController.b(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
          return;
          QQToast.a(paramView.getContext(), 2131363061, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131492923));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.recent", 2, "Don't support ivr");
          return;
          ChatActivityUtils.a(this.app, getActivity(), i1, paramRecentBaseData, paramString, str1, paramBoolean, str2, true, true, null, null);
          break label491;
          ReportController.b(this.app, "CliOper", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject1, "", "", "");
          break label531;
          paramView = "0";
          break label548;
        }
        label752:
        paramView = new Intent(getActivity(), QCallDetailActivity.class);
        paramView.putExtra("uin", ((QCallRecent)localObject2).uin);
        paramView.putExtra("troop_uin", ((QCallRecent)localObject2).troopUin);
        paramView.putExtra("uintype", i1);
        paramView.putExtra("uinname", paramString);
        paramView.putExtra("bind_type", ((QCallRecent)localObject2).bindType);
        paramView.putExtra("bind_id", ((QCallRecent)localObject2).bindId);
        paramView.putExtra("extra_type", ((QCallRecent)localObject2).extraType);
        paramView.putExtra("sig", ((QCallRecent)localObject2).lightalkSig);
        paramView.putExtra("entrance", "Conversation");
        startActivity(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "sig = " + ((QCallRecent)localObject2).lightalkSig);
        }
        ReportController.b(this.app, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
        if (((QCallRecent)localObject2).type == 3000)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject1, "", "", "");
          return;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject1, "", "", "");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, "onRecentBaseDataClick|call is null, data = " + paramRecentBaseData);
      return;
      localObject1 = "99";
      localObject2 = null;
    }
  }
  
  public void a(View paramView, ContactsSearchableRecentUser paramContactsSearchableRecentUser, String paramString, boolean paramBoolean)
  {
    paramView = paramContactsSearchableRecentUser.a();
    if (HotChatManager.b(paramView.uin)) {
      C();
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.app != null) && (!this.jdField_a_of_type_Boolean))
          {
            paramContactsSearchableRecentUser = (QCallFacade)this.app.getManager(37);
            if (paramContactsSearchableRecentUser != null)
            {
              paramContactsSearchableRecentUser = paramContactsSearchableRecentUser.a(paramView.uin, paramView.type);
              if ((paramContactsSearchableRecentUser != null) && (!paramContactsSearchableRecentUser.isEmpty()))
              {
                paramContactsSearchableRecentUser = new Intent(getActivity(), QCallDetailActivity.class);
                paramContactsSearchableRecentUser.putExtra("uin", paramView.uin);
                paramContactsSearchableRecentUser.putExtra("troop_uin", paramView.troopUin);
                paramContactsSearchableRecentUser.putExtra("uintype", paramView.type);
                paramContactsSearchableRecentUser.putExtra("uinname", paramString);
                paramContactsSearchableRecentUser.putExtra("entrance", "Conversation");
                startActivity(paramContactsSearchableRecentUser);
                return;
              }
            }
          }
          a(RecentUtil.a(getActivity(), this.app, paramView, paramString, paramBoolean), paramView);
          paramContactsSearchableRecentUser = new SearchHistory();
          paramContactsSearchableRecentUser.type = paramView.type;
          paramContactsSearchableRecentUser.uin = paramView.uin;
          paramContactsSearchableRecentUser.troopUin = paramView.troopUin;
          paramContactsSearchableRecentUser.displayName = paramString;
          paramString = (SearchHistoryManager)this.app.getManager(53);
        } while (paramString == null);
        paramString.a(paramContactsSearchableRecentUser);
        paramContactsSearchableRecentUser = (FriendManager)this.app.getManager(8);
      } while (paramContactsSearchableRecentUser == null);
      paramView = paramContactsSearchableRecentUser.c(paramView.uin);
    } while ((paramView == null) || (paramView.gathtertype != 1));
    ReportController.b(this.app, "CliOper", "", "", "0X8004C58", "0X8004C58", 2, 0, "", "", "", "");
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
        ReportController.b(this.app, "CliOper", "", "", "0X8004C0C", "0X8004C0C", 0, 0, "", "", "", "");
        return;
      }
      if (paramView.getId() == 2131299875)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004F85", "0X8004F85", 0, 0, "", "", "", "");
        return;
      }
    } while ((paramView.getId() != 2131297249) && (paramView.getId() != 2131297250) && (paramView.getId() != 2131297251) && (paramView.getId() != 2131297252) && (paramView.getId() != 2131297253) && (paramView.getId() != 2131297254) && (paramView.getId() != 2131297255));
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
    }
    paramView = (String)paramObject;
    paramObject = ContactUtils.j(this.app, paramView);
    ChatActivityUtils.a(this.app, getActivity(), 0, paramView, paramObject, null, true, null, true, true, null, null);
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    u();
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = null;
      if ((paramRecentBaseData instanceof RecentUserBaseData)) {
        paramString = ((RecentUserBaseData)paramRecentBaseData).a();
      }
      if (paramString != null)
      {
        a(paramString);
        RecentUtil.b(this.app, paramString);
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramString);
      }
    }
    do
    {
      return;
      QCallFacade localQCallFacade = (QCallFacade)this.app.getManager(37);
      if ((localQCallFacade != null) && (paramRecentBaseData != null))
      {
        localQCallFacade.b(paramRecentBaseData.a(), paramRecentBaseData.a());
        ReportController.b(this.app, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
      }
    } while ((paramRecentBaseData == null) || (paramString == null) || (!paramString.equalsIgnoreCase("2")));
    if (paramRecentBaseData.a() == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
  }
  
  public void a(RecentUser paramRecentUser)
  {
    String str = paramRecentUser.uin;
    int i1 = paramRecentUser.type;
    paramRecentUser = getTopFragment();
    if ((paramRecentUser instanceof MyFragment))
    {
      BasePadActivity localBasePadActivity = ((MyFragment)paramRecentUser).getBasePadAct();
      if (((localBasePadActivity instanceof ChatActivity)) && (((ChatActivity)localBasePadActivity).a(str, i1)))
      {
        ((MyFragment)paramRecentUser).setNoAnimOnce(true);
        localBasePadActivity.finish();
      }
    }
  }
  
  public void a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((this.app.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.app.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) && (paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.d == 0L) && (paramVipGiftDownloadInfo.a != 0L)) {
      paramVipGiftManager.a(paramVipGiftDownloadInfo.a);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    for (;;)
    {
      return;
      this.ag = paramInt;
      if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
      {
        if ((paramInt != 0) && (paramInt != 1)) {
          break label93;
        }
        this.ah = (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.s() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.m());
        if (this.ah < -1) {
          this.ah = -1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
        }
      }
      while ((paramInt == 0) && (this.h))
      {
        a(100L);
        return;
        label93:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Object localObject = getResources();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(this.app, this);
    }
    if (Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3])))
    {
      ChatActivityUtils.a(this.app, this, i1, paramRecentBaseData.a(), true, true, null);
      ReportController.b(this.app, "CliOper", "", "", "0X800416A", "0X800416A", 0, 0, "1", "", paramString2, "");
    }
    label175:
    label202:
    label343:
    label351:
    label359:
    do
    {
      do
      {
        do
        {
          return;
          if (Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2])))
          {
            String str;
            if (i1 == 0)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X800416A", "0X800416A", 0, 0, "0", "", paramString2, "");
              paramString2 = null;
              str = paramRecentBaseData.b();
              localObject = null;
              paramString1 = null;
              if (i1 != 1006) {
                break label343;
              }
              localObject = paramRecentBaseData.a();
              if ((i1 == 1000) || (i1 == 1004))
              {
                paramString1 = null;
                if ((paramRecentBaseData instanceof RecentUserBaseData)) {
                  paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
                }
                if (paramString1 != null) {
                  break label351;
                }
              }
            }
            for (paramString1 = null;; paramString1 = paramString1.troopUin)
            {
              if (i1 != 1024) {
                break label359;
              }
              if (CrmUtils.b(this.app, paramString2, i1)) {
                break;
              }
              QQToast.a(getActivity(), 2131363061, 1).b(getActivity().getResources().getDimensionPixelSize(2131492923));
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.recent", 2, "Don't support ivr");
              return;
              ReportController.b(this.app, "CliOper", "", "", "0X800416A", "0X800416A", 0, 0, "2", "", paramString2, "");
              break label175;
              paramString2 = paramRecentBaseData.a();
              break label202;
            }
            ChatActivityUtils.a(this.app, getActivity(), i1, paramString2, str, (String)localObject, true, paramString1, true, true, null, null);
            return;
          }
          if (!Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4]))) {
            break;
          }
          if (i1 == 7000)
          {
            SubAccountControll.a(this.app, paramRecentBaseData.a(), false);
            ReportController.b(this.app, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", "0", paramString2, "");
            return;
          }
        } while (i1 != 5000);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, false);
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", "0", paramString2, "");
        return;
        if (!Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5]))) {
          break;
        }
        if (i1 == 7000)
        {
          SubAccountControll.a(this.app, paramRecentBaseData.a(), true);
          ReportController.b(this.app, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", "1", paramString2, "");
          return;
        }
      } while (i1 != 5000);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, true);
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", "1", paramString2, "");
      return;
    } while ((i1 != 1) || (!Utils.a(paramString1, ((Resources)localObject).getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]))));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData);
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800416B", "0X800416B", 0, 0, "0", "", paramString2, "");
  }
  
  protected void a(List paramList)
  {
    int i1 = 0;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, [");
      }
    }
    else {
      if (paramList != null) {
        break label143;
      }
    }
    for (;;)
    {
      i1 -= 1;
      while (i1 >= 0)
      {
        RecentUser localRecentUser = (RecentUser)paramList.get(i1);
        if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
        {
          paramList.remove(i1);
          if (QLog.isDevelopLevel()) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(i1).append(",").append(localRecentUser.type).append(";");
          }
        }
        i1 -= 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      break;
      label143:
      i1 = paramList.size();
    }
    if (QLog.isDevelopLevel())
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("]");
      QLog.i("Q.recent", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  /* Error */
  protected void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 791	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +48 -> 51
    //   6: ldc 102
    //   8: iconst_4
    //   9: new 793	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 794	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1689
    //   19: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 803	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 820
    //   29: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 226	com/tencent/mobileqq/activity/Conversation:i	Z
    //   36: invokevirtual 803	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 822
    //   42: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 804	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 648	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   55: ifnonnull +18 -> 73
    //   58: aload_0
    //   59: new 995	com/tencent/mobileqq/utils/CustomHandler
    //   62: dup
    //   63: invokestatic 1693	com/tencent/mobileqq/app/ThreadManager:c	()Landroid/os/Looper;
    //   66: aload_0
    //   67: invokespecial 1004	com/tencent/mobileqq/utils/CustomHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   70: putfield 648	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   73: aload_0
    //   74: invokespecial 1694	com/tencent/mobileqq/activity/Conversation:A	()V
    //   77: iload_1
    //   78: ifeq +216 -> 294
    //   81: invokestatic 830	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   84: invokevirtual 1695	com/tencent/mobileqq/managers/LoadingStateManager:a	()V
    //   87: invokestatic 1137	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   90: invokevirtual 1696	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()V
    //   93: aload_0
    //   94: getfield 209	com/tencent/mobileqq/activity/Conversation:f	Z
    //   97: ifeq +22 -> 119
    //   100: aload_0
    //   101: getfield 661	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   104: ifnull +15 -> 119
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 209	com/tencent/mobileqq/activity/Conversation:f	Z
    //   112: aload_0
    //   113: getfield 661	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   116: invokevirtual 1697	com/tencent/mobileqq/fpsreport/FPSSwipListView:C	()V
    //   119: aload_0
    //   120: getfield 652	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   123: ifnull +15 -> 138
    //   126: aload_0
    //   127: getfield 652	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   130: invokevirtual 1700	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 652	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   138: aload_0
    //   139: getfield 1100	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar	Lcom/tencent/mobileqq/activity/recent/LocalSearchBar;
    //   142: ifnull +14 -> 156
    //   145: aload_0
    //   146: getfield 1100	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar	Lcom/tencent/mobileqq/activity/recent/LocalSearchBar;
    //   149: aload_0
    //   150: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 1701	com/tencent/mobileqq/activity/recent/LocalSearchBar:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   156: aload_0
    //   157: getfield 1632	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   160: ifnull +14 -> 174
    //   163: aload_0
    //   164: getfield 1632	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   167: aload_0
    //   168: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   171: invokevirtual 1702	com/tencent/mobileqq/activity/recent/RecentTroopMenuOption:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   174: aload_0
    //   175: getfield 656	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   178: ifnull +47 -> 225
    //   181: aload_0
    //   182: getfield 656	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   185: aload_0
    //   186: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   189: invokevirtual 1703	com/tencent/mobileqq/activity/recent/RecentAdapter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   192: aload_0
    //   193: getfield 648	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   196: ifnull +29 -> 225
    //   199: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +12 -> 214
    //   205: ldc 102
    //   207: iconst_2
    //   208: ldc_w 1705
    //   211: invokestatic 472	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: iconst_1
    //   216: bipush 10
    //   218: lconst_0
    //   219: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   222: invokevirtual 854	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   225: aload_0
    //   226: getfield 812	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   229: ifnull +10 -> 239
    //   232: aload_0
    //   233: getfield 812	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   236: invokevirtual 1707	com/tencent/mobileqq/activity/recent/BannerManager:d	()V
    //   239: aload_0
    //   240: getfield 226	com/tencent/mobileqq/activity/Conversation:i	Z
    //   243: ifeq +13 -> 256
    //   246: aload_0
    //   247: getfield 648	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   250: bipush 12
    //   252: invokevirtual 756	android/os/Handler:sendEmptyMessage	(I)Z
    //   255: pop
    //   256: aload_0
    //   257: sipush 1035
    //   260: ldc2_w 1626
    //   263: iconst_0
    //   264: invokespecial 679	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   267: aload_0
    //   268: sipush 1010
    //   271: ldc2_w 1626
    //   274: iconst_1
    //   275: invokespecial 679	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   283: bipush 72
    //   285: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   288: checkcast 1621	com/tencent/mobileqq/vipgift/VipGiftManager
    //   291: putfield 234	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager	Lcom/tencent/mobileqq/vipgift/VipGiftManager;
    //   294: aload_0
    //   295: sipush 10001
    //   298: ldc2_w 1708
    //   301: iconst_0
    //   302: invokespecial 679	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   305: aload_0
    //   306: invokevirtual 1711	com/tencent/mobileqq/activity/Conversation:c	()V
    //   309: return
    //   310: astore_2
    //   311: aload_0
    //   312: aconst_null
    //   313: putfield 652	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   316: goto -178 -> 138
    //   319: astore_2
    //   320: aload_0
    //   321: aconst_null
    //   322: putfield 652	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   325: aload_2
    //   326: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	Conversation
    //   0	327	1	paramBoolean	boolean
    //   310	1	2	localException	Exception
    //   319	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   126	133	310	java/lang/Exception
    //   126	133	319	finally
  }
  
  public void a(boolean paramBoolean, Configuration paramConfiguration)
  {
    int i3 = -1;
    int i1;
    if (paramConfiguration == null)
    {
      i1 = getLefPanelWidth();
      paramConfiguration = getParent().findViewById(16908305);
      localObject = paramConfiguration.getLayoutParams();
      int i2;
      if (paramBoolean)
      {
        i2 = i1 * 2 + SizeMeasure.a(this);
        ((ViewGroup.LayoutParams)localObject).width = i2;
        paramConfiguration.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramConfiguration = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.getLayoutParams();
        if (!paramBoolean) {
          break label180;
        }
        i2 = i1;
        label71:
        paramConfiguration.width = i2;
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.setLayoutParams(paramConfiguration);
        paramConfiguration = this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.getLayoutParams();
        paramConfiguration.width = i1;
        ((ViewGroup.MarginLayoutParams)paramConfiguration).leftMargin = (SizeMeasure.a(this) + i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.setLayoutParams(paramConfiguration);
        paramConfiguration = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
        i2 = i3;
        if (paramBoolean) {
          i2 = i1 + SizeMeasure.a(this);
        }
        paramConfiguration.width = i2;
        localObject = (ViewGroup.MarginLayoutParams)paramConfiguration;
        if (!paramBoolean) {
          break label186;
        }
      }
      for (;;)
      {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i1;
        this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramConfiguration);
        return;
        i2 = -1;
        break;
        label180:
        i2 = -1;
        break label71;
        label186:
        i1 = 0;
      }
    }
    Object localObject = getParent().findViewById(16908305);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = -1;
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.getLayoutParams();
    if (paramConfiguration.orientation == 2)
    {
      i1 = getLefPanelWidth();
      label245:
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.getLayoutParams();
      if (paramConfiguration.orientation != 2) {
        break label363;
      }
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    for (((ViewGroup.MarginLayoutParams)localObject).leftMargin = getLefPanelWidth();; ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (((ViewGroup.LayoutParams)localObject).width + SizeMeasure.a(this)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -1;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramConfiguration.orientation != 2) {
        break;
      }
      findViewById(2131297306).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      return;
      i1 = -1;
      break label245;
      label363:
      ((ViewGroup.LayoutParams)localObject).width = getLefPanelWidth();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomHorizontalLoadingBar.setVisibility(8);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.f)) {}
    do
    {
      do
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
        d();
      } while (this.app == null);
      this.app.f(false);
    } while (!QLog.isColorLevel());
    QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
    return true;
  }
  
  protected boolean a(Message paramMessage)
  {
    return ((this.jdField_c_of_type_Boolean) || (paramMessage.arg1 != 0)) && (this.app.isLogin());
  }
  
  public boolean a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if (paramVipGiftDownloadInfo.d == 3L) {
      paramVipGiftManager.a(4L, paramVipGiftDownloadInfo.a);
    }
    return (paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.d == 2L) && (this.app.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b());
  }
  
  protected void addTopLayout() {}
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent", 4, "fillData()");
    }
    a(true);
    j();
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.f)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  protected void b(List paramList)
  {
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("unreadinfo, [");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if ((localRecentBaseData != null) && (localRecentBaseData.B > 0)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.a()).append("-").append(localRecentBaseData.a()).append("-").append(localRecentBaseData.B).append(" , ");
          }
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("]");
      QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected boolean b()
  {
    return (this.ag != 0) && (this.ag != 1);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 1760	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 482	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   24: aload_0
    //   25: invokevirtual 1795	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   28: aload_0
    //   29: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   32: bipush 37
    //   34: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   37: checkcast 493	com/tencent/mobileqq/qcall/QCallFacade
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +8 -> 50
    //   45: aload_2
    //   46: aload_0
    //   47: invokevirtual 1796	com/tencent/mobileqq/qcall/QCallFacade:addObserver	(Ljava/util/Observer;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: invokespecial 689	com/tencent/mobileqq/activity/Conversation:d	(Z)V
    //   55: aload_0
    //   56: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   59: invokevirtual 1799	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   62: invokevirtual 1802	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	()V
    //   65: aload_0
    //   66: getfield 226	com/tencent/mobileqq/activity/Conversation:i	Z
    //   69: ifeq +8 -> 77
    //   72: aload_0
    //   73: lconst_0
    //   74: invokevirtual 1628	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   77: aload_0
    //   78: getfield 373	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   81: bipush 33
    //   83: invokevirtual 409	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   86: checkcast 1804	com/tencent/mobileqq/app/NewFriendManager
    //   89: astore_2
    //   90: aload_2
    //   91: ifnull -77 -> 14
    //   94: aload_2
    //   95: aload_0
    //   96: getfield 349	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendPushListener	Lcom/tencent/mobileqq/newfriend/NewFriendPushListener;
    //   99: invokevirtual 1807	com/tencent/mobileqq/app/NewFriendManager:a	(Lcom/tencent/mobileqq/newfriend/NewFriendPushListener;)V
    //   102: goto -88 -> 14
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	Conversation
    //   9	2	1	bool	boolean
    //   40	55	2	localObject1	Object
    //   105	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	105	finally
    //   17	41	105	finally
    //   45	50	105	finally
    //   50	77	105	finally
    //   77	90	105	finally
    //   94	102	105	finally
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(true, null);
    }
    jdField_b_of_type_Boolean = true;
    ((ImageButton)findViewById(2131302027)).setImageResource(2130842172);
    int i1 = getLefPanelWidth();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidViewView.getScrollX(), i1 });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new dtg(this));
    localValueAnimator.addListener(new dth(this));
    localValueAnimator.start();
    ReportController.b(this.app, "CliOper", "", "", "0X80060D5", "0X80060D5", 0, 0, "", "", "", "");
  }
  
  public void d()
  {
    if (this.app.a() != null)
    {
      this.f = true;
      t();
      d(true);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(5);
      if ((bool1) || (bool2)) {
        b(800L);
      }
    }
    else
    {
      return;
    }
    this.app.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d();
    b(60000L);
    ReportController.b(this.app, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    }
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
                  } while (this == null);
                  setCanLock(false);
                  return;
                } while ((-1 != paramInt2) || (paramIntent == null) || (this.jdField_b_of_type_AndroidOsHandler == null));
                localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
                ((Message)localObject).what = 17;
                ((Message)localObject).obj = paramIntent;
                ((Message)localObject).sendToTarget();
                return;
              } while (paramInt2 != 0);
              finish();
              this.app.b(false);
              return;
            } while ((-1 != paramInt2) || (paramIntent == null));
            paramIntent = paramIntent.getStringExtra("roomId");
          } while (paramIntent == null);
          Object localObject = ContactUtils.a(this.app, getApplicationContext(), paramIntent);
          Intent localIntent = new Intent(this, ChatActivity.class);
          localIntent.putExtra("uin", paramIntent);
          localIntent.putExtra("uintype", 3000);
          localIntent.putExtra("uinname", (String)localObject);
          RecentUtil.a(localIntent);
          startActivity(localIntent);
          ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
          return;
        } while ((-1 != paramInt2) || (paramIntent == null));
        paramIntent = paramIntent.getStringExtra("roomId");
      } while (paramIntent == null);
      ReportController.b(this.app, "CliOper", "", "", "Multi_call", "Multi_call_shortcut_launch", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, null);
      return;
    } while (paramInt2 != -1);
    QQToast.a(this, 2, getString(2131368794), 0).b(getTitleBarHeight());
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    reLayoutClipParams(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout, this.jdField_a_of_type_AndroidViewViewGroup);
    a(false, paramConfiguration);
    if (jdField_b_of_type_Boolean) {
      CircleMenuManager.b(241, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903198);
    v();
    return false;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.a();
    }
  }
  
  protected void doOnResume()
  {
    int i2 = 2;
    int i3 = 1;
    super.doOnResume();
    TimeManager.a().e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.c();
    }
    if (AppSetting.k) {
      this.app.d(true);
    }
    this.jdField_c_of_type_Boolean = true;
    getWindow().setSoftInputMode(32);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager;
    if (localObject != null)
    {
      VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
      if (localVipGiftDownloadInfo != null)
      {
        a((VipGiftManager)localObject, localVipGiftDownloadInfo);
        if ((a((VipGiftManager)localObject, localVipGiftDownloadInfo) == true) && (this != null) && ((this instanceof SplashActivity))) {
          ((SplashActivity)this).d();
        }
      }
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      boolean bool = LoadingStateManager.a().e();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (bool)
      {
        i1 = 2;
        ((BannerManager)localObject).a(5, i1);
        LoadingStateManager.a().b(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
        if (this.app.a().a() == 0) {
          break label381;
        }
        i1 = 1;
        label196:
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
        if (i1 == 0) {
          break label386;
        }
        i1 = 2;
        label208:
        ((BannerManager)localObject).a(19, i1);
        if (!FileViewMusicService.a().a()) {
          break label391;
        }
        i1 = i3;
        label227:
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
        if (i1 == 0) {
          break label396;
        }
        i1 = i2;
        label239:
        ((BannerManager)localObject).a(20, i1);
      }
    }
    else
    {
      if ((this.app != null) && (this.app.jdField_a_of_type_AndroidContentIntent != null))
      {
        startActivity(this.app.jdField_a_of_type_AndroidContentIntent);
        this.app.jdField_a_of_type_AndroidContentIntent = null;
      }
      this.ag = 0;
      if (!this.i) {
        break label401;
      }
      if (this.jdField_b_of_type_Long != 1000L) {
        this.jdField_b_of_type_Long = 1000L;
      }
      if (!this.j) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1020);
      }
      if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      }
      a(0L);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1030, 1000L);
    }
    for (;;)
    {
      E();
      return;
      i1 = 0;
      break;
      label381:
      i1 = 0;
      break label196;
      label386:
      i1 = 0;
      break label208;
      label391:
      i1 = 0;
      break label227;
      label396:
      i1 = 0;
      break label239;
      label401:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1025, 3000L);
    }
  }
  
  protected void doWhenFragmentReplace(Fragment paramFragment1, Fragment paramFragment2)
  {
    if ((paramFragment2 == null) && (getResources().getConfiguration().orientation == 2)) {}
  }
  
  public void e()
  {
    long l1 = 0L;
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "inflateUI, " + this.k);
      }
      boolean bool = this.k;
      if (!bool) {
        break label51;
      }
    }
    finally
    {
      try
      {
        LayoutInflater localLayoutInflater;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903418, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = ((VipGiftManager)this.app.getManager(72));
      }
      catch (Exception localException2)
      {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label274;
        }
      }
      localObject1 = finally;
    }
    return;
    label51:
    this.k = true;
    localLayoutInflater = LayoutInflater.from(this);
    Object localObject2 = "in main thread ";
    label134:
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, (String)localObject2 + localException2.toString());
    }
    for (;;)
    {
      try
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("device_mode", DeviceInfoUtil.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
        String str2 = this.app.a();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label292;
        }
        localStatisticCollector.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, localException1.toString());
      break;
      label274:
      String str1 = "not in main thread ";
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
      this.k = false;
      break label134;
      label292:
      l1 = 1L;
    }
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 791	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5: ifeq +45 -> 50
    //   8: ldc 102
    //   10: iconst_4
    //   11: new 793	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 794	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 2025
    //   21: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 228	com/tencent/mobileqq/activity/Conversation:j	Z
    //   28: invokevirtual 803	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc_w 820
    //   34: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 230	com/tencent/mobileqq/activity/Conversation:k	Z
    //   41: invokevirtual 803	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 804	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 228	com/tencent/mobileqq/activity/Conversation:j	Z
    //   54: istore_1
    //   55: iload_1
    //   56: ifeq +6 -> 62
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 228	com/tencent/mobileqq/activity/Conversation:j	Z
    //   67: aload_0
    //   68: getfield 230	com/tencent/mobileqq/activity/Conversation:k	Z
    //   71: ifne +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 2026	com/tencent/mobileqq/activity/Conversation:e	()V
    //   78: aload_0
    //   79: getfield 661	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   82: aload_0
    //   83: getfield 664	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   86: invokevirtual 2029	com/tencent/mobileqq/fpsreport/FPSSwipListView:setOverScrollHeader	(Landroid/view/View;)V
    //   89: aload_0
    //   90: getfield 661	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   93: aload_0
    //   94: invokevirtual 2033	com/tencent/mobileqq/fpsreport/FPSSwipListView:setOverScrollListener	(Lcom/tencent/widget/OverScrollViewListener;)V
    //   97: aload_0
    //   98: getfield 812	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   101: ifnull +17 -> 118
    //   104: aload_0
    //   105: getfield 907	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Boolean	Z
    //   108: ifeq +10 -> 118
    //   111: aload_0
    //   112: getfield 812	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   115: invokevirtual 2034	com/tencent/mobileqq/activity/recent/BannerManager:f	()V
    //   118: aload_0
    //   119: sipush 1010
    //   122: lconst_0
    //   123: iconst_0
    //   124: invokespecial 679	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   127: aload_0
    //   128: sipush 1023
    //   131: lconst_0
    //   132: iconst_0
    //   133: invokespecial 679	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   136: aload_0
    //   137: invokespecial 1151	com/tencent/mobileqq/activity/Conversation:u	()V
    //   140: aload_0
    //   141: getfield 648	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   144: bipush 12
    //   146: invokevirtual 756	android/os/Handler:sendEmptyMessage	(I)Z
    //   149: pop
    //   150: goto -91 -> 59
    //   153: astore_2
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_2
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	Conversation
    //   54	2	1	bool	boolean
    //   153	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	153	finally
    //   50	55	153	finally
    //   62	78	153	finally
    //   78	118	153	finally
    //   118	150	153	finally
  }
  
  public void g()
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
    TraceUtils.a("conv.handleMessage");
    if ((this.g) || (getActivity() == null) || (getActivity().isFinishing())) {
      return true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int i1;
    if (paramMessage.what == 10)
    {
      if (!a(paramMessage)) {
        return true;
      }
      n();
      TroopAssistantManager.a().e(this.app);
      q();
      paramMessage = this.app.a().a();
      if (QvipSpecialCareManager.a(this.app)) {
        QvipSpecialCareManager.a(this.app);
      }
      localObject1 = paramMessage.b();
      a((List)localObject1);
      paramMessage = RecentDataListManager.a().a;
      localObject3 = this.app;
      localObject4 = getActivity();
      if (localObject1 != null)
      {
        i1 = ((List)localObject1).size();
        ConversationDataFactory.a((List)localObject1, (QQAppInterface)localObject3, (Context)localObject4, paramMessage, i1);
      }
    }
    label418:
    label607:
    label884:
    do
    {
      for (;;)
      {
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_JavaUtilComparator);
          localObject1 = new ArrayList(paramMessage);
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000, 0, 0, localObject1).sendToTarget();
          b(paramMessage);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.e();
          }
          this.jdField_b_of_type_JavaUtilList.clear();
          this.ai = 0;
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          }
          TraceUtils.a();
          return true;
          i1 = 0;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        int i2;
        Object localObject2;
        if (paramMessage.what == 9)
        {
          if (!a(paramMessage)) {
            return true;
          }
          if (QvipSpecialCareManager.a(this.app)) {
            QvipSpecialCareManager.a(this.app);
          }
          q();
          localObject3 = RecentDataListManager.a().a;
          localObject4 = this.app.a().a().b();
          a((List)localObject4);
          ((List)localObject3).clear();
          RecentUser localRecentUser;
          String str;
          if (localObject4 == null)
          {
            i1 = 0;
            i2 = 0;
            if (i2 >= i1) {
              break label607;
            }
            localRecentUser = (RecentUser)((List)localObject4).get(i2);
            str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.type);
            localObject2 = RecentDataListManager.a().a(str);
            if (localObject2 != null) {
              break label520;
            }
            paramMessage = ConversationDataFactory.a(localRecentUser, this.app, getActivity());
            RecentDataListManager.a().a(paramMessage, str);
          }
          for (;;)
          {
            if (paramMessage != null) {
              ((List)localObject3).add(paramMessage);
            }
            i2 += 1;
            break label418;
            i1 = ((List)localObject4).size();
            break;
            paramMessage = (Message)localObject2;
            if (this.jdField_b_of_type_JavaUtilList != null) {
              if (!this.jdField_b_of_type_JavaUtilList.contains(str))
              {
                paramMessage = (Message)localObject2;
                if (!this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(localRecentUser.uin, -2147483648))) {}
              }
              else
              {
                if ((localObject2 instanceof RecentUserBaseData)) {
                  ((RecentUserBaseData)localObject2).a(localRecentUser);
                }
                ((RecentBaseData)localObject2).a(this.app, getActivity());
                paramMessage = (Message)localObject2;
              }
            }
          }
          try
          {
            Collections.sort((List)localObject3, this.jdField_a_of_type_JavaUtilComparator);
            paramMessage = new ArrayList((Collection)localObject3);
            Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000, 0, 0, paramMessage).sendToTarget();
            b((List)localObject3);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.e();
            }
            if (this.ai <= 9) {
              this.ai = 0;
            }
            this.jdField_b_of_type_JavaUtilList.clear();
            this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
            this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
            this.jdField_c_of_type_Long = System.currentTimeMillis();
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              paramMessage.printStackTrace();
            }
          }
        }
        else if (paramMessage.what == 8)
        {
          if (!a(paramMessage)) {
            return true;
          }
          paramMessage = RecentDataListManager.a().a;
          if ((this.jdField_b_of_type_JavaUtilList == null) || (paramMessage == null))
          {
            i1 = 0;
            localObject2 = new ArrayList(i1);
            i2 = 0;
            if (i2 >= i1) {}
          }
          else
          {
            for (;;)
            {
              try
              {
                localObject3 = (RecentBaseData)paramMessage.get(i2);
                if (localObject3 != null) {
                  break label884;
                }
                i2 += 1;
              }
              catch (Exception paramMessage)
              {
                if (!QLog.isDevelopLevel()) {
                  continue;
                }
                QLog.e("Q.recent", 4, paramMessage.toString());
                return true;
              }
              i1 = paramMessage.size();
              break;
              localObject4 = RecentDataListManager.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
              if ((this.jdField_b_of_type_JavaUtilList.contains(localObject4)) || (this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(((RecentBaseData)localObject3).a(), -2147483648))))
              {
                ((RecentBaseData)localObject3).a(this.app, getActivity());
                ((List)localObject2).add(localObject3);
              }
            }
          }
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1019, 0, 0, localObject2).sendToTarget();
          b(paramMessage);
          if (this.ai <= 8)
          {
            this.ai = 0;
            this.jdField_b_of_type_JavaUtilList.clear();
          }
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          }
        }
        else
        {
          if (paramMessage.what == 17) {
            for (;;)
            {
              try
              {
                localObject3 = (Intent)paramMessage.obj;
                if (localObject3 == null) {
                  return true;
                }
                localObject2 = ((Intent)localObject3).getExtras().getString("watermark_photo_path");
                paramMessage = (Message)localObject2;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  paramMessage = ((Intent)localObject3).getData().getPath();
                }
                if (QLog.isColorLevel()) {
                  QLog.i("Q.zebra.", 2, paramMessage);
                }
                if (TextUtils.isEmpty(paramMessage)) {
                  break;
                }
                localObject2 = new File(AppConstants.aK);
                if (!((File)localObject2).exists()) {
                  ((File)localObject2).mkdirs();
                }
                localObject2 = AppConstants.aK + System.currentTimeMillis() + ".jpg";
                bool = FileUtils.c(paramMessage, (String)localObject2);
                if (QLog.isColorLevel()) {
                  QLog.i("Q.zebra.", 2, "REQUEST_CODE_WATER_MARK, path = " + (String)localObject2 + ", bRet = " + bool);
                }
                if (!bool) {
                  break label1318;
                }
                FileUtils.d(paramMessage);
                paramMessage = (Message)localObject2;
                runOnUiThread(new dto(this, paramMessage));
              }
              catch (Exception paramMessage) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.zebra.", 2, paramMessage.toString());
              break;
            }
          }
          if (paramMessage.what != 11) {
            break label1627;
          }
          boolean bool = a(paramMessage);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.i + "," + bool + "]");
          }
          if (!bool) {
            return true;
          }
          i2 = paramMessage.arg2;
          if ((i2 == 8) || (i2 == 9))
          {
            localObject2 = (String)paramMessage.obj;
            if (!this.jdField_b_of_type_JavaUtilList.contains(localObject2)) {
              this.jdField_b_of_type_JavaUtilList.add(localObject2);
            }
            l1 = 0L;
          }
          while (i2 >= this.ai)
          {
            i1 = 8;
            for (;;)
            {
              if (i1 < i2)
              {
                this.jdField_b_of_type_AndroidOsHandler.removeMessages(i1);
                i1 += 1;
                continue;
                l1 = ((Long)paramMessage.obj).longValue();
                break;
              }
            }
            this.ai = i2;
          }
          if ((this.i) && (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(this.ai)))
          {
            long l2 = Math.abs(System.currentTimeMillis() - this.jdField_c_of_type_Long);
            l1 = Math.max(this.jdField_b_of_type_Long - l2, l1);
            localObject2 = Message.obtain();
            ((Message)localObject2).arg1 = paramMessage.arg1;
            ((Message)localObject2).what = this.ai;
            this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, l1);
          }
        }
      }
      if (paramMessage.what == 12)
      {
        TroopAssistantManager.a().j(this.app);
        paramMessage = PubAccountAssistantManager.a();
        if (paramMessage != null) {
          paramMessage.h(this.app);
        }
        paramMessage = TroopBarAssistantManager.a();
        if (paramMessage != null) {
          paramMessage.g(this.app);
        }
        TroopNotificationHelper.a(this.app);
        paramMessage = (TroopTipsMsgMgr)this.app.getManager(76);
        if (paramMessage != null) {
          paramMessage.a(this.app);
        }
        for (;;)
        {
          paramMessage = (EcShopAssistantManager)this.app.getManager(83);
          if (paramMessage == null) {
            break;
          }
          paramMessage.d();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
          }
        }
      }
    } while ((paramMessage.what != 16) || (a(paramMessage)));
    label520:
    label1318:
    label1627:
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {}
    do
    {
      do
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837687);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), "theme_bg_message_path_png", this.app.a(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path == "null")
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130837687);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void k()
  {
    jdField_b_of_type_Boolean = false;
    ((ImageButton)findViewById(2131302027)).setImageResource(2130842152);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidViewView.getScrollX(), 0 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(250L);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new dti(this));
    localValueAnimator.addListener(new dtk(this));
    localValueAnimator.start();
  }
  
  public void l() {}
  
  protected void onAccountChanged()
  {
    a();
    super.onAccountChanged();
    b();
    clearTabStack();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c();
  }
  
  protected void onAlphaAnimEnd()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer != null) && (!jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.setVisibility(0);
    }
  }
  
  protected void onAlphaAnimStart()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer != null) && (!jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.setVisibility(4);
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((jdField_b_of_type_Boolean) && (getFragmentCount(this.jdField_a_of_type_AndroidViewViewGroup) == 0))
    {
      k();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.h();
    }
  }
  
  protected void onDestroy()
  {
    this.g = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    TimeManager.a().b();
    B();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.a().a();
    PubAccountAssistantManager.a().a();
    TroopRemindSettingManager.a();
    TroopBarAssistantManager.a().a();
    NewFriendManager localNewFriendManager = (NewFriendManager)this.app.getManager(33);
    if (localNewFriendManager != null) {
      localNewFriendManager.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer.g();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomRelativeLayout.a();
    }
    super.onDestroy();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.f))
    {
      this.f = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.B();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(13, 0);
    RecentDataListManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramLogoutReason);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (AppSetting.k) {
      this.app.d(false);
    }
    TimeManager.a().d();
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.b();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(9);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  public void onPostThemeChanged()
  {
    j();
  }
  
  public void rightPanelEmpty()
  {
    super.rightPanelEmpty();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c();
  }
  
  protected String setLastActivityName()
  {
    String str = getString(2131366025);
    QQMessageFacade localQQMessageFacade = this.app.a();
    int i1;
    if (localQQMessageFacade != null)
    {
      i1 = localQQMessageFacade.e();
      if (i1 > 0) {}
    }
    else
    {
      return str;
    }
    if (i1 > 99) {
      return str + "(99+)";
    }
    return str + "(" + i1 + ")";
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    Object localObject = paramIntent.getComponent();
    if (localObject != null)
    {
      localObject = ((ComponentName)localObject).getClassName();
      if ((((String)localObject).equals(ChatActivity.class.getName())) || (((String)localObject).equals(LiteActivity.class.getName())))
      {
        int i1 = paramIntent.getIntExtra("uintype", -1);
        localObject = paramIntent.getStringExtra("uin");
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(i1, (String)localObject);
      }
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    label29:
    int i1;
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        break label29;
      }
      while ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2000) && (!this.jdField_c_of_type_Boolean)) {
        return;
      }
      if ((!paramObservable.isSendFromLocal()) || (this.jdField_c_of_type_Boolean)) {
        break label167;
      }
      i1 = 9;
      paramObservable = RecentDataListManager.a(paramObservable.frienduin, paramObservable.istroop);
    }
    for (int i2 = 2;; i2 = 0)
    {
      a(i2, i1, paramObservable);
      for (;;)
      {
        if (!(paramObject instanceof String[])) {
          break label165;
        }
        paramObservable = (String[])paramObject;
        if ((paramObservable.length != 2) || (!AppConstants.W.equals(paramObservable[0])) || (paramObservable[1] == null)) {
          break;
        }
        paramObject = paramObservable[0];
        a(8, paramObservable[1], 7000);
        return;
        if ((paramObject instanceof RecentUser)) {
          a(200L);
        }
      }
      label165:
      break label29;
      label167:
      paramObservable = Long.valueOf(0L);
      i1 = 10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */