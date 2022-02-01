package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static void a(a parama)
  {
    AppMethodBeat.i(120811);
    c localc = cae();
    if (localc != null) {
      ae.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(localc.insert(parama))));
    }
    AppMethodBeat.o(120811);
  }
  
  public static void aap(String paramString)
  {
    AppMethodBeat.i(120812);
    c localc = cae();
    if (localc != null) {
      ae.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(localc.aaq(paramString))));
    }
    AppMethodBeat.o(120812);
  }
  
  public static c cae()
  {
    AppMethodBeat.i(120813);
    c localc = ((com.tencent.mm.plugin.cdndownloader.b.a)g.ab(com.tencent.mm.plugin.cdndownloader.b.a.class)).cae();
    AppMethodBeat.o(120813);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.b
 * JD-Core Version:    0.7.0.1
 */