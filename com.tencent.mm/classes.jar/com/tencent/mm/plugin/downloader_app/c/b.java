package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public static c bYz()
  {
    AppMethodBeat.i(8962);
    if (g.agP().afY())
    {
      g.agP();
      if (!com.tencent.mm.kernel.a.afS()) {}
    }
    else
    {
      ac.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
      AppMethodBeat.o(8962);
      return null;
    }
    if (g.ab(com.tencent.mm.plugin.downloader.a.d.class) == null)
    {
      ac.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
      AppMethodBeat.o(8962);
      return null;
    }
    c localc = ((com.tencent.mm.plugin.downloader_app.api.d)g.ab(com.tencent.mm.plugin.downloader_app.api.d.class)).bYf();
    AppMethodBeat.o(8962);
    return localc;
  }
  
  public static boolean cL(String paramString, int paramInt)
  {
    AppMethodBeat.i(8963);
    if (bYz() == null)
    {
      AppMethodBeat.o(8963);
      return false;
    }
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_status = paramInt;
    locala.field_modifyTime = System.currentTimeMillis();
    boolean bool = bYz().a(locala);
    AppMethodBeat.o(8963);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.b
 * JD-Core Version:    0.7.0.1
 */