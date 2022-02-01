package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c
{
  public static boolean BH(String paramString)
  {
    AppMethodBeat.i(133852);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(133852);
      return false;
    }
    localObject = null;
    String str = null;
    try
    {
      paramString = i.openRead(paramString);
      str = paramString;
      localObject = paramString;
      byte[] arrayOfByte = new byte[8];
      str = paramString;
      localObject = paramString;
      int i = paramString.read(arrayOfByte, 0, 8);
      if (i < 8)
      {
        if (paramString != null) {}
        try
        {
          paramString.close();
          AppMethodBeat.o(133852);
          return false;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
          }
        }
      }
      str = paramString;
      localObject = paramString;
      i = readInt(arrayOfByte, 0);
      str = paramString;
      localObject = paramString;
      int j = readInt(arrayOfByte, 4);
      str = paramString;
      localObject = paramString;
      int k = a.aZH;
      if ((j == k) && (i > 0))
      {
        if (paramString != null) {}
        try
        {
          paramString.close();
          AppMethodBeat.o(133852);
          return true;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
          }
        }
      }
      if (paramString != null) {}
      try
      {
        paramString.close();
        AppMethodBeat.o(133852);
        return false;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
        }
      }
      try
      {
        ((InputStream)localObject).close();
        AppMethodBeat.o(133852);
        throw paramString;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AtomUtil", localIOException, "", new Object[0]);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject = str;
      ad.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
      if (str != null) {}
      try
      {
        str.close();
        AppMethodBeat.o(133852);
        return false;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  public static long D(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(133855);
    byte[] arrayOfByte = new byte[8];
    Arrays.fill(arrayOfByte, (byte)0);
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 4, 4);
    long l = ao(arrayOfByte);
    AppMethodBeat.o(133855);
    return l;
  }
  
  public static a a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(133856);
    localObject2 = null;
    for (;;)
    {
      try
      {
        i = paramRandomAccessFile.read(paramArrayOfByte);
        localObject1 = localObject2;
        if (i >= 8)
        {
          j = readInt(paramArrayOfByte, 0);
          k = readInt(paramArrayOfByte, 4);
          if (k != paramInt) {
            continue;
          }
          localObject1 = h.d(j, k, paramRandomAccessFile.getFilePointer() - i);
        }
      }
      catch (Exception paramRandomAccessFile)
      {
        int i;
        int j;
        int k;
        ad.printErrStackTrace("MicroMsg.AtomUtil", paramRandomAccessFile, "", new Object[0]);
        ad.e("MicroMsg.AtomUtil", "find Atom error: " + paramRandomAccessFile.toString());
        Object localObject1 = localObject2;
        continue;
      }
      AppMethodBeat.o(133856);
      return localObject1;
      if ((k == a.bai) || (k == a.bam))
      {
        i = paramRandomAccessFile.read(paramArrayOfByte);
      }
      else
      {
        localObject1 = localObject2;
        if (a(paramRandomAccessFile, j - 8)) {
          i = paramRandomAccessFile.read(paramArrayOfByte);
        }
      }
    }
  }
  
  public static boolean a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    AppMethodBeat.i(133857);
    long l = 0L;
    while (paramLong > 2147483647L)
    {
      l += paramRandomAccessFile.skipBytes(2147483647);
      paramLong -= 2147483647L;
    }
    l += paramRandomAccessFile.skipBytes((int)paramLong);
    if (l != paramLong)
    {
      ad.w("MicroMsg.AtomUtil", "can not skip.skip: " + paramLong + " trueSkip : " + l);
      AppMethodBeat.o(133857);
      return false;
    }
    AppMethodBeat.o(133857);
    return true;
  }
  
  public static int aY(String paramString)
  {
    AppMethodBeat.i(133854);
    int k = paramString.length();
    int j = 0;
    int m;
    for (int i = 0; j < k; i = i << 8 | m)
    {
      m = paramString.charAt(j);
      j += 1;
    }
    AppMethodBeat.o(133854);
    return i;
  }
  
  public static long ao(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 56 | (paramArrayOfByte[1] & 0xFF) << 48 | (paramArrayOfByte[2] & 0xFF) << 40 | (paramArrayOfByte[3] & 0xFF) << 32 | (paramArrayOfByte[4] & 0xFF) << 24 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[6] & 0xFF) << 8 | paramArrayOfByte[7] & 0xFF;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(133853);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(133853);
      return true;
    }
    AppMethodBeat.o(133853);
    return false;
  }
  
  public static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int j = i + 1;
    return (paramArrayOfByte[i] & 0xFF) << 16 | (paramInt & 0xFF) << 24 | (paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[(j + 1)] & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.c
 * JD-Core Version:    0.7.0.1
 */