package com.tencent.mm.openim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.mm.an.i;

public abstract interface a
  extends i, com.tencent.mm.kernel.c.a
{
  public abstract Bitmap ZA(String paramString);
  
  public abstract int ZB(String paramString);
  
  public abstract TextAppearanceSpan a(Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract CharSequence a(Context paramContext, CharSequence paramCharSequence);
  
  public abstract CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat);
  
  public abstract String a(String paramString1, String paramString2, a.a parama);
  
  public abstract void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence);
  
  public abstract void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt);
  
  public abstract String b(String paramString1, String paramString2, a.a parama);
  
  public abstract void bQ(String paramString1, String paramString2);
  
  public abstract String bR(String paramString1, String paramString2);
  
  public abstract void bup();
  
  public abstract String c(String paramString1, String paramString2, a.a parama);
  
  public abstract SpannableString e(Context paramContext, String paramString, int paramInt);
  
  public abstract void v(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.a
 * JD-Core Version:    0.7.0.1
 */