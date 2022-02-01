package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static String aL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136183);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(136183);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int m = k & 0xF;
      int j;
      label59:
      int n;
      if (m < 10)
      {
        j = 48;
        n = (k & 0xF0) >> 4;
        if (n >= 10) {
          break label111;
        }
      }
      label111:
      for (k = 48;; k = 55)
      {
        localStringBuilder.append(k + n);
        localStringBuilder.append(m + j);
        i += 1;
        break;
        j = 55;
        break label59;
      }
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(136183);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.c
 * JD-Core Version:    0.7.0.1
 */