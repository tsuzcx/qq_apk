package com.tencent.mm.loader.l;

import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String eQS = eQz + ".tmp";
  public static long eQT = 0L;
  public static final String eQx = h.getExternalStorageDirectory().getAbsolutePath();
  public static final String eQz = eQx + "/tencent/MicroMsg/";
  
  public static String Uq()
  {
    Object localObject = new StringBuilder().append(eQS).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ab.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(eQS);
    if (!localb.exists()) {
      localb.mkdirs();
    }
    localb = new com.tencent.mm.vfs.b((String)localObject);
    if (!localb.exists()) {
      localb.mkdirs();
    }
    return localObject;
  }
  
  public static boolean Ur()
  {
    long l = System.currentTimeMillis();
    if (l - eQT > 86400000L)
    {
      ab.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
      eQT = l;
      return true;
    }
    ab.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.l.b
 * JD-Core Version:    0.7.0.1
 */