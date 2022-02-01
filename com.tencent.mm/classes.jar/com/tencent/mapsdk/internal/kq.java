package com.tencent.mapsdk.internal;

import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public final class kq
{
  public static String a(File paramFile)
  {
    AppMethodBeat.i(222424);
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
      AppMethodBeat.o(222424);
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
  
  private static String a(String paramString)
  {
    AppMethodBeat.i(222406);
    paramString = Util.getMD5String(paramString);
    AppMethodBeat.o(222406);
    return paramString;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222413);
    paramArrayOfByte = Util.getMD5String(paramArrayOfByte);
    AppMethodBeat.o(222413);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kq
 * JD-Core Version:    0.7.0.1
 */