package com.tencent.luggage.game.d.b;

import android.text.Editable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.ui.widget.g;

final class e$3
  extends g
{
  e$3(e parame, r paramr) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(130613);
    if (aj.E(paramEditable))
    {
      AppMethodBeat.o(130613);
      return;
    }
    this.ckG.cky.a(paramEditable.toString(), this.cjR);
    AppMethodBeat.o(130613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.e.3
 * JD-Core Version:    0.7.0.1
 */