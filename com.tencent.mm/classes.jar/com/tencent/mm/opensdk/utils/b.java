package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b
{
  public static final String c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(3756);
    char[] arrayOfChar = new char[16];
    char[] tmp14_12 = arrayOfChar;
    tmp14_12[0] = 48;
    char[] tmp19_14 = tmp14_12;
    tmp19_14[1] = 49;
    char[] tmp24_19 = tmp19_14;
    tmp24_19[2] = 50;
    char[] tmp29_24 = tmp24_19;
    tmp29_24[3] = 51;
    char[] tmp34_29 = tmp29_24;
    tmp34_29[4] = 52;
    char[] tmp39_34 = tmp34_29;
    tmp39_34[5] = 53;
    char[] tmp44_39 = tmp39_34;
    tmp44_39[6] = 54;
    char[] tmp50_44 = tmp44_39;
    tmp50_44[7] = 55;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[8] = 56;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[9] = 57;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[10] = 97;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[11] = 98;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[12] = 99;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[13] = 100;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[14] = 101;
    char[] tmp98_92 = tmp92_86;
    tmp98_92[15] = 102;
    tmp98_92;
    for (;;)
    {
      Object localObject;
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(3756);
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      AppMethodBeat.o(3756);
      return paramArrayOfByte;
      while (i < k)
      {
        int n = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(n >>> 4 & 0xF)];
        localObject[m] = arrayOfChar[(n & 0xF)];
        i += 1;
        j = m + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.b
 * JD-Core Version:    0.7.0.1
 */