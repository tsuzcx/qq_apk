package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.a.jp;
import com.tencent.mm.autogen.a.jp.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.k;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "finderSyncReportHandler", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncReportHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "", "scene", "processFansCount", "processFinderAliasSync", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processObjectWordingConfig", "processPreFetch", "processReInit", "processRevokeRedDot", "processRevokeTabTips", "processSpamObj", "processTabRedDot", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements k
{
  private final e APv;
  final String TAG;
  
  public d()
  {
    AppMethodBeat.i(366635);
    this.TAG = "Finder.SyncFinderSyncHandler";
    this.APv = new e();
    AppMethodBeat.o(366635);
  }
  
  private final void a(auw paramauw)
  {
    AppMethodBeat.i(165598);
    axd localaxd = new axd();
    paramauw = paramauw.ZFn;
    if (paramauw == null) {}
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localaxd.parseFrom(paramauw);
      Log.i(this.TAG, "redDotEvent save svr_fans count " + localaxd.fans_count + " svr_fans_add_count:" + localaxd.ZFU);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcQ, Integer.valueOf(localaxd.ZFU));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcP, Integer.valueOf(localaxd.fans_count));
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Nt(localaxd.ZFU);
      AppMethodBeat.o(165598);
      return;
    }
  }
  
  private final void a(auw paramauw, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(366698);
    long l = Util.currentTicks();
    Object localObject2 = new jp();
    ((jp)localObject2).hLg.hLi = paramauw;
    ((jp)localObject2).hLg.scene = paramInt;
    ((jp)localObject2).publish();
    Log.i(this.TAG, "process tab red dot scene:" + paramInt + " isHitExpt:" + ((jp)localObject2).hLh.hLj + " cost:" + Util.ticksToNow(l));
    if (!((jp)localObject2).hLh.hLj)
    {
      localObject2 = new bxh();
      if (paramauw.ZFn != null)
      {
        paramauw = paramauw.ZFn;
        if (paramauw == null) {}
        for (paramauw = localObject1;; paramauw = paramauw.toByteArray())
        {
          ((bxh)localObject2).parseFrom(paramauw);
          ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().a((bxh)localObject2, "processTabRedDot", paramInt);
          AppMethodBeat.o(366698);
          return;
        }
      }
      e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "FinderTabTips_Null", false, null, false, null, 60);
    }
    AppMethodBeat.o(366698);
  }
  
  private final void b(auw paramauw)
  {
    AppMethodBeat.i(165599);
    axo localaxo = new axo();
    paramauw = paramauw.ZFn;
    if (paramauw == null) {}
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localaxo.parseFrom(paramauw);
      Log.i(this.TAG, s.X("save svr_follow count ", Integer.valueOf(localaxo.ZFT)));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcN, Integer.valueOf(localaxo.ZFT));
      AppMethodBeat.o(165599);
      return;
    }
  }
  
  private final void c(auw paramauw)
  {
    AppMethodBeat.i(165600);
    avu localavu = new avu();
    paramauw = paramauw.ZFn;
    if (paramauw == null) {}
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localavu.parseFrom(paramauw);
      Log.i(this.TAG, "redDotEvent new count info, msg count:" + localavu.count + ", normalCount:" + localavu.oRy + ", systemCount:" + localavu.ZFV);
      Log.i(this.TAG, "redDotEvent new count info, msg like count:" + localavu.ZFQ + ", mentioncommentCount:" + localavu.ZFR + ", followcount:" + localavu.ZFW);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addK, Integer.valueOf(localavu.oRy));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addL, Integer.valueOf(localavu.ZFV));
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().aw(localavu.ZFQ, localavu.ZFR, localavu.ZFW);
      if (localavu.ZFV > 0) {
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQv.dZb();
      }
      AppMethodBeat.o(165600);
      return;
    }
  }
  
  private final void d(auw paramauw)
  {
    AppMethodBeat.i(165601);
    Object localObject1 = new axu();
    paramauw = paramauw.ZFn;
    if (paramauw != null)
    {
      ((axu)localObject1).parseFrom(paramauw.toByteArray());
      paramauw = ((axu)localObject1).ZIU;
      s.s(paramauw, "follower.followers");
      paramauw = (Iterable)paramauw;
      int i = 0;
      paramauw = paramauw.iterator();
      while (paramauw.hasNext())
      {
        localObject1 = paramauw.next();
        int j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        localObject1 = (FinderContact)localObject1;
        Object localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
        localObject2 = com.tencent.mm.plugin.finder.api.d.a.auT(((FinderContact)localObject1).username);
        Log.i(this.TAG, "sync follow contact index=" + i + " username=" + ((FinderContact)localObject1).username + " nickname=" + ((FinderContact)localObject1).nickname + " followFlag=" + ((FinderContact)localObject1).followFlag + " user_flag=" + ((FinderContact)localObject1).user_flag + " avatarUrl=" + ((FinderContact)localObject1).headUrl);
        if (localObject2 != null)
        {
          ((m)localObject2).field_nickname = ((FinderContact)localObject1).nickname;
          ((m)localObject2).field_user_flag = ((FinderContact)localObject1).user_flag;
          ((m)localObject2).field_follow_Flag = ((FinderContact)localObject1).followFlag;
          ((m)localObject2).field_authInfo = ((FinderContact)localObject1).authInfo;
          ((m)localObject2).field_avatarUrl = ((FinderContact)localObject1).headUrl;
          localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
          com.tencent.mm.plugin.finder.api.d.a.e((m)localObject2);
          i = j;
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
          s.s(localObject1, "follow");
          com.tencent.mm.plugin.finder.api.d.a.d((FinderContact)localObject1);
          i = j;
        }
      }
    }
    AppMethodBeat.o(165601);
  }
  
  private final void e(auw paramauw)
  {
    AppMethodBeat.i(165602);
    bze localbze = new bze();
    paramauw = paramauw.ZFn;
    if (paramauw == null) {}
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localbze.parseFrom(paramauw);
      int i = localbze.ZFR + localbze.ZFQ + localbze.aain + localbze.aaio + localbze.aaip;
      Log.i(this.TAG, "redDotEvent new wx count info, msg count:" + localbze.count + ", comment:" + localbze.ZFR + ", like:" + localbze.ZFQ + ", objectlike_like:" + localbze.aain + ", objectrecommend_like:" + localbze.aaio + ", follow_accepted_count:" + localbze.aaip + ", headUrl:" + localbze.nVs + " totalCount=" + i + " mentionMentionedCount:" + localbze.aair);
      if (i > 0) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adcU, Boolean.TRUE);
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcq, Integer.valueOf(localbze.ZFR));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcs, Integer.valueOf(localbze.ZFQ));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adct, Integer.valueOf(localbze.aain));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcu, Integer.valueOf(localbze.aaio));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcv, Integer.valueOf(localbze.aaip));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcw, Integer.valueOf(localbze.aair));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcx, localbze.nVs);
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().a(localbze);
      paramauw = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
      i = localbze.ZFQ;
      int j = localbze.aain;
      int k = localbze.aaio;
      int m = localbze.ZFR;
      paramauw.hs(i + j + k, localbze.aair + m);
      AppMethodBeat.o(165602);
      return;
    }
  }
  
  private final void f(auw paramauw)
  {
    AppMethodBeat.i(165603);
    com.tencent.mm.ae.d.d("processSpamObj", (a)new a(paramauw, this));
    AppMethodBeat.o(165603);
  }
  
  private final void g(auw paramauw)
  {
    AppMethodBeat.i(165604);
    bqu localbqu = new bqu();
    if (paramauw.ZFn != null)
    {
      paramauw = paramauw.ZFn;
      if (paramauw != null) {
        break label81;
      }
    }
    label81:
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localbqu.parseFrom(paramauw);
      Log.i(this.TAG, s.X("processNotInterestedConfig config:", localbqu.ZpP));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcJ, Util.encodeHexString(localbqu.toByteArray()));
      AppMethodBeat.o(165604);
      return;
    }
  }
  
  private final void h(auw paramauw)
  {
    AppMethodBeat.i(165605);
    Log.i(this.TAG, "[processReInit] ...");
    bto localbto = new bto();
    paramauw = paramauw.ZFn;
    int i;
    if (paramauw != null)
    {
      localbto.parseFrom(paramauw.toByteArray());
      if (localbto.aabs != 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 20L, 1L);
        paramauw = localbto.aabr;
        s.s(paramauw, "newSelf.self");
        if (((Collection)paramauw).isEmpty()) {
          break label257;
        }
        i = 1;
        if (i == 0) {
          break label262;
        }
        Log.i(this.TAG, "replace new finder username %s", new Object[] { ((FinderContact)localbto.aabr.get(0)).username });
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adcX, ((FinderContact)localbto.aabr.get(0)).username);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcW, Integer.valueOf(localbto.ZEp));
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcY, 0);
      Log.i(this.TAG, "[processReInit] userVersion=" + i + " userVersion=" + localbto.ZEp);
      if ((i != localbto.ZEp) && (localbto.ZEp != 0)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adcZ, Integer.valueOf(1));
      }
      AppMethodBeat.o(165605);
      return;
      label257:
      i = 0;
      break;
      label262:
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcX, "");
    }
  }
  
  private final void i(auw paramauw)
  {
    AppMethodBeat.i(165606);
    btv localbtv = new btv();
    paramauw = paramauw.ZFn;
    if (paramauw == null) {}
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localbtv.parseFrom(paramauw);
      Log.i(this.TAG, s.X("redDotEvent get red dot, showRed:", Integer.valueOf(localbtv.aabw)));
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().a(localbtv);
      AppMethodBeat.o(165606);
      return;
    }
  }
  
  private final void j(auw paramauw)
  {
    AppMethodBeat.i(178142);
    bta localbta = new bta();
    paramauw = paramauw.ZFn;
    if (paramauw == null) {}
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localbta.parseFrom(paramauw);
      Log.i(this.TAG, "processPreFetch needPrefetch:" + localbta.aaaJ + " needShowRedDot:" + localbta.aaaK);
      AppMethodBeat.o(178142);
      return;
    }
  }
  
  private final void k(auw paramauw)
  {
    AppMethodBeat.i(366703);
    try
    {
      bul localbul = new bul();
      paramauw = paramauw.ZFn;
      if (paramauw == null) {}
      for (paramauw = null;; paramauw = paramauw.toByteArray())
      {
        localbul.parseFrom(paramauw);
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().a(localbul);
        AppMethodBeat.o(366703);
        return;
      }
      return;
    }
    catch (Exception paramauw)
    {
      Log.printDebugStack(this.TAG, "", new Object[] { paramauw });
      AppMethodBeat.o(366703);
    }
  }
  
  private final void l(auw paramauw)
  {
    AppMethodBeat.i(366710);
    try
    {
      buj localbuj = new buj();
      paramauw = paramauw.ZFn;
      if (paramauw == null) {}
      for (paramauw = null;; paramauw = paramauw.toByteArray())
      {
        localbuj.parseFrom(paramauw);
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().a(localbuj);
        AppMethodBeat.o(366710);
        return;
      }
      return;
    }
    catch (Exception paramauw)
    {
      Log.printDebugStack(this.TAG, "", new Object[] { paramauw });
      AppMethodBeat.o(366710);
    }
  }
  
  private final void m(auw paramauw)
  {
    AppMethodBeat.i(366716);
    try
    {
      brl localbrl = new brl();
      paramauw = paramauw.ZFn;
      if (paramauw == null) {}
      for (paramauw = null;; paramauw = paramauw.toByteArray())
      {
        localbrl.parseFrom(paramauw);
        paramauw = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
        com.tencent.mm.plugin.finder.storage.logic.h.a(localbrl);
        AppMethodBeat.o(366716);
        return;
      }
      return;
    }
    catch (Exception paramauw)
    {
      Log.printDebugStack(this.TAG, "", new Object[] { paramauw });
      AppMethodBeat.o(366716);
    }
  }
  
  private static void n(auw paramauw)
  {
    AppMethodBeat.i(366723);
    bcz localbcz = new bcz();
    paramauw = paramauw.ZFn;
    if (paramauw == null) {}
    for (paramauw = null;; paramauw = paramauw.toByteArray())
    {
      localbcz.parseFrom(paramauw);
      av.a(av.GiL, localbcz, "FinderSyncHandler");
      AppMethodBeat.o(366723);
      return;
    }
  }
  
  public final void a(auw paramauw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(366732);
    s.u(paramauw, "cmdItem");
    int i = paramauw.cmdId;
    Log.i(this.TAG, s.X("cmdId ", Integer.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      this.APv.a(paramauw, paramInt1, paramInt2);
      AppMethodBeat.o(366732);
      return;
      c(paramauw);
      continue;
      d(paramauw);
      continue;
      e(paramauw);
      continue;
      f(paramauw);
      continue;
      a(paramauw);
      continue;
      b(paramauw);
      continue;
      g(paramauw);
      continue;
      i(paramauw);
      continue;
      h(paramauw);
      continue;
      j(paramauw);
      continue;
      a(paramauw, paramInt2);
      continue;
      k(paramauw);
      continue;
      l(paramauw);
      continue;
      m(paramauw);
      continue;
      n(paramauw);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(auw paramauw, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.d
 * JD-Core Version:    0.7.0.1
 */