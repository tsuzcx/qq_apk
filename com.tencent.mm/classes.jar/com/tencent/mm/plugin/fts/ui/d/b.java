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
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.ui.a
{
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112168);
    j localj = new j();
    localj.jUf = 32;
    localj.query = this.query;
    localj.tFY = paramHashSet;
    localj.tFZ = com.tencent.mm.plugin.fts.a.c.a.tGy;
    localj.tGa = this;
    localj.handler = paramaq;
    paramaq = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112168);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112170);
    int i = paramInt - parama.tGE - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lPc.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lPc.get(i);
        if (!localm.tEY.equals("create_chatroom​")) {
          break label110;
        }
        localObject = new h(paramInt);
        ((h)localObject).tFe = parama.tFe;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
      }
      AppMethodBeat.o(112170);
      return localObject;
      label110:
      localObject = new q(paramInt);
      ((q)localObject).kno = localm;
      ((q)localObject).tFe = parama.tFe;
      ((q)localObject).gf(localm.type, localm.tEX);
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112169);
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -3;
      paramHashSet.lPc = paramk.tGc;
      paramHashSet.tFe = paramk.tFe;
      paramHashSet.rRg = false;
      this.tIP.add(paramHashSet);
    }
    AppMethodBeat.o(112169);
  }
  
  public final int getType()
  {
    return 4128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.b
 * JD-Core Version:    0.7.0.1
 */