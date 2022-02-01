package com.tencent.mm.plugin.game.media;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLocalGalleryView$c$4
  implements Runnable
{
  GameLocalGalleryView$c$4(GameLocalGalleryView.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(41006);
    this.xBh.atj.notifyChanged();
    AppMethodBeat.o(41006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.4
 * JD-Core Version:    0.7.0.1
 */