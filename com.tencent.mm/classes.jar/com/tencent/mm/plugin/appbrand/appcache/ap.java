package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.j;

public final class ap
{
  final ap.b gVX;
  
  ap()
  {
    AppMethodBeat.i(59507);
    this.gVX = new ap.b(this);
    AppMethodBeat.o(59507);
  }
  
  public static String avQ()
  {
    AppMethodBeat.i(59508);
    String str2 = g.RL().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    j.akQ(str1);
    AppMethodBeat.o(59508);
    return str1;
  }
  
  public final int b(a parama)
  {
    AppMethodBeat.i(59509);
    if (this.gVX.alN(parama.vMK))
    {
      ab.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.vMK });
      AppMethodBeat.o(59509);
      return 0;
    }
    int i = this.gVX.b(parama);
    ab.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.vMK, Integer.valueOf(i) });
    AppMethodBeat.o(59509);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap
 * JD-Core Version:    0.7.0.1
 */