package com.tencent.mm.plugin.fav.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107312);
    j localj = new j();
    localj.jQN = 2;
    localj.query = this.query;
    localj.tvh = paramHashSet;
    localj.handler = paramap;
    localj.tvj = this;
    localj.tvi = d.tvK;
    paramap = ((n)g.ad(n.class)).search(6, localj);
    AppMethodBeat.o(107312);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107314);
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
        ((a)localObject).rBJ = true;
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvW = (i + 1);
    }
    AppMethodBeat.o(107314);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107313);
    if (dT(paramk.tvl))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.tun = paramk.tun;
      paramHashSet.lKC = paramk.tvl;
      this.txY.add(paramHashSet);
    }
    AppMethodBeat.o(107313);
  }
  
  public final int getType()
  {
    return 4192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.c
 * JD-Core Version:    0.7.0.1
 */