package com.tencent.mm.av.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String hjW;
  public static long hjY;
  
  static
  {
    AppMethodBeat.i(130455);
    hjW = com.tencent.mm.loader.j.b.asj() + ".tmp";
    hjY = 0L;
    AppMethodBeat.o(130455);
  }
  
  public static boolean aJA()
  {
    AppMethodBeat.i(130451);
    k localk = new k(hjW);
    try
    {
      if ((localk.exists()) && (!localk.isFile())) {
        b(localk, true);
      }
      AppMethodBeat.o(130451);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
      AppMethodBeat.o(130451);
    }
    return false;
  }
  
  public static boolean aJz()
  {
    AppMethodBeat.i(130450);
    long l = System.currentTimeMillis();
    if (l - hjY > 86400000L)
    {
      ae.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      hjY = l;
      AppMethodBeat.o(130450);
      return true;
    }
    ae.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    AppMethodBeat.o(130450);
    return false;
  }
  
  public static String atn()
  {
    AppMethodBeat.i(130449);
    Object localObject = new StringBuilder().append(hjW).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ae.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    k localk = new k(hjW);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(130449);
    return localObject;
  }
  
  private static void b(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(130454);
    if ((paramk != null) && (paramk.exists()) && (paramk.isDirectory()))
    {
      k[] arrayOfk = paramk.fTj();
      if ((arrayOfk != null) && (arrayOfk.length > 0))
      {
        int j = arrayOfk.length;
        int i = 0;
        if (i < j)
        {
          k localk = arrayOfk[i];
          if ((localk != null) && (localk.exists()))
          {
            if (!localk.isFile()) {
              break label90;
            }
            m(localk);
          }
          for (;;)
          {
            i += 1;
            break;
            label90:
            if ((sx(localk.lastModified())) && (paramBoolean)) {
              b(localk, false);
            }
          }
        }
      }
      paramk.delete();
    }
    AppMethodBeat.o(130454);
  }
  
  private static void m(k paramk)
  {
    AppMethodBeat.i(130453);
    if ((paramk != null) && (paramk.isFile()) && (paramk.exists())) {
      paramk.delete();
    }
    AppMethodBeat.o(130453);
  }
  
  private static boolean sx(long paramLong)
  {
    AppMethodBeat.i(130452);
    long l = System.currentTimeMillis();
    ae.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    if (l - paramLong >= 259200000L)
    {
      AppMethodBeat.o(130452);
      return true;
    }
    AppMethodBeat.o(130452);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.av.a.g.b
 * JD-Core Version:    0.7.0.1
 */