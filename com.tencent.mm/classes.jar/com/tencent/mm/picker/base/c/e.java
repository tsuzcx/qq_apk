package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class e
  extends TimerTask
{
  private final WheelView jKa;
  private int jKf;
  private int jKg;
  private int offset;
  
  public e(WheelView paramWheelView, int paramInt)
  {
    this.jKa = paramWheelView;
    this.offset = paramInt;
    this.jKf = 2147483647;
    this.jKg = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(175298);
    if (this.jKf == 2147483647) {
      this.jKf = this.offset;
    }
    this.jKg = ((int)(this.jKf * 0.1F));
    if (this.jKg == 0) {
      if (this.jKf >= 0) {
        break label92;
      }
    }
    label92:
    for (this.jKg = -1; Math.abs(this.jKf) <= 1; this.jKg = 1)
    {
      this.jKa.bkU();
      this.jKa.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(175298);
      return;
    }
    this.jKa.setTotalScrollY(this.jKa.getTotalScrollY() + this.jKg);
    if (!this.jKa.jqj)
    {
      float f1 = this.jKa.getItemHeight();
      float f2 = -this.jKa.getInitPosition();
      float f3 = this.jKa.getItemsCount() - 1 - this.jKa.getInitPosition();
      if ((this.jKa.getTotalScrollY() <= f2 * f1) || (this.jKa.getTotalScrollY() >= f1 * f3))
      {
        this.jKa.setTotalScrollY(this.jKa.getTotalScrollY() - this.jKg);
        this.jKa.bkU();
        this.jKa.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(175298);
        return;
      }
    }
    this.jKa.getHandler().sendEmptyMessage(1000);
    this.jKf -= this.jKg;
    AppMethodBeat.o(175298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.e
 * JD-Core Version:    0.7.0.1
 */