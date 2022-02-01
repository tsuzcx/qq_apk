package com.tencent.mm.plugin.finder.extension;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import d.o;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "enterToSync", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "transformToServerScene", "localScene", "unregister", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.ak.g, d
{
  private static final String TAG = "Finder.SyncExtension";
  private static final SparseArray<HashSet<com.tencent.mm.plugin.finder.api.e>> rea;
  private static final b reb;
  private static HashSet<Integer> rec;
  public static final a.a red;
  private final ConcurrentLinkedQueue<o<Integer, Integer>> rdT;
  private int rdU;
  private int rdV;
  private final int rdW;
  private final int rdX;
  private final ao rdY;
  private final Runnable rdZ;
  
  static
  {
    AppMethodBeat.i(165595);
    red = new a.a((byte)0);
    TAG = "Finder.SyncExtension";
    rea = new SparseArray();
    reb = new b();
    rec = new HashSet();
    AppMethodBeat.o(165595);
  }
  
  public a()
  {
    AppMethodBeat.i(165594);
    this.rdT = new ConcurrentLinkedQueue();
    this.rdW = 3;
    this.rdX = 666;
    this.rdY = new ao("finder_sync_thread", (ao.a)new a.b(this));
    this.rdZ = ((Runnable)new a.c(this));
    AppMethodBeat.o(165594);
  }
  
  private static String Du(int paramInt)
  {
    AppMethodBeat.i(165587);
    Object localObject = new StringBuffer();
    o[] arrayOfo = d.a.crY();
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
  
  private final void ctu()
  {
    AppMethodBeat.i(201432);
    this.rdY.sendEmptyMessage(this.rdX);
    AppMethodBeat.o(201432);
  }
  
  private final void ctv()
  {
    AppMethodBeat.i(165591);
    if (this.rdV >= this.rdW) {
      ac.i(TAG, "checkLoop finderAliveUI " + rec.size() + " sync_fail_count " + this.rdV + " so ignore checkloop");
    }
    if (rec.size() > 0)
    {
      this.rdY.removeCallbacks(this.rdZ);
      ao localao = this.rdY;
      Runnable localRunnable = this.rdZ;
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      localao.postDelayed(localRunnable, com.tencent.mm.plugin.finder.storage.b.cyr());
    }
    AppMethodBeat.o(165591);
  }
  
  private final void ctw()
  {
    AppMethodBeat.i(178141);
    fx(14845, 7);
    AppMethodBeat.o(178141);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.api.e parame)
  {
    AppMethodBeat.i(165589);
    k.h(parame, "handler");
    if ((HashSet)rea.get(paramInt) == null)
    {
      rea.append(paramInt, new HashSet());
      y localy = y.KTp;
    }
    ((HashSet)rea.get(paramInt)).add(parame);
    AppMethodBeat.o(165589);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165592);
    k.h(paramMMFinderUI, "activity");
    if (!rec.contains(Integer.valueOf(paramMMFinderUI.hashCode())))
    {
      rec.add(Integer.valueOf(paramMMFinderUI.hashCode()));
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("Start msg Looper ");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ac.i(str, com.tencent.mm.plugin.finder.storage.b.cyr() + " size: " + rec.size() + ' ' + this.rdV);
      this.rdV = 0;
      if ((paramMMFinderUI instanceof FinderTimelineUI)) {
        ctw();
      }
      ctv();
    }
    AppMethodBeat.o(165592);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.finder.api.e parame)
  {
    AppMethodBeat.i(165590);
    k.h(parame, "handler");
    HashSet localHashSet = (HashSet)rea.get(paramInt);
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
    rec.remove(Integer.valueOf(paramMMFinderUI.hashCode()));
    paramMMFinderUI = TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregister Looper ");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    ac.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.b.cyr() + " size: " + rec.size() + ' ' + this.rdV);
    AppMethodBeat.o(165593);
  }
  
  public final void fx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165588);
    String str = u.axE();
    ac.i(TAG, "sync selector %d myFinderUser %s %s", new Object[] { Integer.valueOf(paramInt1), str, Du(paramInt1) });
    h.wUl.f(19122, new Object[] { Integer.valueOf(paramInt2), bs.eWi() });
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(1292L, 1L, 1L, true);
    this.rdT.add(new o(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
    ctu();
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
    ??? = ((at)paramn).rr.aBC();
    if (??? == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    int i = ((aog)???).hLw;
    ac.i(TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", cmdList=" + ((at)paramn).csQ().size() + ", (curSelector,selector) (" + this.rdU + ',' + i + "), continueFlag " + ((at)paramn).csz());
    this.rdU = 0;
    this.rdT.poll();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.rdV = 0;
      paramInt1 = ((at)paramn).getInterval();
      Object localObject2 = ((at)paramn).csQ();
      ac.i(TAG, "onSceneEnd " + paramInt1 + " continueFlag " + ((at)paramn).csz() + " cmdList " + ((List)localObject2).size());
      if (paramInt1 > 0)
      {
        paramString = com.tencent.mm.plugin.finder.storage.b.rCU;
        com.tencent.mm.plugin.finder.storage.b.DZ(((at)paramn).getInterval() * 1000);
      }
      paramString = ((at)paramn).rr.aBC();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      Object localObject3 = z.a(((aog)paramString).EHs);
      paramString = ((at)paramn).rr.aBD();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      ??? = z.a(((aoh)paramString).EHs);
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
        paramString = ad.k((byte[])localObject3, (byte[])???);
        ac.i(TAG, "processFinderSyncKey, req " + bs.cx((byte[])localObject3) + " resp " + bs.cx((byte[])???) + " merge " + bs.cx(paramString));
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
        paramString = z.a(z.al(paramString));
        if (Arrays.equals((byte[])localObject3, paramString)) {
          break label728;
        }
        ??? = com.tencent.mm.kernel.g.agR();
        k.g(???, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)???).agA().set(ah.a.GUs, bs.cx(paramString));
        paramInt1 = 1;
        label569:
        paramInt2 = i;
        if (paramInt1 != 0)
        {
          paramInt2 = i;
          if (((at)paramn).csz() != 0) {
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
        localObject2 = (aiy)paramString.next();
        reb.a((aiy)localObject2);
        ??? = (HashSet)rea.get(((aiy)localObject2).cmdId);
        if (??? != null)
        {
          synchronized ((Iterable)???)
          {
            localObject3 = ((Iterable)???).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label742;
            }
            ((com.tencent.mm.plugin.finder.api.e)((Iterator)localObject3).next()).a((aiy)localObject2);
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
          ac.i(TAG, "processFinderSyncKey, Sync Key Not change, not save");
          label737:
          paramInt1 = 0;
          break label569;
          label742:
          localObject2 = y.KTp;
        }
      }
      label753:
      if (paramInt2 != 0) {
        this.rdT.add(new o(Integer.valueOf(((at)paramn).csz()), Integer.valueOf(4)));
      }
    }
    for (;;)
    {
      ctu();
      ac.i(TAG, "[onSceneEnd] cost=" + (SystemClock.uptimeMillis() - l) + "ms");
      AppMethodBeat.o(165586);
      return;
      this.rdV += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a
 * JD-Core Version:    0.7.0.1
 */