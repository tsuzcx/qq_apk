package com.tencent.luggage.game.widget.input;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.z;

final class WAGamePanelInputEditText$1
  extends Editable.Factory
{
  WAGamePanelInputEditText$1(WAGamePanelInputEditText paramWAGamePanelInputEditText) {}
  
  public final Editable newEditable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(140568);
    paramCharSequence = WAGamePanelInputEditText.a(this.bCM).c((Editable)WAGamePanelInputEditText.a(this.bCM, super.newEditable(paramCharSequence)));
    AppMethodBeat.o(140568);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.1
 * JD-Core Version:    0.7.0.1
 */