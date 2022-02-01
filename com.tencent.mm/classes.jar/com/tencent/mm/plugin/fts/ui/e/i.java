package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.j;
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
  
  public final com.tencent.mm.plugin.fts.a.a.c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112195);
    l locall = new l();
    locall.query = getQuery();
    locall.handler = paramMMHandler;
    locall.HtA = paramHashSet;
    locall.HtC = this;
    locall.HtB = com.tencent.mm.plugin.fts.a.c.c.Huf;
    paramMMHandler = ((n)h.az(n.class)).search(4, locall);
    AppMethodBeat.o(112195);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    AppMethodBeat.i(112198);
    j localj = new j(paramInt2);
    localj.rpp = paramo;
    localj.FWt = parama.FWt;
    localj.iW(paramo.type, paramo.subtype);
    AppMethodBeat.o(112198);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112197);
    int i = paramInt - parama.Huj - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (o)parama.tbH.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hur = (i + 1);
      if (i == parama.tbH.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hup = false;
      }
    }
    AppMethodBeat.o(112197);
    return localObject1;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112196);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      if (paramHashSet.tbH.size() > 1)
      {
        paramHashSet.ABD = true;
        paramHashSet.tbH = paramHashSet.tbH.subList(0, 1);
      }
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(112196);
  }
  
  public final e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112199);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (o)parama.tbH.get(paramInt);
        localObject1 = new e();
        ((e)localObject1).hTs = String.valueOf(parama.hashCode());
        ((e)localObject1).itemType = 10;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.i
 * JD-Core Version:    0.7.0.1
 */