package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.ah;

final class GameDownloadView$2
  implements Runnable
{
  GameDownloadView$2(GameDownloadView paramGameDownloadView) {}
  
  public final void run()
  {
    AppMethodBeat.i(111893);
    GameDownloadView.b(this.nyF).em(ah.getContext());
    GameDownloadView.b(this.nyF).bjZ();
    GameDownloadView.a(this.nyF);
    AppMethodBeat.o(111893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView.2
 * JD-Core Version:    0.7.0.1
 */