package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.h;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class GameVideoPreviewUI$8
  implements u.g
{
  GameVideoPreviewUI$8(GameVideoPreviewUI paramGameVideoPreviewUI) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(41243);
    params.a(2, GameVideoPreviewUI.e(this.IBq).getString(h.i.IbW), GameVideoPreviewUI.e(this.IBq).getString(h.i.IbV), h.h.game_icon_share_wechat);
    AppMethodBeat.o(41243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.8
 * JD-Core Version:    0.7.0.1
 */