package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.plugin.appbrand.s.b.b;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.p.a.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  
  public e(b.b paramb)
  {
    super(paramb);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.p.a.a a(b.b paramb)
  {
    AppMethodBeat.i(180202);
    paramb = new a(paramb, this.pei);
    AppMethodBeat.o(180202);
    return paramb;
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.p.a.a
  {
    public a(b.b paramb, com.tencent.mm.plugin.appbrand.jsapi.base.a parama)
    {
      super(parama);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, com.tencent.mm.plugin.appbrand.s.a parama, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> paramMap, b.a parama1, String paramString)
    {
      AppMethodBeat.i(180201);
      Object localObject = paramJSONObject.optString("url");
      if (Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
        b(parame, paramString, "url is null or nil");
        AppMethodBeat.o(180201);
        return;
      }
      d locald = d.bOS();
      if ((locald != null) && (locald.agE((String)localObject)))
      {
        localObject = locald.ooR;
        if (localObject != null)
        {
          int i = parama.nWV;
          if (paramBoolean) {}
          for (parame = parama.cxD;; parame = null)
          {
            ((m)localObject).a(paramJSONObject, paramInt, paramMap, parame, i, parama1, paramString, "createDownloadTask");
            AppMethodBeat.o(180201);
            return;
          }
        }
      }
      super.a(parame, parama, paramBoolean, paramJSONObject, paramInt, paramMap, parama1, paramString);
      AppMethodBeat.o(180201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.e
 * JD-Core Version:    0.7.0.1
 */