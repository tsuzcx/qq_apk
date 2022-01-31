package com.tencent.mm.plugin.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.downloader.a.d
{
  private com.tencent.mm.plugin.downloader.g.b kVg;
  private long kVh = 0L;
  
  public final com.tencent.mm.plugin.downloader.g.b YG()
  {
    AppMethodBeat.i(2273);
    g.RM();
    g.RJ().QQ();
    com.tencent.mm.plugin.downloader.g.b localb = this.kVg;
    AppMethodBeat.o(2273);
    return localb;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(2274);
    ab.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new b.1(this));
    AppMethodBeat.o(2274);
    return localHashMap;
  }
  
  public final void gq(boolean paramBoolean)
  {
    AppMethodBeat.i(2275);
    ab.i("MicroMsg.FileDownloaderService", "active: ".concat(String.valueOf(paramBoolean)));
    if ((!paramBoolean) && ((System.currentTimeMillis() - this.kVh) / 1000L > 1800L))
    {
      com.tencent.mm.sdk.g.d.post(new b.2(this), "checkDownloadFile");
      this.kVh = System.currentTimeMillis();
    }
    AppMethodBeat.o(2275);
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(2272);
    this.kVg = new com.tencent.mm.plugin.downloader.g.b(paramh1);
    AppMethodBeat.o(2272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b
 * JD-Core Version:    0.7.0.1
 */