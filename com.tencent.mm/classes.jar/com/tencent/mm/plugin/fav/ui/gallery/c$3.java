package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$3
  implements View.OnClickListener
{
  c$3(c paramc)
  {
    AppMethodBeat.i(107365);
    AppMethodBeat.o(107365);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(230984);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.wQF.dlP();
    a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(230984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.3
 * JD-Core Version:    0.7.0.1
 */