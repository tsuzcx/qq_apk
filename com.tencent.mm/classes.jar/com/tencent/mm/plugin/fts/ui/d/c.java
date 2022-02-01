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

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112171);
    j localj = new j();
    localj.jUf = 96;
    localj.tFX = 3;
    localj.query = this.query;
    localj.tFY = paramHashSet;
    localj.tFZ = com.tencent.mm.plugin.fts.a.c.a.tGy;
    localj.tGa = this;
    localj.handler = paramaq;
    paramaq = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112171);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112175);
    q localq = new q(paramInt2);
    localq.kno = paramm;
    localq.tFe = parama.tFe;
    localq.gf(paramm.type, paramm.tEX);
    AppMethodBeat.o(112175);
    return localq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112173);
    int i = paramInt - parama.tGE - 1;
    m localm;
    Object localObject;
    if ((i < parama.lPc.size()) && (i >= 0))
    {
      localm = (m)parama.lPc.get(i);
      if (localm.tEY.equals("create_chatroom​"))
      {
        localObject = new h(paramInt);
        ((h)localObject).tFe = parama.tFe;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
        if (i == parama.lPc.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGL = false;
        }
      }
      AppMethodBeat.o(112173);
      return localObject;
      if (localm.type == 131075)
      {
        localObject = a(131075, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).gf(localm.type, localm.tEX);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112172);
    boolean bool;
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.lPc = paramk.tGc;
      paramHashSet.businessType = -3;
      paramHashSet.tFe = paramk.tFe;
      if (paramHashSet.lPc.size() > 3)
      {
        if (!((m)paramHashSet.lPc.get(3)).tEY.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.lPc.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.rRg = bool;
      }
    }
    for (paramHashSet.lPc = paramHashSet.lPc.subList(0, 4);; paramHashSet.lPc = paramHashSet.lPc.subList(0, 3))
    {
      this.tIP.add(paramHashSet);
      AppMethodBeat.o(112172);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.rRg = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112174);
    m localm;
    if ((paramInt < parama.lPc.size()) && (paramInt >= 0))
    {
      localm = (m)parama.lPc.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      if (localm.tEY.equals("create_chatroom​"))
      {
        parama.dCw = 20;
        parama.dCl = String.valueOf(localm.hashCode());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112174);
      return parama;
      if (localm.type == 131075)
      {
        parama.dCw = 4;
        parama.dCl = String.valueOf(localm.hashCode());
      }
      else
      {
        parama = null;
        continue;
        parama = null;
      }
    }
  }
  
  public final int getType()
  {
    return 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.c
 * JD-Core Version:    0.7.0.1
 */