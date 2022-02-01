package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.p;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean vaL = false;
  private MTimerHandler uZG;
  private Button vaK;
  private TextView vaw;
  
  public BackupUI()
  {
    AppMethodBeat.i(21490);
    this.uZG = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21489);
        if (Util.isNullOrNil(g.fC(BackupUI.this))) {
          if (BackupUI.vaL)
          {
            BackupUI.a(BackupUI.this).setText(R.l.guX);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(R.e.fkg));
            BackupUI.b(BackupUI.this).setEnabled(false);
            BackupUI.access$002(false);
            com.tencent.mm.plugin.report.service.h.OAn.b(11788, new Object[] { Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21489);
          return true;
          if (!BackupUI.vaL)
          {
            BackupUI.a(BackupUI.this).setText(R.l.guY);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(R.e.fkh));
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
    return R.i.geA;
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
    com.tencent.mm.plugin.report.service.h.OAn.b(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.cWt();
    this.vaw = ((TextView)findViewById(R.h.ftb));
    this.vaK = ((Button)findViewById(R.h.fsX));
    com.tencent.mm.plugin.backup.d.b.cVs();
    paramBundle = com.tencent.mm.plugin.backup.d.b.cUO().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.cVs().cVw().uYm)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.cVs().cVw();
      d.cWK().cWN();
      ThreadPool.post(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!Util.isNullOrNil(g.fC(this))) {
        break label319;
      }
      this.vaw.setText(R.l.guX);
      this.vaw.setTextColor(getResources().getColor(R.e.fkg));
      this.vaK.setEnabled(false);
      vaL = false;
      com.tencent.mm.plugin.report.service.h.OAn.b(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.vaK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21487);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          bh.bCz();
          if (((Boolean)c.ban().get(at.a.acPb, Boolean.FALSE)).booleanValue())
          {
            if (com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg == -100)
            {
              bh.bCz();
              c.ban().set(at.a.acPb, Boolean.FALSE);
            }
          }
          else
          {
            bh.bCz();
            if (!((Boolean)c.ban().get(at.a.acOX, Boolean.FALSE)).booleanValue())
            {
              bh.bCz();
              if (!((Boolean)c.ban().get(at.a.acOY, Boolean.FALSE)).booleanValue()) {}
            }
            else
            {
              if (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg != -100) {
                break label398;
              }
              bh.bCz();
              c.ban().set(at.a.acOX, Boolean.FALSE);
              bh.bCz();
              c.ban().set(at.a.acOY, Boolean.FALSE);
            }
            int i = g.cUZ();
            if (i >= 50) {
              break label513;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 7L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(11787, new Object[] { Integer.valueOf(4) });
            k.a(BackupUI.this, R.l.gsL, R.l.gsK, R.l.guZ, R.l.gsm, false, new BackupUI.1.1(this, i), null, R.e.fkf);
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label398:
            localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
            ((Intent)localObject).addFlags(335544320);
            ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
            paramAnonymousView = MMApplicationContext.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label513:
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(485L, 21L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(11788, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new Intent(BackupUI.this, BackupMoveChooseUI.class);
            MMWizardActivity.aQ(BackupUI.this, paramAnonymousView);
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(21488);
          BackupUI.this.finish();
          AppMethodBeat.o(21488);
          return true;
        }
      });
      ((p)com.tencent.mm.kernel.h.ax(p.class)).aCs();
      AppMethodBeat.o(21491);
      return;
      com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVq();
      break;
      label319:
      this.vaw.setText(R.l.guY);
      this.vaw.setTextColor(getResources().getColor(R.e.fkh));
      this.vaK.setEnabled(true);
      vaL = true;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21494);
    Log.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
    super.onDestroy();
    com.tencent.mm.plugin.backup.d.b.cVs().cVw().cancel();
    com.tencent.mm.plugin.backup.d.a locala = com.tencent.mm.plugin.backup.d.b.cVs().cVw();
    Log.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.uYj = null;
    locala.uYl = null;
    locala.uYk = null;
    locala.uYn = false;
    locala.uYm = false;
    ((p)com.tencent.mm.kernel.h.ax(p.class)).aCr();
    AppMethodBeat.o(21494);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21492);
    super.onStart();
    this.uZG.startTimer(5000L);
    AppMethodBeat.o(21492);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21493);
    super.onStop();
    this.uZG.stopTimer();
    AppMethodBeat.o(21493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI
 * JD-Core Version:    0.7.0.1
 */