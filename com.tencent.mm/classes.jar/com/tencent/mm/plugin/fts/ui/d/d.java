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
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.fts.ui.a
{
  public d(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112176);
    j localj = new j();
    localj.query = this.query;
    localj.tFV = new int[] { 131072, 131081 };
    localj.tFZ = b.tGz;
    localj.tFY = paramHashSet;
    localj.tGa = this;
    localj.handler = paramaq;
    localj.jUf = 16;
    paramaq = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112176);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112178);
    int i = paramInt - parama.tGE - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lPc.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lPc.get(i);
        localObject = new r(paramInt);
        ((r)localObject).kno = localm;
        ((r)localObject).tFe = parama.tFe;
        ((r)localObject).gf(localm.type, localm.tEX);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
    }
    AppMethodBeat.o(112178);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112177);
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -4;
      paramHashSet.lPc = paramk.tGc;
      paramHashSet.tFe = paramk.tFe;
      paramHashSet.rRg = false;
      this.tIP.add(paramHashSet);
    }
    AppMethodBeat.o(112177);
  }
  
  public final int getType()
  {
    return 4112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.d
 * JD-Core Version:    0.7.0.1
 */