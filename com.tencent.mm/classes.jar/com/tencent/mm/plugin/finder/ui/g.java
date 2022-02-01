package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.a.a;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.u.a;
import com.tencent.mm.plugin.finder.feed.u.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.c;
import d.l;
import d.z;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZI)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "getTabType", "()I", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "consumeBackPressed", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "onRefreshEnd", "plugin-finder_release"})
public final class g
  extends i.a
{
  private String TAG;
  final int duh;
  private com.tencent.mm.plugin.finder.view.b rWF;
  d.g.a.b<? super View, z> sIu;
  
  public g(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean, int paramInt2)
  {
    super(paramInt1, paramMMActivity, paramBoolean, (byte)0);
    AppMethodBeat.i(204301);
    this.duh = paramInt2;
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(204301);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    AppMethodBeat.i(204296);
    d.g.b.p.h(paramBaseFinderFeedLoader, "model");
    d.g.b.p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    paramBaseFinderFeedLoader = this.rTS;
    if (paramBaseFinderFeedLoader != null)
    {
      this.rWF = new com.tencent.mm.plugin.finder.view.b(paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = this.rWF;
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.alive();
      }
    }
    paramb.rTF.getRecyclerView().post((Runnable)new b(this));
    AppMethodBeat.o(204296);
  }
  
  public final void cAC()
  {
    AppMethodBeat.i(204298);
    com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ae(this.duh, false);
    AppMethodBeat.o(204298);
  }
  
  public final void cAD()
  {
    AppMethodBeat.i(204299);
    com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ae(this.duh, false);
    AppMethodBeat.o(204299);
  }
  
  public final c cAE()
  {
    AppMethodBeat.i(204295);
    c localc = (c)new a(this);
    AppMethodBeat.o(204295);
    return localc;
  }
  
  public final boolean cKy()
  {
    AppMethodBeat.i(204300);
    Object localObject = this.rTz;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cAL();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.e)localObject).cMZ()))
      {
        ((com.tencent.mm.plugin.finder.view.e)localObject).cMY();
        AppMethodBeat.o(204300);
        return true;
      }
    }
    localObject = this.rTz;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).rTJ;
      if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).KUd))
      {
        ((TouchMediaPreviewLayout)localObject).fLM();
        AppMethodBeat.o(204300);
        return true;
      }
    }
    localObject = this.rTz;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cAM();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).cMZ()))
      {
        ((FinderLikeDrawer)localObject).cMY();
        AppMethodBeat.o(204300);
        return true;
      }
    }
    localObject = this.rTz;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cAJ();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).cMZ()))
      {
        ((FinderLikeDrawer)localObject).cMY();
        AppMethodBeat.o(204300);
        return true;
      }
    }
    AppMethodBeat.o(204300);
    return false;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(204297);
    super.onDetach();
    com.tencent.mm.plugin.finder.view.b localb = this.rWF;
    if (localb != null)
    {
      localb.dead();
      AppMethodBeat.o(204297);
      return;
    }
    AppMethodBeat.o(204297);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(204293);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new g(this, (com.tencent.mm.plugin.finder.feed.h)this.sIv, this.sIv.rMJ);
        AppMethodBeat.o(204293);
        return localb;
      case 4: 
      case 3002: 
        localb = (com.tencent.mm.view.recyclerview.b)new a(this, this.sIv.rOe, (com.tencent.mm.plugin.finder.feed.h)this.sIv, this.sIv.rMJ);
        AppMethodBeat.o(204293);
        return localb;
      case 2: 
      case 3001: 
        localb = (com.tencent.mm.view.recyclerview.b)new b(this, (com.tencent.mm.plugin.finder.feed.h)this.sIv, this.sIv.rMJ);
        AppMethodBeat.o(204293);
        return localb;
      case 7: 
        localb = (com.tencent.mm.view.recyclerview.b)new c(this, (com.tencent.mm.plugin.finder.feed.h)this.sIv, this.sIv.rMJ);
        AppMethodBeat.o(204293);
        return localb;
      case 8: 
        localb = (com.tencent.mm.view.recyclerview.b)new d(this, this.sIv.rOe, (com.tencent.mm.plugin.finder.feed.h)this.sIv, this.sIv.rMJ);
        AppMethodBeat.o(204293);
        return localb;
      case 1: 
        localb = (com.tencent.mm.view.recyclerview.b)new e(this, (com.tencent.mm.plugin.finder.feed.h)this.sIv, this.sIv.rMJ);
        AppMethodBeat.o(204293);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new f(this);
      AppMethodBeat.o(204293);
      return localb;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends w
    {
      a(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, s params, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204273);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(params, "item");
        super.a(parame, (BaseFinderFeed)params, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rMJ);
        parame = parame.Gd(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(204273);
          return;
        }
        AppMethodBeat.o(204273);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends k
    {
      b(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204276);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramn, "item");
        super.a(parame, (BaseFinderFeed)paramn, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rMJ);
        parame = parame.Gd(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(204276);
          return;
        }
        AppMethodBeat.o(204276);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends u
    {
      c(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204279);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramn, "item");
        super.a(parame, paramn, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rMJ);
        AppMethodBeat.o(204279);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends com.tencent.mm.plugin.finder.convert.n
    {
      d(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.p paramp, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204282);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramp, "item");
        super.a(parame, (BaseFinderFeed)paramp, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rMJ);
        AppMethodBeat.o(204282);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.q
    {
      e(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.q paramq, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204285);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramq, "item");
        super.a(parame, (BaseFinderFeed)paramq, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rMJ);
        AppMethodBeat.o(204285);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class f
      extends ah
    {
      public final void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204288);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramb, "item");
        super.a(parame, paramb, paramInt1, paramInt2, paramBoolean, paramList);
        paramb = this.sIw.sIv.sIu;
        if (paramb != null)
        {
          parame = parame.auu;
          d.g.b.p.g(parame, "holder.itemView");
          paramb.invoke(parame);
          AppMethodBeat.o(204288);
          return;
        }
        AppMethodBeat.o(204288);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$7", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class g
      extends k
    {
      g(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.n paramn, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204290);
        d.g.b.p.h(parame, "holder");
        d.g.b.p.h(paramn, "item");
        super.a(parame, (BaseFinderFeed)paramn, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rMJ);
        AppMethodBeat.o(204290);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(204294);
      com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.EO(this.sIv.duh);
      AppMethodBeat.o(204294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g
 * JD-Core Version:    0.7.0.1
 */