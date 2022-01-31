package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class bh
  extends a
{
  public static final int CTRL_INDEX = 616;
  public static final String NAME = "openWCPayLQTDetail";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130525);
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof MMActivity)))
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenWCPayLQTDetail", "mmActivity is null, invoke fail!");
      AppMethodBeat.o(130525);
      return;
    }
    ((MMActivity)localContext).mmSetOnActivityResultCallback(new bh.1(this, localContext, paramc, paramInt));
    AppBrandSysConfigWC localAppBrandSysConfigWC = com.tencent.mm.plugin.appbrand.a.xM(paramc.getAppId());
    if (localAppBrandSysConfigWC == null)
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenWCPayLQTDetail", "sysConfig is null, invoke fail!");
      AppMethodBeat.o(130525);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.a.xL(paramc.getAppId());
    if (localObject == null)
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenWCPayLQTDetail", "runtime is null, invoke fail!");
      AppMethodBeat.o(130525);
      return;
    }
    ab.d("MicroMsg.JsApiOpenWCPayLQTDetail", "do openWCPayLQTDepositPlan");
    localObject = ((i)localObject).atj().getCurrentUrl();
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramc.getAppId());
    localIntent.putExtra("timeStamp", paramJSONObject.optString("timeStamp"));
    localIntent.putExtra("nonceStr", paramJSONObject.optString("nonceStr"));
    localIntent.putExtra("packageExt", paramJSONObject.optString("package"));
    localIntent.putExtra("signtype", paramJSONObject.optString("signType"));
    localIntent.putExtra("paySignature", paramJSONObject.optString("paySign"));
    localIntent.putExtra("pay_channel", paramJSONObject.optString("pay_channel"));
    localIntent.putExtra("wxapp_username", localAppBrandSysConfigWC.cqQ);
    localIntent.putExtra("jsapi_scene", 19);
    localIntent.putExtra("command_word", "openWCPayLQTDetail");
    localIntent.putExtra("wxapp_path", (String)localObject);
    localIntent.putExtra("source_type", 2);
    d.b(localContext, "wallet", ".ui.WalletJsApiAdapterUI", localIntent, hashCode() & 0xFFFF);
    AppMethodBeat.o(130525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bh
 * JD-Core Version:    0.7.0.1
 */