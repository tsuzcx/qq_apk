package com.tencent.mm.openim.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.mm.am.h;
import com.tencent.mm.kernel.c.a;

public abstract interface e
  extends h, a
{
  public abstract Bitmap RG(String paramString);
  
  public abstract TextAppearanceSpan a(Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract CharSequence a(Context paramContext, CharSequence paramCharSequence);
  
  public abstract CharSequence a(Context paramContext, String paramString1, String paramString2, float paramFloat);
  
  public abstract String a(String paramString1, String paramString2, e.a parama);
  
  public abstract String a(String paramString1, String paramString2, e.a parama, int paramInt);
  
  public abstract void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence);
  
  public abstract void a(Context paramContext, TextView paramTextView, CharSequence paramCharSequence, String paramString1, String paramString2, int paramInt);
  
  public abstract String b(String paramString1, String paramString2, e.a parama);
  
  public abstract void bRZ();
  
  public abstract int bl(String paramString, int paramInt);
  
  public abstract void cb(String paramString1, String paramString2);
  
  public abstract String cc(String paramString1, String paramString2);
  
  public abstract SpannableString e(Context paramContext, String paramString, int paramInt);
  
  public abstract void u(String paramString1, String paramString2, int paramInt);
  
  public abstract void y(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.api.e
 * JD-Core Version:    0.7.0.1
 */