package com.tencent.mm.loader.k;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static final String ntb = com.tencent.mm.loader.i.b.bmz() + ".tmp";
  public static final String ntc = ah.v(af.eC(".loader", false).mUri);
  public static long ntd = 0L;
  
  public static String bnI()
  {
    Object localObject = new StringBuilder().append(ntb).append("/");
    long l = System.currentTimeMillis();
    localObject = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
    Log.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[] { localObject });
    u localu = new u(ntb);
    if (!localu.jKS()) {
      localu.jKY();
    }
    localu = new u((String)localObject);
    if (!localu.jKS()) {
      localu.jKY();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */