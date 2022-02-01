package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hy;
import com.tencent.mm.g.b.a.hy.a;
import com.tencent.mm.g.b.a.hy.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class e
{
  private static volatile e kqw;
  public int kqA;
  public String kqB;
  public int kqC;
  boolean kqD = false;
  public int kqE;
  public String kqx;
  public int kqy;
  public int kqz;
  public int mScene = -1;
  
  public static e bih()
  {
    AppMethodBeat.i(45294);
    if (kqw == null) {}
    try
    {
      if (kqw == null) {
        kqw = new e();
      }
      e locale = kqw;
      AppMethodBeat.o(45294);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(45294);
    }
  }
  
  public final void dM(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(45295);
    Object localObject;
    if ((!bu.isNullOrNil(this.kqB)) && (!bu.isNullOrNil(this.kqx)))
    {
      localObject = this.kqB;
      String str = this.kqx;
      int j = this.kqy;
      int k = this.kqz;
      int m = this.kqA;
      int n = this.mScene;
      if (!this.kqD) {
        break label284;
      }
      ae.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new hy();
      ((hy)localObject).rb(this.kqB);
      ((hy)localObject).rc(this.kqx);
      ((hy)localObject).etb = this.kqy;
      ((hy)localObject).evn = hy.a.jc(this.kqz);
      ((hy)localObject).evo = hy.b.jd(this.kqA);
      ((hy)localObject).evp = this.kqC;
      ((hy)localObject).evq = paramInt1;
      ((hy)localObject).evr = paramInt2;
      if (!this.kqD) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((hy)localObject).evs = l;
      ((hy)localObject).dWt = this.mScene;
      ((hy)localObject).evt = this.kqE;
      ((hy)localObject).aLH();
      AppMethodBeat.o(45295);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.e
 * JD-Core Version:    0.7.0.1
 */