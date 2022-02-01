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

public final class d
  extends com.tencent.mm.plugin.fts.ui.a
{
  public d(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112176);
    l locall = new l();
    locall.query = getQuery();
    locall.Htx = new int[] { 131072, 131081 };
    locall.HtB = b.Hue;
    locall.HtA = paramHashSet;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    locall.qRb = 16;
    paramMMHandler = ((n)h.az(n.class)).search(2, locall);
    AppMethodBeat.o(112176);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112178);
    int i = paramInt - parama.Huj - 1;
    o localo = null;
    Object localObject = localo;
    if (i < parama.tbH.size())
    {
      localObject = localo;
      if (i >= 0)
      {
        localo = (o)parama.tbH.get(i);
        localObject = new u(paramInt);
        ((u)localObject).rpp = localo;
        ((u)localObject).FWt = parama.FWt;
        ((u)localObject).iW(localo.type, localo.subtype);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
    }
    AppMethodBeat.o(112178);
    return localObject;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112177);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -4;
      paramHashSet.tbH = paramm.HtF;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.ABD = false;
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(112177);
  }
  
  public final int getType()
  {
    return 4112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.d
 * JD-Core Version:    0.7.0.1
 */