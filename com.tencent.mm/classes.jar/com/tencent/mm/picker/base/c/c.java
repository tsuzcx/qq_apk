package com.tencent.mm.picker.base.c;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private final WheelView iNn;
  private int iNr;
  private int iNs;
  private int offset;
  
  public c(WheelView paramWheelView, int paramInt)
  {
    this.iNn = paramWheelView;
    this.offset = paramInt;
    this.iNr = 2147483647;
    this.iNs = 0;
  }
  
  public final void run()
  {
    AppMethodBeat.i(175298);
    if (this.iNr == 2147483647) {
      this.iNr = this.offset;
    }
    this.iNs = ((int)(this.iNr * 0.1F));
    if (this.iNs == 0) {
      if (this.iNr >= 0) {
        break label92;
      }
    }
    label92:
    for (this.iNs = -1; Math.abs(this.iNr) <= 1; this.iNs = 1)
    {
      this.iNn.aQp();
      this.iNn.getHandler().sendEmptyMessage(3000);
      AppMethodBeat.o(175298);
      return;
    }
    this.iNn.setTotalScrollY(this.iNn.getTotalScrollY() + this.iNs);
    if (!this.iNn.iuX)
    {
      float f1 = this.iNn.getItemHeight();
      float f2 = -this.iNn.getInitPosition();
      float f3 = this.iNn.getItemsCount() - 1 - this.iNn.getInitPosition();
      if ((this.iNn.getTotalScrollY() <= f2 * f1) || (this.iNn.getTotalScrollY() >= f1 * f3))
      {
        this.iNn.setTotalScrollY(this.iNn.getTotalScrollY() - this.iNs);
        this.iNn.aQp();
        this.iNn.getHandler().sendEmptyMessage(3000);
        AppMethodBeat.o(175298);
        return;
      }
    }
    this.iNn.getHandler().sendEmptyMessage(1000);
    this.iNr -= this.iNs;
    AppMethodBeat.o(175298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.c.c
 * JD-Core Version:    0.7.0.1
 */