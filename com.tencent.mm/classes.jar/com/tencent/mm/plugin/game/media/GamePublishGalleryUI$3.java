package com.tencent.mm.plugin.game.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GamePublishGalleryUI$3
  implements View.OnClickListener
{
  GamePublishGalleryUI$3(GamePublishGalleryUI paramGamePublishGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41036);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/media/GamePublishGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Izu.setResult(0);
    this.Izu.finish();
    a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */