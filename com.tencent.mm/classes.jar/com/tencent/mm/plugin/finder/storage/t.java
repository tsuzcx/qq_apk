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
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.h;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.s;
import com.tencent.mm.plugin.finder.convert.y;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "spanCount", "", "getSpanCount", "()I", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class t
  implements v
{
  private final int aqI = 2;
  
  public final boolean A(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(199034);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    Object localObject = paramRecyclerView.getLayoutManager();
    if (localObject == null)
    {
      paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(199034);
      throw paramRecyclerView;
    }
    localObject = ((StaggeredGridLayoutManager)localObject).mb();
    int i = Math.max(localObject[0], localObject[1]);
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1))
    {
      AppMethodBeat.o(199034);
      return true;
    }
    AppMethodBeat.o(199034);
    return false;
  }
  
  public final RecyclerView.v B(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(199030);
    d.g.b.k.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494094, paramViewGroup, false);
    d.g.b.k.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.v)new y(paramViewGroup);
    AppMethodBeat.o(199030);
    return paramViewGroup;
  }
  
  public final c H(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(199033);
    paramb = (c)new a(paramb);
    AppMethodBeat.o(199033);
    return paramb;
  }
  
  public final RecyclerView.n f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(199035);
    d.g.b.k.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderRecyclerViewPool.class)).Lhp;
    AppMethodBeat.o(199035);
    return paramMMActivity;
  }
  
  public final c fTj()
  {
    AppMethodBeat.i(199032);
    c localc = H(null);
    AppMethodBeat.o(199032);
    return localc;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(199031);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(199031);
    return localh;
  }
  
  public final RecyclerView.i lw(Context paramContext)
  {
    AppMethodBeat.i(199029);
    d.g.b.k.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.aqI);
    paramContext.aw(true);
    paramContext = (RecyclerView.i)paramContext;
    AppMethodBeat.o(199029);
    return paramContext;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(199027);
      switch (paramInt)
      {
      default: 
        localObject = this.KWv;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).aA(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          d.g.b.k.fvU();
          localObject = null;
        }
        AppMethodBeat.o(199027);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new s();
        AppMethodBeat.o(199027);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new h();
        AppMethodBeat.o(199027);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new n();
        AppMethodBeat.o(199027);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.k();
        AppMethodBeat.o(199027);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new am();
      AppMethodBeat.o(199027);
      return localObject;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(199028);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRect);
      localb.be(paramView);
      localb.be(paramRecyclerView);
      localb.be(params);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.ado());
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(params, "state");
      paramRecyclerView = paramView.getContext();
      d.g.b.k.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165274);
      paramRecyclerView = paramView.getContext();
      d.g.b.k.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166296);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new d.v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(199028);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).lY())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V");
        AppMethodBeat.o(199028);
        return;
        paramView = paramView.getLayoutParams();
        if (paramView == null)
        {
          paramRect = new d.v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
          AppMethodBeat.o(199028);
          throw paramRect;
        }
        if (((StaggeredGridLayoutManager.LayoutParams)paramView).mg() % 2 == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.t
 * JD-Core Version:    0.7.0.1
 */