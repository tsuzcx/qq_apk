package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.k;
import com.tencent.mm.plugin.finder.live.component.k.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "", "root", "Landroid/view/ViewGroup;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicLoadMoreInterface;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "incrementSize", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicLoadMoreInterface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "loadingMore", "", "getLoadingMore", "()Z", "setLoadingMore", "(Z)V", "musicRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMusicRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setMusicRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "musicRvFooter", "Landroid/view/View;", "getMusicRvFooter", "()Landroid/view/View;", "setMusicRvFooter", "(Landroid/view/View;)V", "getRoot", "()Landroid/view/ViewGroup;", "checkLoadMore", "lastVisiblePosition", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n.b Emr;
  boolean CVX;
  public WxRecyclerView Cxi;
  final k Ems;
  View Emt;
  private final String TAG;
  private final kotlin.g.a.b<Integer, ah> callback;
  private final ViewGroup mJe;
  
  static
  {
    AppMethodBeat.i(361099);
    Emr = new n.b((byte)0);
    AppMethodBeat.o(361099);
  }
  
  public n(ViewGroup paramViewGroup, k paramk, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(361090);
    this.mJe = paramViewGroup;
    this.Ems = paramk;
    this.callback = paramb;
    this.TAG = "FinderLiveAnchorMusicRvWidget";
    paramViewGroup = this.mJe.findViewById(p.e.BYu);
    s.s(paramViewGroup, "root.findViewById(R.id.music_rv_view)");
    this.Cxi = ((WxRecyclerView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BYp);
    s.s(paramViewGroup, "root.findViewById(R.id.music_footer)");
    this.Emt = paramViewGroup;
    this.Cxi.a((RecyclerView.l)new a(this));
    AppMethodBeat.o(361090);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.l
  {
    a(n paramn) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(362056);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = this.Emu.Cxi.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(362056);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).Jx();
      paramRecyclerView = this.Emu;
      if (!paramRecyclerView.CVX)
      {
        localObject = paramRecyclerView.Ems;
        if ((localObject == null) || (((k)localObject).OC(paramInt) != true)) {
          break label178;
        }
      }
      label178:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          paramRecyclerView.CVX = true;
          paramRecyclerView.Emt.setVisibility(0);
          localObject = paramRecyclerView.Ems;
          if (localObject != null) {
            k.a.a((k)localObject, (kotlin.g.a.b)new n.c(paramRecyclerView));
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(362056);
        return;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362065);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(362065);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "incrementSize", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.n
 * JD-Core Version:    0.7.0.1
 */