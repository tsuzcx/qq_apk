package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private float irs;
  private final float irt;
  private final WheelView iru;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.iru = paramWheelView;
    this.irt = paramFloat;
    this.irs = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(175296);
    if (this.irs == 2.147484E+009F)
    {
      if (Math.abs(this.irt) <= 2000.0F) {
        break label103;
      }
      if (this.irt <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.irs = f1;; this.irs = this.irt)
    {
      if ((Math.abs(this.irs) < 0.0F) || (Math.abs(this.irs) > 20.0F)) {
        break label114;
      }
      this.iru.aMF();
      this.iru.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(175296);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.irs / 100.0F);
    this.iru.setTotalScrollY(this.iru.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.iru.hYH)
    {
      f5 = this.iru.getItemHeight();
      f3 = -this.iru.getInitPosition() * f5;
      f4 = (this.iru.getItemsCount() - 1 - this.iru.getInitPosition()) * f5;
      if (this.iru.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.iru.getTotalScrollY() + i;
        f1 = f4;
        if (this.iru.getTotalScrollY() > f2) {
          break label347;
        }
        this.irs = 40.0F;
        this.iru.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.irs >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.irs += 20.0F;; this.irs -= 20.0F)
    {
      this.iru.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(175296);
      return;
      f1 = f4;
      f2 = f3;
      if (this.iru.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.iru.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.iru.getTotalScrollY() < f1) {
        break label262;
      }
      this.iru.setTotalScrollY((int)f1);
      this.irs = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.a
 * JD-Core Version:    0.7.0.1
 */