package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gt;
import com.tencent.mm.g.b.a.gt.a;
import com.tencent.mm.g.b.a.gt.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class e
{
  private static volatile e jSS;
  public String jST;
  public int jSU;
  public int jSV;
  public int jSW;
  public String jSX;
  public int jSY;
  boolean jSZ = false;
  public int jTa;
  public int mScene = -1;
  
  public static e bdV()
  {
    AppMethodBeat.i(45294);
    if (jSS == null) {}
    try
    {
      if (jSS == null) {
        jSS = new e();
      }
      e locale = jSS;
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
    if ((!bs.isNullOrNil(this.jSX)) && (!bs.isNullOrNil(this.jST)))
    {
      localObject = this.jSX;
      String str = this.jST;
      int j = this.jSU;
      int k = this.jSV;
      int m = this.jSW;
      int n = this.mScene;
      if (!this.jSZ) {
        break label284;
      }
      ac.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new gt();
      ((gt)localObject).oh(this.jSX);
      ((gt)localObject).oi(this.jST);
      ((gt)localObject).eaM = this.jSU;
      ((gt)localObject).edb = gt.a.iH(this.jSV);
      ((gt)localObject).edc = gt.b.iI(this.jSW);
      ((gt)localObject).edd = this.jSY;
      ((gt)localObject).ede = paramInt1;
      ((gt)localObject).edf = paramInt2;
      if (!this.jSZ) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((gt)localObject).edg = l;
      ((gt)localObject).dHY = this.mScene;
      ((gt)localObject).edh = this.jTa;
      ((gt)localObject).aHZ();
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