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
    localj.jQN = 96;
    localj.tvg = 3;
    localj.query = this.query;
    localj.tvh = paramHashSet;
    localj.tvi = com.tencent.mm.plugin.fts.a.c.a.tvH;
    localj.tvj = this;
    localj.handler = paramap;
    paramap = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112171);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112175);
    q localq = new q(paramInt2);
    localq.kjY = paramm;
    localq.tun = parama.tun;
    localq.gf(paramm.type, paramm.tug);
    AppMethodBeat.o(112175);
    return localq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112173);
    int i = paramInt - parama.tvN - 1;
    m localm;
    Object localObject;
    if ((i < parama.lKC.size()) && (i >= 0))
    {
      localm = (m)parama.lKC.get(i);
      if (localm.tuh.equals("create_chatroom​"))
      {
        localObject = new h(paramInt);
        ((h)localObject).tun = parama.tun;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvW = (i + 1);
        if (i == parama.lKC.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvU = false;
        }
      }
      AppMethodBeat.o(112173);
      return localObject;
      if (localm.type == 131075)
      {
        localObject = a(131075, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).gf(localm.type, localm.tug);
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
    if (dT(paramk.tvl))
    {
      paramHashSet = new e.a();
      paramHashSet.lKC = paramk.tvl;
      paramHashSet.businessType = -3;
      paramHashSet.tun = paramk.tun;
      if (paramHashSet.lKC.size() > 3)
      {
        if (!((m)paramHashSet.lKC.get(3)).tuh.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.lKC.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.rKf = bool;
      }
    }
    for (paramHashSet.lKC = paramHashSet.lKC.subList(0, 4);; paramHashSet.lKC = paramHashSet.lKC.subList(0, 3))
    {
      this.txY.add(paramHashSet);
      AppMethodBeat.o(112172);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.rKf = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112174);
    m localm;
    if ((paramInt < parama.lKC.size()) && (paramInt >= 0))
    {
      localm = (m)parama.lKC.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      if (localm.tuh.equals("create_chatroom​"))
      {
        parama.dBr = 20;
        parama.dBg = String.valueOf(localm.hashCode());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112174);
      return parama;
      if (localm.type == 131075)
      {
        parama.dBr = 4;
        parama.dBg = String.valueOf(localm.hashCode());
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