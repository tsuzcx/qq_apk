package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameVideoDownloadUI$6$1
  implements Runnable
{
  GameVideoDownloadUI$6$1(GameVideoDownloadUI.6 param6, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(151852);
    GameVideoDownloadUI.f(this.nlI.nlB).setProgress(this.fzv * 100 / this.fFB);
    AppMethodBeat.o(151852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.6.1
 * JD-Core Version:    0.7.0.1
 */