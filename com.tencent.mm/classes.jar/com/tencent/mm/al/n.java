package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ecl;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.ay;

public final class n
{
  public static eco EF(String paramString)
  {
    AppMethodBeat.i(188883);
    try
    {
      paramString = ay.gq("brandService", 1).decodeBytes(EH(paramString));
      eco localeco = new eco();
      localeco.parseFrom(paramString);
      AppMethodBeat.o(188883);
      return localeco;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(188883);
    }
    return null;
  }
  
  public static void EG(final String paramString)
  {
    AppMethodBeat.i(188884);
    ecl localecl = new ecl();
    localecl.IhJ = 0;
    g.ajQ().gDv.a(new v(paramString, localecl, new v.a(new ecm()) {}), 0);
    AppMethodBeat.o(188884);
  }
  
  static String EH(String paramString)
  {
    AppMethodBeat.i(188885);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mmkv_biztransfer").append(paramString);
    localStringBuilder.append("_2");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(188885);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.n
 * JD-Core Version:    0.7.0.1
 */