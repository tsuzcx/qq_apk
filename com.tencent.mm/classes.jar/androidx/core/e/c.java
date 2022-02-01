package androidx.core.e;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.concurrent.Executor;

public class c
  implements Spannable
{
  private static Executor Mb;
  private static final Object sLock;
  private final Spannable Mc;
  public final a Md;
  private final PrecomputedText Me;
  
  static
  {
    AppMethodBeat.i(251275);
    sLock = new Object();
    Mb = null;
    AppMethodBeat.o(251275);
  }
  
  public char charAt(int paramInt)
  {
    AppMethodBeat.i(251271);
    char c = this.Mc.charAt(paramInt);
    AppMethodBeat.o(251271);
    return c;
  }
  
  public final PrecomputedText gR()
  {
    if ((this.Mc instanceof PrecomputedText)) {
      return (PrecomputedText)this.Mc;
    }
    return null;
  }
  
  public int getSpanEnd(Object paramObject)
  {
    AppMethodBeat.i(251266);
    int i = this.Mc.getSpanEnd(paramObject);
    AppMethodBeat.o(251266);
    return i;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    AppMethodBeat.i(251267);
    int i = this.Mc.getSpanFlags(paramObject);
    AppMethodBeat.o(251267);
    return i;
  }
  
  public int getSpanStart(Object paramObject)
  {
    AppMethodBeat.i(251265);
    int i = this.Mc.getSpanStart(paramObject);
    AppMethodBeat.o(251265);
    return i;
  }
  
  @SuppressLint({"NewApi"})
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    AppMethodBeat.i(251264);
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramClass = this.Me.getSpans(paramInt1, paramInt2, paramClass);
      AppMethodBeat.o(251264);
      return paramClass;
    }
    paramClass = this.Mc.getSpans(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(251264);
    return paramClass;
  }
  
  public int length()
  {
    AppMethodBeat.i(251270);
    int i = this.Mc.length();
    AppMethodBeat.o(251270);
    return i;
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    AppMethodBeat.i(251268);
    paramInt1 = this.Mc.nextSpanTransition(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(251268);
    return paramInt1;
  }
  
  @SuppressLint({"NewApi"})
  public void removeSpan(Object paramObject)
  {
    AppMethodBeat.i(251263);
    if ((paramObject instanceof MetricAffectingSpan))
    {
      paramObject = new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
      AppMethodBeat.o(251263);
      throw paramObject;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.Me.removeSpan(paramObject);
      AppMethodBeat.o(251263);
      return;
    }
    this.Mc.removeSpan(paramObject);
    AppMethodBeat.o(251263);
  }
  
  @SuppressLint({"NewApi"})
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(251261);
    if ((paramObject instanceof MetricAffectingSpan))
    {
      paramObject = new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
      AppMethodBeat.o(251261);
      throw paramObject;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.Me.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(251261);
      return;
    }
    this.Mc.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(251261);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251272);
    CharSequence localCharSequence = this.Mc.subSequence(paramInt1, paramInt2);
    AppMethodBeat.o(251272);
    return localCharSequence;
  }
  
  public String toString()
  {
    AppMethodBeat.i(251274);
    String str = this.Mc.toString();
    AppMethodBeat.o(251274);
    return str;
  }
  
  public static final class a
  {
    public final TextPaint Mf;
    public final TextDirectionHeuristic Mg;
    public final int Mh;
    public final int Mi;
    final PrecomputedText.Params Mj;
    
    public a(PrecomputedText.Params paramParams)
    {
      AppMethodBeat.i(251255);
      this.Mf = paramParams.getTextPaint();
      this.Mg = paramParams.getTextDirection();
      this.Mh = paramParams.getBreakStrategy();
      this.Mi = paramParams.getHyphenationFrequency();
      if (Build.VERSION.SDK_INT >= 29) {}
      for (;;)
      {
        this.Mj = paramParams;
        AppMethodBeat.o(251255);
        return;
        paramParams = null;
      }
    }
    
    @SuppressLint({"NewApi"})
    a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251254);
      if (Build.VERSION.SDK_INT >= 29) {}
      for (this.Mj = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.Mj = null)
      {
        this.Mf = paramTextPaint;
        this.Mg = paramTextDirectionHeuristic;
        this.Mh = paramInt1;
        this.Mi = paramInt2;
        AppMethodBeat.o(251254);
        return;
      }
    }
    
    public final boolean a(a parama)
    {
      AppMethodBeat.i(251256);
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.Mh != parama.Mh)
        {
          AppMethodBeat.o(251256);
          return false;
        }
        if (this.Mi != parama.Mi)
        {
          AppMethodBeat.o(251256);
          return false;
        }
      }
      if (this.Mf.getTextSize() != parama.Mf.getTextSize())
      {
        AppMethodBeat.o(251256);
        return false;
      }
      if (this.Mf.getTextScaleX() != parama.Mf.getTextScaleX())
      {
        AppMethodBeat.o(251256);
        return false;
      }
      if (this.Mf.getTextSkewX() != parama.Mf.getTextSkewX())
      {
        AppMethodBeat.o(251256);
        return false;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.Mf.getLetterSpacing() != parama.Mf.getLetterSpacing())
        {
          AppMethodBeat.o(251256);
          return false;
        }
        if (!TextUtils.equals(this.Mf.getFontFeatureSettings(), parama.Mf.getFontFeatureSettings()))
        {
          AppMethodBeat.o(251256);
          return false;
        }
      }
      if (this.Mf.getFlags() != parama.Mf.getFlags())
      {
        AppMethodBeat.o(251256);
        return false;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        if (!this.Mf.getTextLocales().equals(parama.Mf.getTextLocales()))
        {
          AppMethodBeat.o(251256);
          return false;
        }
      }
      else if ((Build.VERSION.SDK_INT >= 17) && (!this.Mf.getTextLocale().equals(parama.Mf.getTextLocale())))
      {
        AppMethodBeat.o(251256);
        return false;
      }
      if (this.Mf.getTypeface() == null)
      {
        if (parama.Mf.getTypeface() != null)
        {
          AppMethodBeat.o(251256);
          return false;
        }
      }
      else if (!this.Mf.getTypeface().equals(parama.Mf.getTypeface()))
      {
        AppMethodBeat.o(251256);
        return false;
      }
      AppMethodBeat.o(251256);
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(251257);
      if (paramObject == this)
      {
        AppMethodBeat.o(251257);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(251257);
        return false;
      }
      paramObject = (a)paramObject;
      if (!a(paramObject))
      {
        AppMethodBeat.o(251257);
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 18) && (this.Mg != paramObject.Mg))
      {
        AppMethodBeat.o(251257);
        return false;
      }
      AppMethodBeat.o(251257);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(251258);
      if (Build.VERSION.SDK_INT >= 24)
      {
        i = d.hash(new Object[] { Float.valueOf(this.Mf.getTextSize()), Float.valueOf(this.Mf.getTextScaleX()), Float.valueOf(this.Mf.getTextSkewX()), Float.valueOf(this.Mf.getLetterSpacing()), Integer.valueOf(this.Mf.getFlags()), this.Mf.getTextLocales(), this.Mf.getTypeface(), Boolean.valueOf(this.Mf.isElegantTextHeight()), this.Mg, Integer.valueOf(this.Mh), Integer.valueOf(this.Mi) });
        AppMethodBeat.o(251258);
        return i;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        i = d.hash(new Object[] { Float.valueOf(this.Mf.getTextSize()), Float.valueOf(this.Mf.getTextScaleX()), Float.valueOf(this.Mf.getTextSkewX()), Float.valueOf(this.Mf.getLetterSpacing()), Integer.valueOf(this.Mf.getFlags()), this.Mf.getTextLocale(), this.Mf.getTypeface(), Boolean.valueOf(this.Mf.isElegantTextHeight()), this.Mg, Integer.valueOf(this.Mh), Integer.valueOf(this.Mi) });
        AppMethodBeat.o(251258);
        return i;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        i = d.hash(new Object[] { Float.valueOf(this.Mf.getTextSize()), Float.valueOf(this.Mf.getTextScaleX()), Float.valueOf(this.Mf.getTextSkewX()), Integer.valueOf(this.Mf.getFlags()), this.Mf.getTextLocale(), this.Mf.getTypeface(), this.Mg, Integer.valueOf(this.Mh), Integer.valueOf(this.Mi) });
        AppMethodBeat.o(251258);
        return i;
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        i = d.hash(new Object[] { Float.valueOf(this.Mf.getTextSize()), Float.valueOf(this.Mf.getTextScaleX()), Float.valueOf(this.Mf.getTextSkewX()), Integer.valueOf(this.Mf.getFlags()), this.Mf.getTextLocale(), this.Mf.getTypeface(), this.Mg, Integer.valueOf(this.Mh), Integer.valueOf(this.Mi) });
        AppMethodBeat.o(251258);
        return i;
      }
      int i = d.hash(new Object[] { Float.valueOf(this.Mf.getTextSize()), Float.valueOf(this.Mf.getTextScaleX()), Float.valueOf(this.Mf.getTextSkewX()), Integer.valueOf(this.Mf.getFlags()), this.Mf.getTypeface(), this.Mg, Integer.valueOf(this.Mh), Integer.valueOf(this.Mi) });
      AppMethodBeat.o(251258);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(251259);
      Object localObject = new StringBuilder("{");
      ((StringBuilder)localObject).append("textSize=" + this.Mf.getTextSize());
      ((StringBuilder)localObject).append(", textScaleX=" + this.Mf.getTextScaleX());
      ((StringBuilder)localObject).append(", textSkewX=" + this.Mf.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        ((StringBuilder)localObject).append(", letterSpacing=" + this.Mf.getLetterSpacing());
        ((StringBuilder)localObject).append(", elegantTextHeight=" + this.Mf.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24) {
        ((StringBuilder)localObject).append(", textLocale=" + this.Mf.getTextLocales());
      }
      for (;;)
      {
        ((StringBuilder)localObject).append(", typeface=" + this.Mf.getTypeface());
        if (Build.VERSION.SDK_INT >= 26) {
          ((StringBuilder)localObject).append(", variationSettings=" + this.Mf.getFontVariationSettings());
        }
        ((StringBuilder)localObject).append(", textDir=" + this.Mg);
        ((StringBuilder)localObject).append(", breakStrategy=" + this.Mh);
        ((StringBuilder)localObject).append(", hyphenationFrequency=" + this.Mi);
        ((StringBuilder)localObject).append("}");
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(251259);
        return localObject;
        if (Build.VERSION.SDK_INT >= 17) {
          ((StringBuilder)localObject).append(", textLocale=" + this.Mf.getTextLocale());
        }
      }
    }
    
    public static final class a
    {
      private final TextPaint Mf;
      public TextDirectionHeuristic Mg;
      public int Mh;
      public int Mi;
      
      public a(TextPaint paramTextPaint)
      {
        AppMethodBeat.i(251223);
        this.Mf = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.Mh = 1;
          this.Mi = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.Mg = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          AppMethodBeat.o(251223);
          return;
          this.Mi = 0;
          this.Mh = 0;
        }
        this.Mg = null;
        AppMethodBeat.o(251223);
      }
      
      public final c.a gS()
      {
        AppMethodBeat.i(251225);
        c.a locala = new c.a(this.Mf, this.Mg, this.Mh, this.Mi);
        AppMethodBeat.o(251225);
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.e.c
 * JD-Core Version:    0.7.0.1
 */