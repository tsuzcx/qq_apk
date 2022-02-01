package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class a
{
  public a cSI;
  public b cSJ = null;
  
  public a(b paramb)
  {
    this.cSJ = paramb;
  }
  
  public static a fa(String paramString)
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
    localObject = a.G(k(paramString, i - 8, 8));
    if (localObject == null)
    {
      AppMethodBeat.o(962);
      return null;
    }
    if (((a)localObject).cSL >= 0)
    {
      localb = new b();
      localb.parseFrom(k(paramString, i - ((a)localObject).cSL - 8, ((a)localObject).cSL));
      paramString = new a(localb);
      paramString.cSI = ((a)localObject);
      AppMethodBeat.o(962);
      return paramString;
    }
    return null;
  }
  
  public static boolean fb(String paramString)
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
    a locala = fa(paramString);
    if ((locala != null) && (locala.cSJ != null)) {
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          boolean bool = locala.cSJ.apkMd5.equalsIgnoreCase(g.a(paramString, (int)(localFile.length() - (locala.cSI.cSL + 8) - 2L), new byte[] { 0, 0 }));
          AppMethodBeat.o(963);
          return bool;
        }
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(963);
    return false;
  }
  
  private static byte[] k(String paramString, int paramInt1, int paramInt2)
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
      if (fa(paramFile.getAbsolutePath()) != null)
      {
        System.out.println("Error: duplicate append apk external info!");
        AppMethodBeat.o(961);
        return -1;
      }
      byte[] arrayOfByte = this.cSJ.toByteArray();
      Object localObject = new a(arrayOfByte.length);
      localObject = a.be(a.cSK << 32 | ((a)localObject).cSL);
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
  
  public static final class a
  {
    static final long cSK;
    public int cSL = 0;
    
    static
    {
      AppMethodBeat.i(959);
      cSK = "Micromsg".hashCode();
      AppMethodBeat.o(959);
    }
    
    public a(int paramInt)
    {
      this.cSL = paramInt;
    }
    
    public static a G(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(960);
      long l;
      int i;
      if (paramArrayOfByte.length == 8)
      {
        l = 0L;
        i = 0;
        if (i >= paramArrayOfByte.length) {
          if (l >> 32 != cSK) {
            break label75;
          }
        }
      }
      label75:
      for (paramArrayOfByte = new a((int)l);; paramArrayOfByte = null)
      {
        AppMethodBeat.o(960);
        return paramArrayOfByte;
        l |= (paramArrayOfByte[i] & 0xFF) << i * 8;
        i += 1;
        break;
      }
    }
    
    static byte[] be(long paramLong)
    {
      byte[] arrayOfByte = new byte[8];
      int i = 0;
      for (;;)
      {
        if (i >= 8) {
          return arrayOfByte;
        }
        arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8 & 0xFF));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.a
 * JD-Core Version:    0.7.0.1
 */