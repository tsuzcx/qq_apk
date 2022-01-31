package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ak;

final class ImagePreviewUI$13
  implements d.b
{
  ImagePreviewUI$13(ImagePreviewUI paramImagePreviewUI, Intent paramIntent) {}
  
  public final void PA(String paramString)
  {
    AppMethodBeat.i(150888);
    new ak(this.ngC.getMainLooper()).post(new ImagePreviewUI.13.1(this, paramString));
    e.bDP().b(this);
    AppMethodBeat.o(150888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.13
 * JD-Core Version:    0.7.0.1
 */