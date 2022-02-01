package com.tencent.mm.plugin.game.media;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class GameLocalGalleryView$c$3
  implements Runnable
{
  GameLocalGalleryView$c$3(GameLocalGalleryView.c paramc, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(41005);
    GameLocalGalleryView.c.e(this.Izm).clear();
    if (this.Izn != null) {
      GameLocalGalleryView.c.e(this.Izm).addAll(this.Izn);
    }
    this.Izm.bZE.notifyChanged();
    AppMethodBeat.o(41005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.3
 * JD-Core Version:    0.7.0.1
 */