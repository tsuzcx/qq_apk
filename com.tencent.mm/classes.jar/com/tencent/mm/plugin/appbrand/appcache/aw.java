package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.m;
import com.tencent.mm.vfs.q;

public final class aw
{
  public final void clear(final String paramString)
  {
    AppMethodBeat.i(44352);
    paramString = new m()
    {
      public final boolean wY(String paramAnonymousString)
      {
        AppMethodBeat.i(174708);
        boolean bool = paramAnonymousString.endsWith("_" + paramString);
        AppMethodBeat.o(174708);
        return bool;
      }
    };
    e locale = new e(ac.bqo());
    if ((locale.exists()) && (locale.isDirectory()))
    {
      paramString = locale.b(paramString);
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          locale = paramString[i];
          i.cZ(q.B(locale.mUri), true);
          ad.i("WxaJsCacheStorage", "clear file:%s", new Object[] { locale.getName() });
          i += 1;
        }
      }
    }
    AppMethodBeat.o(44352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aw
 * JD-Core Version:    0.7.0.1
 */