package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.b;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
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
    if (b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) {
      paramHashSet.add("65");
    }
    com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
    paramHashSet.add("63");
    if (!((e)com.tencent.mm.kernel.h.ae(e.class)).ciC()) {
      paramHashSet.add("69");
    }
    if (!((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.h.class)).ciC()) {
      paramHashSet.add("71");
    }
    if (!d.rk(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG("gh_b4af18eac3d5").field_type)) {
      paramHashSet.add("73");
    }
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = getQuery();
    localj.handler = paramMMHandler;
    localj.BIS = paramHashSet;
    localj.BIU = this;
    localj.BIT = com.tencent.mm.plugin.fts.a.c.c.BJv;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(4, localj);
    AppMethodBeat.o(112191);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112194);
    com.tencent.mm.plugin.fts.ui.a.j localj = new com.tencent.mm.plugin.fts.ui.a.j(paramInt2);
    localj.olG = paramm;
    localj.BHY = parama.BHY;
    localj.hx(paramm.type, paramm.BHR);
    AppMethodBeat.o(112194);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112193);
    int i = paramInt - parama.BJz - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.pWR.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (m)parama.pWR.get(i), parama);
      }
    }
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).BJI = (i + 1);
    }
    AppMethodBeat.o(112193);
    return localObject1;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112192);
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.BHY = paramk.BHY;
      paramHashSet.pWR = paramk.BIW;
      paramHashSet.xcp = false;
      this.BLN.add(paramHashSet);
    }
    AppMethodBeat.o(112192);
  }
  
  public final int getType()
  {
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.h
 * JD-Core Version:    0.7.0.1
 */