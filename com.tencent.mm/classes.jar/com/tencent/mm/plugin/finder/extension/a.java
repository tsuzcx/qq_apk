package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.e.a;
import com.tencent.mm.plugin.finder.cgi.ci;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.bdf;
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
import kotlin.l;
import kotlin.o;
import kotlin.r;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Triple;", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "unregister", "Companion", "SyncArgs", "plugin-finder_release"})
public final class a
  implements i, com.tencent.mm.plugin.finder.api.e
{
  private static final String TAG = "Finder.SyncExtension";
  private static final SparseArray<HashSet<com.tencent.mm.plugin.finder.api.f>> tIT;
  private static final b tIU;
  private static HashSet<Integer> tIV;
  public static final a tIW;
  private final ConcurrentLinkedQueue<r<Integer, Integer, b>> tIM;
  private int tIN;
  private int tIO;
  private final int tIP;
  private final int tIQ;
  private final MMHandler tIR;
  private final Runnable tIS;
  
  static
  {
    AppMethodBeat.i(165595);
    tIW = new a((byte)0);
    TAG = "Finder.SyncExtension";
    tIT = new SparseArray();
    tIU = new b();
    tIV = new HashSet();
    AppMethodBeat.o(165595);
  }
  
  public a()
  {
    AppMethodBeat.i(165594);
    this.tIM = new ConcurrentLinkedQueue();
    this.tIP = 3;
    this.tIQ = 666;
    this.tIR = new MMHandler("finder_sync_thread", (MMHandler.Callback)new c(this));
    this.tIS = ((Runnable)new d(this));
    AppMethodBeat.o(165594);
  }
  
  private static String Iv(int paramInt)
  {
    AppMethodBeat.i(165587);
    Object localObject = new StringBuffer();
    o[] arrayOfo = e.a.cXG();
    int j = arrayOfo.length;
    int i = 0;
    while (i < j)
    {
      o localo = arrayOfo[i];
      if ((((Number)localo.first).intValue() & paramInt) != 0) {
        ((StringBuffer)localObject).append((String)localo.second + " ,");
      }
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    p.g(localObject, "buf.toString()");
    AppMethodBeat.o(165587);
    return localObject;
  }
  
  private final void daq()
  {
    AppMethodBeat.i(243480);
    this.tIR.sendEmptyMessage(this.tIQ);
    AppMethodBeat.o(243480);
  }
  
  private final void dar()
  {
    AppMethodBeat.i(165591);
    if (this.tIO >= this.tIP) {
      Log.i(TAG, "checkLoop finderAliveUI " + tIV.size() + " sync_fail_count " + this.tIO + " so ignore checkloop");
    }
    if (tIV.size() > 0)
    {
      this.tIR.removeCallbacks(this.tIS);
      MMHandler localMMHandler = this.tIR;
      Runnable localRunnable = this.tIS;
      c localc = c.vCb;
      localMMHandler.postDelayed(localRunnable, c.drc());
    }
    AppMethodBeat.o(165591);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.api.f paramf)
  {
    AppMethodBeat.i(165589);
    p.h(paramf, "handler");
    if ((HashSet)tIT.get(paramInt) == null)
    {
      tIT.append(paramInt, new HashSet());
      x localx = x.SXb;
    }
    ((HashSet)tIT.get(paramInt)).add(paramf);
    AppMethodBeat.o(165589);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165592);
    p.h(paramMMFinderUI, "activity");
    if (!tIV.contains(Integer.valueOf(paramMMFinderUI.hashCode())))
    {
      tIV.add(Integer.valueOf(paramMMFinderUI.hashCode()));
      paramMMFinderUI = TAG;
      StringBuilder localStringBuilder = new StringBuilder("Start msg Looper ");
      c localc = c.vCb;
      Log.i(paramMMFinderUI, c.drc() + " size: " + tIV.size() + ' ' + this.tIO);
      this.tIO = 0;
      dar();
    }
    AppMethodBeat.o(165592);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.finder.api.f paramf)
  {
    AppMethodBeat.i(165590);
    p.h(paramf, "handler");
    HashSet localHashSet = (HashSet)tIT.get(paramInt);
    if (localHashSet != null)
    {
      localHashSet.remove(paramf);
      AppMethodBeat.o(165590);
      return;
    }
    AppMethodBeat.o(165590);
  }
  
  public final void b(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165593);
    p.h(paramMMFinderUI, "activity");
    tIV.remove(Integer.valueOf(paramMMFinderUI.hashCode()));
    paramMMFinderUI = TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregister Looper ");
    c localc = c.vCb;
    Log.i(paramMMFinderUI, c.drc() + " size: " + tIV.size() + ' ' + this.tIO);
    AppMethodBeat.o(165593);
  }
  
  public final void fX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165588);
    String str = com.tencent.mm.model.z.aUg();
    h.CyF.a(19122, new Object[] { Integer.valueOf(paramInt2), Util.getStack() });
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1292L, 1L, 1L, false);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1292L, paramInt2 + 10, 1L, false);
    b localb = new b();
    Object localObject1 = g.ah(PluginFinder.class);
    p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("FinderEntrance");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((k)localObject1).field_ctrInfo;
      if (localObject1 != null)
      {
        localObject2 = ((bbi)localObject1).LKM;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localb.asS((String)localObject1);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("FinderEntrance");
    if (localObject1 != null) {
      localb.tIY.add(((k)localObject1).field_ctrInfo);
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("TLFollow");
    int i;
    bbi localbbi;
    if (localObject1 != null)
    {
      localObject2 = (List)localb.tIY;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label1051;
      }
      localbbi = (bbi)((Iterator)localObject2).next();
      if (!p.j(((k)localObject1).field_tipsId, localbbi.LKM)) {
        break label1044;
      }
      label258:
      if (i < 0) {
        localb.tIY.add(((k)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("TLRecommendTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.tIY;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label312:
      if (!((Iterator)localObject2).hasNext()) {
        break label1063;
      }
      localbbi = (bbi)((Iterator)localObject2).next();
      if (!p.j(((k)localObject1).field_tipsId, localbbi.LKM)) {
        break label1056;
      }
      label350:
      if (i < 0) {
        localb.tIY.add(((k)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("finder_tl_hot_tab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.tIY;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label404:
      if (!((Iterator)localObject2).hasNext()) {
        break label1075;
      }
      localbbi = (bbi)((Iterator)localObject2).next();
      if (!p.j(((k)localObject1).field_tipsId, localbbi.LKM)) {
        break label1068;
      }
      label442:
      if (i < 0) {
        localb.tIY.add(((k)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("finder_tl_nearby_tab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.tIY;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label496:
      if (!((Iterator)localObject2).hasNext()) {
        break label1087;
      }
      localbbi = (bbi)((Iterator)localObject2).next();
      if (!p.j(((k)localObject1).field_tipsId, localbbi.LKM)) {
        break label1080;
      }
      label534:
      if (i < 0) {
        localb.tIY.add(((k)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("NearbyEntrance");
    if (localObject1 != null)
    {
      localObject1 = ((k)localObject1).field_ctrInfo;
      if (localObject1 != null)
      {
        localObject2 = ((bbi)localObject1).LKM;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localb.asT((String)localObject1);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("NearbyEntrance");
    if (localObject1 != null) {
      localb.tJa.add(((k)localObject1).field_ctrInfo);
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("NearbyFeedTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.tJa;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label672:
      if (!((Iterator)localObject2).hasNext()) {
        break label1099;
      }
      localbbi = (bbi)((Iterator)localObject2).next();
      if (!p.j(((k)localObject1).field_tipsId, localbbi.LKM)) {
        break label1092;
      }
      label710:
      if (i < 0) {
        localb.tJa.add(((k)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("NearbyLiveTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.tJa;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label764:
      if (!((Iterator)localObject2).hasNext()) {
        break label1111;
      }
      localbbi = (bbi)((Iterator)localObject2).next();
      if (!p.j(((k)localObject1).field_tipsId, localbbi.LKM)) {
        break label1104;
      }
      label802:
      if (i < 0) {
        localb.tJa.add(((k)localObject1).field_ctrInfo);
      }
    }
    localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject3).asX("NearbyPeopleTab");
    if (localObject1 != null)
    {
      localObject2 = (List)localb.tJa;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label856:
      if (!((Iterator)localObject2).hasNext()) {
        break label1123;
      }
      localObject3 = (bbi)((Iterator)localObject2).next();
      if (!p.j(((k)localObject1).field_tipsId, ((bbi)localObject3).LKM)) {
        break label1116;
      }
    }
    for (;;)
    {
      if (i < 0) {
        localb.tJa.add(((k)localObject1).field_ctrInfo);
      }
      Log.i(TAG, "sync selector[" + paramInt1 + '=' + Iv(paramInt1) + "] finderCtrlInfoList=" + localb.tIY.size() + " nearbyCtrlInfoList=" + localb.tJa.size() + "myFinderUser[" + str + "] waitLinkedQueue=" + this.tIM.size());
      this.tIM.add(new r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localb));
      daq();
      AppMethodBeat.o(165588);
      return;
      label1044:
      i += 1;
      break;
      label1051:
      i = -1;
      break label258;
      label1056:
      i += 1;
      break label312;
      label1063:
      i = -1;
      break label350;
      label1068:
      i += 1;
      break label404;
      label1075:
      i = -1;
      break label442;
      label1080:
      i += 1;
      break label496;
      label1087:
      i = -1;
      break label534;
      label1092:
      i += 1;
      break label672;
      label1099:
      i = -1;
      break label710;
      label1104:
      i += 1;
      break label764;
      label1111:
      i = -1;
      break label802;
      label1116:
      i += 1;
      break label856;
      label1123:
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
    Object localObject1 = ((ci)paramq).rr.aYJ();
    if (localObject1 == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    int i = ((bde)localObject1).dML;
    Log.i(TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", cmdList=" + ((ci)paramq).cZf().size() + ", (curSelector,selector) (" + this.tIN + ',' + i + "), continueFlag " + ((ci)paramq).cYA());
    this.tIN = 0;
    r localr = (r)this.tIM.poll();
    Object localObject3;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.tIO = 0;
      paramInt1 = ((ci)paramq).getInterval();
      ??? = ((ci)paramq).cZf();
      Log.i(TAG, "onSceneEnd " + paramInt1 + " continueFlag " + ((ci)paramq).cYA() + " cmdList " + ((List)???).size());
      if (paramInt1 > 0)
      {
        paramString = c.vCb;
        c.KP(((ci)paramq).getInterval() * 1000);
      }
      paramString = ((ci)paramq).rr.aYJ();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      localObject3 = com.tencent.mm.platformtools.z.a(((bde)paramString).LMX);
      paramString = ((ci)paramq).rr.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      localObject1 = com.tencent.mm.platformtools.z.a(((bdf)paramString).LMX);
      if (localObject1 == null) {
        break label986;
      }
      p.g(localObject3, "reqKey");
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
        paramString = ad.l((byte[])localObject3, (byte[])localObject1);
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
        paramString = com.tencent.mm.platformtools.z.a(com.tencent.mm.platformtools.z.aC(paramString));
        if (Arrays.equals((byte[])localObject3, paramString)) {
          break label840;
        }
        localObject1 = g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Oky, Util.encodeHexString(paramString));
        paramInt1 = 1;
        label567:
        if ((paramInt1 == 0) || (((ci)paramq).cYA() == 0)) {
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
        localObject1 = (apf)paramString.next();
        ??? = tIU;
        if (localr != null)
        {
          localObject3 = (Integer)localr.first;
          if (localObject3 != null)
          {
            paramInt2 = ((Integer)localObject3).intValue();
            if (localr == null) {
              break label859;
            }
            localObject3 = (Integer)localr.second;
            if (localObject3 == null) {
              break label859;
            }
            i = ((Integer)localObject3).intValue();
            ((b)???).a((apf)localObject1, paramInt2, i);
            ??? = (HashSet)tIT.get(((apf)localObject1).cmdId);
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
            com.tencent.mm.plugin.finder.api.f localf = (com.tencent.mm.plugin.finder.api.f)((Iterator)localObject3).next();
            if (localr == null) {
              break label865;
            }
            Integer localInteger = (Integer)localr.first;
            if (localInteger == null) {
              break label865;
            }
            paramInt2 = localInteger.intValue();
            if (localr == null) {
              break label870;
            }
            localInteger = (Integer)localr.second;
            if (localInteger == null) {
              break label870;
            }
            i = localInteger.intValue();
            localf.a((apf)localObject1, paramInt2, i);
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
        localObject1 = x.SXb;
      }
      label887:
      if (paramInt1 != 0) {
        this.tIM.add(new r(Integer.valueOf(((ci)paramq).cYA()), Integer.valueOf(4), new b()));
      }
      for (;;)
      {
        daq();
        Log.i(TAG, "[onSceneEnd] cost=" + (SystemClock.uptimeMillis() - l) + "ms");
        AppMethodBeat.o(165586);
        return;
        this.tIO += 1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$Companion;", "", "()V", "TAG", "", "alives", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "defaultHandlers", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "syncHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "", "finderEntranceTipsId", "", "finderCtrlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "nearbyEntranceTipsId", "nearbyCtrlInfoList", "(Ljava/lang/String;Ljava/util/LinkedList;Ljava/lang/String;Ljava/util/LinkedList;)V", "getFinderCtrlInfoList", "()Ljava/util/LinkedList;", "getFinderEntranceTipsId", "()Ljava/lang/String;", "setFinderEntranceTipsId", "(Ljava/lang/String;)V", "getNearbyCtrlInfoList", "getNearbyEntranceTipsId", "setNearbyEntranceTipsId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    public String tIX;
    public final LinkedList<bbi> tIY;
    public String tIZ;
    public final LinkedList<bbi> tJa;
    
    private b(String paramString1, LinkedList<bbi> paramLinkedList1, String paramString2, LinkedList<bbi> paramLinkedList2)
    {
      AppMethodBeat.i(243475);
      this.tIX = paramString1;
      this.tIY = paramLinkedList1;
      this.tIZ = paramString2;
      this.tJa = paramLinkedList2;
      AppMethodBeat.o(243475);
    }
    
    public final void asS(String paramString)
    {
      AppMethodBeat.i(243473);
      p.h(paramString, "<set-?>");
      this.tIX = paramString;
      AppMethodBeat.o(243473);
    }
    
    public final void asT(String paramString)
    {
      AppMethodBeat.i(243474);
      p.h(paramString, "<set-?>");
      this.tIZ = paramString;
      AppMethodBeat.o(243474);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(243479);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.tIX, paramObject.tIX)) || (!p.j(this.tIY, paramObject.tIY)) || (!p.j(this.tIZ, paramObject.tIZ)) || (!p.j(this.tJa, paramObject.tJa))) {}
        }
      }
      else
      {
        AppMethodBeat.o(243479);
        return true;
      }
      AppMethodBeat.o(243479);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(243478);
      Object localObject = this.tIX;
      int i;
      int j;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.tIY;
        if (localObject == null) {
          break label105;
        }
        j = localObject.hashCode();
        label42:
        localObject = this.tIZ;
        if (localObject == null) {
          break label110;
        }
      }
      label105:
      label110:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.tJa;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(243478);
        return (k + (j + i * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label42;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243477);
      String str = "SyncArgs(finderEntranceTipsId=" + this.tIX + ", finderCtrlInfoList=" + this.tIY + ", nearbyEntranceTipsId=" + this.tIZ + ", nearbyCtrlInfoList=" + this.tJa + ")";
      AppMethodBeat.o(243477);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements MMHandler.Callback
  {
    c(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(165584);
      if ((paramMessage != null) && (paramMessage.what == a.a(this.tJb)) && (a.b(this.tJb) == 0))
      {
        int i;
        if (!((Collection)a.c(this.tJb)).isEmpty()) {
          i = 1;
        }
        while (i != 0)
        {
          paramMessage = (r)a.c(this.tJb).peek();
          if (paramMessage != null)
          {
            a.a(this.tJb, ((Number)paramMessage.first).intValue());
            Object localObject = g.aAh();
            p.g(localObject, "MMKernel.storage()");
            localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.Oky, "");
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
              paramMessage = new ci(com.tencent.mm.model.z.aUg(), (byte[])localObject, a.b(this.tJb), ((Number)paramMessage.second).intValue(), (a.b)paramMessage.SWY);
              g.azz().b((q)paramMessage);
            }
          }
        }
      }
      AppMethodBeat.o(165584);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165585);
      this.tJb.fX(47613, 2);
      a.d(this.tJb);
      AppMethodBeat.o(165585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a
 * JD-Core Version:    0.7.0.1
 */