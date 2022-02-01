package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 358;
  public static final String NAME = "getHCEState";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136103);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void y(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136102);
        ad.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        HashMap localHashMap = new HashMap();
        localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramc.h(paramInt, d.this.m("ok", localHashMap));
          AppMethodBeat.o(136102);
          return;
        }
        paramc.h(paramInt, d.this.m("fail ".concat(String.valueOf(paramAnonymousString)), localHashMap));
        AppMethodBeat.o(136102);
      }
    });
    AppMethodBeat.o(136103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d
 * JD-Core Version:    0.7.0.1
 */