package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.c;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112191);
    paramHashSet.add("62");
    if (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null))) {
      paramHashSet.add("65");
    }
    if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBQ()) {
      paramHashSet.add("63");
    }
    for (;;)
    {
      if (!((f)g.ab(f.class)).bnd()) {
        paramHashSet.add("69");
      }
      if (!((com.tencent.mm.plugin.appbrand.service.h)g.ab(com.tencent.mm.plugin.appbrand.service.h.class)).bnd()) {
        paramHashSet.add("71");
      }
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = this.query;
      localj.handler = paramap;
      localj.rpM = paramHashSet;
      localj.rpO = this;
      localj.rpN = c.rqo;
      paramap = ((n)g.ad(n.class)).search(4, localj);
      AppMethodBeat.o(112191);
      return paramap;
      paramHashSet.add("67");
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112194);
    com.tencent.mm.plugin.fts.ui.a.j localj = new com.tencent.mm.plugin.fts.ui.a.j(paramInt2);
    localj.jpy = paramm;
    localj.roS = parama.roS;
    localj.fI(paramm.type, paramm.roM);
    AppMethodBeat.o(112194);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112193);
    int i = paramInt - parama.rqs - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.kLN.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (m)parama.kLN.get(i), parama);
      }
    }
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).rqB = (i + 1);
    }
    AppMethodBeat.o(112193);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112192);
    if (dF(paramk.rpQ))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.roS = paramk.roS;
      paramHashSet.kLN = paramk.rpQ;
      paramHashSet.qpI = false;
      this.rsD.add(paramHashSet);
    }
    AppMethodBeat.o(112192);
  }
  
  public final int getType()
  {
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.h
 * JD-Core Version:    0.7.0.1
 */