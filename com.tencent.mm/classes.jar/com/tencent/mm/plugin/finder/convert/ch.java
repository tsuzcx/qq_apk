package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.adapter.b.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;I)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "exposeItem", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "isEnablePreloadRefreshContent", "", "()Z", "isEnablePreloadRefreshContent$delegate", "Lkotlin/Lazy;", "isPreloadContenting", "isRefreshing", "itemView", "Landroid/view/View;", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1;", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lkotlin/collections/ArrayList;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshContentPreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1;", "singleTaskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "viewRect", "fetchContent", "", "isRefresh", "item", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "call", "Lkotlin/Function1;", "genStat", "getLayoutId", "isViewExposed", "view", "jumpRelatedTimelineUI", "context", "Landroid/content/Context;", "action", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "preloadContent", "reportStat", "Companion", "ExposeItem", "plugin-finder_release"})
public final class ch
  extends com.tencent.mm.view.recyclerview.e<ag>
{
  public static final a tGr;
  private View aus;
  private final int dLS;
  private RecyclerView hak;
  private boolean isRefreshing;
  private final kotlin.f tGg;
  private final kotlin.f tGh;
  private final i tGi;
  private final m<bo> tGj;
  private final ArrayList<cjl> tGk;
  private final Rect tGl;
  private final r tGm;
  private final FinderStreamCardAlbumConvert.lifecycleObserver.1 tGn;
  private b tGo;
  private boolean tGp;
  private final at tGq;
  private bbn ttO;
  private final Rect viewRect;
  
  static
  {
    AppMethodBeat.i(243325);
    tGr = new a((byte)0);
    AppMethodBeat.o(243325);
  }
  
  public ch(at paramat, int paramInt)
  {
    AppMethodBeat.i(243324);
    this.tGq = paramat;
    this.dLS = paramInt;
    this.tGg = g.ah((kotlin.g.a.a)q.tGK);
    this.tGh = g.ah((kotlin.g.a.a)d.tGD);
    paramat = new i("StreamCardFeedLoader");
    paramat.start();
    this.tGi = paramat;
    this.tGj = new m((byte)0);
    paramat = new ArrayList(4);
    paramInt = 0;
    while (paramInt < 4)
    {
      paramat.add(new cjl());
      paramInt += 1;
    }
    this.tGk = paramat;
    this.viewRect = new Rect();
    this.tGl = new Rect();
    this.tGm = new r(this);
    this.tGn = new FinderStreamCardAlbumConvert.lifecycleObserver.1(this);
    this.tGo = new b();
    AppMethodBeat.o(243324);
  }
  
  private final ecq a(ag paramag)
  {
    AppMethodBeat.i(243318);
    ecq localecq = new ecq();
    localecq.NcN = new epf();
    localecq.NcM = new mp();
    localecq.NcO = new cxr();
    localecq.hFK = paramag.tQQ.id;
    localecq.sessionBuffer = paramag.tQQ.sessionBuffer;
    y localy = y.vXH;
    localecq.tCE = y.LB(this.dLS);
    localecq.finderUsername = z.aUg();
    localecq.NcS = paramag.tQP;
    localecq.NcP = cl.aWA();
    localecq.mediaType = 11;
    AppMethodBeat.o(243318);
    return localecq;
  }
  
  private final void a(final ag paramag, final ecq paramecq)
  {
    long l2 = 0L;
    AppMethodBeat.i(243322);
    if (!cZN())
    {
      AppMethodBeat.o(243322);
      return;
    }
    Object localObject1 = (CharSequence)paramag.tQQ.LrN;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(243322);
      return;
    }
    if (this.tGj.ddC())
    {
      Log.w("Finder.FinderStreamCardAlbumConvert", "has cache never use. just return.");
      AppMethodBeat.o(243322);
      return;
    }
    if (this.tGp)
    {
      Log.w("Finder.FinderStreamCardAlbumConvert", "isPreloadContenting. just return.");
      AppMethodBeat.o(243322);
      return;
    }
    this.tGp = true;
    localObject1 = new StringBuilder("[preloadContent] now title=").append(paramag.tQQ.IFO).append(" stats=");
    if (paramecq != null) {}
    for (long l1 = paramecq.hFK;; l1 = 0L)
    {
      localObject1 = ((StringBuilder)localObject1).append(d.zs(l1)).append(' ').append("card request id=");
      Object localObject2 = paramag.tQQ.LLZ;
      l1 = l2;
      if (localObject2 != null)
      {
        localObject2 = ((bcv)localObject2).LMc;
        l1 = l2;
        if (localObject2 != null)
        {
          localObject2 = ((ato)localObject2).LEv;
          l1 = l2;
          if (localObject2 != null) {
            l1 = ((efo)localObject2).id;
          }
        }
      }
      Log.i("Finder.FinderStreamCardAlbumConvert", d.zs(l1) + ' ' + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(paramag.tQQ));
      this.tGi.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new p(this, paramecq, paramag)));
      AppMethodBeat.o(243322);
      return;
    }
  }
  
  private final void a(final boolean paramBoolean, final ag paramag, final ecq paramecq, final kotlin.g.a.b<? super ag, x> paramb)
  {
    AppMethodBeat.i(243323);
    Object localObject1 = new StringBuilder("[fetchContent] isRefresh=").append(paramBoolean).append(" hasCache=").append(this.tGj.ddC()).append(' ').append("card request id=");
    Object localObject2 = paramag.tQQ.LLZ;
    if (localObject2 != null)
    {
      localObject2 = ((bcv)localObject2).LMc;
      if (localObject2 != null)
      {
        localObject2 = ((ato)localObject2).LEv;
        if (localObject2 == null) {}
      }
    }
    for (long l = ((efo)localObject2).id;; l = 0L)
    {
      Log.i("Finder.FinderStreamCardAlbumConvert", d.zs(l) + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(paramag.tQQ));
      localObject1 = this.ttO;
      if (localObject1 == null) {
        p.btv("contextObj");
      }
      localObject1 = new FinderStreamCardAlbumConvert.fetchContent.loader.1(this, paramecq, (bbn)localObject1);
      ((FinderStreamCardAlbumConvert.fetchContent.loader.1)localObject1).register((com.tencent.mm.view.j)new c());
      this.tGi.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new c(this, paramBoolean, paramag, (FinderStreamCardAlbumConvert.fetchContent.loader.1)localObject1, paramecq, paramb)));
      AppMethodBeat.o(243323);
      return;
    }
  }
  
  private final boolean cZN()
  {
    AppMethodBeat.i(243316);
    boolean bool = ((Boolean)this.tGh.getValue()).booleanValue();
    AppMethodBeat.o(243316);
    return bool;
  }
  
  public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.h paramh, final int paramInt)
  {
    AppMethodBeat.i(243317);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    this.hak = paramRecyclerView;
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = paramRecyclerView.getContext();
    if (localObject == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243317);
      throw paramRecyclerView;
    }
    this.ttO = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject).get(FinderReporterUIC.class)).Mz(this.dLS);
    paramRecyclerView.b((RecyclerView.l)this.tGm);
    paramRecyclerView.a((RecyclerView.l)this.tGm);
    localObject = paramRecyclerView.getContext();
    if (localObject == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243317);
      throw paramRecyclerView;
    }
    ((MMActivity)localObject).getLifecycle().removeObserver((LifecycleObserver)this.tGn);
    paramRecyclerView = paramRecyclerView.getContext();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243317);
      throw paramRecyclerView;
    }
    ((MMActivity)paramRecyclerView).getLifecycle().addObserver((LifecycleObserver)this.tGn);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (LinearLayout)paramRecyclerView.findViewById(2131306771);
    paramRecyclerView.post((Runnable)new h(paramRecyclerView));
    paramRecyclerView.setOnClickListener((View.OnClickListener)new i(this, paramh, paramInt));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    ((LinearLayout)paramRecyclerView.findViewById(2131307472)).setOnClickListener((View.OnClickListener)new ch.j(paramh));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    ((TextView)paramRecyclerView.findViewById(2131298010)).setOnClickListener((View.OnClickListener)new ch.k(paramh));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131298010);
    p.g(paramRecyclerView, "holder.itemView.cardHeader");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131306769);
    p.g(paramRecyclerView, "holder.itemView.refreshContent");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    ((TextView)paramRecyclerView.findViewById(2131307470)).setOnClickListener((View.OnClickListener)new l(this, paramh));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    ((LinearLayout)paramRecyclerView.findViewById(2131298012)).setOnClickListener((View.OnClickListener)new m(this, paramh));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (FinderFeedAlbumView)paramRecyclerView.findViewById(2131300556);
    localObject = new n(this, paramh, (List)this.tGk);
    ((com.tencent.mm.plugin.finder.view.adapter.b)localObject).wrh = ((b.c)new g(this, paramh));
    paramRecyclerView.setAdapter((FinderFeedAlbumView.a)localObject);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
      paramh.aus.setOnLongClickListener((View.OnLongClickListener)new o(paramh));
    }
    AppMethodBeat.o(243317);
  }
  
  public final void a(final com.tencent.mm.view.recyclerview.h paramh, ag paramag, final int paramInt1, final int paramInt2, final boolean paramBoolean, final List<Object> paramList)
  {
    AppMethodBeat.i(243319);
    p.h(paramh, "holder");
    p.h(paramag, "item");
    Log.i("Finder.FinderStreamCardAlbumConvert", "[onBindViewHolder] isHotPatch=" + paramBoolean + " pos=" + paramInt1 + " item=" + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(paramag.tQQ) + " rvFeedList isEmpty=" + paramag.rvFeedList.isEmpty());
    this.aus = paramh.aus;
    this.tGo.feedId = paramag.tQQ.id;
    this.tGo.position = paramInt1;
    this.tGo.tGs = paramag;
    paramag.position = paramInt1;
    Object localObject1;
    if ((!paramBoolean) && (paramag.rvFeedList.isEmpty()))
    {
      localObject1 = paramag.tQQ.LLY;
      if ((localObject1 != null) && (((bcv)localObject1).type == 1)) {
        a(false, paramag, null, (kotlin.g.a.b)new e(this, paramh, paramInt1, paramInt2, paramBoolean, paramList));
      }
    }
    for (;;)
    {
      paramList = paramh.aus;
      p.g(paramList, "holder.itemView");
      ((NeatTextView)paramList.findViewById(2131309195)).aw((CharSequence)paramag.tQQ.IFO);
      paramList = paramh.aus;
      p.g(paramList, "holder.itemView");
      paramList = (TextView)paramList.findViewById(2131308714);
      p.g(paramList, "holder.itemView.subTitle");
      paramList.setText((CharSequence)paramag.tQQ.LLT);
      paramag = paramag.tQQ.LrN;
      if (paramag == null) {
        break;
      }
      paramList = paramh.aus;
      p.g(paramList, "holder.itemView");
      paramList = (LinearLayout)paramList.findViewById(2131306771);
      p.g(paramList, "holder.itemView.refreshLayout");
      paramList.setVisibility(0);
      paramh = paramh.aus;
      p.g(paramh, "holder.itemView");
      paramh = (TextView)paramh.findViewById(2131306769);
      p.g(paramh, "holder.itemView.refreshContent");
      paramh.setText((CharSequence)paramag);
      AppMethodBeat.o(243319);
      return;
      if (!((Collection)paramag.rvFeedList).isEmpty()) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        this.tGk.clear();
        paramList = this.tGk;
        Object localObject2 = (Iterable)paramag.rvFeedList;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add((cjl)((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getMediaList().getFirst());
        }
      }
      continue;
      paramList.addAll((Collection)((List)localObject1).subList(0, Math.min(4, paramag.rvFeedList.size())));
      paramList = paramh.aus;
      p.g(paramList, "holder.itemView");
      ((FinderFeedAlbumView)paramList.findViewById(2131300556)).dGH();
      paramList = paramh.aus;
      p.g(paramList, "holder.itemView");
      ((FinderFeedAlbumView)paramList.findViewById(2131300556)).post((Runnable)new f(this));
      a(paramag, a(paramag));
    }
    paramh = paramh.aus;
    p.g(paramh, "holder.itemView");
    paramh = (LinearLayout)paramh.findViewById(2131306771);
    p.g(paramh, "holder.itemView.refreshLayout");
    paramh.setVisibility(8);
    AppMethodBeat.o(243319);
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243321);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    boolean bool = this.tGj.clearCache();
    Log.i("Finder.FinderStreamCardAlbumConvert", "[onDetachedFromRecyclerView] ret=" + bool + " report unReadItem");
    paramRecyclerView = this.tGj.tYO;
    if (paramRecyclerView != null)
    {
      Object localObject = y.vXH;
      int i = this.dLS;
      localObject = paramRecyclerView.getIncrementList();
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = (List)new LinkedList();
      }
      localObject = this.ttO;
      if (localObject == null) {
        p.btv("contextObj");
      }
      y.a(i, paramRecyclerView, (bbn)localObject);
      AppMethodBeat.o(243321);
      return;
    }
    AppMethodBeat.o(243321);
  }
  
  public final int getLayoutId()
  {
    return 2131492876;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "feedId", "", "sumTimeMs", "startTimeMs", "position", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;JJJI)V", "getFeedId", "()J", "setFeedId", "(J)V", "getItem", "()Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "setItem", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;)V", "getPosition", "()I", "setPosition", "(I)V", "getStartTimeMs", "setStartTimeMs", "getSumTimeMs", "setSumTimeMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    long feedId = 0L;
    int position = -1;
    long startTimeMs = 0L;
    ag tGs = null;
    private long tGt = 0L;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(243282);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.tGs, paramObject.tGs)) || (this.feedId != paramObject.feedId) || (this.tGt != paramObject.tGt) || (this.startTimeMs != paramObject.startTimeMs) || (this.position != paramObject.position)) {}
        }
      }
      else
      {
        AppMethodBeat.o(243282);
        return true;
      }
      AppMethodBeat.o(243282);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(243281);
      ag localag = this.tGs;
      if (localag != null) {}
      for (int i = localag.hashCode();; i = 0)
      {
        long l = this.feedId;
        int j = (int)(l ^ l >>> 32);
        l = this.tGt;
        int k = (int)(l ^ l >>> 32);
        l = this.startTimeMs;
        int m = (int)(l ^ l >>> 32);
        int n = this.position;
        AppMethodBeat.o(243281);
        return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243280);
      String str = "ExposeItem(item=" + this.tGs + ", feedId=" + this.feedId + ", sumTimeMs=" + this.tGt + ", startTimeMs=" + this.startTimeMs + ", position=" + this.position + ")";
      AppMethodBeat.o(243280);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    c(ch paramch, boolean paramBoolean, ag paramag, FinderStreamCardAlbumConvert.fetchContent.loader.1 param1, ecq paramecq, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final d tGD;
    
    static
    {
      AppMethodBeat.i(243291);
      tGD = new d();
      AppMethodBeat.o(243291);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<ag, x>
  {
    e(ch paramch, com.tencent.mm.view.recyclerview.h paramh, int paramInt1, int paramInt2, boolean paramBoolean, List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(ch paramch) {}
    
    public final void run()
    {
      AppMethodBeat.i(243295);
      FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = ch.c(this.tGu).tCD.weS;
      if (localFinderVideoAutoPlayManager != null)
      {
        localFinderVideoAutoPlayManager.awI("Finder.FinderStreamCardAlbumConvert");
        AppMethodBeat.o(243295);
        return;
      }
      AppMethodBeat.o(243295);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$8$1", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class g
    implements b.c
  {
    g(ch paramch, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void f(int paramInt, View paramView)
    {
      AppMethodBeat.i(243296);
      p.h(paramView, "view");
      Object localObject = (ag)paramh.hgv();
      if (localObject != null)
      {
        Log.i("Finder.FinderStreamCardAlbumConvert", "[onClick] position=" + paramInt + ' ' + ((ag)localObject).tQQ.id);
        localObject = this.tGu;
        paramView = paramView.getContext();
        p.g(paramView, "view.context");
        ch.a((ch)localObject, paramView, 1, paramh);
        AppMethodBeat.o(243296);
        return;
      }
      AppMethodBeat.o(243296);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(LinearLayout paramLinearLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(243297);
      Object localObject1 = new Rect();
      this.tGG.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width(), -((Rect)localObject1).height() / 2);
      Object localObject2 = this.tGG;
      p.g(localObject2, "refreshLayout");
      localObject2 = ((LinearLayout)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(243297);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.tGG));
      AppMethodBeat.o(243297);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(ch paramch, com.tencent.mm.view.recyclerview.h paramh, int paramInt) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(243299);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (ch.a(this.tGu))
      {
        Log.w("Finder.FinderStreamCardAlbumConvert", "isRefreshing");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243299);
        return;
      }
      ch.a(this.tGu, true);
      ag localag = (ag)paramh.hgv();
      long l1 = System.currentTimeMillis();
      long l2 = ch.b(this.tGu).startTimeMs;
      int i = ch.c(this.tGu).tRo.getDataListJustForAdapter().indexOf(localag);
      localObject = com.tencent.mm.plugin.finder.report.t.vhJ;
      String str = localag.tQQ.IFO;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      p.g(localag, "item");
      com.tencent.mm.plugin.finder.report.t.a((String)localObject, localag, i, l1 - l2, ch.d(this.tGu));
      localObject = com.tencent.mm.plugin.finder.report.t.vhJ;
      str = localag.tQQ.IFO;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.t.a((String)localObject, localag.tQQ.id, 3, 0L, ch.d(this.tGu), i);
      p.g(paramView, "view");
      localObject = (WeImageView)paramView.findViewById(2131306770);
      p.g(localObject, "view.refreshIcon");
      ((WeImageView)localObject).setVisibility(8);
      localObject = (ProgressBar)paramView.findViewById(2131306773);
      p.g(localObject, "view.refreshLoding");
      ((ProgressBar)localObject).setVisibility(0);
      localObject = ch.a(this.tGu, localag);
      ch.a(this.tGu, localag, (ecq)localObject, (kotlin.g.a.b)new q(paramView) {});
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243299);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(ch paramch, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243302);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (!((Collection)((ag)paramh.hgv()).rvFeedList).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramView = this.tGu;
          localObject = paramh.getContext();
          p.g(localObject, "holder.context");
          ch.a(paramView, (Context)localObject, 4, paramh);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243302);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(ch paramch, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243303);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (!((Collection)((ag)paramh.hgv()).rvFeedList).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramView = this.tGu;
          localObject = paramh.getContext();
          p.g(localObject, "holder.context");
          ch.a(paramView, (Context)localObject, 2, paramh);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243303);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$7", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "plugin-finder_release"})
  public static final class n
    extends com.tencent.mm.plugin.finder.view.adapter.b
  {
    n(com.tencent.mm.view.recyclerview.h paramh, List paramList, boolean paramBoolean)
    {
      super(true);
    }
    
    public final ag cZO()
    {
      AppMethodBeat.i(243304);
      ag localag = (ag)paramh.hgv();
      AppMethodBeat.o(243304);
      return localag;
    }
    
    public final k cZP()
    {
      AppMethodBeat.i(243305);
      k localk = ch.c(this.tGu).tCD;
      AppMethodBeat.o(243305);
      return localk;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class o
    implements View.OnLongClickListener
  {
    o(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(243306);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = (ag)this.qhp.hgv();
      paramView = new StringBuilder("FinderStreamCardFeed=").append(com.tencent.mm.plugin.finder.cgi.interceptor.e.a(((ag)localObject).tQQ)).append(' ');
      al localal = al.tuv;
      localObject = ((ag)localObject).tQQ.object;
      p.g(localObject, "item.card.`object`");
      localObject = ((LinkedList)localObject).getFirst();
      p.g(localObject, "item.card.`object`.first");
      Log.i("Finder.FinderStreamCardAlbumConvert", al.a((FinderObject)localObject));
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(243306);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
  {
    p(ch paramch, ecq paramecq, ag paramag)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final q tGK;
    
    static
    {
      AppMethodBeat.i(243312);
      tGK = new q();
      AppMethodBeat.o(243312);
    }
    
    q()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isExposed", "", "()Z", "setExposed", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class r
    extends RecyclerView.l
  {
    boolean tGL;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243314);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new a(this));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(243314);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243315);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(243315);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ch.r paramr) {}
      
      public final void run()
      {
        AppMethodBeat.i(243313);
        Object localObject = ch.j(this.tGM.tGu);
        if (localObject != null)
        {
          boolean bool = ch.a(this.tGM.tGu, (View)localObject);
          if ((!this.tGM.tGL) && (bool))
          {
            this.tGM.tGL = true;
            ch.b(this.tGM.tGu).startTimeMs = System.currentTimeMillis();
            AppMethodBeat.o(243313);
            return;
          }
          if ((this.tGM.tGL) && (!bool))
          {
            this.tGM.tGL = false;
            ag localag = ch.b(this.tGM.tGu).tGs;
            if (localag != null)
            {
              long l1 = System.currentTimeMillis();
              long l2 = ch.b(this.tGM.tGu).startTimeMs;
              int i = ch.c(this.tGM.tGu).tRo.getDataListJustForAdapter().indexOf(localag);
              localObject = com.tencent.mm.plugin.finder.report.t.vhJ;
              String str = localag.tQQ.IFO;
              localObject = str;
              if (str == null) {
                localObject = "";
              }
              com.tencent.mm.plugin.finder.report.t.a((String)localObject, localag, i, l1 - l2, ch.d(this.tGM.tGu));
              AppMethodBeat.o(243313);
              return;
            }
          }
          AppMethodBeat.o(243313);
          return;
        }
        AppMethodBeat.o(243313);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ch
 * JD-Core Version:    0.7.0.1
 */