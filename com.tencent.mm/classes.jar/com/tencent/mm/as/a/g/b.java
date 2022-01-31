package com.tencent.mm.as.a.g;

import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String bkF = h.getExternalStorageDirectory().getAbsolutePath();
  public static final String bkH = bkF + "/tencent/MicroMsg/";
  public static final String erZ = bkH + ".tmp";
  public static long esa = 0L;
  
  public static String OY()
  {
    Object localObject = new StringBuilder().append(erZ).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    y.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(erZ);
    if (!localb.exists()) {
      localb.mkdirs();
    }
    return localObject;
  }
  
  public static boolean OZ()
  {
    long l = System.currentTimeMillis();
    if (l - esa > 86400000L)
    {
      y.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      esa = l;
      return true;
    }
    y.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    return false;
  }
  
  public static boolean Pa()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(erZ);
    try
    {
      if ((localb.exists()) && (!localb.isFile())) {
        a(localb, true);
      }
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
    }
    return false;
  }
  
  private static void a(com.tencent.mm.vfs.b paramb, boolean paramBoolean)
  {
    if ((paramb != null) && (paramb.exists()) && (paramb.isDirectory()))
    {
      com.tencent.mm.vfs.b[] arrayOfb = paramb.cLt();
      if ((arrayOfb != null) && (arrayOfb.length > 0))
      {
        int k = arrayOfb.length;
        int i = 0;
        if (i < k)
        {
          com.tencent.mm.vfs.b localb = arrayOfb[i];
          if ((localb != null) && (localb.exists()))
          {
            if (!localb.isFile()) {
              break label109;
            }
            if ((localb != null) && (localb.isFile()) && (localb.exists())) {
              localb.delete();
            }
          }
          label182:
          for (;;)
          {
            i += 1;
            break;
            label109:
            long l1 = localb.lastModified();
            long l2 = System.currentTimeMillis();
            y.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
            if (l2 - l1 >= 259200000L) {}
            for (int j = 1;; j = 0)
            {
              if ((j == 0) || (!paramBoolean)) {
                break label182;
              }
              a(localb, false);
              break;
            }
          }
        }
      }
      paramb.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.as.a.g.b
 * JD-Core Version:    0.7.0.1
 */