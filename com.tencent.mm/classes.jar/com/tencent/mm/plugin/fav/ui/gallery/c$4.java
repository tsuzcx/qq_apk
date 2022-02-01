package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$4
  implements View.OnClickListener
{
  c$4(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107369);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Ani.dSG();
    a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(107369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.4
 * JD-Core Version:    0.7.0.1
 */