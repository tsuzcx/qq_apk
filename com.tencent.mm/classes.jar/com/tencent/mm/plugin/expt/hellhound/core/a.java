package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(14)
public class a
{
  private static volatile a lZB;
  public c lZC;
  public e lZD;
  
  private a()
  {
    AppMethodBeat.i(73343);
    this.lZD = null;
    if (!brs())
    {
      AppMethodBeat.o(73343);
      return;
    }
    this.lZC = new com.tencent.mm.plugin.expt.hellhound.core.v2.activity.b();
    this.lZD = new com.tencent.mm.plugin.expt.hellhound.core.v2.a.e();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.brw();
    d.brC();
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.brY();
    ab.i("ActivityBundleDao", "habbyge-mali, ActivityBundleDao reset");
    if (b.brt()) {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.v("hell_ac_ble_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(73343);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(73344);
    d.brC().lZQ.lZR.lZU = paramf;
    AppMethodBeat.o(73344);
  }
  
  public static a brr()
  {
    AppMethodBeat.i(73342);
    if (lZB == null) {}
    try
    {
      if (lZB == null) {
        lZB = new a();
      }
      a locala = lZB;
      AppMethodBeat.o(73342);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(73342);
    }
  }
  
  public static boolean brs()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */