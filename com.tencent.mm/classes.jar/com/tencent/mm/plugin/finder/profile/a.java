package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
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
import com.tencent.mm.plugin.finder.convert.by;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Landroid/app/Activity;", "isSelfFlag", "", "(Landroid/app/Activity;Z)V", "getContext", "()Landroid/app/Activity;", "()Z", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class a
  extends al
{
  private final Activity dKq;
  final boolean tFN;
  
  public a(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(249976);
    this.dKq = paramActivity;
    this.tFN = paramBoolean;
    AppMethodBeat.o(249976);
  }
  
  public final com.tencent.mm.view.recyclerview.f G(final b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(249974);
    paramb = (com.tencent.mm.view.recyclerview.f)new a(this, paramb);
    AppMethodBeat.o(249974);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(249972);
    p.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(2);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(249972);
    return paramContext;
  }
  
  public final RecyclerView.m f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(249975);
    p.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramMMActivity).get(FinderRecyclerViewPool.class)).wuw;
    AppMethodBeat.o(249975);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(249973);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(249973);
    return localh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(b paramb) {}
    
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(249970);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null)
        {
          e locale = (e)((b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {
            break label163;
          }
        }
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = (Throwable)new RuntimeException("type invalid");
          AppMethodBeat.o(249970);
          throw ((Throwable)localObject);
        }
        break;
      case 2: 
      case 4: 
      case 9: 
        localObject = new by();
        ((by)localObject).tFI = Boolean.valueOf(this.uZh.tFN);
        localObject = (e)localObject;
        AppMethodBeat.o(249970);
        return localObject;
      }
      Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
      Object localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
      label163:
      AppMethodBeat.o(249970);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(249971);
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
        AppMethodBeat.o(249971);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mJ())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(249971);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(249971);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).kj() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(249971);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(249971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.a
 * JD-Core Version:    0.7.0.1
 */