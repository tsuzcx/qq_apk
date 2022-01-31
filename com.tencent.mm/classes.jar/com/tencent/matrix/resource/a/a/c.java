package com.tencent.matrix.resource.a.a;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public final class c
{
  public static void S(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((paramObject instanceof Closeable))
        {
          ((Closeable)paramObject).close();
          return;
        }
        if ((paramObject instanceof ZipFile))
        {
          ((ZipFile)paramObject).close();
          return;
        }
      }
      catch (Throwable paramObject) {}
    }
  }
  
  public static void a(File paramFile, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    try
    {
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      try
      {
        for (;;)
        {
          int i = paramFile.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        S(paramOutputStream);
      }
      finally
      {
        paramOutputStream = paramFile;
        paramFile = localObject;
      }
    }
    finally
    {
      for (;;)
      {
        paramOutputStream = null;
      }
    }
    throw paramFile;
    paramOutputStream.flush();
    S(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.a.a.c
 * JD-Core Version:    0.7.0.1
 */