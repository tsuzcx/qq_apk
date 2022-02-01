package com.tencent.mm.plugin.game.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class m$5
  implements View.OnClickListener
{
  m$5(m paramm, android.support.design.widget.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41082);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.xBJ.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.m.5
 * JD-Core Version:    0.7.0.1
 */