package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.convert.aq;
import com.tencent.mm.plugin.finder.convert.cf;
import com.tencent.mm.plugin.finder.convert.cn;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FOOTER_COUNT", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "foldedController", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1;", "footerData", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1;", "itemLayoutType", "presenter", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "", "setup", "Companion", "FoldedController", "plugin-finder_release"})
public final class FinderFoldedScrollLayout
  extends FrameLayout
{
  private static long wmM;
  private static long wmN;
  private static long wmO;
  private static long wmP;
  public static final a wmQ;
  private ArrayList<com.tencent.mm.view.recyclerview.a> kgc;
  public WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> tFp;
  public WxRecyclerView ufR;
  private final int wmH;
  private final e wmI;
  private int wmJ;
  private p wmK;
  private final d wmL;
  
  static
  {
    AppMethodBeat.i(254842);
    wmQ = new a((byte)0);
    AppMethodBeat.o(254842);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254840);
    this.wmH = 1;
    this.kgc = new ArrayList();
    this.wmI = new e();
    this.wmL = new d(this);
    initView();
    AppMethodBeat.o(254840);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254841);
    this.wmH = 1;
    this.kgc = new ArrayList();
    this.wmI = new e();
    this.wmL = new d(this);
    initView();
    AppMethodBeat.o(254841);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(254837);
    Object localObject1 = getContext();
    kotlin.g.b.p.g(localObject1, "context");
    this.ufR = new WxRecyclerView((Context)localObject1);
    localObject1 = this.ufR;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("recyclerView");
    }
    ((WxRecyclerView)localObject1).setBackgroundResource(2131232798);
    localObject1 = this.ufR;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("recyclerView");
    }
    addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject1 = this.ufR;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("recyclerView");
    }
    Object localObject2 = getContext();
    kotlin.g.b.p.g(localObject2, "context");
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)localObject2, (byte)0));
    this.tFp = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new c(this), this.kgc, true);
    localObject1 = this.ufR;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("recyclerView");
    }
    localObject2 = this.tFp;
    if (localObject2 == null) {
      kotlin.g.b.p.btv("adapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.ufR;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("recyclerView");
    }
    ((WxRecyclerView)localObject1).b(getItemDecoration());
    localObject1 = FinderReporterUIC.wzC;
    localObject1 = getContext();
    kotlin.g.b.p.g(localObject1, "context");
    localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.tFp;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("adapter");
      }
      kotlin.g.b.p.h(localObject2, "adapter");
      d.h((kotlin.g.a.a)new FinderReporterUIC.b((FinderReporterUIC)localObject1, (WxRecyclerAdapter)localObject2));
      AppMethodBeat.o(254837);
      return;
    }
    AppMethodBeat.o(254837);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter()
  {
    AppMethodBeat.i(254833);
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      kotlin.g.b.p.btv("adapter");
    }
    AppMethodBeat.o(254833);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(254839);
    RecyclerView.h localh = (RecyclerView.h)new f(this);
    AppMethodBeat.o(254839);
    return localh;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(254835);
    WxRecyclerView localWxRecyclerView = this.ufR;
    if (localWxRecyclerView == null) {
      kotlin.g.b.p.btv("recyclerView");
    }
    AppMethodBeat.o(254835);
    return localWxRecyclerView;
  }
  
  public final void setAdapter(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(254834);
    kotlin.g.b.p.h(paramWxRecyclerAdapter, "<set-?>");
    this.tFp = paramWxRecyclerAdapter;
    AppMethodBeat.o(254834);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(254836);
    kotlin.g.b.p.h(paramWxRecyclerView, "<set-?>");
    this.ufR = paramWxRecyclerView;
    AppMethodBeat.o(254836);
  }
  
  public final void setup(p paramp)
  {
    Object localObject2 = null;
    AppMethodBeat.i(254838);
    kotlin.g.b.p.h(paramp, "presenter");
    this.wmK = paramp;
    this.wmJ = paramp.cZG();
    this.kgc.clear();
    List localList = paramp.GW();
    StringBuilder localStringBuilder = new StringBuilder("steup foldedlayout ");
    Object localObject1 = paramp.dGI();
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 != null)
      {
        localObject1 = ((FinderItem)localObject1).getDebugDescription();
        localStringBuilder = localStringBuilder.append((String)localObject1).append(' ');
        localObject1 = paramp.dGI();
        if (localObject1 == null) {
          break label258;
        }
      }
    }
    label258:
    for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      Object localObject3 = (BaseFinderFeed)j.L(localList, 0);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((BaseFinderFeed)localObject3).feedObject;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((FinderItem)localObject3).getDebugDescription();
        }
      }
      Log.i("Finder.FinderFoldedScrollLayout", (String)localObject1);
      this.kgc.addAll((Collection)localList);
      if (paramp.dGJ()) {
        this.kgc.add(this.wmI);
      }
      paramp = this.ufR;
      if (paramp == null) {
        kotlin.g.b.p.btv("recyclerView");
      }
      paramp = paramp.getLayoutManager();
      if (paramp != null) {
        break label263;
      }
      paramp = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(254838);
      throw paramp;
      localObject1 = null;
      break;
    }
    label263:
    ((FinderLinearLayoutManager)paramp).ah(0, 0);
    paramp = this.ufR;
    if (paramp == null) {
      kotlin.g.b.p.btv("recyclerView");
    }
    paramp = paramp.getAdapter();
    if (paramp != null)
    {
      paramp.notifyDataSetChanged();
      AppMethodBeat.o(254838);
      return;
    }
    AppMethodBeat.o(254838);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$Companion;", "", "()V", "clickFeedItemId", "", "getClickFeedItemId", "()J", "setClickFeedItemId", "(J)V", "clickFeedItemTimestamp", "getClickFeedItemTimestamp", "setClickFeedItemTimestamp", "clickFoldedTopTimestamp", "getClickFoldedTopTimestamp", "setClickFoldedTopTimestamp", "clickMoreTimestamp", "getClickMoreTimestamp", "setClickMoreTimestamp", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract ConstraintLayout.LayoutParams cZE();
    
    public abstract boolean cZF();
    
    public abstract int cZG();
    
    public abstract void h(h paramh);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(254826);
      switch (paramInt)
      {
      default: 
        locale = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(254826);
        return locale;
      case 4: 
        locale = (e)new cn((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.wmR));
        AppMethodBeat.o(254826);
        return locale;
      case 2: 
        locale = (e)new aq((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.wmR));
        AppMethodBeat.o(254826);
        return locale;
      }
      e locale = (e)new cf((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(254826);
      return locale;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderFoldedScrollLayout.c paramc)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class d
    implements FinderFoldedScrollLayout.b
  {
    public final ConstraintLayout.LayoutParams cZE()
    {
      AppMethodBeat.i(254828);
      FinderFoldedScrollLayout.b(this.wmR);
      AppMethodBeat.o(254828);
      return null;
    }
    
    public final boolean cZF()
    {
      AppMethodBeat.i(254829);
      FinderFoldedScrollLayout.b(this.wmR);
      AppMethodBeat.o(254829);
      return false;
    }
    
    public final int cZG()
    {
      AppMethodBeat.i(254830);
      p localp = FinderFoldedScrollLayout.b(this.wmR);
      if (localp != null)
      {
        int i = localp.cZG();
        AppMethodBeat.o(254830);
        return i;
      }
      AppMethodBeat.o(254830);
      return 1;
    }
    
    public final void h(h paramh)
    {
      AppMethodBeat.i(254827);
      kotlin.g.b.p.h(paramh, "holder");
      int i = paramh.lQ();
      paramh = FinderFoldedScrollLayout.b(this.wmR);
      if (paramh != null)
      {
        Context localContext = this.wmR.getContext();
        kotlin.g.b.p.g(localContext, "context");
        paramh.ag(localContext, i);
        AppMethodBeat.o(254827);
        return;
      }
      AppMethodBeat.o(254827);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.a
  {
    public final int cxn()
    {
      return -100;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(254831);
      long l = hashCode();
      AppMethodBeat.o(254831);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(254832);
      kotlin.g.b.p.h(paramRect, "outRect");
      kotlin.g.b.p.h(paramView, "view");
      kotlin.g.b.p.h(paramRecyclerView, "parent");
      kotlin.g.b.p.h(params, "state");
      paramRecyclerView = paramView.getContext();
      kotlin.g.b.p.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165289);
      paramRecyclerView = paramView.getContext();
      kotlin.g.b.p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166347);
      FinderFoldedScrollLayout.b(this.wmR);
      j = Math.max(j, 0);
      int k = RecyclerView.bw(paramView);
      if (k == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(254832);
        return;
      }
      if (k == FinderFoldedScrollLayout.c(this.wmR).size() - 1)
      {
        paramRect.left = j;
        paramRect.right = i;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(254832);
        return;
      }
      paramRect.left = j;
      paramRect.right = j;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(254832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout
 * JD-Core Version:    0.7.0.1
 */