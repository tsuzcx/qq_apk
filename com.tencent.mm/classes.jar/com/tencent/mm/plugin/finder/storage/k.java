package com.tencent.mm.plugin.finder.storage;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.aa;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.s;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "gridSpanCount", "", "getGridSpanCount", "()I", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getSpanSizeLookup", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class k
  implements z
{
  final int rXt = 3;
  
  public final com.tencent.mm.view.recyclerview.c B(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(203671);
    paramb = (com.tencent.mm.view.recyclerview.c)new a(paramb);
    AppMethodBeat.o(203671);
    return paramb;
  }
  
  public final com.tencent.mm.view.recyclerview.c cBj()
  {
    AppMethodBeat.i(203670);
    com.tencent.mm.view.recyclerview.c localc = B(null);
    AppMethodBeat.o(203670);
    return localc;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(203667);
    p.h(paramContext, "context");
    paramContext = new y.f();
    paramContext.MLV = new GridLayoutManager(this.rXt);
    ((GridLayoutManager)paramContext.MLV).a((GridLayoutManager.b)new c(paramContext));
    ((GridLayoutManager)paramContext.MLV).aw(true);
    paramContext = (RecyclerView.i)paramContext.MLV;
    AppMethodBeat.o(203667);
    return paramContext;
  }
  
  public final RecyclerView.n f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(203672);
    p.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderRecyclerViewPool.class)).sZF;
    AppMethodBeat.o(203672);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(203669);
    RecyclerView.h localh = (RecyclerView.h)new b(this);
    AppMethodBeat.o(203669);
    return localh;
  }
  
  public final RecyclerView.w q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203668);
    p.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496208, paramViewGroup, false);
    p.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.w)new aa(paramViewGroup);
    AppMethodBeat.o(203668);
    return paramViewGroup;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(203664);
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
        AppMethodBeat.o(203664);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.c();
        AppMethodBeat.o(203664);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.c();
        AppMethodBeat.o(203664);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new s();
        AppMethodBeat.o(203664);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new o();
      AppMethodBeat.o(203664);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(203665);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      paramt = paramView.getContext();
      p.g(paramt, "view.context");
      paramt.getResources().getDimension(2131165274);
      int i = com.tencent.mm.cc.a.g(paramView.getContext(), 0.5F);
      int j = RecyclerView.bw(paramView);
      if (j == 0)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(203665);
        return;
      }
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null) {
        p.gfZ();
      }
      p.g(paramView, "parent.adapter!!");
      if (j >= paramView.getItemCount())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(203665);
        return;
      }
      j -= 1;
      if (j % this.sxX.rXt == 0)
      {
        paramRect.left = 0;
        paramRect.right = i;
        paramRect.bottom = i;
        paramRect.top = i;
        AppMethodBeat.o(203665);
        return;
      }
      if (j % this.sxX.rXt == this.sxX.rXt - 1)
      {
        paramRect.left = i;
        paramRect.right = 0;
        paramRect.bottom = i;
        paramRect.top = i;
        AppMethodBeat.o(203665);
        return;
      }
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(203665);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(y.f paramf) {}
    
    public final int bW(int paramInt)
    {
      AppMethodBeat.i(203666);
      if (paramInt == 0)
      {
        Object localObject = (GridLayoutManager)this.sxY.MLV;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(203666);
          throw ((Throwable)localObject);
        }
        paramInt = ((GridLayoutManager)localObject).jZ();
        AppMethodBeat.o(203666);
        return paramInt;
      }
      AppMethodBeat.o(203666);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k
 * JD-Core Version:    0.7.0.1
 */