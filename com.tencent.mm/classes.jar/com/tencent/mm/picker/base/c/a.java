package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private float iKv;
  private final float iKw;
  private final WheelView iKx;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.iKx = paramWheelView;
    this.iKw = paramFloat;
    this.iKv = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(175296);
    if (this.iKv == 2.147484E+009F)
    {
      if (Math.abs(this.iKw) <= 2000.0F) {
        break label103;
      }
      if (this.iKw <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.iKv = f1;; this.iKv = this.iKw)
    {
      if ((Math.abs(this.iKv) < 0.0F) || (Math.abs(this.iKv) > 20.0F)) {
        break label114;
      }
      this.iKx.aPQ();
      this.iKx.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(175296);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.iKv / 100.0F);
    this.iKx.setTotalScrollY(this.iKx.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.iKx.isd)
    {
      f5 = this.iKx.getItemHeight();
      f3 = -this.iKx.getInitPosition() * f5;
      f4 = (this.iKx.getItemsCount() - 1 - this.iKx.getInitPosition()) * f5;
      if (this.iKx.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.iKx.getTotalScrollY() + i;
        f1 = f4;
        if (this.iKx.getTotalScrollY() > f2) {
          break label347;
        }
        this.iKv = 40.0F;
        this.iKx.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.iKv >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.iKv += 20.0F;; this.iKv -= 20.0F)
    {
      this.iKx.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(175296);
      return;
      f1 = f4;
      f2 = f3;
      if (this.iKx.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.iKx.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.iKx.getTotalScrollY() < f1) {
        break label262;
      }
      this.iKx.setTotalScrollY((int)f1);
      this.iKv = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.a
 * JD-Core Version:    0.7.0.1
 */