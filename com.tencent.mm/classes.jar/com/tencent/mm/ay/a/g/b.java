package com.tencent.mm.ay.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String kRA;
  public static long kRC;
  
  static
  {
    AppMethodBeat.i(130455);
    kRA = com.tencent.mm.loader.j.b.aSL() + ".tmp";
    kRC = 0L;
    AppMethodBeat.o(130455);
  }
  
  private static boolean GL(long paramLong)
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
  
  public static String aTT()
  {
    AppMethodBeat.i(130449);
    Object localObject = new StringBuilder().append(kRA).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    q localq = new q(kRA);
    if (!localq.ifE()) {
      localq.ifL();
    }
    AppMethodBeat.o(130449);
    return localObject;
  }
  
  private static void b(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(130454);
    if ((paramq != null) && (paramq.ifE()) && (paramq.isDirectory()))
    {
      q[] arrayOfq = paramq.ifJ();
      if ((arrayOfq != null) && (arrayOfq.length > 0))
      {
        int j = arrayOfq.length;
        int i = 0;
        if (i < j)
        {
          q localq = arrayOfq[i];
          if ((localq != null) && (localq.ifE()))
          {
            if (!localq.ifH()) {
              break label90;
            }
            l(localq);
          }
          for (;;)
          {
            i += 1;
            break;
            label90:
            if ((GL(localq.lastModified())) && (paramBoolean)) {
              b(localq, false);
            }
          }
        }
      }
      paramq.cFq();
    }
    AppMethodBeat.o(130454);
  }
  
  public static boolean bmU()
  {
    AppMethodBeat.i(130450);
    long l = System.currentTimeMillis();
    if (l - kRC > 86400000L)
    {
      Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      kRC = l;
      AppMethodBeat.o(130450);
      return true;
    }
    Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    AppMethodBeat.o(130450);
    return false;
  }
  
  public static boolean bmV()
  {
    AppMethodBeat.i(130451);
    q localq = new q(kRA);
    try
    {
      if ((localq.ifE()) && (!localq.ifH())) {
        b(localq, true);
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
  
  private static void l(q paramq)
  {
    AppMethodBeat.i(130453);
    if ((paramq != null) && (paramq.ifH()) && (paramq.ifE())) {
      paramq.cFq();
    }
    AppMethodBeat.o(130453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ay.a.g.b
 * JD-Core Version:    0.7.0.1
 */