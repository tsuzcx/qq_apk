package com.tencent.luggage.game.e.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;

final class e$5
  implements View.OnClickListener
{
  e$5(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, r paramr, boolean paramBoolean, a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(140477);
    this.bBC.bBw.a(this.bBD.getEditableText().toString(), this.bAW);
    this.bBC.bBu.a(this.bBD.getEditableText().toString(), this.bAW);
    if (!this.bBA) {
      this.bBE.hide();
    }
    AppMethodBeat.o(140477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.e.b.e.5
 * JD-Core Version:    0.7.0.1
 */