package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static void RD(String paramString)
  {
    AppMethodBeat.i(120812);
    c localc = bMZ();
    if (localc != null) {
      ad.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(localc.RE(paramString))));
    }
    AppMethodBeat.o(120812);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(120811);
    c localc = bMZ();
    if (localc != null) {
      ad.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(localc.insert(parama))));
    }
    AppMethodBeat.o(120811);
  }
  
  public static c bMZ()
  {
    AppMethodBeat.i(120813);
    c localc = ((com.tencent.mm.plugin.cdndownloader.b.a)g.ab(com.tencent.mm.plugin.cdndownloader.b.a.class)).bMZ();
    AppMethodBeat.o(120813);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.b
 * JD-Core Version:    0.7.0.1
 */