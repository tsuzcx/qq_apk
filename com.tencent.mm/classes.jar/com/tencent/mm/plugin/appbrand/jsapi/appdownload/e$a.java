package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q.b.b;
import com.tencent.mm.plugin.appbrand.q.m;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import org.json.JSONObject;

final class e$a
  extends com.tencent.mm.plugin.appbrand.jsapi.j.a.a
{
  public e$a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.j.a parama)
  {
    super(paramb, parama);
  }
  
  public final void a(c paramc, com.tencent.mm.plugin.appbrand.q.a parama, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> paramMap, com.tencent.mm.plugin.appbrand.q.b.a parama1, String paramString)
  {
    AppMethodBeat.i(180201);
    Object localObject = paramJSONObject.optString("url");
    if (bt.isNullOrNil((String)localObject))
    {
      ad.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
      a(paramc, paramString, "url is null or nil");
      AppMethodBeat.o(180201);
      return;
    }
    if ((((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pkV, false)) && (d.aWV().isDownloading((String)localObject)))
    {
      localObject = d.aWV().jsl;
      if (localObject != null)
      {
        int i = parama.jcl;
        if (paramBoolean) {}
        for (paramc = parama.cfK;; paramc = null)
        {
          ((m)localObject).a(paramJSONObject, paramInt, paramMap, paramc, i, parama1, paramString, "createDownloadTask");
          AppMethodBeat.o(180201);
          return;
        }
      }
    }
    super.a(paramc, parama, paramBoolean, paramJSONObject, paramInt, paramMap, parama1, paramString);
    AppMethodBeat.o(180201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.e.a
 * JD-Core Version:    0.7.0.1
 */