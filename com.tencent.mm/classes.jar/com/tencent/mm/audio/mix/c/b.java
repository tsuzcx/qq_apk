package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class b
{
  public static boolean cTI = false;
  
  public static void MR()
  {
    AppMethodBeat.i(136756);
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN)
    {
      cTI = true;
      AppMethodBeat.o(136756);
      return;
    }
    cTI = false;
    AppMethodBeat.o(136756);
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, byte[][] paramArrayOfByte1)
  {
    AppMethodBeat.i(136759);
    if (paramArrayOfByte1.length <= 1)
    {
      AppMethodBeat.o(136759);
      return;
    }
    int j = paramArrayOfByte.length / 2;
    Arrays.fill(paramArrayOfByte1[0], 0, paramArrayOfByte1[0].length, (byte)0);
    Arrays.fill(paramArrayOfByte1[1], 0, paramArrayOfByte1[1].length, (byte)0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136759);
      return;
      int i = 0;
      paramInt = 0;
      while (paramInt < j)
      {
        paramArrayOfByte1[0][i] = paramArrayOfByte[paramInt];
        paramArrayOfByte1[1][i] = paramArrayOfByte[(paramInt + 1)];
        i += 1;
        paramInt += 2;
      }
      AppMethodBeat.o(136759);
      return;
      paramInt = 0;
      while (paramInt < j)
      {
        paramArrayOfByte1[0][paramInt] = paramArrayOfByte[(paramInt * 2)];
        paramArrayOfByte1[0][(paramInt + 1)] = paramArrayOfByte[(paramInt * 2 + 1)];
        paramArrayOfByte1[1][paramInt] = paramArrayOfByte[(paramInt * 2 + 2)];
        paramArrayOfByte1[1][(paramInt + 1)] = paramArrayOfByte[(paramInt * 2 + 3)];
        paramInt += 2;
      }
    }
  }
  
  public static byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(136757);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(136757);
      return paramArrayOfByte;
    }
    int j = paramArrayOfByte.length;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136757);
      return paramArrayOfByte;
      switch (paramInt2)
      {
      default: 
        break;
      case 2: 
        arrayOfByte1 = new byte[j * 2];
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          byte[] arrayOfByte2 = a.getBytes((short)(paramArrayOfByte[paramInt1] * 256), cTI);
          arrayOfByte1[(paramInt1 * 2)] = arrayOfByte2[0];
          arrayOfByte1[(paramInt1 * 2 + 1)] = arrayOfByte2[1];
          paramInt1 += 1;
        }
        AppMethodBeat.o(136757);
        return arrayOfByte1;
        switch (paramInt2)
        {
        }
        break;
      }
    }
    paramInt2 = j / 2;
    byte[] arrayOfByte1 = new byte[paramInt2];
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      arrayOfByte1[paramInt1] = ((byte)(a.a(paramArrayOfByte[(paramInt1 * 2)], paramArrayOfByte[(paramInt1 * 2 + 1)], cTI) / 256));
      paramInt1 += 1;
    }
    AppMethodBeat.o(136757);
    return arrayOfByte1;
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(136760);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2.length == 0))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray or sourceSecondByteArray is null");
      AppMethodBeat.o(136760);
      return null;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray and sourceSecondByteArray length is not same");
      AppMethodBeat.o(136760);
      return null;
    }
    int k = paramArrayOfByte1.length;
    byte[] arrayOfByte = new byte[k * 2];
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136760);
      return arrayOfByte;
      while (i < k)
      {
        arrayOfByte[i] = paramArrayOfByte1[i];
        arrayOfByte[(i + 1)] = paramArrayOfByte2[i];
        i += 2;
      }
      while (j < k)
      {
        arrayOfByte[(j * 2)] = paramArrayOfByte1[j];
        arrayOfByte[(j * 2 + 1)] = paramArrayOfByte1[(j + 1)];
        arrayOfByte[(j * 2 + 2)] = paramArrayOfByte2[j];
        arrayOfByte[(j * 2 + 3)] = paramArrayOfByte2[(j + 1)];
        j += 2;
      }
    }
  }
  
  public static byte[] b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    AppMethodBeat.i(136758);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136758);
      return paramArrayOfByte;
    }
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(136758);
      return paramArrayOfByte;
    }
    switch (paramInt3)
    {
    default: 
      AppMethodBeat.o(136758);
      return paramArrayOfByte;
    }
    int m = paramArrayOfByte.length;
    switch (paramInt1)
    {
    }
    byte b1;
    byte b2;
    for (;;)
    {
      AppMethodBeat.o(136758);
      return paramArrayOfByte;
      switch (paramInt2)
      {
      default: 
        break;
      case 2: 
        arrayOfByte1 = new byte[m * 2];
        paramInt1 = k;
        paramInt2 = i;
        switch (paramInt3)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(136758);
          return arrayOfByte1;
          while (paramInt1 < m)
          {
            b1 = paramArrayOfByte[paramInt1];
            arrayOfByte1[(paramInt1 * 2)] = b1;
            arrayOfByte1[(paramInt1 * 2 + 1)] = b1;
            paramInt1 += 1;
          }
          while (paramInt2 < m)
          {
            b1 = paramArrayOfByte[paramInt2];
            b2 = paramArrayOfByte[(paramInt2 + 1)];
            arrayOfByte1[(paramInt2 * 2)] = b1;
            arrayOfByte1[(paramInt2 * 2 + 1)] = b2;
            arrayOfByte1[(paramInt2 * 2 + 2)] = b1;
            arrayOfByte1[(paramInt2 * 2 + 3)] = b2;
            paramInt2 += 2;
          }
        }
        switch (paramInt2)
        {
        }
        break;
      }
    }
    paramInt2 = m / 2;
    byte[] arrayOfByte1 = new byte[paramInt2];
    paramInt1 = j;
    switch (paramInt3)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136758);
      return arrayOfByte1;
      while (paramInt1 < paramInt2)
      {
        arrayOfByte1[paramInt1] = ((byte)((short)((short)paramArrayOfByte[(paramInt1 * 2)] + (short)paramArrayOfByte[(paramInt1 * 2 + 1)]) >> 1));
        paramInt1 += 2;
      }
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        b1 = paramArrayOfByte[(paramInt1 * 2)];
        b2 = paramArrayOfByte[(paramInt1 * 2 + 1)];
        byte b3 = paramArrayOfByte[(paramInt1 * 2 + 2)];
        byte b4 = paramArrayOfByte[(paramInt1 * 2 + 3)];
        boolean bool = cTI;
        paramInt3 = a.a(b1, b2, bool);
        i = a.a(b3, b4, bool);
        byte[] arrayOfByte2 = a.getBytes((short)(paramInt3 / 2 + i / 2), bool);
        arrayOfByte1[paramInt1] = arrayOfByte2[0];
        arrayOfByte1[(paramInt1 + 1)] = arrayOfByte2[1];
        paramInt1 += 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.b
 * JD-Core Version:    0.7.0.1
 */