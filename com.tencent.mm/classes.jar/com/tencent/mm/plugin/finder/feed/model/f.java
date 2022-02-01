package com.tencent.mm.plugin.finder.feed.model;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.w;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderAdInfoPreLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderBatchSyncLoader;", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderAdInfoPreLoader;", "()V", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adH5CacheManager", "Lcom/tencent/mm/plugin/finder/feed/model/FinderAdCacheManager;", "adSnsCacheManager", "curRequest", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "jumperUIC", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC;", "getJumperUIC", "()Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC;", "jumperUIC$delegate", "lastLoadTime", "loadedIds", "", "kotlin.jvm.PlatformType", "", "loadingIds", "", "", "preloadIdsGenerator", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestIntervalLimit", "requestType", "uxInfo", "", "addMutualCache", "", "loadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectAsyncLoadInfo;", "notifyIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addSnsCache", "batchLoad", "ids", "Lkotlin/Pair;", "clearCache", "id", "type", "convertFlagToScene", "filterFeedId", "", "feedId", "nonceId", "getCommentScene", "getSyncData", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "getUxInfo", "handleRequestSignal", "message", "Landroid/os/Message;", "init", "isInCache", "adType", "isInValidPos", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "isInterrupt", "isLoaded", "notify", "mutualIds", "snsIds", "onAsyncInfoMap", "infoMap", "onAttach", "generator", "onDetach", "onEventHappen", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onScrollEvent", "feeds", "publishEvent", "idList", "publishListEvent", "requestLoad", "scrollRequest", "setUxInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements p<Long>, w
{
  public static final a BeJ;
  private static final int BeQ;
  private static final int BeR;
  private static final int BeS;
  private static final int BeT;
  private final j Bcf;
  private final e BeK;
  private final e BeL;
  private final List<Long> BeM;
  private final Set<Long> BeN;
  private m<? super Integer, ? super Integer, ? extends LinkedList<cc>> BeO;
  private c<aub> BeP;
  private Activity activity;
  private Fragment fragment;
  private RecyclerView mkw;
  private final j rdm;
  private int requestType;
  private String uxInfo;
  
  static
  {
    AppMethodBeat.i(366102);
    BeJ = new a((byte)0);
    BeQ = 1000;
    BeR = 1001;
    BeS = 1002;
    BeT = 1003;
    AppMethodBeat.o(366102);
  }
  
  public f()
  {
    AppMethodBeat.i(365967);
    this.Bcf = k.cm((kotlin.g.a.a)c.BeV);
    g localg = g.BeY;
    this.BeK = g.edK();
    localg = g.BeY;
    this.BeL = g.edL();
    this.uxInfo = "";
    this.BeM = Collections.synchronizedList((List)new ArrayList());
    this.BeN = Collections.synchronizedSet((Set)new HashSet());
    this.rdm = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(365967);
  }
  
  private static final Object a(f paramf, b.a parama)
  {
    AppMethodBeat.i(366056);
    s.u(paramf, "this$0");
    Log.i("Finder.AdInfoPreLoader", "errType: " + parama.errType + " erroCode:" + parama.errCode);
    if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
    {
      parama = ((aub)parama.ott).ZEz;
      if (parama == null)
      {
        AppMethodBeat.o(366056);
        return null;
      }
      paramf.aj(parama);
      AppMethodBeat.o(366056);
      return parama;
    }
    paramf.BeM.clear();
    paramf = ah.aiuX;
    AppMethodBeat.o(366056);
    return paramf;
  }
  
  private final void a(bqy parambqy, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(366039);
    Object localObject = parambqy.ZYU;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      for (localObject = null; localIterator.hasNext(); localObject = new a(parambqy.object_id, (com.tencent.mm.ad.i)localObject))
      {
        localObject = (String)localIterator.next();
        if (s.p("{}", localObject))
        {
          Log.i("Finder.AdInfoPreLoader", "mutual info is empty return");
          AppMethodBeat.o(366039);
          return;
        }
        localObject = new com.tencent.mm.ad.i((String)localObject);
        if (!s.p("3021461725186497", ((com.tencent.mm.ad.i)localObject).opt("ad_posid"))) {
          Log.i("Finder.AdInfoPreLoader", "not h5 type pos id");
        }
      }
    }
    localObject = null;
    Log.i("Finder.AdInfoPreLoader", s.X("save mutual cache and notify adCache:", localObject));
    if (localObject != null)
    {
      long l = parambqy.object_id;
      if (this.BeK.contains(l)) {
        this.BeK.nA(l);
      }
      this.BeK.a((com.tencent.mm.plugin.finder.feed.model.internal.a)localObject);
      paramArrayList.add(Long.valueOf(l));
    }
    AppMethodBeat.o(366039);
  }
  
  private final void ai(LinkedList<cc> paramLinkedList)
  {
    int i;
    label55:
    Object localObject3;
    try
    {
      AppMethodBeat.i(365986);
      if (paramLinkedList == null)
      {
        localObject1 = null;
        break label603;
        Log.i("Finder.AdInfoPreLoader", s.X("requestIds ", localObject2));
        if (localObject1 != null)
        {
          if (((Collection)localObject1).isEmpty()) {
            break label592;
          }
          i = 1;
          break label614;
          if (localObject1 != null)
          {
            getHandler().removeMessages(BeQ);
            getHandler().sendMessage(getHandler().obtainMessage(BeQ, localObject1));
          }
        }
        Log.i("Finder.AdInfoPreLoader", s.X("scrollRequest commentScene:", Integer.valueOf(getCommentScene())));
        ((com.tencent.mm.plugin.finder.feed.jumper.i)this.Bcf.getValue()).E((List)paramLinkedList, getCommentScene());
        AppMethodBeat.o(365986);
        return;
      }
      localObject2 = (Iterable)paramLinkedList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof BaseFinderFeed)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject2 = (Iterable)localObject1;
    }
    finally {}
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = ((Iterable)localObject2).iterator();
    label244:
    label633:
    label636:
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        Object localObject4 = (BaseFinderFeed)localObject3;
        long l1 = ((BaseFinderFeed)localObject4).feedObject.getExpectId();
        i = ((BaseFinderFeed)localObject4).feedObject.getFeedObject().adFlag;
        com.tencent.mm.plugin.finder.utils.g localg = com.tencent.mm.plugin.finder.utils.g.GfZ;
        boolean bool3 = com.tencent.mm.plugin.finder.utils.g.io(i, this.requestType);
        if (!bool3) {
          break label621;
        }
        bool1 = nB(l1);
        long l2 = ((BaseFinderFeed)localObject4).feedObject.getExpectId();
        localObject4 = ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId();
        if ((l2 != 0L) && (!Util.isNullOrNil((String)localObject4))) {
          break label627;
        }
        Log.i("Finder.AdInfoPreLoader", "requestLoad block");
        bool2 = false;
        Log.i("Finder.AdInfoPreLoader", "scrollRequest id" + d.hF(l1) + " adType:" + i + " isAdType:" + bool3 + " isFilter: " + bool2 + " isInCache:" + bool1);
        if ((!bool3) || (!bool2) || (bool1)) {
          break label633;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label636;
        }
        ((Collection)localObject1).add(localObject3);
        break label244;
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BaseFinderFeed)((Iterator)localObject2).next();
          ((Collection)localObject1).add(new r(Long.valueOf(((BaseFinderFeed)localObject3).feedObject.getExpectId()), ((BaseFinderFeed)localObject3).feedObject.getObjectNonceId()));
        }
        localObject1 = (List)localObject1;
        break label603;
        i = ((List)localObject1).size();
        localObject2 = Integer.valueOf(i);
        break;
        i = 0;
        while (i == 0)
        {
          localObject1 = null;
          break label55;
          if (localObject1 != null) {
            break label575;
          }
          localObject2 = null;
          break;
        }
        break label55;
        bool1 = false;
        break label318;
        bool2 = true;
        break label365;
      }
    }
  }
  
  private final void aj(LinkedList<bqy> paramLinkedList)
  {
    AppMethodBeat.i(366031);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    try
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        bqy localbqy = (bqy)paramLinkedList.next();
        a(localbqy, localArrayList1);
        b(localbqy, localArrayList2);
        this.BeM.remove(Long.valueOf(localbqy.object_id));
        this.BeN.add(Long.valueOf(localbqy.object_id));
      }
      getHandler().removeMessages(BeR);
    }
    catch (Exception paramLinkedList)
    {
      Log.printErrStackTrace("Finder.AdInfoPreLoader", (Throwable)paramLinkedList, "FinderAdInfoPreLoader exception", new Object[0]);
      AppMethodBeat.o(366031);
      return;
    }
    getHandler().sendMessage(getHandler().obtainMessage(BeR, new r(localArrayList1, localArrayList2)));
    AppMethodBeat.o(366031);
  }
  
  private final void b(bqy parambqy, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(366048);
    Object localObject = parambqy.ZYV;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      for (localObject = null; localIterator.hasNext(); localObject = new b(parambqy.object_id, (com.tencent.mm.ad.i)localObject))
      {
        localObject = (String)localIterator.next();
        if (s.p("{}", localObject))
        {
          Log.i("Finder.AdInfoPreLoader", "sns info is empty return");
          AppMethodBeat.o(366048);
          return;
        }
        localObject = new com.tencent.mm.ad.i((String)localObject);
      }
    }
    localObject = null;
    Log.i("Finder.AdInfoPreLoader", s.X("save sns cache and notify ", localObject));
    if (localObject != null)
    {
      long l = parambqy.object_id;
      if (this.BeL.contains(l)) {
        this.BeL.nA(l);
      }
      this.BeL.a((com.tencent.mm.plugin.finder.feed.model.internal.a)localObject);
      paramArrayList.add(Long.valueOf(l));
    }
    AppMethodBeat.o(366048);
  }
  
  private final String edF()
  {
    AppMethodBeat.i(366008);
    Object localObject1 = this.activity;
    if (localObject1 != null) {}
    label136:
    for (;;)
    {
      try
      {
        Object localObject2 = as.GSQ;
        localObject1 = as.a.hu((Context)localObject1);
        if (localObject1 == null)
        {
          localObject1 = null;
          if (Util.isNullOrNil((String)localObject1)) {
            break label136;
          }
          localObject1 = new com.tencent.mm.ad.i((String)localObject1).Ft("sns_ad");
          if (localObject1 == null)
          {
            localObject1 = "";
            Log.i("Finder.AdInfoPreLoader", s.X("getUxInfo: ", localObject1));
            if (Util.isNullOrNil((String)localObject1)) {
              break;
            }
            AppMethodBeat.o(366008);
            return localObject1;
          }
        }
        else
        {
          localObject1 = ((as)localObject1).extraInfo;
          continue;
        }
        localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("uxinfo");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = "";
          continue;
          str = "";
        }
      }
      catch (com.tencent.mm.ad.g localg)
      {
        Log.printErrStackTrace("Finder.AdInfoPreLoader", (Throwable)localg, "parse json error", new Object[0]);
      }
    }
    String str = this.uxInfo;
    AppMethodBeat.o(366008);
    return str;
  }
  
  private void gc(List<r<Long, String>> paramList)
  {
    String str1 = null;
    Object localObject1;
    Object localObject3;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(365999);
        s.u(paramList, "ids");
        Log.i("Finder.AdInfoPreLoader", s.X("batchLoad request ids size = ", Integer.valueOf(paramList.size())));
        localObject1 = (Iterable)paramList;
        paramList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (r)localObject2;
        boolean bool1 = nB(((Number)((r)localObject3).bsC).longValue());
        boolean bool2 = this.BeM.contains(((r)localObject3).bsC);
        Log.i("Finder.AdInfoPreLoader", "id: " + d.hF(((Number)((r)localObject3).bsC).longValue()) + " isInCache " + bool1 + " isInLoading:" + bool2);
        if ((!bool2) && (!bool1))
        {
          i = 1;
          if (i != 0) {
            paramList.add(localObject2);
          }
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
    Object localObject2 = new LinkedList((Collection)paramList);
    Log.i("Finder.AdInfoPreLoader", s.X("filteredIds size = ", Integer.valueOf(((LinkedList)localObject2).size())));
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        paramList = this.BeM;
        localObject3 = (Iterable)localObject2;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject1).add(Long.valueOf(((Number)((r)((Iterator)localObject3).next()).bsC).longValue()));
        }
        paramList.addAll((Collection)localObject1);
        paramList = this.activity;
        localObject1 = paramList;
        if (paramList == null)
        {
          paramList = this.fragment;
          if (paramList != null) {
            break label573;
          }
          paramList = null;
          label396:
          localObject1 = (Activity)paramList;
        }
        paramList = str1;
        if ((localObject1 instanceof MMActivity)) {
          paramList = (MMActivity)localObject1;
        }
        if ((paramList != null) && (!paramList.isFinishing()))
        {
          localObject3 = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
          localObject2 = (List)localObject2;
          switch (this.requestType)
          {
          }
        }
      }
    }
    for (;;)
    {
      int j = getCommentScene();
      String str2 = z.bAW();
      s.s(str2, "getMyFinderUsername()");
      str1 = edF();
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = "";
      }
      localObject1 = ((com.tencent.mm.plugin.g)localObject3).b((List)localObject2, i, j, str2, (String)localObject1);
      ((c)localObject1).bFJ().h(new f..ExternalSyntheticLambda0(this)).a((com.tencent.mm.vending.e.b)paramList);
      paramList = ah.aiuX;
      this.BeP = ((c)localObject1);
      AppMethodBeat.o(365999);
      return;
      label573:
      paramList = paramList.getActivity();
      break label396;
      i = 4;
      continue;
      i = 2;
      continue;
      i = 0;
      break;
      i = -1;
    }
  }
  
  private final int getCommentScene()
  {
    as.a locala = null;
    Object localObject = null;
    AppMethodBeat.i(366023);
    int i;
    if (this.activity != null)
    {
      localObject = this.activity;
      if (localObject == null) {
        break label124;
      }
      locala = as.GSQ;
      localObject = as.a.hu((Context)localObject);
      if (localObject != null) {
        break label102;
      }
      i = 0;
    }
    for (;;)
    {
      Log.i("Finder.AdInfoPreLoader", s.X("commentScene: ", Integer.valueOf(i)));
      AppMethodBeat.o(366023);
      return i;
      if (this.fragment == null) {
        break;
      }
      localObject = this.fragment;
      if (localObject == null) {}
      for (localObject = locala;; localObject = ((Fragment)localObject).getActivity())
      {
        localObject = (Activity)localObject;
        break;
      }
      label102:
      localObject = ((as)localObject).fou();
      if (localObject == null)
      {
        i = 0;
      }
      else
      {
        i = ((bui)localObject).AJo;
        continue;
        label124:
        i = 0;
      }
    }
  }
  
  private final MMHandler getHandler()
  {
    AppMethodBeat.i(365962);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(365962);
    return localMMHandler;
  }
  
  private final boolean nB(long paramLong)
  {
    AppMethodBeat.i(366012);
    boolean bool = this.BeN.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(366012);
    return bool;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(366136);
    s.u(paramb, "ev");
    AppMethodBeat.o(366136);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb, final LinkedList<cc> paramLinkedList)
  {
    AppMethodBeat.i(366143);
    s.u(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) {
      d.uiThread((kotlin.g.a.a)new d(this, paramb, paramLinkedList));
    }
    AppMethodBeat.o(366143);
  }
  
  public final void a(m<? super Integer, ? super Integer, ? extends LinkedList<cc>> paramm, RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(366125);
    Log.i("Finder.AdInfoPreLoader", "onAttach");
    this.BeO = paramm;
    this.mkw = paramRecyclerView;
    this.requestType = paramInt;
    AppMethodBeat.o(366125);
  }
  
  public final void av(Activity paramActivity)
  {
    AppMethodBeat.i(366113);
    s.u(paramActivity, "activity");
    this.activity = paramActivity;
    AppMethodBeat.o(366113);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(366130);
    Log.i("Finder.AdInfoPreLoader", "onDetach");
    getHandler().removeCallbacksAndMessages(null);
    this.BeM.clear();
    this.BeN.clear();
    this.BeO = null;
    c localc = this.BeP;
    if (localc != null) {
      localc.cancel();
    }
    this.mkw = null;
    this.activity = null;
    this.fragment = null;
    AppMethodBeat.o(366130);
  }
  
  public final void w(Fragment paramFragment)
  {
    AppMethodBeat.i(366119);
    s.u(paramFragment, "fragment");
    this.fragment = paramFragment;
    AppMethodBeat.o(366119);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderAdInfoPreLoader$Companion;", "", "()V", "MANUAL_REQUEST_SIGNAL", "", "NOTIFY_BY_CLICK", "NOTIFY_SIGNAL", "PRELOAD_LIMIT", "SCROLL_REQUEST_SIGNAL", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    b(f paramf)
    {
      super();
    }
    
    private static final boolean b(f paramf, Message paramMessage)
    {
      Object localObject = null;
      AppMethodBeat.i(365941);
      s.u(paramf, "this$0");
      s.u(paramMessage, "it");
      int i = paramMessage.what;
      if (i == f.edG()) {
        f.a(paramf, paramMessage);
      }
      for (;;)
      {
        AppMethodBeat.o(365941);
        return true;
        if (i == f.edH())
        {
          f.a(paramf, paramMessage);
        }
        else
        {
          if (i == f.edI())
          {
            paramf = paramMessage.obj;
            if ((paramf instanceof r))
            {
              paramf = (r)paramf;
              label82:
              if (paramf != null) {
                break label114;
              }
              paramMessage = null;
              label88:
              f.g(paramMessage, 15);
              if (paramf != null) {
                break label125;
              }
            }
            label114:
            label125:
            for (paramf = localObject;; paramf = (ArrayList)paramf.bsD)
            {
              f.g(paramf, 16);
              break;
              paramf = null;
              break label82;
              paramMessage = (ArrayList)paramf.bsC;
              break label88;
            }
          }
          f.edJ();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedJumperGlobalUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.jumper.i>
  {
    public static final c BeV;
    
    static
    {
      AppMethodBeat.i(365926);
      BeV = new c();
      AppMethodBeat.o(365926);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(f paramf, com.tencent.mm.plugin.finder.event.base.b paramb, LinkedList<cc> paramLinkedList)
    {
      super();
    }
    
    private static final void a(com.tencent.mm.plugin.finder.event.base.b paramb, LinkedList paramLinkedList, f paramf)
    {
      AppMethodBeat.i(365929);
      s.u(paramb, "$ev");
      s.u(paramf, "this$0");
      int i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOr;
      StringBuilder localStringBuilder = new StringBuilder("onScrollEvent:").append(paramb).append(" type: ").append(((com.tencent.mm.plugin.finder.event.base.h)paramb).type).append(" firstItemPos:").append(i).append(" lastItemPos:").append(i + 5).append(" feeds.size: ");
      if (paramLinkedList == null) {}
      for (paramb = null;; paramb = Integer.valueOf(paramLinkedList.size()))
      {
        Log.i("Finder.AdInfoPreLoader", paramb);
        f.a(paramf, paramLinkedList);
        AppMethodBeat.o(365929);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.f
 * JD-Core Version:    0.7.0.1
 */