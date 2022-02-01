package com.tencent.mm.plugin.fav.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.fts.ui.a
{
  public e(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107316);
    j localj = new j();
    localj.iWB = 1;
    localj.query = this.query;
    localj.rpL = 1;
    localj.rpM = paramHashSet;
    localj.handler = paramap;
    localj.rpO = this;
    paramap = ((n)g.ad(n.class)).search(6, localj);
    AppMethodBeat.o(107316);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107318);
    int i = paramInt - parama.rqs - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.kLN.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.kLN.get(i);
        localObject = new a(paramInt);
        ((a)localObject).jpy = localm;
        ((a)localObject).roS = parama.roS;
        ((a)localObject).fI(localm.type, localm.roM);
        ((a)localObject).qjh = false;
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqB = (i + 1);
    }
    AppMethodBeat.o(107318);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107317);
    if (dF(paramk.rpQ))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.roS = paramk.roS;
      paramHashSet.kLN = paramk.rpQ;
      if (paramHashSet.kLN.size() > 1)
      {
        paramHashSet.qpI = true;
        paramHashSet.kLN = paramHashSet.kLN.subList(0, 1);
      }
      this.rsD.add(paramHashSet);
    }
    AppMethodBeat.o(107317);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107319);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.kLN.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.kLN.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).drI = String.valueOf(parama.hashCode());
        ((c)localObject1).drT = 12;
      }
    }
    AppMethodBeat.o(107319);
    return localObject1;
  }
  
  public final int getType()
  {
    return 128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.e
 * JD-Core Version:    0.7.0.1
 */