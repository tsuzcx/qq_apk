package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private float mBf;
  private final float mBg;
  private final WheelView mBh;
  
  public c(WheelView paramWheelView, float paramFloat)
  {
    this.mBh = paramWheelView;
    this.mBg = paramFloat;
    this.mBf = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(175296);
    if (this.mBf == 2.147484E+009F)
    {
      if (Math.abs(this.mBg) <= 2000.0F) {
        break label103;
      }
      if (this.mBg <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.mBf = f1;; this.mBf = this.mBg)
    {
      if ((Math.abs(this.mBf) < 0.0F) || (Math.abs(this.mBf) > 20.0F)) {
        break label114;
      }
      this.mBh.buH();
      this.mBh.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(175296);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.mBf / 100.0F);
    this.mBh.setTotalScrollY(this.mBh.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.mBh.mfK)
    {
      f5 = this.mBh.getItemHeight();
      f3 = -this.mBh.getInitPosition() * f5;
      f4 = (this.mBh.getItemsCount() - 1 - this.mBh.getInitPosition()) * f5;
      if (this.mBh.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.mBh.getTotalScrollY() + i;
        f1 = f4;
        if (this.mBh.getTotalScrollY() > f2) {
          break label347;
        }
        this.mBf = 40.0F;
        this.mBh.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.mBf >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.mBf += 20.0F;; this.mBf -= 20.0F)
    {
      this.mBh.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(175296);
      return;
      f1 = f4;
      f2 = f3;
      if (this.mBh.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.mBh.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.mBh.getTotalScrollY() < f1) {
        break label262;
      }
      this.mBh.setTotalScrollY((int)f1);
      this.mBf = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.c
 * JD-Core Version:    0.7.0.1
 */