package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.fts.ui.a
{
  public e(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(5830);
    paramHashSet.add("gh_3dfda90e39d6");
    paramHashSet.add("gh_43f2581f6fd6");
    paramHashSet.add("gh_f0a92aa7146c");
    String str = this.query;
    b localb = b.tGz;
    paramaq = j.a(str, new int[] { 131076 }, null, 4, paramHashSet, localb, this, paramaq);
    paramaq = ((n)g.ad(n.class)).search(2, paramaq);
    AppMethodBeat.o(5830);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(5833);
    a locala = new a(paramInt2);
    locala.kno = paramm;
    locala.tFe = parama.tFe;
    locala.gf(paramm.type, paramm.tEX);
    AppMethodBeat.o(5833);
    return locala;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(5832);
    int i = paramInt - parama.tGE - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lPc.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lPc.get(i);
        localObject = a(131076, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).gf(localm.type, localm.tEX);
      }
    }
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
      if (i == parama.lPc.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGL = false;
      }
    }
    AppMethodBeat.o(5832);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(5831);
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -7;
      paramHashSet.lPc = paramk.tGc;
      paramHashSet.tFe = paramk.tFe;
      if (paramHashSet.lPc.size() > 1)
      {
        paramHashSet.rRg = true;
        paramHashSet.lPc = paramHashSet.lPc.subList(0, 1);
      }
      this.tIP.add(paramHashSet);
    }
    AppMethodBeat.o(5831);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(5834);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.lPc.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.lPc.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).dCl = String.valueOf(parama.hashCode());
        ((c)localObject1).dCw = 5;
      }
    }
    AppMethodBeat.o(5834);
    return localObject1;
  }
  
  public final int getType()
  {
    return 96;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.e
 * JD-Core Version:    0.7.0.1
 */