package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$2
  implements b.a
{
  public d$2(d paramd, String paramString1, String paramString2) {}
  
  public final void BE(String paramString) {}
  
  public final void c(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(130295);
    ab.v("MicroMsg.WAGamePreloadManager", "download errMsg:%d,mimeType:%s,filePath:%s,statusCode:%d,url:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), this.val$url });
    if ((this.huj.hua == null) || (paramInt2 != 200))
    {
      ab.e("MicroMsg.WAGamePreloadManager", "download fileSystem is null or download failed!");
      AppMethodBeat.o(130295);
      return;
    }
    d.a(this.huj, this.val$url);
    d.b(this.huj);
    paramString1 = this.fYB.substring(0, this.fYB.lastIndexOf("/") + 1);
    paramString1 = this.huj.hua.Y(paramString1, true);
    if ((paramString1 == j.gZA) || (paramString1 == j.gZF)) {
      this.huj.hua.a(this.fYB, new File(paramString2), true);
    }
    d.c(this.huj).addAndGet(1);
    AppMethodBeat.o(130295);
  }
  
  public final void g(int paramInt, long paramLong1, long paramLong2) {}
  
  public final void v(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130296);
    if (paramJSONObject != null) {
      try
      {
        int i = paramJSONObject.getInt("Content-Length");
        d.d(this.huj).addAndGet(i);
        AppMethodBeat.o(130296);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.WAGamePreloadManager", paramJSONObject, "content-length get error", new Object[0]);
      }
    }
    AppMethodBeat.o(130296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d.2
 * JD-Core Version:    0.7.0.1
 */