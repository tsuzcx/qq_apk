package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
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

public final class b
  extends com.tencent.mm.plugin.fts.ui.a
{
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112168);
    l locall = new l();
    locall.qRb = 32;
    locall.query = getQuery();
    locall.HtA = paramHashSet;
    locall.HtB = com.tencent.mm.plugin.fts.a.c.a.Hud;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    paramMMHandler = ((n)com.tencent.mm.kernel.h.az(n.class)).search(2, locall);
    AppMethodBeat.o(112168);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112170);
    int i = paramInt - parama.Huj - 1;
    o localo = null;
    Object localObject = localo;
    if (i < parama.tbH.size())
    {
      localObject = localo;
      if (i >= 0)
      {
        localo = (o)parama.tbH.get(i);
        if (!localo.Hsz.equals("create_chatroom​")) {
          break label110;
        }
        localObject = new com.tencent.mm.plugin.fts.ui.b.h(paramInt);
        ((com.tencent.mm.plugin.fts.ui.b.h)localObject).FWt = parama.FWt;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
      }
      AppMethodBeat.o(112170);
      return localObject;
      label110:
      localObject = new t(paramInt);
      ((t)localObject).rpp = localo;
      ((t)localObject).FWt = parama.FWt;
      ((t)localObject).iW(localo.type, localo.subtype);
    }
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112169);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -3;
      paramHashSet.tbH = paramm.HtF;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.ABD = false;
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(112169);
  }
  
  public final int getType()
  {
    return 4128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.b
 * JD-Core Version:    0.7.0.1
 */