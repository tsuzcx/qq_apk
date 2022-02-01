package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "processFansCount", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processObjectWordingConfig", "processPreFetch", "processReInit", "processRevokeRedDot", "processRevokeTabTips", "processSpamObj", "processTabRedDot", "plugin-finder_release"})
public final class b
  implements com.tencent.mm.plugin.finder.api.f
{
  private final String TAG = "Finder.SyncFinderSyncHandler";
  
  private final void b(ama paramama)
  {
    AppMethodBeat.i(165598);
    anc localanc = new anc();
    paramama = paramama.GEu;
    if (paramama != null) {}
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localanc.parseFrom(paramama);
      ae.i(this.TAG, "redDotEvent save svr_fans count " + localanc.GDY + " svr_fans_add_count:" + localanc.GEP);
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jcz, Integer.valueOf(localanc.GEP));
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jcy, Integer.valueOf(localanc.GDY));
      paramama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramama, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramama).getRedDotManager().ED(localanc.GEP);
      AppMethodBeat.o(165598);
      return;
    }
  }
  
  private final void c(ama paramama)
  {
    AppMethodBeat.i(165599);
    anl localanl = new anl();
    paramama = paramama.GEu;
    if (paramama != null) {}
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localanl.parseFrom(paramama);
      ae.i(this.TAG, "save svr_follow count " + localanl.GEO);
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jcx, Integer.valueOf(localanl.GEO));
      AppMethodBeat.o(165599);
      return;
    }
  }
  
  private final void d(ama paramama)
  {
    AppMethodBeat.i(165600);
    amq localamq = new amq();
    paramama = paramama.GEu;
    if (paramama != null) {}
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localamq.parseFrom(paramama);
      ae.i(this.TAG, "redDotEvent new count info, msg count:" + localamq.count + ", normalCount:" + localamq.imI + ", systemCount:" + localamq.GEQ);
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jde, Integer.valueOf(localamq.imI));
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jdf, Integer.valueOf(localamq.GEQ));
      paramama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramama, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramama).getRedDotManager().fH(localamq.imI, localamq.GEQ);
      AppMethodBeat.o(165600);
      return;
    }
  }
  
  private final void e(ama paramama)
  {
    AppMethodBeat.i(165601);
    anp localanp = new anp();
    paramama = paramama.GEu;
    if (paramama != null)
    {
      localanp.parseFrom(paramama.toByteArray());
      paramama = localanp.GFw;
      p.g(paramama, "follower.followers");
      paramama = ((Iterable)paramama).iterator();
      while (paramama.hasNext())
      {
        Object localObject1 = (FinderContact)paramama.next();
        Object localObject2 = c.rPy;
        localObject2 = c.a.ahT(((FinderContact)localObject1).username);
        ae.i(this.TAG, "sync follow contact " + localanp.GFw.size() + "  username=" + ((FinderContact)localObject1).username + " nickname=" + ((FinderContact)localObject1).nickname + " followFlag=" + ((FinderContact)localObject1).followFlag + ' ');
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.api.g)localObject2).field_follow_Flag = ((FinderContact)localObject1).followFlag;
          localObject1 = c.rPy;
          c.a.c((com.tencent.mm.plugin.finder.api.g)localObject2);
        }
        else
        {
          localObject2 = c.rPy;
          p.g(localObject1, "follow");
          c.a.a((FinderContact)localObject1);
        }
      }
      AppMethodBeat.o(165601);
      return;
    }
    AppMethodBeat.o(165601);
  }
  
  private final void f(ama paramama)
  {
    AppMethodBeat.i(165602);
    atm localatm = new atm();
    paramama = paramama.GEu;
    if (paramama != null) {}
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localatm.parseFrom(paramama);
      int i = localatm.GEM + localatm.GEL + localatm.GKo + localatm.GKp + localatm.GKq;
      ae.i(this.TAG, "redDotEvent new wx count info, msg count:" + localatm.count + ", comment:" + localatm.GEM + ", like:" + localatm.GEL + ", objectlike_like:" + localatm.GKo + ", objectrecommend_like:" + localatm.GKp + ", follow_accepted_count:" + localatm.GKq + ", headUrl:" + localatm.hGI + " totalCount=" + i);
      if (i > 0)
      {
        paramama = com.tencent.mm.kernel.g.ajR();
        p.g(paramama, "MMKernel.storage()");
        paramama.ajA().set(am.a.JcD, Boolean.TRUE);
      }
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jcf, Integer.valueOf(localatm.GEM));
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jcg, Integer.valueOf(localatm.GEL));
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jch, Integer.valueOf(localatm.GKo));
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jci, Integer.valueOf(localatm.GKp));
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jcj, Integer.valueOf(localatm.GKq));
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jck, localatm.hGI);
      paramama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramama, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramama).getRedDotManager().a(localatm);
      AppMethodBeat.o(165602);
      return;
    }
  }
  
  private final void g(ama paramama)
  {
    AppMethodBeat.i(165603);
    Object localObject = new asa();
    paramama = paramama.GEu;
    if (paramama != null)
    {
      ((asa)localObject).parseFrom(paramama.toByteArray());
      paramama = ((asa)localObject).object;
      p.g(paramama, "spamObj.`object`");
      int i;
      if (!((Collection)paramama).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        ae.i(this.TAG, "sync spam obj %s", new Object[] { Integer.valueOf(((asa)localObject).object.size()) });
        paramama = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        paramama = ((asa)localObject).object;
        p.g(paramama, "spamObj.`object`");
        localObject = (Iterable)paramama;
        paramama = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramama.add(Long.valueOf(((dim)((Iterator)localObject).next()).GHa));
            continue;
            i = 0;
            break;
          }
        }
        paramama = (List)paramama;
        p.h(paramama, "objectId");
        long l = System.currentTimeMillis();
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().dL(paramama);
        ae.i(com.tencent.mm.plugin.finder.storage.logic.b.access$getTAG$cp(), "delete feed size=$" + paramama.size() + " cost=" + (System.currentTimeMillis() - l) + "ms");
      }
      AppMethodBeat.o(165603);
      return;
    }
    AppMethodBeat.o(165603);
  }
  
  private final void h(ama paramama)
  {
    AppMethodBeat.i(165604);
    aql localaql = new aql();
    if (paramama.GEu != null)
    {
      paramama = paramama.GEu;
      if (paramama == null) {
        break label102;
      }
    }
    label102:
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localaql.parseFrom(paramama);
      ae.i(this.TAG, "processNotInterestedConfig config:" + localaql.GtQ);
      paramama = com.tencent.mm.kernel.g.ajR();
      p.g(paramama, "MMKernel.storage()");
      paramama.ajA().set(am.a.Jcu, bu.cH(localaql.toByteArray()));
      AppMethodBeat.o(165604);
      return;
    }
  }
  
  private final void i(ama paramama)
  {
    AppMethodBeat.i(165605);
    ae.i(this.TAG, "[processReInit] ...");
    arg localarg = new arg();
    paramama = paramama.GEu;
    if (paramama != null)
    {
      localarg.parseFrom(paramama.toByteArray());
      int i;
      if (localarg.GIa != 0)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 20L, 1L);
        paramama = localarg.GHZ;
        p.g(paramama, "newSelf.self");
        if (((Collection)paramama).isEmpty()) {
          break label289;
        }
        i = 1;
        if (i == 0) {
          break label294;
        }
        ae.i(this.TAG, "replace new finder username %s", new Object[] { ((FinderContact)localarg.GHZ.get(0)).username });
        paramama = com.tencent.mm.kernel.g.ajR();
        p.g(paramama, "MMKernel.storage()");
        paramama.ajA().set(am.a.JcG, ((FinderContact)localarg.GHZ.get(0)).username);
      }
      for (;;)
      {
        paramama = com.tencent.mm.kernel.g.ajR();
        p.g(paramama, "MMKernel.storage()");
        paramama.ajA().set(am.a.JcF, Integer.valueOf(localarg.GEk));
        paramama = com.tencent.mm.kernel.g.ajR();
        p.g(paramama, "MMKernel.storage()");
        i = paramama.ajA().getInt(am.a.JcH, 0);
        ae.i(this.TAG, "[processReInit] userVersion=" + i + " userVersion=" + localarg.GEk);
        if ((i != localarg.GEk) && (localarg.GEk != 0))
        {
          paramama = com.tencent.mm.kernel.g.ajR();
          p.g(paramama, "MMKernel.storage()");
          paramama.ajA().set(am.a.JcI, Integer.valueOf(1));
        }
        AppMethodBeat.o(165605);
        return;
        label289:
        i = 0;
        break;
        label294:
        paramama = com.tencent.mm.kernel.g.ajR();
        p.g(paramama, "MMKernel.storage()");
        paramama.ajA().set(am.a.JcG, "");
      }
    }
    AppMethodBeat.o(165605);
  }
  
  private final void j(ama paramama)
  {
    AppMethodBeat.i(165606);
    ari localari = new ari();
    paramama = paramama.GEu;
    if (paramama != null) {}
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localari.parseFrom(paramama);
      ae.i(this.TAG, "redDotEvent get red dot, showRed:" + localari.GIc);
      paramama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramama, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramama).getRedDotManager().a(localari);
      AppMethodBeat.o(165606);
      return;
    }
  }
  
  private final void k(ama paramama)
  {
    AppMethodBeat.i(178142);
    ara localara = new ara();
    paramama = paramama.GEu;
    if (paramama != null) {}
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localara.parseFrom(paramama);
      ae.i(this.TAG, "processPreFetch needPrefetch:" + localara.GHN + " needShowRedDot:" + localara.GHO);
      AppMethodBeat.o(178142);
      return;
    }
  }
  
  private static void l(ama paramama)
  {
    AppMethodBeat.i(202021);
    asn localasn = new asn();
    paramama = paramama.GEu;
    if (paramama != null) {}
    for (paramama = paramama.toByteArray();; paramama = null)
    {
      localasn.parseFrom(paramama);
      paramama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramama, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramama).getRedDotManager().a(localasn, "processTabRedDot");
      AppMethodBeat.o(202021);
      return;
    }
  }
  
  private final void m(ama paramama)
  {
    AppMethodBeat.i(202022);
    try
    {
      ekt localekt = new ekt();
      paramama = paramama.GEu;
      if (paramama != null) {}
      for (paramama = paramama.toByteArray();; paramama = null)
      {
        localekt.parseFrom(paramama);
        paramama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        p.g(paramama, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramama).getRedDotManager().a(localekt);
        AppMethodBeat.o(202022);
        return;
      }
      return;
    }
    catch (Exception paramama)
    {
      ae.l(this.TAG, "", new Object[] { paramama });
      AppMethodBeat.o(202022);
    }
  }
  
  private final void n(ama paramama)
  {
    AppMethodBeat.i(202023);
    if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) {
      try
      {
        aqp localaqp = new aqp();
        paramama = paramama.GEu;
        if (paramama != null) {}
        for (paramama = paramama.toByteArray();; paramama = null)
        {
          localaqp.parseFrom(paramama);
          paramama = com.tencent.mm.plugin.finder.storage.logic.f.sLy;
          com.tencent.mm.plugin.finder.storage.logic.f.a(localaqp);
          AppMethodBeat.o(202023);
          return;
        }
        AppMethodBeat.o(202023);
      }
      catch (Exception paramama)
      {
        ae.l(this.TAG, "", new Object[] { paramama });
      }
    }
  }
  
  private final void o(ama paramama)
  {
    AppMethodBeat.i(224278);
    try
    {
      aro localaro = new aro();
      paramama = paramama.GEu;
      if (paramama != null) {}
      for (paramama = paramama.toByteArray();; paramama = null)
      {
        localaro.parseFrom(paramama);
        paramama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        p.g(paramama, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramama).getRedDotManager().a(localaro);
        AppMethodBeat.o(224278);
        return;
      }
      return;
    }
    catch (Exception paramama)
    {
      ae.l(this.TAG, "", new Object[] { paramama });
      AppMethodBeat.o(224278);
    }
  }
  
  public final void a(ama paramama)
  {
    AppMethodBeat.i(165597);
    p.h(paramama, "cmdItem");
    int i = paramama.cmdId;
    ae.i(this.TAG, "cmdId ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(165597);
      return;
      d(paramama);
      AppMethodBeat.o(165597);
      return;
      e(paramama);
      AppMethodBeat.o(165597);
      return;
      f(paramama);
      AppMethodBeat.o(165597);
      return;
      g(paramama);
      AppMethodBeat.o(165597);
      return;
      b(paramama);
      AppMethodBeat.o(165597);
      return;
      c(paramama);
      AppMethodBeat.o(165597);
      return;
      h(paramama);
      AppMethodBeat.o(165597);
      return;
      j(paramama);
      AppMethodBeat.o(165597);
      return;
      i(paramama);
      AppMethodBeat.o(165597);
      return;
      k(paramama);
      AppMethodBeat.o(165597);
      return;
      l(paramama);
      AppMethodBeat.o(165597);
      return;
      o(paramama);
      AppMethodBeat.o(165597);
      return;
      m(paramama);
      AppMethodBeat.o(165597);
      return;
      n(paramama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.b
 * JD-Core Version:    0.7.0.1
 */