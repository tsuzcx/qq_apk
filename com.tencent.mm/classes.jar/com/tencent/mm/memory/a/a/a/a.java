package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  private static a fet;
  public static boolean feu;
  public String feA;
  public int fev;
  public int few;
  public int fex;
  public double fey;
  public int fez;
  public Class<?> targetClass;
  
  static
  {
    AppMethodBeat.i(115461);
    fet = new a();
    feu = false;
    AppMethodBeat.o(115461);
  }
  
  public a()
  {
    AppMethodBeat.i(115459);
    this.fev = 10485760;
    this.few = 3;
    this.fex = 2000;
    this.fey = 0.15D;
    this.fez = 3;
    this.feA = "default";
    int i = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    ab.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i >= 512) {
      this.fev = 62914560;
    }
    for (;;)
    {
      this.targetClass = com.tencent.mm.memory.a.a.a.class;
      this.few = 3;
      this.fex = 2000;
      this.fez = 3;
      this.fey = 0.15D;
      AppMethodBeat.o(115459);
      return;
      if (i >= 256) {
        this.fev = 31457280;
      } else {
        this.fev = 15728640;
      }
    }
  }
  
  public static a Yh()
  {
    return fet;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(115460);
    if ((paramObject instanceof a))
    {
      bool = this.feA.equals(((a)paramObject).feA);
      AppMethodBeat.o(115460);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(115460);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */