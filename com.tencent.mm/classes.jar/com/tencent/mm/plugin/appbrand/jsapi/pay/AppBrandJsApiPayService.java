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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    lgh = new AppBrandJsApiPayService("INSTANCE");
    lgi = new AppBrandJsApiPayService[] { lgh };
    g.LA("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    AppMethodBeat.o(46710);
  }
  
  private AppBrandJsApiPayService() {}
  
  public final void sendBizRedPacket(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb)
  {
    AppMethodBeat.i(174861);
    paramAppBrandStatObject = new WalletJsapiData(paramJSONObject);
    paramAppBrandStatObject.dpc = 16;
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
    paramb.putExtra("paySignature", paramAppBrandStatObject.dDF);
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
      localWalletJsapiData.dpc = WalletJsapiData.jv(paramAppBrandStatObject.scene, paramAppBrandStatObject.dLd);
      localWalletJsapiData.FEB = WalletJsapiData.ju(paramAppBrandStatObject.scene, paramAppBrandStatObject.dLd);
    }
    localWalletJsapiData.dDH = 46;
    paramAppBrandStatObject = paramJSONObject.optString("adUxInfo");
    localWalletJsapiData.FEJ = paramAppBrandStatObject;
    com.tencent.mm.plugin.t.a.t("AppBrandRuntime", "requestPayment", paramAppBrandStatObject, "data");
    paramPString.value = localWalletJsapiData.packageExt;
    if (com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.u(paramh)) {}
    for (paramAppBrandStatObject = (com.tencent.mm.plugin.appbrand.jsapi.nfc.c)e.K(com.tencent.mm.plugin.appbrand.jsapi.nfc.c.class);; paramAppBrandStatObject = null)
    {
      int i = hashCode();
      paramJSONObject = new Object()
      {
        AppBrandJsApiPayService.1WxPayActivityResultAdapter lgx;
        
        final void a(int paramAnonymousInt, Intent paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason paramAnonymousPayResultCallbackReason)
        {
          AppMethodBeat.i(222646);
          paramAnonymousIntent = new AppBrandJsApiPayService.1WxPayActivityResultAdapter(this.lgn, paramAnonymousInt, paramAnonymousIntent, paramAnonymousPayResultCallbackReason);
          if ((this.lgx == null) || (this.lgx.a(paramAnonymousIntent)))
          {
            this.lgx = paramAnonymousIntent;
            if ((AppBrandJsApiPayService.1WxPayActivityResultAdapter.b(this.lgx) == AppBrandJsApiPayService.PayResultCallbackReason.lgz) && ((paramb instanceof a.c)))
            {
              paramAnonymousIntent = this.lgx.bmL();
              ((a.c)paramb).b(paramAnonymousIntent.result, paramAnonymousIntent.lgw, paramAnonymousIntent.values);
            }
          }
          AppMethodBeat.o(222646);
        }
      };
      localWalletJsapiData.FEL = new ResultReceiver(paramJSONObject)
      {
        private final AppBrandJsApiPayService.1WxPayResultDispatcher lgt;
        
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(180264);
          paramAnonymousBundle.setClassLoader(WalletJsapiData.class.getClassLoader());
          this.lgt.a(paramAnonymousInt, new Intent().putExtras(paramAnonymousBundle), AppBrandJsApiPayService.PayResultCallbackReason.lgz);
          AppMethodBeat.o(180264);
        }
      };
      if (paramAppBrandStatObject != null) {
        paramAppBrandStatObject.bmm();
      }
      boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()new e.b {}, new e.b()
      {
        public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(222647);
          paramJSONObject.a(paramAnonymousInt, paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason.lgA);
          paramAnonymousIntent = paramJSONObject;
          if (paramAnonymousIntent.kFI != null) {
            paramAnonymousIntent.kFI.bml();
          }
          AppBrandJsApiPayService.1WxPayCallbackResult local1WxPayCallbackResult = ((AppBrandJsApiPayService.1WxPayActivityResultAdapter)Objects.requireNonNull(paramAnonymousIntent.lgx)).bmL();
          if (paramAnonymousIntent.lgl != null) {
            paramAnonymousIntent.lgl.a(local1WxPayCallbackResult.result, local1WxPayCallbackResult.lgw, local1WxPayCallbackResult.values);
          }
          AppMethodBeat.o(222647);
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
      paramJSONObject.dpc = WalletJsapiData.jv(paramAppBrandStatObject.scene, paramAppBrandStatObject.dLd);
      paramJSONObject.FEB = WalletJsapiData.ju(paramAppBrandStatObject.scene, paramAppBrandStatObject.dLd);
    }
    paramJSONObject.dDH = 46;
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
          String str = bu.bI(paramAnonymousIntent.getStringExtra("token"), "");
          paramAnonymousIntent = bu.bI(paramAnonymousIntent.getStringExtra("bind_serial"), "");
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
            str = bu.bI(paramAnonymousIntent.getStringExtra("token"), "");
          }
          if (!TextUtils.isEmpty(str))
          {
            ae.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
            if (paramd != null)
            {
              paramd.p(true, str);
              AppMethodBeat.o(174857);
            }
          }
          else
          {
            ae.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
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
    paramd.putExtra("paySignature", paramJSONObject.dDF);
    paramd.putExtra("url", paramJSONObject.url);
    paramd.putExtra("scene", 1);
    AppBrandJsApiPayUtils.a(paramActivity, new b() {});
    AppMethodBeat.o(174862);
  }
  
  static enum PayResultCallbackReason
  {
    static
    {
      AppMethodBeat.i(222650);
      lgz = new PayResultCallbackReason("SuccessAheadCallback", 0);
      lgA = new PayResultCallbackReason("ActivityResult", 1);
      lgB = new PayResultCallbackReason[] { lgz, lgA };
      AppMethodBeat.o(222650);
    }
    
    private PayResultCallbackReason() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService
 * JD-Core Version:    0.7.0.1
 */