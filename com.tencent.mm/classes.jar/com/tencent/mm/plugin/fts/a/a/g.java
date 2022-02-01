package com.tencent.mm.plugin.fts.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bm.a.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class g
{
  public j FWt;
  public CharSequence HsG;
  public boolean HsH;
  public boolean HsI;
  public g.a HsJ;
  public int HsK;
  public float HsL;
  public CharSequence HsM;
  public CharSequence HsN;
  public String HsO;
  public String HsP;
  public TextPaint dso;
  
  public g()
  {
    AppMethodBeat.i(131679);
    this.HsJ = g.a.HsQ;
    this.HsK = MMApplicationContext.getContext().getResources().getColor(a.a.Brand);
    this.HsM = "";
    this.HsN = "";
    this.HsO = "";
    this.HsP = "";
    AppMethodBeat.o(131679);
  }
  
  public static final g a(CharSequence paramCharSequence, j paramj)
  {
    AppMethodBeat.i(131682);
    g localg = new g();
    localg.HsG = paramCharSequence;
    localg.FWt = paramj;
    AppMethodBeat.o(131682);
    return localg;
  }
  
  public static final g a(CharSequence paramCharSequence, j paramj, float paramFloat, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(131684);
    paramCharSequence = a(paramCharSequence, paramj, false, false, paramFloat, paramTextPaint);
    AppMethodBeat.o(131684);
    return paramCharSequence;
  }
  
  public static final g a(CharSequence paramCharSequence, j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(131683);
    paramCharSequence = a(paramCharSequence, paramj, paramBoolean1, paramBoolean2, 0.0F, null);
    AppMethodBeat.o(131683);
    return paramCharSequence;
  }
  
  public static final g a(CharSequence paramCharSequence, j paramj, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(131685);
    g localg = new g();
    localg.HsG = paramCharSequence;
    localg.FWt = paramj;
    localg.HsH = paramBoolean1;
    localg.HsI = paramBoolean2;
    localg.HsL = paramFloat;
    localg.dso = paramTextPaint;
    AppMethodBeat.o(131685);
    return localg;
  }
  
  public static final g a(CharSequence paramCharSequence1, j paramj, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(131686);
    g localg = new g();
    localg.HsG = paramCharSequence1;
    localg.FWt = paramj;
    localg.HsH = paramBoolean1;
    localg.HsI = paramBoolean2;
    localg.HsL = 400.0F;
    localg.dso = paramTextPaint;
    localg.HsM = paramCharSequence2;
    localg.HsN = paramCharSequence3;
    AppMethodBeat.o(131686);
    return localg;
  }
  
  public static final g a(CharSequence paramCharSequence, List<String> paramList, g.a parama, int paramInt)
  {
    AppMethodBeat.i(131687);
    paramCharSequence = b(paramCharSequence, paramList);
    paramCharSequence.HsJ = parama;
    paramCharSequence.HsK = paramInt;
    AppMethodBeat.o(131687);
    return paramCharSequence;
  }
  
  public static final g b(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(131680);
    paramCharSequence = c(paramCharSequence, Util.listToString(paramList, " "));
    AppMethodBeat.o(131680);
    return paramCharSequence;
  }
  
  public static final g c(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131681);
    g localg = new g();
    localg.HsG = paramCharSequence;
    localg.FWt = j.cc(paramString, false);
    localg.HsH = false;
    localg.HsI = false;
    AppMethodBeat.o(131681);
    return localg;
  }
  
  public static final class b
    implements Comparable<b>
  {
    public j.c HsU;
    public int HsV = -1;
    public int HsW = -1;
    
    public final String getKeyword()
    {
      AppMethodBeat.i(131677);
      if ((this.HsU != null) && (this.HsU.Htm.size() > 0))
      {
        Object localObject = this.HsU.Htm.iterator();
        while (((Iterator)localObject).hasNext())
        {
          j.b localb = (j.b)((Iterator)localObject).next();
          if (localb.Htk == j.d.Htp)
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
      return (this.HsV != -1) && (this.HsW != -1);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(131678);
      if (this.HsU == null) {}
      for (String str = "";; str = this.HsU.fxA().replaceAll("​", ","))
      {
        str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.HsV), Integer.valueOf(this.HsW) });
        AppMethodBeat.o(131678);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.g
 * JD-Core Version:    0.7.0.1
 */