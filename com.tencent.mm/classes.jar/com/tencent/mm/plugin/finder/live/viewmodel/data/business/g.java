package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bal;>;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLotterySlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "DROP_LIST_SIZE", "", "getDROP_LIST_SIZE", "()I", "MAX_LOTTERY_ID_LIST", "getMAX_LOTTERY_ID_LIST", "enableLottery", "", "getEnableLottery", "()Z", "setEnableLottery", "(Z)V", "hasLotteryHistory", "getHasLotteryHistory", "setHasLotteryHistory", "localLotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "getLocalLotteryInfoWrapper", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "setLocalLotteryInfoWrapper", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;)V", "localLotteryInfoWrapperList", "Ljava/util/LinkedList;", "getLocalLotteryInfoWrapperList", "()Ljava/util/LinkedList;", "setLocalLotteryInfoWrapperList", "(Ljava/util/LinkedList;)V", "localSaveLotteryIdList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Pair;", "", "", "getLocalSaveLotteryIdList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLocalSaveLotteryIdList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "lotteryRecord", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setLotteryRecord", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;)V", "useUpdateStrategy", "getUseUpdateStrategy", "setUseUpdateStrategy", "cancelLotteryInfo", "", "clearLotteryInfoList", "getLotteryIdList", "haveParticipated", "isRemoteItemValid", "remoteLotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "localLotteryInfo", "lotteryIdHaveShow", "lotteryId", "lotteryIdListToString", "lotteryList", "mergeLotteryRecord", "record", "onCleared", "printLotteryInfoList", "prefix", "fromJoinLive", "removeLotteryInfoFromList", "saveId", "replaceLocalLotteryInfo", "lotteryInfoWrapper", "resetLotteryInfoToList", "liveMsgLotteryInfoList", "resetLotteryRecord", "safeResetLocalLotteryInfo", "saveLastWinLotteryId", "transLotteryInfo", "finderLiveLotteryInfo", "lastDoneLottery", "updateLocalLotteryInfo", "updateLotteryInfo", "lotteryInfo", "updateLotteryInfoList", "lotteryInfoList", "Companion", "plugin-finder-base_release"})
public final class g
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a zij;
  private boolean zfX;
  public LinkedList<com.tencent.mm.plugin.finder.live.viewmodel.data.l> zib;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.l zic;
  private ConcurrentLinkedDeque<o<Long, String>> zid;
  public azs zie;
  public boolean zif;
  public boolean zig;
  private final int zih;
  private final int zii;
  
  static
  {
    AppMethodBeat.i(259395);
    zij = new a((byte)0);
    AppMethodBeat.o(259395);
  }
  
  public g(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(259394);
    this.zib = new LinkedList();
    this.zid = new ConcurrentLinkedDeque();
    parama = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.imt().aSr()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.zfX = bool;
      parama = com.tencent.c.a.a.a.a.a.Zlt;
      this.zih = ((Number)com.tencent.c.a.a.a.a.a.imu().aSr()).intValue();
      this.zii = (this.zih / 2);
      AppMethodBeat.o(259394);
      return;
    }
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.data.l b(bal parambal, boolean paramBoolean)
  {
    AppMethodBeat.i(259361);
    p.k(parambal, "finderLiveLotteryInfo");
    parambal = new com.tencent.mm.plugin.finder.live.viewmodel.data.l(parambal.ycP, parambal.ynN, parambal, paramBoolean, 96);
    AppMethodBeat.o(259361);
    return parambal;
  }
  
  private static ConcurrentLinkedDeque<o<Long, String>> dHi()
  {
    AppMethodBeat.i(259378);
    Object localObject1 = h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    localObject1 = ((f)localObject1).aHp().get(ar.a.VyR, "");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(259378);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = (String)localObject1;
    localObject1 = new ConcurrentLinkedDeque();
    Object localObject3 = (CharSequence)localObject2;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MMFinder.LiveLotterySlice", "getLotteryIdList lotteryList is empty!");
      AppMethodBeat.o(259378);
      return localObject1;
    }
    localObject2 = n.b((CharSequence)localObject2, new String[] { "|" });
    int k = ((List)localObject2).size();
    i = 0;
    if (i < k)
    {
      localObject3 = (String)((List)localObject2).get(i);
      Object localObject4 = n.b((CharSequence)localObject3, new String[] { ":" });
      if (((List)localObject4).size() != 2)
      {
        localObject4 = ak.AGL;
        if (ak.eej()) {
          Log.i("MMFinder.LiveLotterySlice", "getLotteryIdList invalid lotteryInfo:".concat(String.valueOf(localObject3)));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        long l = Util.safeParseLong((String)((List)localObject4).get(0));
        localObject4 = (String)((List)localObject4).get(1);
        if (l != 0L)
        {
          CharSequence localCharSequence = (CharSequence)localObject4;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label331;
          }
        }
        label331:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label336;
          }
          localObject4 = ak.AGL;
          if (!ak.eej()) {
            break;
          }
          Log.i("MMFinder.LiveLotterySlice", "getLotteryIdList invalid liveId lotteryInfo:".concat(String.valueOf(localObject3)));
          break;
        }
        label336:
        ((ConcurrentLinkedDeque)localObject1).add(new o(Long.valueOf(l), localObject4));
      }
    }
    Log.i("MMFinder.LiveLotterySlice", "getLotteryIdList lotteryList:".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(259378);
    return localObject1;
  }
  
  public final void a(final bal parambal)
  {
    AppMethodBeat.i(259355);
    d.uiThread((kotlin.g.a.a)new j(this, parambal));
    AppMethodBeat.o(259355);
  }
  
  public final boolean a(bal parambal1, bal parambal2)
  {
    AppMethodBeat.i(259352);
    p.k(parambal1, "remoteLotteryInfo");
    p.k(parambal2, "localLotteryInfo");
    if ((p.h(parambal1.id, parambal2.id) ^ true))
    {
      Log.i("MMFinder.LiveLotterySlice", "isRemoteItemValid invalid id:" + parambal1.id + ',' + parambal2.id);
      AppMethodBeat.o(259352);
      return false;
    }
    if (!this.zfX)
    {
      AppMethodBeat.o(259352);
      return true;
    }
    int i = parambal2.ycP;
    int j = parambal1.ycP;
    int k = parambal2.ynN;
    int m = parambal1.ynN;
    if (m >= k)
    {
      if (k < m)
      {
        Log.i("MMFinder.LiveLotterySlice", "printLotteryInfoList RemoteItem:" + com.tencent.mm.ae.g.bN(Integer.valueOf(j)) + " invalid");
        AppMethodBeat.o(259352);
        return false;
      }
      if (((j == 1) && (i != 1)) || ((j == 2) && (i == 3)))
      {
        Log.i("MMFinder.LiveLotterySlice", "printLotteryInfoList RemoteItem:" + com.tencent.mm.ae.g.bN(Integer.valueOf(j)) + " invalid");
        AppMethodBeat.o(259352);
        return false;
      }
    }
    AppMethodBeat.o(259352);
    return true;
  }
  
  public final void aDc(String paramString)
  {
    AppMethodBeat.i(259375);
    Object localObject1 = (c)business(c.class);
    if (localObject1 != null)
    {
      localObject1 = ((c)localObject1).liveInfo;
      if (localObject1 != null)
      {
        Object localObject2;
        Object localObject3;
        if (paramString != null)
        {
          if (this.zid.isEmpty()) {
            this.zid = dHi();
          }
          localObject2 = this.zid.iterator();
          p.j(localObject2, "localSaveLotteryIdList.iterator()");
          while (((Iterator)localObject2).hasNext())
          {
            long l = ((Number)((o)((Iterator)localObject2).next()).Mx).longValue();
            localObject3 = (c)business(c.class);
            if (localObject3 != null)
            {
              localObject3 = ((c)localObject3).liveInfo;
              if ((localObject3 != null) && (l == ((bac)localObject3).liveId)) {
                ((Iterator)localObject2).remove();
              }
            }
          }
          if (this.zid.size() > this.zih)
          {
            int j = this.zii;
            i = 0;
            while (i < j)
            {
              this.zid.removeLast();
              i += 1;
            }
          }
          localObject2 = new o(Long.valueOf(((bac)localObject1).liveId), paramString);
          this.zid.add(localObject2);
          localObject3 = this.zid;
          localObject2 = new StringBuilder();
          localObject3 = ((ConcurrentLinkedDeque)localObject3).iterator();
          p.j(localObject3, "lotteryList.iterator()");
          while (((Iterator)localObject3).hasNext())
          {
            o localo = (o)((Iterator)localObject3).next();
            ((StringBuilder)localObject2).append(((Number)localo.Mx).longValue() + ':' + (String)localo.My).append("|");
          }
          if (((CharSequence)localObject2).length() != 0) {
            break label493;
          }
        }
        label493:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject2 = ((StringBuilder)localObject2).toString();
          p.j(localObject2, "result.toString()");
          localObject3 = h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((f)localObject3).aHp().set(ar.a.VyR, localObject2);
          Log.i("MMFinder.LiveLotterySlice", "saveLastWinLotteryId MAX_LOTTERY_ID_LIST:" + this.zih + ",DROP_LIST_SIZE:" + this.zii + ",liveId:" + ((bac)localObject1).liveId + ",lotteryId:" + paramString + ",lotteryList:" + this.zid + ",cacheListStr:" + (String)localObject2);
          AppMethodBeat.o(259375);
          return;
        }
      }
    }
    AppMethodBeat.o(259375);
  }
  
  public final boolean aDd(String paramString)
  {
    AppMethodBeat.i(259381);
    p.k(paramString, "lotteryId");
    if (this.zid.isEmpty()) {
      this.zid = dHi();
    }
    Iterator localIterator = this.zid.iterator();
    p.j(localIterator, "localSaveLotteryIdList.iterator()");
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l = ((Number)localo.Mx).longValue();
      Object localObject = (c)business(c.class);
      if (localObject != null)
      {
        localObject = ((c)localObject).liveInfo;
        if ((localObject != null) && (l == ((bac)localObject).liveId) && (p.h((String)localo.My, paramString)))
        {
          AppMethodBeat.o(259381);
          return true;
        }
      }
    }
    AppMethodBeat.o(259381);
    return false;
  }
  
  public final LinkedList<bal> aG(LinkedList<bal> paramLinkedList)
  {
    AppMethodBeat.i(259360);
    p.k(paramLinkedList, "lotteryInfoList");
    if (!this.zfX)
    {
      AppMethodBeat.o(259360);
      return paramLinkedList;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = ((Iterable)paramLinkedList).iterator();
    if (localIterator1.hasNext())
    {
      bal localbal = (bal)localIterator1.next();
      Iterator localIterator2 = ((Iterable)this.zib).iterator();
      label83:
      Object localObject;
      if (localIterator2.hasNext())
      {
        localObject = localIterator2.next();
        paramLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).xHW;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.id;
          label118:
          if (!p.h(paramLinkedList, localbal.id)) {
            break label177;
          }
          paramLinkedList = (LinkedList<bal>)localObject;
          label131:
          paramLinkedList = (com.tencent.mm.plugin.finder.live.viewmodel.data.l)paramLinkedList;
          if (paramLinkedList == null) {
            break label184;
          }
        }
      }
      label177:
      label184:
      for (paramLinkedList = paramLinkedList.xHW;; paramLinkedList = null)
      {
        localObject = localbal;
        if (paramLinkedList != null)
        {
          localObject = localbal;
          if (!a(localbal, paramLinkedList)) {
            localObject = paramLinkedList;
          }
        }
        localLinkedList.add(localObject);
        break;
        paramLinkedList = null;
        break label118;
        break label83;
        paramLinkedList = null;
        break label131;
      }
    }
    AppMethodBeat.o(259360);
    return localLinkedList;
  }
  
  public final void bn(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(259366);
    d.uiThread((kotlin.g.a.a)new e(this, paramBoolean, paramString));
    AppMethodBeat.o(259366);
  }
  
  public final void bo(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(259369);
    p.k(paramString, "prefix");
    paramString = new StringBuilder("printLotteryInfoList(" + paramString + ",fromJoinLive:" + paramBoolean + ")：");
    Object localObject1 = (Iterable)this.zib;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject2;
      paramString.append("index:" + i + ',' + localObject2 + "};");
      i += 1;
    }
    Log.i("MMFinder.LiveLotterySlice", paramString.toString());
    AppMethodBeat.o(259369);
  }
  
  public final void c(azs paramazs)
  {
    AppMethodBeat.i(259347);
    StringBuilder localStringBuilder = new StringBuilder("lotteryRecord:");
    azs localazs = this.zie;
    Object localObject = localazs;
    if (localazs == null) {
      localObject = "";
    }
    Log.i("MMFinder.LiveLotterySlice", com.tencent.mm.ae.g.bN(localObject));
    this.zie = paramazs;
    AppMethodBeat.o(259347);
  }
  
  public final void c(final LinkedList<bal> paramLinkedList, final boolean paramBoolean)
  {
    AppMethodBeat.i(259357);
    p.k(paramLinkedList, "liveMsgLotteryInfoList");
    d.uiThread((kotlin.g.a.a)new g(this, paramLinkedList, paramBoolean));
    AppMethodBeat.o(259357);
  }
  
  public final void d(final azs paramazs)
  {
    AppMethodBeat.i(259387);
    d.uiThread((kotlin.g.a.a)new d(this, paramazs));
    AppMethodBeat.o(259387);
  }
  
  public final void dHh()
  {
    AppMethodBeat.i(259363);
    d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(259363);
  }
  
  public final boolean dHj()
  {
    AppMethodBeat.i(259384);
    Object localObject = this.zic;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).xHW;
      if (localObject == null) {}
    }
    for (int i = ((bal)localObject).extFlag;; i = 0)
    {
      boolean bool = d.dr(i, 1);
      Log.i("MMFinder.LiveLotterySlice", "haveParticipated :".concat(String.valueOf(bool)));
      AppMethodBeat.o(259384);
      return bool;
    }
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(259391);
    d.uiThread((kotlin.g.a.a)new h(this));
    dHh();
    this.zid = new ConcurrentLinkedDeque();
    this.zig = false;
    c(null);
    this.zif = false;
    AppMethodBeat.o(259391);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLotterySlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(g paramg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(g paramg, azs paramazs)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(g paramg, boolean paramBoolean, String paramString)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.l, Boolean>
    {
      a(g.e parame)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    public f(g paramg, com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(g paramg, LinkedList paramLinkedList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    public i(g paramg, com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(g paramg, bal parambal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.g
 * JD-Core Version:    0.7.0.1
 */