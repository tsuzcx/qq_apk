package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.h.a;

final class d$2$2
  extends Spannable.Factory
{
  d$2$2(d.2 param2, int paramInt) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141769);
    paramCharSequence = super.newSpannable(paramCharSequence);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      paramCharSequence.setSpan(new a(this.hXQ), 0, paramCharSequence.length(), 18);
    }
    AppMethodBeat.o(141769);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.d.2.2
 * JD-Core Version:    0.7.0.1
 */