package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements SensorController.a
{
  public SensorController iah = new SensorController(ae.getContext());
  public bb ial = new bb(ae.getContext());
  public long iam = -1L;
  private boolean iar = false;
  public d.a lqD = null;
  
  public final void eq(boolean paramBoolean)
  {
    boolean bool = true;
    y.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.iar + " tick:" + bk.cp(this.iam) + "  lt:" + this.iam);
    if (this.iar)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.iar = paramBoolean;
        return;
      }
    }
    if ((!paramBoolean) && (this.iam != -1L) && (bk.cp(this.iam) > 400L))
    {
      this.iar = true;
      return;
    }
    this.iar = false;
    y.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    new am(new d.2(this, paramBoolean), false).S(50L, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.d
 * JD-Core Version:    0.7.0.1
 */