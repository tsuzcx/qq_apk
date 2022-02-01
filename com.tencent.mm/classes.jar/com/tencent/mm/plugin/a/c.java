package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c
{
  public static long B(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(133855);
    byte[] arrayOfByte = new byte[8];
    Arrays.fill(arrayOfByte, (byte)0);
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 4, 4);
    long l = aP(arrayOfByte);
    AppMethodBeat.o(133855);
    return l;
  }
  
  public static boolean Sm(String paramString)
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
      paramString = y.Lh(paramString);
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
            Log.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
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
      int k = a.cOh;
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
            Log.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.AtomUtil", localIOException, "", new Object[0]);
        }
      }
    }
    catch (Exception paramString)
    {
      localObject = str;
      Log.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
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
          Log.printErrStackTrace("MicroMsg.AtomUtil", paramString, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
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
          localObject1 = i.f(j, k, paramRandomAccessFile.getFilePointer() - i);
        }
      }
      catch (Exception paramRandomAccessFile)
      {
        int i;
        int j;
        int k;
        Log.printErrStackTrace("MicroMsg.AtomUtil", paramRandomAccessFile, "", new Object[0]);
        Log.e("MicroMsg.AtomUtil", "find Atom error: " + paramRandomAccessFile.toString());
        Object localObject1 = localObject2;
        continue;
      }
      AppMethodBeat.o(133856);
      return localObject1;
      if ((k == a.cOI) || (k == a.cOM))
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
      Log.w("MicroMsg.AtomUtil", "can not skip.skip: " + paramLong + " trueSkip : " + l);
      AppMethodBeat.o(133857);
      return false;
    }
    AppMethodBeat.o(133857);
    return true;
  }
  
  public static long aP(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 56 | (paramArrayOfByte[1] & 0xFF) << 48 | (paramArrayOfByte[2] & 0xFF) << 40 | (paramArrayOfByte[3] & 0xFF) << 32 | (paramArrayOfByte[4] & 0xFF) << 24 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[6] & 0xFF) << 8 | paramArrayOfByte[7] & 0xFF;
  }
  
  public static a b(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(262682);
    try
    {
      j = paramRandomAccessFile.read(paramArrayOfByte);
      i = j;
    }
    catch (Exception paramRandomAccessFile)
    {
      for (;;)
      {
        int m;
        Log.printErrStackTrace("MicroMsg.AtomUtil", paramRandomAccessFile, "", new Object[0]);
        Log.e("MicroMsg.AtomUtil", "find Atom error: " + paramRandomAccessFile.toString());
        paramRandomAccessFile = null;
        continue;
        int k = j + i;
        int j = i;
        int i = k;
      }
    }
    if (j >= 8)
    {
      if ((4194304L > 0L) && (4194304L <= i))
      {
        AppMethodBeat.o(262682);
        return null;
      }
      k = readInt(paramArrayOfByte, 0);
      m = readInt(paramArrayOfByte, 4);
      if (m != paramInt) {}
    }
    for (paramRandomAccessFile = i.f(k, m, paramRandomAccessFile.getFilePointer() - j);; paramRandomAccessFile = null)
    {
      AppMethodBeat.o(262682);
      return paramRandomAccessFile;
      if ((m == a.cOI) || (m == a.cOM))
      {
        k = paramRandomAccessFile.read(paramArrayOfByte);
        j = i;
        i = k;
        break;
      }
      if (a(paramRandomAccessFile, k - 8))
      {
        j = i + (k - 8);
        i = paramRandomAccessFile.read(paramArrayOfByte);
        break;
      }
    }
  }
  
  public static int du(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.a.c
 * JD-Core Version:    0.7.0.1
 */