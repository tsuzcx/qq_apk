package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.sdk.platformtools.aw;

public final class m
{
  public static dvd Be(String paramString)
  {
    AppMethodBeat.i(209534);
    try
    {
      paramString = aw.fK("brandService", 1).decodeBytes(Bg(paramString));
      dvd localdvd = new dvd();
      localdvd.parseFrom(paramString);
      AppMethodBeat.o(209534);
      return localdvd;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(209534);
    }
    return null;
  }
  
  public static void Bf(final String paramString)
  {
    AppMethodBeat.i(209535);
    dva localdva = new dva();
    localdva.GcF = 0;
    g.agQ().ghe.a(new u(paramString, localdva, new u.a(new dvb()) {}), 0);
    AppMethodBeat.o(209535);
  }
  
  static String Bg(String paramString)
  {
    AppMethodBeat.i(209536);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_biztransfer").append(paramString);
    localStringBuilder.append("_2");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(209536);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.m
 * JD-Core Version:    0.7.0.1
 */