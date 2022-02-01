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
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "spanCount", "", "getSpanCount", "()I", "bindConvert", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends as
{
  final MMActivity lzt;
  private final int spanCount;
  
  public r(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339249);
    this.lzt = paramMMActivity;
    this.spanCount = 2;
    AppMethodBeat.o(339249);
  }
  
  public final com.tencent.mm.view.recyclerview.g au(final b<? super Integer, ? extends f<?>> paramb)
  {
    AppMethodBeat.i(339295);
    paramb = (com.tencent.mm.view.recyclerview.g)new a(this, paramb);
    AppMethodBeat.o(339295);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(339274);
    s.u(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(this.spanCount, 1);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(339274);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(339284);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(339284);
    return localh;
  }
  
  public final RecyclerView.m j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339304);
    s.u(paramMMActivity, "context");
    k localk = k.aeZF;
    paramMMActivity = ((e)k.d((AppCompatActivity)paramMMActivity).q(e.class)).GKV;
    AppMethodBeat.o(339304);
    return paramMMActivity;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(r paramr, b<? super Integer, ? extends f<?>> paramb) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(339435);
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
        localObject = av.GiL;
        av.eY("FinderLbsStaggeredConfig", paramInt);
        localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(339435);
        return localObject;
        localObject = (f)new a(this.FKU);
        AppMethodBeat.o(339435);
        return localObject;
        localObject = (f)new b(this.FKU);
        AppMethodBeat.o(339435);
        return localObject;
        localObject = (f)new ae();
        AppMethodBeat.o(339435);
        return localObject;
        localObject = (f)new z();
        AppMethodBeat.o(339435);
        return localObject;
        localObject = k.aeZF;
        localObject = (f)new w(null, ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.FKU.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), 2);
        AppMethodBeat.o(339435);
        return localObject;
      }
      AppMethodBeat.o(339435);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends ah
    {
      a(r paramr) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(339400);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        r.l(paramj, paramBaseFinderFeed);
        AppMethodBeat.o(339400);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemConvertFactory$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends u
    {
      b(r paramr) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(339404);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        r.l(paramj, paramBaseFinderFeed);
        AppMethodBeat.o(339404);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderLbsStaggeredConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(339447);
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
        AppMethodBeat.o(339447);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(339447);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(339447);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).Lh() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(339447);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(339447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.r
 * JD-Core Version:    0.7.0.1
 */