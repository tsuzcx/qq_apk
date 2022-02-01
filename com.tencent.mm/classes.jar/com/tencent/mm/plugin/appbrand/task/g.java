package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public enum g
{
  public final int code;
  public final int nPG;
  public final Class<? extends s> nPH;
  public final Class<? extends ac> nPI;
  
  static
  {
    AppMethodBeat.i(48433);
    nPD = new g("WASERVICE", 0, 1, 2147483647, com.tencent.mm.plugin.appbrand.service.c.class, ag.class);
    nPE = new g("WAGAME", 1, 2, 2, com.tencent.mm.plugin.appbrand.game.c.class, d.class);
    nPF = new g("NIL", 2, 0, 0, null, null);
    nPJ = new g[] { nPD, nPE, nPF };
    AppMethodBeat.o(48433);
  }
  
  private g(int paramInt1, int paramInt2, Class<? extends s> paramClass, Class<? extends ac> paramClass1)
  {
    AppMethodBeat.i(227483);
    this.code = paramInt1;
    if (this.code == 2) {}
    for (this.nPG = bVW();; this.nPG = paramInt2)
    {
      this.nPH = paramClass;
      this.nPI = paramClass1;
      AppMethodBeat.o(227483);
      return;
    }
  }
  
  public static g L(Intent paramIntent)
  {
    AppMethodBeat.i(48431);
    int j = paramIntent.getIntExtra("AppBrandServiceType", nPF.code);
    paramIntent = values();
    int k = paramIntent.length;
    int i = 0;
    while (i < k)
    {
      g localg = paramIntent[i];
      if (localg.code == j)
      {
        AppMethodBeat.o(48431);
        return localg;
      }
      i += 1;
    }
    paramIntent = new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
    AppMethodBeat.o(48431);
    throw paramIntent;
  }
  
  public static int bVW()
  {
    AppMethodBeat.i(227486);
    int i = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rRm, 2);
    Log.i("AppBrandServiceType", "getGameTaskExptNum exp:%d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(227486);
      return 2;
    }
    AppMethodBeat.o(227486);
    return i;
  }
  
  public static g iD(boolean paramBoolean)
  {
    if (paramBoolean) {
      return nPE;
    }
    return nPD;
  }
  
  public static g j(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(48432);
    if (paramAppBrandInitConfigWC.NA())
    {
      paramAppBrandInitConfigWC = nPE;
      AppMethodBeat.o(48432);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = nPD;
    AppMethodBeat.o(48432);
    return paramAppBrandInitConfigWC;
  }
  
  public static g zm(int paramInt)
  {
    AppMethodBeat.i(227485);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      g localg = localObject[i];
      if (localg.code == paramInt)
      {
        AppMethodBeat.o(227485);
        return localg;
      }
      i += 1;
    }
    localObject = new IllegalStateException("AppBrandServiceType DeserializeFrom[Int] Unreached Code");
    AppMethodBeat.o(227485);
    throw ((Throwable)localObject);
  }
  
  public final Intent K(Intent paramIntent)
  {
    AppMethodBeat.i(227484);
    paramIntent.putExtra("AppBrandServiceType", this.code);
    AppMethodBeat.o(227484);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.g
 * JD-Core Version:    0.7.0.1
 */