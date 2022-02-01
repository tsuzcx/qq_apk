package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.StringTokenizer;

public final class HexDumpUtils
{
  public static byte[] bytesFromString(String paramString)
  {
    AppMethodBeat.i(5232);
    paramString = new StringTokenizer(paramString, " \t\n");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    while (paramString.hasMoreTokens()) {
      try
      {
        localByteArrayOutputStream.write(Integer.parseInt(paramString.nextToken(), 16) & 0xFF);
      }
      catch (NumberFormatException paramString)
      {
        AppMethodBeat.o(5232);
        return null;
      }
    }
    paramString = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(5232);
    return paramString;
  }
  
  public static String dump(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(5231);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length))
    {
      AppMethodBeat.o(5231);
      return null;
    }
    int i = 57;
    if (paramBoolean) {
      i = 75;
    }
    StringBuilder localStringBuilder = new StringBuilder(i * ((paramInt2 + 16 - 1) / 16));
    int j = 0;
    int m = 0;
    int k = paramInt2;
    if (k > 0)
    {
      if (j == 0) {
        if (paramInt2 < 65536)
        {
          localStringBuilder.append(String.format("%04X:", new Object[] { Integer.valueOf(paramInt1) }));
          i = paramInt1;
        }
      }
      int n;
      for (;;)
      {
        localStringBuilder.append(String.format(" %02X", new Object[] { Integer.valueOf(paramArrayOfByte[paramInt1] & 0xFF) }));
        k -= 1;
        m = j + 1;
        if ((!paramBoolean) || ((m != 16) && (k != 0))) {
          break label352;
        }
        n = 16 - m;
        if (n <= 0) {
          break;
        }
        j = 0;
        while (j < n)
        {
          localStringBuilder.append("   ");
          j += 1;
        }
        localStringBuilder.append(String.format("%08X:", new Object[] { Integer.valueOf(paramInt1) }));
        i = paramInt1;
        continue;
        i = m;
        if (j == 8)
        {
          localStringBuilder.append(" -");
          i = m;
        }
      }
      if (n >= 8) {
        localStringBuilder.append("  ");
      }
      localStringBuilder.append("  ");
      j = 0;
      if (j < m)
      {
        char c = (char)paramArrayOfByte[(i + j)];
        if ((c >= ' ') && (c <= '~')) {}
        for (;;)
        {
          localStringBuilder.append(c);
          j += 1;
          break;
          c = '.';
        }
      }
      label352:
      if ((m != 16) && (k != 0)) {
        break label400;
      }
      localStringBuilder.append('\n');
    }
    label400:
    for (j = 0;; j = m)
    {
      paramInt1 += 1;
      m = i;
      break;
      paramArrayOfByte = localStringBuilder.toString();
      AppMethodBeat.o(5231);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.HexDumpUtils
 * JD-Core Version:    0.7.0.1
 */