package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.p.b.b;
import com.tencent.mm.plugin.appbrand.p.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.j.a.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  
  public e(b.b paramb)
  {
    super(paramb);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.j.a.a a(b.b paramb)
  {
    AppMethodBeat.i(180202);
    paramb = new a(paramb, this.kAW);
    AppMethodBeat.o(180202);
    return paramb;
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.j.a.a
  {
    public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.j.a parama)
    {
      super(parama);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.p.a parama, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> paramMap, com.tencent.mm.plugin.appbrand.p.b.a parama1, String paramString)
    {
      AppMethodBeat.i(180201);
      Object localObject = paramJSONObject.optString("url");
      if (bs.isNullOrNil((String)localObject))
      {
        ac.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
        a(paramc, paramString, "url is null or nil");
        AppMethodBeat.o(180201);
        return;
      }
      if ((((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOm, false)) && (d.bdT().isDownloading((String)localObject)))
      {
        localObject = d.bdT().jSF;
        if (localObject != null)
        {
          int i = parama.jCy;
          if (paramBoolean) {}
          for (paramc = parama.ccH;; paramc = null)
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