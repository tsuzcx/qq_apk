package androidx.core.e;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class c$a
{
  public final TextPaint bsk;
  public final TextDirectionHeuristic bsl;
  public final int bsm;
  public final int bsn;
  final PrecomputedText.Params bso;
  
  public c$a(PrecomputedText.Params paramParams)
  {
    AppMethodBeat.i(195499);
    this.bsk = paramParams.getTextPaint();
    this.bsl = paramParams.getTextDirection();
    this.bsm = paramParams.getBreakStrategy();
    this.bsn = paramParams.getHyphenationFrequency();
    if (Build.VERSION.SDK_INT >= 29) {}
    for (;;)
    {
      this.bso = paramParams;
      AppMethodBeat.o(195499);
      return;
      paramParams = null;
    }
  }
  
  public c$a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195488);
    if (Build.VERSION.SDK_INT >= 29) {}
    for (this.bso = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.bso = null)
    {
      this.bsk = paramTextPaint;
      this.bsl = paramTextDirectionHeuristic;
      this.bsm = paramInt1;
      this.bsn = paramInt2;
      AppMethodBeat.o(195488);
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(195510);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.bsm != parama.bsm)
      {
        AppMethodBeat.o(195510);
        return false;
      }
      if (this.bsn != parama.bsn)
      {
        AppMethodBeat.o(195510);
        return false;
      }
    }
    if (this.bsk.getTextSize() != parama.bsk.getTextSize())
    {
      AppMethodBeat.o(195510);
      return false;
    }
    if (this.bsk.getTextScaleX() != parama.bsk.getTextScaleX())
    {
      AppMethodBeat.o(195510);
      return false;
    }
    if (this.bsk.getTextSkewX() != parama.bsk.getTextSkewX())
    {
      AppMethodBeat.o(195510);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.bsk.getLetterSpacing() != parama.bsk.getLetterSpacing())
      {
        AppMethodBeat.o(195510);
        return false;
      }
      if (!TextUtils.equals(this.bsk.getFontFeatureSettings(), parama.bsk.getFontFeatureSettings()))
      {
        AppMethodBeat.o(195510);
        return false;
      }
    }
    if (this.bsk.getFlags() != parama.bsk.getFlags())
    {
      AppMethodBeat.o(195510);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (!this.bsk.getTextLocales().equals(parama.bsk.getTextLocales()))
      {
        AppMethodBeat.o(195510);
        return false;
      }
    }
    else if ((Build.VERSION.SDK_INT >= 17) && (!this.bsk.getTextLocale().equals(parama.bsk.getTextLocale())))
    {
      AppMethodBeat.o(195510);
      return false;
    }
    if (this.bsk.getTypeface() == null)
    {
      if (parama.bsk.getTypeface() != null)
      {
        AppMethodBeat.o(195510);
        return false;
      }
    }
    else if (!this.bsk.getTypeface().equals(parama.bsk.getTypeface()))
    {
      AppMethodBeat.o(195510);
      return false;
    }
    AppMethodBeat.o(195510);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195522);
    if (paramObject == this)
    {
      AppMethodBeat.o(195522);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(195522);
      return false;
    }
    paramObject = (a)paramObject;
    if (!a(paramObject))
    {
      AppMethodBeat.o(195522);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 18) && (this.bsl != paramObject.bsl))
    {
      AppMethodBeat.o(195522);
      return false;
    }
    AppMethodBeat.o(195522);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(195541);
    if (Build.VERSION.SDK_INT >= 24)
    {
      i = c.hash(new Object[] { Float.valueOf(this.bsk.getTextSize()), Float.valueOf(this.bsk.getTextScaleX()), Float.valueOf(this.bsk.getTextSkewX()), Float.valueOf(this.bsk.getLetterSpacing()), Integer.valueOf(this.bsk.getFlags()), this.bsk.getTextLocales(), this.bsk.getTypeface(), Boolean.valueOf(this.bsk.isElegantTextHeight()), this.bsl, Integer.valueOf(this.bsm), Integer.valueOf(this.bsn) });
      AppMethodBeat.o(195541);
      return i;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = c.hash(new Object[] { Float.valueOf(this.bsk.getTextSize()), Float.valueOf(this.bsk.getTextScaleX()), Float.valueOf(this.bsk.getTextSkewX()), Float.valueOf(this.bsk.getLetterSpacing()), Integer.valueOf(this.bsk.getFlags()), this.bsk.getTextLocale(), this.bsk.getTypeface(), Boolean.valueOf(this.bsk.isElegantTextHeight()), this.bsl, Integer.valueOf(this.bsm), Integer.valueOf(this.bsn) });
      AppMethodBeat.o(195541);
      return i;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      i = c.hash(new Object[] { Float.valueOf(this.bsk.getTextSize()), Float.valueOf(this.bsk.getTextScaleX()), Float.valueOf(this.bsk.getTextSkewX()), Integer.valueOf(this.bsk.getFlags()), this.bsk.getTextLocale(), this.bsk.getTypeface(), this.bsl, Integer.valueOf(this.bsm), Integer.valueOf(this.bsn) });
      AppMethodBeat.o(195541);
      return i;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      i = c.hash(new Object[] { Float.valueOf(this.bsk.getTextSize()), Float.valueOf(this.bsk.getTextScaleX()), Float.valueOf(this.bsk.getTextSkewX()), Integer.valueOf(this.bsk.getFlags()), this.bsk.getTextLocale(), this.bsk.getTypeface(), this.bsl, Integer.valueOf(this.bsm), Integer.valueOf(this.bsn) });
      AppMethodBeat.o(195541);
      return i;
    }
    int i = c.hash(new Object[] { Float.valueOf(this.bsk.getTextSize()), Float.valueOf(this.bsk.getTextScaleX()), Float.valueOf(this.bsk.getTextSkewX()), Integer.valueOf(this.bsk.getFlags()), this.bsk.getTypeface(), this.bsl, Integer.valueOf(this.bsm), Integer.valueOf(this.bsn) });
    AppMethodBeat.o(195541);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195555);
    Object localObject = new StringBuilder("{");
    ((StringBuilder)localObject).append("textSize=" + this.bsk.getTextSize());
    ((StringBuilder)localObject).append(", textScaleX=" + this.bsk.getTextScaleX());
    ((StringBuilder)localObject).append(", textSkewX=" + this.bsk.getTextSkewX());
    if (Build.VERSION.SDK_INT >= 21)
    {
      ((StringBuilder)localObject).append(", letterSpacing=" + this.bsk.getLetterSpacing());
      ((StringBuilder)localObject).append(", elegantTextHeight=" + this.bsk.isElegantTextHeight());
    }
    if (Build.VERSION.SDK_INT >= 24) {
      ((StringBuilder)localObject).append(", textLocale=" + this.bsk.getTextLocales());
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(", typeface=" + this.bsk.getTypeface());
      if (Build.VERSION.SDK_INT >= 26) {
        ((StringBuilder)localObject).append(", variationSettings=" + this.bsk.getFontVariationSettings());
      }
      ((StringBuilder)localObject).append(", textDir=" + this.bsl);
      ((StringBuilder)localObject).append(", breakStrategy=" + this.bsm);
      ((StringBuilder)localObject).append(", hyphenationFrequency=" + this.bsn);
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(195555);
      return localObject;
      if (Build.VERSION.SDK_INT >= 17) {
        ((StringBuilder)localObject).append(", textLocale=" + this.bsk.getTextLocale());
      }
    }
  }
  
  public static final class a
  {
    public final TextPaint bsk;
    public TextDirectionHeuristic bsl;
    public int bsm;
    public int bsn;
    
    public a(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(195485);
      this.bsk = paramTextPaint;
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.bsm = 1;
        this.bsn = 1;
      }
      while (Build.VERSION.SDK_INT >= 18)
      {
        this.bsl = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        AppMethodBeat.o(195485);
        return;
        this.bsn = 0;
        this.bsm = 0;
      }
      this.bsl = null;
      AppMethodBeat.o(195485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.e.c.a
 * JD-Core Version:    0.7.0.1
 */