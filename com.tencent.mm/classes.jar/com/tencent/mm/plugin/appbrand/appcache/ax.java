package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;

public final class ax
{
  public final void clear(final String paramString)
  {
    AppMethodBeat.i(44352);
    paramString = new w()
    {
      public final boolean accept(o paramAnonymouso, String paramAnonymousString)
      {
        AppMethodBeat.i(226365);
        boolean bool = paramAnonymousString.endsWith("_" + paramString);
        AppMethodBeat.o(226365);
        return bool;
      }
    };
    o localo = new o(ad.bMK());
    if ((localo.exists()) && (localo.isDirectory()))
    {
      paramString = localo.b(paramString);
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localo = paramString[i];
          s.dy(aa.z(localo.mUri), true);
          Log.i("WxaJsCacheStorage", "clear file:%s", new Object[] { localo.getName() });
          i += 1;
        }
      }
    }
    AppMethodBeat.o(44352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */