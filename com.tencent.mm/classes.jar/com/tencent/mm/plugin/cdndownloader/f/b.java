package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void a(a parama)
  {
    AppMethodBeat.i(120811);
    c localc = cxT();
    if (localc != null) {
      Log.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(localc.insert(parama))));
    }
    AppMethodBeat.o(120811);
  }
  
  public static void akv(String paramString)
  {
    AppMethodBeat.i(120812);
    c localc = cxT();
    if (localc != null) {
      Log.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(localc.akw(paramString))));
    }
    AppMethodBeat.o(120812);
  }
  
  public static c cxT()
  {
    AppMethodBeat.i(120813);
    c localc = ((com.tencent.mm.plugin.cdndownloader.b.a)g.af(com.tencent.mm.plugin.cdndownloader.b.a.class)).cxT();
    AppMethodBeat.o(120813);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.b
 * JD-Core Version:    0.7.0.1
 */