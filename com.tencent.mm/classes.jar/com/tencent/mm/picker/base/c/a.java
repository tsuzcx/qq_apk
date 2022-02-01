package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class a
  extends TimerTask
{
  private float hRn;
  private final float hRo;
  private final WheelView hRp;
  
  public a(WheelView paramWheelView, float paramFloat)
  {
    this.hRp = paramWheelView;
    this.hRo = paramFloat;
    this.hRn = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f1 = 2000.0F;
    AppMethodBeat.i(175296);
    if (this.hRn == 2.147484E+009F)
    {
      if (Math.abs(this.hRo) <= 2000.0F) {
        break label103;
      }
      if (this.hRo <= 0.0F) {
        break label97;
      }
    }
    label97:
    label103:
    for (this.hRn = f1;; this.hRn = this.hRo)
    {
      if ((Math.abs(this.hRn) < 0.0F) || (Math.abs(this.hRn) > 20.0F)) {
        break label114;
      }
      this.hRp.aFS();
      this.hRp.getHandler().sendEmptyMessage(2000);
      AppMethodBeat.o(175296);
      return;
      f1 = -2000.0F;
      break;
    }
    label114:
    int i = (int)(this.hRn / 100.0F);
    this.hRp.setTotalScrollY(this.hRp.getTotalScrollY() - i);
    float f5;
    float f3;
    float f4;
    float f2;
    if (!this.hRp.hyg)
    {
      f5 = this.hRp.getItemHeight();
      f3 = -this.hRp.getInitPosition() * f5;
      f4 = (this.hRp.getItemsCount() - 1 - this.hRp.getInitPosition()) * f5;
      if (this.hRp.getTotalScrollY() - f5 * 0.25D < f3)
      {
        f2 = this.hRp.getTotalScrollY() + i;
        f1 = f4;
        if (this.hRp.getTotalScrollY() > f2) {
          break label347;
        }
        this.hRn = 40.0F;
        this.hRp.setTotalScrollY((int)f2);
      }
    }
    else
    {
      label262:
      if (this.hRn >= 0.0F) {
        break label378;
      }
    }
    label347:
    label378:
    for (this.hRn += 20.0F;; this.hRn -= 20.0F)
    {
      this.hRp.getHandler().sendEmptyMessage(1000);
      AppMethodBeat.o(175296);
      return;
      f1 = f4;
      f2 = f3;
      if (this.hRp.getTotalScrollY() + f5 * 0.25D <= f4) {
        break;
      }
      f1 = this.hRp.getTotalScrollY() + i;
      f2 = f3;
      break;
      if (this.hRp.getTotalScrollY() < f1) {
        break label262;
      }
      this.hRp.setTotalScrollY((int)f1);
      this.hRn = -40.0F;
      break label262;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.a
 * JD-Core Version:    0.7.0.1
 */