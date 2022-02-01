package com.tencent.mm.plugin.finder.storage;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.bz;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "gridSpanCount", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isSelfFlag", "", "username", "", "(ILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;ZLjava/lang/String;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getGridSpanCount", "()I", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class af
  extends al
{
  final BaseFinderFeedLoader tFM;
  final boolean tFN;
  final String username;
  private final int vEY;
  
  public af(BaseFinderFeedLoader paramBaseFinderFeedLoader, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(251857);
    this.vEY = 3;
    this.tFM = paramBaseFinderFeedLoader;
    this.tFN = paramBoolean;
    this.username = paramString;
    AppMethodBeat.o(251857);
  }
  
  public final com.tencent.mm.view.recyclerview.f G(final b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(251855);
    paramb = (com.tencent.mm.view.recyclerview.f)new a(this, paramb);
    AppMethodBeat.o(251855);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(251853);
    p.h(paramContext, "context");
    paramContext = new GridLayoutManager(this.vEY);
    paramContext.a((GridLayoutManager.b)new c());
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(251853);
    return paramContext;
  }
  
  public final RecyclerView.m f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(251856);
    p.h(paramMMActivity, "context");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    paramMMActivity = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramMMActivity).get(FinderRecyclerViewPool.class)).wux;
    AppMethodBeat.o(251856);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(251854);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(251854);
    return localh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(b paramb) {}
    
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(251850);
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
          localObject = y.vXH;
          y.dQ("FinderProfileGridLayoutConfig", paramInt);
          localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        }
        AppMethodBeat.o(251850);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (e)new bz(this.vEZ.tFM, this.vEZ.username, this.vEZ.tFN, (byte)0);
        AppMethodBeat.o(251850);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new bz(this.vEZ.tFM, this.vEZ.username, this.vEZ.tFN, (byte)0);
        AppMethodBeat.o(251850);
        return localObject;
      case -3: 
        localObject = (e)new ag();
        AppMethodBeat.o(251850);
        return localObject;
      }
      Object localObject = (e)new ab();
      AppMethodBeat.o(251850);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    private final int tCv;
    
    b()
    {
      AppMethodBeat.i(251852);
      this.tCv = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1.0F);
      AppMethodBeat.o(251852);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(251851);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      params = paramView.getLayoutParams();
      if (params == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager.LayoutParams");
        AppMethodBeat.o(251851);
        throw paramRect;
      }
      params = (GridLayoutManager.LayoutParams)params;
      int i = RecyclerView.bw(paramView);
      if (paramRecyclerView == null) {
        p.hyc();
      }
      int j = paramRecyclerView.ki();
      if (paramRecyclerView.kf().ac(i, j) == 0) {
        paramRect.top = this.tCv;
      }
      paramRect.bottom = this.tCv;
      if (params.kk() == j)
      {
        paramRect.left = this.tCv;
        paramRect.right = this.tCv;
        AppMethodBeat.o(251851);
        return;
      }
      paramRect.left = ((int)((j - params.kj()) / j * this.tCv));
      paramRect.right = ((int)(1.0F * this.tCv * (j + 1) / j - paramRect.left));
      AppMethodBeat.o(251851);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    public final int bX(int paramInt)
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.af
 * JD-Core Version:    0.7.0.1
 */