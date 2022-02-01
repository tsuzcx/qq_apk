package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBasePluginActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.fling.FlingAllowProvider;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.customviews.CircleMenu;
import com.tencent.mobileqq.customviews.CircleMenuManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserEmptyActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileViewerParamParser;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.NotRemoveFrameLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import cooperation.qlink.QlinkBridgeActivity;
import cooperation.qlink.QlinkShareJumpActivity;
import cooperation.qqfav.widget.QfavJumpActivity;
import cooperation.qwallet.plugin.QWalletPluginProxyActivity;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import hgj;
import hgk;
import hgl;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BasePadActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.MyFragment;

public class BaseActivity
  extends AppActivity
  implements SkinnableActivityProcesser.Callback
{
  public static final int EXIT_TIME = 2000;
  public static final String FROM_DEFAULT_FIRST_PAGE = "open_by_default_first_page";
  public static final String KEY_SHADOW_ANIM = "shadow_anim";
  public static final String KEY_SHADOW_VISIBLE = "shadow_visible";
  public static final String KEY_SHOW_SHADOW = "show_shadow_on_page";
  static final int MSG_REFRESH = 0;
  protected static final String TAG = "qqBaseActivity";
  protected static final int TILTE_TYPE_TRANSPARENT = 3;
  protected static final int[] TITLE_BG_IDS = { 2130841805, 2130841808, 2130841806, -1 };
  protected static final int TITLE_TYPE_AIO = 2;
  protected static final int TITLE_TYPE_MODAL = 1;
  protected static final int TITLE_TYPE_NORMAL = 0;
  public static boolean isUnLockSuccess;
  public static boolean mAppForground = true;
  public static boolean mShowGesture;
  public static boolean sNotShowLockScreen;
  public static BaseActivity sTopActivity;
  private static ShakeListener shakeListener;
  private static boolean snapChecked;
  public QQAppInterface app;
  long backClickTime;
  private String className = getClass().getSimpleName();
  boolean endShow;
  public String fromActivity;
  public boolean fromDefaultFirstAct;
  public boolean mCanLock = true;
  private FlingHandler mFlingHandler;
  private BroadcastReceiver mScreenReceiver;
  public int mStopFlag = 0;
  protected boolean notShowNewTask;
  SkinnableActivityProcesser processer;
  public ScreenShot screenShot;
  
  static
  {
    isUnLockSuccess = false;
    mShowGesture = false;
  }
  
  private void addHongbaoParams(Intent paramIntent)
  {
    if (getIntent().hasExtra("from_float_aio"))
    {
      paramIntent.putExtra("from_float_aio", getIntent().getBooleanExtra("from_float_aio", false));
      paramIntent.putExtra("from_float_nick", getIntent().getStringExtra("from_float_nick"));
    }
    if (getIntent().hasExtra("open_hb_detail")) {
      paramIntent.putExtra("open_hb_detail", getIntent().getBooleanExtra("open_hb_detail", false));
    }
  }
  
  private void addLineInRight(View paramView)
  {
    if ((paramView.findViewById(16908316) == null) && ((paramView instanceof FrameLayout)))
    {
      View localView = new View(this);
      int i = getResources().getDimensionPixelSize(2131493219);
      localView.setBackgroundResource(2130841653);
      localView.setId(16908316);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 3;
      ((ViewGroup)paramView).addView(localView, localLayoutParams);
      localView.setVisibility(8);
    }
  }
  
  private void addShadowInLeft(View paramView)
  {
    View localView;
    int i;
    Object localObject;
    if (paramView.findViewById(2131297224) == null)
    {
      localView = new View(this);
      i = getResources().getDimensionPixelSize(2131492913);
      localView.setBackgroundResource(2130841591);
      localView.setId(2131297224);
      if (!(paramView instanceof FrameLayout)) {
        break label81;
      }
      localObject = new FrameLayout.LayoutParams(i, -1);
      ((FrameLayout.LayoutParams)localObject).gravity = 5;
      ((ViewGroup)paramView).addView(localView, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      localView.setVisibility(8);
      return;
      label81:
      if ((paramView instanceof RelativeLayout))
      {
        localObject = new RelativeLayout.LayoutParams(i, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((ViewGroup)paramView).addView(localView, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void addShadowInRight(View paramView)
  {
    if ((paramView.findViewById(2131297227) == null) && ((paramView instanceof FrameLayout)))
    {
      View localView = new View(this);
      int i = getResources().getDimensionPixelSize(2131492913);
      localView.setBackgroundResource(2130838495);
      localView.setId(2131297227);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 3;
      ((ViewGroup)paramView).addView(localView, localLayoutParams);
    }
  }
  
  private void checkAndOpenRightDefault()
  {
    Object localObject = getClass().getName();
    if ((getResources().getConfiguration().orientation == 2) && (isDefaultRightPage((String)localObject)))
    {
      localObject = (ViewGroup)findViewById(getContaierViewId());
      if ((localObject != null) && (getFragmentCount((ViewGroup)localObject) == 0) && (isResume())) {
        openDefualtRightPage();
      }
    }
  }
  
  private void checkChatActivityOpen(Intent paramIntent)
  {
    Object localObject;
    int i;
    if (getParent() != null)
    {
      localObject = paramIntent.getComponent();
      if (localObject != null) {
        break label89;
      }
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).endsWith("ChatActivity")) || (((String)localObject).endsWith("LiteActivity"))))
      {
        if (!((String)localObject).endsWith("ChatActivity")) {
          break label97;
        }
        localObject = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("uintype", -1);
        paramIntent = (Intent)localObject;
      }
    }
    for (;;)
    {
      if ((i >= 0) && (paramIntent != null)) {
        readyStartAIO(i, paramIntent);
      }
      return;
      label89:
      localObject = ((ComponentName)localObject).getClassName();
      break;
      label97:
      paramIntent = AppConstants.Y;
      i = 0;
    }
  }
  
  private void cleanScreenShot()
  {
    if (this.screenShot != null)
    {
      this.screenShot.a();
      this.screenShot = null;
    }
  }
  
  private void displayLikeDialog(Intent paramIntent)
  {
    Object localObject;
    if (!paramIntent.getExtras().containsKey("display_like_dialog"))
    {
      localObject = paramIntent.getComponent();
      if (localObject != null) {
        break label107;
      }
      localObject = null;
      if ((localObject != null) && ((((String)localObject).endsWith("SelectMemberActivity")) || (((String)localObject).endsWith("ForwardRecentActivity")) || (((String)localObject).endsWith("ForwardFriendListActivity"))))
      {
        paramIntent.putExtra("display_like_dialog", true);
        if (getParent() == null) {
          if ((getWindow().getAttributes().flags & 0x400) == 0) {
            break label115;
          }
        }
      }
    }
    label107:
    label115:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramIntent.putExtra("dialog_full_screen", true);
      }
      return;
      localObject = ((ComponentName)localObject).getClassName();
      break;
    }
  }
  
  private void doAnimStart(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = false; TextUtils.isEmpty(this.fromActivity); paramBoolean = true)
    {
      setShadowInLeftVisible(false, paramBoolean);
      return;
    }
    if (isTabActivity(this.fromActivity))
    {
      if (isDefaultRightPage(this.fromActivity))
      {
        setShadowInLeftVisible(false, false);
        return;
      }
      this.endShow = true;
      return;
    }
    setShadowInLeftVisible(true, paramBoolean);
  }
  
  private boolean finishActivity()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (isDefaultRightPage(this.fromActivity))
    {
      bool1 = bool2;
      if (getParent() == null)
      {
        bool1 = bool2;
        if (isNewTaskActivity())
        {
          bool1 = bool2;
          if (getResources().getConfiguration().orientation == 2) {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean hasNoTitleBarActivity()
  {
    String str = getClass().getName();
    return (isTabActivity(str)) && (str.endsWith("SplashActivity"));
  }
  
  private boolean isClearFragmentStack(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = paramIntent.getBooleanExtra("open_from_base_fragment", false);
    String str;
    if (!this.bActivityToFragment) {
      if (paramIntent.getComponent() == null)
      {
        str = null;
        if ((str != null) && (getParent() != null) && (str.endsWith("QQBrowserDelegationActivity")))
        {
          if (getRealFragmentCount() > 0) {
            bool1 = true;
          }
          paramIntent.putExtra("saved_clear_statck", bool1);
        }
        bool1 = true;
      }
    }
    label106:
    do
    {
      do
      {
        return bool1;
        str = paramIntent.getComponent().getClassName();
        break;
        if (isTabActivity(this.fromActivity)) {
          break label106;
        }
        bool1 = bool2;
      } while (!bool3);
      bool1 = bool2;
    } while (hasContentView());
    if ((bool3) && (!SizeMeasure.a(this))) {}
    for (bool1 = true;; bool1 = paramIntent.getBooleanExtra("saved_clear_statck", false))
    {
      paramIntent.putExtra("notify_activity_finish", true);
      return bool1;
    }
  }
  
  private boolean isFileBrowserFullScreen(Intent paramIntent, String paramString)
  {
    if (!isModeleWindow()) {
      if (!paramString.endsWith("FileBrowserActivity")) {
        break label299;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        FileViewerParamParser localFileViewerParamParser = new FileViewerParamParser(this.app);
        localFileViewerParamParser.a(true);
        paramString = paramIntent.getStringExtra("c2c_discussion_recentfile");
        if ((paramString != null) && (paramString.trim().length() != 0)) {
          localFileViewerParamParser.a(paramString);
        }
        if (!localFileViewerParamParser.a(paramIntent)) {
          return false;
        }
        switch (localFileViewerParamParser.a())
        {
        case 2: 
          if (paramString != null)
          {
            paramString = (IFileViewerAdapter)paramString.get(i);
            if (paramString != null)
            {
              i = paramString.b();
              Log.i("app2", "fileType=" + i);
              if (i == 2)
              {
                paramIntent.putExtra("my_file_fullscreen", true);
                paramIntent.setClass(this, FileBrowserEmptyActivity.class);
                return true;
                paramString = localFileViewerParamParser.a();
                i = localFileViewerParamParser.b();
              }
            }
          }
          break;
        case 1: 
          paramIntent.putExtra("my_file_fullscreen", true);
          return true;
        case 3: 
          paramString = new ArrayList(1);
          paramString.add(localFileViewerParamParser.a());
          i = 0;
          continue;
          if ((paramString.f()) || (paramString.e()) || (paramString.d()))
          {
            paramIntent.setClass(this, FileBrowserActivity.class);
            paramIntent.putExtra("my_file_fullscreen", true);
            return true;
          }
          break;
        }
      }
      catch (Exception paramIntent)
      {
        Log.e("app2", "check file browser error", paramIntent);
      }
      label297:
      label299:
      do
      {
        return false;
      } while (!paramString.endsWith("TroopFileDetailBrowserActivity"));
      try
      {
        paramString = new TroopFileViewerParamParser(this.app);
        if (!paramString.a(paramIntent, this)) {
          return false;
        }
        switch (paramString.a())
        {
        }
        for (;;)
        {
          if (!QLog.isDevelopLevel()) {
            break label526;
          }
          throw new NullPointerException("未知的mFileViewerType");
          for (paramString = paramString.a(); paramString != null; paramString = paramString.a())
          {
            paramString = (IFileViewerAdapter)paramString.get(0);
            if (paramString == null) {
              break;
            }
            i = paramString.b();
            Log.i("app2", "fileType=" + i);
            if (i != 2) {
              break label474;
            }
            paramIntent.putExtra("my_file_fullscreen", true);
            return true;
            paramIntent.putExtra("my_file_fullscreen", true);
            return true;
          }
          label474:
          if ((!paramString.f()) && (!paramString.e()) && (!paramString.d())) {
            break label297;
          }
          paramIntent.putExtra("my_file_fullscreen", true);
          return true;
          paramString = null;
          i = 0;
          break;
        }
      }
      catch (Exception paramIntent) {}
    }
    label526:
    return false;
  }
  
  private boolean isLeftBtnClose()
  {
    boolean bool = false;
    Object localObject = getIntent();
    if ((localObject == null) || (((Intent)localObject).getBooleanExtra("my_file_fullscreen", false))) {
      return true;
    }
    localObject = ((Intent)localObject).getStringExtra("from_activity");
    this.fromActivity = ((String)localObject);
    if (((isModeleWindow()) && (isSpecialFromActivity((String)localObject))) || (isTabActivity((String)localObject))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  private boolean isSpecialFromActivity(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("ChatActivity")) && (!paramString.endsWith("SpecailCareListActivity")) && (!paramString.endsWith("ChatSettingActivity")) && (!paramString.endsWith("ChatSettingForTroop")) && (!paramString.endsWith("TroopMemberListActivity")) && (!paramString.endsWith("ProfileCardMoreActivity")) && (!paramString.endsWith("FileBrowserActivity")) && (!paramString.endsWith("QfavPluginProxyActivity$DetailProxy")) && (!paramString.endsWith("QzoneEnterPluginProxyActivity")) && (!paramString.endsWith("SendHbActivity")) && (!paramString.endsWith("QQBrowserActivity"))) {
      return false;
    }
    return true;
  }
  
  private boolean isStartQQ3rdApp(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while (((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT"))) || ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.PICK"))));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  private boolean noAnim(Intent paramIntent)
  {
    Object localObject = paramIntent.getComponent();
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || ((!((String)localObject).endsWith("QQBrowserDelegationActivity")) && (!((String)localObject).endsWith("PayBridgeActivity")) && (!((String)localObject).endsWith("TroopAvatarWallPreviewActivity")) && (!((String)localObject).endsWith("SearchContactsActivity")) && (!((String)localObject).endsWith("AddFriendLogicActivity")) && (!((String)localObject).endsWith("VipProfileCardPhotoHandlerActivity")) && (!((String)localObject).endsWith("PhotoListActivity")) && (!((String)localObject).endsWith("PhotoCropActivity")) && (!((String)localObject).endsWith("UniformDownloadActivity")) && (!((String)localObject).endsWith("lebasearch.SearchActivity")) && (!((String)localObject).endsWith("TroopBarReplyActivity")) && (!((String)localObject).endsWith("FriendProfileImageActivity")) && (!((String)localObject).endsWith("AutoRemarkActivity")) && (!((String)localObject).endsWith("AudioRecordActivity")) && (!((String)localObject).endsWith("QzonePicturePluginProxyActivity")) && (!((String)localObject).endsWith("QzonePictureExtPluginProxyActivity")))) {
        break label185;
      }
    }
    label185:
    do
    {
      String str;
      do
      {
        return true;
        localObject = ((ComponentName)localObject).getClassName();
        break;
        str = paramIntent.getStringExtra("pluginsdk_launchActivity");
      } while ((!TextUtils.isEmpty(str)) && ((str.endsWith("FavoriteIpcDelegate")) || (str.endsWith("QZoneFriendFeedActivity")) || (str.endsWith("QvipPayBridgeActivity"))));
      if ((localObject != null) && (((String)localObject).endsWith("LiteActivity"))) {
        return false;
      }
      paramIntent = paramIntent.getAction();
    } while ((paramIntent != null) && (paramIntent.length() > 0));
    return false;
  }
  
  private boolean noAnimOnce(Intent paramIntent)
  {
    if ((getParent() != null) && (getClass().getSimpleName().endsWith("Leba")) && (getResources().getConfiguration().orientation == 2)) {}
    for (;;)
    {
      return true;
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null) {}
      for (paramIntent = null; (paramIntent == null) || (!paramIntent.endsWith("AddFriendVerifyActivity")); paramIntent = paramIntent.getClassName()) {
        return false;
      }
    }
  }
  
  private final boolean parseIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    Object localObject;
    do
    {
      return false;
      localObject = paramIntent.getComponent();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((ComponentName)localObject).getClassName())
      {
        if (localObject == null) {
          break label212;
        }
        if ((!((String)localObject).endsWith("ChatActivity")) && (!((String)localObject).endsWith("LiteActivity")) && (!((String)localObject).endsWith("SubLoginActivity"))) {
          break;
        }
        return true;
      }
    } while ((((String)localObject).endsWith("SplashActivity")) || (((String)localObject).endsWith("LoginActivity")) || (((String)localObject).endsWith("Conversation")) || (((String)localObject).endsWith("Call")) || (((String)localObject).endsWith("Contacts")) || (((String)localObject).endsWith("Leba")) || (((String)localObject).endsWith("UpgradeActivity")) || (((String)localObject).endsWith("UserguideActivity")) || (((String)localObject).endsWith("InstallActivity")) || (((String)localObject).endsWith("RegisterGuideActivity")) || (((String)localObject).endsWith("QlinkBridgeActivity")) || (((String)localObject).endsWith("AVActivity")) || (isFileBrowserFullScreen(paramIntent, (String)localObject)));
    label212:
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        boolean bool = QzonePluginProxyActivity.class.isAssignableFrom(Class.forName((String)localObject));
        if (bool)
        {
          i = 1;
          paramIntent = paramIntent.getAction();
          if ((paramIntent != null) && (paramIntent.length() > 0) && (i == 0)) {
            break;
          }
          return true;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
      int i = 0;
    }
  }
  
  private boolean redirectToPhotoWall(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("url");
    if ((!TextUtils.isEmpty(paramIntent)) && (getAppRuntime() != null) && (paramIntent.indexOf("ti.qq.com/photowall") > 0))
    {
      QZoneHelper.a(getAppRuntime(), this);
      return true;
    }
    return false;
  }
  
  private void showOrHideLeftBackBtn()
  {
    View localView = findViewById(2131297357);
    if ((localView != null) && (isDefaultRightPage(this.fromActivity)) && (!isModeleWindow()))
    {
      if (getResources().getConfiguration().orientation == 2) {
        localView.setVisibility(8);
      }
    }
    else {
      return;
    }
    localView.setVisibility(0);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.a(paramBusinessObserver);
    }
  }
  
  public void addTopLayout()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      NotRemoveFrameLayout localNotRemoveFrameLayout = new NotRemoveFrameLayout(this);
      View localView = localViewGroup.getChildAt(0);
      localViewGroup.addView(localNotRemoveFrameLayout);
      localViewGroup.removeView(localView);
      localNotRemoveFrameLayout.addView(localView);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void addTouchFeedback()
  {
    Object localObject1 = null;
    if ((this.app == null) || (this.app.a() == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (Settings.System.getInt(this.app.a().getContentResolver(), "haptic_feedback_enabled", 1) != 1);
        try
        {
          localObject2 = Class.forName("com.android.internal.R$array").getField("config_longPressVibePattern").get(null);
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2;
            int i;
          }
        }
      } while ((localObject1 == null) || (!(localObject1 instanceof Integer)));
      localObject1 = this.app.a().getResources().getIntArray(((Integer)localObject1).intValue());
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break;
      }
      localObject1 = this.app.a().getResources().getIntArray(2131230741);
    } while ((localObject1 == null) || (localObject1.length <= 0));
    localObject2 = new long[localObject1.length];
    i = 0;
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i];
      i += 1;
    }
    ((Vibrator)this.app.a().getSystemService("vibrator")).vibrate((long[])localObject2, -1);
  }
  
  protected void allowContainerNotRemove(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof NotRemoveFrameLayout)) {
      ((NotRemoveFrameLayout)paramView).a = paramBoolean;
    }
  }
  
  public boolean canDrag()
  {
    return (isWrapContent()) || (getResources().getConfiguration().orientation == 1);
  }
  
  public void checkUnlockForSpecial()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=" + BaseApplicationImpl.a().getVisibleActivityCount() + ",stopflag" + this.mStopFlag);
    }
  }
  
  @SuppressLint({"SdCardPath"})
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1)
    {
      if ((paramKeyEvent.getKeyCode() != 24) || (!new File("/mnt/sdcard/skin/res/").isDirectory())) {
        break label71;
      }
      if (SkinEngine.getInstances().getSkinRootPath() == null) {
        break label57;
      }
      SkinEngine.getInstances().setSkinRootPath(this, null);
    }
    for (;;)
    {
      return super.doDispatchKeyEvent(paramKeyEvent);
      label57:
      SkinEngine.getInstances().setSkinRootPath(this, "/mnt/sdcard/skin/res/");
      continue;
      label71:
      if ((paramKeyEvent.getKeyCode() == 25) && (new File("/mnt/sdcard/skin2/res/").isDirectory())) {
        if (SkinEngine.getInstances().getSkinRootPath() != null) {
          SkinEngine.getInstances().setSkinRootPath(this, null);
        } else {
          SkinEngine.getInstances().setSkinRootPath(this, "/mnt/sdcard/skin2/res/", false);
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (!onBackEvent()) {}
    try
    {
      super.doOnBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "", localThrowable);
      }
      finish();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
    SizeMeasure.b(this);
    checkAndOpenRightDefault();
    showOrHideLeftBackBtn();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    StatisticCollector.a(this).a(this);
    SizeMeasure.b(this);
    this.processer = new SkinnableActivityProcesser(this, this);
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    if ((getAppRuntime() instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app != null) {}
    try
    {
      setVolumeControlStream(3);
      if (!snapChecked)
      {
        if (SettingCloneUtil.readValue(this, null, getString(2131366269), "qqsetting_screenshot_key", false)) {
          turnOnShake();
        }
        snapChecked = true;
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      this.mScreenReceiver = new hgl(this, null);
    }
    catch (Exception paramBundle)
    {
      try
      {
        registerReceiver(this.mScreenReceiver, paramBundle);
        label215:
        if (!this.bActivityToFragment) {
          addTopLayout();
        }
        if ((this.app != null) && (this.app.cl == -1))
        {
          StartupTracker.a(null, "Main_ui_create_base_init_calltab");
          this.app.H();
          StartupTracker.a("Main_ui_create_base_init_calltab", null);
        }
        this.fromActivity = getIntent().getStringExtra("from_activity");
        this.fromDefaultFirstAct = getIntent().getBooleanExtra("open_by_default_first_page", false);
        getIntent().removeExtra("open_by_default_first_page");
        boolean bool = getIntent().getBooleanExtra("dialog_full_screen", false);
        getIntent().removeExtra("dialog_full_screen");
        if (bool) {
          getWindow().addFlags(1024);
        }
        return false;
        paramBundle = paramBundle;
      }
      catch (Exception paramBundle)
      {
        break label215;
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    StatisticCollector.a(this).d(this);
    if (this.processer != null) {
      this.processer.destory();
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    if (this.app != null) {
      this.app.a(getClass());
    }
    if (this.mScreenReceiver != null) {}
    try
    {
      unregisterReceiver(this.mScreenReceiver);
      label132:
      if ((MemoryConfigs.a().a > 0.0F) && (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)) {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.releaseLargeCache();
      }
      if (sTopActivity == this) {
        sTopActivity = null;
      }
      return;
    }
    catch (Exception localException)
    {
      break label132;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    StatisticCollector.a(this).c(this);
    if (this.app != null)
    {
      ((SaveTrafficHandler)this.app.a(18)).a(true);
      this.app.a(-1L);
    }
    cleanScreenShot();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onPause");
    }
    if (getParent() != null) {
      hideSoftPanel();
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.bActivityToFragment) {
      sTopActivity = this;
    }
    StatisticCollector.a(this).b(this);
    SizeMeasure.b(this);
    if (this.app != null)
    {
      ((SaveTrafficHandler)this.app.a(18)).a(false);
      StatisticCollector.a(this).a(this.app);
    }
    int i;
    label84:
    SharedPreferences.Editor localEditor;
    if ((this instanceof NotificationActivity))
    {
      EquipmentLockImpl.a().b();
      if (Build.VERSION.SDK_INT <= 10) {
        break label471;
      }
      i = 4;
      localEditor = getSharedPreferences("screen_shot", i).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label476;
      }
      localEditor.apply();
      label129:
      if (this.app != null) {
        this.app.C();
      }
      mAppForground = GesturePWDUtils.getAppForground(getActivity());
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onResume.mAppForground = " + mAppForground + ",mCanLock=" + this.mCanLock);
      }
      if (((mAppForground) && ((!"com.tencent.minihd.qq".equals(BaseApplicationImpl.processName)) || (isUnLockSuccess))) || (!this.mCanLock) || (this.app == null) || (!GesturePWDUtils.getJumpLock(getActivity(), this.app.a())) || ((getActivity() instanceof GesturePWDUnlockActivity)) || ((getActivity() instanceof InstallActivity)) || ((getActivity() instanceof UserguideActivity)) || ((getActivity() instanceof JumpActivity)) || ((getActivity() instanceof qfileJumpActivity)) || ((getActivity() instanceof QfavJumpActivity)) || ((getActivity() instanceof LoginActivity)) || ((getActivity() instanceof QlinkBridgeActivity)) || ((getActivity() instanceof QlinkShareJumpActivity))) {
        break label493;
      }
      if (!"com.tencent.minihd.qq".equals(BaseApplicationImpl.processName)) {
        break label486;
      }
      if ((this instanceof SplashActivity)) {
        startUnlockActivity();
      }
    }
    for (;;)
    {
      if (((mAppForground) || (this.app == null)) || ((!mAppForground) && (!(this instanceof JumpActivity))))
      {
        mAppForground = true;
        GesturePWDUtils.setAppForground(getActivity(), mAppForground);
      }
      this.mStopFlag = 0;
      this.mCanLock = true;
      if (GuardManager.a != null) {
        GuardManager.a.b(1, getPreProcess());
      }
      return;
      EquipmentLockImpl.a().a();
      break;
      label471:
      i = 0;
      break label84;
      label476:
      localEditor.commit();
      break label129;
      label486:
      startUnlockActivity();
      continue;
      label493:
      if ((!mAppForground) && (this.mCanLock)) {
        checkUnlockForSpecial();
      } else if ((!mAppForground) && (!this.mCanLock)) {
        isUnLockSuccess = true;
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    cleanScreenShot();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStart " + BaseApplicationImpl.a().getVisibleActivityCount());
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStop " + BaseApplicationImpl.a().getVisibleActivityCount());
    }
    cleanScreenShot();
    this.mStopFlag = 1;
    mAppForground = GesturePWDUtils.isAppOnForeground(getActivity());
    if (!mAppForground)
    {
      GesturePWDUtils.setAppForground(getActivity(), mAppForground);
      isUnLockSuccess = false;
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStop();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((this.app != null) && (paramBoolean)) {
      this.app.j();
    }
  }
  
  public void endScroll()
  {
    if ((!isDefaultRightPage(this.fromActivity)) && (isTabActivity(this.fromActivity)))
    {
      setShadowInLeftVisible(true, false);
      setRightLineVisible(false);
    }
  }
  
  public boolean exitByTip()
  {
    long l = SystemClock.uptimeMillis();
    if ((this.backClickTime > 0L) && (l - this.backClickTime <= 2000L) && (l - this.backClickTime > 0L))
    {
      this.backClickTime = 0L;
      return true;
    }
    QQToast.a(this, "再次轻击返回键退出QQ", 700).a();
    this.backClickTime = l;
    return false;
  }
  
  public void finish()
  {
    if (this.fromDefaultFirstAct)
    {
      this.fromDefaultFirstAct = false;
      setShadowInLeftVisible(false, false);
    }
    try
    {
      super.finish();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void forward(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), str);
    startActivity(paramIntent);
  }
  
  @Deprecated
  public Activity getActivity()
  {
    return super.getActivity();
  }
  
  public int getLefPanelWidth()
  {
    return SizeMeasure.b(this);
  }
  
  public int getModalWindowFinishAnim()
  {
    return 2130968584;
  }
  
  public int getModalWindowOpenAnim()
  {
    return 2131559055;
  }
  
  public String getPreProcess()
  {
    return null;
  }
  
  protected int getRightPanelWidth()
  {
    return SizeMeasure.e(this);
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public int getTabIndex()
  {
    int i = Utils.b(getActivity());
    if (i >= 0) {
      return i;
    }
    return super.getTabIndex();
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131492923);
  }
  
  public TransFileController getTransFileControlller()
  {
    if (this.app == null) {
      return null;
    }
    return this.app.a();
  }
  
  protected boolean isDefaultRightPage(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.endsWith("Leba"))
      {
        bool1 = bool2;
        if (!paramString.endsWith("SettingMe")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isSpecialActivity()
  {
    String str = getClass().getName();
    return (str.endsWith("SendHbActivity")) || (str.endsWith("ScannerActivity"));
  }
  
  protected boolean isTabActivity(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if ((!paramString.endsWith("Conversation")) && (!paramString.endsWith("Call")) && (!paramString.endsWith("Contacts")) && (!paramString.endsWith("QzoneWrapperActivity")) && (!paramString.endsWith("Leba")))
      {
        bool1 = bool2;
        if (!paramString.endsWith("SettingMe")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  protected void notAnim(boolean paramBoolean)
  {
    if ((paramBoolean) && (hasContentView())) {
      doAnimStart(true);
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    StringBuilder localStringBuilder;
    if (this.app != null) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onAccountChanged ");
        if (this.app != null) {
          break label99;
        }
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("qqBaseActivity", 2, bool);
      this.app.a(0L);
      this.app = ((QQAppInterface)getAppRuntime());
      if ((this.app != null) && (this.app.cl == -1)) {
        this.app.H();
      }
      return;
    }
  }
  
  protected void onAnimEnd(boolean paramBoolean)
  {
    super.onAnimEnd(paramBoolean);
    if ((paramBoolean) && (this.endShow))
    {
      this.endShow = false;
      setShadowInLeftVisible(true, false);
    }
  }
  
  protected void onAnimStart(boolean paramBoolean)
  {
    super.onAnimStart(paramBoolean);
    if (paramBoolean) {
      doAnimStart(false);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!hasNoTitleBarActivity())
    {
      setTitleBackground(-1);
      setLefBtnBackground();
      setTitleBarTextColor();
      if ((isDefaultRightPage(this.fromActivity)) && (!isModeleWindow())) {
        addShadowInRight(getWindow().getDecorView());
      }
      if ((!isDefaultRightPage(this.fromActivity)) && (isTabActivity(this.fromActivity))) {
        addLineInRight(getWindow().getDecorView());
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (getParent() != null)
    {
      CircleMenu localCircleMenu = CircleMenuManager.a();
      if (localCircleMenu != null) {
        localCircleMenu.d();
      }
    }
    do
    {
      return true;
      if (finishActivity()) {
        break;
      }
      if (((this instanceof QQBrowserActivity)) && (isNewTaskFullScreen()))
      {
        ((QQBrowserActivity)this).i();
        return true;
      }
    } while (!exitByTip());
    Utils.a(this);
    return true;
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82)
    {
      Activity localActivity = getParent();
      if (((localActivity instanceof SplashActivity)) && (((SplashActivity)localActivity).a())) {
        return true;
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onRestart()
  {
    super.onRestart();
    showOrHideLeftBackBtn();
  }
  
  public void openAIO(Intent paramIntent)
  {
    paramIntent.setClass(this, ChatActivity.class);
    paramIntent.putExtra("fouce_close", true);
    startActivity(paramIntent);
  }
  
  public void openAIOTop(Intent paramIntent)
  {
    MyFragment localMyFragment = (MyFragment)getTopFragment();
    paramIntent.setClass(this, ChatActivity.class);
    if (localMyFragment == null)
    {
      startActivity(paramIntent);
      return;
    }
    localMyFragment.getBasePadAct().startActivity(paramIntent);
  }
  
  public void openDefualtRightPage() {}
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.isLogin()))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      return RecentDataListManager.a().a(paramAppRuntime, BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramBoolean);
    }
    return false;
  }
  
  public void reLayoutClipParams(View paramView1, View paramView2)
  {
    Object localObject = getParent();
    int i;
    int j;
    label63:
    ViewGroup.LayoutParams localLayoutParams;
    if ((localObject instanceof QQTabActivity))
    {
      if (getResources().getConfiguration().orientation != 2) {
        break label161;
      }
      i = 1;
      localObject = ((QQTabActivity)localObject).a().getTabContentView();
      j = SizeMeasure.a(this);
      if (i == 0) {
        break label166;
      }
      ((FrameLayout)localObject).setPadding(j, 0, 0, 0);
      int k = getLefPanelWidth();
      localObject = paramView1.getLayoutParams();
      localLayoutParams = paramView2.getLayoutParams();
      if (i == 0) {
        break label178;
      }
      ((ViewGroup.LayoutParams)localObject).width = k;
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = k;
      paramView2.setVisibility(0);
      label116:
      localObject = paramView2.findViewById(2131301979);
      if (localObject != null)
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        if (i == 0) {
          break label230;
        }
      }
    }
    label161:
    label166:
    label178:
    label230:
    for (((FrameLayout.LayoutParams)localObject).leftMargin = 0;; ((FrameLayout.LayoutParams)localObject).leftMargin = j)
    {
      addShadowInRight(paramView2);
      addShadowInLeft(paramView1);
      return;
      i = 0;
      break;
      ((FrameLayout)localObject).setPadding(0, 0, 0, 0);
      break label63;
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = 0;
      if ((getFragmentCount((ViewGroup)paramView2) != 0) || (alwaysShowRightView())) {
        break label116;
      }
      paramView2.setVisibility(8);
      break label116;
    }
  }
  
  protected void readyStartAIO(int paramInt, String paramString) {}
  
  public void receiveScreenOff() {}
  
  protected void redirectNewTaskActivity(Intent paramIntent)
  {
    Object localObject;
    int i;
    if (getActivity().getParent() != null)
    {
      localObject = paramIntent.getComponent();
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        if (!((String)localObject).equals(QQBrowserActivity.class.getName())) {
          break label108;
        }
        i = getTabIndex();
        localObject = (Class)QQTabActivity.a().get(i);
        if (localObject != null)
        {
          paramIntent.putExtra("new_task_show_right_belong_tab", i);
          paramIntent.addFlags(268435456);
          if (!((Class)localObject).getName().equals(QQBrowserActivity.class.getName())) {
            paramIntent.setComponent(new ComponentName(getActivity(), (Class)localObject));
          }
        }
      }
    }
    for (;;)
    {
      return;
      label108:
      if (((String)localObject).equals(QWalletPluginProxyActivity.class.getName()))
      {
        i = getTabIndex();
        localObject = (Class)QQTabActivity.d().get(i);
        if (localObject != null)
        {
          paramIntent.putExtra("new_task_show_right_belong_tab", i);
          paramIntent.addFlags(268435456);
          paramIntent.setComponent(new ComponentName(getActivity(), (Class)localObject));
        }
      }
      else if (((String)localObject).equals(TroopTagViewActivity.class.getName()))
      {
        i = getTabIndex();
        localObject = (Class)QQTabActivity.e().get(i);
        if (localObject != null)
        {
          paramIntent.putExtra("new_task_show_right_belong_tab", i);
          paramIntent.addFlags(268435456);
          paramIntent.setComponent(new ComponentName(getActivity(), (Class)localObject));
        }
      }
      else if (((String)localObject).equals(TroopLocationModifyActivity.class.getName()))
      {
        i = getTabIndex();
        localObject = (Class)QQTabActivity.f().get(i);
        if (localObject != null)
        {
          paramIntent.putExtra("new_task_show_right_belong_tab", i);
          paramIntent.addFlags(268435456);
          paramIntent.setComponent(new ComponentName(getActivity(), (Class)localObject));
        }
      }
      else if (((String)localObject).equals(MusicGeneQQBrowserActivity.class.getName()))
      {
        i = getTabIndex();
        localObject = (Class)QQTabActivity.g().get(i);
        if (localObject != null)
        {
          paramIntent.putExtra("new_task_show_right_belong_tab", i);
          paramIntent.addFlags(268435456);
          paramIntent.setComponent(new ComponentName(getActivity(), (Class)localObject));
        }
      }
      else
      {
        try
        {
          localObject = Class.forName((String)localObject);
          if ((QQBrowserActivity.class.isAssignableFrom((Class)localObject)) || (QQBasePluginActivity.class.isAssignableFrom((Class)localObject)))
          {
            paramIntent.putExtra("new_task_show_right_belong_tab", getTabIndex());
            paramIntent.addFlags(268435456);
            return;
          }
        }
        catch (Exception paramIntent) {}
      }
    }
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.c(paramBusinessObserver);
    }
  }
  
  public void rightPanelEmpty()
  {
    super.rightPanelEmpty();
    setShadowInLeftVisible(false, false);
  }
  
  public void setCanLock(boolean paramBoolean)
  {
    this.mCanLock = paramBoolean;
  }
  
  protected void setContentBackgroundResource(int paramInt)
  {
    if (findViewById(16908290) != null) {
      findViewById(16908290).setBackgroundResource(paramInt);
    }
  }
  
  public String setLastActivityName()
  {
    return getString(2131366374);
  }
  
  public void setLefBtnBackground()
  {
    View localView = findViewById(2131297357);
    if (localView != null)
    {
      if ((!isModeleWindow()) && (!isSpecialActivity())) {
        break label54;
      }
      if (!isLeftBtnClose()) {
        break label47;
      }
    }
    label47:
    for (int i = 2130838413;; i = 2130842088)
    {
      localView.setBackgroundResource(i);
      showOrHideLeftBackBtn();
      return;
    }
    label54:
    if (isLeftBtnClose()) {}
    for (i = 2130838414;; i = 2130842089)
    {
      localView.setBackgroundResource(i);
      break;
    }
  }
  
  public void setRightLineVisible(boolean paramBoolean)
  {
    View localView = findViewById(16908316);
    if (localView != null) {
      if (!paramBoolean) {
        break label23;
      }
    }
    label23:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setShadowInLeftVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getActivity().findViewById(2131297224);
    if (localObject != null) {
      if (paramBoolean1)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    while (getParent() != null) {
      for (;;)
      {
        return;
        int i = 4;
      }
    }
    localObject = new Intent("Common_BroadcastReceiver");
    ((Intent)localObject).putExtra("show_shadow_on_page", true);
    ((Intent)localObject).putExtra("shadow_anim", paramBoolean2);
    ((Intent)localObject).putExtra("shadow_visible", paramBoolean1);
    sendBroadcast((Intent)localObject);
  }
  
  public void setTitleBackground(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < TITLE_BG_IDS.length))
    {
      localObject = findViewById(2131297357);
      if (localObject != null)
      {
        localObject = (ViewGroup)((View)localObject).getParent();
        if (localObject != null)
        {
          i = getResources().getDimensionPixelSize(2131492916);
          if (paramInt != 3) {
            break label72;
          }
          ((ViewGroup)localObject).setBackground(new ColorDrawable());
          ((ViewGroup)localObject).setPadding(i, 0, i, 0);
        }
      }
    }
    label72:
    while ((paramInt >= 0) || (!isModeleWindow())) {
      for (;;)
      {
        Object localObject;
        int i;
        return;
        ((ViewGroup)localObject).setBackgroundResource(TITLE_BG_IDS[paramInt]);
      }
    }
    setTitleBackground(1);
  }
  
  protected void setTitleBarTextColor()
  {
    int k = 2131427929;
    Object localObject2;
    Object localObject1;
    int j;
    if ((isModeleWindow()) || (isSpecialActivity()))
    {
      i = 1;
      localObject2 = findViewById(2131297357);
      Object localObject3 = findViewById(2131297348);
      localObject1 = findViewById(2131297360);
      if ((localObject3 != null) && ((localObject3 instanceof TextView)))
      {
        localObject3 = (TextView)localObject3;
        if (i == 0) {
          break label173;
        }
        j = -1;
        label73:
        ((TextView)localObject3).setTextColor(j);
      }
      if ((localObject2 != null) && ((localObject2 instanceof TextView)))
      {
        localObject2 = (TextView)localObject2;
        localObject3 = getResources();
        if (i == 0) {
          break label180;
        }
        j = 2131427929;
        label113:
        ((TextView)localObject2).setTextColor(((Resources)localObject3).getColorStateList(j));
      }
      if ((localObject1 != null) && ((localObject1 instanceof TextView)))
      {
        localObject1 = (TextView)localObject1;
        localObject2 = getResources();
        if (i == 0) {
          break label187;
        }
      }
    }
    label173:
    label180:
    label187:
    for (int i = k;; i = 2131427927)
    {
      ((TextView)localObject1).setTextColor(((Resources)localObject2).getColorStateList(i));
      return;
      i = 0;
      break;
      j = -16777216;
      break label73;
      j = 2131427927;
      break label113;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (mShowGesture)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startActivity.mShowGesture == true. no startactivity.");
      }
      return;
    }
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent)) {
      this.mCanLock = false;
    }
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (mShowGesture)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startActivity.mShowGesture == true. no startactivity.");
      }
      return;
    }
    startActivityForResult(paramIntent, paramInt, 2);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent)) {
      this.mCanLock = false;
    }
    String str = paramIntent.getStringExtra("selfSet_leftViewText");
    if (TextUtils.isEmpty(str)) {
      paramIntent.putExtra("leftViewText", setLastActivityName());
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
      case 0: 
        try
        {
          super.startActivityForResult(paramIntent, paramInt1);
          return;
          paramIntent.putExtra("leftViewText", str);
          paramIntent.removeExtra("selfSet_leftViewText");
          continue;
          super.startActivityForResult(paramIntent, paramInt1);
          return;
        }
        catch (Exception paramIntent)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("qqBaseActivity", 2, "startActivity failed with: ", paramIntent);
          return;
        }
      }
    }
    if ((this.app != null) && (FlingAllowProvider.contain(this.app.a())))
    {
      paramInt2 = hashCode();
      str = ScreenCapture.getSnapPath(getActivity(), paramInt2);
      if (str != null)
      {
        ScreenCapture.captureViewToFile(str, getActivity().getWindow().getDecorView());
        paramIntent.putExtra("fling_action_key", 1);
        paramIntent.putExtra("fling_code_key", paramInt2);
      }
    }
    super.startActivityForResult(paramIntent, paramInt1);
    return;
    paramInt2 = hashCode();
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    if (redirectToPhotoWall(paramIntent)) {
      return;
    }
    paramIntent.putExtra("from_activity", getClass().getName());
    addHongbaoParams(paramIntent);
    if ((isDefaultRightPage(this.fromActivity)) || ((this.fromDefaultFirstAct) && (!hasContentView()))) {
      paramIntent.putExtra("open_by_default_first_page", true);
    }
    displayLikeDialog(paramIntent);
    int i;
    if (getActivity().getParent() != null)
    {
      i = 1;
      if (!paramIntent.getExtras().containsKey("is_activity_to_fragment"))
      {
        if ((!parseIntent(paramIntent)) || (i == 0)) {
          break label228;
        }
        bool1 = true;
        label112:
        paramIntent.putExtra("is_activity_to_fragment", bool1);
      }
      if (!paramIntent.getExtras().containsKey("clear_fragment_stack")) {
        if ((!isClearFragmentStack(paramIntent)) || (i == 0)) {
          break label234;
        }
      }
    }
    label228:
    label234:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramIntent.putExtra("clear_fragment_stack", bool1);
      if (!paramIntent.getExtras().containsKey("open_fragment_no_anim_once")) {
        paramIntent.putExtra("open_fragment_no_anim_once", noAnimOnce(paramIntent));
      }
      if (!paramIntent.getExtras().containsKey("fragment_no_anim")) {
        paramIntent.putExtra("fragment_no_anim", noAnim(paramIntent));
      }
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
      i = 0;
      break;
      bool1 = false;
      break label112;
    }
  }
  
  public void startScroll()
  {
    if ((!isDefaultRightPage(this.fromActivity)) && (isTabActivity(this.fromActivity)))
    {
      setShadowInLeftVisible(false, false);
      setRightLineVisible(true);
    }
  }
  
  public void startUnlockActivity()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "startUnlockActivity..." + this.className);
    }
    if (sNotShowLockScreen)
    {
      sNotShowLockScreen = false;
      isUnLockSuccess = true;
      return;
    }
    Intent localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
    localIntent.putExtra("is_activity_to_fragment", false);
    startActivity(localIntent);
    mShowGesture = true;
    this.notShowNewTask = true;
    new Handler().postDelayed(new hgk(this), 1000L);
  }
  
  public void turnOffShake()
  {
    if (shakeListener != null)
    {
      ((SensorManager)getSystemService("sensor")).unregisterListener(shakeListener);
      shakeListener = null;
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "turnOffShake");
      }
    }
  }
  
  public void turnOnShake()
  {
    ThreadManager.b().post(new hgj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */