package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class b$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int hsC;
  private List<String> idList;
  
  public b$a(b paramb, List paramList)
  {
    this.idList = paramList;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(130067);
    String str = String.format("{deleteSize: %d}", new Object[] { Integer.valueOf(this.hsC) });
    AppMethodBeat.o(130067);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(130066);
    if (bo.es(this.idList))
    {
      AppMethodBeat.o(130066);
      return false;
    }
    this.hsC = this.idList.size();
    ab.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "delete MiniGame info id listSize:%d", new Object[] { Integer.valueOf(this.hsC) });
    Iterator localIterator = this.idList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.hsB.hsz.b(c.mQF, str);
    }
    AppMethodBeat.o(130066);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteMiniGameTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.a
 * JD-Core Version:    0.7.0.1
 */