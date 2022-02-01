package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.api.e.a;
import com.tencent.mm.plugin.finder.cgi.bc;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.o;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MSG_SYNC_NEXT", "", "SYNC_FAIL_MAX_COUNT", "curSelector", "syncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "syncTask", "Ljava/lang/Runnable;", "sync_fail_count", "waitLinkedQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "addSyncHandler", "", "cmdId", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "checkLoop", "doNextSync", "doSync", "selector", "scene", "mergeSyncKey", "", "reqKey", "", "respKey", "onSceneEnd", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "selector2String", "unregister", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.finder.api.e
{
  private static final String TAG = "Finder.SyncExtension";
  private static final SparseArray<HashSet<com.tencent.mm.plugin.finder.api.f>> sac;
  private static final b sad;
  private static HashSet<Integer> sae;
  public static final a saf;
  private final ConcurrentLinkedQueue<o<Integer, Integer>> rZV;
  private int rZW;
  private int rZX;
  private final int rZY;
  private final int rZZ;
  private final aq saa;
  private final Runnable sab;
  
  static
  {
    AppMethodBeat.i(165595);
    saf = new a((byte)0);
    TAG = "Finder.SyncExtension";
    sac = new SparseArray();
    sad = new b();
    sae = new HashSet();
    AppMethodBeat.o(165595);
  }
  
  public a()
  {
    AppMethodBeat.i(165594);
    this.rZV = new ConcurrentLinkedQueue();
    this.rZY = 3;
    this.rZZ = 666;
    this.saa = new aq("finder_sync_thread", (aq.a)new b(this));
    this.sab = ((Runnable)new c(this));
    AppMethodBeat.o(165594);
  }
  
  private static String EB(int paramInt)
  {
    AppMethodBeat.i(165587);
    Object localObject = new StringBuffer();
    o[] arrayOfo = e.a.czl();
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
  
  private final void cBe()
  {
    AppMethodBeat.i(202020);
    this.saa.sendEmptyMessage(this.rZZ);
    AppMethodBeat.o(202020);
  }
  
  private final void cBf()
  {
    AppMethodBeat.i(165591);
    if (this.rZX >= this.rZY) {
      ae.i(TAG, "checkLoop finderAliveUI " + sae.size() + " sync_fail_count " + this.rZX + " so ignore checkloop");
    }
    if (sae.size() > 0)
    {
      this.saa.removeCallbacks(this.sab);
      aq localaq = this.saa;
      Runnable localRunnable = this.sab;
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      localaq.postDelayed(localRunnable, com.tencent.mm.plugin.finder.storage.b.cHr());
    }
    AppMethodBeat.o(165591);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.api.f paramf)
  {
    AppMethodBeat.i(165589);
    p.h(paramf, "handler");
    if ((HashSet)sac.get(paramInt) == null)
    {
      sac.append(paramInt, new HashSet());
      d.z localz = d.z.Nhr;
    }
    ((HashSet)sac.get(paramInt)).add(paramf);
    AppMethodBeat.o(165589);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165592);
    p.h(paramMMFinderUI, "activity");
    if (!sae.contains(Integer.valueOf(paramMMFinderUI.hashCode())))
    {
      sae.add(Integer.valueOf(paramMMFinderUI.hashCode()));
      paramMMFinderUI = TAG;
      StringBuilder localStringBuilder = new StringBuilder("Start msg Looper ");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      ae.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.b.cHr() + " size: " + sae.size() + ' ' + this.rZX);
      this.rZX = 0;
      cBf();
    }
    AppMethodBeat.o(165592);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.finder.api.f paramf)
  {
    AppMethodBeat.i(165590);
    p.h(paramf, "handler");
    HashSet localHashSet = (HashSet)sac.get(paramInt);
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
    sae.remove(Integer.valueOf(paramMMFinderUI.hashCode()));
    paramMMFinderUI = TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregister Looper ");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    ae.i(paramMMFinderUI, com.tencent.mm.plugin.finder.storage.b.cHr() + " size: " + sae.size() + ' ' + this.rZX);
    AppMethodBeat.o(165593);
  }
  
  public final void fG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165588);
    String str = com.tencent.mm.model.v.aAK();
    ae.i(TAG, "sync selector %d myFinderUser %s %s", new Object[] { Integer.valueOf(paramInt1), str, EB(paramInt1) });
    com.tencent.mm.plugin.report.service.g.yxI.f(19122, new Object[] { Integer.valueOf(paramInt2), bu.fpN() });
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(1292L, 1L, 1L, true);
    this.rZV.add(new o(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
    cBe();
    AppMethodBeat.o(165588);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(165586);
    long l = SystemClock.uptimeMillis();
    if (paramn == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderSync");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    ??? = ((bc)paramn).rr.aEU();
    if (??? == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
      AppMethodBeat.o(165586);
      throw paramString;
    }
    int i = ((ask)???).dvk;
    ae.i(TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", cmdList=" + ((bc)paramn).cAn().size() + ", (curSelector,selector) (" + this.rZW + ',' + i + "), continueFlag " + ((bc)paramn).czR());
    this.rZW = 0;
    this.rZV.poll();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.rZX = 0;
      paramInt1 = ((bc)paramn).getInterval();
      Object localObject2 = ((bc)paramn).cAn();
      ae.i(TAG, "onSceneEnd " + paramInt1 + " continueFlag " + ((bc)paramn).czR() + " cmdList " + ((List)localObject2).size());
      if (paramInt1 > 0)
      {
        paramString = com.tencent.mm.plugin.finder.storage.b.sHP;
        com.tencent.mm.plugin.finder.storage.b.FC(((bc)paramn).getInterval() * 1000);
      }
      paramString = ((bc)paramn).rr.aEU();
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncRequest");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      Object localObject3 = com.tencent.mm.platformtools.z.a(((ask)paramString).GJB);
      paramString = ((bc)paramn).rr.aEV();
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
        AppMethodBeat.o(165586);
        throw paramString;
      }
      ??? = com.tencent.mm.platformtools.z.a(((asl)paramString).GJB);
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
        paramString = ad.l((byte[])localObject3, (byte[])???);
        ae.i(TAG, "processFinderSyncKey, req " + bu.cH((byte[])localObject3) + " resp " + bu.cH((byte[])???) + " merge " + bu.cH(paramString));
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
        ??? = com.tencent.mm.kernel.g.ajR();
        p.g(???, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)???).ajA().set(am.a.Jbz, bu.cH(paramString));
        paramInt1 = 1;
        label569:
        paramInt2 = i;
        if (paramInt1 != 0)
        {
          paramInt2 = i;
          if (((bc)paramn).czR() != 0) {
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
        localObject2 = (ama)paramString.next();
        sad.a((ama)localObject2);
        ??? = (HashSet)sac.get(((ama)localObject2).cmdId);
        if (??? != null)
        {
          synchronized ((Iterable)???)
          {
            localObject3 = ((Iterable)???).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label742;
            }
            ((com.tencent.mm.plugin.finder.api.f)((Iterator)localObject3).next()).a((ama)localObject2);
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
          ae.i(TAG, "processFinderSyncKey, Sync Key Not change, not save");
          label737:
          paramInt1 = 0;
          break label569;
          label742:
          localObject2 = d.z.Nhr;
        }
      }
      label753:
      if (paramInt2 != 0) {
        this.rZV.add(new o(Integer.valueOf(((bc)paramn).czR()), Integer.valueOf(4)));
      }
    }
    for (;;)
    {
      cBe();
      ae.i(TAG, "[onSceneEnd] cost=" + (SystemClock.uptimeMillis() - l) + "ms");
      AppMethodBeat.o(165586);
      return;
      this.rZX += 1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$Companion;", "", "()V", "TAG", "", "alives", "Ljava/util/HashSet;", "", "defaultHandlers", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "syncHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements aq.a
  {
    b(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(165584);
      if ((paramMessage != null) && (paramMessage.what == a.a(this.sag)) && (a.b(this.sag) == 0))
      {
        int i;
        if (!((Collection)a.c(this.sag)).isEmpty()) {
          i = 1;
        }
        while (i != 0)
        {
          paramMessage = (o)a.c(this.sag).peek();
          if (paramMessage != null)
          {
            a.a(this.sag, ((Number)paramMessage.first).intValue());
            Object localObject = com.tencent.mm.kernel.g.ajR();
            p.g(localObject, "MMKernel.storage()");
            localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.Jbz, "");
            if (localObject == null)
            {
              paramMessage = new d.v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(165584);
              throw paramMessage;
              i = 0;
            }
            else
            {
              localObject = bu.aSx((String)localObject);
              paramMessage = new bc(com.tencent.mm.model.v.aAK(), (byte[])localObject, a.b(this.sag), ((Number)paramMessage.second).intValue());
              com.tencent.mm.kernel.g.ajj().b((n)paramMessage);
            }
          }
        }
      }
      AppMethodBeat.o(165584);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165585);
      this.sag.fG(14845, 2);
      a.d(this.sag);
      AppMethodBeat.o(165585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a
 * JD-Core Version:    0.7.0.1
 */