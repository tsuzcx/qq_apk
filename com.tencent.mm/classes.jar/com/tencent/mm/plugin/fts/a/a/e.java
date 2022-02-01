package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public TextPaint iW;
  public CharSequence wWc;
  public h wWd;
  public boolean wWe;
  public boolean wWf;
  public a wWg;
  public int wWh;
  public float wWi;
  public CharSequence wWj;
  public CharSequence wWk;
  public String wWl;
  public String wWm;
  
  public e()
  {
    AppMethodBeat.i(131679);
    this.wWg = a.wWn;
    this.wWh = Color.parseColor("#07C160");
    this.wWj = "";
    this.wWk = "";
    this.wWl = "";
    this.wWm = "";
    AppMethodBeat.o(131679);
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh)
  {
    AppMethodBeat.i(131682);
    e locale = new e();
    locale.wWc = paramCharSequence;
    locale.wWd = paramh;
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
    locale.wWc = paramCharSequence;
    locale.wWd = paramh;
    locale.wWe = paramBoolean1;
    locale.wWf = paramBoolean2;
    locale.wWi = paramFloat;
    locale.iW = paramTextPaint;
    AppMethodBeat.o(131685);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence1, h paramh, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(131686);
    e locale = new e();
    locale.wWc = paramCharSequence1;
    locale.wWd = paramh;
    locale.wWe = paramBoolean1;
    locale.wWf = paramBoolean2;
    locale.wWi = 400.0F;
    locale.iW = paramTextPaint;
    locale.wWj = paramCharSequence2;
    locale.wWk = paramCharSequence3;
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
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList, a parama, int paramInt)
  {
    AppMethodBeat.i(131687);
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.wWg = parama;
    paramCharSequence.wWh = paramInt;
    AppMethodBeat.o(131687);
    return paramCharSequence;
  }
  
  public static final e c(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131681);
    e locale = new e();
    locale.wWc = paramCharSequence;
    locale.wWd = h.bE(paramString, false);
    locale.wWe = false;
    locale.wWf = false;
    AppMethodBeat.o(131681);
    return locale;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131676);
      wWn = new a("Foreground", 0);
      wWo = new a("Background", 1);
      wWp = new a("CustomTag", 2);
      wWq = new a[] { wWn, wWo, wWp };
      AppMethodBeat.o(131676);
    }
    
    private a() {}
  }
  
  public static final class b
    implements Comparable<b>
  {
    public h.c wWr;
    public int wWs = -1;
    public int wWt = -1;
    
    public final String getKeyword()
    {
      AppMethodBeat.i(131677);
      if ((this.wWr != null) && (this.wWr.wWJ.size() > 0))
      {
        Object localObject = this.wWr.wWJ.iterator();
        while (((Iterator)localObject).hasNext())
        {
          h.b localb = (h.b)((Iterator)localObject).next();
          if (localb.wWH == h.d.wWM)
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
      return (this.wWs != -1) && (this.wWt != -1);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(131678);
      if (this.wWr == null) {}
      for (String str = "";; str = this.wWr.dOB().replaceAll("​", ","))
      {
        str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.wWs), Integer.valueOf(this.wWt) });
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