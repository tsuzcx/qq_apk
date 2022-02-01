package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45034);
    j localj = new j();
    localj.query = this.query;
    localj.tFZ = com.tencent.mm.plugin.fts.a.c.d.tGB;
    localj.tGa = this;
    localj.handler = paramaq;
    localj.tFY = paramHashSet;
    paramaq = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(7, localj);
    AppMethodBeat.o(45034);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(45037);
    d locald = new d(paramInt2);
    locald.kno = paramm;
    locald.tFe = parama.tFe;
    locald.gf(paramm.type, paramm.tEX);
    AppMethodBeat.o(45037);
    return locald;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45036);
    int i = paramInt - parama.tGE - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.lPc.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(393216, paramInt, (m)parama.lPc.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).tGN = (i + 1);
      if (i == parama.lPc.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).tGL = false;
      }
    }
    AppMethodBeat.o(45036);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45035);
    List localList = paramk.tGc;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
      String str = this.query;
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      localg.m("20KeyWordId", paramHashSet + ",");
      localg.m("21ViewType", "1,");
      localg.m("22OpType", "1,");
      localg.m("23ResultCount", localList.size() + ",");
      localg.m("24ClickPos", ",");
      localg.m("25ClickAppUserName", ",");
      ae.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localg.RD() });
      com.tencent.mm.plugin.report.service.g.yxI.f(13963, new Object[] { localg });
    }
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.lPc = paramk.tGc;
      paramHashSet.tFe = paramk.tFe;
      if (paramHashSet.lPc.size() > 1)
      {
        paramHashSet.rRg = true;
        paramHashSet.lPc = paramHashSet.lPc.subList(0, 1);
      }
      this.tIP.add(paramHashSet);
    }
    AppMethodBeat.o(45035);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45038);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.lPc.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.lPc.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).dCl = String.valueOf(parama.hashCode());
        ((c)localObject1).dCw = 19;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.h
 * JD-Core Version:    0.7.0.1
 */