package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class GameVideoPreviewUI$8
  implements o.f
{
  GameVideoPreviewUI$8(GameVideoPreviewUI paramGameVideoPreviewUI) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(41243);
    paramm.a(2, GameVideoPreviewUI.e(this.xDg).getString(2131761348), GameVideoPreviewUI.e(this.xDg).getString(2131761347), 2131690381);
    AppMethodBeat.o(41243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.8
 * JD-Core Version:    0.7.0.1
 */