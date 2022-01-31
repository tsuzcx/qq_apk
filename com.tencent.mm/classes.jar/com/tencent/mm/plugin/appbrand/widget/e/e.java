package com.tencent.mm.plugin.appbrand.widget.e;

import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.mm.plugin.appbrand.widget.g.a;

final class e
  extends Spannable.Factory
{
  private final int height;
  
  public e(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final Spannable newSpannable(CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if (paramCharSequence != null)
    {
      paramCharSequence.setSpan(new a(this.height), 0, paramCharSequence.length(), 18);
      return paramCharSequence;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.e
 * JD-Core Version:    0.7.0.1
 */