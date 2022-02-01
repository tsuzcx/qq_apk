package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public final class h
{
  private static String ulj;
  private static c<bk> ulk;
  
  static
  {
    AppMethodBeat.i(65175);
    ulj = null;
    ulk = new c() {};
    AppMethodBeat.o(65175);
  }
  
  public static void cYX()
  {
    AppMethodBeat.i(65172);
    e locale = new e(b.aph() + "wallet/luckyMoneyEffect/");
    ac.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((locale.isDirectory()) && (locale.exists())) {
      ac.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(i.cU(q.B(locale.mUri), true)) });
    }
    AppMethodBeat.o(65172);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(65171);
    ac.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    a.GpY.d(ulk);
    AppMethodBeat.o(65171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.h
 * JD-Core Version:    0.7.0.1
 */