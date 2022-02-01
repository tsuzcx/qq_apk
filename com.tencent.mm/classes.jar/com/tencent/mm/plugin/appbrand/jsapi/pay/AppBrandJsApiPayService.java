package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.a.b;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public enum AppBrandJsApiPayService
  implements a
{
  static
  {
    AppMethodBeat.i(46710);
    kfq = new AppBrandJsApiPayService("INSTANCE");
    kfr = new AppBrandJsApiPayService[] { kfq };
    g.DE("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    AppMethodBeat.o(46710);
  }
  
  private AppBrandJsApiPayService() {}
  
  public final void sendBizRedPacket(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject, final JSONObject paramJSONObject, final a.b paramb)
  {
    AppMethodBeat.i(174861);
    paramAppBrandStatObject = new WalletJsapiData(paramJSONObject);
    paramAppBrandStatObject.dfg = 16;
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
    paramb.putExtra("paySignature", paramAppBrandStatObject.dsZ);
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
  
  public final boolean startPay(Activity paramActivity, final h paramh, final AppBrandStatObject paramAppBrandStatObject, JSONObject paramJSONObject, final a.b paramb, PString paramPString)
  {
    AppMethodBeat.i(174858);
    final WalletJsapiData localWalletJsapiData = new WalletJsapiData(paramJSONObject);
    if (paramAppBrandStatObject != null)
    {
      localWalletJsapiData.dfg = WalletJsapiData.iS(paramAppBrandStatObject.scene, paramAppBrandStatObject.dzQ);
      localWalletJsapiData.CoE = WalletJsapiData.iR(paramAppBrandStatObject.scene, paramAppBrandStatObject.dzQ);
    }
    localWalletJsapiData.dtb = 46;
    paramAppBrandStatObject = paramJSONObject.optString("adUxInfo");
    localWalletJsapiData.CoM = paramAppBrandStatObject;
    com.tencent.mm.plugin.t.a.r("AppBrandRuntime", "requestPayment", paramAppBrandStatObject, "data");
    paramPString.value = localWalletJsapiData.packageExt;
    final int i = hashCode() & 0xFFFF;
    paramAppBrandStatObject = new MMActivity.a()
    {
      boolean kfC = false;
      Pair<Integer, Bundle> kfD;
      
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(195927);
        boolean bool2 = this.kfC;
        if (this.kfD != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ad.i("MicroMsg.AppBrandJsApiPayService", "startPay onActivityResult resultReceived[%b] requestCode[%d] resultCode[%d] hasOverriddenSuccessResult[%b]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool1) });
          if (paramAnonymousInt1 == i) {
            break;
          }
          AppMethodBeat.o(195927);
          return;
        }
        if (this.kfC)
        {
          AppMethodBeat.o(195927);
          return;
        }
        this.kfC = true;
        if (this.kfD != null)
        {
          paramAnonymousInt2 = ((Integer)this.kfD.first).intValue();
          paramAnonymousIntent = new Intent().putExtras((Bundle)this.kfD.second);
        }
        if (paramAnonymousIntent != null) {}
        for (paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_is_clear_failure", -1);; paramAnonymousInt1 = -1)
        {
          HashMap localHashMap = new HashMap();
          if (paramAnonymousInt1 == 0) {
            localHashMap.put("payStatus", "pending");
          }
          while (paramAnonymousInt2 == -1)
          {
            if (paramb != null) {
              paramb.a(1, null, localHashMap);
            }
            AppMethodBeat.o(195927);
            return;
            if (paramAnonymousInt1 == 1) {
              localHashMap.put("pay_status", "fail");
            }
          }
          if (paramAnonymousInt2 == 5)
          {
            paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_pay_err_code", 0);
            paramAnonymousIntent = bt.nullAsNil(paramAnonymousIntent.getStringExtra("key_jsapi_pay_err_msg"));
            ad.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousIntent });
            if (paramb != null) {
              paramb.a(2, paramAnonymousIntent, localHashMap);
            }
            AppMethodBeat.o(195927);
            return;
          }
          if (paramb != null) {
            paramb.a(3, null, localHashMap);
          }
          AppMethodBeat.o(195927);
          return;
        }
      }
    };
    localWalletJsapiData.CoO = new ResultReceiver(paramAppBrandStatObject)
    {
      private final AppBrandJsApiPayService.1WxPayMMActivityResultDispatcher kfz;
      
      protected void onReceiveResult(final int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(180264);
        paramAnonymousBundle.setClassLoader(WalletJsapiData.class.getClassLoader());
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(195925);
            AppBrandJsApiPayService.1PaySuccessAheadCallbackResultReceiver.a(AppBrandJsApiPayService.1PaySuccessAheadCallbackResultReceiver.this).c(AppBrandJsApiPayService.1PaySuccessAheadCallbackResultReceiver.this.kft, paramAnonymousInt, new Intent().putExtras(paramAnonymousBundle));
            AppMethodBeat.o(195925);
          }
        };
        if ((paramh instanceof m))
        {
          local1.run();
          AppMethodBeat.o(180264);
          return;
        }
        this.kfz.kfD = Pair.create(Integer.valueOf(paramAnonymousInt), paramAnonymousBundle);
        AppMethodBeat.o(180264);
      }
    };
    boolean bool = AppBrandJsApiPayUtils.a(paramActivity, new b()new e.a {}, new e.a()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(195928);
        paramAppBrandStatObject.c(i, paramAnonymousInt, paramAnonymousIntent);
        AppMethodBeat.o(195928);
      }
    });
    AppMethodBeat.o(174858);
    return bool;
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
      paramJSONObject.dfg = WalletJsapiData.iS(paramAppBrandStatObject.scene, paramAppBrandStatObject.dzQ);
      paramJSONObject.CoE = WalletJsapiData.iR(paramAppBrandStatObject.scene, paramAppBrandStatObject.dzQ);
    }
    paramJSONObject.dtb = 46;
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
          String str = bt.by(paramAnonymousIntent.getStringExtra("token"), "");
          paramAnonymousIntent = bt.by(paramAnonymousIntent.getStringExtra("bind_serial"), "");
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
  
  public final void verifyPassword(Activity paramActivity, final AppBrandStatObject paramAppBrandStatObject, JSONObject paramJSONObject, final a.c paramc)
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
            str = bt.by(paramAnonymousIntent.getStringExtra("token"), "");
          }
          if (!TextUtils.isEmpty(str))
          {
            ad.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
            if (paramc != null)
            {
              paramc.l(true, str);
              AppMethodBeat.o(174857);
            }
          }
          else
          {
            ad.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
            if (paramc != null) {
              paramc.l(false, null);
            }
          }
          AppMethodBeat.o(174857);
          return;
        }
        if (paramc != null) {
          paramc.l(false, null);
        }
        AppMethodBeat.o(174857);
      }
    };
    paramJSONObject = new WalletJsapiData(paramJSONObject);
    paramc = new Intent();
    paramc.putExtra("appId", paramJSONObject.appId);
    paramc.putExtra("timeStamp", paramJSONObject.timeStamp);
    paramc.putExtra("nonceStr", paramJSONObject.nonceStr);
    paramc.putExtra("packageExt", paramJSONObject.packageExt);
    paramc.putExtra("signtype", paramJSONObject.signType);
    paramc.putExtra("paySignature", paramJSONObject.dsZ);
    paramc.putExtra("url", paramJSONObject.url);
    paramc.putExtra("scene", 1);
    AppBrandJsApiPayUtils.a(paramActivity, new b() {});
    AppMethodBeat.o(174862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService
 * JD-Core Version:    0.7.0.1
 */