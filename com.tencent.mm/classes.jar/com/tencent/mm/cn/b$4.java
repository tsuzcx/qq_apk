package com.tencent.mm.cn;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.xweb.h;

final class b$4
  implements h
{
  public final SharedPreferences x(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(80381);
    if (paramBoolean)
    {
      paramString = as.apr(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(80381);
        return null;
      }
    }
    else
    {
      if (paramInt == 4) {}
      for (paramInt = 2;; paramInt = 1)
      {
        paramString = as.eu(paramString, paramInt);
        break;
      }
    }
    paramString = new c(paramString);
    AppMethodBeat.o(80381);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cn.b.4
 * JD-Core Version:    0.7.0.1
 */