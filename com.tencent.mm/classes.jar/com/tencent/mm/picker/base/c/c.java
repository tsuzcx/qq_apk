package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView hRm;
  private int hRq;
  private int hRr;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.hRm = paramWheelView;
    this.offset = paramInt;
    this.hRq = 2147483647;
    this.hRr = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(175298);
    if (this.hRq == 2147483647) {
      this.hRq = this.offset;
    }
    this.hRr = ((int)(this.hRq * 0.1F));
    if (this.hRr == 0) {
      if (this.hRq >= 0) {
        break label92;
      }
    }
    label92:
    for (this.hRr = -1; Math.abs(this.hRq) <= 1; this.hRr = 1)
    {
      this.hRm.aFS();
      this.hRm.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(175298);
      return;
    }
    this.hRm.setTotalScrollY(this.hRm.getTotalScrollY() + this.hRr);
    if (!this.hRm.hyg)
    {
      float f1 = this.hRm.getItemHeight();
      float f2 = -this.hRm.getInitPosition();
      float f3 = this.hRm.getItemsCount() - 1 - this.hRm.getInitPosition();
      if ((this.hRm.getTotalScrollY() <= f2 * f1) || (this.hRm.getTotalScrollY() >= f1 * f3))
      {
        this.hRm.setTotalScrollY(this.hRm.getTotalScrollY() - this.hRr);
        this.hRm.aFS();
        this.hRm.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(175298);
        return;
      }
    }
    this.hRm.getHandler().sendEmptyMessage(1000);
    this.hRq -= this.hRr;
    AppMethodBeat.o(175298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.c
 * JD-Core Version:    0.7.0.1
 */