package com.tencent.mm.loader.l;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String icT = com.tencent.mm.loader.j.b.aKJ() + ".tmp";
  public static final String icU = com.tencent.mm.loader.j.b.aKJ() + ".loader";
  public static long icV = 0L;
  
  public static String aLN()
  {
    Object localObject = new StringBuilder().append(icT).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    Log.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    o localo = new o(icT);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    localo = new o((String)localObject);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.l.b
 * JD-Core Version:    0.7.0.1
 */