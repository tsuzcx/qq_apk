package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  implements SensorController.a
{
  long lastShakeTime;
  private boolean orj;
  public bk ork;
  public SensorController orl;
  public a sBU;
  
  public d()
  {
    AppMethodBeat.i(25435);
    this.lastShakeTime = -1L;
    this.orj = false;
    this.sBU = null;
    this.orl = new SensorController(aj.getContext());
    this.ork = new bk(aj.getContext());
    AppMethodBeat.o(25435);
  }
  
  public final void jz(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25436);
    ad.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.orj + " tick:" + bt.aS(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        AppMethodBeat.o(25436);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      AppMethodBeat.o(25436);
      return;
    }
    this.orj = false;
    ad.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25434);
        if (!paramBoolean)
        {
          ad.i("MicroMsg.IPCallSensorManager", "off screen");
          if (d.this.sBU != null) {
            d.this.sBU.mx(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(25434);
          return false;
          ad.i("MicroMsg.IPCallSensorManager", "light screen");
          if (d.this.sBU != null) {
            d.this.sBU.mx(false);
          }
        }
      }
    }, false).av(50L, 50L);
    AppMethodBeat.o(25436);
  }
  
  public static abstract interface a
  {
    public abstract void mx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.d
 * JD-Core Version:    0.7.0.1
 */