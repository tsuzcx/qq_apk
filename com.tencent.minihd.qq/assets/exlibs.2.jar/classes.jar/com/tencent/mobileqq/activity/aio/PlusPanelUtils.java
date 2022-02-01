package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakUtils;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.zebra.ZebraPluginProxyActivity;
import cooperation.zebra.ZebraPluginSplashDialog;
import fpp;
import fpq;
import fps;
import fpu;
import fpv;
import fpx;
import fpz;
import fqb;
import fqc;
import fqd;
import fqe;
import fqj;
import fqk;
import fql;
import fqm;
import java.io.File;
import java.util.Calendar;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class PlusPanelUtils
{
  public static final int a = 0;
  public static String a;
  public static final int b = 3;
  public static String b;
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  private static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aN);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      localObject = "0" + i;
      localStringBuilder.append(localObject);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label300;
      }
      localObject = "0" + i;
      label108:
      localStringBuilder.append(localObject);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label308;
      }
      localObject = "0" + i;
      label148:
      localStringBuilder.append(localObject);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label316;
      }
      localObject = "0" + i;
      label188:
      localStringBuilder.append(localObject);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label324;
      }
    }
    label300:
    label308:
    label316:
    label324:
    for (Object localObject = "0" + i;; localObject = Integer.valueOf(i))
    {
      localStringBuilder.append(localObject);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label332;
      }
      return localStringBuilder.toString() + ".jpg";
      localObject = Integer.valueOf(i);
      break;
      localObject = Integer.valueOf(i);
      break label108;
      localObject = Integer.valueOf(i);
      break label148;
      localObject = Integer.valueOf(i);
      break label188;
    }
    label332:
    localObject = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(".jpg");
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(j, ((StringBuilder)localObject).length());
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getAccount();
    Friends localFriends = ((FriendManager)paramQQAppInterface.getManager(8)).c(str);
    Object localObject1 = (SplashActivity)SplashActivity.a();
    if (!((SplashActivity)localObject1).permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      ((SplashActivity)localObject1).permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new fpv(paramActivity, paramSessionInfo, paramQQAppInterface, (SplashActivity)localObject1));
      return;
    }
    localObject1 = new Intent(paramActivity, SendPhotoActivity.class);
    ((Intent)localObject1).setClass(paramActivity, PhotoListActivity.class);
    ((Intent)localObject1).putExtra("is_activity_to_fragment", false);
    ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    if (paramSessionInfo.jdField_a_of_type_Int == 9501)
    {
      ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      ((Intent)localObject1).putExtra(AlbumConstants.i, 80);
      ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
      ((Intent)localObject1).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
      boolean bool3 = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpresend_whitelist.name());
      Object localObject2 = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label859;
      }
      i = 4;
      label230:
      localObject2 = ((Context)localObject2).getSharedPreferences("presend_config_sp", i);
      boolean bool2 = ((SharedPreferences)localObject2).getBoolean("key_presend_off_flag", false);
      boolean bool1 = bool2;
      if (bool2)
      {
        long l = ((SharedPreferences)localObject2).getLong("key_presend_off_time", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "PicPresend off more than 24h ,enable PicPresend!");
          }
          ((SharedPreferences)localObject2).edit().putBoolean("key_presend_off_flag", false).commit();
          bool1 = false;
        }
      }
      bool2 = bool1;
      if (paramSessionInfo.jdField_a_of_type_Int == 1001)
      {
        bool2 = bool1;
        if (!paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "old lbs protocol ,disable PicPresend!");
          }
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "enterAlbum isInDPCPicPresendWhiteList :" + bool3 + ", presendOFF = " + bool2);
      }
      if ((!bool3) && (!bool2)) {
        ((Intent)localObject1).putExtra("binder_presendService", new BinderWarpper(new PresendPicMgrService(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, str).asBinder()));
      }
      ((Intent)localObject1).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject1).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      ((Intent)localObject1).putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
      ((Intent)localObject1).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      ((Intent)localObject1).putExtra("album_enter_directly", true);
      ((Intent)localObject1).putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
      ((Intent)localObject1).putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject1).putExtra("PhotoConst.MY_HEAD_DIR", paramQQAppInterface.a(false, str));
      ((Intent)localObject1).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject1).putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uinname", paramSessionInfo.d);
      ((Intent)localObject1).putExtra("PhotoConst.MY_UIN", str);
      if ((paramActivity instanceof ChatActivity)) {
        ((Intent)localObject1).putExtra("isBack2Root", ((ChatActivity)paramActivity).a().c);
      }
      if (localFriends != null) {
        ((Intent)localObject1).putExtra("PhotoConst.MY_NICK", localFriends.name);
      }
      ((Intent)localObject1).putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      if (!AlbumUtil.a(paramSessionInfo.jdField_a_of_type_Int)) {
        break label864;
      }
    }
    label859:
    label864:
    for (int i = MediaFileFilter.MEDIA_FILTER_DEFAULT.ordinal();; i = MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE.ordinal())
    {
      if (AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        i = MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE.ordinal();
      }
      ((Intent)localObject1).putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", i);
      if ((TextUtils.isEmpty(str)) && (QLog.isColorLevel())) {
        QLog.i("PEAK", 2, "enterAlbum: my uin is " + str);
      }
      ((Intent)localObject1).getExtras().remove("forward_type");
      if (paramSessionInfo.jdField_a_of_type_Int != 1) {
        break label874;
      }
      PeakUtils.a(paramActivity, ((Intent)localObject1).getExtras(), 7001);
      return;
      ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
      ((Intent)localObject1).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      break;
      i = 0;
      break label230;
    }
    label874:
    paramActivity.startActivityForResult((Intent)localObject1, 7);
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "enterPhotoPicker");
    }
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
    localIntent.putExtra("url", "https://app.p.qq.com/games/zhuagui/game.html");
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("uin_name", paramSessionInfo.d);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str1 = "https://ti.qq.com/remind/add.html?_wv=1027";
    String str2 = "0";
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str1);
      localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("uin_name", paramSessionInfo.d);
      paramContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("remind", 2, "aioClickRemindReport arg1: " + str2);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Time_reminder", "Time_aio_clk", 0, 0, str2, "", "", "");
      return;
      str1 = "https://ti.qq.com/remind/add.html?_wv=1027" + "&rtype=c2c&uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = "0";
      continue;
      str1 = "https://ti.qq.com/remind/add.html?_wv=1027" + "&rtype=group&gid=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = "1";
      continue;
      str1 = "https://ti.qq.com/remind/add.html?_wv=1027" + "&rtype=discuss&did=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = "2";
    }
  }
  
  public static void a(View paramView, BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, Handler.Callback paramCallback)
  {
    paramCallback = new IconPopupWindow(paramActivity);
    paramCallback.a(2131366481, new fql(paramQQAppInterface, paramActivity, paramInt, paramString));
    paramCallback.a(new fqm(paramQQAppInterface));
    paramCallback.a(paramView, 1);
    paramBaseChatPie.a(paramCallback);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D6C", "0X8004D6C", 0, 0, "", "", "", "");
  }
  
  public static void a(View paramView, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    IconPopupWindow localIconPopupWindow = new IconPopupWindow(paramContext);
    localIconPopupWindow.a(2131365712, new fpp(paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
    localIconPopupWindow.a(2131365713, new fqb(paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
    localIconPopupWindow.a(new fqc(paramQQAppInterface));
    localIconPopupWindow.a(paramView, 1);
    paramBaseChatPie.a(localIconPopupWindow);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    SplashActivity localSplashActivity = (SplashActivity)SplashActivity.a();
    if (!localSplashActivity.permissionManager.checkPermission("android.permission.ACCESS_FINE_LOCATION"))
    {
      localSplashActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.ACCESS_FINE_LOCATION", 500) }).request(new fpx(paramQQAppInterface, paramActivity, localSplashActivity));
      return;
    }
    try
    {
      ((ChatActivity)paramActivity).a().ac();
      paramActivity.startActivityForResult(new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount()), 18);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    Object localObject1 = (SplashActivity)SplashActivity.a();
    if ((!((SplashActivity)localObject1).permissionManager.checkPermission("android.permission.CAMERA")) || (!((SplashActivity)localObject1).permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
    {
      ((SplashActivity)localObject1).permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 100) }).requests(new fps(paramQQAppInterface, paramActivity, paramInt, (SplashActivity)localObject1));
      return;
    }
    if (!Utils.e())
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131367289), 0).a();
      return;
    }
    localObject1 = new File(AppConstants.aN);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = a();
    Uri.fromFile(new File((String)localObject1));
    PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", (String)localObject1).commit();
    if (paramInt == 23)
    {
      localObject1 = new Intent(new Intent());
      Object localObject2 = (FriendManager)paramQQAppInterface.getManager(8);
      if (localObject2 != null)
      {
        localObject2 = ((FriendManager)localObject2).c(paramQQAppInterface.a());
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("self_nick", ((Friends)localObject2).name);
        }
      }
      paramQQAppInterface = paramQQAppInterface.a();
      ((Intent)localObject1).putExtra("market", "photocamera");
      ((Intent)localObject1).putExtra("qq", Long.parseLong(paramQQAppInterface));
      ((Intent)localObject1).putExtra("param_plugin_gesturelock", true);
      if (QLog.isDevelopLevel()) {
        QLog.d("STARTUPTIMELOG", 4, "[STARTUPTIMELOG] DemoActivity mButton onClick, time=" + System.currentTimeMillis());
      }
      localObject2 = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject2).jdField_b_of_type_JavaLangString = "WaterMarkCamera.apk";
      ((IPluginManager.PluginParams)localObject2).d = "水印相机";
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangString = paramQQAppInterface;
      ((IPluginManager.PluginParams)localObject2).e = "com.tencent.cameraui.MqqCameraActivity";
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidContentIntent = ((Intent)localObject1);
      ((IPluginManager.PluginParams)localObject2).jdField_b_of_type_Int = paramInt;
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidAppDialog = new ZebraPluginSplashDialog(paramActivity, 0);
      ((IPluginManager.PluginParams)localObject2).c = 10000;
      ((IPluginManager.PluginParams)localObject2).f = "正在启动水印相机，请稍候";
      IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject2);
      return;
    }
    paramQQAppInterface = new Intent();
    FileProvider7Helper.setSystemCapture((SplashActivity)SplashActivity.a(), new File((String)localObject1), paramQQAppInterface);
    com.tencent.mobileqq.app.BaseActivity.sNotShowLockScreen = true;
    try
    {
      paramActivity.startActivityForResult(paramQQAppInterface, paramInt);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.mobileqq.app.BaseActivity.sNotShowLockScreen = false;
      paramQQAppInterface.printStackTrace();
      QQToast.a(paramActivity, 2131367312, 0).a();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, Handler.Callback paramCallback)
  {
    paramCallback = ActionSheet.a(paramActivity);
    paramCallback.c(2131366481);
    paramCallback.e(2131365736);
    paramCallback.a(new fqj(paramQQAppInterface));
    paramCallback.a(new fqk(paramCallback, paramQQAppInterface, paramActivity, paramInt, paramString));
    paramCallback.show();
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D6C", "0X8004D6C", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface.putExtra("display_like_dialog", true);
    paramQQAppInterface.putExtra("from_aio", true);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramSessionInfo.jdField_a_of_type_Int == 1000) {
      paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      paramActivity.startActivityForResult(paramQQAppInterface, 5);
      paramActivity.overridePendingTransition(2130968586, 2130968588);
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
        paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.e);
      } else {
        paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.c);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new fpu(paramSessionInfo, paramQQAppInterface, paramContext, ImageUtil.c(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString)
  {
    Object localObject1 = (SplashActivity)SplashActivity.a();
    if ((!((SplashActivity)localObject1).permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!((SplashActivity)localObject1).permissionManager.checkPermission("android.permission.CAMERA")))
    {
      ((SplashActivity)localObject1).permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 600), PermissionItem.init("android.permission.CAMERA", 600) }).requests(new fpq(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, (SplashActivity)localObject1));
      return;
    }
    Object localObject2;
    if (paramBoolean)
    {
      localObject2 = "0X80049C5";
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        localObject1 = "0";
        label184:
        ReportController.b(paramQQAppInterface, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, (String)localObject1, "", "", "");
        localObject2 = (PhoneContactManager)paramQQAppInterface.getManager(10);
        if (paramSessionInfo.jdField_a_of_type_Int == 1006)
        {
          localObject1 = ((PhoneContactManager)localObject2).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
          localObject2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = new Intent(paramContext, QavChatActivity.class);
      ((Intent)localObject2).addFlags(262144);
      ((Intent)localObject2).putExtra("key_peer_uin", (String)localObject1);
      ((Intent)localObject2).putExtra("key_only_audio", paramBoolean);
      paramContext.startActivity((Intent)localObject2);
      b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString);
      return;
      localObject2 = "0X80049C7";
      break;
      localObject1 = "0";
      break label184;
      localObject1 = "1";
      break label184;
      localObject1 = "2";
      break label184;
      localObject1 = "3";
      break label184;
      localObject1 = "4";
      break label184;
      localObject1 = "5";
      break label184;
      localObject1 = "6";
      break label184;
      localObject1 = "7";
      break label184;
      localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      ((PhoneContactManager)localObject2).c((String)localObject1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.c(2131366480);
    localActionSheet.c(2131366477);
    localActionSheet.e(2131365736);
    localActionSheet.a(new fqd(paramQQAppInterface));
    localActionSheet.a(new fqe(localActionSheet, paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
    localActionSheet.show();
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    SplashActivity localSplashActivity = (SplashActivity)SplashActivity.a();
    if (!localSplashActivity.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      localSplashActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new fpz(paramQQAppInterface, paramActivity, paramSessionInfo, localSplashActivity));
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files\t", 0, 0, "", paramSessionInfo.jdField_a_of_type_JavaLangString, "", "");
    paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface.putExtra("display_like_dialog", true);
    paramQQAppInterface.putExtra("from_aio", true);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("tab_tab_type", 5);
    paramQQAppInterface.putExtra("key_check_troop_privilege", true);
    paramActivity.startActivityForResult(paramQQAppInterface, 5);
    paramActivity.overridePendingTransition(2130968586, 2130968588);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString)
  {
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      str = ((PhoneContactManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;; localObject = ((PhoneContactManager)localObject).c(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, paramString);
      return;
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("display_like_dialog", true);
    paramQQAppInterface.putExtra("url", "https://y.qq.com/m/qzonemusic/mqzsearch.html" + "?touin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&uintype=" + paramSessionInfo.jdField_a_of_type_Int + "&_wv=1&entry=aio");
    paramQQAppInterface.putExtra("is_share_music", true);
    paramQQAppInterface.putExtra("hide_more_button", true);
    paramQQAppInterface.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(paramQQAppInterface, 6);
    paramActivity.overridePendingTransition(2130968586, 0);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    QfavHelper.b(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1);
    QfavReport.c(paramQQAppInterface, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanelUtils
 * JD-Core Version:    0.7.0.1
 */