package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends b
{
  private m dBO;
  com.tencent.mm.plugin.fts.c.d kzs;
  
  protected final boolean BB()
  {
    this.kzs = null;
    this.dBO = null;
    return true;
  }
  
  public final a a(i parami)
  {
    parami = new d.d(this, parami);
    this.dBO.a(-65536, parami);
    return parami;
  }
  
  public final void addSOSHistory(String paramString)
  {
    d.a locala = new d.a(this);
    locala.kzt = paramString;
    this.dBO.a(132072, locala);
  }
  
  public final void deleteSOSHistory()
  {
    d.b localb = new d.b(this);
    this.dBO.a(132072, localb);
  }
  
  public final void deleteSOSHistory(String paramString)
  {
    d.c localc = new d.c(this);
    localc.kzt = paramString;
    this.dBO.a(132072, localc);
  }
  
  public final String getName()
  {
    return "FTS5SearchSOSHistoryLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
    this.kzs = ((com.tencent.mm.plugin.fts.c.d)((n)g.t(n.class)).getFTSIndexStorage(1024));
    this.dBO = ((n)g.t(n.class)).getFTSTaskDaemon();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d
 * JD-Core Version:    0.7.0.1
 */