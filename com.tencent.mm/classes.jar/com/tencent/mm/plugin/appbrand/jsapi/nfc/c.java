package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class c
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 354;
  public static final String NAME = "sendHCEMessage";
  
  static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, String paramString)
  {
    y.i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", new Object[] { paramString });
    if (paramc != null) {
      paramc.C(paramInt, paramString);
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(new c.1(this, paramc, paramInt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.c
 * JD-Core Version:    0.7.0.1
 */