package com.tencent.mm.plugin.finder.feed.model;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lkotlin.o<Ljava.lang.Long;Ljava.lang.String;>;>;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderAdInfoPreLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderBatchSyncLoader;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adH5CacheManager", "Lcom/tencent/mm/plugin/finder/feed/model/FinderAdCacheManager;", "adSnsCacheManager", "curRequest", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderBatchGetObjectAsyncLoadInfoRequest;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "lastLoadTime", "loadingIds", "", "kotlin.jvm.PlatformType", "", "mutualAdHandler", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedMutualAdHandler;", "preloadIdsGenerator", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestIntervalLimit", "requestType", "uxInfo", "", "addMutualCache", "", "loadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectAsyncLoadInfo;", "notifyIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addSnsCache", "batchLoad", "ids", "Lkotlin/Pair;", "clearCache", "id", "type", "convertFlagToScene", "filterFeedId", "", "feedId", "nonceId", "getCommentScene", "getSyncData", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "getUxInfo", "handleRequestSignal", "message", "Landroid/os/Message;", "isInCache", "adType", "isInValidPos", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "isInterrupt", "notify", "mutualIds", "snsIds", "onAsyncInfoMap", "infoMap", "onAttach", "generator", "onDetach", "onEventHappen", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onScrollEvent", "feeds", "publishEvent", "idList", "publishListEvent", "requestLoad", "scrollRequest", "setUxInfo", "Companion", "plugin-finder_release"})
public final class f
  implements n<Long>
{
  private static final int xFW = 1000;
  private static final int xFX = 1001;
  private static final int xFY = 1002;
  private static final int xFZ = 1003;
  public static final a xGa;
  private Activity activity;
  private Fragment fragment;
  private RecyclerView jLl;
  private final kotlin.f ocu;
  private int requestType;
  private String uxInfo;
  private final e xFQ;
  private final e xFR;
  private final List<Long> xFS;
  private com.tencent.mm.plugin.finder.feed.l xFT;
  private m<? super Integer, ? super Integer, ? extends LinkedList<bu>> xFU;
  private com.tencent.mm.plugin.finder.cgi.g xFV;
  
  static
  {
    AppMethodBeat.i(271365);
    xGa = new a((byte)0);
    xFW = 1000;
    xFX = 1001;
    xFY = 1002;
    xFZ = 1003;
    AppMethodBeat.o(271365);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(271363);
    g localg = g.xGi;
    this.xFQ = g.dul();
    localg = g.xGi;
    this.xFR = g.dum();
    this.uxInfo = "";
    this.xFS = Collections.synchronizedList((List)new ArrayList());
    this.ocu = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.activity = paramActivity;
    if (!(paramActivity instanceof MMActivity)) {
      paramActivity = null;
    }
    for (;;)
    {
      paramActivity = (MMActivity)paramActivity;
      if (paramActivity != null)
      {
        this.xFT = new com.tencent.mm.plugin.finder.feed.l(paramActivity);
        AppMethodBeat.o(271363);
        return;
      }
      AppMethodBeat.o(271363);
      return;
    }
  }
  
  public f(Fragment paramFragment)
  {
    AppMethodBeat.i(271364);
    Object localObject = g.xGi;
    this.xFQ = g.dul();
    localObject = g.xGi;
    this.xFR = g.dum();
    this.uxInfo = "";
    this.xFS = Collections.synchronizedList((List)new ArrayList());
    this.ocu = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.fragment = paramFragment;
    localObject = paramFragment.getActivity();
    paramFragment = (Fragment)localObject;
    if (!(localObject instanceof MMActivity)) {
      paramFragment = null;
    }
    paramFragment = (MMActivity)paramFragment;
    if (paramFragment != null)
    {
      this.xFT = new com.tencent.mm.plugin.finder.feed.l(paramFragment);
      AppMethodBeat.o(271364);
      return;
    }
    AppMethodBeat.o(271364);
  }
  
  private final boolean G(long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(271356);
    com.tencent.mm.plugin.finder.utils.d locald = com.tencent.mm.plugin.finder.utils.d.ACS;
    int j;
    if (com.tencent.mm.plugin.finder.utils.d.gX(paramInt, 1))
    {
      locald = com.tencent.mm.plugin.finder.utils.d.ACS;
      if (com.tencent.mm.plugin.finder.utils.d.gX(this.requestType, 1)) {
        if (H(paramLong, 1) != null) {
          j = 1;
        }
      }
    }
    for (;;)
    {
      locald = com.tencent.mm.plugin.finder.utils.d.ACS;
      int k = j;
      if (com.tencent.mm.plugin.finder.utils.d.gX(paramInt, 2))
      {
        locald = com.tencent.mm.plugin.finder.utils.d.ACS;
        k = j;
        if (com.tencent.mm.plugin.finder.utils.d.gX(this.requestType, 2))
        {
          Log.i("Finder.AdInfoPreLoader", "cache " + H(paramLong, 2));
          if (H(paramLong, 2) == null) {
            break label146;
          }
        }
      }
      label146:
      for (paramInt = i;; paramInt = 0)
      {
        k = j | paramInt;
        AppMethodBeat.o(271356);
        return k;
        j = 0;
        break;
      }
      j = 0;
    }
  }
  
  private o H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(271359);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(271359);
      return null;
    case 1: 
      localo = (o)this.xFQ.KU(paramLong);
      AppMethodBeat.o(271359);
      return localo;
    }
    o localo = (o)this.xFR.KU(paramLong);
    AppMethodBeat.o(271359);
    return localo;
  }
  
  private final void a(bfr parambfr, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(271357);
    Object localObject = parambfr.SQt;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      for (localObject = null; localIterator.hasNext(); localObject = new a(parambfr.object_id, (i)localObject))
      {
        localObject = new i((String)localIterator.next());
        if ((p.h("3021461725186497", ((i)localObject).opt("ad_posid")) ^ true)) {
          Log.i("Finder.AdInfoPreLoader", "not h5 type pos id");
        }
      }
    }
    localObject = null;
    Log.i("Finder.AdInfoPreLoader", "save mutual cache and notify adCache:".concat(String.valueOf(localObject)));
    if (localObject != null)
    {
      this.xFQ.a((com.tencent.mm.plugin.finder.feed.model.internal.a)localObject);
      paramArrayList.add(Long.valueOf(parambfr.object_id));
      AppMethodBeat.o(271357);
      return;
    }
    AppMethodBeat.o(271357);
  }
  
  private final void ae(LinkedList<bu> paramLinkedList)
  {
    try
    {
      AppMethodBeat.i(271352);
      if (paramLinkedList == null) {
        break label514;
      }
      localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof BaseFinderFeed)) {
          paramLinkedList.add(localObject2);
        }
      }
      localObject1 = (Iterable)paramLinkedList;
    }
    finally {}
    paramLinkedList = (Collection)new ArrayList();
    Object localObject1 = ((Iterable)localObject1).iterator();
    int i;
    boolean bool1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)localObject2;
      long l = localBaseFinderFeed.feedObject.getExpectId();
      i = localBaseFinderFeed.feedObject.getFeedObject().adFlag;
      com.tencent.mm.plugin.finder.utils.d locald = com.tencent.mm.plugin.finder.utils.d.ACS;
      boolean bool2 = com.tencent.mm.plugin.finder.utils.d.gX(i, this.requestType);
      if (!bool2) {
        break label544;
      }
      bool1 = G(l, i);
      label186:
      boolean bool3 = s(localBaseFinderFeed.feedObject.getExpectId(), localBaseFinderFeed.feedObject.getObjectNonceId());
      Log.i("Finder.AdInfoPreLoader", "scrollRequest id" + com.tencent.mm.ae.d.Fw(l) + " adType:" + i + " isAdType:" + bool2 + " isFilter: " + bool3 + " isInCache:" + bool1);
      if ((!bool2) || (!bool3) || (bool1)) {
        break label550;
      }
      i = 1;
      label293:
      if (i == 0) {
        break label553;
      }
      paramLinkedList.add(localObject2);
    }
    localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseFinderFeed)((Iterator)localObject1).next();
      paramLinkedList.add(new kotlin.o(Long.valueOf(((BaseFinderFeed)localObject2).feedObject.getExpectId()), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId()));
    }
    paramLinkedList = (List)paramLinkedList;
    label408:
    Object localObject2 = new StringBuilder("requestIds ");
    if (paramLinkedList != null)
    {
      localObject1 = Integer.valueOf(paramLinkedList.size());
      label435:
      Log.i("Finder.AdInfoPreLoader", localObject1);
      if (paramLinkedList == null) {
        break label535;
      }
      if (((Collection)paramLinkedList).isEmpty()) {
        break label525;
      }
      i = 1;
      break label555;
    }
    for (;;)
    {
      label472:
      if (paramLinkedList != null)
      {
        btS().removeMessages(xFW);
        btS().sendMessage(btS().obtainMessage(xFW, paramLinkedList));
        AppMethodBeat.o(271352);
        label511:
        return;
        paramLinkedList = null;
        break label408;
        localObject1 = null;
        break label435;
        i = 0;
      }
      label514:
      label525:
      label535:
      label544:
      label550:
      label553:
      label555:
      while (i == 0)
      {
        paramLinkedList = null;
        break label472;
        AppMethodBeat.o(271352);
        break label511;
        bool1 = false;
        break label186;
        i = 0;
        break label293;
        break;
      }
    }
  }
  
  private final void b(bfr parambfr, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(271358);
    Object localObject = parambfr.SQu;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      for (localObject = null; localIterator.hasNext(); localObject = new b(parambfr.object_id, (i)localObject)) {
        localObject = new i((String)localIterator.next());
      }
    }
    localObject = null;
    Log.i("Finder.AdInfoPreLoader", "save sns cache and notify ".concat(String.valueOf(localObject)));
    if (localObject != null)
    {
      this.xFR.a((com.tencent.mm.plugin.finder.feed.model.internal.a)localObject);
      paramArrayList.add(Long.valueOf(parambfr.object_id));
      AppMethodBeat.o(271358);
      return;
    }
    AppMethodBeat.o(271358);
  }
  
  private final MMHandler btS()
  {
    AppMethodBeat.i(271346);
    MMHandler localMMHandler = (MMHandler)this.ocu.getValue();
    AppMethodBeat.o(271346);
    return localMMHandler;
  }
  
  private final String dug()
  {
    AppMethodBeat.i(271355);
    Object localObject1 = this.activity;
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        Object localObject2 = aj.Bnu;
        localObject1 = aj.a.fZ((Context)localObject1);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((aj)localObject1).extraInfo;
        if (Util.isNullOrNil((String)localObject1)) {
          continue;
        }
        localObject1 = new i((String)localObject1).MK("sns_ad");
        if (localObject1 != null)
        {
          localObject2 = ((i)localObject1).optString("uxinfo");
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
      }
      catch (com.tencent.mm.ad.g localg)
      {
        Log.printErrStackTrace("Finder.AdInfoPreLoader", (Throwable)localg, "parse json error", new Object[0]);
        str = "";
        continue;
      }
      Log.i("Finder.AdInfoPreLoader", "getUxInfo: ".concat(String.valueOf(localObject1)));
      if (Util.isNullOrNil((String)localObject1)) {
        break;
      }
      AppMethodBeat.o(271355);
      return localObject1;
      localObject1 = null;
      continue;
      str = "";
    }
    String str = this.uxInfo;
    AppMethodBeat.o(271355);
    return str;
  }
  
  private void ed(List<kotlin.o<Long, String>> paramList)
  {
    Object localObject1;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(271353);
        p.k(paramList, "ids");
        Log.i("Finder.AdInfoPreLoader", "batchLoad request ids size = " + paramList.size());
        localObject1 = (Iterable)paramList;
        paramList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (kotlin.o)localObject2;
        boolean bool1 = G(((Number)((kotlin.o)localObject3).Mx).longValue(), this.requestType);
        boolean bool2 = this.xFS.contains(((kotlin.o)localObject3).Mx);
        Log.i("Finder.AdInfoPreLoader", "id: " + com.tencent.mm.ae.d.Fw(((Number)((kotlin.o)localObject3).Mx).longValue()) + " isInCache " + bool1 + " isInLoading:" + bool2);
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
    Object localObject3 = new LinkedList((Collection)paramList);
    Log.i("Finder.AdInfoPreLoader", "filteredIds size = " + ((LinkedList)localObject3).size());
    if (!((Collection)localObject3).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        paramList = this.xFS;
        localObject2 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(Long.valueOf(((Number)((kotlin.o)((Iterator)localObject2).next()).Mx).longValue()));
        }
        paramList.addAll((Collection)localObject1);
        localObject1 = this.activity;
        paramList = (List<kotlin.o<Long, String>>)localObject1;
        if (localObject1 == null)
        {
          paramList = this.fragment;
          if (paramList == null) {
            break label640;
          }
          paramList = paramList.getActivity();
          paramList = (Activity)paramList;
        }
        localObject1 = paramList;
        if (!(paramList instanceof MMActivity)) {
          localObject1 = null;
        }
        localObject2 = (MMActivity)localObject1;
        if ((localObject2 != null) && (!((MMActivity)localObject2).isFinishing()))
        {
          localObject3 = (List)localObject3;
          switch (this.requestType)
          {
          }
        }
      }
    }
    for (;;)
    {
      label488:
      label500:
      int j;
      if (this.activity != null)
      {
        paramList = this.activity;
        if (paramList == null) {
          break label699;
        }
        localObject1 = aj.Bnu;
        paramList = aj.a.fZ((Context)paramList);
        if (paramList == null) {
          break label694;
        }
        paramList = paramList.ekY();
        if (paramList == null) {
          break label694;
        }
        j = paramList.xkX;
      }
      for (;;)
      {
        Log.i("Finder.AdInfoPreLoader", "commentScene: ".concat(String.valueOf(j)));
        String str = z.bdh();
        p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
        localObject1 = dug();
        paramList = (List<kotlin.o<Long, String>>)localObject1;
        if (localObject1 == null) {
          paramList = "";
        }
        paramList = new com.tencent.mm.plugin.finder.cgi.g((List)localObject3, i, j, str, paramList, 4);
        paramList.bhW().h((com.tencent.mm.vending.c.a)new b(this, (MMActivity)localObject2)).a((com.tencent.mm.vending.e.b)localObject2);
        this.xFV = paramList;
        AppMethodBeat.o(271353);
        return;
        label640:
        paramList = null;
        break;
        i = 4;
        break label488;
        i = 2;
        break label488;
        if (this.fragment != null)
        {
          paramList = this.fragment;
          if (paramList != null) {}
          for (paramList = paramList.getActivity();; paramList = null)
          {
            paramList = (Activity)paramList;
            break;
          }
        }
        paramList = null;
        break label500;
        label694:
        j = 0;
        continue;
        label699:
        j = 0;
      }
      i = 0;
      break;
      i = -1;
    }
  }
  
  private static boolean s(long paramLong, String paramString)
  {
    AppMethodBeat.i(271362);
    if ((paramLong == 0L) || (Util.isNullOrNil(paramString)))
    {
      Log.i("Finder.AdInfoPreLoader", "requestLoad block");
      AppMethodBeat.o(271362);
      return false;
    }
    AppMethodBeat.o(271362);
    return true;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(271349);
    p.k(paramb, "ev");
    Object localObject = this.xFT;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.feed.o)localObject).xyq;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.event.base.d)localObject).a(paramb);
        AppMethodBeat.o(271349);
        return;
      }
    }
    AppMethodBeat.o(271349);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb, final LinkedList<bu> paramLinkedList)
  {
    AppMethodBeat.i(271350);
    p.k(paramb, "ev");
    if ((paramb instanceof h)) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramb, paramLinkedList));
    }
    AppMethodBeat.o(271350);
  }
  
  public final void a(m<? super Integer, ? super Integer, ? extends LinkedList<bu>> paramm, RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(271347);
    Log.i("Finder.AdInfoPreLoader", "onAttach");
    this.xFU = paramm;
    this.jLl = paramRecyclerView;
    this.requestType = paramInt;
    paramm = this.xFT;
    if (paramm != null)
    {
      paramm.m(paramRecyclerView);
      AppMethodBeat.o(271347);
      return;
    }
    AppMethodBeat.o(271347);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(271348);
    Log.i("Finder.AdInfoPreLoader", "onDetach");
    btS().removeCallbacksAndMessages(null);
    this.xFS.clear();
    this.xFU = null;
    Object localObject = this.xFV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.cgi.g)localObject).cancel();
    }
    localObject = this.xFT;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.feed.l)localObject).onDetach();
    }
    this.jLl = null;
    this.xFT = null;
    this.activity = null;
    this.fragment = null;
    AppMethodBeat.o(271348);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderAdInfoPreLoader$Companion;", "", "()V", "MANUAL_REQUEST_SIGNAL", "", "NOTIFY_BY_CLICK", "NOTIFY_SIGNAL", "PRELOAD_LIMIT", "SCROLL_REQUEST_SIGNAL", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/finder/feed/model/FinderAdInfoPreLoader$batchLoad$2$1"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(f paramf, MMActivity paramMMActivity) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    c(f paramf)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a
      implements MMHandler.Callback
    {
      a(f.c paramc) {}
      
      public final boolean handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(287151);
        int i = paramMessage.what;
        Object localObject;
        if (i == f.duh())
        {
          localObject = this.xGd.xGb;
          p.j(paramMessage, "it");
          f.a((f)localObject, paramMessage);
        }
        for (;;)
        {
          AppMethodBeat.o(287151);
          return true;
          if (i == f.dui())
          {
            localObject = this.xGd.xGb;
            p.j(paramMessage, "it");
            f.a((f)localObject, paramMessage);
          }
          else
          {
            if (i == f.duj())
            {
              localObject = paramMessage.obj;
              paramMessage = (Message)localObject;
              if (!(localObject instanceof kotlin.o)) {
                paramMessage = null;
              }
              localObject = (kotlin.o)paramMessage;
              if (localObject != null)
              {
                paramMessage = (ArrayList)((kotlin.o)localObject).Mx;
                label112:
                f.d(paramMessage, 15);
                if (localObject == null) {
                  break label144;
                }
              }
              label144:
              for (paramMessage = (ArrayList)((kotlin.o)localObject).My;; paramMessage = null)
              {
                f.d(paramMessage, 16);
                break;
                paramMessage = null;
                break label112;
              }
            }
            f.duk();
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(f paramf, com.tencent.mm.plugin.finder.event.base.b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.f
 * JD-Core Version:    0.7.0.1
 */