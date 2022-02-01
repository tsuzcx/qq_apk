package com.tencent.mm.plugin.finder.nearby.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "offset", "", "position", "computeRecyclerViewPosAndOffset", "", "getOffset", "getPosition", "handleOnScrollStateChanged", "newState", "setPosAndOffset", "pos", "Companion", "plugin-finder-nearby_release"})
public final class d
{
  public static final a zDu;
  public int offset;
  public int position;
  
  static
  {
    AppMethodBeat.i(203628);
    zDu = new a((byte)0);
    AppMethodBeat.o(203628);
  }
  
  public d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(203627);
    paramRecyclerView.a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(199662);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        a.c("com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        p.k(paramAnonymousRecyclerView, "recyclerView");
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        d.a(this.zDv, paramAnonymousRecyclerView, paramAnonymousInt);
        a.a(this, "com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(199662);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(199664);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        a.c("com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        a.a(this, "com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(199664);
      }
    });
    AppMethodBeat.o(203627);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.d
 * JD-Core Version:    0.7.0.1
 */