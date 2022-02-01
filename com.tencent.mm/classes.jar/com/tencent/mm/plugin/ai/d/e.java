package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class e
{
  private static e qpu;
  public g qpp;
  public i qpq;
  public k qpr;
  public c qps;
  public d qpt;
  public String qpv = null;
  public String qpw = null;
  
  public static e caH()
  {
    AppMethodBeat.i(267374);
    if (qpu == null) {
      qpu = new e();
    }
    e locale = qpu;
    AppMethodBeat.o(267374);
    return locale;
  }
  
  public static void k(String[] paramArrayOfString)
  {
    AppMethodBeat.i(267382);
    int i = 0;
    while (i < 2)
    {
      String str = paramArrayOfString[i];
      y.bDX(str);
      y.bEr(str);
      i += 1;
    }
    AppMethodBeat.o(267382);
  }
  
  public final String TX(String paramString)
  {
    AppMethodBeat.i(267391);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267391);
      return "";
    }
    paramString = this.qpw + paramString.hashCode() + ".file";
    AppMethodBeat.o(267391);
    return paramString;
  }
  
  public final String TY(String paramString)
  {
    AppMethodBeat.i(267397);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267397);
      return "";
    }
    paramString = Math.abs(paramString.hashCode());
    paramString = this.qpw + paramString + "/";
    AppMethodBeat.o(267397);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.e
 * JD-Core Version:    0.7.0.1
 */