package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
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
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45030);
    l locall = new l();
    locall.query = getQuery();
    locall.HtB = com.tencent.mm.plugin.fts.a.c.d.Hug;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    locall.HtA = paramHashSet;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(7, locall);
    AppMethodBeat.o(45030);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(45032);
    int i = paramInt - parama.Huj - 1;
    o localo = null;
    Object localObject = localo;
    if (i < parama.tbH.size())
    {
      localObject = localo;
      if (i >= 0)
      {
        localo = (o)parama.tbH.get(i);
        localObject = new d(paramInt);
        ((d)localObject).rpp = localo;
        ((d)localObject).FWt = parama.FWt;
        ((d)localObject).iW(localo.type, localo.subtype);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
    }
    AppMethodBeat.o(45032);
    return localObject;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(45031);
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
      localn.s("21ViewType", "2,");
      localn.s("22OpType", "1,");
      localn.s("23ResultCount", localList.size() + ",");
      localn.s("24ClickPos", ",");
      localn.s("25ClickAppUserName", ",");
      Log.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[] { localn.aIF() });
      com.tencent.mm.plugin.report.service.h.OAn.b(13963, new Object[] { localn });
    }
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -13;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(45031);
  }
  
  public final int getType()
  {
    return 4224;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.f
 * JD-Core Version:    0.7.0.1
 */