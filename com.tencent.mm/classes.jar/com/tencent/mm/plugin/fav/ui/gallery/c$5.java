package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$5
  implements View.OnClickListener
{
  c$5(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107370);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.tko.tjZ != null) {
      this.tko.tjZ.Ig(((Integer)paramView.getTag()).intValue());
    }
    a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(107370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.5
 * JD-Core Version:    0.7.0.1
 */