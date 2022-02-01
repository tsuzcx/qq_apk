package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.extension.reddot.f.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "finderSyncReportHandler", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncReportHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "", "scene", "processFansCount", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processObjectWordingConfig", "processPreFetch", "processReInit", "processRevokeRedDot", "processRevokeTabTips", "processSpamObj", "processTabRedDot", "plugin-finder_release"})
public final class b
  implements com.tencent.mm.plugin.finder.api.f
{
  final String TAG;
  private final c tJc;
  
  public b()
  {
    AppMethodBeat.i(243483);
    this.TAG = "Finder.SyncFinderSyncHandler";
    this.tJc = new c();
    AppMethodBeat.o(243483);
  }
  
  private final void a(apf paramapf)
  {
    AppMethodBeat.i(165602);
    ark localark = new ark();
    paramapf = paramapf.LBo;
    if (paramapf != null)
    {
      localark.parseFrom(paramapf.toByteArray());
      paramapf = localark.LCY;
      p.g(paramapf, "follower.followers");
      paramapf = ((Iterable)paramapf).iterator();
      while (paramapf.hasNext())
      {
        Object localObject1 = (FinderContact)paramapf.next();
        Object localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject2 = c.a.asG(((FinderContact)localObject1).username);
        Log.i(this.TAG, "sync follow contact " + localark.LCY.size() + "  username=" + ((FinderContact)localObject1).username + " nickname=" + ((FinderContact)localObject1).nickname + " followFlag=" + ((FinderContact)localObject1).followFlag + ' ');
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.api.g)localObject2).field_follow_Flag = ((FinderContact)localObject1).followFlag;
          localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
          c.a.d((com.tencent.mm.plugin.finder.api.g)localObject2);
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
          p.g(localObject1, "follow");
          c.a.a((FinderContact)localObject1);
        }
      }
      AppMethodBeat.o(165602);
      return;
    }
    AppMethodBeat.o(165602);
  }
  
  public final void a(final apf paramapf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243482);
    p.h(paramapf, "cmdItem");
    int i = paramapf.cmdId;
    Log.i(this.TAG, "cmdId ".concat(String.valueOf(i)));
    Object localObject5;
    Object localObject1;
    label163:
    label459:
    label1272:
    Object localObject2;
    label1622:
    label2148:
    label2660:
    Object localObject3;
    switch (i)
    {
    case 102: 
    case 111: 
    case 115: 
    default: 
    case 101: 
    case 103: 
    case 108: 
    case 107: 
    case 106: 
    case 105: 
    case 109: 
    case 104: 
    case 110: 
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              this.tJc.a(paramapf, paramInt1, paramInt2);
              AppMethodBeat.o(243482);
              return;
              localObject5 = new apx();
              localObject1 = paramapf.LBo;
              int j;
              int k;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();
                ((apx)localObject5).parseFrom((byte[])localObject1);
                Log.i(this.TAG, "redDotEvent new count info, msg count:" + ((apx)localObject5).count + ", normalCount:" + ((apx)localObject5).jhQ + ", systemCount:" + ((apx)localObject5).LBK);
                Log.i(this.TAG, "redDotEvent new count info, msg like count:" + ((apx)localObject5).LBF + ", mentioncommentCount:" + ((apx)localObject5).LBG + ", followcount:" + ((apx)localObject5).LBL);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Omr, Integer.valueOf(((apx)localObject5).jhQ));
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Oms, Integer.valueOf(((apx)localObject5).LBK));
                localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                localObject1 = ((PluginFinder)localObject1).getRedDotManager();
                i = ((apx)localObject5).LBF;
                j = ((apx)localObject5).LBG;
                k = ((apx)localObject5).LBL;
                if ((i > 0) || (j > 0) || (k > 0)) {
                  break label459;
                }
                Log.i("Finder.RedDotManager", "[notifyFinderMsgCount] server error.");
              }
              while (((apx)localObject5).LBK > 0)
              {
                localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder)localObject1).getRedDotManager().tJB.dau();
                break;
                localObject1 = null;
                break label163;
                localObject6 = new bbi();
                ((bbi)localObject6).LKM = String.valueOf(cl.aWA());
                ((bbi)localObject6).priority = 100000;
                ((bbi)localObject6).type = 2;
                bdo localbdo = new bdo();
                localbdo.xGz = 2;
                localbdo.LNm = 1;
                localbdo.path = "AuthorProfileNotify";
                localbdo.count = (i + j + k);
                ((bbi)localObject6).GaM.add(localbdo);
                if (i > 0)
                {
                  localbdo = new bdo();
                  localbdo.xGz = 2;
                  localbdo.LNm = 1;
                  localbdo.path = "NotificationCenterLike";
                  localbdo.count = i;
                  ((bbi)localObject6).GaM.add(localbdo);
                }
                if (j > 0)
                {
                  localbdo = new bdo();
                  localbdo.xGz = 2;
                  localbdo.LNm = 1;
                  localbdo.path = "NotificationCenterComment";
                  localbdo.count = j;
                  ((bbi)localObject6).GaM.add(localbdo);
                }
                if (k > 0)
                {
                  localbdo = new bdo();
                  localbdo.xGz = 2;
                  localbdo.LNm = 1;
                  localbdo.path = "NotificationCenterFollow";
                  localbdo.count = k;
                  ((bbi)localObject6).GaM.add(localbdo);
                }
                ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1).a((bbi)localObject6);
                com.tencent.mm.plugin.finder.extension.reddot.f.a((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1, (bbi)localObject6, "notifyFinderTabMsgCount", null, false, null, 28);
              }
              a(paramapf);
              continue;
              localObject5 = new bem();
              localObject1 = paramapf.LBo;
              if (localObject1 != null) {}
              long l;
              for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
              {
                ((bem)localObject5).parseFrom((byte[])localObject1);
                i = ((bem)localObject5).LBG + ((bem)localObject5).LBF + ((bem)localObject5).LOi + ((bem)localObject5).LOj + ((bem)localObject5).LOk;
                Log.i(this.TAG, "redDotEvent new wx count info, msg count:" + ((bem)localObject5).count + ", comment:" + ((bem)localObject5).LBG + ", like:" + ((bem)localObject5).LBF + ", objectlike_like:" + ((bem)localObject5).LOi + ", objectrecommend_like:" + ((bem)localObject5).LOj + ", follow_accepted_count:" + ((bem)localObject5).LOk + ", headUrl:" + ((bem)localObject5).iAR + " totalCount=" + i);
                if (i > 0)
                {
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  ((e)localObject1).azQ().set(ar.a.OlH, Boolean.TRUE);
                }
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Olg, Integer.valueOf(((bem)localObject5).LBG));
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Olh, Integer.valueOf(((bem)localObject5).LBF));
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Oli, Integer.valueOf(((bem)localObject5).LOi));
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Olj, Integer.valueOf(((bem)localObject5).LOj));
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Olk, Integer.valueOf(((bem)localObject5).LOk));
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.Oll, ((bem)localObject5).iAR);
                localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                localObject1 = ((PluginFinder)localObject1).getRedDotManager();
                p.h(localObject5, "wxMention");
                l = cl.aWA();
                localObject6 = com.tencent.mm.plugin.finder.extension.reddot.l.tLu;
                l -= com.tencent.mm.plugin.finder.extension.reddot.l.dbO();
                if ((((bem)localObject5).count > 0) || (((bem)localObject5).LOj > 0) || (((bem)localObject5).LOi > 0) || (((bem)localObject5).LBG > 0) || (((bem)localObject5).LBF > 0) || (((bem)localObject5).LOh > 0) || (((bem)localObject5).LOk > 0)) {
                  break label1272;
                }
                Log.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
                break;
              }
              Log.i("Finder.RedDotManager", "[notifyWxMentionCount] diffTime=" + l + ' ' + com.tencent.mm.plugin.finder.extension.reddot.f.c(((bem)localObject5).LNi) + " count=" + ((bem)localObject5).count);
              if (l < com.tencent.mm.plugin.finder.extension.reddot.l.tLu.dbH())
              {
                com.tencent.mm.plugin.finder.extension.reddot.f.d(((bem)localObject5).LNi);
                localObject6 = ((bem)localObject5).LNi;
                if (localObject6 != null)
                {
                  localObject6 = ((bbi)localObject6).GaM;
                  if (localObject6 != null) {
                    d.a((LinkedList)localObject6, (kotlin.g.a.b)f.t.tKj);
                  }
                }
              }
              com.tencent.mm.plugin.finder.extension.reddot.f.a((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1, ((bem)localObject5).LNi, "notifyWxMentionCount", null, true, null, 20);
              continue;
              d.b("processSpamObj", (kotlin.g.a.a)new a(this, paramapf));
              continue;
              localObject5 = new aqs();
              localObject1 = paramapf.LBo;
              if (localObject1 != null) {}
              for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
              {
                ((aqs)localObject5).parseFrom((byte[])localObject1);
                Log.i(this.TAG, "redDotEvent save svr_fans count " + ((aqs)localObject5).LAB + " svr_fans_add_count:" + ((aqs)localObject5).LBJ);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.OlD, Integer.valueOf(((aqs)localObject5).LBJ));
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((e)localObject1).azQ().set(ar.a.OlC, Integer.valueOf(((aqs)localObject5).LAB));
                localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
                localObject1 = ((PluginFinder)localObject1).getRedDotManager();
                i = ((aqs)localObject5).LBJ;
                if (i > 0) {
                  break label1622;
                }
                Log.i("Finder.RedDotManager", "[notifyFinderFansAddCount] server error.");
                break;
              }
              Log.i("Finder.RedDotManager", "[notifyFinderFansAddCount] count = ".concat(String.valueOf(i)));
              localObject5 = new bbi();
              ((bbi)localObject5).LKM = String.valueOf(cl.aWA());
              ((bbi)localObject5).priority = 100000;
              ((bbi)localObject5).type = 2;
              Object localObject6 = new bdo();
              ((bdo)localObject6).xGz = 2;
              ((bdo)localObject6).LNm = 1;
              ((bdo)localObject6).path = "AuthorProfileFans";
              ((bdo)localObject6).count = i;
              ((bbi)localObject5).GaM.add(localObject6);
              com.tencent.mm.plugin.finder.extension.reddot.f.a((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1, (bbi)localObject5, "notifyFinderFansAddCount", null, true, null, 20);
            }
            localObject5 = new are();
            localObject1 = paramapf.LBo;
            if (localObject1 != null) {}
            for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
            {
              ((are)localObject5).parseFrom((byte[])localObject1);
              Log.i(this.TAG, "save svr_follow count " + ((are)localObject5).LBI);
              localObject1 = com.tencent.mm.kernel.g.aAh();
              p.g(localObject1, "MMKernel.storage()");
              ((e)localObject1).azQ().set(ar.a.OlA, Integer.valueOf(((are)localObject5).LBI));
              break;
            }
            localObject5 = new azo();
          } while (paramapf.LBo == null);
          localObject1 = paramapf.LBo;
          if (localObject1 != null) {}
          for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
          {
            ((azo)localObject5).parseFrom((byte[])localObject1);
            Log.i(this.TAG, "processNotInterestedConfig config:" + ((azo)localObject5).Lps);
            localObject1 = com.tencent.mm.kernel.g.aAh();
            p.g(localObject1, "MMKernel.storage()");
            ((e)localObject1).azQ().set(ar.a.Olx, Util.encodeHexString(((azo)localObject5).toByteArray()));
            break;
          }
          localObject5 = new bbh();
          localObject1 = paramapf.LBo;
          if (localObject1 != null) {}
          for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
          {
            ((bbh)localObject5).parseFrom((byte[])localObject1);
            Log.i(this.TAG, "redDotEvent get red dot, showRed:" + ((bbh)localObject5).LKI);
            localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder)localObject1).getRedDotManager().a((bbh)localObject5);
            break;
          }
          Log.i(this.TAG, "[processReInit] ...");
          localObject1 = new bba();
          localObject5 = paramapf.LBo;
        } while (localObject5 == null);
        ((bba)localObject1).parseFrom(((com.tencent.mm.bw.b)localObject5).toByteArray());
      } while (((bba)localObject1).LKF == 0);
      h.CyF.n(1279L, 20L, 1L);
      localObject5 = ((bba)localObject1).LKE;
      p.g(localObject5, "newSelf.self");
      if (!((Collection)localObject5).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label2377;
        }
        Log.i(this.TAG, "replace new finder username %s", new Object[] { ((FinderContact)((bba)localObject1).LKE.get(0)).username });
        localObject5 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject5, "MMKernel.storage()");
        ((e)localObject5).azQ().set(ar.a.OlK, ((FinderContact)((bba)localObject1).LKE.get(0)).username);
      }
      for (;;)
      {
        localObject5 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject5, "MMKernel.storage()");
        ((e)localObject5).azQ().set(ar.a.OlJ, Integer.valueOf(((bba)localObject1).LAQ));
        localObject5 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject5, "MMKernel.storage()");
        i = ((e)localObject5).azQ().getInt(ar.a.OlL, 0);
        Log.i(this.TAG, "[processReInit] userVersion=" + i + " userVersion=" + ((bba)localObject1).LAQ);
        if ((i == ((bba)localObject1).LAQ) || (((bba)localObject1).LAQ == 0)) {
          break;
        }
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((e)localObject1).azQ().set(ar.a.OlM, Integer.valueOf(1));
        break;
        i = 0;
        break label2148;
        localObject5 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject5, "MMKernel.storage()");
        ((e)localObject5).azQ().set(ar.a.OlK, "");
      }
    case 112: 
      localObject5 = new bau();
      localObject1 = paramapf.LBo;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
      {
        ((bau)localObject5).parseFrom((byte[])localObject1);
        Log.i(this.TAG, "processPreFetch needPrefetch:" + ((bau)localObject5).LKq + " needShowRedDot:" + ((bau)localObject5).LKr);
        break;
      }
    case 113: 
      localObject5 = new bdh();
      localObject1 = paramapf.LBo;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
      {
        ((bdh)localObject5).parseFrom((byte[])localObject1);
        localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)localObject1).getRedDotManager().a((bdh)localObject5, "processTabRedDot");
        break;
      }
    case 114: 
      for (;;)
      {
        try
        {
          localObject5 = new bbq();
          localObject1 = paramapf.LBo;
          if (localObject1 == null) {
            break label2660;
          }
          localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();
          ((bbq)localObject5).parseFrom((byte[])localObject1);
          localObject1 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
          p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)localObject1).getRedDotManager().a((bbq)localObject5);
        }
        catch (Exception localException1)
        {
          Log.printDebugStack(this.TAG, "", new Object[] { localException1 });
        }
        break;
        localObject2 = null;
      }
    case 117: 
      for (;;)
      {
        try
        {
          label2377:
          localObject5 = new bbo();
          localObject2 = paramapf.LBo;
          if (localObject2 == null) {
            break label2757;
          }
          localObject2 = ((com.tencent.mm.bw.b)localObject2).toByteArray();
          ((bbo)localObject5).parseFrom((byte[])localObject2);
          localObject2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
          p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)localObject2).getRedDotManager().a((bbo)localObject5);
        }
        catch (Exception localException2)
        {
          Log.printDebugStack(this.TAG, "", new Object[] { localException2 });
        }
        break;
        label2757:
        localObject3 = null;
      }
    }
    for (;;)
    {
      try
      {
        localObject5 = new azv();
        localObject3 = paramapf.LBo;
        if (localObject3 == null) {
          break label2835;
        }
        localObject3 = ((com.tencent.mm.bw.b)localObject3).toByteArray();
        ((azv)localObject5).parseFrom((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        com.tencent.mm.plugin.finder.storage.logic.g.a((azv)localObject5);
      }
      catch (Exception localException3)
      {
        Log.printDebugStack(this.TAG, "", new Object[] { localException3 });
      }
      break;
      label2835:
      Object localObject4 = null;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(b paramb, apf paramapf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.b
 * JD-Core Version:    0.7.0.1
 */