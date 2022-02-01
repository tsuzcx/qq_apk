package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.cur.IDragView.OnChangeModeListener;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQTabActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.OGStat;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomWidgetUtil;
import fbp;
import fbq;
import fbr;
import fbs;
import fbt;
import fbu;
import fbv;
import fbw;
import fbx;
import fby;
import fbz;
import fcb;
import fcc;
import fcd;
import fce;
import fcf;
import fcg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.Constants.LogoutReason;
import protocol.KQQConfig.UpgradeInfo;

public class SplashActivity
  extends QQTabActivity
{
  public static final int a = 0;
  private static volatile Activity jdField_a_of_type_AndroidAppActivity;
  private static volatile SplashActivity jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
  public static final String a = "SplashActivity";
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "tab_index";
  public static boolean b = false;
  public static final int c = 2;
  public static final String c = "消息";
  public static final int d = 3;
  public static final String d = "联系人";
  public static final int e = 4;
  public static final String e = "动态";
  public static final int f = 5;
  public static final String f = "发现";
  public static final int g = 6;
  public static final String g = "我";
  public static final int h = 0;
  public static final String h = "电话";
  public static final int i = 0;
  public static final String i = "_icon";
  public static final int j = 1;
  public static final String j = "_num";
  public static final int k = 3;
  public static final String k = "_new";
  public static final int l = 4;
  public static final String l = "_text";
  public static final int m = 300000;
  public static final int n = 16;
  public static final int o = 17;
  public static final int p = 18;
  public static final int q = 19;
  public static final int r = 32;
  public static final int s = 33;
  public static final int t = 34;
  public static final int u = 35;
  public static final int v = 36;
  public static final int w = 36;
  public Dialog a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public View a;
  public MainAssistObserver a;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQTabWidget.onTabWidgetTouchMoveListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = new fbv(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = null;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  public View b;
  private HashMap jdField_b_of_type_JavaUtilHashMap = null;
  private View c;
  public boolean c;
  public boolean d = false;
  public boolean e = true;
  public String m;
  private String v = null;
  private String w = null;
  
  static
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("SplashActivity escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.b = str + "\n" + Log.getStackTraceString(localThrowable);
      }
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = true;
      jdField_b_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
      return;
      BaseApplicationImpl.b = "";
    }
  }
  
  public SplashActivity()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_new");
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      return 2;
    }
    localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_num");
    if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0)) {
      return 3;
    }
    paramString = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_icon");
    if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
      return 1;
    }
    return 0;
  }
  
  public static Activity a()
  {
    return jdField_a_of_type_AndroidAppActivity;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i1 = getResources().getDimensionPixelSize(2131493459);
    SizeMeasure.c(this);
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i1, i1, true);
    SizeMeasure.b(this);
    return paramBitmap;
  }
  
  private View a(int paramInt)
  {
    Object localObject1 = getResources();
    SizeMeasure.c(this);
    localObject1 = BitmapFactory.decodeResource((Resources)localObject1, paramInt);
    SizeMeasure.b(this);
    Object localObject2 = a((Bitmap)localObject1);
    localObject1 = getLayoutInflater().inflate(2130903370, null);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131297979);
    localImageView.setBackgroundResource(2130842017);
    localImageView.setImageBitmap((Bitmap)localObject2);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localObject2 = localImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = -1;
    ((ViewGroup.LayoutParams)localObject2).height = SizeMeasure.a(this);
    return localObject1;
  }
  
  private View a(int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    View localView = getLayoutInflater().inflate(2130903370, null);
    ((ImageView)localView.findViewById(2131297979)).setBackgroundResource(paramInt);
    if (paramDragFrameLayout != null)
    {
      DragTextView localDragTextView = (DragTextView)localView.findViewById(2131297980);
      localDragTextView.setOnModeChangeListener(paramDragFrameLayout);
      localDragTextView.setDragViewType(2);
      localDragTextView.setTag("tab_tag");
    }
    return localView;
  }
  
  private String a()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "getCurrentTabTag. mTabHost is null");
      }
      localObject = null;
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return localObject;
        str1 = "";
        str2 = this.jdField_a_of_type_AndroidWidgetTabHost.getCurrentTabTag();
        localObject = str1;
      } while (str2 == null);
      if (str2.equals(Conversation.class.getName())) {
        return "消息";
      }
      if (str2.equals(Contacts.class.getName())) {
        return "联系人";
      }
      if (str2.equals(QzoneWrapperActivity.class.getName())) {
        return "动态";
      }
      if (str2.equals(Leba.class.getName())) {
        return "发现";
      }
      if (str2.equals(Call.class.getName())) {
        return "电话";
      }
      localObject = str1;
    } while (!str2.equals(SettingMe.class.getName()));
    return "我";
  }
  
  private void a(int paramInt, fcf paramfcf)
  {
    if (paramfcf == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, paramfcf.jdField_a_of_type_JavaLangString + " is execute");
        }
        if (paramInt == 2131296419)
        {
          paramfcf = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
          if ((paramfcf == null) || (paramfcf.a == null))
          {
            if (QLog.isColorLevel()) {
              QLog.w("SplashActivity", 2, "mWrapper is null");
            }
            QQToast.a(getApplicationContext(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131492923));
          }
          for (;;)
          {
            ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
            return;
            if (paramfcf.a.iUpgradeType == 0) {
              QQToast.a(getApplicationContext(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131492923));
            } else if ((paramfcf != null) && (paramfcf.a != null)) {
              UpgradeDetailActivity.a(this, UpgradeController.a().a(), false, false, true);
            }
          }
        }
        if (paramInt != 2131296421) {
          break;
        }
        ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
      } while (!PhoneNumLoginImpl.a().a(this.app, this));
      b();
      return;
      if (paramInt == 2131296422)
      {
        a();
        return;
      }
    } while (paramfcf.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
    a(paramfcf.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
  }
  
  private void a(Activity paramActivity)
  {
    jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    AboutConfig.a(this.app, this, paramResourcePluginInfo);
    if (paramResourcePluginInfo.strPkgName.equals("com.tx.abouthelp")) {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
    }
  }
  
  private void a(fcg paramfcg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "removeTabAndFrame, tabinfo:" + paramfcg);
    }
    if (((this.jdField_a_of_type_ArrayOfAndroidViewView == null) || (paramfcg == null) || (TextUtils.isEmpty(paramfcg.jdField_a_of_type_JavaLangString))) && (QLog.isColorLevel())) {
      QLog.e("SplashActivity", 2, "removeTabAndFrame has error");
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      paramString2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while (paramString2 == null);
    StringBuilder localStringBuilder = new StringBuilder();
    label51:
    int i1;
    TextView localTextView;
    if ("消息".equals(paramString1))
    {
      localStringBuilder.append("消息栏");
      i1 = a(paramString1);
      localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (i1 != 2) {
        break label217;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      paramString2.setContentDescription(localStringBuilder.toString());
      return;
      if ("联系人".equals(paramString1))
      {
        localStringBuilder.append("联系人栏");
        break label51;
      }
      if ("动态".equals(paramString1))
      {
        localStringBuilder.append("动态栏");
        break label51;
      }
      if ("发现".equals(paramString1))
      {
        localStringBuilder.append("发现栏");
        break label51;
      }
      if ("我".equals(paramString1))
      {
        localStringBuilder.append("帐号与设置栏");
        break label51;
      }
      if (!"电话".equals(paramString1)) {
        break;
      }
      localStringBuilder.append("电话栏");
      break label51;
      label217:
      if (i1 == 3)
      {
        if ("消息".equals(paramString1))
        {
          paramString1 = localTextView.getText().toString();
          if ("99+".equals(paramString1)) {
            localStringBuilder.append("多于99条未读");
          } else {
            localStringBuilder.append(paramString1 + "条未读");
          }
        }
        else if ("电话".equals(paramString1))
        {
          paramString1 = localTextView.getText().toString();
          if (localTextView.getVisibility() == 0) {
            if ("99+".equals(paramString1)) {
              localStringBuilder.append("多于99个新的未接来电");
            } else {
              localStringBuilder.append(paramString1 + "个新的未接来电");
            }
          }
        }
      }
      else if (i1 == 1) {
        localStringBuilder.append("有新消息");
      }
    }
  }
  
  public static void a(boolean paramBoolean) {}
  
  private View[] a(View paramView)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null) {
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(10);
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131297977));
      h();
      View localView1 = a(2130838406);
      View localView2 = a(2130842015, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      View localView3 = a(2130842013, null);
      View localView4 = a(2130842014, null);
      RedTouch localRedTouch = new RedTouch(this, a(2130842016, null)).a(49).e(5).a(true).a();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localView1, localView2, localView3, localView4, localRedTouch };
      this.jdField_a_of_type_JavaUtilHashMap.put("我", localView1);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息", localView2);
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人", localView4);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", localRedTouch);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息_num", localView2.findViewById(2131297980));
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人_num", localView4.findViewById(2131297980));
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", localRedTouch.findViewById(2131297980));
      if (paramView == null) {
        break label349;
      }
    }
    label349:
    for (paramView = (QQTabWidget)paramView.findViewById(16908307);; paramView = (QQTabWidget)findViewById(16908307))
    {
      paramView.setTabWidgetMoveListener(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener);
      paramView.setTabNum(this.jdField_a_of_type_ArrayOfAndroidViewView.length);
      if (LebaListViewAdapter.a(this))
      {
        paramView = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramView.red_type.set(0);
        a(paramView);
      }
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)findViewById(2131297977));
      break;
    }
  }
  
  private void b(Intent paramIntent)
  {
    Intent localIntent = new Intent(this, OpenidToUinActivity.class);
    localIntent.putExtra("openid", paramIntent.getStringExtra("openid"));
    localIntent.putExtra("appid", paramIntent.getIntExtra("appid", -1));
    localIntent.putExtra("source", paramIntent.getStringExtra("source"));
    localIntent.setFlags(268435456);
    paramIntent.removeExtra("openid");
    paramIntent.removeExtra("appid");
    paramIntent.removeExtra("source");
    startActivity(localIntent);
  }
  
  private boolean b()
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("发现");
    if (localRedTouch == null) {
      return false;
    }
    return localRedTouch.a();
  }
  
  private void c(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("forward", -1))
    {
    }
    for (;;)
    {
      getIntent().removeExtra("forward");
      return;
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramIntent.getStringExtra("uin"));
      localIntent.putExtra("uintype", paramIntent.getIntExtra("uintype", 0));
      localIntent.putExtra("yuyin", paramIntent.getBooleanExtra("yuyin", false));
      localIntent.putExtra("uinname", paramIntent.getStringExtra("uinname"));
      localIntent.putExtra("enterchatwin", true);
      startActivity(localIntent);
      getIntent().removeExtra("fromMsgBox");
      continue;
      paramIntent = paramIntent.getParcelableExtra("AllInOne");
      if ((paramIntent instanceof ProfileActivity.AllInOne))
      {
        paramIntent = (ProfileActivity.AllInOne)paramIntent;
        paramIntent.f = 100;
        paramIntent.g = 6;
        ProfileActivity.b(this, paramIntent);
      }
    }
  }
  
  private void e()
  {
    if (AIOUtils.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        AIOUtils.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("traceviewSwitch", false);
        AIOUtils.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("forbidChatFont", false);
        AIOUtils.d = getIntent().getBooleanExtra("forbidHeadPendant", false);
        AIOUtils.f = getIntent().getBooleanExtra("forbidChatBubble", false);
        AIOUtils.g = getIntent().getBooleanExtra("logDBOperation", false);
        AIOUtils.jdField_a_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SplashActivity", 2, "traceviewSwitch: " + AIOUtils.jdField_b_of_type_Boolean + " isForbidChatFontFun: " + AIOUtils.jdField_c_of_type_Boolean + " isForbidHeadPendantFun: " + AIOUtils.d + " isForbidChatBubbleFun: " + AIOUtils.f + " logcatDBOperation: " + AIOUtils.g + " isEnableAutoDumpLeak: " + AppSetting.j);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SplashActivity", 2, "", localException);
          }
        }
      }
    }
  }
  
  private void f()
  {
    String str2 = a();
    if (("消息".equals(str2)) || ("联系人".equals(str2))) {
      if (!"消息".equals(str2)) {
        break label360;
      }
    }
    label360:
    for (Object localObject = "Msg_tab";; localObject = "Contacts_tab")
    {
      ReportController.b(this.app, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      DragTextView localDragTextView = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get(str2 + "_num");
      String str1 = "0";
      localObject = str1;
      if (localDragTextView != null)
      {
        localObject = str1;
        if (localDragTextView.getVisibility() == 0)
        {
          localObject = str1;
          if (!TextUtils.isEmpty(localDragTextView.getText())) {
            localObject = "1";
          }
        }
      }
      if ("发现".equals(str2)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005BFE", "0X8005BFE", 0, 0, (String)localObject, "", "", "");
      }
      if ("我".equals(str2)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006118", "0X8006118", 0, 0, (String)localObject, "", "", "");
      }
      if ("消息".equals(str2)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006121", "0X8006121", 0, 0, (String)localObject, "", "", "");
      }
      if ("电话".equals(str2)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006123", "0X8006123", 0, 0, (String)localObject, "", "", "");
      }
      if ("联系人".equals(str2)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006125", "0X8006125", 0, 0, (String)localObject, "", "", "");
      }
      if ("动态".equals(str2)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006127", "0X8006127", 0, 0, (String)localObject, "", "", "");
      }
      return;
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "showActionSheet");
    }
    a();
    if (isFinishing()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new fcf();
    ((fcf)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131367884);
    localArrayList.add(new Pair(Integer.valueOf(2131296419), localObject));
    localObject = new fcf();
    ((fcf)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131366213);
    localArrayList.add(new Pair(Integer.valueOf(2131296421), localObject));
    localObject = new fcf();
    ((fcf)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131366375);
    localArrayList.add(new Pair(Integer.valueOf(2131296422), localObject));
    localObject = ActionSheet.c(this);
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      if (2131296422 == ((Integer)((Pair)localArrayList.get(i1)).first).intValue()) {
        ((ActionSheet)localObject).d(((fcf)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((ActionSheet)localObject).c(((fcf)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((ActionSheet)localObject).a(new fcc(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new fcd(this));
    ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h() {}
  
  private void i()
  {
    ReportController.b(this.app, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    if ((this.app == null) || (this.app.a == null)) {
      return;
    }
    Object localObject = this.app.a.a().iterator();
    ResourcePluginInfo localResourcePluginInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localResourcePluginInfo = (ResourcePluginInfo)((Iterator)localObject).next();
    } while ((TextUtils.isEmpty(localResourcePluginInfo.strPkgName)) || (!localResourcePluginInfo.strPkgName.equals("m.tx.apphelper.android")));
    for (long l1 = localResourcePluginInfo.uiResId;; l1 = 0L)
    {
      localObject = (GameCenterManagerImp)this.app.getManager(11);
      if ((localObject == null) || ((!((GameCenterManagerImp)localObject).a(601L)) && ((l1 <= 0L) || (!((GameCenterManagerImp)localObject).a(l1))))) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return b(getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903294);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296606);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297370);
    if (paramString1 != null) {
      paramString1.setText(2131365736);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297371);
    if (paramString1 != null) {
      paramString1.setText(2131365737);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_b_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {}
    boolean bool;
    String str2;
    String str1;
    Object localObject;
    label87:
    TextView localTextView;
    do
    {
      return;
      bool = false;
      str2 = "";
      switch (paramInt1)
      {
      case 34: 
      case 35: 
      default: 
        str1 = "";
        switch (paramInt2)
        {
        default: 
          localObject = null;
          localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(str1 + "_num");
        }
        break;
      }
    } while ((localTextView == null) || (localObject == null));
    int i1;
    if ((paramObject instanceof Integer)) {
      i1 = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      label145:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
      label224:
      int i4;
      int i3;
      int i2;
      int i5;
      if (((String)localObject).equals(str1 + "_num"))
      {
        localSharedPreferences.edit().putInt((String)localObject + this.app.getAccount(), i1).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(localObject, paramObject);
        i1 = 0;
        i4 = a(str1);
        i3 = i1;
        if (i4 == 3)
        {
          paramObject = this.jdField_b_of_type_JavaUtilHashMap.get(str1 + "_num");
          i3 = i1;
          if ((paramObject instanceof Integer)) {
            i3 = ((Integer)paramObject).intValue();
          }
        }
        paramObject = str2;
        if (i4 == 5)
        {
          localObject = this.jdField_b_of_type_JavaUtilHashMap.get(str1 + "_text");
          paramObject = str2;
          if ((localObject instanceof String)) {
            paramObject = (String)localObject;
          }
        }
        i2 = 0;
        i1 = i4;
        if (paramInt1 == 32)
        {
          if (i3 <= 99) {
            break label851;
          }
          i4 = getResources().getDimensionPixelSize(2131493320);
          i5 = getResources().getDimensionPixelSize(2131493317);
          i1 = 4;
          i2 = 2130841958;
          label411:
          localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
          if (localObject != null)
          {
            ((RelativeLayout.LayoutParams)localObject).setMargins(i5, i4, 0, 0);
            localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        if (paramInt1 != 36) {
          break label919;
        }
        if (i3 <= 99) {
          break label889;
        }
        i4 = getResources().getDimensionPixelSize(2131493320);
        i5 = getResources().getDimensionPixelSize(2131493317);
        i1 = 4;
        i2 = 2130841958;
        label489:
        localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).setMargins(i5, i4, 0, 0);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      label919:
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(i1).append(",").append("num = ").append(i3).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
          QLog.d("SplashActivity", 4, ((StringBuilder)localObject).toString());
        }
        CustomWidgetUtil.a(localTextView, i1, i3, i2, 99, paramObject);
        a(str1, a());
        return;
        str1 = "消息";
        break;
        str1 = "联系人";
        break;
        str1 = "电话";
        break;
        localObject = str1 + "_num";
        break label87;
        localObject = str1 + "_icon";
        break label87;
        localObject = str1 + "_new";
        break label87;
        if (!(paramObject instanceof Boolean)) {
          break label922;
        }
        bool = ((Boolean)paramObject).booleanValue();
        i1 = 0;
        break label145;
        localSharedPreferences.edit().putBoolean((String)localObject + this.app.getAccount(), bool).commit();
        break label224;
        label851:
        int i6 = getResources().getDimensionPixelSize(2131493318);
        i5 = getResources().getDimensionPixelSize(2131493317);
        i1 = i4;
        i2 = 0;
        i4 = i6;
        break label411;
        label889:
        i4 = getResources().getDimensionPixelSize(2131493318);
        i5 = getResources().getDimensionPixelSize(2131493317);
        i2 = 0;
        break label489;
      }
      label922:
      i1 = 0;
    }
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    switch (paramInt)
    {
    }
    RedTouch localRedTouch;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilHashMap == null);
      localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("动态");
      if ((localRedTouch != null) && (paramRedTypeInfo != null))
      {
        switch (paramRedTypeInfo.red_type.get())
        {
        case 1: 
        case 2: 
        case 3: 
        default: 
          localRedTouch.a();
        }
        for (;;)
        {
          localRedTouch.a(paramRedTypeInfo);
          return;
          localRedTouch.b(15).a();
          continue;
          localRedTouch.b(0).a();
        }
      }
    } while (localRedTouch == null);
    localRedTouch.a();
    localRedTouch.a();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      Class localClass = (Class)paramIntent.getSerializableExtra("target_activity");
      if (localClass != null)
      {
        int i1 = paramIntent.getIntExtra("tab_index", 1);
        a(i1);
        paramIntent.setClass(this, localClass);
        paramIntent.removeExtra("target_activity");
        if (i1 != 4) {
          b().startActivity(paramIntent);
        }
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {}
    RedTouch localRedTouch;
    do
    {
      return;
      localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("发现");
      if ((localRedTouch != null) && (paramRedTypeInfo != null))
      {
        localRedTouch.b(15).a();
        localRedTouch.a(paramRedTypeInfo);
        return;
      }
    } while (localRedTouch == null);
    localRedTouch.a();
    localRedTouch.a();
  }
  
  public void a(String paramString)
  {
    ThreadManager.a().post(new fbz(this, paramString));
  }
  
  public boolean a()
  {
    g();
    return true;
  }
  
  protected void addTopLayout() {}
  
  public Dialog b(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296606);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297370);
    if (paramString1 != null) {
      paramString1.setText(17039370);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297371);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  void b()
  {
    c();
    if (isFinishing()) {
      return;
    }
    Dialog localDialog = a("退出", "你确定退出QQ？", new fce(this));
    Object localObject = (TextView)localDialog.findViewById(2131297371);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new fbq(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131297370);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new fbr(this));
    }
    localObject = getString(2131367905);
    boolean bool = SettingCloneUtil.isContainValue(this, this.app.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.e = SettingCloneUtil.readValue(this, this.app.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131297592);
    if ((bool) && (this.e)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.e);
    ((CheckBox)localObject).setOnCheckedChangeListener(new fbs(this));
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void d()
  {
    Object localObject = b();
    if ((localObject != null) && ((localObject instanceof Conversation)))
    {
      localObject = (VipGiftManager)this.app.getManager(72);
      if (localObject != null)
      {
        VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
        if ((localVipGiftDownloadInfo != null) && (isResume()) && (localVipGiftDownloadInfo.d == 2L)) {
          ((VipGiftManager)localObject).a(localVipGiftDownloadInfo, this);
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setRequestedOrientation(-1);
    int i1;
    if ((BaseApplicationImpl.b != null) && (BaseApplicationImpl.b.length() > 0)) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        Intent localIntent = new Intent(getIntent());
        localIntent.addFlags(603979776);
        super.finish();
        super.startActivity(localIntent);
      }
      try
      {
        Thread.sleep(50L);
        System.exit(-1);
        StartupTracker.a(null, "Main_Start");
        StartupTracker.a(null, "Main_OnCreat");
        StartupTracker.a(null, "Main_ui_create_super_create");
        super.doOnCreate(paramBundle);
        StartupTracker.a("Main_ui_create_super_create", null);
        if (UserguideActivity.a(this)) {
          for (;;)
          {
            try
            {
              if (getIntent().getStringExtra("openid") == null) {
                continue;
              }
              paramBundle = getIntent();
              paramBundle.setClass(this, UserguideActivity.class);
              startActivity(paramBundle);
            }
            catch (Exception paramBundle)
            {
              continue;
            }
            this.jdField_c_of_type_Boolean = true;
            finish();
            StartupTracker.a("Main_OnCreat", null);
            return false;
            i1 = 0;
            break;
            paramBundle = new Intent();
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            if (getIntent().getStringExtra("openid") != null) {
              b(getIntent());
            }
            label197:
            if ((jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != this))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SplashActivity", 2, "duplicate SplashActivity: " + jdField_a_of_type_ComTencentMobileqqActivitySplashActivity + ", " + this);
              }
              this.jdField_c_of_type_Boolean = true;
              finish();
              return false;
            }
            jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = this;
            jdField_a_of_type_Boolean = true;
            jdField_b_of_type_Boolean = false;
            this.app.isClearTaskBySystem = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver = new MainAssistObserver(this);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(this.app))
            {
              this.jdField_c_of_type_Boolean = true;
              finish();
              StartupTracker.a("Main_OnCreat", null);
              return false;
            }
            if ((NotificationActivity.a == null) && (!this.app.isLogin()))
            {
              startActivity(new Intent(this, LoginActivity.class));
              this.jdField_c_of_type_Boolean = true;
              finish();
              StartupTracker.a("Main_OnCreat", null);
              return false;
            }
            StartupTracker.a(null, "Main_ui_create_set_content");
            if (this.jdField_c_of_type_AndroidViewView != null)
            {
              setContentView(this.jdField_c_of_type_AndroidViewView);
              label400:
              StartupTracker.a("Main_ui_create_set_content", null);
              getWindow().setBackgroundDrawable(null);
              if (this.app != null)
              {
                this.m = this.app.getAccount();
                if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {
                  this.jdField_a_of_type_ArrayOfAndroidViewView = a(null);
                }
                a(null, SettingMe.class, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
                a(null, Conversation.class, this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
                a(null, Call.class, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
                a(null, Contacts.class, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
                a(null, QzoneWrapperActivity.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
                this.jdField_a_of_type_AndroidWidgetTabHost.setCurrentTab(1);
                if (SizeMeasure.jdField_b_of_type_Boolean) {
                  ((QQTabWidget)this.jdField_a_of_type_AndroidWidgetTabHost.getTabWidget()).a();
                }
                this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
                a(this.app.a());
              }
            }
            try
            {
              paramBundle = (NotificationManager)getSystemService("notification");
              paramBundle.cancel(120);
              paramBundle.cancel(121);
              paramBundle.cancel(122);
              paramBundle.cancel(123);
              paramBundle.cancel(129);
              label606:
              if (getIntent().getExtras() != null) {
                if (getIntent().getExtras().containsKey("forward")) {
                  this.mCanLock = false;
                }
              }
              try
              {
                this.v = getIntent().getStringExtra("jump_action_from_h5");
                this.w = getIntent().getStringExtra("package_from_h5");
                label665:
                this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.j();
                Utils.a(getWindow(), true);
                if (QLog.isColorLevel()) {
                  QLog.d("Version", 2, "QQ_Version:5.9.3.3468");
                }
                QLog.sBuildNumber = "5.9.3.3468.2021-11-21.r2cb8ec.YingYongBao";
                StartupTracker.a("Main_OnCreat", null);
                a(getIntent());
                QbSdk.initX5Environment(BaseApplicationImpl.a().getApplicationContext(), null);
                return true;
                setContentView(2130903369);
                break label400;
                localException = localException;
              }
              catch (Exception paramBundle)
              {
                break label665;
              }
            }
            catch (Exception paramBundle)
            {
              break label606;
            }
          }
        }
        catch (Exception paramBundle)
        {
          break label197;
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d();
        }
        ScreenCapture.clearSnapCacheFile(this);
      } while (!isFinishing());
      try
      {
        OGStat.a().a();
        UniformDownloadMgr.a().b();
        if (QLog.isColorLevel()) {
          QLog.d("MemoryManager", 2, "MainActivity.onDestory.TMAssistantDownloadSDKManager.getInstance(BaseApplication.getContext()).closeAllService(BaseApplication.getContext()");
        }
        if (DownloadManager.a()) {
          DownloadManager.a().e();
        }
        AppNotificationManager.a().a();
        TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          continue;
          boolean bool = false;
        }
        if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
          break label247;
        }
        this.app.startPCActivePolling(this.app.getAccount(), "exitApp");
        this.app.b(true);
        return;
        this.app.b(false);
      }
      if (this.d) {
        break;
      }
      bool = true;
      jdField_b_of_type_Boolean = bool;
    } while (this.app == null);
    this.app.isClearTaskBySystem = jdField_b_of_type_Boolean;
    if (jdField_b_of_type_Boolean)
    {
      this.app.isBackground_Stop = true;
      sendBroadcast(new Intent("mqq.intent.action.EXIT" + getPackageName()));
      return;
    }
    label247:
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onNewIntent ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SplashActivity", 2, bool);
      if (paramIntent.getStringExtra("openid") != null) {
        b(paramIntent);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
        break;
      }
      return;
    }
    if ((getIntent().getExtras() != null) && (getIntent().getExtras().containsKey("forward"))) {
      this.mCanLock = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.j();
    Object localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      if (Boolean.valueOf(((Bundle)localObject).getBoolean("EXIT", false)).booleanValue()) {
        finish();
      }
      if (((Bundle)localObject).containsKey("tab_index"))
      {
        if (this.jdField_a_of_type_AndroidWidgetTabHost == null) {
          break label241;
        }
        if (((Bundle)localObject).getInt("tab_index") == 1) {
          ((Bundle)localObject).getInt("conversation_index", -1);
        }
      }
    }
    for (;;)
    {
      try
      {
        if (paramIntent.getIntExtra("forward", -1) == 2)
        {
          localObject = paramIntent.getParcelableExtra("AllInOne");
          if ((localObject instanceof ProfileActivity.AllInOne))
          {
            localObject = (ProfileActivity.AllInOne)localObject;
            ((ProfileActivity.AllInOne)localObject).f = 100;
            ((ProfileActivity.AllInOne)localObject).g = 6;
            ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
          }
        }
        paramIntent.removeExtra("forward");
      }
      catch (Exception localException)
      {
        label241:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SplashActivity", 1, "", localException);
        continue;
      }
      a(paramIntent);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "MainActivity:onNewIntent mTabHost is null");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    a();
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = false;
    if (DrawerFrame.f == 2)
    {
      Handler localHandler = this.app.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessageDelayed(1031, 1000L);
      }
    }
  }
  
  public void doOnResume()
  {
    StartupTracker.a(null, "Main_OnResume");
    if (DrawerFrame.f > 0)
    {
      localObject1 = this.app.a(Conversation.class);
      if (localObject1 != null) {
        ((Handler)localObject1).removeMessages(1031);
      }
      Conversation.i();
    }
    super.doOnResume();
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    Object localObject1 = getWindow();
    if ((((Window)localObject1).getAttributes().flags & 0x400) != 0) {
      ((Window)localObject1).clearFlags(1024);
    }
    if (this.app.getKickIntent() != null) {
      startActivity(this.app.getKickIntent());
    }
    do
    {
      return;
      c(getIntent());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null);
    if (!jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.i();
    }
    StartupTracker.a(null, "Main_Resume_Sound");
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.a());
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("theme_voice_setting_" + this.app.a(), true))
    {
      localObject1 = ThemeUtil.getThemeInfo(this, ThemeUtil.getUserCurrentThemeId(this.app));
      if ((localObject1 == null) || (!((ThemeUtil.ThemeInfo)localObject1).status.equals("5")) || (!((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme)) {}
    }
    for (boolean bool = false;; bool = true)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.get("消息") != null) {
          ((View)this.jdField_a_of_type_JavaUtilHashMap.get("消息")).setSoundEffectsEnabled(bool);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.get("联系人") != null) {
          ((View)this.jdField_a_of_type_JavaUtilHashMap.get("联系人")).setSoundEffectsEnabled(bool);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.get("动态") != null) {
          ((View)this.jdField_a_of_type_JavaUtilHashMap.get("动态")).setSoundEffectsEnabled(bool);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.get("发现") != null) {
          ((View)this.jdField_a_of_type_JavaUtilHashMap.get("发现")).setSoundEffectsEnabled(bool);
        }
      }
      StartupTracker.a("Main_Resume_Sound", null);
      if (this.app.getDevLockIntent() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume start push");
        }
        new Handler().postDelayed(new fbp(this), 800L);
      }
      if ((this.app.isLogin()) && (this.app.getAccount().equals(BaseApplicationImpl.a().a())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PCActive_SplashActivity", 2, "onResume start push");
        }
        if (!isResume()) {
          break;
        }
        localObject1 = BaseApplicationImpl.a().a();
        if (localObject1 != null) {
          break label695;
        }
        if (QLog.isColorLevel()) {
          QLog.i("PCActive_SplashActivity", 2, "Intent is null");
        }
      }
      for (;;)
      {
        if (this.app.a() != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "onResume security detect push banner");
          }
          new Handler().postDelayed(new fbw(this), 800L);
        }
        StartupTracker.a(null, "Main_Resume_PCActive");
        if ((!TextUtils.isEmpty(this.app.getAccount())) && (!"0".equals(this.app.getAccount())))
        {
          bool = SettingCloneUtil.readValue(this.app.a(), this.app.getAccount(), null, "pcactive_notice_key", false);
          if ((!SettingCloneUtil.readValue(this.app.a(), this.app.getAccount(), null, "pcactive_has_notice", false)) && (bool))
          {
            QLog.d("SplashActivity", 1, "PCActive tips");
            SettingCloneUtil.writeValue(this.app.a(), this.app.getAccount(), null, "pcactive_has_notice", true);
            new Handler().postDelayed(new fbx(this), 800L);
          }
        }
        StartupTracker.a("Main_Resume_PCActive", null);
        StartupTracker.a("Main_OnResume", null);
        a(this);
        return;
        try
        {
          label695:
          if ((NotifyPCActiveActivity.a == null) && ((BaseActivity.sTopActivity instanceof SplashActivity))) {
            startActivity((Intent)localObject1);
          }
          if (QLog.isColorLevel()) {
            QLog.i("PCActive_SplashActivity", 2, "Unknown Exception Occured");
          }
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PCActive_SplashActivity", 2, "Activity Not Found");
          }
          if (QLog.isColorLevel()) {
            QLog.i("PCActive_SplashActivity", 2, "Unknown Exception Occured");
          }
        }
        finally
        {
          if (QLog.isColorLevel()) {
            QLog.i("PCActive_SplashActivity", 2, "Unknown Exception Occured");
          }
        }
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.v != null) && (this.v.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.w)))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.v);
      localJumpAction.b(this.w);
      localJumpAction.b();
      this.v = null;
      this.w = null;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (DrawerFrame.f > 0) {
      Conversation.i();
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    SharedPreUtils.a(getApplication(), "");
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.e();
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.m)) && (this.m.equals(this.app.getAccount()))) {}
    }
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
      localNotificationManager.cancel(120);
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(122);
      localNotificationManager.cancel(123);
      localNotificationManager.cancel(129);
      label126:
      this.m = this.app.getAccount();
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.i();
      RecentDataListManager.a().b = null;
      ThreadManager.b().postDelayed(new fby(this), 10000L);
      a(this.app.a());
      return;
    }
    catch (Exception localException)
    {
      break label126;
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    Object localObject = new TextView(this);
    ((TextView)localObject).setTextColor(-16777216);
    ((TextView)localObject).setTextSize(getResources().getInteger(2131623938));
    ((TextView)localObject).setText(2131366667);
    localLinearLayout.addView((View)localObject);
    localObject = new CheckBox(this);
    ((CheckBox)localObject).setTextColor(-16777216);
    ((CheckBox)localObject).setText(2131366668);
    ((CheckBox)localObject).setChecked(true);
    localLinearLayout.addView((View)localObject);
    return DialogUtil.a(this, 230).setTitle(getString(2131366669)).addView(localLinearLayout).setPositiveButton(2131366670, new fbu(this, (CheckBox)localObject)).setNegativeButton(2131366671, new fbt(this, (CheckBox)localObject));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "MainActivity:onLogout");
    }
    SharedPreUtils.a(getApplication(), "");
    if (TroopAssistantManager.a().d()) {
      TroopAssistantManager.a().a(false);
    }
    TroopAssistantManager.a().d(this.app);
    LoadingStateManager.a().a(1);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131297128)
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
      paramMenuItem = "";
      if (this.app.e()) {
        paramMenuItem = this.app.a();
      }
      localSharedPreferences.getBoolean("notToastPushMsg" + paramMenuItem, true);
      localSharedPreferences.getBoolean("login_auto" + paramMenuItem, false);
      if (!isFinishing()) {}
    }
    else
    {
      return false;
    }
    showDialog(0);
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onTabChanged(String paramString)
  {
    super.onTabChanged(paramString);
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    int i1;
    if (paramString.equals(Conversation.class.getName()))
    {
      ReportController.b(this.app, "CliOper", "", "", "Msg_tab", "Msg_tab", 0, 0, "", "", "", "");
      paramString = "消息";
      i1 = 1;
    }
    for (;;)
    {
      Object localObject = (QZoneManagerImp)this.app.getManager(9);
      boolean bool;
      label83:
      DragTextView localDragTextView;
      if (localObject != null)
      {
        if (i1 == 4)
        {
          bool = true;
          ((QZoneManagerImp)localObject).a(bool);
        }
      }
      else
      {
        localDragTextView = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get("消息_num");
        if (i1 != 1) {
          break label226;
        }
      }
      label226:
      for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;; localObject = null)
      {
        localDragTextView.setOnModeChangeListener((IDragView.OnChangeModeListener)localObject);
        paramString = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        new Handler().postDelayed(new fcb(this, i1), 100L);
        return;
        if (paramString.equals(Contacts.class.getName()))
        {
          paramString = "联系人";
          i1 = 3;
          break;
        }
        if (paramString.equals(QzoneWrapperActivity.class.getName()))
        {
          paramString = "动态";
          i1 = 4;
          break;
        }
        if (!paramString.equals(Call.class.getName())) {
          break label232;
        }
        paramString = "电话";
        i1 = 2;
        break;
        bool = false;
        break label83;
      }
      label232:
      paramString = null;
      i1 = 1;
    }
  }
  
  public void preloadUi()
  {
    try
    {
      SizeMeasure.b(this);
      this.jdField_c_of_type_AndroidViewView = getLayoutInflater().inflate(2130903369, null);
      a(this.jdField_c_of_type_AndroidViewView);
      LayoutInflater localLayoutInflater = LayoutInflater.from(BaseApplicationImpl.a);
      this.jdField_a_of_type_AndroidViewView = localLayoutInflater.inflate(2130903198, null);
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297304);
      if (localFPSSwipListView != null) {
        this.jdField_b_of_type_AndroidViewView = localLayoutInflater.inflate(2130904390, localFPSSwipListView, false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SplashActivity", 2, "", localThrowable);
    }
  }
  
  protected String setLastActivityName()
  {
    if (Conversation.c()) {
      return getString(2131365114);
    }
    return super.setLastActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity
 * JD-Core Version:    0.7.0.1
 */