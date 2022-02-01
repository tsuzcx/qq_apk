package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class i
  extends com.tencent.mm.plugin.fts.ui.a
{
  public i(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112195);
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = this.query;
    localj.handler = paramMMHandler;
    localj.wWX = paramHashSet;
    localj.wWZ = this;
    localj.wWY = com.tencent.mm.plugin.fts.a.c.c.wXz;
    paramMMHandler = ((n)g.ah(n.class)).search(4, localj);
    AppMethodBeat.o(112195);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112198);
    com.tencent.mm.plugin.fts.ui.a.j localj = new com.tencent.mm.plugin.fts.ui.a.j(paramInt2);
    localj.lqW = paramm;
    localj.wWd = parama.wWd;
    localj.gE(paramm.type, paramm.wVW);
    AppMethodBeat.o(112198);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112197);
    int i = paramInt - parama.wXD - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.mWl.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (m)parama.mWl.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).wXM = (i + 1);
      if (i == parama.mWl.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).wXK = false;
      }
    }
    AppMethodBeat.o(112197);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112196);
    if (eP(paramk.wXb))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.wWd = paramk.wWd;
      paramHashSet.mWl = paramk.wXb;
      if (paramHashSet.mWl.size() > 1)
      {
        paramHashSet.tuG = true;
        paramHashSet.mWl = paramHashSet.mWl.subList(0, 1);
      }
      this.wZO.add(paramHashSet);
    }
    AppMethodBeat.o(112196);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112199);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.mWl.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.mWl.get(paramInt);
        localObject1 = new com.tencent.mm.plugin.fts.a.a.c();
        ((com.tencent.mm.plugin.fts.a.a.c)localObject1).dUb = String.valueOf(parama.hashCode());
        ((com.tencent.mm.plugin.fts.a.a.c)localObject1).dUm = 10;
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