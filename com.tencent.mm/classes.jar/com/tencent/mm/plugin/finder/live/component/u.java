package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.lifecycle.r;
import com.tencent.c.a.a.a.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bk.b;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.at;
import com.tencent.mm.plugin.finder.live.report.s.au;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "bindMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;)V", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "luckyMoneyShowInfoList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "resultReceiver", "Lcom/tencent/mm/plugin/finder/live/component/LuckyMoneyResultReceiev;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "getLotteryBottom", "", "()Ljava/lang/Float;", "getLotteryShowingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "getRedPacketType", "", "handleRecvLuckyMoneyErr", "", "errCode", "", "onAttach", "callback", "onBubbleClick", "onDetach", "openLuckyMoney", "showInfo", "removeLuckyMoneyBySendId", "sendId", "removeLuckyMoneyShowInfo", "updateLuckyMoneyShowList", "", "luckyMoneyList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "updateStatus", "Companion", "LuckyMoneyShowInfo", "plugin-finder_release"})
public final class u
  implements t.b
{
  public static final a ybO;
  private final com.tencent.mm.live.c.b kCL;
  final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private t.c ybJ;
  private final ConcurrentLinkedDeque<b> ybK;
  private LuckyMoneyResultReceiev ybL;
  final an ybM;
  private final com.tencent.mm.plugin.finder.live.viewmodel.data.h ybN;
  
  static
  {
    AppMethodBeat.i(290296);
    ybO = new a((byte)0);
    AppMethodBeat.o(290296);
  }
  
  public u(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.c.b paramb, an paraman, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(290295);
    this.xYp = parama;
    this.kCL = paramb;
    this.ybM = paraman;
    this.ybN = paramh;
    this.ybK = new ConcurrentLinkedDeque();
    AppMethodBeat.o(290295);
  }
  
  private final boolean el(List<? extends bbx> paramList)
  {
    AppMethodBeat.i(290285);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateLuckyMoneyShowList: filtered remote luckyMoneyList.size:" + paramList.size() + ", local list size:" + this.ybK.size());
    boolean bool;
    for (;;)
    {
      synchronized ((Iterable)j.m((Iterable)paramList))
      {
        Iterator localIterator1 = ???.iterator();
        bool = false;
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject = (bbx)localIterator1.next();
        Iterator localIterator2 = ((Iterable)this.ybK).iterator();
        if (localIterator2.hasNext())
        {
          paramList = localIterator2.next();
          if (!((b)paramList).ybP.equals(((bbx)localObject).SKs)) {
            continue;
          }
          paramList = (b)paramList;
          if (paramList == null) {
            break label182;
          }
          Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateLuckyMoneyShowList: update local info: ".concat(String.valueOf(paramList)));
        }
      }
      paramList = null;
      continue;
      label182:
      paramList = this.ybK;
      Object localObject = new b((bbx)localObject);
      Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateLuckyMoneyShowList: add local info: ".concat(String.valueOf(localObject)));
      paramList.offerFirst(localObject);
      bool = true;
    }
    paramList = x.aazN;
    AppMethodBeat.o(290285);
    return bool;
  }
  
  public final void a(t.c paramc)
  {
    AppMethodBeat.i(290292);
    p.k(paramc, "callback");
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "onAttach");
    this.ybJ = paramc;
    paramc = this.ybJ;
    if (paramc != null)
    {
      paramc.initView();
      AppMethodBeat.o(290292);
      return;
    }
    AppMethodBeat.o(290292);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(290287);
    p.k(paramb, "showInfo");
    ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().v(((c)this.xYp.business(c.class)).liveInfo.liveId, paramb.ybP);
    this.ybK.remove(paramb);
    d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(290287);
  }
  
  public final void aBV(String paramString)
  {
    AppMethodBeat.i(290286);
    p.k(paramString, "sendId");
    Iterator localIterator = ((Iterable)this.ybK).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((b)localObject).ybP.equals(paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (b)paramString;
      if (paramString == null) {
        break;
      }
      a(paramString);
      AppMethodBeat.o(290286);
      return;
    }
    AppMethodBeat.o(290286);
  }
  
  public final boolean dxC()
  {
    AppMethodBeat.i(290284);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateStatus bindMicUser:" + this.ybN + " liveData.business(LiveCommonSlice::class.java).luckyMoneyList.size:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgc.size());
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgc;
    p.j(localObject1, "liveData.business(LiveCo…lass.java).luckyMoneyList");
    Collection localCollection;
    for (;;)
    {
      synchronized ((Iterable)localObject1)
      {
        localCollection = (Collection)new ArrayList();
        Iterator localIterator = ???.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject3 = localIterator.next();
        bbx localbbx = (bbx)localObject3;
        if (!((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().w(((c)this.xYp.business(c.class)).liveInfo.liveId, localbbx.SKs)) {
          break label252;
        }
        localObject1 = this.ybN;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).sessionId;
          if ((!n.L((String)localObject1, localbbx.SKx, false)) || (localbbx.status != 0)) {
            break label252;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          localCollection.add(localObject3);
        }
      }
      localList = null;
      continue;
      label252:
      int i = 0;
    }
    List localList = (List)localCollection;
    if (el(localList)) {
      d.uiThread((kotlin.g.a.a)new e(this));
    }
    if (!((Collection)this.ybK).isEmpty())
    {
      AppMethodBeat.o(290284);
      return true;
    }
    AppMethodBeat.o(290284);
    return false;
  }
  
  public final String dxD()
  {
    AppMethodBeat.i(290289);
    if (this.ybK.isEmpty())
    {
      AppMethodBeat.o(290289);
      return null;
    }
    Object localObject = (b)this.ybK.peekFirst();
    if (localObject != null)
    {
      localObject = ((b)localObject).ktE;
      AppMethodBeat.o(290289);
      return localObject;
    }
    AppMethodBeat.o(290289);
    return null;
  }
  
  public final bk.b dxE()
  {
    AppMethodBeat.i(290290);
    com.tencent.mm.live.c.b localb = this.kCL;
    Object localObject = localb;
    if (!(localb instanceof com.tencent.mm.plugin.finder.live.view.a)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.finder.live.view.a)localObject;
    if (localObject != null)
    {
      localObject = (bk)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(bk.class);
      if (localObject != null)
      {
        localObject = ((bk)localObject).ytM;
        if (localObject != null)
        {
          localObject = (bk.b)((r)localObject).getValue();
          AppMethodBeat.o(290290);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(290290);
    return null;
  }
  
  public final Float dxF()
  {
    AppMethodBeat.i(290291);
    com.tencent.mm.live.c.b localb = this.kCL;
    Object localObject = localb;
    if (!(localb instanceof com.tencent.mm.plugin.finder.live.view.a)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.finder.live.view.a)localObject;
    if (localObject != null)
    {
      localObject = (bk)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(bk.class);
      if (localObject != null)
      {
        float f = ((bk)localObject).dxG();
        AppMethodBeat.o(290291);
        return Float.valueOf(f);
      }
    }
    AppMethodBeat.o(290291);
    return null;
  }
  
  public final void dxs()
  {
    AppMethodBeat.i(290288);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "onBubbleClick: current size:" + this.ybK.size());
    b localb = (b)this.ybK.peekFirst();
    Object localObject2 = m.yCt;
    s.au localau = s.au.yJS;
    if (localb != null)
    {
      localObject1 = localb.ktE;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label238;
      }
      localObject1 = s.at.yJO;
      label77:
      m.a((m)localObject2, localau, (s.at)localObject1);
      localObject1 = this.ybJ;
      if (localObject1 == null) {
        break label245;
      }
    }
    label238:
    label245:
    for (Object localObject1 = ((t.c)localObject1).dsB();; localObject1 = null)
    {
      if ((localb == null) || (localObject1 == null)) {
        break label250;
      }
      if (this.ybL == null)
      {
        localObject2 = MMHandler.createFreeHandler(Looper.getMainLooper());
        p.j(localObject2, "MMHandler.createFreeHand…r(Looper.getMainLooper())");
        this.ybL = new LuckyMoneyResultReceiev(this, (Handler)localObject2);
      }
      localObject2 = this.ybL;
      if (localObject2 != null)
      {
        p.k(localb, "info");
        ((LuckyMoneyResultReceiev)localObject2).ycS = new WeakReference(localb);
        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "setLuckyMoneyShowInfo info:".concat(String.valueOf(localb)));
      }
      localObject2 = this.ybM;
      if (localObject2 == null) {
        break label250;
      }
      ((an)localObject2).a((Activity)localObject1, localb.ybR, (ResultReceiver)this.ybL, (kotlin.g.a.b)new c(this));
      AppMethodBeat.o(290288);
      return;
      localObject1 = null;
      break;
      localObject1 = s.at.yJP;
      break label77;
    }
    label250:
    AppMethodBeat.o(290288);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(290294);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "onDetach " + Util.getStack());
    this.ybJ = null;
    AppMethodBeat.o(290294);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$Companion;", "", "()V", "TAG", "", "clearCache", "", "liveId", "", "initCache", "saveCache", "plugin-finder_release"})
  public static final class a
  {
    public static void Lh(long paramLong)
    {
      AppMethodBeat.i(257966);
      ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().Lh(paramLong);
      AppMethodBeat.o(257966);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "", "originData", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;)V", "micId", "", "getMicId", "()Ljava/lang/String;", "getOriginData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "sendId", "getSendId", "state", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "getState", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "setState", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    final String ktE;
    final String ybP;
    private t.a ybQ;
    final bbx ybR;
    
    public b(bbx parambbx)
    {
      AppMethodBeat.i(289752);
      this.ybR = parambbx;
      String str = this.ybR.SKs;
      parambbx = str;
      if (str == null) {
        parambbx = "";
      }
      this.ybP = parambbx;
      str = this.ybR.SKx;
      parambbx = str;
      if (str == null) {
        parambbx = "";
      }
      this.ktE = parambbx;
      this.ybQ = t.a.ybF;
      AppMethodBeat.o(289752);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(289754);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (!p.h(this.ybR, paramObject.ybR)) {}
        }
      }
      else
      {
        AppMethodBeat.o(289754);
        return true;
      }
      AppMethodBeat.o(289754);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(289753);
      bbx localbbx = this.ybR;
      if (localbbx != null)
      {
        int i = localbbx.hashCode();
        AppMethodBeat.o(289753);
        return i;
      }
      AppMethodBeat.o(289753);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(289751);
      String str = new StringBuilder("id = ").append(this.ybP).toString() + ", " + new StringBuilder("micId = ").append(this.ktE).toString() + ", " + new StringBuilder("state = ").append(this.ybQ).toString() + "\n";
      p.j(str, "StringBuilder().append(\"…              .toString()");
      AppMethodBeat.o(289751);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "invoke", "com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$openLuckyMoney$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    c(u paramu)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(u paramu)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.u
 * JD-Core Version:    0.7.0.1
 */