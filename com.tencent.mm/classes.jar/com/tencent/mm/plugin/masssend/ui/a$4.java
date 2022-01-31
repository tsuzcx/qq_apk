package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

final class a$4
  extends TimerTask
{
  a$4(p paramp, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(22757);
    if (this.oBu != null)
    {
      this.oBu.dismiss();
      this.mFP.sendEmptyMessage(0);
    }
    AppMethodBeat.o(22757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a.4
 * JD-Core Version:    0.7.0.1
 */