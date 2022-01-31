package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m ezf;
  private k.a hsA;
  a hsz;
  
  public b()
  {
    AppMethodBeat.i(130073);
    this.hsA = new b.1(this);
    AppMethodBeat.o(130073);
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(130076);
    i.onDestroy();
    i.d(this.hsA);
    this.hsz = null;
    this.ezf = null;
    AppMethodBeat.o(130076);
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.i parami)
  {
    AppMethodBeat.i(130074);
    parami = new b.c(this, parami);
    parami = this.ezf.a(-65536, parami);
    AppMethodBeat.o(130074);
    return parami;
  }
  
  public final String getName()
  {
    return "FTS5SearchMiniGameLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(130075);
    if (!((n)g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Fail!");
      AppMethodBeat.o(130075);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Success!");
    this.hsz = ((a)((n)g.G(n.class)).getFTSIndexStorage(8));
    this.ezf = ((n)g.G(n.class)).getFTSTaskDaemon();
    this.ezf.a(65601, new b.d(this));
    i.onCreate();
    i.c(this.hsA);
    AppMethodBeat.o(130075);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b
 * JD-Core Version:    0.7.0.1
 */