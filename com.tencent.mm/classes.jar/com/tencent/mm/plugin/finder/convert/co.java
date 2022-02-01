package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.adapter.b.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.epq;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;I)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "exposeItem", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "isEnablePreloadRefreshContent", "", "()Z", "isEnablePreloadRefreshContent$delegate", "Lkotlin/Lazy;", "isPreloadContenting", "isRefreshing", "itemView", "Landroid/view/View;", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1;", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lkotlin/collections/ArrayList;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshContentPreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1;", "singleTaskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "viewRect", "fetchContent", "", "isRefresh", "item", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "call", "Lkotlin/Function1;", "genStat", "getLayoutId", "isViewExposed", "view", "jumpRelatedTimelineUI", "context", "Landroid/content/Context;", "action", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "preloadContent", "reportStat", "Companion", "ExposeItem", "plugin-finder_release"})
public final class co
  extends com.tencent.mm.view.recyclerview.e<an>
{
  public static final a xpe;
  private View amk;
  private final int fEH;
  private boolean isRefreshing;
  private RecyclerView jLl;
  private final Rect viewRect;
  private bid xbu;
  private final f xoT;
  private final f xoU;
  private final com.tencent.mm.loader.g.i xoV;
  private final com.tencent.mm.plugin.finder.feed.model.internal.p<bu> xoW;
  private final ArrayList<csg> xoX;
  private final Rect xoY;
  private final r xoZ;
  private final FinderStreamCardAlbumConvert.lifecycleObserver.1 xpa;
  private b xpb;
  private boolean xpc;
  private final az xpd;
  
  static
  {
    AppMethodBeat.i(286561);
    xpe = new a((byte)0);
    AppMethodBeat.o(286561);
  }
  
  public co(az paramaz, int paramInt)
  {
    AppMethodBeat.i(286560);
    this.xpd = paramaz;
    this.fEH = paramInt;
    this.xoT = kotlin.g.ar((kotlin.g.a.a)q.xpw);
    this.xoU = kotlin.g.ar((kotlin.g.a.a)d.xpp);
    paramaz = new com.tencent.mm.loader.g.i("StreamCardFeedLoader");
    paramaz.start();
    this.xoV = paramaz;
    this.xoW = new com.tencent.mm.plugin.finder.feed.model.internal.p((byte)0);
    paramaz = new ArrayList(4);
    paramInt = 0;
    while (paramInt < 4)
    {
      paramaz.add(new csg());
      paramInt += 1;
    }
    this.xoX = paramaz;
    this.viewRect = new Rect();
    this.xoY = new Rect();
    this.xoZ = new r(this);
    this.xpa = new FinderStreamCardAlbumConvert.lifecycleObserver.1(this);
    this.xpb = new b();
    AppMethodBeat.o(286560);
  }
  
  private final emr a(an paraman)
  {
    AppMethodBeat.i(286552);
    emr localemr = new emr();
    localemr.Upk = new ezq();
    localemr.Upj = new mf();
    localemr.Upl = new dhb();
    localemr.xbk = paraman.xBH.id;
    localemr.sessionBuffer = paraman.xBH.sessionBuffer;
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localemr.xkX = com.tencent.mm.plugin.finder.utils.aj.QP(this.fEH);
    localemr.finderUsername = z.bdh();
    localemr.Upp = paraman.xBG;
    localemr.Upm = cm.bfE();
    localemr.mediaType = 11;
    AppMethodBeat.o(286552);
    return localemr;
  }
  
  private final void a(final an paraman, final emr paramemr)
  {
    long l2 = 0L;
    AppMethodBeat.i(286556);
    if (!dpK())
    {
      AppMethodBeat.o(286556);
      return;
    }
    Object localObject1 = (CharSequence)paraman.xBH.Stk;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(286556);
      return;
    }
    if (this.xoW.duF())
    {
      Log.w("Finder.FinderStreamCardAlbumConvert", "has cache never use. just return.");
      AppMethodBeat.o(286556);
      return;
    }
    if (this.xpc)
    {
      Log.w("Finder.FinderStreamCardAlbumConvert", "isPreloadContenting. just return.");
      AppMethodBeat.o(286556);
      return;
    }
    this.xpc = true;
    localObject1 = new StringBuilder("[preloadContent] now title=").append(paraman.xBH.PAf).append(" stats=");
    if (paramemr != null) {}
    for (long l1 = paramemr.xbk;; l1 = 0L)
    {
      localObject1 = ((StringBuilder)localObject1).append(d.Fw(l1)).append(' ').append("card request id=");
      Object localObject2 = paraman.xBH.STS;
      l1 = l2;
      if (localObject2 != null)
      {
        localObject2 = ((bjq)localObject2).STV;
        l1 = l2;
        if (localObject2 != null)
        {
          localObject2 = ((avr)localObject2).SId;
          l1 = l2;
          if (localObject2 != null) {
            l1 = ((epq)localObject2).id;
          }
        }
      }
      Log.i("Finder.FinderStreamCardAlbumConvert", d.Fw(l1) + ' ' + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(paraman.xBH));
      this.xoV.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new p(this, paramemr, paraman)));
      AppMethodBeat.o(286556);
      return;
    }
  }
  
  private final void a(final boolean paramBoolean, final an paraman, final emr paramemr, final kotlin.g.a.b<? super an, kotlin.x> paramb)
  {
    AppMethodBeat.i(286558);
    Object localObject1 = new StringBuilder("[fetchContent] isRefresh=").append(paramBoolean).append(" hasCache=").append(this.xoW.duF()).append(' ').append("card request id=");
    Object localObject2 = paraman.xBH.STS;
    if (localObject2 != null)
    {
      localObject2 = ((bjq)localObject2).STV;
      if (localObject2 != null)
      {
        localObject2 = ((avr)localObject2).SId;
        if (localObject2 == null) {}
      }
    }
    for (long l = ((epq)localObject2).id;; l = 0L)
    {
      Log.i("Finder.FinderStreamCardAlbumConvert", d.Fw(l) + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(paraman.xBH));
      localObject1 = this.xbu;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("contextObj");
      }
      localObject1 = new FinderStreamCardAlbumConvert.fetchContent.loader.1(this, paramemr, (bid)localObject1);
      ((FinderStreamCardAlbumConvert.fetchContent.loader.1)localObject1).register((com.tencent.mm.view.j)new c());
      this.xoV.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new c(this, paramBoolean, paraman, (FinderStreamCardAlbumConvert.fetchContent.loader.1)localObject1, paramemr, paramb)));
      AppMethodBeat.o(286558);
      return;
    }
  }
  
  private final boolean dpK()
  {
    AppMethodBeat.i(286550);
    boolean bool = ((Boolean)this.xoU.getValue()).booleanValue();
    AppMethodBeat.o(286550);
    return bool;
  }
  
  public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.i parami, final int paramInt)
  {
    AppMethodBeat.i(286551);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(parami, "holder");
    this.jLl = paramRecyclerView;
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = paramRecyclerView.getContext();
    if (localObject == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(286551);
      throw paramRecyclerView;
    }
    this.xbu = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)localObject).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).RT(this.fEH);
    paramRecyclerView.b((RecyclerView.l)this.xoZ);
    paramRecyclerView.a((RecyclerView.l)this.xoZ);
    localObject = paramRecyclerView.getContext();
    if (localObject == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(286551);
      throw paramRecyclerView;
    }
    ((MMActivity)localObject).getLifecycle().b((k)this.xpa);
    paramRecyclerView = paramRecyclerView.getContext();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(286551);
      throw paramRecyclerView;
    }
    ((MMActivity)paramRecyclerView).getLifecycle().a((k)this.xpa);
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (LinearLayout)paramRecyclerView.findViewById(b.f.refreshLayout);
    paramRecyclerView.post((Runnable)new h(paramRecyclerView));
    paramRecyclerView.setOnClickListener((View.OnClickListener)new i(this, parami, paramInt));
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    ((LinearLayout)paramRecyclerView.findViewById(b.f.see_more_layout)).setOnClickListener((View.OnClickListener)new j(parami));
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    ((TextView)paramRecyclerView.findViewById(b.f.cardHeader)).setOnClickListener((View.OnClickListener)new k(parami));
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.cardHeader);
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView.cardHeader");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.refreshContent);
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView.refreshContent");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    ((TextView)paramRecyclerView.findViewById(b.f.seeMoreTv)).setOnClickListener((View.OnClickListener)new l(this, parami));
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    ((LinearLayout)paramRecyclerView.findViewById(b.f.cardLayout)).setOnClickListener((View.OnClickListener)new m(this, parami));
    paramRecyclerView = parami.amk;
    kotlin.g.b.p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (FinderFeedAlbumView)paramRecyclerView.findViewById(b.f.feedAlbumView);
    localObject = new n(this, parami, (List)this.xoX);
    ((com.tencent.mm.plugin.finder.view.adapter.b)localObject).Bdm = ((b.c)new g(this, parami));
    paramRecyclerView.setAdapter((FinderFeedAlbumView.a)localObject);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
      parami.amk.setOnLongClickListener((View.OnLongClickListener)new o(parami));
    }
    AppMethodBeat.o(286551);
  }
  
  public final void a(final com.tencent.mm.view.recyclerview.i parami, an paraman, final int paramInt1, final int paramInt2, final boolean paramBoolean, final List<Object> paramList)
  {
    AppMethodBeat.i(286553);
    kotlin.g.b.p.k(parami, "holder");
    kotlin.g.b.p.k(paraman, "item");
    Log.i("Finder.FinderStreamCardAlbumConvert", "[onBindViewHolder] isHotPatch=" + paramBoolean + " pos=" + paramInt1 + " item=" + com.tencent.mm.plugin.finder.cgi.interceptor.e.a(paraman.xBH) + " rvFeedList isEmpty=" + paraman.rvFeedList.isEmpty());
    this.amk = parami.amk;
    this.xpb.feedId = paraman.xBH.id;
    this.xpb.position = paramInt1;
    this.xpb.xpf = paraman;
    paraman.position = paramInt1;
    Object localObject1;
    if ((!paramBoolean) && (paraman.rvFeedList.isEmpty()))
    {
      localObject1 = paraman.xBH.STR;
      if ((localObject1 != null) && (((bjq)localObject1).type == 1)) {
        a(false, paraman, null, (kotlin.g.a.b)new e(this, parami, paramInt1, paramInt2, paramBoolean, paramList));
      }
    }
    for (;;)
    {
      paramList = parami.amk;
      kotlin.g.b.p.j(paramList, "holder.itemView");
      ((NeatTextView)paramList.findViewById(b.f.title)).aL((CharSequence)paraman.xBH.PAf);
      paramList = parami.amk;
      kotlin.g.b.p.j(paramList, "holder.itemView");
      paramList = (TextView)paramList.findViewById(b.f.subTitle);
      kotlin.g.b.p.j(paramList, "holder.itemView.subTitle");
      paramList.setText((CharSequence)paraman.xBH.STM);
      paraman = paraman.xBH.Stk;
      if (paraman == null) {
        break;
      }
      paramList = parami.amk;
      kotlin.g.b.p.j(paramList, "holder.itemView");
      paramList = (LinearLayout)paramList.findViewById(b.f.refreshLayout);
      kotlin.g.b.p.j(paramList, "holder.itemView.refreshLayout");
      paramList.setVisibility(0);
      parami = parami.amk;
      kotlin.g.b.p.j(parami, "holder.itemView");
      parami = (TextView)parami.findViewById(b.f.refreshContent);
      kotlin.g.b.p.j(parami, "holder.itemView.refreshContent");
      parami.setText((CharSequence)paraman);
      AppMethodBeat.o(286553);
      return;
      if (!((Collection)paraman.rvFeedList).isEmpty()) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        this.xoX.clear();
        paramList = this.xoX;
        Object localObject2 = (Iterable)paraman.rvFeedList;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add((csg)((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getMediaList().getFirst());
        }
      }
      continue;
      paramList.addAll((Collection)((List)localObject1).subList(0, Math.min(4, paraman.rvFeedList.size())));
      paramList = parami.amk;
      kotlin.g.b.p.j(paramList, "holder.itemView");
      ((FinderFeedAlbumView)paramList.findViewById(b.f.feedAlbumView)).cBf();
      paramList = parami.amk;
      kotlin.g.b.p.j(paramList, "holder.itemView");
      ((FinderFeedAlbumView)paramList.findViewById(b.f.feedAlbumView)).post((Runnable)new f(this));
      a(paraman, a(paraman));
    }
    parami = parami.amk;
    kotlin.g.b.p.j(parami, "holder.itemView");
    parami = (LinearLayout)parami.findViewById(b.f.refreshLayout);
    kotlin.g.b.p.j(parami, "holder.itemView.refreshLayout");
    parami.setVisibility(8);
    AppMethodBeat.o(286553);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(286555);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    boolean bool = this.xoW.clearCache();
    Log.i("Finder.FinderStreamCardAlbumConvert", "[onDetachedFromRecyclerView] ret=" + bool + " report unReadItem");
    paramRecyclerView = this.xoW.xKZ;
    if (paramRecyclerView != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      int i = this.fEH;
      localObject = paramRecyclerView.getIncrementList();
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = (List)new LinkedList();
      }
      localObject = this.xbu;
      if (localObject == null) {
        kotlin.g.b.p.bGy("contextObj");
      }
      com.tencent.mm.plugin.finder.utils.aj.a(i, paramRecyclerView, (bid)localObject);
      AppMethodBeat.o(286555);
      return;
    }
    AppMethodBeat.o(286555);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_card_layout;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "feedId", "", "sumTimeMs", "startTimeMs", "position", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;JJJI)V", "getFeedId", "()J", "setFeedId", "(J)V", "getItem", "()Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "setItem", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;)V", "getPosition", "()I", "setPosition", "(I)V", "getStartTimeMs", "setStartTimeMs", "getSumTimeMs", "setSumTimeMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    long feedId = 0L;
    int position = -1;
    long startTimeMs = 0L;
    an xpf = null;
    private long xpg = 0L;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(265424);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!kotlin.g.b.p.h(this.xpf, paramObject.xpf)) || (this.feedId != paramObject.feedId) || (this.xpg != paramObject.xpg) || (this.startTimeMs != paramObject.startTimeMs) || (this.position != paramObject.position)) {}
        }
      }
      else
      {
        AppMethodBeat.o(265424);
        return true;
      }
      AppMethodBeat.o(265424);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(265422);
      an localan = this.xpf;
      if (localan != null) {}
      for (int i = localan.hashCode();; i = 0)
      {
        long l = this.feedId;
        int j = (int)(l ^ l >>> 32);
        l = this.xpg;
        int k = (int)(l ^ l >>> 32);
        l = this.startTimeMs;
        int m = (int)(l ^ l >>> 32);
        int n = this.position;
        AppMethodBeat.o(265422);
        return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(265421);
      String str = "ExposeItem(item=" + this.xpf + ", feedId=" + this.feedId + ", sumTimeMs=" + this.xpg + ", startTimeMs=" + this.startTimeMs + ", position=" + this.position + ")";
      AppMethodBeat.o(265421);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, kotlin.x>
  {
    c(co paramco, boolean paramBoolean, an paraman, FinderStreamCardAlbumConvert.fetchContent.loader.1 param1, emr paramemr, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final d xpp;
    
    static
    {
      AppMethodBeat.i(283905);
      xpp = new d();
      AppMethodBeat.o(283905);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<an, kotlin.x>
  {
    e(co paramco, com.tencent.mm.view.recyclerview.i parami, int paramInt1, int paramInt2, boolean paramBoolean, List paramList)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(co paramco) {}
    
    public final void run()
    {
      AppMethodBeat.i(287823);
      FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = co.c(this.xph).xkW.ANA;
      if (localFinderVideoAutoPlayManager != null)
      {
        localFinderVideoAutoPlayManager.aGl("Finder.FinderStreamCardAlbumConvert");
        AppMethodBeat.o(287823);
        return;
      }
      AppMethodBeat.o(287823);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$8$1", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class g
    implements b.c
  {
    g(co paramco, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void f(int paramInt, View paramView)
    {
      AppMethodBeat.i(254817);
      kotlin.g.b.p.k(paramView, "view");
      Object localObject = (an)parami.ihX();
      if (localObject != null)
      {
        Log.i("Finder.FinderStreamCardAlbumConvert", "[onClick] position=" + paramInt + ' ' + ((an)localObject).xBH.id);
        localObject = this.xph;
        paramView = paramView.getContext();
        kotlin.g.b.p.j(paramView, "view.context");
        co.a((co)localObject, paramView, 1, parami);
        AppMethodBeat.o(254817);
        return;
      }
      AppMethodBeat.o(254817);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(LinearLayout paramLinearLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(274414);
      Object localObject1 = new Rect();
      this.xps.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width(), -((Rect)localObject1).height() / 2);
      Object localObject2 = this.xps;
      kotlin.g.b.p.j(localObject2, "refreshLayout");
      localObject2 = ((LinearLayout)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(274414);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.xps));
      AppMethodBeat.o(274414);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(co paramco, com.tencent.mm.view.recyclerview.i parami, int paramInt) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(288747);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (co.a(this.xph))
      {
        Log.w("Finder.FinderStreamCardAlbumConvert", "isRefreshing");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(288747);
        return;
      }
      co.a(this.xph, true);
      an localan = (an)parami.ihX();
      long l1 = System.currentTimeMillis();
      long l2 = co.b(this.xph).startTimeMs;
      int i = co.c(this.xph).xCg.getDataListJustForAdapter().indexOf(localan);
      localObject = com.tencent.mm.plugin.finder.report.x.zYS;
      String str = localan.xBH.PAf;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      kotlin.g.b.p.j(localan, "item");
      com.tencent.mm.plugin.finder.report.x.a((String)localObject, localan, i, l1 - l2, co.d(this.xph));
      localObject = com.tencent.mm.plugin.finder.report.x.zYS;
      str = localan.xBH.PAf;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.x.a((String)localObject, localan.xBH.id, 3, 0L, co.d(this.xph), i);
      kotlin.g.b.p.j(paramView, "view");
      localObject = (WeImageView)paramView.findViewById(b.f.refreshIcon);
      kotlin.g.b.p.j(localObject, "view.refreshIcon");
      ((WeImageView)localObject).setVisibility(8);
      localObject = (ProgressBar)paramView.findViewById(b.f.refreshLoding);
      kotlin.g.b.p.j(localObject, "view.refreshLoding");
      ((ProgressBar)localObject).setVisibility(0);
      localObject = co.a(this.xph, localan);
      co.a(this.xph, localan, (emr)localObject, (kotlin.g.a.b)new q(paramView) {});
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288747);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.tDl.amk;
      kotlin.g.b.p.j(paramView, "holder.itemView");
      ((LinearLayout)paramView.findViewById(b.f.cardLayout)).callOnClick();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282671);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282538);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.tDl.amk;
      kotlin.g.b.p.j(paramView, "holder.itemView");
      ((LinearLayout)paramView.findViewById(b.f.cardLayout)).callOnClick();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282538);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(co paramco, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274239);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (!((Collection)((an)parami.ihX()).rvFeedList).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramView = this.xph;
          localObject = parami.getContext();
          kotlin.g.b.p.j(localObject, "holder.context");
          co.a(paramView, (Context)localObject, 4, parami);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(274239);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(co paramco, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286836);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (!((Collection)((an)parami.ihX()).rvFeedList).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramView = this.xph;
          localObject = parami.getContext();
          kotlin.g.b.p.j(localObject, "holder.context");
          co.a(paramView, (Context)localObject, 2, parami);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286836);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$7", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "plugin-finder_release"})
  public static final class n
    extends com.tencent.mm.plugin.finder.view.adapter.b
  {
    n(com.tencent.mm.view.recyclerview.i parami, List paramList)
    {
      super(true);
    }
    
    public final an dpL()
    {
      AppMethodBeat.i(289204);
      an localan = (an)parami.ihX();
      AppMethodBeat.o(289204);
      return localan;
    }
    
    public final com.tencent.mm.plugin.finder.video.l dpM()
    {
      AppMethodBeat.i(289206);
      com.tencent.mm.plugin.finder.video.l locall = co.c(this.xph).xkW;
      AppMethodBeat.o(289206);
      return locall;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class o
    implements View.OnLongClickListener
  {
    o(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(244341);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = (an)this.tDl.ihX();
      paramView = new StringBuilder("FinderStreamCardFeed=").append(com.tencent.mm.plugin.finder.cgi.interceptor.e.a(((an)localObject).xBH)).append(' ');
      am localam = am.xch;
      localObject = ((an)localObject).xBH.object;
      kotlin.g.b.p.j(localObject, "item.card.`object`");
      localObject = ((LinkedList)localObject).getFirst();
      kotlin.g.b.p.j(localObject, "item.card.`object`.first");
      Log.i("Finder.FinderStreamCardAlbumConvert", am.a((FinderObject)localObject));
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(244341);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.b<com.tencent.mm.loader.g.h, kotlin.x>
  {
    p(co paramco, emr paramemr, an paraman)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final q xpw;
    
    static
    {
      AppMethodBeat.i(282606);
      xpw = new q();
      AppMethodBeat.o(282606);
    }
    
    q()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isExposed", "", "()Z", "setExposed", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class r
    extends RecyclerView.l
  {
    boolean xpx;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(221038);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new a(this));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(221038);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(221045);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(221045);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(co.r paramr) {}
      
      public final void run()
      {
        AppMethodBeat.i(285889);
        Object localObject = co.j(this.xpy.xph);
        if (localObject != null)
        {
          boolean bool = co.a(this.xpy.xph, (View)localObject);
          if ((!this.xpy.xpx) && (bool))
          {
            this.xpy.xpx = true;
            co.b(this.xpy.xph).startTimeMs = System.currentTimeMillis();
            AppMethodBeat.o(285889);
            return;
          }
          if ((this.xpy.xpx) && (!bool))
          {
            this.xpy.xpx = false;
            an localan = co.b(this.xpy.xph).xpf;
            if (localan != null)
            {
              long l1 = System.currentTimeMillis();
              long l2 = co.b(this.xpy.xph).startTimeMs;
              int i = co.c(this.xpy.xph).xCg.getDataListJustForAdapter().indexOf(localan);
              localObject = com.tencent.mm.plugin.finder.report.x.zYS;
              String str = localan.xBH.PAf;
              localObject = str;
              if (str == null) {
                localObject = "";
              }
              com.tencent.mm.plugin.finder.report.x.a((String)localObject, localan, i, l1 - l2, co.d(this.xpy.xph));
              AppMethodBeat.o(285889);
              return;
            }
          }
          AppMethodBeat.o(285889);
          return;
        }
        AppMethodBeat.o(285889);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.co
 * JD-Core Version:    0.7.0.1
 */