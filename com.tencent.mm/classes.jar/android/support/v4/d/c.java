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
  private static Executor Li = null;
  private static final Object sLock = new Object();
  public final Spannable Lj;
  public final a Lk;
  private final PrecomputedText Ll;
  
  public final char charAt(int paramInt)
  {
    return this.Lj.charAt(paramInt);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    return this.Lj.getSpanEnd(paramObject);
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    return this.Lj.getSpanFlags(paramObject);
  }
  
  public final int getSpanStart(Object paramObject)
  {
    return this.Lj.getSpanStart(paramObject);
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.Ll.getSpans(paramInt1, paramInt2, paramClass);
    }
    return this.Lj.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public final int length()
  {
    return this.Lj.length();
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.Lj.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public final void removeSpan(Object paramObject)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Ll.removeSpan(paramObject);
      return;
    }
    this.Lj.removeSpan(paramObject);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Ll.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    this.Lj.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.Lj.subSequence(paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return this.Lj.toString();
  }
  
  public static final class a
  {
    public final TextPaint Lm;
    public final TextDirectionHeuristic Ln;
    public final int Lo;
    public final int Lp;
    final PrecomputedText.Params Lq;
    
    public a(PrecomputedText.Params paramParams)
    {
      this.Lm = paramParams.getTextPaint();
      this.Ln = paramParams.getTextDirection();
      this.Lo = paramParams.getBreakStrategy();
      this.Lp = paramParams.getHyphenationFrequency();
      this.Lq = paramParams;
    }
    
    public a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28) {}
      for (this.Lq = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.Lq = null)
      {
        this.Lm = paramTextPaint;
        this.Ln = paramTextDirectionHeuristic;
        this.Lo = paramInt1;
        this.Lp = paramInt2;
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
          if (this.Lq != null) {
            return this.Lq.equals(paramObject.Lq);
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.Lo != paramObject.Lo) {
              return false;
            }
            if (this.Lp != paramObject.Lp) {
              return false;
            }
          }
          if ((Build.VERSION.SDK_INT >= 18) && (this.Ln != paramObject.Ln)) {
            return false;
          }
          if (this.Lm.getTextSize() != paramObject.Lm.getTextSize()) {
            return false;
          }
          if (this.Lm.getTextScaleX() != paramObject.Lm.getTextScaleX()) {
            return false;
          }
          if (this.Lm.getTextSkewX() != paramObject.Lm.getTextSkewX()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 21)
          {
            if (this.Lm.getLetterSpacing() != paramObject.Lm.getLetterSpacing()) {
              return false;
            }
            if (!TextUtils.equals(this.Lm.getFontFeatureSettings(), paramObject.Lm.getFontFeatureSettings())) {
              return false;
            }
          }
          if (this.Lm.getFlags() != paramObject.Lm.getFlags()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 24)
          {
            if (!this.Lm.getTextLocales().equals(paramObject.Lm.getTextLocales())) {
              return false;
            }
          }
          else if ((Build.VERSION.SDK_INT >= 17) && (!this.Lm.getTextLocale().equals(paramObject.Lm.getTextLocale()))) {
            return false;
          }
          if (this.Lm.getTypeface() != null) {
            break;
          }
        } while (paramObject.Lm.getTypeface() == null);
        return false;
      } while (this.Lm.getTypeface().equals(paramObject.Lm.getTypeface()));
      return false;
    }
    
    public final int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return j.hash(new Object[] { Float.valueOf(this.Lm.getTextSize()), Float.valueOf(this.Lm.getTextScaleX()), Float.valueOf(this.Lm.getTextSkewX()), Float.valueOf(this.Lm.getLetterSpacing()), Integer.valueOf(this.Lm.getFlags()), this.Lm.getTextLocales(), this.Lm.getTypeface(), Boolean.valueOf(this.Lm.isElegantTextHeight()), this.Ln, Integer.valueOf(this.Lo), Integer.valueOf(this.Lp) });
      }
      if (Build.VERSION.SDK_INT >= 21) {
        return j.hash(new Object[] { Float.valueOf(this.Lm.getTextSize()), Float.valueOf(this.Lm.getTextScaleX()), Float.valueOf(this.Lm.getTextSkewX()), Float.valueOf(this.Lm.getLetterSpacing()), Integer.valueOf(this.Lm.getFlags()), this.Lm.getTextLocale(), this.Lm.getTypeface(), Boolean.valueOf(this.Lm.isElegantTextHeight()), this.Ln, Integer.valueOf(this.Lo), Integer.valueOf(this.Lp) });
      }
      if (Build.VERSION.SDK_INT >= 18) {
        return j.hash(new Object[] { Float.valueOf(this.Lm.getTextSize()), Float.valueOf(this.Lm.getTextScaleX()), Float.valueOf(this.Lm.getTextSkewX()), Integer.valueOf(this.Lm.getFlags()), this.Lm.getTextLocale(), this.Lm.getTypeface(), this.Ln, Integer.valueOf(this.Lo), Integer.valueOf(this.Lp) });
      }
      if (Build.VERSION.SDK_INT >= 17) {
        return j.hash(new Object[] { Float.valueOf(this.Lm.getTextSize()), Float.valueOf(this.Lm.getTextScaleX()), Float.valueOf(this.Lm.getTextSkewX()), Integer.valueOf(this.Lm.getFlags()), this.Lm.getTextLocale(), this.Lm.getTypeface(), this.Ln, Integer.valueOf(this.Lo), Integer.valueOf(this.Lp) });
      }
      return j.hash(new Object[] { Float.valueOf(this.Lm.getTextSize()), Float.valueOf(this.Lm.getTextScaleX()), Float.valueOf(this.Lm.getTextSkewX()), Integer.valueOf(this.Lm.getFlags()), this.Lm.getTypeface(), this.Ln, Integer.valueOf(this.Lo), Integer.valueOf(this.Lp) });
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("textSize=" + this.Lm.getTextSize());
      localStringBuilder.append(", textScaleX=" + this.Lm.getTextScaleX());
      localStringBuilder.append(", textSkewX=" + this.Lm.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        localStringBuilder.append(", letterSpacing=" + this.Lm.getLetterSpacing());
        localStringBuilder.append(", elegantTextHeight=" + this.Lm.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localStringBuilder.append(", textLocale=" + this.Lm.getTextLocales());
      }
      for (;;)
      {
        localStringBuilder.append(", typeface=" + this.Lm.getTypeface());
        if (Build.VERSION.SDK_INT >= 26) {
          localStringBuilder.append(", variationSettings=" + this.Lm.getFontVariationSettings());
        }
        localStringBuilder.append(", textDir=" + this.Ln);
        localStringBuilder.append(", breakStrategy=" + this.Lo);
        localStringBuilder.append(", hyphenationFrequency=" + this.Lp);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 17) {
          localStringBuilder.append(", textLocale=" + this.Lm.getTextLocale());
        }
      }
    }
    
    public static final class a
    {
      public final TextPaint Lm;
      public TextDirectionHeuristic Ln;
      public int Lo;
      public int Lp;
      
      public a(TextPaint paramTextPaint)
      {
        this.Lm = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.Lo = 1;
          this.Lp = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.Ln = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
          this.Lp = 0;
          this.Lo = 0;
        }
        this.Ln = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.d.c
 * JD-Core Version:    0.7.0.1
 */