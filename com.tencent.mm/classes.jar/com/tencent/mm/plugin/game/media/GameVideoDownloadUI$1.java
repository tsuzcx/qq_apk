package com.tencent.mm.plugin.game.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GameVideoDownloadUI$1
  implements View.OnClickListener
{
  GameVideoDownloadUI$1(GameVideoDownloadUI paramGameVideoDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41120);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/media/GameVideoDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    GameVideoDownloadUI.a(this.xCj);
    a.a(this, "com/tencent/mm/plugin/game/media/GameVideoDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */