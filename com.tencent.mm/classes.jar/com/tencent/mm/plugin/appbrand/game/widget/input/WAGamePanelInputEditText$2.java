package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

final class WAGamePanelInputEditText$2
  implements InputFilter
{
  WAGamePanelInputEditText$2(WAGamePanelInputEditText paramWAGamePanelInputEditText) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    if ((paramCharSequence instanceof Spannable)) {}
    for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = new SpannableStringBuilder(paramCharSequence)) {
      return WAGamePanelInputEditText.a(this.gdC, paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText.2
 * JD-Core Version:    0.7.0.1
 */