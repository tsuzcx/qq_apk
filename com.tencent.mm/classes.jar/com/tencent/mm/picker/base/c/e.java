package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class e
  extends TimerTask
{
  private final WheelView mBd;
  private int mBi;
  private int mBj;
  private int offset;
  
  public e(WheelView paramWheelView, int paramInt)
  {
    this.mBd = paramWheelView;
    this.offset = paramInt;
    this.mBi = 2147483647;
    this.mBj = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(175298);
    if (this.mBi == 2147483647) {
      this.mBi = this.offset;
    }
    this.mBj = ((int)(this.mBi * 0.1F));
    if (this.mBj == 0) {
      if (this.mBi >= 0) {
        break label92;
      }
    }
    label92:
    for (this.mBj = -1; Math.abs(this.mBi) <= 1; this.mBj = 1)
    {
      this.mBd.buH();
      this.mBd.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(175298);
      return;
    }
    this.mBd.setTotalScrollY(this.mBd.getTotalScrollY() + this.mBj);
    if (!this.mBd.mfK)
    {
      float f1 = this.mBd.getItemHeight();
      float f2 = -this.mBd.getInitPosition();
      float f3 = this.mBd.getItemsCount() - 1 - this.mBd.getInitPosition();
      if ((this.mBd.getTotalScrollY() <= f2 * f1) || (this.mBd.getTotalScrollY() >= f1 * f3))
      {
        this.mBd.setTotalScrollY(this.mBd.getTotalScrollY() - this.mBj);
        this.mBd.buH();
        this.mBd.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(175298);
        return;
      }
    }
    this.mBd.getHandler().sendEmptyMessage(1000);
    this.mBi -= this.mBj;
    AppMethodBeat.o(175298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.e
 * JD-Core Version:    0.7.0.1
 */