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

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112171);
    j localj = new j();
    localj.iWB = 96;
    localj.rpL = 3;
    localj.query = this.query;
    localj.rpM = paramHashSet;
    localj.rpN = com.tencent.mm.plugin.fts.a.c.a.rqm;
    localj.rpO = this;
    localj.handler = paramap;
    paramap = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112171);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112175);
    q localq = new q(paramInt2);
    localq.jpy = paramm;
    localq.roS = parama.roS;
    localq.fI(paramm.type, paramm.roM);
    AppMethodBeat.o(112175);
    return localq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112173);
    int i = paramInt - parama.rqs - 1;
    m localm;
    Object localObject;
    if ((i < parama.kLN.size()) && (i >= 0))
    {
      localm = (m)parama.kLN.get(i);
      if (localm.roN.equals("create_chatroom​"))
      {
        localObject = new h(paramInt);
        ((h)localObject).roS = parama.roS;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqB = (i + 1);
        if (i == parama.kLN.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqz = false;
        }
      }
      AppMethodBeat.o(112173);
      return localObject;
      if (localm.type == 131075)
      {
        localObject = a(131075, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).fI(localm.type, localm.roM);
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
    if (dF(paramk.rpQ))
    {
      paramHashSet = new e.a();
      paramHashSet.kLN = paramk.rpQ;
      paramHashSet.businessType = -3;
      paramHashSet.roS = paramk.roS;
      if (paramHashSet.kLN.size() > 3)
      {
        if (!((m)paramHashSet.kLN.get(3)).roN.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.kLN.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.qpI = bool;
      }
    }
    for (paramHashSet.kLN = paramHashSet.kLN.subList(0, 4);; paramHashSet.kLN = paramHashSet.kLN.subList(0, 3))
    {
      this.rsD.add(paramHashSet);
      AppMethodBeat.o(112172);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.qpI = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112174);
    m localm;
    if ((paramInt < parama.kLN.size()) && (paramInt >= 0))
    {
      localm = (m)parama.kLN.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      if (localm.roN.equals("create_chatroom​"))
      {
        parama.drT = 20;
        parama.drI = String.valueOf(localm.hashCode());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112174);
      return parama;
      if (localm.type == 131075)
      {
        parama.drT = 4;
        parama.drI = String.valueOf(localm.hashCode());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.c
 * JD-Core Version:    0.7.0.1
 */