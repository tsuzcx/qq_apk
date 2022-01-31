package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

public final class d
{
  public TextPaint dOi;
  public CharSequence kwh;
  public g kwi;
  public boolean kwj;
  public boolean kwk;
  public d.a kwl = d.a.kws;
  public int kwm = Color.parseColor("#45C01A");
  public float kwn;
  public CharSequence kwo = "";
  public CharSequence kwp = "";
  public String kwq = "";
  public String kwr = "";
  
  public static final d a(CharSequence paramCharSequence, g paramg)
  {
    d locald = new d();
    locald.kwh = paramCharSequence;
    locald.kwi = paramg;
    return locald;
  }
  
  public static final d a(CharSequence paramCharSequence, g paramg, float paramFloat, TextPaint paramTextPaint)
  {
    return a(paramCharSequence, paramg, false, false, paramFloat, paramTextPaint);
  }
  
  public static final d a(CharSequence paramCharSequence, g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramCharSequence, paramg, paramBoolean1, paramBoolean2, 0.0F, null);
  }
  
  public static final d a(CharSequence paramCharSequence, g paramg, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, TextPaint paramTextPaint)
  {
    d locald = new d();
    locald.kwh = paramCharSequence;
    locald.kwi = paramg;
    locald.kwj = paramBoolean1;
    locald.kwk = paramBoolean2;
    locald.kwn = paramFloat;
    locald.dOi = paramTextPaint;
    return locald;
  }
  
  public static final d a(CharSequence paramCharSequence1, g paramg, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    d locald = new d();
    locald.kwh = paramCharSequence1;
    locald.kwi = paramg;
    locald.kwj = paramBoolean1;
    locald.kwk = paramBoolean2;
    locald.kwn = 400.0F;
    locald.dOi = paramTextPaint;
    locald.kwo = paramCharSequence2;
    locald.kwp = paramCharSequence3;
    return locald;
  }
  
  public static final d a(CharSequence paramCharSequence, List<String> paramList)
  {
    return b(paramCharSequence, bk.c(paramList, " "));
  }
  
  public static final d a(CharSequence paramCharSequence, List<String> paramList, d.a parama, int paramInt)
  {
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.kwl = parama;
    paramCharSequence.kwm = paramInt;
    return paramCharSequence;
  }
  
  public static final d b(CharSequence paramCharSequence, String paramString)
  {
    d locald = new d();
    locald.kwh = paramCharSequence;
    locald.kwi = g.aF(paramString, false);
    locald.kwj = false;
    locald.kwk = false;
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.d
 * JD-Core Version:    0.7.0.1
 */