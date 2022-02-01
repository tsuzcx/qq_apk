package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class b
{
  private static b kxL;
  public d kxI;
  public f kxJ;
  public a kxK;
  public String kxM = null;
  public String kxN = null;
  
  public static b bqC()
  {
    AppMethodBeat.i(238936);
    if (kxL == null) {
      kxL = new b();
    }
    b localb = kxL;
    AppMethodBeat.o(238936);
    return localb;
  }
  
  public static void l(String[] paramArrayOfString)
  {
    AppMethodBeat.i(238937);
    int i = 0;
    while (i < 2)
    {
      String str = paramArrayOfString[i];
      s.boN(str);
      s.bpc(str);
      i += 1;
    }
    AppMethodBeat.o(238937);
  }
  
  public final String TM(String paramString)
  {
    AppMethodBeat.i(238938);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(238938);
      return "";
    }
    paramString = Math.abs(paramString.hashCode());
    paramString = this.kxN + paramString + "/";
    AppMethodBeat.o(238938);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.b
 * JD-Core Version:    0.7.0.1
 */