package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
final class MediaItemView$d
  implements Runnable
{
  MediaItemView$d(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(164950);
    this.gnh.setVisibility(this.tKK);
    this.gnh.setAlpha(1.0F);
    AppMethodBeat.o(164950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView.d
 * JD-Core Version:    0.7.0.1
 */