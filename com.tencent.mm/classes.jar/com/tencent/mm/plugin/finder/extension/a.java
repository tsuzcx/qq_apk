package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import d.o;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "enterToSync", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "transformToServerScene", "localScene", "unregister", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.al.g, d
{
  private static final String TAG = "Finder.SyncExtension";
  private static final SparseArray<HashSet<com.tencent.mm.plugin.finder.api.e>> qsV;
  private static final b qsW;
  private static HashSet<Integer> qsX;
  public static final a qsY;
  private int KMp;
  private final int KMq;
  private final ConcurrentLinkedQueue<o<Integer, Integer>> qsQ;
  private int qsR;
  private final int qsS;
  private final ap qsT;
  private final Runnable qsU;
  
  static
  {
    AppMethodBeat.i(165595);
    qsY = new a((byte)0);
    TAG = "Finder.SyncExtension";
    qsV = new SparseArray();
    qsW = new b();
    qsX = new HashSet();
    AppMethodBeat.o(165595);
  }
  
  public a()
  {
    AppMethodBeat.i(165594);
    this.qsQ = new ConcurrentLinkedQueue();
    this.qsS = 3;
    this.KMq = 666;
    this.qsT = new ap("finder_sync_thread", (ap.a)new b(this));
    this.qsU = ((Runnable)new c(this));
    AppMethodBeat.o(165594);
  }
  
  private static String Cw(int paramInt)
  {
    AppMethodBeat.i(165587);
    Object localObject = new StringBuffer();
    o[] arrayOfo = d.a.ckr();
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
    k.g(localObject, "buf.toString()");
    AppMethodBeat.o(165587);
    return localObject;
  }
  
  private final void clh()
  {
    AppMethodBeat.i(165591);
    if (this.qsR >= this.qsS) {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "checkLoop finderAliveUI " + qsX.size() + " sync_fail_count " + this.qsR + " so ignore checkloop");
    }
    if (qsX.size() > 0)
    {
      this.qsT.removeCallbacks(this.qsU);
      ap localap = this.qsT;
      Runnable localRunnable = this.qsU;
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      localap.postDelayed(localRunnable, com.tencent.mm.plugin.finder.storage.b.coU());
    }
    AppMethodBeat.o(165591);
  }
  
  private final void cli()
  {
    AppMethodBeat.i(178141);
    fu(6653, 7);
    AppMethodBeat.o(178141);
  }
  
  private final void fSE()
  {
    AppMethodBeat.i(197551);
    this.qsT.sendEmptyMessage(this.KMq);
    AppMethodBeat.o(197551);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.api.e parame)
  {
    AppMethodBeat.i(165589);
    k.h(parame, "handler");
    if ((HashSet)qsV.get(paramInt) == null)
    {
      qsV.append(paramInt, new HashSet());
      y localy = y.JfV;
    }
    ((HashSet)qsV.get(paramInt)).add(parame);
    AppMethodBeat.o(165589);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165592);
    k.h(paramMMFinderUI, "activity");
    if (!qsX.contains(Integer.valueOf(paramMMFinderUI.hashCode())))
    {
      qsX.add(Integer.valueOf(paramMMFinderUI.hashCode()));
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("Start msg Looper ");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.sdk.platformtools.ad.i(str, com.tencent.mm.plugin.finder.storage.b.coU() + " size: " + qsX.size() + ' ' + this.qsR);
      this.qsR = 0;
      if ((paramMMFinderUI instanceof FinderTimelineUI)) {
        cli();
      }
      clh();
    }
    AppMethodBeat.o(165592);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.finder.api.e parame)
  {
    AppMethodBeat.i(165590);
    k.h(parame, "handler");
    HashSet localHashSet = (HashSet)qsV.get(paramInt);
    if (localHashSet != null)
    {
      localHashSet.remove(parame);
      AppMethodBeat.o(165590);
      return;
    }
    AppMethodBeat.o(165590);
  }
  
  public final void b(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165593);
    k.h(paramMMFinderUI, "activity");
    qsX.remove(Integer.valueOf(paramMMFinderUI.hashCode()));
    paramMMFinderUI = TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregister Looper ");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    com.tencent.mm.sdk.platformtools.ad.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.b.coU() + " size: " + qsX.size() + ' ' + this.qsR);
    AppMethodBeat.o(165593);
  }
  
  public final void fu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165588);
    String str = u.aqO();
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "sync selector %d myFinderUser %s %s", new Object[] { Integer.valueOf(paramInt1), str, Cw(paramInt1) });
    h.vKh.f(19122, new Object[] { Integer.valueOf(paramInt2), bt.eGN() });
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(1292L, 1L, 1L, true);
    this.qsQ.add(new o(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
    fSE();
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
    ??? = ((com.tencent.mm.plugin.finder.cgi.ab)paramn).rr.auL();
    if (??? == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    int i = ((all)???).hkT;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", cmdList=" + ((com.tencent.mm.plugin.finder.cgi.ab)paramn).ckX().size() + ", (curSelector,selector) (" + this.KMp + ',' + i + "), continueFlag " + ((com.tencent.mm.plugin.finder.cgi.ab)paramn).ckO());
    this.KMp = 0;
    this.qsQ.poll();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qsR = 0;
      paramInt1 = ((com.tencent.mm.plugin.finder.cgi.ab)paramn).getInterval();
      Object localObject2 = ((com.tencent.mm.plugin.finder.cgi.ab)paramn).ckX();
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "onSceneEnd " + paramInt1 + " continueFlag " + ((com.tencent.mm.plugin.finder.cgi.ab)paramn).ckO() + " cmdList " + ((List)localObject2).size());
      if (paramInt1 > 0)
      {
        paramString = com.tencent.mm.plugin.finder.storage.b.qJA;
        com.tencent.mm.plugin.finder.storage.b.CO(((com.tencent.mm.plugin.finder.cgi.ab)paramn).getInterval() * 1000);
      }
      paramString = ((com.tencent.mm.plugin.finder.cgi.ab)paramn).rr.auL();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      Object localObject3 = z.a(((all)paramString).DmH);
      paramString = ((com.tencent.mm.plugin.finder.cgi.ab)paramn).rr.auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      ??? = z.a(((alm)paramString).DmH);
      i = 0;
      paramInt2 = i;
      if (??? != null)
      {
        k.g(localObject3, "reqKey");
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
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "processFinderSyncKey, req " + bt.cy((byte[])localObject3) + " resp " + bt.cy((byte[])???) + " merge " + bt.cy(paramString));
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
        paramString = z.a(z.am(paramString));
        if (Arrays.equals((byte[])localObject3, paramString)) {
          break label728;
        }
        ??? = com.tencent.mm.kernel.g.afB();
        k.g(???, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)???).afk().set(ae.a.Fwq, bt.cy(paramString));
        paramInt1 = 1;
        label569:
        paramInt2 = i;
        if (paramInt1 != 0)
        {
          paramInt2 = i;
          if (((com.tencent.mm.plugin.finder.cgi.ab)paramn).ckO() != 0) {
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
        localObject2 = (ahv)paramString.next();
        qsW.a((ahv)localObject2);
        ??? = (HashSet)qsV.get(((ahv)localObject2).cmdId);
        if (??? != null)
        {
          synchronized ((Iterable)???)
          {
            localObject3 = ((Iterable)???).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label742;
            }
            ((com.tencent.mm.plugin.finder.api.e)((Iterator)localObject3).next()).a((ahv)localObject2);
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
          localObject2 = y.JfV;
        }
      }
      label753:
      if (paramInt2 != 0) {
        this.qsQ.add(new o(Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.ab)paramn).ckO()), Integer.valueOf(4)));
      }
    }
    for (;;)
    {
      fSE();
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "[onSceneEnd] cost=" + (SystemClock.uptimeMillis() - l) + "ms");
      AppMethodBeat.o(165586);
      return;
      this.qsR += 1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$Companion;", "", "()V", "TAG", "", "alives", "Ljava/util/HashSet;", "", "defaultHandlers", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "syncHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements ap.a
  {
    b(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(165584);
      if ((paramMessage.what == a.c(this.qsZ)) && (a.d(this.qsZ) == 0))
      {
        int i;
        if (!((Collection)a.a(this.qsZ)).isEmpty()) {
          i = 1;
        }
        while (i != 0)
        {
          paramMessage = (o)a.a(this.qsZ).peek();
          a.a(this.qsZ, ((Number)paramMessage.first).intValue());
          Object localObject = com.tencent.mm.kernel.g.afB();
          k.g(localObject, "MMKernel.storage()");
          localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fwq, "");
          if (localObject == null)
          {
            paramMessage = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(165584);
            throw paramMessage;
            i = 0;
          }
          else
          {
            localObject = bt.aGd((String)localObject);
            paramMessage = new com.tencent.mm.plugin.finder.cgi.ab(u.aqO(), (byte[])localObject, a.d(this.qsZ), a.Cx(((Number)paramMessage.second).intValue()));
            com.tencent.mm.kernel.g.aeS().b((n)paramMessage);
          }
        }
      }
      AppMethodBeat.o(165584);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165585);
      this.qsZ.fu(6653, 2);
      a.b(this.qsZ);
      AppMethodBeat.o(165585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a
 * JD-Core Version:    0.7.0.1
 */