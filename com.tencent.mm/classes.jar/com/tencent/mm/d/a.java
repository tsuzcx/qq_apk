package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class a
{
  public a.a cGU;
  public b cGV = null;
  
  public a(b paramb)
  {
    this.cGV = paramb;
  }
  
  public static a ea(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(962);
    if (paramString == null) {}
    for (;;)
    {
      if (i < 8)
      {
        AppMethodBeat.o(962);
        return null;
      }
      try
      {
        localObject = new File(paramString);
        if (((File)localObject).exists()) {
          i = (int)((File)localObject).length();
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        b localb;
        AppMethodBeat.o(962);
      }
    }
    localObject = a.a.G(i(paramString, i - 8, 8));
    if (localObject == null)
    {
      AppMethodBeat.o(962);
      return null;
    }
    if (((a.a)localObject).cGX >= 0)
    {
      localb = new b();
      localb.parseFrom(i(paramString, i - ((a.a)localObject).cGX - 8, ((a.a)localObject).cGX));
      paramString = new a(localb);
      paramString.cGU = ((a.a)localObject);
      AppMethodBeat.o(962);
      return paramString;
    }
    return null;
  }
  
  public static boolean eb(String paramString)
  {
    AppMethodBeat.i(963);
    if (paramString == null)
    {
      AppMethodBeat.o(963);
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      AppMethodBeat.o(963);
      return false;
    }
    a locala = ea(paramString);
    if ((locala != null) && (locala.cGV != null)) {
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          boolean bool = locala.cGV.apkMd5.equalsIgnoreCase(g.a(paramString, (int)(localFile.length() - (locala.cGU.cGX + 8) - 2L), new byte[] { 0, 0 }));
          AppMethodBeat.o(963);
          return bool;
        }
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(963);
    return false;
  }
  
  private static byte[] i(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(964);
    if (paramString == null)
    {
      AppMethodBeat.o(964);
      return null;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      AppMethodBeat.o(964);
      return null;
    }
    if (paramInt2 == -1)
    {
      paramInt2 = (int)((File)localObject).length();
      for (;;)
      {
        if (paramInt1 < 0)
        {
          AppMethodBeat.o(964);
          return null;
        }
        if (paramInt2 <= 0)
        {
          AppMethodBeat.o(964);
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
          l = paramInt1;
        }
        catch (Exception paramString)
        {
          try
          {
            long l;
            ((RandomAccessFile)localObject).seek(l);
            ((RandomAccessFile)localObject).readFully(paramString);
            ((RandomAccessFile)localObject).close();
            for (;;)
            {
              label141:
              AppMethodBeat.o(964);
              return paramString;
              paramString = paramString;
              paramString = null;
            }
          }
          catch (Exception localException)
          {
            break label141;
          }
        }
      }
    }
  }
  
  public final int A(File paramFile)
  {
    AppMethodBeat.i(961);
    try
    {
      if (ea(paramFile.getAbsolutePath()) != null)
      {
        System.out.println("Error: duplicate append apk external info!");
        AppMethodBeat.o(961);
        return -1;
      }
      byte[] arrayOfByte = this.cGV.toByteArray();
      Object localObject = new a.a(arrayOfByte.length);
      localObject = a.a.be(a.a.cGW << 32 | ((a.a)localObject).cGX);
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
      AppMethodBeat.o(961);
      return 0;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(961);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a
 * JD-Core Version:    0.7.0.1
 */