package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  implements SensorController.a
{
  long lastShakeTime;
  private boolean mtX;
  public bf mtY;
  public SensorController mub;
  public a nNZ;
  
  public d()
  {
    AppMethodBeat.i(21820);
    this.lastShakeTime = -1L;
    this.mtX = false;
    this.nNZ = null;
    this.mub = new SensorController(ah.getContext());
    this.mtY = new bf(ah.getContext());
    AppMethodBeat.o(21820);
  }
  
  public final void hv(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(21821);
    ab.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.mtX + " tick:" + bo.av(this.lastShakeTime) + "  lt:" + this.lastShakeTime);
    if (this.mtX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.mtX = paramBoolean;
        AppMethodBeat.o(21821);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bo.av(this.lastShakeTime) > 400L))
    {
      this.mtX = true;
      AppMethodBeat.o(21821);
      return;
    }
    this.mtX = false;
    ab.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    new ap(new d.2(this, paramBoolean), false).ag(50L, 50L);
    AppMethodBeat.o(21821);
  }
  
  public static abstract interface a
  {
    public abstract void iG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.d
 * JD-Core Version:    0.7.0.1
 */