package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class b$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int gaC;
  private List<String> idList;
  
  public b$a(b paramb, List paramList)
  {
    this.idList = paramList;
  }
  
  public final String afJ()
  {
    return String.format("{deleteSize: %d}", new Object[] { Integer.valueOf(this.gaC) });
  }
  
  public final boolean execute()
  {
    if (bk.dk(this.idList)) {
      return false;
    }
    this.gaC = this.idList.size();
    y.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "delete MiniGame info id listSize:%d", new Object[] { Integer.valueOf(this.gaC) });
    Iterator localIterator = this.idList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.gaB.gaz.b(c.kuS, str);
    }
    return true;
  }
  
  public final String getName()
  {
    return "DeleteMiniGameTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.b.a
 * JD-Core Version:    0.7.0.1
 */