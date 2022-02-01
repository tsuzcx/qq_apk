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
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.v.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "gridSpanCount", "", "getGridSpanCount", "()I", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getSpanSizeLookup", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class n
  implements v
{
  final int KNS = 3;
  
  public final boolean A(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(198983);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    RecyclerView.i locali = paramRecyclerView.getLayoutManager();
    if (locali == null)
    {
      paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
      AppMethodBeat.o(198983);
      throw paramRecyclerView;
    }
    int i = ((GridLayoutManager)locali).jR();
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1))
    {
      AppMethodBeat.o(198983);
      return true;
    }
    AppMethodBeat.o(198983);
    return false;
  }
  
  public final RecyclerView.v B(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(198979);
    d.g.b.k.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496207, paramViewGroup, false);
    d.g.b.k.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.v)new af(paramViewGroup);
    AppMethodBeat.o(198979);
    return paramViewGroup;
  }
  
  public final c H(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(198982);
    paramb = (c)new a(paramb);
    AppMethodBeat.o(198982);
    return paramb;
  }
  
  public final RecyclerView.n f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(198984);
    d.g.b.k.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderRecyclerViewPool.class)).Lhq;
    AppMethodBeat.o(198984);
    return paramMMActivity;
  }
  
  public final c fTj()
  {
    AppMethodBeat.i(198981);
    c localc = H(null);
    AppMethodBeat.o(198981);
    return localc;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(198980);
    RecyclerView.h localh = (RecyclerView.h)new b(this);
    AppMethodBeat.o(198980);
    return localh;
  }
  
  public final RecyclerView.i lw(Context paramContext)
  {
    AppMethodBeat.i(198978);
    d.g.b.k.h(paramContext, "context");
    paramContext = new v.e();
    paramContext.Jhw = new GridLayoutManager(this.KNS);
    ((GridLayoutManager)paramContext.Jhw).a((GridLayoutManager.b)new c(paramContext));
    ((GridLayoutManager)paramContext.Jhw).aw(true);
    paramContext = (RecyclerView.i)paramContext.Jhw;
    AppMethodBeat.o(198978);
    return paramContext;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(198975);
      switch (paramInt)
      {
      case -1: 
      case 0: 
      case 1: 
      case 3: 
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
        AppMethodBeat.o(198975);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new p();
        AppMethodBeat.o(198975);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new p();
        AppMethodBeat.o(198975);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.n();
        AppMethodBeat.o(198975);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.k();
      AppMethodBeat.o(198975);
      return localObject;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(198976);
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(params, "state");
      params = paramView.getContext();
      d.g.b.k.g(params, "view.context");
      params.getResources().getDimension(2131165274);
      int i = com.tencent.mm.cd.a.g(paramView.getContext(), 0.5F);
      int j = RecyclerView.bw(paramView);
      if (j == 0)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(198976);
        return;
      }
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.g(paramView, "parent.adapter!!");
      if (j >= paramView.getItemCount())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(198976);
        return;
      }
      j -= 1;
      if (j % this.KWw.KNS == 0)
      {
        paramRect.left = 0;
        paramRect.right = i;
        paramRect.bottom = i;
        paramRect.top = i;
        AppMethodBeat.o(198976);
        return;
      }
      if (j % this.KWw.KNS == this.KWw.KNS - 1)
      {
        paramRect.left = i;
        paramRect.right = 0;
        paramRect.bottom = i;
        paramRect.top = i;
        AppMethodBeat.o(198976);
        return;
      }
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(198976);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(v.e parame) {}
    
    public final int bW(int paramInt)
    {
      AppMethodBeat.i(198977);
      if (paramInt == 0)
      {
        Object localObject = (GridLayoutManager)this.KWx.Jhw;
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(198977);
          throw ((Throwable)localObject);
        }
        paramInt = ((GridLayoutManager)localObject).jB();
        AppMethodBeat.o(198977);
        return paramInt;
      }
      AppMethodBeat.o(198977);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.n
 * JD-Core Version:    0.7.0.1
 */