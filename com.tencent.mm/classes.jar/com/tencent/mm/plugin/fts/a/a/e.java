package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public TextPaint iU;
  public CharSequence tum;
  public h tun;
  public boolean tuo;
  public boolean tup;
  public e.a tuq;
  public int tur;
  public float tus;
  public CharSequence tut;
  public CharSequence tuu;
  public String tuv;
  public String tuw;
  
  public e()
  {
    AppMethodBeat.i(131679);
    this.tuq = e.a.tux;
    this.tur = Color.parseColor("#07C160");
    this.tut = "";
    this.tuu = "";
    this.tuv = "";
    this.tuw = "";
    AppMethodBeat.o(131679);
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh)
  {
    AppMethodBeat.i(131682);
    e locale = new e();
    locale.tum = paramCharSequence;
    locale.tun = paramh;
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
    locale.tum = paramCharSequence;
    locale.tun = paramh;
    locale.tuo = paramBoolean1;
    locale.tup = paramBoolean2;
    locale.tus = paramFloat;
    locale.iU = paramTextPaint;
    AppMethodBeat.o(131685);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence1, h paramh, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(131686);
    e locale = new e();
    locale.tum = paramCharSequence1;
    locale.tun = paramh;
    locale.tuo = paramBoolean1;
    locale.tup = paramBoolean2;
    locale.tus = 400.0F;
    locale.iU = paramTextPaint;
    locale.tut = paramCharSequence2;
    locale.tuu = paramCharSequence3;
    AppMethodBeat.o(131686);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(131680);
    paramCharSequence = c(paramCharSequence, bt.m(paramList, " "));
    AppMethodBeat.o(131680);
    return paramCharSequence;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList, e.a parama, int paramInt)
  {
    AppMethodBeat.i(131687);
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.tuq = parama;
    paramCharSequence.tur = paramInt;
    AppMethodBeat.o(131687);
    return paramCharSequence;
  }
  
  public static final e c(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131681);
    e locale = new e();
    locale.tum = paramCharSequence;
    locale.tun = h.bn(paramString, false);
    locale.tuo = false;
    locale.tup = false;
    AppMethodBeat.o(131681);
    return locale;
  }
  
  public static final class b
    implements Comparable<b>
  {
    public h.c tuB;
    public int tuC = -1;
    public int tuD = -1;
    
    public final String cSK()
    {
      AppMethodBeat.i(131677);
      if ((this.tuB != null) && (this.tuB.tuT.size() > 0))
      {
        Object localObject = this.tuB.tuT.iterator();
        while (((Iterator)localObject).hasNext())
        {
          h.b localb = (h.b)((Iterator)localObject).next();
          if (localb.tuR == h.d.tuW)
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
      return (this.tuC != -1) && (this.tuD != -1);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(131678);
      if (this.tuB == null) {}
      for (String str = "";; str = this.tuB.cSN().replaceAll("​", ","))
      {
        str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.tuC), Integer.valueOf(this.tuD) });
        AppMethodBeat.o(131678);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.e
 * JD-Core Version:    0.7.0.1
 */