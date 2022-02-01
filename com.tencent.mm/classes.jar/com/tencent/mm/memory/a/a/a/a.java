package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  private static a gEE;
  public static boolean gEF;
  public String drI;
  public int gEG;
  public int gEH;
  public int gEI;
  public double gEJ;
  public int gEK;
  public Class<?> targetClass;
  
  static
  {
    AppMethodBeat.i(156507);
    gEE = new a();
    gEF = false;
    AppMethodBeat.o(156507);
  }
  
  public a()
  {
    AppMethodBeat.i(156505);
    this.gEG = 10485760;
    this.gEH = 3;
    this.gEI = 2000;
    this.gEJ = 0.15D;
    this.gEK = 3;
    this.drI = "default";
    int i = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    ad.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.gEG = 62914560;
    }
    for (;;)
    {
      this.targetClass = com.tencent.mm.memory.a.a.a.class;
      this.gEH = 3;
      this.gEI = 2000;
      this.gEK = 3;
      this.gEJ = 0.15D;
      AppMethodBeat.o(156505);
      return;
      if (i >= 256) {
        this.gEG = 31457280;
      } else {
        this.gEG = 15728640;
      }
    }
  }
  
  public static a apq()
  {
    return gEE;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156506);
    if ((paramObject instanceof a))
    {
      bool = this.drI.equals(((a)paramObject).drI);
      AppMethodBeat.o(156506);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(156506);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */