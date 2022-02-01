package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.b.j;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112191);
    paramHashSet.add("62");
    if (b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) {
      paramHashSet.add("65");
    }
    if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbw()) {
      paramHashSet.add("63");
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.f.class)).bRX()) {
        paramHashSet.add("69");
      }
      if (!((i)com.tencent.mm.kernel.h.ax(i.class)).bRX()) {
        paramHashSet.add("71");
      }
      if (!((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).bRX()) {
        paramHashSet.add("74");
      }
      if (!d.rs(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_b4af18eac3d5").field_type)) {
        paramHashSet.add("73");
      }
      if (!d.rs(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_e087bb5b95e6").field_type)) {
        paramHashSet.add("76");
      }
      l locall = new l();
      locall.query = getQuery();
      locall.handler = paramMMHandler;
      locall.HtA = paramHashSet;
      locall.HtC = this;
      locall.HtB = com.tencent.mm.plugin.fts.a.c.c.Huf;
      paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(4, locall);
      AppMethodBeat.o(112191);
      return paramMMHandler;
      paramHashSet.add("67");
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    AppMethodBeat.i(112194);
    j localj = new j(paramInt2);
    localj.rpp = paramo;
    localj.FWt = parama.FWt;
    localj.iW(paramo.type, paramo.subtype);
    AppMethodBeat.o(112194);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112193);
    int i = paramInt - parama.Huj - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.tbH.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (o)parama.tbH.get(i), parama);
      }
    }
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hur = (i + 1);
    }
    AppMethodBeat.o(112193);
    return localObject1;
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112192);
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.tbH = paramm.HtF;
      paramHashSet.ABD = false;
      this.HwJ.add(paramHashSet);
    }
    AppMethodBeat.o(112192);
  }
  
  public final int getType()
  {
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.h
 * JD-Core Version:    0.7.0.1
 */