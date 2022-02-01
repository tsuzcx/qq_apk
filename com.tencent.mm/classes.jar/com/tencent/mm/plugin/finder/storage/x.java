package com.tencent.mm.plugin.finder.storage;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.bc;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.s;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "spanCount", "", "getSpanCount", "()I", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class x
  implements z
{
  private final int atv = 2;
  
  public final c B(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(203747);
    paramb = (c)new a(paramb);
    AppMethodBeat.o(203747);
    return paramb;
  }
  
  public final c cBj()
  {
    AppMethodBeat.i(203746);
    c localc = B(null);
    AppMethodBeat.o(203746);
    return localc;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(203743);
    p.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.atv);
    paramContext.aw(true);
    paramContext = (RecyclerView.i)paramContext;
    AppMethodBeat.o(203743);
    return paramContext;
  }
  
  public final RecyclerView.n f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(203748);
    p.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderRecyclerViewPool.class)).sZE;
    AppMethodBeat.o(203748);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(203745);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(203745);
    return localh;
  }
  
  public final RecyclerView.w q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203744);
    p.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494094, paramViewGroup, false);
    p.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.w)new bc(paramViewGroup);
    AppMethodBeat.o(203744);
    return paramViewGroup;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(203741);
      switch (paramInt)
      {
      default: 
        localObject = this.sxW;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          p.gfZ();
          localObject = null;
        }
        AppMethodBeat.o(203741);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.x();
        AppMethodBeat.o(203741);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.l();
        AppMethodBeat.o(203741);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new s();
        AppMethodBeat.o(203741);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new o();
      AppMethodBeat.o(203741);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(203742);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRect);
      localb.bd(paramView);
      localb.bd(paramRecyclerView);
      localb.bd(paramt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.ahq());
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165274);
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166296);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(203742);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mG())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V");
        AppMethodBeat.o(203742);
        return;
        paramView = paramView.getLayoutParams();
        if (paramView == null)
        {
          paramRect = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
          AppMethodBeat.o(203742);
          throw paramRect;
        }
        if (((StaggeredGridLayoutManager.LayoutParams)paramView).mH() % 2 == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.x
 * JD-Core Version:    0.7.0.1
 */