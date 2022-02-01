package cooperation.zebra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.pluginsdk.PluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.HashMap;

public class ZebraPluginProxy
{
  public static final String KEY_PHOTOCONST_INIT_ACTIVITY_CLASS_NAME = "PhotoConst.INIT_ACTIVITY_CLASS_NAME";
  public static final String KEY_PHOTOCONST_INIT_ACTIVITY_PACKAGE_NAME = "PhotoConst.INIT_ACTIVITY_PACKAGE_NAME";
  public static final String KEY_PHOTOCONST_IS_CALL_IN_PLUGIN = "PhotoConst.IS_CALL_IN_PLUGIN";
  public static final String KEY_PHOTOCONST_IS_SINGLE_DERECTBACK_MODE = "PhotoConst.IS_SINGLE_DERECTBACK_MODE";
  public static final String KEY_PHOTOCONST_IS_SINGLE_MODE = "PhotoConst.IS_SINGLE_MODE";
  public static final String KEY_PHOTOCONST_MAXUM_SELECTED_NUM = "PhotoConst.MAXUM_SELECTED_NUM";
  public static final String KEY_PHOTOCONST_PLUGIN_APK = "PhotoConst.PLUGIN_APK";
  public static final String KEY_PHOTOCONST_PLUGIN_NAME = "PhotoConst.PLUGIN_NAME";
  public static final String KEY_PHOTOCONST_SINGLE_PHOTO_PATH = "PhotoConst.SINGLE_PHOTO_PATH";
  public static final String KEY_PHOTOCONST_UIN = "PhotoConst.UIN";
  public static final String KEY_TRANSFILE_UTILE_TYPE_PHOTO = "TransfileUtile.TYPE_PHOTO";
  public static final int QZ_LOCAL_PICTURE_REQUEST = 6001;
  private static HashMap sConstIntMap = new HashMap();
  private static HashMap sConstStringMap = new HashMap();
  
  static
  {
    if (sConstIntMap == null) {
      sConstIntMap = new HashMap();
    }
    if (sConstStringMap == null) {
      sConstStringMap = new HashMap();
    }
    sConstIntMap.put("TransfileUtile.TYPE_PHOTO", Integer.valueOf(1));
    sConstStringMap.put("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    sConstStringMap.put("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    sConstStringMap.put("PhotoConst.IS_CALL_IN_PLUGIN", "PhotoConst.IS_CALL_IN_PLUGIN");
    sConstStringMap.put("PhotoConst.PLUGIN_NAME", "PhotoConst.PLUGIN_NAME");
    sConstStringMap.put("PhotoConst.PLUGIN_APK", "PhotoConst.PLUGIN_APK");
    sConstStringMap.put("PhotoConst.UIN", "PhotoConst.UIN");
    sConstStringMap.put("PhotoConst.MAXUM_SELECTED_NUM", "PhotoConst.MAXUM_SELECTED_NUM");
    sConstStringMap.put("PhotoConst.IS_SINGLE_MODE", "PhotoConst.IS_SINGLE_MODE");
    sConstStringMap.put("PhotoConst.IS_SINGLE_DERECTBACK_MODE", "PhotoConst.IS_SINGLE_DERECTBACK_MODE");
    sConstStringMap.put("PhotoConst.SINGLE_PHOTO_PATH", "PhotoConst.SINGLE_PHOTO_PATH");
  }
  
  public static void backToPhoto(Intent paramIntent, Activity paramActivity)
  {
    PhotoUtils.a(paramIntent, paramActivity);
  }
  
  public static void forwardRecentActivity_forwardMessage(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    ForwardRecentActivity.a(paramActivity, paramInt1, paramInt2, paramString1, paramString2, paramBoolean1, paramBoolean2, paramBundle);
  }
  
  public static int getConstInt(String paramString)
  {
    if (!sConstIntMap.containsKey(paramString)) {
      throw new RuntimeException("key not found");
    }
    return ((Integer)sConstIntMap.get(paramString)).intValue();
  }
  
  public static String getConstString(String paramString)
  {
    if (!sConstStringMap.containsKey(paramString)) {
      throw new RuntimeException("key not found");
    }
    return (String)sConstStringMap.get(paramString);
  }
  
  public static String md5_toMD5(String paramString)
  {
    return MD5.toMD5(paramString);
  }
  
  public static void onSendResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    PhotoUtils.a(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean);
  }
  
  public static void reportController_reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void sendPhoto(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList, boolean paramBoolean)
  {
    PhotoUtils.a(paramActivity, paramIntent, paramArrayList, 0, paramBoolean);
  }
  
  public static void sendPhotoForPhotoPlus(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList)
  {
    PhotoUtils.a(paramActivity, paramIntent, paramArrayList);
  }
  
  public static void startPhotoList(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.minihd.qq", PhotoListActivity.class.getName());
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      localIntent.putExtra("full_screen_window", true);
      paramActivity.startActivityForResult(localIntent, 6001);
      if ((paramActivity instanceof PluginActivity))
      {
        AlbumUtil.a(((PluginActivity)paramActivity).getOutActivity(), false, true);
        return;
      }
      AlbumUtil.a(paramActivity, false, true);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.zebra.ZebraPluginProxy
 * JD-Core Version:    0.7.0.1
 */