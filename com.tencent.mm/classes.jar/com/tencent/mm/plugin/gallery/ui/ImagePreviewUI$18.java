package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.m.a;

final class ImagePreviewUI$18
  implements m.a
{
  ImagePreviewUI$18(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(21517);
    if (paramm.position != ImagePreviewUI.g(this.ngC).intValue())
    {
      AppMethodBeat.o(21517);
      return;
    }
    ImagePreviewUI.a(this.ngC, paramm.path, paramm.ndF);
    AppMethodBeat.o(21517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.18
 * JD-Core Version:    0.7.0.1
 */