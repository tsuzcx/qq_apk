package com.tencent.map.lib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class a
{
  static final byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  public static String a(File paramFile)
  {
    AppMethodBeat.i(98240);
    Object localObject1 = new FileInputStream(paramFile);
    Object localObject2 = new byte[1024];
    paramFile = new char[16];
    paramFile[0] = 48;
    paramFile[1] = 49;
    paramFile[2] = 50;
    paramFile[3] = 51;
    paramFile[4] = 52;
    paramFile[5] = 53;
    paramFile[6] = 54;
    paramFile[7] = 55;
    paramFile[8] = 56;
    paramFile[9] = 57;
    paramFile[10] = 97;
    paramFile[11] = 98;
    paramFile[12] = 99;
    paramFile[13] = 100;
    paramFile[14] = 101;
    paramFile[15] = 102;
    paramFile;
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        i = ((FileInputStream)localObject1).read((byte[])localObject2, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update((byte[])localObject2, 0, i);
      }
      AppMethodBeat.o(98240);
    }
    catch (Exception paramFile)
    {
      paramFile = null;
    }
    return paramFile;
    ((FileInputStream)localObject1).close();
    localObject1 = localMessageDigest.digest();
    localObject2 = new char[32];
    int i = 0;
    int j = 0;
    for (;;)
    {
      paramFile = new String((char[])localObject2);
      break;
      while (j < 16)
      {
        int k = localObject1[j];
        int m = i + 1;
        localObject2[i] = paramFile[(k >>> 4 & 0xF)];
        i = m + 1;
        localObject2[m] = paramFile[(k & 0xF)];
        j += 1;
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98239);
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
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = new String((char[])localObject);
      AppMethodBeat.o(98239);
      return paramArrayOfByte;
      while (i < 16)
      {
        int m = paramArrayOfByte[i];
        int k = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        localObject[k] = arrayOfChar[(m & 0xF)];
        i += 1;
        j = k + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.util.a
 * JD-Core Version:    0.7.0.1
 */