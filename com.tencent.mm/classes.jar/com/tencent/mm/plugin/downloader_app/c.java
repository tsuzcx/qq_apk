package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.downloader_app.a.e;
import java.util.HashMap;

public final class c
  implements a, d, e
{
  private com.tencent.mm.plugin.downloader_app.d.c kZW;
  
  public final com.tencent.mm.plugin.downloader_app.d.c bjG()
  {
    return this.kZW;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(136025);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("DOWNLOADTASKITEM_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.downloader_app.d.c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(136025);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(136026);
    this.kZW = new com.tencent.mm.plugin.downloader_app.d.c(paramh1);
    AppMethodBeat.o(136026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c
 * JD-Core Version:    0.7.0.1
 */