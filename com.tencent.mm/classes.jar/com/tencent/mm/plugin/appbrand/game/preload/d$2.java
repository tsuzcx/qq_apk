package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$2
  implements b.a
{
  public d$2(d paramd, String paramString1, String paramString2) {}
  
  public final void M(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45285);
    if (paramJSONObject != null) {
      try
      {
        int i = paramJSONObject.getInt("Content-Length");
        d.d(this.opc).addAndGet(i);
        AppMethodBeat.o(45285);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.WAGamePreloadManager", paramJSONObject, "content-length get error", new Object[0]);
      }
    }
    AppMethodBeat.o(45285);
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap)
  {
    AppMethodBeat.i(174730);
    Log.v("MicroMsg.WAGamePreloadManager", "download errMsg:%d,mimeType:%s,filePath:%s,statusCode:%d,url:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), this.val$url });
    if ((this.opc.ooT == null) || (paramInt2 != 200))
    {
      Log.e("MicroMsg.WAGamePreloadManager", "download fileSystem is null or download failed!");
      AppMethodBeat.o(174730);
      return;
    }
    d.a(this.opc, this.val$url);
    d.b(this.opc);
    paramString1 = this.miZ.substring(0, this.miZ.lastIndexOf("/") + 1);
    paramString1 = this.opc.ooT.aj(paramString1, true);
    if ((paramString1 == m.nMR) || (paramString1 == m.nMW)) {
      this.opc.ooT.a(this.miZ, new q(paramString2), true);
    }
    d.c(this.opc).addAndGet(1);
    AppMethodBeat.o(174730);
  }
  
  public final void aj(int paramInt, String paramString) {}
  
  public final void j(int paramInt, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d.2
 * JD-Core Version:    0.7.0.1
 */