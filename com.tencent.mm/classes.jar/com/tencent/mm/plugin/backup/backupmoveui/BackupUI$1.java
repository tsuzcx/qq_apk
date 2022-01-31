package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;

final class BackupUI$1
  implements View.OnClickListener
{
  BackupUI$1(BackupUI paramBackupUI) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    if (((Boolean)c.Dz().get(ac.a.uuq, Boolean.valueOf(false))).booleanValue())
    {
      if (com.tencent.mm.plugin.backup.d.b.atS().atn().hFu == -100)
      {
        au.Hx();
        c.Dz().c(ac.a.uuq, Boolean.valueOf(false));
      }
    }
    else
    {
      au.Hx();
      if (!((Boolean)c.Dz().get(ac.a.uum, Boolean.valueOf(false))).booleanValue())
      {
        au.Hx();
        if (!((Boolean)c.Dz().get(ac.a.uun, Boolean.valueOf(false))).booleanValue()) {}
      }
      else
      {
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn().hFu != -100) {
          break label276;
        }
        au.Hx();
        c.Dz().c(ac.a.uum, Boolean.valueOf(false));
        au.Hx();
        c.Dz().c(ac.a.uun, Boolean.valueOf(false));
      }
      int i = g.atz();
      if (i >= 50) {
        break label316;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(485L, 7L, 1L, false);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11787, new Object[] { Integer.valueOf(4) });
      com.tencent.mm.ui.base.h.a(this.hJK, R.l.backup_move_error_low_battery_tip, R.l.backup_move_error_low_battery, R.l.backup_sure, R.l.backup_cancel, false, new BackupUI.1.1(this, i), null, R.e.backup_green);
      return;
    }
    paramView = new Intent().setClassName(ae.getContext(), "com.tencent.mm.ui.LauncherUI");
    paramView.addFlags(335544320);
    paramView.putExtra("nofification_type", "backup_move_notification");
    ae.getContext().startActivity(paramView);
    return;
    label276:
    paramView = new Intent().setClassName(ae.getContext(), "com.tencent.mm.ui.LauncherUI");
    paramView.addFlags(335544320);
    paramView.putExtra("nofification_type", "back_to_pcmgr_notification");
    ae.getContext().startActivity(paramView);
    return;
    label316:
    com.tencent.mm.plugin.report.service.h.nFQ.a(485L, 21L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11788, new Object[] { Integer.valueOf(3) });
    paramView = new Intent(this.hJK, BackupMoveChooseUI.class);
    MMWizardActivity.C(this.hJK, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI.1
 * JD-Core Version:    0.7.0.1
 */