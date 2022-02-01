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
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "gridSpanCount", "", "getGridSpanCount", "()I", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getSpanSizeLookup", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class h
  implements r
{
  final int rjc = 3;
  
  public final com.tencent.mm.view.recyclerview.c A(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(202945);
    paramb = (com.tencent.mm.view.recyclerview.c)new a(paramb);
    AppMethodBeat.o(202945);
    return paramb;
  }
  
  public final com.tencent.mm.view.recyclerview.c cuS()
  {
    AppMethodBeat.i(202944);
    com.tencent.mm.view.recyclerview.c localc = A(null);
    AppMethodBeat.o(202944);
    return localc;
  }
  
  public final RecyclerView.n e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202947);
    k.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderRecyclerViewPool.class)).scm;
    AppMethodBeat.o(202947);
    return paramMMActivity;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(202941);
    k.h(paramContext, "context");
    paramContext = new v.f();
    paramContext.KUQ = new GridLayoutManager(this.rjc);
    ((GridLayoutManager)paramContext.KUQ).a((GridLayoutManager.b)new c(paramContext));
    ((GridLayoutManager)paramContext.KUQ).aw(true);
    paramContext = (RecyclerView.i)paramContext.KUQ;
    AppMethodBeat.o(202941);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202943);
    RecyclerView.h localh = (RecyclerView.h)new b(this);
    AppMethodBeat.o(202943);
    return localh;
  }
  
  public final RecyclerView.w q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202942);
    k.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496208, paramViewGroup, false);
    k.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.w)new y(paramViewGroup);
    AppMethodBeat.o(202942);
    return paramViewGroup;
  }
  
  public final boolean x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(202946);
    k.h(paramRecyclerView, "recyclerView");
    RecyclerView.i locali = paramRecyclerView.getLayoutManager();
    if (locali == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
      AppMethodBeat.o(202946);
      throw paramRecyclerView;
    }
    int i = ((GridLayoutManager)locali).jZ();
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && (i == paramRecyclerView.getItemCount() - 1))
    {
      AppMethodBeat.o(202946);
      return true;
    }
    AppMethodBeat.o(202946);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(202938);
      switch (paramInt)
      {
      case -1: 
      case 0: 
      case 1: 
      case 3: 
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
          k.fOy();
          localObject = null;
        }
        AppMethodBeat.o(202938);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.c();
        AppMethodBeat.o(202938);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.c();
        AppMethodBeat.o(202938);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.r();
        AppMethodBeat.o(202938);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new n();
      AppMethodBeat.o(202938);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(202939);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(paramt, "state");
      paramt = paramView.getContext();
      k.g(paramt, "view.context");
      paramt.getResources().getDimension(2131165274);
      int i = com.tencent.mm.cc.a.g(paramView.getContext(), 0.5F);
      int j = RecyclerView.bw(paramView);
      if (j == 0)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(202939);
        return;
      }
      paramView = paramRecyclerView.getAdapter();
      if (paramView == null) {
        k.fOy();
      }
      k.g(paramView, "parent.adapter!!");
      if (j >= paramView.getItemCount())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(202939);
        return;
      }
      j -= 1;
      if (j % this.rDo.rjc == 0)
      {
        paramRect.left = 0;
        paramRect.right = i;
        paramRect.bottom = i;
        paramRect.top = i;
        AppMethodBeat.o(202939);
        return;
      }
      if (j % this.rDo.rjc == this.rDo.rjc - 1)
      {
        paramRect.left = i;
        paramRect.right = 0;
        paramRect.bottom = i;
        paramRect.top = i;
        AppMethodBeat.o(202939);
        return;
      }
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = i;
      paramRect.top = i;
      AppMethodBeat.o(202939);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(v.f paramf) {}
    
    public final int bW(int paramInt)
    {
      AppMethodBeat.i(202940);
      if (paramInt == 0)
      {
        Object localObject = (GridLayoutManager)this.rDp.KUQ;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(202940);
          throw ((Throwable)localObject);
        }
        paramInt = ((GridLayoutManager)localObject).jJ();
        AppMethodBeat.o(202940);
        return paramInt;
      }
      AppMethodBeat.o(202940);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.h
 * JD-Core Version:    0.7.0.1
 */