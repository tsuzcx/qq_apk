package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
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
    localj.nRn = 96;
    localj.BIR = 3;
    localj.query = getQuery();
    localj.BIS = paramHashSet;
    localj.BIT = com.tencent.mm.plugin.fts.a.c.a.BJt;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    paramMMHandler = ((n)com.tencent.mm.kernel.h.ag(n.class)).search(2, localj);
    AppMethodBeat.o(112171);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112175);
    q localq = new q(paramInt2);
    localq.olG = paramm;
    localq.BHY = parama.BHY;
    localq.hx(paramm.type, paramm.BHR);
    AppMethodBeat.o(112175);
    return localq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112173);
    int i = paramInt - parama.BJz - 1;
    m localm;
    Object localObject;
    if ((i < parama.pWR.size()) && (i >= 0))
    {
      localm = (m)parama.pWR.get(i);
      if (localm.BHS.equals("create_chatroom​"))
      {
        localObject = new com.tencent.mm.plugin.fts.ui.a.h(paramInt);
        ((com.tencent.mm.plugin.fts.ui.a.h)localObject).BHY = parama.BHY;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
        if (i == parama.pWR.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJG = false;
        }
      }
      AppMethodBeat.o(112173);
      return localObject;
      if (localm.type == 131075)
      {
        localObject = a(131075, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).hx(localm.type, localm.BHR);
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
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.pWR = paramk.BIW;
      paramHashSet.businessType = -3;
      paramHashSet.BHY = paramk.BHY;
      if (paramHashSet.pWR.size() > 3)
      {
        if (!((m)paramHashSet.pWR.get(3)).BHS.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.pWR.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.xcp = bool;
      }
    }
    for (paramHashSet.pWR = paramHashSet.pWR.subList(0, 4);; paramHashSet.pWR = paramHashSet.pWR.subList(0, 3))
    {
      this.BLN.add(paramHashSet);
      AppMethodBeat.o(112172);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.xcp = true;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112174);
    m localm;
    if ((paramInt < parama.pWR.size()) && (paramInt >= 0))
    {
      localm = (m)parama.pWR.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      if (localm.BHS.equals("create_chatroom​"))
      {
        parama.fNO = 20;
        parama.fND = String.valueOf(localm.hashCode());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112174);
      return parama;
      if (localm.type == 131075)
      {
        parama.fNO = 4;
        parama.fND = String.valueOf(localm.hashCode());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.c
 * JD-Core Version:    0.7.0.1
 */