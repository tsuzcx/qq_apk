package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class a
{
  public a bWq;
  public b bWr = null;
  
  public a(b paramb)
  {
    this.bWr = paramb;
  }
  
  public static a dn(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(125702);
    if (paramString == null) {}
    for (;;)
    {
      if (i < 8)
      {
        AppMethodBeat.o(125702);
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
        AppMethodBeat.o(125702);
      }
    }
    localObject = a.B(j(paramString, i - 8, 8));
    if (localObject == null)
    {
      AppMethodBeat.o(125702);
      return null;
    }
    if (((a)localObject).bWt >= 0)
    {
      localb = new b();
      localb.parseFrom(j(paramString, i - ((a)localObject).bWt - 8, ((a)localObject).bWt));
      paramString = new a(localb);
      paramString.bWq = ((a)localObject);
      AppMethodBeat.o(125702);
      return paramString;
    }
    return null;
  }
  
  public static boolean jdMethod_do(String paramString)
  {
    AppMethodBeat.i(125703);
    if (paramString == null)
    {
      AppMethodBeat.o(125703);
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      AppMethodBeat.o(125703);
      return false;
    }
    a locala = dn(paramString);
    if ((locala != null) && (locala.bWr != null)) {
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          boolean bool = locala.bWr.apkMd5.equalsIgnoreCase(g.a(paramString, (int)(localFile.length() - (locala.bWq.bWt + 8) - 2L), new byte[] { 0, 0 }));
          AppMethodBeat.o(125703);
          return bool;
        }
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(125703);
    return false;
  }
  
  private static byte[] j(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125704);
    if (paramString == null)
    {
      AppMethodBeat.o(125704);
      return null;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      AppMethodBeat.o(125704);
      return null;
    }
    if (paramInt2 == -1)
    {
      paramInt2 = (int)((File)localObject).length();
      for (;;)
      {
        if (paramInt1 < 0)
        {
          AppMethodBeat.o(125704);
          return null;
        }
        if (paramInt2 <= 0)
        {
          AppMethodBeat.o(125704);
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
              label136:
              AppMethodBeat.o(125704);
              return paramString;
              paramString = paramString;
              paramString = null;
            }
          }
          catch (Exception localException)
          {
            break label136;
          }
        }
      }
    }
  }
  
  public final int t(File paramFile)
  {
    AppMethodBeat.i(125701);
    try
    {
      if (dn(paramFile.getAbsolutePath()) != null)
      {
        System.out.println("Error: duplicate append apk external info!");
        AppMethodBeat.o(125701);
        return -1;
      }
      byte[] arrayOfByte = this.bWr.toByteArray();
      Object localObject = new a(arrayOfByte.length);
      localObject = a.aH(a.bWs << 32 | ((a)localObject).bWt);
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
      AppMethodBeat.o(125701);
      return 0;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(125701);
    }
    return -1;
  }
  
  public static final class a
  {
    static final long bWs;
    public int bWt = 0;
    
    static
    {
      AppMethodBeat.i(125699);
      bWs = "Micromsg".hashCode();
      AppMethodBeat.o(125699);
    }
    
    public a(int paramInt)
    {
      this.bWt = paramInt;
    }
    
    public static a B(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(125700);
      long l;
      int i;
      if (paramArrayOfByte.length == 8)
      {
        l = 0L;
        i = 0;
        if (i >= paramArrayOfByte.length) {
          if (l >> 32 != bWs) {
            break label73;
          }
        }
      }
      label73:
      for (paramArrayOfByte = new a((int)l);; paramArrayOfByte = null)
      {
        AppMethodBeat.o(125700);
        return paramArrayOfByte;
        l |= (paramArrayOfByte[i] & 0xFF) << i * 8;
        i += 1;
        break;
      }
    }
    
    static byte[] aH(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */