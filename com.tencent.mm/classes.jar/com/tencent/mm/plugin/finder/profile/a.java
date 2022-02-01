package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
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
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.convert.cc;
import com.tencent.mm.plugin.finder.convert.cf;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Landroid/app/Activity;", "isSelfFlag", "", "(Landroid/app/Activity;Z)V", "getContext", "()Landroid/app/Activity;", "()Z", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class a
  extends ak
{
  private final Activity fDf;
  final boolean xnY;
  
  public a(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(280719);
    this.fDf = paramActivity;
    this.xnY = paramBoolean;
    AppMethodBeat.o(280719);
  }
  
  public static e<?> dNd()
  {
    AppMethodBeat.i(280717);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = (Throwable)new RuntimeException("type invalid");
      AppMethodBeat.o(280717);
      throw ((Throwable)localObject);
    }
    Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
    Object localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
    AppMethodBeat.o(280717);
    return localObject;
  }
  
  public final com.tencent.mm.view.recyclerview.f O(final b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(280716);
    paramb = (com.tencent.mm.view.recyclerview.f)new a(this, paramb);
    AppMethodBeat.o(280716);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(280714);
    p.k(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(2);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(280714);
    return paramContext;
  }
  
  public final RecyclerView.m g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(280718);
    p.k(paramMMActivity, "context");
    g localg = g.Xox;
    paramMMActivity = ((c)g.b((AppCompatActivity)paramMMActivity).i(c.class)).BgV;
    AppMethodBeat.o(280718);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(280715);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(280715);
    return localh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(b paramb) {}
    
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(278417);
      if ((paramInt == 4) || (paramInt == 9) || (paramInt == 2))
      {
        localObject = new cc();
        ((cc)localObject).xor = Boolean.valueOf(this.zPB.xnY);
        localObject = (e)localObject;
        AppMethodBeat.o(278417);
        return localObject;
      }
      if (paramInt == bp.class.hashCode())
      {
        localObject = (e)new cf();
        AppMethodBeat.o(278417);
        return localObject;
      }
      Object localObject = paramb;
      if (localObject != null)
      {
        e locale = (e)((b)localObject).invoke(Integer.valueOf(paramInt));
        localObject = locale;
        if (locale != null) {}
      }
      else
      {
        localObject = a.dNd();
      }
      AppMethodBeat.o(278417);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(275588);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(b.d.Edge_0_5_A);
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(b.d.finder_0_25_A);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(275588);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mF())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(275588);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(275588);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).kv() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(275588);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(275588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.a
 * JD-Core Version:    0.7.0.1
 */