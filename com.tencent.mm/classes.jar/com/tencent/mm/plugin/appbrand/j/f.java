package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class f
  extends com.tencent.mm.plugin.fts.ui.a
{
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45030);
    j localj = new j();
    localj.query = getQuery();
    localj.BIT = com.tencent.mm.plugin.fts.a.c.d.BJw;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    localj.BIS = paramHashSet;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(7, localj);
    AppMethodBeat.o(45030);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45032);
    int i = paramInt - parama.BJz - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.pWR.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.pWR.get(i);
        localObject = new d(paramInt);
        ((d)localObject).olG = localm;
        ((d)localObject).BHY = parama.BHY;
        ((d)localObject).hx(localm.type, localm.BHR);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
    }
    AppMethodBeat.o(45032);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45031);
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
      localn.m("21ViewType", "2,");
      localn.m("22OpType", "1,");
      localn.m("23ResultCount", localList.size() + ",");
      localn.m("24ClickPos", ",");
      localn.m("25ClickAppUserName", ",");
      Log.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localn.agI() });
      com.tencent.mm.plugin.report.service.h.IzE.a(13963, new Object[] { localn });
    }
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.BHY = paramk.BHY;
      paramHashSet.pWR = paramk.BIW;
      this.BLN.add(paramHashSet);
    }
    AppMethodBeat.o(45031);
  }
  
  public final int getType()
  {
    return 4224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.f
 * JD-Core Version:    0.7.0.1
 */