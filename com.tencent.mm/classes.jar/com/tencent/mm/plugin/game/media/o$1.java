package com.tencent.mm.plugin.game.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class o$1
  implements View.OnClickListener
{
  o$1(o paramo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(276812);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/media/GameVideoDownloadPerform$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    o.a(this.IAm);
    a.a(this, "com/tencent/mm/plugin/game/media/GameVideoDownloadPerform$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.o.1
 * JD-Core Version:    0.7.0.1
 */