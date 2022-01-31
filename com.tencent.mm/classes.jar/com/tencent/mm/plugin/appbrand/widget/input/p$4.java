package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

final class p$4
  implements InputFilter
{
  p$4(p paramp) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (p.a(this.huv) != null))
    {
      if ((paramCharSequence instanceof Spannable)) {}
      for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = new SpannableStringBuilder(paramCharSequence))
      {
        paramCharSequence.setSpan(p.a(this.huv), 0, paramCharSequence.length(), 18);
        return paramCharSequence;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.p.4
 * JD-Core Version:    0.7.0.1
 */