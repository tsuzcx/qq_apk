package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public abstract interface f
{
  public abstract void Tw(String paramString);
  
  public abstract void a(a parama, int paramInt);
  
  public abstract void bvo();
  
  public abstract void bvp();
  
  public abstract void ei(String paramString1, String paramString2);
  
  public abstract void hh(boolean paramBoolean);
  
  public abstract void hj(boolean paramBoolean);
  
  public abstract void requestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void setPullDownText(String paramString);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(135307);
      mgg = new a("LIGHT", 0);
      mgh = new a("DARK", 1);
      mgi = new a("IGNORE", 2);
      mgj = new a[] { mgg, mgh, mgi };
      AppMethodBeat.o(135307);
    }
    
    private a() {}
    
    public static a ay(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197345);
      if (TextUtils.isEmpty(paramString))
      {
        if (paramBoolean)
        {
          paramString = mgg;
          AppMethodBeat.o(197345);
          return paramString;
        }
        paramString = mgh;
        AppMethodBeat.o(197345);
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
          AppMethodBeat.o(197345);
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
        paramString = mgg;
        AppMethodBeat.o(197345);
        return paramString;
      }
      paramString = mgh;
      AppMethodBeat.o(197345);
      return paramString;
    }
    
    public final String bvD()
    {
      AppMethodBeat.i(221149);
      String str = name().toLowerCase();
      AppMethodBeat.o(221149);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.f
 * JD-Core Version:    0.7.0.1
 */