package com.tencent.mm.plugin.downloader_app.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public static boolean bV(String paramString, int paramInt)
  {
    AppMethodBeat.i(136202);
    if (bjW() == null)
    {
      AppMethodBeat.o(136202);
      return false;
    }
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_status = paramInt;
    locala.field_modifyTime = System.currentTimeMillis();
    boolean bool = bjW().a(locala);
    AppMethodBeat.o(136202);
    return bool;
  }
  
  public static c bjW()
  {
    AppMethodBeat.i(136201);
    if (g.RJ().QU())
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP()) {}
    }
    else
    {
      ab.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
      AppMethodBeat.o(136201);
      return null;
    }
    if (g.E(d.class) == null)
    {
      ab.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
      AppMethodBeat.o(136201);
      return null;
    }
    c localc = ((e)g.E(e.class)).bjG();
    AppMethodBeat.o(136201);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.b
 * JD-Core Version:    0.7.0.1
 */