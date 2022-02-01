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
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "spanCount", "", "getSpanCount", "()I", "bindConvert", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
public final class p
  extends al
{
  private final int att;
  final MMActivity gte;
  
  public p(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(251787);
    this.gte = paramMMActivity;
    this.att = 2;
    AppMethodBeat.o(251787);
  }
  
  public final com.tencent.mm.view.recyclerview.f G(final b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(251785);
    paramb = (com.tencent.mm.view.recyclerview.f)new a(this, paramb);
    AppMethodBeat.o(251785);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(251783);
    kotlin.g.b.p.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.att);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(251783);
    return paramContext;
  }
  
  public final RecyclerView.m f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(251786);
    kotlin.g.b.p.h(paramMMActivity, "context");
    a locala = a.PRN;
    paramMMActivity = ((FinderRecyclerViewPool)a.b((AppCompatActivity)paramMMActivity).get(FinderRecyclerViewPool.class)).wuw;
    AppMethodBeat.o(251786);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(251784);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(251784);
    return localh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(b paramb) {}
    
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(251781);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null)
        {
          e locale = (e)((b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = com.tencent.mm.plugin.finder.utils.y.vXH;
          com.tencent.mm.plugin.finder.utils.y.dQ("FinderLbsStaggeredConfig", paramInt);
          localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        }
        AppMethodBeat.o(251781);
        return localObject;
      case 4: 
      case 9: 
      case 3002: 
        localObject = (e)new a(this);
        AppMethodBeat.o(251781);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new b(this);
        AppMethodBeat.o(251781);
        return localObject;
      case -3: 
        localObject = (e)new ag();
        AppMethodBeat.o(251781);
        return localObject;
      case -5: 
        localObject = (e)new ab();
        AppMethodBeat.o(251781);
        return localObject;
      }
      Object localObject = a.PRN;
      localObject = (e)new com.tencent.mm.plugin.finder.convert.y(((FinderReporterUIC)a.b((AppCompatActivity)this.vEd.gte).get(FinderReporterUIC.class)).dIx(), 2);
      AppMethodBeat.o(251781);
      return localObject;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends com.tencent.mm.plugin.finder.convert.al
    {
      public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(251777);
        kotlin.g.b.p.h(paramh, "holder");
        kotlin.g.b.p.h(paramBaseFinderFeed, "item");
        super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        p.m(paramh, paramBaseFinderFeed);
        AppMethodBeat.o(251777);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends v
    {
      public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(251779);
        kotlin.g.b.p.h(paramh, "holder");
        kotlin.g.b.p.h(paramBaseFinderFeed, "item");
        super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        p.m(paramh, paramBaseFinderFeed);
        AppMethodBeat.o(251779);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(251782);
      kotlin.g.b.p.h(paramRect, "outRect");
      kotlin.g.b.p.h(paramView, "view");
      kotlin.g.b.p.h(paramRecyclerView, "parent");
      kotlin.g.b.p.h(params, "state");
      paramRecyclerView = paramView.getContext();
      kotlin.g.b.p.g(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(2131165277);
      paramRecyclerView = paramView.getContext();
      kotlin.g.b.p.g(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(2131166347);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(251782);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mJ())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(251782);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(251782);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).kj() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(251782);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(251782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.p
 * JD-Core Version:    0.7.0.1
 */