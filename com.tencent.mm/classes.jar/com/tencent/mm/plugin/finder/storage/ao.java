package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "()V", "spanCount", "", "getSpanCount", "()I", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ao
  extends as
{
  private final int spanCount = 2;
  
  public static f<?> Ts(int paramInt)
  {
    AppMethodBeat.i(339405);
    Object localObject = av.GiL;
    av.eY("FinderStaggeredConfig", paramInt);
    localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
    AppMethodBeat.o(339405);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.g au(kotlin.g.a.b<? super Integer, ? extends f<?>> paramb)
  {
    AppMethodBeat.i(339417);
    paramb = (com.tencent.mm.view.recyclerview.g)new a(paramb, this);
    AppMethodBeat.o(339417);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(339410);
    s.u(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.spanCount, 1);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(339410);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(339413);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(339413);
    return localh;
  }
  
  public final RecyclerView.m j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339421);
    s.u(paramMMActivity, "context");
    k localk = k.aeZF;
    paramMMActivity = ((e)k.d((AppCompatActivity)paramMMActivity).q(e.class)).GKV;
    AppMethodBeat.o(339421);
    return paramMMActivity;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(kotlin.g.a.b<? super Integer, ? extends f<?>> paramb, ao paramao) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(339176);
      switch (paramInt)
      {
      default: 
        localObject = this.Bbh;
        if (localObject != null) {
          break;
        }
      }
      for (Object localObject = null; localObject == null; localObject = (f)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt)))
      {
        localObject = ao.Ts(paramInt);
        AppMethodBeat.o(339176);
        return localObject;
        localObject = (f)new ah();
        AppMethodBeat.o(339176);
        return localObject;
        localObject = (f)new ah();
        AppMethodBeat.o(339176);
        return localObject;
        localObject = (f)new u();
        AppMethodBeat.o(339176);
        return localObject;
        localObject = (f)new ae();
        AppMethodBeat.o(339176);
        return localObject;
        localObject = (f)new z();
        AppMethodBeat.o(339176);
        return localObject;
      }
      AppMethodBeat.o(339176);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(339171);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRect);
      localb.cH(paramView);
      localb.cH(paramRecyclerView);
      localb.cH(params);
      a.c("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$androidx/recyclerview/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", this, localb.aYj());
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int i = (int)paramView.getContext().getResources().getDimension(e.c.Edge_0_5_A);
      int j = (int)paramView.getContext().getResources().getDimension(e.c.finder_0_25_A);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(339171);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$1", "com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$androidx/recyclerview/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V");
        AppMethodBeat.o(339171);
        return;
        paramView = paramView.getLayoutParams();
        if (paramView == null)
        {
          paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
          AppMethodBeat.o(339171);
          throw paramRect;
        }
        if (((StaggeredGridLayoutManager.LayoutParams)paramView).Lh() % 2 == 0)
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
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ao
 * JD-Core Version:    0.7.0.1
 */