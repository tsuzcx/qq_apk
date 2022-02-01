package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ac;
import com.tencent.mm.plugin.finder.convert.be;
import com.tencent.mm.plugin.finder.convert.bg;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FOOTER_COUNT", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "foldedController", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1;", "footerData", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1;", "layoutType", "presenter", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "", "setup", "Companion", "FoldedController", "plugin-finder_release"})
public final class FinderFoldedScrollLayout
  extends FrameLayout
{
  private static long sUr;
  private static long sUs;
  private static long sUt;
  private static long sUu;
  public static final a sUv;
  private ArrayList<com.tencent.mm.view.recyclerview.a> jfg;
  public WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> rPu;
  private final int sUl;
  public WxRecyclerView sUm;
  private final e sUn;
  private int sUo;
  private m sUp;
  private final d sUq;
  
  static
  {
    AppMethodBeat.i(205153);
    sUv = new a((byte)0);
    AppMethodBeat.o(205153);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205151);
    this.sUl = 1;
    this.jfg = new ArrayList();
    this.sUn = new e();
    this.sUq = new d(this);
    initView();
    AppMethodBeat.o(205151);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205152);
    this.sUl = 1;
    this.jfg = new ArrayList();
    this.sUn = new e();
    this.sUq = new d(this);
    initView();
    AppMethodBeat.o(205152);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(205148);
    Object localObject = getContext();
    p.g(localObject, "context");
    this.sUm = new WxRecyclerView((Context)localObject);
    localObject = this.sUm;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((WxRecyclerView)localObject).setBackgroundResource(2131234898);
    localObject = this.sUm;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject = this.sUm;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.i)new FinderLayoutManager());
    this.rPu = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new c(this), this.jfg, true);
    localObject = this.sUm;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    WxRecyclerAdapter localWxRecyclerAdapter = this.rPu;
    if (localWxRecyclerAdapter == null) {
      p.bcb("adapter");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)localWxRecyclerAdapter);
    localObject = this.sUm;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((WxRecyclerView)localObject).b(getItemDecoration());
    localObject = FinderReporterUIC.tcM;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.eY((Context)localObject);
    if (localObject != null)
    {
      localWxRecyclerAdapter = this.rPu;
      if (localWxRecyclerAdapter == null) {
        p.bcb("adapter");
      }
      p.h(localWxRecyclerAdapter, "adapter");
      com.tencent.mm.ad.c.g((d.g.a.a)new FinderReporterUIC.b((FinderReporterUIC)localObject, localWxRecyclerAdapter));
      AppMethodBeat.o(205148);
      return;
    }
    AppMethodBeat.o(205148);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter()
  {
    AppMethodBeat.i(205144);
    WxRecyclerAdapter localWxRecyclerAdapter = this.rPu;
    if (localWxRecyclerAdapter == null) {
      p.bcb("adapter");
    }
    AppMethodBeat.o(205144);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(205150);
    RecyclerView.h localh = (RecyclerView.h)new f(this);
    AppMethodBeat.o(205150);
    return localh;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(205146);
    WxRecyclerView localWxRecyclerView = this.sUm;
    if (localWxRecyclerView == null) {
      p.bcb("recyclerView");
    }
    AppMethodBeat.o(205146);
    return localWxRecyclerView;
  }
  
  public final void setAdapter(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(205145);
    p.h(paramWxRecyclerAdapter, "<set-?>");
    this.rPu = paramWxRecyclerAdapter;
    AppMethodBeat.o(205145);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(205147);
    p.h(paramWxRecyclerView, "<set-?>");
    this.sUm = paramWxRecyclerView;
    AppMethodBeat.o(205147);
  }
  
  public final void setup(m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(205149);
    p.h(paramm, "presenter");
    this.sUp = paramm;
    this.sUo = paramm.cNn();
    this.jfg.clear();
    List localList = paramm.cNm();
    StringBuilder localStringBuilder = new StringBuilder("steup foldedlayout ");
    Object localObject1 = paramm.cNl().feedObject;
    if (localObject1 != null) {}
    for (localObject1 = ((FinderItem)localObject1).getDebugDescription();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(' ').append(paramm.cNl().feedObject).append(' ');
      Object localObject3 = (BaseFinderFeed)j.E(localList, 0);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((BaseFinderFeed)localObject3).feedObject;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((FinderItem)localObject3).getDebugDescription();
        }
      }
      ad.i("Finder.FinderFoldedScrollLayout", (String)localObject1);
      this.jfg.addAll((Collection)localList);
      if (paramm.cNo()) {
        this.jfg.add(this.sUn);
      }
      paramm = this.sUm;
      if (paramm == null) {
        p.bcb("recyclerView");
      }
      paramm = paramm.getLayoutManager();
      if (paramm != null) {
        break;
      }
      paramm = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
      AppMethodBeat.o(205149);
      throw paramm;
    }
    ((FinderLayoutManager)paramm).ag(0, 0);
    paramm = this.sUm;
    if (paramm == null) {
      p.bcb("recyclerView");
    }
    paramm = paramm.getAdapter();
    if (paramm != null)
    {
      paramm.notifyDataSetChanged();
      AppMethodBeat.o(205149);
      return;
    }
    AppMethodBeat.o(205149);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$Companion;", "", "()V", "clickFeedItemId", "", "getClickFeedItemId", "()J", "setClickFeedItemId", "(J)V", "clickFeedItemTimestamp", "getClickFeedItemTimestamp", "setClickFeedItemTimestamp", "clickFoldedTopTimestamp", "getClickFoldedTopTimestamp", "setClickFoldedTopTimestamp", "clickMoreTimestamp", "getClickMoreTimestamp", "setClickMoreTimestamp", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "", "getLayoutType", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract int cNn();
    
    public abstract void g(e parame);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(205139);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.b();
        AppMethodBeat.o(205139);
        return localb;
      case 4: 
        localb = (com.tencent.mm.view.recyclerview.b)new bg((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.sUw));
        AppMethodBeat.o(205139);
        return localb;
      case 2: 
        localb = (com.tencent.mm.view.recyclerview.b)new ac((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.sUw));
        AppMethodBeat.o(205139);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new be((d.g.a.a)new a(this));
      AppMethodBeat.o(205139);
      return localb;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderFoldedScrollLayout.c paramc)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutType", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class d
    implements FinderFoldedScrollLayout.b
  {
    public final int cNn()
    {
      AppMethodBeat.i(205141);
      m localm = FinderFoldedScrollLayout.b(this.sUw);
      if (localm != null)
      {
        int i = localm.cNn();
        AppMethodBeat.o(205141);
        return i;
      }
      AppMethodBeat.o(205141);
      return 1;
    }
    
    public final void g(e parame)
    {
      AppMethodBeat.i(205140);
      p.h(parame, "holder");
      int i = parame.lM();
      parame = FinderFoldedScrollLayout.b(this.sUw);
      if (parame != null)
      {
        Context localContext = this.sUw.getContext();
        p.g(localContext, "context");
        parame.Z(localContext, i);
        AppMethodBeat.o(205140);
        return;
      }
      AppMethodBeat.o(205140);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.a
  {
    public final int bYk()
    {
      return -100;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(205142);
      long l = hashCode();
      AppMethodBeat.o(205142);
      return l;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(205143);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165284);
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166296);
      int k = RecyclerView.bw(paramView);
      if (k == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(205143);
        return;
      }
      if (k == FinderFoldedScrollLayout.c(this.sUw).size() - 1)
      {
        paramRect.left = j;
        paramRect.right = i;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(205143);
        return;
      }
      paramRect.left = j;
      paramRect.right = j;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(205143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout
 * JD-Core Version:    0.7.0.1
 */