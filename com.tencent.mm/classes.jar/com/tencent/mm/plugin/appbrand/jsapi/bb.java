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

public final class bb
  extends a
{
  public static final int CTRL_INDEX = 403;
  public static final String NAME = "openOfflinePayView";
  private int bxX;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130517);
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof MMActivity)))
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenOfflinePayView", "mmActivity is null, invoke fail!");
      AppMethodBeat.o(130517);
      return;
    }
    ((MMActivity)localContext).mmSetOnActivityResultCallback(new bb.1(this, paramc, paramInt));
    this.bxX = paramInt;
    ab.d("MicroMsg.JsApiOpenOfflinePayView", "json: %s", new Object[] { paramJSONObject.toString() });
    AppBrandSysConfigWC localAppBrandSysConfigWC = com.tencent.mm.plugin.appbrand.a.xM(paramc.getAppId());
    if (localAppBrandSysConfigWC == null)
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenOfflinePayView", "sysConfig is null, invoke fail!");
      AppMethodBeat.o(130517);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.a.xL(paramc.getAppId());
    if (localObject == null)
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenOfflinePayView", "runtime is null, invoke fail!");
      AppMethodBeat.o(130517);
      return;
    }
    localObject = ((i)localObject).atj().getCurrentUrl();
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramc.getAppId());
    localIntent.putExtra("timeStamp", paramJSONObject.optString("timeStamp"));
    localIntent.putExtra("nonceStr", paramJSONObject.optString("nonceStr"));
    localIntent.putExtra("packageExt", paramJSONObject.optString("package"));
    localIntent.putExtra("signtype", paramJSONObject.optString("signType"));
    localIntent.putExtra("paySignature", paramJSONObject.optString("paySign"));
    localIntent.putExtra("wxapp_username", localAppBrandSysConfigWC.cqQ);
    localIntent.putExtra("wxapp_path", (String)localObject);
    paramInt = hashCode();
    localIntent.putExtra("key_from_scene", 7);
    d.b(localContext, "offline", ".ui.WalletOfflineEntranceUI", localIntent, paramInt & 0xFFFF);
    AppMethodBeat.o(130517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bb
 * JD-Core Version:    0.7.0.1
 */