package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.h.a.be;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class b
{
  private static String lPG = null;
  private static c<be> lPH = new b.1();
  
  public static void Vt()
  {
    y.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    a.udP.d(lPH);
  }
  
  public static void bfF()
  {
    File localFile = new File(com.tencent.mm.loader.a.b.bkH + "wallet/luckyMoneyEffect/");
    y.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((localFile.isDirectory()) && (localFile.exists())) {
      y.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(e.K(localFile.getPath(), true)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.b
 * JD-Core Version:    0.7.0.1
 */