package com.tencent.mm.plugin.cast.i;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "getBatteryInfo", "", "init", "releaseBatteryCounter", "", "startBatteryCounter", "stopBatteryCounter", "Companion", "plugin-cast_release"})
public final class a
{
  public static final a.a tKT;
  private MMHandler handler;
  private long tKQ;
  private boolean tKR;
  private final BatteryManager tKS;
  
  static
  {
    AppMethodBeat.i(190849);
    tKT = new a.a((byte)0);
    AppMethodBeat.o(190849);
  }
  
  public a()
  {
    AppMethodBeat.i(190848);
    Object localObject = MMApplicationContext.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(190848);
      throw ((Throwable)localObject);
    }
    this.tKS = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(190848);
  }
  
  private int cMa()
  {
    AppMethodBeat.i(190844);
    this.tKR = false;
    if (this.tKQ > 0L)
    {
      Log.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.tKQ + ' ');
      com.tencent.mm.plugin.cast.g.a locala = com.tencent.mm.plugin.cast.g.a.tKa;
      com.tencent.mm.plugin.cast.g.a.Ip((int)this.tKQ);
    }
    int i = (int)this.tKQ;
    AppMethodBeat.o(190844);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(190835);
    this.tKQ = 0L;
    this.handler = new MMHandler("ScreenCast_batteryCounter");
    AppMethodBeat.o(190835);
  }
  
  public final void cLZ()
  {
    AppMethodBeat.i(190841);
    for (;;)
    {
      this.tKR = true;
      MMHandler localMMHandler = this.handler;
      if (((localMMHandler == null) || (localMMHandler.isQuit() != true)) && (this.tKR))
      {
        localMMHandler = this.handler;
        if (localMMHandler != null)
        {
          localMMHandler.postDelayed((Runnable)new b(this), 1000L);
          AppMethodBeat.o(190841);
          return;
        }
        AppMethodBeat.o(190841);
        return;
      }
      init();
    }
  }
  
  public final int cMb()
  {
    AppMethodBeat.i(190845);
    int i = cMa();
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.quitSafely();
    }
    AppMethodBeat.o(190845);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(189624);
      a.a(this.tKU);
      this.tKU.cLZ();
      AppMethodBeat.o(189624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.i.a
 * JD-Core Version:    0.7.0.1
 */