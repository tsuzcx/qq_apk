package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private float iNo;
  private final float iNp;
  private final WheelView iNq;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.iNq = paramWheelView;
    this.iNp = paramFloat;
    this.iNo = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(175296);
    if (this.iNo == 2.147484E+009F)
    {
      if (Math.abs(this.iNp) <= 2000.0F) {
        break label103;
      }
      if (this.iNp <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.iNo = f1;; this.iNo = this.iNp)
    {
      if ((Math.abs(this.iNo) < 0.0F) || (Math.abs(this.iNo) > 20.0F)) {
        break label114;
      }
      this.iNq.aQp();
      this.iNq.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(175296);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.iNo / 100.0F);
    this.iNq.setTotalScrollY(this.iNq.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.iNq.iuX)
    {
      f5 = this.iNq.getItemHeight();
      f3 = -this.iNq.getInitPosition() * f5;
      f4 = (this.iNq.getItemsCount() - 1 - this.iNq.getInitPosition()) * f5;
      if (this.iNq.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.iNq.getTotalScrollY() + i;
        f1 = f4;
        if (this.iNq.getTotalScrollY() > f2) {
          break label347;
        }
        this.iNo = 40.0F;
        this.iNq.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.iNo >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.iNo += 20.0F;; this.iNo -= 20.0F)
    {
      this.iNq.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(175296);
      return;
      f1 = f4;
      f2 = f3;
      if (this.iNq.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.iNq.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.iNq.getTotalScrollY() < f1) {
        break label262;
      }
      this.iNq.setTotalScrollY((int)f1);
      this.iNo = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.a
 * JD-Core Version:    0.7.0.1
 */