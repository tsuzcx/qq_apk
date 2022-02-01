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
    localj.jQN = 1;
    localj.query = this.query;
    localj.tvg = 1;
    localj.tvh = paramHashSet;
    localj.handler = paramap;
    localj.tvj = this;
    paramap = ((n)g.ad(n.class)).search(6, localj);
    AppMethodBeat.o(107316);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107318);
    int i = paramInt - parama.tvN - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lKC.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lKC.get(i);
        localObject = new a(paramInt);
        ((a)localObject).kjY = localm;
        ((a)localObject).tun = parama.tun;
        ((a)localObject).gf(localm.type, localm.tug);
        ((a)localObject).rBJ = false;
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvW = (i + 1);
    }
    AppMethodBeat.o(107318);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107317);
    if (dT(paramk.tvl))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.tun = paramk.tun;
      paramHashSet.lKC = paramk.tvl;
      if (paramHashSet.lKC.size() > 1)
      {
        paramHashSet.rKf = true;
        paramHashSet.lKC = paramHashSet.lKC.subList(0, 1);
      }
      this.txY.add(paramHashSet);
    }
    AppMethodBeat.o(107317);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107319);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.lKC.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.lKC.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).dBg = String.valueOf(parama.hashCode());
        ((c)localObject1).dBr = 12;
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