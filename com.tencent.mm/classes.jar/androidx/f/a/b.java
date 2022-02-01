package androidx.f.a;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b
{
  static void a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(192864);
    byte[] arrayOfByte = new byte[8192];
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, 8192);
      int i = paramInputStream.read(arrayOfByte, 0, j);
      if (i != j)
      {
        paramInputStream = new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
        AppMethodBeat.o(192864);
        throw paramInputStream;
      }
      paramInt -= i;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(192864);
  }
  
  static long[] aF(Object paramObject)
  {
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      long[] arrayOfLong = new long[paramObject.length];
      int i = 0;
      while (i < paramObject.length)
      {
        arrayOfLong[i] = paramObject[i];
        i += 1;
      }
      return arrayOfLong;
    }
    if ((paramObject instanceof long[])) {
      return (long[])paramObject;
    }
    return null;
  }
  
  static void b(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(192907);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        a.d(paramFileDescriptor);
        AppMethodBeat.o(192907);
        return;
      }
      catch (Exception paramFileDescriptor) {}
    }
    AppMethodBeat.o(192907);
  }
  
  static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192891);
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    while (i < 4)
    {
      localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(192891);
    return paramArrayOfByte;
  }
  
  static boolean c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {}
    while (paramArrayOfByte1.length < paramArrayOfByte2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        break label37;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label37:
    return true;
  }
  
  static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(192900);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(192900);
        return;
      }
      catch (RuntimeException paramCloseable)
      {
        AppMethodBeat.o(192900);
        throw paramCloseable;
      }
      catch (Exception paramCloseable) {}
    }
    AppMethodBeat.o(192900);
  }
  
  static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(192857);
    byte[] arrayOfByte = new byte[8192];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      i += j;
      paramOutputStream.write(arrayOfByte, 0, j);
    }
    AppMethodBeat.o(192857);
    return i;
  }
  
  static final class a
  {
    static long a(FileDescriptor paramFileDescriptor, long paramLong, int paramInt)
    {
      AppMethodBeat.i(192861);
      paramLong = Os.lseek(paramFileDescriptor, paramLong, paramInt);
      AppMethodBeat.o(192861);
      return paramLong;
    }
    
    static FileDescriptor c(FileDescriptor paramFileDescriptor)
    {
      AppMethodBeat.i(192856);
      paramFileDescriptor = Os.dup(paramFileDescriptor);
      AppMethodBeat.o(192856);
      return paramFileDescriptor;
    }
    
    static void d(FileDescriptor paramFileDescriptor)
    {
      AppMethodBeat.i(192869);
      Os.close(paramFileDescriptor);
      AppMethodBeat.o(192869);
    }
  }
  
  static final class b
  {
    static void a(MediaMetadataRetriever paramMediaMetadataRetriever, MediaDataSource paramMediaDataSource)
    {
      AppMethodBeat.i(192852);
      paramMediaMetadataRetriever.setDataSource(paramMediaDataSource);
      AppMethodBeat.o(192852);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.f.a.b
 * JD-Core Version:    0.7.0.1
 */