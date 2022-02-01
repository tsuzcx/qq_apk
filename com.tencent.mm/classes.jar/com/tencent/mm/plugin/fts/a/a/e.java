package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public TextPaint gZ;
  public CharSequence sxL;
  public h sxM;
  public boolean sxN;
  public boolean sxO;
  public e.a sxP;
  public int sxQ;
  public float sxR;
  public CharSequence sxS;
  public CharSequence sxT;
  public String sxU;
  public String sxV;
  
  public e()
  {
    AppMethodBeat.i(131679);
    this.sxP = e.a.sxW;
    this.sxQ = Color.parseColor("#07C160");
    this.sxS = "";
    this.sxT = "";
    this.sxU = "";
    this.sxV = "";
    AppMethodBeat.o(131679);
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh)
  {
    AppMethodBeat.i(131682);
    e locale = new e();
    locale.sxL = paramCharSequence;
    locale.sxM = paramh;
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
    locale.sxL = paramCharSequence;
    locale.sxM = paramh;
    locale.sxN = paramBoolean1;
    locale.sxO = paramBoolean2;
    locale.sxR = paramFloat;
    locale.gZ = paramTextPaint;
    AppMethodBeat.o(131685);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence1, h paramh, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(131686);
    e locale = new e();
    locale.sxL = paramCharSequence1;
    locale.sxM = paramh;
    locale.sxN = paramBoolean1;
    locale.sxO = paramBoolean2;
    locale.sxR = 400.0F;
    locale.gZ = paramTextPaint;
    locale.sxS = paramCharSequence2;
    locale.sxT = paramCharSequence3;
    AppMethodBeat.o(131686);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(131680);
    paramCharSequence = c(paramCharSequence, bs.n(paramList, " "));
    AppMethodBeat.o(131680);
    return paramCharSequence;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList, e.a parama, int paramInt)
  {
    AppMethodBeat.i(131687);
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.sxP = parama;
    paramCharSequence.sxQ = paramInt;
    AppMethodBeat.o(131687);
    return paramCharSequence;
  }
  
  public static final e c(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131681);
    e locale = new e();
    locale.sxL = paramCharSequence;
    locale.sxM = h.bi(paramString, false);
    locale.sxN = false;
    locale.sxO = false;
    AppMethodBeat.o(131681);
    return locale;
  }
  
  public static final class b
    implements Comparable<b>
  {
    public h.c sya;
    public int syb = -1;
    public int syc = -1;
    
    public final String cKv()
    {
      AppMethodBeat.i(131677);
      if ((this.sya != null) && (this.sya.sys.size() > 0))
      {
        Object localObject = this.sya.sys.iterator();
        while (((Iterator)localObject).hasNext())
        {
          h.b localb = (h.b)((Iterator)localObject).next();
          if (localb.syq == h.d.syv)
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
      return (this.syb != -1) && (this.syc != -1);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(131678);
      if (this.sya == null) {}
      for (String str = "";; str = this.sya.cKy().replaceAll("​", ","))
      {
        str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.syb), Integer.valueOf(this.syc) });
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