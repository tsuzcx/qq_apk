package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;

public final class aa
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(58730);
    if (paramb == null)
    {
      AppMethodBeat.o(58730);
      return null;
    }
    paramb = paramb.dqj();
    AppMethodBeat.o(58730);
    return paramb;
  }
  
  public static String a(bwc parambwc)
  {
    if (parambwc == null) {
      return null;
    }
    return parambwc.xJE;
  }
  
  public static String a(bwc parambwc, String paramString)
  {
    if (parambwc == null) {
      return paramString;
    }
    return parambwc.xJE;
  }
  
  public static byte[] a(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(58727);
    if ((paramSKBuiltinBuffer_t == null) || (paramSKBuiltinBuffer_t.getBuffer() == null))
    {
      AppMethodBeat.o(58727);
      return null;
    }
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().toByteArray();
    AppMethodBeat.o(58727);
    return paramSKBuiltinBuffer_t;
  }
  
  public static byte[] a(SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58728);
    if ((paramSKBuiltinBuffer_t == null) || (paramSKBuiltinBuffer_t.getBuffer() == null))
    {
      AppMethodBeat.o(58728);
      return paramArrayOfByte;
    }
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().toByteArray();
    AppMethodBeat.o(58728);
    return paramSKBuiltinBuffer_t;
  }
  
  public static SKBuiltinBuffer_t ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58726);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(58726);
      return null;
    }
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte);
    AppMethodBeat.o(58726);
    return localSKBuiltinBuffer_t;
  }
  
  public static String b(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(58731);
    if ((paramSKBuiltinBuffer_t == null) || (paramSKBuiltinBuffer_t.getBuffer() == null))
    {
      AppMethodBeat.o(58731);
      return null;
    }
    paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().dqj();
    AppMethodBeat.o(58731);
    return paramSKBuiltinBuffer_t;
  }
  
  public static bwc wA(String paramString)
  {
    AppMethodBeat.i(58729);
    if (paramString == null)
    {
      AppMethodBeat.o(58729);
      return null;
    }
    bwc localbwc = new bwc();
    localbwc.aoF(paramString);
    AppMethodBeat.o(58729);
    return localbwc;
  }
  
  public static SKBuiltinBuffer_t wB(String paramString)
  {
    AppMethodBeat.i(58732);
    if (paramString == null)
    {
      AppMethodBeat.o(58732);
      return null;
    }
    paramString = Base64.decode(paramString, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(58732);
      return null;
    }
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramString);
    AppMethodBeat.o(58732);
    return localSKBuiltinBuffer_t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.aa
 * JD-Core Version:    0.7.0.1
 */