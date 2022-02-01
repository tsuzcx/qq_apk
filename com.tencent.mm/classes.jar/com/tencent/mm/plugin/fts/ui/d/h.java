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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
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
    AppMethodBeat.i(112191);
    paramHashSet.add("62");
    if (com.tencent.mm.aw.b.CQ((String)g.agR().agA().get(274436, null))) {
      paramHashSet.add("65");
    }
    if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIO()) {
      paramHashSet.add("63");
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.appbrand.service.e)g.ab(com.tencent.mm.plugin.appbrand.service.e.class)).btZ()) {
        paramHashSet.add("69");
      }
      if (!((com.tencent.mm.plugin.appbrand.service.h)g.ab(com.tencent.mm.plugin.appbrand.service.h.class)).btZ()) {
        paramHashSet.add("71");
      }
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = this.query;
      localj.handler = paramao;
      localj.syG = paramHashSet;
      localj.syI = this;
      localj.syH = c.szi;
      paramao = ((n)g.ad(n.class)).search(4, localj);
      AppMethodBeat.o(112191);
      return paramao;
      paramHashSet.add("67");
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112194);
    com.tencent.mm.plugin.fts.ui.a.j localj = new com.tencent.mm.plugin.fts.ui.a.j(paramInt2);
    localj.jPN = paramm;
    localj.sxM = parama.sxM;
    localj.fP(paramm.type, paramm.sxF);
    AppMethodBeat.o(112194);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112193);
    int i = paramInt - parama.szm - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.lnk.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (m)parama.lnk.get(i), parama);
      }
    }
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).szv = (i + 1);
    }
    AppMethodBeat.o(112193);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112192);
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.sxM = paramk.sxM;
      paramHashSet.lnk = paramk.syK;
      paramHashSet.qYO = false;
      this.sBx.add(paramHashSet);
    }
    AppMethodBeat.o(112192);
  }
  
  public final int getType()
  {
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.h
 * JD-Core Version:    0.7.0.1
 */