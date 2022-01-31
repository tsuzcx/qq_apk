package com.tencent.mm.cd;

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
    AppMethodBeat.i(62644);
    paramCharSequence = new SpannableString(paramCharSequence);
    AppMethodBeat.o(62644);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cd.b.1
 * JD-Core Version:    0.7.0.1
 */