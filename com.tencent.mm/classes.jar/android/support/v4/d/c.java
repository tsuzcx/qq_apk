package android.support.v4.d;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.support.v4.e.j;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Locale;
import java.util.concurrent.Executor;

public final class c
  implements Spannable
{
  private static Executor NV = null;
  private static final Object sLock = new Object();
  public final Spannable NW;
  public final a NX;
  private final PrecomputedText NY;
  
  public final char charAt(int paramInt)
  {
    return this.NW.charAt(paramInt);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    return this.NW.getSpanEnd(paramObject);
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    return this.NW.getSpanFlags(paramObject);
  }
  
  public final int getSpanStart(Object paramObject)
  {
    return this.NW.getSpanStart(paramObject);
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.NY.getSpans(paramInt1, paramInt2, paramClass);
    }
    return this.NW.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public final int length()
  {
    return this.NW.length();
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.NW.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public final void removeSpan(Object paramObject)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.NY.removeSpan(paramObject);
      return;
    }
    this.NW.removeSpan(paramObject);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.NY.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    this.NW.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.NW.subSequence(paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return this.NW.toString();
  }
  
  public static final class a
  {
    public final TextPaint NZ;
    public final TextDirectionHeuristic Oa;
    public final int Ob;
    public final int Oc;
    final PrecomputedText.Params Od;
    
    public a(PrecomputedText.Params paramParams)
    {
      this.NZ = paramParams.getTextPaint();
      this.Oa = paramParams.getTextDirection();
      this.Ob = paramParams.getBreakStrategy();
      this.Oc = paramParams.getHyphenationFrequency();
      this.Od = paramParams;
    }
    
    public a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28) {}
      for (this.Od = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.Od = null)
      {
        this.NZ = paramTextPaint;
        this.Oa = paramTextDirectionHeuristic;
        this.Ob = paramInt1;
        this.Oc = paramInt2;
        return;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (!(paramObject instanceof a))) {
            return false;
          }
          paramObject = (a)paramObject;
          if (this.Od != null) {
            return this.Od.equals(paramObject.Od);
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.Ob != paramObject.Ob) {
              return false;
            }
            if (this.Oc != paramObject.Oc) {
              return false;
            }
          }
          if ((Build.VERSION.SDK_INT >= 18) && (this.Oa != paramObject.Oa)) {
            return false;
          }
          if (this.NZ.getTextSize() != paramObject.NZ.getTextSize()) {
            return false;
          }
          if (this.NZ.getTextScaleX() != paramObject.NZ.getTextScaleX()) {
            return false;
          }
          if (this.NZ.getTextSkewX() != paramObject.NZ.getTextSkewX()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 21)
          {
            if (this.NZ.getLetterSpacing() != paramObject.NZ.getLetterSpacing()) {
              return false;
            }
            if (!TextUtils.equals(this.NZ.getFontFeatureSettings(), paramObject.NZ.getFontFeatureSettings())) {
              return false;
            }
          }
          if (this.NZ.getFlags() != paramObject.NZ.getFlags()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 24)
          {
            if (!this.NZ.getTextLocales().equals(paramObject.NZ.getTextLocales())) {
              return false;
            }
          }
          else if ((Build.VERSION.SDK_INT >= 17) && (!this.NZ.getTextLocale().equals(paramObject.NZ.getTextLocale()))) {
            return false;
          }
          if (this.NZ.getTypeface() != null) {
            break;
          }
        } while (paramObject.NZ.getTypeface() == null);
        return false;
      } while (this.NZ.getTypeface().equals(paramObject.NZ.getTypeface()));
      return false;
    }
    
    public final int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return j.hash(new Object[] { Float.valueOf(this.NZ.getTextSize()), Float.valueOf(this.NZ.getTextScaleX()), Float.valueOf(this.NZ.getTextSkewX()), Float.valueOf(this.NZ.getLetterSpacing()), Integer.valueOf(this.NZ.getFlags()), this.NZ.getTextLocales(), this.NZ.getTypeface(), Boolean.valueOf(this.NZ.isElegantTextHeight()), this.Oa, Integer.valueOf(this.Ob), Integer.valueOf(this.Oc) });
      }
      if (Build.VERSION.SDK_INT >= 21) {
        return j.hash(new Object[] { Float.valueOf(this.NZ.getTextSize()), Float.valueOf(this.NZ.getTextScaleX()), Float.valueOf(this.NZ.getTextSkewX()), Float.valueOf(this.NZ.getLetterSpacing()), Integer.valueOf(this.NZ.getFlags()), this.NZ.getTextLocale(), this.NZ.getTypeface(), Boolean.valueOf(this.NZ.isElegantTextHeight()), this.Oa, Integer.valueOf(this.Ob), Integer.valueOf(this.Oc) });
      }
      if (Build.VERSION.SDK_INT >= 18) {
        return j.hash(new Object[] { Float.valueOf(this.NZ.getTextSize()), Float.valueOf(this.NZ.getTextScaleX()), Float.valueOf(this.NZ.getTextSkewX()), Integer.valueOf(this.NZ.getFlags()), this.NZ.getTextLocale(), this.NZ.getTypeface(), this.Oa, Integer.valueOf(this.Ob), Integer.valueOf(this.Oc) });
      }
      if (Build.VERSION.SDK_INT >= 17) {
        return j.hash(new Object[] { Float.valueOf(this.NZ.getTextSize()), Float.valueOf(this.NZ.getTextScaleX()), Float.valueOf(this.NZ.getTextSkewX()), Integer.valueOf(this.NZ.getFlags()), this.NZ.getTextLocale(), this.NZ.getTypeface(), this.Oa, Integer.valueOf(this.Ob), Integer.valueOf(this.Oc) });
      }
      return j.hash(new Object[] { Float.valueOf(this.NZ.getTextSize()), Float.valueOf(this.NZ.getTextScaleX()), Float.valueOf(this.NZ.getTextSkewX()), Integer.valueOf(this.NZ.getFlags()), this.NZ.getTypeface(), this.Oa, Integer.valueOf(this.Ob), Integer.valueOf(this.Oc) });
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("textSize=" + this.NZ.getTextSize());
      localStringBuilder.append(", textScaleX=" + this.NZ.getTextScaleX());
      localStringBuilder.append(", textSkewX=" + this.NZ.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        localStringBuilder.append(", letterSpacing=" + this.NZ.getLetterSpacing());
        localStringBuilder.append(", elegantTextHeight=" + this.NZ.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localStringBuilder.append(", textLocale=" + this.NZ.getTextLocales());
      }
      for (;;)
      {
        localStringBuilder.append(", typeface=" + this.NZ.getTypeface());
        if (Build.VERSION.SDK_INT >= 26) {
          localStringBuilder.append(", variationSettings=" + this.NZ.getFontVariationSettings());
        }
        localStringBuilder.append(", textDir=" + this.Oa);
        localStringBuilder.append(", breakStrategy=" + this.Ob);
        localStringBuilder.append(", hyphenationFrequency=" + this.Oc);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 17) {
          localStringBuilder.append(", textLocale=" + this.NZ.getTextLocale());
        }
      }
    }
    
    public static final class a
    {
      public final TextPaint NZ;
      public TextDirectionHeuristic Oa;
      public int Ob;
      public int Oc;
      
      public a(TextPaint paramTextPaint)
      {
        this.NZ = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.Ob = 1;
          this.Oc = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.Oa = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
          this.Oc = 0;
          this.Ob = 0;
        }
        this.Oa = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.d.c
 * JD-Core Version:    0.7.0.1
 */