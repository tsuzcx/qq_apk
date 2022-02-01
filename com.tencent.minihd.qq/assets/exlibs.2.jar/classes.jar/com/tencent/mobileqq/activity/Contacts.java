package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.adapter.AllBuddyListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter.ViewTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.CircleMenu.Builder;
import com.tencent.mobileqq.customviews.CircleMenuManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import cooperation.smartdevice.SmartDevicePluginDownloadActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import drn;
import dro;
import drp;
import drq;
import drr;
import drs;
import drt;
import dru;
import drv;
import drw;
import drx;
import dry;
import drz;
import dsa;
import dsb;
import dsc;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.Constants.LogoutReason;

public class Contacts
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, RadioGroup.OnCheckedChangeListener, CommonLoadingView.OnFirstDrawListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, QQTabHost.OnTabSelectionListener, OverScrollViewListener
{
  public static final int A = 15;
  public static final int B = 16;
  private static final int C = 1400;
  private static final int D = 9527;
  private static final int E = 9528;
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "last_buddy_list_refresh_time";
  public static int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "Contacts";
  public static int c = 0;
  public static int d = 0;
  static final int jdField_f_of_type_Int = 1;
  static final int g = 3;
  static final int h = 4;
  static final int i = 6;
  static final int j = 800;
  static final int k = 1000;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  public static final int q = 5;
  public static final int r = 6;
  public static final int s = 7;
  public static final int t = 8;
  public static final int u = 9;
  public static final int v = 10;
  public static final int w = 11;
  public static final int x = 12;
  public static final int y = 13;
  public static final int z = 14;
  protected BroadcastReceiver a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public RelativeLayout a;
  public SearchResultDialog a;
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private AllBuddyListAdapter jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter;
  public BuddyListAdapter a;
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new drp(this);
  public FPSPinnedHeaderExpandableListView a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public PullRefreshHeader a;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private final drz jdField_a_of_type_Drz = new drz(this, null);
  private final dsa jdField_a_of_type_Dsa = new dsa(this, null);
  private final dsb jdField_a_of_type_Dsb = new dsb(this, null);
  private final dsc jdField_a_of_type_Dsc = new dsc(this, null);
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2131297271, 2131297275, 2131297279 };
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = true;
  private View d;
  public boolean d;
  public int e;
  public boolean e;
  private boolean jdField_f_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
  }
  
  public Contacts()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.f = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new drq(this);
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(getActivity()).inflate(2130903175, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this);
    return paramViewGroup;
  }
  
  private void a(View paramView)
  {
    if ((a(paramView)) && (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.b(true);
    }
  }
  
  private void a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountHandler.a(this.app, paramPublicAccountInfo.getUin(), "Pb_account_lifeservice", "mp_msg_sys_4", "contacts_aio");
    Intent localIntent;
    if (paramPublicAccountInfo.extendType == 2)
    {
      localIntent = new Intent(getActivity(), ChatActivity.class);
      localIntent.putExtra("chat_subType", 1);
    }
    for (;;)
    {
      localIntent.putExtra("uin", String.valueOf(paramPublicAccountInfo.uin));
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramPublicAccountInfo.name);
      startActivity(localIntent);
      return;
      localIntent = new Intent(getActivity(), ChatActivity.class);
    }
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (AppConstants.X.equals(paramObject.uin))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPerf", 2, "devicesearchEntry:" + System.currentTimeMillis());
        }
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          if (SmartDevicePluginLoader.a().a(this.app)) {
            break label118;
          }
          startActivity(new Intent(getActivity(), SmartDevicePluginDownloadActivity.class));
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1000L);
          return true;
          label118:
          paramObject = new Intent();
          paramObject.putExtra("nickname", this.app.c());
          paramObject.putExtra("bitmap", this.app.a(this.app.a(), (byte)2, false));
          SmartDevicePluginLoader.a().a(getActivity(), this.app, this.app.getAccount(), paramObject, "com.tencent.device.activities.DeviceSearchActivity", 0, null, SmartDevicePluginProxyActivity.class);
        }
      }
      if ((AppConstants.Y.equals(paramObject.uin)) || (AppConstants.Z.equals(paramObject.uin))) {
        for (;;)
        {
          try
          {
            localObject = this.app.b();
            i1 = 0;
            if (i1 < ((List)localObject).size())
            {
              localResourcePluginInfo = (ResourcePluginInfo)((List)localObject).get(i1);
              if ((localResourcePluginInfo == null) || (!localResourcePluginInfo.strPkgName.equals(paramObject.uin))) {
                continue;
              }
              paramObject = JumpParser.a(this.app, getActivity(), localResourcePluginInfo.strGotoUrl);
              if (paramObject != null) {
                paramObject.b();
              }
            }
          }
          catch (Exception paramObject)
          {
            continue;
          }
          return true;
          i1 += 1;
        }
      }
      if (AppConstants.at.equals(paramObject.uin))
      {
        if (!this.jdField_c_of_type_Boolean) {
          return true;
        }
        this.jdField_c_of_type_Boolean = false;
        localObject = (SmartDeviceProxyMgr)this.app.a(53);
        paramObject = ((SmartDeviceProxyMgr)localObject).a(paramObject.signature);
        ((SmartDeviceProxyMgr)localObject).a(getActivity(), paramObject);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1000L);
        if (paramObject.isAdmin == 1)
        {
          i1 = 1;
          SmartDeviceReport.a(null, "Usr_LiteApp_Open", i1, 0, paramObject.productId);
          if (paramObject.userStatus != 10) {
            break label436;
          }
          i1 = 1;
          SmartDeviceReport.a(null, "Usr_LiteApp_Open_Online", i1, 0, paramObject.productId);
        }
      }
    }
    label436:
    while (!(paramObject instanceof PublicAccountInfo))
    {
      for (;;)
      {
        Object localObject;
        ResourcePluginInfo localResourcePluginInfo;
        return false;
        int i1 = 2;
        continue;
        i1 = 2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Hyim", 2, "onItemClick:" + paramObject.name + paramObject.uin + "--[" + paramObject.detalStatusFlag + "] [" + paramObject.iTermType + "] [" + paramObject.getLastLoginType() + "] [" + paramObject.showLoginClient + "]");
      }
      paramObject = new ProfileActivity.AllInOne(paramObject.uin, 1);
      paramObject.g = 59;
      paramObject.i = 2;
      ProfileActivity.b(getActivity(), paramObject);
      return true;
    }
    paramObject = (PublicAccountInfo)paramObject;
    if (PublicAccountInfo.isLooker(paramObject))
    {
      ReportController.b(this.app, "CliOper", "", "", "Contacts_tab", "Clk_lifeservice", 49, 0, "", "", "", "");
      AddContactsActivity.b(getActivity());
    }
    for (;;)
    {
      return true;
      a(paramObject);
    }
  }
  
  private void b(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView) {
      if (paramListView.s() > 0) {
        runOnUiThread(new drr(this));
      }
    }
    while (paramListView.s() <= 0) {
      return;
    }
    paramListView.setSelection(0);
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "updateBuddyList " + this.jdField_a_of_type_Boolean + " " + this.jdField_b_of_type_Boolean);
    }
    if (NetworkUtil.f(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ((FriendListHandler)this.app.a(1)).a(true);
        ((PublicAccountHandler)this.app.a(10)).a();
        SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.app.a(53);
        if (localSmartDeviceProxyMgr.a()) {
          localSmartDeviceProxyMgr.d();
        }
      }
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Contacts", 2, "updateBuddyList succeeded");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "updateBuddyList falied");
    }
    return false;
  }
  
  private void e()
  {
    CircleMenuManager.a(243, new CircleMenu.Builder(this.jdField_a_of_type_AndroidWidgetRelativeLayout).a(2130838041).a(new drn(this)));
  }
  
  private void f()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.app.getManager(10);
    if ((localPhoneContactManager != null) && (localPhoneContactManager.e()) && (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new drs(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
  }
  
  private void g()
  {
    a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.b(true);
    }
  }
  
  private void h()
  {
    ((QzoneContactsFeedManager)this.app.getManager(85)).a();
  }
  
  private void i() {}
  
  private void j()
  {
    Object localObject = (FrameLayout)findViewById(2131297222);
    localObject = LayoutInflater.from(this).inflate(2130904390, (ViewGroup)localObject, true);
    ((View)localObject).findViewById(2131299461).setVisibility(8);
    localObject = (EditText)((View)localObject).findViewById(2131299473);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnClickListener(this);
    ((EditText)localObject).setCursorVisible(false);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter = new BuddyListAdapter(getActivity(), this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView, this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setChoiceMode(1);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setOnInterceptTouchListener(new drv(this));
    }
  }
  
  private void l()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    if (localFriendsManager != null)
    {
      if (localFriendsManager.e() <= 0) {
        break label62;
      }
      if ((this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null))
      {
        this.jdField_b_of_type_AndroidViewView = a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.b(this.jdField_b_of_type_AndroidViewView);
      }
    }
    label62:
    while ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  private void m() {}
  
  private void n()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    Object localObject = (SmartDeviceProxyMgr)this.app.a(53);
    if (((SmartDeviceProxyMgr)localObject).a())
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a();
      if (localObject != null) {
        localDataLineHandler.b(13, true, new ArrayList(Arrays.asList((Object[])localObject)));
      }
    }
  }
  
  protected void a()
  {
    if (this.jdField_e_of_type_Int > 0) {
      return;
    }
    this.jdField_e_of_type_Int = (getTitleBarHeight() - (int)DisplayUtils.a(this, 5.0F));
    i();
    j();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296742));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297225);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)findViewById(2131297218));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131297223));
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    }
    reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewView);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("SmartDevice_receiveOnlineMsg");
    localIntentFilter.addAction("SmartDevice_clickOnDeviceList");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    e();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new drw(this, getActivity(), this.app, paramInt, 2, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new drx(this, l1));
    localTranslateAnimation2.setAnimationListener(new dry(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(new dro(this, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation1);
    ThreadPriorityManager.a(true);
  }
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onNotCompleteVisable");
    }
    ((PullRefreshHeader)paramView).c(a());
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i1 = 9527;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9527);
    }
    while (paramLong == 0L)
    {
      a(paramBoolean);
      return;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(9527)) {
        return;
      }
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (;;)
    {
      localHandler.sendEmptyMessageDelayed(i1, paramLong);
      return;
      i1 = 4;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  void a(ListView paramListView) {}
  
  public void a(String paramString) {}
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JustGo", 2, "<<--doRefreshBuddyList");
    }
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
    {
      if (!paramBoolean) {
        break label57;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.notifyDataSetChanged();
      }
      return;
      label57:
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.a();
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewCompleteVisableAndReleased");
    }
    h();
    ((PullRefreshHeader)paramView).a(a());
    paramView = (Contacts.OverScrollViewTag)paramView.getTag();
    if (!b())
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      localMessage.obj = paramListView;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      paramView.jdField_a_of_type_Boolean = false;
      return true;
    }
    paramView.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public boolean a(View paramView)
  {
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_a_of_type_ArrayOfInt.length)
    {
      View localView = this.jdField_d_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[i1]);
      if ((paramView != null) && (paramView == localView))
      {
        bool = true;
        paramView.post(new drt(this, paramView));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localView.setActivated(false);
      }
    }
    return bool;
  }
  
  protected void addTopLayout() {}
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9528);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewCompleteVisable");
    }
    ((PullRefreshHeader)paramView).b(a());
  }
  
  public void c()
  {
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    this.app.a(this.jdField_a_of_type_Dsa);
    this.app.a(this.jdField_a_of_type_Drz);
    this.app.a(this.jdField_a_of_type_Dsb);
    Object localObject = (StatusManager)this.app.getManager(14);
    if (localObject != null)
    {
      ((StatusManager)localObject).b(this.jdField_a_of_type_Dsc);
      ((StatusManager)localObject).a(this.jdField_a_of_type_Dsc);
    }
    if ((this.app != null) && ("0".equals(this.app.a()))) {
      return;
    }
    localObject = BaseApplication.getContext().getSharedPreferences("share", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("no_auto_reply" + this.app.a(), "");
    if (Build.VERSION.SDK_INT < 9) {
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = false;
      k();
      n();
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
      return;
      try
      {
        SharedPreferences.Editor.class.getMethod("apply", new Class[0]).invoke(localObject, new Object[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewNotCompleteVisableAndReleased");
    }
  }
  
  public void d()
  {
    long l1 = System.currentTimeMillis();
    getActivity().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l1).commit();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.a(paramConfiguration);
    }
    reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewView);
    View localView = findViewById(2131297226);
    if (paramConfiguration.orientation == 1)
    {
      localView.setVisibility(4);
      return;
    }
    localView.setVisibility(0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903179);
    a();
    return false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(1400L, true);
    f();
    m();
    ((FriendListHandler)this.app.a(1)).d(this.app.a(), (byte)1);
    int i2;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
    {
      i2 = this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.getGroupCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.e(i1)) {
          h();
        }
      }
      else {
        return;
      }
      i1 += 1;
    }
  }
  
  protected void doWhenFragmentReplace(Fragment paramFragment1, Fragment paramFragment2) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return true;
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.B();
          return true;
          QQToast.a(getActivity(), 1, 2131366939, 0).b(this.jdField_e_of_type_Int);
        } while (!(paramMessage.obj instanceof ListView));
        ((ListView)paramMessage.obj).B();
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      a(0L, false);
      return true;
    case 9527: 
      a(0L, true);
      return true;
    case 9528: 
      this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
      c();
      if (!this.f) {
        doOnResume();
      }
      this.f = true;
      return true;
    }
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    c();
    clearTabStack();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0))
    {
      finish();
      this.app.b(false);
    }
  }
  
  protected void onAlphaAnimEnd()
  {
    View localView = findViewById(2131297226);
    if ((localView != null) && (getResources().getConfiguration().orientation == 2)) {
      localView.setVisibility(0);
    }
  }
  
  protected void onAlphaAnimStart()
  {
    View localView = findViewById(2131297226);
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (paramView.isActivated()) {}
    BuddyListAdapter.ViewTag localViewTag;
    do
    {
      do
      {
        return;
      } while (this.jdField_d_of_type_Boolean);
      this.jdField_d_of_type_Boolean = true;
      paramView.postDelayed(new dru(this), 400L);
      switch (paramView.getId())
      {
      default: 
        localViewTag = (BuddyListAdapter.ViewTag)paramView.getTag();
      }
    } while ((localViewTag == null) || (localViewTag.jdField_a_of_type_JavaLangObject == null));
    a(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a(localViewTag.jdField_b_of_type_JavaLangString, localViewTag.jdField_a_of_type_Int, localViewTag.jdField_b_of_type_Int);
    }
    a(localViewTag.jdField_a_of_type_JavaLangObject);
    return;
    a(0);
    findViewById(2131300437).setVisibility(8);
    return;
    ReportController.b(this.app, "CliOper", "", "", "0X80050D7", "0X80050D7", 0, 0, "", "", "", "");
    ReportController.b(this.app, "CliOper", "", "", "0X80050E3", "0X80050E3", 0, 0, "0", "", "", "");
    a(paramView);
    startActivity(new Intent(getActivity(), SpecailCareListActivity.class));
    return;
    ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "Contacts_tab", "Clk_grp", 0, 0, "", "", "", "");
    a(paramView);
    startActivity(new Intent(getActivity(), TroopActivity.class));
    return;
    AddContactsActivity.a(getActivity());
    ReportController.b(this.app, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountActivity", 2, "enterPublicAccountActivity: " + System.currentTimeMillis());
    }
    a(paramView);
    PublicAccountActivity.a(getActivity());
    return;
    startActivity(new Intent(getActivity(), UncommonlyUsedContactsActivity.class));
    ReportController.b(this.app, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    if (getResources().getConfiguration().orientation == 2)
    {
      paramConfiguration = findViewById(2131297226);
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(0);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a();
    }
    this.app.c(this.jdField_a_of_type_Dsa);
    this.app.c(this.jdField_a_of_type_Drz);
    this.app.c(this.jdField_a_of_type_Dsb);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_Dsc);
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    paramViewStub.getId();
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView = ((FPSPinnedHeaderExpandableListView)paramView.findViewById(2131297262));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setChildDivider(null);
    paramViewStub = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView;
    paramView = LayoutInflater.from(getActivity());
    View localView2 = paramView.inflate(2130903191, paramViewStub, false);
    this.jdField_d_of_type_AndroidViewView = localView2;
    paramViewStub.a(localView2);
    Object localObject = localView2.findViewById(2131297271);
    View localView1 = localView2.findViewById(2131297275);
    localView2 = localView2.findViewById(2131297279);
    ((View)localObject).setOnClickListener(this);
    localView1.setOnClickListener(this);
    localView2.setOnClickListener(this);
    localObject = (PullRefreshHeader)paramView.inflate(2130903418, paramViewStub, false);
    ((PullRefreshHeader)localObject).setTag(new Contacts.OverScrollViewTag());
    paramViewStub.setOverScrollHeader((View)localObject);
    paramViewStub.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localObject);
    a(paramViewStub);
    paramViewStub.b(paramView.inflate(2130903174, paramViewStub, false));
    k();
    f();
    l();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.a();
    }
  }
  
  public void onPostThemeChanged()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
  }
  
  protected void readyStartAIO(int paramInt, String paramString) {}
  
  public void rightPanelEmpty()
  {
    super.rightPanelEmpty();
    g();
  }
  
  protected String setLastActivityName()
  {
    return getString(2131366000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Contacts
 * JD-Core Version:    0.7.0.1
 */