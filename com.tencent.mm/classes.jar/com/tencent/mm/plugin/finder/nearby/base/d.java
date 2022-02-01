package com.tencent.mm.plugin.finder.nearby.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "offset", "", "position", "computeRecyclerViewPosAndOffset", "", "getOffset", "getPosition", "handleOnScrollStateChanged", "newState", "setPosAndOffset", "pos", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a EHB;
  public int offset;
  public int position;
  
  static
  {
    AppMethodBeat.i(339689);
    EHB = new a((byte)0);
    AppMethodBeat.o(339689);
  }
  
  public d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(339676);
    paramRecyclerView.a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(339692);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        a.c("com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        s.u(paramAnonymousRecyclerView, "recyclerView");
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        d.a(this.EHC, paramAnonymousRecyclerView, paramAnonymousInt);
        a.a(this, "com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(339692);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(339698);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        a.c("com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        a.a(this, "com/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(339698);
      }
    });
    AppMethodBeat.o(339676);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.d
 * JD-Core Version:    0.7.0.1
 */