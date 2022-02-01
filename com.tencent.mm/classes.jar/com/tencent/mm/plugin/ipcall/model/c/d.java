package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  implements SensorController.a
{
  long lastShakeTime;
  private boolean oUJ;
  public bj oUK;
  public SensorController oUL;
  public a tJC;
  
  public d()
  {
    AppMethodBeat.i(25435);
    this.lastShakeTime = -1L;
    this.oUJ = false;
    this.tJC = null;
    this.oUL = new SensorController(ai.getContext());
    this.oUK = new bj(ai.getContext());
    AppMethodBeat.o(25435);
  }
  
  public final void kc(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25436);
    ac.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.oUJ + " tick:" + bs.aO(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        AppMethodBeat.o(25436);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      AppMethodBeat.o(25436);
      return;
    }
    this.oUJ = false;
    ac.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25434);
        if (!paramBoolean)
        {
          ac.i("MicroMsg.IPCallSensorManager", "off screen");
          if (d.this.tJC != null) {
            d.this.tJC.nq(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(25434);
          return false;
          ac.i("MicroMsg.IPCallSensorManager", "light screen");
          if (d.this.tJC != null) {
            d.this.tJC.nq(false);
          }
        }
      }
    }, false).au(50L, 50L);
    AppMethodBeat.o(25436);
  }
  
  public static abstract interface a
  {
    public abstract void nq(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.d
 * JD-Core Version:    0.7.0.1
 */