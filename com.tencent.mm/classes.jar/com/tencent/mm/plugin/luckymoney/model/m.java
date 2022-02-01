package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class m
{
  private static String EyJ;
  private static IListener<bu> EyK;
  
  static
  {
    AppMethodBeat.i(65175);
    EyJ = null;
    EyK = new IListener() {};
    AppMethodBeat.o(65175);
  }
  
  public static void eOx()
  {
    AppMethodBeat.i(65172);
    q localq = new q(b.aSL() + "wallet/luckyMoneyEffect/");
    Log.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
    if ((localq.isDirectory()) && (localq.ifE())) {
      Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", new Object[] { Boolean.valueOf(u.dK(localq.getPath(), true)) });
    }
    AppMethodBeat.o(65172);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(65171);
    Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
    EventCenter.instance.removeListener(EyK);
    AppMethodBeat.o(65171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */