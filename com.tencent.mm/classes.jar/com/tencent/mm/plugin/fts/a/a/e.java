package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public CharSequence BHX;
  public h BHY;
  public boolean BHZ;
  public boolean BIa;
  public e.a BIb;
  public int BIc;
  public float BId;
  public CharSequence BIe;
  public CharSequence BIf;
  public String BIg;
  public String BIh;
  public TextPaint bzo;
  
  public e()
  {
    AppMethodBeat.i(131679);
    this.BIb = e.a.BIi;
    this.BIc = Color.parseColor("#07C160");
    this.BIe = "";
    this.BIf = "";
    this.BIg = "";
    this.BIh = "";
    AppMethodBeat.o(131679);
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh)
  {
    AppMethodBeat.i(131682);
    e locale = new e();
    locale.BHX = paramCharSequence;
    locale.BHY = paramh;
    AppMethodBeat.o(131682);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh, float paramFloat, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(131684);
    paramCharSequence = a(paramCharSequence, paramh, false, false, paramFloat, paramTextPaint);
    AppMethodBeat.o(131684);
    return paramCharSequence;
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(131683);
    paramCharSequence = a(paramCharSequence, paramh, paramBoolean1, paramBoolean2, 0.0F, null);
    AppMethodBeat.o(131683);
    return paramCharSequence;
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(131685);
    e locale = new e();
    locale.BHX = paramCharSequence;
    locale.BHY = paramh;
    locale.BHZ = paramBoolean1;
    locale.BIa = paramBoolean2;
    locale.BId = paramFloat;
    locale.bzo = paramTextPaint;
    AppMethodBeat.o(131685);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence1, h paramh, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(131686);
    e locale = new e();
    locale.BHX = paramCharSequence1;
    locale.BHY = paramh;
    locale.BHZ = paramBoolean1;
    locale.BIa = paramBoolean2;
    locale.BId = 400.0F;
    locale.bzo = paramTextPaint;
    locale.BIe = paramCharSequence2;
    locale.BIf = paramCharSequence3;
    AppMethodBeat.o(131686);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(131680);
    paramCharSequence = c(paramCharSequence, Util.listToString(paramList, " "));
    AppMethodBeat.o(131680);
    return paramCharSequence;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList, e.a parama, int paramInt)
  {
    AppMethodBeat.i(131687);
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.BIb = parama;
    paramCharSequence.BIc = paramInt;
    AppMethodBeat.o(131687);
    return paramCharSequence;
  }
  
  public static final e c(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131681);
    e locale = new e();
    locale.BHX = paramCharSequence;
    locale.BHY = h.bJ(paramString, false);
    locale.BHZ = false;
    locale.BIa = false;
    AppMethodBeat.o(131681);
    return locale;
  }
  
  public static final class b
    implements Comparable<b>
  {
    public h.c BIm;
    public int BIn = -1;
    public int BIo = -1;
    
    public final String getKeyword()
    {
      AppMethodBeat.i(131677);
      if ((this.BIm != null) && (this.BIm.BIE.size() > 0))
      {
        Object localObject = this.BIm.BIE.iterator();
        while (((Iterator)localObject).hasNext())
        {
          h.b localb = (h.b)((Iterator)localObject).next();
          if (localb.BIC == h.d.BIH)
          {
            localObject = localb.content;
            AppMethodBeat.o(131677);
            return localObject;
          }
        }
      }
      AppMethodBeat.o(131677);
      return null;
    }
    
    public final boolean isAvailable()
    {
      return (this.BIn != -1) && (this.BIo != -1);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(131678);
      if (this.BIm == null) {}
      for (String str = "";; str = this.BIm.eqS().replaceAll("​", ","))
      {
        str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.BIn), Integer.valueOf(this.BIo) });
        AppMethodBeat.o(131678);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.e
 * JD-Core Version:    0.7.0.1
 */