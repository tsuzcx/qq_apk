package com.tencent.mm.plugin.game.media.preview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GameVideoPreviewUI$7
  implements View.OnClickListener
{
  GameVideoPreviewUI$7(GameVideoPreviewUI paramGameVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41242);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    GameVideoPreviewUI.h(this.xDg);
    a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.7
 * JD-Core Version:    0.7.0.1
 */