package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;

public final class ax
{
  public final void clear(final String paramString)
  {
    AppMethodBeat.i(44352);
    paramString = new s()
    {
      public final boolean xH(String paramAnonymousString)
      {
        AppMethodBeat.i(174708);
        boolean bool = paramAnonymousString.endsWith("_" + paramString);
        AppMethodBeat.o(174708);
        return bool;
      }
    };
    k localk = new k(ad.bqY());
    if ((localk.exists()) && (localk.isDirectory()))
    {
      paramString = localk.b(paramString);
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localk = paramString[i];
          o.dd(w.B(localk.mUri), true);
          ae.i("WxaJsCacheStorage", "clear file:%s", new Object[] { localk.getName() });
          i += 1;
        }
      }
    }
    AppMethodBeat.o(44352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */