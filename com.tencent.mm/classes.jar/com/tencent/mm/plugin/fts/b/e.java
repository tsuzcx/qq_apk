package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;

public final class e
  extends b
{
  private m ezf;
  com.tencent.mm.plugin.fts.c.e mVl;
  HashSet<String> mVm;
  
  public final void Pn(String paramString)
  {
    AppMethodBeat.i(136785);
    if (this.mVm.add(paramString)) {
      this.mVl.Pr(paramString);
    }
    AppMethodBeat.o(136785);
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136783);
    if (this.mVm != null) {
      this.mVm.clear();
    }
    this.mVl = null;
    this.ezf = null;
    AppMethodBeat.o(136783);
    return true;
  }
  
  public final a a(i parami)
  {
    AppMethodBeat.i(136784);
    parami = new e.b(this, parami);
    parami = this.ezf.a(-65536, parami);
    AppMethodBeat.o(136784);
    return parami;
  }
  
  public final void a(String paramString, l paraml, int paramInt, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(136787);
    e.c localc = new e.c(this, (byte)0);
    e.c.a(localc, paramString);
    e.c.a(localc, paraml);
    e.c.a(localc, paramInt);
    e.c.a(localc, paramHashMap);
    this.ezf.a(65626, localc);
    AppMethodBeat.o(136787);
  }
  
  public final void d(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(136786);
    this.mVl.b(paramArrayOfInt, paramString);
    AppMethodBeat.o(136786);
  }
  
  public final String getName()
  {
    return "FTS5SearchTopHitsLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(136782);
    if (!((n)g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
      AppMethodBeat.o(136782);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
    this.mVm = new HashSet();
    this.mVl = ((com.tencent.mm.plugin.fts.c.e)((n)g.G(n.class)).getFTSIndexStorage(1));
    this.ezf = ((n)g.G(n.class)).getFTSTaskDaemon();
    this.ezf.a(65626, new e.a(this, (byte)0));
    AppMethodBeat.o(136782);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e
 * JD-Core Version:    0.7.0.1
 */