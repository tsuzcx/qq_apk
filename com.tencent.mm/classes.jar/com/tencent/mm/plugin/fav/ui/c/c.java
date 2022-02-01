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
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.List;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107312);
    j localj = new j();
    localj.jUf = 2;
    localj.query = this.query;
    localj.tFY = paramHashSet;
    localj.handler = paramaq;
    localj.tGa = this;
    localj.tFZ = d.tGB;
    paramaq = ((n)g.ad(n.class)).search(6, localj);
    AppMethodBeat.o(107312);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107314);
    int i = paramInt - parama.tGE - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lPc.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lPc.get(i);
        localObject = new a(paramInt);
        ((a)localObject).kno = localm;
        ((a)localObject).tFe = parama.tFe;
        ((a)localObject).gf(localm.type, localm.tEX);
        ((a)localObject).rJU = true;
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
    }
    AppMethodBeat.o(107314);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107313);
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.tFe = paramk.tFe;
      paramHashSet.lPc = paramk.tGc;
      this.tIP.add(paramHashSet);
    }
    AppMethodBeat.o(107313);
  }
  
  public final int getType()
  {
    return 4192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.c
 * JD-Core Version:    0.7.0.1
 */