package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.fts.ui.a
{
  public d(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112176);
    j localj = new j();
    localj.query = this.query;
    localj.tve = new int[] { 131072, 131081 };
    localj.tvi = b.tvI;
    localj.tvh = paramHashSet;
    localj.tvj = this;
    localj.handler = paramap;
    localj.jQN = 16;
    paramap = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112176);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112178);
    int i = paramInt - parama.tvN - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lKC.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lKC.get(i);
        localObject = new r(paramInt);
        ((r)localObject).kjY = localm;
        ((r)localObject).tun = parama.tun;
        ((r)localObject).gf(localm.type, localm.tug);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvW = (i + 1);
    }
    AppMethodBeat.o(112178);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112177);
    if (dT(paramk.tvl))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -4;
      paramHashSet.lKC = paramk.tvl;
      paramHashSet.tun = paramk.tun;
      paramHashSet.rKf = false;
      this.txY.add(paramHashSet);
    }
    AppMethodBeat.o(112177);
  }
  
  public final int getType()
  {
    return 4112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.d
 * JD-Core Version:    0.7.0.1
 */