package com.tencent.mm.plugin.gallery.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SmartGalleryUI$2
  implements View.OnTouchListener
{
  SmartGalleryUI$2(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111672);
    if (!SmartGalleryUI.c(this.sTo)) {
      SmartGalleryUI.a(this.sTo, true);
    }
    AppMethodBeat.o(111672);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.2
 * JD-Core Version:    0.7.0.1
 */