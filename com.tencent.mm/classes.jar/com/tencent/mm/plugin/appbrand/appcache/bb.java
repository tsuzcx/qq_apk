package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class bb
{
  public final void clear(final String paramString)
  {
    AppMethodBeat.i(44352);
    paramString = new ad()
    {
      public final boolean accept(u paramAnonymousu, String paramAnonymousString)
      {
        AppMethodBeat.i(320362);
        boolean bool = paramAnonymousString.endsWith("_" + paramString);
        AppMethodBeat.o(320362);
        return bool;
      }
    };
    u localu = new u(b.bno());
    if ((localu.jKS()) && (localu.isDirectory()))
    {
      paramString = localu.b(paramString);
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localu = paramString[i];
          y.ew(ah.v(localu.mUri), true);
          Log.i("WxaJsCacheStorage", "clear file:%s", new Object[] { localu.getName() });
          i += 1;
        }
      }
    }
    AppMethodBeat.o(44352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bb
 * JD-Core Version:    0.7.0.1
 */