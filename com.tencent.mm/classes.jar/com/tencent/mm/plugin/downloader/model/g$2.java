package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CopyOnWriteArraySet;

final class g$2
  implements am.a
{
  g$2(g paramg) {}
  
  public final boolean tC()
  {
    g localg = this.iPS;
    com.tencent.mm.kernel.g.DS().O(new g.3(localg));
    localg = this.iPS;
    if ((localg.iPQ == null) || (localg.iPQ.size() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.iPS.fjC.S(1000L, 1000L);
      return false;
    }
    y.d("MicroMsg.FileDownloaderImpl23", "timer stop");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g.2
 * JD-Core Version:    0.7.0.1
 */