package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupPcUI$3$12
  implements View.OnClickListener
{
  BackupPcUI$3$12(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17605);
    ab.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
    b.aTX().aUa();
    if (!d.aTw())
    {
      b.aTX().aUa();
      if (!d.aTw())
      {
        b.aTX().aSL().jyN = -22;
        this.jEQ.rf(-22);
        h.qsU.idkeyStat(400L, 64L, 1L, false);
        AppMethodBeat.o(17605);
        return;
      }
    }
    h.qsU.e(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(b.aTX().aTY().jEg) });
    b.aTX().aUa().aTd();
    AppMethodBeat.o(17605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.12
 * JD-Core Version:    0.7.0.1
 */