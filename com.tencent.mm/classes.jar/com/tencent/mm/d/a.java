package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.RandomAccessFile;

public final class a
{
  public a hel;
  public b hem = null;
  
  public a(b paramb)
  {
    this.hem = paramb;
  }
  
  public static a hY(String paramString)
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
    localObject = a.ab(o(paramString, i - 8, 8));
    if (localObject == null)
    {
      AppMethodBeat.o(962);
      return null;
    }
    if (((a)localObject).heo >= 0)
    {
      localb = new b();
      localb.parseFrom(o(paramString, i - ((a)localObject).heo - 8, ((a)localObject).heo));
      paramString = new a(localb);
      paramString.hel = ((a)localObject);
      AppMethodBeat.o(962);
      return paramString;
    }
    return null;
  }
  
  public static boolean hZ(String paramString)
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
    a locala = hY(paramString);
    if ((locala != null) && (locala.hem != null)) {}
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        break label138;
      }
      boolean bool = locala.hem.apkMd5.equalsIgnoreCase(g.a(paramString, (int)(localFile.length() - (locala.hel.heo + 8) - 2L), new byte[] { 0, 0 }));
      AppMethodBeat.o(963);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(963);
    }
    AppMethodBeat.o(963);
    return true;
    label138:
    return false;
  }
  
  private static byte[] o(String paramString, int paramInt1, int paramInt2)
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
  
  public static final class a
  {
    private static final long hen;
    public int heo = 0;
    
    static
    {
      AppMethodBeat.i(959);
      hen = "Micromsg".hashCode();
      AppMethodBeat.o(959);
    }
    
    private a(int paramInt)
    {
      this.heo = paramInt;
    }
    
    public static a ab(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(960);
      long l;
      if (paramArrayOfByte.length == 8)
      {
        l = 0L;
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          l |= (paramArrayOfByte[i] & 0xFF) << i * 8;
          i += 1;
        }
        if (l >> 32 != hen) {}
      }
      for (paramArrayOfByte = new a((int)l);; paramArrayOfByte = null)
      {
        AppMethodBeat.o(960);
        return paramArrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a
 * JD-Core Version:    0.7.0.1
 */