package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class StatisticConstants
{
  public static final String A = "PhotoConst.camerapreviewactivity_send_times";
  public static final String B = "PhotoConst.camerapreviewactivity_send_rate";
  public static final String C = "PhotoConst.camerapreviewactivity_enter_times_fast";
  public static final String D = "PhotoConst.camerapreviewactivity_send_times_fast";
  public static final String E = "PhotoConst.camerapreviewactivity_send_rate_fast";
  public static final String F = "PhotoConst.photopreviewactivity_send";
  public static final String G = "PhotoConst.photopreviewactivity_send_pic_count";
  public static final String H = "PhotoConst.photopreviewactivity_send_pic_total_count";
  public static final String I = "PhotoConst.photopreviewactivity_send_pic_rate";
  public static final String J = "PhotoConst.photopreviewactivity_send_pic_quality";
  public static final String K = "param_type";
  public static final String L = "param_totalSelNum";
  public static final String M = "param_selNum";
  public static final String N = "param_netType";
  public static final String O = "param_urlType";
  public static final String P = "param_cancelSelNum";
  public static final String Q = "param_consumTime";
  public static final String R = "param_aio_duration";
  public static final String S = "param_second_trans";
  public static final String T = "param_phone_type";
  public static final String U = "param_showing_progress";
  public static final String V = "param_pic_filesize";
  public static final String W = "param_optimizePercent";
  public static final String X = "param_averageTime";
  public static final String Y = "param_residentTime";
  public static final String Z = "param_selCount";
  private static final int a = 1001;
  public static final long a = 86400000L;
  public static final String a = "StatisticConstants";
  public static final String aA = "param_qq_zebra_cnt";
  public static final String aB = "param_qq_favorite_cnt";
  public static final String aC = "param_sourceDetailUrl";
  public static final String aD = "param_uinType";
  public static final String aE = "param_forwardSourceUinType";
  public static final String aF = "param_picSizeType";
  public static final String aG = "param_isForward";
  public static final String aH = "param_age";
  public static final String aI = "param_gender";
  public static final String aJ = "param_picSuffixType";
  public static final String aK = "param_picMD5";
  public static final String aL = "param_picReportHour";
  public static final String aM = "param_picInterval";
  public static final String aN = "param_initTime";
  public static final String aO = "param_compressInitTime";
  public static final String aP = "actPSselectSendPic";
  public static final String aQ = "actPScompressPic";
  public static final String aR = "actPSdonecompressPic";
  public static final String aS = "actPSdoneaioduration";
  public static final String aT = "actPScancelSend";
  public static final String aU = "actPSdaySelSend";
  public static final String aV = "actPSdayCameraSend";
  public static final String aW = "actPSdayQuickSend";
  public static final String aX = "actPSdayWastedSize";
  public static final String aY = "actPSprogressTime";
  public static final String aZ = "actDaySendPicSourceType";
  public static final String aa = "param_sendCount";
  public static final String ab = "param_saveCount";
  public static final String ac = "param_sendPercent";
  public static final String ad = "param_cameraCount";
  public static final String ae = "param_browseCount";
  public static final String af = "param_WasteSize";
  public static final String ag = "param_systemAlbumSendCount";
  public static final String ah = "param_otherSendCount";
  public static final String ai = "param_appSendCount";
  public static final String aj = "param_weixinSendCount";
  public static final String ak = "param_screnshotQQSendCount";
  public static final String al = "param_screnshotOtherSendCount";
  public static final String am = "param_qq_collection_SendCount";
  public static final String an = "param_qq_image_SendCount";
  public static final String ao = "param_qq_filerecv_SendCount";
  public static final String ap = "param_qq_zebra_SendCount";
  public static final String aq = "param_qq_favorite_SendCount";
  public static final String ar = "param_systemAlbumCount";
  public static final String as = "param_otherCount";
  public static final String at = "param_appCount";
  public static final String au = "param_weixinCnt";
  public static final String av = "param_screnshot_qq_cnt";
  public static final String aw = "param_screnshot_other_cnt";
  public static final String ax = "param_qq_collection_cnt";
  public static final String ay = "param_qq_image_cnt";
  public static final String az = "param_qq_filerecv_cnt";
  private static final int jdField_b_of_type_Int = 1002;
  private static final long jdField_b_of_type_Long = 40000L;
  public static final String b = "PhotoConst.last_send_select_rate_time";
  public static final String ba = "actAlbumPicSourceType";
  public static final String bb = "actPhotoSourceDetailUrl";
  public static final String bc = "actAIOPhotoSave";
  public static final String bd = "actDayTotalSave";
  private static final int jdField_c_of_type_Int = 1003;
  private static final long jdField_c_of_type_Long = 250000L;
  public static final String c = "PhotoConst.last_send_select_rate_time_preview";
  private static final int jdField_d_of_type_Int = 1004;
  private static final long jdField_d_of_type_Long = 691200L;
  public static final String d = "PhotoConst.last_send_camera_preview_rate";
  private static final int e = 1005;
  public static final String e = "PhotoConst.last_send_camera_preview_rate_fast";
  private static final int f = 1006;
  public static final String f = "PhotoConst.last_send_pic_source_type";
  private static final int g = 1007;
  public static final String g = "PhotoConst.last_album_source_type";
  private static final int h = 1008;
  public static final String h = "PhotoConst.last_total_save_count";
  private static final int i = 1009;
  public static final String i = "PhotoConst.photolistactivity_send";
  private static final int j = 1010;
  public static final String j = "PhotoConst.photolistactivity_pic_quality";
  private static final int k = 1011;
  public static final String k = "PhotoConst.photolistactivity_pic_count";
  public static final String l = "PhotoConst.photolistactivity_pic_total_count";
  public static final String m = "PhotoConst.photolistactivity_pic_rate";
  public static final String n = "PhotoConst.photolistactivity_systemalbum_send_count";
  public static final String o = "PhotoConst.photolistactivity_other_send_count";
  public static final String p = "PhotoConst.photolistactivity_app_send_count";
  public static final String q = "PhotoConst.photolistactivity_weixin_send_count";
  public static final String r = "PhotoConst.photolistactivity_screnshot_qq_send_count";
  public static final String s = "PhotoConst.photolistactivity_screnshot_other_send_count";
  public static final String t = "PhotoConst.photolistactivity_qq_collection_send_count";
  public static final String u = "PhotoConst.photolistactivity_qq_image_send_count";
  public static final String v = "PhotoConst.photolistactivity_qq_filerecv_send_count";
  public static final String w = "PhotoConst.photolistactivity_qq_zebra_send_count";
  public static final String x = "PhotoConst.photolistactivity_qq_favorite_send_count";
  public static final String y = "PhotoConst.total_save_count";
  public static final String z = "PhotoConst.camerapreviewactivity_enter_times";
  
  public static int a()
  {
    int i2 = 1;
    int i1;
    if ((DeviceInfoUtil.c() >>> 20 < 600L) || (DeviceInfoUtil.b() == 1)) {
      i1 = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "getDeviceType,DeviceInfoUtil.getSystemTotalMemory() =" + (DeviceInfoUtil.c() >>> 20) + ",DeviceInfoUtil.getCpuNumber() = " + DeviceInfoUtil.b() + ",phoneType = " + i1);
      }
      return i1;
      i1 = i2;
      if (DeviceInfoUtil.c() >>> 20 >= 1536.0D)
      {
        i1 = i2;
        if (DeviceInfoUtil.b() == 4) {
          i1 = 2;
        }
      }
    }
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times", i1 + 1).commit();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatisticConstants", 2, "sendPhotoPreviewSelectRateStatistic (" + paramInt1 + " ," + paramInt2 + ")");
    }
    SharedPreferences localSharedPreferences;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = localSharedPreferences.getLong("PhotoConst.last_send_select_rate_time_preview", 0L);
      long l2 = System.currentTimeMillis();
      paramInt1 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_count", 0) + paramInt1;
      paramInt2 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0) + paramInt2;
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_count", paramInt1 + "");
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_rate", paramInt1 / paramInt2 + "");
        StatisticCollector.a(BaseApplication.getContext()).a(null, "PhotoConst.photopreviewactivity_send", false, 0L, 0L, localHashMap, "", false);
        localSharedPreferences.edit().putLong("PhotoConst.last_send_select_rate_time_preview", l2).putInt("PhotoConst.photopreviewactivity_send_pic_count", 0).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photopreviewactivity_send_pic_count", paramInt1).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", paramInt2).commit();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + ")");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_pic_source_type", 0L);
    long l2 = System.currentTimeMillis();
    paramInt1 = localSharedPreferences.getInt("PhotoConst.photolistactivity_systemalbum_send_count", 0) + paramInt1;
    paramInt2 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0) + paramInt2;
    paramInt3 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0) + paramInt3;
    paramInt5 = localSharedPreferences.getInt("PhotoConst.photolistactivity_other_send_count", 0) + paramInt5;
    paramInt4 = localSharedPreferences.getInt("PhotoConst.photolistactivity_app_send_count", 0) + paramInt4;
    paramInt6 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_collection_send_count", 0) + paramInt6;
    paramInt7 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_image_send_count", 0) + paramInt7;
    paramInt8 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0) + paramInt8;
    paramInt9 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0) + paramInt9;
    paramInt10 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0) + paramInt10;
    paramInt11 = localSharedPreferences.getInt("PhotoConst.photolistactivity_weixin_send_count", 0) + paramInt11;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumSendCount", paramInt1 + "");
      localHashMap.put("param_screnshotQQSendCount", paramInt2 + "");
      localHashMap.put("param_screnshotOtherSendCount", paramInt3 + "");
      localHashMap.put("param_otherSendCount", paramInt5 + "");
      localHashMap.put("param_appSendCount", paramInt4 + "");
      localHashMap.put("param_qq_collection_SendCount", paramInt6 + "");
      localHashMap.put("param_qq_image_SendCount", paramInt7 + "");
      localHashMap.put("param_qq_filerecv_SendCount", paramInt8 + "");
      localHashMap.put("param_qq_zebra_SendCount", paramInt9 + "");
      localHashMap.put("param_qq_favorite_SendCount", paramInt10 + "");
      localHashMap.put("param_weixinSendCount", paramInt11 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actDaySendPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_pic_source_type", l2).putInt("PhotoConst.photolistactivity_systemalbum_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0).putInt("PhotoConst.photolistactivity_other_send_count", 0).putInt("PhotoConst.photolistactivity_app_send_count", 0).putInt("PhotoConst.photolistactivity_qq_collection_send_count", 0).putInt("PhotoConst.photolistactivity_qq_image_send_count", 0).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0).putInt("PhotoConst.photolistactivity_weixin_send_count", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photolistactivity_systemalbum_send_count", paramInt1).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", paramInt2).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", paramInt3).putInt("PhotoConst.photolistactivity_other_send_count", paramInt5).putInt("PhotoConst.photolistactivity_app_send_count", paramInt4).putInt("PhotoConst.photolistactivity_qq_collection_send_count", paramInt6).putInt("PhotoConst.photolistactivity_qq_image_send_count", paramInt7).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", paramInt8).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", paramInt9).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", paramInt10).putInt("PhotoConst.photolistactivity_weixin_send_count", paramInt11).commit();
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,size <= 0,return! size = " + paramLong);
      }
    }
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_WasteSize", paramLong + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdayWastedSize", false, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,WastedSize =" + paramLong);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong == 0L) || (paramInt == 0) || (paramLong > 86400000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,invalid arg,return!");
      }
    }
    long l1;
    do
    {
      return;
      l1 = paramLong / paramInt;
      localHashMap.put("param_consumTime", paramLong + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_showing_progress", paramBoolean + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdonecompressPic", false, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,param_consumTime =" + paramLong + ",param_selNum = " + paramInt + ",param_averageTime = " + l1 + ",isShowing = " + paramBoolean);
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong1 > 86400000L) || (paramDouble < 0.0D) || (paramDouble > 1.0D)) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,invalid arg,return!");
      }
    }
    int i2;
    do
    {
      return;
      int i1 = NetworkUtil.a(BaseApplication.getContext());
      i2 = a();
      localHashMap.put("param_netType", i1 + "");
      localHashMap.put("param_aio_duration", paramLong1 + "");
      localHashMap.put("param_second_trans", paramBoolean + "");
      localHashMap.put("param_phone_type", i2 + "");
      localHashMap.put("param_pic_filesize", paramLong2 + "");
      localHashMap.put("param_optimizePercent", paramDouble + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdoneaioduration", false, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,aioduration =" + paramLong1 + ",filesize = " + paramLong2 + ",isSecondTrans = " + paramBoolean + ",phoneType = " + i2 + ",percent = " + paramDouble);
  }
  
  public static void a(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    long l1 = paramIntent.getLongExtra("param_compressInitTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPScompressPic,initTime == 0,return!");
      }
    }
    long l2;
    int i1;
    do
    {
      do
      {
        return;
        l2 = System.currentTimeMillis() - l1;
      } while (l2 > 86400000L);
      i1 = paramIntent.getIntExtra("param_selNum", 0);
      if (i1 != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_selNum == 0,return!");
    return;
    if (i1 > 0) {}
    for (l1 = l2 / i1;; l1 = 0L)
    {
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", i1 + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPScompressPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_compressInitTime");
      paramIntent.removeExtra("param_selNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_consumTime =" + l2 + ",param_selNum = " + i1 + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSelectRateStatistic (" + paramInt + ")");
    }
    int i1 = paramIntent.getIntExtra("param_totalSelNum", 0);
    if ((paramInt > 0) && (i1 > 0))
    {
      paramIntent = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = paramIntent.getLong("PhotoConst.last_send_select_rate_time", 0L);
      long l2 = System.currentTimeMillis();
      paramInt = paramIntent.getInt("PhotoConst.photolistactivity_pic_count", 0) + paramInt;
      i1 += paramIntent.getInt("PhotoConst.photolistactivity_pic_total_count", 0);
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_sendCount", paramInt + "");
        localHashMap.put("param_selCount", i1 + "");
        localHashMap.put("param_sendPercent", paramInt / i1 + "");
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdaySelSend", false, 0L, 0L, localHashMap, "", false);
        paramIntent.edit().putLong("PhotoConst.last_send_select_rate_time", l2).putInt("PhotoConst.photolistactivity_pic_count", 0).putInt("PhotoConst.photolistactivity_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    paramIntent.edit().putInt("PhotoConst.photolistactivity_pic_count", paramInt).putInt("PhotoConst.photolistactivity_pic_total_count", i1).commit();
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    long l1 = paramIntent.getLongExtra("param_initTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,initTime == 0,return!");
      }
    }
    long l2;
    do
    {
      return;
      l2 = System.currentTimeMillis() - l1;
    } while (l2 > 86400000L);
    if (paramInt1 > 0) {}
    for (l1 = l2 / paramInt1;; l1 = 0L)
    {
      int i1 = paramIntent.getIntExtra("param_cancelSelNum", 0);
      HashMap localHashMap = new HashMap();
      int i2 = NetworkUtil.a(BaseApplication.getContext());
      localHashMap.put("param_netType", i2 + "");
      localHashMap.put("param_type", paramInt2 + "");
      localHashMap.put("param_cancelSelNum", i1 + "");
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", paramInt1 + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSselectSendPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,param_type =" + paramInt2 + ",param_cancelSelNum = " + i1 + ",param_consumTime = " + l2 + ",param_selNum = " + paramInt1 + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "incrementStatisticParam(" + paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra(paramString, paramIntent.getIntExtra(paramString, 0) + 1);
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: bipush 67
    //   8: invokevirtual 565	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11: checkcast 567	com/tencent/mobileqq/dating/DatingManager
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +896 -> 912
    //   19: aload_2
    //   20: invokevirtual 569	com/tencent/mobileqq/dating/DatingManager:c	()I
    //   23: istore 4
    //   25: aload_2
    //   26: invokevirtual 570	com/tencent/mobileqq/dating/DatingManager:b	()I
    //   29: istore_3
    //   30: new 572	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 573	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: iconst_1
    //   40: putfield 576	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   43: aload_0
    //   44: aload_2
    //   45: invokestatic 582	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload_2
    //   50: getfield 585	android/graphics/BitmapFactory$Options:outWidth	I
    //   53: istore 6
    //   55: aload_2
    //   56: getfield 588	android/graphics/BitmapFactory$Options:outHeight	I
    //   59: istore 7
    //   61: iload 6
    //   63: i2l
    //   64: iload 7
    //   66: i2l
    //   67: invokestatic 593	com/tencent/mobileqq/richmedia/dc/PhotoUtils:a	(JJ)I
    //   70: istore 8
    //   72: iload_1
    //   73: istore 5
    //   75: iload_1
    //   76: ifeq +24 -> 100
    //   79: iload_1
    //   80: istore 5
    //   82: iload_1
    //   83: iconst_1
    //   84: if_icmpeq +16 -> 100
    //   87: iload_1
    //   88: istore 5
    //   90: iload_1
    //   91: sipush 3000
    //   94: if_icmpeq +6 -> 100
    //   97: iconst_5
    //   98: istore 5
    //   100: aconst_null
    //   101: astore 16
    //   103: new 595	java/io/FileInputStream
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 597	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: astore 15
    //   113: aload 15
    //   115: new 599	java/io/File
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 600	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: invokevirtual 603	java/io/File:length	()J
    //   126: invokestatic 609	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   129: astore_2
    //   130: aload_2
    //   131: invokestatic 615	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   134: astore_2
    //   135: aload_2
    //   136: astore 16
    //   138: aload 16
    //   140: astore_2
    //   141: aload 15
    //   143: ifnull +11 -> 154
    //   146: aload 15
    //   148: invokevirtual 618	java/io/FileInputStream:close	()V
    //   151: aload 16
    //   153: astore_2
    //   154: aload_0
    //   155: invokestatic 623	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 15
    //   160: aload 15
    //   162: invokevirtual 628	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   165: ldc_w 630
    //   168: invokevirtual 634	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +701 -> 872
    //   174: iconst_0
    //   175: istore_1
    //   176: invokestatic 640	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   179: bipush 11
    //   181: invokevirtual 644	java/util/Calendar:get	(I)I
    //   184: istore 9
    //   186: invokestatic 472	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   189: ifeq +149 -> 338
    //   192: ldc 89
    //   194: iconst_4
    //   195: new 371	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 646
    //   205: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 648
    //   215: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 5
    //   220: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: ldc_w 650
    //   226: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 8
    //   231: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 652
    //   237: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: iload 4
    //   242: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: ldc_w 654
    //   248: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload_3
    //   252: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 656
    //   258: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload 9
    //   263: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 658
    //   269: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_2
    //   273: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 660
    //   279: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload_1
    //   283: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: ldc_w 662
    //   289: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 15
    //   294: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 664
    //   300: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: invokestatic 667	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc_w 669
    //   313: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: iload 6
    //   318: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: ldc_w 671
    //   324: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload 7
    //   329: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 395	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: new 446	java/util/HashMap
    //   341: dup
    //   342: invokespecial 447	java/util/HashMap:<init>	()V
    //   345: astore_0
    //   346: aload_0
    //   347: ldc 101
    //   349: new 371	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   356: iload 5
    //   358: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: ldc_w 449
    //   364: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: aload_0
    //   375: ldc 107
    //   377: new 371	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   384: iload 8
    //   386: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: ldc_w 449
    //   392: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: pop
    //   402: aload_0
    //   403: ldc 113
    //   405: new 371	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   412: iload 4
    //   414: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: ldc_w 449
    //   420: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   429: pop
    //   430: aload_0
    //   431: ldc 116
    //   433: new 371	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   440: iload_3
    //   441: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 449
    //   447: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   456: pop
    //   457: aload_0
    //   458: ldc 122
    //   460: new 371	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   467: aload_2
    //   468: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc_w 449
    //   474: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   483: pop
    //   484: aload_0
    //   485: ldc 119
    //   487: new 371	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   494: iload_1
    //   495: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: ldc_w 449
    //   501: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   510: pop
    //   511: aload_0
    //   512: ldc 125
    //   514: new 371	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   521: iload 9
    //   523: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: ldc_w 449
    //   529: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   538: pop
    //   539: invokestatic 403	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   542: invokestatic 461	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   545: aconst_null
    //   546: ldc_w 260
    //   549: iconst_0
    //   550: lconst_0
    //   551: lconst_0
    //   552: aload_0
    //   553: ldc_w 449
    //   556: iconst_0
    //   557: invokevirtual 464	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   560: invokestatic 403	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   563: invokestatic 409	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   566: astore_0
    //   567: aload_0
    //   568: ldc_w 291
    //   571: lconst_0
    //   572: invokeinterface 439 4 0
    //   577: lstore 10
    //   579: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   582: lstore 12
    //   584: aload_0
    //   585: ldc_w 345
    //   588: iconst_0
    //   589: invokeinterface 415 3 0
    //   594: iconst_1
    //   595: iadd
    //   596: istore_1
    //   597: lload 12
    //   599: lload 10
    //   601: lsub
    //   602: ldc2_w 86
    //   605: lcmp
    //   606: ifle +271 -> 877
    //   609: new 446	java/util/HashMap
    //   612: dup
    //   613: invokespecial 447	java/util/HashMap:<init>	()V
    //   616: astore_2
    //   617: aload_2
    //   618: ldc 113
    //   620: new 371	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   627: iload 4
    //   629: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: ldc_w 449
    //   635: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   644: pop
    //   645: aload_2
    //   646: ldc 116
    //   648: new 371	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   655: iload_3
    //   656: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   659: ldc_w 449
    //   662: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   671: pop
    //   672: aload_2
    //   673: ldc 173
    //   675: new 371	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   682: iload_1
    //   683: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   686: ldc_w 449
    //   689: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokevirtual 453	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   698: pop
    //   699: invokestatic 403	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   702: invokestatic 461	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   705: aconst_null
    //   706: ldc_w 263
    //   709: iconst_0
    //   710: lconst_0
    //   711: lconst_0
    //   712: aload_2
    //   713: ldc_w 449
    //   716: iconst_0
    //   717: invokevirtual 464	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   720: aload_0
    //   721: invokeinterface 419 1 0
    //   726: ldc_w 291
    //   729: lload 12
    //   731: invokeinterface 468 4 0
    //   736: ldc_w 345
    //   739: iconst_0
    //   740: invokeinterface 425 3 0
    //   745: invokeinterface 428 1 0
    //   750: pop
    //   751: return
    //   752: astore_2
    //   753: new 599	java/io/File
    //   756: dup
    //   757: aload_0
    //   758: invokespecial 600	java/io/File:<init>	(Ljava/lang/String;)V
    //   761: astore_2
    //   762: aload_2
    //   763: invokevirtual 674	java/io/File:exists	()Z
    //   766: istore 14
    //   768: iload 14
    //   770: ifeq +137 -> 907
    //   773: aload_2
    //   774: invokestatic 679	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   777: astore_2
    //   778: aload_2
    //   779: ifnull +11 -> 790
    //   782: aload_2
    //   783: invokestatic 683	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   786: astore_2
    //   787: goto -657 -> 130
    //   790: ldc_w 449
    //   793: astore_2
    //   794: goto -12 -> 782
    //   797: astore_2
    //   798: aconst_null
    //   799: astore_2
    //   800: goto -670 -> 130
    //   803: astore_2
    //   804: aload_2
    //   805: invokevirtual 686	java/io/IOException:printStackTrace	()V
    //   808: aload 16
    //   810: astore_2
    //   811: goto -657 -> 154
    //   814: astore_2
    //   815: aconst_null
    //   816: astore 15
    //   818: aload 16
    //   820: astore_2
    //   821: aload 15
    //   823: ifnull -669 -> 154
    //   826: aload 15
    //   828: invokevirtual 618	java/io/FileInputStream:close	()V
    //   831: aload 16
    //   833: astore_2
    //   834: goto -680 -> 154
    //   837: astore_2
    //   838: aload_2
    //   839: invokevirtual 686	java/io/IOException:printStackTrace	()V
    //   842: aload 16
    //   844: astore_2
    //   845: goto -691 -> 154
    //   848: astore_0
    //   849: aconst_null
    //   850: astore 15
    //   852: aload 15
    //   854: ifnull +8 -> 862
    //   857: aload 15
    //   859: invokevirtual 618	java/io/FileInputStream:close	()V
    //   862: aload_0
    //   863: athrow
    //   864: astore_2
    //   865: aload_2
    //   866: invokevirtual 686	java/io/IOException:printStackTrace	()V
    //   869: goto -7 -> 862
    //   872: iconst_1
    //   873: istore_1
    //   874: goto -698 -> 176
    //   877: aload_0
    //   878: invokeinterface 419 1 0
    //   883: ldc_w 345
    //   886: iload_1
    //   887: invokeinterface 425 3 0
    //   892: invokeinterface 428 1 0
    //   897: pop
    //   898: return
    //   899: astore_0
    //   900: goto -48 -> 852
    //   903: astore_2
    //   904: goto -86 -> 818
    //   907: aconst_null
    //   908: astore_2
    //   909: goto -779 -> 130
    //   912: iconst_m1
    //   913: istore_3
    //   914: iconst_m1
    //   915: istore 4
    //   917: goto -887 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	920	0	paramString	String
    //   0	920	1	paramInt	int
    //   0	920	2	paramQQAppInterface	QQAppInterface
    //   29	885	3	i1	int
    //   23	893	4	i2	int
    //   73	284	5	i3	int
    //   53	264	6	i4	int
    //   59	269	7	i5	int
    //   70	315	8	i6	int
    //   184	338	9	i7	int
    //   577	23	10	l1	long
    //   582	148	12	l2	long
    //   766	3	14	bool	boolean
    //   111	747	15	localObject	Object
    //   101	742	16	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   113	130	752	java/lang/UnsatisfiedLinkError
    //   773	778	797	java/io/IOException
    //   782	787	797	java/io/IOException
    //   146	151	803	java/io/IOException
    //   103	113	814	java/io/IOException
    //   826	831	837	java/io/IOException
    //   103	113	848	finally
    //   857	862	864	java/io/IOException
    //   113	130	899	finally
    //   130	135	899	finally
    //   753	768	899	finally
    //   773	778	899	finally
    //   782	787	899	finally
    //   113	130	903	java/io/IOException
    //   130	135	903	java/io/IOException
    //   753	768	903	java/io/IOException
  }
  
  private static void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramString == null) {
      return;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    int i6 = ((BitmapFactory.Options)localObject1).outWidth;
    int i7 = ((BitmapFactory.Options)localObject1).outHeight;
    int i8 = PhotoUtils.a(i6, i7);
    int i2 = paramInt1;
    if (paramInt1 != 0)
    {
      i2 = paramInt1;
      if (paramInt1 != 1)
      {
        i2 = paramInt1;
        if (paramInt1 != 3000) {
          i2 = 5;
        }
      }
    }
    int i3 = paramInt2;
    if (paramInt2 != 0)
    {
      i3 = paramInt2;
      if (paramInt2 != 1)
      {
        i3 = paramInt2;
        if (paramInt2 != 3000) {
          i3 = 5;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = Environment.getExternalStorageDirectory().toString();
        if ((localObject1 != null) && (paramString.contains((CharSequence)localObject1)))
        {
          localObject1 = paramString.replace((CharSequence)localObject1, "");
          paramInt1 = ((String)localObject1).lastIndexOf("/");
          Object localObject2 = localObject1;
          if (paramInt1 != -1) {
            localObject2 = ((String)localObject1).substring(0, paramInt1);
          }
          localObject1 = ((String)localObject2).replace("/", "//");
          int i9 = Calendar.getInstance().get(11);
          paramInt2 = -1;
          paramInt1 = paramInt2;
          if (!paramBoolean)
          {
            paramInt1 = paramInt2;
            if (new File(paramString).exists())
            {
              paramInt2 = (int)((System.currentTimeMillis() - new File(paramString).lastModified()) / 60000L);
              paramInt1 = paramInt2;
              if (paramInt2 == 0) {
                paramInt1 = 1;
              }
            }
          }
          int i1;
          if (paramString.toLowerCase().contains("gif"))
          {
            i1 = 0;
            paramInt2 = i1;
            int i4 = i7;
            int i5 = i6;
            if (paramString.contains(AppConstants.aL))
            {
              paramString = paramString.split("#");
              paramInt2 = i1;
              i4 = i7;
              i5 = i6;
              if (paramString.length >= 4)
              {
                i5 = Integer.parseInt(paramString[1]);
                i4 = Integer.parseInt(paramString[2]);
                if (Integer.parseInt(paramString[3]) != 3) {
                  continue;
                }
                paramInt2 = 0;
              }
            }
            i1 = NetworkUtil.a(BaseApplication.getContext());
            if (QLog.isDevelopLevel()) {
              QLog.d("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic url=" + (String)localObject1 + ",uinType = " + i2 + ",sizeType = " + i8 + ",isForward = " + paramBoolean + ",age = " + paramInt3 + ",gender = " + paramInt4 + ",reprotHour = " + i9 + ",width = " + i5 + ",height = " + i4 + ",interval = " + paramInt1 + ",suffixType = " + paramInt2 + ",nettype = " + i1 + ",forwardSourceUinType = " + i3 + ",urlType = " + paramInt5);
            }
            paramString = new HashMap();
            paramString.put("param_sourceDetailUrl", localObject1);
            paramString.put("param_uinType", i2 + "");
            paramString.put("param_forwardSourceUinType", i3 + "");
            paramString.put("param_picSizeType", i8 + "");
            paramString.put("param_isForward", paramBoolean + "");
            paramString.put("param_age", paramInt3 + "");
            paramString.put("param_gender", paramInt4 + "");
            paramString.put("param_picReportHour", i9 + "");
            paramString.put("param_picInterval", paramInt1 + "");
            paramString.put("param_picSuffixType", paramInt2 + "");
            paramString.put("param_netType", i1 + "");
            paramString.put("param_urlType", paramInt5 + "");
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actPhotoSourceDetailUrl", false, 0L, 0L, paramString, "", false);
          }
          else
          {
            i1 = 1;
            continue;
          }
          paramInt2 = 1;
          continue;
        }
        localObject1 = paramString;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    a(new String[] { paramString }, paramInt1, paramBoolean, paramInt2, paramQQAppInterface);
  }
  
  public static void a(String[] paramArrayOfString, int paramInt1, boolean paramBoolean, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfString == null) {}
    label158:
    do
    {
      return;
      paramQQAppInterface = (DatingManager)paramQQAppInterface.getManager(67);
      int i14 = -1;
      int i15 = -1;
      if (paramQQAppInterface != null)
      {
        i14 = paramQQAppInterface.c();
        i15 = paramQQAppInterface.b();
      }
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      int i5 = 0;
      int i12 = 0;
      int i7 = 0;
      int i1 = 0;
      int i8 = 0;
      int i9 = 0;
      int i10 = 0;
      int i11 = 0;
      int i19 = paramArrayOfString.length;
      int i16 = 0;
      String str2;
      int i13;
      String str1;
      String str3;
      while (i16 < i19)
      {
        str2 = paramArrayOfString[i16];
        if (str2 == null)
        {
          i13 = i7;
          i16 += 1;
          i7 = i13;
        }
        else
        {
          str1 = str2.toLowerCase(Locale.US);
          str3 = FileUtil.b(str1);
          paramQQAppInterface = null;
        }
      }
      try
      {
        str1 = new File(str1).getParentFile().getName();
        paramQQAppInterface = str1;
      }
      catch (Exception localException)
      {
        int i6;
        int i17;
        break label158;
      }
    } while ((str3 == null) || (paramQQAppInterface == null));
    if (str3.contains("/tencent/")) {
      if (str3.contains("/qq_collection/"))
      {
        i13 = i7 + 1;
        i6 = i4;
        i4 = i2;
        i2 = i5;
        i17 = 1001;
        i5 = i4;
        i4 = i3;
        i3 = i6;
        i7 = i12;
        i6 = i17;
      }
    }
    for (;;)
    {
      a(str2, paramInt1, paramBoolean, paramInt2, i14, i15, i6);
      i6 = i2;
      i12 = i3;
      i3 = i4;
      i2 = i5;
      i4 = i12;
      i5 = i6;
      i12 = i7;
      break;
      int i18;
      if ((paramQQAppInterface.equals("qq_images")) || (str3.contains("/mobileqq/photo")) || (str3.contains("/mobileqq/diskcache")) || (str3.contains("/AIO_FORWARD/")))
      {
        i1 += 1;
        i6 = 1002;
        i17 = i3;
        i18 = i2;
        i2 = i5;
        i13 = i7;
        i7 = i12;
        i3 = i4;
        i4 = i17;
        i5 = i18;
      }
      else if (paramQQAppInterface.equals("qqfile_recv"))
      {
        i17 = i3;
        i18 = i2;
        i2 = i5;
        i8 += 1;
        i6 = 1003;
        i13 = i7;
        i7 = i12;
        i3 = i4;
        i4 = i17;
        i5 = i18;
      }
      else if (paramQQAppInterface.equals("qq_favorite"))
      {
        i17 = i3;
        i18 = i2;
        i2 = i5;
        i10 += 1;
        i6 = 1004;
        i13 = i7;
        i7 = i12;
        i3 = i4;
        i4 = i17;
        i5 = i18;
      }
      else if (str3.contains("/zebra/cache"))
      {
        i17 = i3;
        i18 = i2;
        i2 = i5;
        i9 += 1;
        i6 = 1005;
        i13 = i7;
        i7 = i12;
        i3 = i4;
        i4 = i17;
        i5 = i18;
      }
      else if ((paramQQAppInterface.equals("weixin")) || (paramQQAppInterface.equals("wechat")) || (paramQQAppInterface.equals("micromsg")))
      {
        i17 = i3;
        i18 = i2;
        i2 = i5;
        i11 += 1;
        i6 = 1006;
        i13 = i7;
        i7 = i12;
        i3 = i4;
        i4 = i17;
        i5 = i18;
      }
      else if (a(str3))
      {
        i17 = i3;
        i18 = i2;
        i2 = i5 + 1;
        i6 = 1007;
        i13 = i7;
        i7 = i12;
        i3 = i4;
        i4 = i17;
        i5 = i18;
      }
      else
      {
        i18 = i12 + 1;
        i12 = i3;
        i17 = i2;
        i2 = i5;
        i6 = 1008;
        i13 = i7;
        i7 = i18;
        i3 = i4;
        i4 = i12;
        i5 = i17;
        continue;
        if (paramQQAppInterface.equals("qq_screenshot"))
        {
          i18 = i3 + 1;
          i17 = i2;
          i2 = i5;
          i6 = 1009;
          i13 = i7;
          i7 = i12;
          i3 = i4;
          i4 = i18;
          i5 = i17;
        }
        else if ((str3.contains("screenshot")) || (str3.contains("截屏")) || (str3.contains("截图")) || (str3.equals("screen_cap")) || (str3.equals("ScreenCapture")))
        {
          i18 = i4 + 1;
          i4 = i3;
          i17 = i2;
          i2 = i5;
          i6 = 1010;
          i13 = i7;
          i7 = i12;
          i3 = i18;
          i5 = i17;
        }
        else if ((paramQQAppInterface.contains("camera")) || (paramQQAppInterface.equals("dcim")) || (paramQQAppInterface.equals("100MEDIA")) || (paramQQAppInterface.equals("100ANDRO")) || (paramQQAppInterface.contains("相机")) || (paramQQAppInterface.contains("照片")) || (paramQQAppInterface.contains("相片")))
        {
          i17 = i3;
          i18 = i2 + 1;
          i2 = i5;
          i6 = 1011;
          i13 = i7;
          i7 = i12;
          i3 = i4;
          i4 = i17;
          i5 = i18;
        }
        else if (a(str3))
        {
          i17 = i3;
          i18 = i2;
          i2 = i5 + 1;
          i6 = 1007;
          i13 = i7;
          i7 = i12;
          i3 = i4;
          i4 = i17;
          i5 = i18;
        }
        else
        {
          i18 = i12 + 1;
          i12 = i3;
          i17 = i2;
          i2 = i5;
          i6 = 1008;
          i13 = i7;
          i7 = i18;
          i3 = i4;
          i4 = i12;
          i5 = i17;
        }
      }
    }
    a(i2, i3, i4, i5, i12, i7, i1, i8, i9, i10, i11);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = new String[14];
      arrayOfString[0] = "/weibo";
      arrayOfString[1] = "/sina/news/save/";
      arrayOfString[2] = "/faceq/";
      arrayOfString[3] = "/newsreader/";
      arrayOfString[4] = "/tieba";
      arrayOfString[5] = "/baidu";
      arrayOfString[6] = "/UCDownloads";
      arrayOfString[7] = "/taobao";
      arrayOfString[8] = "/news_article/";
      arrayOfString[9] = "/sohunewsdown/";
      arrayOfString[10] = "/pitu/";
      arrayOfString[11] = "/pins/";
      arrayOfString[12] = "/tumblr/";
      arrayOfString[13] = "/download";
      int i1 = 0;
      while (i1 < arrayOfString.length)
      {
        if (paramString.contains(arrayOfString[i1])) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendNomalCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate", 0L);
    long l2 = System.currentTimeMillis();
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i1 + "");
      int i2 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
      localHashMap.put("param_cameraCount", i2 + "");
      if (i2 > 0) {
        localHashMap.put("param_sendPercent", i1 / i2 + "");
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdayCameraSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate", l2).putInt("PhotoConst.camerapreviewactivity_send_times", 0).putInt("PhotoConst.camerapreviewactivity_enter_times", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times", i1).commit();
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "userAlbumSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + ")");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_album_source_type", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumCount", paramInt1 + "");
      localHashMap.put("param_screnshot_qq_cnt", paramInt2 + "");
      localHashMap.put("param_screnshot_other_cnt", paramInt3 + "");
      localHashMap.put("param_appCount", paramInt4 + "");
      localHashMap.put("param_otherCount", paramInt5 + "");
      localHashMap.put("param_qq_collection_cnt", paramInt6 + "");
      localHashMap.put("param_qq_filerecv_cnt", paramInt8 + "");
      localHashMap.put("param_qq_image_cnt", paramInt7 + "");
      localHashMap.put("param_qq_zebra_cnt", paramInt9 + "");
      localHashMap.put("param_qq_favorite_cnt", paramInt10 + "");
      localHashMap.put("param_weixinCnt", paramInt11 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actAlbumPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_album_source_type", l2).commit();
    }
  }
  
  public static void b(long paramLong)
  {
    if (paramLong <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSprogressTime,size <= 0,return! duration = " + paramLong);
      }
    }
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_consumTime", paramLong + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSprogressTime", false, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPSprogressTime,WastedSize =" + paramLong);
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    if (!paramIntent.hasExtra("param_initTime")) {}
    long l1;
    do
    {
      do
      {
        do
        {
          return;
          l1 = paramIntent.getLongExtra("param_initTime", 0L);
          if (l1 != 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("StatisticConstants", 2, "reportActPScancelSend,initTime == 0,return!");
        return;
        l1 = System.currentTimeMillis() - l1;
      } while (l1 > 86400000L);
      HashMap localHashMap = new HashMap();
      int i1 = NetworkUtil.a(BaseApplication.getContext());
      localHashMap.put("param_netType", i1 + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_residentTime", l1 + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPScancelSend", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScancelSend,param_residentTime =" + l1 + ",param_selNum = " + paramInt);
  }
  
  public static void c()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times_fast", i1 + 1).commit();
  }
  
  public static void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendFastImageCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate_fast", 0L);
    long l2 = System.currentTimeMillis();
    int i1 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times_fast", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i1 + "");
      int i2 = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
      localHashMap.put("param_browseCount", i2 + "");
      if (i2 > 0) {
        localHashMap.put("param_sendPercent", i1 / i2 + "");
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPSdayQuickSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate_fast", l2).putInt("PhotoConst.camerapreviewactivity_send_times_fast", 0).putInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times_fast", i1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.StatisticConstants
 * JD-Core Version:    0.7.0.1
 */