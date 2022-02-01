package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.lifecycle.x;
import com.tencent.d.a.a.a.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.plugin.ba;
import com.tencent.mm.plugin.finder.live.plugin.ba.b;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bh;
import com.tencent.mm.plugin.finder.live.report.q.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "bindMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;)V", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "luckyMoneyShowInfoList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "resultReceiver", "Lcom/tencent/mm/plugin/finder/live/component/LuckyMoneyResultReceiev;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "getLotteryBottom", "", "()Ljava/lang/Float;", "getLotteryShowingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "getRedPacketType", "", "handleRecvLuckyMoneyErr", "", "errCode", "", "onAttach", "callback", "onBubbleClick", "onDetach", "openLuckyMoney", "showInfo", "removeLuckyMoneyBySendId", "sendId", "removeLuckyMoneyShowInfo", "updateLuckyMoneyShowList", "", "luckyMoneyList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "updateStatus", "Companion", "LuckyMoneyShowInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  implements ai.b
{
  public static final a CzY;
  private final com.tencent.mm.plugin.finder.live.viewmodel.data.h CAa;
  private ai.c CAb;
  private final ConcurrentLinkedDeque<b> CAc;
  private LuckyMoneyResultReceiev CAd;
  final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  final ap CzZ;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(352796);
    CzY = new a((byte)0);
    AppMethodBeat.o(352796);
  }
  
  public aj(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb, ap paramap, com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(352763);
    this.CvU = parama;
    this.nfT = paramb;
    this.CzZ = paramap;
    this.CAa = paramh;
    this.CAc = new ConcurrentLinkedDeque();
    AppMethodBeat.o(352763);
  }
  
  private final boolean gp(List<? extends bls> paramList)
  {
    AppMethodBeat.i(352774);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateLuckyMoneyShowList: filtered remote luckyMoneyList.size:" + paramList.size() + ", local list size:" + this.CAc.size());
    boolean bool;
    for (;;)
    {
      synchronized ((Iterable)p.m((Iterable)paramList))
      {
        Iterator localIterator = ???.iterator();
        bool = false;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (bls)localIterator.next();
        localObject2 = ((Iterable)this.CAc).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          paramList = ((Iterator)localObject2).next();
          if (!((b)paramList).CAf.equals(((bls)localObject1).ZOX)) {
            continue;
          }
          paramList = (b)paramList;
          if (paramList == null) {
            break label179;
          }
          Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", s.X("updateLuckyMoneyShowList: update local info: ", paramList));
        }
      }
      paramList = null;
      continue;
      label179:
      paramList = this.CAc;
      Object localObject1 = new b((bls)localObject1);
      Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", s.X("updateLuckyMoneyShowList: add local info: ", localObject1));
      Object localObject2 = ah.aiuX;
      paramList.offerFirst(localObject1);
      bool = true;
    }
    paramList = ah.aiuX;
    AppMethodBeat.o(352774);
    return bool;
  }
  
  public final void a(ai.c paramc)
  {
    AppMethodBeat.i(352863);
    s.u(paramc, "callback");
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "onAttach");
    this.CAb = paramc;
    paramc = this.CAb;
    if (paramc != null) {
      paramc.initView();
    }
    AppMethodBeat.o(352863);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(352823);
    s.u(paramb, "showInfo");
    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().F(((f)this.CvU.business(f.class)).liveInfo.liveId, paramb.CAf);
    this.CAc.remove(paramb);
    d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(352823);
  }
  
  public final void awr(String paramString)
  {
    AppMethodBeat.i(352816);
    s.u(paramString, "sendId");
    Iterator localIterator = ((Iterable)this.CAc).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((b)localObject).CAf.equals(paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (b)paramString;
      if (paramString != null) {
        a(paramString);
      }
      AppMethodBeat.o(352816);
      return;
    }
  }
  
  public final boolean eiE()
  {
    AppMethodBeat.i(352809);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateStatus bindMicUser:" + this.CAa + " liveData.business(LiveCommonSlice::class.java).luckyMoneyList.size:" + ((e)this.CvU.business(e.class)).EdS.size());
    Object localObject1 = ((e)this.CvU.business(e.class)).EdS;
    s.s(localObject1, "liveData.business(LiveCo…lass.java).luckyMoneyList");
    for (;;)
    {
      Collection localCollection;
      synchronized ((Iterable)localObject1)
      {
        localCollection = (Collection)new ArrayList();
        Iterator localIterator = ???.iterator();
        if (!localIterator.hasNext()) {
          break label252;
        }
        Object localObject4 = localIterator.next();
        bls localbls = (bls)localObject4;
        if (!((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().G(((f)this.CvU.business(f.class)).liveInfo.liveId, localbls.ZOX)) {
          break label313;
        }
        localObject1 = this.CAa;
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((!n.T((String)localObject1, localbls.ZPd, false)) || (localbls.status != 0)) {
            break label313;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          localCollection.add(localObject4);
        }
      }
      Object localObject3 = localObject2.sessionId;
      continue;
      label252:
      localObject3 = (List)localCollection;
      if (gp((List)localObject3)) {
        d.uiThread((kotlin.g.a.a)new e(this));
      }
      if (!((Collection)this.CAc).isEmpty())
      {
        AppMethodBeat.o(352809);
        return true;
      }
      AppMethodBeat.o(352809);
      return false;
      label313:
      int i = 0;
    }
  }
  
  public final String eiF()
  {
    AppMethodBeat.i(352843);
    if (this.CAc.isEmpty())
    {
      AppMethodBeat.o(352843);
      return null;
    }
    Object localObject = (b)this.CAc.peekFirst();
    if (localObject == null)
    {
      AppMethodBeat.o(352843);
      return null;
    }
    localObject = ((b)localObject).mXx;
    AppMethodBeat.o(352843);
    return localObject;
  }
  
  public final ba.b eiG()
  {
    AppMethodBeat.i(352850);
    Object localObject = this.nfT;
    if ((localObject instanceof com.tencent.mm.plugin.finder.live.view.a)) {}
    for (localObject = (com.tencent.mm.plugin.finder.live.view.a)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(352850);
      return null;
    }
    localObject = (ba)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(ba.class);
    if (localObject == null)
    {
      AppMethodBeat.o(352850);
      return null;
    }
    localObject = ((ba)localObject).Deh;
    if (localObject == null)
    {
      AppMethodBeat.o(352850);
      return null;
    }
    localObject = (ba.b)((x)localObject).getValue();
    AppMethodBeat.o(352850);
    return localObject;
  }
  
  public final Float eiH()
  {
    AppMethodBeat.i(352855);
    Object localObject = this.nfT;
    if ((localObject instanceof com.tencent.mm.plugin.finder.live.view.a)) {}
    for (localObject = (com.tencent.mm.plugin.finder.live.view.a)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(352855);
      return null;
    }
    localObject = (ba)((com.tencent.mm.plugin.finder.live.view.a)localObject).getPlugin(ba.class);
    if (localObject == null)
    {
      AppMethodBeat.o(352855);
      return null;
    }
    float f = ((ba)localObject).eiI();
    AppMethodBeat.o(352855);
    return Float.valueOf(f);
  }
  
  public final void eij()
  {
    AppMethodBeat.i(352835);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", s.X("onBubbleClick: current size:", Integer.valueOf(this.CAc.size())));
    b localb = (b)this.CAc.peekFirst();
    Object localObject2 = (cf)k.Doi;
    q.bi localbi = q.bi.DAV;
    if (localb == null)
    {
      localObject1 = null;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label226;
      }
      localObject1 = q.bh.DAR;
      label70:
      cf.a.a((cf)localObject2, localbi, (q.bh)localObject1);
      localObject1 = this.CAb;
      if (localObject1 != null) {
        break label233;
      }
    }
    label226:
    label233:
    for (Object localObject1 = null;; localObject1 = ((ai.c)localObject1).dUP())
    {
      if ((localb != null) && (localObject1 != null))
      {
        if (this.CAd == null)
        {
          localObject2 = MMHandler.createFreeHandler(Looper.getMainLooper());
          s.s(localObject2, "createFreeHandler(Looper.getMainLooper())");
          this.CAd = new LuckyMoneyResultReceiev(this, (Handler)localObject2);
        }
        localObject2 = this.CAd;
        if (localObject2 != null)
        {
          s.u(localb, "info");
          ((LuckyMoneyResultReceiev)localObject2).CBj = new WeakReference(localb);
          Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", s.X("setLuckyMoneyShowInfo info:", localb));
        }
        localObject2 = this.CzZ;
        if (localObject2 != null) {
          ((ap)localObject2).a((Activity)localObject1, localb.CAe, (ResultReceiver)this.CAd, (kotlin.g.a.b)new c(this));
        }
      }
      AppMethodBeat.o(352835);
      return;
      localObject1 = localb.mXx;
      break;
      localObject1 = q.bh.DAS;
      break label70;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(352867);
    Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", s.X("onDetach ", Util.getStack()));
    this.CAb = null;
    AppMethodBeat.o(352867);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$Companion;", "", "()V", "TAG", "", "clearCache", "", "liveId", "", "initCache", "saveCache", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void nU(long paramLong)
    {
      AppMethodBeat.i(352959);
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().nU(paramLong);
      AppMethodBeat.o(352959);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "", "originData", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;)V", "micId", "", "getMicId", "()Ljava/lang/String;", "getOriginData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "sendId", "getSendId", "state", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "getState", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "setState", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final bls CAe;
    final String CAf;
    private ai.a CAg;
    final String mXx;
    
    public b(bls parambls)
    {
      AppMethodBeat.i(352948);
      this.CAe = parambls;
      String str = this.CAe.ZOX;
      parambls = str;
      if (str == null) {
        parambls = "";
      }
      this.CAf = parambls;
      str = this.CAe.ZPd;
      parambls = str;
      if (str == null) {
        parambls = "";
      }
      this.mXx = parambls;
      this.CAg = ai.a.CzU;
      AppMethodBeat.o(352948);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(352981);
      if (this == paramObject)
      {
        AppMethodBeat.o(352981);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(352981);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.CAe, paramObject.CAe))
      {
        AppMethodBeat.o(352981);
        return false;
      }
      AppMethodBeat.o(352981);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(352972);
      int i = this.CAe.hashCode();
      AppMethodBeat.o(352972);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(352961);
      String str = s.X("id = ", this.CAf) + ", " + s.X("micId = ", this.mXx) + ", " + s.X("state = ", this.CAg) + "\n";
      s.s(str, "StringBuilder().append(\"…              .toString()");
      AppMethodBeat.o(352961);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(aj paramaj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(aj paramaj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(aj paramaj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.aj
 * JD-Core Version:    0.7.0.1
 */