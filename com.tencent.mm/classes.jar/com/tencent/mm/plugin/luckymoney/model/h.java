package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public final class h
{
  private static String tcU;
  private static c<bk> tcV;
  
  static
  {
    AppMethodBeat.i(65175);
    tcU = null;
    tcV = new c() {};
    AppMethodBeat.o(65175);
  }
  
  public static void NX()
  {
    AppMethodBeat.i(65171);
    ad.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    a.ESL.d(tcV);
    AppMethodBeat.o(65171);
  }
  
  public static void cLr()
  {
    AppMethodBeat.i(65172);
    e locale = new e(b.aih() + "wallet/luckyMoneyEffect/");
    ad.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((locale.isDirectory()) && (locale.exists())) {
      ad.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(i.cO(q.B(locale.mUri), true)) });
    }
    AppMethodBeat.o(65172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.h
 * JD-Core Version:    0.7.0.1
 */