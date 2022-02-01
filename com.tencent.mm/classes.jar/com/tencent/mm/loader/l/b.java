package com.tencent.mm.loader.l;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String kRA = com.tencent.mm.loader.j.b.aSL() + ".tmp";
  public static final String kRB = com.tencent.mm.loader.j.b.aSL() + ".loader";
  public static long kRC = 0L;
  
  public static String aTT()
  {
    Object localObject = new StringBuilder().append(kRA).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    Log.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    q localq = new q(kRA);
    if (!localq.ifE()) {
      localq.ifL();
    }
    localq = new q((String)localObject);
    if (!localq.ifE()) {
      localq.ifL();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.l.b
 * JD-Core Version:    0.7.0.1
 */