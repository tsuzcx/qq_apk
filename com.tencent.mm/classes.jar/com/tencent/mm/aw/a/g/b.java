package com.tencent.mm.aw.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String hhi;
  public static long hhk;
  
  static
  {
    AppMethodBeat.i(130455);
    hhi = com.tencent.mm.loader.j.b.arU() + ".tmp";
    hhk = 0L;
    AppMethodBeat.o(130455);
  }
  
  public static boolean aJh()
  {
    AppMethodBeat.i(130450);
    long l = System.currentTimeMillis();
    if (l - hhk > 86400000L)
    {
      ad.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      hhk = l;
      AppMethodBeat.o(130450);
      return true;
    }
    ad.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    AppMethodBeat.o(130450);
    return false;
  }
  
  public static boolean aJi()
  {
    AppMethodBeat.i(130451);
    e locale = new e(hhi);
    try
    {
      if ((locale.exists()) && (!locale.isFile())) {
        b(locale, true);
      }
      AppMethodBeat.o(130451);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
      AppMethodBeat.o(130451);
    }
    return false;
  }
  
  public static String asY()
  {
    AppMethodBeat.i(130449);
    Object localObject = new StringBuilder().append(hhi).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ad.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    e locale = new e(hhi);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(130449);
    return localObject;
  }
  
  private static void b(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(130454);
    if ((parame != null) && (parame.exists()) && (parame.isDirectory()))
    {
      e[] arrayOfe = parame.fOM();
      if ((arrayOfe != null) && (arrayOfe.length > 0))
      {
        int j = arrayOfe.length;
        int i = 0;
        if (i < j)
        {
          e locale = arrayOfe[i];
          if ((locale != null) && (locale.exists()))
          {
            if (!locale.isFile()) {
              break label90;
            }
            m(locale);
          }
          for (;;)
          {
            i += 1;
            break;
            label90:
            if ((sk(locale.lastModified())) && (paramBoolean)) {
              b(locale, false);
            }
          }
        }
      }
      parame.delete();
    }
    AppMethodBeat.o(130454);
  }
  
  private static void m(e parame)
  {
    AppMethodBeat.i(130453);
    if ((parame != null) && (parame.isFile()) && (parame.exists())) {
      parame.delete();
    }
    AppMethodBeat.o(130453);
  }
  
  private static boolean sk(long paramLong)
  {
    AppMethodBeat.i(130452);
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
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
 * Qualified Name:     com.tencent.mm.aw.a.g.b
 * JD-Core Version:    0.7.0.1
 */