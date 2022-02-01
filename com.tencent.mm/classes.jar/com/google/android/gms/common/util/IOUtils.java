package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public final class IOUtils
{
  public static void close(Closeable paramCloseable, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5247);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(5247);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(5247);
  }
  
  public static void closeQuietly(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(5244);
    if (paramParcelFileDescriptor != null) {
      try
      {
        paramParcelFileDescriptor.close();
        AppMethodBeat.o(5244);
        return;
      }
      catch (IOException paramParcelFileDescriptor) {}
    }
    AppMethodBeat.o(5244);
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(5243);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(5243);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(5243);
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    AppMethodBeat.i(5246);
    if (paramServerSocket != null) {
      try
      {
        paramServerSocket.close();
        AppMethodBeat.o(5246);
        return;
      }
      catch (IOException paramServerSocket) {}
    }
    AppMethodBeat.o(5246);
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    AppMethodBeat.i(5245);
    if (paramSocket != null) {
      try
      {
        paramSocket.close();
        AppMethodBeat.o(5245);
        return;
      }
      catch (IOException paramSocket) {}
    }
    AppMethodBeat.o(5245);
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(5248);
    long l = copyStream(paramInputStream, paramOutputStream, false);
    AppMethodBeat.o(5248);
    return l;
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(5249);
    long l = copyStream(paramInputStream, paramOutputStream, paramBoolean, 1024);
    AppMethodBeat.o(5249);
    return l;
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(5250);
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
        break label85;
      }
    }
    finally
    {
      if (paramBoolean)
      {
        closeQuietly(paramInputStream);
        closeQuietly(paramOutputStream);
      }
      AppMethodBeat.o(5250);
    }
    closeQuietly(paramInputStream);
    closeQuietly(paramOutputStream);
    label85:
    AppMethodBeat.o(5250);
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
    //   0: sipush 5255
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 79	java/io/File:exists	()Z
    //   10: ifne +19 -> 29
    //   13: new 81	java/io/FileNotFoundException
    //   16: dup
    //   17: invokespecial 82	java/io/FileNotFoundException:<init>	()V
    //   20: astore_0
    //   21: sipush 5255
    //   24: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: athrow
    //   29: new 84	java/io/RandomAccessFile
    //   32: dup
    //   33: aload_0
    //   34: ldc 86
    //   36: invokespecial 89	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 93	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 99	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   49: astore_1
    //   50: aload_0
    //   51: lconst_0
    //   52: invokevirtual 103	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   55: pop
    //   56: aload_1
    //   57: ifnull +14 -> 71
    //   60: aload_1
    //   61: invokevirtual 108	java/nio/channels/FileLock:isValid	()Z
    //   64: ifeq +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 111	java/nio/channels/FileLock:release	()V
    //   71: aload_2
    //   72: invokestatic 68	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   75: sipush 5255
    //   78: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_1
    //   88: ifnull +14 -> 102
    //   91: aload_1
    //   92: invokevirtual 108	java/nio/channels/FileLock:isValid	()Z
    //   95: ifeq +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 111	java/nio/channels/FileLock:release	()V
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokestatic 68	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   110: sipush 5255
    //   113: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_0
    //   117: athrow
    //   118: astore_0
    //   119: goto -48 -> 71
    //   122: astore_1
    //   123: goto -21 -> 102
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: goto -42 -> 87
    //   132: astore_0
    //   133: goto -46 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramFile	File
    //   49	50	1	localFileLock	java.nio.channels.FileLock
    //   122	1	1	localIOException	IOException
    //   128	1	1	localObject	Object
    //   39	68	2	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   29	40	82	finally
    //   67	71	118	java/io/IOException
    //   98	102	122	java/io/IOException
    //   40	50	126	finally
    //   50	56	132	finally
  }
  
  public static byte[] readInputStreamFully(InputStream paramInputStream)
  {
    AppMethodBeat.i(5251);
    paramInputStream = readInputStreamFully(paramInputStream, true);
    AppMethodBeat.o(5251);
    return paramInputStream;
  }
  
  public static byte[] readInputStreamFully(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(5252);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyStream(paramInputStream, localByteArrayOutputStream, paramBoolean);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(5252);
    return paramInputStream;
  }
  
  public static byte[] toByteArray(File paramFile)
  {
    AppMethodBeat.i(5253);
    paramFile = new zzb(paramFile, null).zzdd();
    AppMethodBeat.o(5253);
    return paramFile;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    AppMethodBeat.i(5254);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    zza(paramInputStream, localByteArrayOutputStream);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(5254);
    return paramInputStream;
  }
  
  private static long zza(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(5257);
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
    AppMethodBeat.o(5257);
    return l;
  }
  
  private static byte[] zza(InputStream paramInputStream, long paramLong)
  {
    AppMethodBeat.i(5256);
    if (paramLong > 2147483647L)
    {
      paramInputStream = new OutOfMemoryError(68 + "file is too large to fit in a byte array: " + paramLong + " bytes");
      AppMethodBeat.o(5256);
      throw paramInputStream;
    }
    if (paramLong == 0L)
    {
      paramInputStream = toByteArray(paramInputStream);
      AppMethodBeat.o(5256);
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
        AppMethodBeat.o(5256);
        return paramInputStream;
      }
      i -= m;
    }
    i = paramInputStream.read();
    if (i == -1)
    {
      AppMethodBeat.o(5256);
      return arrayOfByte;
    }
    zza localzza = new zza(null);
    localzza.write(i);
    zza(paramInputStream, localzza);
    paramInputStream = Arrays.copyOf(arrayOfByte, localzza.size() + j);
    localzza.zza(paramInputStream, j);
    AppMethodBeat.o(5256);
    return paramInputStream;
  }
  
  static final class zza
    extends ByteArrayOutputStream
  {
    final void zza(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(5240);
      System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, this.count);
      AppMethodBeat.o(5240);
    }
  }
  
  static final class zzb
  {
    private final File file;
    
    private zzb(File paramFile)
    {
      AppMethodBeat.i(5241);
      this.file = ((File)Preconditions.checkNotNull(paramFile));
      AppMethodBeat.o(5241);
    }
    
    public final byte[] zzdd()
    {
      AppMethodBeat.i(5242);
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.file);
        byte[] arrayOfByte;
        IOUtils.closeQuietly(localFileInputStream);
      }
      finally
      {
        try
        {
          arrayOfByte = IOUtils.zzb(localFileInputStream, localFileInputStream.getChannel().size());
          IOUtils.closeQuietly(localFileInputStream);
          AppMethodBeat.o(5242);
          return arrayOfByte;
        }
        finally {}
        localObject1 = finally;
        localFileInputStream = null;
      }
      AppMethodBeat.o(5242);
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.IOUtils
 * JD-Core Version:    0.7.0.1
 */