package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLotterySlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "DROP_LIST_SIZE", "", "getDROP_LIST_SIZE", "()I", "MAX_LOTTERY_ID_LIST", "getMAX_LOTTERY_ID_LIST", "anchorLotterySetting", "Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;", "getAnchorLotterySetting", "()Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;", "setAnchorLotterySetting", "(Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;)V", "cacheLotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "getCacheLotteryInfoWrapper", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "setCacheLotteryInfoWrapper", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;)V", "enableLottery", "", "getEnableLottery", "()Z", "setEnableLottery", "(Z)V", "hasLotteryHistory", "getHasLotteryHistory", "setHasLotteryHistory", "localLotteryInfoWrapper", "getLocalLotteryInfoWrapper", "setLocalLotteryInfoWrapper", "localLotteryInfoWrapperList", "Ljava/util/LinkedList;", "getLocalLotteryInfoWrapperList", "()Ljava/util/LinkedList;", "setLocalLotteryInfoWrapperList", "(Ljava/util/LinkedList;)V", "localSaveLotteryIdList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Pair;", "", "", "getLocalSaveLotteryIdList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLocalSaveLotteryIdList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "lotteryRecord", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setLotteryRecord", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;)V", "useUpdateStrategy", "getUseUpdateStrategy", "setUseUpdateStrategy", "cacheLotteryInfo", "", "cancelLotteryInfo", "clearLotteryInfoList", "getLotteryIdList", "haveParticipated", "isCardShowing", "isRemoteItemValid", "remoteLotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "localLotteryInfo", "isRunning", "lotteryIdHaveShow", "lotteryId", "lotteryIdListToString", "lotteryList", "mergeLotteryRecord", "record", "onCleared", "printLotteryInfoList", "prefix", "fromJoinLive", "removeLotteryInfoFromList", "saveId", "replaceLocalLotteryInfo", "lotteryInfoWrapper", "resetCacheLotteryInfo", "resetLotteryInfoToList", "liveMsgLotteryInfoList", "resetLotteryRecord", "safeResetLocalLotteryInfo", "saveLastWinLotteryId", "transLotteryInfo", "finderLiveLotteryInfo", "lastDoneLottery", "updateLocalLotteryInfo", "updateLotteryInfo", "lotteryInfo", "updateLotteryInfoList", "lotteryInfoList", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a Egn;
  boolean EdN;
  public LinkedList<m> Ego;
  public m Egp;
  private ConcurrentLinkedDeque<r<Long, String>> Egq;
  public bib Egr;
  public boolean Egs;
  public boolean Egt;
  public diq Egu;
  public m Egv;
  private final int Egw;
  private final int Egx;
  
  static
  {
    AppMethodBeat.i(356782);
    Egn = new a((byte)0);
    AppMethodBeat.o(356782);
  }
  
  public k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356728);
    this.Ego = new LinkedList();
    this.Egq = new ConcurrentLinkedDeque();
    parama = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSV().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.EdN = bool;
      this.Egu = new diq();
      parama = com.tencent.d.a.a.a.a.a.ahiX;
      this.Egw = ((Number)com.tencent.d.a.a.a.a.a.jSW().bmg()).intValue();
      this.Egx = (this.Egw / 2);
      AppMethodBeat.o(356728);
      return;
    }
  }
  
  private static ConcurrentLinkedDeque<r<Long, String>> eze()
  {
    AppMethodBeat.i(356756);
    Object localObject1 = h.baE().ban().get(at.a.adaN, "");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(356756);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = (String)localObject1;
    localObject1 = new ConcurrentLinkedDeque();
    if (((CharSequence)localObject2).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MMFinder.LiveLotterySlice", "getLotteryIdList lotteryList is empty!");
      AppMethodBeat.o(356756);
      return localObject1;
    }
    localObject2 = n.b((CharSequence)localObject2, new String[] { "|" });
    int k = ((List)localObject2).size();
    if (k > 0) {}
    int j;
    for (i = 0;; i = j)
    {
      j = i + 1;
      String str = (String)((List)localObject2).get(i);
      Object localObject3 = n.b((CharSequence)str, new String[] { ":" });
      if (((List)localObject3).size() != 2)
      {
        localObject3 = aw.Gjk;
        if (aw.bgV()) {
          Log.i("MMFinder.LiveLotterySlice", s.X("getLotteryIdList invalid lotteryInfo:", str));
        }
      }
      while (j >= k)
      {
        Log.i("MMFinder.LiveLotterySlice", s.X("getLotteryIdList lotteryList:", localObject1));
        AppMethodBeat.o(356756);
        return localObject1;
        long l = Util.safeParseLong((String)((List)localObject3).get(0));
        localObject3 = (String)((List)localObject3).get(1);
        if (l != 0L)
        {
          CharSequence localCharSequence = (CharSequence)localObject3;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label332;
          }
        }
        label332:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label337;
          }
          localObject3 = aw.Gjk;
          if (!aw.bgV()) {
            break;
          }
          Log.i("MMFinder.LiveLotterySlice", s.X("getLotteryIdList invalid liveId lotteryInfo:", str));
          break;
        }
        label337:
        ((ConcurrentLinkedDeque)localObject1).add(new r(Long.valueOf(l), localObject3));
      }
    }
  }
  
  public final void a(bjc parambjc)
  {
    AppMethodBeat.i(356801);
    d.uiThread((kotlin.g.a.a)new j(parambjc, this));
    AppMethodBeat.o(356801);
  }
  
  final boolean a(bjc parambjc1, bjc parambjc2)
  {
    AppMethodBeat.i(356793);
    if (!s.p(parambjc1.id, parambjc2.id))
    {
      Log.i("MMFinder.LiveLotterySlice", "isRemoteItemValid invalid id:" + parambjc1.id + ',' + parambjc2.id);
      AppMethodBeat.o(356793);
      return false;
    }
    if (!this.EdN)
    {
      AppMethodBeat.o(356793);
      return true;
    }
    int i = parambjc2.CBd;
    int j = parambjc1.CBd;
    int k = parambjc2.CWC;
    int m = parambjc1.CWC;
    if (m >= k)
    {
      if (k < m)
      {
        Log.i("MMFinder.LiveLotterySlice", "printLotteryInfoList RemoteItem:" + com.tencent.mm.ae.f.dg(Integer.valueOf(j)) + " invalid");
        AppMethodBeat.o(356793);
        return false;
      }
      if (((j == 1) && (i != 1)) || ((j == 2) && (i == 3)))
      {
        Log.i("MMFinder.LiveLotterySlice", "printLotteryInfoList RemoteItem:" + com.tencent.mm.ae.f.dg(Integer.valueOf(j)) + " invalid");
        AppMethodBeat.o(356793);
        return false;
      }
    }
    AppMethodBeat.o(356793);
    return true;
  }
  
  public final void ayu(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(356838);
    Object localObject1 = (f)business(f.class);
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).liveInfo;
      if ((localObject1 != null) && (paramString != null))
      {
        if (this.Egq.isEmpty())
        {
          localObject2 = eze();
          s.u(localObject2, "<set-?>");
          this.Egq = ((ConcurrentLinkedDeque)localObject2);
        }
        Object localObject2 = this.Egq.iterator();
        s.s(localObject2, "localSaveLotteryIdList.iterator()");
        for (;;)
        {
          Object localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            long l = ((Number)((r)((Iterator)localObject2).next()).bsC).longValue();
            localObject3 = (f)business(f.class);
            if (localObject3 == null) {
              break label356;
            }
            localObject3 = ((f)localObject3).liveInfo;
            if ((localObject3 == null) || (l != ((bip)localObject3).liveId)) {
              break label356;
            }
          }
          label356:
          for (i = 1; i != 0; i = 0)
          {
            ((Iterator)localObject2).remove();
            if (this.Egq.size() > this.Egw)
            {
              int m = this.Egx;
              if (m > 0)
              {
                i = 0;
                int k;
                do
                {
                  k = i + 1;
                  this.Egq.removeLast();
                  i = k;
                } while (k < m);
              }
            }
            localObject2 = new r(Long.valueOf(((bip)localObject1).liveId), paramString);
            this.Egq.add(localObject2);
            localObject3 = this.Egq;
            localObject2 = new StringBuilder();
            localObject3 = ((ConcurrentLinkedDeque)localObject3).iterator();
            s.s(localObject3, "lotteryList.iterator()");
            while (((Iterator)localObject3).hasNext())
            {
              r localr = (r)((Iterator)localObject3).next();
              ((StringBuilder)localObject2).append(((Number)localr.bsC).longValue() + ':' + (String)localr.bsD).append("|");
            }
          }
        }
        int i = j;
        if (((CharSequence)localObject2).length() == 0) {
          i = 1;
        }
        if (i == 0) {
          ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        s.s(localObject2, "result.toString()");
        h.baE().ban().set(at.a.adaN, localObject2);
        Log.i("MMFinder.LiveLotterySlice", "saveLastWinLotteryId MAX_LOTTERY_ID_LIST:" + this.Egw + ",DROP_LIST_SIZE:" + this.Egx + ",liveId:" + ((bip)localObject1).liveId + ",lotteryId:" + paramString + ",lotteryList:" + this.Egq + ",cacheListStr:" + (String)localObject2);
      }
    }
    AppMethodBeat.o(356838);
  }
  
  public final boolean ayv(String paramString)
  {
    AppMethodBeat.i(356852);
    s.u(paramString, "lotteryId");
    if (this.Egq.isEmpty()) {
      this.Egq = eze();
    }
    Iterator localIterator = this.Egq.iterator();
    s.s(localIterator, "localSaveLotteryIdList.iterator()");
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      long l = ((Number)localr.bsC).longValue();
      Object localObject = (f)business(f.class);
      if (localObject != null)
      {
        localObject = ((f)localObject).liveInfo;
        if ((localObject == null) || (l != ((bip)localObject).liveId)) {}
      }
      for (int i = 1; (i != 0) && (s.p(localr.bsD, paramString)); i = 0)
      {
        AppMethodBeat.o(356852);
        return true;
      }
    }
    AppMethodBeat.o(356852);
    return false;
  }
  
  public final void bB(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(356822);
    d.uiThread((kotlin.g.a.a)new e(paramBoolean, this, paramString));
    AppMethodBeat.o(356822);
  }
  
  public final void bC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(356827);
    s.u(paramString, "prefix");
    paramString = new StringBuilder("printLotteryInfoList(" + paramString + ",fromJoinLive:" + paramBoolean + ")：");
    Object localObject1 = (Iterable)this.Ego;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (m)localObject2;
      paramString.append("index:" + i + ',' + localObject2 + "};");
      i += 1;
    }
    Log.i("MMFinder.LiveLotterySlice", paramString.toString());
    AppMethodBeat.o(356827);
  }
  
  public final void c(bib parambib)
  {
    AppMethodBeat.i(356786);
    bib localbib = this.Egr;
    Object localObject = localbib;
    if (localbib == null) {
      localObject = "";
    }
    Log.i("MMFinder.LiveLotterySlice", s.X("lotteryRecord:", com.tencent.mm.ae.f.dg(localObject)));
    this.Egr = parambib;
    AppMethodBeat.o(356786);
  }
  
  public final void c(final LinkedList<bjc> paramLinkedList, final boolean paramBoolean)
  {
    AppMethodBeat.i(356808);
    s.u(paramLinkedList, "liveMsgLotteryInfoList");
    d.uiThread((kotlin.g.a.a)new g(this, paramLinkedList, paramBoolean));
    AppMethodBeat.o(356808);
  }
  
  public final void d(bib parambib)
  {
    AppMethodBeat.i(356869);
    d.uiThread((kotlin.g.a.a)new k.d(parambib, this));
    AppMethodBeat.o(356869);
  }
  
  public final void ezd()
  {
    AppMethodBeat.i(356814);
    d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(356814);
  }
  
  public final boolean ezf()
  {
    int i = 0;
    AppMethodBeat.i(356862);
    Object localObject = this.Egp;
    if (localObject == null) {}
    for (;;)
    {
      boolean bool = d.ee(i, 1);
      Log.i("MMFinder.LiveLotterySlice", s.X("haveParticipated :", Boolean.valueOf(bool)));
      AppMethodBeat.o(356862);
      return bool;
      localObject = ((m)localObject).Bhm;
      if (localObject != null) {
        i = ((bjc)localObject).extFlag;
      }
    }
  }
  
  public final boolean isRunning()
  {
    m localm = this.Egp;
    return (localm != null) && (localm.CBc == 1);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356882);
    d.uiThread((kotlin.g.a.a)new h(this));
    ezd();
    this.Egq = new ConcurrentLinkedDeque();
    this.Egv = null;
    this.Egt = false;
    c(null);
    this.Egs = false;
    this.Egu = new diq();
    AppMethodBeat.o(356882);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLotterySlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(boolean paramBoolean, k paramk, String paramString)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<m, Boolean>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(k paramk, LinkedList<bjc> paramLinkedList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    public i(m paramm, k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(bjc parambjc, k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.k
 * JD-Core Version:    0.7.0.1
 */