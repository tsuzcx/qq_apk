package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public enum a
  implements b
{
  static
  {
    AppMethodBeat.i(131410);
    hWj = new a("INSTANCE");
    hWk = new a[] { hWj };
    AppMethodBeat.o(131410);
  }
  
  private a() {}
  
  public final void a(MMActivity paramMMActivity, JSONObject paramJSONObject, b.b paramb)
  {
    AppMethodBeat.i(131409);
    paramb = new a.5(this, paramb);
    paramJSONObject = new WalletJsapiData(paramJSONObject);
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramJSONObject.appId);
    localIntent.putExtra("timeStamp", paramJSONObject.timeStamp);
    localIntent.putExtra("nonceStr", paramJSONObject.nonceStr);
    localIntent.putExtra("packageExt", paramJSONObject.packageExt);
    localIntent.putExtra("signtype", paramJSONObject.signType);
    localIntent.putExtra("paySignature", paramJSONObject.cCB);
    localIntent.putExtra("url", paramJSONObject.url);
    localIntent.putExtra("scene", 1);
    paramMMActivity.mmSetOnActivityResultCallback(paramb);
    d.a(paramMMActivity, "wallet_core", ".ui.WalletCheckPwdUI", localIntent, 0xFFFF & hashCode(), false);
    AppMethodBeat.o(131409);
  }
  
  public final boolean a(MMActivity paramMMActivity, AppBrandStatObject paramAppBrandStatObject, JSONObject paramJSONObject, b.a parama, PString paramPString)
  {
    AppMethodBeat.i(131408);
    paramJSONObject = new WalletJsapiData(paramJSONObject);
    if (paramAppBrandStatObject != null)
    {
      paramJSONObject.cqj = WalletJsapiData.hi(paramAppBrandStatObject.scene, paramAppBrandStatObject.cIZ);
      paramJSONObject.wgH = WalletJsapiData.hh(paramAppBrandStatObject.scene, paramAppBrandStatObject.cIZ);
    }
    paramJSONObject.cCD = 46;
    paramPString.value = paramJSONObject.packageExt;
    paramAppBrandStatObject = new a.1(this, parama);
    boolean bool = h.a(paramMMActivity, paramJSONObject, hashCode() & 0xFFFF, paramAppBrandStatObject);
    AppMethodBeat.o(131408);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a
 * JD-Core Version:    0.7.0.1
 */