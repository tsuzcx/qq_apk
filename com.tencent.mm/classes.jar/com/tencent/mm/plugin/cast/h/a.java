package com.tencent.mm.plugin.cast.h;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "getBatteryInfo", "", "init", "releaseBatteryCounter", "", "startBatteryCounter", "stopBatteryCounter", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a wOg;
  public MMHandler handler;
  public long wOh;
  public boolean wOi;
  private final BatteryManager wOj;
  
  static
  {
    AppMethodBeat.i(274225);
    wOg = new a.a((byte)0);
    AppMethodBeat.o(274225);
  }
  
  public a()
  {
    AppMethodBeat.i(274195);
    Object localObject = MMApplicationContext.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(274195);
      throw ((Throwable)localObject);
    }
    this.wOj = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(274195);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(274217);
    s.u(parama, "this$0");
    long l = parama.wOj.getLongProperty(5);
    int i = parama.wOj.getIntProperty(1);
    int j = parama.wOj.getIntProperty(2);
    int k = parama.wOj.getIntProperty(3);
    int m = parama.wOj.getIntProperty(4);
    Log.i("MicroMsg.BatteryUtils", "mBatteryEnergyCounter=" + l + " nanoWattHours ");
    Log.i("MicroMsg.BatteryUtils", "mBatteryChargeCounter=" + i + "  microAmpereHours");
    Log.i("MicroMsg.BatteryUtils", "mBatteryCurrentNow=" + j + "   microAmpere");
    Log.i("MicroMsg.BatteryUtils", "mBatteryCurrentAverage=" + k + "  microAmpere");
    Log.i("MicroMsg.BatteryUtils", "mBatteryCapacity=" + m + "  ");
    Log.i("MicroMsg.BatteryUtils", "mBatteryEnergyCounter=" + l + " nanoWattHours ");
    if (parama.wOh != 0L) {}
    for (l = (parama.wOh + k) / 2L;; l = k)
    {
      parama.wOh = l;
      parama.dpF();
      AppMethodBeat.o(274217);
      return;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(274203);
    this.wOh = 0L;
    this.handler = new MMHandler("ScreenCast_batteryCounter");
    AppMethodBeat.o(274203);
  }
  
  public final void dpF()
  {
    AppMethodBeat.i(274239);
    for (;;)
    {
      this.wOi = true;
      MMHandler localMMHandler = this.handler;
      if ((localMMHandler != null) && (localMMHandler.isQuit() == true)) {}
      for (int i = 1; (i == 0) && (this.wOi); i = 0)
      {
        localMMHandler = this.handler;
        if (localMMHandler == null) {
          break label83;
        }
        localMMHandler.postDelayed(new a..ExternalSyntheticLambda0(this), 1000L);
        AppMethodBeat.o(274239);
        return;
      }
      init();
    }
    label83:
    AppMethodBeat.o(274239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.a
 * JD-Core Version:    0.7.0.1
 */