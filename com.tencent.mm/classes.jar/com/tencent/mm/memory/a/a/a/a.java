package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  private static a hAb;
  public static boolean hAc;
  public String dCl;
  public int hAd;
  public int hAe;
  public int hAf;
  public double hAg;
  public int hAh;
  public Class<?> targetClass;
  
  static
  {
    AppMethodBeat.i(156507);
    hAb = new a();
    hAc = false;
    AppMethodBeat.o(156507);
  }
  
  public a()
  {
    AppMethodBeat.i(156505);
    this.hAd = 10485760;
    this.hAe = 3;
    this.hAf = 2000;
    this.hAg = 0.15D;
    this.hAh = 3;
    this.dCl = "default";
    int i = ((ActivityManager)ak.getContext().getSystemService("activity")).getLargeMemoryClass();
    ae.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.hAd = 62914560;
    }
    for (;;)
    {
      this.targetClass = com.tencent.mm.memory.a.a.a.class;
      this.hAe = 3;
      this.hAf = 2000;
      this.hAh = 3;
      this.hAg = 0.15D;
      AppMethodBeat.o(156505);
      return;
      if (i >= 256) {
        this.hAd = 31457280;
      } else {
        this.hAd = 15728640;
      }
    }
  }
  
  public static a azj()
  {
    return hAb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156506);
    if ((paramObject instanceof a))
    {
      bool = this.dCl.equals(((a)paramObject).dCl);
      AppMethodBeat.o(156506);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(156506);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */