package com.tencent.mm.plugin.gallery.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SmartGalleryUI$3
  implements TextView.OnEditorActionListener
{
  SmartGalleryUI$3(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111673);
    if (3 == paramInt)
    {
      paramTextView = paramTextView.getText().toString();
      if (!Util.isNullOrNil(paramTextView))
      {
        SmartGalleryUI.a(this.HQw, paramTextView, true);
        AppMethodBeat.o(111673);
        return true;
      }
    }
    AppMethodBeat.o(111673);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */