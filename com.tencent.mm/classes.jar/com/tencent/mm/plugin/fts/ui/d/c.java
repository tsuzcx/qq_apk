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
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.List;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112171);
    j localj = new j();
    localj.jwR = 96;
    localj.syF = 3;
    localj.query = this.query;
    localj.syG = paramHashSet;
    localj.syH = com.tencent.mm.plugin.fts.a.c.a.szg;
    localj.syI = this;
    localj.handler = paramao;
    paramao = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112171);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112175);
    q localq = new q(paramInt2);
    localq.jPN = paramm;
    localq.sxM = parama.sxM;
    localq.fP(paramm.type, paramm.sxF);
    AppMethodBeat.o(112175);
    return localq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112173);
    int i = paramInt - parama.szm - 1;
    m localm;
    Object localObject;
    if ((i < parama.lnk.size()) && (i >= 0))
    {
      localm = (m)parama.lnk.get(i);
      if (localm.sxG.equals("create_chatroom​"))
      {
        localObject = new h(paramInt);
        ((h)localObject).sxM = parama.sxM;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
        if (i == parama.lnk.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szt = false;
        }
      }
      AppMethodBeat.o(112173);
      return localObject;
      if (localm.type == 131075)
      {
        localObject = a(131075, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).fP(localm.type, localm.sxF);
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
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.lnk = paramk.syK;
      paramHashSet.businessType = -3;
      paramHashSet.sxM = paramk.sxM;
      if (paramHashSet.lnk.size() > 3)
      {
        if (!((m)paramHashSet.lnk.get(3)).sxG.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.lnk.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.qYO = bool;
      }
    }
    for (paramHashSet.lnk = paramHashSet.lnk.subList(0, 4);; paramHashSet.lnk = paramHashSet.lnk.subList(0, 3))
    {
      this.sBx.add(paramHashSet);
      AppMethodBeat.o(112172);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.qYO = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112174);
    m localm;
    if ((paramInt < parama.lnk.size()) && (paramInt >= 0))
    {
      localm = (m)parama.lnk.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      if (localm.sxG.equals("create_chatroom​"))
      {
        parama.dpE = 20;
        parama.dpt = String.valueOf(localm.hashCode());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112174);
      return parama;
      if (localm.type == 131075)
      {
        parama.dpE = 4;
        parama.dpt = String.valueOf(localm.hashCode());
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