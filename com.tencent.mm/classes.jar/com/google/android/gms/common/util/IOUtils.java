package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import javax.annotation.Nullable;

public final class IOUtils
{
  public static void close(@Nullable Closeable paramCloseable, String paramString1, String paramString2)
  {
    AppMethodBeat.i(90225);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(90225);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(90225);
  }
  
  public static void closeQuietly(@Nullable ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(90222);
    if (paramParcelFileDescriptor != null) {
      try
      {
        paramParcelFileDescriptor.close();
        AppMethodBeat.o(90222);
        return;
      }
      catch (IOException paramParcelFileDescriptor) {}
    }
    AppMethodBeat.o(90222);
  }
  
  public static void closeQuietly(@Nullable Closeable paramCloseable)
  {
    AppMethodBeat.i(90221);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(90221);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(90221);
  }
  
  public static void closeQuietly(@Nullable ServerSocket paramServerSocket)
  {
    AppMethodBeat.i(90224);
    if (paramServerSocket != null) {
      try
      {
        paramServerSocket.close();
        AppMethodBeat.o(90224);
        return;
      }
      catch (IOException paramServerSocket) {}
    }
    AppMethodBeat.o(90224);
  }
  
  public static void closeQuietly(@Nullable Socket paramSocket)
  {
    AppMethodBeat.i(90223);
    if (paramSocket != null) {
      try
      {
        paramSocket.close();
        AppMethodBeat.o(90223);
        return;
      }
      catch (IOException paramSocket) {}
    }
    AppMethodBeat.o(90223);
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(90226);
    long l = copyStream(paramInputStream, paramOutputStream, false);
    AppMethodBeat.o(90226);
    return l;
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(90227);
    long l = copyStream(paramInputStream, paramOutputStream, paramBoolean, 1024);
    AppMethodBeat.o(90227);
    return l;
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(90228);
    byte[] arrayOfByte = new byte[paramInt];
    long l = 0L;
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, paramInt);
        if (i == -1) {
          break;
        }
        l += i;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      if (!paramBoolean) {
        break label83;
      }
    }
    finally
    {
      if (paramBoolean)
      {
        closeQuietly(paramInputStream);
        closeQuietly(paramOutputStream);
      }
      AppMethodBeat.o(90228);
    }
    closeQuietly(paramInputStream);
    closeQuietly(paramOutputStream);
    label83:
    AppMethodBeat.o(90228);
    return l;
  }
  
  public static boolean isGzipByteBuffer(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte.length > 1) && ((paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8) == 35615);
  }
  
  /* Error */
  public static void lockAndTruncateFile(File paramFile)
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 89	java/io/File:exists	()Z
    //   9: ifne +18 -> 27
    //   12: new 91	java/io/FileNotFoundException
    //   15: dup
    //   16: invokespecial 92	java/io/FileNotFoundException:<init>	()V
    //   19: astore_0
    //   20: ldc 83
    //   22: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: athrow
    //   27: new 94	java/io/RandomAccessFile
    //   30: dup
    //   31: aload_0
    //   32: ldc 96
    //   34: invokespecial 99	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 103	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 109	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   47: astore_1
    //   48: aload_0
    //   49: lconst_0
    //   50: invokevirtual 113	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   53: pop
    //   54: aload_1
    //   55: ifnull +14 -> 69
    //   58: aload_1
    //   59: invokevirtual 118	java/nio/channels/FileLock:isValid	()Z
    //   62: ifeq +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 121	java/nio/channels/FileLock:release	()V
    //   69: aload_2
    //   70: invokestatic 77	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   73: ldc 83
    //   75: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_1
    //   85: ifnull +14 -> 99
    //   88: aload_1
    //   89: invokevirtual 118	java/nio/channels/FileLock:isValid	()Z
    //   92: ifeq +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 121	java/nio/channels/FileLock:release	()V
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokestatic 77	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   107: ldc 83
    //   109: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: goto -46 -> 69
    //   118: astore_1
    //   119: goto -20 -> 99
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -41 -> 84
    //   128: astore_0
    //   129: goto -45 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramFile	File
    //   47	49	1	localFileLock	java.nio.channels.FileLock
    //   118	1	1	localIOException	IOException
    //   124	1	1	localObject	Object
    //   37	67	2	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   27	38	79	finally
    //   65	69	114	java/io/IOException
    //   95	99	118	java/io/IOException
    //   38	48	122	finally
    //   48	54	128	finally
  }
  
  public static byte[] readInputStreamFully(InputStream paramInputStream)
  {
    AppMethodBeat.i(90229);
    paramInputStream = readInputStreamFully(paramInputStream, true);
    AppMethodBeat.o(90229);
    return paramInputStream;
  }
  
  public static byte[] readInputStreamFully(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(90230);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyStream(paramInputStream, localByteArrayOutputStream, paramBoolean);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(90230);
    return paramInputStream;
  }
  
  public static byte[] toByteArray(File paramFile)
  {
    AppMethodBeat.i(90231);
    paramFile = new IOUtils.zzb(paramFile, null).zzdd();
    AppMethodBeat.o(90231);
    return paramFile;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    AppMethodBeat.i(90232);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    zza(paramInputStream, localByteArrayOutputStream);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(90232);
    return paramInputStream;
  }
  
  private static long zza(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(90235);
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(90235);
    return l;
  }
  
  private static byte[] zza(InputStream paramInputStream, long paramLong)
  {
    AppMethodBeat.i(90234);
    if (paramLong > 2147483647L)
    {
      paramInputStream = new OutOfMemoryError(68 + "file is too large to fit in a byte array: " + paramLong + " bytes");
      AppMethodBeat.o(90234);
      throw paramInputStream;
    }
    if (paramLong == 0L)
    {
      paramInputStream = toByteArray(paramInputStream);
      AppMethodBeat.o(90234);
      return paramInputStream;
    }
    int j = (int)paramLong;
    byte[] arrayOfByte = new byte[j];
    int i = j;
    while (i > 0)
    {
      int k = j - i;
      int m = paramInputStream.read(arrayOfByte, k, i);
      if (m == -1)
      {
        paramInputStream = Arrays.copyOf(arrayOfByte, k);
        AppMethodBeat.o(90234);
        return paramInputStream;
      }
      i -= m;
    }
    i = paramInputStream.read();
    if (i == -1)
    {
      AppMethodBeat.o(90234);
      return arrayOfByte;
    }
    zza localzza = new zza(null);
    localzza.write(i);
    zza(paramInputStream, localzza);
    paramInputStream = Arrays.copyOf(arrayOfByte, localzza.size() + j);
    localzza.zza(paramInputStream, j);
    AppMethodBeat.o(90234);
    return paramInputStream;
  }
  
  static final class zza
    extends ByteArrayOutputStream
  {
    final void zza(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(90218);
      System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, this.count);
      AppMethodBeat.o(90218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.util.IOUtils
 * JD-Core Version:    0.7.0.1
 */