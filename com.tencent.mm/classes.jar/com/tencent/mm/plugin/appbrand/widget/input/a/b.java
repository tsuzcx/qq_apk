package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.mm.pointers.PInt;

public abstract interface b
  extends com.tencent.luggage.a.b
{
  public abstract Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory);
  
  public abstract SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat);
  
  public abstract a ys(int paramInt);
  
  public static final class a
  {
    public int owH;
    public int owI;
    public int owJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.a.b
 * JD-Core Version:    0.7.0.1
 */