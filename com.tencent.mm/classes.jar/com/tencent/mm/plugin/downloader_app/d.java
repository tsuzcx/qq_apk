package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class d
  implements a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.downloader_app.api.d
{
  private c pnT;
  
  public final c ccJ()
  {
    return this.pnT;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(8780);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("DOWNLOADTASKITEM_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(8780);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(8781);
    this.pnT = new c(paramh1);
    AppMethodBeat.o(8781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d
 * JD-Core Version:    0.7.0.1
 */