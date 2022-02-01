package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p$a
{
  public static byte[] f(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(103783);
    byte[] arrayOfByte2 = paramString.getBytes();
    byte[] arrayOfByte1 = new byte[256];
    int j = 0;
    while (j < 256)
    {
      arrayOfByte1[j] = ((byte)j);
      j += 1;
    }
    int k;
    int m;
    if ((arrayOfByte2 == null) || (arrayOfByte2.length == 0))
    {
      paramString = null;
      arrayOfByte1 = new byte[paramArrayOfByte.length];
      if (paramString != null)
      {
        j = 0;
        k = 0;
        m = 0;
      }
    }
    else
    {
      while (j < paramArrayOfByte.length)
      {
        m = m + 1 & 0xFF;
        k = (paramString[m] & 0xFF) + k & 0xFF;
        int i = paramString[m];
        paramString[m] = paramString[k];
        paramString[k] = i;
        int n = paramString[m];
        int i1 = paramString[k];
        int i2 = paramArrayOfByte[j];
        arrayOfByte1[j] = ((byte)(paramString[((n & 0xFF) + (i1 & 0xFF) & 0xFF)] ^ i2));
        j += 1;
        continue;
        k = 0;
        m = 0;
        j = 0;
        for (;;)
        {
          paramString = arrayOfByte1;
          if (k >= 256) {
            break;
          }
          m = m + ((arrayOfByte2[j] & 0xFF) + (arrayOfByte1[k] & 0xFF)) & 0xFF;
          i = arrayOfByte1[k];
          arrayOfByte1[k] = arrayOfByte1[m];
          arrayOfByte1[m] = i;
          j = (j + 1) % arrayOfByte2.length;
          k += 1;
        }
      }
    }
    AppMethodBeat.o(103783);
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.p.a
 * JD-Core Version:    0.7.0.1
 */