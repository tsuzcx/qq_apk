package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "processFansCount", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processPreFetch", "processReInit", "processRevokeRedDot", "processSpamObj", "processTabRedDot", "plugin-finder_release"})
public final class b
  implements f
{
  private final String TAG = "Finder.SyncFinderSyncHandler";
  
  private final void b(alo paramalo)
  {
    AppMethodBeat.i(165598);
    amq localamq = new amq();
    localamq.parseFrom(paramalo.Glr.toByteArray());
    ad.i(this.TAG, "redDotEvent save svr_fans count " + localamq.GlN + " svr_fans_add_count:" + localamq.GlO);
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHW, Integer.valueOf(localamq.GlO));
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHV, Integer.valueOf(localamq.GlN));
    paramalo = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramalo, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramalo).getRedDotManager().Eq(localamq.GlO);
    AppMethodBeat.o(165598);
  }
  
  private final void c(alo paramalo)
  {
    AppMethodBeat.i(165599);
    amy localamy = new amy();
    localamy.parseFrom(paramalo.Glr.toByteArray());
    ad.i(this.TAG, "save svr_follow count " + localamy.GlM);
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHU, Integer.valueOf(localamy.GlM));
    AppMethodBeat.o(165599);
  }
  
  private final void d(alo paramalo)
  {
    AppMethodBeat.i(165600);
    ame localame = new ame();
    localame.parseFrom(paramalo.Glr.toByteArray());
    ad.i(this.TAG, "redDotEvent new count info, msg count:" + localame.count + ", normalCount:" + localame.ijP + ", systemCount:" + localame.GlP);
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IIB, Integer.valueOf(localame.ijP));
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IIC, Integer.valueOf(localame.GlP));
    paramalo = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramalo, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramalo).getRedDotManager().fJ(localame.ijP, localame.GlP);
    AppMethodBeat.o(165600);
  }
  
  private final void e(alo paramalo)
  {
    AppMethodBeat.i(165601);
    anc localanc = new anc();
    paramalo = paramalo.Glr;
    if (paramalo != null)
    {
      localanc.parseFrom(paramalo.toByteArray());
      paramalo = localanc.Gmo;
      p.g(paramalo, "follower.followers");
      paramalo = ((Iterable)paramalo).iterator();
      while (paramalo.hasNext())
      {
        Object localObject1 = (FinderContact)paramalo.next();
        Object localObject2 = c.rHn;
        localObject2 = ((FinderContact)localObject1).username;
        p.g(localObject2, "follow.username");
        localObject2 = c.a.agW((String)localObject2);
        ad.i(this.TAG, "sync follow contact " + localanc.Gmo.size() + "  username=" + ((FinderContact)localObject1).username + " nickname=" + ((FinderContact)localObject1).nickname + " followFlag=" + ((FinderContact)localObject1).followFlag + ' ');
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.api.g)localObject2).field_follow_Flag = ((FinderContact)localObject1).followFlag;
          localObject1 = c.rHn;
          c.a.c((com.tencent.mm.plugin.finder.api.g)localObject2);
        }
        else
        {
          localObject2 = c.rHn;
          p.g(localObject1, "follow");
          c.a.a((FinderContact)localObject1);
        }
      }
      AppMethodBeat.o(165601);
      return;
    }
    AppMethodBeat.o(165601);
  }
  
  private final void f(alo paramalo)
  {
    AppMethodBeat.i(165602);
    asw localasw = new asw();
    localasw.parseFrom(paramalo.Glr.toByteArray());
    int i = localasw.GlK + localasw.GlJ + localasw.GqQ + localasw.GqR + localasw.GqS;
    ad.i(this.TAG, "redDotEvent new wx count info, msg count:" + localasw.count + ", comment:" + localasw.GlK + ", like:" + localasw.GlJ + ", objectlike_like:" + localasw.GqQ + ", objectrecommend_like:" + localasw.GqR + ", follow_accepted_count:" + localasw.GqS + ", headUrl:" + localasw.hDQ + " totalCount=" + i);
    if (i > 0)
    {
      paramalo = com.tencent.mm.kernel.g.ajC();
      p.g(paramalo, "MMKernel.storage()");
      paramalo.ajl().set(al.a.IIa, Boolean.TRUE);
    }
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHC, Integer.valueOf(localasw.GlK));
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHD, Integer.valueOf(localasw.GlJ));
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHE, Integer.valueOf(localasw.GqQ));
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHF, Integer.valueOf(localasw.GqR));
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHG, Integer.valueOf(localasw.GqS));
    paramalo = com.tencent.mm.kernel.g.ajC();
    p.g(paramalo, "MMKernel.storage()");
    paramalo.ajl().set(al.a.IHH, localasw.hDQ);
    paramalo = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramalo, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramalo).getRedDotManager().a(localasw);
    AppMethodBeat.o(165602);
  }
  
  private final void g(alo paramalo)
  {
    AppMethodBeat.i(165603);
    Object localObject = new arl();
    paramalo = paramalo.Glr;
    if (paramalo != null)
    {
      ((arl)localObject).parseFrom(paramalo.toByteArray());
      paramalo = ((arl)localObject).object;
      p.g(paramalo, "spamObj.`object`");
      int i;
      if (!((Collection)paramalo).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        ad.i(this.TAG, "sync spam obj %s", new Object[] { Integer.valueOf(((arl)localObject).object.size()) });
        paramalo = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        paramalo = ((arl)localObject).object;
        p.g(paramalo, "spamObj.`object`");
        localObject = (Iterable)paramalo;
        paramalo = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramalo.add(Long.valueOf(((dhs)((Iterator)localObject).next()).GnU));
            continue;
            i = 0;
            break;
          }
        }
        paramalo = (List)paramalo;
        p.h(paramalo, "objectId");
        long l = System.currentTimeMillis();
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().dI(paramalo);
        ad.i(com.tencent.mm.plugin.finder.storage.logic.b.access$getTAG$cp(), "delete feed size=$" + paramalo.size() + " cost=" + (System.currentTimeMillis() - l) + "ms");
      }
      AppMethodBeat.o(165603);
      return;
    }
    AppMethodBeat.o(165603);
  }
  
  private final void h(alo paramalo)
  {
    AppMethodBeat.i(165604);
    apy localapy = new apy();
    if (paramalo.Glr != null)
    {
      localapy.parseFrom(paramalo.Glr.toByteArray());
      ad.i(this.TAG, "processNotInterestedConfig config:" + localapy.Gbj);
      paramalo = com.tencent.mm.kernel.g.ajC();
      p.g(paramalo, "MMKernel.storage()");
      paramalo.ajl().set(al.a.IHR, bt.cE(localapy.toByteArray()));
    }
    AppMethodBeat.o(165604);
  }
  
  private final void i(alo paramalo)
  {
    AppMethodBeat.i(165605);
    ad.i(this.TAG, "[processReInit] ...");
    aqr localaqr = new aqr();
    paramalo = paramalo.Glr;
    if (paramalo != null)
    {
      localaqr.parseFrom(paramalo.toByteArray());
      int i;
      if (localaqr.GoK != 0)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 20L, 1L);
        paramalo = localaqr.GoJ;
        p.g(paramalo, "newSelf.self");
        if (((Collection)paramalo).isEmpty()) {
          break label289;
        }
        i = 1;
        if (i == 0) {
          break label294;
        }
        ad.i(this.TAG, "replace new finder username %s", new Object[] { ((FinderContact)localaqr.GoJ.get(0)).username });
        paramalo = com.tencent.mm.kernel.g.ajC();
        p.g(paramalo, "MMKernel.storage()");
        paramalo.ajl().set(al.a.IId, ((FinderContact)localaqr.GoJ.get(0)).username);
      }
      for (;;)
      {
        paramalo = com.tencent.mm.kernel.g.ajC();
        p.g(paramalo, "MMKernel.storage()");
        paramalo.ajl().set(al.a.IIc, Integer.valueOf(localaqr.Gli));
        paramalo = com.tencent.mm.kernel.g.ajC();
        p.g(paramalo, "MMKernel.storage()");
        i = paramalo.ajl().getInt(al.a.IIe, 0);
        ad.i(this.TAG, "[processReInit] userVersion=" + i + " userVersion=" + localaqr.Gli);
        if ((i != localaqr.Gli) && (localaqr.Gli != 0))
        {
          paramalo = com.tencent.mm.kernel.g.ajC();
          p.g(paramalo, "MMKernel.storage()");
          paramalo.ajl().set(al.a.IIf, Integer.valueOf(1));
        }
        AppMethodBeat.o(165605);
        return;
        label289:
        i = 0;
        break;
        label294:
        paramalo = com.tencent.mm.kernel.g.ajC();
        p.g(paramalo, "MMKernel.storage()");
        paramalo.ajl().set(al.a.IId, "");
      }
    }
    AppMethodBeat.o(165605);
  }
  
  private final void j(alo paramalo)
  {
    AppMethodBeat.i(165606);
    aqt localaqt = new aqt();
    localaqt.parseFrom(paramalo.Glr.toByteArray());
    ad.i(this.TAG, "redDotEvent get red dot, showRed:" + localaqt.GoM);
    paramalo = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramalo, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramalo).getRedDotManager().a(localaqt);
    AppMethodBeat.o(165606);
  }
  
  private final void k(alo paramalo)
  {
    AppMethodBeat.i(178142);
    aql localaql = new aql();
    localaql.parseFrom(paramalo.Glr.toByteArray());
    ad.i(this.TAG, "processPreFetch needPrefetch:" + localaql.Gox + " needShowRedDot:" + localaql.Goy);
    AppMethodBeat.o(178142);
  }
  
  private static void l(alo paramalo)
  {
    AppMethodBeat.i(201574);
    ary localary = new ary();
    localary.parseFrom(paramalo.Glr.toByteArray());
    paramalo = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    p.g(paramalo, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramalo).getRedDotManager().a(localary, "processTabRedDot");
    AppMethodBeat.o(201574);
  }
  
  private final void m(alo paramalo)
  {
    AppMethodBeat.i(201575);
    try
    {
      aqz localaqz = new aqz();
      localaqz.parseFrom(paramalo.Glr.toByteArray());
      paramalo = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      p.g(paramalo, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramalo).getRedDotManager().a(localaqz);
      AppMethodBeat.o(201575);
      return;
    }
    catch (Exception paramalo)
    {
      ad.l(this.TAG, "", new Object[] { paramalo });
      AppMethodBeat.o(201575);
    }
  }
  
  public final void a(alo paramalo)
  {
    AppMethodBeat.i(165597);
    p.h(paramalo, "cmdItem");
    int i = paramalo.cmdId;
    ad.i(this.TAG, "cmdId ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(165597);
      return;
      d(paramalo);
      AppMethodBeat.o(165597);
      return;
      e(paramalo);
      AppMethodBeat.o(165597);
      return;
      f(paramalo);
      AppMethodBeat.o(165597);
      return;
      g(paramalo);
      AppMethodBeat.o(165597);
      return;
      b(paramalo);
      AppMethodBeat.o(165597);
      return;
      c(paramalo);
      AppMethodBeat.o(165597);
      return;
      h(paramalo);
      AppMethodBeat.o(165597);
      return;
      j(paramalo);
      AppMethodBeat.o(165597);
      return;
      i(paramalo);
      AppMethodBeat.o(165597);
      return;
      k(paramalo);
      AppMethodBeat.o(165597);
      return;
      l(paramalo);
      AppMethodBeat.o(165597);
      return;
      m(paramalo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.b
 * JD-Core Version:    0.7.0.1
 */