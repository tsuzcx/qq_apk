package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.convert.as;
import com.tencent.mm.plugin.finder.convert.cm;
import com.tencent.mm.plugin.finder.convert.cu;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FOOTER_COUNT", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "foldedController", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1;", "footerData", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1;", "itemLayoutType", "presenter", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "", "setup", "Companion", "FoldedController", "plugin-finder_release"})
public final class FinderFoldedScrollLayout
  extends FrameLayout
{
  private static long AXP;
  private static long AXQ;
  private static long AXR;
  private static long AXS;
  public static final a AXT;
  private final int AXK;
  private final e AXL;
  private int AXM;
  private v AXN;
  private final d AXO;
  private ArrayList<com.tencent.mm.view.recyclerview.a> mXB;
  public WxRecyclerView xUj;
  public WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> xnR;
  
  static
  {
    AppMethodBeat.i(277662);
    AXT = new a((byte)0);
    AppMethodBeat.o(277662);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(277660);
    this.AXK = 1;
    this.mXB = new ArrayList();
    this.AXL = new e();
    this.AXO = new d(this);
    initView();
    AppMethodBeat.o(277660);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(277661);
    this.AXK = 1;
    this.mXB = new ArrayList();
    this.AXL = new e();
    this.AXO = new d(this);
    initView();
    AppMethodBeat.o(277661);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(277655);
    Object localObject1 = getContext();
    p.j(localObject1, "context");
    this.xUj = new WxRecyclerView((Context)localObject1);
    localObject1 = this.xUj;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    ((WxRecyclerView)localObject1).setBackgroundResource(b.e.folded_recycler_view_bg);
    localObject1 = this.xUj;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject1 = this.xUj;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    Object localObject2 = getContext();
    p.j(localObject2, "context");
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)localObject2, (byte)0));
    this.xnR = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new c(this), this.mXB, true);
    localObject1 = this.xUj;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    localObject2 = this.xnR;
    if (localObject2 == null) {
      p.bGy("adapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.xUj;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    ((WxRecyclerView)localObject1).b(getItemDecoration());
    localObject1 = aj.Bnu;
    localObject1 = getContext();
    p.j(localObject1, "context");
    localObject1 = aj.a.fZ((Context)localObject1);
    if (localObject1 != null)
    {
      localObject2 = this.xnR;
      if (localObject2 == null) {
        p.bGy("adapter");
      }
      p.k(localObject2, "adapter");
      d.uiThread((kotlin.g.a.a)new aj.b((aj)localObject1, (WxRecyclerAdapter)localObject2));
      AppMethodBeat.o(277655);
      return;
    }
    AppMethodBeat.o(277655);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter()
  {
    AppMethodBeat.i(277648);
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    AppMethodBeat.o(277648);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(277659);
    RecyclerView.h localh = (RecyclerView.h)new f(this);
    AppMethodBeat.o(277659);
    return localh;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(277651);
    WxRecyclerView localWxRecyclerView = this.xUj;
    if (localWxRecyclerView == null) {
      p.bGy("recyclerView");
    }
    AppMethodBeat.o(277651);
    return localWxRecyclerView;
  }
  
  public final void setAdapter(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(277650);
    p.k(paramWxRecyclerAdapter, "<set-?>");
    this.xnR = paramWxRecyclerAdapter;
    AppMethodBeat.o(277650);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(277653);
    p.k(paramWxRecyclerView, "<set-?>");
    this.xUj = paramWxRecyclerView;
    AppMethodBeat.o(277653);
  }
  
  public final void setup(v paramv)
  {
    Object localObject2 = null;
    AppMethodBeat.i(277657);
    p.k(paramv, "presenter");
    this.AXN = paramv;
    this.AXM = paramv.dpz();
    this.mXB.clear();
    List localList = paramv.eiH();
    StringBuilder localStringBuilder = new StringBuilder("steup foldedlayout ");
    Object localObject1 = paramv.eiG();
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 != null)
      {
        localObject1 = ((FinderItem)localObject1).getDebugDescription();
        localStringBuilder = localStringBuilder.append((String)localObject1).append(' ');
        localObject1 = paramv.eiG();
        if (localObject1 == null) {
          break label258;
        }
      }
    }
    label258:
    for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      Object localObject3 = (BaseFinderFeed)j.M(localList, 0);
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
      this.mXB.addAll((Collection)localList);
      if (paramv.aDl()) {
        this.mXB.add(this.AXL);
      }
      paramv = this.xUj;
      if (paramv == null) {
        p.bGy("recyclerView");
      }
      paramv = paramv.getLayoutManager();
      if (paramv != null) {
        break label263;
      }
      paramv = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(277657);
      throw paramv;
      localObject1 = null;
      break;
    }
    label263:
    ((FinderLinearLayoutManager)paramv).au(0, 0);
    paramv = this.xUj;
    if (paramv == null) {
      p.bGy("recyclerView");
    }
    paramv = paramv.getAdapter();
    if (paramv != null)
    {
      paramv.notifyDataSetChanged();
      AppMethodBeat.o(277657);
      return;
    }
    AppMethodBeat.o(277657);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$Companion;", "", "()V", "clickFeedItemId", "", "getClickFeedItemId", "()J", "setClickFeedItemId", "(J)V", "clickFeedItemTimestamp", "getClickFeedItemTimestamp", "setClickFeedItemTimestamp", "clickFoldedTopTimestamp", "getClickFoldedTopTimestamp", "setClickFoldedTopTimestamp", "clickMoreTimestamp", "getClickMoreTimestamp", "setClickMoreTimestamp", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "", "getItemLayoutType", "", "getLayoutParam", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract ConstraintLayout.LayoutParams dpx();
    
    public abstract boolean dpy();
    
    public abstract int dpz();
    
    public abstract void j(i parami);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(269016);
      switch (paramInt)
      {
      default: 
        locale = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(269016);
        return locale;
      case 4: 
        locale = (e)new cu((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.AXU));
        AppMethodBeat.o(269016);
        return locale;
      case 2: 
        locale = (e)new as((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.AXU));
        AppMethodBeat.o(269016);
        return locale;
      }
      e locale = (e)new cm((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(269016);
      return locale;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class d
    implements FinderFoldedScrollLayout.b
  {
    public final ConstraintLayout.LayoutParams dpx()
    {
      AppMethodBeat.i(227230);
      FinderFoldedScrollLayout.b(this.AXU);
      AppMethodBeat.o(227230);
      return null;
    }
    
    public final boolean dpy()
    {
      AppMethodBeat.i(227231);
      FinderFoldedScrollLayout.b(this.AXU);
      AppMethodBeat.o(227231);
      return false;
    }
    
    public final int dpz()
    {
      AppMethodBeat.i(227233);
      v localv = FinderFoldedScrollLayout.b(this.AXU);
      if (localv != null)
      {
        int i = localv.dpz();
        AppMethodBeat.o(227233);
        return i;
      }
      AppMethodBeat.o(227233);
      return 1;
    }
    
    public final void j(i parami)
    {
      AppMethodBeat.i(227227);
      p.k(parami, "holder");
      int i = parami.mc();
      parami = FinderFoldedScrollLayout.b(this.AXU);
      if (parami != null)
      {
        Context localContext = this.AXU.getContext();
        p.j(localContext, "context");
        parami.as(localContext, i);
        AppMethodBeat.o(227227);
        return;
      }
      AppMethodBeat.o(227227);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.a
  {
    public final int bAQ()
    {
      return -100;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(260161);
      long l = hashCode();
      AppMethodBeat.o(260161);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(271663);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(b.d.Edge_1_5_A);
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(b.d.finder_0_25_A);
      FinderFoldedScrollLayout.b(this.AXU);
      j = Math.max(j, 0);
      int k = RecyclerView.bh(paramView);
      if (k == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(271663);
        return;
      }
      if (k == FinderFoldedScrollLayout.c(this.AXU).size() - 1)
      {
        paramRect.left = j;
        paramRect.right = i;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(271663);
        return;
      }
      paramRect.left = j;
      paramRect.right = j;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(271663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout
 * JD-Core Version:    0.7.0.1
 */