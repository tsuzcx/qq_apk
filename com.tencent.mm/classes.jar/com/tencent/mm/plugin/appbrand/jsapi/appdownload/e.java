package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.b.b;
import com.tencent.mm.plugin.appbrand.o.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.m.a.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  
  public e(b.b paramb)
  {
    super(paramb);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.m.a.a a(b.b paramb)
  {
    AppMethodBeat.i(180202);
    paramb = new a(paramb, this.laM);
    AppMethodBeat.o(180202);
    return paramb;
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.m.a.a
  {
    public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
    {
      super(parama);
    }
    
    public final void a(c paramc, com.tencent.mm.plugin.appbrand.o.a parama, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> paramMap, com.tencent.mm.plugin.appbrand.o.b.a parama1, String paramString)
    {
      AppMethodBeat.i(180201);
      Object localObject = paramJSONObject.optString("url");
      if (bu.isNullOrNil((String)localObject))
      {
        ae.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
        b(paramc, paramString, "url is null or nil");
        AppMethodBeat.o(180201);
        return;
      }
      if ((((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qza, false)) && (d.bif().isDownloading((String)localObject)))
      {
        localObject = d.bif().kqj;
        if (localObject != null)
        {
          int i = parama.jZJ;
          if (paramBoolean) {}
          for (paramc = parama.cna;; paramc = null)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.e
 * JD-Core Version:    0.7.0.1
 */