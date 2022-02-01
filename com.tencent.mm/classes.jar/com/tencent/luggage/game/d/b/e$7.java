package com.tencent.luggage.game.d.b;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;

final class e$7
  implements TextView.OnEditorActionListener
{
  e$7(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, r paramr, boolean paramBoolean) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(130617);
    this.ckG.ckA.a(this.ckH.getEditableText().toString(), this.cjR);
    if (this.ckE)
    {
      AppMethodBeat.o(130617);
      return true;
    }
    AppMethodBeat.o(130617);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.e.7
 * JD-Core Version:    0.7.0.1
 */