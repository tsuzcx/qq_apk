package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  public final int mZp;
  
  static
  {
    AppMethodBeat.i(208024);
    mZn = new a("BLACK", 0, -16777216);
    mZo = new a("WHITE", 1, -1);
    mZq = new a[] { mZn, mZo };
    AppMethodBeat.o(208024);
  }
  
  private e$a(int paramInt)
  {
    this.mZp = paramInt;
  }
  
  public static a Wa(String paramString)
  {
    AppMethodBeat.i(208023);
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
          AppMethodBeat.o(208023);
          return locala;
        }
        i += 1;
      }
    }
    paramString = mZo;
    AppMethodBeat.o(208023);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e.a
 * JD-Core Version:    0.7.0.1
 */