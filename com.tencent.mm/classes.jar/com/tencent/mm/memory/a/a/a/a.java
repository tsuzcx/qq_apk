package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private static a ljr;
  public static boolean ljs;
  public String fND;
  public int ljt;
  public int lju;
  public int ljv;
  public double ljw;
  public int ljx;
  public Class<?> targetClass;
  
  static
  {
    AppMethodBeat.i(156507);
    ljr = new a();
    ljs = false;
    AppMethodBeat.o(156507);
  }
  
  public a()
  {
    AppMethodBeat.i(156505);
    this.ljt = 10485760;
    this.lju = 3;
    this.ljv = 2000;
    this.ljw = 0.15D;
    this.ljx = 3;
    this.fND = "default";
    int i = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    Log.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.ljt = 62914560;
    }
    for (;;)
    {
      this.targetClass = com.tencent.mm.memory.a.a.a.class;
      this.lju = 3;
      this.ljv = 2000;
      this.ljx = 3;
      this.ljw = 0.15D;
      AppMethodBeat.o(156505);
      return;
      if (i >= 256) {
        this.ljt = 31457280;
      } else {
        this.ljt = 15728640;
      }
    }
  }
  
  public static a bbm()
  {
    return ljr;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156506);
    if ((paramObject instanceof a))
    {
      bool = this.fND.equals(((a)paramObject).fND);
      AppMethodBeat.o(156506);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(156506);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */