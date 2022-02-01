package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.sdk.platformtools.ax;

public final class m
{
  public static dpm wY(String paramString)
  {
    AppMethodBeat.i(191058);
    try
    {
      paramString = ax.fF("brandService", 1).decodeBytes(xa(paramString));
      dpm localdpm = new dpm();
      localdpm.parseFrom(paramString);
      AppMethodBeat.o(191058);
      return localdpm;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(191058);
    }
    return null;
  }
  
  public static void wZ(final String paramString)
  {
    AppMethodBeat.i(191059);
    dpj localdpj = new dpj();
    localdpj.EFt = 0;
    g.afA().gcy.a(new u(paramString, localdpj, new u.a(new dpk()) {}), 0);
    AppMethodBeat.o(191059);
  }
  
  static String xa(String paramString)
  {
    AppMethodBeat.i(191060);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_biztransfer").append(paramString);
    localStringBuilder.append("_2");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(191060);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.m
 * JD-Core Version:    0.7.0.1
 */