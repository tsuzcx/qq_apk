package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class GameGalleryUI$a$2
  implements View.OnClickListener
{
  GameGalleryUI$a$2(GameGalleryUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111963);
    ((MMActivity)this.nzJ.mContext).finish();
    AppMethodBeat.o(111963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI.a.2
 * JD-Core Version:    0.7.0.1
 */