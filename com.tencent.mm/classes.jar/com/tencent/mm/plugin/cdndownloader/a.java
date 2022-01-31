package com.tencent.mm.plugin.cdndownloader;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.cdndownloader.f.c;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.cdndownloader.b.a
{
  private c iAp;
  
  public final c aDr()
  {
    return this.iAp;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CdnDownloadInfo".hashCode()), new a.1(this));
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    this.iAp = new c(paramh1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.a
 * JD-Core Version:    0.7.0.1
 */