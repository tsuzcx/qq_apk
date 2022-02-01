package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
  implements SensorController.a
{
  long lastShakeTime;
  private boolean pEX;
  public bl pEY;
  public SensorController pEZ;
  public a uYc;
  
  public d()
  {
    AppMethodBeat.i(25435);
    this.lastShakeTime = -1L;
    this.pEX = false;
    this.uYc = null;
    this.pEZ = new SensorController(ak.getContext());
    this.pEY = new bl(ak.getContext());
    AppMethodBeat.o(25435);
  }
  
  public final void km(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25436);
    ae.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.pEX + " tick:" + bu.aO(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.pEX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pEX = paramBoolean;
        AppMethodBeat.o(25436);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bu.aO(this.lastShakeTime) > 400L))
    {
      this.pEX = true;
      AppMethodBeat.o(25436);
      return;
    }
    this.pEX = false;
    ae.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25434);
        if (!paramBoolean)
        {
          ae.i("MicroMsg.IPCallSensorManager", "off screen");
          if (d.this.uYc != null) {
            d.this.uYc.nO(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(25434);
          return false;
          ae.i("MicroMsg.IPCallSensorManager", "light screen");
          if (d.this.uYc != null) {
            d.this.uYc.nO(false);
          }
        }
      }
    }, false).ay(50L, 50L);
    AppMethodBeat.o(25436);
  }
  
  public static abstract interface a
  {
    public abstract void nO(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.d
 * JD-Core Version:    0.7.0.1
 */