package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  private static a hxn;
  public static boolean hxo;
  public String dBg;
  public int hxp;
  public int hxq;
  public int hxr;
  public double hxs;
  public int hxt;
  public Class<?> targetClass;
  
  static
  {
    AppMethodBeat.i(156507);
    hxn = new a();
    hxo = false;
    AppMethodBeat.o(156507);
  }
  
  public a()
  {
    AppMethodBeat.i(156505);
    this.hxp = 10485760;
    this.hxq = 3;
    this.hxr = 2000;
    this.hxs = 0.15D;
    this.hxt = 3;
    this.dBg = "default";
    int i = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    ad.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.hxp = 62914560;
    }
    for (;;)
    {
      this.targetClass = com.tencent.mm.memory.a.a.a.class;
      this.hxq = 3;
      this.hxr = 2000;
      this.hxt = 3;
      this.hxs = 0.15D;
      AppMethodBeat.o(156505);
      return;
      if (i >= 256) {
        this.hxp = 31457280;
      } else {
        this.hxp = 15728640;
      }
    }
  }
  
  public static a ayU()
  {
    return hxn;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156506);
    if ((paramObject instanceof a))
    {
      bool = this.dBg.equals(((a)paramObject).dBg);
      AppMethodBeat.o(156506);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(156506);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */