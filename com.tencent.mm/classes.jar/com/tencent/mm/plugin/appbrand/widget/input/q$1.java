package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$1
  extends Spannable.Factory
{
  q$1(q paramq) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(123698);
    paramCharSequence = super.newSpannable(paramCharSequence);
    if ((q.a(this.jmB) != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      paramCharSequence.setSpan(q.a(this.jmB), 0, paramCharSequence.length(), 18);
    }
    AppMethodBeat.o(123698);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.q.1
 * JD-Core Version:    0.7.0.1
 */