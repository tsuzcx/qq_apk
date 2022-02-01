package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout.LayoutParams;
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
import com.tencent.mm.plugin.finder.convert.bf;
import com.tencent.mm.plugin.finder.convert.bi;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.b;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FOOTER_COUNT", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "foldedController", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1;", "footerData", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1;", "itemLayoutType", "presenter", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initView", "", "setup", "Companion", "FoldedController", "plugin-finder_release"})
public final class FinderFoldedScrollLayout
  extends FrameLayout
{
  private static long tfF;
  private static long tfG;
  private static long tfH;
  private static long tfI;
  public static final FinderFoldedScrollLayout.a tfJ;
  private ArrayList<com.tencent.mm.view.recyclerview.a> jhZ;
  public WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> rXV;
  public WxRecyclerView tfA;
  private final FinderFoldedScrollLayout.e tfB;
  private int tfC;
  private n tfD;
  private final d tfE;
  private final int tfz;
  
  static
  {
    AppMethodBeat.i(205788);
    tfJ = new FinderFoldedScrollLayout.a((byte)0);
    AppMethodBeat.o(205788);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205786);
    this.tfz = 1;
    this.jhZ = new ArrayList();
    this.tfB = new FinderFoldedScrollLayout.e();
    this.tfE = new d(this);
    initView();
    AppMethodBeat.o(205786);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205787);
    this.tfz = 1;
    this.jhZ = new ArrayList();
    this.tfB = new FinderFoldedScrollLayout.e();
    this.tfE = new d(this);
    initView();
    AppMethodBeat.o(205787);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(205783);
    Object localObject = getContext();
    p.g(localObject, "context");
    this.tfA = new WxRecyclerView((Context)localObject);
    localObject = this.tfA;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((WxRecyclerView)localObject).setBackgroundResource(2131234898);
    localObject = this.tfA;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject = this.tfA;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.i)new FinderLayoutManager());
    this.rXV = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new c(this), this.jhZ, true);
    localObject = this.tfA;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    WxRecyclerAdapter localWxRecyclerAdapter = this.rXV;
    if (localWxRecyclerAdapter == null) {
      p.bdF("adapter");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)localWxRecyclerAdapter);
    localObject = this.tfA;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((WxRecyclerView)localObject).b(getItemDecoration());
    localObject = FinderReporterUIC.tnG;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.fc((Context)localObject);
    if (localObject != null)
    {
      localWxRecyclerAdapter = this.rXV;
      if (localWxRecyclerAdapter == null) {
        p.bdF("adapter");
      }
      p.h(localWxRecyclerAdapter, "adapter");
      com.tencent.mm.ac.c.h((d.g.a.a)new FinderReporterUIC.b((FinderReporterUIC)localObject, localWxRecyclerAdapter));
      AppMethodBeat.o(205783);
      return;
    }
    AppMethodBeat.o(205783);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter()
  {
    AppMethodBeat.i(205779);
    WxRecyclerAdapter localWxRecyclerAdapter = this.rXV;
    if (localWxRecyclerAdapter == null) {
      p.bdF("adapter");
    }
    AppMethodBeat.o(205779);
    return localWxRecyclerAdapter;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(205785);
    RecyclerView.h localh = (RecyclerView.h)new f(this);
    AppMethodBeat.o(205785);
    return localh;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(205781);
    WxRecyclerView localWxRecyclerView = this.tfA;
    if (localWxRecyclerView == null) {
      p.bdF("recyclerView");
    }
    AppMethodBeat.o(205781);
    return localWxRecyclerView;
  }
  
  public final void setAdapter(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(205780);
    p.h(paramWxRecyclerAdapter, "<set-?>");
    this.rXV = paramWxRecyclerAdapter;
    AppMethodBeat.o(205780);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(205782);
    p.h(paramWxRecyclerView, "<set-?>");
    this.tfA = paramWxRecyclerView;
    AppMethodBeat.o(205782);
  }
  
  public final void setup(n paramn)
  {
    Object localObject2 = null;
    AppMethodBeat.i(205784);
    p.h(paramn, "presenter");
    this.tfD = paramn;
    this.tfC = paramn.cPV();
    this.jhZ.clear();
    List localList = paramn.cPU();
    StringBuilder localStringBuilder = new StringBuilder("steup foldedlayout ");
    Object localObject1 = paramn.cPT();
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 != null)
      {
        localObject1 = ((FinderItem)localObject1).getDebugDescription();
        localStringBuilder = localStringBuilder.append((String)localObject1).append(' ');
        localObject1 = paramn.cPT();
        if (localObject1 == null) {
          break label258;
        }
      }
    }
    label258:
    for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      Object localObject3 = (BaseFinderFeed)j.F(localList, 0);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((BaseFinderFeed)localObject3).feedObject;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((FinderItem)localObject3).getDebugDescription();
        }
      }
      ae.i("Finder.FinderFoldedScrollLayout", (String)localObject1);
      this.jhZ.addAll((Collection)localList);
      if (paramn.cPW()) {
        this.jhZ.add(this.tfB);
      }
      paramn = this.tfA;
      if (paramn == null) {
        p.bdF("recyclerView");
      }
      paramn = paramn.getLayoutManager();
      if (paramn != null) {
        break label263;
      }
      paramn = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
      AppMethodBeat.o(205784);
      throw paramn;
      localObject1 = null;
      break;
    }
    label263:
    ((FinderLayoutManager)paramn).ag(0, 0);
    paramn = this.tfA;
    if (paramn == null) {
      p.bdF("recyclerView");
    }
    paramn = paramn.getAdapter();
    if (paramn != null)
    {
      paramn.notifyDataSetChanged();
      AppMethodBeat.o(205784);
      return;
    }
    AppMethodBeat.o(205784);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract int cPV();
    
    public abstract ConstraintLayout.LayoutParams cPX();
    
    public abstract void g(e parame);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(205773);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.b();
        AppMethodBeat.o(205773);
        return localb;
      case 4: 
        localb = (com.tencent.mm.view.recyclerview.b)new bi((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.tfK));
        AppMethodBeat.o(205773);
        return localb;
      case 2: 
        localb = (com.tencent.mm.view.recyclerview.b)new ac((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.tfK));
        AppMethodBeat.o(205773);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new bf((d.g.a.a)new a(this));
      AppMethodBeat.o(205773);
      return localb;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class d
    implements FinderFoldedScrollLayout.b
  {
    public final int cPV()
    {
      AppMethodBeat.i(205776);
      n localn = FinderFoldedScrollLayout.b(this.tfK);
      if (localn != null)
      {
        int i = localn.cPV();
        AppMethodBeat.o(205776);
        return i;
      }
      AppMethodBeat.o(205776);
      return 1;
    }
    
    public final ConstraintLayout.LayoutParams cPX()
    {
      AppMethodBeat.i(205775);
      Object localObject = FinderFoldedScrollLayout.b(this.tfK);
      if (localObject != null)
      {
        localObject = ((n)localObject).cPX();
        AppMethodBeat.o(205775);
        return localObject;
      }
      AppMethodBeat.o(205775);
      return null;
    }
    
    public final void g(e parame)
    {
      AppMethodBeat.i(205774);
      p.h(parame, "holder");
      int i = parame.lM();
      parame = FinderFoldedScrollLayout.b(this.tfK);
      if (parame != null)
      {
        Context localContext = this.tfK.getContext();
        p.g(localContext, "context");
        parame.Z(localContext, i);
        AppMethodBeat.o(205774);
        return;
      }
      AppMethodBeat.o(205774);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(205778);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131165284);
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int k = (int)paramRecyclerView.getResources().getDimension(2131166296);
      paramRecyclerView = FinderFoldedScrollLayout.b(this.tfK);
      if (paramRecyclerView != null) {}
      for (int i = paramRecyclerView.cPY();; i = 0)
      {
        i = Math.max(k, i);
        k = RecyclerView.bw(paramView);
        if (k != 0) {
          break;
        }
        paramRect.left = j;
        paramRect.right = i;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(205778);
        return;
      }
      if (k == FinderFoldedScrollLayout.c(this.tfK).size() - 1)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(205778);
        return;
      }
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(205778);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout
 * JD-Core Version:    0.7.0.1
 */