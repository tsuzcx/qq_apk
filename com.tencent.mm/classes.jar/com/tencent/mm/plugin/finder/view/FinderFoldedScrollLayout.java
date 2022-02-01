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
import com.tencent.mm.plugin.finder.convert.as;
import com.tencent.mm.plugin.finder.convert.at;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.b;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FOOTER_COUNT", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "foldedController", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1;", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "footerData", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1;", "layoutType", "parentFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "", "jumpFoldedUI", "jumpPos", "setup", "Companion", "FoldedController", "plugin-finder_release"})
public final class FinderFoldedScrollLayout
  extends FrameLayout
{
  private static long rXA;
  public static final FinderFoldedScrollLayout.a rXB;
  private static long rXx;
  private static long rXy;
  private static long rXz;
  public ArrayList<com.tencent.mm.view.recyclerview.a> dataList;
  public ajz foldedLayout;
  private final int rXs;
  public final e rXt;
  public int rXu;
  public BaseFinderFeed rXv;
  private final d rXw;
  public WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> rfX;
  public WxRecyclerView rlU;
  
  static
  {
    AppMethodBeat.i(204175);
    rXB = new FinderFoldedScrollLayout.a((byte)0);
    AppMethodBeat.o(204175);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204173);
    this.rXs = 1;
    this.dataList = new ArrayList();
    this.rXt = new e();
    this.rXw = new d(this);
    initView();
    AppMethodBeat.o(204173);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204174);
    this.rXs = 1;
    this.dataList = new ArrayList();
    this.rXt = new e();
    this.rXw = new d(this);
    initView();
    AppMethodBeat.o(204174);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(204171);
    Object localObject = getContext();
    k.g(localObject, "context");
    this.rlU = new WxRecyclerView((Context)localObject);
    localObject = this.rlU;
    if (localObject == null) {
      k.aVY("recyclerView");
    }
    ((WxRecyclerView)localObject).setBackgroundResource(2131234898);
    localObject = this.rlU;
    if (localObject == null) {
      k.aVY("recyclerView");
    }
    addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject = this.rlU;
    if (localObject == null) {
      k.aVY("recyclerView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.i)new FinderLayoutManager());
    this.rfX = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new c(this), this.dataList, true);
    localObject = this.rlU;
    if (localObject == null) {
      k.aVY("recyclerView");
    }
    WxRecyclerAdapter localWxRecyclerAdapter = this.rfX;
    if (localWxRecyclerAdapter == null) {
      k.aVY("adapter");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)localWxRecyclerAdapter);
    localObject = this.rlU;
    if (localObject == null) {
      k.aVY("recyclerView");
    }
    ((WxRecyclerView)localObject).b(getItemDecoration());
    localObject = FinderReporterUIC.seQ;
    localObject = getContext();
    k.g(localObject, "context");
    localObject = FinderReporterUIC.a.eV((Context)localObject);
    if (localObject != null)
    {
      localWxRecyclerAdapter = this.rfX;
      if (localWxRecyclerAdapter == null) {
        k.aVY("adapter");
      }
      k.h(localWxRecyclerAdapter, "adapter");
      com.tencent.mm.ac.c.g((d.g.a.a)new FinderReporterUIC.b((FinderReporterUIC)localObject, localWxRecyclerAdapter));
      AppMethodBeat.o(204171);
      return;
    }
    AppMethodBeat.o(204171);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter()
  {
    AppMethodBeat.i(204167);
    WxRecyclerAdapter localWxRecyclerAdapter = this.rfX;
    if (localWxRecyclerAdapter == null) {
      k.aVY("adapter");
    }
    AppMethodBeat.o(204167);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(204172);
    RecyclerView.h localh = (RecyclerView.h)new f(this);
    AppMethodBeat.o(204172);
    return localh;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(204169);
    WxRecyclerView localWxRecyclerView = this.rlU;
    if (localWxRecyclerView == null) {
      k.aVY("recyclerView");
    }
    AppMethodBeat.o(204169);
    return localWxRecyclerView;
  }
  
  public final void setAdapter(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(204168);
    k.h(paramWxRecyclerAdapter, "<set-?>");
    this.rfX = paramWxRecyclerAdapter;
    AppMethodBeat.o(204168);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(204170);
    k.h(paramWxRecyclerView, "<set-?>");
    this.rlU = paramWxRecyclerView;
    AppMethodBeat.o(204170);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "", "getLayoutType", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract int cEY();
    
    public abstract void f(e parame);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(204162);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.b();
        AppMethodBeat.o(204162);
        return localb;
      case 4: 
        localb = (com.tencent.mm.view.recyclerview.b)new at((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.rXC));
        AppMethodBeat.o(204162);
        return localb;
      case 2: 
        localb = (com.tencent.mm.view.recyclerview.b)new z((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.rXC));
        AppMethodBeat.o(204162);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new as((d.g.a.a)new a(this));
      AppMethodBeat.o(204162);
      return localb;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderFoldedScrollLayout.c paramc)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutType", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class d
    implements FinderFoldedScrollLayout.b
  {
    public final int cEY()
    {
      AppMethodBeat.i(204164);
      int i = FinderFoldedScrollLayout.e(this.rXC);
      AppMethodBeat.o(204164);
      return i;
    }
    
    public final void f(e parame)
    {
      AppMethodBeat.i(204163);
      k.h(parame, "holder");
      int i = parame.lu();
      parame = FinderFoldedScrollLayout.b(this.rXC);
      if (parame != null)
      {
        FinderFoldedScrollLayout.a(this.rXC, parame, i);
        AppMethodBeat.o(204163);
        return;
      }
      AppMethodBeat.o(204163);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.a
  {
    public final int bTF()
    {
      return -100;
    }
    
    public final long lx()
    {
      AppMethodBeat.i(204165);
      long l = hashCode();
      AppMethodBeat.o(204165);
      return l;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(204166);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(paramt, "state");
      paramRecyclerView = paramView.getContext();
      k.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165284);
      paramRecyclerView = paramView.getContext();
      k.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166296);
      int k = RecyclerView.bw(paramView);
      if (k == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(204166);
        return;
      }
      if (k == FinderFoldedScrollLayout.c(this.rXC).size() - 1)
      {
        paramRect.left = j;
        paramRect.right = i;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(204166);
        return;
      }
      paramRect.left = j;
      paramRect.right = j;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(204166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout
 * JD-Core Version:    0.7.0.1
 */