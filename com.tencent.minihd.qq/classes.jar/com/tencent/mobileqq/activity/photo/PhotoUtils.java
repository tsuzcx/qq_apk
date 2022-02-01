package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoedit.PhotoEditPluginProxyActivity;
import cooperation.photoplus.PhotoPlusPluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.video.QzoneVideoPluginProxyActivity;
import cooperation.troop.TroopProxyActivity;
import cooperation.zebra.ZebraPluginBaseDialog;
import cooperation.zebra.ZebraPluginPreviewDialog;
import cooperation.zebra.ZebraPluginProxyActivity;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoUtils
{
  public static final int a = 1048576;
  private static final String a = "PhotoUtils";
  private static final String b = "PHOTO_KEY_FRIEND_UIN";
  
  public static String a(Context paramContext, float paramFloat)
  {
    paramFloat /= 1048576.0F;
    paramContext = new DecimalFormat("0.0");
    if (paramFloat > 1.0F) {
      return paramContext.format(paramFloat) + "M";
    }
    return paramContext.format(paramFloat * 1024.0F) + "K";
  }
  
  public static String a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    if (paramArrayList.hasNext())
    {
      File localFile = new File((String)paramArrayList.next());
      if (localFile.length() > 204800) {}
      for (l += 204800;; l = (l + localFile.length() * 0.8D)) {
        break;
      }
    }
    float f = (float)l * 1.0F / 1048576.0F;
    paramArrayList = new DecimalFormat("#.0");
    if (f > 1.0F) {
      return "约" + paramArrayList.format(f) + "M";
    }
    return "约" + paramArrayList.format(f * 1024.0F) + "K";
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramActivity != null) && (((BaseActivity)paramActivity).app != null)) {
      a(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean, ((BaseActivity)paramActivity).app.a());
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, String paramString)
  {
    Object localObject;
    String str1;
    String str2;
    if (((paramInt1 == 2) || (paramInt1 == 7001)) && (paramInt2 == -1))
    {
      if (paramInt1 != 7001) {
        break label127;
      }
      localObject = paramActivity.getIntent();
      str1 = ((Intent)localObject).getStringExtra("key_album_id");
      str2 = ((Intent)localObject).getStringExtra("key_album_name");
      QZoneHelper.a(paramString, ((Intent)localObject).getStringExtra("uin"), str1, str2);
      ((Intent)localObject).putExtras(paramIntent);
      paramIntent = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject).setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramIntent);
      if (!paramBoolean)
      {
        ((Intent)localObject).addFlags(603979776);
        paramActivity.startActivity((Intent)localObject);
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AlbumUtil.a(paramActivity, false, false);
      return;
      label127:
      if ("AddPhotosFavActivity".equals(paramIntent.getStringExtra("back_activity")))
      {
        paramActivity.finish();
        return;
      }
      paramString = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramString);
      if (!paramBoolean)
      {
        paramIntent.addFlags(603979776);
        StatisticConstants.a(paramIntent);
      }
      else
      {
        localObject = paramActivity.getIntent().getStringExtra("PhotoConst.PLUGIN_NAME");
        str1 = paramActivity.getIntent().getStringExtra("PhotoConst.PLUGIN_APK");
        str2 = paramActivity.getIntent().getStringExtra("PhotoConst.UIN");
        paramIntent.addFlags(67108864);
        paramActivity.getIntent().putExtra("cleartop", true);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.jdField_b_of_type_JavaLangString = str1;
        localPluginParams.d = ((String)localObject);
        localPluginParams.jdField_a_of_type_JavaLangString = str2;
        localPluginParams.e = paramString;
        localPluginParams.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
        localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
        localPluginParams.jdField_b_of_type_Int = paramInt1;
        IPluginManager.a(paramActivity, localPluginParams);
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent(paramIntent);
    localIntent.putExtra("image_path", paramString1);
    localIntent.putExtra("market", "photo");
    localIntent.putExtra("self_nick", paramString3);
    localIntent.putExtra("qq", Long.parseLong(paramString2));
    localIntent.putExtra("qq_face_file_path", paramString4);
    localIntent.putExtra("param_plugin_gesturelock", true);
    paramIntent = localIntent.getStringExtra("uin");
    if (paramIntent != null) {
      localIntent.putExtra("PHOTO_KEY_FRIEND_UIN", paramIntent);
    }
    paramIntent = "com.tencent.cameraui.MqqCameraActivity";
    if (paramInt == 4) {
      paramIntent = "com.tencent.cameraui.MqqCameraActivity";
    }
    while ("com.tencent.cameraui.MqqCameraActivity".equals(paramIntent))
    {
      paramString1 = new IPluginManager.PluginParams(0);
      paramString1.jdField_b_of_type_JavaLangString = "WaterMarkCamera.apk";
      paramString1.d = "Photo+";
      paramString1.jdField_a_of_type_JavaLangString = paramString2;
      paramString1.e = paramIntent;
      paramString1.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
      paramString1.jdField_a_of_type_AndroidContentIntent = localIntent;
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_a_of_type_AndroidAppDialog = new ZebraPluginPreviewDialog(paramActivity, 0);
      paramString1.jdField_a_of_type_Boolean = false;
      paramString1.c = 120000;
      paramString1.f = null;
      IPluginManager.a(paramActivity, paramString1);
      return;
      if (paramInt == 6) {
        paramIntent = "com.tencent.zebra.effect.PhotoEffectActivity";
      } else if (paramInt == 5) {
        paramIntent = "com.tencent.zebra.effect.PhotoEffectActivity";
      }
    }
    paramString1 = new IPluginManager.PluginParams(0);
    paramString1.jdField_b_of_type_JavaLangString = "Photoplus.apk";
    paramString1.d = "Photoplus";
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    paramString1.e = paramIntent;
    paramString1.jdField_a_of_type_JavaLangClass = PhotoPlusPluginProxyActivity.class;
    paramString1.jdField_a_of_type_AndroidContentIntent = localIntent;
    paramString1.jdField_b_of_type_Int = paramInt;
    paramString1.jdField_a_of_type_AndroidAppDialog = new ZebraPluginBaseDialog(paramActivity, 2131558979);
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.c = 10000;
    paramString1.f = "正在启动，请稍候...";
    IPluginManager.a(paramActivity, paramString1);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramIntent.putExtra("PhotoConst.SEND_FLAG", true);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList, int paramInt)
  {
    String str3 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    String str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    String str1 = str3;
    if (str3 == null)
    {
      str3 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str3;
      if (str3 == null)
      {
        QQToast.a(paramActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
        return;
      }
    }
    paramIntent.setClassName(str2, str1);
    str2 = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
    if (str2 != null) {
      paramIntent.putExtra("uin", str2);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "currActivity is:" + paramActivity.getClass().getName());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "destination activity is:" + str1 + ",intent extra is:" + paramIntent.getExtras());
    }
    paramIntent.addFlags(603979776);
    if (!paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      if (str1.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity"))
      {
        paramIntent.putExtra("cleartop", true);
        TroopProxyActivity.a(paramActivity, paramIntent, 2);
        return;
      }
      if (str1.endsWith("LiteActivity"))
      {
        paramArrayList = new Intent("com.tencent.mobileqq.intent.refreshLite");
        paramArrayList.putExtras(paramIntent.getExtras());
        paramActivity.sendBroadcast(paramArrayList);
        return;
      }
      if ((str1.endsWith("ChatSettingForTroop")) || (str1.endsWith("TroopInfoActivity")))
      {
        paramArrayList = new Intent("fragment_on_recieve");
        paramArrayList.putExtras(paramIntent.getExtras());
        paramActivity.sendBroadcast(paramArrayList);
        return;
      }
      paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
      if (paramIntent.getBooleanExtra("friend_forward_photo", false))
      {
        if ("com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(paramIntent.getComponent().getShortClassName()))
        {
          paramActivity.startActivityForResult(paramIntent, 2);
          return;
        }
        paramArrayList = new Intent("Common_BroadcastReceiver");
        paramArrayList.putExtras(paramIntent.getExtras());
        paramActivity.sendBroadcast(paramArrayList);
        return;
      }
      paramActivity.startActivityForResult(paramIntent, 2);
      return;
    }
    str2 = paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
    str3 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
    String str4 = paramIntent.getStringExtra("PhotoConst.UIN");
    if ("WaterMarkCamera.apk".equals(str2))
    {
      paramIntent.putExtra("cleartop", true);
      paramArrayList = new IPluginManager.PluginParams(0);
      paramArrayList.jdField_b_of_type_JavaLangString = str3;
      paramArrayList.d = str2;
      paramArrayList.jdField_a_of_type_JavaLangString = str4;
      paramArrayList.e = str1;
      paramArrayList.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
      paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
      paramArrayList.jdField_b_of_type_Int = 2;
      IPluginManager.a(paramActivity, paramArrayList);
      return;
    }
    if ("qzone_plugin.apk".equals(str3))
    {
      if (str1.equals("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity"))
      {
        a(paramActivity, (String)paramArrayList.get(0), paramIntent.getIntExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", 0));
        return;
      }
      if (b(str1))
      {
        paramArrayList = new Intent("com.tencent.mobileqq.intent.PhotoActivity");
        paramArrayList.putExtras(paramIntent.getExtras());
        paramActivity.sendBroadcast(paramArrayList);
        return;
      }
      paramArrayList = new Intent("cover_wall_refresh_picture");
      paramArrayList.putExtras(paramIntent.getExtras());
      paramActivity.sendBroadcast(paramArrayList);
      return;
    }
    if ("QzoneVideoPlugin.apk".equals(str3))
    {
      QzoneVideoPluginProxyActivity.a(paramIntent, str1);
      paramIntent.putExtra("cleartop", true);
      QzoneVideoPluginProxyActivity.a(paramActivity, str4, paramIntent, -1);
      return;
    }
    if ("qqfav.apk".equals(str3))
    {
      QfavHelper.a(paramActivity, str4, paramIntent, 2);
      return;
    }
    paramIntent.putExtra("cleartop", true);
    paramArrayList = new IPluginManager.PluginParams(0);
    paramArrayList.jdField_b_of_type_JavaLangString = str3;
    paramArrayList.d = str2;
    paramArrayList.jdField_a_of_type_JavaLangString = str4;
    paramArrayList.e = str1;
    paramArrayList.jdField_a_of_type_JavaLangClass = PhotoEditPluginProxyActivity.class;
    paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
    paramArrayList.jdField_b_of_type_Int = 2;
    IPluginManager.a(paramActivity, paramArrayList);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    String str3 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    String str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    String str1 = str3;
    if (str3 == null)
    {
      str3 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str3;
      if (str3 == null) {
        QQToast.a(paramActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      }
    }
    for (;;)
    {
      return;
      paramIntent.setClassName(str2, str1);
      str2 = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
      if (str2 != null) {
        paramIntent.putExtra("uin", str2);
      }
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      if (paramArrayList.size() == 1) {
        paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
      }
      paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "currActivity is:" + paramActivity.getClass().getName());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "destination activity is:" + str1 + ",intent extra is:" + paramIntent.getExtras());
      }
      paramIntent.addFlags(603979776);
      if (!paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
        if (str1.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity"))
        {
          paramIntent.putExtra("cleartop", true);
          TroopProxyActivity.a(paramActivity, paramIntent, 2);
        }
      }
      while (!paramBoolean)
      {
        paramActivity.finish();
        AlbumUtil.a(paramActivity, false, false);
        return;
        if ((str1.endsWith("ChatSettingForTroop")) || (str1.endsWith("TroopInfoActivity")) || (str1.endsWith("LiteActivity")))
        {
          paramArrayList = new Intent("fragment_on_recieve");
          paramArrayList.putExtras(paramIntent.getExtras());
          paramActivity.sendBroadcast(paramArrayList);
        }
        else if (str1.endsWith("TroopCreateActivity"))
        {
          paramArrayList = new Intent("choice_local_img_for_troop");
          paramArrayList.putExtras(paramIntent.getExtras());
          paramArrayList.putExtra("param_compressInitTime", System.currentTimeMillis());
          paramActivity.sendBroadcast(paramArrayList);
        }
        else
        {
          if (str1.endsWith("VipProfileCardPhotoHandlerActivity")) {
            paramIntent.putExtra("action", "photo_edit_complete");
          }
          paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
          paramActivity.startActivityForResult(paramIntent, 2);
          continue;
          str2 = paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
          str3 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
          String str4 = paramIntent.getStringExtra("PhotoConst.UIN");
          if ("WaterMarkCamera.apk".equals(str2))
          {
            paramIntent.putExtra("cleartop", true);
            paramArrayList = new IPluginManager.PluginParams(0);
            paramArrayList.jdField_b_of_type_JavaLangString = str3;
            paramArrayList.d = str2;
            paramArrayList.jdField_a_of_type_JavaLangString = str4;
            paramArrayList.e = str1;
            paramArrayList.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
            paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
            paramArrayList.jdField_b_of_type_Int = 2;
            IPluginManager.a(paramActivity, paramArrayList);
          }
          else if ("qzone_plugin.apk".equals(str3))
          {
            if (str1.equals("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity"))
            {
              a(paramActivity, (String)paramArrayList.get(0), paramIntent.getIntExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", 0));
            }
            else if (b(str1))
            {
              paramArrayList = new Intent("com.tencent.mobileqq.intent.PhotoActivity");
              paramArrayList.putExtras(paramIntent.getExtras());
              paramActivity.sendBroadcast(paramArrayList);
            }
            else
            {
              paramArrayList = new Intent("cover_wall_refresh_picture");
              paramArrayList.putExtras(paramIntent.getExtras());
              paramActivity.sendBroadcast(paramArrayList);
            }
          }
          else if ("QzoneVideoPlugin.apk".equals(str3))
          {
            QzoneVideoPluginProxyActivity.a(paramIntent, str1);
            paramIntent.putExtra("cleartop", true);
            QzoneVideoPluginProxyActivity.a(paramActivity, str4, paramIntent, -1);
          }
          else if ("qqfav.apk".equals(str3))
          {
            QfavHelper.a(paramActivity, str4, paramIntent, 2);
            paramBoolean = true;
          }
          else
          {
            paramIntent.putExtra("cleartop", true);
            paramArrayList = new IPluginManager.PluginParams(0);
            paramArrayList.jdField_b_of_type_JavaLangString = str3;
            paramArrayList.d = str2;
            paramArrayList.jdField_a_of_type_JavaLangString = str4;
            paramArrayList.e = str1;
            paramArrayList.jdField_a_of_type_JavaLangClass = PhotoEditPluginProxyActivity.class;
            paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
            paramArrayList.jdField_b_of_type_Int = 2;
            IPluginManager.a(paramActivity, paramArrayList);
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, ForwardHandlerActivity.class);
    Bundle localBundle = new Bundle(paramBundle);
    localBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    localBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    localBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ForwardHandlerActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(localBundle);
    Object localObject = localBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    paramBundle = (Bundle)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramBundle = localBundle.getString("forward_thumb");
    }
    localObject = paramBundle;
    if (TextUtils.isEmpty(paramBundle)) {
      localObject = localBundle.getString("forward_filepath");
    }
    paramBundle = new ArrayList();
    paramBundle.add(localObject);
    a(paramActivity, localIntent, paramBundle, 0);
  }
  
  static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    paramIntent.setClass(paramActivity, PhotoListActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
    paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    paramActivity.startActivity(paramIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    if (100 == paramIntent.getIntExtra("Business_Origin", 0))
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    }
    for (;;)
    {
      paramIntent.removeExtra("Business_Origin");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
      paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString3);
      paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
      paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
      paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
      paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
      paramActivity.startActivity(paramIntent);
      AlbumUtil.a(paramActivity, false, true);
      return;
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    paramIntent.setClass(paramActivity, PhotoListActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    if (paramInt == 1) {
      paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    }
    paramIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", paramBoolean);
    paramIntent.putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
    paramIntent.putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
    paramActivity.startActivity(paramIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramIntent.setClass(paramActivity, PhotoPreviewActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramString2);
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    paramIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", "com.tencent.minihd.qq");
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString3);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramActivity.startActivity(paramIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    String str = AppConstants.aG + paramBaseActivity.app.getAccount() + "/" + "custom_background/";
    str = str + System.currentTimeMillis() + ".jpg";
    Rect localRect = new Rect();
    paramBaseActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    localRect.width();
    int m = localRect.height();
    int k = SizeMeasure.h(paramBaseActivity);
    int i = SizeMeasure.i(paramBaseActivity);
    int j;
    if (i < k) {
      j = i;
    }
    for (;;)
    {
      i = k - (i - m);
      paramIntent.putExtra("PhotoConst.IS_SET_BACKGROUND", true);
      a(paramIntent, paramBaseActivity, paramBaseActivity.getClass().getName(), j, i, j, i, str);
      return;
      j = k;
      k = i;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      String str;
      Iterator localIterator;
      switch (paramInt)
      {
      case 1: 
      default: 
        str = "Send_compress";
        localIterator = paramArrayList.iterator();
        paramInt = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label135;
        }
        Object localObject = (String)localIterator.next();
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:path == null");
          continue;
          str = "Send_compress";
          break;
          str = "Send_raw";
          break;
        }
        localObject = new File((String)localObject);
        paramInt = (int)(paramInt + ((File)localObject).length());
      }
      label135:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:" + str + ",count:" + paramArrayList.size() + ",totalSize:" + paramInt);
      }
      a(paramQQAppInterface, str, paramArrayList.size(), paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Pic_edit", paramString, 0, 1, null, String.valueOf(paramInt1), null, String.valueOf(paramInt2), null);
  }
  
  static boolean a(String paramString)
  {
    boolean bool2 = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "isLargeFile w:" + j + ",h:" + i);
    }
    boolean bool1 = bool2;
    if (i != -1)
    {
      bool1 = bool2;
      if (j != -1) {
        if (i <= j * 3)
        {
          bool1 = bool2;
          if (j <= i * 3) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    if (paramArrayList.hasNext())
    {
      File localFile = new File((String)paramArrayList.next());
      if (localFile.length() > 102400) {
        if (localFile.length() > 204800L) {
          l += 102400;
        }
      }
      for (;;)
      {
        break;
        l = (l + localFile.length() * 0.5D);
        continue;
        l = (l + localFile.length() * 0.5D);
      }
    }
    float f = (float)l * 1.0F / 1048576.0F;
    paramArrayList = new DecimalFormat("#.0");
    if (f > 1.0F) {
      return "约" + paramArrayList.format(f) + "M";
    }
    return "约" + paramArrayList.format(f * 1024.0F) + "K";
  }
  
  public static boolean b(String paramString)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "QZonePublishMoodActivity";
    arrayOfString[1] = "QZoneUploadPhotoActivity";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.endsWith(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */