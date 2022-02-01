package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.component.b.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "", "root", "Landroid/view/ViewGroup;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicLoadMoreInterface;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "incrementSize", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicLoadMoreInterface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "loadingMore", "", "getLoadingMore", "()Z", "setLoadingMore", "(Z)V", "musicRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMusicRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setMusicRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "musicRvFooter", "Landroid/view/View;", "getMusicRvFooter", "()Landroid/view/View;", "setMusicRvFooter", "(Landroid/view/View;)V", "getRoot", "()Landroid/view/ViewGroup;", "checkLoadMore", "lastVisiblePosition", "Companion", "plugin-finder_release"})
public final class i
{
  public static final b zlW;
  private final String TAG;
  private final kotlin.g.a.b<Integer, x> callback;
  private final ViewGroup kiF;
  public WxRecyclerView xYQ;
  boolean yne;
  View zlU;
  final com.tencent.mm.plugin.finder.live.component.b zlV;
  
  static
  {
    AppMethodBeat.i(272425);
    zlW = new b((byte)0);
    AppMethodBeat.o(272425);
  }
  
  public i(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.component.b paramb, kotlin.g.a.b<? super Integer, x> paramb1)
  {
    AppMethodBeat.i(272424);
    this.kiF = paramViewGroup;
    this.zlV = paramb;
    this.callback = paramb1;
    this.TAG = "FinderLiveAnchorMusicRvWidget";
    paramViewGroup = this.kiF.findViewById(b.f.music_rv_view);
    p.j(paramViewGroup, "root.findViewById(R.id.music_rv_view)");
    this.xYQ = ((WxRecyclerView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.music_footer);
    p.j(paramViewGroup, "root.findViewById(R.id.music_footer)");
    this.zlU = paramViewGroup;
    this.xYQ.a((RecyclerView.l)new a(this));
    AppMethodBeat.o(272424);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.l
  {
    a(i parami) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(269126);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$$special$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      paramRecyclerView = this.zlX.xYQ.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(269126);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).kM();
      paramRecyclerView = this.zlX;
      if (!paramRecyclerView.yne)
      {
        localObject = paramRecyclerView.zlV;
        if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.component.b)localObject).Nb(paramInt) == true))
        {
          paramRecyclerView.yne = true;
          paramRecyclerView.zlU.setVisibility(0);
          localObject = paramRecyclerView.zlV;
          if (localObject != null) {
            b.a.a((com.tencent.mm.plugin.finder.live.component.b)localObject, (kotlin.g.a.b)new i.c(paramRecyclerView));
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$$special$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(269126);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(269127);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$$special$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$$special$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(269127);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$Companion;", "", "()V", "LOAD_MORE_THRESHOLD", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "incrementSize", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.i
 * JD-Core Version:    0.7.0.1
 */