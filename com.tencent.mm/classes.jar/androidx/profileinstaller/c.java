package androidx.profileinstaller;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

final class c
{
  static void a(OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(194225);
    a(paramOutputStream, paramInt, 1);
    AppMethodBeat.o(194225);
  }
  
  static void a(OutputStream paramOutputStream, long paramLong)
  {
    AppMethodBeat.i(194237);
    a(paramOutputStream, paramLong, 4);
    AppMethodBeat.o(194237);
  }
  
  static void a(OutputStream paramOutputStream, long paramLong, int paramInt)
  {
    AppMethodBeat.i(194220);
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
      i += 1;
    }
    paramOutputStream.write(arrayOfByte);
    AppMethodBeat.o(194220);
  }
  
  static void a(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194289);
    a(paramOutputStream, paramArrayOfByte.length, 4);
    Object localObject = new Deflater(1);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localObject = new DeflaterOutputStream(localByteArrayOutputStream, (Deflater)localObject);
    try
    {
      ((DeflaterOutputStream)localObject).write(paramArrayOfByte);
      ((DeflaterOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      a(paramOutputStream, paramArrayOfByte.length);
      paramOutputStream.write(paramArrayOfByte);
      AppMethodBeat.o(194289);
      return;
    }
    finally {}
    try
    {
      ((DeflaterOutputStream)localObject).close();
      AppMethodBeat.o(194289);
      throw paramOutputStream;
    }
    finally
    {
      paramOutputStream.addSuppressed(paramArrayOfByte);
    }
  }
  
  static byte[] a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194280);
    Inflater localInflater = new Inflater();
    byte[] arrayOfByte1 = new byte[paramInt2];
    byte[] arrayOfByte2 = new byte[2048];
    int j = 0;
    int i = 0;
    while ((!localInflater.finished()) && (!localInflater.needsDictionary()) && (i < paramInt1))
    {
      int k = paramInputStream.read(arrayOfByte2);
      if (k < 0)
      {
        paramInputStream = aQ("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + paramInt1 + " bytes");
        AppMethodBeat.o(194280);
        throw paramInputStream;
      }
      localInflater.setInput(arrayOfByte2, 0, k);
      try
      {
        int m = localInflater.inflate(arrayOfByte1, j, paramInt2 - j);
        j += m;
        i += k;
      }
      catch (DataFormatException paramInputStream)
      {
        paramInputStream = aQ(paramInputStream.getMessage());
        AppMethodBeat.o(194280);
        throw paramInputStream;
      }
    }
    if (i != paramInt1)
    {
      paramInputStream = aQ("Didn't read enough bytes during decompression. expected=" + paramInt1 + " actual=" + i);
      AppMethodBeat.o(194280);
      throw paramInputStream;
    }
    if (!localInflater.finished())
    {
      paramInputStream = aQ("Inflater did not finish");
      AppMethodBeat.o(194280);
      throw paramInputStream;
    }
    AppMethodBeat.o(194280);
    return arrayOfByte1;
  }
  
  static int aP(String paramString)
  {
    AppMethodBeat.i(194213);
    int i = paramString.getBytes(StandardCharsets.UTF_8).length;
    AppMethodBeat.o(194213);
    return i;
  }
  
  static RuntimeException aQ(String paramString)
  {
    AppMethodBeat.i(194298);
    paramString = new IllegalStateException(paramString);
    AppMethodBeat.o(194298);
    return paramString;
  }
  
  static void b(OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(194232);
    a(paramOutputStream, paramInt, 2);
    AppMethodBeat.o(194232);
  }
  
  static byte[] b(InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(194251);
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j < 0)
      {
        paramInputStream = aQ("Not enough bytes to read: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(194251);
        throw paramInputStream;
      }
      i += j;
    }
    AppMethodBeat.o(194251);
    return arrayOfByte;
  }
  
  static long c(InputStream paramInputStream, int paramInt)
  {
    AppMethodBeat.i(194259);
    paramInputStream = b(paramInputStream, paramInt);
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l += ((paramInputStream[i] & 0xFF) << i * 8);
      i += 1;
    }
    AppMethodBeat.o(194259);
    return l;
  }
  
  static void c(OutputStream paramOutputStream, String paramString)
  {
    AppMethodBeat.i(194244);
    paramOutputStream.write(paramString.getBytes(StandardCharsets.UTF_8));
    AppMethodBeat.o(194244);
  }
  
  static void d(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(194293);
    byte[] arrayOfByte = new byte[512];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(194293);
  }
  
  static int j(InputStream paramInputStream)
  {
    AppMethodBeat.i(194266);
    int i = (int)c(paramInputStream, 2);
    AppMethodBeat.o(194266);
    return i;
  }
  
  static long k(InputStream paramInputStream)
  {
    AppMethodBeat.i(194272);
    long l = c(paramInputStream, 4);
    AppMethodBeat.o(194272);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.profileinstaller.c
 * JD-Core Version:    0.7.0.1
 */