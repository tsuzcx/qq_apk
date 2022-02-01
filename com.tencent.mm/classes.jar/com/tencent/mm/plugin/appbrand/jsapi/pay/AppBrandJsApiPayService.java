package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.x;
import org.json.JSONObject;

public enum AppBrandJsApiPayService
  implements a
{
  static
  {
    AppMethodBeat.i(46710);
    mlD = new AppBrandJsApiPayService("INSTANCE");
    mlE = new AppBrandJsApiPayService[] { mlD };
    j.UJ("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    AppMethodBeat.o(46710);
  }
  
  private AppBrandJsApiPayService() {}
  
  public final void sendBizRedPacket(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb)
  {
    AppMethodBeat.i(174861);
    paramAppBrandStatObject = new WalletJsapiData(paramJSONObject);
    paramAppBrandStatObject.payChannel = 16;
    paramJSONObject = new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
    paramb.putExtra("paySignature", paramAppBrandStatObject.dVt);
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
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
  
  public final boolean startPay(Activity paramActivity, final k paramk, final AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb, PString paramPString)
  {
    AppMethodBeat.i(174858);
    final WalletJsapiData localWalletJsapiData = new WalletJsapiData(paramJSONObject);
    if (paramAppBrandStatObject != null)
    {
      localWalletJsapiData.payChannel = WalletJsapiData.kH(paramAppBrandStatObject.scene, paramAppBrandStatObject.ecS);
      localWalletJsapiData.KxG = WalletJsapiData.kG(paramAppBrandStatObject.scene, paramAppBrandStatObject.ecS);
    }
    localWalletJsapiData.dVv = 46;
    paramAppBrandStatObject = paramJSONObject.optString("adUxInfo");
    localWalletJsapiData.KxO = paramAppBrandStatObject;
    com.tencent.mm.plugin.s.a.x("AppBrandRuntime", "requestPayment", paramAppBrandStatObject, "data");
    paramPString.value = localWalletJsapiData.packageExt;
    if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.u(paramk)) {}
    for (paramAppBrandStatObject = (com.tencent.mm.plugin.appbrand.jsapi.nfc.c)e.M(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.class);; paramAppBrandStatObject = null)
    {
      int i = hashCode();
      paramJSONObject = new Object()
      {
        AppBrandJsApiPayService.1WxPayActivityResultAdapter mlT;
        
        final void a(int paramAnonymousInt, Intent paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason paramAnonymousPayResultCallbackReason)
        {
          AppMethodBeat.i(226955);
          paramAnonymousIntent = new AppBrandJsApiPayService.1WxPayActivityResultAdapter(this.mlJ, paramAnonymousInt, paramAnonymousIntent, paramAnonymousPayResultCallbackReason);
          if ((this.mlT == null) || (this.mlT.a(paramAnonymousIntent)))
          {
            this.mlT = paramAnonymousIntent;
            if ((AppBrandJsApiPayService.1WxPayActivityResultAdapter.b(this.mlT) == AppBrandJsApiPayService.PayResultCallbackReason.mlV) && ((paramb instanceof a.c)))
            {
              paramAnonymousIntent = this.mlT.bIk();
              ((a.c)paramb).b(paramAnonymousIntent.result, paramAnonymousIntent.mlS, paramAnonymousIntent.values);
            }
          }
          AppMethodBeat.o(226955);
        }
      };
      localWalletJsapiData.KxQ = new ResultReceiver(paramJSONObject)
      {
        private final AppBrandJsApiPayService.1WxPayResultDispatcher mlP;
        
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(180264);
          paramAnonymousBundle.setClassLoader(WalletJsapiData.class.getClassLoader());
          this.mlP.a(paramAnonymousInt, new Intent().putExtras(paramAnonymousBundle), AppBrandJsApiPayService.PayResultCallbackReason.mlV);
          AppMethodBeat.o(180264);
        }
      };
      if (paramAppBrandStatObject != null) {
        paramAppBrandStatObject.bHL();
      }
      boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()new f.b {}, new f.b()
      {
        public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(226956);
          paramJSONObject.a(paramAnonymousInt, paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason.mlW);
          paramAnonymousIntent = paramJSONObject;
          if (paramAnonymousIntent.lKj != null) {
            paramAnonymousIntent.lKj.bHK();
          }
          AppBrandJsApiPayService.1WxPayCallbackResult local1WxPayCallbackResult = ((AppBrandJsApiPayService.1WxPayActivityResultAdapter)Objects.requireNonNull(paramAnonymousIntent.mlT)).bIk();
          if (paramAnonymousIntent.mlH != null) {
            paramAnonymousIntent.mlH.a(local1WxPayCallbackResult.result, local1WxPayCallbackResult.mlS, local1WxPayCallbackResult.values);
          }
          AppMethodBeat.o(226956);
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
      paramJSONObject.payChannel = WalletJsapiData.kH(paramAppBrandStatObject.scene, paramAppBrandStatObject.ecS);
      paramJSONObject.KxG = WalletJsapiData.kG(paramAppBrandStatObject.scene, paramAppBrandStatObject.ecS);
    }
    paramJSONObject.dVv = 46;
    boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
          String str = Util.nullAs(paramAnonymousIntent.getStringExtra("token"), "");
          paramAnonymousIntent = Util.nullAs(paramAnonymousIntent.getStringExtra("bind_serial"), "");
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
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
            str = Util.nullAs(paramAnonymousIntent.getStringExtra("token"), "");
          }
          if (!TextUtils.isEmpty(str))
          {
            Log.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
            if (paramd != null)
            {
              paramd.p(true, str);
              AppMethodBeat.o(174857);
            }
          }
          else
          {
            Log.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
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
    paramd.putExtra("paySignature", paramJSONObject.dVt);
    paramd.putExtra("url", paramJSONObject.url);
    paramd.putExtra("scene", 1);
    AppBrandJsApiPayUtils.a(paramActivity, new b() {});
    AppMethodBeat.o(174862);
  }
  
  static enum PayResultCallbackReason
  {
    static
    {
      AppMethodBeat.i(226959);
      mlV = new PayResultCallbackReason("SuccessAheadCallback", 0);
      mlW = new PayResultCallbackReason("ActivityResult", 1);
      mlX = new PayResultCallbackReason[] { mlV, mlW };
      AppMethodBeat.o(226959);
    }
    
    private PayResultCallbackReason() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService
 * JD-Core Version:    0.7.0.1
 */