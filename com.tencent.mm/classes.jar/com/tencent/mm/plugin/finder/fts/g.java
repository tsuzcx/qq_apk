package com.tencent.mm.plugin.finder.fts;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.fts.ui.a
{
  private int count;
  private ArrayList<String> lPt;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(330965);
    this.lPt = new ArrayList();
    this.count = 0;
    AppMethodBeat.o(330965);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(330976);
    l locall = new l();
    locall.query = getQuery();
    locall.HtB = com.tencent.mm.plugin.fts.a.c.d.Hug;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    locall.HtA = paramHashSet;
    Log.i("MicroMsg.FTSFinderFollowerUIUnit", "doSearch, request.query = " + locall.query);
    paramMMHandler = ((n)h.az(n.class)).search(13, locall);
    AppMethodBeat.o(330976);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    AppMethodBeat.i(331002);
    d locald = new d(paramInt2);
    locald.rpp = paramo;
    locald.FWt = parama.FWt;
    if (paramo.HtW) {
      locald.vFg = getContext().getResources().getString(i.d.settings_my_album_finder);
    }
    locald.iW(paramo.type, paramo.subtype);
    AppMethodBeat.o(331002);
    return locald;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(330993);
    int i = paramInt - parama.Huj - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(589824, paramInt, (o)parama.tbH.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hur = (i + 1);
      if (i == parama.tbH.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hup = false;
      }
    }
    AppMethodBeat.o(330993);
    return localObject1;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(330986);
    Log.i("MicroMsg.FTSFinderFollowerUIUnit", "setResult, ftsResult.");
    this.lPt.clear();
    if (hS(paramm.HtF))
    {
      this.count = paramm.HtF.size();
      paramHashSet = new e.a();
      paramHashSet.businessType = -23;
      paramHashSet.tbH = paramm.HtF;
      paramHashSet.FWt = paramm.FWt;
      if (paramHashSet.tbH.size() > 1)
      {
        paramHashSet.ABD = true;
        paramHashSet.tbH = paramHashSet.tbH.subList(0, 1);
      }
      this.HwJ.add(paramHashSet);
      paramm = paramHashSet.tbH.iterator();
      while (paramm.hasNext())
      {
        paramHashSet = (o)paramm.next();
        if (paramHashSet.Hsz != null) {
          this.lPt.add(paramHashSet.Hsz);
        }
      }
      Log.i("MicroMsg.FTSFinderFollowerUIUnit", "setResult, userNames = " + this.lPt);
    }
    if ((this.lPt != null) && (this.lPt.size() > 0))
    {
      long l = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUn, 300000L);
      ((y)h.ax(y.class)).f(this.lPt, l);
    }
    AppMethodBeat.o(330986);
  }
  
  public final e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(331012);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (o)parama.tbH.get(paramInt);
        localObject1 = new e();
        ((e)localObject1).hTs = String.valueOf(parama.hashCode());
        ((e)localObject1).itemType = 31;
        ((e)localObject1).HsE = parama.Hsz;
      }
    }
    AppMethodBeat.o(331012);
    return localObject1;
  }
  
  public final int getType()
  {
    return 133;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.g
 * JD-Core Version:    0.7.0.1
 */