package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public static void IT(String paramString)
  {
    AppMethodBeat.i(960);
    c localc = bfO();
    if (localc != null) {
      ab.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(localc.IU(paramString))));
    }
    AppMethodBeat.o(960);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(959);
    c localc = bfO();
    if (localc != null) {
      ab.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(localc.insert(parama))));
    }
    AppMethodBeat.o(959);
  }
  
  public static c bfO()
  {
    AppMethodBeat.i(961);
    c localc = ((com.tencent.mm.plugin.cdndownloader.b.a)g.E(com.tencent.mm.plugin.cdndownloader.b.a.class)).bfO();
    AppMethodBeat.o(961);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.b
 * JD-Core Version:    0.7.0.1
 */