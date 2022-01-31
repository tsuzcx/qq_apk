package com.tencent.luggage.game.e.b;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;

final class e$7
  implements TextView.OnEditorActionListener
{
  e$7(e parame, boolean paramBoolean, WAGamePanelInputEditText paramWAGamePanelInputEditText, r paramr) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(140479);
    if (this.bBA)
    {
      this.bBC.bBw.a(this.bBD.getEditableText().toString(), this.bAW);
      AppMethodBeat.o(140479);
      return true;
    }
    AppMethodBeat.o(140479);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.e.b.e.7
 * JD-Core Version:    0.7.0.1
 */