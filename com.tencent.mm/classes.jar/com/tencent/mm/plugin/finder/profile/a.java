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
import com.tencent.mm.plugin.finder.convert.ca;
import com.tencent.mm.plugin.finder.convert.ce;
import com.tencent.mm.plugin.finder.convert.cf;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.bw;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Landroid/app/Activity;", "isSelfFlag", "", "(Landroid/app/Activity;Z)V", "getContext", "()Landroid/app/Activity;", "()Z", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends as
{
  final boolean ALI;
  private final Activity hHU;
  
  public a(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(348169);
    this.hHU = paramActivity;
    this.ALI = paramBoolean;
    AppMethodBeat.o(348169);
  }
  
  public static f<?> eGS()
  {
    AppMethodBeat.i(348179);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = new RuntimeException("type invalid");
      AppMethodBeat.o(348179);
      throw ((Throwable)localObject);
    }
    Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
    Object localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
    AppMethodBeat.o(348179);
    return localObject;
  }
  
  public final com.tencent.mm.view.recyclerview.g au(b<? super Integer, ? extends f<?>> paramb)
  {
    AppMethodBeat.i(348206);
    paramb = (com.tencent.mm.view.recyclerview.g)new a(paramb, this);
    AppMethodBeat.o(348206);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(348190);
    s.u(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(2, 1);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(348190);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(348196);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(348196);
    return localh;
  }
  
  public final RecyclerView.m j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(348215);
    s.u(paramMMActivity, "context");
    k localk = k.aeZF;
    paramMMActivity = ((e)k.d((AppCompatActivity)paramMMActivity).q(e.class)).GKV;
    AppMethodBeat.o(348215);
    return paramMMActivity;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(b<? super Integer, ? extends f<?>> paramb, a parama) {}
    
    public final f<?> yF(int paramInt)
    {
      int j = 1;
      AppMethodBeat.i(348494);
      int i = j;
      switch (paramInt)
      {
      default: 
        if (paramInt != 2) {
          break;
        }
      }
      for (i = j; i != 0; i = 0)
      {
        localObject = new ca();
        ((ca)localObject).ALZ = Boolean.valueOf(jdField_this.ALI);
        localObject = (f)localObject;
        AppMethodBeat.o(348494);
        return localObject;
      }
      if (paramInt == bw.class.hashCode())
      {
        localObject = (f)new cf();
        AppMethodBeat.o(348494);
        return localObject;
      }
      if (paramInt == ap.class.hashCode())
      {
        localObject = (f)new ce();
        AppMethodBeat.o(348494);
        return localObject;
      }
      Object localObject = this.Bbh;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = (f)((b)localObject).invoke(Integer.valueOf(paramInt)))
      {
        localObject = a.eGS();
        AppMethodBeat.o(348494);
        return localObject;
      }
      AppMethodBeat.o(348494);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(348471);
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
        AppMethodBeat.o(348471);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(348471);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(348471);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).Lh() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(348471);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(348471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.a
 * JD-Core Version:    0.7.0.1
 */