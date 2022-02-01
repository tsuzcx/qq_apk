package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public final class f
  extends com.tencent.mm.plugin.fts.ui.a
{
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45030);
    j localj = new j();
    localj.query = this.query;
    localj.tFZ = com.tencent.mm.plugin.fts.a.c.d.tGB;
    localj.tGa = this;
    localj.handler = paramaq;
    localj.tFY = paramHashSet;
    paramaq = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(7, localj);
    AppMethodBeat.o(45030);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45032);
    int i = paramInt - parama.tGE - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lPc.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lPc.get(i);
        localObject = new d(paramInt);
        ((d)localObject).kno = localm;
        ((d)localObject).tFe = parama.tFe;
        ((d)localObject).gf(localm.type, localm.tEX);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
    }
    AppMethodBeat.o(45032);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45031);
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
      localg.m("21ViewType", "2,");
      localg.m("22OpType", "1,");
      localg.m("23ResultCount", localList.size() + ",");
      localg.m("24ClickPos", ",");
      localg.m("25ClickAppUserName", ",");
      ae.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localg.RD() });
      com.tencent.mm.plugin.report.service.g.yxI.f(13963, new Object[] { localg });
    }
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.tFe = paramk.tFe;
      paramHashSet.lPc = paramk.tGc;
      this.tIP.add(paramHashSet);
    }
    AppMethodBeat.o(45031);
  }
  
  public final int getType()
  {
    return 4224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.f
 * JD-Core Version:    0.7.0.1
 */