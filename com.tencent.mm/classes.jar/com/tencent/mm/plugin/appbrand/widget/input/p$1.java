package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;

final class p$1
  extends Spannable.Factory
{
  p$1(p paramp) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if ((p.a(this.huv) != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      paramCharSequence.setSpan(p.a(this.huv), 0, paramCharSequence.length(), 18);
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.p.1
 * JD-Core Version:    0.7.0.1
 */