package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;

public final class z
{
  public static cmf BE(String paramString)
  {
    AppMethodBeat.i(132979);
    if (paramString == null)
    {
      AppMethodBeat.o(132979);
      return null;
    }
    cmf localcmf = new cmf();
    localcmf.aEE(paramString);
    AppMethodBeat.o(132979);
    return localcmf;
  }
  
  public static SKBuiltinBuffer_t BF(String paramString)
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
    paramb = paramb.eBA();
    AppMethodBeat.o(132980);
    return paramb;
  }
  
  public static String a(cmf paramcmf)
  {
    if (paramcmf == null) {
      return null;
    }
    return paramcmf.Ehn;
  }
  
  public static String a(cmf paramcmf, String paramString)
  {
    if (paramcmf == null) {
      return paramString;
    }
    return paramcmf.Ehn;
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
  
  public static SKBuiltinBuffer_t am(byte[] paramArrayOfByte)
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
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().eBA();
    AppMethodBeat.o(132981);
    return paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.z
 * JD-Core Version:    0.7.0.1
 */