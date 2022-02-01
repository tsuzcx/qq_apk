package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ao;

final class ImagePreviewUI$10
  implements d.b
{
  ImagePreviewUI$10(ImagePreviewUI paramImagePreviewUI, Intent paramIntent, String paramString) {}
  
  public final void agr(String paramString)
  {
    AppMethodBeat.i(111571);
    new ao(this.sSr.getMainLooper()).post(new ImagePreviewUI.10.1(this, paramString));
    e.cMs().b(this);
    AppMethodBeat.o(111571);
  }
  
  public final String cMp()
  {
    AppMethodBeat.i(179472);
    String str = d.a(this.sSs, null, -1);
    AppMethodBeat.o(179472);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(111572);
    String str = "fileKey:" + this.sSs + " this: " + super.toString();
    AppMethodBeat.o(111572);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.10
 * JD-Core Version:    0.7.0.1
 */