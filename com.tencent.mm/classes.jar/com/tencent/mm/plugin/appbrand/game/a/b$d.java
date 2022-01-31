package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class b$d
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int fYw;
  
  b$d(b paramb) {}
  
  public final String afJ()
  {
    return String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.fYw) });
  }
  
  public final boolean execute()
  {
    Object localObject = i.agv();
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame search list is nil.");
      return true;
    }
    this.fYw = ((List)localObject).size();
    this.gaB.gaz.beginTransaction();
    this.gaB.gaz.k(c.kuS);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.appbrand.game.a.a.b localb = (com.tencent.mm.plugin.appbrand.game.a.a.b)((Iterator)localObject).next();
      if ((localb == null) || (bk.bl(localb.field_AppName)))
      {
        y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "UpdateMiniGameIndexTask appname is null");
        this.fYw -= 1;
      }
      else
      {
        String str = bk.pm(localb.field_RecordId);
        int i = str.hashCode();
        long l = System.currentTimeMillis();
        this.gaB.gaz.a(458752, 1, i, str, l, localb.field_AppName);
        this.gaB.gaz.a(458752, 2, i, str, l, d.aD(localb.field_AppName, false));
        this.gaB.gaz.a(458752, 3, i, str, l, d.aD(localb.field_AppName, true));
      }
    }
    this.gaB.gaz.commit();
    y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "update MiniGame info id listSize:%d", new Object[] { Integer.valueOf(this.fYw) });
    return true;
  }
  
  public final String getName()
  {
    return "UpdateMiniGameIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.b.d
 * JD-Core Version:    0.7.0.1
 */