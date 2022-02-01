package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QzoneWrapperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.video.QzoneVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVideoPluginProxyService;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.MD5;

public class QZoneHelper
{
  public static final String A = "key_has_talk";
  public static final String B = "key_nearby_profile";
  public static final String C = "key_nearby_qzone_to_aio";
  public static final String D = "nearby_qzone_to_aio";
  public static final String E = "qqid";
  public static final String F = "k_modal";
  public static final String G = "k_hide_qzone_icon";
  public static final String H = "qqid";
  public static final String I = "com.qzone.detail.ui.activity.QzoneDetailActivity";
  public static final String J = "com.qzone.publish.ui.activity.QZonePublishMoodActivity";
  public static final String K = "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity";
  public static final String L = "com.qzone.album.ui.activity.QZonePersonalAlbumActivity";
  public static final String M = "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity";
  public static final String N = "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity";
  public static final String O = "com.qzone.qun.ui.activity.QzoneTroopAlbumViewPhotoActivity";
  public static final String P = "com.qzone.qun.ui.activity.QZoneTroopAlbumListActivity";
  public static final String Q = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
  public static final String R = "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity";
  public static final String S = "com.qzone.setting.QZoneSettingManager";
  public static final String T = "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity";
  public static final String U = "com.qzone.qun.ui.activity.QzoneQunFeedActivity";
  public static final String V = "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity";
  public static final String W = "com.qzone.lbsv2.ui.QZoneMoodSelectLocation";
  public static final String X = "com.qzone.feed.ui.activity.QZoneFriendFeedActivity";
  public static final String Y = "com.qzone.cover.ui.activity.QZoneCoverStoreActivity";
  public static final String Z = "com.qzone.qun.ui.activity.QzoneQunMsgbListActivity";
  private static final int a = 3;
  public static final String a = "qzone_key_publish_mood_camera_flag";
  public static final String aa = "com.qzone.preview.QzonePictureViewer";
  public static final String ab = "com.qzone.feed.ui.activity.QZoneMyFeedActivity";
  public static final String ac = "com.qzone.homepage.ui.activity.QzoneMoodListActivity";
  public static final String ad = "com.qzone.cover.ui.activity.QZoneWidgetDetailActivity";
  public static final String ae = "com.tencent.maxvideo.activity.RecordActivity";
  public static final String af = "com.tencent.maxvideo.activity.TrimVideoActivity";
  public static final String ag = "com.tencent.maxvideo.activity.PreviewVideoActivity";
  public static final String ah = "com.tencent.qq.syncQunMsg";
  public static final String ai = "com.tencent.qq.unreadcount";
  private static final String aj = "com.qzone.app.QZoneAppInterface";
  private static final String ak = "com.tencent.maxvideo.QZoneVideoAppInterface";
  private static final String al = "com.qzone.component.cache.CacheManager";
  private static final String am = "total_retried_times_";
  private static int b = -2;
  public static final String b = "qzone_key_skip_from_widget";
  public static final String c = "qzone_start";
  public static final String d = "key_select_poi";
  public static final String e = "com.qzone";
  public static final String f = "com.tencent.zebra";
  public static final String g = "com.adobe.flashplayer";
  public static final String h = "aciton_check_qzone_vip_info";
  public static final String i = "requestQzoneOpenVip";
  public static final String j = "https://pay.qq.com/h5/index.shtml?m=buy&c=xxjzgw&aid={AID}&sid={SID}&u={UIN}&pf=2103&su=pay%3A%2F%2FrequestQzoneOpenVip";
  public static final String k = "pay://requestQzoneOpenVip";
  public static final String l = "key_qzone_vip_open_back_need_check_vipinfo";
  public static final String m = "file" + File.separator + "image";
  public static final String n = "qzone_uin";
  public static final String o = "nickname";
  public static final String p = "sid";
  public static final String q = "com.qzone.preview.service.PictureService";
  public static final String r = "com.qzone.publish.service.PublishQueueService";
  public static final String s = "com.qzone.intent.action.PRELOAD_FRIEND_FEEDS";
  public static final String t = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
  public static final String u = "com.qzone.intent.action.PRE_DOWNLOAD_PHOTOS";
  public static final String v = "com.qzone.intent.action.LAUNCH_BY_WEB_MUSIC";
  public static final String w = "com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE";
  public static final String x = "videoPluginSupportTrim";
  public static final String y = "SQQzoneSvc.";
  public static final String z = "qzone_entry";
  
  public static int a()
  {
    return QzoneConfig.a().a("QZoneSetting", "UpdateCountIntervalWhenActiveApp", 5) * 1000;
  }
  
  public static Intent a()
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    return localIntent;
  }
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.a(paramContext, "com.qzone.feed.ui.activity.QZoneMyFeedActivity");
    return paramContext;
  }
  
  private static Intent a(Context paramContext, Long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_left_tab_title", paramContext.getString(2131365482));
    localIntent.putExtra("key_rihgt_tab_title", paramContext.getString(2131365484));
    localIntent.putExtra("key_album_owner_uin", paramLong);
    localIntent.putExtra("key_selected_tab", paramInt);
    a(localIntent);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.album.ui.activity.QZonePersonalAlbumActivity");
    return localIntent;
  }
  
  private static Intent a(QZoneHelper.UserInfo paramUserInfo, String paramString)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, paramString);
    return localIntent;
  }
  
  public static Intent a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qqid", Long.parseLong(paramString));
    localIntent.putExtra("qzone_entry", 0);
    a(localIntent);
    return localIntent;
  }
  
  private static Intent a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("QZoneUploadPhotoActivity.key_state_type_src", paramInt);
    paramString1.putExtra("key_qun_id", paramString2);
    paramString1.putExtra("ken_qun_name", paramString3);
    paramString1.putExtra("key_album_id", paramString4);
    paramString1.putExtra("key_album_name", paramString5);
    paramString1.putExtra("key_need_load_photo_from_intent", false);
    paramString1.putExtra("refer", paramString6);
    paramString1.putExtra("IsBack", true);
    return paramString1;
  }
  
  public static BaseBusinessAlbumInfo a(String paramString1, String paramString2)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    paramString2 = LocalMultiProcConfig.a(str, "");
    paramString1 = LocalMultiProcConfig.a(paramString1, "");
    paramString2 = new BaseBusinessAlbumInfo(paramString2);
    paramString2.b = paramString1;
    return paramString2;
  }
  
  public static String a()
  {
    return QUA.a();
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.a(null, "Runtime_load_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    QLog.e("QZLog", 1, "-------------createQZoneAppInterface");
    try
    {
      paramString = Class.forName("com.qzone.app.QZoneAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = paramString;
        paramString = QzonePluginProxyActivity.a(paramBaseApplicationImpl);
        paramBaseApplicationImpl = paramString.loadClass("com.qzone.app.QZoneAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      for (;;)
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
        {
          paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
          return paramBaseApplicationImpl;
        }
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    finally
    {
      PerfTracer.a("Runtime_load_runtime", null);
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static void a()
  {
    Intent localIntent = new Intent("QZonePreDownload");
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "actionString: " + localIntent.getAction());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "unregister");
    localBundle.putString("uin", "");
    localIntent.putExtras(localBundle);
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("widgetType", paramInt);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QZoneWidgetDetailActivity");
    QzonePluginProxyActivity.a(paramActivity, "", localIntent, -1);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    localIntent.putExtra("videoPluginSupportTrim", paramBoolean);
    QzoneVideoPluginProxyActivity.a(localIntent, "com.tencent.maxvideo.activity.RecordActivity");
    QzoneVideoPluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity");
    localIntent.putExtra("qqid", paramLong);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramIntent, paramInt, paramOnDismissListener);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, ArrayList paramArrayList, int paramInt2)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "UploadPhoto_click2Activity");
    paramString1 = a(null, 1, paramString1, paramString2, paramString3, paramString4, "mqqChat");
    a(paramString1, paramUserInfo);
    QzonePluginProxyActivity.a(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramString1 == null) {
      return;
    }
    int i1 = paramInt1;
    switch (paramInt1)
    {
    default: 
      i1 = paramInt1;
    }
    for (;;)
    {
      paramString1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      paramString1.putExtra("key_quality", i1);
      paramString1.putExtra("key_album_upload_immediately", true);
      paramString1.putExtra("photoactivity_key_type", 1);
      paramString2 = String.valueOf(MessageUtils.a());
      paramIntent.putExtra("key_upload_client_key", paramString2);
      paramString1.putExtra("key_upload_client_key", paramString2);
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString1, paramInt2);
      return;
      i1 = 0;
      continue;
      i1 = 3;
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = a(paramUserInfo, "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, CoverCacheData paramCoverCacheData, int paramInt)
  {
    if (!TextUtils.isEmpty(paramUserInfo.c)) {}
    for (paramCoverCacheData = Uri.encode(paramUserInfo.c);; paramCoverCacheData = "empty")
    {
      paramUserInfo = QZoneHelper.QZoneCoverConstants.a(paramCoverCacheData, "usersummary", String.valueOf(3), paramUserInfo.jdField_a_of_type_JavaLangString);
      paramCoverCacheData = new Intent(paramActivity, QQBrowserActivity.class);
      paramCoverCacheData.putExtra("url", paramUserInfo);
      paramCoverCacheData.setData(Uri.parse(paramUserInfo));
      paramActivity.startActivityForResult(paramCoverCacheData, paramInt);
      return;
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "QzoneAlbum_click2Activity");
    paramLong = a(paramActivity, paramLong, paramInt1);
    a(paramLong, paramUserInfo);
    paramLong.putExtra("key_need_show_album_recent_photo", true);
    paramLong.putExtra("refer", "mqqSetting");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramLong, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "QzoneRecent_click2Activity");
    paramLong = a(paramActivity, paramLong, paramInt1);
    if ((paramActivity instanceof QzoneWrapperActivity)) {
      paramLong.putExtra("has_base_fragment", true);
    }
    a(paramLong, paramUserInfo);
    a(paramLong, paramInt2);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramLong, paramInt3);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "UserHome_click2Activity");
    paramString = a(paramString);
    if (!(paramActivity instanceof FriendProfileCardActivity)) {
      paramString.putExtra("has_base_fragment", true);
    }
    a(paramString, paramUserInfo);
    QzonePluginProxyActivity.a(paramString, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    a(paramString, paramInt1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ProfileActivity.AllInOne paramAllInOne)
  {
    paramString = a(paramString);
    a(paramString, paramUserInfo);
    QzonePluginProxyActivity.a(paramString, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramString.putExtra("key_has_talk", paramBoolean);
    paramString.putExtra("key_nearby_profile", paramAllInOne);
    a(paramString, paramInt1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("video_source_path", paramString);
    localIntent.putExtra("video_type", paramInt1);
    localIntent.putExtra("start_time", paramLong1);
    localIntent.putExtra("end_time", paramLong2);
    a(localIntent, paramUserInfo);
    QzoneVideoPluginProxyActivity.a(localIntent, "com.tencent.maxvideo.activity.PreviewVideoActivity");
    QzoneVideoPluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt, String paramString2)
  {
    paramString2 = new Intent();
    a(paramString2, paramUserInfo);
    QzonePluginProxyActivity.a(paramString2, "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity");
    paramString2.putExtra("mqqflag", 1);
    paramString2.putExtra("cell_operation.qq_url", paramString1);
    paramString2.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString2, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, long paramLong, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    Intent localIntent = new Intent("android.intent.action.MAIN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("qzone.cellid", paramString);
    localIntent.putExtra("qzone.sourceFrom", true);
    localIntent.putExtra("qzone.favorOwner", paramLong);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_PUBLISH_QR_CODE");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "QunAlbum_click2Activity");
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QzoneTroopAlbumViewPhotoActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_album_id", paramString2);
    localIntent.putExtra("cell_operation.qq_url", paramString3);
    localIntent.putExtra("refer", paramString4);
    localIntent.putExtra("qundetail", 1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "UploadPhoto_click2Activity");
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong);
    localIntent.putExtra("refer", "mqqChat");
    localIntent.putExtra("display_like_dialog", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList3);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QzoneQunMsgbListActivity");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("ken_qun_name", paramString2);
    localIntent.putExtra("newflag", paramBoolean);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt2)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "UploadPhoto_click2Activity");
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_file_id", paramLong2);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong1);
    localIntent.putExtra("refer", "mqqChat");
    localIntent.putExtra("display_like_dialog", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_fileids", paramArrayList4);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList3);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("has_base_fragment", true);
    localIntent.putExtra("refer", "getActiveFeeds");
    localIntent.putExtra("launch_time", System.currentTimeMillis());
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneMyFeedActivity");
    QzonePluginProxyActivity.a(paramActivity, paramString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "FriendFeed_click2Activity");
    paramIntent.setAction(null);
    a(paramActivity, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QzonePluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt, paramOnDismissListener);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.stopService(new Intent(paramContext, QzonePluginPublishQueueProxyService.class));
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qq.syncQunMsg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.tencent.qq.unreadcount", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Object localObject = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService((Intent)localObject);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.minihd.qq:picture");
      localObject = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService((Intent)localObject);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.minihd.qq:qzone");
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.minihd.qq:qzonevideo");
      localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "image";
      if (localObject != null) {
        FileUtil.c((String)localObject);
      }
      localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "video";
      if (localObject != null) {
        FileUtil.c((String)localObject);
      }
      localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.minihd.qq" + File.separator + "qzone";
      if (localObject != null) {
        FileUtil.c((String)localObject);
      }
      localObject = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone";
      if (localObject != null) {
        FileUtil.c((String)localObject);
      }
      if (!TextUtils.isEmpty(paramString)) {
        paramContext.deleteDatabase(SecurityUtil.a(paramString));
      }
      QZConfigProviderUtil.a();
      paramContext = paramContext.getFilesDir().getParent() + File.separator + "shared_prefs";
      if (!TextUtils.isEmpty(paramContext))
      {
        FileUtil.c(paramContext + File.separator + "qz_predownload_config.xml");
        FileUtil.c(paramContext + File.separator + "QZ_Per_Config.xml");
        FileUtil.c(paramContext + File.separator + "QZONE_UNREAD.xml");
      }
      paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace";
    } while (paramContext == null);
    FileUtil.c(paramContext);
  }
  
  public static void a(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramContext, QzoneVideoPluginProxyService.class);
    localIntent.putExtra("qzone_uin", paramString);
    QzoneVideoPluginProxyService.a(paramContext, paramString, localIntent, paramServiceConnection);
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("key_time_record", System.currentTimeMillis());
  }
  
  private static void a(Intent paramIntent, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramIntent.putExtra("refer", "mqqSetProfile");
      return;
    case 2: 
      paramIntent.putExtra("refer", "mqqAvatar");
      return;
    case 3: 
      paramIntent.putExtra("refer", "mqqQuanzi");
      return;
    case 4: 
      paramIntent.putExtra("refer", "mqqNearby");
      return;
    case 5: 
      paramIntent.putExtra("refer", "mqqChat");
      return;
    }
    paramIntent.putExtra("refer", "mqqQunSpace");
  }
  
  public static void a(Intent paramIntent, QZoneHelper.UserInfo paramUserInfo)
  {
    paramIntent.putExtra("qzone_uin", paramUserInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("nickname", paramUserInfo.b);
    paramIntent.putExtra("sid", paramUserInfo.c);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
        Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
        localIntent.putExtra("useSkinEngine", 1);
        localIntent.setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.b = QzonePluginProxyActivity.a();
        localPluginParams.d = "QQ空间";
        localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
        localPluginParams.e = "com.qzone.preview.service.PictureService";
        localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
        if (QLog.isColorLevel()) {
          QLog.d("QPlugin", 2, "QZoneHelper Start QZone Preload PictureService", new Throwable("debug"));
        }
        IPluginManager.b(paramQQAppInterface.a(), localPluginParams);
        if (b < 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QPlugin", 2, "Qz video plugin current state:" + b);
      return;
      bool1 = ((IPluginManager)paramQQAppInterface.getManager(26)).isPlugininstalled("QzoneVideoPlugin.apk");
      bool2 = NetworkUtil.g(paramQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("QPlugin", 2, "Qz video plugin is installed:" + bool1 + ",current network is wifi:" + bool2);
      }
    } while ((bool1) || (!bool2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    try
    {
      paramQQAppInterface.a(paramContext);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ServiceConnection paramServiceConnection)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginPublishQueueProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = QzonePluginProxyActivity.a();
    localPluginParams.d = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    localPluginParams.e = "com.qzone.publish.service.PublishQueueService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "start and bind QzonePublishQueueService");
    }
    IPluginManager.b(paramQQAppInterface.a(), localPluginParams);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS");
    localIntent.putExtra("qunid", paramString);
    localIntent.putExtra("qzone_uin", paramQQAppInterface.a());
    paramString = new IPluginManager.PluginParams(0);
    paramString.b = QzonePluginProxyActivity.a();
    paramString.d = "QQ空间";
    paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    paramString.e = "com.qzone.preview.service.PictureService";
    paramString.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone QunAlbum Preload");
    }
    IPluginManager.b(paramQQAppInterface.a(), paramString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = new Intent("QZonePreDownload");
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "actionString: " + paramString1.getAction());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "register");
    localBundle.putString("periods", paramString2);
    localBundle.putInt("expiredDay", paramInt1);
    localBundle.putInt("interval", paramInt2);
    paramString1.putExtras(localBundle);
    BaseApplication.getContext().sendBroadcast(paramString1);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    LocalMultiProcConfig.a(str, paramString3);
    LocalMultiProcConfig.a(paramString1, paramString4);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    localCoverCacheData.type = "PhotoWallCover";
    try
    {
      localCoverCacheData.uin = Long.parseLong(paramAppRuntime.getAccount());
      label26:
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
      localUserInfo.c = paramAppRuntime.getSid();
      b(paramActivity, localUserInfo, localCoverCacheData, 1008);
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getInstalledPackages(4).iterator();
    while (paramContext.hasNext()) {
      if (paramString.equals(((PackageInfo)paramContext.next()).packageName)) {
        return true;
      }
    }
    return false;
  }
  
  public static int b()
  {
    return QzoneConfig.a().a("QZoneSetting", "UpdateCountIntervalWhenClickFeedTab", 30) * 1000;
  }
  
  public static Intent b(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.a(paramContext, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    return paramContext;
  }
  
  public static AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.maxvideo.QZoneVideoAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*createQZoneVideoAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramBaseApplicationImpl = QzoneVideoPluginProxyActivity.a(paramBaseApplicationImpl).loadClass("com.tencent.maxvideo.QZoneVideoAppInterface");
        continue;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
          break label87;
        }
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
      return null;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static void b()
  {
    Intent localIntent = new Intent("QZonePreDownload");
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "NotifyPreDownloadComplete actionString: " + localIntent.getAction());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "preDownloadComplete");
    localBundle.putBoolean("downloadCompleted", true);
    localIntent.putExtras(localBundle);
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.setting.QZoneSettingManager");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = a(paramUserInfo, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, CoverCacheData paramCoverCacheData, int paramInt)
  {
    if (paramCoverCacheData == null) {
      return;
    }
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "PhotoWall_click2Activity");
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCoverCacheData.type != null)
    {
      bool1 = bool2;
      if (paramCoverCacheData.type.equals("PhotoWallCover")) {
        bool1 = true;
      }
    }
    localIntent.putExtra("cover_uin", paramCoverCacheData.uin);
    localIntent.putExtra("photowall_mode", bool1);
    localIntent.putExtra("set_source", 1);
    if (!bool1) {
      localIntent.putExtra("current_cover", paramCoverCacheData);
    }
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("has_base_fragment", true);
    localIntent.putExtra("key_uin", paramLong);
    localIntent.putExtra("key_nickname", paramUserInfo.b);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.homepage.ui.activity.QzoneMoodListActivity");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("qundetail", 1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "QunFeed_click2Activity");
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QzoneQunFeedActivity");
    localIntent.putExtra("refer", "1");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("ken_qun_name", paramString2);
    localIntent.putExtra("newflag", paramBoolean);
    a(localIntent);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("moveTaskToBack", true);
    localIntent.putExtra("is_base_fragment", true);
    localIntent.putExtra("has_base_fragment", true);
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("launch_time", System.currentTimeMillis());
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    a(paramActivity, paramString, localIntent, paramInt);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.minihd.qq:picture");
      localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.minihd.qq:qzone");
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.minihd.qq:qzonevideo");
    } while (TextUtils.isEmpty(paramString));
    paramContext.deleteDatabase(SecurityUtil.a(paramString));
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.PRE_DOWNLOAD_PHOTOS");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = QzonePluginProxyActivity.a();
    localPluginParams.d = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    localPluginParams.e = "com.qzone.preview.service.PictureService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone PreDownload");
    }
    IPluginManager.b(paramQQAppInterface.a(), localPluginParams);
  }
  
  public static void c(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void c(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QZoneTroopAlbumListActivity");
    localIntent.putExtra("QZoneTroopAlbumListActivity.key_state_type_src", 1);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("ken_qun_name", paramString2);
    localIntent.putExtra("QZoneTroopAlbumListActivity.key_troop_album_is_from_qq", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void d(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_select_video", true);
    a(localIntent, paramUserInfo);
    QzoneVideoPluginProxyActivity.a(localIntent, "com.tencent.maxvideo.activity.TrimVideoActivity");
    QzoneVideoPluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper
 * JD-Core Version:    0.7.0.1
 */