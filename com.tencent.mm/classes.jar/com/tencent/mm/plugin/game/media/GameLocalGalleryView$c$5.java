package com.tencent.mm.plugin.game.media;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLocalGalleryView$c$5
  implements Runnable
{
  GameLocalGalleryView$c$5(GameLocalGalleryView.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(41007);
    this.xBh.atj.notifyChanged();
    AppMethodBeat.o(41007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.5
 * JD-Core Version:    0.7.0.1
 */