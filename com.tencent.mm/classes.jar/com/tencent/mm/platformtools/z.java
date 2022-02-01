package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;

public final class z
{
  public static eaf ZW(String paramString)
  {
    AppMethodBeat.i(132979);
    if (paramString == null)
    {
      AppMethodBeat.o(132979);
      return null;
    }
    eaf localeaf = new eaf();
    localeaf.btQ(paramString);
    AppMethodBeat.o(132979);
    return localeaf;
  }
  
  public static eae ZX(String paramString)
  {
    AppMethodBeat.i(132982);
    if (paramString == null)
    {
      AppMethodBeat.o(132982);
      return null;
    }
    paramString = Base64.decode(paramString, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(132982);
      return null;
    }
    eae localeae = new eae();
    localeae.dc(paramString);
    AppMethodBeat.o(132982);
    return localeae;
  }
  
  public static String a(b paramb)
  {
    AppMethodBeat.i(132980);
    if (paramb == null)
    {
      AppMethodBeat.o(132980);
      return null;
    }
    paramb = paramb.Ap();
    AppMethodBeat.o(132980);
    return paramb;
  }
  
  public static String a(eaf parameaf)
  {
    if (parameaf == null) {
      return null;
    }
    return parameaf.Ufy;
  }
  
  public static String a(eaf parameaf, String paramString)
  {
    if (parameaf == null) {
      return paramString;
    }
    return parameaf.Ufy;
  }
  
  public static byte[] a(eae parameae)
  {
    AppMethodBeat.i(132977);
    if ((parameae == null) || (parameae.Tkb == null))
    {
      AppMethodBeat.o(132977);
      return null;
    }
    parameae = parameae.Tkb.toByteArray();
    AppMethodBeat.o(132977);
    return parameae;
  }
  
  public static byte[] a(eae parameae, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132978);
    if ((parameae == null) || (parameae.Tkb == null))
    {
      AppMethodBeat.o(132978);
      return paramArrayOfByte;
    }
    parameae = parameae.Tkb.toByteArray();
    AppMethodBeat.o(132978);
    return parameae;
  }
  
  public static eae aN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132976);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(132976);
      return null;
    }
    eae localeae = new eae();
    localeae.dc(paramArrayOfByte);
    AppMethodBeat.o(132976);
    return localeae;
  }
  
  public static String b(eae parameae)
  {
    AppMethodBeat.i(132981);
    if ((parameae == null) || (parameae.Tkb == null))
    {
      AppMethodBeat.o(132981);
      return null;
    }
    parameae = parameae.Tkb.Ap();
    AppMethodBeat.o(132981);
    return parameae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.z
 * JD-Core Version:    0.7.0.1
 */