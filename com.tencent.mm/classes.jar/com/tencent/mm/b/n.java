package com.tencent.mm.b;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

public final class n
{
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar2 = new char[k * 2];
    int i = 0;
    int m;
    for (int j = 0; i < k; j = m + 1)
    {
      int n = paramArrayOfByte[i];
      m = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(n >>> 4 & 0xF)];
      arrayOfChar2[m] = arrayOfChar1[(n & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static String fc(String paramString)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localByteArrayOutputStream.write(paramString.getBytes("UTF-8"));
    return bytesToHex(localMessageDigest.digest(localByteArrayOutputStream.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.b.n
 * JD-Core Version:    0.7.0.1
 */