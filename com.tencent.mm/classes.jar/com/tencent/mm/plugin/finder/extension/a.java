package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.e.a;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "enterToSync", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "unregister", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.finder.api.e
{
  private static final String TAG = "Finder.SyncExtension";
  private static final SparseArray<HashSet<com.tencent.mm.plugin.finder.api.f>> rRA;
  private static final b rRB;
  private static HashSet<Integer> rRC;
  public static final a rRD;
  private final ConcurrentLinkedQueue<o<Integer, Integer>> rRt;
  private int rRu;
  private int rRv;
  private final int rRw;
  private final int rRx;
  private final ap rRy;
  private final Runnable rRz;
  
  static
  {
    AppMethodBeat.i(165595);
    rRD = new a((byte)0);
    TAG = "Finder.SyncExtension";
    rRA = new SparseArray();
    rRB = new b();
    rRC = new HashSet();
    AppMethodBeat.o(165595);
  }
  
  public a()
  {
    AppMethodBeat.i(165594);
    this.rRt = new ConcurrentLinkedQueue();
    this.rRw = 3;
    this.rRx = 666;
    this.rRy = new ap("finder_sync_thread", (ap.a)new b(this));
    this.rRz = ((Runnable)new c(this));
    AppMethodBeat.o(165594);
  }
  
  private static String Eo(int paramInt)
  {
    AppMethodBeat.i(165587);
    Object localObject = new StringBuffer();
    o[] arrayOfo = e.a.cxK();
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
  
  private final void czA()
  {
    AppMethodBeat.i(201573);
    this.rRy.sendEmptyMessage(this.rRx);
    AppMethodBeat.o(201573);
  }
  
  private final void czB()
  {
    AppMethodBeat.i(165591);
    if (this.rRv >= this.rRw) {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "checkLoop finderAliveUI " + rRC.size() + " sync_fail_count " + this.rRv + " so ignore checkloop");
    }
    if (rRC.size() > 0)
    {
      this.rRy.removeCallbacks(this.rRz);
      ap localap = this.rRy;
      Runnable localRunnable = this.rRz;
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      localap.postDelayed(localRunnable, com.tencent.mm.plugin.finder.storage.b.cFu());
    }
    AppMethodBeat.o(165591);
  }
  
  private final void czC()
  {
    AppMethodBeat.i(178141);
    fI(14845, 7);
    AppMethodBeat.o(178141);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.api.f paramf)
  {
    AppMethodBeat.i(165589);
    p.h(paramf, "handler");
    if ((HashSet)rRA.get(paramInt) == null)
    {
      rRA.append(paramInt, new HashSet());
      d.z localz = d.z.MKo;
    }
    ((HashSet)rRA.get(paramInt)).add(paramf);
    AppMethodBeat.o(165589);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165592);
    p.h(paramMMFinderUI, "activity");
    if (!rRC.contains(Integer.valueOf(paramMMFinderUI.hashCode())))
    {
      rRC.add(Integer.valueOf(paramMMFinderUI.hashCode()));
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("Start msg Looper ");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      com.tencent.mm.sdk.platformtools.ad.i(str, com.tencent.mm.plugin.finder.storage.b.cFu() + " size: " + rRC.size() + ' ' + this.rRv);
      this.rRv = 0;
      if ((paramMMFinderUI instanceof FinderTimelineUI)) {
        czC();
      }
      czB();
    }
    AppMethodBeat.o(165592);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.finder.api.f paramf)
  {
    AppMethodBeat.i(165590);
    p.h(paramf, "handler");
    HashSet localHashSet = (HashSet)rRA.get(paramInt);
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
    rRC.remove(Integer.valueOf(paramMMFinderUI.hashCode()));
    paramMMFinderUI = TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregister Looper ");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    com.tencent.mm.sdk.platformtools.ad.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.b.cFu() + " size: " + rRC.size() + ' ' + this.rRv);
    AppMethodBeat.o(165593);
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165588);
    String str = u.aAu();
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "sync selector %d myFinderUser %s %s", new Object[] { Integer.valueOf(paramInt1), str, Eo(paramInt1) });
    com.tencent.mm.plugin.report.service.g.yhR.f(19122, new Object[] { Integer.valueOf(paramInt2), bt.flS() });
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1292L, 1L, 1L, true);
    this.rRt.add(new o(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
    czA();
    AppMethodBeat.o(165588);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(165586);
    long l = SystemClock.uptimeMillis();
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderSync");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    ??? = ((bb)paramn).rr.aEE();
    if (??? == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    int i = ((arv)???).duf;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", cmdList=" + ((bb)paramn).cyM().size() + ", (curSelector,selector) (" + this.rRu + ',' + i + "), continueFlag " + ((bb)paramn).cyq());
    this.rRu = 0;
    this.rRt.poll();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.rRv = 0;
      paramInt1 = ((bb)paramn).getInterval();
      Object localObject2 = ((bb)paramn).cyM();
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "onSceneEnd " + paramInt1 + " continueFlag " + ((bb)paramn).cyq() + " cmdList " + ((List)localObject2).size());
      if (paramInt1 > 0)
      {
        paramString = com.tencent.mm.plugin.finder.storage.b.sxa;
        com.tencent.mm.plugin.finder.storage.b.Fg(((bb)paramn).getInterval() * 1000);
      }
      paramString = ((bb)paramn).rr.aEE();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      Object localObject3 = com.tencent.mm.platformtools.z.a(((arv)paramString).Gqg);
      paramString = ((bb)paramn).rr.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      ??? = com.tencent.mm.platformtools.z.a(((arw)paramString).Gqg);
      i = 0;
      paramInt2 = i;
      if (??? != null)
      {
        p.g(localObject3, "reqKey");
        if (???.length != 0) {
          break label713;
        }
        paramInt1 = 1;
        if (paramInt1 != 0) {
          break label718;
        }
        paramInt1 = 1;
        label438:
        if (paramInt1 == 0) {
          break label737;
        }
        paramString = com.tencent.mm.protocal.ad.k((byte[])localObject3, (byte[])???);
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "processFinderSyncKey, req " + bt.cE((byte[])localObject3) + " resp " + bt.cE((byte[])???) + " merge " + bt.cE(paramString));
        if (paramString != null)
        {
          if (paramString.length != 0) {
            break label723;
          }
          paramInt1 = 1;
          label515:
          if (paramInt1 == 0) {}
        }
        else
        {
          paramString = (String)???;
        }
        paramString = com.tencent.mm.platformtools.z.a(com.tencent.mm.platformtools.z.al(paramString));
        if (Arrays.equals((byte[])localObject3, paramString)) {
          break label728;
        }
        ??? = com.tencent.mm.kernel.g.ajC();
        p.g(???, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)???).ajl().set(al.a.IGY, bt.cE(paramString));
        paramInt1 = 1;
        label569:
        paramInt2 = i;
        if (paramInt1 != 0)
        {
          paramInt2 = i;
          if (((bb)paramn).cyq() != 0) {
            paramInt2 = 1;
          }
        }
      }
      paramString = ((Iterable)localObject2).iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label753;
        }
        localObject2 = (alo)paramString.next();
        rRB.a((alo)localObject2);
        ??? = (HashSet)rRA.get(((alo)localObject2).cmdId);
        if (??? != null)
        {
          synchronized ((Iterable)???)
          {
            localObject3 = ((Iterable)???).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label742;
            }
            ((com.tencent.mm.plugin.finder.api.f)((Iterator)localObject3).next()).a((alo)localObject2);
          }
          label713:
          paramInt1 = 0;
          break;
          label718:
          paramInt1 = 0;
          break label438;
          label723:
          paramInt1 = 0;
          break label515;
          label728:
          com.tencent.mm.sdk.platformtools.ad.i(TAG, "processFinderSyncKey, Sync Key Not change, not save");
          label737:
          paramInt1 = 0;
          break label569;
          label742:
          localObject2 = d.z.MKo;
        }
      }
      label753:
      if (paramInt2 != 0) {
        this.rRt.add(new o(Integer.valueOf(((bb)paramn).cyq()), Integer.valueOf(4)));
      }
    }
    for (;;)
    {
      czA();
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "[onSceneEnd] cost=" + (SystemClock.uptimeMillis() - l) + "ms");
      AppMethodBeat.o(165586);
      return;
      this.rRv += 1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$Companion;", "", "()V", "TAG", "", "alives", "Ljava/util/HashSet;", "", "defaultHandlers", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "syncHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements ap.a
  {
    b(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(165584);
      if ((paramMessage != null) && (paramMessage.what == a.a(this.rRE)) && (a.b(this.rRE) == 0))
      {
        int i;
        if (!((Collection)a.c(this.rRE)).isEmpty()) {
          i = 1;
        }
        while (i != 0)
        {
          paramMessage = (o)a.c(this.rRE).peek();
          if (paramMessage != null)
          {
            a.a(this.rRE, ((Number)paramMessage.first).intValue());
            Object localObject = com.tencent.mm.kernel.g.ajC();
            p.g(localObject, "MMKernel.storage()");
            localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IGY, "");
            if (localObject == null)
            {
              paramMessage = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(165584);
              throw paramMessage;
              i = 0;
            }
            else
            {
              localObject = bt.aRa((String)localObject);
              paramMessage = new bb(u.aAu(), (byte[])localObject, a.b(this.rRE), ((Number)paramMessage.second).intValue());
              com.tencent.mm.kernel.g.aiU().b((n)paramMessage);
            }
          }
        }
      }
      AppMethodBeat.o(165584);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165585);
      this.rRE.fI(14845, 2);
      a.d(this.rRE);
      AppMethodBeat.o(165585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a
 * JD-Core Version:    0.7.0.1
 */