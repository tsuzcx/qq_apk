package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager.PCPayData;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import eoy;
import eoz;
import java.util.HashSet;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class PayBridgeActivity
  extends BaseActivity
{
  public static final int A = 5;
  public static final int B = 6;
  public static final int C = 7;
  public static final int a = 1;
  public static final String a = "Q.qwallet.payPayBridgeActivity";
  public static final int b = 2;
  public static final String b = "release";
  public static final int c = 3;
  public static final String c = "pay_requestcode";
  public static final int d = 4;
  public static final String d = "payparmas_paytype";
  private static boolean d = false;
  public static final int e = 5;
  public static final String e = "payparmas_from_native";
  public static final int f = 6;
  public static final String f = "payparmas_from_pcpush";
  public static final int g = 7;
  public static final String g = "payparmas_from_is_login_state";
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = -5;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = -1;
  public static final int p = 0;
  public static final int q = 2;
  public static final int r = 3;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  public static final int v = 4;
  public static final int w = 1;
  public static final int x = 2;
  public static final int y = 3;
  public static final int z = 4;
  protected int D = -1;
  private int E = -1;
  private int F = -1;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private DataFactory.EmojiPayReqData jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData;
  public boolean a;
  protected boolean b = true;
  boolean c = true;
  private boolean e = false;
  private String h;
  private final String i = "2711679534";
  
  public PayBridgeActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
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
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297371);
    if (paramString1 != null) {
      paramString1.setText(2131365065);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("payState", -1);
      ((JSONObject)localObject).put("provideState", -1);
      ((JSONObject)localObject).put("resultMsg", "");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    Object localObject1 = "";
    String str5 = "";
    Object localObject4 = "";
    Object localObject2 = "";
    String str3 = "";
    String str2 = "";
    int i2 = paramString1.lastIndexOf("|channel#");
    Object localObject3 = localObject4;
    String str1 = str5;
    String str4;
    int i1;
    if (i2 != -1)
    {
      str4 = paramString1.substring("|channel#".length() + i2);
      i1 = paramString1.indexOf("|bargainor_id#");
      localObject3 = localObject4;
      str1 = str5;
      localObject1 = str4;
      if (i1 != -1)
      {
        str5 = paramString1.substring("|bargainor_id#".length() + i1, i2);
        i2 = paramString1.indexOf("appid#");
        localObject3 = localObject4;
        str1 = str5;
        localObject1 = str4;
        if (i2 != -1)
        {
          localObject3 = paramString1.substring("appid#".length() + i2, i1);
          localObject1 = str4;
          str1 = str5;
        }
      }
    }
    i2 = paramString2.lastIndexOf("|channel#");
    localObject4 = str2;
    paramString1 = str3;
    if (i2 != -1)
    {
      str4 = paramString2.substring("|channel#".length() + i2);
      i1 = paramString2.indexOf("|bargainor_id#");
      localObject4 = str2;
      paramString1 = str3;
      localObject2 = str4;
      if (i1 != -1)
      {
        str3 = paramString2.substring("|bargainor_id#".length() + i1, i2);
        i2 = paramString2.indexOf("appid#");
        localObject4 = str2;
        paramString1 = str3;
        localObject2 = str4;
        if (i2 != -1)
        {
          localObject4 = paramString2.substring("appid#".length() + i2, i1);
          localObject2 = str4;
          paramString1 = str3;
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      paramString2 = "appid#" + (String)localObject4;
      paramString2 = paramString2 + "|bargainor_id#";
      if (!TextUtils.isEmpty(str1)) {
        break label436;
      }
      paramString1 = paramString2 + paramString1;
      label362:
      paramString1 = paramString1 + "|channel#";
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label491;
      }
    }
    label436:
    label491:
    for (paramString1 = paramString1 + (String)localObject2;; paramString1 = paramString1 + (String)localObject1)
    {
      return paramString1;
      paramString2 = "appid#" + (String)localObject3;
      break;
      if (str1.compareTo("0") == 0)
      {
        paramString1 = paramString2 + paramString1;
        break label362;
      }
      paramString1 = paramString2 + str1;
      break label362;
    }
  }
  
  private void a() {}
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt1);
    localBundle.putInt("realSaveNum", paramInt2);
    localBundle.putInt("payChannel", paramInt3);
    localBundle.putInt("payState", paramInt4);
    localBundle.putInt("provideState", paramInt5);
    localBundle.putString("message", paramString);
    localIntent.putExtras(localBundle);
    setResult(paramInt1, localIntent);
    a(paramInt1, localIntent);
    finish();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((!this.e) && (this.jdField_a_of_type_AndroidContentIntent == null))
    {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.F = paramInt;
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(paramInt1, paramString);
    a(paramInt1, paramString);
    finish();
  }
  
  private void a(Intent paramIntent)
  {
    setResult(-1, paramIntent);
    finish();
  }
  
  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("vkey");
    String str4 = paramBundle.getString("pf");
    String str5 = paramBundle.getString("discountId");
    String str6 = paramBundle.getString("other");
    String str7 = paramBundle.getString("saveValue");
    boolean bool = paramBundle.getBoolean("isCanChange", true);
    paramBundle = new Bundle();
    paramBundle.putString("setOfferId", str1);
    paramBundle.putString("setEnv", "release");
    paramBundle.putBoolean("setLogEnable", false);
    paramBundle.putString("userId", str2);
    paramBundle.putString("userKey", str3);
    paramBundle.putString("sessionId", "uin");
    paramBundle.putString("sessionType", "vkey");
    paramBundle.putString("zoneId", "1");
    paramBundle.putString("pf", str4);
    paramBundle.putString("pfKey", "pfKey");
    paramBundle.putString("acctType", "common");
    paramBundle.putInt("resId", 2130840678);
    paramBundle.putString("discountId", str5);
    paramBundle.putString("other", str6);
    paramBundle.putInt("PayInvokerId", 2);
    if ((str7 != null) && (str7.trim().length() > 0))
    {
      paramBundle.putString("saveValue", str7);
      paramBundle.putBoolean("isCanChange", bool);
    }
    QWalletPayBridge.a(this, this.app, paramBundle);
  }
  
  private void a(QWalletPushManager.PCPayData paramPCPayData)
  {
    if (paramPCPayData == null)
    {
      finish();
      return;
    }
    paramPCPayData.f = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramPCPayData.b);
    localBundle.putString("callbackSn", "0");
    switch (QWalletPushManager.a(paramPCPayData.e))
    {
    case 5: 
    case 10: 
    default: 
      finish();
      return;
    case 9: 
      h(localBundle);
      return;
    case 4: 
      c(localBundle);
      return;
    case 11: 
      j(localBundle);
      return;
    case 8: 
      g(localBundle);
      return;
    case 7: 
      e(localBundle);
      return;
    }
    f(localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (!paramString.contains(";")) {
        break;
      }
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length != 0))
      {
        int i2 = paramString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          StatisticCollector.a(BaseApplication.getContext()).d(paramQQAppInterface, paramString[i1]);
          i1 += 1;
        }
      }
    }
    StatisticCollector.a(BaseApplication.getContext()).d(paramQQAppInterface, paramString);
  }
  
  private void a(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData = paramEmojiPayReqData;
    Bundle localBundle = new Bundle();
    localBundle.putString("setOfferId", paramEmojiPayReqData.appid);
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putBoolean("setNumberVisible", false);
    localBundle.putString("userId", paramEmojiPayReqData.userId);
    localBundle.putString("userKey", paramEmojiPayReqData.userKey);
    localBundle.putString("sessionId", paramEmojiPayReqData.sessionId);
    localBundle.putString("sessionType", paramEmojiPayReqData.sessionType);
    localBundle.putString("zoneId", paramEmojiPayReqData.zoneId);
    localBundle.putString("pf", paramEmojiPayReqData.pf);
    localBundle.putString("pfKey", paramEmojiPayReqData.pfKey);
    localBundle.putString("tokenUrl", paramEmojiPayReqData.tokenUrl);
    localBundle.putInt("resId", 2130838301);
    localBundle.putString("discountId", paramEmojiPayReqData.discountId);
    localBundle.putString("other", paramEmojiPayReqData.other);
    localBundle.putInt("PayInvokerId", 1);
    QWalletPayBridge.a(this, this.app, localBundle);
  }
  
  private void a(DataFactory.EmojiPayReqData paramEmojiPayReqData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    if (paramEmojiPayReqData == null)
    {
      finish();
      return;
    }
    Intent localIntent = new Intent();
    paramString = new DataFactory.EmojiPayRespData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    localIntent.putExtras(paramEmojiPayReqData.getBundleData());
    localIntent.putExtras(paramString.getBundleData());
    setResult(-1, localIntent);
    a(-1, localIntent);
    finish();
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramString2);
    localIntent.putExtra("callbackSn", paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity tenpayResult:callbackSn=" + paramString1 + ",result=" + paramString2);
    }
    setResult(-1, localIntent);
    a(-1, localIntent);
    finish();
  }
  
  public static boolean a()
  {
    return d;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramActivity == null) || (paramString1 == null)) {
      return false;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString1);
    localBundle.putString("callbackSn", paramString2);
    localBundle.putString("urlAppInfo", paramString3);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("pay_requestcode", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity tenpay startActivity and request=" + localBundle.toString() + ",requestCode=" + paramInt);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.payPayBridgeActivity", 2, "startEmojimallPaycallbackid:" + paramString1 + "appid:" + paramString2 + "userId:" + paramString3 + "userKey:" + paramString4 + "zoneId:" + paramString5 + "pf:" + paramString6 + "pfKey:" + paramString7 + "tokenUrl:" + paramString8);
    }
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString8))) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(new DataFactory.EmojiPayReqData(paramString1, paramString2, paramString3, paramString4, "uin", "skey", paramString5, paramString6, paramString7, paramString8).getBundleData());
    localIntent.putExtra("pay_requestcode", 1);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    paramActivity.startActivityForResult(localIntent, 1);
    return true;
  }
  
  private boolean a(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    return (paramEmojiPayReqData != null) && (!TextUtils.isEmpty(paramEmojiPayReqData.appid)) && (!TextUtils.isEmpty(paramEmojiPayReqData.callbackid)) && (!TextUtils.isEmpty(paramEmojiPayReqData.userId)) && (!TextUtils.isEmpty(paramEmojiPayReqData.userKey)) && (!TextUtils.isEmpty(paramEmojiPayReqData.tokenUrl));
  }
  
  private String b()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("retmsg", "error");
      ((JSONObject)localObject).put("data", new JSONObject());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private void b(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("vkey");
    String str4 = paramBundle.getString("pf");
    String str5 = paramBundle.getString("provideUin");
    String str6 = paramBundle.getString("provideType");
    String str7 = paramBundle.getString("discountId");
    paramBundle = paramBundle.getString("other");
    Bundle localBundle = new Bundle();
    localBundle.putString("setOfferId", str1);
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("userId", str2);
    localBundle.putString("userKey", str3);
    localBundle.putString("sessionId", "uin");
    localBundle.putString("sessionType", "vkey");
    localBundle.putString("pf", str4);
    localBundle.putString("pfKey", "pfKey");
    localBundle.putString("serviceCode", "QQYFSC");
    localBundle.putString("serviceName", "腾讯文学包月VIP");
    localBundle.putInt("resId", 2130840678);
    localBundle.putString("openMonth", "3");
    localBundle.putBoolean("isCanChange", true);
    localBundle.putString("remark", "");
    localBundle.putString("provideUin", str5);
    localBundle.putString("provideType", str6);
    localBundle.putString("discountId", str7);
    localBundle.putString("other", paramBundle);
    localBundle.putInt("PayInvokerId", 3);
    QWalletPayBridge.a(this, this.app, localBundle);
  }
  
  private String c()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.app.a());
    }
    return "";
  }
  
  private void c(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("realSaveNum", -1);
    int i4 = paramIntent.getIntExtra("payChannel", -1);
    int i5 = paramIntent.getIntExtra("payState", -1);
    int i6 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if ((i1 == 1) && (this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData != null))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData, i2, i3, i4, i5, i6, paramIntent);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData, -1, -1, -1, -1, -1, "");
  }
  
  private void c(Bundle paramBundle)
  {
    String str12 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity openService request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str12));
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramBundle.getString("json"));
        String str16 = ((JSONObject)localObject).getString("offerId");
        String str13 = ((JSONObject)localObject).getString("userId");
        String str14 = ((JSONObject)localObject).getString("serviceCode");
        String str15 = ((JSONObject)localObject).getString("serviceName");
        if (((JSONObject)localObject).has("channel"))
        {
          paramBundle = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label835;
          }
          str1 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("openMonth")) {
            break label840;
          }
          str2 = ((JSONObject)localObject).getString("openMonth");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label846;
          }
          bool = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("remark")) {
            break label851;
          }
          str3 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("provideUin")) {
            break label858;
          }
          str4 = ((JSONObject)localObject).getString("provideUin");
          if (!((JSONObject)localObject).has("provideType")) {
            break label864;
          }
          str5 = ((JSONObject)localObject).getString("provideType");
          if (!((JSONObject)localObject).has("discountId")) {
            break label870;
          }
          str6 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label877;
          }
          str7 = ((JSONObject)localObject).getString("other");
          if (!((JSONObject)localObject).has("aid")) {
            break label884;
          }
          str8 = ((JSONObject)localObject).getString("aid");
          String str11 = null;
          String str10 = null;
          String str9 = null;
          if ((((JSONObject)localObject).has("ticketName")) && (((JSONObject)localObject).has("ticketValue")))
          {
            str10 = ((JSONObject)localObject).getString("ticketName");
            str11 = ((JSONObject)localObject).getString("ticketValue");
            localObject = new Bundle();
            ((Bundle)localObject).putString("setOfferId", str16);
            ((Bundle)localObject).putString("setEnv", "release");
            ((Bundle)localObject).putBoolean("setLogEnable", false);
            if ((str1 != null) && (str1.length() > 0)) {
              ((Bundle)localObject).putString("setPropUnit", str1);
            }
            if ((paramBundle != null) && (paramBundle.length() > 0)) {
              ((Bundle)localObject).putString("setPayChannel", paramBundle);
            }
            ((Bundle)localObject).putString("callbackSn", str12);
            paramBundle = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str8;
            ((Bundle)localObject).putString("userId", str13);
            if (str11 != null)
            {
              ((Bundle)localObject).putString("sessionType", str10);
              ((Bundle)localObject).putString("userKey", str11);
              ((Bundle)localObject).putString("sessionId", "uin");
              ((Bundle)localObject).putString("pf", paramBundle);
              ((Bundle)localObject).putString("pfKey", "pfKey");
              ((Bundle)localObject).putString("serviceCode", str14);
              ((Bundle)localObject).putString("serviceName", str15);
              ((Bundle)localObject).putInt("resId", 0);
              if ((str2 != null) && (str2.length() > 0))
              {
                ((Bundle)localObject).putString("openMonth", str2);
                ((Bundle)localObject).putBoolean("isCanChange", Boolean.valueOf(bool).booleanValue());
              }
              ((Bundle)localObject).putString("remark", str3);
              ((Bundle)localObject).putString("provideUin", str4);
              ((Bundle)localObject).putString("provideType", str5);
              ((Bundle)localObject).putString("discountId", str6);
              ((Bundle)localObject).putString("other", str7);
              ((Bundle)localObject).putInt("PayInvokerId", 4);
              QWalletPayBridge.a(this, this.app, (Bundle)localObject);
            }
          }
          else
          {
            str9 = c();
            continue;
          }
          ((Bundle)localObject).putString("sessionType", "skey");
          ((Bundle)localObject).putString("userKey", str9);
          continue;
        }
        paramBundle = null;
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "openService JSONException:" + paramBundle.getMessage());
        }
        a(str12, "{'resultCode':-1,'resultMsg':'openService JSONException'}");
        paramBundle.printStackTrace();
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "openService Exception:" + paramBundle.getMessage());
        }
        a(str12, "{'resultCode':-1,'resultMsg':'openService Exception'}");
        paramBundle.printStackTrace();
        return;
      }
      continue;
      label835:
      String str1 = null;
      continue;
      label840:
      String str2 = null;
      continue;
      label846:
      boolean bool = true;
      continue;
      label851:
      String str3 = "";
      continue;
      label858:
      String str4 = null;
      continue;
      label864:
      String str5 = null;
      continue;
      label870:
      String str6 = "";
      continue;
      label877:
      String str7 = "";
      continue;
      label884:
      String str8 = "";
    }
  }
  
  private void d(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("realSaveNum", -1);
    int i4 = paramIntent.getIntExtra("payChannel", -1);
    int i5 = paramIntent.getIntExtra("payState", -1);
    int i6 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if (i1 == 1)
    {
      a(i2, i3, i4, i5, i6, paramIntent);
      return;
    }
    a(-1, -1, -1, -1, -1, "");
  }
  
  private void d(Bundle paramBundle)
  {
    int i1 = 1;
    String str1 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity openTenpayView request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str1));
    }
    Object localObject2;
    String str3;
    String str2;
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(paramBundle.getString("json"));
      str3 = ((JSONObject)localObject2).getString("userId");
      paramBundle = new HashSet();
      paramBundle.add("bindNewCard");
      paramBundle.add("balance");
      paramBundle.add("pswManage");
      paramBundle.add("modifyPsw");
      paramBundle.add("checkPsw");
      paramBundle.add("withdraw");
      paramBundle.add("transferInfor");
      paramBundle.add("transfer");
      paramBundle.add("graphb");
      paramBundle.add("qpay_hb_share");
      paramBundle.add("sendHb");
      paramBundle.add("sendHbCallback");
      paramBundle.add("makeHongbao");
      paramBundle.add("parseqrcode");
      paramBundle.add("verifyqrcode");
      paramBundle.add("findPsw");
      paramBundle.add("pushMsg");
      paramBundle.add("transferPush");
      paramBundle.add("transferqrcode");
      paramBundle.add("transferInput");
      paramBundle.add("redgiftDetail");
      paramBundle.add("redgiftRecord");
      str2 = ((JSONObject)localObject2).getString("viewTag");
      if ((str2 == null) || (!paramBundle.contains(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(str2, 2, "openTenpayView viewTag is not allow");
        }
        a(str1, "{'resultCode':-1,'retmsg':'openTenpayView param viewTag error'}");
        return;
      }
      if (("transfer".compareTo(str2) != 0) && ("transferInput".compareTo(str2) != 0)) {
        break label503;
      }
      localObject1 = new Intent(this, TransactionActivity.class);
      ((Intent)localObject1).putExtra("callbackSn", str1);
      ((Intent)localObject1).putExtra("come_from", 1);
      ((Intent)localObject1).putExtra("tag", str2);
      if (!((JSONObject)localObject2).has("appInfo")) {
        break label497;
      }
      paramBundle = ((JSONObject)localObject2).getString("appInfo");
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openTenpayView JSONException:" + paramBundle.getMessage());
        }
        a(str1, "{'resultCode':-1,'retmsg':'openTenpayView params error'}");
        paramBundle.printStackTrace();
        return;
        paramBundle = "";
      }
      if ("makeHongbao".compareTo(str2) != 0) {
        break label675;
      }
      localObject1 = new Intent(this, SendHbActivity.class);
      ((Intent)localObject1).putExtra("callbackSn", str1);
      ((Intent)localObject1).putExtra("come_from", 2);
      ((Intent)localObject1).putExtra("is_H5", true);
      if (!((JSONObject)localObject2).has("appInfo")) {
        break label669;
      }
      paramBundle = ((JSONObject)localObject2).getString("appInfo");
      ((Intent)localObject1).putExtra("app_info", paramBundle);
      if (!((JSONObject)localObject2).has("extra_data")) {
        break label1008;
      }
      paramBundle = ((JSONObject)localObject2).getString("extra_data");
      ((Intent)localObject1).putExtra("extra_data", paramBundle);
      startActivityForResult((Intent)localObject1, 5);
      return;
    }
    catch (Exception paramBundle)
    {
      if (!QLog.isColorLevel()) {
        break label655;
      }
      QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openTenpayView Exception:" + paramBundle.getMessage());
      a(str1, "{'resultCode':-1,'retmsg':'openTenpayView Exception'}");
      paramBundle.printStackTrace();
      return;
    }
    ((Intent)localObject1).putExtra("app_info", paramBundle);
    if (((JSONObject)localObject2).has("extra_data"))
    {
      paramBundle = ((JSONObject)localObject2).getString("extra_data");
      ((Intent)localObject1).putExtra("extra_data", paramBundle);
      startActivityForResult((Intent)localObject1, 5);
      return;
      label603:
      for (;;)
      {
        label497:
        label503:
        paramBundle = "";
      }
      label655:
      label669:
      label675:
      String str4;
      if ("transferqrcode".compareTo(str2) == 0)
      {
        str4 = this.app.c();
        paramBundle = ((JSONObject)localObject2).optJSONObject("extra_data");
        localObject1 = paramBundle;
        if (paramBundle != null) {}
      }
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("name", str4);
        ((JSONObject)localObject2).put("extra_data", localObject1);
      }
      catch (Exception paramBundle)
      {
        label738:
        break label738;
      }
      localObject1 = new Bundle();
      if ((str2.equals("bindNewCard")) && (((JSONObject)localObject2).has("bargainor_id"))) {
        ((Bundle)localObject1).putString("bargainor_id", ((JSONObject)localObject2).getString("bargainor_id"));
      }
      if (((JSONObject)localObject2).has("comeForm")) {
        i1 = ((JSONObject)localObject2).getInt("comeForm");
      }
      ((Bundle)localObject1).putInt("come_from", i1);
      if (!((JSONObject)localObject2).has("appInfo")) {
        break label1014;
      }
    }
    label1008:
    label1014:
    for (paramBundle = ((JSONObject)localObject2).getString("appInfo");; paramBundle = "")
    {
      ((Bundle)localObject1).putString("app_info", paramBundle);
      if (((JSONObject)localObject2).has("extra_data")) {}
      for (paramBundle = ((JSONObject)localObject2).getString("extra_data");; paramBundle = "")
      {
        ((Bundle)localObject1).putString("extra_data", paramBundle);
        paramBundle = c();
        this.h = str2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("callbackSn", str1);
        ((Bundle)localObject2).putString("tag", str2);
        ((Bundle)localObject2).putString("uin", str3);
        ((Bundle)localObject2).putString("nick_name", this.app.c());
        ((Bundle)localObject2).putString("skey", paramBundle);
        ((Bundle)localObject2).putString("skey_type", "2");
        ((Bundle)localObject2).putBundle("params", (Bundle)localObject1);
        ((Bundle)localObject2).putInt("PayInvokerId", 5);
        ((Bundle)localObject2).putInt("payparmas_paytype", this.D);
        QWalletPayBridge.a(this, this.app, (Bundle)localObject2);
        return;
      }
      paramBundle = "";
      break;
      paramBundle = "";
      break label603;
    }
  }
  
  private void e(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("realSaveNum", -1);
    int i4 = paramIntent.getIntExtra("payChannel", -1);
    int i5 = paramIntent.getIntExtra("payState", -1);
    int i6 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if (i1 == 1)
    {
      a(i2, i3, i4, i5, i6, paramIntent);
      return;
    }
    a(-1, -1, -1, -1, -1, "");
  }
  
  private void e(Bundle paramBundle)
  {
    String str4 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity buyGoods request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str4));
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramBundle.getString("json"));
        String str7 = ((JSONObject)localObject).getString("offerId");
        String str5 = ((JSONObject)localObject).getString("userId");
        String str6 = ((JSONObject)localObject).getString("tokenUrl");
        if (((JSONObject)localObject).has("zoneId"))
        {
          paramBundle = ((JSONObject)localObject).getString("zoneId");
          if (!((JSONObject)localObject).has("numberVisible")) {
            break label595;
          }
          bool = ((JSONObject)localObject).getBoolean("numberVisible");
          if (!((JSONObject)localObject).has("unit")) {
            break label600;
          }
          str1 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("aid")) {
            break label605;
          }
          str2 = ((JSONObject)localObject).getString("aid");
          String str8 = c();
          if (!((JSONObject)localObject).has("discountId")) {
            break label612;
          }
          str3 = ((JSONObject)localObject).getString("discountId");
          if (((JSONObject)localObject).has("other"))
          {
            localObject = ((JSONObject)localObject).getString("other");
            Bundle localBundle = new Bundle();
            localBundle.putString("setOfferId", str7);
            localBundle.putString("setEnv", "release");
            localBundle.putBoolean("setLogEnable", false);
            localBundle.putBoolean("setNumberVisible", Boolean.valueOf(bool).booleanValue());
            if ((str1 != null) && (str1.length() > 0)) {
              localBundle.putString("setPropUnit", str1);
            }
            localBundle.putString("callbackSn", str4);
            str1 = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str2;
            localBundle.putString("userId", str5);
            localBundle.putString("userKey", str8);
            localBundle.putString("sessionId", "uin");
            localBundle.putString("sessionType", "skey");
            localBundle.putString("zoneId", paramBundle);
            localBundle.putString("pf", str1);
            localBundle.putString("pfKey", "pfKey");
            localBundle.putString("tokenUrl", str6);
            localBundle.putInt("resId", 0);
            localBundle.putString("discountId", str3);
            localBundle.putString("other", (String)localObject);
            localBundle.putInt("PayInvokerId", 7);
            QWalletPayBridge.a(this, this.app, localBundle);
            return;
          }
          localObject = "";
          continue;
        }
        paramBundle = "1";
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "buyGoods JSONException:" + paramBundle.getMessage());
        }
        a(str4, "{'resultCode':-1,'retmsg':'buyGoods JSONException'}");
        paramBundle.printStackTrace();
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "buyGoods Exception:" + paramBundle.getMessage());
        }
        a(str4, "{'resultCode':-1,'retmsg':'buyGoods Exception'}");
        paramBundle.printStackTrace();
        return;
      }
      continue;
      label595:
      boolean bool = true;
      continue;
      label600:
      String str1 = null;
      continue;
      label605:
      String str2 = "";
      continue;
      label612:
      String str3 = "";
    }
  }
  
  private void f(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("payState", -1);
    int i4 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if (i1 == 1)
    {
      a(i2, paramIntent, i3, i4);
      return;
    }
    a(-1, "", -1, -1);
  }
  
  private void f(Bundle paramBundle)
  {
    String str5 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity rechargeGameCurrency request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str5));
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramBundle.getString("json"));
        String str7 = ((JSONObject)localObject).getString("offerId");
        String str6 = ((JSONObject)localObject).getString("userId");
        if (((JSONObject)localObject).has("zoneId"))
        {
          paramBundle = ((JSONObject)localObject).getString("zoneId");
          if (!((JSONObject)localObject).has("acctType")) {
            break label647;
          }
          str1 = ((JSONObject)localObject).getString("acctType");
          if (!((JSONObject)localObject).has("numberVisible")) {
            break label655;
          }
          bool1 = ((JSONObject)localObject).getBoolean("numberVisible");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label660;
          }
          str2 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label666;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("aid")) {
            break label671;
          }
          str3 = ((JSONObject)localObject).getString("aid");
          String str8 = c();
          if (!((JSONObject)localObject).has("discountId")) {
            break label678;
          }
          str4 = ((JSONObject)localObject).getString("discountId");
          if (((JSONObject)localObject).has("other"))
          {
            localObject = ((JSONObject)localObject).getString("other");
            Bundle localBundle = new Bundle();
            localBundle.putString("setOfferId", str7);
            localBundle.putString("setEnv", "release");
            localBundle.putBoolean("setLogEnable", true);
            localBundle.putBoolean("setNumberVisible", Boolean.valueOf(bool1).booleanValue());
            localBundle.putString("callbackSn", str5);
            str3 = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str3;
            localBundle.putString("userId", str6);
            localBundle.putString("userKey", str8);
            localBundle.putString("sessionId", "uin");
            localBundle.putString("sessionType", "skey");
            localBundle.putString("zoneId", paramBundle);
            localBundle.putString("pf", str3);
            localBundle.putString("pfKey", "pfKey");
            localBundle.putString("acctType", str1);
            localBundle.putString("discountId", str4);
            localBundle.putString("other", (String)localObject);
            if ((str2 != null) && (str2.length() > 0))
            {
              localBundle.putString("saveValue", str2);
              localBundle.putBoolean("isCanChange", Boolean.valueOf(bool2).booleanValue());
            }
            localBundle.putInt("resId", 0);
            localBundle.putInt("PayInvokerId", 6);
            QWalletPayBridge.a(this, this.app, localBundle);
            return;
          }
          localObject = "";
          continue;
        }
        paramBundle = "1";
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "rechargeCurrency JSONException:" + paramBundle.getMessage());
        }
        a(str5, "{'resultCode':-1,'retmsg':'rechargeCurrency JSONException'}");
        paramBundle.printStackTrace();
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "rechargeCurrency Exception:" + paramBundle.getMessage());
        }
        a(str5, "{'resultCode':-1,'retmsg':'rechargeCurrency Exception'}");
        paramBundle.printStackTrace();
        return;
      }
      continue;
      label647:
      String str1 = "common";
      continue;
      label655:
      boolean bool1 = true;
      continue;
      label660:
      String str2 = null;
      continue;
      label666:
      boolean bool2 = true;
      continue;
      label671:
      String str3 = "";
      continue;
      label678:
      String str4 = "";
    }
  }
  
  private void g(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void g(Bundle paramBundle)
  {
    String str10 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity rechargeQb request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str10));
    }
    paramBundle = paramBundle.getString("json");
    String str1;
    label136:
    boolean bool;
    label156:
    String str2;
    label177:
    String str3;
    label198:
    String str4;
    label219:
    String str5;
    label240:
    String str6;
    label261:
    Object localObject1;
    label282:
    String str7;
    label303:
    String str8;
    label324:
    String str9;
    label345:
    Object localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramBundle);
      if ((((JSONObject)localObject3).has("payparmas_from_native")) && (((JSONObject)localObject3).getBoolean("payparmas_from_native")))
      {
        if (((JSONObject)localObject3).has("setOfferId"))
        {
          paramBundle = ((JSONObject)localObject3).getString("setOfferId");
          if (!((JSONObject)localObject3).has("setEnv")) {
            break label1214;
          }
          str1 = ((JSONObject)localObject3).getString("setEnv");
          if (!((JSONObject)localObject3).has("setLogEnable")) {
            break label1219;
          }
          bool = ((JSONObject)localObject3).getBoolean("setLogEnable");
          if (!((JSONObject)localObject3).has("userId")) {
            break label1224;
          }
          str2 = ((JSONObject)localObject3).getString("userId");
          if (!((JSONObject)localObject3).has("userKey")) {
            break label1230;
          }
          str3 = ((JSONObject)localObject3).getString("userKey");
          if (!((JSONObject)localObject3).has("sessionId")) {
            break label1236;
          }
          str4 = ((JSONObject)localObject3).getString("sessionId");
          if (!((JSONObject)localObject3).has("sessionType")) {
            break label1242;
          }
          str5 = ((JSONObject)localObject3).getString("sessionType");
          if (!((JSONObject)localObject3).has("pf")) {
            break label1248;
          }
          str6 = ((JSONObject)localObject3).getString("pf");
          if (!((JSONObject)localObject3).has("pfKey")) {
            break label1254;
          }
          localObject1 = ((JSONObject)localObject3).getString("pfKey");
          if (!((JSONObject)localObject3).has("saveValue")) {
            break label1260;
          }
          str7 = ((JSONObject)localObject3).getString("saveValue");
          if (!((JSONObject)localObject3).has("provideUin")) {
            break label1266;
          }
          str8 = ((JSONObject)localObject3).getString("provideUin");
          if (!((JSONObject)localObject3).has("provideType")) {
            break label1272;
          }
          str9 = ((JSONObject)localObject3).getString("provideType");
          if (!((JSONObject)localObject3).has("discountId")) {
            break label1278;
          }
          localObject2 = ((JSONObject)localObject3).getString("discountId");
          label366:
          if (((JSONObject)localObject3).has("other")) {}
          for (localObject3 = ((JSONObject)localObject3).getString("other");; localObject3 = "")
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("setOfferId", paramBundle);
            localBundle.putString("setEnv", str1);
            localBundle.putBoolean("setLogEnable", bool);
            localBundle.putString("callbackSn", str10);
            localBundle.putString("userId", str2);
            localBundle.putString("userKey", str3);
            localBundle.putString("sessionId", str4);
            localBundle.putString("sessionType", str5);
            localBundle.putString("pf", str6);
            localBundle.putString("pfKey", (String)localObject1);
            localBundle.putString("saveValue", str7);
            localBundle.putString("provideUin", str8);
            localBundle.putString("provideType", str9);
            localBundle.putString("discountId", (String)localObject2);
            localBundle.putString("other", (String)localObject3);
            localBundle.putInt("PayInvokerId", 8);
            QWalletPayBridge.a(this, this.app, localBundle);
            return;
          }
        }
      }
      else {
        try
        {
          localObject1 = new JSONObject(paramBundle);
          str8 = ((JSONObject)localObject1).getString("offerId");
          str7 = ((JSONObject)localObject1).getString("userId");
          if (((JSONObject)localObject1).has("channel"))
          {
            paramBundle = ((JSONObject)localObject1).getString("channel");
            if (!((JSONObject)localObject1).has("unit")) {
              break label1134;
            }
            str1 = ((JSONObject)localObject1).getString("unit");
            if (!((JSONObject)localObject1).has("saveValue")) {
              break label1139;
            }
            str2 = ((JSONObject)localObject1).getString("saveValue");
            if (!((JSONObject)localObject1).has("aid")) {
              break label1145;
            }
            str3 = ((JSONObject)localObject1).getString("aid");
            if (!((JSONObject)localObject1).has("provideUin")) {
              break label1285;
            }
            str4 = ((JSONObject)localObject1).getString("provideUin");
            if (!((JSONObject)localObject1).has("provideType")) {
              break label1291;
            }
            str5 = ((JSONObject)localObject1).getString("provideType");
            if (!((JSONObject)localObject1).has("discountId")) {
              break label1297;
            }
            str6 = ((JSONObject)localObject1).getString("discountId");
            if (!((JSONObject)localObject1).has("other")) {
              break label1152;
            }
            localObject1 = ((JSONObject)localObject1).getString("other");
            str9 = c();
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("setOfferId", str8);
            ((Bundle)localObject2).putString("setEnv", "release");
            ((Bundle)localObject2).putBoolean("setLogEnable", true);
            if ((str1 != null) && (str1.length() > 0)) {
              ((Bundle)localObject2).putString("setPropUnit", str1);
            }
            if ((paramBundle != null) && (paramBundle.length() > 0)) {
              ((Bundle)localObject2).putString("setPayChannel", paramBundle);
            }
            ((Bundle)localObject2).putString("callbackSn", str10);
            paramBundle = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str3;
            ((Bundle)localObject2).putString("userId", str7);
            ((Bundle)localObject2).putString("userKey", str9);
            ((Bundle)localObject2).putString("sessionId", "uin");
            ((Bundle)localObject2).putString("sessionType", "skey");
            ((Bundle)localObject2).putString("pf", paramBundle);
            ((Bundle)localObject2).putString("pfKey", "pfKey");
            ((Bundle)localObject2).putString("saveValue", str2);
            ((Bundle)localObject2).putString("provideUin", str4);
            ((Bundle)localObject2).putString("provideType", str5);
            ((Bundle)localObject2).putString("discountId", str6);
            ((Bundle)localObject2).putString("other", (String)localObject1);
            ((Bundle)localObject2).putInt("PayInvokerId", 8);
            QWalletPayBridge.a(this, this.app, (Bundle)localObject2);
          }
        }
        catch (JSONException paramBundle)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.qwallet.payPayBridgeActivity", 2, "rechargeQb JSONException:" + paramBundle.getMessage());
            }
            a(str10, "{'resultCode':-1,'retmsg':'rechargeQb JSONException'}");
            paramBundle.printStackTrace();
            return;
            paramBundle = null;
            continue;
            str1 = null;
            continue;
            str2 = null;
            continue;
            str3 = "";
            continue;
            localObject1 = "";
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.payPayBridgeActivity", 2, "rechargeQb Exception:" + paramBundle.getMessage());
          }
          a(str10, "{'resultCode':-1,'retmsg':'rechargeQb Exception'}");
          paramBundle.printStackTrace();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.payPayBridgeActivity", 2, "rechargeQb Exception:" + paramBundle.getMessage());
      }
      a(str10, "{'resultCode':-1,'retmsg':'rechargeQb Exception'}");
      paramBundle.printStackTrace();
      return;
    }
    for (;;)
    {
      label1134:
      label1139:
      label1145:
      paramBundle = null;
      label1152:
      break;
      label1214:
      str1 = null;
      break label136;
      label1219:
      bool = false;
      break label156;
      label1224:
      str2 = null;
      break label177;
      label1230:
      str3 = null;
      break label198;
      label1236:
      str4 = null;
      break label219;
      label1242:
      str5 = null;
      break label240;
      label1248:
      str6 = null;
      break label261;
      label1254:
      localObject1 = null;
      break label282;
      label1260:
      str7 = null;
      break label303;
      label1266:
      str8 = null;
      break label324;
      label1272:
      str9 = null;
      break label345;
      label1278:
      localObject2 = "";
      break label366;
      label1285:
      str4 = null;
      continue;
      label1291:
      str5 = null;
      continue;
      label1297:
      str6 = "";
    }
  }
  
  private void h(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str1 = paramIntent.getStringExtra("callbackSn");
    String str2 = paramIntent.getStringExtra("result");
    paramIntent = paramIntent.getStringExtra("upload_data");
    if (i1 == 1)
    {
      a(str1, str2);
      if ((paramIntent != null) && (paramIntent.length() > 0)) {
        a(this.app, paramIntent);
      }
      return;
    }
    a(str1, b());
  }
  
  /* Error */
  private void h(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 329
    //   4: invokevirtual 252	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 6
    //   9: aload_1
    //   10: ldc_w 438
    //   13: invokevirtual 252	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload 4
    //   23: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +12 -> 38
    //   29: aload 4
    //   31: ldc_w 778
    //   34: invokestatic 783	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_3
    //   38: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +46 -> 87
    //   44: ldc 16
    //   46: iconst_2
    //   47: new 194	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 785
    //   57: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: invokevirtual 444	android/os/Bundle:toString	()Ljava/lang/String;
    //   64: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 546
    //   70: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 6
    //   75: invokestatic 550	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   78: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: new 138	org/json/JSONObject
    //   90: dup
    //   91: aload_1
    //   92: ldc_w 325
    //   95: invokevirtual 252	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokespecial 553	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   101: astore 7
    //   103: aload_0
    //   104: getfield 310	com/tencent/mobileqq/activity/PayBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   107: invokevirtual 535	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   110: astore 8
    //   112: aload_0
    //   113: getfield 310	com/tencent/mobileqq/activity/PayBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   116: invokevirtual 704	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   119: astore 9
    //   121: aload 7
    //   123: ldc_w 787
    //   126: invokevirtual 556	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 10
    //   131: aload 7
    //   133: ldc_w 717
    //   136: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   139: ifeq +268 -> 407
    //   142: aload 7
    //   144: ldc_w 717
    //   147: invokevirtual 720	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   150: istore_2
    //   151: aload 7
    //   153: ldc_w 683
    //   156: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   159: ifeq +253 -> 412
    //   162: aload 7
    //   164: ldc_w 683
    //   167: invokevirtual 556	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_1
    //   171: aload 7
    //   173: ldc_w 789
    //   176: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   179: ifeq +346 -> 525
    //   182: aload 7
    //   184: ldc_w 789
    //   187: invokevirtual 556	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 4
    //   192: aload 7
    //   194: ldc_w 791
    //   197: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   200: ifeq +218 -> 418
    //   203: aload 7
    //   205: ldc_w 791
    //   208: invokevirtual 556	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   211: astore 5
    //   213: aload_0
    //   214: invokespecial 594	com/tencent/mobileqq/activity/PayBridgeActivity:c	()Ljava/lang/String;
    //   217: astore 11
    //   219: aload_0
    //   220: aload_1
    //   221: aload_3
    //   222: invokespecial 793	com/tencent/mobileqq/activity/PayBridgeActivity:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   225: astore_1
    //   226: new 211	android/os/Bundle
    //   229: dup
    //   230: invokespecial 212	android/os/Bundle:<init>	()V
    //   233: astore_3
    //   234: aload_3
    //   235: ldc_w 329
    //   238: aload 6
    //   240: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_3
    //   244: ldc_w 476
    //   247: aload 11
    //   249: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_3
    //   253: ldc_w 726
    //   256: ldc_w 728
    //   259: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_3
    //   263: ldc_w 787
    //   266: aload 10
    //   268: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_3
    //   272: ldc_w 282
    //   275: aload 8
    //   277: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_3
    //   281: ldc_w 795
    //   284: aload 9
    //   286: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_3
    //   290: ldc_w 717
    //   293: iload_2
    //   294: invokevirtual 218	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   297: aload_3
    //   298: ldc_w 683
    //   301: aload_1
    //   302: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload 4
    //   307: ifnull +54 -> 361
    //   310: aload 4
    //   312: invokevirtual 178	java/lang/String:length	()I
    //   315: ifle +46 -> 361
    //   318: aload 5
    //   320: ifnull +41 -> 361
    //   323: aload 5
    //   325: invokevirtual 178	java/lang/String:length	()I
    //   328: ifle +33 -> 361
    //   331: aload_0
    //   332: getfield 310	com/tencent/mobileqq/activity/PayBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   335: aload 4
    //   337: invokestatic 800	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Z
    //   340: ifne +21 -> 361
    //   343: aload_3
    //   344: ldc_w 789
    //   347: aload 4
    //   349: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_3
    //   353: ldc_w 791
    //   356: aload 5
    //   358: invokevirtual 228	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_3
    //   362: ldc_w 802
    //   365: aload 7
    //   367: ldc_w 802
    //   370: invokevirtual 805	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   373: invokevirtual 280	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   376: aload_3
    //   377: ldc_w 303
    //   380: bipush 9
    //   382: invokevirtual 218	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   385: aload_0
    //   386: aload_0
    //   387: getfield 310	com/tencent/mobileqq/activity/PayBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   390: aload_3
    //   391: invokestatic 315	cooperation/qwallet/plugin/QWalletPayBridge:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/os/Bundle;)Z
    //   394: pop
    //   395: return
    //   396: astore_3
    //   397: aload_3
    //   398: invokevirtual 806	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   401: aload 4
    //   403: astore_3
    //   404: goto -366 -> 38
    //   407: iconst_1
    //   408: istore_2
    //   409: goto -258 -> 151
    //   412: ldc 153
    //   414: astore_1
    //   415: goto -244 -> 171
    //   418: ldc 153
    //   420: astore 5
    //   422: goto -209 -> 213
    //   425: astore_1
    //   426: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +32 -> 461
    //   432: ldc 16
    //   434: iconst_2
    //   435: new 194	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 808
    //   445: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_1
    //   449: invokevirtual 599	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   452: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: aload_0
    //   462: aload 6
    //   464: ldc_w 810
    //   467: invokespecial 506	com/tencent/mobileqq/activity/PayBridgeActivity:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload_1
    //   471: invokevirtual 604	org/json/JSONException:printStackTrace	()V
    //   474: return
    //   475: astore_1
    //   476: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +32 -> 511
    //   482: ldc 16
    //   484: iconst_2
    //   485: new 194	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   492: ldc_w 812
    //   495: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: invokevirtual 607	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   502: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 432	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: aload_0
    //   512: aload 6
    //   514: ldc_w 814
    //   517: invokespecial 506	com/tencent/mobileqq/activity/PayBridgeActivity:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload_1
    //   521: invokevirtual 610	java/lang/Exception:printStackTrace	()V
    //   524: return
    //   525: ldc 153
    //   527: astore 4
    //   529: goto -337 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	PayBridgeActivity
    //   0	532	1	paramBundle	Bundle
    //   150	259	2	i1	int
    //   20	371	3	localObject	Object
    //   396	2	3	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   403	1	3	str1	String
    //   16	512	4	str2	String
    //   211	210	5	str3	String
    //   7	506	6	str4	String
    //   101	265	7	localJSONObject	JSONObject
    //   110	166	8	str5	String
    //   119	166	9	str6	String
    //   129	138	10	str7	String
    //   217	31	11	str8	String
    // Exception table:
    //   from	to	target	type
    //   29	38	396	java/io/UnsupportedEncodingException
    //   87	151	425	org/json/JSONException
    //   151	171	425	org/json/JSONException
    //   171	192	425	org/json/JSONException
    //   192	213	425	org/json/JSONException
    //   213	305	425	org/json/JSONException
    //   310	318	425	org/json/JSONException
    //   323	361	425	org/json/JSONException
    //   361	395	425	org/json/JSONException
    //   87	151	475	java/lang/Exception
    //   151	171	475	java/lang/Exception
    //   171	192	475	java/lang/Exception
    //   192	213	475	java/lang/Exception
    //   213	305	475	java/lang/Exception
    //   310	318	475	java/lang/Exception
    //   323	361	475	java/lang/Exception
    //   361	395	475	java/lang/Exception
  }
  
  private void i(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str1 = paramIntent.getStringExtra("callbackSn");
    String str2 = paramIntent.getStringExtra("result");
    String str3 = paramIntent.getStringExtra("upload_data");
    boolean bool = paramIntent.getBooleanExtra("isChoosePubAcc", false);
    paramIntent = paramIntent.getStringExtra("pubAcc");
    if (i1 == 1)
    {
      if ((str3 != null) && (str3.length() > 0)) {
        a(this.app, str3);
      }
      if ((bool) && (this.app != null) && (!TextUtils.isEmpty(paramIntent))) {
        PublicAccountUtil.a(this.app, this.app.a(), paramIntent);
      }
      a(str1, str2);
      return;
    }
    a(str1, b());
  }
  
  private void i(Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("offerId");
      String str2 = paramBundle.getString("userId");
      String str3 = paramBundle.getString("skey");
      String str4 = paramBundle.getString("serviceCode");
      String str5 = paramBundle.getString("serviceName");
      String str6 = paramBundle.getString("channel");
      String str7 = paramBundle.getString("uint");
      String str8 = paramBundle.getString("openMonth");
      boolean bool = paramBundle.getBoolean("isCanChange");
      String str9 = paramBundle.getString("provideUin");
      String str10 = paramBundle.getString("provideType");
      String str11 = paramBundle.getString("discountId");
      String str12 = paramBundle.getString("other");
      paramBundle = paramBundle.getString("aid");
      paramBundle = "qq_m_qq-2013-android-" + AppSetting.a + "-" + paramBundle;
      Bundle localBundle = new Bundle();
      localBundle.putString("setOfferId", str1);
      localBundle.putString("setEnv", "release");
      localBundle.putBoolean("setLogEnable", true);
      if ((str7 != null) && (str7.length() > 0)) {
        localBundle.putString("setPropUnit", str7);
      }
      if ((str6 != null) && (str6.length() > 0)) {
        localBundle.putString("setPayChannel", str6);
      }
      localBundle.putString("userId", str2);
      localBundle.putString("userKey", str3);
      localBundle.putString("sessionId", "uin");
      localBundle.putString("sessionType", "skey");
      localBundle.putString("pf", paramBundle);
      localBundle.putString("pfKey", "pfKey");
      localBundle.putString("serviceCode", str4);
      localBundle.putString("serviceName", str5);
      localBundle.putInt("resId", 0);
      if ((str8 != null) && (str8.length() > 0))
      {
        localBundle.putString("openMonth", str8);
        localBundle.putBoolean("isCanChange", Boolean.valueOf(bool).booleanValue());
      }
      localBundle.putString("remark", "");
      localBundle.putString("provideUin", str9);
      localBundle.putString("provideType", str10);
      localBundle.putString("discountId", str11);
      localBundle.putString("other", str12);
      localBundle.putInt("PayInvokerId", 10);
      QWalletPayBridge.a(this, this.app, localBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.payPayBridgeActivity", 2, "openService Exception:" + paramBundle.getMessage());
      }
      a(-5, "openService Exception", -1, -1);
      paramBundle.printStackTrace();
    }
  }
  
  private void j(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void j(Bundle paramBundle)
  {
    String str15 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity openSVip request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str15));
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramBundle.getString("json"));
        String str19 = ((JSONObject)localObject).getString("offerId");
        String str16 = ((JSONObject)localObject).getString("userId");
        String str17 = ((JSONObject)localObject).getString("serviceCode");
        String str18 = ((JSONObject)localObject).getString("serviceName");
        if (((JSONObject)localObject).has("channel"))
        {
          paramBundle = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label1079;
          }
          str1 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("openMonth")) {
            break label1085;
          }
          str2 = ((JSONObject)localObject).getString("openMonth");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label1091;
          }
          bool1 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("isAutoPay")) {
            break label1097;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isAutoPay");
          if (!((JSONObject)localObject).has("remark")) {
            break label1103;
          }
          str3 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("aid")) {
            break label1110;
          }
          str4 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("actTitle")) {
            break label1117;
          }
          str5 = ((JSONObject)localObject).getString("actTitle");
          if (!((JSONObject)localObject).has("openType")) {
            break label1124;
          }
          i1 = ((JSONObject)localObject).getInt("openType");
          if (!((JSONObject)localObject).has("actHint")) {
            break label1129;
          }
          str6 = ((JSONObject)localObject).getString("actHint");
          if (!((JSONObject)localObject).has("actPayTotal")) {
            break label1135;
          }
          str7 = ((JSONObject)localObject).getString("actPayTotal");
          if (!((JSONObject)localObject).has("actPayDiscount")) {
            break label1141;
          }
          str8 = ((JSONObject)localObject).getString("actPayDiscount");
          if (!((JSONObject)localObject).has("actBtnTitle")) {
            break label1147;
          }
          str9 = ((JSONObject)localObject).getString("actBtnTitle");
          if (!((JSONObject)localObject).has("openServicePrice")) {
            break label1153;
          }
          str10 = ((JSONObject)localObject).getString("openServicePrice");
          if (!((JSONObject)localObject).has("upgradeServicePrice")) {
            break label1159;
          }
          str11 = ((JSONObject)localObject).getString("upgradeServicePrice");
          if (!((JSONObject)localObject).has("maxUpgradeMonth")) {
            break label1165;
          }
          i2 = ((JSONObject)localObject).getInt("maxUpgradeMonth");
          if (!((JSONObject)localObject).has("openTitle")) {
            break label1170;
          }
          str12 = ((JSONObject)localObject).getString("openTitle");
          if (!((JSONObject)localObject).has("upgradeTitle")) {
            break label1177;
          }
          str13 = ((JSONObject)localObject).getString("upgradeTitle");
          if (!((JSONObject)localObject).has("discountId")) {
            break label1184;
          }
          str14 = ((JSONObject)localObject).getString("discountId");
          if (((JSONObject)localObject).has("other"))
          {
            localObject = ((JSONObject)localObject).getString("other");
            String str20 = c();
            Bundle localBundle = new Bundle();
            localBundle.putString("setOfferId", str19);
            localBundle.putString("setEnv", "release");
            localBundle.putBoolean("setLogEnable", false);
            if ((str1 != null) && (str1.length() > 0)) {
              localBundle.putString("setPropUnit", str1);
            }
            if ((paramBundle != null) && (paramBundle.length() > 0)) {
              localBundle.putString("setPayChannel", paramBundle);
            }
            localBundle.putString("callbackSn", str15);
            paramBundle = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str4;
            localBundle.putString("userId", str16);
            localBundle.putString("userKey", str20);
            localBundle.putString("sessionId", "uin");
            localBundle.putString("sessionType", "skey");
            localBundle.putString("pf", paramBundle);
            localBundle.putString("pfKey", "pfKey");
            localBundle.putString("serviceCode", str17);
            localBundle.putString("serviceName", str18);
            localBundle.putInt("resId", 0);
            if ((str2 != null) && (str2.length() > 0))
            {
              localBundle.putString("openMonth", str2);
              localBundle.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
            }
            localBundle.putBoolean("isAutoPay", Boolean.valueOf(bool2).booleanValue());
            localBundle.putString("remark", str3);
            localBundle.putString("actTitle", str5);
            localBundle.putInt("openType", i1);
            localBundle.putString("actHint", str6);
            localBundle.putString("actPayTotal", str7);
            localBundle.putString("actPayDiscount", str8);
            localBundle.putString("actBtnTitle", str9);
            localBundle.putString("openServicePrice", str10);
            localBundle.putString("upgradeServicePrice", str11);
            localBundle.putInt("maxUpgradeMonth", i2);
            localBundle.putString("openTitle", str12);
            localBundle.putString("upgradeTitle", str13);
            localBundle.putString("discountId", str14);
            localBundle.putString("other", (String)localObject);
            localBundle.putInt("PayInvokerId", 11);
            QWalletPayBridge.a(this, this.app, localBundle);
            return;
          }
          localObject = "";
          continue;
        }
        paramBundle = null;
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "openSVip JSONException:" + paramBundle.getMessage());
        }
        a(str15, "{'resultCode':-1,'resultMsg':'openSVip JSONException'}");
        paramBundle.printStackTrace();
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "openSVip Exception:" + paramBundle.getMessage());
        }
        a(str15, "{'resultCode':-1,'resultMsg':'openSVip Exception'}");
        paramBundle.printStackTrace();
        return;
      }
      continue;
      label1079:
      String str1 = null;
      continue;
      label1085:
      String str2 = null;
      continue;
      label1091:
      boolean bool1 = true;
      continue;
      label1097:
      boolean bool2 = true;
      continue;
      label1103:
      String str3 = "";
      continue;
      label1110:
      String str4 = "";
      continue;
      label1117:
      String str5 = "";
      continue;
      label1124:
      int i1 = 0;
      continue;
      label1129:
      String str6 = null;
      continue;
      label1135:
      String str7 = null;
      continue;
      label1141:
      String str8 = null;
      continue;
      label1147:
      String str9 = null;
      continue;
      label1153:
      String str10 = null;
      continue;
      label1159:
      String str11 = null;
      continue;
      label1165:
      int i2 = 0;
      continue;
      label1170:
      String str12 = "";
      continue;
      label1177:
      String str13 = "";
      continue;
      label1184:
      String str14 = "";
    }
  }
  
  private void k(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void l(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  public static boolean startGoldCharge(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean startOpenQQReaderVip(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean tenpay(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    return a(paramActivity, paramString1, paramInt, paramString2, "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427375);
    getWindow().getDecorView().setOnTouchListener(new eoy(this));
    getIntent();
    if ((getIntent() != null) && (getIntent().getExtras() == null))
    {
      finish();
      return true;
    }
    this.b = getIntent().getExtras().getBoolean("payparmas_from_is_login_state", true);
    if ((this.b) && (this.app != null) && (!PublicAccountUtil.a(this.app, "2711679534"))) {
      PublicAccountUtil.a(this.app, this.app.a(), "2711679534");
    }
    ((NotificationManager)getSystemService("notification")).cancel(128);
    this.E = getIntent().getExtras().getInt("pay_requestcode", -1);
    this.e = getIntent().getExtras().getBoolean("payparmas_from_pcpush", false);
    if (this.E == 12)
    {
      if (d)
      {
        super.finish();
        return true;
      }
      d = true;
      this.e = true;
      this.jdField_a_of_type_Boolean = true;
      if ((!mAppForground) && (this.mCanLock) && (this.app != null) && (this.app.a() != null) && (GesturePWDUtils.getJumpLock(this, this.app.a())))
      {
        super.finish();
        return true;
      }
      a(QWalletPushManager.a(this.jdField_a_of_type_Boolean));
      return true;
    }
    d = true;
    if (this.E == 1)
    {
      paramBundle = DataFactory.EmojiPayReqData.makeEmojiPayReqData(getIntent().getExtras());
      if ((paramBundle == null) || (!a(paramBundle)))
      {
        a(paramBundle, -1, 0, -1, -1, -1, "param error");
        if (paramBundle == null) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.payPayBridgeActivity", 2, "emojimall pay paramerror: reqData:null");
          }
        }
        for (;;)
        {
          d = false;
          finish();
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.payPayBridgeActivity", 2, "emojimall pay paramerror:userid:" + paramBundle.userId + "userkey:" + paramBundle.userKey + "sessionid:" + paramBundle.sessionId + "sessionType:" + paramBundle.sessionType + "zoneId:" + paramBundle.zoneId + "pf:" + paramBundle.pf + "pfKey:" + paramBundle.pfKey + "tokenUrl:" + paramBundle.tokenUrl + "discountId:" + paramBundle.discountId + "other:" + paramBundle.other);
          }
        }
      }
      a(paramBundle);
      return true;
    }
    if (this.E == 2)
    {
      a(getIntent().getExtras());
      return true;
    }
    if (this.E == 3)
    {
      b(getIntent().getExtras());
      return true;
    }
    if (this.E == 4)
    {
      c(getIntent().getExtras());
      return true;
    }
    if (this.E == 5)
    {
      d(getIntent().getExtras());
      return true;
    }
    if (this.E == 6)
    {
      f(getIntent().getExtras());
      return true;
    }
    if (this.E == 7)
    {
      e(getIntent().getExtras());
      return true;
    }
    if (this.E == 8)
    {
      g(getIntent().getExtras());
      return true;
    }
    if (this.E == 9)
    {
      h(getIntent().getExtras());
      return true;
    }
    if (this.E == 10)
    {
      i(getIntent().getExtras());
      return true;
    }
    if (this.E == 11)
    {
      j(getIntent().getExtras());
      return true;
    }
    if (this.E == 13)
    {
      paramBundle = new Bundle();
      paramBundle.putInt("PayInvokerId", 12);
      QWalletPayBridge.a(this, this.app, paramBundle);
      return true;
    }
    finish();
    return true;
  }
  
  protected void doOnResume()
  {
    if ((!this.c) && (this.bActivityToFragment)) {
      finish();
    }
    for (;;)
    {
      this.c = false;
      return;
      super.doOnResume();
    }
  }
  
  public void finish()
  {
    QWalletPushManager.a();
    int i1 = QWalletPushManager.a();
    if (i1 <= 0)
    {
      if ((!this.e) && (this.jdField_a_of_type_AndroidContentIntent != null)) {
        setResult(this.F, this.jdField_a_of_type_AndroidContentIntent);
      }
      d = false;
      super.finish();
      return;
    }
    Object localObject = String.format(getString(2131365066), new Object[] { Integer.valueOf(i1) });
    localObject = a(getString(2131369082), (String)localObject, null);
    ((Dialog)localObject).setCancelable(false);
    eoz localeoz = new eoz(this, (Dialog)localObject);
    ((Dialog)localObject).findViewById(2131297371).setOnClickListener(localeoz);
    ((Dialog)localObject).findViewById(2131297370).setOnClickListener(localeoz);
    ((Dialog)localObject).show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramInt1 == 3001)) || (paramInt2 == -1))
    {
      paramInt1 = paramIntent.getIntExtra("PayInvokerId", -1);
      switch (paramInt1)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.payPayBridgeActivity", 2, "QvipPayBridge Unknown InvokerId : " + paramInt1);
        }
        finish();
        return;
      case 7: 
        b(paramIntent);
        return;
      case 1: 
        c(paramIntent);
        return;
      case 2: 
        d(paramIntent);
        return;
      case 3: 
        e(paramIntent);
        return;
      case 10: 
        f(paramIntent);
        return;
      case 4: 
        g(paramIntent);
        return;
      case 5: 
        h(paramIntent);
        return;
      case 9: 
        i(paramIntent);
        return;
      case 6: 
        j(paramIntent);
        return;
      case 8: 
        k(paramIntent);
        return;
      case 11: 
        l(paramIntent);
        return;
      }
      a(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.payPayBridgeActivity", 2, "QvipPayBridge Unknown data");
    }
    finish();
  }
  
  protected void onDestroy()
  {
    d = false;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PayBridgeActivity
 * JD-Core Version:    0.7.0.1
 */