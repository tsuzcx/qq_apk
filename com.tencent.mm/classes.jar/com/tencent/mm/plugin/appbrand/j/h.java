package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45034);
    j localj = new j();
    localj.query = getQuery();
    localj.BIT = com.tencent.mm.plugin.fts.a.c.d.BJw;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    localj.BIS = paramHashSet;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(7, localj);
    AppMethodBeat.o(45034);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(45037);
    d locald = new d(paramInt2);
    locald.olG = paramm;
    locald.BHY = parama.BHY;
    locald.hx(paramm.type, paramm.BHR);
    AppMethodBeat.o(45037);
    return locald;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45036);
    int i = paramInt - parama.BJz - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.pWR.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(393216, paramInt, (m)parama.pWR.get(i), parama);
      }
    }
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).BJI = (i + 1);
      if (i == parama.pWR.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).BJG = false;
      }
    }
    AppMethodBeat.o(45036);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45035);
    List localList = paramk.BIW;
    if ((localList != null) && (!localList.isEmpty()))
    {
      com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
      String str = getQuery();
      paramHashSet = str;
      if (str != null) {
        paramHashSet = str.replaceAll(",", " ");
      }
      localn.m("20KeyWordId", paramHashSet + ",");
      localn.m("21ViewType", "1,");
      localn.m("22OpType", "1,");
      localn.m("23ResultCount", localList.size() + ",");
      localn.m("24ClickPos", ",");
      localn.m("25ClickAppUserName", ",");
      Log.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localn.agI() });
      com.tencent.mm.plugin.report.service.h.IzE.a(13963, new Object[] { localn });
    }
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.pWR = paramk.BIW;
      paramHashSet.BHY = paramk.BHY;
      if (paramHashSet.pWR.size() > 1)
      {
        paramHashSet.xcp = true;
        paramHashSet.pWR = paramHashSet.pWR.subList(0, 1);
      }
      this.BLN.add(paramHashSet);
    }
    AppMethodBeat.o(45035);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45038);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.pWR.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.pWR.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).fND = String.valueOf(parama.hashCode());
        ((c)localObject1).fNO = 19;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.h
 * JD-Core Version:    0.7.0.1
 */