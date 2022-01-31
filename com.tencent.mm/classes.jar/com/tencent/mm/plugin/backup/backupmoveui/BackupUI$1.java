package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;

final class BackupUI$1
  implements View.OnClickListener
{
  BackupUI$1(BackupUI paramBackupUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17428);
    aw.aaz();
    if (((Boolean)c.Ru().get(ac.a.yEt, Boolean.FALSE)).booleanValue())
    {
      if (com.tencent.mm.plugin.backup.d.b.aTr().aSL().jyN == -100)
      {
        aw.aaz();
        c.Ru().set(ac.a.yEt, Boolean.FALSE);
      }
    }
    else
    {
      aw.aaz();
      if (!((Boolean)c.Ru().get(ac.a.yEp, Boolean.FALSE)).booleanValue())
      {
        aw.aaz();
        if (!((Boolean)c.Ru().get(ac.a.yEq, Boolean.FALSE)).booleanValue()) {}
      }
      else
      {
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTX().aSL().jyN != -100) {
          break label283;
        }
        aw.aaz();
        c.Ru().set(ac.a.yEp, Boolean.FALSE);
        aw.aaz();
        c.Ru().set(ac.a.yEq, Boolean.FALSE);
      }
      int i = g.aSX();
      if (i >= 50) {
        break label329;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(485L, 7L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(11787, new Object[] { Integer.valueOf(4) });
      com.tencent.mm.ui.base.h.a(this.jDo, 2131297249, 2131297248, 2131297394, 2131297220, false, new BackupUI.1.1(this, i), null, 2131689739);
      AppMethodBeat.o(17428);
      return;
    }
    paramView = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
    paramView.addFlags(335544320);
    paramView.putExtra("nofification_type", "backup_move_notification");
    ah.getContext().startActivity(paramView);
    AppMethodBeat.o(17428);
    return;
    label283:
    paramView = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
    paramView.addFlags(335544320);
    paramView.putExtra("nofification_type", "back_to_pcmgr_notification");
    ah.getContext().startActivity(paramView);
    AppMethodBeat.o(17428);
    return;
    label329:
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(485L, 21L, 1L, false);
    com.tencent.mm.plugin.report.service.h.qsU.e(11788, new Object[] { Integer.valueOf(3) });
    paramView = new Intent(this.jDo, BackupMoveChooseUI.class);
    MMWizardActivity.J(this.jDo, paramView);
    AppMethodBeat.o(17428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI.1
 * JD-Core Version:    0.7.0.1
 */