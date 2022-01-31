package com.tencent.mm.plugin.backup.backupui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17710);
    int i = d.aSO();
    ab.i(a.access$100(), "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17710);
      return;
      i = com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL().jyN;
      ab.i(a.access$100(), "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        ab.i(a.access$100(), "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL().jyN) });
        AppMethodBeat.o(17710);
        return;
      case -4: 
      case 4: 
      case 5: 
      case 12: 
      case 14: 
      case 15: 
      case 22: 
      case 23: 
      case 28: 
        ab.i(a.access$100(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL().jyN) });
        a.a(this.jGH, false);
        AppMethodBeat.o(17710);
        return;
      }
      ab.i(a.access$100(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL().jyN) });
      a.a(this.jGH, true);
      AppMethodBeat.o(17710);
      return;
      i = com.tencent.mm.plugin.backup.d.b.aTr().aSL().jyN;
      ab.i(a.access$100(), "backupbanner onclick, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        ab.i(a.access$100(), "click backup banner,backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
      }
    }
    ab.i(a.access$100(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
    a.b(this.jGH, false);
    AppMethodBeat.o(17710);
    return;
    ab.i(a.access$100(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
    a.b(this.jGH, true);
    AppMethodBeat.o(17710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a.1
 * JD-Core Version:    0.7.0.1
 */