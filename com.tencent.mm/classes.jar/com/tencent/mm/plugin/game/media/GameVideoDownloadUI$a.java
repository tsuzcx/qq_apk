package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.o;

final class GameVideoDownloadUI$a
  implements Runnable
{
  private h rTq;
  
  public GameVideoDownloadUI$a(GameVideoDownloadUI paramGameVideoDownloadUI, h paramh)
  {
    this.rTq = paramh;
  }
  
  public final void run()
  {
    AppMethodBeat.i(41130);
    if (this.rTq != null) {
      o.aCJ().a(this.rTq, false);
    }
    AppMethodBeat.o(41130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.a
 * JD-Core Version:    0.7.0.1
 */