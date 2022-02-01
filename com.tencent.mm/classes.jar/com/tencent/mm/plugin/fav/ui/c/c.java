package com.tencent.mm.plugin.fav.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
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
    AppMethodBeat.i(107312);
    l locall = new l();
    locall.qRb = 2;
    locall.query = getQuery();
    locall.HtA = paramHashSet;
    locall.handler = paramMMHandler;
    locall.HtC = this;
    locall.HtB = d.Hug;
    paramMMHandler = ((n)h.az(n.class)).search(6, locall);
    AppMethodBeat.o(107312);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107314);
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
        ((a)localObject).Amy = true;
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
    }
    AppMethodBeat.o(107314);
    return localObject;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107313);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(107313);
  }
  
  public final int getType()
  {
    return 4192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.c
 * JD-Core Version:    0.7.0.1
 */