package com.tencent.mm.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class a
{
  public a.a bvf;
  public b bvg = null;
  
  public a(b paramb)
  {
    this.bvg = paramb;
  }
  
  public static a cc(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      if (i >= 8) {
        break label39;
      }
    }
    label39:
    do
    {
      for (;;)
      {
        return null;
        Object localObject;
        b localb;
        try
        {
          localObject = new File(paramString);
          if (!((File)localObject).exists()) {
            break;
          }
          i = (int)((File)localObject).length();
        }
        catch (Exception paramString) {}
      }
      localObject = a.a.s(d(paramString, i - 8, 8));
    } while ((localObject == null) || (((a.a)localObject).bvi < 0));
    localb = new b();
    localb.aH(d(paramString, i - ((a.a)localObject).bvi - 8, ((a.a)localObject).bvi));
    paramString = new a(localb);
    paramString.bvf = ((a.a)localObject);
    return paramString;
    return null;
  }
  
  public static boolean cd(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        a locala = cc(paramString);
        if ((locala != null) && (locala.bvg != null)) {
          try
          {
            paramString = new File(paramString);
            if (paramString.exists())
            {
              boolean bool = locala.bvg.apkMd5.equalsIgnoreCase(g.a(paramString, (int)(localFile.length() - (locala.bvf.bvi + 8) - 2L), new byte[] { 0, 0 }));
              return bool;
            }
          }
          catch (Exception paramString) {}
        }
      }
    }
    return false;
  }
  
  private static byte[] d(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      return null;
    }
    if (paramInt2 == -1)
    {
      paramInt2 = (int)((File)localObject).length();
      for (;;)
      {
        if (paramInt1 < 0) {
          return null;
        }
        if (paramInt2 <= 0) {
          return null;
        }
        int i = paramInt2;
        if (paramInt1 + paramInt2 > (int)((File)localObject).length()) {
          i = (int)((File)localObject).length() - paramInt1;
        }
        try
        {
          localObject = new RandomAccessFile(paramString, "r");
          paramString = new byte[i];
          long l = paramInt1;
          try
          {
            ((RandomAccessFile)localObject).seek(l);
            ((RandomAccessFile)localObject).readFully(paramString);
            ((RandomAccessFile)localObject).close();
            return paramString;
          }
          catch (Exception localException)
          {
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          return null;
        }
      }
    }
  }
  
  public final int o(File paramFile)
  {
    try
    {
      if (cc(paramFile.getAbsolutePath()) != null)
      {
        System.out.println("Error: duplicate append apk external info!");
        return -1;
      }
      byte[] arrayOfByte = this.bvg.toByteArray();
      Object localObject = new a.a(arrayOfByte.length);
      localObject = a.a.ak(a.a.bvh << 32 | ((a.a)localObject).bvi);
      int i = (byte)((arrayOfByte.length + 8) % 256);
      int j = (byte)((arrayOfByte.length + 8) / 256);
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      localRandomAccessFile.seek(paramFile.length() - 2L);
      localRandomAccessFile.write(new byte[] { i, j });
      localRandomAccessFile.close();
      paramFile = new FileOutputStream(paramFile, true);
      paramFile.write(arrayOfByte);
      paramFile.write((byte[])localObject);
      paramFile.flush();
      paramFile.close();
      return 0;
    }
    catch (Exception paramFile) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */