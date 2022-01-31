package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class g
{
  private static String ond;
  private static c<bg> one;
  
  static
  {
    AppMethodBeat.i(42285);
    ond = null;
    one = new c() {};
    AppMethodBeat.o(42285);
  }
  
  public static void aoR()
  {
    AppMethodBeat.i(42281);
    ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    a.ymk.d(one);
    AppMethodBeat.o(42281);
  }
  
  public static void bNi()
  {
    AppMethodBeat.i(42282);
    File localFile = new File(b.eQz + "wallet/luckyMoneyEffect/");
    ab.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((localFile.isDirectory()) && (localFile.exists())) {
      ab.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(e.O(localFile.getPath(), true)) });
    }
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.g
 * JD-Core Version:    0.7.0.1
 */