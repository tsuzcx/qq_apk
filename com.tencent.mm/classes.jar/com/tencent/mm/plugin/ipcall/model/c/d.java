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
  private boolean pyt;
  public bk pyu;
  public SensorController pyv;
  public a uMp;
  
  public d()
  {
    AppMethodBeat.i(25435);
    this.lastShakeTime = -1L;
    this.pyt = false;
    this.uMp = null;
    this.pyv = new SensorController(aj.getContext());
    this.pyu = new bk(aj.getContext());
    AppMethodBeat.o(25435);
  }
  
  public final void kn(final boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(25436);
    ad.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.pyt + " tick:" + bt.aO(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        AppMethodBeat.o(25436);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      AppMethodBeat.o(25436);
      return;
    }
    this.pyt = false;
    ad.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25434);
        if (!paramBoolean)
        {
          ad.i("MicroMsg.IPCallSensorManager", "off screen");
          if (d.this.uMp != null) {
            d.this.uMp.nK(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(25434);
          return false;
          ad.i("MicroMsg.IPCallSensorManager", "light screen");
          if (d.this.uMp != null) {
            d.this.uMp.nK(false);
          }
        }
      }
    }, false).az(50L, 50L);
    AppMethodBeat.o(25436);
  }
  
  public static abstract interface a
  {
    public abstract void nK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.d
 * JD-Core Version:    0.7.0.1
 */