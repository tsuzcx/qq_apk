package com.tencent.mm.plugin.fav.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
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
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107316);
    l locall = new l();
    locall.qRb = 1;
    locall.query = getQuery();
    locall.Htz = 1;
    locall.HtA = paramHashSet;
    locall.handler = paramMMHandler;
    locall.HtC = this;
    paramMMHandler = ((n)h.az(n.class)).search(6, locall);
    AppMethodBeat.o(107316);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107318);
    int i = paramInt - parama.Huj - 1;
    o localo = null;
    Object localObject = localo;
    if (i < parama.tbH.size())
    {
      localObject = localo;
      if (i >= 0)
      {
        localo = (o)parama.tbH.get(i);
        localObject = new a(paramInt);
        ((a)localObject).rpp = localo;
        ((a)localObject).FWt = parama.FWt;
        ((a)localObject).iW(localo.type, localo.subtype);
        ((a)localObject).Amy = false;
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
    }
    AppMethodBeat.o(107318);
    return localObject;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107317);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      if (paramHashSet.tbH.size() > 1)
      {
        paramHashSet.ABD = true;
        paramHashSet.tbH = paramHashSet.tbH.subList(0, 1);
      }
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(107317);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107319);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (o)parama.tbH.get(paramInt);
        localObject1 = new com.tencent.mm.plugin.fts.a.a.e();
        ((com.tencent.mm.plugin.fts.a.a.e)localObject1).hTs = String.valueOf(parama.hashCode());
        ((com.tencent.mm.plugin.fts.a.a.e)localObject1).itemType = 12;
      }
    }
    AppMethodBeat.o(107319);
    return localObject1;
  }
  
  public final int getType()
  {
    return 128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.e
 * JD-Core Version:    0.7.0.1
 */