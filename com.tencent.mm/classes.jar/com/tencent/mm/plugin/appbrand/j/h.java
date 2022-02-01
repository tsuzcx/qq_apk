package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45034);
    j localj = new j();
    localj.query = this.query;
    localj.wWY = com.tencent.mm.plugin.fts.a.c.d.wXA;
    localj.wWZ = this;
    localj.handler = paramMMHandler;
    localj.wWX = paramHashSet;
    paramMMHandler = ((n)g.ah(n.class)).search(7, localj);
    AppMethodBeat.o(45034);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, com.tencent.mm.plugin.fts.a.a.m paramm, e.a parama)
  {
    AppMethodBeat.i(45037);
    d locald = new d(paramInt2);
    locald.lqW = paramm;
    locald.wWd = parama.wWd;
    locald.gE(paramm.type, paramm.wVW);
    AppMethodBeat.o(45037);
    return locald;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45036);
    int i = paramInt - parama.wXD - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.mWl.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(393216, paramInt, (com.tencent.mm.plugin.fts.a.a.m)parama.mWl.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).wXM = (i + 1);
      if (i == parama.mWl.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).wXK = false;
      }
    }
    AppMethodBeat.o(45036);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45035);
    List localList = paramk.wXb;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.m localm = new com.tencent.mm.modelsns.m();
      String str = this.query;
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      localm.n("20KeyWordId", paramHashSet + ",");
      localm.n("21ViewType", "1,");
      localm.n("22OpType", "1,");
      localm.n("23ResultCount", localList.size() + ",");
      localm.n("24ClickPos", ",");
      localm.n("25ClickAppUserName", ",");
      Log.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localm.abW() });
      com.tencent.mm.plugin.report.service.h.CyF.a(13963, new Object[] { localm });
    }
    if (eP(paramk.wXb))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.mWl = paramk.wXb;
      paramHashSet.wWd = paramk.wWd;
      if (paramHashSet.mWl.size() > 1)
      {
        paramHashSet.tuG = true;
        paramHashSet.mWl = paramHashSet.mWl.subList(0, 1);
      }
      this.wZO.add(paramHashSet);
    }
    AppMethodBeat.o(45035);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45038);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.mWl.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (com.tencent.mm.plugin.fts.a.a.m)parama.mWl.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).dUb = String.valueOf(parama.hashCode());
        ((c)localObject1).dUm = 19;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.h
 * JD-Core Version:    0.7.0.1
 */