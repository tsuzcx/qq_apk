package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.j.d
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  
  public final void a(c paramc, com.tencent.mm.plugin.appbrand.m.a parama, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> paramMap, b.a parama1, String paramString)
  {
    AppMethodBeat.i(130678);
    Object localObject = paramJSONObject.optString("url");
    if (bo.isNullOrNil((String)localObject))
    {
      ab.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(130678);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTz, false)) && (com.tencent.mm.plugin.appbrand.game.preload.d.aAQ().isDownloading((String)localObject)))
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.d.aAQ().htY;
      if (localObject != null)
      {
        int i = parama.hhD;
        if (paramBoolean) {}
        for (paramc = parama.bDC;; paramc = null)
        {
          ((m)localObject).a(paramJSONObject, paramInt, paramMap, paramc, i, parama1, paramString, "createDownloadTask");
          AppMethodBeat.o(130678);
          return;
        }
      }
    }
    super.a(paramc, parama, paramBoolean, paramJSONObject, paramInt, paramMap, parama1, paramString);
    AppMethodBeat.o(130678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.e
 * JD-Core Version:    0.7.0.1
 */