package com.tencent.mm.plugin.finder.nearby.video;

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
import com.tencent.mm.plugin.finder.convert.cz;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "spanCount", "", "getSpanCount", "()I", "bindConvert", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends as
{
  public static final a ERL;
  final MMActivity lzt;
  private final int spanCount;
  
  static
  {
    AppMethodBeat.i(340159);
    ERL = new a((byte)0);
    AppMethodBeat.o(340159);
  }
  
  public c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(340121);
    this.lzt = paramMMActivity;
    this.spanCount = 2;
    AppMethodBeat.o(340121);
  }
  
  public static f<?> eGS()
  {
    AppMethodBeat.i(340132);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = new RuntimeException("type invalid");
      AppMethodBeat.o(340132);
      throw ((Throwable)localObject);
    }
    Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
    Object localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
    AppMethodBeat.o(340132);
    return localObject;
  }
  
  public final com.tencent.mm.view.recyclerview.g au(final b<? super Integer, ? extends f<?>> paramb)
  {
    AppMethodBeat.i(340188);
    paramb = (com.tencent.mm.view.recyclerview.g)new b(this, paramb);
    AppMethodBeat.o(340188);
    return paramb;
  }
  
  public final com.tencent.mm.view.recyclerview.g ech()
  {
    AppMethodBeat.i(340179);
    com.tencent.mm.view.recyclerview.g localg = au(null);
    AppMethodBeat.o(340179);
    return localg;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(340165);
    s.u(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.spanCount, 1);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(340165);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(340172);
    RecyclerView.h localh = (RecyclerView.h)new c();
    AppMethodBeat.o(340172);
    return localh;
  }
  
  public final RecyclerView.m j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(340198);
    s.u(paramMMActivity, "context");
    k localk = k.aeZF;
    paramMMActivity = ((e)k.d((AppCompatActivity)paramMMActivity).q(e.class)).GKV;
    AppMethodBeat.o(340198);
    return paramMMActivity;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(c paramc, b<? super Integer, ? extends f<?>> paramb) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(340081);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null) {
          break;
        }
      }
      for (Object localObject = null; localObject == null; localObject = (f)((b)localObject).invoke(Integer.valueOf(paramInt)))
      {
        localObject = c.eGS();
        AppMethodBeat.o(340081);
        return localObject;
        localObject = (f)new a(this.ERM);
        AppMethodBeat.o(340081);
        return localObject;
        localObject = (f)new b(this.ERM);
        AppMethodBeat.o(340081);
        return localObject;
        localObject = (f)new com.tencent.mm.plugin.finder.nearby.live.convert.c((Context)this.ERM.lzt);
        AppMethodBeat.o(340081);
        return localObject;
      }
      AppMethodBeat.o(340081);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/NearbyVideoFeedConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends cz
    {
      a(c paramc) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(340091);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        c.k(paramj, paramBaseFinderFeed);
        AppMethodBeat.o(340091);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends u
    {
      b(c paramc) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(340092);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        c.k(paramj, paramBaseFinderFeed);
        AppMethodBeat.o(340092);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(340087);
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
        AppMethodBeat.o(340087);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(340087);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(340087);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).Lh() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(340087);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(340087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.c
 * JD-Core Version:    0.7.0.1
 */