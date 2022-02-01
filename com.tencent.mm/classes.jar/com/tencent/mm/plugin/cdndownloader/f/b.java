package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void a(a parama)
  {
    AppMethodBeat.i(120811);
    c localc = cMo();
    if (localc != null) {
      Log.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(localc.insert(parama))));
    }
    AppMethodBeat.o(120811);
  }
  
  public static void asj(String paramString)
  {
    AppMethodBeat.i(120812);
    c localc = cMo();
    if (localc != null) {
      Log.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(localc.ask(paramString))));
    }
    AppMethodBeat.o(120812);
  }
  
  public static c cMo()
  {
    AppMethodBeat.i(120813);
    c localc = ((com.tencent.mm.plugin.cdndownloader.b.a)h.ae(com.tencent.mm.plugin.cdndownloader.b.a.class)).cMo();
    AppMethodBeat.o(120813);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.b
 * JD-Core Version:    0.7.0.1
 */