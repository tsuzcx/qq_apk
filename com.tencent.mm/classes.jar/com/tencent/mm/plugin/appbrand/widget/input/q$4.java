package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$4
  implements InputFilter
{
  q$4(q paramq) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123701);
    if ((!TextUtils.isEmpty(paramCharSequence)) && (q.a(this.jmB) != null))
    {
      if ((paramCharSequence instanceof Spannable)) {}
      for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = new SpannableStringBuilder(paramCharSequence))
      {
        paramCharSequence.setSpan(q.a(this.jmB), 0, paramCharSequence.length(), 18);
        AppMethodBeat.o(123701);
        return paramCharSequence;
      }
    }
    AppMethodBeat.o(123701);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.q.4
 * JD-Core Version:    0.7.0.1
 */