package com.tencent.mm.loader.l;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static long gmA = 0L;
  public static final String gmy = com.tencent.mm.loader.j.b.aih() + ".tmp";
  public static final String gmz = com.tencent.mm.loader.j.b.aih() + ".loader";
  
  public static String ajj()
  {
    Object localObject = new StringBuilder().append(gmy).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ad.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    e locale = new e(gmy);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new e((String)localObject);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.l.b
 * JD-Core Version:    0.7.0.1
 */