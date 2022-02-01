package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SmartGalleryUI$5
  implements View.OnClickListener
{
  SmartGalleryUI$5(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111675);
    this.sTo.setResult(SmartGalleryUI.sTn);
    this.sTo.finish();
    AppMethodBeat.o(111675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */