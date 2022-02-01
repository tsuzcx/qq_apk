package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.extension.reddot.f.aa;
import com.tencent.mm.plugin.finder.extension.reddot.m;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "finderSyncReportHandler", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncReportHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "", "scene", "processFansCount", "processFinderAliasSync", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processObjectWordingConfig", "processPreFetch", "processReInit", "processRevokeRedDot", "processRevokeTabTips", "processSpamObj", "processTabRedDot", "plugin-finder_release"})
public final class d
  implements com.tencent.mm.plugin.finder.api.h
{
  final String TAG;
  private final e xsl;
  
  public d()
  {
    AppMethodBeat.i(277818);
    this.TAG = "Finder.SyncFinderSyncHandler";
    this.xsl = new e();
    AppMethodBeat.o(277818);
  }
  
  private final void a(aqt paramaqt)
  {
    AppMethodBeat.i(165602);
    atg localatg = new atg();
    paramaqt = paramaqt.SDX;
    if (paramaqt != null)
    {
      localatg.parseFrom(paramaqt.toByteArray());
      paramaqt = localatg.SGk;
      p.j(paramaqt, "follower.followers");
      paramaqt = ((Iterable)paramaqt).iterator();
      while (paramaqt.hasNext())
      {
        Object localObject1 = (FinderContact)paramaqt.next();
        Object localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject2 = com.tencent.mm.plugin.finder.api.d.a.aAK(((FinderContact)localObject1).username);
        Log.i(this.TAG, "sync follow contact " + localatg.SGk.size() + "  username=" + ((FinderContact)localObject1).username + " nickname=" + ((FinderContact)localObject1).nickname + " followFlag=" + ((FinderContact)localObject1).followFlag + ' ');
        if (localObject2 != null)
        {
          ((i)localObject2).field_follow_Flag = ((FinderContact)localObject1).followFlag;
          localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
          com.tencent.mm.plugin.finder.api.d.a.d((i)localObject2);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
          p.j(localObject1, "follow");
          com.tencent.mm.plugin.finder.api.d.a.a((FinderContact)localObject1);
        }
      }
      AppMethodBeat.o(165602);
      return;
    }
    AppMethodBeat.o(165602);
  }
  
  public final void a(final aqt paramaqt, int paramInt1, int paramInt2)
  {
    Object localObject5 = null;
    Object localObject6 = null;
    com.tencent.mm.cd.b localb = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject1 = null;
    AppMethodBeat.i(277817);
    p.k(paramaqt, "cmdItem");
    int i = paramaqt.cmdId;
    Log.i(this.TAG, "cmdId ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      this.xsl.a(paramaqt, paramInt1, paramInt2);
      AppMethodBeat.o(277817);
      return;
      localObject5 = new arl();
      localObject6 = paramaqt.SDX;
      if (localObject6 != null) {
        localObject1 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
      }
      ((arl)localObject5).parseFrom((byte[])localObject1);
      Log.i(this.TAG, "redDotEvent new count info, msg count:" + ((arl)localObject5).count + ", normalCount:" + ((arl)localObject5).lYt + ", systemCount:" + ((arl)localObject5).SEv);
      Log.i(this.TAG, "redDotEvent new count info, msg like count:" + ((arl)localObject5).SEq + ", mentioncommentCount:" + ((arl)localObject5).SEr + ", followcount:" + ((arl)localObject5).SEw);
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBo, Integer.valueOf(((arl)localObject5).lYt));
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBp, Integer.valueOf(((arl)localObject5).SEv));
      localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject1).getRedDotManager().af(((arl)localObject5).SEq, ((arl)localObject5).SEr, ((arl)localObject5).SEw);
      if (((arl)localObject5).SEv > 0)
      {
        localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)localObject1).getRedDotManager().xsM.dqu();
        continue;
        a(paramaqt);
        continue;
        localObject5 = new blo();
        localObject1 = paramaqt.SDX;
        if (localObject1 != null) {}
        long l;
        for (localObject1 = ((com.tencent.mm.cd.b)localObject1).toByteArray();; localObject1 = null)
        {
          ((blo)localObject5).parseFrom((byte[])localObject1);
          i = ((blo)localObject5).SEr + ((blo)localObject5).SEq + ((blo)localObject5).SWB + ((blo)localObject5).SWC + ((blo)localObject5).SWD;
          Log.i(this.TAG, "redDotEvent new wx count info, msg count:" + ((blo)localObject5).count + ", comment:" + ((blo)localObject5).SEr + ", like:" + ((blo)localObject5).SEq + ", objectlike_like:" + ((blo)localObject5).SWB + ", objectrecommend_like:" + ((blo)localObject5).SWC + ", follow_accepted_count:" + ((blo)localObject5).SWD + ", headUrl:" + ((blo)localObject5).lqp + " totalCount=" + i);
          if (i > 0)
          {
            localObject1 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAC, Boolean.TRUE);
          }
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAb, Integer.valueOf(((blo)localObject5).SEr));
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAc, Integer.valueOf(((blo)localObject5).SEq));
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAd, Integer.valueOf(((blo)localObject5).SWB));
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAe, Integer.valueOf(((blo)localObject5).SWC));
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAf, Integer.valueOf(((blo)localObject5).SWD));
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAg, ((blo)localObject5).lqp);
          localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
          localObject1 = ((PluginFinder)localObject1).getRedDotManager();
          p.k(localObject5, "wxMention");
          l = cm.bfE();
          localObject6 = m.xuU;
          l -= m.drZ();
          if ((((blo)localObject5).count > 0) || (((blo)localObject5).SWC > 0) || (((blo)localObject5).SWB > 0) || (((blo)localObject5).SEr > 0) || (((blo)localObject5).SEq > 0) || (((blo)localObject5).SWA > 0) || (((blo)localObject5).SWD > 0)) {
            break label1000;
          }
          Log.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
          break;
        }
        label1000:
        Log.i("Finder.RedDotManager", "[notifyWxMentionCount] diffTime=" + l + ' ' + com.tencent.mm.plugin.finder.extension.reddot.f.c(((blo)localObject5).SVk) + " count=" + ((blo)localObject5).count);
        if (l < m.xuU.drS())
        {
          com.tencent.mm.plugin.finder.extension.reddot.f.d(((blo)localObject5).SVk);
          localObject6 = ((blo)localObject5).SVk;
          if (localObject6 != null)
          {
            localObject6 = ((bhw)localObject6).MFx;
            if (localObject6 != null) {
              com.tencent.mm.ae.d.a((LinkedList)localObject6, (kotlin.g.a.b)f.aa.xtE);
            }
          }
        }
        com.tencent.mm.plugin.finder.extension.reddot.f.a((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1, ((blo)localObject5).SVk, "notifyWxMentionCount", null, true, null, null, 52);
        continue;
        com.tencent.mm.ae.d.b("processSpamObj", (kotlin.g.a.a)new a(this, paramaqt));
        continue;
        localObject5 = new aso();
        localObject1 = paramaqt.SDX;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.cd.b)localObject1).toByteArray();; localObject1 = null)
        {
          ((aso)localObject5).parseFrom((byte[])localObject1);
          Log.i(this.TAG, "redDotEvent save svr_fans count " + ((aso)localObject5).fans_count + " svr_fans_add_count:" + ((aso)localObject5).SEu);
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAy, Integer.valueOf(((aso)localObject5).SEu));
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAx, Integer.valueOf(((aso)localObject5).fans_count));
          localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
          localObject1 = ((PluginFinder)localObject1).getRedDotManager();
          i = ((aso)localObject5).SEu;
          if (i > 0) {
            break label1351;
          }
          Log.i("Finder.RedDotManager", "[notifyFinderFansAddCount] server error.");
          break;
        }
        label1351:
        Log.i("Finder.RedDotManager", "[notifyFinderFansAddCount] count = ".concat(String.valueOf(i)));
        localObject5 = new bhw();
        ((bhw)localObject5).SQm = String.valueOf(cm.bfE());
        ((bhw)localObject5).priority = 100000;
        ((bhw)localObject5).type = 2;
        localObject6 = new bkn();
        ((bkn)localObject6).CKC = 2;
        ((bkn)localObject6).SVs = 1;
        ((bkn)localObject6).path = "AuthorProfileFans";
        ((bkn)localObject6).count = i;
        ((bhw)localObject5).MFx.add(localObject6);
        com.tencent.mm.plugin.finder.extension.reddot.f.a((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1, (bhw)localObject5, "notifyFinderFansAddCount", null, true, null, null, 52);
        continue;
        localObject6 = new ata();
        localb = paramaqt.SDX;
        localObject1 = localObject5;
        if (localb != null) {
          localObject1 = localb.toByteArray();
        }
        ((ata)localObject6).parseFrom((byte[])localObject1);
        Log.i(this.TAG, "save svr_follow count " + ((ata)localObject6).SEt);
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAv, Integer.valueOf(((ata)localObject6).SEt));
        continue;
        localObject5 = new bfn();
        if (paramaqt.SDX != null)
        {
          localb = paramaqt.SDX;
          localObject1 = localObject6;
          if (localb != null) {
            localObject1 = localb.toByteArray();
          }
          ((bfn)localObject5).parseFrom((byte[])localObject1);
          Log.i(this.TAG, "processNotInterestedConfig config:" + ((bfn)localObject5).SqO);
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAs, Util.encodeHexString(((bfn)localObject5).toByteArray()));
          continue;
          localObject5 = new bhv();
          localObject6 = paramaqt.SDX;
          localObject1 = localb;
          if (localObject6 != null) {
            localObject1 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
          }
          ((bhv)localObject5).parseFrom((byte[])localObject1);
          Log.i(this.TAG, "redDotEvent get red dot, showRed:" + ((bhv)localObject5).SSi);
          localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)localObject1).getRedDotManager().a((bhv)localObject5);
          continue;
          Log.i(this.TAG, "[processReInit] ...");
          localObject1 = new bho();
          localObject5 = paramaqt.SDX;
          if (localObject5 != null)
          {
            ((bho)localObject1).parseFrom(((com.tencent.mm.cd.b)localObject5).toByteArray());
            if (((bho)localObject1).SSe != 0)
            {
              com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 20L, 1L);
              localObject5 = ((bho)localObject1).SSd;
              p.j(localObject5, "newSelf.self");
              if (!((Collection)localObject5).isEmpty())
              {
                i = 1;
                label1872:
                if (i == 0) {
                  break label2101;
                }
                Log.i(this.TAG, "replace new finder username %s", new Object[] { ((FinderContact)((bho)localObject1).SSd.get(0)).username });
                localObject5 = com.tencent.mm.kernel.h.aHG();
                p.j(localObject5, "MMKernel.storage()");
                ((com.tencent.mm.kernel.f)localObject5).aHp().set(ar.a.VAF, ((FinderContact)((bho)localObject1).SSd.get(0)).username);
              }
              for (;;)
              {
                localObject5 = com.tencent.mm.kernel.h.aHG();
                p.j(localObject5, "MMKernel.storage()");
                ((com.tencent.mm.kernel.f)localObject5).aHp().set(ar.a.VAE, Integer.valueOf(((bho)localObject1).SDr));
                localObject5 = com.tencent.mm.kernel.h.aHG();
                p.j(localObject5, "MMKernel.storage()");
                i = ((com.tencent.mm.kernel.f)localObject5).aHp().getInt(ar.a.VAG, 0);
                Log.i(this.TAG, "[processReInit] userVersion=" + i + " userVersion=" + ((bho)localObject1).SDr);
                if ((i == ((bho)localObject1).SDr) || (((bho)localObject1).SDr == 0)) {
                  break;
                }
                localObject1 = com.tencent.mm.kernel.h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAH, Integer.valueOf(1));
                break;
                i = 0;
                break label1872;
                label2101:
                localObject5 = com.tencent.mm.kernel.h.aHG();
                p.j(localObject5, "MMKernel.storage()");
                ((com.tencent.mm.kernel.f)localObject5).aHp().set(ar.a.VAF, "");
              }
              localObject5 = new bhf();
              localObject6 = paramaqt.SDX;
              localObject1 = localObject7;
              if (localObject6 != null) {
                localObject1 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
              }
              ((bhf)localObject5).parseFrom((byte[])localObject1);
              Log.i(this.TAG, "processPreFetch needPrefetch:" + ((bhf)localObject5).SRK + " needShowRedDot:" + ((bhf)localObject5).SRL);
              continue;
              localObject5 = new bke();
              localObject6 = paramaqt.SDX;
              localObject1 = localObject8;
              if (localObject6 != null) {
                localObject1 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
              }
              ((bke)localObject5).parseFrom((byte[])localObject1);
              localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
              p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
              ((PluginFinder)localObject1).getRedDotManager().a((bke)localObject5, "processTabRedDot");
              continue;
              try
              {
                localObject5 = new big();
                localObject6 = paramaqt.SDX;
                localObject1 = localObject9;
                if (localObject6 != null) {
                  localObject1 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
                }
                ((big)localObject5).parseFrom((byte[])localObject1);
                localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
                p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder)localObject1).getRedDotManager().a((big)localObject5);
              }
              catch (Exception localException1)
              {
                Log.printDebugStack(this.TAG, "", new Object[] { localException1 });
              }
              continue;
              try
              {
                localObject5 = new bie();
                localObject6 = paramaqt.SDX;
                Object localObject2 = localObject10;
                if (localObject6 != null) {
                  localObject2 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
                }
                ((bie)localObject5).parseFrom((byte[])localObject2);
                localObject2 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
                p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder)localObject2).getRedDotManager().a((bie)localObject5);
              }
              catch (Exception localException2)
              {
                Log.printDebugStack(this.TAG, "", new Object[] { localException2 });
              }
              continue;
              try
              {
                localObject5 = new bga();
                localObject6 = paramaqt.SDX;
                Object localObject3 = localObject11;
                if (localObject6 != null) {
                  localObject3 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
                }
                ((bga)localObject5).parseFrom((byte[])localObject3);
                localObject3 = g.AnT;
                g.a((bga)localObject5);
              }
              catch (Exception localException3)
              {
                Log.printDebugStack(this.TAG, "", new Object[] { localException3 });
              }
              continue;
              localObject5 = new axc();
              localObject6 = paramaqt.SDX;
              Object localObject4 = localObject12;
              if (localObject6 != null) {
                localObject4 = ((com.tencent.mm.cd.b)localObject6).toByteArray();
              }
              ((axc)localObject5).parseFrom((byte[])localObject4);
              aj.a(aj.AGc, (axc)localObject5, "FinderSyncHandler");
            }
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(d paramd, aqt paramaqt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.d
 * JD-Core Version:    0.7.0.1
 */