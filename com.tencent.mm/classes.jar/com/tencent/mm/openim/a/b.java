package com.tencent.mm.openim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.mm.al.g;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends g, a
{
  public abstract Bitmap Bh(String paramString);
  
  public abstract int Bi(String paramString);
  
  public abstract CharSequence a(Context paramContext, CharSequence paramCharSequence);
  
  public abstract CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat);
  
  public abstract String a(String paramString1, String paramString2, b.a parama);
  
  public abstract void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence);
  
  public abstract void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt);
  
  public abstract void aFw();
  
  public abstract String b(String paramString1, String paramString2, b.a parama);
  
  public abstract void bs(String paramString1, String paramString2);
  
  public abstract String bt(String paramString1, String paramString2);
  
  public abstract String c(String paramString1, String paramString2, b.a parama);
  
  public abstract SpannableString e(Context paramContext, String paramString, int paramInt);
  
  public abstract TextAppearanceSpan f(Context paramContext, String paramString, int paramInt);
  
  public abstract void t(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.a.b
 * JD-Core Version:    0.7.0.1
 */