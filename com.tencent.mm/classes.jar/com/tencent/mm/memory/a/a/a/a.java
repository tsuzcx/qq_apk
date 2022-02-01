package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
{
  private static a hff;
  public static boolean hfg;
  public String dpt;
  public int hfh;
  public int hfi;
  public int hfj;
  public double hfk;
  public int hfl;
  public Class<?> targetClass;
  
  static
  {
    AppMethodBeat.i(156507);
    hff = new a();
    hfg = false;
    AppMethodBeat.o(156507);
  }
  
  public a()
  {
    AppMethodBeat.i(156505);
    this.hfh = 10485760;
    this.hfi = 3;
    this.hfj = 2000;
    this.hfk = 0.15D;
    this.hfl = 3;
    this.dpt = "default";
    int i = ((ActivityManager)ai.getContext().getSystemService("activity")).getLargeMemoryClass();
    ac.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.hfh = 62914560;
    }
    for (;;)
    {
      this.targetClass = com.tencent.mm.memory.a.a.a.class;
      this.hfi = 3;
      this.hfj = 2000;
      this.hfl = 3;
      this.hfk = 0.15D;
      AppMethodBeat.o(156505);
      return;
      if (i >= 256) {
        this.hfh = 31457280;
      } else {
        this.hfh = 15728640;
      }
    }
  }
  
  public static a awh()
  {
    return hff;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156506);
    if ((paramObject instanceof a))
    {
      bool = this.dpt.equals(((a)paramObject).dpt);
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