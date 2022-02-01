package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public abstract interface f
{
  public abstract void LM(String paramString);
  
  public abstract void a(a parama, int paramInt);
  
  public abstract void bky();
  
  public abstract void bkz();
  
  public abstract void dM(String paramString1, String paramString2);
  
  public abstract void gF(boolean paramBoolean);
  
  public abstract void gH(boolean paramBoolean);
  
  public abstract void requestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void setPullDownText(String paramString);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(135307);
      lgJ = new a("LIGHT", 0);
      lgK = new a("DARK", 1);
      lgL = new a("IGNORE", 2);
      lgM = new a[] { lgJ, lgK, lgL };
      AppMethodBeat.o(135307);
    }
    
    private a() {}
    
    public static a av(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(194513);
      if (TextUtils.isEmpty(paramString))
      {
        if (paramBoolean)
        {
          paramString = lgJ;
          AppMethodBeat.o(194513);
          return paramString;
        }
        paramString = lgK;
        AppMethodBeat.o(194513);
        return paramString;
      }
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        String str = locala.name().toLowerCase();
        boolean bool;
        if (str == null) {
          if (paramString == null) {
            bool = true;
          }
        }
        while (bool)
        {
          AppMethodBeat.o(194513);
          return locala;
          bool = false;
          continue;
          bool = str.equalsIgnoreCase(paramString);
        }
        i += 1;
      }
      ad.e("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", new Object[] { paramString });
      if (paramBoolean)
      {
        paramString = lgJ;
        AppMethodBeat.o(194513);
        return paramString;
      }
      paramString = lgK;
      AppMethodBeat.o(194513);
      return paramString;
    }
    
    public final String bkM()
    {
      AppMethodBeat.i(203651);
      String str = name().toLowerCase();
      AppMethodBeat.o(203651);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.f
 * JD-Core Version:    0.7.0.1
 */