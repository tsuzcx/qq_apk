package com.tencent.mm.plugin.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.downloader.a.d
{
  private com.tencent.mm.plugin.downloader.g.b uec;
  private long ued = 0L;
  
  public final com.tencent.mm.plugin.downloader.g.b bbS()
  {
    AppMethodBeat.i(88817);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.downloader.g.b localb = this.uec;
    AppMethodBeat.o(88817);
    return localb;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(88818);
    Log.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
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
  
  public final void md(boolean paramBoolean)
  {
    AppMethodBeat.i(88819);
    Log.i("MicroMsg.FileDownloaderService", "active: ".concat(String.valueOf(paramBoolean)));
    if ((!paramBoolean) && ((System.currentTimeMillis() - this.ued) / 1000L > 1800L))
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88815);
          b.cPP();
          AppMethodBeat.o(88815);
        }
      }, "checkDownloadFile");
      this.ued = System.currentTimeMillis();
    }
    AppMethodBeat.o(88819);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(88816);
    this.uec = new com.tencent.mm.plugin.downloader.g.b(paramh1);
    AppMethodBeat.o(88816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b
 * JD-Core Version:    0.7.0.1
 */