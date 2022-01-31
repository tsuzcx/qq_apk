package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m ezf;
  c hrH;
  private k.a hrI;
  
  public b()
  {
    AppMethodBeat.i(129964);
    this.hrI = new b.1(this);
    AppMethodBeat.o(129964);
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(129967);
    i.onDestroy();
    i.d(this.hrI);
    this.hrH = null;
    this.ezf = null;
    AppMethodBeat.o(129967);
    return true;
  }
  
  public final a a(com.tencent.mm.plugin.fts.a.a.i parami)
  {
    AppMethodBeat.i(129965);
    parami = new b.c(this, parami);
    parami = this.ezf.a(-65536, parami);
    AppMethodBeat.o(129965);
    return parami;
  }
  
  public final String getName()
  {
    return "FTS5SearchWeAppLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(129966);
    if (!((n)g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
      AppMethodBeat.o(129966);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
    this.hrH = ((c)((n)g.G(n.class)).getFTSIndexStorage(512));
    this.ezf = ((n)g.G(n.class)).getFTSTaskDaemon();
    this.ezf.a(65616, new b.d(this));
    i.onCreate();
    i.c(this.hrI);
    AppMethodBeat.o(129966);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b
 * JD-Core Version:    0.7.0.1
 */