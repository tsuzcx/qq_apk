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
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
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
  private static final String l = "a";
  private static volatile a m;
  public IAPPayCallBack a;
  public IAPNetCallBack b;
  public WeakReference<Activity> c;
  public Context d = null;
  public APPayResponse e = null;
  public boolean f = false;
  public el g = null;
  public String h;
  public String i = "0";
  public String j = "";
  public ResultReceiver k;
  private boolean n = false;
  private int o = 0;
  private boolean p = true;
  private boolean q = false;
  private ResultReceiver r;
  private String s;
  private String t;
  
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
    if (m == null) {
      try
      {
        if (m == null)
        {
          m = new a();
          m.o = 0;
          m.p = true;
        }
      }
      finally {}
    }
    return m;
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
    by.a().a(paramMidasActivityAbility, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        paramAnonymouslh = (ca)paramAnonymouslh;
        int i = paramAnonymouslh.T();
        if (i == 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("orderId", paramAnonymouslh.a());
          localBundle.putString("shareUrl", paramAnonymouslh.d());
          a.a(a.this, paramContext, paramMidasActivityAbility, paramAnonymouslh, localBundle);
          return;
        }
        MidasAbilityResponse.onFailureCGI(paramMidasActivityAbility, i, paramAnonymouslh.V(), new Bundle());
      }
      
      public void b(lh paramAnonymouslh)
      {
        paramAnonymouslh = (ca)paramAnonymouslh;
        MidasAbilityResponse.onFailureSDK(paramMidasActivityAbility, -3, paramAnonymouslh.V(), new Bundle());
      }
      
      public void c(lh paramAnonymouslh)
      {
        APLog.d("APAndroidPay", "toPreEnjoySign() network.onStop");
      }
    });
  }
  
  private void a(Context paramContext, final MidasActivityAbility paramMidasActivityAbility, ca paramca, Bundle paramBundle)
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
      localStringBuilder.append(paramca.a());
      localAPGoodsRequest.goodsTokenUrl = localStringBuilder.toString();
      paramca = new StringBuilder();
      paramca.append("goodsRequest = ");
      paramca.append(localAPGoodsRequest.toString());
      APLog.d("APAndroidPay", paramca.toString());
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
        paramBundle.putString("qqMiniUrl", paramca.j());
        paramBundle.putString("qqMiniPath", paramca.i());
        paramBundle.putString("qqMiniId", paramca.h());
        APQQShareActivity.a(paramContext, paramca.b(), paramMidasActivityAbility, paramBundle);
        return;
      }
      if ((paramMidasActivityAbility.shareInfo instanceof MidasActivityAbility.AbsWXShare))
      {
        paramBundle.putString("wxMiniUrl", paramca.f());
        paramBundle.putString("wxMiniPath", paramca.e());
        paramBundle.putString("wxMiniOriId", paramca.g());
        new fp(paramContext, paramca.c()).a(paramContext, paramMidasActivityAbility, paramBundle);
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
    a(paramContext, (APBaseRequest)localObject, null);
    p();
    c(paramContext, paramMidasBaseAbility);
    localObject = new el((APBaseRequest)localObject);
    em.b().a((el)localObject);
    this.g = ((el)localObject);
    localObject = fy.a();
    ((fy)localObject).d(APTools.h());
    ((fy)localObject).o(paramMidasBaseAbility.others);
    m.f = false;
    a().d = paramContext.getApplicationContext();
  }
  
  private static void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (paramContext == null)
    {
      APLog.e(l, "Cannot load key from disk with null context!");
      return;
    }
    if (paramAPBaseRequest == null)
    {
      APLog.e(l, "Cannot load key from disk with null request!");
      return;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openId))
    {
      APLog.e(l, "Cannot load key from disk without open id!");
      return;
    }
    paramAPBaseRequest = paramAPBaseRequest.openId;
    paramContext = paramContext.getApplicationContext();
    String str = em.b().f();
    by.a().b(paramContext, paramAPBaseRequest, str, "1.7.4");
  }
  
  private void a(Context paramContext, APBaseRequest paramAPBaseRequest, ResultReceiver paramResultReceiver)
  {
    this.k = paramResultReceiver;
    a().d = paramContext.getApplicationContext();
    APAppDataInterface.singleton().o(APTools.r(paramContext));
    if ((paramAPBaseRequest != null) && (em.b().n() == null))
    {
      paramResultReceiver = new el(paramAPBaseRequest);
      em.b().a(paramResultReceiver);
      this.q = true;
    }
    if ((paramContext instanceof Activity)) {
      m.c = new WeakReference((Activity)paramContext);
    }
    APAppDataInterface.singleton().a(paramContext.getResources().getConfiguration().orientation);
    int i1 = gi.a(a().d);
    APAppDataInterface.singleton().b(i1);
    paramResultReceiver = k.a(paramContext.getApplicationContext()).a();
    APAppDataInterface.singleton().f(paramResultReceiver);
    c(paramContext, paramAPBaseRequest);
    b(paramContext.getApplicationContext(), paramAPBaseRequest);
    APAppDataInterface.singleton().p("");
    bz.a(paramContext.getApplicationContext());
    a(paramContext, paramAPBaseRequest);
    StringBuilder localStringBuilder;
    try
    {
      paramResultReceiver = LocalMid.getInstance(paramContext.getApplicationContext()).getLocalMid();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GlobalInitialize（） xgMid=");
      localStringBuilder.append(paramResultReceiver);
      APLog.d("APAndroidPay", localStringBuilder.toString());
      if (LocalMid.getInstance(paramContext.getApplicationContext()).isMidValid(paramResultReceiver)) {
        APAppDataInterface.singleton().c(APTools.a(paramResultReceiver, 1));
      }
      fy.a().k(APTools.e(paramContext.getApplicationContext()));
      fy.a().l(APTools.d(paramContext.getApplicationContext()));
      fy.a().m(APTools.c());
      fy.a().q(APTools.d());
      fy.a().s(APTools.e());
    }
    catch (Exception paramResultReceiver)
    {
      paramResultReceiver.printStackTrace();
    }
    paramResultReceiver = new StringBuilder();
    paramResultReceiver.append(" plugin version");
    paramResultReceiver.append(APAppDataInterface.singleton().m());
    APLog.i("GlobalInitialize", paramResultReceiver.toString());
    if (paramAPBaseRequest != null) {
      try
      {
        a(paramAPBaseRequest.offerId, paramAPBaseRequest.openId);
      }
      catch (Exception paramResultReceiver)
      {
        paramResultReceiver.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Init platform got exception = ");
        localStringBuilder.append(paramResultReceiver);
        APLog.e("initPlatform", localStringBuilder.toString());
      }
    }
    n();
    id.a(paramContext.getApplicationContext());
    if ((paramAPBaseRequest != null) && (this.p)) {
      try
      {
        new b().a();
        this.p = false;
        return;
      }
      catch (Exception paramContext)
      {
        APLog.i("GlobalInitialize APGetNetInfo", paramContext.toString());
      }
    }
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
    bz.a(paramString);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    paramContext = new APAlertDialog.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    paramContext.a("确定", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        fv.d();
        paramAnonymousAPAlertDialog.a();
      }
    });
    paramContext.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          fv.d();
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
    fy.a().k(APTools.e((Context)m.c.get()));
    fy.a().l(APTools.d((Context)m.c.get()));
    fy.a().m(APTools.c());
    fy.a().b(0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, lw paramlw)
  {
    paramString1 = new dk(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString9, paramString10);
    paramString2 = new dj(paramString8, paramlw);
    by.a().a(paramString1, paramString2);
  }
  
  public static void a(boolean paramBoolean) {}
  
  private void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (this.o > 0) {
      return;
    }
    fx.a();
    APTools.a(paramContext);
    APTools.setKey(APTools.e);
    APTools.p(paramContext);
    if (m.c != null)
    {
      paramAPBaseRequest = APTools.a((Activity)m.c.get());
      APAppDataInterface.singleton().a(paramAPBaseRequest);
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, paramAPBaseRequest);
    }
    paramAPBaseRequest = APPluginUtils.getMidasCoreVersionName(paramContext);
    APAppDataInterface.singleton().e(paramAPBaseRequest);
    a(paramContext);
    paramAPBaseRequest = ((Activity)this.c.get()).getApplicationContext().getPackageName();
    if (!"com.tencent.unipay".equals(paramAPBaseRequest))
    {
      localObject = a(((Activity)this.c.get()).getApplicationContext(), paramAPBaseRequest);
      fy.a().A(paramAPBaseRequest);
      fy.a().B((String)localObject);
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
    paramAPBaseRequest.append(this.n);
    APLog.i("initOnce", paramAPBaseRequest.toString());
    if ((!this.n) && (bool))
    {
      paramAPBaseRequest = APPluginUtils.getInstallPathString(paramContext, "MidasPay");
      localObject = APPluginUtils.getLibPath(paramContext);
      if ((localObject != null) && (!TextUtils.isEmpty(paramAPBaseRequest))) {
        APTools.c(paramAPBaseRequest, ((File)localObject).getAbsolutePath());
      }
      this.n = true;
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
          fn.a(true);
        }
        i1 += 1;
      }
    }
    catch (Exception paramAPBaseRequest)
    {
      label574:
      break label574;
    }
    System.loadLibrary("unipayutils");
    APTools.l();
    if (this.o == 0) {
      this.o = i.a(new fz().a(paramContext, "TencentUnipay", "intCt"));
    }
    this.o += 1;
    new fz().a(paramContext.getApplicationContext(), "TencentUnipay", "intCt", String.valueOf(this.o));
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
    if (paramAPBaseRequest == null) {
      return;
    }
    String str = paramAPBaseRequest.reserv;
    if ((paramAPBaseRequest instanceof MidasBaseAbility)) {
      str = ((MidasBaseAbility)paramAPBaseRequest).configs;
    }
    try
    {
      fy.a().w("");
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
          fy.a().w((String)localObject1);
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
              if (new fz().a(paramContext.getApplicationContext(), "TencentUnipay", "enableX5").equals("2"))
              {
                APLog.e("AndroidPay", "current operation is invalid, cause midas set force X5");
                return;
              }
              if (paramAPBaseRequest.equals("0"))
              {
                id.a(paramContext, "0");
                return;
              }
              if (paramAPBaseRequest.equals("1"))
              {
                id.a(paramContext, "1");
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
            new fp(this.d).b();
            return;
          }
          if (!"unsign".equals(paramAPBaseRequest)) {
            break label266;
          }
          paramAPBaseRequest = new APAlertDialog.a((Context)this.c.get());
          paramAPBaseRequest.b("解除微信小额免密支付");
          paramAPBaseRequest.a("确认解除微信小额免密支付服务吗？\n1.仅限小额支付，大额仍然需要密码验证\n2.此操作仅在本应用有效。");
          paramAPBaseRequest.a("确定", new gy()
          {
            public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              paramAnonymousAPAlertDialog.a();
              new fp(a.this.d).c();
            }
          });
          paramAPBaseRequest.b(new gy()
          {
            public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousAPAlertDialog.a();
                APUICommonMethod.b();
                fv.a(3, "unsign getcardbillinfo stop");
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
    Object localObject = em.b().n();
    if ((localObject != null) && ((((el)localObject).a instanceof APGoodsRequest)))
    {
      localObject = ((APGoodsRequest)((el)localObject).a).goodsTokenUrl;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("midastype=present"))) {
        return true;
      }
    }
    return false;
  }
  
  private void d(APBaseRequest paramAPBaseRequest)
  {
    e(paramAPBaseRequest);
    fy localfy = fy.a();
    localfy.d(APTools.h());
    localfy.o(paramAPBaseRequest.reserv);
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
    el localel = em.b().n();
    try
    {
      localel.e.a = gj.a(a().d).a(localel.a.openId);
      localel.e.b = gj.a(a().d).b(localel.a.openId);
    }
    catch (Exception localException)
    {
      APLog.e("paramsInit", localException.toString());
    }
    localel.d.f = false;
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
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230770));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230771));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.openKey))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230772));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.sessionId))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230780));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.sessionType))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230781));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.pf))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230776));
      return false;
    }
    if (TextUtils.isEmpty(paramAPBaseRequest.pfKey))
    {
      APUICommonMethod.a((Context)this.c.get(), ((Activity)this.c.get()).getString(2131230777));
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
        localEditor.putString("900045921", "1.7.4");
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
    fy.a().j(str1);
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
    by.a().f(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        if (paramAnonymouslh.T() == 0)
        {
          localObject = ((dx)paramAnonymouslh).a();
          Activity localActivity = (Activity)a.m().c.get();
          if (localActivity != null)
          {
            fn.a(localActivity, (String)localObject);
            APUICommonMethod.b();
            fv.a(2, -1, -1);
            return;
          }
          APUICommonMethod.b();
          fv.a(3, "sign onFinish err: fromActivity==Null", paramAnonymouslh.W());
          return;
        }
        APUICommonMethod.b();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sign onFinish err: ");
        ((StringBuilder)localObject).append(paramAnonymouslh.U());
        fv.a(3, ((StringBuilder)localObject).toString(), paramAnonymouslh.W());
      }
      
      public void b(lh paramAnonymouslh)
      {
        APUICommonMethod.b();
        fv.a(3, "sign mobile_sign_contract onError");
      }
      
      public void c(lh paramAnonymouslh)
      {
        APUICommonMethod.b();
        fv.a(3, "sign mobile_sign_contract stop");
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
      this.t = e((String)localObject);
    } else {
      this.t = "__midas_none_loopback";
    }
    if (this.r == null)
    {
      APLog.w("APAndroidPay", "launchWXMiniProgram_OnResponse miniProgramResultReceiver == Null");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchWXMiniProgram_OnResponse reqLoopback=");
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append(", respLoopback=");
    ((StringBuilder)localObject).append(this.t);
    APLog.w("APAndroidPay", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.s)) && (!TextUtils.isEmpty(this.t)) && (this.s.equals(this.t)))
    {
      this.r.send(paramInt, paramBundle);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("launchWXMiniProgram_OnResponse failure: reqLoopback=");
    paramBundle.append(this.s);
    paramBundle.append(", respLoopback=");
    paramBundle.append(this.t);
    APLog.w("APAndroidPay", paramBundle.toString());
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest)
  {
    a(paramActivity, paramAPBaseRequest, null);
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest, ResultReceiver paramResultReceiver)
  {
    a(paramActivity, paramAPBaseRequest, null);
    bq.a().a(paramAPBaseRequest);
    if (bq.d())
    {
      bs.a().a(paramActivity, paramAPBaseRequest, paramResultReceiver);
      return;
    }
    if (paramResultReceiver != null)
    {
      paramActivity = new Bundle();
      paramActivity.putInt("code", 0);
      paramActivity.putString("msg", "");
      paramResultReceiver.send(0, paramActivity);
    }
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    if (paramIAPPayCallBack != null) {
      this.a = paramIAPPayCallBack;
    }
    APUICommonMethod.e();
    fy.b();
    com.pay.ui.recoChannel.APRecoChannelActivity.b = false;
    el localel = new el(paramAPBaseRequest);
    em.b().a(localel);
    this.g = localel;
    a().d = paramActivity.getApplicationContext();
    if (au.a()) {
      fy.a().m(true);
    } else {
      fy.a().m(false);
    }
    a(paramActivity, paramAPBaseRequest);
    a(paramActivity, paramAPBaseRequest);
    p();
    APDataReportManager.getInstance().insertData("sdk.launchpay.enter", paramAPBaseRequest.saveType, paramAPBaseRequest.openId, APAppDataInterface.singleton().l(), paramAPBaseRequest.getReportInfo());
    if (!f(paramAPBaseRequest))
    {
      fv.a(3, paramActivity.getString(2131230774));
      return;
    }
    b(paramAPBaseRequest);
    fy.a().d(APTools.h());
    m.f = false;
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
    fy.a().n(false);
    fy.a().C("");
    if ((paramAPBaseRequest instanceof APGoodsRequest))
    {
      paramIAPPayCallBack = (APGoodsRequest)paramAPBaseRequest;
      if (paramIAPPayCallBack.mIsReceiptMode)
      {
        fy.a().n(true);
        fy.a().C(paramIAPPayCallBack.developerPayload);
      }
      else
      {
        fy.a().n(false);
        fy.a().C("");
      }
    }
    fy.a().o(paramAPBaseRequest.reserv);
    bt.a().a(paramActivity, paramAPBaseRequest);
    if (a(paramAPBaseRequest))
    {
      fy.a().b(true);
      f();
      return;
    }
    if (fv.a(paramAPBaseRequest))
    {
      c(paramAPBaseRequest);
      return;
    }
    if (fv.b(paramAPBaseRequest))
    {
      fy.a().b(true);
      paramAPBaseRequest = new Intent();
      paramIAPPayCallBack = new Bundle();
      paramIAPPayCallBack.putString("pageName", hu.z);
      paramAPBaseRequest.putExtras(paramIAPPayCallBack);
      if (id.b(paramActivity.getApplicationContext())) {
        paramAPBaseRequest.setClass(paramActivity, APX5WebJSBridgeActivity.class);
      } else {
        paramAPBaseRequest.setClass(paramActivity, APWebJSBridgeActivity.class);
      }
      paramActivity.startActivity(paramAPBaseRequest);
      return;
    }
    fb.a().a(paramActivity, paramAPBaseRequest);
  }
  
  public void a(Activity paramActivity, APNetRequest paramAPNetRequest, final IAPNetCallBack paramIAPNetCallBack)
  {
    el localel = new el(paramAPNetRequest);
    em.b().a(localel);
    this.g = localel;
    fy.b();
    fy.a().o(paramAPNetRequest.reserv);
    a(paramActivity, paramAPNetRequest);
    a(paramActivity, paramAPNetRequest);
    p();
    if (paramAPNetRequest.reqType.equals(APNetRequest.NET_REQ_MP))
    {
      a(paramAPNetRequest.openId, paramAPNetRequest.openKey, paramAPNetRequest.sessionId, paramAPNetRequest.sessionType, paramAPNetRequest.zoneId, paramAPNetRequest.pf, paramAPNetRequest.pfKey, paramAPNetRequest.reqType, paramAPNetRequest.mpInfo.drmInfo, paramAPNetRequest.reserv, new lw()
      {
        public void a(lh paramAnonymouslh)
        {
          paramAnonymouslh = (dj)paramAnonymouslh;
          paramIAPNetCallBack.MidasNetFinish(paramAnonymouslh.a, paramAnonymouslh.a());
        }
        
        public void b(lh paramAnonymouslh)
        {
          paramIAPNetCallBack.MidasNetError(((dj)paramAnonymouslh).a, paramAnonymouslh.T(), paramAnonymouslh.V());
        }
        
        public void c(lh paramAnonymouslh)
        {
          paramIAPNetCallBack.MidasNetStop(((dj)paramAnonymouslh).a);
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
    el localel = new el(paramAPBaseRequest);
    em.b().a(localel);
    this.g = localel;
    fy.b();
    fy.a().o(paramAPBaseRequest.reserv);
    a(paramActivity, paramAPBaseRequest);
    a(paramActivity, paramAPBaseRequest);
    APLog.i("APAndroidPay info reqType", paramString);
    if (paramString.equals(APNetRequest.NET_REQ_MP))
    {
      a(paramAPBaseRequest.openId, paramAPBaseRequest.openKey, paramAPBaseRequest.sessionId, paramAPBaseRequest.sessionType, paramAPBaseRequest.zoneId, paramAPBaseRequest.pf, paramAPBaseRequest.pfKey, paramString, paramAPBaseRequest.mpInfo.drmInfo, paramAPBaseRequest.reserv, new lw()
      {
        public void a(lh paramAnonymouslh)
        {
          paramAnonymouslh = (dj)paramAnonymouslh;
          paramIAPNetCallBack.MidasNetFinish(paramAnonymouslh.a, paramAnonymouslh.a());
        }
        
        public void b(lh paramAnonymouslh)
        {
          dj localdj = (dj)paramAnonymouslh;
          paramIAPNetCallBack.MidasNetError(localdj.a, paramAnonymouslh.T(), paramAnonymouslh.V());
        }
        
        public void c(lh paramAnonymouslh)
        {
          paramAnonymouslh = (dj)paramAnonymouslh;
          paramIAPNetCallBack.MidasNetStop(paramAnonymouslh.a);
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
    m.f = false;
    fy.a().b(true);
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
        new fp(paramActivity, paramJSONObject.optString("appId")).a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), paramJSONObject.optString("wxPreEntrustWebId"), "");
        return;
      }
      if ((paramJSONObject.has("wxSignUrl")) && (!TextUtils.isEmpty(paramJSONObject.optString("wxSignUrl"))))
      {
        APDataReportManager.getInstance().insertData("sdk.h5.wechat.sign", -1, "", "sign", "");
        new fp(paramActivity, paramJSONObject.optString("appId")).a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), "", APTools.b(paramJSONObject.optString("wxSignUrl"), 1));
        return;
      }
      if ((paramJSONObject.has("qqwalletSignUrl")) && (!TextUtils.isEmpty(paramJSONObject.optString("qqwalletSignUrl"))))
      {
        fn.a(paramActivity, paramJSONObject.optString("qqwalletSignUrl"));
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
    m.f = false;
    fy.a().b(true);
    a(paramActivity, null);
    try
    {
      fp localfp = new fp(paramActivity, paramJSONObject.optString("appId"));
      paramIAPPayCallBack = "";
      if (!paramJSONObject.has("payType"))
      {
        Toast.makeText(paramActivity, "PayType 不能为空", 1).show();
        return;
      }
      Object localObject = paramJSONObject.optString("payType");
      if ("1".equals(localObject))
      {
        localfp.a(paramJSONObject.optString("appId"), paramJSONObject.optString("wxSignVersion"), APTools.b(paramJSONObject.optString("wxPreEntrustWebId"), 1), APTools.b(paramJSONObject.optString("wxSignUrl"), 1));
        APUICommonMethod.b();
        return;
      }
      if ("2".equals(localObject))
      {
        if (paramJSONObject.has("extends")) {
          paramIAPPayCallBack = paramJSONObject.optString("extends");
        }
        if (paramJSONObject.has("wxSignUrl")) {
          fy.a().y(paramJSONObject.optString("wxSignUrl"));
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
        if (em.b().n() == null)
        {
          paramActivity = new el((APBaseRequest)localObject);
          em.b().a(paramActivity);
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
        localfp.a(paramActivity, (String)localObject, str1, str2, str3, str4, str5, str6, str7, str8, localStringBuilder.toString(), paramIAPPayCallBack);
        APDataReportManager.getInstance().insertData("sdk.h5.wechat.paysign", -1, "", "pay", paramJSONObject.optString("tokenId"));
        return;
      }
      APUICommonMethod.b();
      paramActivity = new StringBuilder();
      paramActivity.append("payType=");
      paramActivity.append((String)localObject);
      paramActivity.append("  不支持");
      fv.a(3, paramActivity.toString());
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
              fy.a().n(str);
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
    this.s = a(paramBundle);
    this.r = paramResultReceiver;
    String str1 = paramBundle.getString("wxAppId");
    String str2 = paramBundle.getString("wxMiniProgramId");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      new fp(paramContext, str1).a(paramBundle, new ResultReceiver(new Handler())
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
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bu.a().d();
      return;
    }
    bu.a().e();
  }
  
  public void a(APPayResponse paramAPPayResponse)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("payCallBack resultCode:");
    ((StringBuilder)localObject).append(paramAPPayResponse.resultCode);
    APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
    by.a().b();
    APUICommonMethod.g();
    jd.b();
    try
    {
      APLog.i("getDeviceInfo:", APAppDataInterface.singleton().j());
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, APAppDataInterface.singleton().j());
      localObject = APDataReportManager.getInstance();
      String str1 = em.b().n().a.openId;
      String str2 = APAppDataInterface.singleton().l();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramAPPayResponse.resultCode));
      localStringBuilder.append("-");
      localStringBuilder.append(String.valueOf(paramAPPayResponse.resultInerCode));
      ((APDataReportManager)localObject).insertData("sdk.callback.exit", 0, str1, str2, localStringBuilder.toString());
      paramAPPayResponse.extendInfo = String.valueOf(em.b().n().a.saveType);
      paramAPPayResponse.payReserve1 = String.valueOf(em.b().n().a.reserv);
      paramAPPayResponse.payReserve2 = String.valueOf(em.b().n().a.pf);
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
      gn.b();
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
    try
    {
      if (bq.c()) {
        bt.a().b();
      }
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
      gc.b();
      this.g = null;
      fh.i();
      fb.b();
      em.b().n().a();
      gn.b();
      com.pay.ui.recoChannel.APRecoChannelActivity.a = null;
      APTools.c = 0L;
      gg.a().b();
    }
    catch (Exception paramAPPayResponse)
    {
      paramAPPayResponse.printStackTrace();
    }
    try
    {
      new fz().a(this.d, "TencentUnipay", "launchpaycalling", "0");
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
    if (em.b().n().a == null)
    {
      APDataReportManager.getInstance().insertData("sdk.result.receipt.consumreq", -1, null, "requestisnull", em.b().n().a.toString());
      APLog.e("APAndroidPay", "consumeAsync enter request is null");
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.result.receipt.consumreq", -1, null, "requestisnotnull", em.b().n().a.toString());
    Object localObject1 = l;
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
    by.a().c(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("consumeAsync onFinish ret :");
        ((StringBuilder)localObject).append(paramAnonymouslh.T());
        APLog.i("APAndroidPay", ((StringBuilder)localObject).toString());
        if (paramAnonymouslh.T() == 0)
        {
          localObject = new APInventory(((dp)paramAnonymouslh).a);
          paramOnAPConsumeFinishedListener.onConsumeFinished(((APInventory)localObject).getPurchaseList());
          APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
          int i = paramAnonymouslh.T();
          paramAnonymouslh = new StringBuilder();
          paramAnonymouslh.append("size=");
          paramAnonymouslh.append(String.valueOf(((APInventory)localObject).mPurchaseMap.size()));
          localAPDataReportManager.insertData("sdk.result.receipt.comsumans", -1, null, String.valueOf(i), paramAnonymouslh.toString());
          return;
        }
        paramOnAPConsumeFinishedListener.onConsumeFinished(null);
        APDataReportManager.getInstance().insertData("sdk.result.receipt.comsumans", -1, null, String.valueOf(paramAnonymouslh.T()), null);
      }
      
      public void b(lh paramAnonymouslh)
      {
        APLog.i("APAndroidPay", "consumeAsync onError");
        paramOnAPConsumeFinishedListener.onConsumeFinished(null);
        APDataReportManager.getInstance().insertData("sdk.result.receipt.comsumans", -1, null, "onError", null);
      }
      
      public void c(lh paramAnonymouslh)
      {
        APLog.i("APAndroidPay", "consumeAsync onStop");
        paramOnAPConsumeFinishedListener.onConsumeFinished(null);
      }
    }, ((JSONArray)localObject1).toString());
  }
  
  public void a(lw paramlw)
  {
    by.a().l(paramlw);
  }
  
  public void a(boolean paramBoolean, List<?> paramList, final APQueryInventoryFinishedListener paramAPQueryInventoryFinishedListener)
  {
    APLog.i(l, "queryInventoryAsync enter ");
    if (em.b().n().a == null)
    {
      APDataReportManager.getInstance().insertData("sdk.result.receipt.queryreq", -1, null, "requestisnull", em.b().n().a.toString());
      APLog.e("APAndroidPay", "queryInventoryAsync enter mAPBaseRequest is null");
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.result.receipt.queryreq", -1, null, "requestisnotnull", em.b().n().a.toString());
    by.a().b(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("queryInventoryAsync Ans onFinish ret:");
        ((StringBuilder)localObject1).append(paramAnonymouslh.T());
        APLog.i("APAndroidPay", ((StringBuilder)localObject1).toString());
        if (paramAnonymouslh.T() == 0)
        {
          Object localObject2 = new APIabResult(paramAnonymouslh.T(), paramAnonymouslh.V());
          localObject1 = new APInventory(((dp)paramAnonymouslh).a);
          paramAPQueryInventoryFinishedListener.onQueryInventoryFinished((APIabResult)localObject2, (APInventory)localObject1);
          localObject2 = APDataReportManager.getInstance();
          int i = paramAnonymouslh.T();
          paramAnonymouslh = new StringBuilder();
          paramAnonymouslh.append("size=");
          paramAnonymouslh.append(String.valueOf(((APInventory)localObject1).mPurchaseMap.size()));
          ((APDataReportManager)localObject2).insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(i), paramAnonymouslh.toString());
          return;
        }
        localObject1 = new APIabResult(paramAnonymouslh.T(), paramAnonymouslh.V());
        paramAPQueryInventoryFinishedListener.onQueryInventoryFinished((APIabResult)localObject1, null);
        APDataReportManager.getInstance().insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(paramAnonymouslh.T()), null);
      }
      
      public void b(lh paramAnonymouslh)
      {
        APDataReportManager.getInstance().insertData("sdk.result.receipt.queryans", -1, null, String.valueOf(paramAnonymouslh.T()), "onError");
        APLog.i("APAndroidPay", "queryInventoryAsync Ans onError");
        paramAnonymouslh = new APIabResult(paramAnonymouslh.T(), paramAnonymouslh.V());
        paramAPQueryInventoryFinishedListener.onQueryInventoryFinished(paramAnonymouslh, null);
      }
      
      public void c(lh paramAnonymouslh)
      {
        APLog.i("APAndroidPay", "queryInventoryAsync Ans onStop");
        paramAnonymouslh = new APIabResult(paramAnonymouslh.T(), paramAnonymouslh.V());
        paramAPQueryInventoryFinishedListener.onQueryInventoryFinished(paramAnonymouslh, null);
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
    paramIAPPayCallBack = new el(paramAPBaseRequest);
    if (this.q) {
      em.b().a(paramIAPPayCallBack);
    }
    a().d = paramActivity.getApplicationContext();
    a(paramActivity, paramAPBaseRequest);
    p();
    if (!f(paramAPBaseRequest))
    {
      fv.a(3, paramActivity.getString(2131230774));
      return;
    }
    m.f = false;
    fy.a().b(true);
    paramAPBaseRequest = new Intent();
    if (id.b(paramActivity)) {
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
        by.a().k(new lw()
        {
          public void a(lh paramAnonymouslh)
          {
            APLog.i("APAndroidPay", "插话费卡券onFinish");
          }
          
          public void b(lh paramAnonymouslh)
          {
            APLog.i("APAndroidPay", "插话费卡券onError");
          }
          
          public void c(lh paramAnonymouslh)
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
    fv.a(em.b().n().e.a(), 0, 0);
    return 1;
  }
  
  public void d()
  {
    if (this.a != null)
    {
      jd.b();
      fb.b();
      gn.b();
      this.g = null;
      this.a.MidasPayNeedLogin();
      this.a = null;
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.deviceinfo", -1, null, null, APAppDataInterface.singleton().j());
      APDataReportManager.getInstance().insertData("sdk.callback.exit", 0, em.b().n().a.openId, APAppDataInterface.singleton().l(), String.valueOf(1018));
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
    String str = em.b().n().a.mpInfo.payChannel;
    return (str.equals("wechat")) || (str.equals("bank"));
  }
  
  public void f()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (id.b((Context)this.c.get()))
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
    Object localObject1 = em.b().n();
    boolean bool2 = false;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((el)localObject1).a;
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
    Object localObject = em.b().n();
    if (localObject == null) {
      return false;
    }
    localObject = ((el)localObject).a;
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
    String str1 = fy.a().ak();
    String str2 = fy.a().al();
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
    String str1 = fy.a().ak();
    String str2 = fy.a().al();
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
    Object localObject = new fz().a(this.d, "TencentUnipay", "launchpaycalling");
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
      by.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.a
 * JD-Core Version:    0.7.0.1
 */