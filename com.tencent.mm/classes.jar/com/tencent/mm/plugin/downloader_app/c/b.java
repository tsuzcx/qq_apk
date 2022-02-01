package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static c cCi()
  {
    AppMethodBeat.i(8962);
    if (g.aAf().azp())
    {
      g.aAf();
      if (!com.tencent.mm.kernel.a.azj()) {}
    }
    else
    {
      Log.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
      AppMethodBeat.o(8962);
      return null;
    }
    if (g.af(com.tencent.mm.plugin.downloader.a.d.class) == null)
    {
      Log.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
      AppMethodBeat.o(8962);
      return null;
    }
    c localc = ((com.tencent.mm.plugin.downloader_app.api.d)g.af(com.tencent.mm.plugin.downloader_app.api.d.class)).cBU();
    AppMethodBeat.o(8962);
    return localc;
  }
  
  public static boolean cX(String paramString, int paramInt)
  {
    AppMethodBeat.i(8963);
    if (cCi() == null)
    {
      AppMethodBeat.o(8963);
      return false;
    }
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_status = paramInt;
    locala.field_modifyTime = System.currentTimeMillis();
    boolean bool = cCi().a(locala);
    AppMethodBeat.o(8963);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.b
 * JD-Core Version:    0.7.0.1
 */