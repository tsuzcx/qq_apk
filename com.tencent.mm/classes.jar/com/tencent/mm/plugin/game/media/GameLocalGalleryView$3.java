package com.tencent.mm.plugin.game.media;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.i;

final class GameLocalGalleryView$3
  implements GameLocalGalleryView.b
{
  GameLocalGalleryView$3(GameLocalGalleryView paramGameLocalGalleryView) {}
  
  public final void Ng(int paramInt)
  {
    AppMethodBeat.i(40999);
    if (paramInt > 0)
    {
      GameLocalGalleryView.c(this.Izj).setText(this.Izj.getResources().getString(h.i.Ibp, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(GameLocalGalleryView.b(this.Izj)) }));
      GameLocalGalleryView.c(this.Izj).setEnabled(true);
      GameLocalGalleryView.d(this.Izj).setVisibility(0);
      GameLocalGalleryView.d(this.Izj).setText(this.Izj.getResources().getString(h.i.HWc));
      AppMethodBeat.o(40999);
      return;
    }
    GameLocalGalleryView.c(this.Izj).setText(this.Izj.getResources().getString(h.i.HWa));
    GameLocalGalleryView.c(this.Izj).setEnabled(false);
    if (!GameLocalGalleryView.e(this.Izj))
    {
      GameLocalGalleryView.d(this.Izj).setVisibility(0);
      GameLocalGalleryView.d(this.Izj).setText(this.Izj.getResources().getString(h.i.HWb));
      AppMethodBeat.o(40999);
      return;
    }
    GameLocalGalleryView.d(this.Izj).setVisibility(8);
    AppMethodBeat.o(40999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.3
 * JD-Core Version:    0.7.0.1
 */