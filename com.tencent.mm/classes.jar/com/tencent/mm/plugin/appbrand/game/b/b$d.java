package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class b$d
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int hrK;
  
  b$d(b paramb) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(130072);
    String str = String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.hrK) });
    AppMethodBeat.o(130072);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(130071);
    Object localObject = i.aAA();
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame search list is nil.");
      AppMethodBeat.o(130071);
      return true;
    }
    this.hrK = ((List)localObject).size();
    this.hsB.hsz.beginTransaction();
    this.hsB.hsz.u(c.mQF);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.appbrand.game.b.a.b localb = (com.tencent.mm.plugin.appbrand.game.b.a.b)((Iterator)localObject).next();
      if ((localb == null) || (bo.isNullOrNil(localb.field_AppName)))
      {
        ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "UpdateMiniGameIndexTask appname is null");
        this.hrK -= 1;
      }
      else
      {
        String str = bo.nullAsNil(localb.field_RecordId);
        int i = str.hashCode();
        long l = System.currentTimeMillis();
        this.hsB.hsz.a(458752, 1, i, str, l, localb.field_AppName);
        this.hsB.hsz.a(458752, 2, i, str, l, d.aR(localb.field_AppName, false));
        this.hsB.hsz.a(458752, 3, i, str, l, d.aR(localb.field_AppName, true));
      }
    }
    this.hsB.hsz.commit();
    ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "update MiniGame info id listSize:%d", new Object[] { Integer.valueOf(this.hrK) });
    AppMethodBeat.o(130071);
    return true;
  }
  
  public final String getName()
  {
    return "UpdateMiniGameIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.d
 * JD-Core Version:    0.7.0.1
 */