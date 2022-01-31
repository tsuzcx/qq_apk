package com.tencent.mm.plugin.appbrand.widget;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  extends Spannable.Factory
{
  e$1(e parame) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(126657);
    paramCharSequence = super.newSpannable(paramCharSequence);
    if ((e.a(this.jao) != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      paramCharSequence.setSpan(e.a(this.jao), 0, paramCharSequence.length(), 18);
    }
    AppMethodBeat.o(126657);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.1
 * JD-Core Version:    0.7.0.1
 */