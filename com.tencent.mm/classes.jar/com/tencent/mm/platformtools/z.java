package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;

public final class z
{
  public static crm FI(String paramString)
  {
    AppMethodBeat.i(132979);
    if (paramString == null)
    {
      AppMethodBeat.o(132979);
      return null;
    }
    crm localcrm = new crm();
    localcrm.aJV(paramString);
    AppMethodBeat.o(132979);
    return localcrm;
  }
  
  public static SKBuiltinBuffer_t FJ(String paramString)
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
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramString);
    AppMethodBeat.o(132982);
    return localSKBuiltinBuffer_t;
  }
  
  public static String a(b paramb)
  {
    AppMethodBeat.i(132980);
    if (paramb == null)
    {
      AppMethodBeat.o(132980);
      return null;
    }
    paramb = paramb.eQU();
    AppMethodBeat.o(132980);
    return paramb;
  }
  
  public static String a(crm paramcrm)
  {
    if (paramcrm == null) {
      return null;
    }
    return paramcrm.FEm;
  }
  
  public static String a(crm paramcrm, String paramString)
  {
    if (paramcrm == null) {
      return paramString;
    }
    return paramcrm.FEm;
  }
  
  public static byte[] a(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(132977);
    if ((paramSKBuiltinBuffer_t == null) || (paramSKBuiltinBuffer_t.getBuffer() == null))
    {
      AppMethodBeat.o(132977);
      return null;
    }
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().toByteArray();
    AppMethodBeat.o(132977);
    return paramSKBuiltinBuffer_t;
  }
  
  public static byte[] a(SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132978);
    if ((paramSKBuiltinBuffer_t == null) || (paramSKBuiltinBuffer_t.getBuffer() == null))
    {
      AppMethodBeat.o(132978);
      return paramArrayOfByte;
    }
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().toByteArray();
    AppMethodBeat.o(132978);
    return paramSKBuiltinBuffer_t;
  }
  
  public static SKBuiltinBuffer_t al(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132976);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(132976);
      return null;
    }
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte);
    AppMethodBeat.o(132976);
    return localSKBuiltinBuffer_t;
  }
  
  public static String b(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(132981);
    if ((paramSKBuiltinBuffer_t == null) || (paramSKBuiltinBuffer_t.getBuffer() == null))
    {
      AppMethodBeat.o(132981);
      return null;
    }
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().eQU();
    AppMethodBeat.o(132981);
    return paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.z
 * JD-Core Version:    0.7.0.1
 */