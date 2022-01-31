package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class ap
  extends a
{
  public static final int CTRL_INDEX = 403;
  public static final String NAME = "openOfflinePayView";
  private int bhx;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof MMActivity)))
    {
      paramc.C(paramInt, h("fail", null));
      y.e("MicroMsg.JsApiOpenOfflinePayView", "mmActivity is null, invoke fail!");
      return;
    }
    ((MMActivity)localContext).gJb = new ap.1(this, paramc, paramInt);
    this.bhx = paramInt;
    y.d("MicroMsg.JsApiOpenOfflinePayView", "json: %s", new Object[] { paramJSONObject.toString() });
    AppBrandSysConfigWC localAppBrandSysConfigWC = com.tencent.mm.plugin.appbrand.a.qo(paramc.getAppId());
    if (localAppBrandSysConfigWC == null)
    {
      paramc.C(paramInt, h("fail", null));
      y.e("MicroMsg.JsApiOpenOfflinePayView", "sysConfig is null, invoke fail!");
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.a.qn(paramc.getAppId());
    if (localObject == null)
    {
      paramc.C(paramInt, h("fail", null));
      y.e("MicroMsg.JsApiOpenOfflinePayView", "runtime is null, invoke fail!");
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.i)localObject).Zz().getCurrentUrl();
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramc.getAppId());
    localIntent.putExtra("timeStamp", paramJSONObject.optString("timeStamp"));
    localIntent.putExtra("nonceStr", paramJSONObject.optString("nonceStr"));
    localIntent.putExtra("packageExt", paramJSONObject.optString("package"));
    localIntent.putExtra("signtype", paramJSONObject.optString("signType"));
    localIntent.putExtra("paySignature", paramJSONObject.optString("paySign"));
    localIntent.putExtra("wxapp_username", localAppBrandSysConfigWC.bJw);
    localIntent.putExtra("wxapp_path", (String)localObject);
    paramInt = hashCode();
    localIntent.putExtra("key_from_scene", 7);
    d.b(localContext, "offline", ".ui.WalletOfflineEntranceUI", localIntent, paramInt & 0xFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */