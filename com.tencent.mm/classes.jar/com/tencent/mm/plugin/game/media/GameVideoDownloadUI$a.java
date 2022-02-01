package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.o;

final class GameVideoDownloadUI$a
  implements Runnable
{
  private h xCt;
  
  public GameVideoDownloadUI$a(GameVideoDownloadUI paramGameVideoDownloadUI, h paramh)
  {
    this.xCt = paramh;
  }
  
  public final void run()
  {
    AppMethodBeat.i(41130);
    if (this.xCt != null) {
      o.bhk().a(this.xCt, false);
    }
    AppMethodBeat.o(41130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.a
 * JD-Core Version:    0.7.0.1
 */