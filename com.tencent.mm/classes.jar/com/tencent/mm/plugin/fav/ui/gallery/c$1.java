package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$1
  extends RecyclerView.l
{
  c$1(c paramc)
  {
    AppMethodBeat.i(107360);
    AppMethodBeat.o(107360);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(235352);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(235352);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235351);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(235351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.1
 * JD-Core Version:    0.7.0.1
 */