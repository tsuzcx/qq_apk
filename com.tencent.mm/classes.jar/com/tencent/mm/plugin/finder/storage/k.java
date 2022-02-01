package com.tencent.mm.plugin.finder.storage;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.aa;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.s;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.b.p;
import d.g.b.y.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "gridSpanCount", "", "getGridSpanCount", "()I", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getSpanSizeLookup", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class k
  implements z
{
  final int sge = 3;
  
  public final com.tencent.mm.view.recyclerview.c B(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb)
  {
    AppMethodBeat.i(204238);
    paramb = (com.tencent.mm.view.recyclerview.c)new a(paramb);
    AppMethodBeat.o(204238);
    return paramb;
  }
  
  public final com.tencent.mm.view.recyclerview.c cCV()
  {
    AppMethodBeat.i(204237);
    com.tencent.mm.view.recyclerview.c localc = B(null);
    AppMethodBeat.o(204237);
    return localc;
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(204234);
    p.h(paramContext, "context");
    paramContext = new y.f();
    paramContext.NiY = new GridLayoutManager(this.sge);
    ((GridLayoutManager)paramContext.NiY).a((GridLayoutManager.b)new k.c(paramContext));
    ((GridLayoutManager)paramContext.NiY).aw(true);
    paramContext = (RecyclerView.i)paramContext.NiY;
    AppMethodBeat.o(204234);
    return paramContext;
  }
  
  public final RecyclerView.n f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(204239);
    p.h(paramMMActivity, "context");
    a locala = a.KEX;
    paramMMActivity = ((FinderRecyclerViewPool)a.s(paramMMActivity).get(FinderRecyclerViewPool.class)).tkT;
    AppMethodBeat.o(204239);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(204236);
    RecyclerView.h localh = (RecyclerView.h)new k.b(this);
    AppMethodBeat.o(204236);
    return localh;
  }
  
  public final RecyclerView.w q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204235);
    p.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496208, paramViewGroup, false);
    p.g(paramViewGroup, "convertView");
    paramViewGroup = (RecyclerView.w)new aa(paramViewGroup);
    AppMethodBeat.o(204235);
    return paramViewGroup;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(204231);
      switch (paramInt)
      {
      default: 
        localObject = this.sIN;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          p.gkB();
          localObject = null;
        }
        AppMethodBeat.o(204231);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.c();
        AppMethodBeat.o(204231);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.c();
        AppMethodBeat.o(204231);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new s();
        AppMethodBeat.o(204231);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new o();
      AppMethodBeat.o(204231);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k
 * JD-Core Version:    0.7.0.1
 */