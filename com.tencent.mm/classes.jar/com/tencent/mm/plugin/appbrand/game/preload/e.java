package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sk;
import com.tencent.mm.autogen.mmdata.rpt.sk.a;
import com.tencent.mm.autogen.mmdata.rpt.sk.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class e
{
  private static volatile e rsL;
  public int mScene = -1;
  public String rsM;
  public int rsN;
  public int rsO;
  public int rsP;
  public String rsQ;
  public int rsR;
  boolean rsS = false;
  public int rsT;
  
  public static e cpi()
  {
    AppMethodBeat.i(45294);
    if (rsL == null) {}
    try
    {
      if (rsL == null) {
        rsL = new e();
      }
      e locale = rsL;
      AppMethodBeat.o(45294);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(45294);
    }
  }
  
  public final void fp(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(45295);
    Object localObject;
    if ((!Util.isNullOrNil(this.rsQ)) && (!Util.isNullOrNil(this.rsM)))
    {
      localObject = this.rsQ;
      String str = this.rsM;
      int j = this.rsN;
      int k = this.rsO;
      int m = this.rsP;
      int n = this.mScene;
      if (!this.rsS) {
        break label284;
      }
      Log.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new sk();
      ((sk)localObject).zb(this.rsQ);
      ((sk)localObject).zc(this.rsM);
      ((sk)localObject).ind = this.rsN;
      ((sk)localObject).jyn = sk.a.oF(this.rsO);
      ((sk)localObject).jyo = sk.b.oG(this.rsP);
      ((sk)localObject).jyp = this.rsR;
      ((sk)localObject).jyq = paramInt1;
      ((sk)localObject).jyr = paramInt2;
      if (!this.rsS) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((sk)localObject).jys = l;
      ((sk)localObject).iqr = this.mScene;
      ((sk)localObject).jyt = this.rsT;
      ((sk)localObject).bMH();
      AppMethodBeat.o(45295);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.e
 * JD-Core Version:    0.7.0.1
 */