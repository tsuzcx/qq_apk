package com.tencent.luggage.game.widget.input;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WAGamePanelInputEditText$3
  extends Spannable.Factory
{
  WAGamePanelInputEditText$3(WAGamePanelInputEditText paramWAGamePanelInputEditText) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(130723);
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    AppMethodBeat.o(130723);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.3
 * JD-Core Version:    0.7.0.1
 */