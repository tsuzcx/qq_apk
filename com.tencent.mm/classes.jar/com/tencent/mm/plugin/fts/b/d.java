package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends b
{
  private m ezf;
  com.tencent.mm.plugin.fts.c.d mVi;
  
  public final boolean Pp()
  {
    this.mVi = null;
    this.ezf = null;
    return true;
  }
  
  public final a a(i parami)
  {
    AppMethodBeat.i(136776);
    parami = new d.d(this, parami);
    this.ezf.a(-65536, parami);
    AppMethodBeat.o(136776);
    return parami;
  }
  
  public final void addSOSHistory(String paramString)
  {
    AppMethodBeat.i(136773);
    d.a locala = new d.a(this);
    locala.mVj = paramString;
    this.ezf.a(132072, locala);
    AppMethodBeat.o(136773);
  }
  
  public final void deleteSOSHistory()
  {
    AppMethodBeat.i(136774);
    d.b localb = new d.b(this);
    this.ezf.a(132072, localb);
    AppMethodBeat.o(136774);
  }
  
  public final void deleteSOSHistory(String paramString)
  {
    AppMethodBeat.i(136775);
    d.c localc = new d.c(this);
    localc.mVj = paramString;
    this.ezf.a(132072, localc);
    AppMethodBeat.o(136775);
  }
  
  public final String getName()
  {
    return "FTS5SearchSOSHistoryLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(136772);
    if (!((n)g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
      AppMethodBeat.o(136772);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
    this.mVi = ((com.tencent.mm.plugin.fts.c.d)((n)g.G(n.class)).getFTSIndexStorage(1024));
    this.ezf = ((n)g.G(n.class)).getFTSTaskDaemon();
    AppMethodBeat.o(136772);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d
 * JD-Core Version:    0.7.0.1
 */