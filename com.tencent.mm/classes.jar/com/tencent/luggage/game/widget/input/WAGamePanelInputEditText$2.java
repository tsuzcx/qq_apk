package com.tencent.luggage.game.widget.input;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WAGamePanelInputEditText$2
  implements InputFilter
{
  WAGamePanelInputEditText$2(WAGamePanelInputEditText paramWAGamePanelInputEditText) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140569);
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    if ((paramCharSequence instanceof Spannable)) {}
    for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = new SpannableStringBuilder(paramCharSequence))
    {
      paramCharSequence = WAGamePanelInputEditText.a(this.bCM, paramCharSequence);
      AppMethodBeat.o(140569);
      return paramCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.2
 * JD-Core Version:    0.7.0.1
 */