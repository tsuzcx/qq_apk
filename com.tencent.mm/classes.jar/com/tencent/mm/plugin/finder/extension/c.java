package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.api.g.a;
import com.tencent.mm.plugin.finder.cgi.cm;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.r;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Triple;", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "unregister", "Companion", "SyncArgs", "plugin-finder_release"})
public final class c
  implements i, g
{
  private static final String TAG = "Finder.SyncExtension";
  private static final SparseArray<HashSet<com.tencent.mm.plugin.finder.api.h>> xsc;
  private static final d xsd;
  private static HashSet<Integer> xse;
  public static final a xsf;
  private final ConcurrentLinkedQueue<r<Integer, Integer, b>> xrV;
  private int xrW;
  private int xrX;
  private final int xrY;
  private final int xrZ;
  private final MMHandler xsa;
  private final Runnable xsb;
  
  static
  {
    AppMethodBeat.i(165595);
    xsf = new a((byte)0);
    TAG = "Finder.SyncExtension";
    xsc = new SparseArray();
    xsd = new d();
    xse = new HashSet();
    AppMethodBeat.o(165595);
  }
  
  public c()
  {
    AppMethodBeat.i(165594);
    this.xrV = new ConcurrentLinkedQueue();
    this.xrY = 3;
    this.xrZ = 666;
    this.xsa = new MMHandler("finder_sync_thread", (MMHandler.Callback)new c(this));
    this.xsb = ((Runnable)new d(this));
    AppMethodBeat.o(165594);
  }
  
  private static String Ml(int paramInt)
  {
    AppMethodBeat.i(165587);
    Object localObject = new StringBuffer();
    o[] arrayOfo = g.a.dnm();
    int j = arrayOfo.length;
    int i = 0;
    while (i < j)
    {
      o localo = arrayOfo[i];
      if ((((Number)localo.Mx).intValue() & paramInt) != 0) {
        ((StringBuffer)localObject).append((String)localo.My + " ,");
      }
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    p.j(localObject, "buf.toString()");
    AppMethodBeat.o(165587);
    return localObject;
  }
  
  private final void dqq()
  {
    AppMethodBeat.i(290216);
    this.xsa.sendEmptyMessage(this.xrZ);
    AppMethodBeat.o(290216);
  }
  
  private final void dqr()
  {
    AppMethodBeat.i(165591);
    if (this.xrX >= this.xrY) {
      Log.i(TAG, "checkLoop finderAliveUI " + xse.size() + " sync_fail_count " + this.xrX + " so ignore checkloop");
    }
    if (xse.size() > 0)
    {
      this.xsa.removeCallbacks(this.xsb);
      MMHandler localMMHandler = this.xsa;
      Runnable localRunnable = this.xsb;
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      localMMHandler.postDelayed(localRunnable, com.tencent.mm.plugin.finder.storage.d.dSq());
    }
    AppMethodBeat.o(165591);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.api.h paramh)
  {
    AppMethodBeat.i(165589);
    p.k(paramh, "handler");
    if ((HashSet)xsc.get(paramInt) == null)
    {
      xsc.append(paramInt, new HashSet());
      x localx = x.aazN;
    }
    ((HashSet)xsc.get(paramInt)).add(paramh);
    AppMethodBeat.o(165589);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165592);
    p.k(paramMMFinderUI, "activity");
    if (!xse.contains(Integer.valueOf(paramMMFinderUI.hashCode())))
    {
      xse.add(Integer.valueOf(paramMMFinderUI.hashCode()));
      paramMMFinderUI = TAG;
      StringBuilder localStringBuilder = new StringBuilder("Start msg Looper ");
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      Log.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.d.dSq() + " size: " + xse.size() + ' ' + this.xrX);
      this.xrX = 0;
      dqr();
    }
    AppMethodBeat.o(165592);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.finder.api.h paramh)
  {
    AppMethodBeat.i(165590);
    p.k(paramh, "handler");
    HashSet localHashSet = (HashSet)xsc.get(paramInt);
    if (localHashSet != null)
    {
      localHashSet.remove(paramh);
      AppMethodBeat.o(165590);
      return;
    }
    AppMethodBeat.o(165590);
  }
  
  public final void b(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165593);
    p.k(paramMMFinderUI, "activity");
    xse.remove(Integer.valueOf(paramMMFinderUI.hashCode()));
    paramMMFinderUI = TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregister Looper ");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    Log.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.d.dSq() + " size: " + xse.size() + ' ' + this.xrX);
    AppMethodBeat.o(165593);
  }
  
  public final void gu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165588);
    String str = com.tencent.mm.model.z.bdh();
    com.tencent.mm.plugin.report.service.h.IzE.a(19122, new Object[] { Integer.valueOf(paramInt2), Util.getStack() });
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1292L, 1L, 1L, false);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1292L, paramInt2 + 10, 1L, false);
    b localb = new b();
    Object localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("FinderEntrance");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo;
      if (localObject1 != null)
      {
        localObject2 = ((bhw)localObject1).SQm;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localb.aBa((String)localObject1);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("FinderEntrance");
    if (localObject1 != null) {
      localb.xsh.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("TLFollow");
    int i;
    bhw localbhw;
    if (localObject1 != null)
    {
      localObject2 = (List)localb.xsh;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label1106;
      }
      localbhw = (bhw)((Iterator)localObject2).next();
      if (!p.h(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_tipsId, localbhw.SQm)) {
        break label1099;
      }
      label258:
      if (i < 0) {
        localb.xsh.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("TLRecommendTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.xsh;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label312:
      if (!((Iterator)localObject2).hasNext()) {
        break label1118;
      }
      localbhw = (bhw)((Iterator)localObject2).next();
      if (!p.h(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_tipsId, localbhw.SQm)) {
        break label1111;
      }
      label350:
      if (i < 0) {
        localb.xsh.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("finder_tl_hot_tab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.xsh;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label404:
      if (!((Iterator)localObject2).hasNext()) {
        break label1130;
      }
      localbhw = (bhw)((Iterator)localObject2).next();
      if (!p.h(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_tipsId, localbhw.SQm)) {
        break label1123;
      }
      label442:
      if (i < 0) {
        localb.xsh.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("finder_tl_nearby_tab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.xsh;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label496:
      if (!((Iterator)localObject2).hasNext()) {
        break label1142;
      }
      localbhw = (bhw)((Iterator)localObject2).next();
      if (!p.h(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_tipsId, localbhw.SQm)) {
        break label1135;
      }
      label534:
      if (i < 0) {
        localb.xsh.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("NearbyEntrance");
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo;
      if (localObject1 != null)
      {
        localObject2 = ((bhw)localObject1).SQm;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localb.aBb((String)localObject1);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("FinderLiveEntrance");
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo;
      if (localObject1 != null)
      {
        localObject2 = ((bhw)localObject1).SQm;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localb.aBb((String)localObject1);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("NearbyEntrance");
    if (localObject1 != null) {
      localb.xsj.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("NearbyFeedTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.xsj;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label727:
      if (!((Iterator)localObject2).hasNext()) {
        break label1154;
      }
      localbhw = (bhw)((Iterator)localObject2).next();
      if (!p.h(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_tipsId, localbhw.SQm)) {
        break label1147;
      }
      label765:
      if (i < 0) {
        localb.xsj.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("NearbyLiveTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.xsj;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label819:
      if (!((Iterator)localObject2).hasNext()) {
        break label1166;
      }
      localbhw = (bhw)((Iterator)localObject2).next();
      if (!p.h(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_tipsId, localbhw.SQm)) {
        break label1159;
      }
      label857:
      if (i < 0) {
        localb.xsj.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).aBf("NearbyPeopleTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.xsj;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label911:
      if (!((Iterator)localObject2).hasNext()) {
        break label1178;
      }
      localObject3 = (bhw)((Iterator)localObject2).next();
      if (!p.h(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_tipsId, ((bhw)localObject3).SQm)) {
        break label1171;
      }
    }
    for (;;)
    {
      if (i < 0) {
        localb.xsj.add(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).field_ctrInfo);
      }
      Log.i(TAG, "sync selector[" + paramInt1 + '=' + Ml(paramInt1) + "] finderCtrlInfoList=" + localb.xsh.size() + " nearbyCtrlInfoList=" + localb.xsj.size() + "myFinderUser[" + str + "] waitLinkedQueue=" + this.xrV.size());
      this.xrV.add(new r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localb));
      dqq();
      AppMethodBeat.o(165588);
      return;
      label1099:
      i += 1;
      break;
      label1106:
      i = -1;
      break label258;
      label1111:
      i += 1;
      break label312;
      label1118:
      i = -1;
      break label350;
      label1123:
      i += 1;
      break label404;
      label1130:
      i = -1;
      break label442;
      label1135:
      i += 1;
      break label496;
      label1142:
      i = -1;
      break label534;
      label1147:
      i += 1;
      break label727;
      label1154:
      i = -1;
      break label765;
      label1159:
      i += 1;
      break label819;
      label1166:
      i = -1;
      break label857;
      label1171:
      i += 1;
      break label911;
      label1178:
      i = -1;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(165586);
    long l = SystemClock.uptimeMillis();
    if (paramq == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderSync");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    Object localObject1 = ((cm)paramq).rr.bhX();
    if (localObject1 == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    int i = ((bkb)localObject1).fFT;
    Log.i(TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", cmdList=" + ((cm)paramq).doX().size() + ", (curSelector,selector) (" + this.xrW + ',' + i + "), continueFlag " + ((cm)paramq).doo());
    this.xrW = 0;
    r localr = (r)this.xrV.poll();
    Object localObject3;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.xrX = 0;
      paramInt1 = ((cm)paramq).doW();
      ??? = ((cm)paramq).doX();
      Log.i(TAG, "onSceneEnd " + paramInt1 + " continueFlag " + ((cm)paramq).doo() + " cmdList " + ((List)???).size());
      if (paramInt1 > 0)
      {
        paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
        com.tencent.mm.plugin.finder.storage.d.Qa(((cm)paramq).doW() * 1000);
      }
      paramString = ((cm)paramq).rr.bhX();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      localObject3 = com.tencent.mm.platformtools.z.a(((bkb)paramString).SUZ);
      paramString = ((cm)paramq).rr.bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      localObject1 = com.tencent.mm.platformtools.z.a(((bkc)paramString).SUZ);
      if (localObject1 == null) {
        break label986;
      }
      p.j(localObject3, "reqKey");
      if (localObject1.length == 0)
      {
        paramInt1 = 1;
        if (paramInt1 != 0) {
          break label830;
        }
        paramInt1 = 1;
        label436:
        if (paramInt1 == 0) {
          break label849;
        }
        paramString = ad.n((byte[])localObject3, (byte[])localObject1);
        Log.i(TAG, "processFinderSyncKey, req " + Util.encodeHexString((byte[])localObject3) + " resp " + Util.encodeHexString((byte[])localObject1) + " merge " + Util.encodeHexString(paramString));
        if (paramString != null)
        {
          if (paramString.length != 0) {
            break label835;
          }
          paramInt1 = 1;
          label513:
          if (paramInt1 == 0) {}
        }
        else
        {
          paramString = (String)localObject1;
        }
        paramString = com.tencent.mm.platformtools.z.a(com.tencent.mm.platformtools.z.aN(paramString));
        if (Arrays.equals((byte[])localObject3, paramString)) {
          break label840;
        }
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vzp, Util.encodeHexString(paramString));
        paramInt1 = 1;
        label567:
        if ((paramInt1 == 0) || (((cm)paramq).doo() == 0)) {
          break label986;
        }
      }
    }
    label646:
    label673:
    label830:
    label835:
    label840:
    label849:
    label986:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString = ((Iterable)???).iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label887;
        }
        localObject1 = (aqt)paramString.next();
        ??? = xsd;
        if (localr != null)
        {
          localObject3 = (Integer)localr.Mx;
          if (localObject3 != null)
          {
            paramInt2 = ((Integer)localObject3).intValue();
            if (localr == null) {
              break label859;
            }
            localObject3 = (Integer)localr.My;
            if (localObject3 == null) {
              break label859;
            }
            i = ((Integer)localObject3).intValue();
            ((d)???).a((aqt)localObject1, paramInt2, i);
            ??? = (HashSet)xsc.get(((aqt)localObject1).cmdId);
            if (??? == null) {
              continue;
            }
          }
        }
        for (;;)
        {
          synchronized ((Iterable)???)
          {
            localObject3 = ((Iterable)???).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label876;
            }
            com.tencent.mm.plugin.finder.api.h localh = (com.tencent.mm.plugin.finder.api.h)((Iterator)localObject3).next();
            if (localr == null) {
              break label865;
            }
            Integer localInteger = (Integer)localr.Mx;
            if (localInteger == null) {
              break label865;
            }
            paramInt2 = localInteger.intValue();
            if (localr == null) {
              break label870;
            }
            localInteger = (Integer)localr.My;
            if (localInteger == null) {
              break label870;
            }
            i = localInteger.intValue();
            localh.a((aqt)localObject1, paramInt2, i);
          }
          paramInt1 = 0;
          break;
          paramInt1 = 0;
          break label436;
          paramInt1 = 0;
          break label513;
          Log.i(TAG, "processFinderSyncKey, Sync Key Not change, not save");
          paramInt1 = 0;
          break label567;
          paramInt2 = 0;
          break label646;
          label859:
          i = 0;
          break label673;
          label865:
          paramInt2 = 0;
          continue;
          label870:
          i = 0;
        }
        label876:
        localObject1 = x.aazN;
      }
      label887:
      if (paramInt1 != 0) {
        this.xrV.add(new r(Integer.valueOf(((cm)paramq).doo()), Integer.valueOf(4), new b()));
      }
      for (;;)
      {
        dqq();
        Log.i(TAG, "[onSceneEnd] cost=" + (SystemClock.uptimeMillis() - l) + "ms");
        AppMethodBeat.o(165586);
        return;
        this.xrX += 1;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$Companion;", "", "()V", "TAG", "", "alives", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "defaultHandlers", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "syncHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "", "finderEntranceTipsId", "", "finderCtrlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "nearbyEntranceTipsId", "nearbyCtrlInfoList", "(Ljava/lang/String;Ljava/util/LinkedList;Ljava/lang/String;Ljava/util/LinkedList;)V", "getFinderCtrlInfoList", "()Ljava/util/LinkedList;", "getFinderEntranceTipsId", "()Ljava/lang/String;", "setFinderEntranceTipsId", "(Ljava/lang/String;)V", "getNearbyCtrlInfoList", "getNearbyEntranceTipsId", "setNearbyEntranceTipsId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    public String xsg;
    public final LinkedList<bhw> xsh;
    public String xsi;
    public final LinkedList<bhw> xsj;
    
    private b(String paramString1, LinkedList<bhw> paramLinkedList1, String paramString2, LinkedList<bhw> paramLinkedList2)
    {
      AppMethodBeat.i(279835);
      this.xsg = paramString1;
      this.xsh = paramLinkedList1;
      this.xsi = paramString2;
      this.xsj = paramLinkedList2;
      AppMethodBeat.o(279835);
    }
    
    public final void aBa(String paramString)
    {
      AppMethodBeat.i(279833);
      p.k(paramString, "<set-?>");
      this.xsg = paramString;
      AppMethodBeat.o(279833);
    }
    
    public final void aBb(String paramString)
    {
      AppMethodBeat.i(279834);
      p.k(paramString, "<set-?>");
      this.xsi = paramString;
      AppMethodBeat.o(279834);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(279839);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.xsg, paramObject.xsg)) || (!p.h(this.xsh, paramObject.xsh)) || (!p.h(this.xsi, paramObject.xsi)) || (!p.h(this.xsj, paramObject.xsj))) {}
        }
      }
      else
      {
        AppMethodBeat.o(279839);
        return true;
      }
      AppMethodBeat.o(279839);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(279838);
      Object localObject = this.xsg;
      int i;
      int j;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.xsh;
        if (localObject == null) {
          break label105;
        }
        j = localObject.hashCode();
        label42:
        localObject = this.xsi;
        if (localObject == null) {
          break label110;
        }
      }
      label105:
      label110:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.xsj;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(279838);
        return (k + (j + i * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label42;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(279837);
      String str = "SyncArgs(finderEntranceTipsId=" + this.xsg + ", finderCtrlInfoList=" + this.xsh + ", nearbyEntranceTipsId=" + this.xsi + ", nearbyCtrlInfoList=" + this.xsj + ")";
      AppMethodBeat.o(279837);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements MMHandler.Callback
  {
    c(c paramc) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(165584);
      if ((paramMessage != null) && (paramMessage.what == c.a(this.xsk)) && (c.b(this.xsk) == 0))
      {
        int i;
        if (!((Collection)c.c(this.xsk)).isEmpty()) {
          i = 1;
        }
        while (i != 0)
        {
          paramMessage = (r)c.c(this.xsk).peek();
          if (paramMessage != null)
          {
            c.a(this.xsk, ((Number)paramMessage.Mx).intValue());
            Object localObject = com.tencent.mm.kernel.h.aHG();
            p.j(localObject, "MMKernel.storage()");
            localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.Vzp, "");
            if (localObject == null)
            {
              paramMessage = new kotlin.t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(165584);
              throw paramMessage;
              i = 0;
            }
            else
            {
              localObject = Util.decodeHexString((String)localObject);
              paramMessage = new cm(com.tencent.mm.model.z.bdh(), (byte[])localObject, c.b(this.xsk), ((Number)paramMessage.My).intValue(), (c.b)paramMessage.aazK);
              com.tencent.mm.kernel.h.aGY().b((q)paramMessage);
            }
          }
        }
      }
      AppMethodBeat.o(165584);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(165585);
      this.xsk.gu(113149, 2);
      c.d(this.xsk);
      AppMethodBeat.o(165585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.c
 * JD-Core Version:    0.7.0.1
 */