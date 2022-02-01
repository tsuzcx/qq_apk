package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarShareActivity;
import com.tencent.qphone.base.util.QLog;

public class TroopBarShareUtils
{
  public static final String a = "troopbar_share";
  public static final String b = "share_app_id";
  public static final String c = "share_app_name";
  public static final String d = "Grp_share";
  public static final String e = "to_tribe";
  public static final String f = "share_ask";
  public static final String g = "share_suc";
  public static final String h = "suc_app";
  public static final String i = "suc_tribe";
  
  public static String a()
  {
    return "https://xiaoqu.qq.com/mobile/index.html?_wv=5123&_bid=128";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "https://xiaoqu.qq.com/mobile/detail.html?_wv=5123&_bid=128#bid=" + paramString1 + "&pid=" + paramString2;
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "notifySDKCanceled:" + paramLong);
    }
    ForwardOperations.a(paramContext, false, "shareToTroopBar", paramLong);
  }
  
  public static void a(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    paramString3 = a(paramString2, paramString3);
    Intent localIntent = new Intent(paramContext, TroopBarShareActivity.class);
    localIntent.putExtra("share_app_name", paramString1);
    localIntent.putExtra("share_app_id", paramLong);
    localIntent.putExtra("url", paramString3);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("bid", paramString2);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "openTopicDetail:" + paramString1 + ", " + paramLong + ", " + paramString3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_share", "", "to_tribe", paramString1, 0, 0, paramString2, "1", null, null);
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "notifySDKCompleted:" + paramLong);
    }
    ForwardOperations.a(paramContext, true, "shareToTroopBar", paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TroopBarShareUtils
 * JD-Core Version:    0.7.0.1
 */