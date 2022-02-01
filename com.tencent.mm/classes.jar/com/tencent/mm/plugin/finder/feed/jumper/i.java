package com.tencent.mm.plugin.finder.feed.jumper;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.component.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "curJob", "Lkotlinx/coroutines/Job;", "getCurJob", "()Lkotlinx/coroutines/Job;", "setCurJob", "(Lkotlinx/coroutines/Job;)V", "emptyLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedAllJumpInfo;", "liveDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "olyJumpMap", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "getOlyJumpMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "refreshManager", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC$FeedRefreshManager;", "findJumperInfoLiveData", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "feedId", "", "flag", "", "commentScene", "findLiveData", "adFlag", "finderItemToUnit", "Lcom/tencent/mm/protocal/protobuf/FinderObjectUidUnit;", "it", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "innerRequest", "", "units", "", "scene", "isHotSearch", "", "allJumpInfoSet", "isPosterOrJumper", "isSnsLeadInJumper", "key", "request", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feeds", "requestFeedsByCacheFilter", "feedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "requestFeedsJumpInfo", "resetRefresh", "refreshList", "Companion", "FeedRefreshManager", "FeedRefreshRecord", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends n<PluginFinder>
{
  public static final a BdE;
  private static int BdK;
  private static long BdL;
  private final b BdF;
  cb BdG;
  private final ConcurrentHashMap<String, x<Set<h>>> BdH;
  public final ConcurrentHashMap<String, FinderJumpInfo> BdI;
  private final x<Set<h>> BdJ;
  
  static
  {
    AppMethodBeat.i(364256);
    BdE = new a((byte)0);
    AppMethodBeat.o(364256);
  }
  
  public i()
  {
    AppMethodBeat.i(364190);
    this.BdF = new b((kotlin.g.a.b)new e(this));
    this.BdH = new ConcurrentHashMap();
    this.BdI = new ConcurrentHashMap();
    this.BdJ = new x();
    AppMethodBeat.o(364190);
  }
  
  private final x<Set<h>> m(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(364200);
    if (paramInt1 == 0)
    {
      localObject1 = this.BdJ;
      AppMethodBeat.o(364200);
      return localObject1;
    }
    Object localObject2 = (ConcurrentMap)this.BdH;
    String str = n(paramLong, paramInt1, paramInt2);
    Object localObject1 = ((ConcurrentMap)localObject2).get(str);
    if (localObject1 == null)
    {
      x localx = new x();
      localObject2 = ((ConcurrentMap)localObject2).putIfAbsent(str, localx);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localx;
      }
    }
    for (;;)
    {
      s.s(localObject1, "liveDataMap.getOrPut(key…), { MutableLiveData() })");
      localObject1 = (x)localObject1;
      AppMethodBeat.o(364200);
      return localObject1;
    }
  }
  
  private static String n(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(364208);
    String str = paramLong + '#' + paramInt1 + '#' + paramInt2;
    AppMethodBeat.o(364208);
    return str;
  }
  
  public final void D(List<? extends cc> paramList, int paramInt)
  {
    AppMethodBeat.i(364263);
    if (paramList == null)
    {
      AppMethodBeat.o(364263);
      return;
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramList.iterator();
    label95:
    while (localIterator.hasNext())
    {
      paramList = (cc)localIterator.next();
      if ((paramList instanceof BaseFinderFeed)) {}
      for (paramList = ((BaseFinderFeed)paramList).feedObject;; paramList = null)
      {
        if (paramList == null) {
          break label95;
        }
        localCollection.add(paramList);
        break;
      }
    }
    F((List)localCollection, paramInt);
    AppMethodBeat.o(364263);
  }
  
  public final void E(List<? extends cc> paramList, int paramInt)
  {
    AppMethodBeat.i(364281);
    Object localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(364281);
      return;
    }
    paramList = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    label125:
    while (((Iterator)localObject2).hasNext())
    {
      paramList = (cc)((Iterator)localObject2).next();
      if ((paramList instanceof BaseFinderFeed)) {}
      for (paramList = ((BaseFinderFeed)paramList).feedObject;; paramList = null)
      {
        if (paramList == null) {
          break label125;
        }
        ((Collection)localObject1).add(paramList);
        break;
      }
    }
    localObject1 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      FinderItem localFinderItem = (FinderItem)localObject2;
      long l = b.a(this.BdF, localFinderItem.getId());
      if ((l != 0L) && (cn.bDu() - l > 30000L)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          this.BdF.Q(localFinderItem.getId(), 1);
        }
        Log.i("Finder.FeedGlobalJumperUIC", "requestFeedsByCacheFilter refreshTime:" + l + " delta:" + (cn.bDu() - l) + " isRefresh:" + bool);
        if (!bool) {
          break;
        }
        paramList.add(localObject2);
        break;
      }
    }
    paramList = (List)paramList;
    Log.i("Finder.FeedGlobalJumperUIC", s.X("requestFeedsByCacheFilter: size:", Integer.valueOf(paramList.size())));
    if (((Collection)paramList).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        F(paramList, paramInt);
      }
      AppMethodBeat.o(364281);
      return;
    }
  }
  
  public final void F(List<? extends FinderItem> paramList, final int paramInt)
  {
    AppMethodBeat.i(364296);
    s.u(paramList, "feeds");
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      AppMethodBeat.o(364296);
      return;
    }
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FinderItem localFinderItem = (FinderItem)localIterator.next();
      if ((localFinderItem.field_finderObject.id != 0L) && (localFinderItem.field_finderObject.adFlag > 0))
      {
        brr localbrr = new brr();
        localbrr.object_id = localFinderItem.field_finderObject.id;
        localbrr.object_nonce_id = localFinderItem.getObjectNonceId();
        localbrr.ZZS = localFinderItem.field_finderObject.adFlag;
        localbrr.ZZT = localFinderItem.field_finderObject.cookie;
        ((LinkedList)localObject).add(localbrr);
      }
    }
    int i;
    if (!((Collection)localObject).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        localObject = (List)localObject;
        if (!((List)localObject).isEmpty()) {
          break label265;
        }
        Log.w("Finder.FeedGlobalJumperUIC", "[request] units isEmpty! scene=2 commentScene=" + paramInt);
      }
    }
    for (;;)
    {
      e.launch$default((e)this, null, null, (m)new f(paramList, paramInt, this, null), 3, null);
      AppMethodBeat.o(364296);
      return;
      i = 0;
      break;
      label265:
      long l = SystemClock.uptimeMillis() - BdL;
      if (l < BdK * 1000L) {
        Log.w("Finder.FeedGlobalJumperUIC", "[request] scene=2 commentScene=" + paramInt + " diffTimeSeconds=" + l / 1000L + " intervalSeconds=" + BdK);
      } else {
        e.launch$default((e)this, null, null, (m)new d((List)localObject, 2, paramInt, this, null), 3, null);
      }
    }
  }
  
  public final LiveData<Set<h>> l(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(364308);
    LiveData localLiveData = (LiveData)m(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(364308);
    return localLiveData;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC$Companion;", "", "()V", "TAG", "", "WITH_EXPIRE_REQUEST_LIMIT", "", "intervalSeconds", "lastRequestTimeMs", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC$FeedRefreshManager;", "", "condition", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedAllJumpInfo;", "Lkotlin/ParameterName;", "name", "allJumpInfoSet", "", "(Lkotlin/jvm/functions/Function1;)V", "getCondition", "()Lkotlin/jvm/functions/Function1;", "record", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC$FeedRefreshRecord;", "get", "feedId", "isFilterRefreshing", "set", "", "setRefreshStat", "refreshStat", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final a BdM;
    final kotlin.g.a.b<Set<h>, Boolean> BdN;
    final ConcurrentHashMap<Long, i.c> BdO;
    
    static
    {
      AppMethodBeat.i(364123);
      BdM = new a((byte)0);
      AppMethodBeat.o(364123);
    }
    
    public b(kotlin.g.a.b<? super Set<h>, Boolean> paramb)
    {
      AppMethodBeat.i(364111);
      this.BdN = paramb;
      this.BdO = new ConcurrentHashMap();
      AppMethodBeat.o(364111);
    }
    
    public final void Q(long paramLong, int paramInt)
    {
      AppMethodBeat.i(364127);
      i.c localc = (i.c)this.BdO.get(Long.valueOf(paramLong));
      if (localc != null) {
        localc.BdP = paramInt;
      }
      AppMethodBeat.o(364127);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC$FeedRefreshManager$Companion;", "", "()V", "REFRESHED_STATE", "", "REFRESHING_INIT", "REFRESHING_STATE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC$FeedRefreshRecord;", "", "feedId", "", "refreshTime", "(JJ)V", "getFeedId", "()J", "refreshStat", "", "getRefreshStat", "()I", "setRefreshStat", "(I)V", "getRefreshTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final long AZk;
    int BdP;
    private final long feedId;
    
    public c(long paramLong1, long paramLong2)
    {
      this.feedId = paramLong1;
      this.AZk = paramLong2;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    int aai;
    int asI;
    int label;
    int nuz;
    
    d(List<? extends brr> paramList, int paramInt1, int paramInt2, i parami, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(364159);
      paramd = new d(this.BdQ, this.ofW, paramInt, jdField_this, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(364159);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(364153);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      int m;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(364153);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (aq)this.L$0;
        if (this.BdQ.size() < this.BdQ.size()) {
          Log.w("Finder.FeedGlobalJumperUIC", "[request] scene=" + this.ofW + " commentScene=" + paramInt + " units[" + this.BdQ.size() + "] => pending[" + this.BdQ.size() + ']');
        }
        localObject2 = jdField_this.BdG;
        paramObject = localObject1;
        if (localObject2 != null)
        {
          localObject3 = (kotlin.d.d)this;
          this.L$0 = localObject1;
          this.label = 1;
          paramObject = localObject1;
          if (((cb)localObject2).ay((kotlin.d.d)localObject3) == locala)
          {
            AppMethodBeat.o(364153);
            return locala;
          }
        }
      case 1: 
        localObject1 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        localObject1 = ah.aiuX;
        jdField_this.BdG = ((cb)paramObject.getCoroutineContext().get((f.c)cb.ajws));
      case 2: 
        try
        {
          localObject1 = com.tencent.mm.kernel.h.ax(g.class);
          s.s(localObject1, "service(IFinderCommonLiveService::class.java)");
          localObject1 = (com.tencent.mm.am.b)g.a.a((g)localObject1, this.BdQ, this.ofW, paramInt, null, null, 52);
          localObject2 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 2;
          paramObject = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject1, (kotlin.d.d)localObject2);
          localObject1 = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(364153);
            return locala;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
          }
          paramObject = (aub)localObject1;
        }
        catch (com.tencent.mm.af.a paramObject)
        {
          for (;;)
          {
            Log.e("Finder.FeedGlobalJumperUIC", "[request] doCgiFinderBatchGetObjectAsyncLoadInfo errType=" + paramObject.hDx + " errCode=" + paramObject.errorCode + " fail:" + paramObject.getLocalizedMessage());
            paramObject = null;
          }
          Log.i("Finder.FeedGlobalJumperUIC", "[request] units[" + this.BdQ.size() + "] scene=" + this.ofW + " commentScene=" + paramInt);
          localObject1 = i.BdE;
          i.ny(SystemClock.uptimeMillis());
          localObject1 = i.BdE;
          i.NZ(paramObject.ZEB);
          localObject2 = (Iterable)this.BdQ;
          i = this.ofW;
          j = paramInt;
          localObject1 = jdField_this;
          k = 0;
          localObject2 = ((Iterable)localObject2).iterator();
        }
        if (paramObject == null)
        {
          i = this.ofW;
          j = paramInt;
          paramObject = jdField_this;
          localObject1 = this.BdQ;
          Log.e("Finder.FeedGlobalJumperUIC", "[request] fail scene=" + i + " commentScene=" + j);
          i.a(paramObject, (List)localObject1);
          paramObject.BdG = null;
          paramObject = ah.aiuX;
          AppMethodBeat.o(364153);
          return paramObject;
        }
        if (!((Iterator)localObject2).hasNext()) {
          break label2522;
        }
        localObject3 = ((Iterator)localObject2).next();
        m = k + 1;
        if (k < 0) {
          p.kkW();
        }
        brr localbrr = (brr)localObject3;
        final long l = localbrr.object_id;
        Object localObject7 = com.tencent.mm.ae.d.hF(l);
        localObject3 = paramObject.ZEz;
        s.s(localObject3, "resp.object_async_info_map");
        Object localObject4 = ((Iterable)localObject3).iterator();
        label739:
        Object localObject5;
        label754:
        Object localObject6;
        label816:
        label821:
        label836:
        Object localObject8;
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            localObject3 = ((Iterator)localObject4).next();
            if (((bqy)localObject3).object_id == l)
            {
              k = 1;
              if (k == 0) {
                continue;
              }
              localObject3 = (bqy)localObject3;
              if (localObject3 != null) {
                break label1425;
              }
              localObject5 = null;
              localObject3 = paramObject.ZEz;
              s.s(localObject3, "resp.object_async_info_map");
              localObject4 = ((Iterable)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject4).hasNext())
                {
                  localObject3 = ((Iterator)localObject4).next();
                  if (((bqy)localObject3).object_id == l)
                  {
                    k = 1;
                    if (k == 0) {
                      continue;
                    }
                    localObject3 = (bqy)localObject3;
                    if (localObject3 != null) {
                      break label1447;
                    }
                    localObject3 = null;
                    localObject4 = paramObject.ZEz;
                    s.s(localObject4, "resp.object_async_info_map");
                    localObject6 = ((Iterable)localObject4).iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject6).hasNext())
                      {
                        localObject4 = ((Iterator)localObject6).next();
                        if (((bqy)localObject4).object_id == l)
                        {
                          k = 1;
                          label898:
                          if (k == 0) {
                            continue;
                          }
                          label903:
                          localObject4 = (bqy)localObject4;
                          if (localObject4 != null) {
                            break label1469;
                          }
                          localObject4 = null;
                          label918:
                          localObject8 = new StringBuilder("[request] scene=").append(i).append(" commentScene=").append(j).append(" feedId=").append((String)localObject7).append(" jumpInfo=");
                          if (localObject5 != null) {
                            break label1479;
                          }
                          localObject6 = null;
                          label967:
                          Log.i("Finder.FeedGlobalJumperUIC", localObject6);
                          localObject8 = new StringBuilder("[request] scene=").append(i).append(" commentScene=").append(j).append(" feedId=").append((String)localObject7).append(" hotSpotJumpInfo=");
                          if (localObject3 != null) {
                            break label1601;
                          }
                          localObject6 = null;
                          label1031:
                          Log.i("Finder.FeedGlobalJumperUIC", localObject6);
                          localObject7 = new StringBuilder("[request] scene=").append(i).append(" commentScene=").append(j).append(" feedId=").append((String)localObject7).append(" posJumpInfo=");
                          if (localObject4 != null) {
                            break label1723;
                          }
                          localObject6 = null;
                          label1095:
                          Log.i("Finder.FeedGlobalJumperUIC", localObject6);
                          localObject6 = new HashSet();
                          if (localObject5 != null) {
                            break label1845;
                          }
                          localObject5 = null;
                          label1127:
                          localObject7 = (Collection)localObject5;
                          if ((localObject7 != null) && (!((Collection)localObject7).isEmpty())) {
                            break label1984;
                          }
                          k = 1;
                          label1152:
                          if (k == 0) {
                            ((HashSet)localObject6).add(new h(j, l, 2, (List)localObject5));
                          }
                          if (localObject3 != null) {
                            break label1990;
                          }
                          localObject5 = null;
                          label1184:
                          localObject7 = (Collection)localObject5;
                          if ((localObject7 != null) && (!((Collection)localObject7).isEmpty())) {
                            break label2139;
                          }
                          k = 1;
                          label1209:
                          if (k == 0) {
                            ((HashSet)localObject6).add(new h(j, l, 1, (List)localObject5));
                          }
                          if (localObject4 != null) {
                            break label2145;
                          }
                          localObject4 = null;
                          label1241:
                          localObject5 = (Collection)localObject4;
                          if ((localObject5 != null) && (!((Collection)localObject5).isEmpty())) {
                            break label2271;
                          }
                          k = 1;
                          label1266:
                          if (k == 0) {
                            ((HashSet)localObject6).add(new h(j, l, 3, (List)localObject4));
                          }
                          if (localObject3 == null) {
                            break label2288;
                          }
                          localObject5 = ((Iterable)localObject3).iterator();
                          label1307:
                          do
                          {
                            if (!((Iterator)localObject5).hasNext()) {
                              break;
                            }
                            localObject7 = (FinderJumpInfo)((Iterator)localObject5).next();
                          } while (((FinderJumpInfo)localObject7).business_type != 16);
                          localObject3 = (CharSequence)((FinderJumpInfo)localObject7).jump_id;
                          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
                            break label2277;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label1425:
        label1447:
        label1469:
        label1479:
        label2123:
        label2127:
        label2139:
        label2145:
        label2277:
        for (k = 1;; k = 0)
        {
          if (k != 0) {
            break label1307;
          }
          localObject8 = ((i)localObject1).BdI;
          localObject4 = ((FinderJumpInfo)localObject7).jump_id;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          ((ConcurrentHashMap)localObject8).put(localObject3, localObject7);
          break label1307;
          k = 0;
          break;
          localObject3 = null;
          break label739;
          localObject5 = ((bqy)localObject3).jump_info;
          break label754;
          k = 0;
          break label816;
          localObject3 = null;
          break label821;
          localObject3 = ((bqy)localObject3).ZYW;
          break label836;
          k = 0;
          break label898;
          localObject4 = null;
          break label903;
          localObject4 = ((bqy)localObject4).akkQ;
          break label918;
          Object localObject9 = (Iterable)localObject5;
          localObject6 = (Collection)new ArrayList(p.a((Iterable)localObject9, 10));
          localObject9 = ((Iterable)localObject9).iterator();
          Object localObject10;
          while (((Iterator)localObject9).hasNext())
          {
            localObject10 = (FinderJumpInfo)((Iterator)localObject9).next();
            ((Collection)localObject6).add(((FinderJumpInfo)localObject10).jumpinfo_type + '#' + ((FinderJumpInfo)localObject10).business_type + '#' + ((FinderJumpInfo)localObject10).wording);
          }
          localObject6 = (List)localObject6;
          break label967;
          localObject9 = (Iterable)localObject3;
          localObject6 = (Collection)new ArrayList(p.a((Iterable)localObject9, 10));
          localObject9 = ((Iterable)localObject9).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject10 = (FinderJumpInfo)((Iterator)localObject9).next();
            ((Collection)localObject6).add(((FinderJumpInfo)localObject10).jumpinfo_type + '#' + ((FinderJumpInfo)localObject10).business_type + '#' + ((FinderJumpInfo)localObject10).wording);
          }
          localObject6 = (List)localObject6;
          break label1031;
          localObject8 = (Iterable)localObject4;
          localObject6 = (Collection)new ArrayList(p.a((Iterable)localObject8, 10));
          localObject8 = ((Iterable)localObject8).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (FinderJumpInfo)((Iterator)localObject8).next();
            ((Collection)localObject6).add(((FinderJumpInfo)localObject9).jumpinfo_type + '#' + ((FinderJumpInfo)localObject9).business_type + '#' + ((FinderJumpInfo)localObject9).wording);
          }
          localObject6 = (List)localObject6;
          break label1095;
          localObject7 = (Iterable)localObject5;
          localObject5 = (Collection)new ArrayList();
          localObject7 = ((Iterable)localObject7).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject8 = ((Iterator)localObject7).next();
            localObject9 = (FinderJumpInfo)localObject8;
            localObject10 = (CharSequence)((FinderJumpInfo)localObject9).wording;
            if ((localObject10 == null) || (((CharSequence)localObject10).length() == 0))
            {
              k = 1;
              if ((k != 0) && (((FinderJumpInfo)localObject9).business_type != 2)) {
                break label1968;
              }
            }
            for (k = 1;; k = 0)
            {
              if (k == 0) {
                break label1972;
              }
              ((Collection)localObject5).add(localObject8);
              break;
              k = 0;
              break label1927;
            }
          }
          localObject5 = (List)localObject5;
          break label1127;
          k = 0;
          break label1152;
          localObject7 = (Iterable)localObject3;
          localObject5 = (Collection)new ArrayList();
          localObject7 = ((Iterable)localObject7).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject8 = ((Iterator)localObject7).next();
            localObject9 = (FinderJumpInfo)localObject8;
            localObject10 = (CharSequence)((FinderJumpInfo)localObject9).wording;
            if ((localObject10 == null) || (((CharSequence)localObject10).length() == 0))
            {
              k = 1;
              if ((k != 0) && (((FinderJumpInfo)localObject9).business_type != 2) && (((FinderJumpInfo)localObject9).business_type != 16)) {
                break label2123;
              }
            }
            for (k = 1;; k = 0)
            {
              if (k == 0) {
                break label2127;
              }
              ((Collection)localObject5).add(localObject8);
              break;
              k = 0;
              break label2072;
            }
          }
          localObject5 = (List)localObject5;
          break label1184;
          k = 0;
          break label1209;
          localObject5 = (Iterable)localObject4;
          localObject4 = (Collection)new ArrayList();
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject7 = ((Iterator)localObject5).next();
            localObject8 = (CharSequence)((FinderJumpInfo)localObject7).wording;
            if ((localObject8 == null) || (((CharSequence)localObject8).length() == 0))
            {
              k = 1;
              if (k != 0) {
                break label2255;
              }
            }
            for (k = 1;; k = 0)
            {
              if (k == 0) {
                break label2259;
              }
              ((Collection)localObject4).add(localObject7);
              break;
              k = 0;
              break label2223;
            }
          }
          localObject4 = (List)localObject4;
          break label1241;
          k = 0;
          break label1266;
        }
        label1601:
        label1990:
        label2255:
        label2259:
        label2271:
        localObject3 = ah.aiuX;
        label1723:
        label1984:
        label2288:
        localObject3 = i.a((i)localObject1);
        label1845:
        localObject4 = (Set)localObject6;
        label1927:
        label1968:
        label1972:
        if (((Boolean)((i.b)localObject3).BdN.invoke(localObject4)).booleanValue())
        {
          localObject3 = (Map)((i.b)localObject3).BdO;
          localObject4 = new i.c(l, cn.bDu());
          ((i.c)localObject4).BdP = 2;
          ((Map)localObject3).put(Long.valueOf(l), localObject4);
        }
        label2072:
        label2223:
        localObject3 = (f)bg.kCh();
        localObject4 = (m)new a((i)localObject1, l, localbrr, j, (HashSet)localObject6, null);
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.VC = localObject2;
        this.aai = i;
        this.asI = j;
        this.nuz = m;
        this.label = 3;
        if (l.a((f)localObject3, (m)localObject4, this) != locala) {
          break label2541;
        }
        AppMethodBeat.o(364153);
        return locala;
      }
      int i = this.nuz;
      int k = this.asI;
      final int j = this.aai;
      Object localObject2 = (Iterator)this.VC;
      Object localObject1 = (i)this.Uf;
      Object localObject3 = (aub)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject3;
      for (;;)
      {
        m = j;
        j = k;
        k = i;
        i = m;
        break;
        label2522:
        jdField_this.BdG = null;
        paramObject = ah.aiuX;
        AppMethodBeat.o(364153);
        return paramObject;
        label2541:
        k = m;
        m = i;
        i = k;
        k = j;
        j = m;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(i parami, long paramLong, brr parambrr, int paramInt, HashSet<h> paramHashSet, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(370892);
        paramObject = (kotlin.d.d)new a(this.BdR, l, j, this.AsP, this.ENw, paramd);
        AppMethodBeat.o(370892);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(370891);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(370891);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        i.a(this.BdR, l, j.ZZS, this.AsP).t(this.ENw);
        paramObject = ah.aiuX;
        AppMethodBeat.o(370891);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "jumpInfoSet", "", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedAllJumpInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Set<? extends h>, Boolean>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int aai;
    int label;
    
    f(List<? extends FinderItem> paramList, int paramInt, i parami, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(364142);
      paramObject = (kotlin.d.d)new f(this.BdV, paramInt, jdField_this, paramd);
      AppMethodBeat.o(364142);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(364135);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      final int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(364135);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (Iterable)this.BdV;
        paramObject = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject3;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = (FinderItem)localObject2;
          if ((((FinderItem)localObject3).field_finderObject.adFlag > 0) && (((FinderItem)localObject3).field_finderObject.id == 0L)) {}
          for (i = 1; i != 0; i = 0)
          {
            paramObject.add(localObject2);
            break;
          }
        }
        localObject1 = (Iterable)paramObject;
        i = paramInt;
        paramObject = jdField_this;
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (FinderItem)((Iterator)localObject1).next();
          localObject2 = (f)bg.kCh();
          localObject3 = (m)new a((FinderItem)localObject3, i, paramObject, null);
          this.L$0 = paramObject;
          this.Uf = localObject1;
          this.aai = i;
          this.label = 1;
          if (l.a((f)localObject2, (m)localObject3, this) != locala) {
            break label308;
          }
          AppMethodBeat.o(364135);
          return locala;
        }
        break;
      case 1: 
        i = this.aai;
        localObject1 = (Iterator)this.Uf;
        localObject2 = (i)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      label308:
      for (;;)
      {
        break;
        paramObject = ah.aiuX;
        AppMethodBeat.o(364135);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(FinderItem paramFinderItem, int paramInt, i parami, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(364175);
        paramObject = (kotlin.d.d)new a(this.BdW, i, paramObject, paramd);
        AppMethodBeat.o(364175);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(364170);
        Object localObject1 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(364170);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.BdW.getFeedObject().attachmentList;
        if (paramObject != null)
        {
          paramObject = paramObject.ZEi;
          if (paramObject != null)
          {
            localObject1 = (Iterable)paramObject;
            paramObject = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
            label165:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              atq localatq = (atq)localObject2;
              av localav = av.GiL;
              s.s(localatq, "it");
              if (!av.a(localatq)) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label165;
                }
                paramObject.add(localObject2);
                break;
              }
            }
            paramObject = (Iterable)paramObject;
            localObject1 = (Collection)new ArrayList(p.a(paramObject, 10));
            Object localObject2 = paramObject.iterator();
            if (((Iterator)localObject2).hasNext())
            {
              paramObject = ((atq)((Iterator)localObject2).next()).ZEh;
              if (paramObject == null) {}
              for (paramObject = null;; paramObject = paramObject.ZNl)
              {
                ((Collection)localObject1).add(paramObject);
                break;
              }
            }
            localObject2 = (List)localObject1;
            int i = i;
            paramObject = this.BdW;
            localObject1 = paramObject;
            localObject2 = new h(i, paramObject.getExpectId(), 2, p.l((Iterable)localObject2));
            i.a((i)localObject1, paramObject.getExpectId(), paramObject.field_finderObject.adFlag, i).t(ar.setOf(localObject2));
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(364170);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.i
 * JD-Core Version:    0.7.0.1
 */