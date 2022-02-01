package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class m
{
  private static String yUM;
  private static IListener<bp> yUN;
  
  static
  {
    AppMethodBeat.i(65175);
    yUM = null;
    yUN = new IListener() {};
    AppMethodBeat.o(65175);
  }
  
  public static void efc()
  {
    AppMethodBeat.i(65172);
    o localo = new o(b.aKJ() + "wallet/luckyMoneyEffect/");
    Log.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((localo.isDirectory()) && (localo.exists())) {
      Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(s.dy(aa.z(localo.mUri), true)) });
    }
    AppMethodBeat.o(65172);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(65171);
    Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    EventCenter.instance.removeListener(yUN);
    AppMethodBeat.o(65171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */