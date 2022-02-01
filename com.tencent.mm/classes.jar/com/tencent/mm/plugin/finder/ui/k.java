package com.tencent.mm.plugin.finder.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.be;
import com.tencent.mm.plugin.finder.convert.bw;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.v.a;
import com.tencent.mm.plugin.finder.feed.v.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.f;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZI)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "feedProgressListener", "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1;", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "consumeBackPressed", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "smoothScrollToNextPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class k
  extends j.a
{
  String TAG;
  private com.tencent.mm.plugin.finder.view.b tPE;
  kotlin.g.a.b<? super View, x> vQl;
  private final b vQm;
  
  public k(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean, int paramInt2)
  {
    super(paramInt1, paramMMActivity, paramBoolean, paramInt2, (byte)0);
    AppMethodBeat.i(252839);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.vQm = new b(this);
    AppMethodBeat.o(252839);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
  {
    AppMethodBeat.i(252834);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    paramBaseFinderFeedLoader = this.tFM;
    if (paramBaseFinderFeedLoader != null)
    {
      this.tPE = new com.tencent.mm.plugin.finder.view.b(paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = this.tPE;
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.alive();
      }
    }
    paramb.tLS.getRecyclerView().post((Runnable)new c(this));
    this.vQm.alive();
    AppMethodBeat.o(252834);
  }
  
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    final int i = 0;
    AppMethodBeat.i(252837);
    p.h(paramc, "reason");
    com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, this.dLS, false, null, 12);
    Object localObject1;
    if ((paramc.Rml) && (paramc.Rmj))
    {
      localObject1 = this.tLN;
      if (localObject1 != null)
      {
        localObject1 = ((b.b)localObject1).tLS.getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = y.vXH;
          int j = this.dLS;
          localObject2 = this.tLN;
          if (localObject2 != null) {
            i = ((b.b)localObject2).tCE;
          }
          if (y.gr(j, i))
          {
            localObject2 = ((RecyclerView)localObject1).getLayoutManager();
            if (localObject2 == null)
            {
              paramc = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
              AppMethodBeat.o(252837);
              throw paramc;
            }
            i = ((FinderLinearLayoutManager)localObject2).ks() + 1;
            Log.i(this.TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(i)));
            ((RecyclerView)localObject1).post((Runnable)new d((RecyclerView)localObject1, i));
          }
        }
      }
    }
    if (paramc.Rmj)
    {
      paramc = com.tencent.mm.ui.component.a.PRN;
      localObject1 = (FinderFullFeedGuideUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderFullFeedGuideUIC.class);
      paramc = this.tLN;
      if (paramc == null) {
        break label281;
      }
      paramc = paramc.tLS.getRecyclerView();
      ((FinderFullFeedGuideUIC)localObject1).setRecyclerView(paramc);
      paramc = this.tFM;
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
    for (paramc = (bo)j.L((List)paramc, 1);; paramc = null)
    {
      ((FinderFullFeedGuideUIC)localObject1).e(paramc);
      ((FinderFullFeedGuideUIC)localObject1).dIc();
      AppMethodBeat.o(252837);
      return;
      paramc = null;
      break;
    }
  }
  
  public final boolean dAp()
  {
    AppMethodBeat.i(252838);
    Object localObject = this.tLN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dcm();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.e)localObject).dGs()))
      {
        ((com.tencent.mm.plugin.finder.view.e)localObject).dGr();
        AppMethodBeat.o(252838);
        return true;
      }
    }
    localObject = this.tLN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).tLW;
      if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).QFs))
      {
        ((TouchMediaPreviewLayout)localObject).gZk();
        AppMethodBeat.o(252838);
        return true;
      }
    }
    localObject = this.tLN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dcn();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).dGs()))
      {
        ((FinderLikeDrawer)localObject).dGr();
        AppMethodBeat.o(252838);
        return true;
      }
    }
    localObject = this.tLN;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).dcj();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).dGs()))
      {
        ((FinderLikeDrawer)localObject).dGr();
        AppMethodBeat.o(252838);
        return true;
      }
    }
    AppMethodBeat.o(252838);
    return false;
  }
  
  public final void dcd()
  {
    AppMethodBeat.i(252836);
    com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.veu;
    int i = this.dLS;
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.plugin.finder.report.h.a(localh, i, false, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx(), 8);
    AppMethodBeat.o(252836);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(252833);
    f localf = (f)new a(this);
    AppMethodBeat.o(252833);
    return localf;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(252835);
    super.onDetach();
    com.tencent.mm.plugin.finder.view.b localb = this.tPE;
    if (localb != null) {
      localb.dead();
    }
    this.vQm.dead();
    AppMethodBeat.o(252835);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(252829);
      if (this.vQn.dca())
      {
        localObject = k.a(this.vQn).EC(paramInt);
        AppMethodBeat.o(252829);
        return localObject;
      }
      switch (paramInt)
      {
      default: 
        localObject = k.a(this.vQn).EC(paramInt);
        AppMethodBeat.o(252829);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.e)new a(this, this.vQn.tCD, (i)this.vQn, this.vQn.tAj, this.vQn.dLS);
        AppMethodBeat.o(252829);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.e)new b(this, (i)this.vQn, this.vQn.tAj, this.vQn.dLS);
        AppMethodBeat.o(252829);
        return localObject;
      case 2001: 
        localObject = (com.tencent.mm.view.recyclerview.e)new c(this);
        AppMethodBeat.o(252829);
        return localObject;
      }
      Object localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this.vQn.gte);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new bw((bbn)localObject, this.vQn.dLS);
        AppMethodBeat.o(252829);
        return localObject;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends ak
    {
      a(com.tencent.mm.plugin.finder.video.k paramk, i parami, boolean paramBoolean, int paramInt)
      {
        super(paramBoolean, paramInt, i);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.h paramh, ad paramad, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(252821);
        p.h(paramh, "holder");
        p.h(paramad, "item");
        super.a(paramh, paramad, paramInt1, paramInt2, paramBoolean, paramList);
        if (paramad.feedObject.isPostFinish()) {
          k.d(paramh, this.tAj);
        }
        paramh = paramh.Mn(2131301631);
        if (paramh != null)
        {
          paramh.setVisibility(8);
          AppMethodBeat.o(252821);
          return;
        }
        AppMethodBeat.o(252821);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends com.tencent.mm.plugin.finder.convert.u
    {
      b(i parami, boolean paramBoolean, int paramInt)
      {
        super(paramInt, i);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.h paramh, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(252824);
        p.h(paramh, "holder");
        p.h(paramu, "item");
        super.a(paramh, paramu, paramInt1, paramInt2, paramBoolean, paramList);
        if (paramu.feedObject.isPostFinish()) {
          k.d(paramh, this.tAj);
        }
        paramh = paramh.Mn(2131301631);
        if (paramh != null)
        {
          paramh.setVisibility(8);
          AppMethodBeat.o(252824);
          return;
        }
        AppMethodBeat.o(252824);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends be
    {
      public final void a(com.tencent.mm.view.recyclerview.h paramh, com.tencent.mm.plugin.finder.model.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(252827);
        p.h(paramh, "holder");
        p.h(paramb, "item");
        super.a(paramh, paramb, paramInt1, paramInt2, paramBoolean, paramList);
        paramb = this.vQo.vQn.vQl;
        if (paramb != null)
        {
          paramh = paramh.aus;
          p.g(paramh, "holder.itemView");
          paramb.invoke(paramh);
          AppMethodBeat.o(252827);
          return;
        }
        AppMethodBeat.o(252827);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hk>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(252831);
      com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.Kl(this.vQn.dLS);
      AppMethodBeat.o(252831);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(RecyclerView paramRecyclerView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(252832);
      RecyclerView localRecyclerView = this.tDJ;
      com.tencent.mm.hellhoundlib.b.a locala = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(252832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.k
 * JD-Core Version:    0.7.0.1
 */