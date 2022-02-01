package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.s;

final class GameVideoDownloadUI$a
  implements Runnable
{
  private h CGt;
  
  public GameVideoDownloadUI$a(GameVideoDownloadUI paramGameVideoDownloadUI, h paramh)
  {
    this.CGt = paramh;
  }
  
  public final void run()
  {
    AppMethodBeat.i(41130);
    if (this.CGt != null) {
      s.bqC().a(this.CGt, false);
    }
    AppMethodBeat.o(41130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.a
 * JD-Core Version:    0.7.0.1
 */