package com.tencent.mm.plugin.fts.ui.d;

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
import com.tencent.mm.plugin.fts.ui.a.r;
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
    AppMethodBeat.i(112179);
    j localj = new j();
    localj.kXb = 64;
    localj.query = this.query;
    localj.wWU = new int[] { 131072, 131081 };
    localj.wWW = 3;
    localj.wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
    localj.wWX = paramHashSet;
    localj.wWZ = this;
    localj.handler = paramMMHandler;
    paramMMHandler = ((n)g.ah(n.class)).search(2, localj);
    AppMethodBeat.o(112179);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112182);
    Object localObject = null;
    if ((paramm.type == 131072) || (paramm.type == 131081))
    {
      localObject = new r(paramInt2);
      ((r)localObject).lqW = paramm;
      ((r)localObject).wWd = parama.wWd;
      ((r)localObject).gE(paramm.type, paramm.wVW);
    }
    for (;;)
    {
      AppMethodBeat.o(112182);
      return localObject;
      if ((paramm.type == 131073) || (paramm.type == 131074)) {
        localObject = ((com.tencent.mm.plugin.fts.ui.a)((n)g.ah(n.class)).createFTSUIUnit(33, this.context, this.wXC, this.mve)).a(paramInt1, paramInt2, paramm, parama);
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112181);
    Object localObject = null;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    int i;
    if (parama.wXE)
    {
      i = paramInt - parama.wXD - 1;
      localObject = locala;
      if (i < parama.mWl.size())
      {
        localObject = locala;
        if (i >= 0)
        {
          m localm = (m)parama.mWl.get(i);
          locala = a(localm.type, paramInt, localm, parama);
          localObject = locala;
          if (locala != null)
          {
            locala.gE(localm.type, localm.wVW);
            localObject = locala;
          }
        }
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      if (localObject != null)
      {
        localObject.wXM = (paramInt + 1);
        if (paramInt == parama.mWl.size() - 1) {
          localObject.wXK = false;
        }
      }
      AppMethodBeat.o(112181);
      return localObject;
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112180);
    paramHashSet = new e.a();
    paramHashSet.businessType = -4;
    paramHashSet.mWl = paramk.wXb;
    paramHashSet.wXE = eP(paramk.wXb);
    paramHashSet.wWd = paramk.wWd;
    if (paramHashSet.mWl.size() > 3)
    {
      paramHashSet.tuG = true;
      paramHashSet.mWl = paramHashSet.mWl.subList(0, 3);
    }
    if (eP(paramk.wXb)) {
      this.wZO.add(paramHashSet);
    }
    AppMethodBeat.o(112180);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112183);
    if ((paramInt < parama.mWl.size()) && (paramInt >= 0))
    {
      m localm = (m)parama.mWl.get(paramInt);
      parama = new c();
      parama.dUb = String.valueOf(localm.hashCode());
      if ((localm.type == 131072) || (localm.type == 131081) || (localm.type == 131073) || (localm.type == 131074)) {
        parama.dUm = 3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112183);
      return parama;
      parama = null;
      continue;
      parama = null;
    }
  }
  
  public final int getType()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.e
 * JD-Core Version:    0.7.0.1
 */