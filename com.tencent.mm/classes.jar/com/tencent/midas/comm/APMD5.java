package com.tencent.midas.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class APMD5
{
  public static String parseByte2HexStr(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193229);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        str1 = "0".concat(String.valueOf(str2));
      }
      localStringBuffer.append(str1.toUpperCase());
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(193229);
    return paramArrayOfByte;
  }
  
  public static String toMd5(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193228);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = parseByte2HexStr(localMessageDigest.digest());
      AppMethodBeat.o(193228);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      AppMethodBeat.o(193228);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.midas.comm.APMD5
 * JD-Core Version:    0.7.0.1
 */