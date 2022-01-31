package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;

final class BackupUI$3
  implements am.a
{
  BackupUI$3(BackupUI paramBackupUI) {}
  
  public final boolean tC()
  {
    if (bk.bl(g.cM(this.hJK))) {
      if (BackupUI.access$000())
      {
        BackupUI.a(this.hJK).setText(R.l.backup_status_content_no_wifi);
        BackupUI.a(this.hJK).setTextColor(this.hJK.getResources().getColor(R.e.backup_red));
        BackupUI.b(this.hJK).setEnabled(false);
        BackupUI.bo(false);
        h.nFQ.f(11788, new Object[] { Integer.valueOf(2) });
      }
    }
    while (BackupUI.access$000()) {
      return true;
    }
    BackupUI.a(this.hJK).setText(R.l.backup_status_content_open_wifi);
    BackupUI.a(this.hJK).setTextColor(this.hJK.getResources().getColor(R.e.backup_status_content));
    BackupUI.b(this.hJK).setEnabled(true);
    BackupUI.bo(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI.3
 * JD-Core Version:    0.7.0.1
 */