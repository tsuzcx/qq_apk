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
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "spanCount", "", "getSpanCount", "()I", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class p
  implements r
{
  private final int arE = 2;
  
  public final c A(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(202997);
    paramb = (c)new a(paramb);
    AppMethodBeat.o(202997);
    return paramb;
  }
  
  public final c cuS()
  {
    AppMethodBeat.i(202996);
    c localc = A(null);
    AppMethodBeat.o(202996);
    return localc;
  }
  
  public final RecyclerView.n e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202999);
    d.g.b.k.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderRecyclerViewPool.class)).scl;
    AppMethodBeat.o(202999);
    return paramMMActivity;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(202993);
    d.g.b.k.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.arE);
    paramContext.aw(true);
    paramContext = (RecyclerView.i)paramContext;
    AppMethodBeat.o(202993);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202995);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(202995);
    return localh;
  }
  
  public final RecyclerView.w q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202994);
    d.g.b.k.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494094, paramViewGroup, false);
    d.g.b.k.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.w)new aq(paramViewGroup);
    AppMethodBeat.o(202994);
    return paramViewGroup;
  }
  
  public final boolean x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202998);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    Object localObject = paramRecyclerView.getLayoutManager();
    if (localObject == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(202998);
      throw paramRecyclerView;
    }
    localObject = ((StaggeredGridLayoutManager)localObject).mj();
    int i = Math.max(localObject[0], localObject[1]);
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1))
    {
      AppMethodBeat.o(202998);
      return true;
    }
    AppMethodBeat.o(202998);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(202991);
      switch (paramInt)
      {
      default: 
        localObject = this.rDn;
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
        AppMethodBeat.o(202991);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new w();
        AppMethodBeat.o(202991);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.k();
        AppMethodBeat.o(202991);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.r();
        AppMethodBeat.o(202991);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new n();
        AppMethodBeat.o(202991);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new af();
      AppMethodBeat.o(202991);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(202992);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRect);
      localb.bb(paramView);
      localb.bb(paramRecyclerView);
      localb.bb(paramt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.aeE());
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
        AppMethodBeat.o(202992);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mo())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V");
        AppMethodBeat.o(202992);
        return;
        paramView = paramView.getLayoutParams();
        if (paramView == null)
        {
          paramRect = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
          AppMethodBeat.o(202992);
          throw paramRect;
        }
        if (((StaggeredGridLayoutManager.LayoutParams)paramView).mp() % 2 == 0)
        {
          paramRect.left = i;
          paramRect.right = j;
          paramRect.bottom = j;
          paramRect.top = j;
        }
        else
        {
          paramRect.left = j;
          paramRect.right = i;
          paramRect.bottom = j;
          paramRect.top = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.p
 * JD-Core Version:    0.7.0.1
 */