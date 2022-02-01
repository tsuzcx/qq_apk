package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.fts.ui.a
{
  public i(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112195);
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = this.query;
    localj.handler = paramap;
    localj.tvh = paramHashSet;
    localj.tvj = this;
    localj.tvi = com.tencent.mm.plugin.fts.a.c.c.tvJ;
    paramap = ((n)g.ad(n.class)).search(4, localj);
    AppMethodBeat.o(112195);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112198);
    com.tencent.mm.plugin.fts.ui.a.j localj = new com.tencent.mm.plugin.fts.ui.a.j(paramInt2);
    localj.kjY = paramm;
    localj.tun = parama.tun;
    localj.gf(paramm.type, paramm.tug);
    AppMethodBeat.o(112198);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112197);
    int i = paramInt - parama.tvN - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.lKC.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (m)parama.lKC.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).tvW = (i + 1);
      if (i == parama.lKC.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).tvU = false;
      }
    }
    AppMethodBeat.o(112197);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112196);
    if (dT(paramk.tvl))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.tun = paramk.tun;
      paramHashSet.lKC = paramk.tvl;
      if (paramHashSet.lKC.size() > 1)
      {
        paramHashSet.rKf = true;
        paramHashSet.lKC = paramHashSet.lKC.subList(0, 1);
      }
      this.txY.add(paramHashSet);
    }
    AppMethodBeat.o(112196);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112199);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.lKC.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.lKC.get(paramInt);
        localObject1 = new com.tencent.mm.plugin.fts.a.a.c();
        ((com.tencent.mm.plugin.fts.a.a.c)localObject1).dBg = String.valueOf(parama.hashCode());
        ((com.tencent.mm.plugin.fts.a.a.c)localObject1).dBr = 10;
      }
    }
    AppMethodBeat.o(112199);
    return localObject1;
  }
  
  public final int getType()
  {
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.i
 * JD-Core Version:    0.7.0.1
 */