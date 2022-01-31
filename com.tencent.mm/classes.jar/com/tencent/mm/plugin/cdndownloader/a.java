package com.tencent.mm.plugin.cdndownloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.cdndownloader.f.c;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.cdndownloader.b.a
{
  private c kDv;
  
  public final c bfO()
  {
    return this.kDv;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(859);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CdnDownloadInfo".hashCode()), new a.1(this));
    AppMethodBeat.o(859);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(860);
    this.kDv = new c(paramh1);
    AppMethodBeat.o(860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.a
 * JD-Core Version:    0.7.0.1
 */