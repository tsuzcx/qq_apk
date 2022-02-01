package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lt;
import com.tencent.mm.g.b.a.lt.a;
import com.tencent.mm.g.b.a.lt.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class e
{
  private static volatile e lue;
  public String luf;
  public int lug;
  public int luh;
  public int lui;
  public String luj;
  public int luk;
  boolean lul = false;
  public int lum;
  public int mScene = -1;
  
  public static e bDw()
  {
    AppMethodBeat.i(45294);
    if (lue == null) {}
    try
    {
      if (lue == null) {
        lue = new e();
      }
      e locale = lue;
      AppMethodBeat.o(45294);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(45294);
    }
  }
  
  public final void dX(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(45295);
    Object localObject;
    if ((!Util.isNullOrNil(this.luj)) && (!Util.isNullOrNil(this.luf)))
    {
      localObject = this.luj;
      String str = this.luf;
      int j = this.lug;
      int k = this.luh;
      int m = this.lui;
      int n = this.mScene;
      if (!this.lul) {
        break label284;
      }
      Log.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new lt();
      ((lt)localObject).ze(this.luj);
      ((lt)localObject).zf(this.luf);
      ((lt)localObject).eXc = this.lug;
      ((lt)localObject).eZI = lt.a.me(this.luh);
      ((lt)localObject).eZJ = lt.b.mf(this.lui);
      ((lt)localObject).eZK = this.luk;
      ((lt)localObject).eZL = paramInt1;
      ((lt)localObject).eZM = paramInt2;
      if (!this.lul) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((lt)localObject).eZN = l;
      ((lt)localObject).erW = this.mScene;
      ((lt)localObject).eZO = this.lum;
      ((lt)localObject).bfK();
      AppMethodBeat.o(45295);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.e
 * JD-Core Version:    0.7.0.1
 */