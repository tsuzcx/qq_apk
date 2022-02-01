package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView iKu;
  private int iKy;
  private int iKz;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.iKu = paramWheelView;
    this.offset = paramInt;
    this.iKy = 2147483647;
    this.iKz = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(175298);
    if (this.iKy == 2147483647) {
      this.iKy = this.offset;
    }
    this.iKz = ((int)(this.iKy * 0.1F));
    if (this.iKz == 0) {
      if (this.iKy >= 0) {
        break label92;
      }
    }
    label92:
    for (this.iKz = -1; Math.abs(this.iKy) <= 1; this.iKz = 1)
    {
      this.iKu.aPQ();
      this.iKu.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(175298);
      return;
    }
    this.iKu.setTotalScrollY(this.iKu.getTotalScrollY() + this.iKz);
    if (!this.iKu.isd)
    {
      float f1 = this.iKu.getItemHeight();
      float f2 = -this.iKu.getInitPosition();
      float f3 = this.iKu.getItemsCount() - 1 - this.iKu.getInitPosition();
      if ((this.iKu.getTotalScrollY() <= f2 * f1) || (this.iKu.getTotalScrollY() >= f1 * f3))
      {
        this.iKu.setTotalScrollY(this.iKu.getTotalScrollY() - this.iKz);
        this.iKu.aPQ();
        this.iKu.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(175298);
        return;
      }
    }
    this.iKu.getHandler().sendEmptyMessage(1000);
    this.iKy -= this.iKz;
    AppMethodBeat.o(175298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.c
 * JD-Core Version:    0.7.0.1
 */