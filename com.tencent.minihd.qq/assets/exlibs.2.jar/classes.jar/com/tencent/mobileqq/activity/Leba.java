package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import efw;
import efx;
import efy;
import efz;
import ega;
import egb;
import egc;
import egd;
import egf;
import egg;
import egh;
import egi;
import egk;
import egl;
import egn;
import ego;
import egp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Constants.LogoutReason;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class Leba
  extends BaseActivity
  implements View.OnClickListener, ViewStub.OnInflateListener, LebaIconDownloader.IDownloadListener, CommonLoadingView.OnFirstDrawListener, QQTabHost.OnTabSelectionListener
{
  public static final int a = 11340001;
  private static final long jdField_a_of_type_Long = 500L;
  public static final String a = "leba_list_refresh";
  public static boolean a = false;
  public static final int b = 11340002;
  private static final String jdField_b_of_type_JavaLangString = "Q.lebatab.leba";
  private static final boolean jdField_b_of_type_Boolean = true;
  public static final int c = 11340005;
  public static final int d = 1134006;
  public static final int e = 1688001;
  public static int f;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public LebaListViewAdapter a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new egf(this);
  public DownloadIconsListener a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new egn(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new egd(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new egc(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public AdapterView.OnItemClickListener a;
  public XListView a;
  private List jdField_a_of_type_JavaUtilList;
  private View jdField_b_of_type_AndroidViewView;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  private boolean g;
  private boolean h = true;
  private boolean i = true;
  private final int j = 1;
  private int k = -1;
  
  static
  {
    jdField_f_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  public Leba()
  {
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new egl(this);
    this.jdField_a_of_type_AndroidOsHandler = new ego(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new efy(this);
  }
  
  private int a(List paramList, String paramString)
  {
    int n = -1;
    int m = 0;
    if (m < paramList.size())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)paramList.get(m);
      int i1;
      if (localLebaViewItem.a == null) {
        i1 = n;
      }
      for (;;)
      {
        m += 1;
        n = i1;
        break;
        i1 = n;
        if (paramString != null)
        {
          i1 = n;
          if (paramString.equals(localLebaViewItem.a.strPkgName)) {
            i1 = m;
          }
        }
      }
    }
    return n;
  }
  
  private void a(ImageView paramImageView, int paramInt, Drawable paramDrawable)
  {
    if (paramInt == 1)
    {
      paramImageView.setImageDrawable(LebaIconDownloader.a(this.app, paramDrawable));
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {
      return;
    }
    int m = getResources().getDimensionPixelSize(2131493324);
    switch (paramInt)
    {
    case 4: 
    default: 
      paramInt = m;
    }
    for (;;)
    {
      paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      if ((paramTextView == null) || ((paramTextView.leftMargin == paramInt) && (paramTextView.bottomMargin == paramInt))) {
        break;
      }
      paramTextView.setMargins(paramInt, 0, 0, paramInt);
      return;
      paramInt = getResources().getDimensionPixelSize(2131493324);
      continue;
      paramInt = getResources().getDimensionPixelSize(2131493326);
      continue;
      paramInt = getResources().getDimensionPixelSize(2131493325);
      continue;
      paramInt = getResources().getDimensionPixelSize(2131493326);
    }
  }
  
  private void a(LebaViewItem paramLebaViewItem)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.a == null) || (TextUtils.isEmpty(paramLebaViewItem.a.strPkgName))) {}
    long l;
    do
    {
      return;
      String str = paramLebaViewItem.a.strPkgName;
      if (((str.equals("com.tencent.xiaoshuo2.androidhd")) || (str.equals("com.tencent.manhua2.androidhd"))) && (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(str);
        this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
      }
      l = paramLebaViewItem.a.uiResId;
    } while (l == 0L);
    ReportController.b(this.app, "CliOper", "", "", "0X8005BFC", "0X8005BFC", 0, 0, l + "", "", "", "");
  }
  
  private void a(LebaViewItem paramLebaViewItem, int paramInt, ViewGroup paramViewGroup)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.a == null) || (paramInt == 0) || (paramViewGroup == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "invalid arguments in markNewFeatureUsed");
      }
    }
    do
    {
      do
      {
        return;
      } while (paramLebaViewItem.a.isNew != 0);
      paramLebaViewItem.a.isNew = 1;
      ThreadManager.b(new egb(this, paramLebaViewItem));
      paramLebaViewItem = paramViewGroup.findViewById(paramInt);
    } while (paramLebaViewItem == null);
    paramLebaViewItem.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {}
    try
    {
      paramString = new File(getFilesDir(), paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.minihd.qq:web".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (RedTouchManager)this.app.getManager(35);
      if (localObject != null) {
        ((RedTouchManager)localObject).b(34);
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    if ((this.app == null) || (this.app.a == null)) {
      return;
    }
    Object localObject = this.app.a.a();
    ResourcePluginInfo localResourcePluginInfo;
    if (localObject != null)
    {
      int m = 0;
      if (m < ((List)localObject).size())
      {
        localResourcePluginInfo = (ResourcePluginInfo)((List)localObject).get(m);
        if (localResourcePluginInfo == null) {}
        while ((TextUtils.isEmpty(localResourcePluginInfo.strPkgName)) || (!localResourcePluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          m += 1;
          break;
        }
      }
    }
    for (long l = localResourcePluginInfo.uiResId;; l = 0L)
    {
      localObject = (GameCenterManagerImp)this.app.getManager(11);
      if ((localObject != null) && ((((GameCenterManagerImp)localObject).a(601L)) || ((l > 0L) && (((GameCenterManagerImp)localObject).a(l))))) {
        ReportController.b(this.app, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
      }
      this.app.a.d();
      ((SplashActivity)getActivity()).a.k();
      return;
    }
  }
  
  private void h()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {}
    int m;
    do
    {
      return;
      m = a(this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_JavaLangString);
      if (m < 0) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXListView == null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setItemChecked(m, true);
    return;
    openDefualtRightPage();
  }
  
  private void i()
  {
    Object localObject = (ViewGroup)findViewById(2131297931);
    if ((localObject != null) && (((ViewGroup)localObject).getChildCount() > 0))
    {
      localObject = getFragmentManager();
      ReflectionUtil.a(localObject, localObject.getClass(), "noteStateNotSaved", null, null);
      ((FragmentManager)localObject).popBackStackImmediate();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new egk(this);
    }
    IntentFilter localIntentFilter = new IntentFilter("leba_list_refresh");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297933));
      this.jdField_a_of_type_ComTencentWidgetXListView.setChoiceMode(1);
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter = new LebaListViewAdapter(getActivity(), this.jdField_a_of_type_JavaUtilList, 2130903275, 2130903276, this.app, new egp(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        if (this.jdField_c_of_type_AndroidViewView == null)
        {
          this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2130903933, (FrameLayout)findViewById(2131297929), true);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296742));
          this.jdField_a_of_type_AndroidViewView = findViewById(2131297932);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131300128));
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131299473));
          this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131299461));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.b = this.jdField_c_of_type_AndroidViewView;
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new efx(this));
          reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      }
      g();
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.app);
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void m()
  {
    if ((this != null) && (this.app != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)this.app.getManager(9);
      if (localQZoneManager != null)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localQZoneManager.b(2);
        }
        localQZoneManager.a(false);
      }
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void n() {}
  
  private void o() {}
  
  private void p()
  {
    Object localObject = (TroopRedTouchManager)this.app.getManager(66);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a(1);
      if (localRedDotInfo != null) {
        TroopRedTouchHandler.a(this.app, localRedDotInfo);
      }
      localObject = ((TroopRedTouchManager)localObject).a(6);
      if (localObject != null) {
        TroopRedTouchHandler.a(this.app, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  protected void a()
  {
    ((ViewStub)findViewById(2131297930)).setOnInflateListener(this);
    ((CommonLoadingView)findViewById(2131297218)).setOnFirstDrawListener(this);
  }
  
  protected void a(int paramInt)
  {
    Object localObject = (TroopRedTouchManager)this.app.getManager(66);
    if (localObject == null) {
      return;
    }
    int m;
    if (((TroopRedTouchManager)localObject).a(7)) {
      m = 7;
    }
    for (;;)
    {
      label30:
      if (paramInt == 0) {}
      for (localObject = "Clk_tribe";; localObject = "exp_tribe")
      {
        ReportController.b(this.app, "P_CliOper", "Grp_tribe", "", "dynamic", (String)localObject, 0, 0, m + "", "", "", "");
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("xingqubuluo", 4, "reportTroopTribe,action=" + (String)localObject + ", appId=" + m);
        return;
        if (((TroopRedTouchManager)localObject).a(6))
        {
          m = 6;
          break label30;
        }
        if (!((TroopRedTouchManager)localObject).a(1)) {
          break label168;
        }
        m = 1;
        break label30;
        if (paramInt != 1) {
          break;
        }
      }
      label168:
      m = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost)
  {
    if ((paramInt2 == 5) && (LebaListViewAdapter.a(this)))
    {
      LebaListViewAdapter.a(this, false);
      if ((getParent() instanceof SplashActivity)) {
        ((SplashActivity)getParent()).a(null);
      }
    }
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if ((paramInt != 2) || (paramDrawable == null) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {}
    while ((paramVarArgs[0] == null) || (!(paramVarArgs[0] instanceof Integer))) {
      return;
    }
    ((Integer)paramVarArgs[0]).intValue();
  }
  
  public void a(View paramView, int paramInt, LebaViewItem paramLebaViewItem)
  {
    LebaViewItem localLebaViewItem;
    if (this.h)
    {
      this.h = false;
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new efz(this), 500L);
      if ((paramInt != -1) || (paramLebaViewItem == null)) {
        break label73;
      }
      localLebaViewItem = paramLebaViewItem;
    }
    for (;;)
    {
      if ((localLebaViewItem == null) || (localLebaViewItem.a == null)) {}
      label73:
      while ((paramView != null) && (paramView.isActivated()))
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
        return;
        if (paramInt < 0) {
          break label1604;
        }
        localLebaViewItem = (LebaViewItem)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.getItem(paramInt);
        break;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setItemChecked(paramInt, true);
        this.k = paramInt;
      }
      a(localLebaViewItem);
      Object localObject = localLebaViewItem.a.strGotoUrl;
      String str = localLebaViewItem.a.strResName;
      paramInt = localLebaViewItem.a.sResSubType;
      this.jdField_c_of_type_JavaLangString = localLebaViewItem.a.strPkgName;
      boolean bool1 = false;
      boolean bool2 = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str + ",url=" + (String)localObject);
      }
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(localLebaViewItem.a.uiResId + "");
      if ((localLebaViewItem.a != null) && (localLebaViewItem.a.uiResId > 0L)) {
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
          if (localAppInfo.type.get() != 0) {
            break label1598;
          }
        }
      }
      label439:
      label1598:
      for (bool1 = true;; bool1 = false)
      {
        paramLebaViewItem = "status=" + localAppInfo.type.get() + "&number=" + localAppInfo.num.get() + "&path=" + localAppInfo.path.get();
        label382:
        GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(11);
        if (localGameCenterManagerImp != null) {
          if (localGameCenterManagerImp.a(localLebaViewItem.a.uiResId + "") != -1)
          {
            bool2 = true;
            localRedTouchManager.b(localLebaViewItem.a.uiResId + "");
            bool3 = bool2;
            if (bool2) {
              this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
            }
          }
        }
        for (boolean bool3 = bool2;; bool3 = false)
        {
          bool2 = bool3;
          for (;;)
          {
            if ((localObject == null) || ("".equals(localObject)))
            {
              a(localLebaViewItem, localAppInfo, localRedTouchManager);
              return;
              paramLebaViewItem = "status=" + -1 + "&number=0" + "&path=" + localLebaViewItem.a.uiResId;
              bool1 = false;
              break label382;
              bool2 = false;
              break label439;
              if ((localLebaViewItem.a != null) && (localLebaViewItem.a.strPkgName.equals("qzone_feedlist")))
              {
                paramLebaViewItem = (QZoneManagerImp)this.app.getManager(9);
                bool2 = bool1;
                if (paramLebaViewItem != null) {
                  if (paramLebaViewItem.a(0) <= 0)
                  {
                    bool2 = bool1;
                    if (paramLebaViewItem.a(1) <= 0) {}
                  }
                  else
                  {
                    bool2 = true;
                  }
                }
                bool1 = false;
                paramLebaViewItem = null;
                continue;
              }
              if (localLebaViewItem.a == null) {
                break label1584;
              }
              if (localLebaViewItem.a.isNew == 0) {}
              for (bool1 = true;; bool1 = false)
              {
                bool2 = bool1;
                paramLebaViewItem = null;
                bool1 = false;
                break;
              }
            }
            if ((localLebaViewItem.a.cDataType == 0) && (paramView != null)) {
              a(localLebaViewItem, 2131297137, (ViewGroup)paramView);
            }
            if (paramInt == 0)
            {
              if (((String)localObject).indexOf("plg_auth=1") <= -1) {
                break label1581;
              }
              localObject = (String)localObject + "&sid=" + this.app.getSid();
            }
            for (;;)
            {
              paramView = (View)localObject;
              if (((String)localObject).indexOf("plg_uin=1") > -1) {
                paramView = (String)localObject + "&mqquin=" + this.app.a();
              }
              localObject = paramView;
              if (paramView.indexOf("plg_vkey=1") > -1) {
                localObject = paramView + "&mqqvkey=" + this.app.e();
              }
              paramView = new Intent(getActivity(), QQBrowserActivity.class);
              if (((String)localObject).indexOf("plg_nld=1") > -1) {
                paramView.putExtra("reportNld", true);
              }
              if (!TextUtils.isEmpty(paramLebaViewItem)) {
                paramView.putExtra("redTouch", paramLebaViewItem);
              }
              paramView.putExtra("uin", this.app.a());
              paramView.putExtra("vkey", this.app.d());
              paramView.putExtra("plugin_start_time", System.nanoTime());
              paramView.putExtra("click_start_time", System.currentTimeMillis());
              paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
              paramView.putExtra("is_from_leba", true);
              paramView.putExtra("has_red_dot", bool1);
              startActivity(paramView.putExtra("url", (String)localObject).putExtra("title", str));
              paramView = (View)localObject;
              do
              {
                a(localLebaViewItem, localAppInfo, localRedTouchManager);
                if ((localLebaViewItem.a.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) || (localLebaViewItem.a.strResName.contains(this.app.a().getResources().getString(2131367584)))) {
                  StatisticCollector.a(getActivity()).a(this.app, this.app.a(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
                }
                if ((paramView.trim().equals("mqqapi://redEnvelopeEnter/open?src_type=internal&version=1")) && (!((PortalManager)this.app.getManager(74)).a(getActivity(), false, 3, null)))
                {
                  paramView = new Intent(getActivity(), QQBrowserActivity.class);
                  paramView.putExtra("url", "https://3gimg.qq.com/qq_product_operations/hongbao/index.html?_wv=1027&_bid=351&f_hbadtag=3");
                  getActivity().startActivity(paramView);
                }
                this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11340005);
                if (localLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                  break;
                }
                this.jdField_c_of_type_Boolean = true;
                return;
                paramView = (View)localObject;
              } while (paramInt != 2);
              paramView = JumpParser.a(this.app, getActivity(), (String)localObject);
              if (paramView != null)
              {
                if ((!localLebaViewItem.a.strPkgName.equals("com.tx.gamecenter.android")) && (!localLebaViewItem.a.strResName.contains(this.app.a().getResources().getString(2131367584)))) {
                  break label1484;
                }
                paramView.c("platformId=qq_m");
              }
              for (;;)
              {
                paramView.a("from_leba", "fromleba");
                paramView.a("config_res_plugin_item_name", str);
                paramView.a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
                paramView.a(bool2);
                paramView.b(localLebaViewItem.a.strPkgName);
                paramView.d(paramLebaViewItem);
                paramView.b(bool1);
                paramView.a(localAppInfo);
                paramView.b();
                paramView = (View)localObject;
                if (!localLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                  break;
                }
                paramView = (QZoneManagerImp)this.app.getManager(9);
                if (paramView != null)
                {
                  if (QLog.isDevelopLevel()) {
                    QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
                  }
                  paramView.a(0);
                  paramView.a(true);
                }
                ReportController.b(this.app, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
                paramView = (View)localObject;
                break;
                label1484:
                if (localLebaViewItem.a.strPkgName.equals("com.tx.xingqubuluo.android"))
                {
                  paramInt = ((TroopRedTouchManager)this.app.getManager(66)).c();
                  if (paramInt > 0) {
                    paramView.c("redid=" + paramInt);
                  }
                  if (QLog.isDevelopLevel()) {
                    QLog.d("xingqubuluo", 4, "***redid=" + paramInt);
                  }
                }
              }
            }
            bool1 = false;
            paramLebaViewItem = null;
          }
        }
      }
      label1581:
      label1584:
      label1604:
      localLebaViewItem = null;
    }
  }
  
  protected void a(LebaViewItem paramLebaViewItem, BusinessInfoCheckUpdate.AppInfo paramAppInfo, RedTouchManager paramRedTouchManager)
  {
    if ((paramLebaViewItem.a != null) && (paramLebaViewItem.a.uiResId > 0L))
    {
      paramRedTouchManager = (WebProcessManager)this.app.getManager(12);
      String str = String.valueOf(paramLebaViewItem.a.uiResId);
      if ((paramAppInfo != null) && (paramRedTouchManager != null) && (paramRedTouchManager.a(str))) {
        ThreadManager.a().post(new ega(this, str, paramAppInfo));
      }
      ReportController.a(this.app, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + paramLebaViewItem.a.uiResId, "", "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new egg(this, paramBoolean), 150L);
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  protected void addTopLayout() {}
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new efw(this));
  }
  
  public void c()
  {
    if ((LebaShowListManager.a() == null) || (this.b == null)) {
      return;
    }
    if (LebaShowListManager.a().a())
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void d()
  {
    l();
    this.app.n();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.app.a.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewView);
    }
    i();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903360);
    this.jdField_f_of_type_Boolean = true;
    a();
    j();
    return false;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    WebProcessManager.c(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Log.i("app2", "Leba doOnResume");
    if ((!this.e) || ((LebaShowListManager.d & 0x4) != 0))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(11340002, 200L);
      this.e = true;
      WebProcessManager.c(true);
      if (!this.g) {
        break label153;
      }
      this.g = false;
      openDefualtRightPage();
    }
    for (;;)
    {
      this.i = false;
      return;
      if (LebaShowListManager.d <= 0) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      LebaUtil.a(localArrayList, LebaShowListManager.a().b());
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null)
        {
          h();
          this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
          n();
        }
      }
      LebaShowListManager.d = 0;
      break;
      label153:
      if ((!this.i) && (this.k >= 0) && (!a(this))) {
        a(null, this.k, null);
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    ThreadManager.b(new egi(this));
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.e();
    }
  }
  
  protected void f()
  {
    Object localObject = (RedTouchManager)this.app.getManager(35);
    int n;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        n = 0;
        int m = n;
        if (n == -1)
        {
          localAppInfo = ((RedTouchManager)localObject).a("886.100171");
          m = n;
          if (localAppInfo != null)
          {
            m = n;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              m = n;
              if (localAppInfo.type.get() != -1) {
                m = 1;
              }
            }
          }
        }
        n = m;
        if (m == -1)
        {
          localObject = ((RedTouchManager)localObject).a("886.100172");
          n = m;
          if (localObject != null)
          {
            n = m;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              n = m;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                n = 2;
              }
            }
          }
        }
        if (n != -1) {
          ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, n + "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + n);
      }
      return;
      n = -1;
      break;
      n = -1;
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    label65:
    ThemeBackground localThemeBackground2;
    label128:
    label130:
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_ComTencentWidgetXListView.getTag() instanceof ThemeBackground)) {}
        for (ThemeBackground localThemeBackground1 = (ThemeBackground)this.jdField_a_of_type_ComTencentWidgetXListView.getTag();; localThemeBackground1 = null)
        {
          if (ThemeBackground.getThemeBackgroundEnable()) {
            break label65;
          }
          if (localThemeBackground1 == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(null, false);
          this.jdField_a_of_type_ComTencentWidgetXListView.setTag(null);
          return;
        }
        if (localThemeBackground1 != null) {}
        for (localThemeBackground2 = localThemeBackground1;; localThemeBackground2 = new ThemeBackground())
        {
          if (!ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentWidgetXListView.getContext(), "theme_bg_message_path_png", this.app.a(), localThemeBackground2)) {
            break label128;
          }
          if (localThemeBackground2.path != "null") {
            break label130;
          }
          if (localThemeBackground1 == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(null, false);
          return;
        }
      }
    } while (localThemeBackground2.img == null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(localThemeBackground2.img, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(localThemeBackground2);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    clearTabStack();
    this.g = true;
    LebaShowListManager.a().a();
    n();
    d();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1688001))
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131492923), 0.0F);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setAnimationListener(new egh(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
      ThreadPriorityManager.a(true);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    LebaShowListManager.a().jdField_a_of_type_Boolean = true;
    paramView = new Intent(getActivity(), LebaListMgrActivity.class);
    paramView.putExtra("display_like_dialog", true);
    startActivity(paramView);
  }
  
  protected void onDestroy()
  {
    if (this.app != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (this.app.a != null) {
        this.app.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
      }
    }
    k();
    super.onDestroy();
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    d();
    if (!this.e) {
      doOnResume();
    }
    this.e = true;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onPostThemeChanged()
  {
    g();
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  public void openDefualtRightPage()
  {
    a(null, 0, null);
  }
  
  public void rightPanelEmpty()
  {
    super.rightPanelEmpty();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentWidgetXListView.e();
      this.jdField_a_of_type_ComTencentWidgetXListView.requestLayout();
    }
  }
  
  protected String setLastActivityName()
  {
    return getString(2131366001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */