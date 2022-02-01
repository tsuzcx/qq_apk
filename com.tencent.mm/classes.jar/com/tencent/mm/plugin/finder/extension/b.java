package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "processFansCount", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processPreFetch", "processReInit", "processSpamObj", "processTabRedDot", "plugin-finder_release"})
public final class b
  implements com.tencent.mm.plugin.finder.api.e
{
  private final String TAG = "Finder.SyncFinderSyncHandler";
  
  private final void b(ahv paramahv)
  {
    AppMethodBeat.i(165598);
    aij localaij = new aij();
    localaij.parseFrom(paramahv.Dkt.toByteArray());
    ad.i(this.TAG, "redDotEvent save svr_fans count " + localaij.Dla + " svr_fans_add_count:" + localaij.Dlb);
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.FwY, Integer.valueOf(localaij.Dlb));
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.FwX, Integer.valueOf(localaij.Dla));
    AppMethodBeat.o(165598);
  }
  
  private final void c(ahv paramahv)
  {
    AppMethodBeat.i(165599);
    aio localaio = new aio();
    localaio.parseFrom(paramahv.Dkt.toByteArray());
    ad.i(this.TAG, "save svr_follow count " + localaio.Dlh);
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.FwW, Integer.valueOf(localaio.Dlh));
    AppMethodBeat.o(165599);
  }
  
  private final void d(ahv paramahv)
  {
    AppMethodBeat.i(165600);
    aia localaia = new aia();
    localaia.parseFrom(paramahv.Dkt.toByteArray());
    ad.i(this.TAG, "redDotEvent new count info, msg count:" + localaia.count + ", normalCount:" + localaia.hpZ + ", systemCount:" + localaia.Lxp);
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.LBn, Integer.valueOf(localaia.hpZ));
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.LBo, Integer.valueOf(localaia.Lxp));
    AppMethodBeat.o(165600);
  }
  
  private final void e(ahv paramahv)
  {
    AppMethodBeat.i(165601);
    air localair = new air();
    paramahv = paramahv.Dkt;
    if (paramahv != null)
    {
      localair.parseFrom(paramahv.toByteArray());
      paramahv = localair.Dli;
      k.g(paramahv, "follower.followers");
      paramahv = ((Iterable)paramahv).iterator();
      while (paramahv.hasNext())
      {
        Object localObject1 = (FinderContact)paramahv.next();
        Object localObject2 = com.tencent.mm.plugin.finder.api.b.qnX;
        localObject2 = ((FinderContact)localObject1).username;
        k.g(localObject2, "follow.username");
        localObject2 = com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject2);
        ad.i(this.TAG, "sync follow contact " + localair.Dli.size() + "  username=" + ((FinderContact)localObject1).username + " nickname=" + ((FinderContact)localObject1).nickname + " followFlag=" + ((FinderContact)localObject1).followFlag + ' ');
        if (localObject2 != null)
        {
          ((f)localObject2).field_follow_Flag = ((FinderContact)localObject1).followFlag;
          localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
          k.h(localObject2, "contact");
          com.tencent.mm.plugin.finder.api.b.a.c((f)localObject2);
          com.tencent.mm.plugin.finder.api.b.a.a((f)localObject2);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.api.b.qnX;
          k.g(localObject1, "follow");
          com.tencent.mm.plugin.finder.api.b.a.a((FinderContact)localObject1);
        }
      }
      AppMethodBeat.o(165601);
      return;
    }
    AppMethodBeat.o(165601);
  }
  
  private final void f(ahv paramahv)
  {
    AppMethodBeat.i(165602);
    aly localaly = new aly();
    localaly.parseFrom(paramahv.Dkt.toByteArray());
    int i = localaly.DkE + localaly.DkD + localaly.LyK + localaly.LyL;
    ad.i(this.TAG, "redDotEvent new wx count info, msg count:" + localaly.count + ", comment:" + localaly.DkE + ", like:" + localaly.DkD + ", objectlike_like:" + localaly.LyK + ", objectrecommend_like:" + localaly.LyL + ", headUrl:" + localaly.gLg + " totalCount=" + i);
    if (i > 0)
    {
      paramahv = g.afB();
      k.g(paramahv, "MMKernel.storage()");
      paramahv.afk().set(ae.a.Fxc, Boolean.TRUE);
    }
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.FwJ, Integer.valueOf(localaly.DkE));
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.FwK, Integer.valueOf(localaly.DkD));
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.LBe, Integer.valueOf(localaly.LyK));
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.LBf, Integer.valueOf(localaly.LyL));
    paramahv = g.afB();
    k.g(paramahv, "MMKernel.storage()");
    paramahv.afk().set(ae.a.FwL, localaly.gLg);
    paramahv = g.ad(PluginFinder.class);
    k.g(paramahv, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramahv).getRedDotManager().a(localaly);
    AppMethodBeat.o(165602);
  }
  
  private final void g(ahv paramahv)
  {
    AppMethodBeat.i(165603);
    Object localObject = new alf();
    paramahv = paramahv.Dkt;
    if (paramahv != null)
    {
      ((alf)localObject).parseFrom(paramahv.toByteArray());
      paramahv = ((alf)localObject).object;
      k.g(paramahv, "spamObj.`object`");
      int i;
      if (!((Collection)paramahv).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        ad.i(this.TAG, "sync spam obj %s", new Object[] { Integer.valueOf(((alf)localObject).object.size()) });
        paramahv = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        paramahv = ((alf)localObject).object;
        k.g(paramahv, "spamObj.`object`");
        localObject = (Iterable)paramahv;
        paramahv = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramahv.add(Long.valueOf(((cwt)((Iterator)localObject).next()).DlN));
            continue;
            i = 0;
            break;
          }
        }
        com.tencent.mm.plugin.finder.storage.logic.b.a.dz((List)paramahv);
      }
      AppMethodBeat.o(165603);
      return;
    }
    AppMethodBeat.o(165603);
  }
  
  private final void h(ahv paramahv)
  {
    AppMethodBeat.i(165604);
    akc localakc = new akc();
    if (paramahv.Dkt != null)
    {
      localakc.parseFrom(paramahv.Dkt.toByteArray());
      ad.i(this.TAG, "processNotInterestedConfig config:" + localakc.DaU);
      paramahv = g.afB();
      k.g(paramahv, "MMKernel.storage()");
      paramahv.afk().set(ae.a.FwT, bt.cy(localakc.toByteArray()));
    }
    AppMethodBeat.o(165604);
  }
  
  private final void i(ahv paramahv)
  {
    AppMethodBeat.i(165605);
    ad.i(this.TAG, "process reInit");
    akt localakt = new akt();
    paramahv = paramahv.Dkt;
    if (paramahv != null)
    {
      localakt.parseFrom(paramahv.toByteArray());
      int i;
      if (localakt.Dmp != 0)
      {
        h.vKh.m(1279L, 20L, 1L);
        paramahv = localakt.Dmo;
        k.g(paramahv, "newSelf.self");
        if (((Collection)paramahv).isEmpty()) {
          break label191;
        }
        i = 1;
        if (i == 0) {
          break label196;
        }
        ad.i(this.TAG, "replace new finder username %s", new Object[] { ((FinderContact)localakt.Dmo.get(0)).username });
        paramahv = g.afB();
        k.g(paramahv, "MMKernel.storage()");
        paramahv.afk().set(ae.a.Fxf, ((FinderContact)localakt.Dmo.get(0)).username);
      }
      for (;;)
      {
        paramahv = g.afB();
        k.g(paramahv, "MMKernel.storage()");
        paramahv.afk().set(ae.a.Fxe, Integer.valueOf(localakt.Dko));
        AppMethodBeat.o(165605);
        return;
        label191:
        i = 0;
        break;
        label196:
        paramahv = g.afB();
        k.g(paramahv, "MMKernel.storage()");
        paramahv.afk().set(ae.a.Fxf, "");
      }
    }
    AppMethodBeat.o(165605);
  }
  
  private final void j(ahv paramahv)
  {
    AppMethodBeat.i(165606);
    aku localaku = new aku();
    localaku.parseFrom(paramahv.Dkt.toByteArray());
    ad.i(this.TAG, "redDotEvent get red dot, showRed:" + localaku.Dmq);
    paramahv = g.ad(PluginFinder.class);
    k.g(paramahv, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramahv).getRedDotManager().a(localaku);
    AppMethodBeat.o(165606);
  }
  
  private final void k(ahv paramahv)
  {
    AppMethodBeat.i(178142);
    akn localakn = new akn();
    localakn.parseFrom(paramahv.Dkt.toByteArray());
    ad.i(this.TAG, "processPreFetch needPrefetch:" + localakn.Dmc + " needShowRedDot:" + localakn.Dmd);
    paramahv = g.ad(PluginFinder.class);
    k.g(paramahv, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramahv).getRedDotManager().a(localakn);
    AppMethodBeat.o(178142);
  }
  
  private static void l(ahv paramahv)
  {
    AppMethodBeat.i(197552);
    dzs localdzs = new dzs();
    localdzs.parseFrom(paramahv.Dkt.toByteArray());
    paramahv = g.ad(PluginFinder.class);
    k.g(paramahv, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramahv).getRedDotManager().a(localdzs, "processTabRedDot");
    AppMethodBeat.o(197552);
  }
  
  public final void a(ahv paramahv)
  {
    AppMethodBeat.i(165597);
    k.h(paramahv, "cmdItem");
    int i = paramahv.cmdId;
    ad.i(this.TAG, "cmdId ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(165597);
      return;
      d(paramahv);
      AppMethodBeat.o(165597);
      return;
      e(paramahv);
      AppMethodBeat.o(165597);
      return;
      f(paramahv);
      AppMethodBeat.o(165597);
      return;
      g(paramahv);
      AppMethodBeat.o(165597);
      return;
      b(paramahv);
      AppMethodBeat.o(165597);
      return;
      c(paramahv);
      AppMethodBeat.o(165597);
      return;
      h(paramahv);
      AppMethodBeat.o(165597);
      return;
      j(paramahv);
      AppMethodBeat.o(165597);
      return;
      i(paramahv);
      AppMethodBeat.o(165597);
      return;
      k(paramahv);
      AppMethodBeat.o(165597);
      return;
      l(paramahv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.b
 * JD-Core Version:    0.7.0.1
 */