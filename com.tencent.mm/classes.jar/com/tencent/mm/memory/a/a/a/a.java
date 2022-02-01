package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private static a iui;
  public static boolean iuj;
  public String dUb;
  public int iuk;
  public int iul;
  public int ium;
  public double iun;
  public int iuo;
  public Class<?> targetClass;
  
  static
  {
    AppMethodBeat.i(156507);
    iui = new a();
    iuj = false;
    AppMethodBeat.o(156507);
  }
  
  public a()
  {
    AppMethodBeat.i(156505);
    this.iuk = 10485760;
    this.iul = 3;
    this.ium = 2000;
    this.iun = 0.15D;
    this.iuo = 3;
    this.dUb = "default";
    int i = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    Log.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.iuk = 62914560;
    }
    for (;;)
    {
      this.targetClass = com.tencent.mm.memory.a.a.a.class;
      this.iul = 3;
      this.ium = 2000;
      this.iuo = 3;
      this.iun = 0.15D;
      AppMethodBeat.o(156505);
      return;
      if (i >= 256) {
        this.iuk = 31457280;
      } else {
        this.iuk = 15728640;
      }
    }
  }
  
  public static a aSp()
  {
    return iui;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156506);
    if ((paramObject instanceof a))
    {
      bool = this.dUb.equals(((a)paramObject).dUb);
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