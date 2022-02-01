package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.a.b;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONObject;

public enum AppBrandJsApiPayService
  implements a
{
  static
  {
    AppMethodBeat.i(46710);
    lcw = new AppBrandJsApiPayService("INSTANCE");
    lcx = new AppBrandJsApiPayService[] { lcw };
    g.La("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    AppMethodBeat.o(46710);
  }
  
  private AppBrandJsApiPayService() {}
  
  public final void sendBizRedPacket(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb)
  {
    AppMethodBeat.i(174861);
    paramAppBrandStatObject = new WalletJsapiData(paramJSONObject);
    paramAppBrandStatObject.dnX = 16;
    paramJSONObject = new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174855);
        if (paramAnonymousInt1 != (AppBrandJsApiPayService.this.hashCode() & 0xFFFF))
        {
          AppMethodBeat.o(174855);
          return;
        }
        if (paramAnonymousInt2 == -1)
        {
          if (paramb != null) {
            paramb.a(1, null, null);
          }
          AppMethodBeat.o(174855);
          return;
        }
        if (paramAnonymousInt2 == 2)
        {
          if (paramb != null) {
            if (paramAnonymousIntent == null) {
              break label96;
            }
          }
          label96:
          for (paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_result_errmsg");; paramAnonymousIntent = "")
          {
            paramb.a(2, paramAnonymousIntent, null);
            AppMethodBeat.o(174855);
            return;
          }
        }
        if (paramb != null) {
          paramb.a(3, null, null);
        }
        AppMethodBeat.o(174855);
      }
    };
    paramb = new Intent();
    paramb.putExtra("key_way", 3);
    paramb.putExtra("appId", paramAppBrandStatObject.appId);
    paramb.putExtra("timeStamp", paramAppBrandStatObject.timeStamp);
    paramb.putExtra("nonceStr", paramAppBrandStatObject.nonceStr);
    paramb.putExtra("packageExt", paramAppBrandStatObject.packageExt);
    paramb.putExtra("signtype", paramAppBrandStatObject.signType);
    paramb.putExtra("paySignature", paramAppBrandStatObject.dCA);
    paramb.putExtra("key_static_from_scene", 100004);
    paramb.putExtra("url", paramAppBrandStatObject.url);
    AppBrandJsApiPayUtils.a(paramActivity, new b() {});
    AppMethodBeat.o(174861);
  }
  
  public final void startBindBankcard(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb)
  {
    AppMethodBeat.i(174860);
    AppBrandJsApiPayUtils.a(paramActivity, new b()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46700);
        if (paramAnonymousInt1 != (AppBrandJsApiPayService.this.hashCode() & 0xFFFF))
        {
          AppMethodBeat.o(46700);
          return;
        }
        if (paramAnonymousInt2 == -1)
        {
          if (paramb != null)
          {
            paramb.a(1, null, null);
            AppMethodBeat.o(46700);
          }
        }
        else if (paramb != null) {
          paramb.a(2, null, null);
        }
        AppMethodBeat.o(46700);
      }
    } {});
    AppMethodBeat.o(174860);
  }
  
  public final boolean startPay(Activity paramActivity, final h paramh, final AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb, PString paramPString)
  {
    AppMethodBeat.i(174858);
    final WalletJsapiData localWalletJsapiData = new WalletJsapiData(paramJSONObject);
    if (paramAppBrandStatObject != null)
    {
      localWalletJsapiData.dnX = WalletJsapiData.jr(paramAppBrandStatObject.scene, paramAppBrandStatObject.dJO);
      localWalletJsapiData.Fmd = WalletJsapiData.jq(paramAppBrandStatObject.scene, paramAppBrandStatObject.dJO);
    }
    localWalletJsapiData.dCC = 46;
    paramAppBrandStatObject = paramJSONObject.optString("adUxInfo");
    localWalletJsapiData.Fml = paramAppBrandStatObject;
    com.tencent.mm.plugin.t.a.t("AppBrandRuntime", "requestPayment", paramAppBrandStatObject, "data");
    paramPString.value = localWalletJsapiData.packageExt;
    if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.u(paramh)) {}
    for (paramAppBrandStatObject = (com.tencent.mm.plugin.appbrand.jsapi.nfc.c)e.K(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.class);; paramAppBrandStatObject = null)
    {
      int i = hashCode();
      paramJSONObject = new Object()
      {
        AppBrandJsApiPayService.1WxPayActivityResultAdapter lcM;
        
        final void a(int paramAnonymousInt, Intent paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason paramAnonymousPayResultCallbackReason)
        {
          AppMethodBeat.i(188496);
          paramAnonymousIntent = new AppBrandJsApiPayService.1WxPayActivityResultAdapter(this.lcC, paramAnonymousInt, paramAnonymousIntent, paramAnonymousPayResultCallbackReason);
          if ((this.lcM == null) || (this.lcM.a(paramAnonymousIntent)))
          {
            this.lcM = paramAnonymousIntent;
            if ((AppBrandJsApiPayService.1WxPayActivityResultAdapter.b(this.lcM) == AppBrandJsApiPayService.PayResultCallbackReason.lcO) && ((paramb instanceof a.c)))
            {
              paramAnonymousIntent = this.lcM.bmc();
              ((a.c)paramb).b(paramAnonymousIntent.result, paramAnonymousIntent.lcL, paramAnonymousIntent.values);
            }
          }
          AppMethodBeat.o(188496);
        }
      };
      localWalletJsapiData.Fmn = new ResultReceiver(paramJSONObject)
      {
        private final AppBrandJsApiPayService.1WxPayResultDispatcher lcI;
        
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(180264);
          paramAnonymousBundle.setClassLoader(WalletJsapiData.class.getClassLoader());
          this.lcI.a(paramAnonymousInt, new Intent().putExtras(paramAnonymousBundle), AppBrandJsApiPayService.PayResultCallbackReason.lcO);
          AppMethodBeat.o(180264);
        }
      };
      if (paramAppBrandStatObject != null) {
        paramAppBrandStatObject.blD();
      }
      boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()new e.b {}, new e.b()
      {
        public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(188497);
          paramJSONObject.a(paramAnonymousInt, paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason.lcP);
          paramAnonymousIntent = paramJSONObject;
          if (paramAnonymousIntent.kCt != null) {
            paramAnonymousIntent.kCt.blC();
          }
          AppBrandJsApiPayService.1WxPayCallbackResult local1WxPayCallbackResult = ((AppBrandJsApiPayService.1WxPayActivityResultAdapter)Objects.requireNonNull(paramAnonymousIntent.lcM)).bmc();
          if (paramAnonymousIntent.lcA != null) {
            paramAnonymousIntent.lcA.a(local1WxPayCallbackResult.result, local1WxPayCallbackResult.lcL, local1WxPayCallbackResult.values);
          }
          AppMethodBeat.o(188497);
        }
      });
      AppMethodBeat.o(174858);
      return bool;
    }
  }
  
  public final void startPayComponent(Activity paramActivity, final AppBrandStatObject paramAppBrandStatObject, final String paramString, final Map<String, String> paramMap, final a.a parama)
  {
    AppMethodBeat.i(174863);
    AppBrandJsApiPayUtils.a(paramActivity, new b() {});
    AppMethodBeat.o(174863);
  }
  
  public final boolean startPayToBank(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb)
  {
    AppMethodBeat.i(174859);
    paramJSONObject = new WalletJsapiData(paramJSONObject);
    if (paramAppBrandStatObject != null)
    {
      paramJSONObject.dnX = WalletJsapiData.jr(paramAppBrandStatObject.scene, paramAppBrandStatObject.dJO);
      paramJSONObject.Fmd = WalletJsapiData.jq(paramAppBrandStatObject.scene, paramAppBrandStatObject.dJO);
    }
    paramJSONObject.dCC = 46;
    boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46698);
        if (paramAnonymousInt1 != (AppBrandJsApiPayService.this.hashCode() & 0xFFFF))
        {
          AppMethodBeat.o(46698);
          return;
        }
        if (paramAnonymousInt2 == -1)
        {
          HashMap localHashMap = new HashMap();
          String str = bt.bI(paramAnonymousIntent.getStringExtra("token"), "");
          paramAnonymousIntent = bt.bI(paramAnonymousIntent.getStringExtra("bind_serial"), "");
          localHashMap.put("token", str);
          localHashMap.put("bindSerial", paramAnonymousIntent);
          if (paramb != null) {
            paramb.a(1, null, localHashMap);
          }
          AppMethodBeat.o(46698);
          return;
        }
        if (paramb != null) {
          paramb.a(2, null, null);
        }
        AppMethodBeat.o(46698);
      }
    } {});
    AppMethodBeat.o(174859);
    return bool;
  }
  
  public final void verifyPassword(Activity paramActivity, final AppBrandStatObject paramAppBrandStatObject, JSONObject paramJSONObject, final a.d paramd)
  {
    AppMethodBeat.i(174862);
    paramAppBrandStatObject = new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174857);
        if (paramAnonymousInt1 != (AppBrandJsApiPayService.this.hashCode() & 0xFFFF))
        {
          AppMethodBeat.o(174857);
          return;
        }
        if (paramAnonymousInt2 == -1)
        {
          String str = "";
          if (paramAnonymousIntent != null) {
            str = bt.bI(paramAnonymousIntent.getStringExtra("token"), "");
          }
          if (!TextUtils.isEmpty(str))
          {
            ad.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
            if (paramd != null)
            {
              paramd.p(true, str);
              AppMethodBeat.o(174857);
            }
          }
          else
          {
            ad.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
            if (paramd != null) {
              paramd.p(false, null);
            }
          }
          AppMethodBeat.o(174857);
          return;
        }
        if (paramd != null) {
          paramd.p(false, null);
        }
        AppMethodBeat.o(174857);
      }
    };
    paramJSONObject = new WalletJsapiData(paramJSONObject);
    paramd = new Intent();
    paramd.putExtra("appId", paramJSONObject.appId);
    paramd.putExtra("timeStamp", paramJSONObject.timeStamp);
    paramd.putExtra("nonceStr", paramJSONObject.nonceStr);
    paramd.putExtra("packageExt", paramJSONObject.packageExt);
    paramd.putExtra("signtype", paramJSONObject.signType);
    paramd.putExtra("paySignature", paramJSONObject.dCA);
    paramd.putExtra("url", paramJSONObject.url);
    paramd.putExtra("scene", 1);
    AppBrandJsApiPayUtils.a(paramActivity, new b() {});
    AppMethodBeat.o(174862);
  }
  
  static enum PayResultCallbackReason
  {
    static
    {
      AppMethodBeat.i(188500);
      lcO = new PayResultCallbackReason("SuccessAheadCallback", 0);
      lcP = new PayResultCallbackReason("ActivityResult", 1);
      lcQ = new PayResultCallbackReason[] { lcO, lcP };
      AppMethodBeat.o(188500);
    }
    
    private PayResultCallbackReason() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService
 * JD-Core Version:    0.7.0.1
 */