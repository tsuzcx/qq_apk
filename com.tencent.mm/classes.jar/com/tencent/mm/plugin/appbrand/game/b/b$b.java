package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class b$b
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int hsD;
  private List<String> idList;
  
  public b$b(b paramb, List paramList)
  {
    this.idList = paramList;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(130069);
    String str = String.format("{insertSize: %d}", new Object[] { Integer.valueOf(this.hsD) });
    AppMethodBeat.o(130069);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(130068);
    if (bo.es(this.idList))
    {
      AppMethodBeat.o(130068);
      return false;
    }
    this.hsD = this.idList.size();
    ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id listSize:%d", new Object[] { Integer.valueOf(this.hsD) });
    this.hsB.hsz.beginTransaction();
    Iterator localIterator = this.idList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.hsB.hsz.b(c.mQF, str);
      com.tencent.mm.plugin.appbrand.game.b.a.b localb = i.Bv(str);
      if ((localb != null) && (!bo.isNullOrNil(localb.field_AppName)))
      {
        long l = System.currentTimeMillis();
        str = bo.nullAsNil(localb.field_RecordId);
        int i = str.hashCode();
        this.hsB.hsz.a(458752, 1, i, str, l, localb.field_AppName);
        this.hsB.hsz.a(458752, 2, i, str, l, d.aR(localb.field_AppName, false));
        this.hsB.hsz.a(458752, 3, i, str, l, d.aR(localb.field_AppName, true));
        ab.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id = %s, name = %s", new Object[] { str, localb.field_AppName });
      }
      else
      {
        ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted miniGame info is null. id:%s", new Object[] { str });
      }
    }
    this.hsB.hsz.commit();
    AppMethodBeat.o(130068);
    return true;
  }
  
  public final String getName()
  {
    return "InsertMiniGameTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.b
 * JD-Core Version:    0.7.0.1
 */