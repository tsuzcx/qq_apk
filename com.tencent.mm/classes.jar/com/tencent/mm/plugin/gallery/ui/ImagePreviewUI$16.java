package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class ImagePreviewUI$16
  implements ap.a
{
  ImagePreviewUI$16(ImagePreviewUI paramImagePreviewUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(150892);
    ImagePreviewUI localImagePreviewUI = this.ngC;
    if (!ImagePreviewUI.x(this.ngC)) {}
    for (boolean bool = true;; bool = false)
    {
      ImagePreviewUI.d(localImagePreviewUI, bool);
      ImagePreviewUI.a(this.ngC, ImagePreviewUI.x(this.ngC));
      AppMethodBeat.o(150892);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.16
 * JD-Core Version:    0.7.0.1
 */