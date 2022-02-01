package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.TenpayActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import java.net.URLEncoder;

public class QRResultHandler
{
  static final String a = "https://qm.qq.com/cgi-bin/result";
  private static final String b = "mqqapi://card/show_pslcard";
  
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, QRActionEntity paramQRActionEntity, String paramString, Bundle paramBundle)
  {
    if ((paramQRActionEntity == null) || (paramQRActionEntity.a() == 0))
    {
      a(paramQQAppInterface, paramActivity, paramString);
      return 0;
    }
    for (;;)
    {
      try
      {
        switch (paramQRActionEntity.r)
        {
        case 5: 
          a(paramQQAppInterface, paramActivity, paramString);
          return 0;
        }
      }
      catch (Exception paramQRActionEntity)
      {
        a(paramQQAppInterface, paramActivity, paramString);
        return 0;
      }
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle.getBoolean("issupportwpa", false));
      return 1;
      String str = "";
      paramBundle = str;
      if (!TextUtils.isEmpty(paramString))
      {
        Uri localUri = Uri.parse(paramString);
        paramBundle = str;
        if (localUri != null)
        {
          paramBundle = str;
          if (localUri.isHierarchical()) {
            paramBundle = localUri.getQueryParameter("jump_from");
          }
        }
      }
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle);
      return 2;
      a(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a() + "", paramBundle);
      return 3;
      b(paramQQAppInterface, paramActivity, paramQRActionEntity.a().a());
      return 4;
      a(paramActivity, paramQRActionEntity);
      int i = paramQRActionEntity.r;
      return i;
    }
  }
  
  private static void a(Context paramContext, QRActionEntity paramQRActionEntity)
  {
    long l = paramQRActionEntity.a().a();
    paramQRActionEntity = new Intent(paramContext, EnterpriseDetailActivity.class);
    paramQRActionEntity.putExtra("uin", String.valueOf(l));
    paramQRActionEntity.putExtra("need_finish", false);
    paramContext.startActivity(paramQRActionEntity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramString = 1024 + "https://qm.qq.com/cgi-bin/result" + "?p=a&v=" + DeviceInfoUtil.c() + "&r=" + URLEncoder.encode(paramString).replaceAll("\\+", "%20") + "&_wv=1027";
    paramQQAppInterface.putExtra("title", paramActivity.getString(2131363531));
    paramQQAppInterface.putExtra("url", paramString);
    paramQQAppInterface.putExtra("key_isReadModeEnabled", true);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt)
  {
    paramQQAppInterface = new Intent(paramActivity, QRCardActivity.class);
    paramQQAppInterface.putExtra("CARDMODE", paramInt);
    paramQQAppInterface.putExtra("QRCARDSTR", paramString);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  private static final void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, AccountDetailActivity.class);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("extvalue");
      paramBundle = paramBundle.getString("exttype");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBundle)))
      {
        localIntent.putExtra("extvalue", str);
        localIntent.putExtra("exttype", paramBundle);
      }
    }
    localIntent.putExtra("uin", paramString);
    paramActivity.startActivity(localIntent);
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_1", "scan");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString1);
    localBundle.putString("card_type", "group");
    localBundle.putString("from", "qrcode");
    paramString1 = paramString2;
    if (StringUtil.b(paramString2))
    {
      if (!(paramActivity instanceof ScannerActivity)) {
        break label143;
      }
      paramString1 = "ScannerActivity";
    }
    for (;;)
    {
      localBundle.putString("jump_from", paramString1);
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(localBundle)).toString());
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b();
      }
      return;
      label143:
      paramString1 = paramString2;
      if ((paramActivity instanceof QRJumpActivity)) {
        paramString1 = "QRJumpActivity";
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString);
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localBundle.putString("wpa", paramString);
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, Uri.parse("mqqapi://card/show_pslcard?" + HttpUtil.a(localBundle)).toString());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a();
        paramQQAppInterface.b();
      }
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, TenpayActivity.class);
    paramQQAppInterface.putExtra("src_type", "qrcode");
    paramQQAppInterface.putExtra("token_id", paramString);
    paramActivity.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.QRResultHandler
 * JD-Core Version:    0.7.0.1
 */