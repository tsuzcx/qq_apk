package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m dBO;
  private j.a gaA = new b.1(this);
  a gaz;
  
  protected final boolean BB()
  {
    i.onDestroy();
    i.f(this.gaA);
    this.gaz = null;
    this.dBO = null;
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.i parami)
  {
    parami = new b.c(this, parami);
    return this.dBO.a(-65536, parami);
  }
  
  public final String getName()
  {
    return "FTS5SearchMiniGameLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Success!");
    this.gaz = ((a)((n)g.t(n.class)).getFTSIndexStorage(8));
    this.dBO = ((n)g.t(n.class)).getFTSTaskDaemon();
    this.dBO.a(65601, new b.d(this));
    i.onCreate();
    i.e(this.gaA);
    return true;
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int gaD;
    private List<String> idList;
    
    public b(List paramList)
    {
      this.idList = paramList;
    }
    
    public final String afJ()
    {
      return String.format("{insertSize: %d}", new Object[] { Integer.valueOf(this.gaD) });
    }
    
    public final boolean execute()
    {
      if (bk.dk(this.idList)) {
        return false;
      }
      this.gaD = this.idList.size();
      y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id listSize:%d", new Object[] { Integer.valueOf(this.gaD) });
      b.this.gaz.beginTransaction();
      Iterator localIterator = this.idList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        b.this.gaz.b(c.kuS, str);
        com.tencent.mm.plugin.appbrand.game.a.a.b localb = i.tr(str);
        if ((localb != null) && (!bk.bl(localb.field_AppName)))
        {
          long l = System.currentTimeMillis();
          str = bk.pm(localb.field_RecordId);
          int i = str.hashCode();
          b.this.gaz.a(458752, 1, i, str, l, localb.field_AppName);
          b.this.gaz.a(458752, 2, i, str, l, d.aD(localb.field_AppName, false));
          b.this.gaz.a(458752, 3, i, str, l, d.aD(localb.field_AppName, true));
          y.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id = %s, name = %s", new Object[] { str, localb.field_AppName });
        }
        else
        {
          y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted miniGame info is null. id:%s", new Object[] { str });
        }
      }
      b.this.gaz.commit();
      return true;
    }
    
    public final String getName()
    {
      return "InsertMiniGameTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.b
 * JD-Core Version:    0.7.0.1
 */