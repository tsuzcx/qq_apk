package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import krb;

public final class AvatarPendantUtil
{
  public static final int a = 1;
  private static final String a = "AvatarPendantUtil";
  public static Vector a;
  public static ConcurrentHashMap a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 1;
  public static final int j = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  public static String a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.bm).append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("aio_static_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("aio_file");
      continue;
      localStringBuilder.append("market_static_50.png");
      continue;
      localStringBuilder.append("market_dynamic_50.gif");
      continue;
      localStringBuilder.append("thumbnail_50.png");
      continue;
      localStringBuilder.append("config.json");
      continue;
      localStringBuilder.append("crop_portrait.png");
    }
  }
  
  public static String a(File paramFile)
  {
    String str2 = "";
    String str1 = str2;
    if (paramFile != null)
    {
      str1 = str2;
      if (!paramFile.exists()) {}
    }
    try
    {
      paramFile = new String(FileUtils.a(paramFile));
      int k = paramFile.indexOf("\"seriesID\":");
      str1 = str2;
      if (k != -1)
      {
        int m = paramFile.indexOf(",", k + 10);
        str1 = str2;
        if (m != -1) {
          str1 = paramFile.substring(k + 11, m);
        }
      }
      return str1;
    }
    catch (Exception paramFile) {}
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilVector == null) || (jdField_a_of_type_JavaUtilVector.size() == 0)) {
      return;
    }
    ThreadManager.a(new krb(paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, AvatarPendantMarketActivity.class);
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    int k = localGameCenterManagerImp.a("100005.100006");
    RedTouchManager localRedTouchManager;
    int m;
    int n;
    label117:
    int i1;
    label131:
    int i2;
    label145:
    int i3;
    label159:
    int i4;
    if ((k == 1) || (k == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "Clear pendant red flag");
      }
      localIntent.putExtra("key_update_flag", true);
      localRedTouchManager = (RedTouchManager)paramQQAppInterface.getManager(35);
      localRedTouchManager.b("100005.100006");
      if (localGameCenterManagerImp.a("100005.100003") == -1) {
        break label374;
      }
      m = 1;
      if (localGameCenterManagerImp.a("100005.100002") == -1) {
        break label379;
      }
      n = 1;
      if (localGameCenterManagerImp.a("100005.100001") == -1) {
        break label385;
      }
      i1 = 1;
      if (localGameCenterManagerImp.a("100005.100018") == -1) {
        break label391;
      }
      i2 = 1;
      if (localGameCenterManagerImp.a("100005.100020") == -1) {
        break label397;
      }
      i3 = 1;
      if (localGameCenterManagerImp.a("100005.100021") == -1) {
        break label403;
      }
      i4 = 1;
      label173:
      if (!((FontManager)paramQQAppInterface.getManager(41)).a) {
        break label414;
      }
      if (localGameCenterManagerImp.a("100005.100011") == -1) {
        break label409;
      }
      k = 1;
    }
    for (;;)
    {
      if ((m == 0) && (n == 0) && (i1 == 0) && (i2 == 0) && (k == 0) && (i3 == 0) && (i4 == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear parent red flag");
        }
        BusinessInfoCheckUpdateItem.a(paramQQAppInterface, "100005", false);
        localRedTouchManager.b("100005");
      }
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", VasWebviewConstants.AVATAR_PENDANT_URL);
      localIntent.putExtra("business", 512L);
      localIntent.putExtra("individuation_url_type", 200);
      VasWebviewUtil.a(512L, localIntent);
      localIntent.putExtra("isShowAd", false);
      paramContext.startActivity(localIntent);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
      return;
      label374:
      m = 0;
      break;
      label379:
      n = 0;
      break label117;
      label385:
      i1 = 0;
      break label131;
      label391:
      i2 = 0;
      break label145;
      label397:
      i3 = 0;
      break label159;
      label403:
      i4 = 0;
      break label173;
      label409:
      k = 0;
      continue;
      label414:
      k = 0;
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    while (jdField_a_of_type_JavaUtilVector.contains(paramString)) {
      return;
    }
    jdField_a_of_type_JavaUtilVector.add(paramString);
  }
  
  public static boolean a(long paramLong)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localInteger == null) {
      return true;
    }
    if (localInteger.intValue() == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String b(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipFaceAddon_").append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return EmosmUtils.insertMtype("VIP_avatar", localStringBuilder.toString());
      localStringBuilder.append("aio_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("preview_50.png");
      continue;
      localStringBuilder.append("preview_50.gif");
      continue;
      localStringBuilder.append("thumb_nail_50.png");
      continue;
      localStringBuilder.append("xydata.js");
      continue;
      localStringBuilder.append("avatarfit.png");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AvatarPendantUtil
 * JD-Core Version:    0.7.0.1
 */