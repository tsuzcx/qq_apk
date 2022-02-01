package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.fts.ui.a
{
  public e(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(5830);
    paramHashSet.add("gh_3dfda90e39d6");
    paramHashSet.add("gh_43f2581f6fd6");
    paramHashSet.add("gh_f0a92aa7146c");
    if (1 == ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waa, 0)) {
      paramHashSet.add("gh_579db1f2cf89");
    }
    paramHashSet.add("gh_b4af18eac3d5");
    String str = getQuery();
    com.tencent.mm.plugin.fts.a.c.b localb = com.tencent.mm.plugin.fts.a.c.b.BJu;
    paramMMHandler = j.a(str, new int[] { 131076 }, null, 4, paramHashSet, localb, this, paramMMHandler);
    paramMMHandler = ((n)h.ag(n.class)).search(2, paramMMHandler);
    AppMethodBeat.o(5830);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(5833);
    a locala = new a(paramInt2);
    locala.olG = paramm;
    locala.BHY = parama.BHY;
    locala.hx(paramm.type, paramm.BHR);
    AppMethodBeat.o(5833);
    return locala;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(5832);
    int i = paramInt - parama.BJz - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.pWR.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.pWR.get(i);
        localObject = a(131076, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).hx(localm.type, localm.BHR);
      }
    }
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
      if (i == parama.pWR.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJG = false;
      }
    }
    AppMethodBeat.o(5832);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(5831);
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -7;
      paramHashSet.pWR = paramk.BIW;
      paramHashSet.BHY = paramk.BHY;
      if (paramHashSet.pWR.size() > 1)
      {
        paramHashSet.xcp = true;
        paramHashSet.pWR = paramHashSet.pWR.subList(0, 1);
      }
      this.BLN.add(paramHashSet);
    }
    AppMethodBeat.o(5831);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(5834);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.pWR.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.pWR.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).fND = String.valueOf(parama.hashCode());
        ((c)localObject1).fNO = 5;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.e
 * JD-Core Version:    0.7.0.1
 */