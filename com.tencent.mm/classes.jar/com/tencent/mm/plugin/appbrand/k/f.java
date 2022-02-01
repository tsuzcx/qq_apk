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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class f
  extends com.tencent.mm.plugin.fts.ui.a
{
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45030);
    j localj = new j();
    localj.query = this.query;
    localj.rpN = com.tencent.mm.plugin.fts.a.c.d.rqp;
    localj.rpO = this;
    localj.handler = paramap;
    localj.rpM = paramHashSet;
    paramap = ((n)g.ad(n.class)).search(7, localj);
    AppMethodBeat.o(45030);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45032);
    int i = paramInt - parama.rqs - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.kLN.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.kLN.get(i);
        localObject = new d(paramInt);
        ((d)localObject).jpy = localm;
        ((d)localObject).roS = parama.roS;
        ((d)localObject).fI(localm.type, localm.roM);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqB = (i + 1);
    }
    AppMethodBeat.o(45032);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45031);
    List localList = paramk.rpQ;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.f localf = new com.tencent.mm.modelsns.f();
      String str = this.query;
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      localf.o("20KeyWordId", paramHashSet + ",");
      localf.o("21ViewType", "2,");
      localf.o("22OpType", "1,");
      localf.o("23ResultCount", localList.size() + ",");
      localf.o("24ClickPos", ",");
      localf.o("25ClickAppUserName", ",");
      ad.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localf.PW() });
      h.vKh.f(13963, new Object[] { localf });
    }
    if (dF(paramk.rpQ))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.roS = paramk.roS;
      paramHashSet.kLN = paramk.rpQ;
      this.rsD.add(paramHashSet);
    }
    AppMethodBeat.o(45031);
  }
  
  public final int getType()
  {
    return 4224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.f
 * JD-Core Version:    0.7.0.1
 */