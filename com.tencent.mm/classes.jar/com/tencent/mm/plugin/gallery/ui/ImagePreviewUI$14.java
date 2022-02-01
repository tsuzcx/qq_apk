package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw.a;

final class ImagePreviewUI$14
  implements aw.a
{
  ImagePreviewUI$14(ImagePreviewUI paramImagePreviewUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(111577);
    ImagePreviewUI localImagePreviewUI = this.tZM;
    if (!ImagePreviewUI.x(this.tZM)) {}
    for (boolean bool = true;; bool = false)
    {
      ImagePreviewUI.c(localImagePreviewUI, bool);
      ImagePreviewUI.a(this.tZM, ImagePreviewUI.x(this.tZM));
      AppMethodBeat.o(111577);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.14
 * JD-Core Version:    0.7.0.1
 */