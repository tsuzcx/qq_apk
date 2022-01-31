package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.widget.g.a;

final class d$2$3
  extends Spannable.Factory
{
  d$2$3(d.2 param2, int paramInt) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      paramCharSequence.setSpan(new a(this.gAA), 0, paramCharSequence.length(), 18);
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.d.2.3
 * JD-Core Version:    0.7.0.1
 */