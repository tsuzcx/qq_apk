package com.tencent.mm.audio.mix.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class c
{
  protected static char[] bUg;
  protected static ThreadLocal<MessageDigest> cic;
  
  static
  {
    AppMethodBeat.i(137222);
    bUg = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    cic = new c.1();
    AppMethodBeat.o(137222);
  }
  
  public static String cE(String paramString)
  {
    AppMethodBeat.i(137221);
    paramString = paramString.getBytes();
    paramString = ((MessageDigest)cic.get()).digest(paramString);
    int j = paramString.length;
    StringBuffer localStringBuffer = new StringBuffer(j * 2);
    int i = 0;
    while (i < j + 0)
    {
      int k = paramString[i];
      char c1 = bUg[((k & 0xF0) >> 4)];
      char c2 = bUg[(k & 0xF)];
      localStringBuffer.append(c1);
      localStringBuffer.append(c2);
      i += 1;
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(137221);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.c
 * JD-Core Version:    0.7.0.1
 */