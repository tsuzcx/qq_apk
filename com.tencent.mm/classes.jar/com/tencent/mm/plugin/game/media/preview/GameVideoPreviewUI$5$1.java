package com.tencent.mm.plugin.game.media.preview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class GameVideoPreviewUI$5$1
  implements View.OnClickListener
{
  GameVideoPreviewUI$5$1(GameVideoPreviewUI.5 param5, com.google.android.material.bottomsheet.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41239);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.IzO.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.5.1
 * JD-Core Version:    0.7.0.1
 */