package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;

final class SmartGalleryUI$6
  extends RecyclerView.m
{
  SmartGalleryUI$6(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198431);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt1);
    localb.lS(paramInt2);
    a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(198431);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(111676);
    b localb = new b();
    localb.bb(paramRecyclerView);
    localb.lS(paramInt);
    a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
    ac.d("MicroMsg.SmartGalleryUI", "onScrollStateChanged, newState: %d, mIsNeedReset: %s.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SmartGalleryUI.c(this.sTo)) });
    if ((1 == paramInt) && (SmartGalleryUI.c(this.sTo)))
    {
      SmartGalleryUI.a(this.sTo, false);
      this.sTo.hideVKB();
      SmartGalleryUI.a(this.sTo).clearFocus();
    }
    a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(111676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.6
 * JD-Core Version:    0.7.0.1
 */