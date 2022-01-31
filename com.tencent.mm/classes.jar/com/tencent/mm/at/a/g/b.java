package com.tencent.mm.at.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String eQS;
  public static long eQT;
  public static final String eQx;
  public static final String eQz;
  
  static
  {
    AppMethodBeat.i(116126);
    eQx = h.getExternalStorageDirectory().getAbsolutePath();
    eQz = eQx + "/tencent/MicroMsg/";
    eQS = eQz + ".tmp";
    eQT = 0L;
    AppMethodBeat.o(116126);
  }
  
  public static String Uq()
  {
    AppMethodBeat.i(116120);
    Object localObject = new StringBuilder().append(eQS).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(eQS);
    if (!localb.exists()) {
      localb.mkdirs();
    }
    AppMethodBeat.o(116120);
    return localObject;
  }
  
  public static boolean Ur()
  {
    AppMethodBeat.i(116121);
    long l = System.currentTimeMillis();
    if (l - eQT > 86400000L)
    {
      ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      eQT = l;
      AppMethodBeat.o(116121);
      return true;
    }
    ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    AppMethodBeat.o(116121);
    return false;
  }
  
  private static void a(com.tencent.mm.vfs.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(116125);
    if ((paramb != null) && (paramb.exists()) && (paramb.isDirectory()))
    {
      com.tencent.mm.vfs.b[] arrayOfb = paramb.dQL();
      if ((arrayOfb != null) && (arrayOfb.length > 0))
      {
        int j = arrayOfb.length;
        int i = 0;
        if (i < j)
        {
          com.tencent.mm.vfs.b localb = arrayOfb[i];
          if ((localb != null) && (localb.exists()))
          {
            if (!localb.isFile()) {
              break label90;
            }
            f(localb);
          }
          for (;;)
          {
            i += 1;
            break;
            label90:
            if ((gY(localb.lastModified())) && (paramBoolean)) {
              a(localb, false);
            }
          }
        }
      }
      paramb.delete();
    }
    AppMethodBeat.o(116125);
  }
  
  public static boolean aib()
  {
    AppMethodBeat.i(116122);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(eQS);
    try
    {
      if ((localb.exists()) && (!localb.isFile())) {
        a(localb, true);
      }
      AppMethodBeat.o(116122);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
      AppMethodBeat.o(116122);
    }
    return false;
  }
  
  private static void f(com.tencent.mm.vfs.b paramb)
  {
    AppMethodBeat.i(116124);
    if ((paramb != null) && (paramb.isFile()) && (paramb.exists())) {
      paramb.delete();
    }
    AppMethodBeat.o(116124);
  }
  
  private static boolean gY(long paramLong)
  {
    AppMethodBeat.i(116123);
    long l = System.currentTimeMillis();
    ab.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    if (l - paramLong >= 259200000L)
    {
      AppMethodBeat.o(116123);
      return true;
    }
    AppMethodBeat.o(116123);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.a.g.b
 * JD-Core Version:    0.7.0.1
 */