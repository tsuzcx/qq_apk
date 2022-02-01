package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
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
    AppMethodBeat.i(5825);
    paramHashSet.add("gh_43f2581f6fd6");
    paramHashSet.addAll(au.iZM());
    if (1 == ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1)) {
      paramHashSet.add("gh_579db1f2cf89");
    }
    String str = getQuery();
    b localb = b.Hue;
    paramMMHandler = l.a(str, new int[] { 131076 }, null, -1, paramHashSet, localb, this, paramMMHandler);
    paramMMHandler = ((n)h.az(n.class)).search(2, paramMMHandler);
    AppMethodBeat.o(5825);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    AppMethodBeat.i(5828);
    a locala = new a(paramInt2);
    locala.rpp = paramo;
    locala.FWt = parama.FWt;
    locala.iW(paramo.type, paramo.subtype);
    AppMethodBeat.o(5828);
    return locala;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(5827);
    int i = paramInt - parama.Huj - 1;
    o localo = null;
    Object localObject = localo;
    if (i < parama.tbH.size())
    {
      localObject = localo;
      if (i >= 0)
      {
        localo = (o)parama.tbH.get(i);
        localObject = a(131076, paramInt, localo, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).iW(localo.type, localo.subtype);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
    }
    AppMethodBeat.o(5827);
    return localObject;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(5826);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -7;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(5826);
  }
  
  public final int getType()
  {
    return 4208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.c
 * JD-Core Version:    0.7.0.1
 */