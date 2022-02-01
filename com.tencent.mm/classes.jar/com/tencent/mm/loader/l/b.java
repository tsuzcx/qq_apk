package com.tencent.mm.loader.l;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String hhi = com.tencent.mm.loader.j.b.arU() + ".tmp";
  public static final String hhj = com.tencent.mm.loader.j.b.arU() + ".loader";
  public static long hhk = 0L;
  
  public static String asY()
  {
    Object localObject = new StringBuilder().append(hhi).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ad.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    e locale = new e(hhi);
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