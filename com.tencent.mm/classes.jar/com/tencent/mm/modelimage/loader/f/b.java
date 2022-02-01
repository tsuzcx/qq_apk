package com.tencent.mm.modelimage.loader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String ntb;
  public static long ntd;
  
  static
  {
    AppMethodBeat.i(130455);
    ntb = com.tencent.mm.loader.i.b.bmz() + ".tmp";
    ntd = 0L;
    AppMethodBeat.o(130455);
  }
  
  private static void b(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(130454);
    if ((paramu != null) && (paramu.jKS()) && (paramu.isDirectory()))
    {
      u[] arrayOfu = paramu.jKX();
      if ((arrayOfu != null) && (arrayOfu.length > 0))
      {
        int j = arrayOfu.length;
        int i = 0;
        if (i < j)
        {
          u localu = arrayOfu[i];
          if ((localu != null) && (localu.jKS()))
          {
            if (!localu.jKV()) {
              break label90;
            }
            l(localu);
          }
          for (;;)
          {
            i += 1;
            break;
            label90:
            if ((iW(localu.lastModified())) && (paramBoolean)) {
              b(localu, false);
            }
          }
        }
      }
      paramu.diJ();
    }
    AppMethodBeat.o(130454);
  }
  
  public static boolean bKG()
  {
    AppMethodBeat.i(130450);
    long l = System.currentTimeMillis();
    if (l - ntd > 86400000L)
    {
      Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      ntd = l;
      AppMethodBeat.o(130450);
      return true;
    }
    Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    AppMethodBeat.o(130450);
    return false;
  }
  
  public static boolean bKH()
  {
    AppMethodBeat.i(130451);
    u localu = new u(ntb);
    try
    {
      if ((localu.jKS()) && (!localu.jKV())) {
        b(localu, true);
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
  
  public static String bnI()
  {
    AppMethodBeat.i(130449);
    Object localObject = new StringBuilder().append(ntb).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    u localu = new u(ntb);
    if (!localu.jKS()) {
      localu.jKY();
    }
    AppMethodBeat.o(130449);
    return localObject;
  }
  
  private static boolean iW(long paramLong)
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
  
  private static void l(u paramu)
  {
    AppMethodBeat.i(130453);
    if ((paramu != null) && (paramu.jKV()) && (paramu.jKS())) {
      paramu.diJ();
    }
    AppMethodBeat.o(130453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.f.b
 * JD-Core Version:    0.7.0.1
 */