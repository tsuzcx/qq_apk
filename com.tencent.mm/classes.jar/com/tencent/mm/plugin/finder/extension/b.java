package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.extension.reddot.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "processFansCount", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processPreFetch", "processReInit", "processRevokeRedDot", "processSpamObj", "processTabRedDot", "plugin-finder_release"})
public final class b
  implements com.tencent.mm.plugin.finder.api.e
{
  private final String TAG = "Finder.SyncFinderSyncHandler";
  
  private final void b(aiy paramaiy)
  {
    AppMethodBeat.i(165598);
    ajt localajt = new ajt();
    localajt.parseFrom(paramaiy.EDH.toByteArray());
    ac.i(this.TAG, "redDotEvent save svr_fans count " + localajt.EDY + " svr_fans_add_count:" + localajt.EDZ);
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GVo, Integer.valueOf(localajt.EDZ));
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GVn, Integer.valueOf(localajt.EDY));
    AppMethodBeat.o(165598);
  }
  
  private final void c(aiy paramaiy)
  {
    AppMethodBeat.i(165599);
    aka localaka = new aka();
    localaka.parseFrom(paramaiy.EDH.toByteArray());
    ac.i(this.TAG, "save svr_follow count " + localaka.EDX);
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GVm, Integer.valueOf(localaka.EDX));
    AppMethodBeat.o(165599);
  }
  
  private final void d(aiy paramaiy)
  {
    AppMethodBeat.i(165600);
    ajj localajj = new ajj();
    localajj.parseFrom(paramaiy.EDH.toByteArray());
    ac.i(this.TAG, "redDotEvent new count info, msg count:" + localajj.count + ", normalCount:" + localajj.hQB + ", systemCount:" + localajj.EEa);
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GVL, Integer.valueOf(localajj.hQB));
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GVM, Integer.valueOf(localajj.EEa));
    AppMethodBeat.o(165600);
  }
  
  private final void e(aiy paramaiy)
  {
    AppMethodBeat.i(165601);
    akd localakd = new akd();
    paramaiy = paramaiy.EDH;
    if (paramaiy != null)
    {
      localakd.parseFrom(paramaiy.toByteArray());
      paramaiy = localakd.EEx;
      k.g(paramaiy, "follower.followers");
      paramaiy = ((Iterable)paramaiy).iterator();
      while (paramaiy.hasNext())
      {
        Object localObject1 = (FinderContact)paramaiy.next();
        Object localObject2 = com.tencent.mm.plugin.finder.api.b.qWt;
        localObject2 = ((FinderContact)localObject1).username;
        k.g(localObject2, "follow.username");
        localObject2 = com.tencent.mm.plugin.finder.api.b.a.adh((String)localObject2);
        ac.i(this.TAG, "sync follow contact " + localakd.EEx.size() + "  username=" + ((FinderContact)localObject1).username + " nickname=" + ((FinderContact)localObject1).nickname + " followFlag=" + ((FinderContact)localObject1).followFlag + ' ');
        if (localObject2 != null)
        {
          ((f)localObject2).field_follow_Flag = ((FinderContact)localObject1).followFlag;
          localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
          k.h(localObject2, "contact");
          com.tencent.mm.plugin.finder.api.b.a.c((f)localObject2);
          com.tencent.mm.plugin.finder.api.b.a.a((f)localObject2);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.api.b.qWt;
          k.g(localObject1, "follow");
          com.tencent.mm.plugin.finder.api.b.a.a((FinderContact)localObject1);
        }
      }
      AppMethodBeat.o(165601);
      return;
    }
    AppMethodBeat.o(165601);
  }
  
  private final void f(aiy paramaiy)
  {
    AppMethodBeat.i(165602);
    apb localapb = new apb();
    localapb.parseFrom(paramaiy.EDH.toByteArray());
    int i = localapb.EDV + localapb.EDU + localapb.EHX + localapb.EHY;
    ac.i(this.TAG, "redDotEvent new wx count info, msg count:" + localapb.count + ", comment:" + localapb.EDV + ", like:" + localapb.EDU + ", objectlike_like:" + localapb.EHX + ", objectrecommend_like:" + localapb.EHY + ", headUrl:" + localapb.hlG + " totalCount=" + i);
    if (i > 0)
    {
      paramaiy = g.agR();
      k.g(paramaiy, "MMKernel.storage()");
      paramaiy.agA().set(ah.a.GVs, Boolean.TRUE);
    }
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GUV, Integer.valueOf(localapb.EDV));
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GUW, Integer.valueOf(localapb.EDU));
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GUX, Integer.valueOf(localapb.EHX));
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GUY, Integer.valueOf(localapb.EHY));
    paramaiy = g.agR();
    k.g(paramaiy, "MMKernel.storage()");
    paramaiy.agA().set(ah.a.GUZ, localapb.hlG);
    paramaiy = g.ad(PluginFinder.class);
    k.g(paramaiy, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramaiy).getRedDotManager().a(localapb);
    AppMethodBeat.o(165602);
  }
  
  private final void g(aiy paramaiy)
  {
    AppMethodBeat.i(165603);
    Object localObject = new anz();
    paramaiy = paramaiy.EDH;
    if (paramaiy != null)
    {
      ((anz)localObject).parseFrom(paramaiy.toByteArray());
      paramaiy = ((anz)localObject).object;
      k.g(paramaiy, "spamObj.`object`");
      int i;
      if (!((Collection)paramaiy).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        ac.i(this.TAG, "sync spam obj %s", new Object[] { Integer.valueOf(((anz)localObject).object.size()) });
        paramaiy = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        paramaiy = ((anz)localObject).object;
        k.g(paramaiy, "spamObj.`object`");
        localObject = (Iterable)paramaiy;
        paramaiy = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramaiy.add(Long.valueOf(((dcf)((Iterator)localObject).next()).EFE));
            continue;
            i = 0;
            break;
          }
        }
        com.tencent.mm.plugin.finder.storage.logic.b.a.dB((List)paramaiy);
      }
      AppMethodBeat.o(165603);
      return;
    }
    AppMethodBeat.o(165603);
  }
  
  private final void h(aiy paramaiy)
  {
    AppMethodBeat.i(165604);
    amn localamn = new amn();
    if (paramaiy.EDH != null)
    {
      localamn.parseFrom(paramaiy.EDH.toByteArray());
      ac.i(this.TAG, "processNotInterestedConfig config:" + localamn.EtR);
      paramaiy = g.agR();
      k.g(paramaiy, "MMKernel.storage()");
      paramaiy.agA().set(ah.a.GVj, bs.cx(localamn.toByteArray()));
    }
    AppMethodBeat.o(165604);
  }
  
  private final void i(aiy paramaiy)
  {
    AppMethodBeat.i(165605);
    ac.i(this.TAG, "process reInit");
    anf localanf = new anf();
    paramaiy = paramaiy.EDH;
    if (paramaiy != null)
    {
      localanf.parseFrom(paramaiy.toByteArray());
      int i;
      if (localanf.EGn != 0)
      {
        h.wUl.n(1279L, 20L, 1L);
        paramaiy = localanf.EGm;
        k.g(paramaiy, "newSelf.self");
        if (((Collection)paramaiy).isEmpty()) {
          break label191;
        }
        i = 1;
        if (i == 0) {
          break label196;
        }
        ac.i(this.TAG, "replace new finder username %s", new Object[] { ((FinderContact)localanf.EGm.get(0)).username });
        paramaiy = g.agR();
        k.g(paramaiy, "MMKernel.storage()");
        paramaiy.agA().set(ah.a.GVv, ((FinderContact)localanf.EGm.get(0)).username);
      }
      for (;;)
      {
        paramaiy = g.agR();
        k.g(paramaiy, "MMKernel.storage()");
        paramaiy.agA().set(ah.a.GVu, Integer.valueOf(localanf.EDy));
        AppMethodBeat.o(165605);
        return;
        label191:
        i = 0;
        break;
        label196:
        paramaiy = g.agR();
        k.g(paramaiy, "MMKernel.storage()");
        paramaiy.agA().set(ah.a.GVv, "");
      }
    }
    AppMethodBeat.o(165605);
  }
  
  private final void j(aiy paramaiy)
  {
    AppMethodBeat.i(165606);
    anh localanh = new anh();
    localanh.parseFrom(paramaiy.EDH.toByteArray());
    ac.i(this.TAG, "redDotEvent get red dot, showRed:" + localanh.EGp);
    paramaiy = g.ad(PluginFinder.class);
    k.g(paramaiy, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramaiy).getRedDotManager().a(localanh);
    AppMethodBeat.o(165606);
  }
  
  private final void k(aiy paramaiy)
  {
    AppMethodBeat.i(178142);
    amz localamz = new amz();
    localamz.parseFrom(paramaiy.EDH.toByteArray());
    ac.i(this.TAG, "processPreFetch needPrefetch:" + localamz.EGb + " needShowRedDot:" + localamz.EGc);
    paramaiy = g.ad(PluginFinder.class);
    k.g(paramaiy, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramaiy).getRedDotManager().a(localamz);
    AppMethodBeat.o(178142);
  }
  
  private static void l(aiy paramaiy)
  {
    AppMethodBeat.i(201433);
    aoj localaoj = new aoj();
    localaoj.parseFrom(paramaiy.EDH.toByteArray());
    paramaiy = g.ad(PluginFinder.class);
    k.g(paramaiy, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramaiy).getRedDotManager().a(localaoj, "processTabRedDot");
    AppMethodBeat.o(201433);
  }
  
  private final void m(aiy paramaiy)
  {
    AppMethodBeat.i(201434);
    try
    {
      ann localann = new ann();
      localann.parseFrom(paramaiy.EDH.toByteArray());
      paramaiy = g.ad(PluginFinder.class);
      k.g(paramaiy, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramaiy).getRedDotManager().a(localann);
      AppMethodBeat.o(201434);
      return;
    }
    catch (Exception paramaiy)
    {
      ac.l(this.TAG, "", new Object[] { paramaiy });
      AppMethodBeat.o(201434);
    }
  }
  
  public final void a(aiy paramaiy)
  {
    AppMethodBeat.i(165597);
    k.h(paramaiy, "cmdItem");
    int i = paramaiy.cmdId;
    ac.i(this.TAG, "cmdId ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(165597);
      return;
      d(paramaiy);
      AppMethodBeat.o(165597);
      return;
      e(paramaiy);
      AppMethodBeat.o(165597);
      return;
      f(paramaiy);
      AppMethodBeat.o(165597);
      return;
      g(paramaiy);
      AppMethodBeat.o(165597);
      return;
      b(paramaiy);
      AppMethodBeat.o(165597);
      return;
      c(paramaiy);
      AppMethodBeat.o(165597);
      return;
      h(paramaiy);
      AppMethodBeat.o(165597);
      return;
      j(paramaiy);
      AppMethodBeat.o(165597);
      return;
      i(paramaiy);
      AppMethodBeat.o(165597);
      return;
      k(paramaiy);
      AppMethodBeat.o(165597);
      return;
      l(paramaiy);
      AppMethodBeat.o(165597);
      return;
      m(paramaiy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.b
 * JD-Core Version:    0.7.0.1
 */