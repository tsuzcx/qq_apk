package com.tencent.mm.loader.l;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String gNl = com.tencent.mm.loader.j.b.aph() + ".tmp";
  public static final String gNm = com.tencent.mm.loader.j.b.aph() + ".loader";
  public static long gNn = 0L;
  
  public static String aqj()
  {
    Object localObject = new StringBuilder().append(gNl).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ac.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    e locale = new e(gNl);
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