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
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112171);
    j localj = new j();
    localj.kXb = 96;
    localj.wWW = 3;
    localj.query = this.query;
    localj.wWX = paramHashSet;
    localj.wWY = com.tencent.mm.plugin.fts.a.c.a.wXx;
    localj.wWZ = this;
    localj.handler = paramMMHandler;
    paramMMHandler = ((n)g.ah(n.class)).search(2, localj);
    AppMethodBeat.o(112171);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112175);
    q localq = new q(paramInt2);
    localq.lqW = paramm;
    localq.wWd = parama.wWd;
    localq.gE(paramm.type, paramm.wVW);
    AppMethodBeat.o(112175);
    return localq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112173);
    int i = paramInt - parama.wXD - 1;
    m localm;
    Object localObject;
    if ((i < parama.mWl.size()) && (i >= 0))
    {
      localm = (m)parama.mWl.get(i);
      if (localm.wVX.equals("create_chatroom​"))
      {
        localObject = new h(paramInt);
        ((h)localObject).wWd = parama.wWd;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXM = (i + 1);
        if (i == parama.mWl.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXK = false;
        }
      }
      AppMethodBeat.o(112173);
      return localObject;
      if (localm.type == 131075)
      {
        localObject = a(131075, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).gE(localm.type, localm.wVW);
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
    if (eP(paramk.wXb))
    {
      paramHashSet = new e.a();
      paramHashSet.mWl = paramk.wXb;
      paramHashSet.businessType = -3;
      paramHashSet.wWd = paramk.wWd;
      if (paramHashSet.mWl.size() > 3)
      {
        if (!((m)paramHashSet.mWl.get(3)).wVX.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.mWl.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.tuG = bool;
      }
    }
    for (paramHashSet.mWl = paramHashSet.mWl.subList(0, 4);; paramHashSet.mWl = paramHashSet.mWl.subList(0, 3))
    {
      this.wZO.add(paramHashSet);
      AppMethodBeat.o(112172);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.tuG = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112174);
    m localm;
    if ((paramInt < parama.mWl.size()) && (paramInt >= 0))
    {
      localm = (m)parama.mWl.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      if (localm.wVX.equals("create_chatroom​"))
      {
        parama.dUm = 20;
        parama.dUb = String.valueOf(localm.hashCode());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112174);
      return parama;
      if (localm.type == 131075)
      {
        parama.dUm = 4;
        parama.dUb = String.valueOf(localm.hashCode());
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