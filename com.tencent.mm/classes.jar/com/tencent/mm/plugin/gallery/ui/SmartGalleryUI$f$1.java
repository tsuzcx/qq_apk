package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.s.a;

final class SmartGalleryUI$f$1
  implements View.OnClickListener
{
  SmartGalleryUI$f$1(SmartGalleryUI.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111692);
    paramView = paramView.getTag();
    if (((paramView instanceof s.a)) && (SmartGalleryUI.f.a(this.sTC) != null)) {
      SmartGalleryUI.f.a(this.sTC).a((s.a)paramView);
    }
    AppMethodBeat.o(111692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.f.1
 * JD-Core Version:    0.7.0.1
 */