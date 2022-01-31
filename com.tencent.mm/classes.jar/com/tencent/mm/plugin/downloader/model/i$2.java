package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.concurrent.CopyOnWriteArraySet;

final class i$2
  implements ap.a
{
  i$2(i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(2453);
    i locali = this.kZe;
    g.RO().ac(new i.3(locali));
    locali = this.kZe;
    if ((locali.kZc == null) || (locali.kZc.size() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.kZe.bAz.ag(1000L, 1000L);
      AppMethodBeat.o(2453);
      return false;
    }
    ab.d("MicroMsg.FileDownloaderImpl23", "timer stop");
    AppMethodBeat.o(2453);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.i.2
 * JD-Core Version:    0.7.0.1
 */