package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  public final int mga;
  
  static
  {
    AppMethodBeat.i(135288);
    mfY = new a("BLACK", 0, -16777216);
    mfZ = new a("WHITE", 1, -1);
    mgb = new a[] { mfY, mfZ };
    AppMethodBeat.o(135288);
  }
  
  private d$a(int paramInt)
  {
    this.mga = paramInt;
  }
  
  public static a TA(String paramString)
  {
    AppMethodBeat.i(135287);
    if (!TextUtils.isEmpty(paramString))
    {
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala.name().equalsIgnoreCase(paramString))
        {
          AppMethodBeat.o(135287);
          return locala;
        }
        i += 1;
      }
    }
    paramString = mfZ;
    AppMethodBeat.o(135287);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.d.a
 * JD-Core Version:    0.7.0.1
 */