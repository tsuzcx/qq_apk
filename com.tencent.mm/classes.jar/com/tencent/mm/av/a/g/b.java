package com.tencent.mm.av.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String icT;
  public static long icV;
  
  static
  {
    AppMethodBeat.i(130455);
    icT = com.tencent.mm.loader.j.b.aKJ() + ".tmp";
    icV = 0L;
    AppMethodBeat.o(130455);
  }
  
  private static boolean AD(long paramLong)
  {
    AppMethodBeat.i(130452);
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    if (l - paramLong >= 259200000L)
    {
      AppMethodBeat.o(130452);
      return true;
    }
    AppMethodBeat.o(130452);
    return false;
  }
  
  public static String aLN()
  {
    AppMethodBeat.i(130449);
    Object localObject = new StringBuilder().append(icT).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    o localo = new o(icT);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(130449);
    return localObject;
  }
  
  private static void b(o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(130454);
    if ((paramo != null) && (paramo.exists()) && (paramo.isDirectory()))
    {
      o[] arrayOfo = paramo.het();
      if ((arrayOfo != null) && (arrayOfo.length > 0))
      {
        int j = arrayOfo.length;
        int i = 0;
        if (i < j)
        {
          o localo = arrayOfo[i];
          if ((localo != null) && (localo.exists()))
          {
            if (!localo.isFile()) {
              break label90;
            }
            l(localo);
          }
          for (;;)
          {
            i += 1;
            break;
            label90:
            if ((AD(localo.lastModified())) && (paramBoolean)) {
              b(localo, false);
            }
          }
        }
      }
      paramo.delete();
    }
    AppMethodBeat.o(130454);
  }
  
  public static boolean bdA()
  {
    AppMethodBeat.i(130450);
    long l = System.currentTimeMillis();
    if (l - icV > 86400000L)
    {
      Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      icV = l;
      AppMethodBeat.o(130450);
      return true;
    }
    Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    AppMethodBeat.o(130450);
    return false;
  }
  
  public static boolean bdB()
  {
    AppMethodBeat.i(130451);
    o localo = new o(icT);
    try
    {
      if ((localo.exists()) && (!localo.isFile())) {
        b(localo, true);
      }
      AppMethodBeat.o(130451);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
      AppMethodBeat.o(130451);
    }
    return false;
  }
  
  private static void l(o paramo)
  {
    AppMethodBeat.i(130453);
    if ((paramo != null) && (paramo.isFile()) && (paramo.exists())) {
      paramo.delete();
    }
    AppMethodBeat.o(130453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.a.g.b
 * JD-Core Version:    0.7.0.1
 */