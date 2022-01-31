package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class c
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 354;
  public static final String NAME = "sendHCEMessage";
  
  static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, String paramString)
  {
    AppMethodBeat.i(137871);
    ab.i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", new Object[] { paramString });
    if (paramc != null) {
      paramc.h(paramInt, paramString);
    }
    AppMethodBeat.o(137871);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137870);
    a(new c.1(this, paramc, paramInt, paramJSONObject));
    AppMethodBeat.o(137870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.c
 * JD-Core Version:    0.7.0.1
 */