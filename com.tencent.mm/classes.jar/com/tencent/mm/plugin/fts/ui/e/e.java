package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.u;
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
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112179);
    l locall = new l();
    locall.qRb = 64;
    locall.query = getQuery();
    locall.Htx = new int[] { 131072, 131081 };
    locall.Htz = 3;
    locall.HtB = b.Hue;
    locall.HtA = paramHashSet;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    paramMMHandler = ((n)h.az(n.class)).search(2, locall);
    AppMethodBeat.o(112179);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    AppMethodBeat.i(112182);
    Object localObject = null;
    if ((paramo.type == 131072) || (paramo.type == 131081))
    {
      localObject = new u(paramInt2);
      ((u)localObject).rpp = paramo;
      ((u)localObject).FWt = parama.FWt;
      ((u)localObject).iW(paramo.type, paramo.subtype);
    }
    for (;;)
    {
      AppMethodBeat.o(112182);
      return localObject;
      if ((paramo.type == 131073) || (paramo.type == 131074)) {
        localObject = ((com.tencent.mm.plugin.fts.ui.a)((n)h.az(n.class)).createFTSUIUnit(33, getContext(), fxE(), fxF())).a(paramInt1, paramInt2, paramo, parama);
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112181);
    Object localObject = null;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    int i;
    if (parama.Huk)
    {
      i = paramInt - parama.Huj - 1;
      localObject = locala;
      if (i < parama.tbH.size())
      {
        localObject = locala;
        if (i >= 0)
        {
          o localo = (o)parama.tbH.get(i);
          locala = a(localo.type, paramInt, localo, parama);
          localObject = locala;
          if (locala != null)
          {
            locala.iW(localo.type, localo.subtype);
            localObject = locala;
          }
        }
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      if (localObject != null)
      {
        localObject.Hur = (paramInt + 1);
        if (paramInt == parama.tbH.size() - 1) {
          localObject.Hup = false;
        }
      }
      AppMethodBeat.o(112181);
      return localObject;
    }
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112180);
    paramHashSet = new e.a();
    paramHashSet.businessType = -4;
    paramHashSet.tbH = paramm.HtF;
    paramHashSet.Huk = hS(paramm.HtF);
    paramHashSet.FWt = paramm.FWt;
    if (paramHashSet.tbH.size() > 3)
    {
      paramHashSet.ABD = true;
      paramHashSet.tbH = paramHashSet.tbH.subList(0, 3);
    }
    if (hS(paramm.HtF)) {
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(112180);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112183);
    if ((paramInt < parama.tbH.size()) && (paramInt >= 0))
    {
      o localo = (o)parama.tbH.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.e();
      parama.hTs = String.valueOf(localo.hashCode());
      if ((localo.type == 131072) || (localo.type == 131081) || (localo.type == 131073) || (localo.type == 131074)) {
        parama.itemType = 3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.e
 * JD-Core Version:    0.7.0.1
 */