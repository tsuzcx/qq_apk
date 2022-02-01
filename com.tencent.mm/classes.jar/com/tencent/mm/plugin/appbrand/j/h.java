package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45034);
    l locall = new l();
    locall.query = getQuery();
    locall.HtB = com.tencent.mm.plugin.fts.a.c.d.Hug;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    locall.HtA = paramHashSet;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(7, locall);
    AppMethodBeat.o(45034);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    AppMethodBeat.i(45037);
    d locald = new d(paramInt2);
    locald.rpp = paramo;
    locald.FWt = parama.FWt;
    locald.iW(paramo.type, paramo.subtype);
    AppMethodBeat.o(45037);
    return locald;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45036);
    int i = paramInt - parama.Huj - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(393216, paramInt, (o)parama.tbH.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hur = (i + 1);
      if (i == parama.tbH.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hup = false;
      }
    }
    AppMethodBeat.o(45036);
    return localObject1;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45035);
    List localList = paramm.HtF;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
      String str = getQuery();
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      localn.s("20KeyWordId", paramHashSet + ",");
      localn.s("21ViewType", "1,");
      localn.s("22OpType", "1,");
      localn.s("23ResultCount", localList.size() + ",");
      localn.s("24ClickPos", ",");
      localn.s("25ClickAppUserName", ",");
      Log.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localn.aIF() });
      com.tencent.mm.plugin.report.service.h.OAn.b(13963, new Object[] { localn });
    }
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.tbH = paramm.HtF;
      paramHashSet.FWt = paramm.FWt;
      if (paramHashSet.tbH.size() > 1)
      {
        paramHashSet.ABD = true;
        paramHashSet.tbH = paramHashSet.tbH.subList(0, 1);
      }
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(45035);
  }
  
  public final e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45038);
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
        ((e)localObject1).itemType = 19;
        ((e)localObject1).HsE = parama.Hsz;
      }
    }
    AppMethodBeat.o(45038);
    return localObject1;
  }
  
  public final int getType()
  {
    return 144;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.h
 * JD-Core Version:    0.7.0.1
 */