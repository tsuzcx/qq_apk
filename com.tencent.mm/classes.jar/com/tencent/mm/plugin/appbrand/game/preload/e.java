package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.g.b.a.cb.a;
import com.tencent.mm.g.b.a.cb.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class e
{
  private static volatile e huk;
  public String hul;
  public int hum;
  public int hun;
  public int huo;
  public String hup;
  public int huq;
  boolean hur = false;
  public int hus;
  public int mScene = -1;
  
  public static e aAT()
  {
    AppMethodBeat.i(130307);
    if (huk == null) {}
    try
    {
      if (huk == null) {
        huk = new e();
      }
      e locale = huk;
      AppMethodBeat.o(130307);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130307);
    }
  }
  
  public final void de(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(130308);
    Object localObject;
    if ((!bo.isNullOrNil(this.hup)) && (!bo.isNullOrNil(this.hul)))
    {
      localObject = this.hup;
      String str = this.hul;
      int j = this.hum;
      int k = this.hun;
      int m = this.huo;
      int n = this.mScene;
      if (!this.hur) {
        break label284;
      }
      ab.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new cb();
      ((cb)localObject).ha(this.hup);
      ((cb)localObject).hb(this.hul);
      ((cb)localObject).cZB = this.hum;
      ((cb)localObject).cZY = cb.a.gN(this.hun);
      ((cb)localObject).cZZ = cb.b.gO(this.huo);
      ((cb)localObject).daa = this.huq;
      ((cb)localObject).dab = paramInt1;
      ((cb)localObject).dac = paramInt2;
      if (!this.hur) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((cb)localObject).dad = l;
      ((cb)localObject).cRG = this.mScene;
      ((cb)localObject).dae = this.hus;
      ((cb)localObject).ake();
      AppMethodBeat.o(130308);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.e
 * JD-Core Version:    0.7.0.1
 */