package com.tencent.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e
{
  public static final String aC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138475);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(138475);
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
    AppMethodBeat.o(138475);
    return paramArrayOfByte;
  }
  
  public static byte[] bCW(String paramString)
  {
    AppMethodBeat.i(138474);
    if (paramString == null)
    {
      AppMethodBeat.o(138474);
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
    AppMethodBeat.o(138474);
    return arrayOfByte;
  }
  
  public static byte[] md5(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138476);
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      AppMethodBeat.o(138476);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.f.e
 * JD-Core Version:    0.7.0.1
 */