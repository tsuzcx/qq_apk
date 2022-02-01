package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class e
  extends TimerTask
{
  private int offset;
  private final WheelView pxN;
  private int pxS;
  private int pxT;
  
  public e(WheelView paramWheelView, int paramInt)
  {
    this.pxN = paramWheelView;
    this.offset = paramInt;
    this.pxS = 2147483647;
    this.pxT = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(175298);
    if (this.pxS == 2147483647) {
      this.pxS = this.offset;
    }
    this.pxT = ((int)(this.pxS * 0.1F));
    if (this.pxT == 0) {
      if (this.pxS >= 0) {
        break label92;
      }
    }
    label92:
    for (this.pxT = -1; Math.abs(this.pxS) <= 1; this.pxT = 1)
    {
      this.pxN.bSQ();
      this.pxN.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(175298);
      return;
    }
    this.pxN.setTotalScrollY(this.pxN.getTotalScrollY() + this.pxT);
    if (!this.pxN.oYG)
    {
      float f1 = this.pxN.getItemHeight();
      float f2 = -this.pxN.getInitPosition();
      float f3 = this.pxN.getItemsCount() - 1 - this.pxN.getInitPosition();
      if ((this.pxN.getTotalScrollY() <= f2 * f1) || (this.pxN.getTotalScrollY() >= f1 * f3))
      {
        this.pxN.setTotalScrollY(this.pxN.getTotalScrollY() - this.pxT);
        this.pxN.bSQ();
        this.pxN.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(175298);
        return;
      }
    }
    this.pxN.getHandler().sendEmptyMessage(1000);
    this.pxS -= this.pxT;
    AppMethodBeat.o(175298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.e
 * JD-Core Version:    0.7.0.1
 */