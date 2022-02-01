package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.bg;
import com.tencent.mm.plugin.finder.convert.bz;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.feed.aa.a;
import com.tencent.mm.plugin.finder.feed.aa.b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.y;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "tabType", "isEnableFullScreen", "shareScene", "(ILcom/tencent/mm/ui/MMActivity;ZIZI)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "feedProgressListener", "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1;", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "consumeBackPressed", "isEnableFullScreenEnjoyByScene", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onFollow", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isFollow", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "smoothScrollToNextPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class i
  extends j.a
{
  kotlin.g.a.b<? super View, x> Axj;
  private final b Axk;
  String TAG;
  private final int shareScene;
  private com.tencent.mm.plugin.finder.view.c xAv;
  final boolean xyG;
  
  public i(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    super(paramInt1, paramMMActivity, paramBoolean1, paramInt2, (byte)0);
    AppMethodBeat.i(273035);
    this.xyG = paramBoolean2;
    this.shareScene = paramInt3;
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.Axk = new b(this);
    AppMethodBeat.o(273035);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(273030);
    p.k(paramBaseFinderFeedLoader, "model");
    p.k(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    paramBaseFinderFeedLoader = this.xnX;
    if (paramBaseFinderFeedLoader != null)
    {
      this.xAv = new com.tencent.mm.plugin.finder.view.c(paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = this.xAv;
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.alive();
      }
    }
    paramb.xvJ.getRecyclerView().post((Runnable)new c(this));
    this.Axk.alive();
    AppMethodBeat.o(273030);
  }
  
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    final int i = 0;
    AppMethodBeat.i(273033);
    p.k(paramc, "reason");
    com.tencent.mm.plugin.finder.report.j.a(com.tencent.mm.plugin.finder.report.j.zVy, this.fEH, false, null, 12);
    Object localObject1;
    if ((paramc.YNH) && (paramc.YNF))
    {
      localObject1 = this.xvC;
      if (localObject1 != null)
      {
        localObject1 = ((b.b)localObject1).xvJ.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          int j = this.fEH;
          localObject2 = this.xvC;
          if (localObject2 != null) {
            i = ((b.b)localObject2).xkX;
          }
          if (com.tencent.mm.plugin.finder.utils.aj.hd(j, i))
          {
            localObject2 = ((RecyclerView)localObject1).getLayoutManager();
            if (localObject2 == null)
            {
              paramc = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
              AppMethodBeat.o(273033);
              throw paramc;
            }
            i = ((FinderLinearLayoutManager)localObject2).kJ() + 1;
            Log.i(this.TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(i)));
            ((RecyclerView)localObject1).post((Runnable)new d((RecyclerView)localObject1, i));
          }
        }
      }
    }
    if (paramc.YNF)
    {
      paramc = g.Xox;
      localObject1 = (y)g.b((AppCompatActivity)this.iXq).i(y.class);
      paramc = this.xvC;
      if (paramc == null) {
        break label281;
      }
      paramc = paramc.xvJ.getRecyclerView();
      ((y)localObject1).setRecyclerView(paramc);
      paramc = this.xnX;
      if (paramc == null) {
        break label286;
      }
      paramc = paramc.getDataListJustForAdapter();
      if (paramc == null) {
        break label286;
      }
    }
    label281:
    label286:
    for (paramc = (bu)kotlin.a.j.M((List)paramc, 1);; paramc = null)
    {
      ((y)localObject1).h(paramc);
      ((y)localObject1).ekI();
      AppMethodBeat.o(273033);
      return;
      paramc = null;
      break;
    }
  }
  
  public final boolean dsq()
  {
    return this.xyG;
  }
  
  public final void dst()
  {
    AppMethodBeat.i(273032);
    com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.zVy;
    int i = this.fEH;
    g localg = g.Xox;
    com.tencent.mm.plugin.finder.report.j.a(localj, i, false, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), 8);
    AppMethodBeat.o(273032);
  }
  
  public final com.tencent.mm.view.recyclerview.f dsu()
  {
    AppMethodBeat.i(273029);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(273029);
    return localf;
  }
  
  public final boolean ebm()
  {
    AppMethodBeat.i(273034);
    Object localObject = this.xvC;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dsC();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.f)localObject).eis()))
      {
        ((com.tencent.mm.plugin.finder.view.f)localObject).eir();
        AppMethodBeat.o(273034);
        return true;
      }
    }
    localObject = this.xvC;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).xvN;
      if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).YdO))
      {
        ((TouchMediaPreviewLayout)localObject).iaa();
        AppMethodBeat.o(273034);
        return true;
      }
    }
    localObject = this.xvC;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dsD();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).eis()))
      {
        ((FinderLikeDrawer)localObject).eir();
        AppMethodBeat.o(273034);
        return true;
      }
    }
    localObject = this.xvC;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dsz();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).eis()))
      {
        ((FinderLikeDrawer)localObject).eir();
        AppMethodBeat.o(273034);
        return true;
      }
    }
    AppMethodBeat.o(273034);
    return false;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void l(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(273028);
    p.k(paramBaseFinderFeed, "feed");
    boolean bool = this.iXq.getIntent().getBooleanExtra("is_from_ad", false);
    Object localObject1 = g.Xox;
    bid localbid = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    localObject1 = ai.zAJ;
    localObject1 = paramBaseFinderFeed.contact;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.api.i)localObject1).getUsername();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = an.xci;
    int j = an.dnL();
    long l = paramBaseFinderFeed.mf();
    if (bool) {}
    for (int i = 22;; i = 0)
    {
      ai.a(localbid, (String)localObject1, j, l, false, true, i);
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed != null)
      {
        localObject1 = paramBaseFinderFeed.getUsername();
        paramBaseFinderFeed = (BaseFinderFeed)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramBaseFinderFeed = "";
      }
      localObject1 = com.tencent.mm.plugin.finder.api.i.xai;
      d.a.dP(paramBaseFinderFeed, com.tencent.mm.plugin.finder.api.i.dny());
      AppMethodBeat.o(273028);
      return;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(273031);
    super.onDetach();
    com.tencent.mm.plugin.finder.view.c localc = this.xAv;
    if (localc != null) {
      localc.dead();
    }
    this.Axk.dead();
    AppMethodBeat.o(273031);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(291699);
      if (this.Axl.xyG)
      {
        localObject = i.a(this.Axl).yx(paramInt);
        if ((localObject instanceof com.tencent.mm.plugin.finder.convert.u))
        {
          localObject = (e)new a(this, this.Axl.xkW, (com.tencent.mm.plugin.finder.feed.i)this.Axl, this.Axl.safeMode, this.Axl.fEH);
          AppMethodBeat.o(291699);
          return localObject;
        }
        if ((localObject instanceof r))
        {
          localObject = (e)new b(this, (com.tencent.mm.plugin.finder.feed.i)this.Axl, this.Axl.safeMode, this.Axl.fEH);
          AppMethodBeat.o(291699);
          return localObject;
        }
        AppMethodBeat.o(291699);
        return localObject;
      }
      switch (paramInt)
      {
      default: 
        localObject = i.a(this.Axl).yx(paramInt);
        AppMethodBeat.o(291699);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (e)new c(this, this.Axl.xkW, (com.tencent.mm.plugin.finder.feed.i)this.Axl, this.Axl.safeMode, this.Axl.fEH);
        AppMethodBeat.o(291699);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new d(this, (com.tencent.mm.plugin.finder.feed.i)this.Axl, this.Axl.safeMode, this.Axl.fEH);
        AppMethodBeat.o(291699);
        return localObject;
      case 2001: 
        localObject = (e)new e(this);
        AppMethodBeat.o(291699);
        return localObject;
      }
      Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = aj.a.fZ((Context)this.Axl.iXq);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
      {
        localObject = (e)new bz((bid)localObject, this.Axl.fEH);
        AppMethodBeat.o(291699);
        return localObject;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends com.tencent.mm.plugin.finder.convert.u
    {
      a(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
      {
        super(paramBoolean, paramInt, i);
      }
      
      private void a(com.tencent.mm.view.recyclerview.i parami, af paramaf, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(275492);
        p.k(parami, "holder");
        p.k(paramaf, "item");
        super.a(parami, (BaseFinderFeed)paramaf, paramInt1, paramInt2, paramBoolean, paramList);
        paramaf = com.tencent.mm.plugin.finder.feed.logic.d.xFu;
        if (com.tencent.mm.plugin.finder.feed.logic.d.MD(i.b(this.Axm.Axl)))
        {
          paramaf = com.tencent.mm.plugin.finder.feed.logic.d.xFu;
          com.tencent.mm.plugin.finder.feed.logic.d.q(parami);
        }
        AppMethodBeat.o(275492);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends r
    {
      b(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
      {
        super(paramInt, i);
      }
      
      private void a(com.tencent.mm.view.recyclerview.i parami, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(273242);
        p.k(parami, "holder");
        p.k(paramu, "item");
        super.a(parami, (BaseFinderFeed)paramu, paramInt1, paramInt2, paramBoolean, paramList);
        paramu = com.tencent.mm.plugin.finder.feed.logic.d.xFu;
        if (com.tencent.mm.plugin.finder.feed.logic.d.MD(i.b(this.Axm.Axl)))
        {
          paramu = com.tencent.mm.plugin.finder.feed.logic.d.xFu;
          com.tencent.mm.plugin.finder.feed.logic.d.q(parami);
        }
        AppMethodBeat.o(273242);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends am
    {
      c(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
      {
        super(paramBoolean, paramInt, i);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.i parami, af paramaf, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(288226);
        p.k(parami, "holder");
        p.k(paramaf, "item");
        super.a(parami, paramaf, paramInt1, paramInt2, paramBoolean, paramList);
        if (paramaf.feedObject.isPostFinish()) {
          i.b(parami, dps());
        }
        parami = parami.RD(b.f.folded_layout_view);
        if (parami != null)
        {
          parami.setVisibility(8);
          AppMethodBeat.o(288226);
          return;
        }
        AppMethodBeat.o(288226);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends v
    {
      d(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
      {
        super(paramInt, i);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.i parami, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(245315);
        p.k(parami, "holder");
        p.k(paramu, "item");
        super.a(parami, paramu, paramInt1, paramInt2, paramBoolean, paramList);
        if (paramu.feedObject.isPostFinish()) {
          i.b(parami, dps());
        }
        parami = parami.RD(b.f.folded_layout_view);
        if (parami != null)
        {
          parami.setVisibility(8);
          AppMethodBeat.o(245315);
          return;
        }
        AppMethodBeat.o(245315);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends bg
    {
      public final void a(com.tencent.mm.view.recyclerview.i parami, com.tencent.mm.plugin.finder.model.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(222740);
        p.k(parami, "holder");
        p.k(paramb, "item");
        super.a(parami, paramb, paramInt1, paramInt2, paramBoolean, paramList);
        paramb = this.Axm.Axl.Axj;
        if (paramb != null)
        {
          parami = parami.amk;
          p.j(parami, "holder.itemView");
          paramb.invoke(parami);
          AppMethodBeat.o(222740);
          return;
        }
        AppMethodBeat.o(222740);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hr>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(291396);
      com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.Pp(this.Axl.fEH);
      AppMethodBeat.o(291396);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(RecyclerView paramRecyclerView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(271035);
      RecyclerView localRecyclerView = this.xmk;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(271035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.i
 * JD-Core Version:    0.7.0.1
 */