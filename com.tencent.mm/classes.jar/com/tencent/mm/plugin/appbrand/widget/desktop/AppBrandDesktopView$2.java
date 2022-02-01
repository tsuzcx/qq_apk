package com.tencent.mm.plugin.appbrand.widget.desktop;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandDesktopView$2
  extends RecyclerView.l
{
  AppBrandDesktopView$2(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(324212);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    if (paramInt == 0) {
      AppBrandDesktopView.d(this.uAi);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
    AppMethodBeat.o(324212);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324216);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(324216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.2
 * JD-Core Version:    0.7.0.1
 */