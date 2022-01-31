package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;

final class BakOperatingUI$10
  implements Runnable
{
  BakOperatingUI$10(BakOperatingUI paramBakOperatingUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(17943);
    if (6 == BakOperatingUI.j(this.jIE))
    {
      BakOperatingUI.m(this.jIE).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(17942);
          BakOperatingUI.10.this.jIE.showOptionMenu(false);
          if (BakOperatingUI.h(BakOperatingUI.10.this.jIE) != null) {
            BakOperatingUI.h(BakOperatingUI.10.this.jIE).setProgress(0);
          }
          if (BakOperatingUI.k(BakOperatingUI.10.this.jIE) != null) {
            BakOperatingUI.k(BakOperatingUI.10.this.jIE).setText(BakOperatingUI.10.this.jIE.getString(2131297424));
          }
          if (BakOperatingUI.l(BakOperatingUI.10.this.jIE) != null) {
            BakOperatingUI.l(BakOperatingUI.10.this.jIE).setText(BakOperatingUI.10.this.jIE.getString(2131297423));
          }
          if (BakOperatingUI.i(BakOperatingUI.10.this.jIE) != null) {
            BakOperatingUI.i(BakOperatingUI.10.this.jIE).setText(BakOperatingUI.10.this.jIE.getString(2131297414) + "0%");
          }
          AppMethodBeat.o(17942);
        }
      });
      AppMethodBeat.o(17943);
      return;
    }
    if (1 == BakOperatingUI.j(this.jIE))
    {
      Intent localIntent = new Intent(this.jIE, BakFinishUI.class);
      localIntent.putExtra("cmd", BakOperatingUI.j(this.jIE));
      MMWizardActivity.J(this.jIE, localIntent);
    }
    AppMethodBeat.o(17943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.10
 * JD-Core Version:    0.7.0.1
 */