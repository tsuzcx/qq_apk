package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract interface f
{
  public abstract void a(a parama, int paramInt);
  
  public abstract void adV(String paramString);
  
  public abstract void bSe();
  
  public abstract void bSf();
  
  public abstract void eE(String paramString1, String paramString2);
  
  public abstract void ij(boolean paramBoolean);
  
  public abstract void il(boolean paramBoolean);
  
  public abstract void requestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void setPullDownText(String paramString);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(135307);
      nvE = new a("LIGHT", 0);
      nvF = new a("DARK", 1);
      nvG = new a("IGNORE", 2);
      nvH = new a[] { nvE, nvF, nvG };
      AppMethodBeat.o(135307);
    }
    
    private a() {}
    
    public static a az(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(219488);
      if (TextUtils.isEmpty(paramString))
      {
        if (paramBoolean)
        {
          paramString = nvE;
          AppMethodBeat.o(219488);
          return paramString;
        }
        paramString = nvF;
        AppMethodBeat.o(219488);
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
          AppMethodBeat.o(219488);
          return locala;
          bool = false;
          continue;
          bool = str.equalsIgnoreCase(paramString);
        }
        i += 1;
      }
      Log.e("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", new Object[] { paramString });
      if (paramBoolean)
      {
        paramString = nvE;
        AppMethodBeat.o(219488);
        return paramString;
      }
      paramString = nvF;
      AppMethodBeat.o(219488);
      return paramString;
    }
    
    public final String bSC()
    {
      AppMethodBeat.i(258642);
      String str = name().toLowerCase();
      AppMethodBeat.o(258642);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f
 * JD-Core Version:    0.7.0.1
 */