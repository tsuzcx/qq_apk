package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public TextPaint ga;
  public CharSequence roR;
  public h roS;
  public boolean roT;
  public boolean roU;
  public a roV;
  public int roW;
  public float roX;
  public CharSequence roY;
  public CharSequence roZ;
  public String rpa;
  public String rpb;
  
  public e()
  {
    AppMethodBeat.i(131679);
    this.roV = a.rpc;
    this.roW = Color.parseColor("#07C160");
    this.roY = "";
    this.roZ = "";
    this.rpa = "";
    this.rpb = "";
    AppMethodBeat.o(131679);
  }
  
  public static final e a(CharSequence paramCharSequence, h paramh)
  {
    AppMethodBeat.i(131682);
    e locale = new e();
    locale.roR = paramCharSequence;
    locale.roS = paramh;
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
    locale.roR = paramCharSequence;
    locale.roS = paramh;
    locale.roT = paramBoolean1;
    locale.roU = paramBoolean2;
    locale.roX = paramFloat;
    locale.ga = paramTextPaint;
    AppMethodBeat.o(131685);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence1, h paramh, boolean paramBoolean1, boolean paramBoolean2, TextPaint paramTextPaint, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(131686);
    e locale = new e();
    locale.roR = paramCharSequence1;
    locale.roS = paramh;
    locale.roT = paramBoolean1;
    locale.roU = paramBoolean2;
    locale.roX = 400.0F;
    locale.ga = paramTextPaint;
    locale.roY = paramCharSequence2;
    locale.roZ = paramCharSequence3;
    AppMethodBeat.o(131686);
    return locale;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(131680);
    paramCharSequence = b(paramCharSequence, bt.n(paramList, " "));
    AppMethodBeat.o(131680);
    return paramCharSequence;
  }
  
  public static final e a(CharSequence paramCharSequence, List<String> paramList, a parama, int paramInt)
  {
    AppMethodBeat.i(131687);
    paramCharSequence = a(paramCharSequence, paramList);
    paramCharSequence.roV = parama;
    paramCharSequence.roW = paramInt;
    AppMethodBeat.o(131687);
    return paramCharSequence;
  }
  
  public static final e b(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131681);
    e locale = new e();
    locale.roR = paramCharSequence;
    locale.roS = h.bc(paramString, false);
    locale.roT = false;
    locale.roU = false;
    AppMethodBeat.o(131681);
    return locale;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131676);
      rpc = new a("Foreground", 0);
      rpd = new a("Background", 1);
      rpe = new a("CustomTag", 2);
      rpf = new a[] { rpc, rpd, rpe };
      AppMethodBeat.o(131676);
    }
    
    private a() {}
  }
  
  public static final class b
    implements Comparable<b>
  {
    public h.c rpg;
    public int rph = -1;
    public int rpi = -1;
    
    public final String cxj()
    {
      AppMethodBeat.i(131677);
      if ((this.rpg != null) && (this.rpg.rpy.size() > 0))
      {
        Object localObject = this.rpg.rpy.iterator();
        while (((Iterator)localObject).hasNext())
        {
          h.b localb = (h.b)((Iterator)localObject).next();
          if (localb.rpw == h.d.rpB)
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
      return (this.rph != -1) && (this.rpi != -1);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(131678);
      if (this.rpg == null) {}
      for (String str = "";; str = this.rpg.cxm().replaceAll("​", ","))
      {
        str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.rph), Integer.valueOf(this.rpi) });
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