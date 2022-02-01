package com.tencent.mm.plugin.finder.storage;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "spanCount", "", "getSpanCount", "()I", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class ah
  extends al
{
  private final int att = 2;
  
  public final com.tencent.mm.view.recyclerview.f G(final kotlin.g.a.b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(251874);
    paramb = (com.tencent.mm.view.recyclerview.f)new a(this, paramb);
    AppMethodBeat.o(251874);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(251872);
    p.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.att);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(251872);
    return paramContext;
  }
  
  public final RecyclerView.m f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(251875);
    p.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramMMActivity).get(FinderRecyclerViewPool.class)).wuw;
    AppMethodBeat.o(251875);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(251873);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(251873);
    return localh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(kotlin.g.a.b paramb) {}
    
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(251870);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null)
        {
          e locale = (e)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = y.vXH;
          y.dQ("FinderStaggeredConfig", paramInt);
          localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        }
        AppMethodBeat.o(251870);
        return localObject;
      case 4: 
      case 9: 
      case 3002: 
        localObject = (e)new com.tencent.mm.plugin.finder.convert.al();
        AppMethodBeat.o(251870);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new v();
        AppMethodBeat.o(251870);
        return localObject;
      case -3: 
        localObject = (e)new ag();
        AppMethodBeat.o(251870);
        return localObject;
      }
      Object localObject = (e)new ab();
      AppMethodBeat.o(251870);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(251871);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRect);
      localb.bm(paramView);
      localb.bm(paramRecyclerView);
      localb.bm(params);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.axR());
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165277);
      paramRecyclerView = paramView.getContext();
      p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166347);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(251871);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mJ())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$android/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V");
        AppMethodBeat.o(251871);
        return;
        paramView = paramView.getLayoutParams();
        if (paramView == null)
        {
          paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
          AppMethodBeat.o(251871);
          throw paramRect;
        }
        if (((StaggeredGridLayoutManager.LayoutParams)paramView).kj() % 2 == 0)
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
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ah
 * JD-Core Version:    0.7.0.1
 */