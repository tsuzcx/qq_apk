package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.luggage.l.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.ResultReceiverFixLeak;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
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
import kotlin.ah;
import kotlin.g.a.b;
import org.json.JSONObject;

public enum AppBrandJsApiPayService
  implements a
{
  static
  {
    AppMethodBeat.i(46710);
    soM = new AppBrandJsApiPayService("INSTANCE");
    soN = new AppBrandJsApiPayService[] { soM };
    com.tencent.mm.plugin.appbrand.app.k.UT("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
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
      public void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
    paramb.putExtra("paySignature", paramAppBrandStatObject.hUP);
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
      public void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
  
  public final boolean startPay(Activity paramActivity, final com.tencent.mm.plugin.appbrand.jsapi.k paramk, final AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb, PString paramPString)
  {
    AppMethodBeat.i(174858);
    final WalletJsapiData localWalletJsapiData = new WalletJsapiData(paramJSONObject);
    if (paramAppBrandStatObject != null)
    {
      localWalletJsapiData.payChannel = WalletJsapiData.nO(paramAppBrandStatObject.scene, paramAppBrandStatObject.icW);
      localWalletJsapiData.YvS = WalletJsapiData.axk(paramAppBrandStatObject.scene);
      localWalletJsapiData.tOn = paramAppBrandStatObject.tOn;
    }
    localWalletJsapiData.hUR = 46;
    paramAppBrandStatObject = paramJSONObject.optString("adUxInfo");
    localWalletJsapiData.Ywb = paramAppBrandStatObject;
    com.tencent.mm.plugin.ad.a.E("AppBrandRuntime", "requestPayment", paramAppBrandStatObject, "data");
    paramPString.value = localWalletJsapiData.packageExt;
    int j;
    if (g.z(paramk))
    {
      paramAppBrandStatObject = (c)e.T(c.class);
      j = hashCode();
      paramJSONObject = new Object()
      {
        AppBrandJsApiPayService.1WxPayActivityResultAdapter spc;
        
        final void a(int paramAnonymousInt, Intent paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason paramAnonymousPayResultCallbackReason)
        {
          AppMethodBeat.i(327819);
          paramAnonymousIntent = new AppBrandJsApiPayService.1WxPayActivityResultAdapter(this.soS, paramAnonymousInt, paramAnonymousIntent, paramAnonymousPayResultCallbackReason);
          if ((this.spc == null) || (this.spc.a(paramAnonymousIntent)))
          {
            this.spc = paramAnonymousIntent;
            if ((AppBrandJsApiPayService.1WxPayActivityResultAdapter.b(this.spc) == AppBrandJsApiPayService.PayResultCallbackReason.spe) && ((paramb instanceof a.c)))
            {
              paramAnonymousIntent = this.spc.cug();
              ((a.c)paramb).b(paramAnonymousIntent.result, paramAnonymousIntent.spb, paramAnonymousIntent.values);
            }
          }
          AppMethodBeat.o(327819);
        }
      };
      localWalletJsapiData.Ywd = ResultReceiverFixLeak.a(new ResultReceiver(paramJSONObject)
      {
        private final AppBrandJsApiPayService.1WxPayResultDispatcher soY;
        
        public final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(180264);
          paramAnonymousBundle.setClassLoader(WalletJsapiData.class.getClassLoader());
          this.soY.a(paramAnonymousInt, new Intent().putExtras(paramAnonymousBundle), AppBrandJsApiPayService.PayResultCallbackReason.spe);
          AppMethodBeat.o(180264);
        }
      }, paramActivity);
      if ((paramk.getRuntime() instanceof w)) {
        if (!((w)paramk.getRuntime()).ccB()) {
          break label249;
        }
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      localWalletJsapiData.YvT = i;
      if (paramAppBrandStatObject != null) {
        paramAppBrandStatObject.ctz();
      }
      boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()new e.b {}, new e.b()
      {
        public void onResult(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(327821);
          paramJSONObject.a(paramAnonymousInt, paramAnonymousIntent, AppBrandJsApiPayService.PayResultCallbackReason.spf);
          paramAnonymousIntent = paramJSONObject;
          if (paramAnonymousIntent.rJy != null) {
            paramAnonymousIntent.rJy.cty();
          }
          AppBrandJsApiPayService.1WxPayCallbackResult local1WxPayCallbackResult = ((AppBrandJsApiPayService.1WxPayActivityResultAdapter)Objects.requireNonNull(paramAnonymousIntent.spc)).cug();
          if (paramAnonymousIntent.soQ != null) {
            paramAnonymousIntent.soQ.a(local1WxPayCallbackResult.result, local1WxPayCallbackResult.spb, local1WxPayCallbackResult.values);
          }
          AppMethodBeat.o(327821);
        }
      });
      AppMethodBeat.o(174858);
      return bool;
      paramAppBrandStatObject = null;
      break;
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
      paramJSONObject.payChannel = WalletJsapiData.nO(paramAppBrandStatObject.scene, paramAppBrandStatObject.icW);
      paramJSONObject.YvS = WalletJsapiData.axk(paramAppBrandStatObject.scene);
    }
    paramJSONObject.hUR = 46;
    boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()
    {
      public void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
      public void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
              paramd.G(true, str);
              AppMethodBeat.o(174857);
            }
          }
          else
          {
            Log.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
            if (paramd != null) {
              paramd.G(false, null);
            }
          }
          AppMethodBeat.o(174857);
          return;
        }
        if (paramd != null) {
          paramd.G(false, null);
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
    paramd.putExtra("paySignature", paramJSONObject.hUP);
    paramd.putExtra("url", paramJSONObject.url);
    paramd.putExtra("scene", 1);
    AppBrandJsApiPayUtils.a(paramActivity, new b() {});
    AppMethodBeat.o(174862);
  }
  
  static enum PayResultCallbackReason
  {
    static
    {
      AppMethodBeat.i(327822);
      spe = new PayResultCallbackReason("SuccessAheadCallback", 0);
      spf = new PayResultCallbackReason("ActivityResult", 1);
      spg = new PayResultCallbackReason[] { spe, spf };
      AppMethodBeat.o(327822);
    }
    
    private PayResultCallbackReason() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService
 * JD-Core Version:    0.7.0.1
 */