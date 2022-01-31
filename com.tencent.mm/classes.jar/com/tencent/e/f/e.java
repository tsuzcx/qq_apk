package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e
{
  public static byte[] awF(String paramString)
  {
    AppMethodBeat.i(114611);
    if (paramString == null)
    {
      AppMethodBeat.o(114611);
      return null;
    }
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = (byte)"0123456789ABCDEF".indexOf(paramString[k]);
      arrayOfByte[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(paramString[(k + 1)]) | m << 4));
      i += 1;
    }
    AppMethodBeat.o(114611);
    return arrayOfByte;
  }
  
  public static final String bytesToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114612);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(114612);
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(114612);
    return paramArrayOfByte;
  }
  
  public static byte[] cq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114613);
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      AppMethodBeat.o(114613);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = localObject;
      }
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.e.f.e
 * JD-Core Version:    0.7.0.1
 */