package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class e
{
  public static final boolean a(o paramo)
  {
    int i = 0;
    if (!paramo.exists()) {}
    do
    {
      do
      {
        return false;
      } while (!paramo.isDirectory());
      paramo = paramo.het();
    } while (paramo == null);
    while (i < paramo.length)
    {
      paramo[i].delete();
      i += 1;
    }
    return true;
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l2;
    if ((paramInputStream == null) || (paramOutputStream == null)) {
      l2 = 0L;
    }
    for (;;)
    {
      return l2;
      try
      {
        byte[] arrayOfByte = new byte[4096];
        int i;
        for (long l1 = 0L;; l1 += i)
        {
          i = paramInputStream.read(arrayOfByte);
          l2 = l1;
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        return 0L;
      }
      catch (Exception paramInputStream)
      {
        Log.w("MicroMsg.FileOperation", "copyStream error: %s", new Object[] { paramInputStream.getMessage() });
      }
    }
  }
  
  public static void f(String... paramVarArgs)
  {
    int i = 0;
    while (i <= 0)
    {
      String str = paramVarArgs[0];
      o localo = new o(str);
      if ((!localo.exists()) && ((!localo.mkdirs()) || (!localo.isDirectory()))) {
        Log.e("MicroMsg.FileOperation", "batchMkDirs mkdir error. %s", new Object[] { str });
      }
      i += 1;
    }
  }
  
  public static byte[] readFromStream(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    int i = 0;
    for (;;)
    {
      try
      {
        int j = paramInputStream.read(arrayOfByte, 0, 1024);
        i = j;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      if (i <= 0) {
        continue;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.e
 * JD-Core Version:    0.7.0.1
 */