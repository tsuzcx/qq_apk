package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;

public final class z
{
  public static dqi Su(String paramString)
  {
    AppMethodBeat.i(132979);
    if (paramString == null)
    {
      AppMethodBeat.o(132979);
      return null;
    }
    dqi localdqi = new dqi();
    localdqi.bhy(paramString);
    AppMethodBeat.o(132979);
    return localdqi;
  }
  
  public static SKBuiltinBuffer_t Sv(String paramString)
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
    paramb = paramb.yO();
    AppMethodBeat.o(132980);
    return paramb;
  }
  
  public static String a(dqi paramdqi)
  {
    if (paramdqi == null) {
      return null;
    }
    return paramdqi.MTo;
  }
  
  public static String a(dqi paramdqi, String paramString)
  {
    if (paramdqi == null) {
      return paramString;
    }
    return paramdqi.MTo;
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
  
  public static SKBuiltinBuffer_t aC(byte[] paramArrayOfByte)
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
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().yO();
    AppMethodBeat.o(132981);
    return paramSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.z
 * JD-Core Version:    0.7.0.1
 */