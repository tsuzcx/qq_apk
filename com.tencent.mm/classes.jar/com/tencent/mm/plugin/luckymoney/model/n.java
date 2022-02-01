package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class n
{
  private static String Krw;
  private static IListener<cd> Krx;
  
  static
  {
    AppMethodBeat.i(65175);
    Krw = null;
    Krx = new LuckMoneyEffectResourceMgr.1(f.hfK);
    AppMethodBeat.o(65175);
  }
  
  public static void fWU()
  {
    AppMethodBeat.i(65172);
    u localu = new u(b.bmz() + "wallet/luckyMoneyEffect/");
    Log.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((localu.isDirectory()) && (localu.jKS())) {
      Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(y.ew(ah.v(localu.mUri), true)) });
    }
    AppMethodBeat.o(65172);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(65171);
    Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    Krx.dead();
    AppMethodBeat.o(65171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.n
 * JD-Core Version:    0.7.0.1
 */