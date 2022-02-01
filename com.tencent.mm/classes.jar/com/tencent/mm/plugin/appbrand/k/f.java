package com.tencent.mm.plugin.appbrand.k;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.List;

public final class f
  extends com.tencent.mm.plugin.fts.ui.a
{
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45030);
    j localj = new j();
    localj.query = this.query;
    localj.syH = com.tencent.mm.plugin.fts.a.c.d.szj;
    localj.syI = this;
    localj.handler = paramao;
    localj.syG = paramHashSet;
    paramao = ((n)g.ad(n.class)).search(7, localj);
    AppMethodBeat.o(45030);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45032);
    int i = paramInt - parama.szm - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lnk.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lnk.get(i);
        localObject = new d(paramInt);
        ((d)localObject).jPN = localm;
        ((d)localObject).sxM = parama.sxM;
        ((d)localObject).fP(localm.type, localm.sxF);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
    }
    AppMethodBeat.o(45032);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45031);
    List localList = paramk.syK;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.f localf = new com.tencent.mm.modelsns.f();
      String str = this.query;
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      localf.n("20KeyWordId", paramHashSet + ",");
      localf.n("21ViewType", "2,");
      localf.n("22OpType", "1,");
      localf.n("23ResultCount", localList.size() + ",");
      localf.n("24ClickPos", ",");
      localf.n("25ClickAppUserName", ",");
      ac.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localf.PS() });
      h.wUl.f(13963, new Object[] { localf });
    }
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.sxM = paramk.sxM;
      paramHashSet.lnk = paramk.syK;
      this.sBx.add(paramHashSet);
    }
    AppMethodBeat.o(45031);
  }
  
  public final int getType()
  {
    return 4224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.f
 * JD-Core Version:    0.7.0.1
 */