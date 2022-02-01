package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.c;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
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
    AppMethodBeat.i(112191);
    paramHashSet.add("62");
    if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null))) {
      paramHashSet.add("65");
    }
    if (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clc()) {
      paramHashSet.add("63");
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.appbrand.service.e)g.af(com.tencent.mm.plugin.appbrand.service.e.class)).bVr()) {
        paramHashSet.add("69");
      }
      if (!((com.tencent.mm.plugin.appbrand.service.h)g.af(com.tencent.mm.plugin.appbrand.service.h.class)).bVr()) {
        paramHashSet.add("71");
      }
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = this.query;
      localj.handler = paramMMHandler;
      localj.wWX = paramHashSet;
      localj.wWZ = this;
      localj.wWY = c.wXz;
      paramMMHandler = ((n)g.ah(n.class)).search(4, localj);
      AppMethodBeat.o(112191);
      return paramMMHandler;
      paramHashSet.add("67");
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112194);
    com.tencent.mm.plugin.fts.ui.a.j localj = new com.tencent.mm.plugin.fts.ui.a.j(paramInt2);
    localj.lqW = paramm;
    localj.wWd = parama.wWd;
    localj.gE(paramm.type, paramm.wVW);
    AppMethodBeat.o(112194);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112193);
    int i = paramInt - parama.wXD - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.mWl.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (m)parama.mWl.get(i), parama);
      }
    }
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).wXM = (i + 1);
    }
    AppMethodBeat.o(112193);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112192);
    if (eP(paramk.wXb))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.wWd = paramk.wWd;
      paramHashSet.mWl = paramk.wXb;
      paramHashSet.tuG = false;
      this.wZO.add(paramHashSet);
    }
    AppMethodBeat.o(112192);
  }
  
  public final int getType()
  {
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.h
 * JD-Core Version:    0.7.0.1
 */