package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.plugin.appbrand.t.b.b;
import com.tencent.mm.plugin.appbrand.t.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.s.a.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  
  public e(b.b paramb)
  {
    super(paramb);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.a.a a(b.b paramb)
  {
    AppMethodBeat.i(180202);
    paramb = new a(paramb, this.sjy);
    AppMethodBeat.o(180202);
    return paramb;
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.s.a.a
  {
    public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
    {
      super(parama);
    }
    
    public final void a(f paramf, com.tencent.mm.plugin.appbrand.t.a parama, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> paramMap, b.a parama1, String paramString)
    {
      AppMethodBeat.i(180201);
      Object localObject = paramJSONObject.optString("url");
      if (Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
        b(paramf, paramString, "url is null or nil");
        AppMethodBeat.o(180201);
        return;
      }
      d locald = d.cpg();
      if ((locald != null) && (locald.ZA((String)localObject)))
      {
        localObject = locald.rsz;
        if (localObject != null)
        {
          int i = parama.qWL;
          if (paramBoolean) {}
          for (paramf = parama.epX;; paramf = null)
          {
            ((l)localObject).a(paramJSONObject, paramInt, paramMap, paramf, i, parama1, paramString, "createDownloadTask");
            AppMethodBeat.o(180201);
            return;
          }
        }
      }
      super.a(paramf, parama, paramBoolean, paramJSONObject, paramInt, paramMap, parama1, paramString);
      AppMethodBeat.o(180201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.e
 * JD-Core Version:    0.7.0.1
 */