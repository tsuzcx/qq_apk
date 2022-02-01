package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class w
{
  public static etl Sk(String paramString)
  {
    AppMethodBeat.i(132979);
    if (paramString == null)
    {
      AppMethodBeat.o(132979);
      return null;
    }
    etl localetl = new etl();
    localetl.btH(paramString);
    AppMethodBeat.o(132979);
    return localetl;
  }
  
  public static String a(b paramb)
  {
    AppMethodBeat.i(132980);
    if (paramb == null)
    {
      AppMethodBeat.o(132980);
      return null;
    }
    paramb = paramb.ZV();
    AppMethodBeat.o(132980);
    return paramb;
  }
  
  public static String a(etl parametl)
  {
    if (parametl == null) {
      return null;
    }
    return parametl.abwM;
  }
  
  public static String a(etl parametl, String paramString)
  {
    if (parametl == null) {
      return paramString;
    }
    return parametl.abwM;
  }
  
  public static boolean a(etl... paramVarArgs)
  {
    AppMethodBeat.i(234067);
    int i = 0;
    while (i < 3)
    {
      if ((paramVarArgs[i] == null) || (Util.isNullOrNil(a(paramVarArgs[i]))))
      {
        AppMethodBeat.o(234067);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(234067);
    return true;
  }
  
  public static byte[] a(gol paramgol)
  {
    AppMethodBeat.i(132977);
    if ((paramgol == null) || (paramgol.aaxD == null))
    {
      AppMethodBeat.o(132977);
      return null;
    }
    paramgol = paramgol.aaxD.toByteArray();
    AppMethodBeat.o(132977);
    return paramgol;
  }
  
  public static byte[] a(gol paramgol, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132978);
    if ((paramgol == null) || (paramgol.aaxD == null))
    {
      AppMethodBeat.o(132978);
      return paramArrayOfByte;
    }
    paramgol = paramgol.aaxD.toByteArray();
    AppMethodBeat.o(132978);
    return paramgol;
  }
  
  public static gol aN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132976);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(132976);
      return null;
    }
    gol localgol = new gol();
    localgol.df(paramArrayOfByte);
    AppMethodBeat.o(132976);
    return localgol;
  }
  
  public static gol ak(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(234064);
    if (paramString == null)
    {
      AppMethodBeat.o(234064);
      return null;
    }
    if (paramBoolean) {}
    for (paramString = Base64.decode(paramString, 0); paramString == null; paramString = paramString.getBytes())
    {
      AppMethodBeat.o(234064);
      return null;
    }
    gol localgol = new gol();
    localgol.df(paramString);
    AppMethodBeat.o(234064);
    return localgol;
  }
  
  public static String b(gol paramgol)
  {
    AppMethodBeat.i(132981);
    if ((paramgol == null) || (paramgol.aaxD == null))
    {
      AppMethodBeat.o(132981);
      return null;
    }
    paramgol = paramgol.aaxD.ZV();
    AppMethodBeat.o(132981);
    return paramgol;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.w
 * JD-Core Version:    0.7.0.1
 */