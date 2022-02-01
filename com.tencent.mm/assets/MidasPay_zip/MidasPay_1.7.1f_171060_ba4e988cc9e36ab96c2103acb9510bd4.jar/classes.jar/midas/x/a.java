package midas.x;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.Toast;
import com.pay.api.APAndroidPayAPI;
import com.pay.api.APPayResponse;
import com.pay.api.IAPNetCallBack;
import com.pay.api.IAPPayCallBack;
import com.pay.api.MidasAbilityResponse;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.ability.MidasActivityAbility.AbsQQShare;
import com.pay.api.ability.MidasActivityAbility.AbsWXShare;
import com.pay.api.ability.MidasBaseAbility;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APNetRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.qqwallet.APQQShareActivity;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.marketing.APWebMarketActivity;
import com.pay.ui.marketing.APX5WebMarketActivity;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.tencent.mid.local.LocalMid;
import com.tencent.midas.api.request.APIabResult;
import com.tencent.midas.api.request.APInventory;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.api.request.APQueryInventoryFinishedListener;
import com.tencent.midas.api.request.OnAPConsumeFinishedListener;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String k = "a";
  private static volatile a l;
  public IAPPayCallBack a;
  public IAPNetCallBack b;
  public WeakReference<Activity> c;
  public Context d = null;
  public APPayResponse e = null;
  public boolean f = false;
  public ec g = null;
  public String h;
  public String i = "0";
  public String j = "";
  private boolean m = false;
  private int n = 0;
  private boolean o = true;
  private boolean p = false;
  private ResultReceiver q;
  private String r;
  private String s;
  
  private String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.signatures;
      if (paramContext != null)
      {
        if (paramContext.length == 0) {
          return null;
        }
        if (paramContext.length > 0) {
          return g.a(paramContext[0].toByteArray());
        }
        return null;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  private String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getString("wxMiniProgramPath");
    }
    if (TextUtils.isEmpty(paramBundle)) {
      return "__midas_none_loopback";
    }
    paramBundle = APTools.b(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("__midasLoopback")))
    {
      paramBundle = (String)paramBundle.get("__midasLoopback");
      if (TextUtils.isEmpty(paramBundle)) {
        return "__midas_empty_loopback";
      }
      return paramBundle;
    }
    return "__midas_none_loopback";
  }
  
  public static a a()
  {
    if (l == null) {
      try
      {
        if (l == null)
        {
          l = new a();
          l.n = 0;
          l.o = true;
        }
      }
      finally {}
    }
    return l;
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0))
    {
      APAppDataInterface.singleton().c(-1);
      return;
    }
    APAppDataInterface.singleton().c(paramInt);
  }
  
  private void a(final Context paramContext, final MidasActivityAbility paramMidasActivityAbility)
  {
    bs.a().a(paramMidasActivityAbility, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        paramAnonymousjw = (bu)paramAnonymousjw;
        int i = paramAnonymousjw.R();
        if (i == 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("orderId", paramAnonymousjw.a());
          localBundle.putString("shareUrl", paramAnonymousjw.d());
          a.a(a.this, paramContext, paramMidasActivityAbility, paramAnonymousjw, localBundle);
          return;
        }
        MidasAbilityResponse.onFailureCGI(paramMidasActivityAbility, i, paramAnonymousjw.T(), new Bundle());
      }
      
      public void b(jw paramAnonymousjw)
      {
        paramAnonymousjw = (bu)paramAnonymousjw;
        MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, -3, paramAnonymousjw.T(), new Bundle());
      }
      
      public void c(jw paramAnonymousjw)
      {
        APLog.d("APAndroidPay", "toPreEnjoySign() network.onStop");
      }
    });
  }
  
  private void a(Context paramContext, final MidasActivityAbility paramMidasActivityAbility, bu parambu, Bundle paramBundle)
  {
    if ("present".equals(paramMidasActivityAbility.action))
    {
      APGoodsRequest localAPGoodsRequest = new APGoodsRequest();
      localAPGoodsRequest.offerId = paramMidasActivityAbility.offerId;
      localAPGoodsRequest.openId = paramMidasActivityAbility.openId;
      localAPGoodsRequest.openKey = paramMidasActivityAbility.openKey;
      localAPGoodsRequest.sessionId = paramMidasActivityAbility.sessionId;
      localAPGoodsRequest.sessionType = paramMidasActivityAbility.sessionType;
      localAPGoodsRequest.zoneId = paramMidasActivityAbility.zoneId;
      localAPGoodsRequest.pf = paramMidasActivityAbility.pf;
      localAPGoodsRequest.pfKey = paramMidasActivityAbility.pfKey;
      localAPGoodsRequest.saveValue = "1";
      localAPGoodsRequest.isCanChange = false;
      localAPGoodsRequest.acctType = paramMidasActivityAbility.acctType;
      localAPGoodsRequest.tokenType = 1;
      if (TextUtils.isEmpty(paramMidasActivityAbility.reserv))
      {
        paramBundle = paramMidasActivityAbility.others;
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append(paramMidasActivityAbility.others);
        paramBundle.append("&req_reserv=");
        paramBundle.append(APTools.a(paramMidasActivityAbility.reserv, 1));
        paramBundle = paramBundle.toString();
      }
      localAPGoodsRequest.reserv = paramBundle;
      localAPGoodsRequest.mpInfo.payChannel = paramMidasActivityAbility.mpInfo.payChannel;
      localAPGoodsRequest.extendInfo.isShowNum = paramMidasActivityAbility.extendInfo.isShowNum;
      localAPGoodsRequest.extendInfo.isShowListOtherNum = paramMidasActivityAbility.extendInfo.isShowListOtherNum;
      localAPGoodsRequest.remark = paramMidasActivityAbility.remark;
      paramBundle = String.format("/v1/r/%s/mobile_goods_info", new Object[] { localAPGoodsRequest.offerId });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("?midastype=present&token_id=");
      localStringBuilder.append(parambu.a());
      localAPGoodsRequest.goodsTokenUrl = localStringBuilder.toString();
      parambu = new StringBuilder();
      parambu.append("goodsRequest = ");
      parambu.append(localAPGoodsRequest.toString());
      APLog.d("APAndroidPay", parambu.toString());
      if ((paramContext instanceof Activity)) {
        APAndroidPayAPI.launchPay((Activity)paramContext, localAPGoodsRequest, new IAPPayCallBack()
        {
          public void MidasPayCallBack(APPayResponse paramAnonymousAPPayResponse)
          {
            Bundle localBundle = new Bundle();
            if (paramAnonymousAPPayResponse != null)
            {
              localBundle.putInt("resultCode", paramAnonymousAPPayResponse.resultCode);
              localBundle.putInt("resultInerCode", paramAnonymousAPPayResponse.resultInerCode);
              localBundle.putInt("realSaveNum", paramAnonymousAPPayResponse.realSaveNum);
              localBundle.putInt("payChannel", paramAnonymousAPPayResponse.payChannel);
              localBundle.putInt("payState", paramAnonymousAPPayResponse.payState);
              localBundle.putInt("provideState", paramAnonymousAPPayResponse.provideState);
              localBundle.putString("extendInfo", paramAnonymousAPPayResponse.extendInfo);
              localBundle.putString("resultMsg", paramAnonymousAPPayResponse.resultMsg);
              localBundle.putString("payReserve1", paramAnonymousAPPayResponse.payReserve1);
              localBundle.putString("payReserve2", paramAnonymousAPPayResponse.payReserve2);
              localBundle.putString("payReserve3", paramAnonymousAPPayResponse.payReserve3);
              if (paramAnonymousAPPayResponse.mAPPurchase != null)
              {
                localBundle.putString("purchaseJson", paramAnonymousAPPayResponse.mAPPurchase.mOriginalJson);
                localBundle.putString("purchaseSign", paramAnonymousAPPayResponse.mAPPurchase.mSignature);
              }
            }
            else
            {
              localBundle.putString("msg", "midas sdk responseInfo is Null");
            }
            if (paramAnonymousAPPayResponse.resultCode == 0)
            {
              MidasAbilityResponse.onSuccess(paramMidasActivityAbility, 0, localBundle);
              return;
            }
            if (paramAnonymousAPPayResponse.resultCode == 2)
            {
              MidasAbilityResponse.onCancel(paramMidasActivityAbility, 1, localBundle);
              return;
            }
            MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, paramAnonymousAPPayResponse.resultCode, "Payment callback failure", localBundle);
          }
          
          public void MidasPayNeedLogin()
          {
            MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, -5, "Login invalid, need reLogin", new Bundle());
          }
        });
      }
    }
    else
    {
      if (!"ask".equals(paramMidasActivityAbility.action)) {
        break label515;
      }
      if ((paramMidasActivityAbility.shareInfo instanceof MidasActivityAbility.AbsQQShare))
      {
        paramBundle.putString("qqMiniUrl", parambu.j());
        paramBundle.putString("qqMiniPath", parambu.i());
        paramBundle.putString("qqMiniId", parambu.h());
        APQQShareActivity.a(paramContext, parambu.b(), paramMidasActivityAbility, paramBundle);
        return;
      }
      if ((paramMidasActivityAbility.shareInfo instanceof MidasActivityAbility.AbsWXShare))
      {
        paramBundle.putString("wxMiniUrl", parambu.f());
        paramBundle.putString("wxMiniPath", parambu.e());
        paramBundle.putString("wxMiniOriId", parambu.g());
        new fg(paramContext, parambu.c()).a(paramContext, paramMidasActivityAbility, paramBundle);
      }
    }
    return;
    label515:
    paramContext = new StringBuilder();
    paramContext.append("Unsupported request.action : ");
    paramContext.append(paramMidasActivityAbility.action);
    MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, -4, paramContext.toString(), new Bundle());
  }
  
  private void a(Context paramContext, MidasBaseAbility paramMidasBaseAbility)
  {
    Object localObject = new APGameRequest();
    ((APGameRequest)localObject).offerId = paramMidasBaseAbility.offerId;
    ((APGameRequest)localObject).openId = paramMidasBaseAbility.openId;
    ((APGameRequest)localObject).openKey = paramMidasBaseAbility.openKey;
    ((APGameRequest)localObject).sessionId = paramMidasBaseAbility.sessionId;
    ((APGameRequest)localObject).sessionType = paramMidasBaseAbility.sessionType;
    ((APGameRequest)localObject).pf = paramMidasBaseAbility.pf;
    ((APGameRequest)localObject).pfKey = paramMidasBaseAbility.pfKey;
    ((APGameRequest)localObject).zoneId = "1";
    b(paramContext, (APBaseRequest)localObject);
    p();
    d(paramContext, paramMidasBaseAbility);
    localObject = new ec((APBaseRequest)localObject);
    ed.b().a((ec)localObject);
    this.g = ((ec)localObject);
    localObject = fp.a();
    ((fp)localObject).d(APTools.h());
    ((fp)localObject).o(paramMidasBaseAbility.others);
    l.f = false;
    a().d = paramContext.getApplicationContext();
  }
  
  private static void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (paramContext == null)
    {
      APLog.e(k, "Cannot load key from disk with null context!");
      return;
    }
    if (paramAPBaseRequest == null)
    {
      APLog.e(k, "Cannot load key from disk with null request!");
      return;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openId))
    {
      APLog.e(k, "Cannot load key from disk without open id!");
      return;
    }
    paramAPBaseRequest = paramAPBaseRequest.openId;
    paramContext = paramContext.getApplicationContext();
    String str = ed.b().f();
    bs.a().b(paramContext, paramAPBaseRequest, str, "1.7.1f");
  }
  
  private void a(APBaseRequest paramAPBaseRequest, HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("midas_friendspayurl");
    if (TextUtils.isEmpty(paramHashMap)) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("midas_friendspayurl=");
    ((StringBuilder)localObject1).append(paramHashMap);
    paramHashMap = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramHashMap);
    ((StringBuilder)localObject1).append("&");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&");
    ((StringBuilder)localObject2).append(paramHashMap);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramAPBaseRequest.reserv.contains((CharSequence)localObject1))
    {
      paramAPBaseRequest.reserv = paramAPBaseRequest.reserv.replace((CharSequence)localObject1, "");
      return;
    }
    if (paramAPBaseRequest.reserv.contains((CharSequence)localObject2))
    {
      paramAPBaseRequest.reserv = paramAPBaseRequest.reserv.replace((CharSequence)localObject2, "");
      return;
    }
    paramAPBaseRequest.reserv = paramAPBaseRequest.reserv.replace(paramHashMap, "");
  }
  
  public static void a(String paramString)
  {
    APAppDataInterface.singleton().setEnv(paramString);
    bt.a(paramString);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    paramContext = new APAlertDialog.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    paramContext.a("确定", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        fm.d();
        paramAnonymousAPAlertDialog.a();
      }
    });
    paramContext.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          fm.d();
          paramAnonymousAPAlertDialog.a();
        }
      }
    });
    try
    {
      paramContext.c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    o();
    fp.a().k(APTools.e((Context)l.c.get()));
    fp.a().l(APTools.d((Context)l.c.get()));
    fp.a().m(APTools.c());
    fp.a().b(0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, kl paramkl)
  {
    paramString1 = new de(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString9, paramString10);
    paramString2 = new dd(paramString8, paramkl);
    bs.a().a(paramString1, paramString2);
  }
  
  public static void a(boolean paramBoolean) {}
  
  private void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    a().d = paramContext.getApplicationContext();
    APAppDataInterface.singleton().o(APTools.t(paramContext));
    if ((paramAPBaseRequest != null) && (ed.b().n() == null))
    {
      localObject = new ec(paramAPBaseRequest);
      ed.b().a((ec)localObject);
      this.p = true;
    }
    if ((paramContext instanceof Activity)) {
      l.c = new WeakReference((Activity)paramContext);
    }
    APAppDataInterface.singleton().a(paramContext.getResources().getConfiguration().orientation);
    int i1 = fy.a(a().d);
    APAppDataInterface.singleton().b(i1);
    Object localObject = k.a(paramContext.getApplicationContext()).a();
    APAppDataInterface.singleton().f((String)localObject);
    d(paramContext, paramAPBaseRequest);
    c(paramContext.getApplicationContext(), paramAPBaseRequest);
    APAppDataInterface.singleton().p("");
    bt.a(paramContext.getApplicationContext());
    a(paramContext, paramAPBaseRequest);
    StringBuilder localStringBuilder2;
    try
    {
      localObject = LocalMid.getInstance(paramContext.getApplicationContext()).getLocalMid();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("GlobalInitialize（） xgMid=");
      localStringBuilder2.append((String)localObject);
      APLog.d("APAndroidPay", localStringBuilder2.toString());
      if (LocalMid.getInstance(paramContext.getApplicationContext()).isMidValid((String)localObject)) {
        APAppDataInterface.singleton().c(APTools.a((String)localObject, 1));
      }
      fp.a().k(APTools.e(paramContext.getApplicationContext()));
      fp.a().l(APTools.d(paramContext.getApplicationContext()));
      fp.a().m(APTools.c());
      fp.a().q(APTools.d());
      fp.a().s(APTools.e());
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(" plugin version");
    localStringBuilder1.append(APAppDataInterface.singleton().m());
    APLog.i("GlobalInitialize", localStringBuilder1.toString());
    if (paramAPBaseRequest != null) {
      try
      {
        a(paramAPBaseRequest.offerId, paramAPBaseRequest.openId);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Init platform got exception = ");
        localStringBuilder2.append(localException2);
        APLog.e("initPlatform", localStringBuilder2.toString());
      }
    }
    n();
    hs.a(paramContext.getApplicationContext());
    if ((paramAPBaseRequest != null) && (this.o)) {
      try
      {
        new b().a();
        this.o = false;
        return;
      }
      catch (Exception paramContext)
      {
        APLog.i("GlobalInitialize APGetNetInfo", paramContext.toString());
      }
    }
  }
  
  private void b(APBaseRequest paramAPBaseRequest)
  {
    this.i = "0";
    this.j = "";
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      HashMap localHashMap = APTools.b(paramAPBaseRequest.reserv);
      if (localHashMap != null)
      {
        if (!TextUtils.isEmpty((CharSequence)localHashMap.get("midas_friendspay")))
        {
          String str = (String)localHashMap.get("midas_friendspay");
          if ((paramAPBaseRequest instanceof APGoodsRequest))
          {
            this.i = "0";
          }
          else if (str.equals("1"))
          {
            this.i = "1";
            if (!TextUtils.isEmpty((CharSequence)localHashMap.get("midas_friendspayurl"))) {
              try
              {
                this.j = URLDecoder.decode((String)localHashMap.get("midas_friendspayurl"), "UTF-8");
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                localUnsupportedEncodingException.printStackTrace();
              }
            }
          }
          else if ((localUnsupportedEncodingException.equals("2")) && (!TextUtils.isEmpty(paramAPBaseRequest.saveValue)))
          {
            this.i = "2";
          }
        }
        a(paramAPBaseRequest, localHashMap);
      }
    }
  }
  
  public static void b(String paramString)
  {
    APAppDataInterface.singleton().b(paramString);
  }
  
  private void c(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (this.n > 0) {
      return;
    }
    fo.a();
    APTools.a(paramContext);
    APTools.setKey(APTools.e);
    APTools.p(paramContext);
    if (l.c != null)
    {
      paramAPBaseRequest = APTools.a((Activity)l.c.get());
      APAppDataInterface.singleton().a(paramAPBaseRequest);
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, paramAPBaseRequest);
    }
    if ((Build.VERSION.SDK_INT >= 28) && (APTools.q(paramContext))) {
      try
      {
        WebView.setDataDirectorySuffix("midaspay");
      }
      catch (Throwable paramAPBaseRequest)
      {
        paramAPBaseRequest.printStackTrace();
      }
    }
    paramAPBaseRequest = APPluginUtils.getMidasCoreVersionName(paramContext);
    APAppDataInterface.singleton().e(paramAPBaseRequest);
    a(paramContext);
    paramAPBaseRequest = ((Activity)this.c.get()).getApplicationContext().getPackageName();
    if (!"com.tencent.unipay".equals(paramAPBaseRequest))
    {
      localObject = a(((Activity)this.c.get()).getApplicationContext(), paramAPBaseRequest);
      fp.a().A(paramAPBaseRequest);
      fp.a().B((String)localObject);
    }
    try
    {
      paramAPBaseRequest = LocalMid.getInstance(paramContext).getLocalMid();
      if (LocalMid.getInstance(paramContext.getApplicationContext()).isMidValid(paramAPBaseRequest)) {
        APAppDataInterface.singleton().c(APTools.a(paramAPBaseRequest, 1));
      }
    }
    catch (Exception paramAPBaseRequest)
    {
      paramAPBaseRequest.printStackTrace();
    }
    int i2 = "1.3.9e".compareToIgnoreCase(APAppDataInterface.singleton().m());
    int i1 = 0;
    boolean bool;
    if (i2 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("isNeedExtra:");
    paramAPBaseRequest.append(bool);
    paramAPBaseRequest.append(" initso:");
    paramAPBaseRequest.append(this.m);
    APLog.i("initOnce", paramAPBaseRequest.toString());
    if ((!this.m) && (bool))
    {
      paramAPBaseRequest = APPluginUtils.getInstallPathString(paramContext, "MidasPay");
      localObject = APPluginUtils.getLibPath(paramContext);
      if ((localObject != null) && (!TextUtils.isEmpty(paramAPBaseRequest))) {
        APTools.c(paramAPBaseRequest, ((File)localObject).getAbsolutePath());
      }
      this.m = true;
      APLog.i("initOnce", "init so done");
    }
    if (APTools.a(paramContext, "com.eg.android.AlipayGphone")) {
      APDataReportManager.getInstance().insertData("sdk.wsj.isInstall", -1, null, "1", null);
    } else {
      APDataReportManager.getInstance().insertData("sdk.wsj.isInstall", -1, null, "0", null);
    }
    paramAPBaseRequest = APTools.c(paramContext, "com.tencent.mobileqq");
    if (!TextUtils.isEmpty(paramAPBaseRequest))
    {
      APAppDataInterface.singleton().i(APTools.a(paramAPBaseRequest, 1));
      APAppDataInterface.singleton().g("1");
    }
    else
    {
      APAppDataInterface.singleton().i("");
      APAppDataInterface.singleton().g("0");
    }
    paramAPBaseRequest = APTools.c(paramContext, "com.tencent.mm");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wechatversion：");
    ((StringBuilder)localObject).append(paramAPBaseRequest);
    APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramAPBaseRequest))
    {
      APAppDataInterface.singleton().j(paramAPBaseRequest);
      APAppDataInterface.singleton().h("1");
    }
    else
    {
      APAppDataInterface.singleton().j("");
      APAppDataInterface.singleton().h("0");
    }
    try
    {
      paramAPBaseRequest = paramContext.getApplicationContext().getPackageManager();
      paramAPBaseRequest = paramAPBaseRequest.getPackageInfo(paramAPBaseRequest.getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
      while (i1 < paramAPBaseRequest.length)
      {
        if (paramAPBaseRequest[i1].name.equals("com.tencent.midas.qq.APMidasQQWalletActivity")) {
          fe.a(true);
        }
        i1 += 1;
      }
    }
    catch (Exception paramAPBaseRequest)
    {
      label603:
      break label603;
    }
    System.loadLibrary("unipayutils");
    APTools.l();
    if (this.n == 0) {
      this.n = i.a(new fq().a(paramContext, "TencentUnipay", "intCt"));
    }
    this.n += 1;
    new fq().a(paramContext.getApplicationContext(), "TencentUnipay", "intCt", String.valueOf(this.n));
  }
  
  private void c(APBaseRequest paramAPBaseRequest)
  {
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.b(paramAPBaseRequest.reserv);
      if (paramAPBaseRequest != null) {
        if (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("wechattype")))
        {
          paramAPBaseRequest = (String)paramAPBaseRequest.get("wechattype");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("wechattype=");
          localStringBuilder.append(paramAPBaseRequest);
          APLog.d("APAndroidPay", localStringBuilder.toString());
          if ("sign".equals(paramAPBaseRequest))
          {
            new fg(this.d).b();
            return;
          }
          if (!"unsign".equals(paramAPBaseRequest)) {
            break label266;
          }
          paramAPBaseRequest = new APAlertDialog.a((Context)this.c.get());
          paramAPBaseRequest.b("解除微信小额免密支付");
          paramAPBaseRequest.a("确认解除微信小额免密支付服务吗？\n1.仅限小额支付，大额仍然需要密码验证\n2.此操作仅在本应用有效。");
          paramAPBaseRequest.a("确定", new gn()
          {
            public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              paramAnonymousAPAlertDialog.a();
              new fg(a.this.d).c();
            }
          });
          paramAPBaseRequest.b(new gn()
          {
            public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousAPAlertDialog.a();
                APUICommonMethod.b();
                fm.a(3, "unsign getcardbillinfo stop");
              }
            }
          });
        }
      }
    }
    label266:
    try
    {
      paramAPBaseRequest.c();
      return;
    }
    catch (Exception paramAPBaseRequest) {}
    if (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("qqtype")))
    {
      paramAPBaseRequest = (String)paramAPBaseRequest.get("qqtype");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("wechattype=");
      localStringBuilder.append(paramAPBaseRequest);
      APLog.d("APAndroidPay", localStringBuilder.toString());
      if ("sign".equals(paramAPBaseRequest))
      {
        q();
        return;
      }
      "unsign".equals(paramAPBaseRequest);
    }
    return;
  }
  
  public static void c(String paramString)
  {
    APAppDataInterface.singleton().d(paramString);
  }
  
  public static boolean c()
  {
    Object localObject = ed.b().n();
    if ((localObject != null) && ((((ec)localObject).a instanceof APGoodsRequest)))
    {
      localObject = ((APGoodsRequest)((ec)localObject).a).goodsTokenUrl;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("midastype=present"))) {
        return true;
      }
    }
    return false;
  }
  
  private void d(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (paramAPBaseRequest == null) {
      return;
    }
    String str = paramAPBaseRequest.reserv;
    if ((paramAPBaseRequest instanceof MidasBaseAbility)) {
      str = ((MidasBaseAbility)paramAPBaseRequest).configs;
    }
    try
    {
      fp.a().w("");
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty(str)))
      {
        Object localObject1 = APTools.b(str);
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((HashMap)localObject1).get("wechatSignVersion"))))
        {
          localObject1 = (String)((HashMap)localObject1).get("wechatSignVersion");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wechat sign version: ");
          localStringBuilder.append((String)localObject1);
          APLog.i("APAndroidPay", localStringBuilder.toString());
          fp.a().w((String)localObject1);
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      APAppDataInterface.singleton().f(false);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty(str)))
      {
        HashMap localHashMap = APTools.b(str);
        if ((localHashMap != null) && (!TextUtils.isEmpty((CharSequence)localHashMap.get("midas_http_type"))) && ("1".equals((String)localHashMap.get("midas_http_type")))) {
          APAppDataInterface.singleton().f(true);
        }
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    try
    {
      APAppDataInterface.singleton().g(true);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty(str)))
      {
        Object localObject2 = APTools.b(str);
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)((HashMap)localObject2).get("midas_encrypt_type"))))
        {
          localObject2 = (String)((HashMap)localObject2).get("midas_encrypt_type");
          APAppDataInterface.singleton().g("1".equals(localObject2));
        }
      }
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
    if (paramAPBaseRequest != null) {
      try
      {
        if (!TextUtils.isEmpty(str))
        {
          paramAPBaseRequest = APTools.b(str);
          if (paramAPBaseRequest != null)
          {
            paramAPBaseRequest = (String)paramAPBaseRequest.get("enableX5");
            if (!TextUtils.isEmpty(paramAPBaseRequest))
            {
              if (new fq().a(paramContext.getApplicationContext(), "TencentUnipay", "enableX5").equals("2"))
              {
                APLog.e("AndroidPay", "current operation is invalid, cause midas set force X5");
                return;
              }
              if (paramAPBaseRequest.equals("0"))
              {
                hs.a(paramContext, "0");
                return;
              }
              if (paramAPBaseRequest.equals("1"))
              {
                hs.a(paramContext, "1");
                return;
              }
              paramContext = new StringBuilder();
              paramContext.append("invalid command in reserve param: ");
              paramContext.append(paramAPBaseRequest);
              paramContext.append(", pass \"0\" or \"1\"");
              APLog.e("AndroidPay", paramContext.toString());
              return;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void d(APBaseRequest paramAPBaseRequest)
  {
    e(paramAPBaseRequest);
    fp localfp = fp.a();
    localfp.d(APTools.h());
    localfp.o(paramAPBaseRequest.reserv);
  }
  
  private String e(String paramString)
  {
    paramString = APTools.c(paramString);
    if ((paramString != null) && (paramString.containsKey("__midasLoopback")))
    {
      paramString = (String)paramString.get("__midasLoopback");
      if (TextUtils.isEmpty(paramString)) {
        return "__midas_empty_loopback";
      }
      return paramString;
    }
    return "__midas_none_loopback";
  }
  
  private void e(APBaseRequest paramAPBaseRequest)
  {
    ec localec = ed.b().n();
    try
    {
      localec.e.a = fz.a(a().d).a(localec.a.openId);
      localec.e.b = fz.a(a().d).b(localec.a.openId);
    }
    catch (Exception localException)
    {
      APLog.e("paramsInit", localException.toString());
    }
    localec.d.f = false;
    APAppDataInterface.singleton().c(paramAPBaseRequest.extendInfo.isShowNum);
    APAppDataInterface.singleton().d(paramAPBaseRequest.extendInfo.isShowListOtherNum);
    if (TextUtils.isEmpty(paramAPBaseRequest.saveValue)) {
      paramAPBaseRequest.isCanChange = true;
    }
  }
  
  private boolean f(APBaseRequest paramAPBaseRequest)
  {
    if (TextUtils.isEmpty(paramAPBaseRequest.offerId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230769));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230770));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openKey))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230771));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.sessionId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230779));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.sessionType))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230780));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.pf))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230775));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.pfKey))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230776));
      return false;
    }
    return true;
  }
  
  private void n()
  {
    try
    {
      try
      {
        Class.forName("com.tencent.bugly.crashreport.CrashReport").getMethod("initCrashReport", new Class[] { Context.class, String.class, Boolean.TYPE }).invoke((Class)null, new Object[] { this.d, "900045921", Boolean.valueOf(false) });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label107:
      break label107;
    }
    APLog.w("GlobalInitialize", "not has bugly sdk.");
    new Thread(new Runnable()
    {
      public void run()
      {
        SharedPreferences.Editor localEditor = a.this.d.getSharedPreferences("BuglySdkInfos", 0).edit();
        localEditor.putString("900045921", "1.7.1f");
        localEditor.commit();
      }
    }).start();
  }
  
  private void o()
  {
    String str2 = APTools.e("MidasDeviceId");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = APTools.h();
      APTools.b("MidasDeviceId", str1);
    }
    APLog.i("MidasDeviceId", str1);
    fp.a().j(str1);
  }
  
  private void p()
  {
    String str;
    APAppDataInterface localAPAppDataInterface;
    StringBuilder localStringBuilder;
    if (a().g())
    {
      if ("1".equals(APAppDataInterface.singleton().r()))
      {
        str = APAppDataInterface.singleton().t();
        localAPAppDataInterface = APAppDataInterface.singleton();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("wx");
        localStringBuilder.append(str);
        localAPAppDataInterface.n(localStringBuilder.toString());
        return;
      }
      APAppDataInterface.singleton().n("wxUninstall");
      return;
    }
    if (a().h())
    {
      if (a().i())
      {
        if ("1".equals(APAppDataInterface.singleton().r()))
        {
          str = APAppDataInterface.singleton().t();
          localAPAppDataInterface = APAppDataInterface.singleton();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("itopWx");
          localStringBuilder.append(str);
          localAPAppDataInterface.n(localStringBuilder.toString());
          return;
        }
        APAppDataInterface.singleton().n("itopWxUninstall");
        return;
      }
      if (a().k())
      {
        if ("1".equals(APAppDataInterface.singleton().q()))
        {
          str = APAppDataInterface.singleton().s();
          localAPAppDataInterface = APAppDataInterface.singleton();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("itopQQ");
          localStringBuilder.append(str);
          localAPAppDataInterface.n(localStringBuilder.toString());
          return;
        }
        APAppDataInterface.singleton().n("itopQQUninstall");
      }
    }
    else
    {
      if (d.a())
      {
        APAppDataInterface.singleton().n("other");
        return;
      }
      if (d.b())
      {
        APAppDataInterface.singleton().n("none");
        return;
      }
      if ("1".equals(APAppDataInterface.singleton().q()))
      {
        str = APAppDataInterface.singleton().s();
        localAPAppDataInterface = APAppDataInterface.singleton();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("qq");
        localStringBuilder.append(str);
        localAPAppDataInterface.n(localStringBuilder.toString());
        return;
      }
      APAppDataInterface.singleton().n("qqUninstall");
    }
  }
  
  private void q()
  {
    bs.a().f(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        if (paramAnonymousjw.R() == 0)
        {
          localObject = ((dp)paramAnonymousjw).a();
          Activity localActivity = (Activity)a.m().c.get();
          if (localActivity != null)
          {
            fe.a(localActivity, (String)localObject);
            APUICommonMethod.b();
            fm.a(2, -1, -1);
            return;
          }
          APUICommonMethod.b();
          fm.a(3, "sign onFinish err: fromActivity==Null", paramAnonymousjw.U());
          return;
        }
        APUICommonMethod.b();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sign onFinish err: ");
        ((StringBuilder)localObject).append(paramAnonymousjw.S());
        fm.a(3, ((StringBuilder)localObject).toString(), paramAnonymousjw.U());
      }
      
      public void b(jw paramAnonymousjw)
      {
        APUICommonMethod.b();
        fm.a(3, "sign mobile_sign_contract onError");
      }
      
      public void c(jw paramAnonymousjw)
      {
        APUICommonMethod.b();
        fm.a(3, "sign mobile_sign_contract stop");
      }
    });
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchWXMiniProgram_OnResponse() resultCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", resultData=");
    ((StringBuilder)localObject).append(paramBundle);
    APLog.d("APAndroidPay", ((StringBuilder)localObject).toString());
    if (paramBundle == null) {
      localObject = "";
    } else {
      localObject = paramBundle.getString("extMsg");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.s = e((String)localObject);
    } else {
      this.s = "__midas_none_loopback";
    }
    if (this.q == null)
    {
      APLog.w("APAndroidPay", "launchWXMiniProgram_OnResponse miniProgramResultReceiver == Null");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchWXMiniProgram_OnResponse reqLoopback=");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append(", respLoopback=");
    ((StringBuilder)localObject).append(this.s);
    APLog.w("APAndroidPay", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.r)) && (!TextUtils.isEmpty(this.s)) && (this.r.equals(this.s)))
    {
      this.q.send(paramInt, paramBundle);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("launchWXMiniProgram_OnResponse failure: reqLoopback=");
    paramBundle.append(this.r);
    paramBundle.append(", respLoopback=");
    paramBundle.append(this.s);
    APLog.w("APAndroidPay", paramBundle.toString());
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest)
  {
    b(paramActivity, paramAPBaseRequest);
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    APUICommonMethod.e();
    fp.b();
    com.pay.ui.recoChannel.APRecoChannelActivity.b = false;
    ec localec = new ec(paramAPBaseRequest);
    ed.b().a(localec);
    this.g = localec;
    a().d = paramActivity.getApplicationContext();
    if (au.a()) {
      fp.a().m(true);
    } else {
      fp.a().m(false);
    }
    a(paramActivity, paramAPBaseRequest);
    a(paramActivity, paramAPBaseRequest);
    p();
    APDataReportManager.getInstance().insertData("sdk.launchpay.enter", paramAPBaseRequest.saveType, paramAPBaseRequest.openId, APAppDataInterface.singleton().l(), paramAPBaseRequest.getReportInfo());
    if (!f(paramAPBaseRequest))
    {
      fm.a(3, paramActivity.getString(2131230773));
      return;
    }
    b(paramAPBaseRequest);
    fp.a().d(APTools.h());
    l.f = false;
    if ((TextUtils.isEmpty(paramAPBaseRequest.mpInfo.payChannel)) && (!TextUtils.isEmpty(paramAPBaseRequest.mpInfo.discountType)) && (!TextUtils.isEmpty(paramAPBaseRequest.mpInfo.discountUrl))) {
      if (("hy_gameid".equals(paramAPBaseRequest.sessionId)) && ("wc_actoken".equals(paramAPBaseRequest.sessionType))) {
        paramAPBaseRequest.mpInfo.payChannel = "wechat";
      } else if (("openid".equals(paramAPBaseRequest.sessionId)) && ("kp_actoken".equals(paramAPBaseRequest.sessionType))) {
        paramAPBaseRequest.mpInfo.payChannel = "bank";
      }
    }
    e(paramAPBaseRequest);
    if (bg.a().a(paramActivity))
    {
      if (!bg.a().d())
      {
        bg.a().b(paramActivity);
        return;
      }
      bg.a().a(paramActivity, paramAPBaseRequest, paramIAPPayCallBack);
      return;
    }
    APLog.i("APAndroidPayAPI pay request = ", paramAPBaseRequest.toString());
    APLog.i("APAndroidPayAPI pay request reserv = ", paramAPBaseRequest.reserv);
    fp.a().n(false);
    fp.a().C("");
    if ((paramAPBaseRequest instanceof APGoodsRequest))
    {
      paramIAPPayCallBack = (APGoodsRequest)paramAPBaseRequest;
      if (paramIAPPayCallBack.mIsReceiptMode)
      {
        fp.a().n(true);
        fp.a().C(paramIAPPayCallBack.developerPayload);
      }
      else
      {
        fp.a().n(false);
        fp.a().C("");
      }
    }
    fp.a().o(paramAPBaseRequest.reserv);
    if (a(paramAPBaseRequest))
    {
      fp.a().b(true);
      f();
      return;
    }
    if (fm.a(paramAPBaseRequest))
    {
      c(paramAPBaseRequest);
      return;
    }
    if (fm.b(paramAPBaseRequest))
    {
      fp.a().b(true);
      paramAPBaseRequest = new Intent();
      paramIAPPayCallBack = new Bundle();
      paramIAPPayCallBack.putString("pageName", hj.z);
      paramAPBaseRequest.putExtras(paramIAPPayCallBack);
      if (hs.b(paramActivity.getApplicationContext())) {
        paramAPBaseRequest.setClass(paramActivity, APX5WebJSBridgeActivity.class);
      } else {
        paramAPBaseRequest.setClass(paramActivity, APWebJSBridgeActivity.class);
      }
      paramActivity.startActivity(paramAPBaseRequest);
      return;
    }
    es.a().a(paramActivity, paramAPBaseRequest);
  }
  
  public void a(Activity paramActivity, APNetRequest paramAPNetRequest, final IAPNetCallBack paramIAPNetCallBack)
  {
    ec localec = new ec(paramAPNetRequest);
    ed.b().a(localec);
    this.g = localec;
    fp.b();
    fp.a().o(paramAPNetRequest.reserv);
    a(paramActivity, paramAPNetRequest);
    a(paramActivity, paramAPNetRequest);
    p();
    if (paramAPNetRequest.reqType.equals(APNetRequest.NET_REQ_MP))
    {
      a(paramAPNetRequest.openId, paramAPNetRequest.openKey, paramAPNetRequest.sessionId, paramAPNetRequest.sessionType, paramAPNetRequest.zoneId, paramAPNetRequest.pf, paramAPNetRequest.pfKey, paramAPNetRequest.reqType, paramAPNetRequest.mpInfo.drmInfo, paramAPNetRequest.reserv, new kl()
      {
        public void a(jw paramAnonymousjw)
        {
          paramAnonymousjw = (dd)paramAnonymousjw;
          paramIAPNetCallBack.MidasNetFinish(paramAnonymousjw.a, paramAnonymousjw.a());
        }
        
        public void b(jw paramAnonymousjw)
        {
          paramIAPNetCallBack.MidasNetError(((dd)paramAnonymousjw).a, paramAnonymousjw.R(), paramAnonymousjw.T());
        }
        
        public void c(jw paramAnonymousjw)
        {
          paramIAPNetCallBack.MidasNetStop(((dd)paramAnonymousjw).a);
        }
      });
      return;
    }
    if (paramAPNetRequest.reqType.equals(APNetRequest.NET_REQ_QQ))
    {
      try
      {
        e(paramAPNetRequest);
        a(paramAPNetRequest.offerId, paramAPNetRequest.openId);
      }
      catch (Exception paramActivity)
      {
        APLog.e("APAndroidPay net NET_REQ_QQ", paramActivity.toString());
      }
      new b().a(paramAPNetRequest, paramIAPNetCallBack);
      return;
    }
    paramIAPNetCallBack.MidasNetError(APNetRequest.NET_REQ_MP, -1, "APMidasNetRequest param<reqType> error");
  }
  
  public void a(Activity paramActivity, String paramString, APBaseRequest paramAPBaseRequest, final IAPNetCallBack paramIAPNetCallBack)
  {
    this.b = paramIAPNetCallBack;
    this.h = paramString;
    ec localec = new ec(paramAPBaseRequest);
    ed.b().a(localec);
    this.g = localec;
    fp.b();
    fp.a().o(paramAPBaseRequest.reserv);
    a(paramActivity, paramAPBaseRequest);
    a(paramActivity, paramAPBaseRequest);
    APLog.i("APAndroidPay info reqType", paramString);
    if (paramString.equals(APNetRequest.NET_REQ_MP))
    {
      a(paramAPBaseRequest.openId, paramAPBaseRequest.openKey, paramAPBaseRequest.sessionId, paramAPBaseRequest.sessionType, paramAPBaseRequest.zoneId, paramAPBaseRequest.pf, paramAPBaseRequest.pfKey, paramString, paramAPBaseRequest.mpInfo.drmInfo, paramAPBaseRequest.reserv, new kl()
      {
        public void a(jw paramAnonymousjw)
        {
          paramAnonymousjw = (dd)paramAnonymousjw;
          paramIAPNetCallBack.MidasNetFinish(paramAnonymousjw.a, paramAnonymousjw.a());
        }
        
        public void b(jw paramAnonymousjw)
        {
          dd localdd = (dd)paramAnonymousjw;
          paramIAPNetCallBack.MidasNetError(localdd.a, paramAnonymousjw.R(), paramAnonymousjw.T());
        }
        
        public void c(jw paramAnonymousjw)
        {
          paramAnonymousjw = (dd)paramAnonymousjw;
          paramIAPNetCallBack.MidasNetStop(paramAnonymousjw.a);
        }
      });
      return;
    }
    if (paramString.equals(APNetRequest.NET_REQ_FRIENDSPAY))
    {
      try
      {
        e(paramAPBaseRequest);
        a(paramAPBaseRequest.offerId, paramAPBaseRequest.openId);
      }
      catch (Exception paramActivity)
      {
        APLog.e("APAndroidPay net NET_REQ_QQ", paramActivity.toString());
      }
      d(paramAPBaseRequest);
      b(paramAPBaseRequest);
      new b().a(this.b);
      return;
    }
    paramIAPNetCallBack.MidasNetError(APNetRequest.NET_REQ_MP, -1, "APMidasNetRequest param<reqType> error");
  }
  
  public void a(Activity paramActivity, JSONObject paramJSONObject)
  {
    a().d = paramActivity.getApplicationContext();
    l.f = false;
    fp.a().b(true);
    a(paramActivity, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jsonObj:");
    localStringBuilder.append(paramJSONObject.toString());
    APLog.i("launchSign", localStringBuilder.toString());
    try
    {
      if ((paramJSONObject.optString("wxSignVersion", "").toLowerCase().equals("v2")) && (!TextUtils.isEmpty(paramJSONObject.optString("wxPreEntrustWebId"))))
      {
        APDataReportManager.getInstance().insertData("sdk.h5.wechat.sign", -1, "", "sign", "");
        new fg(paramActivity, paramJSONObject.optString("appId")).a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), paramJSONObject.optString("wxPreEntrustWebId"), "");
        return;
      }
      if ((paramJSONObject.has("wxSignUrl")) && (!TextUtils.isEmpty(paramJSONObject.optString("wxSignUrl"))))
      {
        APDataReportManager.getInstance().insertData("sdk.h5.wechat.sign", -1, "", "sign", "");
        new fg(paramActivity, paramJSONObject.optString("appId")).a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), "", APTools.b(paramJSONObject.optString("wxSignUrl"), 1));
        return;
      }
      if ((paramJSONObject.has("qqwalletSignUrl")) && (!TextUtils.isEmpty(paramJSONObject.optString("qqwalletSignUrl"))))
      {
        fe.a(paramActivity, paramJSONObject.optString("qqwalletSignUrl"));
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void a(Activity paramActivity, JSONObject paramJSONObject, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    a().d = paramActivity.getApplicationContext();
    l.f = false;
    fp.a().b(true);
    a(paramActivity, null);
    try
    {
      fg localfg = new fg(paramActivity, paramJSONObject.optString("appId"));
      paramIAPPayCallBack = "";
      if (!paramJSONObject.has("payType"))
      {
        Toast.makeText(paramActivity, "PayType 不能为空", 1).show();
        return;
      }
      Object localObject = paramJSONObject.optString("payType");
      if ("1".equals(localObject))
      {
        localfg.a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), APTools.b(paramJSONObject.optString("wxPreEntrustWebId"), 1), APTools.b(paramJSONObject.optString("wxSignUrl"), 1));
        APUICommonMethod.b();
        return;
      }
      if ("2".equals(localObject))
      {
        if (paramJSONObject.has("extends")) {
          paramIAPPayCallBack = paramJSONObject.optString("extends");
        }
        if (paramJSONObject.has("wxSignUrl")) {
          fp.a().y(paramJSONObject.optString("wxSignUrl"));
        }
        localObject = new APSubscribeRequest();
        if (paramJSONObject.has("offerId")) {
          ((APBaseRequest)localObject).offerId = paramJSONObject.optString("offerId");
        }
        if (paramJSONObject.has("openId")) {
          ((APBaseRequest)localObject).openId = paramJSONObject.optString("openId");
        }
        if (paramJSONObject.has("openKey")) {
          ((APBaseRequest)localObject).openKey = paramJSONObject.optString("openKey");
        }
        if (paramJSONObject.has("sessionId")) {
          ((APBaseRequest)localObject).sessionId = paramJSONObject.optString("sessionId");
        }
        if (paramJSONObject.has("sessiontType")) {
          ((APBaseRequest)localObject).sessionType = paramJSONObject.optString("sessiontType");
        }
        if (paramJSONObject.has("pf")) {
          ((APBaseRequest)localObject).pf = paramJSONObject.optString("pf");
        }
        if (paramJSONObject.has("pfKey")) {
          ((APBaseRequest)localObject).pfKey = paramJSONObject.optString("pfKey");
        }
        a(paramActivity, (APBaseRequest)localObject);
        if (ed.b().n() == null)
        {
          paramActivity = new ec((APBaseRequest)localObject);
          ed.b().a(paramActivity);
        }
        paramActivity = paramJSONObject.optString("appId");
        localObject = paramJSONObject.optString("bargainorId");
        String str1 = paramJSONObject.optString("tokenId");
        String str2 = paramJSONObject.optString("nonceStr");
        String str3 = paramJSONObject.optString("timeStamp");
        String str4 = paramJSONObject.optString("packageValue");
        String str5 = paramJSONObject.optString("sign");
        String str6 = paramJSONObject.optString("wxSignVersion");
        String str7 = paramJSONObject.optString("wxSignUrl");
        String str8 = paramJSONObject.optString("wxPreEntrustWebId");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramJSONObject.optInt("payType"));
        localfg.a(paramActivity, (String)localObject, str1, str2, str3, str4, str5, str6, str7, str8, localStringBuilder.toString(), paramIAPPayCallBack);
        APDataReportManager.getInstance().insertData("sdk.h5.wechat.paysign", -1, "", "pay", paramJSONObject.optString("tokenId"));
        return;
      }
      APUICommonMethod.b();
      paramActivity = new StringBuilder();
      paramActivity.append("payType=");
      paramActivity.append((String)localObject);
      paramActivity.append("  不支持");
      fm.a(3, paramActivity.toString());
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = paramContext.getApplicationContext();
    int i1 = 0;
    localObject = ((Context)localObject).getDir("midasplugins", 0).listFiles();
    if (localObject != null)
    {
      int i2 = localObject.length;
      for (;;)
      {
        if ((i2 > 0) && (i1 < i2)) {
          try
          {
            if (localObject[i1].getName().startsWith("MidasCore"))
            {
              String str = new au(paramContext).a(localObject[i1]);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("resultData=版本号");
              localStringBuilder.append(str);
              APLog.i("APbuypage", localStringBuilder.toString());
              fp.a().n(str);
            }
            i1 += 1;
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle, final ResultReceiver paramResultReceiver)
  {
    this.r = a(paramBundle);
    this.q = paramResultReceiver;
    String str1 = paramBundle.getString("wxAppId");
    String str2 = paramBundle.getString("wxMiniProgramId");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      new fg(paramContext, str1).a(paramBundle, new ResultReceiver(new Handler())
      {
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wechatAPI.onReceiveResult resultCode = ");
          localStringBuilder.append(paramAnonymousInt);
          localStringBuilder.append(", resultData = ");
          localStringBuilder.append(paramAnonymousBundle);
          APLog.d("APAndroidPay", localStringBuilder.toString());
          if (paramAnonymousBundle.getInt("type") == 19) {
            paramResultReceiver.send(0, paramAnonymousBundle);
          }
        }
      });
      return;
    }
    APLog.e("APAndroidPay", "wx_appId or wx_userName is empty");
    paramContext = new Bundle();
    paramContext.putString("resultMsg", "wx_appId or wx_userName is empty");
    paramResultReceiver.send(-1, paramContext);
  }
  
  public void a(Context paramContext, MidasBaseAbility paramMidasBaseAbility, ResultReceiver paramResultReceiver)
  {
    a(paramContext, paramMidasBaseAbility);
    MidasAbilityResponse.push(paramResultReceiver);
    APDataReportManager.getInstance().insertData("sdk.launchability.enter", 0, paramMidasBaseAbility.openId, APAppDataInterface.singleton().l(), paramMidasBaseAbility.toString());
    if ((paramMidasBaseAbility instanceof MidasActivityAbility))
    {
      a(paramContext, (MidasActivityAbility)paramMidasBaseAbility);
      return;
    }
    MidasAbilityResponse.onFailureSDK(paramMidasBaseAbility, -1, "不识别的Req", new Bundle());
  }
  
  public void a(APPayResponse paramAPPayResponse)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("payCallBack resultCode:");
    ((StringBuilder)localObject).append(paramAPPayResponse.resultCode);
    APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
    bs.a().b();
    APUICommonMethod.g();
    is.b();
    try
    {
      APLog.i("getDeviceInfo:", APAppDataInterface.singleton().j());
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, APAppDataInterface.singleton().j());
      localObject = APDataReportManager.getInstance();
      String str1 = ed.b().n().a.openId;
      String str2 = APAppDataInterface.singleton().l();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramAPPayResponse.resultCode));
      localStringBuilder.append("-");
      localStringBuilder.append(String.valueOf(paramAPPayResponse.resultInerCode));
      ((APDataReportManager)localObject).insertData("sdk.callback.exit", 0, str1, str2, localStringBuilder.toString());
      paramAPPayResponse.extendInfo = String.valueOf(ed.b().n().a.saveType);
      paramAPPayResponse.payReserve1 = String.valueOf(ed.b().n().a.reserv);
      paramAPPayResponse.payReserve2 = String.valueOf(ed.b().n().a.pf);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      new Handler().postDelayed(new a(null), 200L);
    }
    catch (Exception localException2)
    {
      APLog.i("paycallback report", localException2.toString());
    }
    if (this.a != null)
    {
      this.a.MidasPayCallBack(paramAPPayResponse);
      this.a = null;
    }
    try
    {
      gd.b();
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
    com.pay.ui.recoChannel.APRecoChannelActivity.b = false;
    try
    {
      APUICommonMethod.e();
      APUICommonMethod.f();
      fs.b();
      this.g = null;
      ey.i();
      es.b();
      ed.b().n().a();
      gd.b();
      com.pay.ui.recoChannel.APRecoChannelActivity.a = null;
      APTools.c = 0L;
      fw.a().b();
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
    try
    {
      new fq().a(this.d, "TencentUnipay", "launchpaycalling", "0");
      av.b(this.d);
      return;
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
  }
  
  public void a(List<APPurchase> paramList, final OnAPConsumeFinishedListener paramOnAPConsumeFinishedListener)
  {
    if (ed.b().n().a == null)
    {
      APDataReportManager.getInstance().insertData("sdk.result.receipt.consumreq", -1, null, "requestisnull", ed.b().n().a.toString());
      APLog.e("APAndroidPay", "consumeAsync enter request is null");
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.result.receipt.consumreq", -1, null, "requestisnotnull", ed.b().n().a.toString());
    Object localObject1 = k;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("consumeAsync:");
    ((StringBuilder)localObject2).append(paramList.size());
    APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new JSONArray();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("data", ((APPurchase)paramList.get(i1)).getOriginalJson());
        ((JSONObject)localObject2).put("sign", ((APPurchase)paramList.get(i1)).getSignature());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((JSONArray)localObject1).put(localObject2);
      i1 += 1;
    }
    bs.a().c(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("consumeAsync onFinish ret :");
        ((StringBuilder)localObject).append(paramAnonymousjw.R());
        APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
        if (paramAnonymousjw.R() == 0)
        {
          localObject = new APInventory(((dh)paramAnonymousjw).a);
          paramOnAPConsumeFinishedListener.onConsumeFinished(((APInventory)localObject).getPurchaseList());
          APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
          int i = paramAnonymousjw.R();
          paramAnonymousjw = new StringBuilder();
          paramAnonymousjw.append("size=");
          paramAnonymousjw.append(String.valueOf(((APInventory)localObject).mPurchaseMap.size()));
          localAPDataReportManager.insertData("sdk.result.receipt.comsumans", -1, null, String.valueOf(i), paramAnonymousjw.toString());
          return;
        }
        paramOnAPConsumeFinishedListener.onConsumeFinished(null);
        APDataReportManager.getInstance().insertData("sdk.result.receipt.comsumans", -1, null, String.valueOf(paramAnonymousjw.R()), null);
      }
      
      public void b(jw paramAnonymousjw)
      {
        APLog.i("APAndroidPay", "consumeAsync onError");
        paramOnAPConsumeFinishedListener.onConsumeFinished(null);
        APDataReportManager.getInstance().insertData("sdk.result.receipt.comsumans", -1, null, "onError", null);
      }
      
      public void c(jw paramAnonymousjw)
      {
        APLog.i("APAndroidPay", "consumeAsync onStop");
        paramOnAPConsumeFinishedListener.onConsumeFinished(null);
      }
    }, ((JSONArray)localObject1).toString());
  }
  
  public void a(kl paramkl)
  {
    bs.a().l(paramkl);
  }
  
  public void a(boolean paramBoolean, List<?> paramList, final APQueryInventoryFinishedListener paramAPQueryInventoryFinishedListener)
  {
    APLog.i(k, "queryInventoryAsync enter ");
    if (ed.b().n().a == null)
    {
      APDataReportManager.getInstance().insertData("sdk.result.receipt.queryreq", -1, null, "requestisnull", ed.b().n().a.toString());
      APLog.e("APAndroidPay", "queryInventoryAsync enter mAPBaseRequest is null");
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.result.receipt.queryreq", -1, null, "requestisnotnull", ed.b().n().a.toString());
    bs.a().b(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("queryInventoryAsync Ans onFinish ret:");
        ((StringBuilder)localObject1).append(paramAnonymousjw.R());
        APLog.i("APAndroidPay", ((StringBuilder)localObject1).toString());
        if (paramAnonymousjw.R() == 0)
        {
          Object localObject2 = new APIabResult(paramAnonymousjw.R(), paramAnonymousjw.T());
          localObject1 = new APInventory(((dh)paramAnonymousjw).a);
          paramAPQueryInventoryFinishedListener.onQueryInventoryFinished((APIabResult)localObject2, (APInventory)localObject1);
          localObject2 = APDataReportManager.getInstance();
          int i = paramAnonymousjw.R();
          paramAnonymousjw = new StringBuilder();
          paramAnonymousjw.append("size=");
          paramAnonymousjw.append(String.valueOf(((APInventory)localObject1).mPurchaseMap.size()));
          ((APDataReportManager)localObject2).insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(i), paramAnonymousjw.toString());
          return;
        }
        localObject1 = new APIabResult(paramAnonymousjw.R(), paramAnonymousjw.T());
        paramAPQueryInventoryFinishedListener.onQueryInventoryFinished((APIabResult)localObject1, null);
        APDataReportManager.getInstance().insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(paramAnonymousjw.R()), null);
      }
      
      public void b(jw paramAnonymousjw)
      {
        APDataReportManager.getInstance().insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(paramAnonymousjw.R()), "onError");
        APLog.i("APAndroidPay", "queryInventoryAsync Ans onError");
        paramAnonymousjw = new APIabResult(paramAnonymousjw.R(), paramAnonymousjw.T());
        paramAPQueryInventoryFinishedListener.onQueryInventoryFinished(paramAnonymousjw, null);
      }
      
      public void c(jw paramAnonymousjw)
      {
        APLog.i("APAndroidPay", "queryInventoryAsync Ans onStop");
        paramAnonymousjw = new APIabResult(paramAnonymousjw.R(), paramAnonymousjw.T());
        paramAPQueryInventoryFinishedListener.onQueryInventoryFinished(paramAnonymousjw, null);
      }
    }, "");
  }
  
  public boolean a(APBaseRequest paramAPBaseRequest)
  {
    String str1 = paramAPBaseRequest.mpInfo.payChannel;
    String str2 = paramAPBaseRequest.mpInfo.discountType;
    paramAPBaseRequest = paramAPBaseRequest.mpInfo.discountUrl;
    if ((!str1.equals("wechat")) && (!str1.equals("bank"))) {
      return false;
    }
    return (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramAPBaseRequest));
  }
  
  public Context b()
  {
    return this.d;
  }
  
  public void b(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    paramIAPPayCallBack = new ec(paramAPBaseRequest);
    if (this.p) {
      ed.b().a(paramIAPPayCallBack);
    }
    a().d = paramActivity.getApplicationContext();
    a(paramActivity, paramAPBaseRequest);
    p();
    if (!f(paramAPBaseRequest))
    {
      fm.a(3, paramActivity.getString(2131230773));
      return;
    }
    l.f = false;
    fp.a().b(true);
    paramAPBaseRequest = new Intent();
    if (hs.b(paramActivity)) {
      paramAPBaseRequest.setClass(paramActivity, APX5WebJSBridgeActivity.class);
    } else {
      paramAPBaseRequest.setClass(paramActivity, APWebJSBridgeActivity.class);
    }
    paramActivity.startActivity(paramAPBaseRequest);
  }
  
  public int d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("话费券回滚hfCouponsRollBack，strJson=");
    localStringBuilder.append(paramString);
    APLog.i("话费券回滚3", localStringBuilder.toString());
    APUICommonMethod.b();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("card_list");
      if ((paramString != null) && (paramString.length() > 0) && (!"1".equals(paramString.getJSONObject(0).optString("is_succ")))) {
        bs.a().k(new kl()
        {
          public void a(jw paramAnonymousjw)
          {
            APLog.i("APAndroidPay", "插话费卡券onFinish");
          }
          
          public void b(jw paramAnonymousjw)
          {
            APLog.i("APAndroidPay", "插话费卡券onError");
          }
          
          public void c(jw paramAnonymousjw)
          {
            APLog.i("APAndroidPay", "插话费卡券onStop");
          }
        });
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    fm.a(ed.b().n().e.a(), 0, 0);
    return 1;
  }
  
  public void d()
  {
    if (this.a != null)
    {
      is.b();
      es.b();
      gd.b();
      this.g = null;
      this.a.MidasPayNeedLogin();
      this.a = null;
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, APAppDataInterface.singleton().j());
      APDataReportManager.getInstance().insertData("sdk.callback.exit", 0, ed.b().n().a.openId, APAppDataInterface.singleton().l(), String.valueOf(1018));
      new Handler().postDelayed(new a(null), 200L);
      return;
    }
    catch (Exception localException)
    {
      APLog.i("paycallback report", localException.toString());
    }
  }
  
  public boolean e()
  {
    String str = ed.b().n().a.mpInfo.payChannel;
    return (str.equals("wechat")) || (str.equals("bank"));
  }
  
  public void f()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (hs.b((Context)this.c.get()))
    {
      localBundle.putString("loadUI", "showStartActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass((Context)this.c.get(), APX5WebMarketActivity.class);
    }
    else
    {
      localBundle.putString("loadUI", "showStartActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass((Context)this.c.get(), APWebMarketActivity.class);
    }
    ((Activity)this.c.get()).startActivity(localIntent);
  }
  
  public boolean g()
  {
    Object localObject1 = ed.b().n();
    boolean bool2 = false;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((ec)localObject1).a;
    if (localObject2 == null) {
      return false;
    }
    localObject1 = ((APBaseRequest)localObject2).sessionId;
    localObject2 = ((APBaseRequest)localObject2).sessionType;
    boolean bool1 = bool2;
    if ("hy_gameid".equals(localObject1))
    {
      bool1 = bool2;
      if ("wc_actoken".equals(localObject2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean h()
  {
    Object localObject = ed.b().n();
    if (localObject == null) {
      return false;
    }
    localObject = ((ec)localObject).a;
    if (localObject == null) {
      return false;
    }
    return "itopid".equals(((APBaseRequest)localObject).sessionId);
  }
  
  public boolean i()
  {
    boolean bool1 = h();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    String str1 = fp.a().ak();
    String str2 = fp.a().al();
    bool1 = bool2;
    if ("hy_gameid".equals(str1))
    {
      bool1 = bool2;
      if ("wc_actoken".equals(str2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean j()
  {
    return (g()) || (i());
  }
  
  public boolean k()
  {
    boolean bool1 = h();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    String str1 = fp.a().ak();
    String str2 = fp.a().al();
    bool1 = bool2;
    if ("openid".equals(str1))
    {
      bool1 = bool2;
      if ("kp_actoken".equals(str2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean l()
  {
    Object localObject = new fq().a(this.d, "TencentUnipay", "launchpaycalling");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCallIng launchpaycalling ");
    localStringBuilder.append((String)localObject);
    APLog.i("APAndroidPay", localStringBuilder.toString());
    if (this.a == null)
    {
      if ("1".equals(localObject)) {
        return true;
      }
      if (this.d != null)
      {
        localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)this.d.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isCallIng topActivity = ");
        localStringBuilder.append(((ComponentName)localObject).getClassName());
        APLog.d("APAndroidPay", localStringBuilder.toString());
        if (((ComponentName)localObject).getClassName().contains("com.tencent.midas.proxyactivity")) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      bs.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.a
 * JD-Core Version:    0.7.0.1
 */