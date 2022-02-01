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
  private static Executor Oh = null;
  private static final Object sLock = new Object();
  public final Spannable Oi;
  public final a Oj;
  private final PrecomputedText Ok;
  
  public final char charAt(int paramInt)
  {
    return this.Oi.charAt(paramInt);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    return this.Oi.getSpanEnd(paramObject);
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    return this.Oi.getSpanFlags(paramObject);
  }
  
  public final int getSpanStart(Object paramObject)
  {
    return this.Oi.getSpanStart(paramObject);
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.Ok.getSpans(paramInt1, paramInt2, paramClass);
    }
    return this.Oi.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public final int length()
  {
    return this.Oi.length();
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.Oi.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public final void removeSpan(Object paramObject)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Ok.removeSpan(paramObject);
      return;
    }
    this.Oi.removeSpan(paramObject);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Ok.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    this.Oi.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.Oi.subSequence(paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return this.Oi.toString();
  }
  
  public static final class a
  {
    public final TextPaint Ol;
    public final TextDirectionHeuristic Om;
    public final int On;
    public final int Oo;
    final PrecomputedText.Params Op;
    
    public a(PrecomputedText.Params paramParams)
    {
      this.Ol = paramParams.getTextPaint();
      this.Om = paramParams.getTextDirection();
      this.On = paramParams.getBreakStrategy();
      this.Oo = paramParams.getHyphenationFrequency();
      this.Op = paramParams;
    }
    
    public a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28) {}
      for (this.Op = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.Op = null)
      {
        this.Ol = paramTextPaint;
        this.Om = paramTextDirectionHeuristic;
        this.On = paramInt1;
        this.Oo = paramInt2;
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
          if (this.Op != null) {
            return this.Op.equals(paramObject.Op);
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.On != paramObject.On) {
              return false;
            }
            if (this.Oo != paramObject.Oo) {
              return false;
            }
          }
          if ((Build.VERSION.SDK_INT >= 18) && (this.Om != paramObject.Om)) {
            return false;
          }
          if (this.Ol.getTextSize() != paramObject.Ol.getTextSize()) {
            return false;
          }
          if (this.Ol.getTextScaleX() != paramObject.Ol.getTextScaleX()) {
            return false;
          }
          if (this.Ol.getTextSkewX() != paramObject.Ol.getTextSkewX()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 21)
          {
            if (this.Ol.getLetterSpacing() != paramObject.Ol.getLetterSpacing()) {
              return false;
            }
            if (!TextUtils.equals(this.Ol.getFontFeatureSettings(), paramObject.Ol.getFontFeatureSettings())) {
              return false;
            }
          }
          if (this.Ol.getFlags() != paramObject.Ol.getFlags()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 24)
          {
            if (!this.Ol.getTextLocales().equals(paramObject.Ol.getTextLocales())) {
              return false;
            }
          }
          else if ((Build.VERSION.SDK_INT >= 17) && (!this.Ol.getTextLocale().equals(paramObject.Ol.getTextLocale()))) {
            return false;
          }
          if (this.Ol.getTypeface() != null) {
            break;
          }
        } while (paramObject.Ol.getTypeface() == null);
        return false;
      } while (this.Ol.getTypeface().equals(paramObject.Ol.getTypeface()));
      return false;
    }
    
    public final int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return j.hash(new Object[] { Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Float.valueOf(this.Ol.getLetterSpacing()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocales(), this.Ol.getTypeface(), Boolean.valueOf(this.Ol.isElegantTextHeight()), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo) });
      }
      if (Build.VERSION.SDK_INT >= 21) {
        return j.hash(new Object[] { Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Float.valueOf(this.Ol.getLetterSpacing()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocale(), this.Ol.getTypeface(), Boolean.valueOf(this.Ol.isElegantTextHeight()), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo) });
      }
      if (Build.VERSION.SDK_INT >= 18) {
        return j.hash(new Object[] { Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocale(), this.Ol.getTypeface(), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo) });
      }
      if (Build.VERSION.SDK_INT >= 17) {
        return j.hash(new Object[] { Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTextLocale(), this.Ol.getTypeface(), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo) });
      }
      return j.hash(new Object[] { Float.valueOf(this.Ol.getTextSize()), Float.valueOf(this.Ol.getTextScaleX()), Float.valueOf(this.Ol.getTextSkewX()), Integer.valueOf(this.Ol.getFlags()), this.Ol.getTypeface(), this.Om, Integer.valueOf(this.On), Integer.valueOf(this.Oo) });
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("textSize=" + this.Ol.getTextSize());
      localStringBuilder.append(", textScaleX=" + this.Ol.getTextScaleX());
      localStringBuilder.append(", textSkewX=" + this.Ol.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        localStringBuilder.append(", letterSpacing=" + this.Ol.getLetterSpacing());
        localStringBuilder.append(", elegantTextHeight=" + this.Ol.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localStringBuilder.append(", textLocale=" + this.Ol.getTextLocales());
      }
      for (;;)
      {
        localStringBuilder.append(", typeface=" + this.Ol.getTypeface());
        if (Build.VERSION.SDK_INT >= 26) {
          localStringBuilder.append(", variationSettings=" + this.Ol.getFontVariationSettings());
        }
        localStringBuilder.append(", textDir=" + this.Om);
        localStringBuilder.append(", breakStrategy=" + this.On);
        localStringBuilder.append(", hyphenationFrequency=" + this.Oo);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 17) {
          localStringBuilder.append(", textLocale=" + this.Ol.getTextLocale());
        }
      }
    }
    
    public static final class a
    {
      public final TextPaint Ol;
      public TextDirectionHeuristic Om;
      public int On;
      public int Oo;
      
      public a(TextPaint paramTextPaint)
      {
        this.Ol = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.On = 1;
          this.Oo = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.Om = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
          this.Oo = 0;
          this.On = 0;
        }
        this.Om = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.d.c
 * JD-Core Version:    0.7.0.1
 */