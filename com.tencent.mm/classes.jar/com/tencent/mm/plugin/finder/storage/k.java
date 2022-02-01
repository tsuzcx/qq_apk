package com.tencent.mm.plugin.finder.storage;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.aq;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import d.v;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "spanCount", "", "getSpanCount", "()I", "bindConvert", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class k
  implements r
{
  private final int arE = 2;
  
  public final c A(final d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(202981);
    paramb = (c)new a(this, paramb);
    AppMethodBeat.o(202981);
    return paramb;
  }
  
  public final c cuS()
  {
    AppMethodBeat.i(202980);
    c localc = A(null);
    AppMethodBeat.o(202980);
    return localc;
  }
  
  public final RecyclerView.n e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202983);
    d.g.b.k.h(paramMMActivity, "context");
    a locala = a.IrY;
    paramMMActivity = ((FinderRecyclerViewPool)a.q(paramMMActivity).get(FinderRecyclerViewPool.class)).scl;
    AppMethodBeat.o(202983);
    return paramMMActivity;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(202977);
    d.g.b.k.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.arE);
    paramContext.aw(true);
    paramContext = (RecyclerView.i)paramContext;
    AppMethodBeat.o(202977);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202979);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(202979);
    return localh;
  }
  
  public final RecyclerView.w q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202978);
    d.g.b.k.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494094, paramViewGroup, false);
    d.g.b.k.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.w)new aq(paramViewGroup);
    AppMethodBeat.o(202978);
    return paramViewGroup;
  }
  
  public final boolean x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202982);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    Object localObject = paramRecyclerView.getLayoutManager();
    if (localObject == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(202982);
      throw paramRecyclerView;
    }
    localObject = ((StaggeredGridLayoutManager)localObject).mj();
    int i = Math.max(localObject[0], localObject[1]);
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1))
    {
      AppMethodBeat.o(202982);
      return true;
    }
    AppMethodBeat.o(202982);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(202975);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).ay(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          d.g.b.k.fOy();
          localObject = null;
        }
        AppMethodBeat.o(202975);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new a(this);
        AppMethodBeat.o(202975);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new b(this);
        AppMethodBeat.o(202975);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.r();
        AppMethodBeat.o(202975);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new n();
        AppMethodBeat.o(202975);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new af();
      AppMethodBeat.o(202975);
      return localObject;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends w
    {
      public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(202971);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramBaseFinderFeed, "item");
        super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        k.c(parame, paramBaseFinderFeed);
        AppMethodBeat.o(202971);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends com.tencent.mm.plugin.finder.convert.k
    {
      public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(202973);
        d.g.b.k.h(parame, "holder");
        d.g.b.k.h(paramBaseFinderFeed, "item");
        super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        k.c(parame, paramBaseFinderFeed);
        AppMethodBeat.o(202973);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(202976);
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(paramt, "state");
      paramRecyclerView = paramView.getContext();
      d.g.b.k.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165274);
      paramRecyclerView = paramView.getContext();
      d.g.b.k.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166296);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(202976);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mo())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(202976);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(202976);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).mp() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(202976);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(202976);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k
 * JD-Core Version:    0.7.0.1
 */