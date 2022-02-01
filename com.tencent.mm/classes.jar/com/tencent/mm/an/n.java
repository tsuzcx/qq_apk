package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.gdr;
import com.tencent.mm.protocal.protobuf.gds;
import com.tencent.mm.protocal.protobuf.gdu;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class n
{
  public static gdu MO(String paramString)
  {
    AppMethodBeat.i(239443);
    try
    {
      paramString = MultiProcessMMKV.getMMKV("brandService", 1).decodeBytes(MQ(paramString));
      gdu localgdu = new gdu();
      localgdu.parseFrom(paramString);
      return localgdu;
    }
    finally
    {
      AppMethodBeat.o(239443);
    }
    return null;
  }
  
  public static void MP(final String paramString)
  {
    AppMethodBeat.i(239445);
    gdr localgdr = new gdr();
    localgdr.acbx = 0;
    h.baD().mCm.a(new v(paramString, localgdr, new v.a(new gds()) {}), 0);
    AppMethodBeat.o(239445);
  }
  
  static String MQ(String paramString)
  {
    AppMethodBeat.i(239448);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_biztransfer").append(paramString);
    localStringBuilder.append("_2");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(239448);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.n
 * JD-Core Version:    0.7.0.1
 */