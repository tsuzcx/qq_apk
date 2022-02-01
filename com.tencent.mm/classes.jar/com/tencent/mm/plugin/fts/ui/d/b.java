package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.ui.a
{
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112168);
    j localj = new j();
    localj.iWB = 32;
    localj.query = this.query;
    localj.rpM = paramHashSet;
    localj.rpN = com.tencent.mm.plugin.fts.a.c.a.rqm;
    localj.rpO = this;
    localj.handler = paramap;
    paramap = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112168);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112170);
    int i = paramInt - parama.rqs - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.kLN.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.kLN.get(i);
        if (!localm.roN.equals("create_chatroom​")) {
          break label110;
        }
        localObject = new h(paramInt);
        ((h)localObject).roS = parama.roS;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqB = (i + 1);
      }
      AppMethodBeat.o(112170);
      return localObject;
      label110:
      localObject = new q(paramInt);
      ((q)localObject).jpy = localm;
      ((q)localObject).roS = parama.roS;
      ((q)localObject).fI(localm.type, localm.roM);
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112169);
    if (dF(paramk.rpQ))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -3;
      paramHashSet.kLN = paramk.rpQ;
      paramHashSet.roS = paramk.roS;
      paramHashSet.qpI = false;
      this.rsD.add(paramHashSet);
    }
    AppMethodBeat.o(112169);
  }
  
  public final int getType()
  {
    return 4128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.b
 * JD-Core Version:    0.7.0.1
 */