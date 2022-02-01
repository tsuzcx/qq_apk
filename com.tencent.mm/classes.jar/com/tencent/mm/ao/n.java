package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.fhf;
import com.tencent.mm.protocal.protobuf.fhg;
import com.tencent.mm.protocal.protobuf.fhi;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class n
{
  public static fhi UP(String paramString)
  {
    AppMethodBeat.i(208274);
    try
    {
      paramString = MultiProcessMMKV.getMMKV("brandService", 1).decodeBytes(UR(paramString));
      fhi localfhi = new fhi();
      localfhi.parseFrom(paramString);
      AppMethodBeat.o(208274);
      return localfhi;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(208274);
    }
    return null;
  }
  
  public static void UQ(final String paramString)
  {
    AppMethodBeat.i(208278);
    fhf localfhf = new fhf();
    localfhf.UHn = 0;
    h.aHF().kcd.a(new v(paramString, localfhf, new v.a(new fhg()) {}), 0);
    AppMethodBeat.o(208278);
  }
  
  static String UR(String paramString)
  {
    AppMethodBeat.i(208282);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_biztransfer").append(paramString);
    localStringBuilder.append("_2");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(208282);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.n
 * JD-Core Version:    0.7.0.1
 */