package com.tencent.mm.plugin.finder.fts;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  private ArrayList<String> lPt;
  
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(330968);
    this.lPt = new ArrayList();
    AppMethodBeat.o(330968);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(330979);
    l locall = new l();
    locall.query = getQuery();
    locall.HtB = com.tencent.mm.plugin.fts.a.c.d.Hug;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    locall.HtA = paramHashSet;
    paramMMHandler = ((n)h.az(n.class)).search(13, locall);
    AppMethodBeat.o(330979);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(330995);
    int i = paramInt - parama.Huj - 1;
    o localo = null;
    Object localObject = localo;
    if (i < parama.tbH.size())
    {
      localObject = localo;
      if (i >= 0)
      {
        localo = (o)parama.tbH.get(i);
        localObject = new d(paramInt);
        ((d)localObject).rpp = localo;
        ((d)localObject).FWt = parama.FWt;
        ((d)localObject).iW(localo.type, localo.subtype);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
    }
    AppMethodBeat.o(330995);
    return localObject;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(330988);
    this.lPt.clear();
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -23;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      this.HwJ.add(paramHashSet);
      paramm = paramHashSet.tbH.iterator();
      while (paramm.hasNext())
      {
        paramHashSet = (o)paramm.next();
        if (paramHashSet.Hsz != null) {
          this.lPt.add(paramHashSet.Hsz);
        }
      }
    }
    if ((this.lPt != null) && (this.lPt.size() > 0))
    {
      long l = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUn, 300000L);
      ((y)h.ax(y.class)).f(this.lPt, l);
    }
    AppMethodBeat.o(330988);
  }
  
  public final int getType()
  {
    return 8224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.c
 * JD-Core Version:    0.7.0.1
 */