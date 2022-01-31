package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.report.service.h;

final class LaunchAAUI$15
  implements a.a
{
  LaunchAAUI$15(LaunchAAUI paramLaunchAAUI) {}
  
  public final void aoW()
  {
    AppMethodBeat.i(40836);
    Intent localIntent = new Intent(this.grm, AAQueryListUI.class);
    this.grm.startActivity(localIntent);
    if (LaunchAAUI.b(this.grm) == a.gne)
    {
      h.qsU.e(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      AppMethodBeat.o(40836);
      return;
    }
    h.qsU.e(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
    AppMethodBeat.o(40836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.15
 * JD-Core Version:    0.7.0.1
 */