package android.support.v4.d;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.support.v4.e.i;
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

public final class b
  implements Spannable
{
  private static Executor Ek = null;
  private static final Object sLock = new Object();
  public final Spannable El;
  public final a Em;
  private final PrecomputedText En;
  
  public final char charAt(int paramInt)
  {
    return this.El.charAt(paramInt);
  }
  
  public final int getSpanEnd(Object paramObject)
  {
    return this.El.getSpanEnd(paramObject);
  }
  
  public final int getSpanFlags(Object paramObject)
  {
    return this.El.getSpanFlags(paramObject);
  }
  
  public final int getSpanStart(Object paramObject)
  {
    return this.El.getSpanStart(paramObject);
  }
  
  public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.En.getSpans(paramInt1, paramInt2, paramClass);
    }
    return this.El.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public final int length()
  {
    return this.El.length();
  }
  
  public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.El.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public final void removeSpan(Object paramObject)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.En.removeSpan(paramObject);
      return;
    }
    this.El.removeSpan(paramObject);
  }
  
  public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof MetricAffectingSpan)) {
      throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.En.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    this.El.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.El.subSequence(paramInt1, paramInt2);
  }
  
  public final String toString()
  {
    return this.El.toString();
  }
  
  public static final class a
  {
    public final TextDirectionHeuristic Eo;
    public final int Ep;
    public final int Eq;
    final PrecomputedText.Params Er;
    public final TextPaint mPaint;
    
    public a(PrecomputedText.Params paramParams)
    {
      this.mPaint = paramParams.getTextPaint();
      this.Eo = paramParams.getTextDirection();
      this.Ep = paramParams.getBreakStrategy();
      this.Eq = paramParams.getHyphenationFrequency();
      this.Er = paramParams;
    }
    
    public a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28) {}
      for (this.Er = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.Er = null)
      {
        this.mPaint = paramTextPaint;
        this.Eo = paramTextDirectionHeuristic;
        this.Ep = paramInt1;
        this.Eq = paramInt2;
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
          if (this.Er != null) {
            return this.Er.equals(paramObject.Er);
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.Ep != paramObject.Ep) {
              return false;
            }
            if (this.Eq != paramObject.Eq) {
              return false;
            }
          }
          if ((Build.VERSION.SDK_INT >= 18) && (this.Eo != paramObject.Eo)) {
            return false;
          }
          if (this.mPaint.getTextSize() != paramObject.mPaint.getTextSize()) {
            return false;
          }
          if (this.mPaint.getTextScaleX() != paramObject.mPaint.getTextScaleX()) {
            return false;
          }
          if (this.mPaint.getTextSkewX() != paramObject.mPaint.getTextSkewX()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 21)
          {
            if (this.mPaint.getLetterSpacing() != paramObject.mPaint.getLetterSpacing()) {
              return false;
            }
            if (!TextUtils.equals(this.mPaint.getFontFeatureSettings(), paramObject.mPaint.getFontFeatureSettings())) {
              return false;
            }
          }
          if (this.mPaint.getFlags() != paramObject.mPaint.getFlags()) {
            return false;
          }
          if (Build.VERSION.SDK_INT >= 24)
          {
            if (!this.mPaint.getTextLocales().equals(paramObject.mPaint.getTextLocales())) {
              return false;
            }
          }
          else if ((Build.VERSION.SDK_INT >= 17) && (!this.mPaint.getTextLocale().equals(paramObject.mPaint.getTextLocale()))) {
            return false;
          }
          if (this.mPaint.getTypeface() != null) {
            break;
          }
        } while (paramObject.mPaint.getTypeface() == null);
        return false;
      } while (this.mPaint.getTypeface().equals(paramObject.mPaint.getTypeface()));
      return false;
    }
    
    public final int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return i.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.Eo, Integer.valueOf(this.Ep), Integer.valueOf(this.Eq) });
      }
      if (Build.VERSION.SDK_INT >= 21) {
        return i.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.Eo, Integer.valueOf(this.Ep), Integer.valueOf(this.Eq) });
      }
      if (Build.VERSION.SDK_INT >= 18) {
        return i.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.Eo, Integer.valueOf(this.Ep), Integer.valueOf(this.Eq) });
      }
      if (Build.VERSION.SDK_INT >= 17) {
        return i.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.Eo, Integer.valueOf(this.Ep), Integer.valueOf(this.Eq) });
      }
      return i.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.Eo, Integer.valueOf(this.Ep), Integer.valueOf(this.Eq) });
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("textSize=" + this.mPaint.getTextSize());
      localStringBuilder.append(", textScaleX=" + this.mPaint.getTextScaleX());
      localStringBuilder.append(", textSkewX=" + this.mPaint.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        localStringBuilder.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
        localStringBuilder.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocales());
      }
      for (;;)
      {
        localStringBuilder.append(", typeface=" + this.mPaint.getTypeface());
        if (Build.VERSION.SDK_INT >= 26) {
          localStringBuilder.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
        }
        localStringBuilder.append(", textDir=" + this.Eo);
        localStringBuilder.append(", breakStrategy=" + this.Ep);
        localStringBuilder.append(", hyphenationFrequency=" + this.Eq);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 17) {
          localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocale());
        }
      }
    }
    
    public static final class a
    {
      public TextDirectionHeuristic Eo;
      public int Ep;
      public int Eq;
      public final TextPaint mPaint;
      
      public a(TextPaint paramTextPaint)
      {
        this.mPaint = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.Ep = 1;
          this.Eq = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.Eo = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
          this.Eq = 0;
          this.Ep = 0;
        }
        this.Eo = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.d.b
 * JD-Core Version:    0.7.0.1
 */