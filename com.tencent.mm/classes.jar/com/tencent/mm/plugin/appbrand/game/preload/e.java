package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.or;
import com.tencent.mm.f.b.a.or.a;
import com.tencent.mm.f.b.a.or.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class e
{
  private static volatile e opd;
  public int mScene = -1;
  public String ope;
  public int opf;
  public int opg;
  public int oph;
  public String opi;
  public int opj;
  boolean opk = false;
  public int opl;
  
  public static e bOU()
  {
    AppMethodBeat.i(45294);
    if (opd == null) {}
    try
    {
      if (opd == null) {
        opd = new e();
      }
      e locale = opd;
      AppMethodBeat.o(45294);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(45294);
    }
  }
  
  public final void ew(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(45295);
    Object localObject;
    if ((!Util.isNullOrNil(this.opi)) && (!Util.isNullOrNil(this.ope)))
    {
      localObject = this.opi;
      String str = this.ope;
      int j = this.opf;
      int k = this.opg;
      int m = this.oph;
      int n = this.mScene;
      if (!this.opk) {
        break label284;
      }
      Log.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", new Object[] { localObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i) });
      localObject = new or();
      ((or)localObject).FK(this.opi);
      ((or)localObject).FL(this.ope);
      ((or)localObject).gYL = this.opf;
      ((or)localObject).hcz = or.a.op(this.opg);
      ((or)localObject).hcA = or.b.oq(this.oph);
      ((or)localObject).hcB = this.opj;
      ((or)localObject).hcC = paramInt1;
      ((or)localObject).hcD = paramInt2;
      if (!this.opk) {
        break label289;
      }
    }
    label284:
    label289:
    for (long l = 1L;; l = 0L)
    {
      ((or)localObject).hcE = l;
      ((or)localObject).gnP = this.mScene;
      ((or)localObject).hcF = this.opl;
      ((or)localObject).bpa();
      AppMethodBeat.o(45295);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.e
 * JD-Core Version:    0.7.0.1
 */