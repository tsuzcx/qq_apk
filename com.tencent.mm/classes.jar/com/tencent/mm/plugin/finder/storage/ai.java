package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.cb;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "gridSpanCount", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isSelfFlag", "", "username", "", "(ILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;ZLjava/lang/String;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getGridSpanCount", "()I", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ai
  extends as
{
  final BaseFinderFeedLoader ALH;
  final boolean ALI;
  private final int FMi;
  final String username;
  
  public ai(BaseFinderFeedLoader paramBaseFinderFeedLoader, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(339412);
    this.FMi = 3;
    this.ALH = paramBaseFinderFeedLoader;
    this.ALI = paramBoolean;
    this.username = paramString;
    AppMethodBeat.o(339412);
  }
  
  public static f<?> Ts(int paramInt)
  {
    AppMethodBeat.i(339418);
    Object localObject = av.GiL;
    av.eY("FinderProfileGridLayoutConfig", paramInt);
    localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
    AppMethodBeat.o(339418);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.g au(final b<? super Integer, ? extends f<?>> paramb)
  {
    AppMethodBeat.i(339434);
    paramb = (com.tencent.mm.view.recyclerview.g)new a(this, paramb);
    AppMethodBeat.o(339434);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(339424);
    s.u(paramContext, "context");
    paramContext = new GridLayoutManager(this.FMi);
    paramContext.bWq = ((GridLayoutManager.b)new c());
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(339424);
    return paramContext;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(339427);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(339427);
    return localh;
  }
  
  public final RecyclerView.m j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339444);
    s.u(paramMMActivity, "context");
    k localk = k.aeZF;
    paramMMActivity = ((e)k.d((AppCompatActivity)paramMMActivity).q(e.class)).GKW;
    AppMethodBeat.o(339444);
    return paramMMActivity;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(ai paramai, b<? super Integer, ? extends f<?>> paramb) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(338939);
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
        localObject = ai.Ts(paramInt);
        AppMethodBeat.o(338939);
        return localObject;
        localObject = (f)new cb(this.FMj.ALH, this.FMj.username, this.FMj.ALI, (byte)0);
        AppMethodBeat.o(338939);
        return localObject;
        localObject = (f)new cb(this.FMj.ALH, this.FMj.username, this.FMj.ALI, (byte)0);
        AppMethodBeat.o(338939);
        return localObject;
        localObject = (f)new ae();
        AppMethodBeat.o(338939);
        return localObject;
        localObject = (f)new z();
        AppMethodBeat.o(338939);
        return localObject;
      }
      AppMethodBeat.o(338939);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    private final int space;
    
    b()
    {
      AppMethodBeat.i(338942);
      this.space = a.fromDPToPix(MMApplicationContext.getContext(), 1.0F);
      AppMethodBeat.o(338942);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(338952);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      params = paramView.getLayoutParams();
      if (params == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        AppMethodBeat.o(338952);
        throw paramRect;
      }
      params = (GridLayoutManager.LayoutParams)params;
      int i = RecyclerView.bA(paramView);
      s.checkNotNull(paramRecyclerView);
      int j = paramRecyclerView.bWl;
      if (paramRecyclerView.bWq.bh(i, j) == 0) {
        paramRect.top = this.space;
      }
      paramRect.bottom = this.space;
      if (params.bWt == j)
      {
        paramRect.left = this.space;
        paramRect.right = this.space;
        AppMethodBeat.o(338952);
        return;
      }
      paramRect.left = ((int)((j - params.bWs) / j * this.space));
      paramRect.right = ((int)(1.0F * this.space * (j + 1) / j - paramRect.left));
      AppMethodBeat.o(338952);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getLayoutManager$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends GridLayoutManager.b
  {
    public final int fJ(int paramInt)
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ai
 * JD-Core Version:    0.7.0.1
 */