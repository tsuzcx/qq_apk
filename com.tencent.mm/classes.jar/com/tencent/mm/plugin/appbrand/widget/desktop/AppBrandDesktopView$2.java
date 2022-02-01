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
    AppMethodBeat.i(268250);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    if (paramInt == 0) {
      AppBrandDesktopView.d(this.rpX);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
    AppMethodBeat.o(268250);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268251);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(268251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.2
 * JD-Core Version:    0.7.0.1
 */