package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public final class h
{
  private static String vnP;
  private static c<bn> vnQ;
  
  static
  {
    AppMethodBeat.i(65175);
    vnP = null;
    vnQ = new c() {};
    AppMethodBeat.o(65175);
  }
  
  public static void dij()
  {
    AppMethodBeat.i(65172);
    e locale = new e(b.arU() + "wallet/luckyMoneyEffect/");
    ad.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((locale.isDirectory()) && (locale.exists())) {
      ad.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(i.cZ(q.B(locale.mUri), true)) });
    }
    AppMethodBeat.o(65172);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(65171);
    ad.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    a.IbL.d(vnQ);
    AppMethodBeat.o(65171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.h
 * JD-Core Version:    0.7.0.1
 */