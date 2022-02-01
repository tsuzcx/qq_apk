package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ewt;
import com.tencent.mm.protocal.protobuf.ewu;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class n
{
  public static eww Nt(String paramString)
  {
    AppMethodBeat.i(212176);
    try
    {
      paramString = MultiProcessMMKV.getMMKV("brandService", 1).decodeBytes(Nv(paramString));
      eww localeww = new eww();
      localeww.parseFrom(paramString);
      AppMethodBeat.o(212176);
      return localeww;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(212176);
    }
    return null;
  }
  
  public static void Nu(final String paramString)
  {
    AppMethodBeat.i(212177);
    ewt localewt = new ewt();
    localewt.Nun = 0;
    g.aAg().hqi.a(new v(paramString, localewt, new v.a(new ewu()) {}), 0);
    AppMethodBeat.o(212177);
  }
  
  static String Nv(String paramString)
  {
    AppMethodBeat.i(212178);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_biztransfer").append(paramString);
    localStringBuilder.append("_2");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(212178);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.n
 * JD-Core Version:    0.7.0.1
 */