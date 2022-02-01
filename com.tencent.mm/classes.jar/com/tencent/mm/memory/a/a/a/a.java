package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private static a nOc;
  public static boolean nOd;
  public String hTs;
  public Class<?> mzl;
  public int nOe;
  public int nOf;
  public int nOg;
  public double nOh;
  public int nOi;
  
  static
  {
    AppMethodBeat.i(156507);
    nOc = new a();
    nOd = false;
    AppMethodBeat.o(156507);
  }
  
  public a()
  {
    AppMethodBeat.i(156505);
    this.nOe = 10485760;
    this.nOf = 3;
    this.nOg = 2000;
    this.nOh = 0.15D;
    this.nOi = 3;
    this.hTs = "default";
    int i = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    Log.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.nOe = 62914560;
    }
    for (;;)
    {
      this.mzl = com.tencent.mm.memory.a.a.a.class;
      this.nOf = 3;
      this.nOg = 2000;
      this.nOi = 3;
      this.nOh = 0.15D;
      AppMethodBeat.o(156505);
      return;
      if (i >= 256) {
        this.nOe = 31457280;
      } else {
        this.nOe = 15728640;
      }
    }
  }
  
  public static a bwh()
  {
    return nOc;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156506);
    if ((paramObject instanceof a))
    {
      bool = this.hTs.equals(((a)paramObject).hTs);
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