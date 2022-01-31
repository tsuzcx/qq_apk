package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BakOperatingUI$9
  implements Runnable
{
  BakOperatingUI$9(BakOperatingUI paramBakOperatingUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(17941);
    if (BakOperatingUI.h(this.jIE) != null) {
      BakOperatingUI.h(this.jIE).setProgress(this.gAL);
    }
    if ((BakOperatingUI.i(this.jIE) != null) && (BakOperatingUI.k(this.jIE) != null))
    {
      BakOperatingUI.i(this.jIE).setText(this.jIE.getString(2131297414) + this.gAL + "%");
      BakOperatingUI.k(this.jIE).setText(this.jIE.getString(2131297424));
    }
    AppMethodBeat.o(17941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.9
 * JD-Core Version:    0.7.0.1
 */