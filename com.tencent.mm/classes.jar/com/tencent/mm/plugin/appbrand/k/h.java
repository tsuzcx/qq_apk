package com.tencent.mm.plugin.appbrand.k;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45034);
    j localj = new j();
    localj.query = this.query;
    localj.syH = com.tencent.mm.plugin.fts.a.c.d.szj;
    localj.syI = this;
    localj.handler = paramao;
    localj.syG = paramHashSet;
    paramao = ((n)g.ad(n.class)).search(7, localj);
    AppMethodBeat.o(45034);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(45037);
    d locald = new d(paramInt2);
    locald.jPN = paramm;
    locald.sxM = parama.sxM;
    locald.fP(paramm.type, paramm.sxF);
    AppMethodBeat.o(45037);
    return locald;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45036);
    int i = paramInt - parama.szm - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.lnk.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(393216, paramInt, (m)parama.lnk.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).szv = (i + 1);
      if (i == parama.lnk.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).szt = false;
      }
    }
    AppMethodBeat.o(45036);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45035);
    List localList = paramk.syK;
    if ((localList != null) && (!localList.isEmpty()))
    {
      f localf = new f();
      String str = this.query;
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      localf.n("20KeyWordId", paramHashSet + ",");
      localf.n("21ViewType", "1,");
      localf.n("22OpType", "1,");
      localf.n("23ResultCount", localList.size() + ",");
      localf.n("24ClickPos", ",");
      localf.n("25ClickAppUserName", ",");
      ac.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localf.PS() });
      com.tencent.mm.plugin.report.service.h.wUl.f(13963, new Object[] { localf });
    }
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.lnk = paramk.syK;
      paramHashSet.sxM = paramk.sxM;
      if (paramHashSet.lnk.size() > 1)
      {
        paramHashSet.qYO = true;
        paramHashSet.lnk = paramHashSet.lnk.subList(0, 1);
      }
      this.sBx.add(paramHashSet);
    }
    AppMethodBeat.o(45035);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45038);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.lnk.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.lnk.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).dpt = String.valueOf(parama.hashCode());
        ((c)localObject1).dpE = 19;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.h
 * JD-Core Version:    0.7.0.1
 */