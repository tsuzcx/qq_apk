package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

public final class h
{
  private static String vzU;
  private static c<bn> vzV;
  
  static
  {
    AppMethodBeat.i(65175);
    vzU = null;
    vzV = new c() {};
    AppMethodBeat.o(65175);
  }
  
  public static void dli()
  {
    AppMethodBeat.i(65172);
    k localk = new k(b.asj() + "wallet/luckyMoneyEffect/");
    ae.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((localk.isDirectory()) && (localk.exists())) {
      ae.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(o.dd(w.B(localk.mUri), true)) });
    }
    AppMethodBeat.o(65172);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(65171);
    ae.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    a.IvT.d(vzV);
    AppMethodBeat.o(65171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.h
 * JD-Core Version:    0.7.0.1
 */