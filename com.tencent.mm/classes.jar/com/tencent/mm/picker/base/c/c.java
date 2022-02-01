package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private float pxP;
  private final float pxQ;
  private final WheelView pxR;
  
  public c(WheelView paramWheelView, float paramFloat)
  {
    this.pxR = paramWheelView;
    this.pxQ = paramFloat;
    this.pxP = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(175296);
    if (this.pxP == 2.147484E+009F)
    {
      if (Math.abs(this.pxQ) <= 2000.0F) {
        break label103;
      }
      if (this.pxQ <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.pxP = f1;; this.pxP = this.pxQ)
    {
      if ((Math.abs(this.pxP) < 0.0F) || (Math.abs(this.pxP) > 20.0F)) {
        break label114;
      }
      this.pxR.bSQ();
      this.pxR.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(175296);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.pxP / 100.0F);
    this.pxR.setTotalScrollY(this.pxR.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.pxR.oYG)
    {
      f5 = this.pxR.getItemHeight();
      f3 = -this.pxR.getInitPosition() * f5;
      f4 = (this.pxR.getItemsCount() - 1 - this.pxR.getInitPosition()) * f5;
      if (this.pxR.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.pxR.getTotalScrollY() + i;
        f1 = f4;
        if (this.pxR.getTotalScrollY() > f2) {
          break label347;
        }
        this.pxP = 40.0F;
        this.pxR.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.pxP >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.pxP += 20.0F;; this.pxP -= 20.0F)
    {
      this.pxR.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(175296);
      return;
      f1 = f4;
      f2 = f3;
      if (this.pxR.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.pxR.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.pxR.getTotalScrollY() < f1) {
        break label262;
      }
      this.pxR.setTotalScrollY((int)f1);
      this.pxP = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.c
 * JD-Core Version:    0.7.0.1
 */