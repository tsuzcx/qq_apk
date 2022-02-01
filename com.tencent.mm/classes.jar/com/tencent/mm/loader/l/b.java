package com.tencent.mm.loader.l;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String hjW = com.tencent.mm.loader.j.b.asj() + ".tmp";
  public static final String hjX = com.tencent.mm.loader.j.b.asj() + ".loader";
  public static long hjY = 0L;
  
  public static String atn()
  {
    Object localObject = new StringBuilder().append(hjW).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    ae.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    k localk = new k(hjW);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    localk = new k((String)localObject);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.l.b
 * JD-Core Version:    0.7.0.1
 */