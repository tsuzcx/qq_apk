package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  implements SensorController.SensorEventCallBack
{
  public a JHO;
  long lastShakeTime;
  private boolean xCT;
  public ShakeManager xCU;
  public SensorController xCV;
  
  public d()
  {
    AppMethodBeat.i(25435);
    this.lastShakeTime = -1L;
    this.xCT = false;
    this.JHO = null;
    this.xCV = new SensorController(MMApplicationContext.getContext());
    this.xCU = new ShakeManager(MMApplicationContext.getContext());
    AppMethodBeat.o(25435);
  }
  
  public final void onSensorEvent(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25436);
    Log.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.xCT + " tick:" + Util.ticksToNow(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.xCT)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.xCT = paramBoolean;
        AppMethodBeat.o(25436);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.xCT = true;
      AppMethodBeat.o(25436);
      return;
    }
    this.xCT = false;
    Log.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25434);
        if (!paramBoolean)
        {
          Log.i("MicroMsg.IPCallSensorManager", "off screen");
          if (d.a(d.this) != null) {
            d.a(d.this).xK(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(25434);
          return false;
          Log.i("MicroMsg.IPCallSensorManager", "light screen");
          if (d.a(d.this) != null) {
            d.a(d.this).xK(false);
          }
        }
      }
    }, false).startTimer(50L);
    AppMethodBeat.o(25436);
  }
  
  public static abstract interface a
  {
    public abstract void xK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.d
 * JD-Core Version:    0.7.0.1
 */