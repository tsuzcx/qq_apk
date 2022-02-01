package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public TextPaint iU;
  public CharSequence tFd;
  public h tFe;
  public boolean tFf;
  public boolean tFg;
  public a tFh;
  public int tFi;
  public float tFj;
  public CharSequence tFk;
  public CharSequence tFl;
  public String tFm;
  public String tFn;
  
  public e()
  {
    AppMethodBeat.i(131679);
    this.tFh = a.tFo;
    this.tFi = Color.parseColor("#07C160");
    this.tFk = "";
    this.tFl = "";
    this.tFm = "";
    this.tFn = "";
    AppMethodBeat.o(131679);
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh)
  {
    AppMethodBeat.i(131682);
    e locale = new e();
    locale.tFd = paramCharSequence;
    locale.tFe = paramh;
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
    locale.tFd = paramCharSequence;
    locale.tFe = paramh;
    locale.tFf = paramBoolean1;
    locale.tFg = paramBoolean2;
    locale.tFj = paramFloat;
    locale.iU = paramTextPaint;
    AppMethodBeat.o(131685);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence1, h paramh, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(131686);
    e locale = new e();
    locale.tFd = paramCharSequence1;
    locale.tFe = paramh;
    locale.tFf = paramBoolean1;
    locale.tFg = paramBoolean2;
    locale.tFj = 400.0F;
    locale.iU = paramTextPaint;
    locale.tFk = paramCharSequence2;
    locale.tFl = paramCharSequence3;
    AppMethodBeat.o(131686);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(131680);
    paramCharSequence = c(paramCharSequence, bu.m(paramList, " "));
    AppMethodBeat.o(131680);
    return paramCharSequence;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList, a parama, int paramInt)
  {
    AppMethodBeat.i(131687);
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.tFh = parama;
    paramCharSequence.tFi = paramInt;
    AppMethodBeat.o(131687);
    return paramCharSequence;
  }
  
  public static final e c(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131681);
    e locale = new e();
    locale.tFd = paramCharSequence;
    locale.tFe = h.bq(paramString, false);
    locale.tFf = false;
    locale.tFg = false;
    AppMethodBeat.o(131681);
    return locale;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131676);
      tFo = new a("Foreground", 0);
      tFp = new a("Background", 1);
      tFq = new a("CustomTag", 2);
      tFr = new a[] { tFo, tFp, tFq };
      AppMethodBeat.o(131676);
    }
    
    private a() {}
  }
  
  public static final class b
    implements Comparable<b>
  {
    public h.c tFs;
    public int tFt = -1;
    public int tFu = -1;
    
    public final String cVp()
    {
      AppMethodBeat.i(131677);
      if ((this.tFs != null) && (this.tFs.tFK.size() > 0))
      {
        Object localObject = this.tFs.tFK.iterator();
        while (((Iterator)localObject).hasNext())
        {
          h.b localb = (h.b)((Iterator)localObject).next();
          if (localb.tFI == h.d.tFN)
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
      return (this.tFt != -1) && (this.tFu != -1);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(131678);
      if (this.tFs == null) {}
      for (String str = "";; str = this.tFs.cVs().replaceAll("​", ","))
      {
        str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.tFt), Integer.valueOf(this.tFu) });
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