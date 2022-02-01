package com.tencent.mm.cf;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  extends Spannable.Factory
{
  b$1(b paramb) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104896);
    paramCharSequence = new SpannableString(paramCharSequence);
    AppMethodBeat.o(104896);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cf.b.1
 * JD-Core Version:    0.7.0.1
 */