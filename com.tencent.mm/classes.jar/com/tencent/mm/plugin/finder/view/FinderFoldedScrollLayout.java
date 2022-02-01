package com.tencent.mm.plugin.finder.view;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.as;
import com.tencent.mm.plugin.finder.convert.at;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.b;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FOOTER_COUNT", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "foldedController", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1;", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "footerData", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1;", "layoutType", "parentFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "", "jumpFoldedUI", "jumpPos", "setup", "Companion", "FoldedController", "plugin-finder_release"})
public final class FinderFoldedScrollLayout
  extends FrameLayout
{
  private static long LeT;
  private static long LeU;
  private static long LeV;
  private static long LeW;
  public static final a LeX;
  public int Dlf;
  public WxRecyclerView KPx;
  private final int LeP;
  public final e LeQ;
  public BaseFinderFeed LeR;
  private final d LeS;
  public ArrayList<com.tencent.mm.view.recyclerview.a> dataList;
  public ain foldedLayout;
  public WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> qul;
  
  static
  {
    AppMethodBeat.i(200104);
    LeX = new a((byte)0);
    AppMethodBeat.o(200104);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200102);
    this.LeP = 1;
    this.dataList = new ArrayList();
    this.LeQ = new e();
    this.LeS = new d(this);
    initView();
    AppMethodBeat.o(200102);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200103);
    this.LeP = 1;
    this.dataList = new ArrayList();
    this.LeQ = new e();
    this.LeS = new d(this);
    initView();
    AppMethodBeat.o(200103);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(200100);
    Object localObject1 = getContext();
    k.g(localObject1, "context");
    this.KPx = new WxRecyclerView((Context)localObject1);
    localObject1 = this.KPx;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    ((WxRecyclerView)localObject1).setBackgroundResource(2131234894);
    localObject1 = this.KPx;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject1 = this.KPx;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new FinderLayoutManager());
    this.qul = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new c(this), this.dataList, true);
    localObject1 = this.KPx;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    Object localObject2 = this.qul;
    if (localObject2 == null) {
      k.aPZ("adapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.KPx;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    ((WxRecyclerView)localObject1).b(getItemDecoration());
    localObject1 = this.KPx;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    localObject2 = com.tencent.mm.ui.component.a.LCX;
    localObject2 = getContext();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(200100);
      throw ((Throwable)localObject1);
    }
    ((WxRecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s((MMActivity)localObject2).get(FinderRecyclerViewPool.class)).Lhs);
    localObject1 = FinderReporterUIC.Ljl;
    localObject1 = getContext();
    k.g(localObject1, "context");
    localObject1 = FinderReporterUIC.a.lB((Context)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.qul;
      if (localObject2 == null) {
        k.aPZ("adapter");
      }
      k.h(localObject2, "adapter");
      com.tencent.mm.ad.c.g((d.g.a.a)new FinderReporterUIC.b((FinderReporterUIC)localObject1, (WxRecyclerAdapter)localObject2));
      AppMethodBeat.o(200100);
      return;
    }
    AppMethodBeat.o(200100);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter()
  {
    AppMethodBeat.i(200096);
    WxRecyclerAdapter localWxRecyclerAdapter = this.qul;
    if (localWxRecyclerAdapter == null) {
      k.aPZ("adapter");
    }
    AppMethodBeat.o(200096);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(200101);
    RecyclerView.h localh = (RecyclerView.h)new f(this);
    AppMethodBeat.o(200101);
    return localh;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(200098);
    WxRecyclerView localWxRecyclerView = this.KPx;
    if (localWxRecyclerView == null) {
      k.aPZ("recyclerView");
    }
    AppMethodBeat.o(200098);
    return localWxRecyclerView;
  }
  
  public final void setAdapter(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(200097);
    k.h(paramWxRecyclerAdapter, "<set-?>");
    this.qul = paramWxRecyclerAdapter;
    AppMethodBeat.o(200097);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(200099);
    k.h(paramWxRecyclerView, "<set-?>");
    this.KPx = paramWxRecyclerView;
    AppMethodBeat.o(200099);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$Companion;", "", "()V", "clickFeedItemId", "", "getClickFeedItemId", "()J", "setClickFeedItemId", "(J)V", "clickFeedItemTimestamp", "getClickFeedItemTimestamp", "setClickFeedItemTimestamp", "clickFoldedTopTimestamp", "getClickFoldedTopTimestamp", "setClickFoldedTopTimestamp", "clickMoreTimestamp", "getClickMoreTimestamp", "setClickMoreTimestamp", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "", "getLayoutType", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void f(e parame);
    
    public abstract int fWP();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.c
  {
    public final b<?> zm(int paramInt)
    {
      AppMethodBeat.i(200091);
      switch (paramInt)
      {
      default: 
        localb = (b)new j();
        AppMethodBeat.o(200091);
        return localb;
      case 4: 
        localb = (b)new at((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.LeY));
        AppMethodBeat.o(200091);
        return localb;
      case 2: 
        localb = (b)new ag((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.LeY));
        AppMethodBeat.o(200091);
        return localb;
      }
      b localb = (b)new as((d.g.a.a)new a(this));
      AppMethodBeat.o(200091);
      return localb;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutType", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class d
    implements FinderFoldedScrollLayout.b
  {
    public final void f(e parame)
    {
      AppMethodBeat.i(200092);
      k.h(parame, "holder");
      int i = parame.lm();
      parame = FinderFoldedScrollLayout.b(this.LeY);
      if (parame != null)
      {
        FinderFoldedScrollLayout.a(this.LeY, parame, i);
        AppMethodBeat.o(200092);
        return;
      }
      AppMethodBeat.o(200092);
    }
    
    public final int fWP()
    {
      AppMethodBeat.i(200093);
      int i = FinderFoldedScrollLayout.e(this.LeY);
      AppMethodBeat.o(200093);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.a
  {
    public final long bMs()
    {
      AppMethodBeat.i(200094);
      long l = hashCode();
      AppMethodBeat.o(200094);
      return l;
    }
    
    public final int bMt()
    {
      return -100;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(200095);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
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
        AppMethodBeat.o(200095);
        return;
      }
      if (k == FinderFoldedScrollLayout.c(this.LeY).size() - 1)
      {
        paramRect.left = j;
        paramRect.right = i;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(200095);
        return;
      }
      paramRect.left = j;
      paramRect.right = j;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(200095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout
 * JD-Core Version:    0.7.0.1
 */