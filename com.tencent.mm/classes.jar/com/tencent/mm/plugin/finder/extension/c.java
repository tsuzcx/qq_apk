package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.plugin.finder.api.j.a;
import com.tencent.mm.plugin.finder.api.k;
import com.tencent.mm.plugin.finder.cgi.dn;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;
import kotlin.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "bypRedDotNotifyEventListener", "com/tencent/mm/plugin/finder/extension/FinderSyncExtension$bypRedDotNotifyEventListener$1", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$bypRedDotNotifyEventListener$1;", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Triple;", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "unregister", "BypFinderCmdScene", "Companion", "SyncArgs", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.am.h, j
{
  public static final b APc;
  private static final SparseArray<HashSet<k>> APl;
  private static final d APm;
  private static HashSet<Integer> APn;
  private static final String TAG;
  private final FinderSyncExtension.bypRedDotNotifyEventListener.1 APd;
  private final ConcurrentLinkedQueue<u<Integer, Integer, c>> APe;
  private int APf;
  private int APg;
  private final int APh;
  private final int APi;
  private final MMHandler APj;
  private final Runnable APk;
  
  static
  {
    AppMethodBeat.i(165595);
    APc = new b((byte)0);
    TAG = "Finder.SyncExtension";
    APl = new SparseArray();
    APm = new d();
    APn = new HashSet();
    AppMethodBeat.o(165595);
  }
  
  public c()
  {
    AppMethodBeat.i(165594);
    this.APd = new FinderSyncExtension.bypRedDotNotifyEventListener.1(this, com.tencent.mm.app.f.hfK);
    this.APd.alive();
    this.APe = new ConcurrentLinkedQueue();
    this.APh = 3;
    this.APi = 666;
    this.APj = new MMHandler("finder_sync_thread", new c..ExternalSyntheticLambda0(this));
    this.APk = new c..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(165594);
  }
  
  private static String Nq(int paramInt)
  {
    AppMethodBeat.i(165587);
    Object localObject = new StringBuffer();
    r[] arrayOfr = j.a.dUp();
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      r localr = arrayOfr[i];
      if ((((Number)localr.bsC).intValue() & paramInt) != 0) {
        ((StringBuffer)localObject).append(kotlin.g.b.s.X((String)localr.bsD, " ,"));
      }
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    kotlin.g.b.s.s(localObject, "buf.toString()");
    AppMethodBeat.o(165587);
    return localObject;
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(366677);
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.a(113149, 2, null);
    paramc.dYW();
    AppMethodBeat.o(366677);
  }
  
  private static final boolean a(c paramc, Message paramMessage)
  {
    AppMethodBeat.i(366668);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramMessage, "it");
    if ((paramMessage.what == paramc.APi) && (paramc.APf == 0))
    {
      int i;
      if (!((Collection)paramc.APe).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        paramMessage = (u)paramc.APe.peek();
        if (paramMessage != null)
        {
          paramc.APf = ((Number)paramMessage.bsC).intValue();
          i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcr, 0);
          Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          int j = ((Number)com.tencent.mm.plugin.finder.storage.d.eXS().bmg()).intValue();
          if (j > i)
          {
            Log.w(TAG, "clean keybuf. svrCleanVersion=" + j + " cleanVersion=" + i);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adbu, "");
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adcr, Integer.valueOf(j));
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1292L, 30L, 1L, true);
          }
          localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adbu, "");
          if (localObject == null)
          {
            paramc = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(366668);
            throw paramc;
            i = 0;
          }
          else
          {
            localObject = Util.decodeHexString((String)localObject);
            paramc = new dn(z.bAW(), (byte[])localObject, paramc.APf, ((Number)paramMessage.bsD).intValue(), (c)paramMessage.aiuN);
            com.tencent.mm.kernel.h.aZW().a((p)paramc, 0);
          }
        }
      }
    }
    AppMethodBeat.o(366668);
    return false;
  }
  
  private final void dYV()
  {
    AppMethodBeat.i(366653);
    this.APj.sendEmptyMessage(this.APi);
    AppMethodBeat.o(366653);
  }
  
  private final void dYW()
  {
    AppMethodBeat.i(165591);
    if (this.APg >= this.APh) {
      Log.i(TAG, "checkLoop finderAliveUI " + APn.size() + " sync_fail_count " + this.APg + " so ignore checkloop");
    }
    if (APn.size() > 0)
    {
      this.APj.removeCallbacks(this.APk);
      MMHandler localMMHandler = this.APj;
      Runnable localRunnable = this.APk;
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      localMMHandler.postDelayed(localRunnable, com.tencent.mm.plugin.finder.storage.d.eQE());
    }
    AppMethodBeat.o(165591);
  }
  
  private static boolean j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(366642);
    int i;
    label19:
    byte[] arrayOfByte2;
    if (paramArrayOfByte2.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label149;
      }
      i = 1;
      if (i == 0) {
        break label168;
      }
      arrayOfByte2 = ad.o(paramArrayOfByte1, paramArrayOfByte2);
      Log.i(TAG, "processFinderSyncKey, req " + Util.encodeHexString(paramArrayOfByte1) + " resp " + Util.encodeHexString(paramArrayOfByte2) + " merge " + Util.encodeHexString(arrayOfByte2));
      arrayOfByte1 = paramArrayOfByte2;
      if (arrayOfByte2 != null)
      {
        if (arrayOfByte2.length != 0) {
          break label154;
        }
        i = 1;
        label98:
        if (i == 0) {
          break label176;
        }
      }
    }
    label149:
    label154:
    label168:
    label176:
    for (byte[] arrayOfByte1 = paramArrayOfByte2;; arrayOfByte1 = arrayOfByte2)
    {
      paramArrayOfByte2 = w.a(w.aN(arrayOfByte1));
      if (!Arrays.equals(paramArrayOfByte1, paramArrayOfByte2))
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adbu, Util.encodeHexString(paramArrayOfByte2));
        AppMethodBeat.o(366642);
        return true;
        i = 0;
        break;
        i = 0;
        break label19;
        i = 0;
        break label98;
      }
      Log.i(TAG, "processFinderSyncKey, Sync Key Not change, not save");
      AppMethodBeat.o(366642);
      return false;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, bui parambui)
  {
    AppMethodBeat.i(366715);
    String str = z.bAW();
    com.tencent.mm.plugin.report.service.h.OAn.b(19122, new Object[] { Integer.valueOf(paramInt2), Util.getStack() });
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1292L, 1L, 1L, false);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1292L, paramInt2 + 10, 1L, false);
    c localc = new c();
    localc.Auc = parambui;
    if (((paramInt2 == 3) || (paramInt2 == 11)) && (!((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry()))
    {
      Log.e(TAG, "ignore this notify to sync[" + paramInt2 + "].");
      AppMethodBeat.o(366715);
      return;
    }
    Log.i(TAG, "sync selector[" + paramInt1 + '=' + Nq(paramInt1) + "] myFinderUser[" + str + "] waitLinkedQueue=" + this.APe.size());
    this.APe.add(new u(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localc));
    dYV();
    AppMethodBeat.o(366715);
  }
  
  public final void a(int paramInt, k paramk)
  {
    AppMethodBeat.i(165589);
    kotlin.g.b.s.u(paramk, "handler");
    if ((HashSet)APl.get(paramInt) == null) {
      APl.append(paramInt, new HashSet());
    }
    ((HashSet)APl.get(paramInt)).add(paramk);
    AppMethodBeat.o(165589);
  }
  
  public final void b(int paramInt, k paramk)
  {
    AppMethodBeat.i(165590);
    kotlin.g.b.s.u(paramk, "handler");
    HashSet localHashSet = (HashSet)APl.get(paramInt);
    if (localHashSet != null) {
      localHashSet.remove(paramk);
    }
    AppMethodBeat.o(165590);
  }
  
  public final void c(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165592);
    kotlin.g.b.s.u(paramMMFinderUI, "activity");
    if (!APn.contains(Integer.valueOf(paramMMFinderUI.hashCode())))
    {
      APn.add(Integer.valueOf(paramMMFinderUI.hashCode()));
      paramMMFinderUI = TAG;
      StringBuilder localStringBuilder = new StringBuilder("Start msg Looper ");
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      Log.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.d.eQE() + " size: " + APn.size() + ' ' + this.APg);
      this.APg = 0;
      dYW();
    }
    AppMethodBeat.o(165592);
  }
  
  public final void d(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165593);
    kotlin.g.b.s.u(paramMMFinderUI, "activity");
    APn.remove(Integer.valueOf(paramMMFinderUI.hashCode()));
    paramMMFinderUI = TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregister Looper ");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    Log.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.d.eQE() + " size: " + APn.size() + ' ' + this.APg);
    AppMethodBeat.o(165593);
  }
  
  public final void ho(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(371845);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(371845);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(165586);
    long l = SystemClock.uptimeMillis();
    if (paramp == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderSync");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    Object localObject1 = com.tencent.mm.am.c.b.b(((dn)paramp).rr.otB);
    if (localObject1 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    int i = ((bxe)localObject1).selector;
    Log.i(TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", cmdList=" + ((dn)paramp).dWx().size() + ", (curSelector,selector) (" + this.APf + ',' + i + "), continueFlag " + ((dn)paramp).dVZ());
    this.APf = 0;
    paramString = this.APe.poll();
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.APg = 0;
      paramInt1 = ((dn)paramp).dWw();
      localObject1 = ((dn)paramp).dWx();
      Log.i(TAG, "onSceneEnd " + paramInt1 + " continueFlag " + ((dn)paramp).dVZ() + " cmdList " + ((List)localObject1).size());
      if (paramInt1 > 0)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        com.tencent.mm.plugin.finder.storage.d.Tk(((dn)paramp).dWw() * 1000);
      }
      localObject2 = com.tencent.mm.am.c.b.b(((dn)paramp).rr.otB);
      if (localObject2 == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      localObject2 = w.a(((bxe)localObject2).aafS);
      ??? = com.tencent.mm.am.c.c.b(((dn)paramp).rr.otC);
      if (??? == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      ??? = w.a(((bxf)???).aafS);
      if (??? == null) {
        break label881;
      }
      kotlin.g.b.s.s(localObject2, "reqKey");
      kotlin.g.b.s.s(???, "respKey");
      if ((!j((byte[])localObject2, (byte[])???)) || (((dn)paramp).dVZ() == 0)) {
        break label881;
      }
    }
    label531:
    label683:
    label712:
    label741:
    label881:
    for (i = 1;; i = 0)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (auw)((Iterator)localObject1).next();
        ??? = APm;
        Object localObject4 = (u)paramString;
        if (localObject4 == null)
        {
          paramInt1 = 0;
          localObject4 = (u)paramString;
          if (localObject4 != null) {
            break label683;
          }
          paramInt2 = 0;
          ((d)???).a((auw)localObject2, paramInt1, paramInt2);
          ??? = (HashSet)APl.get(((auw)localObject2).cmdId);
          if (??? == null) {
            continue;
          }
        }
        for (;;)
        {
          synchronized ((Iterable)???)
          {
            localObject4 = ((Iterable)???).iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label770;
            }
            k localk = (k)((Iterator)localObject4).next();
            localObject5 = (u)paramString;
            if (localObject5 != null) {
              break label712;
            }
            paramInt1 = 0;
            localObject5 = (u)paramString;
            if (localObject5 != null) {
              break label741;
            }
            paramInt2 = 0;
            localk.a((auw)localObject2, paramInt1, paramInt2);
          }
          localObject4 = (Integer)((u)localObject4).bsC;
          if (localObject4 == null)
          {
            paramInt1 = 0;
            break;
          }
          paramInt1 = ((Integer)localObject4).intValue();
          break;
          localObject4 = (Integer)((u)localObject4).bsD;
          if (localObject4 == null)
          {
            paramInt2 = 0;
            break label531;
          }
          paramInt2 = ((Integer)localObject4).intValue();
          break label531;
          Object localObject5 = (Integer)((u)localObject5).bsC;
          if (localObject5 == null)
          {
            paramInt1 = 0;
          }
          else
          {
            paramInt1 = ((Integer)localObject5).intValue();
            continue;
            localObject5 = (Integer)((u)localObject5).bsD;
            if (localObject5 == null) {
              paramInt2 = 0;
            } else {
              paramInt2 = ((Integer)localObject5).intValue();
            }
          }
        }
        localObject2 = ah.aiuX;
      }
      if (i != 0) {
        this.APe.add(new u(Integer.valueOf(((dn)paramp).dVZ()), Integer.valueOf(4), new c()));
      }
      for (;;)
      {
        dYV();
        Log.i(TAG, "[onSceneEnd] cost=" + (SystemClock.uptimeMillis() - l) + "ms");
        AppMethodBeat.o(165586);
        return;
        this.APg += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$BypFinderCmdScene;", "", "()V", "BYP_FINDER_CMD_SCENE_FINDERSYNC", "", "getBYP_FINDER_CMD_SCENE_FINDERSYNC", "()I", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a APo;
    private static final int APp;
    
    static
    {
      AppMethodBeat.i(366626);
      APo = new a();
      APp = 1;
      AppMethodBeat.o(366626);
    }
    
    public static int dYX()
    {
      return APp;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$Companion;", "", "()V", "TAG", "", "alives", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "defaultHandlers", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "syncHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "", "finderEntranceTipsId", "", "finderCtrlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "nearbyEntranceTipsId", "nearbyCtrlInfoList", "(Ljava/lang/String;Ljava/util/LinkedList;Ljava/lang/String;Ljava/util/LinkedList;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFinderCtrlInfoList", "()Ljava/util/LinkedList;", "getFinderEntranceTipsId", "()Ljava/lang/String;", "setFinderEntranceTipsId", "(Ljava/lang/String;)V", "getNearbyCtrlInfoList", "getNearbyEntranceTipsId", "setNearbyEntranceTipsId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public String APq;
    public final LinkedList<btw> APr;
    public String APs;
    public final LinkedList<btw> APt;
    public bui Auc;
    
    private c(String paramString1, LinkedList<btw> paramLinkedList1, String paramString2, LinkedList<btw> paramLinkedList2)
    {
      AppMethodBeat.i(366622);
      this.APq = paramString1;
      this.APr = paramLinkedList1;
      this.APs = paramString2;
      this.APt = paramLinkedList2;
      AppMethodBeat.o(366622);
    }
    
    public final void avn(String paramString)
    {
      AppMethodBeat.i(366634);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.APs = paramString;
      AppMethodBeat.o(366634);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(366650);
      if (this == paramObject)
      {
        AppMethodBeat.o(366650);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(366650);
        return false;
      }
      paramObject = (c)paramObject;
      if (!kotlin.g.b.s.p(this.APq, paramObject.APq))
      {
        AppMethodBeat.o(366650);
        return false;
      }
      if (!kotlin.g.b.s.p(this.APr, paramObject.APr))
      {
        AppMethodBeat.o(366650);
        return false;
      }
      if (!kotlin.g.b.s.p(this.APs, paramObject.APs))
      {
        AppMethodBeat.o(366650);
        return false;
      }
      if (!kotlin.g.b.s.p(this.APt, paramObject.APt))
      {
        AppMethodBeat.o(366650);
        return false;
      }
      AppMethodBeat.o(366650);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(366645);
      int i = this.APq.hashCode();
      int j = this.APr.hashCode();
      int k = this.APs.hashCode();
      int m = this.APt.hashCode();
      AppMethodBeat.o(366645);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(366640);
      String str = "SyncArgs(finderEntranceTipsId=" + this.APq + ", finderCtrlInfoList=" + this.APr + ", nearbyEntranceTipsId=" + this.APs + ", nearbyCtrlInfoList=" + this.APt + ')';
      AppMethodBeat.o(366640);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.c
 * JD-Core Version:    0.7.0.1
 */