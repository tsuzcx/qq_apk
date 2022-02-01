package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.a.a;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.u.a;
import com.tencent.mm.plugin.finder.feed.u.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import d.z;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZI)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "getTabType", "()I", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "consumeBackPressed", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "onRefreshEnd", "plugin-finder_release"})
public final class g
  extends i.a
{
  private String TAG;
  final int dvm;
  d.g.a.b<? super View, z> sTG;
  private com.tencent.mm.plugin.finder.view.b sfq;
  
  public g(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean, int paramInt2)
  {
    super(paramInt1, paramMMActivity, paramBoolean, (byte)0);
    AppMethodBeat.i(204919);
    this.dvm = paramInt2;
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(204919);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    AppMethodBeat.i(204914);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    paramBaseFinderFeedLoader = this.scw;
    if (paramBaseFinderFeedLoader != null)
    {
      this.sfq = new com.tencent.mm.plugin.finder.view.b(paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = this.sfq;
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.alive();
      }
    }
    paramb.scj.getRecyclerView().post((Runnable)new b(this));
    AppMethodBeat.o(204914);
  }
  
  public final void cCo()
  {
    AppMethodBeat.i(204916);
    f localf = f.syc;
    f.ah(this.dvm, false);
    AppMethodBeat.o(204916);
  }
  
  public final void cCp()
  {
    AppMethodBeat.i(204917);
    f localf = f.syc;
    f.ah(this.dvm, false);
    AppMethodBeat.o(204917);
  }
  
  public final c cCq()
  {
    AppMethodBeat.i(204913);
    c localc = (c)new a(this);
    AppMethodBeat.o(204913);
    return localc;
  }
  
  public final boolean cNc()
  {
    AppMethodBeat.i(204918);
    Object localObject = this.scd;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cCx();
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.view.e)localObject).cPI()))
      {
        ((com.tencent.mm.plugin.finder.view.e)localObject).cPH();
        AppMethodBeat.o(204918);
        return true;
      }
    }
    localObject = this.scd;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).scn;
      if ((localObject != null) && (((TouchMediaPreviewLayout)localObject).LqB))
      {
        ((TouchMediaPreviewLayout)localObject).fQg();
        AppMethodBeat.o(204918);
        return true;
      }
    }
    localObject = this.scd;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cCy();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).cPI()))
      {
        ((FinderLikeDrawer)localObject).cPH();
        AppMethodBeat.o(204918);
        return true;
      }
    }
    localObject = this.scd;
    if (localObject != null)
    {
      localObject = ((a.b)localObject).cCv();
      if ((localObject != null) && (((FinderLikeDrawer)localObject).cPI()))
      {
        ((FinderLikeDrawer)localObject).cPH();
        AppMethodBeat.o(204918);
        return true;
      }
    }
    AppMethodBeat.o(204918);
    return false;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(204915);
    super.onDetach();
    com.tencent.mm.plugin.finder.view.b localb = this.sfq;
    if (localb != null)
    {
      localb.dead();
      AppMethodBeat.o(204915);
      return;
    }
    AppMethodBeat.o(204915);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(204911);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new g(this, (com.tencent.mm.plugin.finder.feed.h)this.sTH, this.sTH.rUX);
        AppMethodBeat.o(204911);
        return localb;
      case 4: 
      case 3002: 
        localb = (com.tencent.mm.view.recyclerview.b)new a(this, this.sTH.rWB, (com.tencent.mm.plugin.finder.feed.h)this.sTH, this.sTH.rUX);
        AppMethodBeat.o(204911);
        return localb;
      case 2: 
      case 3001: 
        localb = (com.tencent.mm.view.recyclerview.b)new b(this, (com.tencent.mm.plugin.finder.feed.h)this.sTH, this.sTH.rUX);
        AppMethodBeat.o(204911);
        return localb;
      case 7: 
        localb = (com.tencent.mm.view.recyclerview.b)new c(this, (com.tencent.mm.plugin.finder.feed.h)this.sTH, this.sTH.rUX);
        AppMethodBeat.o(204911);
        return localb;
      case 8: 
        localb = (com.tencent.mm.view.recyclerview.b)new d(this, this.sTH.rWB, (com.tencent.mm.plugin.finder.feed.h)this.sTH, this.sTH.rUX);
        AppMethodBeat.o(204911);
        return localb;
      case 1: 
        localb = (com.tencent.mm.view.recyclerview.b)new e(this, (com.tencent.mm.plugin.finder.feed.h)this.sTH, this.sTH.rUX);
        AppMethodBeat.o(204911);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new g.a.f(this);
      AppMethodBeat.o(204911);
      return localb;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends w
    {
      a(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, t paramt, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204891);
        p.h(parame, "holder");
        p.h(paramt, "item");
        super.a(parame, (BaseFinderFeed)paramt, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rUX);
        parame = parame.GD(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(204891);
          return;
        }
        AppMethodBeat.o(204891);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends k
    {
      b(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204894);
        p.h(parame, "holder");
        p.h(paramo, "item");
        super.a(parame, (BaseFinderFeed)paramo, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rUX);
        parame = parame.GD(2131307449);
        if (parame != null)
        {
          parame.setVisibility(8);
          AppMethodBeat.o(204894);
          return;
        }
        AppMethodBeat.o(204894);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class c
      extends u
    {
      c(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204897);
        p.h(parame, "holder");
        p.h(paramo, "item");
        super.a(parame, paramo, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rUX);
        AppMethodBeat.o(204897);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class d
      extends n
    {
      d(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(paramBoolean, bool, 0, 8);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, com.tencent.mm.plugin.finder.model.q paramq, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204900);
        p.h(parame, "holder");
        p.h(paramq, "item");
        super.a(parame, (BaseFinderFeed)paramq, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rUX);
        AppMethodBeat.o(204900);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class e
      extends com.tencent.mm.plugin.finder.convert.q
    {
      e(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, r paramr, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204903);
        p.h(parame, "holder");
        p.h(paramr, "item");
        super.a(parame, (BaseFinderFeed)paramr, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rUX);
        AppMethodBeat.o(204903);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$7", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class g
      extends k
    {
      g(com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean)
      {
        super(bool, 0, 4);
      }
      
      private void a(com.tencent.mm.view.recyclerview.e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(204908);
        p.h(parame, "holder");
        p.h(paramo, "item");
        super.a(parame, (BaseFinderFeed)paramo, paramInt1, paramInt2, paramBoolean, paramList);
        g.d(parame, this.rUX);
        AppMethodBeat.o(204908);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(204912);
      f localf = f.syc;
      f.Fk(this.sTH.dvm);
      AppMethodBeat.o(204912);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g
 * JD-Core Version:    0.7.0.1
 */