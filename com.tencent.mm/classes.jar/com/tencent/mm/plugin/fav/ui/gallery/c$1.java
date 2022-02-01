package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$1
  extends RecyclerView.m
{
  c$1(c paramc)
  {
    AppMethodBeat.i(107360);
    AppMethodBeat.o(107360);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218804);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt1);
    localb.mr(paramInt2);
    a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(218804);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(218805);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt);
    a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
    super.b(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(218805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.1
 * JD-Core Version:    0.7.0.1
 */