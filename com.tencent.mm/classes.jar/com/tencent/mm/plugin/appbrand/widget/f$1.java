package com.tencent.mm.plugin.appbrand.widget;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;

final class f$1
  extends Spannable.Factory
{
  f$1(f paramf) {}
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if ((f.a(this.hoc) != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      paramCharSequence.setSpan(f.a(this.hoc), 0, paramCharSequence.length(), 18);
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.1
 * JD-Core Version:    0.7.0.1
 */