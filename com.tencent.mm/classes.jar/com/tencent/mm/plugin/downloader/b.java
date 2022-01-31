package com.tencent.mm.plugin.downloader;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class b
  implements com.tencent.mm.kernel.api.bucket.a, d, c
{
  private com.tencent.mm.plugin.downloader.f.b iOb;
  
  public final com.tencent.mm.plugin.downloader.f.b FC()
  {
    g.DQ();
    g.DN().CX();
    return this.iOb;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    y.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new b.1(this));
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    this.iOb = new com.tencent.mm.plugin.downloader.f.b(paramh1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b
 * JD-Core Version:    0.7.0.1
 */