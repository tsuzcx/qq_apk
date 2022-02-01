package com.tencent.mm.plugin.finder.nearby.video;

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
import com.tencent.mm.plugin.finder.convert.cp;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "spanCount", "", "getSpanCount", "()I", "bindConvert", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
public final class c
  extends al
{
  private final int att;
  private final MMActivity gte;
  
  public c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(249462);
    this.gte = paramMMActivity;
    this.att = 2;
    AppMethodBeat.o(249462);
  }
  
  public final com.tencent.mm.view.recyclerview.f G(final b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(249460);
    paramb = (com.tencent.mm.view.recyclerview.f)new a(this, paramb);
    AppMethodBeat.o(249460);
    return paramb;
  }
  
  public final com.tencent.mm.view.recyclerview.f dcK()
  {
    AppMethodBeat.i(249459);
    com.tencent.mm.view.recyclerview.f localf = G(null);
    AppMethodBeat.o(249459);
    return localf;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(249457);
    p.h(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.att);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(249457);
    return paramContext;
  }
  
  public final RecyclerView.m f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(249461);
    p.h(paramMMActivity, "context");
    a locala = a.PRN;
    paramMMActivity = ((FinderRecyclerViewPool)a.b((AppCompatActivity)paramMMActivity).get(FinderRecyclerViewPool.class)).wuw;
    AppMethodBeat.o(249461);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(249458);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(249458);
    return localh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(b paramb) {}
    
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(249455);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null)
        {
          e locale = (e)((b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {
            break label183;
          }
        }
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
        {
          localObject = (Throwable)new RuntimeException("type invalid");
          AppMethodBeat.o(249455);
          throw ((Throwable)localObject);
        }
        break;
      case 4: 
      case 9: 
      case 3002: 
        localObject = (e)new a(this);
        AppMethodBeat.o(249455);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new b(this);
        AppMethodBeat.o(249455);
        return localObject;
      }
      Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
      Object localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
      label183:
      AppMethodBeat.o(249455);
      return localObject;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/NearbyVideoFeedConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends cp
    {
      public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(249451);
        p.h(paramh, "holder");
        p.h(paramBaseFinderFeed, "item");
        super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        c.l(paramh, paramBaseFinderFeed);
        AppMethodBeat.o(249451);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends v
    {
      public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(249453);
        p.h(paramh, "holder");
        p.h(paramBaseFinderFeed, "item");
        super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        c.l(paramh, paramBaseFinderFeed);
        AppMethodBeat.o(249453);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(249456);
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
        AppMethodBeat.o(249456);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mJ())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(249456);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(249456);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).kj() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(249456);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(249456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.c
 * JD-Core Version:    0.7.0.1
 */