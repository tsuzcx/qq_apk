package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class BackupPcUI$3$12
  implements View.OnClickListener
{
  BackupPcUI$3$12(BackupPcUI.3 param3) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
    b.auw().auz();
    if (!d.atX())
    {
      b.auw().auz();
      if (!d.atX())
      {
        b.auw().atn().hFu = -22;
        this.hLn.nt(-22);
        h.nFQ.a(400L, 64L, 1L, false);
        return;
      }
    }
    h.nFQ.f(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(b.auw().aux().hKD) });
    b.auw().auz().atF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.12
 * JD-Core Version:    0.7.0.1
 */