package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.g.b.a.hw.a;
import com.tencent.mm.g.b.a.hw.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class e
{
  private static volatile e kng;
  public String knh;
  public int kni;
  public int knj;
  public int knk;
  public String knl;
  public int knm;
  boolean knn = false;
  public int kno;
  public int mScene = -1;
  
  public static e bhz()
  {
    AppMethodBeat.i(45294);
    if (kng == null) {}
    try
    {
      if (kng == null) {
        kng = new e();
      }
      e locale = kng;
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
    if ((!bt.isNullOrNil(this.knl)) && (!bt.isNullOrNil(this.knh)))
    {
      localObject = this.knl;
      String str = this.knh;
      int j = this.kni;
      int k = this.knj;
      int m = this.knk;
      int n = this.mScene;
      if (!this.knn) {
        break label284;
      }
      ad.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new hw();
      ((hw)localObject).qG(this.knl);
      ((hw)localObject).qH(this.knh);
      ((hw)localObject).eru = this.kni;
      ((hw)localObject).etG = hw.a.ja(this.knj);
      ((hw)localObject).etH = hw.b.jb(this.knk);
      ((hw)localObject).etI = this.knm;
      ((hw)localObject).etJ = paramInt1;
      ((hw)localObject).etK = paramInt2;
      if (!this.knn) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((hw)localObject).etL = l;
      ((hw)localObject).dVd = this.mScene;
      ((hw)localObject).etM = this.kno;
      ((hw)localObject).aLk();
      AppMethodBeat.o(45295);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.e
 * JD-Core Version:    0.7.0.1
 */