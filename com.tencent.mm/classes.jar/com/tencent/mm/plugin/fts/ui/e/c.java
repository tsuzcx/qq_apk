package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.t;
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
  
  public final com.tencent.mm.plugin.fts.a.a.c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112171);
    l locall = new l();
    locall.qRb = 96;
    locall.Htz = 3;
    locall.query = getQuery();
    locall.HtA = paramHashSet;
    locall.HtB = com.tencent.mm.plugin.fts.a.c.a.Hud;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    paramMMHandler = ((n)com.tencent.mm.kernel.h.az(n.class)).search(2, locall);
    AppMethodBeat.o(112171);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    AppMethodBeat.i(112175);
    t localt = new t(paramInt2);
    localt.rpp = paramo;
    localt.FWt = parama.FWt;
    localt.iW(paramo.type, paramo.subtype);
    AppMethodBeat.o(112175);
    return localt;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112173);
    int i = paramInt - parama.Huj - 1;
    o localo;
    Object localObject;
    if ((i < parama.tbH.size()) && (i >= 0))
    {
      localo = (o)parama.tbH.get(i);
      if (localo.Hsz.equals("create_chatroom​"))
      {
        localObject = new com.tencent.mm.plugin.fts.ui.b.h(paramInt);
        ((com.tencent.mm.plugin.fts.ui.b.h)localObject).FWt = parama.FWt;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
        if (i == parama.tbH.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hup = false;
        }
      }
      AppMethodBeat.o(112173);
      return localObject;
      if (localo.type == 131075)
      {
        localObject = a(131075, paramInt, localo, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).iW(localo.type, localo.subtype);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112172);
    boolean bool;
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.tbH = paramm.HtF;
      paramHashSet.businessType = -3;
      paramHashSet.FWt = paramm.FWt;
      if (paramHashSet.tbH.size() > 3)
      {
        if (!((o)paramHashSet.tbH.get(3)).Hsz.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.tbH.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.ABD = bool;
      }
    }
    for (paramHashSet.tbH = paramHashSet.tbH.subList(0, 4);; paramHashSet.tbH = paramHashSet.tbH.subList(0, 3))
    {
      this.HwJ.add(paramHashSet);
      AppMethodBeat.o(112172);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.ABD = true;
    }
  }
  
  public final e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112174);
    o localo;
    if ((paramInt < parama.tbH.size()) && (paramInt >= 0))
    {
      localo = (o)parama.tbH.get(paramInt);
      parama = new e();
      if (localo.Hsz.equals("create_chatroom​"))
      {
        parama.itemType = 20;
        parama.hTs = String.valueOf(localo.hashCode());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112174);
      return parama;
      if (localo.type == 131075)
      {
        parama.itemType = 4;
        parama.hTs = String.valueOf(localo.hashCode());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.c
 * JD-Core Version:    0.7.0.1
 */