package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.ax;

public final class n
{
  public static eax Ed(String paramString)
  {
    AppMethodBeat.i(207185);
    try
    {
      paramString = ax.gh("brandService", 1).decodeBytes(Ef(paramString));
      eax localeax = new eax();
      localeax.parseFrom(paramString);
      AppMethodBeat.o(207185);
      return localeax;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(207185);
    }
    return null;
  }
  
  public static void Ee(final String paramString)
  {
    AppMethodBeat.i(207186);
    eau localeau = new eau();
    localeau.HNC = 0;
    g.ajB().gAO.a(new v(paramString, localeau, new v.a(new eav()) {}), 0);
    AppMethodBeat.o(207186);
  }
  
  static String Ef(String paramString)
  {
    AppMethodBeat.i(207187);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_biztransfer").append(paramString);
    localStringBuilder.append("_2");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(207187);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.n
 * JD-Core Version:    0.7.0.1
 */