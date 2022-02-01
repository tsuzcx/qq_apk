package com.tencent.mm.plugin.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.downloader.a.d
{
  private com.tencent.mm.plugin.downloader.g.b obO;
  private long obP = 0L;
  
  public final com.tencent.mm.plugin.downloader.g.b apS()
  {
    AppMethodBeat.i(88817);
    g.afC();
    g.afz().aeD();
    com.tencent.mm.plugin.downloader.g.b localb = this.obO;
    AppMethodBeat.o(88817);
    return localb;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(88818);
    ad.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.downloader.g.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(88818);
    return localHashMap;
  }
  
  public final void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(88819);
    ad.i("MicroMsg.FileDownloaderService", "active: ".concat(String.valueOf(paramBoolean)));
    if ((!paramBoolean) && ((System.currentTimeMillis() - this.obP) / 1000L > 1800L))
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88815);
          b.bQh();
          AppMethodBeat.o(88815);
        }
      }, "checkDownloadFile");
      this.obP = System.currentTimeMillis();
    }
    AppMethodBeat.o(88819);
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(88816);
    this.obO = new com.tencent.mm.plugin.downloader.g.b(paramh1);
    AppMethodBeat.o(88816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b
 * JD-Core Version:    0.7.0.1
 */