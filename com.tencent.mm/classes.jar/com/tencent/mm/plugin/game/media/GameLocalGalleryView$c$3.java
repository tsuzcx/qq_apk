package com.tencent.mm.plugin.game.media;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class GameLocalGalleryView$c$3
  implements Runnable
{
  GameLocalGalleryView$c$3(GameLocalGalleryView.c paramc, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(41005);
    GameLocalGalleryView.c.e(this.xBh).clear();
    if (this.xBi != null) {
      GameLocalGalleryView.c.e(this.xBh).addAll(this.xBi);
    }
    this.xBh.atj.notifyChanged();
    AppMethodBeat.o(41005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.3
 * JD-Core Version:    0.7.0.1
 */