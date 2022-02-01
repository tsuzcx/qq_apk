package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public final class d
{
  private static int a(RandomAccessFile paramRandomAccessFile, int paramInt1, byte[] paramArrayOfByte, int paramInt2, File paramFile, int paramInt3)
  {
    AppMethodBeat.i(947);
    if ((paramRandomAccessFile == null) || (paramInt1 <= 0))
    {
      AppMethodBeat.o(947);
      return 3;
    }
    if (paramFile == null)
    {
      AppMethodBeat.o(947);
      return 4;
    }
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(947);
      return 2;
    }
    int j = paramInt1 - paramInt3 - 2;
    if (j <= 2)
    {
      AppMethodBeat.o(947);
      return 3;
    }
    Object localObject1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2));
    ((DataInputStream)localObject1).skip(8L);
    long l1 = ((DataInputStream)localObject1).readLong();
    long l2 = ((DataInputStream)localObject1).readLong();
    int k = (int)((DataInputStream)localObject1).readLong();
    ((DataInputStream)localObject1).close();
    localObject1 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    ((InputStream)localObject1).skip(32L);
    localObject1 = new DataInputStream(new GZIPInputStream((InputStream)localObject1));
    Object localObject2 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    ((InputStream)localObject2).skip(32L + l1);
    localObject2 = new GZIPInputStream((InputStream)localObject2);
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    paramArrayOfByte.skip(l1 + l2 + 32L);
    paramArrayOfByte = new GZIPInputStream(paramArrayOfByte);
    paramFile = new FileOutputStream(paramFile);
    paramInt2 = 0;
    int[] arrayOfInt = new int[3];
    paramInt3 = 0;
    while (paramInt3 < k)
    {
      int i = 0;
      while (i <= 2)
      {
        arrayOfInt[i] = ((DataInputStream)localObject1).readInt();
        i += 1;
      }
      if (arrayOfInt[0] + paramInt3 > k)
      {
        paramFile.close();
        AppMethodBeat.o(947);
        return 2;
      }
      byte[] arrayOfByte1 = new byte[arrayOfInt[0]];
      if (!e.a((InputStream)localObject2, arrayOfByte1, arrayOfInt[0]))
      {
        paramFile.close();
        AppMethodBeat.o(947);
        return 2;
      }
      byte[] arrayOfByte2 = new byte[arrayOfInt[0]];
      if (paramRandomAccessFile.read(arrayOfByte2, 0, arrayOfInt[0]) < arrayOfInt[0])
      {
        paramFile.close();
        AppMethodBeat.o(947);
        return 2;
      }
      i = 0;
      while (i < arrayOfInt[0])
      {
        if (paramInt2 + i == j)
        {
          arrayOfByte2[i] = 0;
          arrayOfByte2[(i + 1)] = 0;
        }
        if ((paramInt2 + i >= 0) && (paramInt2 + i < paramInt1)) {
          arrayOfByte1[i] = ((byte)(arrayOfByte1[i] + arrayOfByte2[i]));
        }
        i += 1;
      }
      paramFile.write(arrayOfByte1);
      paramInt3 = arrayOfInt[0] + paramInt3;
      int m = arrayOfInt[0];
      if (arrayOfInt[1] + paramInt3 > k)
      {
        paramFile.close();
        AppMethodBeat.o(947);
        return 2;
      }
      arrayOfByte1 = new byte[arrayOfInt[1]];
      if (!e.a(paramArrayOfByte, arrayOfByte1, arrayOfInt[1]))
      {
        paramFile.close();
        AppMethodBeat.o(947);
        return 2;
      }
      paramFile.write(arrayOfByte1);
      paramFile.flush();
      i = arrayOfInt[1];
      paramInt2 = arrayOfInt[2] + (m + paramInt2);
      paramRandomAccessFile.seek(paramInt2);
      paramInt3 += i;
    }
    ((DataInputStream)localObject1).close();
    ((InputStream)localObject2).close();
    paramArrayOfByte.close();
    paramRandomAccessFile.close();
    paramFile.close();
    AppMethodBeat.o(947);
    return 1;
  }
  
  public static int a(RandomAccessFile paramRandomAccessFile, File paramFile1, File paramFile2, int paramInt)
  {
    AppMethodBeat.i(946);
    if (paramRandomAccessFile.length() <= 0L)
    {
      AppMethodBeat.o(946);
      return 3;
    }
    if (paramFile2.length() <= 0L)
    {
      AppMethodBeat.o(946);
      return 2;
    }
    byte[] arrayOfByte = new byte[(int)paramFile2.length()];
    e.a(new FileInputStream(paramFile2), arrayOfByte, arrayOfByte.length);
    paramInt = a(paramRandomAccessFile, (int)paramRandomAccessFile.length(), arrayOfByte, arrayOfByte.length, paramFile1, paramInt);
    AppMethodBeat.o(946);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.d
 * JD-Core Version:    0.7.0.1
 */