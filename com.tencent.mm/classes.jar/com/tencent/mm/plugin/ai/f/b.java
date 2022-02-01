package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class b
{
  private static b nqK;
  public d nqG;
  public f nqH;
  public h nqI;
  public a nqJ;
  public String nqL = null;
  public String nqM = null;
  
  public static b bBr()
  {
    AppMethodBeat.i(240136);
    if (nqK == null) {
      nqK = new b();
    }
    b localb = nqK;
    AppMethodBeat.o(240136);
    return localb;
  }
  
  public static void k(String[] paramArrayOfString)
  {
    AppMethodBeat.i(240138);
    int i = 0;
    while (i < 2)
    {
      String str = paramArrayOfString[i];
      u.bBD(str);
      u.bBX(str);
      i += 1;
    }
    AppMethodBeat.o(240138);
  }
  
  public final String abw(String paramString)
  {
    AppMethodBeat.i(240140);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(240140);
      return "";
    }
    paramString = Math.abs(paramString.hashCode());
    paramString = this.nqM + paramString + "/";
    AppMethodBeat.o(240140);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.b
 * JD-Core Version:    0.7.0.1
 */