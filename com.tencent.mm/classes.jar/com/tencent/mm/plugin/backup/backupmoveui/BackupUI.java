package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a.1;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean rPw = false;
  private MTimerHandler rOs;
  private TextView rPh;
  private Button rPv;
  
  public BackupUI()
  {
    AppMethodBeat.i(21490);
    this.rOs = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21489);
        if (Util.isNullOrNil(g.eH(BackupUI.this))) {
          if (BackupUI.rPw)
          {
            BackupUI.a(BackupUI.this).setText(R.l.erW);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(R.e.dkf));
            BackupUI.b(BackupUI.this).setEnabled(false);
            BackupUI.access$002(false);
            com.tencent.mm.plugin.report.service.h.IzE.a(11788, new Object[] { Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21489);
          return true;
          if (!BackupUI.rPw)
          {
            BackupUI.a(BackupUI.this).setText(R.l.erX);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(R.e.dkg));
            BackupUI.b(BackupUI.this).setEnabled(true);
            BackupUI.access$002(true);
          }
        }
      }
    }, true);
    AppMethodBeat.o(21490);
  }
  
  public int getLayoutId()
  {
    return R.i.ebS;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21491);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21491);
      return;
    }
    setMMTitle(R.l.backup_move);
    com.tencent.mm.plugin.report.service.h.IzE.a(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.ctJ();
    this.rPh = ((TextView)findViewById(R.h.dsK));
    this.rPv = ((Button)findViewById(R.h.dsG));
    com.tencent.mm.plugin.backup.d.b.csI();
    paramBundle = com.tencent.mm.plugin.backup.d.b.cse().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.csI().csM().rMY)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.csI().csM();
      d.cua().cud();
      ThreadPool.post(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!Util.isNullOrNil(g.eH(this))) {
        break label305;
      }
      this.rPh.setText(R.l.erW);
      this.rPh.setTextColor(getResources().getColor(R.e.dkf));
      this.rPv.setEnabled(false);
      rPw = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.rPv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21487);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          bh.beI();
          if (((Boolean)c.aHp().get(ar.a.VnG, Boolean.FALSE)).booleanValue())
          {
            if (com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS == -100)
            {
              bh.beI();
              c.aHp().set(ar.a.VnG, Boolean.FALSE);
            }
          }
          else
          {
            bh.beI();
            if (!((Boolean)c.aHp().get(ar.a.VnC, Boolean.FALSE)).booleanValue())
            {
              bh.beI();
              if (!((Boolean)c.aHp().get(ar.a.VnD, Boolean.FALSE)).booleanValue()) {}
            }
            else
            {
              if (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS != -100) {
                break label398;
              }
              bh.beI();
              c.aHp().set(ar.a.VnC, Boolean.FALSE);
              bh.beI();
              c.aHp().set(ar.a.VnD, Boolean.FALSE);
            }
            int i = g.csp();
            if (i >= 50) {
              break label513;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 7L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(11787, new Object[] { Integer.valueOf(4) });
            com.tencent.mm.ui.base.h.a(BackupUI.this, R.l.epK, R.l.epJ, R.l.erY, R.l.epl, false, new BackupUI.1.1(this, i), null, R.e.dke);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
            ((Intent)localObject).addFlags(335544320);
            ((Intent)localObject).putExtra("nofification_type", "backup_move_notification");
            paramAnonymousView = MMApplicationContext.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label398:
            localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
            ((Intent)localObject).addFlags(335544320);
            ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
            paramAnonymousView = MMApplicationContext.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label513:
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 21L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(11788, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new Intent(BackupUI.this, BackupMoveChooseUI.class);
            MMWizardActivity.aH(BackupUI.this, paramAnonymousView);
          }
        }
      });
      setBackBtn(new BackupUI.2(this));
      AppMethodBeat.o(21491);
      return;
      com.tencent.mm.plugin.backup.d.b.csI().csM().csG();
      break;
      label305:
      this.rPh.setText(R.l.erX);
      this.rPh.setTextColor(getResources().getColor(R.e.dkg));
      this.rPv.setEnabled(true);
      rPw = true;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21494);
    Log.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
    super.onDestroy();
    com.tencent.mm.plugin.backup.d.b.csI().csM().cancel();
    com.tencent.mm.plugin.backup.d.a locala = com.tencent.mm.plugin.backup.d.b.csI().csM();
    Log.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.rMV = null;
    locala.rMX = null;
    locala.rMW = null;
    locala.rMZ = false;
    locala.rMY = false;
    AppMethodBeat.o(21494);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21492);
    super.onStart();
    this.rOs.startTimer(5000L);
    AppMethodBeat.o(21492);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21493);
    super.onStop();
    this.rOs.stopTimer();
    AppMethodBeat.o(21493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI
 * JD-Core Version:    0.7.0.1
 */