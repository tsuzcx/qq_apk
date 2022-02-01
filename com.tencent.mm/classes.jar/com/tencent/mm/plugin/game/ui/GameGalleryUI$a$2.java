package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

final class GameGalleryUI$a$2
  implements View.OnClickListener
{
  GameGalleryUI$a$2(GameGalleryUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42147);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ((MMActivity)GameGalleryUI.a.a(this.IRv)).finish();
    a.a(this, "com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI.a.2
 * JD-Core Version:    0.7.0.1
 */