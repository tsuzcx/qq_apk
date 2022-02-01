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
  private static Executor Md = null;
  private static final Object sLock = new Object();
  public final Spannable Me;
  public final a Mf;
  private final PrecomputedText Mg;
  
  public final char charAt(int paramInt)
  {
    return this.Me.charAt(paramInt);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    return this.Me.getSpanEnd(paramObject);
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    return this.Me.getSpanFlags(paramObject);
  }
  
  public final int getSpanStart(Object paramObject)
  {
    return this.Me.getSpanStart(paramObject);
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.Mg.getSpans(paramInt1, paramInt2, paramClass);
    }
    return this.Me.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public final int length()
  {
    return this.Me.length();
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.Me.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public final void removeSpan(Object paramObject)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Mg.removeSpan(paramObject);
      return;
    }
    this.Me.removeSpan(paramObject);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Mg.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    this.Me.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.Me.subSequence(paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return this.Me.toString();
  }
  
  public static final class a
  {
    public final TextPaint Mh;
    public final TextDirectionHeuristic Mi;
    public final int Mj;
    public final int Mk;
    final PrecomputedText.Params Ml;
    
    public a(PrecomputedText.Params paramParams)
    {
      this.Mh = paramParams.getTextPaint();
      this.Mi = paramParams.getTextDirection();
      this.Mj = paramParams.getBreakStrategy();
      this.Mk = paramParams.getHyphenationFrequency();
      this.Ml = paramParams;
    }
    
    public a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28) {}
      for (this.Ml = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.Ml = null)
      {
        this.Mh = paramTextPaint;
        this.Mi = paramTextDirectionHeuristic;
        this.Mj = paramInt1;
        this.Mk = paramInt2;
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
          if (this.Ml != null) {
            return this.Ml.equals(paramObject.Ml);
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.Mj != paramObject.Mj) {
              return false;
            }
            if (this.Mk != paramObject.Mk) {
              return false;
            }
          }
          if ((Build.VERSION.SDK_INT >= 18) && (this.Mi != paramObject.Mi)) {
            return false;
          }
          if (this.Mh.getTextSize() != paramObject.Mh.getTextSize()) {
            return false;
          }
          if (this.Mh.getTextScaleX() != paramObject.Mh.getTextScaleX()) {
            return false;
          }
          if (this.Mh.getTextSkewX() != paramObject.Mh.getTextSkewX()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 21)
          {
            if (this.Mh.getLetterSpacing() != paramObject.Mh.getLetterSpacing()) {
              return false;
            }
            if (!TextUtils.equals(this.Mh.getFontFeatureSettings(), paramObject.Mh.getFontFeatureSettings())) {
              return false;
            }
          }
          if (this.Mh.getFlags() != paramObject.Mh.getFlags()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 24)
          {
            if (!this.Mh.getTextLocales().equals(paramObject.Mh.getTextLocales())) {
              return false;
            }
          }
          else if ((Build.VERSION.SDK_INT >= 17) && (!this.Mh.getTextLocale().equals(paramObject.Mh.getTextLocale()))) {
            return false;
          }
          if (this.Mh.getTypeface() != null) {
            break;
          }
        } while (paramObject.Mh.getTypeface() == null);
        return false;
      } while (this.Mh.getTypeface().equals(paramObject.Mh.getTypeface()));
      return false;
    }
    
    public final int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return j.hash(new Object[] { Float.valueOf(this.Mh.getTextSize()), Float.valueOf(this.Mh.getTextScaleX()), Float.valueOf(this.Mh.getTextSkewX()), Float.valueOf(this.Mh.getLetterSpacing()), Integer.valueOf(this.Mh.getFlags()), this.Mh.getTextLocales(), this.Mh.getTypeface(), Boolean.valueOf(this.Mh.isElegantTextHeight()), this.Mi, Integer.valueOf(this.Mj), Integer.valueOf(this.Mk) });
      }
      if (Build.VERSION.SDK_INT >= 21) {
        return j.hash(new Object[] { Float.valueOf(this.Mh.getTextSize()), Float.valueOf(this.Mh.getTextScaleX()), Float.valueOf(this.Mh.getTextSkewX()), Float.valueOf(this.Mh.getLetterSpacing()), Integer.valueOf(this.Mh.getFlags()), this.Mh.getTextLocale(), this.Mh.getTypeface(), Boolean.valueOf(this.Mh.isElegantTextHeight()), this.Mi, Integer.valueOf(this.Mj), Integer.valueOf(this.Mk) });
      }
      if (Build.VERSION.SDK_INT >= 18) {
        return j.hash(new Object[] { Float.valueOf(this.Mh.getTextSize()), Float.valueOf(this.Mh.getTextScaleX()), Float.valueOf(this.Mh.getTextSkewX()), Integer.valueOf(this.Mh.getFlags()), this.Mh.getTextLocale(), this.Mh.getTypeface(), this.Mi, Integer.valueOf(this.Mj), Integer.valueOf(this.Mk) });
      }
      if (Build.VERSION.SDK_INT >= 17) {
        return j.hash(new Object[] { Float.valueOf(this.Mh.getTextSize()), Float.valueOf(this.Mh.getTextScaleX()), Float.valueOf(this.Mh.getTextSkewX()), Integer.valueOf(this.Mh.getFlags()), this.Mh.getTextLocale(), this.Mh.getTypeface(), this.Mi, Integer.valueOf(this.Mj), Integer.valueOf(this.Mk) });
      }
      return j.hash(new Object[] { Float.valueOf(this.Mh.getTextSize()), Float.valueOf(this.Mh.getTextScaleX()), Float.valueOf(this.Mh.getTextSkewX()), Integer.valueOf(this.Mh.getFlags()), this.Mh.getTypeface(), this.Mi, Integer.valueOf(this.Mj), Integer.valueOf(this.Mk) });
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("textSize=" + this.Mh.getTextSize());
      localStringBuilder.append(", textScaleX=" + this.Mh.getTextScaleX());
      localStringBuilder.append(", textSkewX=" + this.Mh.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        localStringBuilder.append(", letterSpacing=" + this.Mh.getLetterSpacing());
        localStringBuilder.append(", elegantTextHeight=" + this.Mh.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localStringBuilder.append(", textLocale=" + this.Mh.getTextLocales());
      }
      for (;;)
      {
        localStringBuilder.append(", typeface=" + this.Mh.getTypeface());
        if (Build.VERSION.SDK_INT >= 26) {
          localStringBuilder.append(", variationSettings=" + this.Mh.getFontVariationSettings());
        }
        localStringBuilder.append(", textDir=" + this.Mi);
        localStringBuilder.append(", breakStrategy=" + this.Mj);
        localStringBuilder.append(", hyphenationFrequency=" + this.Mk);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 17) {
          localStringBuilder.append(", textLocale=" + this.Mh.getTextLocale());
        }
      }
    }
    
    public static final class a
    {
      public final TextPaint Mh;
      public TextDirectionHeuristic Mi;
      public int Mj;
      public int Mk;
      
      public a(TextPaint paramTextPaint)
      {
        this.Mh = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.Mj = 1;
          this.Mk = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.Mi = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
          this.Mk = 0;
          this.Mj = 0;
        }
        this.Mi = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.d.c
 * JD-Core Version:    0.7.0.1
 */