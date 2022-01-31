package com.tencent.mm.plugin.location.ui.impl;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements TextView.OnEditorActionListener
{
  c$2(c paramc) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113595);
    ab.d("MicroMsg.MMPoiMapUI", "keyboard action");
    if (3 == paramInt) {
      c.m(this.ogD);
    }
    AppMethodBeat.o(113595);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.2
 * JD-Core Version:    0.7.0.1
 */