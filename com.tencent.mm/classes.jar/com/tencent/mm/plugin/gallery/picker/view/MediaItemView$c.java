package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
final class MediaItemView$c
  implements Runnable
{
  MediaItemView$c(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(164949);
    this.fTD.setVisibility(0);
    View localView = this.fTD;
    if ((this.sOc == 4) || (this.sOc == 8)) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      localView.setAlpha(f);
      AppMethodBeat.o(164949);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView.c
 * JD-Core Version:    0.7.0.1
 */