package com.tencent.mm.plugin.cdndownloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$6
  implements Runnable
{
  a$6(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(898);
    synchronized (a.access$800())
    {
      ab.i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync, notify after 10000ms");
      a.access$800().notifyAll();
      AppMethodBeat.o(898);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.6
 * JD-Core Version:    0.7.0.1
 */