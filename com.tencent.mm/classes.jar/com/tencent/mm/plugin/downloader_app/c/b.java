package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(8963);
    if (dvf() == null)
    {
      AppMethodBeat.o(8963);
      return false;
    }
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_status = paramInt;
    locala.field_modifyTime = System.currentTimeMillis();
    boolean bool = dvf().a(locala);
    AppMethodBeat.o(8963);
    return bool;
  }
  
  public static c dvf()
  {
    AppMethodBeat.i(8962);
    if (h.baC().aZN())
    {
      h.baC();
      if (!com.tencent.mm.kernel.b.aZG()) {}
    }
    else
    {
      Log.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
      AppMethodBeat.o(8962);
      return null;
    }
    if (h.ax(com.tencent.mm.plugin.downloader.a.d.class) == null)
    {
      Log.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
      AppMethodBeat.o(8962);
      return null;
    }
    c localc = ((com.tencent.mm.plugin.downloader_app.api.d)h.ax(com.tencent.mm.plugin.downloader_app.api.d.class)).duR();
    AppMethodBeat.o(8962);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.b
 * JD-Core Version:    0.7.0.1
 */