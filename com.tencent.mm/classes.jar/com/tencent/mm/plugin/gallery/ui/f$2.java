package com.tencent.mm.plugin.gallery.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2
  implements h.a
{
  f$2(f paramf, f.a parama) {}
  
  public final void bEo()
  {
    AppMethodBeat.i(21576);
    ab.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[] { Integer.valueOf(this.ngX.mZY.getWidth()), Integer.valueOf(this.ngX.mZY.getHeight()) });
    AppMethodBeat.o(21576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.2
 * JD-Core Version:    0.7.0.1
 */