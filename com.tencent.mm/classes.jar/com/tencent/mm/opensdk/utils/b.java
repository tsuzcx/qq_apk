package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b
{
  public static final String c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128071);
    char[] arrayOfChar = new char[16];
    char[] tmp13_11 = arrayOfChar;
    tmp13_11[0] = 48;
    char[] tmp18_13 = tmp13_11;
    tmp18_13[1] = 49;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[2] = 50;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[3] = 51;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 52;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 53;
    char[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 54;
    char[] tmp49_43 = tmp43_38;
    tmp49_43[7] = 55;
    char[] tmp55_49 = tmp49_43;
    tmp55_49[8] = 56;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[9] = 57;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[10] = 97;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[11] = 98;
    char[] tmp79_73 = tmp73_67;
    tmp79_73[12] = 99;
    char[] tmp85_79 = tmp79_73;
    tmp85_79[13] = 100;
    char[] tmp91_85 = tmp85_79;
    tmp91_85[14] = 101;
    char[] tmp97_91 = tmp91_85;
    tmp97_91[15] = 102;
    tmp97_91;
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
        AppMethodBeat.o(128071);
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      AppMethodBeat.o(128071);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.b
 * JD-Core Version:    0.7.0.1
 */