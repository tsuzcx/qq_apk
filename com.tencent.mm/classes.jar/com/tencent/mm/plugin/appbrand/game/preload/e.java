package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.g.b.a.fb.a;
import com.tencent.mm.g.b.a.fb.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class e
{
  private static volatile e jsy;
  public int jsA;
  public int jsB;
  public int jsC;
  public String jsD;
  public int jsE;
  boolean jsF = false;
  public int jsG;
  public String jsz;
  public int mScene = -1;
  
  public static e aWX()
  {
    AppMethodBeat.i(45294);
    if (jsy == null) {}
    try
    {
      if (jsy == null) {
        jsy = new e();
      }
      e locale = jsy;
      AppMethodBeat.o(45294);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(45294);
    }
  }
  
  public final void dK(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(45295);
    Object localObject;
    if ((!bt.isNullOrNil(this.jsD)) && (!bt.isNullOrNil(this.jsz)))
    {
      localObject = this.jsD;
      String str = this.jsz;
      int j = this.jsA;
      int k = this.jsB;
      int m = this.jsC;
      int n = this.mScene;
      if (!this.jsF) {
        break label284;
      }
      ad.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new fb();
      ((fb)localObject).lc(this.jsD);
      ((fb)localObject).ld(this.jsz);
      ((fb)localObject).dYT = this.jsA;
      ((fb)localObject).eaV = fb.a.iJ(this.jsB);
      ((fb)localObject).eaW = fb.b.iK(this.jsC);
      ((fb)localObject).eaX = this.jsE;
      ((fb)localObject).eaY = paramInt1;
      ((fb)localObject).eaZ = paramInt2;
      if (!this.jsF) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((fb)localObject).eba = l;
      ((fb)localObject).dKe = this.mScene;
      ((fb)localObject).ebb = this.jsG;
      ((fb)localObject).aBj();
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