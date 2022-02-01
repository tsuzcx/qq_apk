package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public abstract interface f
{
  public abstract void PS(String paramString);
  
  public abstract void a(a parama, int paramInt);
  
  public abstract void brn();
  
  public abstract void bro();
  
  public abstract void dY(String paramString1, String paramString2);
  
  public abstract void gZ(boolean paramBoolean);
  
  public abstract void hb(boolean paramBoolean);
  
  public abstract void requestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void setPullDownText(String paramString);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(135307);
      lGD = new a("LIGHT", 0);
      lGE = new a("DARK", 1);
      lGF = new a("IGNORE", 2);
      lGG = new a[] { lGD, lGE, lGF };
      AppMethodBeat.o(135307);
    }
    
    private a() {}
    
    public static a aw(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193428);
      if (TextUtils.isEmpty(paramString))
      {
        if (paramBoolean)
        {
          paramString = lGD;
          AppMethodBeat.o(193428);
          return paramString;
        }
        paramString = lGE;
        AppMethodBeat.o(193428);
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
          AppMethodBeat.o(193428);
          return locala;
          bool = false;
          continue;
          bool = str.equalsIgnoreCase(paramString);
        }
        i += 1;
      }
      ac.e("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", new Object[] { paramString });
      if (paramBoolean)
      {
        paramString = lGD;
        AppMethodBeat.o(193428);
        return paramString;
      }
      paramString = lGE;
      AppMethodBeat.o(193428);
      return paramString;
    }
    
    public final String brB()
    {
      AppMethodBeat.i(210521);
      String str = name().toLowerCase();
      AppMethodBeat.o(210521);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.f
 * JD-Core Version:    0.7.0.1
 */