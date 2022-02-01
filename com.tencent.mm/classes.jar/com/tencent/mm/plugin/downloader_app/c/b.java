package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static c cQM()
  {
    AppMethodBeat.i(8962);
    if (h.aHE().aGM())
    {
      h.aHE();
      if (!com.tencent.mm.kernel.b.aGE()) {}
    }
    else
    {
      Log.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
      AppMethodBeat.o(8962);
      return null;
    }
    if (h.ae(com.tencent.mm.plugin.downloader.a.d.class) == null)
    {
      Log.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
      AppMethodBeat.o(8962);
      return null;
    }
    c localc = ((com.tencent.mm.plugin.downloader_app.api.d)h.ae(com.tencent.mm.plugin.downloader_app.api.d.class)).cQy();
    AppMethodBeat.o(8962);
    return localc;
  }
  
  public static boolean dr(String paramString, int paramInt)
  {
    AppMethodBeat.i(8963);
    if (cQM() == null)
    {
      AppMethodBeat.o(8963);
      return false;
    }
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_status = paramInt;
    locala.field_modifyTime = System.currentTimeMillis();
    boolean bool = cQM().a(locala);
    AppMethodBeat.o(8963);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.b
 * JD-Core Version:    0.7.0.1
 */