package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView irq;
  private int irv;
  private int irw;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.irq = paramWheelView;
    this.offset = paramInt;
    this.irv = 2147483647;
    this.irw = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(175298);
    if (this.irv == 2147483647) {
      this.irv = this.offset;
    }
    this.irw = ((int)(this.irv * 0.1F));
    if (this.irw == 0) {
      if (this.irv >= 0) {
        break label92;
      }
    }
    label92:
    for (this.irw = -1; Math.abs(this.irv) <= 1; this.irw = 1)
    {
      this.irq.aMF();
      this.irq.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(175298);
      return;
    }
    this.irq.setTotalScrollY(this.irq.getTotalScrollY() + this.irw);
    if (!this.irq.hYH)
    {
      float f1 = this.irq.getItemHeight();
      float f2 = -this.irq.getInitPosition();
      float f3 = this.irq.getItemsCount() - 1 - this.irq.getInitPosition();
      if ((this.irq.getTotalScrollY() <= f2 * f1) || (this.irq.getTotalScrollY() >= f1 * f3))
      {
        this.irq.setTotalScrollY(this.irq.getTotalScrollY() - this.irw);
        this.irq.aMF();
        this.irq.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(175298);
        return;
      }
    }
    this.irq.getHandler().sendEmptyMessage(1000);
    this.irv -= this.irw;
    AppMethodBeat.o(175298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.c
 * JD-Core Version:    0.7.0.1
 */