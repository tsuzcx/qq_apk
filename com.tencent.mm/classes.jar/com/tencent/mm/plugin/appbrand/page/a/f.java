package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public abstract interface f
{
  public abstract void Uh(String paramString);
  
  public abstract void a(a parama, int paramInt);
  
  public abstract void bvZ();
  
  public abstract void bwa();
  
  public abstract void el(String paramString1, String paramString2);
  
  public abstract void hi(boolean paramBoolean);
  
  public abstract void hk(boolean paramBoolean);
  
  public abstract void requestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void setPullDownText(String paramString);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(135307);
      mlg = new a("LIGHT", 0);
      mlh = new a("DARK", 1);
      mli = new a("IGNORE", 2);
      mlj = new a[] { mlg, mlh, mli };
      AppMethodBeat.o(135307);
    }
    
    private a() {}
    
    public static a ay(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(207886);
      if (TextUtils.isEmpty(paramString))
      {
        if (paramBoolean)
        {
          paramString = mlg;
          AppMethodBeat.o(207886);
          return paramString;
        }
        paramString = mlh;
        AppMethodBeat.o(207886);
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
          AppMethodBeat.o(207886);
          return locala;
          bool = false;
          continue;
          bool = str.equalsIgnoreCase(paramString);
        }
        i += 1;
      }
      ae.e("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", new Object[] { paramString });
      if (paramBoolean)
      {
        paramString = mlg;
        AppMethodBeat.o(207886);
        return paramString;
      }
      paramString = mlh;
      AppMethodBeat.o(207886);
      return paramString;
    }
    
    public final String bwu()
    {
      AppMethodBeat.i(224486);
      String str = name().toLowerCase();
      AppMethodBeat.o(224486);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f
 * JD-Core Version:    0.7.0.1
 */