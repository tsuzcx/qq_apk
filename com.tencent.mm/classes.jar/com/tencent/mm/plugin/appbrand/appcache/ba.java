package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.z;

public final class ba
{
  public final void clear(final String paramString)
  {
    AppMethodBeat.i(44352);
    paramString = new z()
    {
      public final boolean accept(q paramAnonymousq, String paramAnonymousString)
      {
        AppMethodBeat.i(267929);
        boolean bool = paramAnonymousString.endsWith("_" + paramString);
        AppMethodBeat.o(267929);
        return bool;
      }
    };
    q localq = new q(b.aTA());
    if ((localq.ifE()) && (localq.isDirectory()))
    {
      paramString = localq.b(paramString);
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localq = paramString[i];
          u.deleteDir(localq.getPath());
          Log.i("WxaJsCacheStorage", "clear file:%s", new Object[] { localq.getName() });
          i += 1;
        }
      }
    }
    AppMethodBeat.o(44352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ba
 * JD-Core Version:    0.7.0.1
 */